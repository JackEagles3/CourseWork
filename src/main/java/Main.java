import org.sqlite.SQLiteConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

    private static Connection db = null;
    private static int MaxUserID;

    public static void main(String[] args) {

        // Opens Database
        openDatabase("Inventory Database.db");

        //Code for manipulating the data in the database
        InnerJoinDatabase();

        //Closes Database
        closeDatabase();
    }


    private static void ReadDatebase() {

        try {
            //Selects all data from the database
            PreparedStatement ps = db.prepareStatement("SELECT * FROM Inventory");


            //Outputs all the data from the database
            ResultSet results = ps.executeQuery();
            int UserID = 0;
            String UserName;
            while (results.next()) {
                UserID = results.getInt(1);
                UserName = results.getString(2);

                System.out.println(UserID + " " + UserName);

            }

            MaxUserID = UserID;
        } catch (Exception e) {

            System.out.println("Database error:" + e);

        }

    }

    private static void WriteToDatabase(String UserName) {

        try {

            //Lets you insert into the Login table
            PreparedStatement ps = db.prepareStatement("INSERT INTO LogIn (UserID, UserName) VALUES (?, ?)");
            MaxUserID++;

            //Sets the values of the columns(UserID and UserName
            ps.setInt(1, MaxUserID);
            ps.setString(2, UserName + MaxUserID);

            ps.executeUpdate();


        } catch (Exception e) {
            System.out.println("Database error:" + e);
        }

    }

    private static void UpdateDatabase() {

        try {
            String UserName = "Dan";
            //Lets you insert into the Login table
            PreparedStatement ps = db.prepareStatement("UPDATE LogIn SET UserName='Dan' WHERE UserID=0");





        } catch (Exception e) {
            System.out.println("Database Update error:" + e);
        }

    }

    private static void DeleteFromDatabase() {
        try {

            //Lets you delete from the Login table
            PreparedStatement ps = db.prepareStatement("DELETE FROM LogIn WHERE UserID=" + MaxUserID);
            MaxUserID--;
            ps.executeUpdate();


        } catch (Exception e) {
            System.out.println("Database error:" + e);
        }
    }

    private static void InnerJoinDatabase(){
        try{

            PreparedStatement ps = db.prepareStatement("SELECT Inventory.ID, Inventory.NAME, LogIn.UserName From Inventory INNER JOIN LogIn ON Inventory.RoleID=LogIn.RoleID where LogIn.RoleID = 2");

            ResultSet results = ps.executeQuery();
            int ID = 0;
            String UserName;
            String Name;
            while (results.next()) {
                ID = results.getInt(1);
                Name = results.getString(2);
                UserName = results.getString(3);

                System.out.println(ID + " " + UserName + " " + Name);

            }


        } catch (Exception e){
            System.out.println("Database error:" + e);
        }


    }


    private static void openDatabase(String dbFile) {

        //Creates a connection to the database
        try {
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            db = DriverManager.getConnection("jdbc:sqlite:resources/" + dbFile, config.toProperties());
            System.out.println("Successful Connection");


            //Catches any errors from connecting to the database
        } catch (Exception e) {
            System.out.println("Connection error: " + e);
        }


    }

    private static void closeDatabase() {

        //Disconnects the database
        try {

            db.close();
            System.out.println("Successful Disconnection");


            //Catches any errors from disconnecting the database
        } catch (Exception e) {
            System.out.println("Disconnection error: " + e);

        }
    }


}


