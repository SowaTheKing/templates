package sowa.the.king;

import sowa.the.king.Parser.Parser;
import sowa.the.king.Recon.OperatingSystemPOJO;
import sowa.the.king.Recon.Recon;
import sowa.the.king.Recon.Windows.WindowsRecon;
import sowa.the.king.Util.ReconDisplay;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.parse(args);

        Recon recon = new Recon();

        OperatingSystemPOJO osNamme = recon.getOs();

        ReconDisplay.displayWelcome(osNamme);
        ReconDisplay.displayOptions(parser);

        // TODO - run the thread's conditionally, despite option's. If recon enabled, run that etc
        Thread t1 = new WindowsRecon();
        t1.start();
    }
}
