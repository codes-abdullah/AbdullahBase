package codes.abdullah.io.attribute;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclEntryType;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.AttributeView;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class IOLazyAttribute implements IOAttributes {
	private BasicFileAttributes basic;
	private DosFileAttributes dos;
	private PosixFileAttributes posix;

	private BasicFileAttributeView basicView;
	private DosFileAttributeView dosView;
	private PosixFileAttributeView posixView;

	private AclFileAttributeView aclView;
	private FileOwnerAttributeView ownerView;
	private List<String> names;
	private Rwx rwx;
	private static final boolean isunix = File.separatorChar == '/';
	private static final String NTFS_KEY_AUTHENTICATED_USERS = "NT AUTHORITY\\Authenticated Users";
	private Path path;
	private LinkOption linkOption;

	public IOLazyAttribute(Path path) {
		this(path, null);
	}

	public IOLazyAttribute(Path path, LinkOption linkOption) {
		this.path = path;
		this.linkOption = linkOption;
	}

	private BasicFileAttributes getBasic() throws IOException {
		if (basic == null)
			basic = Files.readAttributes(path, BasicFileAttributes.class, linkOption);
		return basic;
	}

	private BasicFileAttributeView getBasicView() throws IOException {
		if (basicView == null)
			basicView = Files.getFileAttributeView(path, BasicFileAttributeView.class, linkOption);
		return basicView;
	}

	public DosFileAttributes getDos() throws IOException {
		if (dos == null)
			dos = Files.readAttributes(path, DosFileAttributes.class, linkOption);
		return dos;
	}

	private DosFileAttributeView getDosView() throws IOException {
		if (basicView == null)
			dosView = Files.getFileAttributeView(path, DosFileAttributeView.class, linkOption);
		return dosView;
	}

	public PosixFileAttributes getPosix() throws IOException {
		if (posix == null)
			posix = Files.readAttributes(path, PosixFileAttributes.class, linkOption);
		return posix;
	}

	private PosixFileAttributeView getPosixView() throws IOException {
		if (posixView == null)
			posixView = Files.getFileAttributeView(path, PosixFileAttributeView.class, linkOption);
		return posixView;
	}

	private FileOwnerAttributeView getOwnerView() throws IOException {
		if (ownerView == null)
			ownerView = Files.getFileAttributeView(path, FileOwnerAttributeView.class, linkOption);
		return ownerView;
	}

	private AclFileAttributeView getAclView() throws IOException {
		if (aclView == null)
			aclView = Files.getFileAttributeView(path, AclFileAttributeView.class, linkOption);
		return aclView;
	}

	private Rwx getRwx() throws IOException {
		if (rwx == null)
			rwx = new Rwx(Files.isWritable(path), Files.isReadable(path), Files.isExecutable(path));
		return rwx;
	}

	@Override
	public IOAttributes refresh() throws IOException {
		if (basic != null)
			basic = Files.readAttributes(path, BasicFileAttributes.class, linkOption);

		if (basicView != null)
			basicView = Files.getFileAttributeView(path, BasicFileAttributeView.class, linkOption);

		if (dos != null)
			dos = Files.readAttributes(path, DosFileAttributes.class, linkOption);

		if (basicView != null)
			dosView = Files.getFileAttributeView(path, DosFileAttributeView.class, linkOption);

		if (posix != null)
			posix = Files.readAttributes(path, PosixFileAttributes.class, linkOption);

		if (posixView != null)
			posixView = Files.getFileAttributeView(path, PosixFileAttributeView.class, linkOption);

		if (ownerView != null)
			ownerView = Files.getFileAttributeView(path, FileOwnerAttributeView.class, linkOption);

		if (aclView != null)
			aclView = Files.getFileAttributeView(path, AclFileAttributeView.class, linkOption);

		return this;
	}

	private static void updatePosixPermission(PosixFileAttributes attrs, PosixFileAttributeView view,
			PosixFilePermission permission, boolean set) throws IOException {
		Set<PosixFilePermission> p = attrs.permissions();
		if (set)
			p.add(PosixFilePermission.OWNER_WRITE);
		else
			p.remove(PosixFilePermission.OWNER_WRITE);
		view.setPermissions(p);
	}

	private static void updateAclPermission(AclFileAttributeView view, AclEntryPermission permission, boolean set)
			throws IOException {
		List<AclEntry> acls = view.getAcl();
		for (int i = 0; i < acls.size(); i++) {
			UserPrincipal principal = acls.get(i).principal();
			String principalName = principal.getName();
			if (principalName.equals(NTFS_KEY_AUTHENTICATED_USERS)) {
				Set<AclEntryPermission> permissions = acls.get(i).permissions();

				if (set)
					permissions.add(permission);
				else
					permissions.remove(permission);
				AclEntry entry = AclEntry.newBuilder().setType(AclEntryType.ALLOW).setPrincipal(principal)
						.setPermissions(permissions).build();
				acls.set(i, entry);
			}
		}
		view.setAcl(acls);
	}

	private static void addName(List<String> names, AttributeView av) {
		if (av != null && !names.contains(av.name()))
			names.add(av.name());
	}

	@Override
	public FileTime getLastModifiedTime() throws IOException {
		return getBasic().lastModifiedTime();
	}

	@Override
	public FileTime getLastAccessTime() throws IOException {
		return getBasic().lastAccessTime();
	}

	@Override
	public FileTime getCreationTime() throws IOException {
		return getBasic().creationTime();
	}

	@Override
	public boolean isFile() throws IOException {
		return getBasic().isRegularFile();
	}

	@Override
	public boolean isDirectory() throws IOException {
		return getBasic().isDirectory();
	}

	@Override
	public boolean isSymbolicLink() throws IOException {
		return getBasic().isSymbolicLink();
	}

	@Override
	public boolean isOther() throws IOException {
		return getBasic().isOther();
	}

	@Override
	public long getSize() throws IOException {
		return getBasic().size();
	}

	@Override
	public Object getFileKey() throws IOException {
		return getBasic().fileKey();
	}

	@Override
	public IOAttributes setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime)
			throws IOException {
		getBasicView().setTimes(lastModifiedTime, lastAccessTime, createTime);
		return this;
	}

	@Override
	public boolean isReadable() throws IOException {
		return getRwx().isReadable();
	}

	@Override
	public boolean isWritable() throws IOException {
		return getRwx().isWritable();
	}

	@Override
	public boolean isExecutable() throws IOException {
		return getRwx().isExecutable();
	}

	@Override
	public boolean isHidden() throws IOException {
		return getDos().isHidden();
	}

	@Override
	public List<String> getNames() throws IOException {
		if (names == null)
			names = new ArrayList<>();

		addName(names, basicView);
		addName(names, dosView);
		addName(names, posixView);
		addName(names, aclView);
		addName(names, ownerView);

		return names;
	}

	@Override
	public IOAttributes setReadable(boolean b) throws IOException {
		if (isunix) {
			updatePosixPermission(getPosix(), getPosixView(), PosixFilePermission.OWNER_READ, b);
		} else {
			updateAclPermission(getAclView(), AclEntryPermission.READ_DATA, b);
		}
		return this;
	}

	@Override
	public IOAttributes setExecutable(boolean b) throws IOException {
		if (isunix) {
			updatePosixPermission(getPosix(), getPosixView(), PosixFilePermission.OWNER_EXECUTE, b);
		} else {
			updateAclPermission(getAclView(), AclEntryPermission.EXECUTE, b);
		}
		return this;
	}

	@Override
	public IOAttributes setWriteable(boolean b) throws IOException {
		if (isunix) {
			updatePosixPermission(getPosix(), getPosixView(), PosixFilePermission.OWNER_WRITE, b);
		} else {
			updateAclPermission(getAclView(), AclEntryPermission.WRITE_DATA, b);
		}
		return this;
	}

	@Override
	public IOAttributes setHidden(boolean b) throws IOException {
		if (isunix) {
			String name = path.getFileName().toString();
			if (b && name.charAt(0) != '.') {
				name = "." + name;
			} else if (!b && name.charAt(0) == '.') {
				name = name.substring(1);
			} else {
				return this;
			}
			Path path2 = path.getParent().resolve(name);
			Files.move(path, path2);
			path = path2;
			return this;
		}
		getDosView().setHidden(b);
		return this;
	}

	@Override
	public IOAttributes setOwner(UserPrincipal owner) throws IOException {
		if (isunix)
			getPosixView().setOwner(owner);
		getOwnerView().setOwner(owner);
		return this;
	}

	@Override
	public UserPrincipal getOwner() throws IOException {
		if (isunix)
			getPosix().owner();
		return getOwnerView().getOwner();
	}

	@Override
	public IOAttributes setGroup(GroupPrincipal group) throws IOException {
		if (isunix)
			getPosixView().setGroup(group);
		return this;
	}

	@Override
	public GroupPrincipal getGroup() throws IOException {
		if (isunix)
			return getPosix().group();
		return null;
	}

}
