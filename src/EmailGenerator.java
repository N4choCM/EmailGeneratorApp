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

    public EmailGenerator(){

        this.sFullName = setFullName();

        this.sDepartment = setDepartment();

        this.sPassword = generateRandomPassword(iDefaultPasswordLength);

        sEmail = sFullName.toLowerCase() + "@" + sDepartment + "." + sCompanySuffix;

        setAlternateEmail();

        System.out.println(showInfo());

        changePassword();

    }

    /**
     * Method that sets the First Name, the Last Name and the Full Name of the new worker.
      * @return A String concatenation with the First Name and the Last Name.
     * @author Nacho Campos Martí
     * @since 15/09/2022
     */
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

    /**
     * Method that establishes the department of the worker. This will be used when creating the new email address.
      * @return A String with the reference of the department.
     * @author Nacho Campos Martí
     * @since 15/09/2022
     */
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

    /**
     * Method that generates a random password for the worker's account.
     * @param iLength Directly connected to the param iDefaultPasswordLength, which has been set by default to 30.
     *                It will be the number of characters that the random password will have.
     * @return A String with the random password.
     * @author Nacho Campos Martí
     * @since 15/09/2022
     */
    private String generateRandomPassword(int iLength){
        String sPasswordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_-/!@#~$%";
        char[] cPassword = new char[iLength];

        for (int i = 0; i < iLength; i++){
            int iRandom = (int)(Math.random() * sPasswordSet.length());
            cPassword[i] = sPasswordSet.charAt(iRandom);
        }
        return new String(cPassword);
    }

    /**
     * Method that sets the Mailbox Capacity. It is not used since it has been set 1 GB by default, but the method
     * exists in case it would be necessary to change this capacity in the future.
     * @param iMailBoxCapacity Directly connected to this.iMailBoxCapacity, which has been set by default to 1 GB.
     * @author Nacho Campos Martí
     * @since 15/09/2022
     */
    public void setMailBoxCapacity(int iMailBoxCapacity){
        this.iMailBoxCapacity = iMailBoxCapacity;
    }

    /**
     * Method that asks the user to set an alternative email address.
     * @author Nacho Campos Martí
     * @since 15/09/2022
     */
    public void setAlternateEmail() {
        System.out.println("\nPlease, enter an alternative email address: ");
        Scanner alternateEmail = new Scanner(System.in);
        String sAlternateEmail = alternateEmail.next().replace(" ", "");

        this.sAlternateEmail = sAlternateEmail;
    }

    /**
     * Method that converts the random generated password into a new one introduced by the user.
     * @author Nacho Campos Martí
     * @since 15/09/2022
     */
    public void changePassword(){
        System.out.println("\nPlease, you must change your password immediately for security purposes: ");
        Scanner password = new Scanner(System.in);
        String sPassword = password.next().replace(" ", "");
        this.sPassword = sPassword;
        System.out.println("\nYour new password is: " + sPassword);
    }

    /**
     * Method that shows to the user his/her personal information.
     * @return String with his/her personal information.
     * @author Nacho Campos Martí
     * @since 15/09/2022
     */
    public String showInfo(){
        return "\nFull name: " + sFirstName + " " + sLastName +
                "\nCompany email: " + sEmail +
                "\nAlternate email: " + sAlternateEmail +
                "\nMailbox capacity: " + iMailBoxCapacity + " " + "GB" +
                "\nYour automatically generated password is: " + sPassword;
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
}
