package me.mouse.modmaker.core.resources;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Random;

import javax.swing.ImageIcon;

public class Texture {

	private final ImageIcon Icon;
	
	private final ImageIcon Exit;
	private final ImageIcon Minimize;
	private final ImageIcon Empty;
	private final ImageIcon Add;
	private final ImageIcon Clear;
	private final ImageIcon Delete;
	private final ImageIcon Edit;
	private final ImageIcon Import;
	private final ImageIcon Export;
	private final ImageIcon RunServer;
	private final ImageIcon Preferences;
	private final ImageIcon Select;
	
	private final ImageIcon API;
	private final ImageIcon Command;
	private final ImageIcon Event;
	private final ImageIcon Item;
	private final ImageIcon Java;
	private final ImageIcon Other;
	private final ImageIcon Permission;
	private final ImageIcon Plugin;
	private final ImageIcon Resources;
	private final ImageIcon Source;
	private final ImageIcon Variable;
	private final ImageIcon Yaml;

	private final ImageIcon Background;

	public Texture() throws MalformedURLException {
		Icon = new ImageIcon(new File("resources/texture/Icon.png").toURI()
				.toURL());
		Exit = new ImageIcon(new File("resources/texture/gui/Exit.png").toURI()
				.toURL());
		Minimize = new ImageIcon(new File("resources/texture/gui/Minimize.png")
				.toURI().toURL());
		Empty = new ImageIcon(new File("resources/texture/gui/Empty.png")
				.toURI().toURL());
		Add = new ImageIcon(new File("resources/texture/gui/Add.png").toURI()
				.toURL());
		Clear = new ImageIcon(new File("resources/texture/gui/Clear.png")
				.toURI().toURL());
		Delete = new ImageIcon(new File("resources/texture/gui/Delete.png")
				.toURI().toURL());
		Edit = new ImageIcon(new File("resources/texture/gui/Edit.png").toURI()
				.toURL());
		Import = new ImageIcon(new File("resources/texture/gui/Import.png")
		.toURI().toURL());
		Export = new ImageIcon(new File("resources/texture/gui/Export.png")
				.toURI().toURL());
		RunServer = new ImageIcon(new File(
				"resources/texture/gui/Runserver.png").toURI().toURL());
		Preferences = new ImageIcon(new File(
				"resources/texture/gui/Preferences.png").toURI().toURL());
		Select = new ImageIcon(new File(
				"resources/texture/gui/Select.png").toURI().toURL());
		
		API = new ImageIcon(new File(
				"resources/texture/type/API.png").toURI().toURL());
		Command = new ImageIcon(new File(
				"resources/texture/type/Command.png").toURI().toURL());
		Event = new ImageIcon(new File(
				"resources/texture/type/Event.png").toURI().toURL());
		Item = new ImageIcon(new File(
				"resources/texture/type/Item.png").toURI().toURL());
		Java = new ImageIcon(new File(
				"resources/texture/type/Java.png").toURI().toURL());
		Other = new ImageIcon(new File(
				"resources/texture/type/Other.png").toURI().toURL());
		Permission = new ImageIcon(new File(
				"resources/texture/type/Permission.png").toURI().toURL());
		Plugin = new ImageIcon(new File(
				"resources/texture/type/Plugin.png").toURI().toURL());
		Resources = new ImageIcon(new File(
				"resources/texture/type/Resources.png").toURI().toURL());
		Source = new ImageIcon(new File(
				"resources/texture/type/Source.png").toURI().toURL());
		Variable = new ImageIcon(new File(
				"resources/texture/type/Varuable.png").toURI().toURL());
		Yaml = new ImageIcon(new File(
				"resources/texture/type/Yaml.png").toURI().toURL());

		File load = new File("resources/texture/background");
		String[] l = load.list();
		Random r = new Random();
		Background = new ImageIcon(new File(load, "/" + l[r.nextInt(l.length)])
				.toURI().toURL());
	}

	public ImageIcon getIcon() {
		return Icon;
	}

	public ImageIcon getExit() {
		return Exit;
	}

	public ImageIcon getMinimize() {
		return Minimize;
	}

	public ImageIcon getEmpty() {
		return Empty;
	}

	public ImageIcon getBackground() {
		return Background;
	}

	public ImageIcon getAdd() {
		return Add;
	}

	public ImageIcon getClear() {
		return Clear;
	}

	public ImageIcon getDelete() {
		return Delete;
	}

	public ImageIcon getEdit() {
		return Edit;
	}

	public ImageIcon getImport() {
		return Import;
	}

	public ImageIcon getExport() {
		return Export;
	}

	public ImageIcon getRunServer() {
		return RunServer;
	}

	public ImageIcon getPreferences() {
		return Preferences;
	}

	public ImageIcon getAPI() {
		return API;
	}

	public ImageIcon getCommand() {
		return Command;
	}

	public ImageIcon getEvent() {
		return Event;
	}

	public ImageIcon getItem() {
		return Item;
	}

	public ImageIcon getJava() {
		return Java;
	}

	public ImageIcon getOther() {
		return Other;
	}

	public ImageIcon getPermission() {
		return Permission;
	}

	public ImageIcon getPlugin() {
		return Plugin;
	}

	public ImageIcon getResources() {
		return Resources;
	}

	public ImageIcon getSource() {
		return Source;
	}

	public ImageIcon getVariable() {
		return Variable;
	}

	public ImageIcon getYaml() {
		return Yaml;
	}

	public ImageIcon getSelect() {
		return Select;
	}
}
