package Edit_Group_Profile_Use_Case;

public class EditGroupProfileDsRequestModel {

    String groupName;
    public EditGroupProfileDsRequestModel(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName(){
        return this.groupName;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }
}

