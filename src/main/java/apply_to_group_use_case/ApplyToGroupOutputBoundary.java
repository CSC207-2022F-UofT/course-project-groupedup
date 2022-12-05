package apply_to_group_use_case;
/**
 * The output boundary interface for the Apply to Group use case
 */
public interface ApplyToGroupOutputBoundary {
    void prepareSuccessView(ApplyToGroupResponseModel user);
    void prepareFailView(String error);

}
