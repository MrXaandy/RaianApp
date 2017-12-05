package courses;

public class Discipline {
    private Integer id;
    private Integer courseId;
    private String name;
    private String professorName;
    private int totalClass;
    private int absenceLimit;

    public Discipline() {
    }

    public Discipline(Integer id, Integer courseId, String name, String professorName, int absenceLimit) {
        this.id = id;
        this.courseId = courseId;
        this.name = name;
        this.professorName = professorName;
        this.absenceLimit = absenceLimit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public int getTotalClass() {
        return totalClass;
    }

    public void setTotalClass(int totalClass) {
        this.totalClass = totalClass;
    }

    public int getAbsenceLimit() {
        return absenceLimit;
    }

    public void setAbsenceLimit(int absenceLimit) {
        this.absenceLimit = absenceLimit;
    }
    
    
}
