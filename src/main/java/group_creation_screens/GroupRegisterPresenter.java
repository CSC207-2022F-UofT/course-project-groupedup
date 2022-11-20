package group_creation_screens;
import group_creation_use_case.GroupRegisterOutputBoundary;
import group_creation_use_case.GroupRegisterResponseModel;

public class GroupRegisterPresenter implements GroupRegisterOutputBoundary {
    /**
     *
     * @param response takes the response model data and presents it in the UI upon success
     * @return
     */
    @Override
    public GroupRegisterResponseModel prepareSuccessView(GroupRegisterResponseModel response) {
        return response;
    }

    /**
     *
     * @param error takes an error message and presents a failure screen/message in the UI upon failure
     * @return
     */
    @Override
    public GroupRegisterResponseModel prepareFailView(String error) {
        throw new GroupCreationFailed(error);
    }
}
