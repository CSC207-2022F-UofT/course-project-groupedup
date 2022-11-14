package group_creation_screens;


// Need?

/**
 * Used by Spring to know what data to maintain. It's used by JpaRepository,
 * Spring's root of the programmer-written persistence classes mapping data to =
 * storage.
 */
class GroupDataMapper {

    String groupName;


    public GroupDataMapper() {
    }

    public GroupDataMapper(String groupName) {
        super();
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String name) {
        this.groupName = groupName;
    }
}
