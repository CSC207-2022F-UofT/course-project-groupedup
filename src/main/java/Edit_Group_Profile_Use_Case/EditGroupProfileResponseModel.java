package Edit_Group_Profile_Use_Case;
import java.util.HashMap;

public class EditGroupProfileResponseModel {

    HashMap<String, String> editedPreferences;
    String editedDescription;

    public EditGroupProfileResponseModel(HashMap<String, String> editedPreferences, String editedDescription){
        this.editedPreferences = editedPreferences;
        this.editedDescription = editedDescription;
    }

    public String getEditedDescription() {
        return this.editedDescription;
    }

    public void setEditedDescription(String editedDescription) {
        this.editedDescription = editedDescription;
    }


    public HashMap<String, String> getEditedPreferences() {
        return this.editedPreferences;
    }

    public void setEditedPreferences(HashMap<String, String>  editedPreferences) {
        this.editedPreferences = editedPreferences;
    }

}
