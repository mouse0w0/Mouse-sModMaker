package me.mouse.modmaker.core.file;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BaseInputStream implements Closeable {

	private final DataInputStream is;

	public BaseInputStream(final InputStream is) {
		this.is = new DataInputStream(is);
	}

	public BaseInputStream(final DataInputStream is) {
		this.is = is;
	}

	public String read() throws IOException {
		return is.readUTF();
	}

	@Override
	public void close() throws IOException {
		is.close();
	}

}
