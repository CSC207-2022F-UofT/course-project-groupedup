package view_user_public_profile_usecase;

import Entities.User;

public interface ViewUserPublicProfileDSGateway {
    User findUser(String username);
}
