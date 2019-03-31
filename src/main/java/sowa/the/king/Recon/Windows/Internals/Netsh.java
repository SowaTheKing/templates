package sowa.the.king.Recon.Windows.Internals;

import sowa.the.king.Parser.CommandLineOutputParser;
import sowa.the.king.Parser.CommandType;
import sowa.the.king.Parser.WlanProfile;
import sowa.the.king.Recon.Windows.WindowsRecon;

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
        WlanProfile wlanProfile = new WlanProfile();
        for (String line : input.subList(9, 39)) {
            System.out.println(line);
            buildWlanProfileFromStrings(wlanProfile, line);
        }
        return wlanProfile;
    }

    private void buildWlanProfileFromStrings(WlanProfile wlanProfile, String line) {
        String[] pair = line.split(":");
        String key;
        String value;
        try {
            key = pair[0].trim();
            value = pair[1].trim();
        } catch (IndexOutOfBoundsException e) {
            return;
        }

        switch (key) {
            case "Type" : wlanProfile.setType(value);
            case "Name" : wlanProfile.setName(value);
            case "Number of SSIDs" : wlanProfile.setNumberOfSSIDs(value);
            case "SSID name" : wlanProfile.setSSIDname(value);
            case "Network type" : wlanProfile.setNetworkType(value);
            case "Radio type" : wlanProfile.setRadioType(value);
            case "Vendor extension" : wlanProfile.setVendorExtension(value);
            case "Authentication" : wlanProfile.setAuthentication(value);
            case "Cipher" : wlanProfile.setCipher(value);
            case "Security key" : wlanProfile.setSecurityKey(value);
            case "Key Content" : wlanProfile.setKeyContent(value);
        }
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
