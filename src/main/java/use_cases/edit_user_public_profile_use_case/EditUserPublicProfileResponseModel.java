package use_cases.edit_user_public_profile_use_case;

import java.util.HashMap;

/**
 * Edit user public profile response model.
 */
public class EditUserPublicProfileResponseModel {
    private final String username;
    private HashMap<String, String> editedPreferences;
    private String coursePreferences;
    private String editedBio;
    private String message;

    /**
     *
     * @param editedPreferences User's edited preferences.
     * @param coursePreferences User's edited course preferences.
     * @param editedBio User's edited bio.
     * @param message Success/failure message.
     */
    public EditUserPublicProfileResponseModel(String username, HashMap<String, String> editedPreferences,
                                              String coursePreferences,
                                              String editedBio,
                                              String message){
        this.username = username;
        this.editedPreferences = editedPreferences;
        this.coursePreferences = coursePreferences;
        this.editedBio = editedBio;
        this.message = message;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEditedBio() {
        return this.editedBio;
    }

    public void setEditedBio(String editedBio) {
        this.editedBio = editedBio;
    }


    public HashMap<String, String> getEditedPreferences() {
        return this.editedPreferences;
    }

    public void setEditedPreferences(HashMap<String, String>  editedPreferences) {
        this.editedPreferences = editedPreferences;
    }

    public String getEditedCoursePreferences() {
        return this.coursePreferences;
    }

    public void setEditedCoursePreferences(String editedCoursePreferences) {
        this.coursePreferences = editedCoursePreferences;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}

