package edit_user_public_profile_usecase;

import java.util.HashMap;

public class editUserPublicProfileResponseModel {
    private HashMap<String, String> editedPreferences;
    private String editedBio;
    private String message;

    public editUserPublicProfileResponseModel(HashMap<String, String> editedPreferences, String editedBio, String message){
        this.editedPreferences = editedPreferences;
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

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}

