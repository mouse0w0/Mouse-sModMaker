package me.mouse.modmaker.core.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import me.mouse.modmaker.core.Main;
import me.mouse.modmaker.core.resources.ColorAndFont;
import me.mouse.modmaker.core.util.Cmd;

public class CmdPanel extends JPanel {

	private static final long serialVersionUID = 7430196508655279882L;

	private JTextArea ta;
	private JTextField tf;

	public CmdPanel() {
		setBackground(ColorAndFont.Choose);
		setBounds(0, 52, 890, 538);
		setLayout(null);

		ta = new JTextArea(256, 256);
		ta.setFont(new Font("ËÎÌו", 0, 14));
		ta.setBackground(ColorAndFont.Empty);
		ta.setForeground(Color.white);
		ta.setLineWrap(true);
		ta.setEditable(false);

		JScrollPane sp = new JScrollPane(ta);
		sp.setBackground(Color.white);
		sp.setBounds(8, 8, 874, 496);
		add(sp);

		tf = new JTextField(1024);
		tf.setFont(new Font("ËÎÌו", 0, 14));
		tf.setBounds(8, 508, 844, 22);
		tf.setBackground(Color.white);
		tf.setForeground(Color.black);
		tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					Cmd.lineDos(tf.getText().split(";"), ta);
				}
			}
		});
		add(tf);

		JLabel clear = new JLabel(Main.getTexture().getClear());
		clear.setBounds(860, 508, 22, 22);
		clear.setOpaque(true);
		clear.setBackground(ColorAndFont.Button);
		clear.setToolTipText(Main.getLanguage().get("cmd.clear.info"));
		clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ta.setText("");
			}
		});
		add(clear);
	}
}
