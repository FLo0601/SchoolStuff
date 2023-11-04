import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter a Username: ");
                String name = sc.nextLine();
                System.out.println("Please enter a password: ");
                String pw = sc.nextLine();
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eGameDarling", "root", "TestPW");
                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery("SELECT p_acocunt_id FROM T_Accounts WHERE passwort = '" + pw + "' AND nickname = '" + name + "';");
                if(rs.wasNull()){
                    System.out.println("Login was incorrect");
                }
                else {
                    System.out.println("Login succesful!");
                }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void test(Statement st) {
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM T_Accounts");

            while (rs.next()) {
                System.out.println(rs.getString("nickname"));
            }

            st.executeUpdate("DELETE FROM T_Accounts WHERE p_account_id = 3");
            st.executeUpdate("INSERT INTO T_Accounts VALUES (3,'test3@mail.com','123', 'juser3', '')");

            String strPwd = "321";
            st.executeUpdate("UPDATE T_Accounts SET passwort='" + strPwd + "' WHERE p_account_id = 3");

            rs = st.executeQuery("SELECT * FROM T_Accounts");
            while (rs.next()) {
                System.out.println(rs.getString("nickname") + " , " + rs.getString("passwort"));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}