package group_creation_use_case;

import Entities.Group;

import javax.swing.*;
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
    public boolean create(GroupRegisterRequestModel requestModel) {
        if (newGroupDSGateway.groupIdentifierExists(requestModel.getGroupName())){
            groupPresenter.prepareFailView("Group already exists.");
            return false;
        } else if (requestModel.getGroupName().equals("")){
            groupPresenter.prepareFailView("Invalid group name.");
            return false;
        }
        Group group = groupFactory.create(requestModel.getGroupName());
        GroupRegisterDSRequestModel groupDSRequestModel = new GroupRegisterDSRequestModel(group, group.getGroupName());
        newGroupDSGateway.saveNewGroups(groupDSRequestModel);
        GroupRegisterResponseModel groupResponseModel = new GroupRegisterResponseModel(group.getGroupName());
        groupPresenter.prepareSuccessView(groupResponseModel);
        return true;
    }
}












