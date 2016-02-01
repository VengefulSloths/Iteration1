package com.vengeful.sloths.View.AreaView;

import java.awt.Graphics2D;

import javax.swing.JComponent;

public abstract class ViewObject extends JComponent implements ModelObserver{
	protected int x;
	protected int y;
	protected CoordinateStrategy converter;
	abstract void paintComponent(Graphics2D g);
}
