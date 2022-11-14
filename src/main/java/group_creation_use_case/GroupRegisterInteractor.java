package group_creation_use_case;

import Entities.Group;

public class GroupRegisterInteractor implements GroupRegisterInputBoundary{
    final GroupDSGateway groupDSGateway;
    final GroupRegisterPresenter groupPresenter;
    final GroupFactory groupFactory;

    public GroupRegisterInteractor(GroupDSGateway groupDSGateway, GroupRegisterPresenter groupPresenter,
                                   GroupFactory groupFactory){
        this.groupDSGateway= groupDSGateway;
        this.groupPresenter = groupPresenter;
        this.groupFactory = groupFactory;

    }


    @Override
    public GroupRegisterResponseModel create(GroupRegisterRequestModel requestModel) {
        if (groupDSGateway.existsByIdentifier(requestModel.getGroupName())){
            return groupPresenter.prepareFailView("Group already exists.");
        } else if (requestModel.getGroupName().equals("")){
            return groupPresenter.prepareFailView("Invalid group name.");
        }
        Group group = groupFactory.create(requestModel.getGroupName());
        GroupRegisterDSRequestModel groupDSRequestModel = new GroupRegisterDSRequestModel(group, group.getGroupName());
        groupDSGateway.save(groupDSRequestModel);
        GroupRegisterResponseModel groupResponseModel = new GroupRegisterResponseModel(group.getGroupName());
        return groupPresenter.prepareSuccessView(groupResponseModel);
    }
}












