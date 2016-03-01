package com;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class Grid {
	/**
	 * Represents grid of cells
	 */
	public final static int ROWS = 20;
	public final static int COLS = 20;
	private JPanel gridPanel;

	public JPanel getGridPanel() {
		return gridPanel;
	}

	private static Cell[][] grid;

	public static Cell[][] getCellGrid() {
		return grid;
	}

	public JPanel createGrid() {
		grid = new Cell[ROWS][COLS];
		gridPanel = new JPanel(new GridLayout(ROWS, COLS));
		CellListener cellListener = new CellListener();
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				Cell cell = new Cell(i, j);
				grid[i][j] = cell;
				cell.getCellLabel().addMouseListener(cellListener);
				gridPanel.add(cell.getCellLabel());
			}
		}
		gridPanel.validate();
		gridPanel.repaint();
		return gridPanel;
	}

	/**
	 * 
	 * @param cell
	 * @return an array of neighbor cells
	 */
	public static Cell[] getNeigbors(Cell cell) {
		Cell[] nbrs = new Cell[8];
		int xPos = cell.getPosX();
		int yPos = cell.getPosY();
		nbrs[0] = addNeighbor(xPos - 1, yPos - 1);
		nbrs[1] = addNeighbor(xPos, yPos - 1);
		nbrs[2] = addNeighbor(xPos + 1, yPos - 1);
		nbrs[3] = addNeighbor(xPos - 1, yPos);
		nbrs[4] = addNeighbor(xPos + 1, yPos);
		nbrs[5] = addNeighbor(xPos - 1, yPos + 1);
		nbrs[6] = addNeighbor(xPos, yPos + 1);
		nbrs[7] = addNeighbor(xPos + 1, yPos + 1);

		return nbrs;

	}

	/**
	 * 
	 * @param xPos
	 *            x-coordinate of cell within grid
	 * @param yPos
	 *            y-coordinate of cell within grid
	 * @return cell at passed coordinates within grid
	 * 
	 *         null is returned for cells at boundary of grid, when no cell is
	 *         present.
	 */
	private static Cell addNeighbor(int xPos, int yPos) {
		if (xPos < 0 || yPos < 0 || xPos >= ROWS || yPos >= COLS)
			return null;
		else
			return grid[xPos][yPos];
	}

}
