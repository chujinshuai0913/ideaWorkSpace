package common.model;

public class PermissionsSet {
    private Long id;

    private Integer roleId;

    private String groupName;

    private Integer permissionsId;

    private Integer status;

    public PermissionsSet(Long id, Integer roleId, String groupName, Integer permissionsId, Integer status) {
        this.id = id;
        this.roleId = roleId;
        this.groupName = groupName;
        this.permissionsId = permissionsId;
        this.status = status;
    }

    public PermissionsSet() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Integer getPermissionsId() {
        return permissionsId;
    }

    public void setPermissionsId(Integer permissionsId) {
        this.permissionsId = permissionsId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}