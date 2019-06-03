package IndividualProject;

import java.time.LocalDate;
import java.util.Scanner;

public class Assignment {

    private String title;
    private String description;
    private LocalDate subDateTime;
    private double oralMark;
    private double totalMark;

    // GETTERS & SETTERS
    public String getTitle() {
        return title;
    }

    public void setTitle(Scanner scan) {
        String t = Validation.maxCharactersValidation(scan, 50);
        this.title = t;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(Scanner scan) {
        String desc = Validation.maxCharactersValidation(scan, 60);
        this.description = desc;
    }

    public LocalDate getSubDateTime() {
        return subDateTime;
    }
    
    public String getSubDateTimeString() {
        String dateString = Validation.LocalDate_to_String(subDateTime);
        return dateString;
    }

    public void setSubDateTime(Scanner scan, LocalDate start_date, LocalDate end_date) {
        String start = Validation.LocalDate_to_String(start_date);
        String end = Validation.LocalDate_to_String(end_date);
        System.out.println("Set the submission date to be after " + start + " up until to " + end);
        System.out.println("The assignments submissions take place Monday-Friday.");
        System.out.println();
        boolean isNotValid = true;
        
        while (isNotValid) {
            LocalDate subDate = Validation.dateValidation(scan);
            if (subDate.isAfter(start_date) && (subDate.isBefore(end_date) || subDate.isEqual(end_date))) {
                int x = subDate.getDayOfWeek().getValue();
                if (x == 6 || x == 7) {
                    System.out.println("The date you entered is Weekend.");
                    System.out.println("The assignments submissions take place Monday-Friday.");
                    System.out.println();
                } else {
                    this.subDateTime = subDate;
                    System.out.println("Date successfully registered.");
                    System.out.println();
                    isNotValid = false;
                }

            } else {
                System.out.println("The date must be after " + start + " up until to " + end);
            }
        }
    }
    /**
     * This method does not offer validation according to Course starting/ending dates.
     * 
     * @param date 
     */
    public void setSubDateTime(LocalDate date) {
        this.subDateTime = date;
    }

    public double getOralMark() {
        return oralMark;
    }

    public void setOralMark(Scanner scan) {
        boolean isNotValid = true;
        double mark = 0;
        while (isNotValid) {
            mark = Validation.maxDoubleValidation(100, scan);
            if (mark <= totalMark) {
                this.oralMark = mark;
                isNotValid = false;
            } else {
                System.out.println("Oral mark must be equal or less than Total mark.");
                System.out.println();
            }
        }
    }

    public double getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(double totalMark) {
        this.totalMark = totalMark;
    }

    // CONSTRUCTORS
    Assignment(int i, Scanner scan) {
        System.out.println("Title of Assignment no." + (i + 1));
        setTitle(scan);
        System.out.println("Description of " + this.title);
        setDescription(scan);
        //System.out.println("Submission date of Assignment no." + (i + 1));
        //setSubDateTime(scan.nextLine());
        System.out.println("Total Mark of " + this.title);
        setTotalMark(Validation.maxDoubleValidation(100, scan));
        System.out.println("Oral Mark of " + this.title);
        setOralMark(scan);        
    }
    
    
///////////////////////////////////////////////////////////////////////////////
//                  SYNTHETIC DATA METHODS    
    /**
     * Use only for synthetic data.
     * This constructor creates Assignment objects.
     * @param title Title of assignment
     * @param description Description of assignment
     * @param subDate Submission date of assignment
     * @param oralMark Oral mark of assignment
     * @param totalMark Total mark of assignment
     */
    
    Assignment(String title, String description, String subDate, double oralMark, double totalMark) {
        this.title = title;
        this.description = description;
        this.subDateTime = Validation.StringDate_to_LocalDate(subDate);
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }

}
