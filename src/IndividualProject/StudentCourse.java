package IndividualProject;

import java.util.ArrayList;
import java.util.List;

public class StudentCourse {

    private Course course;
    private List<Student> students;

    StudentCourse(Course course) {
        this.course = course;
        students = new ArrayList();
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    
    public boolean isStudentListEmpty() {
        return students.isEmpty() ? true : false;
    }
    
    public Course getCourse() {
        return this.course;
    }
    
    public List<Student> getStudentList() {
        return this.students;
    }
    
    
///////////////////////////////////////////////////////////////////////////////    
// NOT USED  
//   
///////////////////////////////////////////////////////////////////////////////
/*

public void seeRelation() {
        String courseTitle = this.course.getTitle().toUpperCase();
        String courseStream = this.course.getStream().toUpperCase();
        String courseType = this.course.getType().toUpperCase();
        String line = "____________________________________________________________________________________________________";
        System.out.println(line);
        System.out.printf("%-25s%-20s%-20s", courseTitle, courseStream, courseType);
        System.out.println("Λίστα μαθητών");
        System.out.println(line);
        for (Student tr : students) {
            String first = tr.getFirstName();
            String last = tr.getLastName();
            System.out.printf("%-20s%-25s", first, last);
            System.out.println();
        }
        System.out.println(line);
    }    
    
*/    
    
    
    
    
    
    
    
    
    
    
    
}
