package codes.abdullah.io;

class IONameImpl implements IOName {

	private String name, extension;

	public IONameImpl(String name) {
		this.name = name;
		int i = name.lastIndexOf('.');
		if (i > 0) {
			this.extension = name.substring(i + 1);
			this.name = name.substring(0, i);
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getExtension() {
		return extension;
	}

	@Override
	public boolean hasExtension() {
		return extension != null;
	}

	@Override
	public String toString() {
		if (extension == null)
			return name;
		return name + "." + extension;
	}

}
