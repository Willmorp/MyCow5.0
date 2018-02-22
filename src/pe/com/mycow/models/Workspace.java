package pe.com.mycow.models;
public class Workspace {
    private int id;
    private int price;
    private int capacity;
    private String description;
    private String fhoto;
    private Workplace workplace;
    private User user;
    private SpaceType spacetype;
    
    public Workspace(){
    }
    
    public Workspace(int id, int price, int capacity, String description, String fhoto, Workplace workplace, User user, SpaceType spacetype) {
        this.id = id;
        this.price = price;
        this.capacity = capacity;
        this.description = description;
        this.fhoto = fhoto;
        this.workplace = workplace;
        this.user = user;
    }
    
    public int getId(){
        return id;
    }
    
    public Workspace setId(int id){
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
    
    public String getFhoto(){
        return fhoto;
    }
    
    public Workspace setFhoto(String fhoto){
        this.fhoto = fhoto;
        return this;
    }
    
    public Workplace getWorkplace(){ 
        return workplace;
    }

    public Workspace setWorkplace(Workplace workplace) {
        this.workplace = workplace;
        return this;
    }
    
    public User getUser(){ 
        return user;
    }

    public Workspace setUser(User user) {
        this.user = user;
        return this;
    }
    
    public SpaceType getSpacetype(){
        return spacetype;
    }
    
    public Workspace setSpaceType(SpaceType spacetype){
        this.spacetype = spacetype;
        return this;
    }
}
    
