package IndividualProject;

import java.time.LocalDate;
import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int tuitionFees;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(Scanner scan) {
        boolean isNotValid = true;
        while(isNotValid) {
            String s = Validation.namesValidation(scan);
            boolean chars = Validation.maxCharactersValidation(s, 20);
            if(chars == true) {
                this.firstName = s;
                isNotValid = false;
            }
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(Scanner scan) {
        boolean isNotValid = true;
        while(isNotValid) {
            String s = Validation.namesValidation(scan);
            boolean chars = Validation.maxCharactersValidation(s, 25);
            if(chars == true) {
                this.lastName = s;
                isNotValid = false;
            }
        }
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
    public String getDateofBirthString() {
        String date = Validation.LocalDate_to_String(dateOfBirth);
        return date;
    }

    public void setDateOfBirth(Scanner scan) {
        boolean isNotValid = true;
        while(isNotValid) {
            LocalDate date = Validation.dateValidation(scan);
            LocalDate sixYearsAgo = LocalDate.now().minusYears(6);
            LocalDate min = LocalDate.now().minusYears(30);
            if(date.isAfter(min) && date.isBefore(sixYearsAgo)) {
                this.dateOfBirth = date;
                isNotValid = false;
            } else {
                String from = Validation.LocalDate_to_String(min);
                String to = Validation.LocalDate_to_String(sixYearsAgo);
                System.out.println("Students can't be less than 6 years old or " +
                        "more than 30 years old.\nYou must enter a date between " + from + " and " + to);
                System.out.println();
            }
        }
    }

    public int getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(Scanner scan) {
        boolean isNotValid = true;
        while(isNotValid) {
            int fees = Validation.positiveIntValidation(scan);
            if(fees > 99999) {
                System.out.println("Fees cannot exceed €99,999.00");
                System.out.println();
            } else {
                this.tuitionFees = fees;
                isNotValid = false;
            }
        }
    }


    Student(int i, Scanner scan) {
        System.out.println("Name of student no." + (i + 1));
        setFirstName(scan);
        System.out.println("Surname of student " + this.firstName);
        setLastName(scan);
        System.out.println("Date of birth of student " + this.firstName + " " + this.lastName);
        setDateOfBirth(scan);
        System.out.println("Tuition fees paid of student " + this.firstName + " " + this.lastName);
        setTuitionFees(scan);
        
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////
//                  SYNTHETIC DATA METHODS    
    
    /**
     * Use only for synthetic data.
     * This constructor creates Student objects.
     * @param firstName
     * @param lastName
     * @param dateOfBirth
     * @param tuitionFees 
     */
    Student(String firstName, String lastName, String dateOfBirth, int tuitionFees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = Validation.StringDate_to_LocalDate(dateOfBirth);
        this.tuitionFees = tuitionFees;
    }

}
