package edit_user_public_profile_usecase;

import java.util.HashMap;

public class EditUserPublicProfileResponseModel {
    private HashMap<String, String> editedPreferences;
    private String coursePreferences;
    private String editedBio;
    private String message;

    public EditUserPublicProfileResponseModel(HashMap<String, String> editedPreferences,
                                              String coursePreferences,
                                              String editedBio,
                                              String message){
        this.editedPreferences = editedPreferences;
        this.coursePreferences = coursePreferences;
        this.editedBio = editedBio;
        this.message = message;
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

