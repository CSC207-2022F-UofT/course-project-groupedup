package LeaveGroup;

public interface LeaveGroupPresenter {
    LeaveGroupResponseModel prepareFailureView(String error);
    LeaveGroupResponseModel prepareSuccessView(String message);
}
