package view_user_public_profile_screens;

import use_cases.view_user_public_profile_use_case.ViewUserPublicProfileInputBoundary;
import use_cases.view_user_public_profile_use_case.ViewUserPublicProfileRequestModel;

public class ViewUserPublicProfileController {
    final ViewUserPublicProfileInputBoundary viewInput;

    public ViewUserPublicProfileController(ViewUserPublicProfileInputBoundary viewInput) {
        this.viewInput = viewInput;
    }

    public void viewProfile(String username) {
        ViewUserPublicProfileRequestModel requestModel = new ViewUserPublicProfileRequestModel(username);
        viewInput.showUserProfile(requestModel);
    }
}