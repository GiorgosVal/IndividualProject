package IndividualProject;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static List<Student> studentsArray;
    static List<Course> coursesArray;
    static List<Trainer> trainersArray;
    static List<Assignment> assignmentsArray;
    static List<TrainerCourse> trainerCourseRelations;
    static List<AssignmentCourse> assignmentCourseRelations;
    static List<StudentCourse> studentCourseRelations;
    static List<StudentAssignment> studentAssignmentsRelations;

    int numOfStudents;
    int numOfCourses;
    int numOfTrainers;
    int numOfAssignments;

// ////////////////////////////////////////////////////////////////////////////
//
//                   O B J E C T S   C R E A T I O N
//
// ////////////////////////////////////////////////////////////////////////////
//
//* ------------------------------------------------------------------------- */
// Student Object Creation
//* ------------------------------------------------------------------------- */
    void studentCreation(Scanner scan) {
        System.out.println("\nHow many Student profiles do you want to create?");
        System.out.println("\nWrite 'C<' if you want to return to the previous menu.");
        numOfStudents = Validation.positiveIntValidationWithReturn(scan);
        if (numOfStudents != -1) {
            for (int i = 0; i < numOfStudents; i++) {
                Student student = new Student(i, scan);
                studentsArray.add(student);
            }
        }

    }

//* ------------------------------------------------------------------------- */
// Course Object Creation
//* ------------------------------------------------------------------------- */
    void courseCreation(Scanner scan) {
        System.out.println("\nHow many Courses do you want to create?");
        System.out.println("\nWrite 'C<' if you want to return to the previous menu.");
        numOfCourses = Validation.positiveIntValidationWithReturn(scan);
        if (numOfCourses != -1) {
            for (int i = 0; i < numOfCourses; i++) {
                Course course = new Course(i, scan);
                coursesArray.add(course);
            }
        }

    }

//* ------------------------------------------------------------------------- */
// Trainer Object Creation
//* ------------------------------------------------------------------------- */
    void trainerCreation(Scanner scan) {
        System.out.println("\nHow many Trainers profiles do you want to create?");
        System.out.println("\nWrite 'C<' if you want to return to the previous menu.");
        numOfTrainers = Validation.positiveIntValidationWithReturn(scan);
        if (numOfTrainers != -1) {
            for (int i = 0; i < numOfTrainers; i++) {
                Trainer trainer = new Trainer(i, scan);
                trainersArray.add(trainer);
            }
        }

    }

//* ------------------------------------------------------------------------- */
// Assignment Object Creation
//* ------------------------------------------------------------------------- */
    void assignmentCreation(Scanner scan) {
        System.out.println("\nHow many Assignments do you want to create? At least " + ((coursesArray.size()) * 6) + " are required.");
        System.out.println("\nWrite 'C<' if you want to return to the previous menu.");
        numOfAssignments = Validation.positiveIntValidationWithReturn(scan);
        if (numOfAssignments != -1) {
            for (int i = 0; i < numOfAssignments; i++) {
                Assignment assignment = new Assignment(i, scan);
                assignmentsArray.add(assignment);
            }
        }

    }

// ////////////////////////////////////////////////////////////////////////////
//
//                   O B J E C T S   P R I N T I N G
//
// ////////////////////////////////////////////////////////////////////////////
//    
//* ------------------------------------------------------------------------- */
// Student Object Printing
//* ------------------------------------------------------------------------- */
    static void studentPrint() {
        int i = 1;
        String line = "-";
        for (int j = 0; j < 72; j++) {
            line += "-";
        }

        System.out.printf("%23s%s\n", " ", "S T U D E N T S   L I S T");
        System.out.println(line);
        System.out.printf("%-4s%-20s%-25s%13s%10s\n", "NO", "FIRST NAME", "LAST NAME", "DATE OF BIRTH", "FEES");
        System.out.println(line);
        for (Student student : studentsArray) {

            String name = student.getFirstName();
            String last = student.getLastName();
            String birth = student.getDateofBirthString();
            int fees = student.getTuitionFees();

            System.out.printf("%-4d%-20s%-25s%13s%10d\n", i, name, last, birth, fees);
            i++;
        }
        System.out.println(line);
        System.out.println();
        System.out.println();
    }

//* ------------------------------------------------------------------------- */
// Course Object Printing
//* ------------------------------------------------------------------------- */
    static void coursePrint() {
        int i = 1;
        String line = "-";
        for (int j = 0; j < 95; j++) {
            line += "-";
        }

        System.out.printf("%36s%s\n", " ", "C O U R S E S   L I S T");
        System.out.println(line);
        System.out.printf("%-4s%-25s%-15s%-15s%13s%13s%10s\n", "NO", "TITLE", "STREAM", "TYPE", "START DATE", "END DATE", "COST");
        System.out.println(line);
        for (Course course : coursesArray) {

            String title = course.getTitle();
            String stream = course.getStream();
            String type = course.getType();
            String start = course.getStart_dateString();
            String end = course.getEnd_dateString();
            double cost = course.getCost();

            System.out.printf("%-4d%-25s%-15s%-15s%13s%13s%10.2f\n", i, title, stream, type, start, end, cost);
            i++;
        }
        System.out.println(line);
        System.out.println();
        System.out.println();
    }
//* ------------------------------------------------------------------------- */
// Trainer Object Printing
//* ------------------------------------------------------------------------- */

    static void trainerPrint() {
        int i = 1;

        String line = "-";
        for (int j = 0; j < 69; j++) {
            line += "-";
        }

        System.out.printf("%22s%s\n", " ", "T R A I N E R S   L I S T");
        System.out.println(line);
        System.out.printf("%-4s%-20s%-25s%-20s\n", "NO", "FIRST NAME", "LAST NAME", "SUBJECT");
        System.out.println(line);
        for (Trainer trainer : trainersArray) {

            String name = trainer.getFirstName();
            String last = trainer.getLastName();
            String subject = trainer.getSubject();

            System.out.printf("%-4d%-20s%-25s%-50s\n", i, name, last, subject);
            i++;
        }
        System.out.println(line);
        System.out.println();
        System.out.println();
    }

