package com.java.minigames.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.minigames.entities.Player;
import com.java.minigames.entities.Tennis;

@Controller
public class TennisController {
	
	Player player1 = new Player("Grigor Dimitrov");
	Player player2 = new Player("Roger Federer");
	Boolean isGameContinuous = true;
	List<Player> players;
	
	@GetMapping("/tennis")
	public String getTennisPage(Model model) {		
		Tennis tennis = new Tennis(player1, player2);
		tennis.setGameName("Tennis");	
		if(players == null) {
			players = mockTests();	
		}
		String score = getScore();

		model.addAttribute("isGameContinuous", isGameContinuous);
		model.addAttribute("score", score);
		model.addAttribute("players", players);
		model.addAttribute("firstPlayer", player1.getName());
		model.addAttribute("secondPlayer", player2.getName());
		
		return "tennis";
	}
	
	@RequestMapping(value="/score", method=RequestMethod.GET)
	public String addPoint(@RequestParam("name") String name) {	
		
		if((player1.getName()).equalsIgnoreCase(name)) {
			player1.winBall();
		} else {
			player2.winBall();
		}
		getScore();
		
		return "redirect:/tennis";
	}
	
	private String getScore() {
        if (player1.getScore() >= 3 || player2.getScore() >= 3) {
            if (Math.abs(player2.getScore() - player1.getScore()) >= 2) {
            	isGameContinuous = false;
                return getLeadPlayer().getName() + " WON";
            } else if (player1.getScore() == player2.getScore()) {            	
                return "Deuce";
            } else {
                return "Advantage: " + getLeadPlayer().getName();
            }
        } else {
            return player1.getName() + ": " + player1.getScoreDescription() + ", " + player2.getName() + ": " + player2.getScoreDescription();
        }
    }

    private Player getLeadPlayer() {
        return (player1.getScore() > player2.getScore()) ? player1 : player2;
    }
    
    private List<Player> mockTests() {
    	players = new ArrayList<Player>();
//    	player1.winBall();
//    	player2.winBall();
    	
		players.add(player1);
		players.add(player2);
		
		return players;
    }
}
