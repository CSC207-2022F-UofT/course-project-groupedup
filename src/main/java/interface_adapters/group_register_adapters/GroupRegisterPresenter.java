package interface_adapters.group_register_adapters;
import use_cases.group_creation_use_case.GroupRegisterOutputBoundary;
import use_cases.group_creation_use_case.GroupRegisterResponseModel;


/**
 * Takes information/data from the interactor and will tell the UI
 * what to display.
 */

public class GroupRegisterPresenter implements GroupRegisterOutputBoundary{
    GroupCreationScreenBoundary groupRegisterScreenBoundary;


    public GroupRegisterPresenter(GroupCreationScreenBoundary groupRegisterScreenBoundary ){
        this.groupRegisterScreenBoundary = groupRegisterScreenBoundary;

    }
    public GroupRegisterPresenter(){};
    /**
     * Takes the response model data and calls the view interface to display success
     * with the data from the response model. Since groupRegisterScreenBoundary is an interface,
     * the presenter is not dependent on the view/UI.
     * @param groupResponseModel
     *
     */
    @Override
    public void prepareSuccessView(GroupRegisterResponseModel groupResponseModel) {
        this.groupRegisterScreenBoundary.switchScreen(groupResponseModel.getGroupName());

    }

    /**
     * Takes an error message and calls the view model interface to display failure
     * with the data from the response model. Since groupRegisterScreenBoundary is an interface,
     * the presenter is not dependent on the view/UI.
     * @param error
     */
    @Override
    public void prepareFailView(String error) {
        this.groupRegisterScreenBoundary.prepareFailView(error);
    }
}
