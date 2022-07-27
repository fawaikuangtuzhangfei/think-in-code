package utils.tree.entity;

/**
 * @author yechaoa
 * @date 2022-07-27 7:42
 */
public class Menu implements TreeI {
    private String id;
    private String parentId;
    private String name;

    /* 省略getter、setter */

    public Menu(String id, String parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public String getTreeId() {
        return getId();
    }

    @Override
    public String getTreeParentId() {
        return getParentId();
    }

    @Override
    public String getTreeName() {
        return getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
