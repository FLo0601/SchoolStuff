package org.hase;


import org.hase.model.Account;

import java.io.*;
import java.util.ArrayList;

public class Authentication {
    private static Authentication instance;
    private ArrayList<Account> accountList;

    private Authentication() {
        this.accountList = new ArrayList<>();
        readAccountsFromFile();
    }

    public static Authentication getInstance() {
        // Wenn die Instanz noch nicht erstellt wurde, erstelle sie
        if (instance == null) {
            instance = new Authentication();
        }
        // Gib die Instanz zurück
        return instance;
    }

    public boolean addAccount(String username, String password, String email) {
        Account newAccount = new Account(username, password, email);

        if (accountList.contains(newAccount))
            return false;

        accountList.add(newAccount);
        return true;
    }

    public boolean authenticate(String username, String password) {
        for (Account account : accountList) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                System.out.println("Login erfolgreich für Benutzer: " + username);
                return true;
            }
        }
        System.out.println("Fehlerhafte Anmeldeinformationen für Benutzer: " + username);
        return false;
    }

    public boolean changePassword(String username, String password, String newPassword){
        for (Account account : accountList) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                account.setPassword(newPassword);
                System.out.println("The password has been successfully changed");
                return true;
            }
        }
        System.out.println("Error: The password change failed.");
        return false;
    }

    public boolean resetPassword(String username){
        for (Account account : accountList) {
            if (account.getUsername().equals(username) ) {
                System.out.println("A password reset email has been sent to " + account.getEmail() );
                return true;
            }
        }
        System.out.println("Error: The username " + username + " doesn't exist.");
        return false;
    }

    private void readAccountsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/oszimt/accounts.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    String email = parts[2].trim();
                    Account account = new Account(username, password, email);
                    accountList.add(account);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void store() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("accounts.txt"))) {
            for (Account account : accountList) {
                bw.write(account.getUsername() + "," + account.getPassword());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Beispiel für die Verwendung der Authentifizierungsklasse
        Authentication authentication = Authentication.getInstance();

        // Accounts hinzufügen
        authentication.addAccount("Benutzer1", "Passwort1", "Benutzer1@haseGmbH.de");
        authentication.addAccount("Benutzer2", "Passwort2", "Benutzer2@haseGmbH.de");

        // Login-Versuche
        authentication.authenticate("Benutzer1", "Passwort1"); // Erfolgreich
        authentication.authenticate("Benutzer2", "FalschesPasswort"); // Fehlerhaft
        authentication.authenticate("UnbekannterBenutzer", "IrgendeinPasswort"); // Fehlerhaft
    }
}
