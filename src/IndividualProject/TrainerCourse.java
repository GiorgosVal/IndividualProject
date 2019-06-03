package IndividualProject;

import java.util.ArrayList;
import java.util.List;

public class TrainerCourse {

    private Course course;
    private List<Trainer> trainers;

    TrainerCourse(Course course) {
        this.course = course;
        trainers = new ArrayList();
    }

    public void addTrainer(Trainer trainer) {
        trainers.add(trainer);
    }
    
    public boolean isTrainerListEmpty() {
        return trainers.isEmpty() ? true : false;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public List<Trainer> getTrainersList(){
        return trainers;
    }
    
    
    
    
/*    
    
///////////////////////////////////////////////////////////////////////////////    
// NOT USED  
//   
///////////////////////////////////////////////////////////////////////////////
    public void setRelation(Trainer trainer) {
        if (trainers.contains(trainer)) {
            System.out.println("The trainer " + trainer.getFirstName() + " "
                    + trainer.getLastName() + " is already in the list.");
        } else {
            trainers.add(trainer);
        }
    }

    public void seeRelation() {
        String courseTitle = this.course.getTitle().toUpperCase();
        String courseStream = this.course.getStream().toUpperCase();
        String courseType = this.course.getType().toUpperCase();
        String line = "____________________________________________________________________________________________________";
        System.out.println(line);
        System.out.printf("%-25s%-20s%-20s", courseTitle, courseStream, courseType);
        System.out.println("Trainers list");
        System.out.println(line);
        for (Trainer tr : trainers) {
            String first = tr.getFirstName();
            String last = tr.getLastName();
            String sub = tr.getSubject();
            System.out.printf("%-20s%-25s%-50s", first, last, sub);
            System.out.println();
        }
        System.out.println(line);
    }

    */

}
