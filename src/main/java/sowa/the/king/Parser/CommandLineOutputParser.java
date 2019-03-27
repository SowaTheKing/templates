package sowa.the.king.Parser;

import sowa.the.king.User;

import java.util.ArrayList;
import java.util.List;

public class CommandLineOutputParser {

    public Object parse(CommandType commandType, List<String> input) {
        if (CommandType.NET_USER.equals(commandType)) {
            return parseFromNetUser(input);
        }
        if (CommandType.NETSH_WLAN_SHOW_PROFILES.equals(commandType)) {
            return parseFromNetshWlanShowProfiles(input);
        }
        return null;
    }

    private List<User> parseFromNetUser(List<String> input) {
        List<User> users = new ArrayList<>();
        String[] splited = new String[]{};
        for (String line : input.subList(4, 5)) {
            splited = line.split("\\s+");
        }
        // CleanupList
        for (String userName : splited) {
            if (!"".equals(userName)) {
                users.add(new User(userName));
            }
        }
        return users;
    }

    private List<String> parseFromNetshWlanShowProfiles(List<String> input) {
        List<String> profiles = new ArrayList<>();
        String[] splited = new String[]{};
        for (String line : input.subList(9, input.size())) {
            if (!"".equals(line)) {
                String split = line.split(":")[1].trim();
                profiles.add(split);
            }
        }
        return profiles;
    }
}

