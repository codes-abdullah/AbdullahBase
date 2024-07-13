package codes.abdullah.bigbit;

import java.util.Queue;

import codes.abdullah.chars.Chars;

public class BitsStack {
	private BitsStackOeprands t = new BitsStackOeprands();
	private int r;
	private CharSequence rname;

	public BitsStack() {
		this(0);
	}

	public BitsStack(int r) {
		this(r, "n1");
	}

	public BitsStack(int r, CharSequence rname) {
		this.r = r;
		this.rname = rname;
	}

	public BitsStack and(int n) {
		return and(n, null);
	}

	public BitsStack and(int n, CharSequence name) {
		return calcAndOffer(n, name, "&");
	}

	public BitsStack or(int n) {
		return or(n, null);
	}

	public BitsStack or(int n, CharSequence name) {
		return calcAndOffer(n, name, "|");
	}

	public BitsStack xor(int n) {
		return xor(n, null);
	}

	public BitsStack xor(int n, CharSequence name) {
		return calcAndOffer(n, name, "^");
	}

	public BitsStack not() {
		return calcAndOffer(0, null, "~");
	}

	public BitsStack shr(int n) {
		return shr(n, null);
	}

	public BitsStack shr(int n, CharSequence name) {
		return calcAndOffer(n, name, ">>");
	}

	public BitsStack shl(int n) {
		return shl(n, null);
	}

	public BitsStack shl(int n, CharSequence name) {
		return calcAndOffer(n, name, "<<");
	}

	public BitsStack ushr(int n) {
		return ushr(n, null);
	}

	public BitsStack ushr(int n, CharSequence name) {
		return calcAndOffer(n, name, ">>>");
	}
	// ---------
	// ---------
	// ---------
	// ---------

	public BitsStack andNot(int n) {
		return andNot(n, null);
	}

	public BitsStack andNot(int n, CharSequence name) {
		return calcAndOffer(n, name, "&~");
	}

	// ----------------------------

	public BitsStack add(int n) {
		return add(n, null);
	}

	public BitsStack add(int n, CharSequence name) {
		return calcAndOffer(n, name, "+");
	}

	public BitsStack sub(int n) {
		return sub(n, null);
	}

	public BitsStack sub(int n, CharSequence name) {
		return calcAndOffer(n, name, "-");
	}

	public BitsStack mul(int n) {
		return mul(n, null);
	}

	public BitsStack mul(int n, CharSequence name) {
		return calcAndOffer(n, name, "*");
	}

	public BitsStack div(int n) {
		return add(n, null);
	}

	public BitsStack div(int n, CharSequence name) {
		return calcAndOffer(n, name, "/");
	}

	public BitsStack mod(int n) {
		return add(n, null);
	}

	public BitsStack mod(int n, CharSequence name) {
		return calcAndOffer(n, name, "%");
	}

	// ----------------------------

	public Queue<Chars> calculate() {
		return t.calculate();
	}

	public BitsStack clear() {
		t.clear();
		return this;
	}

	public boolean isEmpty() {
		return t.isEmpty();
	}

	private BitsStack calcAndOffer(int n, CharSequence name, String ops) {
		if (ops.contentEquals("&")) {
			t.and(r, n, rname, name);
			r = r & n;
		} else if (ops.contentEquals("|")) {
			t.or(r, n, rname, name);
			r = r | n;
		} else if (ops.contentEquals("^")) {
			t.xor(r, n, rname, name);
			r = r ^ n;
		} else if (ops.contentEquals(">>>")) {
			t.shiftRightUnsigned(r, n, rname, name);
			r = r >>> n;
		} else if (ops.contentEquals(">>")) {
			t.shiftRight(r, n, rname, name);
			r = r >> n;
		} else if (ops.contentEquals("<<")) {
			t.shiftLeft(r, n, rname, name);
			r = r << n;
		} else if (ops.contentEquals("~")) {
			t.not(r, rname);
			r = ~r;
		} else if (ops.contentEquals("&~")) {
			t.andNot(r, n, rname, name);
			r = r & ~n;
		} else if (ops.contentEquals("+")) {
			t.add(r, n, rname, name);
			r = r + n;
		} else if (ops.contentEquals("-")) {
			t.sub(r, n, rname, name);
			r = r - n;
		} else if (ops.contentEquals("*")) {
			t.mul(r, n, rname, name);
			r = r * n;
		} else if (ops.contentEquals("/")) {
			t.div(r, n, rname, name);
			r = r / n;
		} else if (ops.contentEquals("%")) {
			t.mod(r, n, rname, name);
			r = r % n;
		} else {
			throw new UnsupportedOperationException(ops);
		}
		return this;
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			String str = Bits.of(r).toBinary(BitsStackOeprands.size, true, t.readable).toString();
			return String.format("r%s: %s (%d)\n%s", Chars.of().repeat(' ', BitsStackOeprands.name_space - 3), str, r,
					Chars.of().repeat('-', str.length() + 4));
		}
		Chars c = Chars.of();
		Queue<Chars> q = calculate();
		while (!q.isEmpty()) {
			c.append(q.poll()).ln(2);
		}
		return c.toString();
	}
	
	public BitsStack setReadable(boolean b) {
		t.readable = b;
		return this;
	}

	public static BitsStack of() {
		return new BitsStack(0);
	}

	public static BitsStack of(int r) {
		return new BitsStack(r);
	}

	public static BitsStack of(int r, CharSequence rname) {
		return new BitsStack(r, rname);
	}

}
