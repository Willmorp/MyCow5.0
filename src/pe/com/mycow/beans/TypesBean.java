package pe.com.mycow.beans;

import pe.com.mycow.models.MycowService;
import pe.com.mycow.models.Types;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class TypesBean implements Serializable {
    private MycowService service;
    private Types types;


    public TypesBean(){
        service = new MycowService();
    }

    public List<Types> getTypes(){
        return service.findAllTypes();
    }

    public Types getType() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }
}
