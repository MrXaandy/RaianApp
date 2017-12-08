package courses;

import java.util.List;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/disciplines")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DisciplinesService {
    
    static Integer count = 1;
    List<Discipline> disciplines;

    public DisciplinesService() {
        disciplines = new ArrayList<>();
    }
     
    @GET
    public List<Discipline> getDisciplines(){
        return disciplines;
    }
    
    @POST
    public Discipline add(Discipline discipline){
        discipline.setId(count++);
        disciplines.add(discipline);
        return discipline;
    }
    
    @PUT
    @Path("/{id}")
    public Discipline update(@PathParam("id") Integer id, Discipline discipline){
        for(Discipline d : disciplines){
            if(d.getId().equals(id)){
                d.setCourseId(discipline.getCourseId());
                d.setName(discipline.getName());
                d.setProfessorName(discipline.getProfessorName());
                d.setAbsenceLimit(discipline.getAbsenceLimit());
                return d;
            }
        }
        return null;
    }
    
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id){
        for(Discipline d : disciplines){
            if(d.getId().equals(id)){
                disciplines.remove(d);
                break;
            }
        } 
    }
    
    @GET
    @Path("/{id}")
    public Discipline getDiscipline(@PathParam("id") Integer id){
        for(Discipline d : disciplines){
            if(d.getId().equals(id)){
                return d;
            }
        } 
        return null;    
    }
}
