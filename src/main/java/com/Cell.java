package com;

import javax.swing.JLabel;

/**
 * 
 * Representation of a Cell for Game of Life
 * 
 */
public class Cell {
	private int posX;
	private int posY;
	private CellLabel cellLabel;

	private enum CellState {
		DEAD, ALIVE

	}

	private CellState nextState;

	public CellState getNextState() {
		return nextState;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public JLabel getCellLabel() {
		return cellLabel;
	}

	public CellState getCellState() {
		return cellState;
	}

	public boolean isAlive() {
		if (cellState == CellState.ALIVE)
			return true;
		else
			return false;
	}

	public void setCellState(CellState cellState) {
		this.cellState = cellState;
	}

	private CellState cellState;

	public Cell(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		cellLabel = new CellLabel(this);
		makeDead();
	}

	public void makeAlive() {
		cellState = CellState.ALIVE;
		cellLabel.setText("x");
	}

	public void makeDead() {
		cellState = CellState.DEAD;
		cellLabel.setText("-");
		nextState = CellState.DEAD;
	}

	/**
	 * calculates number of live cell in neighborhood of cell
	 */
	public int getNumberOfLiveNeighbors() {
		int liveNbrs = 0;
		Cell[] nbrs = getNeighbors();
		for (int i = 0; i < nbrs.length; i++) {
			if (nbrs[i] != null && nbrs[i].getCellState() == CellState.ALIVE) {
				liveNbrs++;

			}
		}
		return liveNbrs;
	}

	private Cell[] getNeighbors() {
		return Grid.getNeigbors(this);
	}

	/**
	 * This method implements the rules of game to arrive at next state for a
	 * cell
	 */
	public void storeNewState() {
		int liveNbrs = getNumberOfLiveNeighbors();
		if (isAlive()) {
			if (liveNbrs < 2 || liveNbrs > 3) { // Rule 1 and 2.(Dies of
												// lonliness or overcrowding)

				nextState = CellState.DEAD;
			}
			if (liveNbrs == 2 || liveNbrs == 3) { // Rule 3

				nextState = CellState.ALIVE;
			}
		} else {
			if (liveNbrs == 3) { // Rule 4

				nextState = CellState.ALIVE;
			}
		}

	}

	/**
	 * Marks next cell state to be rendered in next cycle.
	 */
	public void setNewState() {
		if (getNextState() == CellState.ALIVE)
			makeAlive();
		else
			makeDead();
	}

}
