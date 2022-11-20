package view_user_public_profile_screens;

import view_user_public_profile_usecase.viewUserPublicProfileInputBoundary;
import view_user_public_profile_usecase.viewUserPublicProfileResponseModel;
import view_user_public_profile_usecase.viewUserPublicProfileRequestModel;

import java.util.HashMap;

public class viewUserPublicProfileController {
    final viewUserPublicProfileInputBoundary viewInput;

    public viewUserPublicProfileController(viewUserPublicProfileInputBoundary viewInput) {
        this.viewInput = viewInput;
    }

    viewUserPublicProfileResponseModel viewProfile(String username) {

        viewUserPublicProfileRequestModel requestModel = new viewUserPublicProfileRequestModel(username);

        return viewInput.showUserProfile(requestModel);

    }
}