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
    private TypesEntity typesEntity;
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
    protected TypesEntity getTypesEntity() {
        if(getConnection() != null) {
            if(typesEntity == null) {
                typesEntity = new TypesEntity();
                typesEntity.setConnection(getConnection());
            }
        }
        return typesEntity;
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

    public List<Workspace> findAllWorkspaces() {
        return getWorkSpacesEntity() != null ?
                getWorkSpacesEntity().findAll(getUsersEntity(),getTypesEntity(),getWorkplacesEntity()) : null;
    }
    public List<ReserveSpace> findAllReserveSpaces(){
        return getReserveSpacesEntity() != null ?
                getReserveSpacesEntity().findAll(getUsersEntity(),getWorkSpacesEntity(),getTypesEntity(),getWorkplacesEntity()) : null;
    }
    public List<Types> findAllTypes() {
        return getTypesEntity() != null ?
                getTypesEntity().findAll() : null;
    }
    public User findUserById(int id) {
        return getUsersEntity() != null ?
                getUsersEntity().findById(id) : null;
    }

//    public User findUserByName(String name) {
//        return getUsersEntity() != null ?
//                getUsersEntity().findByName(name) : null;
//    }
    
    public User findUserByEmail(String email) {
        return getUsersEntity() != null ?
                getUsersEntity().findByEmail(email) : null;
    }

    public User findUserByPassword(String password) {
        return getUsersEntity() != null ?
                getUsersEntity().findByPassword(password) : null;
    }


    //*********** CREATEE**********


//    public User createUser(String name) {
//        return getUsersEntity() != null ?
//                getUsersEntity().create(name) : null;
//    }
//    public Workspace createWorkSpace(int price,int capacity, String photo, String status,String description, User user, Types type, Workplace workplace) {
//        return getWorkSpacesEntity() != null ?
//                getWorkSpacesEntity().create(price, capacity, photo,  status, description, user, type, workplace) : null;
//    }
    public Workspace createWorkSpace(int price,int capacity, String photo, String status,String description) {
        return getWorkSpacesEntity() != null ?
                getWorkSpacesEntity().create(price, capacity , photo , status, description ) : null;
    }


//    public boolean deleteUser(int id) {
//        return getUsersEntity() != null ?
//                getUsersEntity().delete(id) : false;
//    }
//
//    public boolean updateUser(User region) {
//        return getUsersEntity() != null ?
//                getUsersEntity().update(region) : false;
//    }

    public ReserveSpace createReserveSpace(String startDate, String endDate, String observation, User user , Workspace workspace,Types types, Workplace workplace) {
        return getReserveSpacesEntity() != null ?
                getReserveSpacesEntity().create(startDate, endDate, observation, user, workspace, types, workplace) : null;
    }

//    public boolean updateReserveSpace(ReserveSpace reserveSpace, UsersEntity usersEntity,WorkspacesEntity workspacesEntity,TypesEntity typesEntity,WorkplacesEntity workplacesEntity) {
//        return getReserveSpacesEntity() != null ?
//                getReserveSpacesEntity().update(reserveSpace,usersEntity,workspacesEntity,typesEntity,workplacesEntity) : false;
//    }

    public boolean deleteReserveSpace(int id) {
        return getReserveSpacesEntity() != null ?
                getReserveSpacesEntity() .delete(id) : false;
    }

}
