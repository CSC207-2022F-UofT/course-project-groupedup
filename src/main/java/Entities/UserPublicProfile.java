package Entities;
import java.io.Serializable;
import java.util.HashMap;
public class UserPublicProfile implements Serializable {
    private String biography;
    private HashMap<String, String> preferences;
    public UserPublicProfile(){
        HashMap<String, String> preferences = new HashMap<>();
        /*Prefilling in the preferences*/
        preferences.put("courseCode", "");
        preferences.put("timeCommitment", "");
        preferences.put("location", "");
        preferences.put("meetingTime", "");
        this.preferences = preferences;
    }

    public HashMap<String, String> getPreferences() {
        return this.preferences;
    }

    public void setPreferences(HashMap<String, String> newPreferences) {
        this.preferences = newPreferences;
    }

    public String getBiography() {
        return this.biography;
    }

    public void setBiography(String bio) {
        this.biography = bio;
    }
}
