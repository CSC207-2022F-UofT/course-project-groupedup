package group_creation_use_case;

import Entities.Checker;
import Entities.Group;
import Entities.Saver;

public class GroupRegisterInteractor implements GroupRegisterInputBoundary{
    final Checker groupChecker;
    final Saver groupSaver;
    final GroupRegisterPresenter groupPresenter;
    final GroupFactory groupFactory;

    public GroupRegisterInteractor(Checker groupChecker, Saver groupSaver, GroupRegisterPresenter groupPresenter,
                                   GroupFactory groupFactory){
        this.groupChecker = groupChecker;
        this.groupPresenter = groupPresenter;
        this.groupFactory = groupFactory;
        this.groupSaver = groupSaver;

    }


    @Override
    public GroupRegisterResponseModel create(GroupRegisterRequestModel requestModel) {
        if (groupChecker.existsByName(requestModel.getGroupName())){
            return groupPresenter.prepareFailView("Group already exists.");
        } else if (requestModel.getGroupName() == ""){
            return groupPresenter.prepareFailView("Invalid group name.");
        }
        Group group = groupFactory.create(requestModel.getGroupName());
        groupSaver.saveToRepo(group);
        GroupRegisterResponseModel groupResponseModel = new GroupRegisterResponseModel(group.getGroupName());
        return groupPresenter.prepareSuccessView(groupResponseModel);
    }
}












