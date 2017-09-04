package com.java.minigames.entities;

import java.util.Arrays;
import java.util.List;

public class Player {
	
    public static final List<String> pointsDescription = Arrays.asList("love", "fifteen", "thirty", "forty");
	
	private String name;
	private int score;
	
	public Player() {};
	
	public Player(String name) {
		this.name = name;
	}

	public void winBall() {
        this.score = this.score + 1;
    }
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}
	
    public String getScoreDescription(){
        return pointsDescription.get(score);
    }
}
