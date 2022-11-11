package Entities;
import java.util.HashMap;
public class UserPublicProfile {
    private String biography;
    private HashMap<String, String> preferences;
    public UserPublicProfile(){
        HashMap<String, String> preferences = new HashMap<>();
        /*Prefilling in the preferences*/
        preferences.put("Work Hours", "");
        preferences.put("Remote or In-person", "");
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
