package interface_adapters.view_user_public_profile_adapters;

import use_cases.view_user_public_profile_use_case.ViewUserPublicProfileInputBoundary;
import use_cases.view_user_public_profile_use_case.ViewUserPublicProfileRequestModel;

public class ViewUserPublicProfileController {
    final ViewUserPublicProfileInputBoundary viewInput;

    public ViewUserPublicProfileController(ViewUserPublicProfileInputBoundary viewInput) {
        this.viewInput = viewInput;
    }

    /**
     * Method allows the user to view their profile.
     * @param username the username of the current user.
     */
    public void viewProfile(String username) {
        ViewUserPublicProfileRequestModel requestModel = new ViewUserPublicProfileRequestModel(username);
        viewInput.showUserProfile(requestModel);
    }
}