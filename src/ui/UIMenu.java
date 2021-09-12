/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import access.PlayerDAO;
import java.util.Scanner;
import model.PlayerModel;

/**
 *
 * @author saabr
 */
public class UIMenu {
    public static void showMenu(){
        System.out.println("Welcome to Millionaire!");
        System.out.println("Select the desired option:");
        
        int response = 0;
        do {
            System.out.println("1. Play");
            System.out.println("2. View game history ");
            System.out.println("0. Exit");
            
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            
            switch(response){
                case 1: 
                    response = 0;
                    
                    System.out.println("Let's play!");
                    PlayerModel player = addPlayer();
                    UIPlay.startGame(player);
                    break;
                    
                case 2: 
                    response = 0;
                    
                    System.out.println("Game history:");
                    UIHistory.showHistory();
                    break;
                    
                case 0:
                    System.out.println("Thank you for playing!");
                    break;
                    
                default:
                    System.out.println("Please select a correct answer");
            }
            
        } while (response != 0);
        
    }
    
    public static PlayerModel addPlayer(){
        System.out.println("Insert your name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        
        PlayerModel playerModel = new PlayerModel(name);  
        PlayerDAO playerDAO = new PlayerDAO();
        playerDAO.addPlayer(playerModel);
        
        return playerModel;
    }
}
