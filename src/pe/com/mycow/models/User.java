package pe.com.mycow.models;

public class User {

    private int id;
    private int dni;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String role;
    private String password;


    public User(int id, int dni, String firstName, String lastName, int age, String email, String role, String password) {
        this.setId(id);
        this.setDni(dni);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setEmail(email);
        this.setRole(role);
        this.setPassword(password);
    }

    public User() {
    }

    public User(int id, String firstName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return  this;
    }

    public int getDni() {
        return dni;
    }

    public User setDni(int dni) {
        this.dni = dni;
        return  this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return  this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return  this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return  this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return  this;
    }

    public String getRole() {
        return role;
    }

    public User setRole(String role) {
        this.role = role;
        return  this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return  this;
    }
}
