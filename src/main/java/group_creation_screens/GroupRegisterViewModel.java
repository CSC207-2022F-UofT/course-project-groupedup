package group_creation_screens;

import group_creation_use_case.GroupRegisterResponseModel;

/**
 * This is an interface which creates dependency inversion between the presenter
 * and the view/UI. This interface is implemented by GroupRegisterView which
 * will directly modify the UI and is injected into the GroupRegisterPresenter.
 */
public interface GroupRegisterViewModel {
    void displaySuccess(GroupRegisterResponseModel groupResponseModel);
    void displayFailure(String error);
}
