import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PurchaseOrderDetails_Controller {

    public  static void ReadPurchasesOrderDetails(){

        try{
            //Selects all data from the database
            PreparedStatement ps = Main.db.prepareStatement("SELECT * FROM [Purchase Orders detail]");


            //Outputs all the data from the database
            ResultSet results = ps.executeQuery();




            while (results.next()){
                int PurchaseId = results.getInt(1);
                PurchaseId += 1-1;
                int ItemID = results.getInt(2);
                int Quantity = results.getInt(3);
                double Price = results.getDouble(4);
                System.out.println(PurchaseId + " "+ ItemID + " " + Quantity + " " + Price);

            }


        }catch (Exception e){

            System.out.println("Database error:" + e);

        }

    }

    public static void AddPurchaseOrderDetail(int PurchaseID, int ItemID, int Quantity, double Price){

        try{

            //Lets you insert into the [Purchases Order Details] table
            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO [Purchases Order Details] (PurchaseID,ItemID, Quantity, Unit Price) VALUES (?,?,?,?)");


            //Sets the values of the columns(UserID and UserName

            ps.setInt(1, PurchaseID);
            ps.setInt(2, ItemID);
            ps.setInt(3, Quantity);
            ps.setDouble(4, Price);


            ps.executeUpdate();


        }catch (Exception  e){
            System.out.println("Database error:" + e);
        }

    }

    public static void UpdatePurchasesOrderDetails(int PurchaseID, int ItemID, int Quantity, double Price){

        try{

            //Lets you insert into the [Purchases Order Details] table
            PreparedStatement ps = Main.db.prepareStatement("UPDATE [Purchases Order Details] SET  ItemID=?, Quantity=?, Unit Price=? WHERE PurchaseID=?");



            ps.setInt(1, ItemID);
            ps.setInt(2, Quantity);
            ps.setDouble(3, Price);
            ps.setInt(4, PurchaseID);

            ps.executeUpdate();


        }catch (Exception  e){
            System.out.println("Database Update error:" + e);
        }

    }

    public static void DeletePurchasesOrderDetails(int PurchaseID){
        try{

            //Lets you delete from the [Purchases Order Details] table
            PreparedStatement ps = Main.db.prepareStatement("DELETE FROM [Purchases Order Details] WHERE PurchaseID = ?");

            ps.setInt(PurchaseID,1);

            ps.executeUpdate();


        }catch (Exception  e){
            System.out.println("Database error:" + e);
        }
    }


}

