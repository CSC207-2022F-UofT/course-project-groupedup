package ApplyToGroup_screens;

import ApplyToGroup.ApplyToGroupOutputBoundary;
import ApplyToGroup.ApplyToGroupResponseModel;

public class ApplyToGroupPresenter implements ApplyToGroupOutputBoundary {

    @Override
    public ApplyToGroupResponseModel prepareSuccessView(ApplyToGroupResponseModel user) {
        return null;
    }

    @Override
    public ApplyToGroupResponseModel prepareFailView(String error) {
        return null;
    }

}
