import java.util.Scanner;

public class EmailGenerator {
    private String sFirstName;
    private String sLastName;
    private String sFullName;
    private String sPassword;
    private String sDepartment;
    private String sEmail;
    private int iMailBoxCapacity = 1;
    private int iDefaultPasswordLength = 30;
    private String sAlternateEmail;
    private String sCompanySuffix = "codingschool.com";

    // Constructor that receives the first and last names.
    public EmailGenerator(){

        this.sFullName = setFullName();

        // Call a method asking for the department - return the department.
        this.sDepartment = setDepartment();

        // Call a method returning a random password.
        this.sPassword = generateRandomPassword(iDefaultPasswordLength);

        // Combine elements to generate Email address.
        sEmail = sFullName.toLowerCase() + "@" + sDepartment + "." + sCompanySuffix;

        setAlternateEmail();

        System.out.println(showInfo());

        changePassword();

    }

    //Ask for the name
    private String setFullName(){
        System.out.println("Please, enter your first name: ");
        Scanner firstName = new Scanner(System.in);
        String sFirstName = firstName.next().replace(" ", "");
        this.sFirstName = sFirstName;

        System.out.println("\nPlease, enter your last name/s: ");
        Scanner lastName = new Scanner(System.in);
        String sLastName = lastName.next().replace(" ", "");
        this.sLastName = sLastName;

        return sFirstName + sLastName;
    }

    // Ask for the department
    private String setDepartment(){
        System.out.println("\nWelcome to Coding School! You will find below our Department Codes." +
                "\n----------------------------------------------------------------------------" +
                "\n" +
                "\n1 for Back-End" +
                "\n2 for Front-End" +
                "\n3 for Full-Stack" +
                "\n4 for none" +
                "\n\n----------------------------------------------------------------------------" +
                "\n" +
                "\nPlease, enter your department code: ");
        Scanner code = new Scanner(System.in);
        int iDepartmentCode = code.nextInt();

        return iDepartmentCode == 1 ? "back" : iDepartmentCode == 2 ? "front" : iDepartmentCode == 3 ? "fs" : "general";
    }

    private String generateRandomPassword(int iLength){
        String sPasswordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_-/!@#~$%";
        char[] cPassword = new char[iLength];

        for (int i = 0; i < iLength; i++){
            int iRandom = (int)(Math.random() * sPasswordSet.length());
            cPassword[i] = sPasswordSet.charAt(iRandom);
        }
        return new String(cPassword);
    }

    public void setMailBoxCapacity(int iMailBoxCapacity){
        this.iMailBoxCapacity = iMailBoxCapacity;
    }

    public void setAlternateEmail() {
        System.out.println("\nPlease, enter an alternative email address: ");
        Scanner alternateEmail = new Scanner(System.in);
        String sAlternateEmail = alternateEmail.next().replace(" ", "");

        this.sAlternateEmail = sAlternateEmail;
    }

    public void changePassword(){
        System.out.println("\nPlease, you must change your password immediately for security purposes: ");
        Scanner password = new Scanner(System.in);
        String sPassword = password.next().replace(" ", "");
        this.sPassword = sPassword;
        System.out.println("\nYour new password is: " + sPassword);
    }

    public String getPassword() {
        return sPassword;
    }

    public int getMailBoxCapacity() {
        return iMailBoxCapacity;
    }

    public String getAlternateEmail() {
        return sAlternateEmail;
    }

    public String showInfo(){
        return "\nFull name: " + sFirstName + " " + sLastName +
                "\nCompany email: " + sEmail +
                "\nAlternate email: " + sAlternateEmail +
                "\nMailbox capacity: " + iMailBoxCapacity + " " + "GB" +
                "\nYour automatically generated password is: " + sPassword;
    }
}
