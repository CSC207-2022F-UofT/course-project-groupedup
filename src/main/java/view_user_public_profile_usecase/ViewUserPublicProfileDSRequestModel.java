package view_user_public_profile_usecase;


public class ViewUserPublicProfileDSRequestModel {
    private String username;

    ViewUserPublicProfileDSRequestModel(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
}
