package org.akshay.messenger.resources;


import org.akshay.messenger.model.Profile;
import org.akshay.messenger.service.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

    private ProfileService profileService = new ProfileService();

    //For getting all Profiles
    @GET
    public List<Profile> getAllProfile() {
        return profileService.getAllProfiles();
    }

    //    Get Specifice Profiles
    @Path("/{profileName}")
    @GET
    public Profile getProfile(@PathParam("profileName") String profileName) {
        return profileService.getProfile(profileName);
    }

    //For Posting Profiles
    @POST
    public Profile addProfile(Profile profile) {
        return profileService.addProfile(profile);
    }


    @Path("/{profileName}")
    @PUT
    public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
        profile.setProfileName(profileName);
        return profileService.updateProfile(profile);
    }

    @Path("/{profileName}")
    @DELETE
    public Profile removeProfile(@PathParam("profileName") String profileName){
        return profileService.deleteProfile(profileName);
    }
}
