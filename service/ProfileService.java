package org.akshay.messenger.service;

import org.akshay.messenger.database.DatabaseClass;
import org.akshay.messenger.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {


    private Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService(){
        profiles.put("Akshay",new Profile(1L,"Akshay:","Akshay","Babbar"));
    }

    public List<Profile> getAllProfiles() {
        return new ArrayList<>(profiles.values());
    }

    //GET Service
    public Profile getProfile(String profileName) {
        return profiles.get(profileName);
    }

    //POST Service
    public Profile addProfile(Profile profile) {
        profile.setId(profiles.size() + 1);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    //    PUT Service
    public Profile updateProfile(Profile profile) {
        if (profile.getProfileName().isEmpty())
            return null;
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }
//    DELETE Service
    public Profile deleteProfile(String profileName){
        return profiles.remove(profileName);
    }
}
