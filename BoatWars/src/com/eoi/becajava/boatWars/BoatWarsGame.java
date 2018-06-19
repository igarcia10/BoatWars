package com.eoi.becajava.boatWars;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BoatWarsGame {
	
	private static int x=10;
	private static int y=10;
	private static int SBoats=4;
	private static int MBoats=3;
	private static int LBoats=2;
	private static String solutionPath = "C:\\Users\\kiler\\git\\BoatWars\\BoatWars\\src\\com\\eoi\\becajava\\boatWars\\solution.txt";
	private static TablePosition[][] gameBoard = new TablePosition[x][y];
	private static Random rndm = new Random();

	public static void main(String[] args) throws IOException {

		createBoard();
		
		fillBoard();
		//loadBoard();
		
		//play();

	}
	
	static void createBoard() {
		
		for(int x = 0; x < gameBoard.length; x++) {
			for (int y = 0; y < gameBoard[x].length; y++) {
				gameBoard[x][y]= new TablePosition();
				}
			}
	}
	
	static void fillBoard() throws IOException {
		
		int xPos;
		int yPos;
		int direction;
		
		Boat boat = null;
		
		while(SBoats>0) {
			xPos=rndm.nextInt(x);
			yPos=rndm.nextInt(y);
			boat = Boat.newBoat(0);
			
			if(null==gameBoard[xPos][yPos].getContent()) {
				gameBoard[xPos][yPos].setContent(boat);
				SBoats--;
			}
			
		}

		while(MBoats>0) {
			
			direction=rndm.nextInt(2);
			boat = Boat.newBoat(1);
			
			if(direction==0) {
				xPos=rndm.nextInt(x);
				yPos=rndm.nextInt(y-1);
				
				if(null==gameBoard[xPos][yPos].getContent() && null==gameBoard[xPos][yPos+1].getContent()) {
					gameBoard[xPos][yPos].setContent(boat);
					gameBoard[xPos][yPos+1].setContent(boat);
					MBoats--;
				}
			}else {
				xPos=rndm.nextInt(x-1);
				yPos=rndm.nextInt(y);
				
				if(null==gameBoard[xPos][yPos].getContent() && null==gameBoard[xPos+1][yPos].getContent()) {
					gameBoard[xPos][yPos].setContent(boat);
					gameBoard[xPos+1][yPos].setContent(boat);
					MBoats--;
				}
			}
		}
		
		while(LBoats>0) {
			
			direction=rndm.nextInt(2);
			boat = Boat.newBoat(2);
			
			if(direction==0) {
				xPos=rndm.nextInt(x);
				yPos=rndm.nextInt(y-2);
				
				if(null==gameBoard[xPos][yPos].getContent() && null==gameBoard[xPos][yPos+1].getContent() && null==gameBoard[xPos][yPos+2].getContent()) {
					gameBoard[xPos][yPos].setContent(boat);
					gameBoard[xPos][yPos+1].setContent(boat);
					gameBoard[xPos][yPos+2].setContent(boat);
					LBoats--;
				}
			}else {
				xPos=rndm.nextInt(x-2);
				yPos=rndm.nextInt(y);
				
				if(null==gameBoard[xPos][yPos].getContent() && null==gameBoard[xPos+1][yPos].getContent() && null==gameBoard[xPos+2][yPos].getContent()) {
					gameBoard[xPos][yPos].setContent(boat);
					gameBoard[xPos+1][yPos].setContent(boat);
					gameBoard[xPos+2][yPos].setContent(boat);
					LBoats--;
				}
			}
		}
		
		File file = new File(solutionPath);
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter buffer = new BufferedWriter(fileWriter);
		
		for(int x = 0; x < gameBoard.length; x++) {
			for (int y = 0; y < gameBoard[x].length; y++) {
				buffer.write("|");
				if(null!=gameBoard[x][y].getContent()) {
					buffer.write(gameBoard[x][y].getContent().getType());
				} else {
					buffer.write("0");
				}
			}
			buffer.write("|");
			buffer.newLine();
		}
		buffer.close();
	}
	
	static void loadBoard() throws IOException {
		File file = new File(solutionPath);
		FileReader fileReader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(fileReader);
		String line;
		
		while((line=buffer.readLine())!=null) {
			String[] splittedLine = line.split("|");
		}
		
	}

}
