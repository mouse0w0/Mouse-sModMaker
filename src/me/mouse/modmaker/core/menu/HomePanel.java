package me.mouse.modmaker.core.menu;

import javax.swing.JPanel;

import me.mouse.modmaker.core.resources.ColorAndFont;

public class HomePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public HomePanel(){
		setBackground(ColorAndFont.Choose);
		setBounds(0, 52, 890, 538);
		setLayout(null);
		setOpaque(false);
	}
}
