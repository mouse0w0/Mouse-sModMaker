package me.mouse.modmaker.core.menu;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import me.mouse.modmaker.core.Main;

public class CustomDefaultTreeCellRenderer extends DefaultTreeCellRenderer{

	private static final long serialVersionUID = 1L;
	
    @Override  
    public Component getTreeCellRendererComponent(JTree tree, Object value,  
            boolean sel, boolean expanded, boolean leaf, int row,  
            boolean hasFocus)  
    {  
  
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,  
                row, hasFocus);  
  
        setText(value.toString());  
          
        if (sel)  
        {  
            setForeground(getTextSelectionColor());  
        }  
        else  
        {  
            setForeground(getTextNonSelectionColor());  
        }  
           
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;  
          
        String str = node.toString();         
        
        if (str == Main.getLanguage().get("work.item"))
        {
        	this.setIcon(Main.getTexture().getItem());
        }
        if (str == Main.getLanguage().get("work.plugin"))  
        {  
            this.setIcon(Main.getTexture().getPlugin());  
        }  
        if (str == Main.getLanguage().get("work.resources"))  
        {  
            this.setIcon(Main.getTexture().getResources());  
        }  
        if (str == Main.getLanguage().get("work.source"))  
        {  
            this.setIcon(Main.getTexture().getSource());  
        }  
        if (str == Main.getLanguage().get("work.api")){
        	this.setIcon(Main.getTexture().getAPI());
        }
        if (str.startsWith("ЦёБо")){
        	this.setIcon(Main.getTexture().getCommand());
        }
        	
        return this;  
    }  

}
