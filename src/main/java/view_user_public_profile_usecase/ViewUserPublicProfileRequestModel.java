package view_user_public_profile_usecase;

public class viewUserPublicProfileRequestModel {
    private final String username;

    public viewUserPublicProfileRequestModel(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
