/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.RoundModel;
import utils.ConnectionDB;

/**
 *
 * @author saabr
 */
public class RoundDAO {
    private Connection conn = null;
    
    public RoundModel getRound(int rouId){
        RoundModel roundModel = null;
        
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            
            String sql = "select rou_id, rou_category, rou_reward "
                    + "from roundT where rou_id=" +
                    rouId + ";";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()){
                roundModel = new RoundModel(result.getInt(1),
                                            result.getString(2),
                                            result.getDouble(3));
                break;
            }
        }
        catch(SQLException ex){}
        return roundModel;
    }
}
