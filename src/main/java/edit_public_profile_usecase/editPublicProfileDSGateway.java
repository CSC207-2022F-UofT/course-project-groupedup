package edit_public_profile_usecase;
import Entities.NormalUser;

public interface editPublicProfileDSGateway {
    boolean existsByUsername(String username);
    NormalUser findUser(String username);
    void saveUser(editPublicProfileDsRequestModel requestModel);
}
