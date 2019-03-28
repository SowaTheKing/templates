package sowa.the.king.Recon.Windows;

import sowa.the.king.Parser.CommandLineOutputParser;
import sowa.the.king.Parser.CommandType;
import sowa.the.king.Parser.WlanProfile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Netsh {

    private static final String[] NETSH_WLAN_SHOW_PROFILES_COMMAND = {"cmd.exe", "/c", "netsh", "wlan", "show", "profiles"};
    private static String[] NETSH_WLAN_GET_PROFILE = {"cmd.exe", "/c", "netsh", "wlan", "show", "profile"};

    public List<WlanProfile> getWlanProfiles() throws IOException {
        List<String> profiles = getNetshProfiles();
        List<WlanProfile> wlanProfiles = new ArrayList<>();
        for (String profile : profiles) {
            String[] parametrizedCommand = buildParametrizedGetWlanProfileCommand(profile);
            List<String> output = WindowsRecon.runCommandCaptureOutput(parametrizedCommand);
            wlanProfiles.add(parseWlanProfile(output));
        }
        return wlanProfiles;
    }

    private WlanProfile parseWlanProfile(List<String> input) {
        for (String line : input.subList(9, 39)) {
            System.out.println(line);
        }
        return new WlanProfile();
    }

    private List<String> getNetshProfiles() throws IOException {
        CommandLineOutputParser commandLineOutputParser = new CommandLineOutputParser();
        List<String> output = WindowsRecon.runCommandCaptureOutput(NETSH_WLAN_SHOW_PROFILES_COMMAND);
        return (List<String>) commandLineOutputParser.parse(CommandType.NETSH_WLAN_SHOW_PROFILES, output);
    }

    private String[] buildParametrizedGetWlanProfileCommand(String profileName) {
        List<String> parametrizedCommand = new ArrayList<>();
        for (String command : NETSH_WLAN_GET_PROFILE) {
            parametrizedCommand.add(command);
        }
        parametrizedCommand.add("name=" + profileName);
        parametrizedCommand.add("key=clear");
        return parametrizedCommand.toArray(new String[]{});
    }
}
