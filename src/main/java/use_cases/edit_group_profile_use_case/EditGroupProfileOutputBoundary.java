package use_cases.edit_group_profile_use_case;

/**
 * This is an interface between the interactor and the presenter.
 * The presenter implements this interface to create a dependency.
 * Since the interactor needs to communicate with the UI.
 */

public interface EditGroupProfileOutputBoundary {

    void prepareSuccessView(EditGroupProfileResponseModel newChanges);

    void prepareFailView(String error);
}
