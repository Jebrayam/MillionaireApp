/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import model.PlayerModel;
import utils.ConnectionDB;

/**
 *
 * @author saabr
 */
public class PlayerDAO {
    private Connection conn = null;
    
    public ArrayList<PlayerModel> getPlayers(){
        ArrayList<PlayerModel> players = new ArrayList<>();
        
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            
            String sql = "select pla_id, pla_name from player;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()){
                PlayerModel player = new PlayerModel(result.getInt(1),
                                                     result.getString(2));
                players.add(player);
                        
            }
        }
        catch(SQLException ex){}
        
        return players;
    }
    
    public void addPlayer(PlayerModel player){
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            
            String sql = "insert into player(pla_name) values(?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, player.getName());
            int rowsInserted = statement.executeUpdate();
            
            if(rowsInserted > 0){
//                System.out.println("Player added");
            } else{
                System.out.println("No added");
            }
                        
        }
        catch(SQLException ex){}
    }
    
}
