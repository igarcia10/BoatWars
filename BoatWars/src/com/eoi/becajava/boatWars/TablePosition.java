package com.eoi.becajava.boatWars;

public class TablePosition {
	
	private Boat content;
	private boolean selected;
	
	

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Boat getContent() {
		return content;
	}

	public void setContent(Boat content) {
		this.content = content;
	}
	
	public TablePosition() {
		content = null;
		selected = false;
	}

}