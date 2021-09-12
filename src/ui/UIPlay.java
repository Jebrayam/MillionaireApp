/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Date;
import model.GameModel;
import access.GameDAO;
import access.OptionDAO;
import access.PartialGameDAO;
import access.PlayerDAO;
import access.QuestionDAO;
import access.RoundDAO;
import java.util.ArrayList;
import java.util.Scanner;
import model.OptionModel;
import model.PartialGameModel;
import model.PlayerModel;
import model.QuestionModel;
import model.RoundModel;

/**
 *
 * @author saabr
 */
public class UIPlay {
    public static void startGame(PlayerModel player){  
        int currentRound = 1;
        double tempReward = 0.0;
        
        Date date = new Date();
        GameModel game = new GameModel(date);
        GameDAO gameDAO = new GameDAO();
        gameDAO.addGame(game);
        
        PlayerDAO playerDAO = new PlayerDAO();
        ArrayList<PlayerModel> currentPlayers = playerDAO.getPlayers();
        PlayerModel lastPlayer = currentPlayers.get(currentPlayers.size()-1);
        ArrayList<GameModel> currentGames = gameDAO.getGames();
        GameModel lastGame = currentGames.get(currentGames.size()-1);
                
        do {                        
            RoundDAO roundDAO = new RoundDAO();
            RoundModel roundModel = roundDAO.getRound(currentRound);            
            
            PartialGameModel partialGameModel = new PartialGameModel(0, 
                                                lastPlayer.getId(),
                                                lastGame.getGamId(), 
                                                roundModel.getRouId());
            
            System.out.println("--> Round " + roundModel.getRouId() + ": " +
                                               roundModel.getRouCategoryName());
            
            QuestionDAO questionDAO = new QuestionDAO();
            ArrayList<QuestionModel> questionModel = 
                           questionDAO.getQuestionsRound(roundModel.getRouId());
            int idx = (int)(Math.random()*questionModel.size());
            QuestionModel question = questionModel.get(idx);            
            System.out.println("\t" + 
                                question.getQueQuestionText());
            
            OptionDAO optionDAO = new OptionDAO();
            ArrayList<OptionModel> optionModel = optionDAO.getOptionQuestion(
                                                    question.getQueId());
            for (int i = 0; i < optionModel.size(); i++) {
                System.out.println("\t\t" + toLetter(i+1) + ") " +
                                        optionModel.get(i).getOptOptionText());                
            }    
            System.out.println("g) Give up");
            
            int idxAnswer = 0;
            do {
                System.out.print("Your answer: ");
                Scanner sc = new Scanner(System.in);
                String answer = sc.nextLine();
                idxAnswer = toNumber(answer);
                
            } while (idxAnswer == 0);
            
            if(idxAnswer == -1){
                PartialGameDAO partialGameDAO = new PartialGameDAO();
                partialGameDAO.addPartialGame(partialGameModel);
                System.out.println("You have given up! Your reward is $" +
                        tempReward);
                System.out.println("");
                break;
            }
            
            OptionModel pickedOption = optionModel.get(idxAnswer-1);
            if(pickedOption.isOptCorrectOption() == 1){
                partialGameModel.setPagWonRound(1);
                PartialGameDAO partialGameDAO = new PartialGameDAO();
                partialGameDAO.addPartialGame(partialGameModel);
                
                System.out.println("Rigth!! You won $" + 
                                    roundModel.getRouReward() + "!!");
                tempReward += roundModel.getRouReward();
                System.out.println("You have $" + tempReward);
                
                if(currentRound == 5){
                    System.out.println("Congratulations!! "
                            + "You are Millionaire! Your reward is $" + 
                            tempReward);
                }
            }else{
                PartialGameDAO partialGameDAO = new PartialGameDAO();
                partialGameDAO.addPartialGame(partialGameModel);
                partialGameDAO.updatePartialGame(lastGame.getGamId(), 0);
                System.out.println("Wrong answer! "
                        + "Sorry, you lose your reward!");
                System.out.println("");
                break;
            }                        
            
            System.out.println("");
            currentRound++;
            
        } while (currentRound < 6);                
      
        UIMenu.showMenu();
    }
    
    private static String toLetter(int num){
        String let = null;
        switch(num){
            case 1:
                let = "a";
                break;
            case 2:
                let = "b";
                break;
            case 3:
                let = "c";
                break;
            case 4:
                let = "d";
                break;
                
        }
        
        return let;
    }
    
    private static int toNumber(String let){
        int num;
        switch(let){
            case "a":
                num = 1;
                break;
            case "b":
                num = 2;
                break;
            case "c":
                num = 3;
                break;
            case "d":
                num = 4;
                break;
            case "g":
                num = -1;
                break;
            default:
                System.out.println("Pick a valid option!");
                num = 0; 
                
        }
        
        return num;
    }
}
