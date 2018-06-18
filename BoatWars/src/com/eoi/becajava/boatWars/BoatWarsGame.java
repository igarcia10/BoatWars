package com.eoi.becajava.boatWars;

import java.util.Random;

public class BoatWarsGame {
	
	private static int x=10;
	private static int y=10;
	private static int SBoats=4;
	private static int MBoats=3;
	private static int LBoats=2;
	private static TablePosition[][] gameBoard = new TablePosition[x][y];
	private static Random rndm = new Random();

	public static void main(String[] args) {

		createBoard();
		
		fillBoard();
		
		//play();

	}
	
	static void createBoard() {
		
		for(int x = 0; x < gameBoard.length; x++) {
			for (int y = 0; y < gameBoard[x].length; y++) {
				gameBoard[x][y]= new TablePosition();
				}
			}
	}
	
	static void fillBoard() {
		
		int xPos;
		int yPos;
		
		for(int i=0; i<SBoats; i++) {
			xPos=rndm.nextInt(x);
			yPos=rndm.nextInt(y);
			
			if(null==gameBoard[xPos][yPos].getContent()) {
				gameBoard[xPos][yPos].setContent(Boat.newBoat(0));
			}
			
		}

		for(int i=0; i<MBoats; i++) {
			
			xPos=rndm.nextInt(x-1);
			yPos=rndm.nextInt(y-1);
			
			if(null==gameBoard[xPos][yPos].getContent() && null==gameBoard[xPos+1][yPos+1].getContent()) {
				gameBoard[xPos][yPos].setContent(Boat.newBoat(1));
				gameBoard[xPos+1][yPos+1].setContent(gameBoard[xPos][yPos].getContent());
			}
	
		}
		
		for(int i=0; i<LBoats; i++) {
			xPos=rndm.nextInt(x-2);
			yPos=rndm.nextInt(y-2);
			
			if(null==gameBoard[xPos][yPos].getContent() && null==gameBoard[xPos+1][yPos+1].getContent() && null==gameBoard[xPos+2][yPos+2].getContent()) {
				gameBoard[xPos][yPos].setContent(Boat.newBoat(2));
				gameBoard[xPos+1][yPos+1].setContent(gameBoard[xPos][yPos].getContent());
				gameBoard[xPos+2][yPos+2].setContent(gameBoard[xPos][yPos].getContent());
			}
		}
		
		for(int x = 0; x < gameBoard.length; x++) {
			for (int y = 0; y < gameBoard[x].length; y++) {
				System.out.print("|");
				if(null!=gameBoard[x][y].getContent()) {
					System.out.print(gameBoard[x][y].getContent().getType());
				} else {
					System.out.print("0");
				}
			}
			System.out.print("|");
			System.out.println();
		}
		
	}

}
