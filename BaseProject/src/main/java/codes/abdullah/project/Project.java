package codes.abdullah.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

public final class Project {

	private static String masterPackage = "codes.abdullah";
	private static final String WINDOWS_OS_FILE_NAME_FORBIDDEN_CHARS = "\"*/:<>?\\|";
	private static final String[] WINDOWS_OS_RESERVED_FILE_NAMES = { "AUX", " COM1", " COM2", " COM3", " COM4", " COM5",
			" COM6", " COM7", " COM8", " COM9", " CON", " LPT1", " LPT2", " LPT3", " LPT4", " LPT5", " LPT6", " LPT7",
			" LPT8", " LPT9", " NUL", " PRN" };
	private static final String unknown = "unknown";
	public static final boolean WINDOWS_OS;
	public static final boolean UNIX_OS;
	public static final boolean LINUX_OS;
	public static final boolean MAC_OS;
	public static final boolean SOLARIS_OS;
	public static final boolean DOS_LIKE_OS;
	public static final boolean UNIX_LIKE_OS;

	public static final int JRE_VERSION_INT;
	public static final String JRE_VERSION;
	public static final boolean EXPORTED;
	public static final int FILE_NAME_MAX_LENGTH;
	public static final int FILE_PATH_MAX_LENGTH;

	public static final Charset CHARSET;

	public synchronized static void setMasterPackage(String masterPackage) {
		Project.masterPackage = masterPackage;
	}

	public synchronized static String getMasterPackage() {
		return masterPackage;
	}

	static {
		String OS_NAME = System.getProperty("os.name", unknown).toLowerCase(Locale.US);
		WINDOWS_OS = (File.separatorChar == '\\' && OS_NAME.indexOf("win") >= 0);
		UNIX_OS = OS_NAME.indexOf("nix") >= 0;
		LINUX_OS = OS_NAME.indexOf("nux") >= 0;
		MAC_OS = (OS_NAME.indexOf("mac") >= 0 || OS_NAME.indexOf("darwin") >= 0);
		SOLARIS_OS = (OS_NAME.indexOf("solaris") >= 0 || OS_NAME.indexOf("sunos") >= 0);
		URL u = Project.class.getResource(Project.class.getSimpleName() + ".class");
		EXPORTED = !u.toString().startsWith("file:");
		JRE_VERSION_INT = findJreIntVersion();
		JRE_VERSION = System.getProperty("java.version");
		FILE_NAME_MAX_LENGTH = WINDOWS_OS ? 247 : 254;
		FILE_PATH_MAX_LENGTH = Short.MAX_VALUE - 20;
		CHARSET = Charset.forName(System.getProperty("sun.jnu.encoding", unknown));
		DOS_LIKE_OS = File.separatorChar == '\\';
		UNIX_LIKE_OS = File.separatorChar == '/';
	}

	/**
	 * validate a filename ONLY, not the entire path<br>
	 * will throw {@link IllegalArgumentException} if invalid filename
	 */
	public static void validateWindowsFilename(CharSequence filename) {
		if (filename == null)
			throw new NullPointerException("filename is null");
		if (filename.length() > FILE_NAME_MAX_LENGTH)
			throw new NullPointerException(
					"filename length(" + filename.length() + ") exceed the max (" + FILE_NAME_MAX_LENGTH + ")");
		if (filename.length() == 0)
			throw new IllegalArgumentException("filename is empty");
		if (Character.isWhitespace(filename.charAt(0)))
			throw new IllegalArgumentException("filename starts with space, found: " + filename);
		if (Character.isWhitespace(filename.charAt(filename.length() - 1)))
			throw new IllegalArgumentException("filename ends with space, found: " + filename);
		if (filename.charAt(filename.length() - 1) == '.')
			throw new IllegalArgumentException("filename ends with dot, found: " + filename);
		for (int i = 0; i < filename.length(); i++) {
			int ch = filename.charAt(i);
			if (ch != ':' && i != 1 && !isValidFilenameChar(ch)) {
				throw new IllegalArgumentException("filename contains forbidden char(" + filename.charAt(i) + ") at("
						+ i + "), found: " + filename);
			}
		}

		// check if reserved
		int i = Arrays.binarySearch(WINDOWS_OS_RESERVED_FILE_NAMES, filename.toString().toUpperCase(Locale.US));

		if (i >= 0)
			throw new IllegalArgumentException("filename is reserved by OS, found: " + filename);

		// split it by dots
		String[] parts = filename.toString().split(".");
		if (parts.length == 0)
			return;

		// and check if first part is reserved
		i = Arrays.binarySearch(WINDOWS_OS_RESERVED_FILE_NAMES, parts[0].toUpperCase(Locale.US));
		if (i >= 0)
			throw new IllegalArgumentException("filename is reserved, found: " + filename);

	}

	public static boolean isValidWindowsFilenameChar(int ch) {
		return WINDOWS_OS_FILE_NAME_FORBIDDEN_CHARS.indexOf(ch) < 0 && ch >= 0x20;
	}

	public static boolean isValidUnixFilenameChar(int ch) {
		return ch != '/' && ch != '\\' && ch >= 0x20;
	}

	public static boolean isValidFilenameChar(int ch) {
		// \u0020 = 32 = space
		if (WINDOWS_OS)
			return isValidWindowsFilenameChar(ch);
		else
			// in unix-like os, it's allowed to use below 32
			return isValidUnixFilenameChar(ch);
	}

