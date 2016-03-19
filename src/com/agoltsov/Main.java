package com.agoltsov;

import com.agoltsov.models.SubPart;
import com.agoltsov.services.BomExplosionService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Argument is not defined, expected path of file");

        } else {
            print(new BomExplosionService().explode(args[0]));
        }
    }

    private static void print(List<SubPart> elements) {
        for (SubPart subPart : elements) {
            System.out.format("%6d %-10s", subPart.getQuantity(), subPart.getName());
            System.out.println();
        }

    }
}
