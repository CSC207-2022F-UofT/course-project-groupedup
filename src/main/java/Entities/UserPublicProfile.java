package Entities;
import java.io.Serializable;
import java.util.HashMap;
public class UserPublicProfile implements Serializable {
    private String biography;
    private String coursePreferences = "";
    private HashMap<String, String> preferences;
    public UserPublicProfile(){
        HashMap<String, String> preferences = new HashMap<>();
        /*Prefilling in the preferences*/
        preferences.put("Time Commitment", "");
        preferences.put("Location", "");
        preferences.put("Meeting Time", "");
        this.preferences = preferences;
    }
// HANNAH'S CODE FROM GITHUB SO THERE WILL BE NO CONFLICTS CAUSE WE NEVER MERGED HER STUFF
    public String getCoursePreferences() {
        return this.coursePreferences;
    }

    public void setCoursePreferences(String coursePreferences) {
        this.coursePreferences = coursePreferences;
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