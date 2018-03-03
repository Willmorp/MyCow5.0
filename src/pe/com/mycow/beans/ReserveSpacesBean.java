package pe.com.mycow.beans;

import pe.com.mycow.models.*;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ReserveSpacesBean implements Serializable{

    private MycowService service;
    private ReserveSpace reserveSpace;

    public ReserveSpacesBean() {
        service = new MycowService();
    }

    public List<ReserveSpace> getReserveSpaces() {
        return service.findAllReserveSpaces();
    }

    public ReserveSpace getReserveSpace() {
        return reserveSpace;
    }

    public void setReserveSpace(ReserveSpace reserveSpace) {
        this.reserveSpace = reserveSpace;
    }

    public UsersEntity getUserEntity() {
        return getUserEntity();
    }

    public void setUsersEntity(UsersEntity usersEntity) {
        this.reserveSpace = reserveSpace;
    }

    public WorkplacesEntity getWorkplacesEntity() {
        return getWorkplacesEntity();
    }

    public void setWorkplacesEntity(WorkplacesEntity workplacesEntity) {
        this.reserveSpace = reserveSpace;
    }

    public TypesEntity getTypesEntity() {
        return getTypesEntity();
    }

    public void setTypesEntity(TypesEntity typesEntity) {
        this.reserveSpace = reserveSpace;
    }

    public WorkspacesEntity getWorkspacesEntity() {
        return getWorkspacesEntity();
    }

    public void setWorkspaces(WorkspacesEntity workspaces) {
        this.reserveSpace = reserveSpace;
    }

    //**************************
    public String getStartDate() {
        return this.getReserveSpace().getStartDate();
    }
    public void setStartDate(String startDate) {
        this.getReserveSpace().setStartDate(startDate);
    }
    public String getEndDate() {
        return this.getReserveSpace().getEndDate();
    }

   public void setEndDate(String endDate) {
        this.getReserveSpace().setStartDate(endDate);
    }

    public String getObservation() {
        return this.getReserveSpace().getObservation();
    }

    public void setObservation(String observation) {
        this.getReserveSpace().setObservation(observation);
    }

    public User getUser() {
        return this.getReserveSpace().getUser();
    }

    public void setUser(User user) {
        this.getReserveSpace().setUser(user);
    }

    public Workspace getWorkspace() {
        return this.getReserveSpace().getWorkspace();
    }

    public void setWorkspace(Workspace workspace) {
        this.getReserveSpace().setWorkspace(workspace);
    }

    public Types getTypes() {
        return this.getWorkspace().getTypes();
    }

    public void setTypes(Types types) {
        this.getWorkspace().setTypes(types);
    }


    public Workplace getWorkplace() {
        return this.getWorkspace().getWorkplace();
    }

    public void setWorkplace(Workplace workplace) {
        this.getWorkspace().setWorkplace(workplace);
    }



    //***************************


    public String newReserveSpace() {
        this.setReserveSpace(new ReserveSpace());
        return "success";
    }

    public String createReserveSpace() {
        service.createReserveSpace( getStartDate(), getEndDate(), getObservation(),
                getUser(), getWorkspace(), getTypesEntity(),getWorkplacesEntity());
        return "success";
    }

    public String editReserveSpace(ReserveSpace reserveSpace) {
        this.setReserveSpace(reserveSpace);
        return "success";
    }

    public String updateReserveSpace() {
        service.updateReserveSpace(this.getReserveSpace(),this.getUserEntity(),
                this.getWorkspacesEntity(),this.getTypesEntity(),this.getWorkplacesEntity());
        return "success";
    }

    public String deleteReserveSpace(ReserveSpace reserveSpace) {
        service.deleteReserveSpace(reserveSpace.getId());
        return "success";
    }

}
