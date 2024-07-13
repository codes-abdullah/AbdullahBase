package codes.abdullah.bigbit;

import java.util.Queue;

import codes.abdullah.chars.Chars;

public class LongBitsStack {
	private LongBitsStackOeprands t = new LongBitsStackOeprands();
	private long r;
	private CharSequence rname;

	public LongBitsStack() {
		this(0);
	}

	public LongBitsStack(long r) {
		this(r, "n1");
	}

	public LongBitsStack(long r, CharSequence rname) {
		this.r = r;
		this.rname = rname;
	}

	public LongBitsStack and(long n) {
		return and(n, null);
	}

	public LongBitsStack and(long n, CharSequence name) {
		return calcAndOffer(n, name, "&");
	}

	public LongBitsStack or(long n) {
		return or(n, null);
	}

	public LongBitsStack or(long n, CharSequence name) {
		return calcAndOffer(n, name, "|");
	}

	public LongBitsStack xor(long n) {
		return xor(n, null);
	}

	public LongBitsStack xor(long n, CharSequence name) {
		return calcAndOffer(n, name, "^");
	}

	public LongBitsStack not() {
		return calcAndOffer(0, null, "~");
	}

	public LongBitsStack shiftRight(int n) {
		return shiftRight(n, null);
	}

	public LongBitsStack shiftRight(int n, CharSequence name) {
		return calcAndOffer(n, name, ">>");
	}

	public LongBitsStack shiftLeft(int n) {
		return shiftLeft(n, null);
	}

	public LongBitsStack shiftLeft(int n, CharSequence name) {
		return calcAndOffer(n, name, "<<");
	}

	public LongBitsStack shiftRightUnsigned(int n) {
		return shiftRightUnsigned(n, null);
	}

	public LongBitsStack shiftRightUnsigned(int n, CharSequence name) {
		return calcAndOffer(n, name, ">>>");
	}
	// ---------
	// ---------
	// ---------
	// ---------

	public LongBitsStack andNot(long n) {
		return andNot(n, null);
	}

	public LongBitsStack andNot(long n, CharSequence name) {
		return calcAndOffer(n, name, "&~");
	}

	// ----------------------------

	public LongBitsStack add(long n) {
		return add(n, null);
	}

	public LongBitsStack add(long n, CharSequence name) {
		return calcAndOffer(n, name, "+");
	}

	public LongBitsStack sub(long n) {
		return sub(n, null);
	}

	public LongBitsStack sub(long n, CharSequence name) {
		return calcAndOffer(n, name, "-");
	}

	public LongBitsStack mul(long n) {
		return mul(n, null);
	}

	public LongBitsStack mul(long n, CharSequence name) {
		return calcAndOffer(n, name, "*");
	}

	public LongBitsStack div(long n) {
		return div(n, null);
	}

	public LongBitsStack div(long n, CharSequence name) {
		return calcAndOffer(n, name, "/");
	}

	public LongBitsStack mod(long n) {
		return add(n, null);
	}

	public LongBitsStack mod(long n, CharSequence name) {
		return calcAndOffer(n, name, "%");
	}

	// ----------------------------

	public Queue<Chars> calculate() {
		return t.calculate();
	}

	public LongBitsStack clear() {
		t.clear();
		return this;
	}

	public boolean isEmpty() {
		return t.isEmpty();
	}

	private LongBitsStack calcAndOffer(long n, CharSequence name, String ops) {
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
			t.shiftRightUnsigned(r, (int) n, rname, name);
			r = r >>> n;
		} else if (ops.contentEquals(">>")) {
			t.shiftRight(r, (int) n, rname, name);
			r = r >> n;
		} else if (ops.contentEquals("<<")) {
			t.shiftLeft(r, (int) n, rname, name);
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
			if(r == 0) {
				Chars c = Chars.of().repeat('0', LongBitsStackOeprands.size);
				return t.readable ? Chars.of().repeatAfterEach('_', Byte.SIZE, 1, true).toString() : c.toString();
			}
			rname = rname == null ? "r" : rname;					
			String str = Bits.of(r).toImmutable().toBinary(LongBitsStackOeprands.size, true, t.readable).toString();
			return String.format("%s%s: %s (%d)\n%s", rname, Chars.of().repeat(' ', BitsStackOeprands.name_space - 3), str, r,
					Chars.of().repeat('-', str.length() + 4));
		}
		Chars c = Chars.of();
		Queue<Chars> q = calculate();
		while (!q.isEmpty()) {
			c.append(q.poll()).ln(2);
		}
		return c.toString();
	}

	public static LongBitsStack of() {
		return new LongBitsStack(0);
	}

	public static LongBitsStack of(long r) {
		return new LongBitsStack(r);
	}

	public static LongBitsStack of(long r, CharSequence rname) {
		return new LongBitsStack(r, rname);
	}

	public LongBitsStack setReadable(boolean b) {
		t.readable = b;
		return this;
	}
}
