package sowa.the.king.Parser;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class Parser extends OptionsPOJO {

    public void parse(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("Java SampleMain [options...] arguments...");
            parser.printUsage(System.err);
            System.err.println();
        }
    }
}
