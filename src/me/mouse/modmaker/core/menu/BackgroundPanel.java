package me.mouse.modmaker.core.menu;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {

	private static final long serialVersionUID = 6806656838586753353L;

	private ImageIcon Background = null;

	public BackgroundPanel(ImageIcon background) {
		setBackground(new Color(30, 30, 30));
		setBounds(0, 52, 890, 538);
		setLayout(null);
		this.Background = background;
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(Background.getImage(), 0, 0, getWidth(), getHeight(), this);
		paintComponents(g);
	}

	public ImageIcon getBackgroundImage() {
		return Background;
	}

	public void setBackgroundImage(ImageIcon background) {
		Background = background;
	}
}