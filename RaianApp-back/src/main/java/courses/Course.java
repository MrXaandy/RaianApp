package courses;

public class Course {
    private Integer id;
    private String name;
    private int totalClass;
    private int dayClass;
    
    public Course(){
        
    }
    
    public Course(Integer id, String course, int totalClass, int dayClass) {
        this.id = id;
        this.name = course;
        this.totalClass = totalClass;
        this.dayClass = dayClass;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String course) {
        this.name = course;
    }

    public int getTotalClass() {
        return totalClass;
    }

    public void setTotalClass(int totalClass) {
        this.totalClass = totalClass;
    }

    public int getDayClass() {
        return dayClass;
    }

    public void setDayClass(int dayClass) {
        this.dayClass = dayClass;
    }
    
    
}
