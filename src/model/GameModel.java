/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author saabr
 */
public class GameModel {
    private int gamId;
    private Date gamDate;       

    public GameModel(Date gamDate) {        
        this.gamDate = gamDate;        
    }
    
    public GameModel(int gamId, Date gamDate) {  
        this.gamId = gamId;
        this.gamDate = gamDate;        
    }

    public int getGamId() {
        return gamId;
    }  
    
    public String getGamDateFormat() {
        String tempDate = this.gamDate.toString();
        return tempDate.substring(4,10) + " " + tempDate.substring(24, 28)
                            + " " + tempDate.substring(12,19);
    }
    
    public void setGamDate(Date gamDate) {
        this.gamDate = gamDate;
    }

    public Date getGamDate() {
        return gamDate;
    }
    
    
}
