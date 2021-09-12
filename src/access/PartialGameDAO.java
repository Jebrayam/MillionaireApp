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
import model.PartialGameModel;
import utils.ConnectionDB;

/**
 *
 * @author saabr
 */
public class PartialGameDAO {
    private Connection conn = null;
    
    public double getPartialGamesReward(int gamId){
        double total = 0.0;
        
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            
            String sql = "select sum(rou_reward) " +
                    " from partialG join roundT on rou_id = pag_rou_id " +
                    "where (pag_gam_id = " + gamId + " and pag_wonRound=1);";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()){   
                total = result.getDouble(1);
            }
        }
        catch(SQLException ex){}
        
        return total;
    }
    
    public void addPartialGame(PartialGameModel partialGameModel){
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            
            String sql = "insert into partialG(pag_wonRound, pag_pla_id,"
                    + "pag_gam_id, pag_rou_id) values(" + 
                    partialGameModel.isPagWonRound() + ", " + 
                    partialGameModel.getPagPlaId() + ", " + 
                    partialGameModel.getPagGamId()+ ", " + 
                    partialGameModel.getPagRouId() + ");";
            PreparedStatement statement = conn.prepareStatement(sql);            
            int rowsInserted = statement.executeUpdate();
            
            if(rowsInserted > 0){
            } else{
                System.out.println("No added");
            }
                        
        }
        catch(SQLException ex){}
    }
    
    public void updatePartialGame(int pagGameId, int pagWonRound){
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            
            String sql = "update partialG set pag_wonRound =" + pagWonRound + 
                    " where pag_gam_id = " + pagGameId + ";";
            PreparedStatement statement = conn.prepareStatement(sql);            
            int rowsInserted = statement.executeUpdate();
            
            if(rowsInserted > 0){
            } else{
                System.out.println("No added");
            }
                        
        }
        catch(SQLException ex){}
    }    
}
