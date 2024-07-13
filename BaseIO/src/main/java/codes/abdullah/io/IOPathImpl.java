package codes.abdullah.io;

import java.net.URI;
import java.nio.file.Paths;

public class IOPathImpl {
	URI uri;

	public IOPathImpl(String path) {
		URI u = URI.create(path);
		if (u.getScheme() == null) {
			u = URI.create("file:///" + path);
		}
		
		System.out.println(uri.getPath());
		System.out.println(uri.getScheme());
	}

	public static void main(String[] args) {
		new IOPathImpl("path-to-file");
	}
}
