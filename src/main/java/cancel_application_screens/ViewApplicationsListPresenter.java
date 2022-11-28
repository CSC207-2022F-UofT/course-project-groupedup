package cancel_application_screens;

import view_user_applications_use_case.ViewApplicationsListOutputBoundary;
import view_user_applications_use_case.ViewApplicationsListResponseModel;

public class ViewApplicationsListPresenter implements ViewApplicationsListOutputBoundary {
    @Override
    public ViewApplicationsListResponseModel prepareSuccessView(ViewApplicationsListResponseModel responseModel) {
        return responseModel;
    }
}
