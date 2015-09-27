package me.mouse.modmaker.core.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import me.mouse.modmaker.core.Main;
import me.mouse.modmaker.core.resources.ColorAndFont;

public class TabPanel extends JPanel {

	private static final long serialVersionUID = 9028898083559310239L;

	private JLabel home;
	private JLabel work;
	private JLabel tool;
	private JLabel cmd;

	public TabPanel() {
		SpringLayout sLayout = new SpringLayout();
		setBackground(ColorAndFont.Have);
		setBounds(0, 0, 890, 52);
		setLayout(sLayout);

		JLabel exit = new JLabel(Main.getTexture().getExit());
		exit.setBounds(869, 5, 16, 16);
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.getGUI().exit();
			}
		});
		add(exit);
		sLayout.putConstraint(SpringLayout.EAST, exit, -5, SpringLayout.EAST,
				this);
		sLayout.putConstraint(SpringLayout.NORTH, exit, 5, SpringLayout.NORTH,
				this);

		JLabel minimize = new JLabel(Main.getTexture().getMinimize());
		minimize.setBounds(848, 5, 16, 16);
		minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.getGUI().minimize();
			}
		});
		add(minimize);
		sLayout.putConstraint(SpringLayout.EAST, minimize, -5,
				SpringLayout.WEST, exit);
		sLayout.putConstraint(SpringLayout.NORTH, minimize, 5,
				SpringLayout.NORTH, this);

		JLabel st = new JLabel(Main.getTexture().getPreferences());
		st.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setSelectedTab(4);
				Main.getGUI().setTab(4);
			}
		});
		add(st);
		sLayout.putConstraint(SpringLayout.EAST, st, -5, SpringLayout.EAST,
				this);
		sLayout.putConstraint(SpringLayout.SOUTH, st, -5, SpringLayout.SOUTH,
				this);

		home = new JLabel(Main.getLanguage().get("tab.home"));
		home.setBounds(12, 0, 52, 52);
		home.setForeground(Color.WHITE);
		home.setFont(new Font("Î¢ÈíÑÅºÚ", 0, 20));
		home.setHorizontalAlignment(SwingConstants.CENTER);
		home.setOpaque(true);
		home.setBackground(new Color(50, 50, 50));
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setSelectedTab(0);
				Main.getGUI().setTab(0);
			}
		});
		add(home);
		sLayout.putConstraint(SpringLayout.NORTH, home, 0, SpringLayout.NORTH,
				this);
		sLayout.putConstraint(SpringLayout.WEST, home, 10, SpringLayout.WEST,
				this);
		sLayout.putConstraint(SpringLayout.SOUTH, home, 0, SpringLayout.SOUTH,
				this);

		work = new JLabel(Main.getLanguage().get("tab.work"));
		work.setBounds(64, 0, 70, 52);
		work.setForeground(Color.WHITE);
		work.setFont(new Font("Î¢ÈíÑÅºÚ", 0, 20));
		work.setHorizontalAlignment(SwingConstants.CENTER);
		work.setOpaque(true);
		work.setBackground(new Color(50, 50, 50));
		work.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setSelectedTab(1);
				Main.getGUI().setTab(1);
			}
		});
		add(work);
		sLayout.putConstraint(SpringLayout.NORTH, work, 0, SpringLayout.NORTH,
				this);
		sLayout.putConstraint(SpringLayout.WEST, work, 5, SpringLayout.EAST,
				home);
		sLayout.putConstraint(SpringLayout.SOUTH, work, 0, SpringLayout.SOUTH,
				this);

		tool = new JLabel(Main.getLanguage().get("tab.tool"));
		tool.setBounds(134, 0, 52, 52);
		tool.setForeground(Color.WHITE);
		tool.setFont(new Font("Î¢ÈíÑÅºÚ", 0, 20));
		tool.setHorizontalAlignment(SwingConstants.CENTER);
		tool.setOpaque(true);
		tool.setBackground(new Color(50, 50, 50));
		tool.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setSelectedTab(2);
				Main.getGUI().setTab(2);
			}
		});
		add(tool);
		sLayout.putConstraint(SpringLayout.NORTH, tool, 0, SpringLayout.NORTH,
				this);
		sLayout.putConstraint(SpringLayout.WEST, tool, 5, SpringLayout.EAST,
				work);
		sLayout.putConstraint(SpringLayout.SOUTH, tool, 0, SpringLayout.SOUTH,
				this);

		cmd = new JLabel(Main.getLanguage().get("tab.cmd"));
		cmd.setBounds(186, 0, 70, 52);
		cmd.setForeground(Color.WHITE);
		cmd.setFont(new Font("Î¢ÈíÑÅºÚ", 0, 20));
		cmd.setHorizontalAlignment(SwingConstants.CENTER);
		cmd.setOpaque(true);
		cmd.setBackground(new Color(50, 50, 50));
		cmd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setSelectedTab(3);
				Main.getGUI().setTab(3);
			}
		});
		add(cmd);
		sLayout.putConstraint(SpringLayout.NORTH, cmd, 0, SpringLayout.NORTH,
				this);
		sLayout.putConstraint(SpringLayout.WEST, cmd, 5, SpringLayout.EAST,
				tool);
		sLayout.putConstraint(SpringLayout.SOUTH, cmd, 0, SpringLayout.SOUTH,
				this);
	}

	
	/**
	 * ¸ü¸ÄÏÔÊ¾µÄÒ³Ãæ
	 * @param tab Ò³Ãæ´úÂë
	 */
	private void setSelectedTab(int tab) {
		cmd.setBackground(ColorAndFont.Have);
		work.setBackground(ColorAndFont.Have);
		tool.setBackground(ColorAndFont.Have);
		home.setBackground(ColorAndFont.Have);
		switch (tab) {
		case 0:
			home.setBackground(ColorAndFont.Choose);
			break;
		case 1:
			work.setBackground(ColorAndFont.Choose);
			break;
		case 2:
			tool.setBackground(ColorAndFont.Choose);
			break;
		case 3:
			cmd.setBackground(ColorAndFont.Choose);
			break;
		case -1:
			break;
		default:
			break;
		}
	}
}
