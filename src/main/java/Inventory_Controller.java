import sun.java2d.cmm.lcms.LcmsServiceProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Inventory_Controller {


    public  static void ReadDatebase() {

        try {
            //Selects all data from the database
            PreparedStatement ps = Main.db.prepareStatement("SELECT * FROM Inventory");


            //Outputs all the data from the database
            ResultSet results = ps.executeQuery();
            int ItemID = 0;
            String Name;
            Double Price;
            String RoleName;
            String Location;
            int quantity;
            System.out.println("ItemID,Name,Price,Location,Quantity,RoleName");
            while (results.next()) {
                ItemID = results.getInt(1);
                Name = results.getString(2);
                Price = results.getDouble(3);
                RoleName = results.getString(6);
                Location = results.getString(4);
                quantity = results.getInt(5);

                System.out.println(ItemID + "," + Name + "," + Price + "," + Location + "," + quantity + "," + RoleName);

            }


        } catch (Exception e) {

            System.out.println("Database error:" + e);

        }
    }

        public static void AddItem( String ItemName, Double Price, String Location, int Quantity, String RoleName  ){

            try{

                //Lets you insert into the Login table
                PreparedStatement ps = Main.db.prepareStatement("INSERT INTO Inventory (Name,Price,Location,Quantity,RoleName) VALUES (?,?,?,?,?)");


                //Sets the values of the columns

                ps.setString(1, ItemName);
                ps.setDouble(2, Price);
                ps.setString(3, Location);
                ps.setInt(4, Quantity);
                ps.setString(5, RoleName);




                ps.executeUpdate();


            }catch (Exception  e){
                System.out.println("Database error:" + e);
            }

        }
    }

