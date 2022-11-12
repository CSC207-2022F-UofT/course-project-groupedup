package ApplyToGroup;

public interface ApplyToGroupPresenter {

    ApplyToGroupResponseModel prepareSuccessView(ApplyToGroupResponseModel user);

    ApplyToGroupResponseModel prepareFailView(String error);

}
