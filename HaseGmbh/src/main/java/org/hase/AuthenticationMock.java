package org.hase;


import org.hase.interfaces.IAuthentication;
import org.hase.model.Account;

import java.io.*;
import java.util.ArrayList;

public class AuthenticationMock implements IAuthentication {
    private static AuthenticationMock instance;
    private ArrayList<Account> accountList;

    private AuthenticationMock() {
        this.accountList = new ArrayList<>();
        readAccountsFromFile();
    }

    public static AuthenticationMock getInstance() {
        // Wenn die Instanz noch nicht erstellt wurde, erstelle sie
        if (instance == null) {
            instance = new AuthenticationMock();
        }
        // Gib die Instanz zurück
        return instance;
    }

    public boolean addAccount(String username, String password, String email) {
        return true;
    }

    public boolean authenticate(String username, String password) {
        return true;
    }

    public boolean changePassword(String username, String password, String newPassword){
        return true;
    }

    public boolean resetPassword(String username){
        return true;
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
        AuthenticationMock authentication = AuthenticationMock.getInstance();

        // Accounts hinzufügen
        authentication.addAccount("Benutzer1", "Passwort1", "Benutzer1@haseGmbH.de");
        authentication.addAccount("Benutzer2", "Passwort2", "Benutzer2@haseGmbH.de");

        // Login-Versuche
        authentication.authenticate("Benutzer1", "Passwort1"); // Erfolgreich
        authentication.authenticate("Benutzer2", "FalschesPasswort"); // Fehlerhaft
        authentication.authenticate("UnbekannterBenutzer", "IrgendeinPasswort"); // Fehlerhaft
    }
}
