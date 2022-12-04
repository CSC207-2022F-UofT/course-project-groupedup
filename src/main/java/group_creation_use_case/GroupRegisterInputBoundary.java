package group_creation_use_case;

public interface GroupRegisterInputBoundary {
    /**
     * Triggers the Group Creation Use Case.
     * @param requestModel
     * @return
     */
    boolean create(GroupRegisterRequestModel requestModel);
}