	public static List<InetAddress> getLanAddresses() throws SocketException {
		List<InetAddress> l = new ArrayList<InetAddress>();
		for (final Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces(); interfaces
				.hasMoreElements();) {
			final NetworkInterface cur = interfaces.nextElement();

			if (cur.isLoopback()) {
				continue;
			}

			for (final InterfaceAddress addr : cur.getInterfaceAddresses()) {
				final InetAddress inet_addr = addr.getAddress();

				if (!(inet_addr instanceof Inet4Address)) {
					continue;
				}
				l.add(inet_addr);
			}
		}
		return l;
	}

	public static InetAddress getLanAddress() throws SocketException {
		for (final Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces(); interfaces
				.hasMoreElements();) {
			final NetworkInterface cur = interfaces.nextElement();

			if (cur.isLoopback()) {
				continue;
			}

			for (final InterfaceAddress addr : cur.getInterfaceAddresses()) {
				final InetAddress inet_addr = addr.getAddress();

				if (!(inet_addr instanceof Inet4Address)) {
					continue;
				}
				// return first result
				return inet_addr;
			}
		}
		return null;
	}

	/**
	 * usage: if src/main/resources present: (running from IDE)<br>
	 * i.e: file.txt<br>
	 * i.e: strings/string.properties
	 * <p>
	 * if running from jar, this method will insert resources namespace
	 * automatically, i.e:<br>
	 * i.e: resources/file.txt<br>
	 * i.e: resources/strings/string.properties
	 */
	public static URL getResource(String filepath) throws IOException {
		filepath = resolveResourcePath(filepath);
		URL in = Project.class.getClassLoader().getResource(filepath);
		if (in == null)
			in = Thread.currentThread().getContextClassLoader().getResource(filepath);
		if (in == null)
			in = Project.class.getResource(filepath);
		if (in == null)
			throw new IOException("invalid filepath or not exists:, filepath: " + filepath);
		return in;
	}

	public static InputStream getResourceAsStream(String filepath) throws IOException {
		return getResource(filepath).openStream();
	}

	public static InputStream getSilentResourceAsStream(String filepath) {
		try {
			return getResourceAsStream(filepath);
		} catch (Exception e) {
		}
		return null;
	}

	public static URL getSilentResource(String filepath) {
		try {
			return getResource(filepath);
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * insert resources/ to given string only if {@link #RUNNING_FROM_JAR} <br>
	 * example: langs/strings -> resources/langs/strings
	 */
	public static String resolveResourcePath(String s) {
		return EXPORTED ? ("resources/" + s) : s;
	}

	/**
	 * insert resources/ to given array only if {@link #RUNNING_FROM_JAR}
	 * 
	 * @see #resolveResourcePath(String)
	 */
	public static String[] resolveResourcePaths(String[] arr) {
		String[] a = new String[arr.length];
		for (int i = 0; i < a.length; i++)
			a[i] = resolveResourcePath(arr[i]);
		return a;
	}

	/**
	 * @return <br>
	 *         executed file, i.e: <br>
	 *         IDE: bla.pkg.Main<br>
	 *         Jar: C:\Users\mradf\Desktop\tst\XXX.jar
	 */
	public static String getExecutedFile() {
		return System.getProperty("sun.java.command", unknown);
	}

	/**
	 * @return execution dir, i.e: <br>
	 *         IDE: C:\Eclipse\JEEOxygen2v472\workspace\BasePathAPI<br>
	 *         Jar: C:\Users\mradf\Desktop\tst
	 */
	public static String getExecutionDir() {
		return System.getProperty("user.dir", unknown);
	}

	public static String getUserhome() {
		return System.getProperty("user.home", unknown);
	}

	private static int findJreIntVersion() {
		String version = System.getProperty("java.version");
		if (version.startsWith("1.")) {
			version = version.substring(2, 3);
		} else {
			int dot = version.indexOf(".");
			if (dot != -1) {
				version = version.substring(0, dot);
			}
		}
		return Integer.parseInt(version);
	}

	/**
	 * Scans all classes accessible from the context class loader which belong to
	 * the given package and subpackages.
	 *
	 * @param packageName The base package
	 * @return The classes
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static Class<?>[] getClasses(String packageName) throws ClassNotFoundException, IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		assert classLoader != null;
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}
		ArrayList<Class<?>> classes = new ArrayList<>();
		for (File directory : dirs) {
			classes.addAll(findClasses(directory, packageName));
		}
		return classes.toArray(new Class[classes.size()]);
	}

	/**
	 * Recursive method used to find all classes in a given directory and subdirs.
	 *
	 * @param directory   The base directory
	 * @param packageName The package name for classes found inside the base
	 *                    directory
	 * @return The classes
	 * @throws ClassNotFoundException
	 */
	private static List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
		List<Class<?>> classes = new ArrayList<>();
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file, packageName + "." + file.getName()));
			} else if (file.getName().endsWith(".class")) {
				classes.add(
						Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
			}
		}
		return classes;
	}

	
	
	public static File getSourceFile(Class<?> cls) throws FileNotFoundException {
		String fqn = cls.getName().replaceAll("\\.", "/");
		File f = new File(cls.getProtectionDomain().getCodeSource().getLocation().getPath());

		// eclipse/ant project
		if (f.getName().equals("bin")) {
			f = new File(f.getParent(), String.format("src/%s.java", fqn));
			if (f.exists())
				return f;
		}

		// maven
		if (f.toString().endsWith("/target/classes")) {
			f = new File(f.getParentFile().getParent(), String.format("src/main/java/%s.java", fqn));
			if (f.exists())
				return f;
		}

		throw new FileNotFoundException("can't find source file of " + cls.getName());

	}

}
