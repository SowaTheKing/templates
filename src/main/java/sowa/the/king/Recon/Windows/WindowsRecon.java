package sowa.the.king.Recon.Windows;

import sowa.the.king.Parser.WlanProfile;
import sowa.the.king.Recon.Windows.Internals.Net;
import sowa.the.king.Recon.Windows.Internals.Netsh;
import sowa.the.king.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WindowsRecon {

    private static transient Net net = new Net();
    private static transient Netsh netsh = new Netsh();




    public List<User> getUserNames() throws IOException {
        return net.getUserNames();
    }

    public List<WlanProfile> getWifiProfiles() throws IOException {
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
