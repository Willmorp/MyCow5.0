package pe.com.mycow.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkplacesEntity extends BaseEntity {

    private static String DEFAULT_SQL = "SELECT * FROM workplaces";
    private List<Workplace> findByCriteria(String sql) {
        List<Workplace> workplaces;
        if(getConnection() != null) {
            workplaces = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    Workplace workplace = new Workplace()
                            .setId(resultSet.getInt("id"))
                            .setDepartment(resultSet.getString("depatment"))
                            .setProvince(resultSet.getString("province"))
                            .setDistrict(resultSet.getString("district"))
                            .setAddress(resultSet.getString("address"))
                            ;
                    workplaces.add(workplace);
                }
                return workplaces;

            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }

        return
                null;
    }

    public List<Workplace> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public Workplace findById(int id ){
        List<Workplace> workplaces = findByCriteria(DEFAULT_SQL+" WHERE id = "+String.valueOf(id));
        return(workplaces != null ? workplaces.get(0) : null);
    }



}
