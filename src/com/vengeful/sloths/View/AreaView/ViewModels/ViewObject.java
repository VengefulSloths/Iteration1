package com.vengeful.sloths.View.AreaView.ViewModels;

import com.vengeful.sloths.View.AreaView.CoordinateStrategies.CoordinateStrategy;
import com.vengeful.sloths.View.AreaView.Observers.ModelObserver;

import java.awt.Graphics2D;

import javax.swing.JComponent;

public abstract class ViewObject extends JComponent implements ModelObserver {
	protected int x;
	protected int y;
	protected CoordinateStrategy converter;
	public abstract void paintComponent(Graphics2D g);
}
