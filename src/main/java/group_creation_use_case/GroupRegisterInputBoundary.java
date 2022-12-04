package group_creation_use_case;

/**
 * This is an interface between the controller and the use case interactor.
 * The interactor implements this interface to create dependency inversion between these
 * two layers.
 */
public interface GroupRegisterInputBoundary {
    /**
     * Triggers the Group Creation Use Case.
     * @param requestModel
     * @return
     */
    boolean create(GroupRegisterRequestModel requestModel);
}
