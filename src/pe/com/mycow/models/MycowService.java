package pe.com.mycow.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MycowService {

    private Connection connection;
    private UsersEntity usersEntity;
    private WorkplacesEntity workplacesEntity ;
    private WorkspacesEntity workspacesEntity;
    private ReserveSpacesEntity reservespacesEntity;

    private Connection getConnection() {
        if(connection == null) {
            try {
                connection = ((DataSource) InitialContext
                        .doLookup("jdbc/MySQLDataSource2"))
                        .getConnection();
            } catch (NamingException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    protected UsersEntity getUsersEntity() {
        if(getConnection() != null) {
            if(usersEntity == null) {
                usersEntity = new UsersEntity();
                usersEntity.setConnection(getConnection());
            }
        }
        return usersEntity;
    }

    protected WorkplacesEntity getWorkplacesEntity() {
        if(getConnection() != null) {
            if(workplacesEntity == null) {
                workplacesEntity = new WorkplacesEntity();
                workplacesEntity.setConnection(getConnection());
            }
        }
        return workplacesEntity;
    }

    protected WorkspacesEntity getWorkSpacesEntity() {
        if(getConnection() != null) {
            if(workspacesEntity == null) {
                workspacesEntity = new WorkspacesEntity();
                workspacesEntity.setConnection(getConnection());
            }
        }
        return workspacesEntity;
    }
    protected ReserveSpacesEntity getReserveSpacesEntity(){
        if(getConnection() != null){
            if (reservespacesEntity == null){
                reservespacesEntity = new ReserveSpacesEntity();
                reservespacesEntity.setConnection(getConnection());
            }
        }
        return reservespacesEntity;
    }

    //********************
    //       FindAll
    //*********************
    public List<User> findAllUsers() {
        return getUsersEntity() != null ?
                getUsersEntity().findAll() : null;
    }

    public List<Workplace> findAllWorkplaces(){
        return getWorkplacesEntity() != null ?
                getWorkplacesEntity().findAll() : null;
    }

    public List<Workspace> findAllWorkSpaces() {
        return getWorkSpacesEntity() != null ?
                getWorkSpacesEntity().findAll() : null;
    }
    public List<ReserveSpace> findAllReserveSpaces(){
        return getReserveSpacesEntity() != null ?
                getReserveSpacesEntity().findAll() : null;
    }



    public User findUserById(int id) {
        return getUsersEntity() != null ?
                getUsersEntity().findById(id) : null;
    }

    public User findUserByName(String name) {
        return getUsersEntity() != null ?
                getUsersEntity().findByName(name) : null;
    }

    public User createUser(String name) {
        return getUsersEntity() != null ?
                getUsersEntity().create(name) : null;
    }

    public boolean deleteUser(int id) {
        return getUsersEntity() != null ?
                getUsersEntity().delete(id) : false;
    }

    public boolean updateUser(User region) {
        return getUsersEntity() != null ?
                getUsersEntity().update(region) : false;
    }

public ReserveSpace createReserveSpace(String reservationDate) {
        return getReserveSpacesEntity() != null ?
                getReserveSpacesEntity().create(reservationDate) : null;
    }

    public boolean updateReserveSpace(ReserveSpace reserveSpace) {
        return getReserveSpacesEntity() != null ?
                getReserveSpacesEntity().update(reserveSpace) : false;
    }

    public boolean deleteReserveSpace(int id) {
        return getReserveSpacesEntity() != null ?
                getReserveSpacesEntity() .delete(id) : false;
    }
}
