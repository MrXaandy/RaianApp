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

@Path("/courses")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CoursesService {
    
    static Integer count = 1;
    List<Course> courses;

    public CoursesService() {
        courses = new ArrayList<>();
    }
     
    @GET
    public List<Course> getCourses(){
        return courses;
    }
    
    @POST
    public Course add(Course course){
        course.setId(count++);
        courses.add(course);
        return course;
    }
    
    @PUT
    @Path("/{id}")
    public Course update(@PathParam("id") Integer id, Course course){
        for(Course c : courses){
            if(c.getId().equals(id)){
                c.setName(course.getName());
                c.setTotalClass(course.getTotalClass());
                c.setDayClass(course.getDayClass());
                return c;
            }
        }
        return null;
    }
    
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id){
        for(Course c : courses){
            if(c.getId().equals(id)){
                courses.remove(c);
                break;
            }
        } 
    }
    
    @GET
    @Path("/{id}")
    public Course getCourse(@PathParam("id") Integer id){
        for(Course c : courses){
            if(c.getId().equals(id)){
                return c;
            }
        } 
        return null;    
    }
}
