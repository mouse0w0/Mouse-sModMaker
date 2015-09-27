package me.mouse.modmaker.core.workspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import me.mouse.modmaker.core.nbt.CompoundTag;
import me.mouse.modmaker.core.nbt.StringTag;
import me.mouse.modmaker.core.nbt.Tag;

public class Item {

	private String Name;
	private String ModName;
	private String ModVersion;
	private String ModAuthor;
	private String ModDescription;
	
	private List<ModObject> Objects;
	
	/**
	 * 构造Item对象
	 */
	public Item() {
		setPlugin(new ArrayList<ModObject>());
	}
	
	/**
	 * 构造Item对象
	 * @param Name 名字
	 */
	public Item(String Name){
		setPlugin(new ArrayList<PluginObject>());
		this.setName(Name);
	}
	
	/**
	 * 通过Tag构造Item对象
	 * @param tag Tag
	 */
	public Item(Tag tag){
		setPlugin(new ArrayList<PluginObject>());
		if (tag == null) return;
		if (tag instanceof CompoundTag){
			CompoundTag ct = (CompoundTag) tag;
			Map<String, Tag> map = ct.getValue();
			Tag name = map.get("name");
			if (name instanceof StringTag){
				this.Name = name.getValue().toString();
			}
		}
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPluginName() {
		return PluginName;
	}

	public String getPluginVersion() {
		return PluginVersion;
	}

	public String getPluginAuthor() {
		return PluginAuthor;
	}

	public String getPluginDescription() {
		return PluginDescription;
	}

	public void setPluginName(String pluginName) {
		PluginName = pluginName;
	}

	public void setPluginVersion(String pluginVersion) {
		PluginVersion = pluginVersion;
	}

	public void setPluginAuthor(String pluginAuthor) {
		PluginAuthor = pluginAuthor;
	}

	public void setPluginDescription(String pluginDescription) {
		PluginDescription = pluginDescription;
	}

	public List<PluginObject> getPlugin() {
		return Plugin;
	}

	public void setPlugin(List<PluginObject> plugin) {
		Plugin = plugin;
	}
	
	public PluginObject getPluginObject(String Name){
		for (PluginObject po:Plugin){
			if (po.getName().equalsIgnoreCase(Name))
				return po;
		}
		return null;
	}
	
	public void addPluginObject(PluginObject po){
		Plugin.add(po);
	}
	
	public void removePluginObject(String Name){
		PluginObject po = getPluginObject(Name);
		if (po != null) Plugin.remove(po);
	}
	
	public void removePluginObject(PluginObject po){
		if (po != null) Plugin.remove(po);
	}

	public Tag toNBT(){
		Map<String, Tag> map = new TreeMap<String, Tag>();
		map.put("name", new StringTag("name", Name));
		map.put("plugin_name", new StringTag("plugin_name", PluginName));
		map.put("plugin_version", new StringTag("plugin_version", PluginVersion));
		map.put("plugin_author", new StringTag("plugin_author", PluginAuthor));
		map.put("plugin_description", new StringTag("plugin_description", PluginDescription));
		CompoundTag root = new CompoundTag("root", map);
		return root;
	}
	
}
