package pe.com.mycow.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkspacesEntity extends BaseEntity{

    private static String DEFAULT_SQL = " SELECT * FROM workspaces ";

    private List<Workspace> findByCriteria(String sql, UsersEntity usersEntity, TypesEntity typesEntity, WorkplacesEntity workplacesEntity) {
        List<Workspace> workspaces;

        if (getConnection() != null) {
            workspaces = new ArrayList<>();

            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    Workspace workspace = new Workspace()
                            .setId(resultSet.getInt("id"))
                            .setPrice( resultSet.getInt("price"))
                            .setCapacity(resultSet.getInt("capacity"))
                            .setPhoto(resultSet.getString("photo"))
                            .setStatus(resultSet.getString("status"))
                            .setDescription(resultSet.getString("description"))
                            .setUser(usersEntity.findById(resultSet.getInt("user_id")))
                            .setTypes(typesEntity.findById(resultSet.getInt("type_id")))
                            .setWorkplace(workplacesEntity.findById(resultSet.getInt("workplace_id")))
                            ;

                    workspaces.add(workspace);
                }
                return workspaces;

            }
            catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public List<Workspace> findAll(UsersEntity usersEntity, TypesEntity typesEntity, WorkplacesEntity workplacesEntity ){
        return findByCriteria(DEFAULT_SQL, usersEntity, typesEntity, workplacesEntity);
    }

    public Workspace findById(int id , UsersEntity usersEntity, TypesEntity typesEntity, WorkplacesEntity workplacesEntity){
        List<Workspace> workspaces = findByCriteria(DEFAULT_SQL + " WHERE id = "+String.valueOf(id), usersEntity, typesEntity, workplacesEntity);
        return(workspaces != null ? workspaces.get(0) : null);
    }

    /*public User findByName(String name){
        List<User> users = findByCriteria(DEFAULT_SQL+" WHERE first_name = '"+name + "'");
        return(users != null ? users.get(0) : null);
    }*/

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_idi FROM workspaces";
        if(getConnection() != null) {
             try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                return resultSet.next() ? resultSet.getInt("max_idi") : 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public  Workspace create(int price, int capacity, String photo, String status,String description){

        if(getConnection() != null){
            String sql = "INSERT INTO workspaces (id , price , capacity, photo, status , description, user_id, type_id, workplace_id  ) VALUES(" +
                    String.valueOf(getMaxId() + 1) +", " + price + ", "+ capacity + " , '"  + photo + "', '"+ status  +"' , '"+ description + "' ,  '100' , '1'  , '1001')";
            int results = updatebycriteria(sql);
            if(results > 0){
                Workspace workspace = new Workspace(getMaxId(), price , capacity, photo, status, description );
                return workspace;
            }
        }
        return null;
    }

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

}

