package codes.abdullah.project;

public class ImplementationRequiredException extends IllegalStateException {

	private static final long serialVersionUID = 2103941149669317118L;

	
	public ImplementationRequiredException() {
		super("implamentation required");
	}
	
	public ImplementationRequiredException(String msg) {
		super("implamentation required, "+msg);
	}
}
