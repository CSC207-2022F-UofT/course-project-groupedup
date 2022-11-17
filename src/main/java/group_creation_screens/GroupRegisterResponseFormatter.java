package group_creation_screens;
import group_creation_use_case.GroupRegisterPresenter;
import group_creation_use_case.GroupRegisterResponseModel;

public class GroupRegisterResponseFormatter implements GroupRegisterPresenter{

    @Override
    public GroupRegisterResponseModel prepareSuccessView(GroupRegisterResponseModel response) {
        return response;
    }

    @Override
    public GroupRegisterResponseModel prepareFailView(String error) {
        throw new GroupCreationFailed(error);
    }
}
