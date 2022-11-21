package group_creation_use_case;

import Entities.Group;

import java.io.IOException;

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
     * Executes the Group Creation Use Case. Will create a Group and store it in the database
     * if the Group doesn't already exist.
     * @param requestModel
     * @return
     */

    @Override
    public GroupRegisterResponseModel create(GroupRegisterRequestModel requestModel) {
        if (newGroupDSGateway.groupIdentifierExists(requestModel.getGroupName())){
            return groupPresenter.prepareFailView("Group already exists.");
        } else if (requestModel.getGroupName().equals("")){
            return groupPresenter.prepareFailView("Invalid group name.");
        }
        Group group = groupFactory.create(requestModel.getGroupName());
        GroupRegisterDSRequestModel groupDSRequestModel = new GroupRegisterDSRequestModel(group, group.getGroupName());
        newGroupDSGateway.saveNewGroups(groupDSRequestModel);
        GroupRegisterResponseModel groupResponseModel = new GroupRegisterResponseModel(group.getGroupName());
        return groupPresenter.prepareSuccessView(groupResponseModel);
    }
}












