package pe.com.mycow.models;

public class Types {
    private int id;
    private String typename;
    private String description;

    public Types(int id, String type_name) {
        this.id = id;
        this.typename = type_name;
    }

    public Types() {
    }

    public int getId() {
        return id;
    }

    public Types setId(int id) {
        this.id = id;
        return this;
    }

    public String getTypeName() {
        return typename;
    }

    public Types setTypeName(String typename) {
        this.typename = typename;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Types setDescription(String description) {
        this.description = description;
        return this;
    }
}
