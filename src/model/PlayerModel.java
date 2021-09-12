/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author saabr
 */
public class PlayerModel {
    private int plaId;
    private String plaName;

    public PlayerModel(int plaId, String plaName) { 
        this.plaId = plaId;
        this.plaName = plaName;
    }
    
    public PlayerModel(String plaName) {         
        this.plaName = plaName;
    }

    public int getId() {
        return plaId;
    }

    public String getName() {
        return plaName;
    }
    
    
}
