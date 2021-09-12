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
public class RoundModel {
    private int rouId;    
    private String rouCategoryName;
    private double rouReward;

    public RoundModel(int rouId, String rouCategoryName, double rouReward) {
        this.rouId = rouId;
        this.rouCategoryName = rouCategoryName;
        this.rouReward = rouReward;
    }

    public int getRouId() {
        return rouId;
    }

    public String getRouCategoryName() {
        return rouCategoryName;
    }

    public double getRouReward() {
        return rouReward;
    }
    
    
    
}
