package codes.abdullah.io.attribute;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;

public interface IOAttributes {
	public static IOAttributes newAttributes(Path p) {
		return new IOLazyAttribute(p);
	}
	// =========================
	// =========================
	// =========================
	// =========================
	// ========================= BasicFileAttributes
	// =========================
	// =========================
	// =========================
	// =========================

	FileTime getLastModifiedTime() throws IOException;

	FileTime getLastAccessTime() throws IOException;

	FileTime getCreationTime() throws IOException;

	boolean isFile() throws IOException;

	boolean isDirectory() throws IOException;

	boolean isSymbolicLink() throws IOException;

	boolean isOther() throws IOException;

	long getSize() throws IOException;

	Object getFileKey() throws IOException;

	// =========================
	// =========================
	// =========================
	// =========================
	// ========================= BasicFileAttributeView
	// =========================
	// =========================
	// =========================
	// =========================

	IOAttributes setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) throws IOException;

	// =========================
	// =========================
	// =========================
	// =========================
	// ========================= DosFileAttributes
	// =========================
	// =========================
	// =========================
	// =========================

	boolean isReadable() throws IOException;

	boolean isWritable() throws IOException;

	boolean isExecutable() throws IOException;

	boolean isHidden() throws IOException;

//	boolean isArchive() throws IOException;

//	boolean isSystem() throws IOException;

	// =========================
	// =========================
	// =========================
	// =========================
	// ========================= DosFileAttributeView
	// =========================
	// =========================
	// =========================
	// =========================

	List<String> getNames() throws IOException;

	IOAttributes setReadable(boolean value) throws IOException;

	IOAttributes setWriteable(boolean value) throws IOException;

	IOAttributes setExecutable(boolean value) throws IOException;

	IOAttributes setHidden(boolean value) throws IOException;

//	IOAttributes setSystem(boolean value) throws IOException;

//	IOAttributes setArchive(boolean value) throws IOException;

	// =========================
	// =========================
	// =========================
	// =========================
	// ========================= FileOwnerAttributeView
	// =========================
	// =========================
	// =========================
	// =========================

	UserPrincipal getOwner() throws IOException;

	IOAttributes setOwner(UserPrincipal owner) throws IOException;

	// =========================
	// =========================
	// =========================
	// =========================
	// ========================= PosixFileAttributeView
	// =========================
	// =========================
	// =========================
	// =========================

//	IOAttributes setPermissions(Set<PosixFilePermission> perms) throws IOException;

	IOAttributes setGroup(GroupPrincipal group) throws IOException;

	// =========================
	// =========================
	// =========================
	// =========================
	// ========================= PosixFileAttributes
	// =========================
	// =========================
	// =========================
	// =========================

//	UserPrincipal owner() throws IOException;
//	GroupPrincipal group() throws IOException;

	GroupPrincipal getGroup() throws IOException;

//	Set<PosixFilePermission> permissions();

	// =========================
	// =========================
	// =========================
	// =========================
	// ========================= AclFileAttributeView
	// =========================
	// =========================
	// =========================
	// =========================

//	List<AclEntry> getAcl() throws IOException;

//	IOAttributes setAcl(List<AclEntry> acl) throws IOException;

	// =========================
	// =========================
	// =========================
	// =========================
	// =========================
	// =========================
	// =========================
	// =========================
	// =========================

	IOAttributes refresh() throws IOException;

}
