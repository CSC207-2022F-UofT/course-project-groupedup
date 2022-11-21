package ApplyToGroup_screens;

import ApplyToGroup.ApplyToGroupOutputBoundary;
import ApplyToGroup.ApplyToGroupResponseModel;

public class ApplyToGroupPresenter implements ApplyToGroupOutputBoundary {
    @Override
    public ApplyToGroupResponseModel prepareSuccessView(ApplyToGroupResponseModel userApplication) {
        return userApplication;
    }

    @Override
    public ApplyToGroupResponseModel prepareFailView(String error) {
        throw new ApplyToGroupFailed(error);
    }

}
