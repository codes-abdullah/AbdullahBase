package codes.abdullah.project;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class ExternalClassLoader {

	private final String srcDir, targetDir;
	private final URL[] urlarr;

	public ExternalClassLoader(String srcDir, String targetDir) throws IOException {
		Path s = Paths.get(srcDir);
		Path t = Paths.get(targetDir);
		if (!Files.exists(s))
			throw new NoSuchFileException(srcDir);
		if (!Files.exists(t))
			Files.createDirectories(t);
		this.srcDir = srcDir;
		this.targetDir = targetDir;
		this.urlarr = new URL[] { t.toUri().toURL() };
	}

	public String getSourceDir() {
		return srcDir;
	}

	public String getTargetDir() {
		return targetDir;
	}

	/**
	 * compile or recompile all source files from {@link #getSourceDir()} and move
	 * compiled files into {@link #getTargetDir()}
	 */
	public void compile() throws IOException {
		Path s = Paths.get(srcDir);
		Path t = Paths.get(targetDir);
		List<Path> l = Files
				.find(s, Integer.MAX_VALUE,
						(path, attr) -> attr.isRegularFile() && path.getFileName().toString().endsWith(".java"))
				.collect(Collectors.toList());

		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		for (int i = 0; i < l.size(); i++) {
			try {
				Path src = l.get(i);
				Path compiled = Paths.get(src.getParent().toString(),
						src.getFileName().toString().replace(".java", ".class"));
				Path target = t.resolve(compiled.subpath(s.getNameCount(), compiled.getNameCount()));

				if (!Files.exists(target)) {

//					System.out.println("compiling: " + src + " -> " + compiled);
					compiler.run(null, null, null, "-cp", srcDir, src.toString());
//					System.out.println("moving: " + compiled + " -> " + target);
					if (!Files.exists(target.getParent()))
						Files.createDirectories(target.getParent());
					Files.move(compiled, target, StandardCopyOption.REPLACE_EXISTING);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return new loaded class-loader
	 */
	public ClassLoader getClassLoader() throws MalformedURLException, ClassNotFoundException {
		return new URLClassLoader(urlarr);
	}

	public static void main(String[] args) throws Exception {
//		ExternalClassLoader e = new ExternalClassLoader();
//		File f = new File("/home/abod/junk/java/");
////				
//		URL url = new URL("http://localhost/java/");
//		System.out.println();
//		ClassLoader loader = ExternalClassLoader.class.getClassLoader();
//		URLClassLoader ucl = new URLClassLoader(new URL[] { url });
//		Class c = ucl.loadClass("sec.Sec");
//		Object o = c.newInstance();
//		o.getClass().getMethod("main", String[].class).invoke(o, new Object[] { new String[] { "" } });
//		System.out.println(c.getClassLoader());
//		Class.forName("bla.Bla", true, c.getClassLoader());

//		t1();

		ExternalClassLoader e = new ExternalClassLoader("/home/abod/junk/java/test/src",
				"/home/abod/junk/java/test/target/classes");
		e.compile();
//		Class c = e.getClassLoader().loadClass("codes.abdullah.project.T");
//		c.newInstance();

//		System.out.println(Project.getExecutionDir());
//		

//		System.out.println(Project.getSourceFile(Issue.class));

	}

	public static void t1() throws Exception {
		// Prepare source somehow.
		String source = "package test; public class Test { static { System.out.println(\"hello\"); } public Test() { System.out.println(\"world\"); } }";

		// Save source in .java file.
		File root = new File("/home/abod/junk/java"); // On Windows running on C:\, this is C:\java.
		File sourceFile = new File(root, "test/Test.java");
		sourceFile.getParentFile().mkdirs();
		Files.write(sourceFile.toPath(), source.getBytes(StandardCharsets.UTF_8));

		// Compile source file.
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		compiler.run(null, null, null, sourceFile.getPath());

		// Load and instantiate compiled class.
		URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { root.toURI().toURL() });
		Class<?> cls = Class.forName("test.Test", true, classLoader); // Should print "hello".
		Object instance = cls.newInstance(); // Should print "world".
		System.out.println(instance); // Should print "test.Test@hashcode".

	}

}
