package view_user_public_profile_usecase;

import UserRegistrationUsecase.NewUserDSGateway;
import Entities.User;

/**
 * The view user public profile use case.
 */
public class ViewUserPublicProfileInteractor implements ViewUserPublicProfileInputBoundary {
    final private NewUserDSGateway userDSGateway;
    final private ViewUserPublicProfileOutputBoundary viewUserProfileOutputBoundary;

    /**
     *
     * @param userDSGateway is the data access interface used to save and find the user's public profile.
     * @param viewUserProfileOutputBoundary is the output boundary implemented by the viewUserPublicProfilePresenter
     */
    ViewUserPublicProfileInteractor(NewUserDSGateway userDSGateway,
                                    ViewUserPublicProfileOutputBoundary viewUserProfileOutputBoundary) {
        this.userDSGateway = userDSGateway;
        this.viewUserProfileOutputBoundary = viewUserProfileOutputBoundary;
    }

    /**
     * Implements the showUserProfile from the Input Boundary's interface.
     * @param requestModel the request model for the view public profile use case. Holds the username.
     * @return the user's public profile information.
     */
    @Override
    public ViewUserPublicProfileResponseModel showUserProfile(ViewUserPublicProfileRequestModel requestModel) {
        /*Find User*/
        String username = requestModel.getUsername();

        User user = userDSGateway.loadUsers().get(username);

        ViewUserPublicProfileResponseModel successViewResponseModel = new ViewUserPublicProfileResponseModel(
                user.getUserPublicProfile().getPreferences(),
                user.getUserPublicProfile().getCoursePreferences(),
                user.getUserPublicProfile().getBiography());

        /*Return response model with userPublicProfile information*/
        return viewUserProfileOutputBoundary.prepareSuccessView(successViewResponseModel);
    }
}

