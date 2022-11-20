package leave_group_screens;

public class LeaveGroupFailed extends RuntimeException {
    public LeaveGroupFailed(String error) {
        super(error);
    }
}
