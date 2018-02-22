package pe.com.mycow.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersEntity extends BaseEntity{
  
  private static String DEFAULT_SQL = "SELECT * FROM mycow.users";

    private List<User> findByCriteria(String sql) {
        List<User> users;

        if (getConnection() != null) {
            users = new ArrayList<>();
          
          try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    User user = new User().setId(resultSet.getInt("id"))
                            .setDni(resultSet.getInt("dni"))
                            .setFirstName(resultSet.getString("first_name"))
                            .setLastName(resultSet.getString("last_name"))
                            .setAge(resultSet.getInt("age"))
                            ;
                    users.add(user);                  
                }
                return users;

            }
            catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public List<User> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }
  
      public User findById(int id){
        List<User> users = findByCriteria(DEFAULT_SQL+"WHERE id = "+String.valueOf(id));
        return(users != null ? users.get(0) : null);
    }

    public User findByName(String name){
        List<User> users = findByCriteria(DEFAULT_SQL+"WHERE first_name = '"+name + "'");
        return(users != null ? users.get(0) : null);
    }

   /* public User findAll(String name){
        List<User> users = findByCriteria(DEFAULT_SQL+"WHERE first_name = '"+name + "'");
        return(users != null ? users.get(0) : null);
    }*/
  
    private  int updatebycriteria(String sql){
        if(getConnection() != null){
            try {
                return  getConnection().createStatement().executeUpdate(sql);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /*private int getId(){
        String sql = "SELECT(user_id) AS id FROM users ";

        if(getConnection() != null){
            ResultSet resultSet = null;
            try {
                resultSet = getConnection().createStatement().executeQuery(sql);
                return resultSet.next() ? resultSet.getInt("id") : 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return 0;
    }*/

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM users";
        if(getConnection() != null) {
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                return resultSet.next() ?
                        resultSet.getInt("max_id") : 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return 0;
    }

    public  User create(String first_name){
        if(findByName(first_name) == null){
            if(getConnection() != null){
                String sql = "INSERT INTO users(id , dni ,first_name , last_name , age , email, password  ) VALUES(" +
                        String.valueOf(getMaxId() + 1) + ", 7815 ,'" +
                        first_name + "', 'otronombre' , 22 , 'email', 987654 )";
                int results = updatebycriteria(sql);
                if(results > 0){
                    User user = new User(getMaxId(), first_name );
                    return user;
                }
            }
        }
        return null;
    }
  
  public boolean delete(int id){

        return updatebycriteria("DELETE FROM users WHERE user_id =" + String.valueOf(id)) > 0;
    }

    public boolean delete(String name){

        return updatebycriteria("DELETE FROM users WHERE user_name = '" + name + "'") > 0;
    }

    public boolean update(User user){

        return updatebycriteria("UPDATE users SET first_name = '" +
                user.getFirstName() + "' " +
                "WHERE id ="+
                String.valueOf(user.getId())) > 0;

    }
                     
}
