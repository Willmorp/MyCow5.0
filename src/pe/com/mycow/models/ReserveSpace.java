package pe.com.mycow.models;

public class ReserveSpace  {
    private int id;
    private String startDate;
    private String endDate;
    private String observation;
    private User user;
    private Workspace workspace;

    public ReserveSpace() {
    }

    public ReserveSpace(int id, String startDate, String endDate, String observation, User user, Workspace workspace) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.observation = observation;
        this.user = user;
        this.workspace = workspace;
    }


    public int getId() {
        return id;
    }

    public ReserveSpace setId(int id) {
        this.id = id;
        return this;
    }


    public String getStartDate() {
        return startDate;
    }

    public ReserveSpace setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public ReserveSpace setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getObservation() {
        return observation;
    }

    public ReserveSpace setObservation(String observation) {
        this.observation = observation;
        return this;
    }

    public User getUser() {
        return user;
    }

    public ReserveSpace setUser(User user) {
        this.user = user;
        return this;
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public ReserveSpace setWorkspace(Workspace workspace) {
        this.workspace = workspace;
        return this;
    }
}

