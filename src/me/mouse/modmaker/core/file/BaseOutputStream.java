package me.mouse.modmaker.core.file;

import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BaseOutputStream implements Closeable {

	private final DataOutputStream os;

	public BaseOutputStream(final OutputStream os) {
		this.os = new DataOutputStream(os);
	}

	public BaseOutputStream(final DataOutputStream os) {
		this.os = os;
	}

	public void write(String arg) throws IOException {
		os.writeUTF(arg);
	}

	@Override
	public void close() throws IOException {
		os.close();
	}

}
