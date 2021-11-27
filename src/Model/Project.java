package Model;

public class Project {
    
    private String name, description;
    private int owner, id;
    private static int staticId;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public static int getStaticId() {
        return staticId;
    }

    public static void setStaticId(int staticId) {
        Project.staticId = staticId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
