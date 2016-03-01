package com;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CellListener extends MouseAdapter {
	/**
	 * Mouse event listener for cells. clicking of a dead cell makes it alive
	 */

	@Override
	public void mouseClicked(MouseEvent e) {

		CellLabel cellLabel = (CellLabel) e.getSource();
		Cell cell = cellLabel.getCell();

		if (e.getButton() == MouseEvent.BUTTON3) {
			System.out.println("NBRS : " + cell.getNumberOfLiveNeighbors());
			return;
		}
		if (e.getButton() == MouseEvent.BUTTON2)
			return;
		cell.makeAlive();

	}

}
