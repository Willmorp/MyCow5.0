package pe.com.mycow.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypesEntity extends BaseEntity{
    private static String DEFAULT_SQL = " SELECT * FROM types ";

    private List<Types> findByCriteria(String sql) {
        List<Types> types;

        if (getConnection() != null) {
            types = new ArrayList<>();

            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    Types type = new Types()
                            .setId(resultSet.getInt("id"))
                            .setTypeName(resultSet.getString("type_name"))
                            .setDescription(resultSet.getString("description"))
                            ;
                    types.add(type);
                }
                return types;

            }
            catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public List<Types> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public Types findById(int id){
        List<Types> types = findByCriteria(DEFAULT_SQL + " WHERE id = "+String.valueOf(id));
        return(types != null ? types.get(0) : null);
    }
}
