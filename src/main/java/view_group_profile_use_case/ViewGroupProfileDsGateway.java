package view_group_profile_use_case;

import Entities.Group;

/**
 * The data access interface for the view group profile use case.
 */
public interface ViewGroupProfileDsGateway {
    boolean groupIdentifierExists(String groupName);
    Group getGroup(String groupName);
}
