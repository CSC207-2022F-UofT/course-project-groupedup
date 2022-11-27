package view_user_applications_use_case;

import Entities.User;

public interface ViewApplicationsListDsGateway {
    User getUser(String username);
}
