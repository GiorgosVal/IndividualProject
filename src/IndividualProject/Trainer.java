package IndividualProject;

import java.util.Scanner;

public class Trainer {
    private String firstName;
    private String lastName;
    private String subject;

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(Scanner scan) {
        boolean isNotValid = true;
        while(isNotValid) {
            String s = Validation.namesValidation(scan);
            boolean chars = Validation.maxCharactersValidation(s, 50);
            if(chars == true) {
                this.subject = s;
                isNotValid = false;
            }
        }
    }
    
    Trainer(int i, Scanner scan) {
        System.out.println("Name of trainer no." + (i + 1));
        setFirstName(scan);
        System.out.println("Surname of trainer " + this.firstName);
        setLastName(scan);
        System.out.println("Teaching subject of trainer " + this.firstName + " " + this.lastName);
        setSubject(scan);
    }
    
    
    
    /**
     * Use only for synthetic data.
     * This constructor creates Trainer objects.
     * @param firstName
     * @param lastName
     * @param subject 
     */
    Trainer(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }
    
    
    
}
