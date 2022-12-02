package group_creation_screens;

import group_creation_use_case.GroupRegisterResponseModel;

public interface GroupRegisterViewModel {
    void displaySuccess(GroupRegisterResponseModel groupResponseModel);
    void displayFailure(String error);
}
