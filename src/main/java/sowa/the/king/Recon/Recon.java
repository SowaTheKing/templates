package sowa.the.king.Recon;

import sowa.the.king.Parser.CommandLineOutputParser;
import sowa.the.king.Parser.CommandType;
import sowa.the.king.Parser.WlanProfile;
import sowa.the.king.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Recon {

    private static final String[] NET_USER_COMMAND = {"cmd.exe", "/c", "net", "user"};
    private static final String[] NETSH_WLAN_SHOW_PROFILES_COMMAND = {"cmd.exe", "/c", "netsh", "wlan", "show", "profiles"};
    private static final String[] NETSH_WLAN_GET_PROFILE = {"cmd.exe", "/c", "netsh", "wlan", "show", "profile"};

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
