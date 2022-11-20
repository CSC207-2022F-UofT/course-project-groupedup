package edit_user_public_profile_usecase;
import Entities.NormalUser;

public interface editUserPublicProfileDSGateway {
    boolean existsByUsername(String username);
    NormalUser findUser(String username);
    void saveUser(editUserPublicProfileDsRequestModel requestModel);
}
