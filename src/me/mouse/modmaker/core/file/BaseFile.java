package me.mouse.modmaker.core.file;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public class BaseFile extends File {

	private static final long serialVersionUID = 1L;

	public BaseFile(File parent, String child) throws IOException {
		super(parent, child);
		if (!exists()) {
			if (!getParentFile().exists()) {
				getParentFile().mkdirs();
			}
			createNewFile();
		}
	}

	public BaseFile(String parent, String child) throws IOException {
		super(parent, child);
		if (!exists()) {
			if (!getParentFile().exists()) {
				getParentFile().mkdirs();
			}
			createNewFile();
		}
	}

	public BaseFile(String pathname) throws IOException {
		super(pathname);
		if (!exists()) {
			if (!getParentFile().exists()) {
				getParentFile().mkdirs();
			}
			createNewFile();
		}
	}

	public BaseFile(URI uri) throws IOException {
		super(uri);
		if (!exists()) {
			if (!getParentFile().exists()) {
				getParentFile().mkdirs();
			}
			createNewFile();
		}
	}

}
