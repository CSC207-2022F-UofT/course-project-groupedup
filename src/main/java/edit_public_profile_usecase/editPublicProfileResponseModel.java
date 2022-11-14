package edit_public_profile_usecase;

import java.util.HashMap;

public class editPublicProfileResponseModel {
    HashMap<String, String> editedPreferences;
    String editedBio;

    public editPublicProfileResponseModel(HashMap<String, String> editedPreferences, String editedBio){
        this.editedPreferences = editedPreferences;
        this.editedBio = editedBio;
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

}

