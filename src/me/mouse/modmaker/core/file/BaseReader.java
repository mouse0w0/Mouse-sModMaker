package me.mouse.modmaker.core.file;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BaseReader implements Closeable {

	private final BufferedReader br;

	public BaseReader(String file) throws FileNotFoundException {
		br = new BufferedReader(
				new InputStreamReader(new FileInputStream(file)));
	}

	public BaseReader(final File file) throws FileNotFoundException {
		br = new BufferedReader(
				new InputStreamReader(new FileInputStream(file)));
	}

	public BaseReader(final InputStream is) {
		br = new BufferedReader(new InputStreamReader(is));
	}

	public BaseReader(final BufferedReader br) {
		this.br = br;
	}

	public String readAll() throws IOException {
		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			builder.append(line);
			builder.append("/n");
		}
		return builder.toString();
	}

	public String readLine() throws IOException {
		return br.readLine();
	}

	@Override
	public void close() throws IOException {
		br.close();
	}

}
