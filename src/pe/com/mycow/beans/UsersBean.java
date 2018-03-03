package pe.com.mycow.beans;

import pe.com.mycow.models.MycowService;
import pe.com.mycow.models.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UsersBean implements Serializable {

    private MycowService service;
    private User user;

    public UsersBean(){

        service = new MycowService();
    }

    public List<User> getUsers(){

        return service.findAllUsers();
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public String getFirstName(){

        return this.getUser().getFirstName();
    }

    public void setFirstName(String firstName){

        this.getUser().setFirstName(firstName);
    }

    public String getEmail(){

        return this.getUser().getEmail();
    }

    public void setEmail(String email){

        this.getUser().setEmail(email);
    }


    public String getPassword(){

        return this.getUser().getPassword();
    }

    public void setPassword(String password){

        this.getUser().setPassword(password);
    }


    public String newUser(){
        this.setUser(new User());
        return "success";
    }

//    public  String createUser(){
//        service.createUser(this.getFirstName(), this.getEmail(), this.getPassword());
//        return "success";
//    }

    public String doValidateInput (){
        if(!"mycow".equals(getPassword())) return "error";
        return "success";
    }
}

