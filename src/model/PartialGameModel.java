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
public class PartialGameModel {    
    private int pagWonRound;
    
    private int pagPlaId;
    private int pagGamId;
    private int pagRouId;
    
    public PartialGameModel(int pagWonRound, int pagPlaId, int pagGamId, 
                                                                int pagRouId) {        
        this.pagWonRound = pagWonRound;
        this.pagPlaId = pagPlaId;
        this.pagGamId = pagGamId;
        this.pagRouId = pagRouId;
    }

    /**
     * @return the pagWonRound
     */
    public int isPagWonRound() {
        return pagWonRound;
    }

    /**
     * @param pagWonRound the pagWonRound to set
     */
    public void setPagWonRound(int pagWonRound) {
        this.pagWonRound = pagWonRound;
    }

    /**
     * @return the pagPlaId
     */
    public int getPagPlaId() {
        return pagPlaId;
    }

    /**
     * @return the pagGamId
     */
    public int getPagGamId() {
        return pagGamId;
    }

    /**
     * @return the pagRouId
     */
    public int getPagRouId() {
        return pagRouId;
    }
    
    
}
