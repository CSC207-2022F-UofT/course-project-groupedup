package Entities;
import java.util.HashMap;

public class GroupProfile {
    private String description;
    private String courseCode;
    private HashMap<String, String> preferences;

    public GroupProfile(){
        HashMap<String, String> preferences = new HashMap<>();
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

}
