import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SalesOrder_Controller {

    public  static void ReadSalesOrder(){

        try{
            //Selects all data from the database
            PreparedStatement ps = Main.db.prepareStatement("SELECT * FROM [Sales Order Details]");


            //Outputs all the data from the database
            ResultSet results = ps.executeQuery();




            while (results.next()){
                int SaleId = results.getInt(1);

                int Date = results.getInt(2);
                int UserID = results.getInt(3);
                System.out.println(SaleId + " "+ UserID + " " + Date);

            }


        }catch (Exception e){

            System.out.println("Database error:" + e);

        }

    }

    public static void AddSaleOrder(int SaleID ,String Date1,int UserID){

        try{

            //Lets you insert into the [Sales Order] table
            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO [Sales Order] (SaleID,Date,UserID) VALUES (?,?,?)");


            //Sets the values of the columns
            ps.setInt(1,SaleID);
            ps.setString(2,Date1);
            ps.setInt(3,UserID);

            ps.executeUpdate();


        }catch (Exception  e){
            System.out.println("Database error:" + e);
        }

    }

    public static void UpdateSalesOrder(int SaleID ,String Date1,int UserID){

        try{

            //Lets you insert into the [Sales Order] table
            PreparedStatement ps = Main.db.prepareStatement("UPDATE [Sales Order] SET  Date = ?, UserID = ?= ? WHERE SaleID=?");
            ps.setInt(3,SaleID);
            ps.setString(1,Date1);
            ps.setInt(2,UserID);


            ps.executeUpdate();


        }catch (Exception  e){
            System.out.println("Database Update error:" + e);
        }

    }

    public static void DeteleSalesOrder(int SaleID){
        try{

            //Lets you delete from the [Sales Order] table
            PreparedStatement ps = Main.db.prepareStatement("DELETE FROM [Sales Order] WHERE SaleID = ?");

            ps.setInt(1,SaleID);

            ps.executeUpdate();


        }catch (Exception  e){
            System.out.println("Database error:" + e);
        }
    }

}
