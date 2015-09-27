package me.mouse.modmaker.core.menu;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import me.mouse.modmaker.core.Main;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = -5086826111395227328L;

	private TabPanel tab;
	private BackgroundPanel background;
	private WorkPanel work;
	private CmdPanel cmd;
	private HomePanel home;
	private ToolPanel tool;
	private PreferencesPanel pref;

	private int xOld = 0;
	private int yOld = 0;

	private int Tab;

	public MainFrame() {
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		setTitle(Main.getName());
		setIconImage(Main.getTexture().getIcon().getImage());
		setLayout(null);
		setUndecorated(true);
		setBounds(
				(Toolkit.getDefaultToolkit().getScreenSize().width - 890) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - 590) / 2,
				890, 590);

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getY() <= 52) {
					xOld = e.getX();
					yOld = e.getY();
				} else {
					xOld = -1;
					yOld = -1;
				}
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (xOld == -1 || yOld == -1)
					return;
				int xOnScreen = e.getXOnScreen();
				int yOnScreen = e.getYOnScreen();
				int xx = xOnScreen - xOld;
				int yy = yOnScreen - yOld;
				setLocation(xx, yy);
			}
		});

		home = new HomePanel();
		home.setVisible(false);

		work = new WorkPanel();
		work.setVisible(false);

		tool = new ToolPanel();
		tool.setVisible(false);

		cmd = new CmdPanel();
		cmd.setVisible(false);

		pref = new PreferencesPanel();
		pref.setVisible(false);

		tab = new TabPanel();
		tab.setVisible(true);

		background = new BackgroundPanel(Main.getTexture().getBackground());
		background.setVisible(true);

		add(home);
		add(work);
		add(tool);
		add(cmd);
		add(pref);
		add(tab);
		add(background);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * 窗口最小化
	 */
	public void minimize() {
		setExtendedState(JFrame.ICONIFIED);
	}

	/**
	 * 退出窗口
	 */
	public void exit() {
		Object[] options = {Main.getLanguage().get("cancel"), Main.getLanguage().get("ok")};
		int i = JOptionPane.showOptionDialog(null, "你确认要退出吗?"	, Main.getLanguage().get("warning"), 
		JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
		null, options, options[0]);
		if(i == 1){
		Main.exit();
		}
	}

	/**
	 * 返回Tab 0-主页 1-工作台 2-工具 3-控制台 4-设置
	 * 
	 * @return Tab编号
	 */
	public int getTab() {
		return Tab;
	}

	/**
	 * 设置Tab 0-主页 1-工作台 2-工具 3-控制台 4-设置
	 * 
	 * @param tab
	 *            Tab编号
	 */
	public void setTab(int tab) {
		home.setVisible(false);
		work.setVisible(false);
		tool.setVisible(false);
		cmd.setVisible(false);
		pref.setVisible(false);
		switch (tab) {
		case 0:
			home.setVisible(true);
			Tab = 0;
			break;
		case 1:
			work.setVisible(true);
			Tab = 1;
			break;
		case 2:
			tool.setVisible(true);
			Tab = 2;
			break;
		case 3:
			cmd.setVisible(true);
			Tab = 3;
			break;
		case 4:
			pref.setVisible(true);
			Tab = 4;
		default:
			break;
		}
	}
}
