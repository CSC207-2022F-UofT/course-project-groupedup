package view_user_public_profile_screens;

import view_user_public_profile_usecase.ViewUserPublicProfileInputBoundary;
import view_user_public_profile_usecase.ViewUserPublicProfileResponseModel;
import view_user_public_profile_usecase.ViewUserPublicProfileRequestModel;

public class ViewUserPublicProfileController {
    final ViewUserPublicProfileInputBoundary viewInput;

    public ViewUserPublicProfileController(ViewUserPublicProfileInputBoundary viewInput) {
        this.viewInput = viewInput;
    }

    ViewUserPublicProfileResponseModel viewProfile(String username) {

        ViewUserPublicProfileRequestModel requestModel = new ViewUserPublicProfileRequestModel(username);

        return viewInput.showUserProfile(requestModel);

    }
}