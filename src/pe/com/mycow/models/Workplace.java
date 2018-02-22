package pe.com.mycow.models;

public class Workplace {
    private int id;
    private String department;
    private String province;
    private String district;
    private String address;
    private User user;

    public Workplace() {
    }

    public Workplace(int id, String department, String province, String district, String address, User user) {
        this.id = id;
        this.department = department;
        this.province = province;
        this.district = district;
        this.address = address;
        this.user = user;
    }

    public int getId() {

        return id;
    }

    public Workplace setId(int id) {
        this.id = id;
        return this;
    }

    public String getDepartment() {

        return department;
    }

    public Workplace setDepartment(String department) {
        this.department = department;
        return this;
    }
    
    public String getProvince(){
        return province;
    }

    public Workplace setProvince(String province){
        this.province = province;
        return this;
    }
    
       public String getDistrict(){
        return district;
    }

    public Workplace setDistrict(String district){
        this.district = district;
        return this;
    }

    public String getAddress(){
        return address;
    }

    public Workplace setAddress(String address){
        this.address = address;
        return this;
    }


    public User getUser() {
        return user;
    }

    public Workplace setUser(User user) {
        this.user = user;
        return this;
    }
}
