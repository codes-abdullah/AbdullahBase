package codes.abdullah.io;

public interface IOPath {
	IOName getName();

	IOPath resolve(String s);

	IOPath relativize();

	IODir asDir();

	IOFile asFile();

	boolean isAbsolute();

	IOPath toAbsolute();

	boolean startsWith(String s);

	boolean endsWith(String s);

}
