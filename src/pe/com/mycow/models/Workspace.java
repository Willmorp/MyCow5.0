package pe.com.mycow.models;

public class Workspace {
    private int id;
    private int price;
    private int capacity;
    private String photo;
    private String status;
    private String description;
    private User user;
    private Types types;
    private Workplace workplace;

    public Workspace() {
    }

    public Workspace(int id, int price, int capacity, String photo, String status, String description, User user, Types types, Workplace workplace) {
        this.id = id;
        this.price = price;
        this.capacity = capacity;
        this.photo = photo;
        this.status = status;
        this.description = description;
        this.user = user;
        this.types = types;
        this.workplace = workplace;
    }

    public Workspace(int id, int price, int capacity, String photo, String status, String description) {
        this.id = id;
        this.price = price;
        this.capacity = capacity;
        this.photo = photo;
        this.status = status;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public Workspace setId(int id) {
        this.id = id;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Workspace setPrice(int price) {
        this.price = price;
        return this;
    }

    public int getCapacity() {
        return capacity;
    }

    public Workspace setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Workspace setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public Workspace setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Workspace setStatus(String status) {
        this.status = status;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Workspace setUser(User user) {
        this.user = user;
        return this;
    }

    public Types getTypes() {
        return types;
    }

    public Workspace setTypes(Types types) {
        this.types = types;
        return this;
    }

    public Workplace getWorkplace() {
        return workplace;
    }

    public Workspace setWorkplace(Workplace workplace) {
        this.workplace = workplace;
        return this;
    }
}
