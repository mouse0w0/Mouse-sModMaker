package me.mouse.modmaker.core.resources;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import me.mouse.modmaker.core.Main;
import me.mouse.modmaker.core.file.BaseReader;

public class Language {

	private final Map<String, String> language = new HashMap<String, String>();

	public Language() throws IOException{
		File file = new File("resources/language/"
				+ Main.getDefaultLanguage() + ".lang");
		BaseReader br = new BaseReader(file);
		String read = br.readAll();
		for (String s1 : read.split("/n")) {
			if (!s1.startsWith("#")) {
				String[] s2 = s1.split("=", 2);
				language.put(s2[0], s2[1]);
			}
		}
		br.close();
	}

	public Language(String language) throws IOException{
		File file = new File("resources/language/" + language + ".lang");
		BaseReader br = new BaseReader(file);
		String read = br.readAll();
		for (String s1 : read.split("/n")) {
			if (!s1.startsWith("#")) {
				String[] s2 = s1.split("=", 2);
				this.language.put(s2[0], s2[1]);
			}
		}
		br.close();
	}

	public String get(String key) {
		return language.get(key);
	}
	
	public static Map<String,String> getAllLanguage(){
		Map<String,String> map = new HashMap<String, String>();
		String[] list = new File("resources/language/").list();
		for(String s:list){
			if(s.endsWith(".lang")){
				try {
					Language lang = new Language(s.replaceFirst(".lang", ""));
					map.put(lang.get("language"),s.replaceFirst(".lang", ""));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}
	
	public static Map<String,String> getAllDisplayLanguage(){
		Map<String,String> map = new HashMap<String, String>();
		String[] list = new File("resources/language/").list();
		for(String s:list){
			if(s.endsWith(".lang")){
				try {
					Language lang = new Language(s.replaceFirst(".lang", ""));
					map.put(s.replaceFirst(".lang", ""),lang.get("language"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}
	
	public static int getAllLanguageNumber(){
		return new File("resources/language/").list().length;
	}
	
	public static String getLanguageDisplay(String arg){
		return getAllDisplayLanguage().get(arg);
	}
}
