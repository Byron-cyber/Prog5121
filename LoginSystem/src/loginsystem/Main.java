package loginsystem;

import loginsystem.Login; // Import the Login class
import javax.swing.JOptionPane; // Import the JOptionPane class

public class Main {

    public static void main(String[] args) {

        String firstname, lastname, username, password, phone;

        // Prompt and receive user inputs
        String registrationMessage = "-----------Register-----------";
        JOptionPane.showMessageDialog(null, registrationMessage);

        // Get user inputs via JOptionPane
        firstname = JOptionPane.showInputDialog("Enter First Name: ");
        lastname = JOptionPane.showInputDialog("Enter Last Name: ");
        username = JOptionPane.showInputDialog("Enter username: ");
        password = JOptionPane.showInputDialog("Enter Password: ");
        phone = JOptionPane.showInputDialog("Enter Phone Number (starting with South African international code (+27)): ");

        Login login = new Login(); // Instantiate Login object

        boolean validatePhone = login.checkCellPhoneNumber(phone);
        boolean validateUsername = login.checkUserName(username);
        boolean validatePassword = login.checkPasswordComplexity(password);

        // Check and validate username
        if (validateUsername) {
            JOptionPane.showMessageDialog(null, "Username successfully captured.");
        } else {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted. Please ensure that your username contains an underscore and is not more than five characters in length.");
        }

        // Check and validate password
        if (validatePassword) {
            JOptionPane.showMessageDialog(null, "Password successfully captured.");
        } else {
            JOptionPane.showMessageDialog(null, "Password is incorrect. Please ensure that the password contains at least eight characters, a capital and small letter, a number, and a special character.");
        }

        // Check and validate phone number
        if (validatePhone) {
            JOptionPane.showMessageDialog(null, "Cellphone number successfully added.");
        } else {
            JOptionPane.showMessageDialog(null, "Cellphone number is incorrectly formatted or does not contain the international code.");
        }

        // If all validations pass, continue to login
        if (validateUsername && validatePassword && validatePhone) {
            JOptionPane.showMessageDialog(null, "You have registered successfully!");

            String loginUsername = JOptionPane.showInputDialog("Enter username: ");
            String loginPassword = JOptionPane.showInputDialog("Enter password: ");

            if (loginUsername.equals(username) && loginPassword.equals(password)) {
                JOptionPane.showMessageDialog(null, "Welcome " + firstname + " " + lastname + ", it is great to see you again.");
            } else {
                JOptionPane.showMessageDialog(null, "Login failed! Wrong username or password.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Failed to register.");
        }
    }
}

