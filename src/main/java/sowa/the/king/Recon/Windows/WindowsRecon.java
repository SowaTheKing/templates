package sowa.the.king.Recon.Windows;

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

public class WindowsRecon {

    private static final String[] NET_USER_COMMAND = {"cmd.exe", "/c", "net", "user"};
    private static final String[] NETSH_WLAN_SHOW_PROFILES_COMMAND = {"cmd.exe", "/c", "netsh", "wlan", "show", "profiles"};
    private static final String[] NETSH_WLAN_GET_PROFILE = {"cmd.exe", "/c", "netsh", "wlan", "show", "profile"};

    public List<String> getNetshProfiles() throws IOException {
        CommandLineOutputParser commandLineOutputParser = new CommandLineOutputParser();
        List<String> output = runCommandCaptureOutput(NETSH_WLAN_SHOW_PROFILES_COMMAND);
        return (List<String>) commandLineOutputParser.parse(CommandType.NETSH_WLAN_SHOW_PROFILES, output);
    }

    public List<User> getUserNames() throws IOException {
        CommandLineOutputParser commandLineOutputParser = new CommandLineOutputParser();
        List<String> output = runCommandCaptureOutput(NET_USER_COMMAND);
        return (List<User>) commandLineOutputParser.parse(CommandType.NET_USER, output);
    }

    public List<WlanProfile> getNetshProfilesLayer() throws IOException {
        Netsh netsh = new Netsh();
        return netsh.getWlanProfiles();
    }

    public static List<String> runCommandCaptureOutput(String[] commands) throws IOException {
        List<String> output = new ArrayList<>();
        ProcessBuilder pb = new ProcessBuilder(commands);
        pb.redirectErrorStream(true);

        Process process = pb.start();
        InputStream inputStream = process.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            output.add(line);
        }
        return output;
    }
}
