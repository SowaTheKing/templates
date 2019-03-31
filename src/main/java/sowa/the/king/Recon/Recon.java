package sowa.the.king.Recon;

import java.util.Properties;

public class Recon {

    public OperatingSystemPOJO getOs() {
        return getOsPOJO();
    }

    private OperatingSystemPOJO getOsPOJO() {
        Properties properties = System.getProperties();
        OperatingSystemPOJO osPOJO = new OperatingSystemPOJO();

        osPOJO.setName(properties.getProperty("os.name"));
        osPOJO.setVersion(properties.getProperty("os.version"));
        return osPOJO;
    }

    /*public void getInstalledProgramsList() throws IOException {
        String command = "cmd \\c wmic /output:\"C:\\/Users\\%username%\\Desktop\\temp.txt\"  product get name,version";

        Runtime rt = Runtime.getRuntime();
        rt.exec(command);
    }

    public void runCommand(String command) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "wmic",  "/output:\"C:\\/Users\\%username%\\Desktop\\temp.txt\"", "product get name,version");
        pb.redirectErrorStream(true);
        pb.start();
    }*/

}
