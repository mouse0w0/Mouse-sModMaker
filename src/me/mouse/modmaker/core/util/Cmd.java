package me.mouse.modmaker.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.JTextArea;

public class Cmd {
	public static void lineDos(String[] dos, JTextArea jt) {
		try {
			Process process = Runtime.getRuntime().exec("cmd");
			PrintWriter stdin = new PrintWriter(process.getOutputStream());
			for (String s : dos) {
				stdin.println(s);
			}
			stdin.close();
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String line;
			while ((line = stdInput.readLine()) != null)
				jt.append(line + "\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
