package edit_user_public_profile_usecase;
import Entities.User;

public interface EditUserPublicProfileDSGateway {
    void saveUser(EditUserPublicProfileDSRequestModel profileDSRequestModel);
    User findUser(String username);
    boolean userExists(String username);
}
