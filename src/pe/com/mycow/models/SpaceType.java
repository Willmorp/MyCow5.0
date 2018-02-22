package pe.com.mycow.models;

public class SpaceType {
    private int id;
    private String name;

    public SpaceType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public SpaceType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
