package LeaveGroup;

public interface LeaveGroupPresenter {
    LeaveGroupResponseModel prepareSuccessView(LeaveGroupResponseModel userAndGroup);
    LeaveGroupResponseModel prepareFailView(String error);
}