//* ------------------------------------------------------------------------- */
// Assignment Object Printing
//* ------------------------------------------------------------------------- */
    static void assignmentPrint() {
        int i = 1;
        String line = "-";
        for (int j = 0; j < 153; j++) {
            line += "-";
        }

        System.out.printf("%61s%s\n", " ", "A S S I G N M E N T S   L I S T");
        System.out.println(line);
        System.out.printf("%-4s%-50s%-60s%-17s%10s%12s\n", "NO", "TITLE", "DESCRIPTION", "SUBMISSION DATE", "ORAL MARK", "TOTAL MARK");
        System.out.println(line);
        for (Assignment assignment : assignmentsArray) {

            String title = assignment.getTitle();
            String description = assignment.getDescription();
            String subDate = assignment.getSubDateTimeString();
            double oral = assignment.getOralMark();
            double total = assignment.getTotalMark();

            System.out.printf("%-4d%-50s%-60s%-17s%10.2f%12.2f\n", i, title, description, subDate, oral, total);
            i++;
        }
        System.out.println(line);
        System.out.println();
        System.out.println();
    }

//* ------------------------------------------------------------------------- */
// Students / Courses Relations Printing
//* ------------------------------------------------------------------------- */
    static void studentsCoursesPrint() {
        String line = "-";
        for (int j = 0; j < 49; j++) {
            line += "-";
        }

        System.out.printf("%5s%s\n", " ", "S T U D E N T S / C O U R S E   L I S T");
        for (StudentCourse obj : studentCourseRelations) {
            int i = 1;
            String title = obj.getCourse().getTitle().toUpperCase();
            String stream = obj.getCourse().getStream();
            String type = obj.getCourse().getType();
            List<Student> list = obj.getStudentList();

            System.out.println(line);
            System.out.println(title + ", " + stream + ", " + type);
            System.out.printf("%-4s%-20s%-25s\n", "NO", "FIRST NAME", "LAST NAME");
            System.out.println(line);

            for (Student student : list) {
                String lastName = student.getLastName();
                String firstName = student.getFirstName();

                System.out.printf("%-4d%-20s%-25s\n", i, firstName, lastName);
                i++;
            }
            System.out.println(line);
            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

//* ------------------------------------------------------------------------- */
// Trainers / Courses Relations Printing
//* ------------------------------------------------------------------------- */
    static void trainersCoursesPrint() {
        String line = "-";
        for (int j = 0; j < 49; j++) {
            line += "-";
        }

        System.out.printf("%5s%s\n", " ", "T R A I N E R S / C O U R S E   L I S T");
        for (TrainerCourse obj : trainerCourseRelations) {
            int i = 1;
            String title = obj.getCourse().getTitle().toUpperCase();
            String stream = obj.getCourse().getStream();
            String type = obj.getCourse().getType();
            List<Trainer> list = obj.getTrainersList();

            System.out.println(line);
            System.out.println(title + ", " + stream + ", " + type);
            System.out.printf("%-4s%-20s%-25s\n", "NO", "FIRST NAME", "LAST NAME");
            System.out.println(line);

            for (Trainer trainer : list) {
                String lastName = trainer.getLastName();
                String firstName = trainer.getFirstName();

                System.out.printf("%-4d%-20s%-25s\n", i, firstName, lastName);
                i++;
            }
            System.out.println(line);
            System.out.println();
            System.out.println();

        }

        System.out.println();
        System.out.println();
    }

//* ------------------------------------------------------------------------- */
// Assignments / Courses Relations Printing
//* ------------------------------------------------------------------------- */
    static void assignmentsCoursesPrint() {
        String line = "-";
        for (int j = 0; j < 114; j++) {
            line += "-";
        }

        System.out.printf("%34s%s\n", " ", "A S S I G N M E N T S / C O U R S E   L I S T");
        for (AssignmentCourse obj : assignmentCourseRelations) {
            int i = 1;
            String title = obj.getCourse().getTitle().toUpperCase();
            String stream = obj.getCourse().getStream();
            String type = obj.getCourse().getType();
            List<Assignment> list = obj.getAssignmentList();

            System.out.println(line);
            System.out.println(title + ", " + stream + ", " + type);
            System.out.printf("%-4s%-50s%-60s\n", "NO", "TITLE", "DESCRIPTION");
            System.out.println(line);

            for (Assignment assignment : list) {
                String asstitle = assignment.getTitle();
                String description = assignment.getDescription();

                System.out.printf("%-4d%-50s%-60s\n", i, asstitle, description);
                i++;
            }
            System.out.println(line);
            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

//* ------------------------------------------------------------------------- */
// Students / Assignments Relations Printing
//* ------------------------------------------------------------------------- */
    static void studentsAssignmentsPrint() {
        String line = "-";
        for (int i = 0; i < 110; i++) {
            line += "-";
        }

        System.out.printf("%34s%s\n", " ", "A S S I G N M E N T S / S T U D E N T   L I S T");
        for (StudentAssignment obj : studentAssignmentsRelations) {
            int i = 1;
            String first = obj.getStudent().getFirstName();
            String last = obj.getStudent().getLastName();

            List<Assignment> list = obj.getAssignmentList();

            System.out.println(line);
            System.out.println(last + " " + first);
            System.out.printf("%-4s%-50s%-100s\n", "NO", "TITLE", "DESCRIPTION");
            System.out.println(line);
            for (Assignment assignment : list) {
                String title = assignment.getTitle();
                String description = assignment.getDescription();
                System.out.printf("%-4d%-50s%-100s\n", i, title, description);
                i++;
            }

            System.out.println(line);
            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

//* ------------------------------------------------------------------------- */
// Students With Multiple Courses Relations Printing
//* ------------------------------------------------------------------------- */
    static void studentsMultipleCoursesPrint() {
        String line = "-";
        for (int j = 0; j < 49; j++) {
            line += "-";
        }

        System.out.printf("%4s%s\n", " ", "S T U D E N T S   W H O   E N R O L L E D");
        System.out.printf("%6s%s\n", " ", "I N   M U L T I P L E   C O U R S E S");
        int i = 1;
        System.out.println(line);
        System.out.printf("%-4s%-20s%-25s\n", "NO", "FIRST NAME", "LAST NAME");
        System.out.println(line);

        for (StudentAssignment obj : studentAssignmentsRelations) {

            int numOfAssignments = obj.getAssignmentList().size();

            if (numOfAssignments > 6) {

                String last = obj.getStudent().getLastName();
                String first = obj.getStudent().getFirstName();

                System.out.printf("%-4d%-20s%-25s\n", i, first, last);
                i++;
            }
        }

        System.out.println(line);
        System.out.println();
        System.out.println();
    }

//* ------------------------------------------------------------------------- */
// Week Assignments Printing
//* ------------------------------------------------------------------------- */
    static void weeksAssignments(Scanner scan) {

        // Finding the date range in which the assignments are
        Assignment assignment = assignmentsArray.get(0);
        LocalDate min = assignment.getSubDateTime();
        LocalDate max = assignment.getSubDateTime();

        for (Assignment a : assignmentsArray) {
            LocalDate date = a.getSubDateTime();
            if (date.isAfter(max)) {
                max = date;
            }
            if (date.isBefore(min)) {
                min = date;
            }
        }

        String minString = Validation.LocalDate_to_String(min);
        String maxString = Validation.LocalDate_to_String(max);

        System.out.println();
        System.out.println("Enter a date to see the Students who have to submit assignments for the according week. Date format dd/mm/yyyy.");
        System.out.println("According to the data, the submission dates begin on " + minString + " and end on " + maxString);
        System.out.println();

        // validation input
        boolean isNotValid = true;
        LocalDate request = null;
        while (isNotValid) {
            request = Validation.dateValidation(scan);
            if (request.isBefore(min) || request.isAfter(max)) {
                System.out.println("Enter a date from " + minString + " to " + maxString);
                System.out.println();
            } else {
                isNotValid = false;
            }
        }

        // Finding the week
        LocalDate requestMax = request;
        LocalDate requestMin = request;
        DayOfWeek firstDayOfWeek = request.getDayOfWeek();
        DayOfWeek lastDayOfWeek = request.getDayOfWeek();

        while (firstDayOfWeek != DayOfWeek.MONDAY) {
            firstDayOfWeek = firstDayOfWeek.minus(1);
            requestMin = requestMin.minusDays(1);
        }

        while (lastDayOfWeek != DayOfWeek.FRIDAY) {
            if (lastDayOfWeek.getValue() < 5) {
                lastDayOfWeek = lastDayOfWeek.plus(1);
                requestMax = requestMax.plusDays(1);
            } else {
                lastDayOfWeek = lastDayOfWeek.minus(1);
                requestMax = requestMax.minusDays(1);
            }
        }

        String from = Validation.LocalDate_to_String(requestMin);
        String to = Validation.LocalDate_to_String(requestMax);

        // Finding the students that must submit assignment
        Set<Student> students = new HashSet();

        for (StudentAssignment sa : studentAssignmentsRelations) {
            for (Assignment asgn : sa.getAssignmentList()) {
                LocalDate asgnSub = asgn.getSubDateTime();
                boolean isSameOrAfter = (asgnSub.isEqual(requestMin) || asgnSub.isAfter(requestMin));
                boolean isSameOrBefore = (asgnSub.isEqual(requestMax) || asgnSub.isBefore(requestMax));
                if (isSameOrAfter && isSameOrBefore) {
                    Student st = sa.getStudent();
                    students.add(st);
                }
            }
        }

        // start of printing
        String line = "-";
        for (int j = 0; j < 49; j++) {
            line += "-";
        }
        System.out.println(line);
        System.out.printf("%6s%s\n", " ", "T H I S   W E E K S   S T U D E N T S");
        System.out.printf("%7s%s\n", " ", "W H O   H A V E   T O   S U B M I T");
        System.out.printf("%14s%s\n", " ", "A S S I G N M E N T S");
        System.out.println(line);
        System.out.println("From " + from + " to " + to);
        System.out.printf("%-4s%-20s%-25s\n", "NO", "FIRST NAME", "LAST NAME");
        System.out.println();
        int i = 1;
        for (Student st : students) {
            String first = st.getFirstName();
            String last = st.getLastName();

            System.out.printf("%-4d%-20s%-25s\n", i, first, last);
            i++;
        }
        students.clear();
        System.out.println(line);
        System.out.println();
        System.out.println();
    }

//
// ////////////////////////////////////////////////////////////////////////////
//
//               P R O G R A M   F L O W   M E T H O D S
//
// ////////////////////////////////////////////////////////////////////////////
//
//* ------------------------------------------------------------------------- */
// Initial Inputs
//* ------------------------------------------------------------------------- */
    static void initialInputs(int choise, Scanner scan, Main p) {
        boolean inputIncomplete = true;

        while (inputIncomplete) {
            System.out.println("You have the following options:\n\n"
                    + "1. Create Courses.\n"
                    + "2. Create Student profiles.\n"
                    + "3. Create Trainer profiles.\n"
                    + "4. Create Assignments.\n"
                    + "5. Continue to relating the data you gave above.");

            choise = Validation.maxValidation(5, scan);

            switch (choise) {
                case 1:
                    p.courseCreation(scan);
                    break;
                case 2:
                    p.studentCreation(scan);
                    break;
                case 3:
                    p.trainerCreation(scan);
                    break;
                case 4:
                    p.assignmentCreation(scan);
                    break;
                case 5:
                    boolean coursesEmpty = coursesArray.isEmpty();
                    boolean studentsEmpty = studentsArray.isEmpty();
                    boolean trainersEmpty = trainersArray.isEmpty();
                    boolean assignmentsEmpty = assignmentsArray.isEmpty();
                    int numOfAssignmentsGiven = assignmentsArray.size();
                    int numOfAssignmentsRequired = coursesArray.size() * 6;
                    boolean fewAssignments = numOfAssignmentsGiven < numOfAssignmentsRequired;

                    if (coursesEmpty) {
                        System.out.println("You haven't created Courses.");
                    }
                    if (studentsEmpty) {
                        System.out.println("You haven't created Student profiles.");
                    }
                    if (trainersEmpty) {
                        System.out.println("You haven't created Trainer profiles.");
                    }
                    if (assignmentsEmpty) {
                        System.out.println("You haven't created Assignments.");
                    }
                    if (!assignmentsEmpty && fewAssignments) {
                        System.out.println("Number of Assignments not adequate.\n"
                                + "Each Course demands 6 Assignments.\n"
                                + "You must enter " + (numOfAssignmentsRequired - numOfAssignmentsGiven) + " more assignments.");
                    }
                    if (!coursesEmpty && !studentsEmpty && !trainersEmpty && !assignmentsEmpty && !fewAssignments) {
                        System.out.println("TRASFERING TO DATA RELATIONS....");
                        inputIncomplete = false;
                    } else {
                        System.out.println("\nEnter the required fields and try again.\n");
                    }
            }

        }
    }

//* ------------------------------------------------------------------------- */
// Availability Methods
//* ------------------------------------------------------------------------- */       
    static void printAvailableCourses(List<Course> availableCourses) {
        if (availableCourses.isEmpty()) {
            System.out.println("There are no more Courses to relate.\n");
        } else {
            System.out.println("The available Courses are the following:\n");
            int i = 1;
            for (Course c : availableCourses) {
                System.out.println(i + ". " + c.getTitle());
                i++;
            }
            System.out.println();
            System.out.println("Select which Course you want to relate.");
            System.out.println("Write 'C<' if you want to return to the previous menu.");
        }
    }

    static void printAvailableTrainers(List<Trainer> availableTrainers) {
        if (availableTrainers.isEmpty()) {
            System.out.println("There are no more Trainers to relate.\n");
        } else {
            System.out.println("The available Trainers are the following:\n");
            int i = 1;
            for (Trainer c : availableTrainers) {
                System.out.println(i + ". " + c.getLastName() + " " + c.getFirstName());
                i++;
            }
            System.out.println();
            System.out.println("Select the Trainer you want to relate.");
        }
    }

    static void printAvailableAssignments(List<Assignment> availableAssignments) {
        if (availableAssignments.isEmpty()) {
            System.out.println("There are no more Assignments to relate.\n");
        } else {
            System.out.println("The available Assignments are the following:\n");
            int i = 1;
            for (Assignment c : availableAssignments) {
                System.out.println(i + ". " + c.getTitle() + " " + c.getDescription());
                i++;
            }
            System.out.println();
            System.out.println("Select which Assignment you want to relate.");
        }
    }

    static void printAvailableStudents(List<Student> availableStudents) {
        if (availableStudents.isEmpty()) {
            System.out.println("There are no more Students to relate.\n");
        } else {
            System.out.println("The available Students are the following:\n");
            int i = 1;
            for (Student c : availableStudents) {
                System.out.println(i + ". " + c.getLastName() + " " + c.getFirstName());
                i++;
            }
            System.out.println();
            System.out.println("Select the Student you want to relate.");
        }
    }

//* ------------------------------------------------------------------------- */
// Relations
//* ------------------------------------------------------------------------- */  
    static void relations(int choise, Scanner scan, Main p) {
        /* Δημιουργία αντιγράφων της αρχικής courses array. Τα αντίγραφα χρησιμεύουν
        για να αφαιρώ κάθε φορά το επιλεγμένο course από τα διαθέσιμα, ώστε να μην εμφανίζονται
        ως επιλογή στον χρήστη.
         */
        List<List<Course>> avCoursesCopies = new ArrayList();

        for (int i = 0; i < 4; i++) {
            List<Course> temp = new ArrayList();
            for (Course c : coursesArray) {
                temp.add(c);
            }
            avCoursesCopies.add(temp);
        }

        List<Course> avCourses1 = avCoursesCopies.get(0);
        List<Course> avCourses2 = avCoursesCopies.get(1);
        List<Course> avCourses3 = avCoursesCopies.get(2);
        avCoursesCopies = null;

        /*
        Δημιουργώ επίσης και ένα αντίγραφο των assignments. Επειδή κάθε assignment
        μπορεί να προστεθεί σε 1 μόνο course, θα το αφαιρώ από τη λίστα με τα διαθέσιμα assignments.
         */
        List<Assignment> avAssignments = new ArrayList();
        for (Assignment a : assignmentsArray) {
            avAssignments.add(a);
        }

        /*
        Αρχή μενού συσχέτισης.
         */
        System.out.println();
        System.out.println();
        System.out.println("D A T A   C O R R E L A T I O N");
        System.out.println("At this stage you are going to correlate the data you entered.\n");

        boolean relationsIncomplete = true;
        boolean relation1Completed = false;
        boolean relation2Completed = false;
        boolean relation3Completed = false;
        while (relationsIncomplete) {
            System.out.println("You have the following corellation options:\n");
            System.out.println("1. Courses and Trainers.");
            System.out.println("2. Courses and Assignments.");
            System.out.println("3. Courses and Students.\n");

            choise = Validation.maxValidation(3, scan);
            int range = 0;
            switch (choise) {
                case 1:
                    printAvailableCourses(avCourses1);
                    if (!avCourses1.isEmpty()) {
                        range = avCourses1.size();                            // ορίζω το εύρος του input να ισούται με το μέγεθος της available courses
                        choise = Validation.maxValidationWithReturn(range, scan);
                        if (choise == -1) {                                              // εάν η επιλογή -1 τότε γυρίζω στο προηγούμενο μενού
                            break;
                        } else {
                            Course c = avCourses1.get(choise - 1);                  // αλλιώς παίρνω την επιλογή από το available courses
                            System.out.println("You chose the course " + c.getTitle());

                            TrainerCourse tc = new TrainerCourse(c);                 // δημιουργώ obj που μέσα του περνάω το επιλεγμένο course.
                            avCourses1.remove(c);                                   // αφαιρώ το course από τα available
                            trainerCourseRelations.add(tc);                         // προσθέτω το temporary obj σε μόνιμη λίστα

                            List<Trainer> avTrainers = new ArrayList();             // Για το scope του επιλεγμένου course δημιουργώ μία λίστα
                            for (Trainer tr : trainersArray) {                      // με διαθέσιμους trainers
                                avTrainers.add(tr);
                            }

                            while (!(avTrainers.isEmpty())) {                       // για όσο υπάρχουν διαθέσιμοι trainers
                                printAvailableTrainers(avTrainers);                 // τους εκτυπώνω
                                range = avTrainers.size();                          // ορίζω το εύρος επιλογής να ισούται με το μέγεθος της λίστας
                                if (tc.isTrainerListEmpty()) {                      // εάν η λίστα καθηγητών για το επιλεγμένο course είναι άδεια
                                    choise = Validation.maxValidation(range, scan); // τότε κάνω validate την επιλογή με μέθοδο που δεν προσφέρει return
                                } else {
                                    System.out.println("Write 'C<' if you finished relating Trainers in this Course."); // ειδάλλως δίνω την επιλογή return
                                    choise = Validation.maxValidationWithReturn(range, scan);
                                }

                                if (choise == -1) {
                                    break;
                                } else {
                                    Trainer tr = avTrainers.get(choise - 1);
                                    System.out.println("You chose the trainer " + tr.getLastName() + " " + tr.getFirstName() + ".");
                                    tc.addTrainer(tr);
                                    avTrainers.remove(tr);
                                }
                            }
                        }

                    }

                    break;
                case 2:
                    printAvailableCourses(avCourses2);
                    if (!avCourses2.isEmpty()) {
                        range = avCourses2.size();                            // ορίζω το εύρος του input να ισούται με το μέγεθος της available courses
                        choise = Validation.maxValidationWithReturn(range, scan);
                        if (choise == -1) {                                              // εάν η επιλογή -1 τότε γυρίζω στο προηγούμενο μενού
                            break;
                        } else {
                            Course c = avCourses2.get(choise - 1);                  // αλλιώς παίρνω την επιλογή από το available courses

                            LocalDate start_date = c.getStart_date();                  // παίρω τις ημερομηνίες διεξαγωγής του Course
                            LocalDate end_date = c.getEnd_date();                      // για να τις βάλω ως παραμέτρους στο assignment subDateTime

                            System.out.println("You chose the course " + c.getTitle());

                            AssignmentCourse ac = new AssignmentCourse(c);      // δημιουργώ obj που μέσα του περνάω το επιλεγμένο course.
                            avCourses2.remove(c);                           // αφαιρώ το course από τα available
                            assignmentCourseRelations.add(ac);             // προσθέτω το temporary obj σε μόνιμη λίστα

                            while (!(avAssignments.isEmpty()) && ac.assignmentsSize() != 6) {
                                printAvailableAssignments(avAssignments);
                                System.out.println("You can correlate " + (6 - ac.assignmentsSize()) + " more Assignments to this Course.");
                                range = avAssignments.size();
                                choise = Validation.maxValidation(range, scan);
                                Assignment as = avAssignments.get(choise - 1);          // παίρνω το assignment obj από την available assignments list
                                String title = as.getTitle();
                                System.out.println("You chose the assignment " + title + ".");

                                as.setSubDateTime(scan, start_date, end_date);                 // ορίζω το subDate στο Assignment obj της available assignments list

                                LocalDate subDate = as.getSubDateTime();                       // παιρνω το subDate πάλι πίσω
                                for (Assignment a : assignmentsArray) {
                                    if (a.equals(as)) {
                                        a.setSubDateTime(subDate);                              // ορίζω το subDate να είναι το ίδιο και στην αρχική assignments list
                                    }
                                }

                                ac.addAssignment(as);               // προσθέτω το assignment obj στη λίστα των assignments της StudentCourse
                                avAssignments.remove(as);
                            }
                        }
                    }
                    break;
                case 3:
                    printAvailableCourses(avCourses3);
                    if (!avCourses3.isEmpty()) {
                        range = avCourses3.size();                            // ορίζω το εύρος του input να ισούται με το μέγεθος της available courses
                        choise = Validation.maxValidationWithReturn(range, scan);
                        if (choise == -1) {                                              // εάν η επιλογή -1 τότε γυρίζω στο προηγούμενο μενού
                            break;
                        } else {
                            Course c = avCourses3.get(choise - 1);                  // αλλιώς παίρνω την επιλογή από το available courses
                            System.out.println("You chose " + c.getTitle());

                            StudentCourse tc = new StudentCourse(c);      // δημιουργώ obj που μέσα του περνάω το επιλεγμένο course.
                            avCourses3.remove(c);                           // αφαιρώ το course από τα available
                            studentCourseRelations.add(tc);             // προσθέτω το temporary obj σε μόνιμη λίστα

                            List<Student> avStudents = new ArrayList();
                            for (Student tr : studentsArray) {
                                avStudents.add(tr);
                            }
                            while (!(avStudents.isEmpty())) {
                                printAvailableStudents(avStudents);
                                range = avStudents.size();
                                if (tc.isStudentListEmpty()) {
                                    choise = Validation.maxValidation(range, scan);
                                } else {
                                    System.out.println("Write 'C<' if you finished relating Students in this Course.");
                                    choise = Validation.maxValidationWithReturn(range, scan);
                                }

                                if (choise == -1) {
                                    break;
                                } else {
                                    Student tr = avStudents.get(choise - 1);
                                    System.out.println("You chose the student " + tr.getLastName() + " " + tr.getFirstName() + ".");
                                    tc.addStudent(tr);
                                    avStudents.remove(tr);
                                }
                            }
                        }
                    }
                    break;
            }

            /*
            Όταν και τα 3 αντίγραφα λιστών των courses αδειάσουν σημαίνει ότι
            ολοκληρώθηκαν οι συσχετίσεις.
             */
            if (avCourses1.isEmpty()) {
                relation1Completed = true;
                System.out.printf("%-25s%4s\n", "TRAINERS CORRELATION:", "ΟΚ");
            }
            if (avCourses2.isEmpty()) {
                relation2Completed = true;
                System.out.printf("%-25s%4s\n", "ASSIGNMENTS CORRELATION:", "ΟΚ");
            }
            if (avCourses3.isEmpty()) {
                relation3Completed = true;
                System.out.printf("%-25s%4s\n", "STUDENTS CORRELATION:", "ΟΚ");
            }
            if (relation1Completed && relation2Completed && relation3Completed) {
                relationsIncomplete = false;
                studentAssignments();                                               // Αυτόματη συσχέτιση students με assignments
                System.out.println();
                System.out.println("The correlation of data has finished.\nYou are transfered to Outputs menu.\n");
                System.out.println();
            }

        }
    }

    /**
     * This method implements the relation between Students and Assignments. For
     * each Student inside the initial studentsArray, it creates a relation
     * object of the class StudentAssignment. After this, it makes a concurrent
     * search inside the relational object's lists of the classes StudentCourse
     * and AssignmentCourse. If the Course objects inside the lists are equal,
     * and the Student object exists, then adds the Assignment objects of the
     * Course to the Student.
     */
    static void studentAssignments() {
        for (Student student : studentsArray) {                                 // για κάθε μαθητή στην αρχική λίστα των μαθητών
            StudentAssignment sa = new StudentAssignment(student);              // δημιούργησε μία σχέση Student/Assinment
            // έπειτα:
            for (StudentCourse scObj : studentCourseRelations) {                 // ψάξε τα objects στη λίστα σχέσεων StudenCourses
                for (AssignmentCourse acObj : assignmentCourseRelations) {       // ψάξε τα objects στη λίστα σχέσεων AssignmentCourses
                    if (scObj.getCourse().equals(acObj.getCourse())) {           // εάν τα objects έχουν το ίδιο Course object
                        if (scObj.getStudentList().contains(student)) {
                            for (Assignment a : acObj.getAssignmentList()) {     // για κάθε assignment στην assignment list του Course
                                sa.addAssignment(a);                            // πρόσθεσε το assignment στον Student.
                            }
                        }
                    }
                }
            }
            studentAssignmentsRelations.add(sa);                        // αποθήκευσε τη σχέση Student/Assignment
        }
    }

//
// ////////////////////////////////////////////////////////////////////////////
//
//                   S T A R T   O F   P R O G R A M
//
// ////////////////////////////////////////////////////////////////////////////
//
    public static void main(String[] args) {
        Main p = new Main();
        Scanner scan = new Scanner(System.in);
        coursesArray = new ArrayList<>();
        studentsArray = new ArrayList<>();
        trainersArray = new ArrayList<>();
        assignmentsArray = new ArrayList<>();
        trainerCourseRelations = new ArrayList<>();
        assignmentCourseRelations = new ArrayList<>();
        studentCourseRelations = new ArrayList<>();
        studentAssignmentsRelations = new ArrayList<>();

        int choise = 0;

        System.out.println("Welcome to this app.\n\n"
                + "This console app simulates a private school's data handling program.\n"
                + "You can insert courses, trainers, students and assignments.\n"
                + "After this, you can correlate the data given and output data.\n\n\n"
                + "You have the following options:\n"
                + "(Choose 1 or 2 respectively)\n\n"
                + "1. Insert data.\n2. Continue with synthetic data.");

        choise = Validation.maxValidation(2, scan);

        if (choise == 1) {
            System.out.println("\nYou chose to insert data.\n");

            initialInputs(choise, scan, p);   // Αρχική εισαγωγή δεδομένων
            relations(choise, scan, p);       // Συσχέτιση δεδομένων
            // Τ Ε Λ Ο Σ   I N P U T S    
        } else {
            System.out.println("\nYou chose to continue with synthetic data.\n");
            syntheticData();
        }

        // Φ Α Σ Η   O U T P U T S
        System.out.println();
        System.out.println("O U T P U T S   M E N U");
        System.out.println();
        boolean outputsNeeded = true;
        while (outputsNeeded) {
            System.out.println("You have the following output options:\n\n"
                    + "1. List of all students.\n"
                    + "2. List of all trainers.\n"
                    + "3. List of all assignments.\n"
                    + "4. List of all courses.\n"
                    + "5. List of all students per course.\n"
                    + "6. List of all trainers per course.\n"
                    + "7. List of all assignments per course.\n"
                    + "8. List of all assignments per student.\n"
                    + "9. List of all students who enrolled for multiple courses.\n"
                    + "10. Enter a date and check the students you have to"
                    + " submit assignments for the corresponding week. \n\n\n"
                    + "Write 'C<' to exit the program.");

            choise = Validation.maxValidationWithReturn(10, scan);

            switch (choise) {
                case 1:
                    studentPrint();
                    break;
                case 2:
                    trainerPrint();
                    break;
                case 3:
                    assignmentPrint();
                    break;
                case 4:
                    coursePrint();
                    break;
                case 5:
                    studentsCoursesPrint();
                    break;
                case 6:
                    trainersCoursesPrint();
                    break;
                case 7:
                    assignmentsCoursesPrint();
                    break;
                case 8:
                    studentsAssignmentsPrint();
                    break;
                case 9:
                    studentsMultipleCoursesPrint();
                    break;
                case 10:
                    weeksAssignments(scan);
                    break;
                case -1:
                    System.out.println("THANKS FOR CHOOSING OUR APP!");
                    scan.close();
                    System.exit(0);
            }

        }

// -------------------------------------------------------------------------- //
//
//                       S Y N T H E T I C   D A T A
//
// -------------------------------------------------------------------------- //        
    }

    static void syntheticData() {
        Course c1 = new Course("Coding Bootcamp", "Full-time", "Java", "15/09/2018", "31/12/2018", 450);
        Course c2 = new Course("Robotics", "Full-time", "Robot Modeling", "15/09/2018", "31/12/2018", 4444);
        Course c3 = new Course("Applied Mathematics", "Part-time", "MatLab", "15/09/2018", "31/12/2018", 4444);
        Course c4 = new Course("Embedeed Systems", "Part-time", "Arduino", "15/09/2018", "31/12/2018", 4444);
        Course c5 = new Course("CAD Design", "Part-time", "AutoCAD 3D", "15/09/2018", "31/12/2018", 4444);

        coursesArray.add(c1);
        coursesArray.add(c2);
        coursesArray.add(c3);
        coursesArray.add(c4);
        coursesArray.add(c5);

        Student s1 = new Student("Harold", "Graham", "14/11/1987", 455);
        Student s2 = new Student("Frank", "Hillman", "26/10/1990", 455);
        Student s3 = new Student("Kevin", "Chase", "04/09/1994", 455);
        Student s4 = new Student("Marie", "Lombardo", "16/05/1995", 455);
        Student s5 = new Student("Rebecca", "Marten", "05/01/2000", 455);
        Student s6 = new Student("Adrian", "Fortier", "23/12/1998", 455);
        Student s7 = new Student("Erica", "Neal", "26/10/1990", 455);
        Student s8 = new Student("Marjorie", "Ward", "14/11/1987", 455);
        Student s9 = new Student("Patricia", "Good", "04/09/1994", 455);
        Student s10 = new Student("Diego", "McDermott", "16/05/1995", 455);
        Student s11 = new Student("Ruth", "Ho", "05/01/2000", 455);
        Student s12 = new Student("Patricia", "Moorehead", "14/11/1987", 455);
        Student s13 = new Student("Margaret", "Patterson", "26/10/1990", 455);
        Student s14 = new Student("Victoria", "Martinez", "14/11/1987", 455);
        Student s15 = new Student("Kimberly", "Ochoa", "04/09/1994", 455);
        Student s16 = new Student("Miriam", "Madsen", "16/05/1995", 455);
        Student s17 = new Student("John", "Vaillancourt", "05/01/2000", 455);
        Student s18 = new Student("Sharron", "Guertin", "14/11/1987", 455);
        Student s19 = new Student("Jacob", "Dunn", "26/10/1990", 455);
        Student s20 = new Student("Matt", "McBride", "14/11/1987", 455);

        studentsArray.add(s1);
        studentsArray.add(s2);
        studentsArray.add(s3);
        studentsArray.add(s4);
        studentsArray.add(s5);
        studentsArray.add(s6);
        studentsArray.add(s7);
        studentsArray.add(s8);
        studentsArray.add(s9);
        studentsArray.add(s10);
        studentsArray.add(s11);
        studentsArray.add(s12);
        studentsArray.add(s13);
        studentsArray.add(s14);
        studentsArray.add(s15);
        studentsArray.add(s16);
        studentsArray.add(s17);
        studentsArray.add(s18);
        studentsArray.add(s19);
        studentsArray.add(s20);

        Trainer t1 = new Trainer("William", "Arnold", "Ειδικά μαθήματα");
        Trainer t2 = new Trainer("Vernice", "McEvoy", "Front-end");
        Trainer t3 = new Trainer("Ella", "Trent", "Back-end");
        Trainer t4 = new Trainer("Michael", "Ortiz", "Data bases");
        Trainer t5 = new Trainer("Rikki", "Jose", "Data bases");
        Trainer t6 = new Trainer("Nathan", "Dufresne", "Data bases");
        Trainer t7 = new Trainer("Mary", "Warner", "Data bases");
        Trainer t8 = new Trainer("Kimberly", "Graham", "Data bases");
        Trainer t9 = new Trainer("Travis", "Giannini", "Data bases");
        Trainer t10 = new Trainer("Don", "Brown", "Data bases");

        trainersArray.add(t1);
        trainersArray.add(t2);
        trainersArray.add(t3);
        trainersArray.add(t4);
        trainersArray.add(t5);
        trainersArray.add(t6);
        trainersArray.add(t7);
        trainersArray.add(t8);
        trainersArray.add(t9);
        trainersArray.add(t10);

        Assignment a1 = new Assignment("Lorem ipsum dolor sit amet", "Praesent id sem convallis, auctor nunc vel, mattis nunc.", "05/10/2018", 50, 50);
        Assignment a2 = new Assignment("Cras vitae est finibus", "porta velit non, gravida e", "10/10/2018", 70, 30);
        Assignment a3 = new Assignment("Maecenas at risus euismod, auctor erat sit amet", "Mauris vel arcu consectetu", "16/10/2018", 90, 10);
        Assignment a4 = new Assignment("Maecenas id risus efficitur", "pulvinar arcu quis, malesuada magna", "23/10/2018", 40, 60);
        Assignment a5 = new Assignment("Sed a arcu sed ligula interdum", "Fusce eu mi vitae leo", "20/11/2018", 40, 50);
        Assignment a6 = new Assignment("Praesent ornare purus", "Sed porttitor mauris eget nibh placerat commodo", "28/12/2018", 40, 50);
        
        Assignment a7 = new Assignment("In id urna ac ipsum luctus", "Aenean elementum purus a dictum condimentum.", "13/11/2018", 40, 50);
        Assignment a8 = new Assignment("Donec eget turpis vel felis", "Morbi vitae erat at ex blandit fermentum.", "20/11/2018", 40, 50);
        Assignment a9 = new Assignment("Fusce a nulla quis", "Donec quis odio consequat, ornare nulla nec, placerat mi.", "30/11/2018", 40, 50);
        Assignment a10 = new Assignment("Cras lobortis urna placerat", "Maecenas consequat ligula eget lacus tincidunt varius.", "29/11/2018", 40, 50);
        Assignment a11 = new Assignment("Ut sodales metus ut", "Ut sodales metus ut eleifend malesuada.", "14/11/2018", 40, 50);
        Assignment a12 = new Assignment("Nunc luctus turpis vitae", "In id urna ac ipsum luctus rhoncus sed vitae metus.", "21/12/2018", 40, 50);
        
        Assignment a13 = new Assignment("Fusce a nulla quis metus", "Nunc luctus turpis vitae vestibulum ultrices.", "17/10/2018", 40, 50);
        Assignment a14 = new Assignment("Nullam volutpat sem", "Nullam volutpat sem a elementum iaculis.", "25/10/2018", 40, 50);
        Assignment a15 = new Assignment("Donec vitae massa", "Duis porta nibh et purus laoree", "01/11/2018", 40, 50);
        Assignment a16 = new Assignment("Nulla non felis iaculis", "Donec quis odio consequat, ornare nulla nec, placerat mi.", "06/11/2018", 40, 50);
        Assignment a17 = new Assignment("Aenean vel elit posuere", "Morbi non est finibus", "20/11/2018", 40, 50);
        Assignment a18 = new Assignment("Donec vitae massa", "Morbi non est finibus", "14/12/2018", 40, 50);
        
        Assignment a19 = new Assignment("Duis porta nibh et purus laoree", "Donec quis odio consequat, ornare nulla nec, placerat mi.", "27/11/2018", 40, 50);
        Assignment a20 = new Assignment("Donec vitae massa", "Aenean vel elit posuere", "03/12/2018", 40, 50);
        Assignment a21 = new Assignment("Nullam volutpat sem", "Nullam volutpat sem a elementum iaculis.", "02/10/2018", 40, 50);
        Assignment a22 = new Assignment("Nulla non felis iaculis", "Pellentesque ornare ipsum nec turpis", "01/11/2018", 40, 50);
        Assignment a23 = new Assignment("Integer egestas nibh ac neque", "Morbi non est finibus", "16/10/2018", 40, 50);
        Assignment a24 = new Assignment("Morbi non est finibus", "Donec quis odio consequat, ornare nulla nec, placerat mi.", "05/12/2018", 40, 50);
        
        Assignment a25 = new Assignment("Duis porta nibh et purus laoree", "Pellentesque ornare ipsum nec turpis", "30/10/2018", 40, 50);
        Assignment a26 = new Assignment("Nullam volutpat sem", "Nullam volutpat sem a elementum iaculis.", "08/11/2018", 40, 50);
        Assignment a27 = new Assignment("Nulla non felis iaculis", "Mauris tempus velit in tempus gravida", "21/11/2018", 40, 50);
        Assignment a28 = new Assignment("Pellentesque ornare ipsum nec turpis", "Donec quis odio consequat, ornare nulla nec, placerat mi.", "23/10/2018", 40, 50);
        Assignment a29 = new Assignment("Nullam volutpat sem", "Duis porta nibh et purus laoree", "26/11/2018", 40, 50);
        Assignment a30 = new Assignment("Integer egestas nibh ac neque", "Nullam volutpat sem a elementum iaculis.", "29/11/2018", 40, 50);

        assignmentsArray.add(a1);
        assignmentsArray.add(a2);
        assignmentsArray.add(a3);
        assignmentsArray.add(a4);
        assignmentsArray.add(a5);
        assignmentsArray.add(a6);
        assignmentsArray.add(a7);
        assignmentsArray.add(a8);
        assignmentsArray.add(a9);
        assignmentsArray.add(a10);
        assignmentsArray.add(a11);
        assignmentsArray.add(a12);
        assignmentsArray.add(a13);
        assignmentsArray.add(a14);
        assignmentsArray.add(a15);
        assignmentsArray.add(a16);
        assignmentsArray.add(a17);
        assignmentsArray.add(a18);
        assignmentsArray.add(a19);
        assignmentsArray.add(a20);
        assignmentsArray.add(a21);
        assignmentsArray.add(a22);
        assignmentsArray.add(a23);
        assignmentsArray.add(a24);
        assignmentsArray.add(a25);
        assignmentsArray.add(a26);
        assignmentsArray.add(a27);
        assignmentsArray.add(a28);
        assignmentsArray.add(a29);
        assignmentsArray.add(a30);

        TrainerCourse tc1 = new TrainerCourse(c1);
        TrainerCourse tc2 = new TrainerCourse(c2);
        TrainerCourse tc3 = new TrainerCourse(c3);
        TrainerCourse tc4 = new TrainerCourse(c4);
        TrainerCourse tc5 = new TrainerCourse(c5);

        tc1.addTrainer(t1);
        tc1.addTrainer(t2);
        tc1.addTrainer(t3);
        tc1.addTrainer(t4);

        tc2.addTrainer(t5);
        tc2.addTrainer(t6);
        tc2.addTrainer(t7);
        tc2.addTrainer(t8);
        tc2.addTrainer(t9);
        tc2.addTrainer(t10);

        tc3.addTrainer(t9);
        tc3.addTrainer(t10);
        tc3.addTrainer(t1);
        tc3.addTrainer(t2);

        tc4.addTrainer(t3);
        tc4.addTrainer(t4);
        tc4.addTrainer(t5);
        tc4.addTrainer(t6);
        tc4.addTrainer(t7);
        tc4.addTrainer(t8);
        tc4.addTrainer(t9);
        tc4.addTrainer(t10);

        tc5.addTrainer(t7);
        tc5.addTrainer(t8);
        tc5.addTrainer(t9);
        tc5.addTrainer(t10);

        trainerCourseRelations.add(tc1);
        trainerCourseRelations.add(tc2);
        trainerCourseRelations.add(tc3);
        trainerCourseRelations.add(tc4);
        trainerCourseRelations.add(tc5);

        AssignmentCourse ac1 = new AssignmentCourse(c1);
        AssignmentCourse ac2 = new AssignmentCourse(c2);
        AssignmentCourse ac3 = new AssignmentCourse(c3);
        AssignmentCourse ac4 = new AssignmentCourse(c4);
        AssignmentCourse ac5 = new AssignmentCourse(c5);

        ac1.addAssignment(a1);
        ac1.addAssignment(a2);
        ac1.addAssignment(a3);
        ac1.addAssignment(a4);
        ac1.addAssignment(a5);
        ac1.addAssignment(a6);
        
        ac2.addAssignment(a7);
        ac2.addAssignment(a8);
        ac2.addAssignment(a9);
        ac2.addAssignment(a10);
        ac2.addAssignment(a11);
        ac2.addAssignment(a12);
        
        ac3.addAssignment(a13);
        ac3.addAssignment(a14);
        ac3.addAssignment(a15);
        ac3.addAssignment(a16);
        ac3.addAssignment(a17);
        ac3.addAssignment(a18);
        
        ac4.addAssignment(a19);
        ac4.addAssignment(a20);
        ac4.addAssignment(a21);
        ac4.addAssignment(a22);
        ac4.addAssignment(a23);
        ac4.addAssignment(a24);
        
        ac5.addAssignment(a25);
        ac5.addAssignment(a26);
        ac5.addAssignment(a27);
        ac5.addAssignment(a28);
        ac5.addAssignment(a29);
        ac5.addAssignment(a30);

        assignmentCourseRelations.add(ac1);
        assignmentCourseRelations.add(ac2);
        assignmentCourseRelations.add(ac3);
        assignmentCourseRelations.add(ac4);
        assignmentCourseRelations.add(ac5);

        StudentCourse sc1 = new StudentCourse(c1);
        StudentCourse sc2 = new StudentCourse(c2);
        StudentCourse sc3 = new StudentCourse(c3);
        StudentCourse sc4 = new StudentCourse(c4);
        StudentCourse sc5 = new StudentCourse(c5);

        sc1.addStudent(s1);
        sc1.addStudent(s2);
        sc1.addStudent(s3);
        sc1.addStudent(s4);
        sc1.addStudent(s5);
        sc1.addStudent(s6);
        sc1.addStudent(s7);
        sc1.addStudent(s8);

        sc2.addStudent(s9);
        sc2.addStudent(s10);
        sc2.addStudent(s11);
        sc2.addStudent(s12);
        sc2.addStudent(s13);

        sc3.addStudent(s14);
        sc3.addStudent(s15);
        sc3.addStudent(s16);
        sc3.addStudent(s17);
        sc3.addStudent(s18);
        sc3.addStudent(s19);
        sc3.addStudent(s20);
        sc3.addStudent(s1);
        sc3.addStudent(s2);
        sc3.addStudent(s3);
        sc3.addStudent(s4);

        sc4.addStudent(s20);
        sc4.addStudent(s17);
        sc4.addStudent(s16);
        sc4.addStudent(s15);
        sc4.addStudent(s14);
        sc4.addStudent(s13);
        sc4.addStudent(s10);
        sc4.addStudent(s6);
        sc4.addStudent(s3);
        sc4.addStudent(s2);
        sc4.addStudent(s7);
        sc4.addStudent(s9);

        sc5.addStudent(s11);
        sc5.addStudent(s12);
        sc5.addStudent(s13);
        sc5.addStudent(s14);
        sc5.addStudent(s17);
        sc5.addStudent(s19);

        studentCourseRelations.add(sc1);
        studentCourseRelations.add(sc2);
        studentCourseRelations.add(sc3);
        studentCourseRelations.add(sc4);
        studentCourseRelations.add(sc5);

        studentAssignments();
    }
}
