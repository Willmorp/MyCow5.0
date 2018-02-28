package pe.com.mycow.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReserveSpacesEntity extends BaseEntity{

    private static String DEFAULT_SQL = "SELECT * FROM reserve_spaces";

    private List<ReserveSpace> findByCriteria(String sql, UsersEntity usersEntity, WorkspacesEntity workspacesEntity,TypesEntity typesEntity ,WorkplacesEntity workplacesEntity) {
        List<ReserveSpace> reserveSpaces;
        if(getConnection() != null) {
            reserveSpaces = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    ReserveSpace reservespace = new ReserveSpace()
                            .setId(resultSet.getInt("id"))
                            .setStartDate(resultSet.getString("start_date"))
                            .setEndDate(resultSet.getString("end_date"))
                            .setObservation(resultSet.getString("observation"))
                            .setUser(usersEntity.findById(resultSet.getInt("id")))
                            .setWorkspace(workspacesEntity.findById(resultSet.getInt("id"), usersEntity,typesEntity,workplacesEntity)
                            );
                    reserveSpaces.add(reservespace);
                }
                return reserveSpaces;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public List<ReserveSpace> findAll(int id, UsersEntity userEntity, WorkspacesEntity workspacesEntity, TypesEntity typesEntity,WorkplacesEntity workplacesEntity) {
        return findByCriteria(DEFAULT_SQL, userEntity, workspacesEntity,typesEntity , workplacesEntity);
    }

    public ReserveSpace findById(int id, UsersEntity usersEntity, WorkspacesEntity workspacesEntity,TypesEntity typesEntity, WorkplacesEntity workplacesEntity) {
        List<ReserveSpace> reserveSpaces = findByCriteria(DEFAULT_SQL +
                " WHERE id = "+ String.valueOf(id),usersEntity , workspacesEntity,typesEntity , workplacesEntity );
        return (reserveSpaces != null ? reserveSpaces.get(0) : null);
    }

    public ReserveSpace findByStartDate(String date, UsersEntity usersEntity, WorkspacesEntity workspacesEntity,TypesEntity typesEntity, WorkplacesEntity workplacesEntity) {
        List<ReserveSpace> reserveSpaces = findByCriteria(DEFAULT_SQL +
                " WHERE start_date= " + String.valueOf(date),usersEntity , workspacesEntity,typesEntity , workplacesEntity );
        return (reserveSpaces != null ? reserveSpaces.get(0) : null);
    }

    public ReserveSpace findByEndDate(String date, UsersEntity usersEntity, WorkspacesEntity workspacesEntity,TypesEntity typesEntity, WorkplacesEntity workplacesEntity) {
        List<ReserveSpace> reserveSpaces = findByCriteria(DEFAULT_SQL +
                " WHERE end_date= " + String.valueOf(date),usersEntity , workspacesEntity, typesEntity ,workplacesEntity );
        return (reserveSpaces != null ? reserveSpaces.get(0) : null);
    }


    private int updateByCriteria(String sql) {
        if(getConnection() != null) {
            try {
                return getConnection()
                        .createStatement()
                        .executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public boolean delete(int id) {
        return updateByCriteria("DELETE FROM reserve_spaces WHERE id = " + String.valueOf(id)) > 0;
    }

    private int getMaxId()
    {
        String sql = "SELECT ISNULL(MAX(id)+ 1, 1) AS max_id FROM reserve_spaces";
        if (getConnection() != null)
        {
            try
            {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                return resultSet.next()?
                        resultSet.getInt("max_id") : 0;
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public ReserveSpace findByDate(String startDate,UsersEntity usersEntity,WorkplacesEntity workplacesEntity,TypesEntity typesEntity,WorkspacesEntity workspacesEntity) {
        List<ReserveSpace> reserveSpaces = findByCriteria(DEFAULT_SQL +
                " WHERE start_date = '" + startDate + "'",usersEntity,workspacesEntity,typesEntity ,workplacesEntity);
        return (reserveSpaces != null && !reserveSpaces.isEmpty() ? reserveSpaces.get(0) : null);
    }



        public ReserveSpace create (String startDate , String endDate, String observation, User user, Workspace workspace,TypesEntity typesEntity,WorkplacesEntity workplacesEntity)
        {
            UsersEntity usersEntity = new UsersEntity();
            WorkspacesEntity workspaces= new WorkspacesEntity();
            if (findByStartDate(startDate, usersEntity,workspaces,typesEntity ,workplacesEntity) == null) {
                if (getConnection() != null) {
                    String sql = "INSERT INTO reserve_spaces(id, start_date, end_date, user_id, observation, workspaces_id) VALUES(" +
                            String.valueOf(getMaxId() + 1) + ", '" +
                            startDate +"', '"+endDate+"', '"+observation+"', '"+"'  )" ;
                    int results = updateByCriteria(sql);
                    if (results > 0) {
                        ReserveSpace reserveSpace = new ReserveSpace(getMaxId(), startDate, endDate,observation, user ,workspace);
                        return reserveSpace;
                    }
                }
            }
            return null;
        }

        public List<ReserveSpace> findAll (UsersEntity usersEntity,  WorkspacesEntity
        workspacesEntity, TypesEntity typesEntity,WorkplacesEntity workplacesEntity){
            return findByCriteria(DEFAULT_SQL, usersEntity, workspacesEntity,typesEntity ,workplacesEntity);
        }


        public boolean update (ReserveSpace reserveSpace,UsersEntity usersEntity, WorkspacesEntity workspacesEntity,TypesEntity typesEntity,WorkplacesEntity workplacesEntity) {
            if (findByStartDate(reserveSpace.getStartDate(), usersEntity, workspacesEntity,typesEntity, workplacesEntity ) != null) return false;
            return updateByCriteria(
                    "UPDATE reserve_spaces SET start_date = '" +
                            reserveSpace.getStartDate() + "'" +
                            " WHERE id = " +
                            String.valueOf(reserveSpace.getId())) > 0;
        }

    }
