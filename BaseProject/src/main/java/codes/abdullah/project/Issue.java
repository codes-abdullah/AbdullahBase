package codes.abdullah.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

public class Issue {
	private final boolean printStack;
	private Throwable e;
	private String extra;
	private static final String MASTER_PACKAGE = "codes.abdullah";

	public Issue(Throwable e) {
		this(e, MASTER_PACKAGE, true);
	}

	public Issue(Throwable e, boolean enableConsolePrint) {
		this(e, MASTER_PACKAGE, null, enableConsolePrint);
	}

	public Issue(Throwable e, String masterPackage, boolean enableConsolePrint) {
		this(e, masterPackage, null, enableConsolePrint);
	}

	public Issue(Throwable e, String masterPackage, String extra) {
		this(e, masterPackage, extra, true);
	}

	public Issue(Throwable e, String masterPackage, String extra, boolean enableConsolePrint) {
		this.printStack = enableConsolePrint;
		this.e = e;
		this.extra = extra;
		filter(e, "codes.abdullah");
	}

	private void filter(Throwable x, String masterPackage) {
		Throwable cause = getCause();
		StackTraceElement[] ste = e.getStackTrace();
		List<StackTraceElement> l = new ArrayList<StackTraceElement>();

		for (int i = 0; i < ste.length; i++) {
			if (i < 2 || ste[i].toString().contains(masterPackage))
				l.add(ste[i]);
		}

		ste = l.toArray(new StackTraceElement[l.size()]);
		e.setStackTrace(ste);
		if (cause != null) {
			e.getCause().setStackTrace(cause.getStackTrace());
		}

		if (printStack)
			LoggerFactory.getLogger(getClass())
					.error("issue occured: " + ((extra == null) ? "" : "[" + extra + "]") + "", x);

	}

	public StackTraceElement[] getStackTrace() {
		return e.getStackTrace();
	}

	private Throwable getCause() {
		if (e.getCause() == null)
			return null;
		Issue i = new Issue(e.getCause(), false);
		return i.getThrowable();
	}

	public Throwable getThrowable() {
		return e;
	}

	public static String of(Throwable t) {
		return new Issue(t, false).toStringStackTrace();
	}

	public void print() {
		LoggerFactory.getLogger(getClass()).error("issue occured: ", e);
	}

	public String toStringStackTrace() {
		return getStringStackTrace(e);
	}

	public static String getStringStackTrace(Throwable x) {
		StringWriter s = new StringWriter();
		PrintWriter p = new PrintWriter(s);
		x.printStackTrace(p);
		String stack = s.toString();

		try {
			if (s != null) {
				s.flush();
				s.close();
			}
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		if (p != null) {
			p.flush();
			p.close();
		}
		return stack;
	}

	public String getMessage() {
		String m = e.getMessage();
		if (e.getCause() != null)
			m += ", " + e.getCause().getMessage();
		return m;
	}

	@Override
	public String toString() {
		return getMessage() + "\n" + toStringStackTrace();
	}

}
