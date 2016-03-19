package com.agoltsov.services;


import com.agoltsov.models.Element;
import com.agoltsov.models.SubPart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BomExplosionService {

    private String rootElement;
    private final Map<String, List<Element>> map = new HashMap<>();
    private final List<SubPart> collectedSubParts = new LinkedList<>();


    public List<SubPart> explode(String filePath) {
        parseFile(filePath);

        collectSubParts();

        return collectedSubParts;
    }


    private void collectSubParts() {
        collect(map.get(rootElement), 1);
    }

    private void collect(List<Element> list, int multiplier) {

        for (Element element : list) {

            if (map.keySet().contains(element.getSubPart())) { //collect inner sub-parts
                collect(map.get(element.getSubPart()), multiplier * element.getQuantity());

            } else { //collect sup-part
                SubPart subPart = new SubPart(element.getSubPart(), multiplier * element.getQuantity());
                int index = collectedSubParts.indexOf(subPart);

                if (index == -1) { //add new sub-part
                    collectedSubParts.add(subPart);

                } else { //update existed sub-part quantity
                    SubPart found = collectedSubParts.get(index);
                    found.setQuantity(found.getQuantity() + multiplier * element.getQuantity());
                }
            }
        }
    }

    private void parseFile(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {

                String part = line.substring(0, 9).trim();
                String subPart = line.substring(11, 20).trim();
                String quantity = line.substring(22, 28).trim();

                List<Element> elements = map.get(part);
                if (elements == null) {
                    elements = new LinkedList<>();
                    map.put(part, elements);
                }
                elements.add(new Element(part, subPart, Integer.valueOf(quantity)));
            }

            rootElement = defineRootElement();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String defineRootElement() {
        List<String> branches = new LinkedList<>(map.keySet());

        for (Map.Entry<String, List<Element>> entry : map.entrySet()) {
            List<Element> elementsInBranch = entry.getValue();
            for (Element element : elementsInBranch) {
                String subPart = element.getSubPart();
                if (branches.contains(subPart)) {
                    branches.remove(subPart);
                }
            }
        }
        if (branches.isEmpty()) {
            throw new RuntimeException("Your BOM description doesn't contain root element(part)");
        }
        return branches.get(0);
    }
}
