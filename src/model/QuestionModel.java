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
public class QuestionModel {
    private int queId;
    private String queQuestionText;
    
    private int queCatId;

    public QuestionModel(int queId, String queQuestionText, int queCatId) {
        this.queId = queId;
        this.queQuestionText = queQuestionText;
        this.queCatId = queCatId;
    }

    public int getQueId() {
        return queId;
    }

    public String getQueQuestionText() {
        return queQuestionText;
    }

    public int getQueCatId() {
        return queCatId;
    }
    
    
}
