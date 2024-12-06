//import java.util.ArrayList;
import java.sql.*;

public class Function1 {
    //ArrayList<Toner> toner;
    //Function1(){
    //    toner = new ArrayList<>();
    private static final String url = "jdbc:mysql://localhost:3306/toner_inventory";
    private static final String username = "root";
    private static final String password = "";

    void addToner(String tonerName){
        //toner.add(new Toner(description));
        String query = "INSERT INTO toners (toner_name, is_used) VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setString (1, tonerName);
            statement.setBoolean (2, false);
            statement.executeUpdate();
            System.out.println("Toner added successfully!");

        } catch (SQLException e){
            e.printStackTrace();
        }

        }
    
    void viewToner(){
        //if(toner.isEmpty()){
        //   System.out.println("No Toner Listed");
        //}
        //else{
        //    for(int i = 0; i < toner.size(); i++){
        //        System.out.println((i + 1) + ". " + toner.get(i));
        //    }
        //}
        String query = "SELECT * FROM toners";
        try (Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery()){

            if(!resultSet.next()){
                System.out.println("No toner listed");
            }
            else{
                do{
                    int id = resultSet.getInt("id");
                    String tonerName = resultSet.getString("toner_name");
                    boolean isUsed = resultSet.getBoolean("is_used");
                    System.out.println(id + ". " + (isUsed ? "[Used] " : "[Unused] ") + tonerName);
                    
                } while (resultSet.next());
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    
    }
    void markTonerAsUsed(int index){
        //if(index > 0 || index < toner.size()){
        //    toner.get(index - 1).markAsUsed();
        //}
        //else{
        //    System.out.println("Invalid input!");
        //}
        String query = "UPDATE toners SET is_used = TRUE WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement statement = connection.prepareStatement(query);)
        {

            statement.setInt(1, index);
            int rowsUpdated = statement.executeUpdate();

            if(rowsUpdated > 0){
                System.out.println("Toner marked successfully");
            }
            else{
                System.out.println("Invalid toner ID");
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    
    }
    void removeToner(int index){
        String query = "DELETE FROM toners WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement statement = connection.prepareStatement(query);){

            statement.setInt(1,index);
            int rowsUpdated = statement.executeUpdate();

            if(rowsUpdated > 0){
                System.out.println("Toner removed successfully!");
            }
            else{
                System.out.println("Invalid toner ID!");
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
