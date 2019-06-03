package IndividualProject;

import java.time.LocalDate;
import java.util.Scanner;

public class Course {

    private String title;
    private String stream;
    private String type;
    private LocalDate start_date;
    private LocalDate end_date;
    private double cost;

    public String getTitle() {
        return title;
    }

    public void setTitle(Scanner scan) {
        String t = Validation.maxCharactersValidation(scan, 25);
        this.title = t;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(Scanner scan) {
        String st = Validation.maxCharactersValidation(scan, 15);
        this.stream = st;
    }

    public String getType() {
        return type;
    }

    public void setType(Scanner scan) {
        String t = Validation.maxCharactersValidation(scan, 15);
        this.type = t;
    }

    public LocalDate getStart_date() {
        return start_date;
    }
    
    public String getStart_dateString() {
        String dateString = Validation.LocalDate_to_String(start_date);
        return dateString;
    }

    public void setStart_date(Scanner scan) {
        boolean isNotValid = true;
        while (isNotValid) {
            LocalDate date = Validation.dateValidation(scan);
            LocalDate now = LocalDate.now();
            if (date.isAfter(now) || date.isEqual(now)) {
                this.start_date = date;
                isNotValid = false;
            } else {
                System.out.println("The starting date must be the current date or later.");
                System.out.println();
            }
        }
    }

    public LocalDate getEnd_date() {
        return end_date;
    }
    
    public String getEnd_dateString() {
        String dateString = Validation.LocalDate_to_String(end_date);
        return dateString;
    }

    public void setEnd_date(Scanner scan) {
        boolean isNotValid = true;
        while (isNotValid) {
            LocalDate end = Validation.dateValidation(scan);
            LocalDate start = this.start_date;
            if (end.isAfter(start)) {
                isNotValid = false;
                this.end_date = end;
            } else {
                System.out.println("The ending date must be later than the starting date.");
                System.out.println();
            }
        }
    }

    public double getCost() {
        return cost;
    }

    public void setCost(Scanner scan) {
        boolean isNotValid = true;
        while(isNotValid) {
            double c = Validation.positiveDoubleValidation(scan);
            if(c > 20000) {
                System.out.println("Cost cannot exceed €20,000.00");
                System.out.println();
            } else {
                this.cost = c;
                isNotValid = false;
            }
        }
        
    }

    Course(int i, Scanner scan) {
        System.out.println("Enter the title of Course no. " + (i + 1));
        setTitle(scan);
        System.out.println("Enter the stream of " + this.title);
        setStream(scan);
        System.out.println("Enter the type of " + this.title);
        setType(scan);
        System.out.println("Enter the starting date of " + this.title);
        setStart_date(scan);
        System.out.println("Enter the ending date of " + this.title);
        setEnd_date(scan);
        System.out.println("Enter the cost of " + this.title);
        setCost(scan);

    }


///////////////////////////////////////////////////////////////////////////////4
//                  METHODS FOR SYNTHETIC DATA ONLY    
    
    
    /**
     * Use only for synthetic data.
     * This constructor creates Course objects.
     * @param title
     * @param stream
     * @param type
     * @param start_date
     * @param end_date
     * @param cost 
     */
    Course(String title, String stream, String type, String start_date, String end_date, double cost) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.start_date = Validation.StringDate_to_LocalDate(start_date);
        this.end_date = Validation.StringDate_to_LocalDate(end_date);
        this.cost = cost;
    }
    
    
    
    
    

}
