package me.mouse.modmaker.core.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.SpringLayout;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import me.mouse.modmaker.core.Main;
import me.mouse.modmaker.core.resources.ColorAndFont;

public class WorkPanel extends JPanel {

	private static final long serialVersionUID = -2749726472104085816L;

	private JTree tree;
	private JSplitPane split;
	private JComboBox<String> items;

	public WorkPanel() {
		setBounds(0, 52, 890, 538);
		setBackground(ColorAndFont.Have);
		SpringLayout sl = new SpringLayout();
		setLayout(sl);
		setOpaque(false);
		
		Font fa = new Font("宋体", 0, 16);

		JLabel text1 = new JLabel(Main.getLanguage().get("work.item")+":");
		text1.setForeground(Color.WHITE);
		text1.setFont(fa);
		add(text1);
		sl.putConstraint(SpringLayout.NORTH, text1, 8, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.WEST, text1, 8, SpringLayout.WEST, this);
		
		items = new JComboBox<String>();
		items.addItem("测试项目1");
		items.addItem("测试项目2");
		items.addItem("测试项目3");
		add(items);
		sl.putConstraint(SpringLayout.NORTH, items, 8, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.WEST, items, 5, SpringLayout.EAST, text1);
		
		JLabel selecta = new JLabel(Main.getTexture().getSelect());
		selecta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
			}
		});
		add(selecta);
		sl.putConstraint(SpringLayout.NORTH, selecta, 10, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.WEST, selecta, 5, SpringLayout.EAST, items);
		
		JLabel selectb = new JLabel(Main.getTexture().getExport());
		selectb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
			}
		});
		add(selectb);
		sl.putConstraint(SpringLayout.NORTH, selectb, 5, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.EAST, selectb, -8, SpringLayout.EAST, this);
		
		JLabel selectc = new JLabel(Main.getTexture().getRunServer());
		selectc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
			}
		});
		add(selectc);
		sl.putConstraint(SpringLayout.NORTH, selectc, 5, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.EAST, selectc, -8, SpringLayout.WEST, selectb);
		
		JLabel selectd = new JLabel(Main.getTexture().getDelete());
		selectc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
			}
		});
		add(selectd);
		sl.putConstraint(SpringLayout.NORTH, selectd, 5, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.EAST, selectd, -8, SpringLayout.WEST, selectc);
		
		JLabel selecte = new JLabel(Main.getTexture().getEdit());
		selecte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
			}
		});
		add(selecte);
		sl.putConstraint(SpringLayout.NORTH, selecte, 5, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.EAST, selecte, -8, SpringLayout.WEST, selectd);
		
		JLabel selectf = new JLabel(Main.getTexture().getAdd());
		selectf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
			}
		});
		add(selectf);
		sl.putConstraint(SpringLayout.NORTH, selectf, 5, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.EAST, selectf, -8, SpringLayout.WEST, selecte);
		

		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);
		split.setDividerLocation(200);
		split.setOpaque(false);
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(Main.getLanguage().get("work.item"));
		
		DefaultMutableTreeNode plugin = new DefaultMutableTreeNode(Main.getLanguage().get("work.plugin"),true);
		root.add(plugin);
		DefaultMutableTreeNode resources = new DefaultMutableTreeNode(Main.getLanguage().get("work.resources"),true);
		root.add(resources);
		DefaultMutableTreeNode source = new DefaultMutableTreeNode(Main.getLanguage().get("work.source"),true);
		root.add(source);
		DefaultMutableTreeNode api = new DefaultMutableTreeNode(Main.getLanguage().get("work.api"),true);
		root.add(api);
		
		DefaultMutableTreeNode command1 = new DefaultMutableTreeNode("指令:1", false);
		plugin.add(command1);
		DefaultMutableTreeNode command2 = new DefaultMutableTreeNode("指令:2", false);
		plugin.add(command2);
		
		tree = new JTree(root);
		tree.setRootVisible(true);
		tree.setOpaque(false);
		tree.getSelectionModel().setSelectionMode(1);
		tree.setRowHeight(20);
		tree.setCellRenderer(new CustomDefaultTreeCellRenderer());
		DefaultTreeCellRenderer cellRenderer = (DefaultTreeCellRenderer) tree
				.getCellRenderer();
		cellRenderer.setFont(new Font("宋体", 0, 14));
		cellRenderer.setBackgroundNonSelectionColor(ColorAndFont.Transparent);
		cellRenderer.setBackgroundSelectionColor(ColorAndFont.Transparent);
		cellRenderer.setBorderSelectionColor(Color.white);
		cellRenderer.setTextNonSelectionColor(Color.white);
		cellRenderer.setTextSelectionColor(Color.white);
		tree.setCellRenderer(cellRenderer);

		JScrollPane sp = new JScrollPane(tree);
		sp.setBorder(null);
		sp.getViewport().setOpaque(false);
		sp.setOpaque(false);

		JPanel jp = new JPanel();
		jp.setOpaque(false);

		split.setLeftComponent(sp);
		split.setRightComponent(jp);

		add(split);
		sl.putConstraint(SpringLayout.NORTH, split, 8, SpringLayout.SOUTH, text1);
		sl.putConstraint(SpringLayout.WEST, split, 8, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.EAST, split, -8, SpringLayout.EAST, this);
		sl.putConstraint(SpringLayout.SOUTH, split, -8, SpringLayout.SOUTH, this);
	}
}
