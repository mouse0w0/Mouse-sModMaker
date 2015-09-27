package me.mouse.modmaker.core.file;

import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BaseWriter implements Closeable {

	private final FileWriter fw;

	public BaseWriter(final String file) throws IOException {
		fw = new FileWriter(file);
	}

	public BaseWriter(final File file) throws IOException {
		fw = new FileWriter(file);
	}

	public BaseWriter(final FileWriter fw) {
		this.fw = fw;
	}

	public void write(String arg) throws IOException {
		fw.write(arg+"\r\n");
	}

	@Override
	public void close() throws IOException {
		fw.close();
	}

}
