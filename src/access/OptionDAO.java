/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.OptionModel;
import utils.ConnectionDB;


/**
 *
 * @author saabr
 */
public class OptionDAO {
    private Connection conn = null;
    
    public ArrayList<OptionModel> getOptionQuestion(int queId){
        ArrayList<OptionModel> options = new ArrayList<>();
        
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            
            String sql = "select opt_id, opt_optionText, opt_correctOption, "
                    + "opt_que_id from optionT "
                    + "where opt_que_id = " + queId + ";";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()){
                OptionModel option = new OptionModel(result.getInt(1), 
                                                     result.getString(2),
                                                     result.getInt(3),
                                                     result.getInt(4));
                options.add(option);
                        
            }
        }
        catch(SQLException ex){}
        
        return options;
    }
}
