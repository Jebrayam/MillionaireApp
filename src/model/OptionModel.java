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
public class OptionModel {
    private int optId;
    private String optOptionText;
    private int optCorrectOption;
    
    private int optQueId;

    public OptionModel(int optId, String optOptionText,
                                       int optCorrectOption, int optQueId) {
        this.optId = optId;
        this.optOptionText = optOptionText;
        this.optCorrectOption = optCorrectOption;
        this.optQueId = optQueId;
    }

    public int getOptId() {
        return optId;
    }

    public String getOptOptionText() {
        return optOptionText;
    }

    public int isOptCorrectOption() {
        return optCorrectOption;
    }

    public int getOptQueId() {
        return optQueId;
    }
    
    
}
