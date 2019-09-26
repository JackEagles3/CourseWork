import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SalesOrderDetails_Controller {

    public  static void ReadSalesOrderDetails(){

        try{
            //Selects all data from the database
            PreparedStatement ps = Main.db.prepareStatement("SELECT * FROM [Sales Order Details]");


            //Outputs all the data from the database
            ResultSet results = ps.executeQuery();




            while (results.next()){
                int SaleId = results.getInt(1);
                int ItemID = results.getInt(2);
                int Quantity = results.getInt(3);
                double Price = results.getDouble(4);
                System.out.println(SaleId + " "+ ItemID + " " + Quantity + " " + Price);

            }


        }catch (Exception e){

            System.out.println("Database error:" + e);

        }

    }

    public static void AddSaleOrderDetail(int SaleID, int ItemID, int Quantity, double Price){

        try{

            //Lets you insert into the [Sales Order Details] table
            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO [Sales Order Details] (SaleID,ItemID, Quantity, Unit Price) VALUES (?,?,?,?)");


            //Sets the values of the columns(UserID and UserName

            ps.setInt(1, SaleID);
            ps.setInt(2, ItemID);
            ps.setInt(3, Quantity);
            ps.setDouble(4, Price);


            ps.executeUpdate();


        }catch (Exception  e){
            System.out.println("Database error:" + e);
        }

    }

    public static void UpdateSalesOrderDetails(int SaleID, int ItemID, int Quantity, double Price){

        try{

            //Lets you insert into the [Sales Order Details] table
            PreparedStatement ps = Main.db.prepareStatement("UPDATE [Sales Order Details] SET  ItemID=?, Quantity=?, Unit Price=? WHERE SaleID=?");



            ps.setInt(1, ItemID);
            ps.setInt(2, Quantity);
            ps.setDouble(3, Price);
            ps.setInt(4, SaleID);

            ps.executeUpdate();


        }catch (Exception  e){
            System.out.println("Database Update error:" + e);
        }

    }

    public static void DeleteSalesOrderDetails(int SaleID){
        try{

            //Lets you delete from the [Sales Order Details] table
            PreparedStatement ps = Main.db.prepareStatement("DELETE FROM [Sales Order Details] WHERE SaleID = ?");

            ps.setInt(SaleID,1);

            ps.executeUpdate();


        }catch (Exception  e){
            System.out.println("Database error:" + e);
        }
    }


}
