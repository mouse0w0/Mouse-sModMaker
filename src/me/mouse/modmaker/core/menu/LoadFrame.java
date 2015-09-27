package me.mouse.modmaker.core.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import me.mouse.modmaker.core.Main;

public class LoadFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel info;

	public LoadFrame() {
		setTitle(Main.getName());
		try {
			setIconImage(new ImageIcon(new File("resources/texture/Icon.png")
					.toURI().toURL()).getImage());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		setLayout(null);
		setUndecorated(true);
		setBounds(
				(Toolkit.getDefaultToolkit().getScreenSize().width - 890) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - 590) / 2,
				890, 590);

		File load = new File("resources/texture/background");
		String[] l = load.list();
		BackgroundPanel bg;
		try {
			bg = new BackgroundPanel(new ImageIcon(new File(load, "/"
					+ l[new Random().nextInt(l.length)]).toURI().toURL()));
			bg.setBounds(0, 0, 890, 590);
			add(bg);
			
			JLabel li = new JLabel(new ImageIcon(new File("resources/texture/load.png").toURI().toURL()));
			li.setBounds(195, 245, 500, 100);
			li.setOpaque(false);
			bg.add(li);
			
			info = new JLabel("‘ÿ»Î÷–......");
			info.setBounds(195, 345, 200, 20);
			info.setFont(new Font("Œ¢»Ì—≈∫⁄", 0, 16));
			info.setForeground(Color.WHITE);
			bg.add(info);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		setVisible(true);
	}
}
