package codes.abdullah.io.attribute;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AclFileAttributeView;

class Rwx {
	private boolean writable, readable, executable;

	public Rwx(boolean writable, boolean readable, boolean executable) {
		this.writable = writable;
		this.readable = readable;
		this.executable = executable;
	}

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("../b2");
		System.out.println(path.normalize());
		
		System.out.println(path.relativize(Paths.get(System.getProperty("user.dir", "unknwon"))));

	}

	public boolean isWritable() {
		return writable;
	}

	public void setWritable(boolean writable) {
		this.writable = writable;
	}

	public boolean isReadable() {
		return readable;
	}

	public void setReadable(boolean readable) {
		this.readable = readable;
	}

	public boolean isExecutable() {
		return executable;
	}

	public void setExecutable(boolean executable) {
		this.executable = executable;
	}

}
