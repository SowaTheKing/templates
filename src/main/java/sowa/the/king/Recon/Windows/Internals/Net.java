package sowa.the.king.Recon.Windows.Internals;

import sowa.the.king.Parser.CommandLineOutputParser;
import sowa.the.king.Parser.CommandType;
import sowa.the.king.User;

import java.io.IOException;
import java.util.List;

import static sowa.the.king.Recon.Windows.WindowsRecon.runCommandCaptureOutput;

public class Net {
    private static final String[] NET_USER_COMMAND = {"cmd.exe", "/c", "net", "user"};

    public List<User> getUserNames() throws IOException {
        CommandLineOutputParser commandLineOutputParser = new CommandLineOutputParser();
        List<String> output = runCommandCaptureOutput(NET_USER_COMMAND);
        return (List<User>) commandLineOutputParser.parse(CommandType.NET_USER, output);
    }
}
