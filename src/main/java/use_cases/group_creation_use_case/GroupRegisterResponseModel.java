package use_cases.group_creation_use_case;

/**
 * This is a data bundle of the data which should be presented by the presenter
 * to the UI in response to the group creaitonuse case being completed.
 * It is passed to the presenter.
 */
public class GroupRegisterResponseModel {

    String groupName;

    public GroupRegisterResponseModel(String groupName){
        this.groupName = groupName;
    }

    /**
     *
     * @return the Group's groupname.
     */
    public String getGroupName() {
        return groupName;
    }

}
