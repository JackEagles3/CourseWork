import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LogIn_Controller {

    public  static void ShowUsers(){

        try{
            //Selects all data from the database
            PreparedStatement ps = Main.db.prepareStatement("SELECT * FROM LogIn");


            //Outputs all the data from the database
            ResultSet results = ps.executeQuery();
            int UserID = 0;
            String UserName;
            String Pass;
            String RoleName;
            System.out.println("UserID,UserName,Password,RoleName");
            while (results.next()){
                UserID = results.getInt(1);
                UserName = results.getString(2);
                Pass = results.getString(3);
                RoleName = results.getString(4);
                System.out.println(UserName + "," + Pass + "," + RoleName);

            }


        }catch (Exception e){

            System.out.println("Database error:" + e);

        }

    }

    public static void WriteToDatabase(String UserName, String Password, String RoleName){

        try{

            //Lets you insert into the Login table
            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO LogIn (UserName, Password, RoleName) VALUES (?,?,?)");


            //Sets the values of the columns(UserID and UserName

            ps.setString(1, UserName);
            ps.setString(2, Password);
            ps.setString(3, RoleName);

            ps.executeUpdate();


        }catch (Exception  e){
            System.out.println("Database error:" + e);
        }

    }

    /** @noinspection unused*/
    public static void UpdateDatabase(String Password, int UserId ){

        try{

            //Lets you insert into the Login table
            PreparedStatement ps = Main.db.prepareStatement("UPDATE LogIn SET  Password = ? WHERE UserID=?");


            ps.setString(1, Password);
            ps.setInt(2, UserId);

            ps.executeUpdate();


        }catch (Exception  e){
            System.out.println("Database Update error:" + e);
        }

    }

    public static void DeleteFromDatabase(int UserID){
        try{

            //Lets you delete from the Login table
            PreparedStatement ps = Main.db.prepareStatement("DELETE FROM LogIn WHERE UserID = ?");


            ps.setInt(1,UserID);
            ps.executeUpdate();


        }catch (Exception  e){
            System.out.println("Database error:" + e);
        }
    }







}
