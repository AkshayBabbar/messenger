/*
*   @author:    Akshay Babbar
*   @Version:   1.0
*   @Purpose:
* */
package org.akshay.messenger.database;

import org.akshay.messenger.model.Message;
import org.akshay.messenger.model.Profile;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {
    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();

    public static Map<Long, Message> getMessages(){
        return messages;
    }

    public static Map<String, Profile> getProfiles(){
        return profiles;
    }
}
