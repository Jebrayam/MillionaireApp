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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.GameModel;

import utils.ConnectionDB;

/**
 *
 * @author saabr
 */
public class GameDAO {
    private Connection conn = null;
    
    public ArrayList<GameModel> getGames(){
        ArrayList<GameModel> games = new ArrayList<>();
        
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            
            String sql = "select gam_id, game_date from game;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()){
                Timestamp timestamp = result.getTimestamp(2);
                Date date = new Date(timestamp.getTime());
                GameModel game = new GameModel(result.getInt(1), date);
                games.add(game);                        
            }
        }
        catch(SQLException ex){}
        
        return games;
    }
    
    public void addGame(GameModel gameModel){
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String dateF = DATE_FORMAT.format(gameModel.getGamDate());
            
            String sql = "insert into game(game_date) values(?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, dateF);
            int rowsInserted = statement.executeUpdate();
            
            if(rowsInserted > 0){
//                System.out.println("Date added");
            } else{
                System.out.println("No added");
            }
                        
        }
        catch(SQLException ex){}        
    }
}
