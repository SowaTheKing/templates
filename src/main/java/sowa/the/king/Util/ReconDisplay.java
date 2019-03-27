package sowa.the.king.Util;

import sowa.the.king.Parser.Parser;
import sowa.the.king.Recon.OperatingSystemPOJO;

public class ReconDisplay {
    public static void displayWelcome(OperatingSystemPOJO osPojo) {
        System.out.println("Welcome to HACK THE PLANET v 0.1");
        System.out.println();
        System.out.println("Your are on: \t" + osPojo.getName() + " \t " + osPojo.getVersion());
    }

    public static void displayOptions(Parser parser) {
        System.out.println("Options :");
        if (parser.isTakeIntel()) {
            System.out.println("\t [*] Take intel Option");
        }
    }
}
