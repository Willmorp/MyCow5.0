package pe.com.mycow.beans;

import pe.com.mycow.models.MycowService;
import pe.com.mycow.models.Workplace;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class WorkplaceBean implements Serializable{
    private MycowService service;
    private Workplace workplace;


    public WorkplaceBean(){
        service = new MycowService();
    }

    public List<Workplace> getWorkplaces(){
        return service.findAllWorkplaces();
    }

    public Workplace getWorkPlace(){
        return workplace;
    }
}
