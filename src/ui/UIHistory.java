/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import access.GameDAO;
import access.PartialGameDAO;
import access.PlayerDAO;
import java.util.ArrayList;
import model.GameModel;

import model.PlayerModel;

/**
 *
 * @author saabr
 */
public class UIHistory {
    
    public static void showHistory(){        
        PlayerDAO playerDAO = new PlayerDAO();
        ArrayList<PlayerModel> players = playerDAO.getPlayers();
        GameDAO gameDAO = new GameDAO();
        ArrayList<GameModel> games = gameDAO.getGames();
        
        PartialGameDAO partialGameDAO = new PartialGameDAO();
        
        System.out.println("Player\t\tReward\t\tDate");        
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getName() + "\t\t"
                    + "$" + partialGameDAO.getPartialGamesReward(
                                                        games.get(i).getGamId())
                    + "\t\t" + games.get(i).getGamDateFormat());
            System.out.println("---------------------------------------------"
                    + "--------");
        }
        
        System.out.println("");
        
        UIMenu.showMenu();
    }
}
