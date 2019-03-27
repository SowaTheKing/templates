package sowa.the.king.Parser;

import org.kohsuke.args4j.Option;

public class OptionsPOJO {

    @Option(name = "-i", usage = "Take Intel of OS")
    private boolean takeIntel;

    public boolean isTakeIntel() {
        return takeIntel;
    }
}
