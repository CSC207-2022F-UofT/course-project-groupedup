package edit_public_profile_usecase;
import Entities.User;

public interface editPublicProfileDSGateway {
    boolean existsByUsername(String username);
    User findUser(String username);
    void saveUser(editPublicProfileDsRequestModel requestModel);
}
