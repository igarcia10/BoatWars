package com.eoi.becajava.boatWars;

public class Boat {
	
	private char type;
	private int size;
	private int hits;
	private boolean status;
	
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Boat(char type, int size, int hits, boolean status) {
		
		this.type = type;
		this.size = size;
		this.hits = hits;
		this.status = status;
	}
	
	public static Boat newBoat(int type) {
		Boat boat = null;
		
		switch(type) {
		case 0:
			boat=new SmallBoat();
			break;
		case 1:
			boat=new MediumBoat();
			break;
		case 2:
			boat=new LargeBoat();
			break;
		}
		
		return boat;
	}

}
