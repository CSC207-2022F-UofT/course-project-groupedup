package apply_to_group_use_case;

public interface ApplyToGroupOutputBoundary {
    ApplyToGroupResponseModel prepareSuccessView(ApplyToGroupResponseModel user);
    ApplyToGroupResponseModel prepareFailView(String error);

}
