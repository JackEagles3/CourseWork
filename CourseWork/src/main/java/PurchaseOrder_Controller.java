import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PurchaseOrder_Controller {

    public  static void ReadPurchaseOrder(){

        try{
            //Selects all data from the database
            PreparedStatement ps = Main.db.prepareStatement("SELECT * FROM [Purchase Order]");


            //Outputs all the data from the database
            ResultSet results = ps.executeQuery();




            while (results.next()){
                int PurchaseId = results.getInt(1);
                PurchaseId += 1-1;
                String Date = results.getString(2);
                int UserID = results.getInt(3);
                System.out.println(PurchaseId + " "+ UserID + " " + Date);

            }


        }catch (Exception e){

            System.out.println("Database error:" + e);

        }

    }

    public static void AddPurchaseOrder(int PurchaseID ,String Date1,int UserID, int Supplier){

        try{

            //Lets you insert into the [Purchase Order] table
            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO [Purchase Order] (PurchaseID,Date,UserID,SupplierID) VALUES (?,?,?)");


            //Sets the values of the columns
            ps.setInt(1,PurchaseID);
            ps.setString(2,Date1);
            ps.setInt(3,UserID);
            ps.setInt(4,Supplier);

            ps.executeUpdate();


        }catch (Exception  e){
            System.out.println("Database error:" + e);
        }

    }

    public static void UpdatePurchaseOrder(int PurchaseID ,String Date1,int UserID, int purchaseID){

        try{

            //Lets you insert into the [Purchase Order] table
            PreparedStatement ps = Main.db.prepareStatement("UPDATE [Purchase Order] SET  Date = ?, UserID = ? WHERE PurchaseID=?");
            ps.setInt(3,PurchaseID);
            ps.setString(1,Date1);
            ps.setInt(2,UserID);
            ps.setInt(4,purchaseID);


            ps.executeUpdate();


        }catch (Exception  e){
            System.out.println("Database Update error:" + e);
        }

    }

    public static void DetelePurchaseOrder(int PurchaseID){
        try{

            //Lets you delete from the [Purchase Order] table
            PreparedStatement ps = Main.db.prepareStatement("DELETE FROM [Purchase Order] WHERE PurchaseID = ?");

            ps.setInt(1,PurchaseID);

            ps.executeUpdate();


        }catch (Exception  e){
            System.out.println("Database error:" + e);
        }
    }

}
