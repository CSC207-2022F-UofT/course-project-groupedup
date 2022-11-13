package edit_public_profile_usecase;

import java.util.HashMap;

public class editPublicProfileResponseModel {
    HashMap<String, String> editedPreferences;
    String editedBio;
    String Message;

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

    public String getMessage() {
        return this.Message;
    }

    public void setMessage() {
        /*Pass or fail message (I don't know if we want to let them leave their preferences blank or not)*/
        if (!this.editedBio.equals("")) {
            this.Message = "Edits were successful.";
        } else {
            this.Message = "Edits were unsuccessful";
        }
    }

}

