Description: Bill of material explosion. Collect all needed sub-parts

Usage: Run with argument: /{pathToFile}/{fileName}

File example:
Bicycle    Handlebar       1
Bicycle    Pedal           2
Bicycle    Frame           1
Bicycle    Wheel           2
Bicycle    Saddle          1
Wheel      Tire            1
Wheel      Spokes         32
Wheel      Hub             1
Spokes     Spoke           1
Spokes     Nipple          1


Result output:
     1 Handlebar 
     2 Pedal     
     1 Frame     
     2 Tire      
    64 Spoke     
    64 Nipple    
     2 Hub       
     1 Saddle    