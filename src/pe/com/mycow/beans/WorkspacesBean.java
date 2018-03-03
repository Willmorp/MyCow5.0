package pe.com.mycow.beans;

import pe.com.mycow.models.*;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named
@SessionScoped
public class WorkspacesBean implements Serializable{
    private MycowService service;
    private Workspace workspace;
    private User user;
    private Types type;
    private Workplace workplace;


    public WorkspacesBean(){
        service = new MycowService();
    }

    //************************* WORKSPACE *****************************
    public List<Workspace> getWorkspaces(){
        return service.findAllWorkspaces();
    }

    public Workspace getWorkspace() {
        return workspace;
    }
    public String newWS() {
        this.setWorkspace(new Workspace());
        return "success";
    }
    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }
    public int getPrice(){
        return this.getWorkspace().getPrice();
    }
    public void setPrice(int price) {
        this.getWorkspace().setPrice(price);
    }
    public int getCapacity(){
        return this.getWorkspace().getCapacity();
    }
    public void setCapacity(int capacity) {
        this.getWorkspace().setCapacity(capacity);
    }
    public String getPhoto(){
        return this.getWorkspace().getPhoto();
    }
    public void setPhoto(String photo){
         this.getWorkspace().setPhoto(photo);
    }
    public String getStatus(){
        return this.getWorkspace().getStatus();
    }
    public void setStatus(String status){
         this.getWorkspace().setStatus(status);
    }
    public String getDescription(){
        return this.getWorkspace().getDescription();
    }
    public void setDescription(String descrip){
        this.getWorkspace().setDescription(descrip);
    }


    //********************* USERS ***************************
    public List<User> getUsers(){
        service = new MycowService();
        return service.findAllUsers();
    }
    public User getUser(){
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public int getId(){
        return this.getUser().getId() ;
    }
    public void setId(int id) {
        this.getWorkspace().getUser().setId(id);
    }
    public String getFirstName(){
        return this.getWorkspace().getUser().getFirstName() ;
    }
    public void setFirstName(String name) {
        this.getWorkspace().getUser().setFirstName(name);
    }

    // *********************** type ******************

    public List<Types> getTypes(){
        return service.findAllTypes();
    }
    public Types getType(){
        return type;
    }
    public void setType(Types type) {
        this.type = type;
    }
    public String getNameType(){
        return  this.getType().getTypeName();
    }
    public void setNameType(String nametype) {
       this.getWorkspace().getTypes().setTypeName(nametype);
    }

    //******************* WORKPLACE ************************
    public List<Workplace> getWorkPlaces(){
        return service.findAllWorkplaces();
    }
    public Workplace getWorkplace(){
        return workplace;
    }
    public void setWorkplace(Workplace workplace) {
        this.workplace = workplace;
    }
    public String getAddress(){
        return this.getWorkplace().getAddress();
    }
    public void setAddress(String address) {
        this.getWorkspace().getWorkplace().setAddress(address);
    }


    public String newWorkspace() {
        this.setWorkspace(new Workspace());
        return "success";
    }
    public  String createWorkSpace(){
        service.createWorkSpace(this.getPrice(),this.getCapacity(),this.getPhoto(),this.getStatus() ,this.getDescription() );
        return "success";
    }

}
