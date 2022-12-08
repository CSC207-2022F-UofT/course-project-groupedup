package use_cases.view_user_public_profile_use_case;
import entities.InteractorMessages;
import entities.User;

/**
 * The view user public profile use case.
 */
public class ViewUserPublicProfileInteractor implements ViewUserPublicProfileInputBoundary {
    final private ViewUserPublicProfileDSGateway userDSGateway;
    final private ViewUserPublicProfileOutputBoundary viewUserProfileOutputBoundary;

    /**
     *
     * @param userDSGateway is the data access interface used to save and find the user's public profile.
     * @param viewUserProfileOutputBoundary is the output boundary implemented by the viewUserPublicProfilePresenter
     */
    public ViewUserPublicProfileInteractor(ViewUserPublicProfileDSGateway userDSGateway,
                                    ViewUserPublicProfileOutputBoundary viewUserProfileOutputBoundary) {
        this.userDSGateway = userDSGateway;
        this.viewUserProfileOutputBoundary = viewUserProfileOutputBoundary;
    }

    /**
     * Implements the showUserProfile from the Input Boundary's interface.
     * @param requestModel the request model for the view public profile use case. Holds the username.
     */
    @Override
    public void showUserProfile(ViewUserPublicProfileRequestModel requestModel) {
        String username = requestModel.getUsername();
        if (userDSGateway.userIdentifierExists(username)) {
            /*Find User*/
            User user = userDSGateway.getUser(username);

            ViewUserPublicProfileResponseModel successViewResponseModel = new ViewUserPublicProfileResponseModel(
                    user.getUsername(),
                    user.getUserPublicProfile().getPreferences(),
                    user.getUserPublicProfile().getCoursePreferences(),
                    user.getUserPublicProfile().getBiography());

            /*Return response model with userPublicProfile information*/
            viewUserProfileOutputBoundary.prepareSuccessView(successViewResponseModel);
        } else {
            throw new RuntimeException(InteractorMessages.USER_DOES_NOT_EXIST);
        }
    }
}

