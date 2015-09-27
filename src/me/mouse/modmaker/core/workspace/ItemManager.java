package me.mouse.modmaker.core.workspace;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {

	private File workspace;
	
	private List<Item> items;
	
	public ItemManager(File workspace) {
		this.setWorkspace(workspace);
		items = new ArrayList<Item>();
	}

	public File getWorkspace() {
		return workspace;
	}

	public void setWorkspace(File workspace) {
		this.workspace = workspace;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public void addItem(Item item){
		items.add(item);
	}
	
	public Item getItem(String Name){
		for(Item i:items){
			if (i.getName().equalsIgnoreCase(Name)){
				return i;
			}
		}
		return null;
	}
	
	public void removeItem(String Name){
		items.remove(getItem(Name));
	}
	
	public void removeItem(Item item){
		items.remove(item);
	}
}
