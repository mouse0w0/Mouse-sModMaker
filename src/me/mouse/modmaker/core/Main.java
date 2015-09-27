package me.mouse.modmaker.core;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Locale;

import me.mouse.modmaker.core.file.configuration.BaseConfiguration;
import me.mouse.modmaker.core.menu.LoadFrame;
import me.mouse.modmaker.core.menu.MainFrame;
import me.mouse.modmaker.core.resources.Language;
import me.mouse.modmaker.core.resources.Texture;

public class Main{

	private static final String NAME = "Mouse'sModMaker";
	private static final String VERSION = "0.0.1";
	private static final String DefaultLanguage = Locale.getDefault().getLanguage()
			+ "_" + Locale.getDefault().getCountry();

	private static Texture Texture;
	private static Language Language;
	private static MainFrame GUI;
	private static BaseConfiguration Config;
	
	private static boolean debug;

	private static void onLoad() {
		try {
			Config = new BaseConfiguration(new File("user/config.yml"));
			if(Config.getFirstCreateFile() == true){
				Config.set("language", getDefaultLanguage());
				Config.set("workspace", new File("user/workspace").getAbsolutePath());
			}
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		try {
			Language = new Language(Config.get("language"));
		} catch (FileNotFoundException e1) {
			try {
				Language = new Language("zh_CN");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		LoadFrame load = new LoadFrame();
		
		try {
			Texture = new Texture();
		} catch (MalformedURLException e2) {
			e2.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI = new MainFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		load.dispose();
	}

	public static void main(String[] args) {
		onLoad();
	}

	public static Texture getTexture() {
		return Texture;
	}

	public static Language getLanguage() {
		return Language;
	}
	
	public static boolean isDebug(){
		return debug;
	}
	
	public static void setDebug(boolean debug){
		Main.debug = debug;
	}

	/**
	 * 返回软件名字
	 * 
	 * @return 软件名字
	 */
	public static String getName() {
		return NAME;
	}

	/**
	 * 返回软件版本号
	 * 
	 * @return 版本号
	 */
	public static String getVersion() {
		return VERSION;
	}

	/**
	 * 返回默认语言
	 * 
	 * @return 默认语言
	 */
	public static String getDefaultLanguage() {
		return DefaultLanguage;
	}

	/**
	 * 返回GUI操作接口
	 * 
	 * @return GUI操作接口
	 */
	public static MainFrame getGUI() {
		return GUI;
	}

	/**
	 * 获取配置文件类
	 * 
	 * @return 配置文件
	 */
	public static BaseConfiguration getConfig() {
		return Config;
	}

	/**
	 * 退出软件,同时保存
	 */
	public static void exit() {
		save();
		System.exit(0);
	}

	/**
	 * 保存信息
	 */
	public static void save() {
		Config.save(new File("user/config.yml"));
	}

}

/**
 * >C:\Pylo\MCreator147>cd forge >C:\Pylo\MCreator147\forge>SET
 * "JAVA_HOME=C:\Pylo\MCreator147\jdk\" >C:\Pylo\MCreator147\forge>SET
 * JAVA_EXE=%JAVA_HOME%\bin\java.exe >C:\Pylo\MCreator147\forge>SET
 * PATH=%JAVA_HOME%\bin\;%PATH%
 */
