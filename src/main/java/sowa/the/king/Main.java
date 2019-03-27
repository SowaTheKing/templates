package sowa.the.king;

import sowa.the.king.Parser.Parser;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.parse(args);

        System.out.println(parser.isTakeIntel());

    }
}
