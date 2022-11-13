package edit_public_profile_usecase;

import Entities.UserPublicProfile;

public interface editPublicProfileInputBoundary {
    editPublicProfileResponseModel create(editPublicProfileRequestModel requestModel);
}
