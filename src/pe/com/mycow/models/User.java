package pe.com.mycow.models;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private int age;
    private int dni;

    public User(int id, String firstName, String lastName, String password, String email, int age, int dni) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.age = age;
        this.dni = dni;
    }



    public User() {
    }

    public User(int id, String firstName) {
        this.id = id;
        this.firstName = firstName;

    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return  this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public int getDni() {
        return dni;
    }

    public User setDni(int dni) {
        this.dni = dni;
        return this;
    }


}
