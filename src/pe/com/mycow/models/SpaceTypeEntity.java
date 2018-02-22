package pe.com.mycow.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpaceTypeEntity extends BaseEntity{

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

}
