package edit_user_public_profile_usecase;

public class editUserPublicProfileDsRequestModel {
    String username;

    public editUserPublicProfileDsRequestModel(String username) {
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }
}
