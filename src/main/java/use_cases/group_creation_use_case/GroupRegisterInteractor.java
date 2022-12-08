package use_cases.group_creation_use_case;

import entities.*;

/**
 * This interactor will execute the functionality of the group creation use case.
 */
public class GroupRegisterInteractor implements GroupRegisterInputBoundary{
    final GroupRegisterOutputBoundary groupPresenter;
    final GroupFactory groupFactory;

    final NewGroupDSGateway newGroupDSGateway;

    public GroupRegisterInteractor(NewGroupDSGateway newGroupDSGateway, GroupRegisterOutputBoundary groupPresenter,
                                   GroupFactory groupFactory){
        this.newGroupDSGateway = newGroupDSGateway;
        this.groupPresenter = groupPresenter;
        this.groupFactory = groupFactory;
    }

    /**
     * Executes the Group Creation Use Case.
     * Takes in a request model and checks if the group name is valid.
     * If the group name is empty then it will get the presenter to display failure.
     * If the group already exists in the database then the presenter will display failure.
     * If the group doesn't already exist, a new group object will be created, saved to
     * the database, and the presenter will display success.
     * @param requestModel
     * @return
     */

    @Override
    public boolean create(GroupRegisterRequestModel requestModel) {
        if (newGroupDSGateway.groupIdentifierExists(requestModel.getGroupName())){
            groupPresenter.prepareFailView(InteractorMessages.GROUP_EXISTS);
            return false;
        } else if (requestModel.getGroupName().equals("")){
            groupPresenter.prepareFailView(InteractorMessages.INVALID_GROUP_NAME);
            return false;
        }
        Group group = groupFactory.create(requestModel.getGroupName());
        GroupRegisterDSRequestModel groupDSRequestModel = new GroupRegisterDSRequestModel(group, group.getGroupName());
        newGroupDSGateway.saveNewGroups(groupDSRequestModel);
        CurrentUser.getInstance().getUser().getGroups().put(group.getGroupName(), group.getGroupName());
        newGroupDSGateway.updateUser(CurrentUser.getInstance().getUser());
        GroupRegisterResponseModel groupResponseModel = new GroupRegisterResponseModel(group.getGroupName());
        groupPresenter.prepareSuccessView(groupResponseModel);
        return true;
    }
}












