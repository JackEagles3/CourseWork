import org.sqlite.SQLiteConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

    public static Connection db = null;

    public static void main(String[] args) {

        // Opens Database
        openDatabase("Inventory Database.db");

        //Code for manipulating the data in the database

        PurchaseOrderDetails_Controller.ReadPurchasesOrderDetails();

        closeDatabase();



    }



 private static void openDatabase(String dbFile){

        //Creates a connection to the database
        try{
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            db = DriverManager.getConnection("jdbc:sqlite:resources/" + dbFile, config.toProperties());
            System.out.println("Successful Connection");


        //Catches any errors from connecting to the database
        }catch (Exception e){
            System.out.println("Connection error: " + e);
        }


    }

    private static void closeDatabase(){

        //Disconnects the database
        try{

            db.close();
            System.out.println("Successful Disconnection");



        //Catches any errors from disconnecting the database
        }catch (Exception e){
            System.out.println("Disconnection error: " + e);

        }
    }


}
