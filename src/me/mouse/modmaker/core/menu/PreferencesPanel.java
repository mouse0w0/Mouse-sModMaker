package me.mouse.modmaker.core.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.filechooser.FileNameExtensionFilter;

import me.mouse.modmaker.core.Main;
import me.mouse.modmaker.core.file.configuration.BaseConfiguration;
import me.mouse.modmaker.core.resources.ColorAndFont;
import me.mouse.modmaker.core.resources.Language;

public class PreferencesPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public JPanel pre;

	public PreferencesPanel() {
		setBounds(0, 52, 890, 538);
		setBackground(ColorAndFont.Have);
		setOpaque(false);
		setLayout(null);

		pre = new JPanel();
		SpringLayout sLayout = new SpringLayout();
		pre.setOpaque(false);
		pre.setLayout(sLayout);
		pre.setBackground(ColorAndFont.Have);
		
		Font first = new Font("ËÎÌå", 1, 16);
		Font second = new Font("ËÎÌå", 0, 15);
		
		JLabel a = new JLabel(Main.getLanguage().get("config.basic")+":");
		JLabel b = new JLabel(Main.getLanguage().get("config.language")+":");
		JLabel c = new JLabel(Main.getLanguage().get("config.workspace")+":");
		a.setFont(first);
		b.setFont(second);
		c.setFont(second);
		a.setForeground(Color.WHITE);
		b.setForeground(Color.WHITE);
		c.setForeground(Color.WHITE);
		pre.add(a);
		pre.add(b);
		pre.add(c);
		sLayout.putConstraint(SpringLayout.NORTH, a, 5, SpringLayout.NORTH, pre);
		sLayout.putConstraint(SpringLayout.WEST, a, 5, SpringLayout.WEST, pre);
		sLayout.putConstraint(SpringLayout.NORTH, b, 5, SpringLayout.SOUTH, a);
		sLayout.putConstraint(SpringLayout.WEST, b, 5, SpringLayout.WEST, pre);
		
		final JComboBox<String> language = new JComboBox<String>(Language.getAllLanguage().keySet().toArray(new String[Language.getAllLanguageNumber()]));
		language.setOpaque(false);
		language.setSelectedItem(Language.getLanguageDisplay(Main.getConfig().get("language")));
		pre.add(language);
		sLayout.putConstraint(SpringLayout.WEST, language, 5, SpringLayout.EAST, b);
		sLayout.putConstraint(SpringLayout.NORTH, language, 5, SpringLayout.SOUTH, a);
		
		sLayout.putConstraint(SpringLayout.NORTH, c, 5, SpringLayout.SOUTH, language);
		sLayout.putConstraint(SpringLayout.WEST, c, 5, SpringLayout.WEST, pre);

		final JTextField workspace = new JTextField(Main.getConfig().get("workspace"),48);
		pre.add(workspace);
		sLayout.putConstraint(SpringLayout.NORTH, workspace, 5, SpringLayout.SOUTH, language);
		sLayout.putConstraint(SpringLayout.WEST, workspace, 5, SpringLayout.EAST, c);
		
		final JLabel selectws = new JLabel(Main.getTexture().getSelect());
		selectws.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int i = fc.showOpenDialog(pre);
				if(i == JFileChooser.APPROVE_OPTION){
					workspace.setText(fc.getSelectedFile().getAbsolutePath());
				}
			}
		});
		pre.add(selectws);
		sLayout.putConstraint(SpringLayout.NORTH, selectws, 5, SpringLayout.SOUTH, language);
		sLayout.putConstraint(SpringLayout.WEST, selectws, 5, SpringLayout.EAST, workspace);
		
		JLabel d = new JLabel(Main.getLanguage().get("config.bukkit")+":");
		d.setFont(second);
		d.setForeground(Color.WHITE);
		pre.add(d);
		sLayout.putConstraint(SpringLayout.NORTH, d, 5, SpringLayout.SOUTH, workspace);
		sLayout.putConstraint(SpringLayout.WEST, d, 5, SpringLayout.WEST, pre);
		
		final JTextField bukkit = new JTextField(Main.getConfig().get("bukkit"),48);
		pre.add(bukkit);
		sLayout.putConstraint(SpringLayout.NORTH, bukkit, 5, SpringLayout.SOUTH, workspace);
		sLayout.putConstraint(SpringLayout.WEST, bukkit, 5, SpringLayout.EAST, d);
		
		final JLabel selectb = new JLabel(Main.getTexture().getSelect());
		selectb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				JFileChooser fc = new JFileChooser();
				fc.setFileFilter(new FileNameExtensionFilter("JarÎÄ¼þ", "JAR"));
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int i = fc.showOpenDialog(pre);
				if(i == JFileChooser.APPROVE_OPTION){
					bukkit.setText(fc.getSelectedFile().getAbsolutePath());
				}
			}
		});
		pre.add(selectb);
		sLayout.putConstraint(SpringLayout.NORTH, selectb, 5, SpringLayout.SOUTH, workspace);
		sLayout.putConstraint(SpringLayout.WEST, selectb, 5, SpringLayout.EAST, bukkit);
		
		JLabel f= new JLabel("Debug:");
		f.setFont(second);
		f.setForeground(Color.WHITE);
		pre.add(f);
		sLayout.putConstraint(SpringLayout.NORTH, f, 5, SpringLayout.SOUTH, bukkit);
		sLayout.putConstraint(SpringLayout.WEST, f, 5, SpringLayout.WEST, pre);
		
		final JRadioButton debug = new JRadioButton();
		debug.setFont(second);
		debug.setForeground(Color.WHITE);
		debug.setOpaque(false);
		debug.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(debug.isSelected());
				Main.setDebug(debug.isSelected());
			}
		});
		pre.add(debug);
		sLayout.putConstraint(SpringLayout.NORTH, debug, 5, SpringLayout.SOUTH, bukkit);
		sLayout.putConstraint(SpringLayout.WEST, debug, 5, SpringLayout.EAST, f);
		
		JLabel cancel = new JLabel(Main.getLanguage().get("cancel"));
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Î¢ÈíÑÅºÚ", 0, 20));
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				language.setSelectedItem(Main.getConfig().get("language"));
				workspace.setText(Main.getConfig().get("workspace"));
			}
		});
		pre.add(cancel);
		sLayout.putConstraint(SpringLayout.EAST, cancel, -5, SpringLayout.EAST, pre);
		sLayout.putConstraint(SpringLayout.SOUTH, cancel, -5, SpringLayout.SOUTH, pre);
		
		
		JLabel save = new JLabel(Main.getLanguage().get("save"));
		save.setForeground(Color.WHITE);
		save.setFont(new Font("Î¢ÈíÑÅºÚ", 0, 20));
		pre.add(save);
		save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				BaseConfiguration config = Main.getConfig();
				config.set("language", Language.getAllLanguage().get(language.getSelectedItem()));
				config.set("workspace", workspace.getText());
				config.set("bukkit", bukkit.getText());
				config.save(new File("user/config.yml"));
			}
		});
		sLayout.putConstraint(SpringLayout.EAST, save, -5, SpringLayout.WEST, cancel);
		sLayout.putConstraint(SpringLayout.SOUTH, save, -5, SpringLayout.SOUTH, pre);
		
		JScrollPane sp = new JScrollPane(pre, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setBorder(null);
		sp.setOpaque(false);
		sp.getViewport().setOpaque(false);
		sp.setBounds(8, 8, 874, 522);
		add(sp);
	}

}