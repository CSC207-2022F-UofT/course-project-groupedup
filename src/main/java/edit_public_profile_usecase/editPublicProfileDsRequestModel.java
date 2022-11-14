package edit_public_profile_usecase;

public class editPublicProfileDsRequestModel {
    String username;

    public editPublicProfileDsRequestModel(String username) {
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }
}
