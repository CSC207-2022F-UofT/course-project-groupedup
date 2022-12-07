package view_user_public_profile_screens;

import view_user_public_profile_usecase.ViewUserPublicProfileInputBoundary;
import view_user_public_profile_usecase.ViewUserPublicProfileRequestModel;

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