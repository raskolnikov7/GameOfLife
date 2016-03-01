package com;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Kamlendra
 * 
 *         GUI and starter class for "Game of Life"
 * 
 *         USAGE:
 * 
 *         The game consists of a 20 x 20 grid of cells. Users can left click a
 *         dead cell (denoted by "-" ) to make it alive (denoted by "x").
 *         clicking on a live cell causes nothing. Right clicking on a cell
 *         shows numbers of live neighbor cells for the clicked cell on the
 *         console. Initially all cells are in a dead state. After giving the
 *         seed input by making some cells alive the program displayed next
 *         states for cells when button "Start" is clicked. Button "Clear" can
 *         be clicked to clear the states of cells; to make all of them dead.
 * 
 * 
 */
public class GameOfLife {

	private JFrame appFrame;
	private JPanel controlPanel;
	private JButton clearButton;
	private JButton startButton;
	private JPanel gridPanel;

	private void createAndShowUI() {
		appFrame = new JFrame("Game of Life");
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appFrame.setPreferredSize(new Dimension(500, 500));
		appFrame.setAlwaysOnTop(true);
		appFrame.setResizable(false);

		startButton = new JButton("Start");
		startButton.addActionListener(new StartListener());
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new StopListener());
		controlPanel = new JPanel(new BorderLayout());
		controlPanel.add(startButton, BorderLayout.WEST);
		controlPanel.add(clearButton, BorderLayout.EAST);

		appFrame.getContentPane().setLayout(new BorderLayout());
		Grid grid = new Grid();
		gridPanel = grid.createGrid();

		appFrame.getContentPane().add(controlPanel, BorderLayout.NORTH);
		appFrame.getContentPane().add(gridPanel, BorderLayout.CENTER);
		appFrame.validate();
		appFrame.pack();
		appFrame.setVisible(true);

	}

	/**
	 * 
	 * Listener for Start button. stores and then displays the next state for
	 * cells in the grid.
	 * 
	 */
	private class StartListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Cell[][] cellGrid = Grid.getCellGrid();
			for (int i = 0; i < Grid.ROWS; i++)
				for (int j = 0; j < Grid.COLS; j++) {
					Cell cell = cellGrid[i][j];
					cell.storeNewState();
				}

			for (int i = 0; i < Grid.ROWS; i++)
				for (int j = 0; j < Grid.COLS; j++) {
					Cell cell = cellGrid[i][j];
					cell.setNewState();

				}

		}
	}

	/**
	 * 
	 * Listener for Clear button. clears all cell states to "dead"
	 * 
	 */
	private class StopListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Cell[][] cellGrid = Grid.getCellGrid();
			for (int i = 0; i < Grid.ROWS; i++)
				for (int j = 0; j < Grid.COLS; j++) {
					Cell cell = cellGrid[i][j];
					if (cell.isAlive())
						cell.makeDead();
				}

		}

	}

	public static void main(String args[]) {
		new GameOfLife().createAndShowUI();
	}

}
