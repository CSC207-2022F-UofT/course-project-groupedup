package use_cases.group_creation_use_case;

/**
 * A data bundle which takes in the user's input from the GroupRegisterScreen.
 * It is passed into the interacter.
 */
public class GroupRegisterRequestModel {
    private String groupName;

    public GroupRegisterRequestModel(String groupName){
        this.groupName = groupName;
    }

    /**
     *
     * @return the Group's unique name.
     */
    public String getGroupName() {
        return groupName;
    }
}
