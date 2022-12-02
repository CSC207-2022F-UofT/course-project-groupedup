package Entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class GroupProfile implements Serializable {
    private String description;
    private String courseCode;
    private HashMap<String, String> preferences;

    public GroupProfile(){
        HashMap<String, String> preferences = new HashMap<>();
        preferences.put("Time Commitment", "");
        preferences.put("Location", "");
        preferences.put("Meeting Time", "");
        this.preferences = preferences;
    }
    public GroupProfile(HashMap<String, String> preferences){
        this.preferences = preferences;
    }

    public HashMap<String, String> getPreferences() {
        return this.preferences;
    }

    public String getDescription() {
        return this.description;
    }

    public void setPreferences(HashMap<String, String> updatedPreferences) {
        this.preferences = updatedPreferences;
    }

    public void setDescription(String updatedDescription) {
        this.description = updatedDescription;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseCode() {
        return this.courseCode;
    }
}
