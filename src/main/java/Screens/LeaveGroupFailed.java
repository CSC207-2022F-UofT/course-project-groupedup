package Screens;

public class LeaveGroupFailed extends RuntimeException {
    public LeaveGroupFailed(String error) {
        super(error);
    }
}
