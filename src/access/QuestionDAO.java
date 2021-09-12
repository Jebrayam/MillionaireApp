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
import model.QuestionModel;
import utils.ConnectionDB;

/**
 *
 * @author saabr
 */
public class QuestionDAO {
    private Connection conn = null;
    
    public ArrayList<QuestionModel> getQuestionsRound(int rouId){
        ArrayList<QuestionModel> questions = new ArrayList<>();
        
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            
            String sql = "select que_id, que_questionText, que_rou_id "
                    + "from question where que_rou_id= " + rouId + ";";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()){
                QuestionModel question = new QuestionModel(result.getInt(1),
                                                           result.getString(2),
                                                           result.getInt(3));
                questions.add(question);
                        
            }
        }
        catch(SQLException ex){}
        
        return questions;
    }
    
}
