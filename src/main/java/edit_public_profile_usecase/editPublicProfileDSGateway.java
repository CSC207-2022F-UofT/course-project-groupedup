package edit_public_profile_usecase;

public interface editPublicProfileDSGateway {
    boolean existsByUserId(Integer userID);
    void findUser(Integer userID);
    void savePublicProfile(editPublicProfileDsRequestModel requestModel);
}
