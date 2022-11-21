package apply_to_group_screens;

import apply_to_group_use_case.ApplyToGroupOutputBoundary;
import apply_to_group_use_case.ApplyToGroupResponseModel;

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
