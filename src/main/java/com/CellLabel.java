package com;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class CellLabel extends JLabel {
	/**
	 * Represents "UI" of a cell.
	 */
	private static final long serialVersionUID = 1L;
	private Cell cell;
	private Color borderColor = Color.red;

	public CellLabel(Cell cell) {
		super();
		setBorder(new LineBorder(borderColor, 1));
		setHorizontalAlignment(SwingConstants.CENTER);
		this.cell = cell;

	}

	public Cell getCell() {
		return cell;
	}

}
