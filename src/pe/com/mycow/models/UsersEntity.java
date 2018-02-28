package pe.com.mycow.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersEntity extends BaseEntity {

    private static String DEFAULT_SQL = " SELECT * FROM users ";

    private List<User> findByCriteria(String sql) {
        List<User> users;

        if (getConnection() != null) {
            users = new ArrayList<>();

            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    User user = new User()
                            .setId(resultSet.getInt("id"))
                            .setDni(resultSet.getInt("dni"))
                            .setFirstName(resultSet.getString("first_name"))
                            .setLastName(resultSet.getString("last_name"))
                            .setAge(resultSet.getInt("age"))
                            .setEmail(resultSet.getString("email"))
                            .setRole(resultSet.getString("role"))
                            .setPassword(resultSet.getString("password"));
                    users.add(user);
                }
                return users;

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public List<User> findAll() {

        return findByCriteria(DEFAULT_SQL);
    }

    public User findById(int id) {
        List<User> users = findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return (users != null && !users.isEmpty() ? users.get(0) : null);
    }

    public User findByFirstName(String firstname) {
        List<User> users = findByCriteria(DEFAULT_SQL + " WHERE first_name = '" + firstname + "'");
        return (users != null && !users.isEmpty() ? users.get(0) : null);
    }

    public User findByEmail(String email) {
        List<User> users = findByCriteria(DEFAULT_SQL + " WHERE email = '" + email + "'");
        return (users != null && !users.isEmpty() ? users.get(0) : null);
    }

    public User findByPassword(String password) {
        List<User> users = findByCriteria(DEFAULT_SQL + " WHERE password = '" + password + "'");
        return (users != null && !users.isEmpty() ? users.get(0) : null);
    }


    private int updatebycriteria(String sql) {
        if (getConnection() != null) {
            try {
                return getConnection().createStatement().executeUpdate(sql);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM users";
        if (getConnection() != null) {
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

    public User create(String firstName, String email,  String password) {
        if (findByEmail(email) == null) {
            if (findByFirstName(firstName) == null) {
                if (getConnection() != null) {
                    String sql = "INSERT INTO users(id , dni, first_name ,last_name, email, role , password  ) VALUES(" +
                            String.valueOf(getMaxId() + 1) + ", '" +  "456897215"   +
                            firstName + "', '" +  "Perez"   + email + "', " + "User"   + password + "')";
                    int results = updatebycriteria(sql);
                    if (results > 0) {
                        User user = new User(getMaxId(), firstName, email , password);
                        return user;
                    }
                }
            }
            return null;
        }

            return null;
        }


}
