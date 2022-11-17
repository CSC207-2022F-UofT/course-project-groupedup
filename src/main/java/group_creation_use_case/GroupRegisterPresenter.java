package group_creation_use_case;

public interface GroupRegisterPresenter {
    GroupRegisterResponseModel prepareSuccessView(GroupRegisterResponseModel group);

    GroupRegisterResponseModel prepareFailView(String error);

}
