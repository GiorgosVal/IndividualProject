package IndividualProject;

import java.util.ArrayList;
import java.util.List;

public class AssignmentCourse {
    
    private Course course;
    private List<Assignment> assignments;
    
    
    AssignmentCourse(Course course) {
        this.course = course;
        assignments = new ArrayList();
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }
    
    public boolean isAssignmentListEmpty() {
        return assignments.isEmpty() ? true : false;
    }
    
    public int assignmentsSize(){
        return assignments.size();
    }
    
    public Course getCourse() {
        return this.course;
    }
    
    public List<Assignment> getAssignmentList() {
        return this.assignments;
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
        System.out.println("Λίστα καθηγητών");
        System.out.println(line);
        for (Assignment tr : assignments) {
            String first = tr.getTitle();
            String last = tr.getDescription();
            String sub = tr.getDescription();
            System.out.printf("%-20s%-25s%-50s", first, last, sub);
            System.out.println();
        }
        System.out.println(line);
    }
 */   
    
    
    
    
    
    
    
}
