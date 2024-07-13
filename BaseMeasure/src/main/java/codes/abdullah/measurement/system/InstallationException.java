package codes.abdullah.measurement.system;

public class InstallationException extends IllegalArgumentException {
	private static final long serialVersionUID = -3902535042756895594L;

	public InstallationException() {
	}

	public InstallationException(String s) {
		super(s);
	}

	public InstallationException(String s, Throwable e) {
		super(s, e);
	}
}
