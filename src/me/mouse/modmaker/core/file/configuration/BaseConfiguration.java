package me.mouse.modmaker.core.file.configuration;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import me.mouse.modmaker.core.file.BaseReader;
import me.mouse.modmaker.core.file.BaseWriter;

public class BaseConfiguration {

	protected Map<String, String> map = new LinkedHashMap<String, String>();
	private boolean first = false;

	public BaseConfiguration(final File file) throws IOException {
		if(file.exists()){
		try {
			BaseReader br = new BaseReader(file);
			String data = br.readAll();
			for (String s : data.split("/n")) {
				if (!s.startsWith("#")) {
					String[] args = s.split(":", 2);
					map.put(args[0], args[1]);
				}
			}
			br.close();
			first = false;
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
		}else{
			if(!file.getParentFile().exists()){
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
			first = true;
		}
	}

	public String get(String key) {
		return map.get(key);
	}

	public void set(String key, String value) {
		map.remove(key);
		map.put(key, value);
	}

	public Set<String> getKeySet() {
		return map.keySet();
	}

	public void save(final File file) {
		try {
			BaseWriter bw = new BaseWriter(file);
			for (String s : map.keySet()) {
				bw.write(s + ":" + map.get(s));
			}
			bw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public boolean getFirstCreateFile(){
		return first;
	}
}
