package sowa.the.king;

import sowa.the.king.Parser.CommandLineOutputParser;
import sowa.the.king.Parser.Parser;
import sowa.the.king.Recon.OperatingSystemPOJO;
import sowa.the.king.Recon.Recon;
import sowa.the.king.Util.ReconDisplay;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        parser.parse(args);

        Recon recon = new Recon();

        OperatingSystemPOJO osNamme = recon.getOs();

        ReconDisplay.displayWelcome(osNamme);
        ReconDisplay.displayOptions(parser);

        System.out.println(recon.getUserNames());

        CommandLineOutputParser commandLineOutputParser = new CommandLineOutputParser();
        List<String> output = recon.getNetshProfiles();
        System.out.println(output);



    }
}
