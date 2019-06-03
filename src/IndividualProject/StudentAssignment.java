package IndividualProject;

import java.util.ArrayList;
import java.util.List;

public class StudentAssignment {
    private Student student;
    private List<Assignment> assignments;
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }
            
    StudentAssignment(Student student) {
        this.student = student;
        assignments = new ArrayList();
    }
    
    public Student getStudent() {
        return student;
    }
    
    public List<Assignment> getAssignmentList() {
        return assignments;
    }
            
            
}
