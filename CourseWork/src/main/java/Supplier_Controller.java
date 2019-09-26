import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Supplier_Controller {

    public  static void ReadSalesOrderDetails(){

        try{
            //Selects all data from the database
            PreparedStatement ps = Main.db.prepareStatement("SELECT * FROM [Supplier]");


            //Outputs all the data from the database
            ResultSet results = ps.executeQuery();

            while (results.next()){

                int SupplierID = results.getInt(1);
                String SupplierName = results.getString(2);
                int ItemID = results.getInt(3);
                double price = results.getDouble(4);
                System.out.println(SupplierID + " "+ SupplierName + " " + ItemID + " " + price);



            }


        }catch (Exception e){

            System.out.println("Database error:" + e);

        }

    }

    public static void AddSaleOrderDetail(int SupplierID, String name, int itemId, double price){

        try{

            //Lets you insert into the [Supplier] table
            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO [Supplier] (SupplierID,SupplierName,ItemID,price) VALUES (?,?,?,?)");


            //Sets the values of the columns(UserID and UserName
            ps.setInt(1,SupplierID);
            ps.setString(2,name);
            ps.setInt(3,itemId);
            ps.setDouble(4,price);

            ps.executeUpdate();


        }catch (Exception  e){
            System.out.println("Database error:" + e);
        }

    }

    public static void UpdateSalesOrderDetails(int SupplierID, String name, int itemId, double price){

        try{

            //Lets you insert into the [Supplier] table
            PreparedStatement ps = Main.db.prepareStatement("UPDATE [Supplier] SET  SupplierName = ?,  ItemID = ?, Unit Price = ? WHERE SupplierID=?");

            ps.setDouble(3,price);
            ps.setString(1,name);
            ps.setInt(2,itemId);
            ps.setInt(4,SupplierID);

            ps.executeUpdate();


        }catch (Exception  e){
            System.out.println("Database Update error:" + e);
        }

    }

    public static void DeteleSalesOrderDetails(int SupplierID){
        try{

            //Lets you delete from the [Supplier] table
            PreparedStatement ps = Main.db.prepareStatement("DELETE FROM [Supplier] WHERE SupplierID = ?");


            ps.setInt(1,SupplierID);
            ps.executeUpdate();


        }catch (Exception  e){
            System.out.println("Database error:" + e);
        }
    }

}
