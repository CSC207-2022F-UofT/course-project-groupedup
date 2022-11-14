package edit_public_profile_usecase;

public class editPublicProfileDsRequestModel {
    Integer userId;

    public editPublicProfileDsRequestModel(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId(){
        return this.userId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }
}
