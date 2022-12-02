package Edit_Group_Profile_Use_Case;
import java.util.HashMap;

public class EditGroupProfileResponseModel {

    HashMap<String, String> editedPreferences;
    String editedDescription;

    String courseCode;
    String error;

    public EditGroupProfileResponseModel(HashMap<String, String> editedPreferences, String editedCourseCode, String editedDescription, String error){
        this.editedPreferences = editedPreferences;
        this.courseCode = editedCourseCode;
        this.editedDescription = editedDescription;
        this.error = error;
    }

    public String getNewCourseCode() {
        return this.courseCode;
    }

    public void setNewCourseCode(String newCourseCode) {
        this.courseCode = newCourseCode;
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

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }
}
