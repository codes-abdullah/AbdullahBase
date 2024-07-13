package codes.abdullah.bigbit;

import java.util.LinkedList;
import java.util.Queue;

import codes.abdullah.chars.Chars;
import codes.abdullah.project.lang.Lang;

class LongBitsStackOeprands {
	private Queue<CharSequence> name1list = new LinkedList<>();
	private Queue<CharSequence> name2list = new LinkedList<>();
	private Queue<Long> n1list = new LinkedList<>();
	private Queue<Long> n2list = new LinkedList<>();
	private Queue<CharSequence> olist = new LinkedList<>();
	static final int name_max_length = 6;
	static final int name_space = name_max_length + 2;
	static final int size = 64;
	boolean readable = true;

	public LongBitsStackOeprands and(long n1, long n2) {
		return and(n1, n2, null);
	}

	public LongBitsStackOeprands and(long n1, long n2, CharSequence name1) {
		return and(n1, n2, name1, null);
	}

	public LongBitsStackOeprands and(long n1, long n2, CharSequence name1, CharSequence name2) {
		return offer(n1, n2, "&", name1, name2);
	}

	public LongBitsStackOeprands or(long n1, long n2) {
		return or(n1, n2, null);
	}

	public LongBitsStackOeprands or(long n1, long n2, CharSequence name1) {
		return or(n1, n2, name1, null);
	}

	public LongBitsStackOeprands or(long n1, long n2, CharSequence name1, CharSequence name2) {
		return offer(n1, n2, "|", name1, name2);
	}

	public LongBitsStackOeprands xor(long n1, long n2) {
		return xor(n1, n2, null);
	}

	public LongBitsStackOeprands xor(long n1, long n2, CharSequence name1) {
		return xor(n1, n2, name1, null);
	}

	public LongBitsStackOeprands xor(long n1, long n2, CharSequence name1, CharSequence name2) {
		return offer(n1, n2, "^", name1, name2);
	}

	public LongBitsStackOeprands not(long n) {
		return not(n, null);
	}

	public LongBitsStackOeprands not(long n, CharSequence name) {
		return offer(n, 0, "~", name, null);
	}

	public LongBitsStackOeprands shiftRight(long n1, int n2) {
		return shiftRight(n1, n2, null);
	}

	public LongBitsStackOeprands shiftRight(long n1, int n2, CharSequence name1) {
		return shiftRight(n1, n2, name1, null);
	}

	public LongBitsStackOeprands shiftRight(long n1, int n2, CharSequence name1, CharSequence name2) {
		return offer(n1, n2, ">>", name1, name2);
	}

	public LongBitsStackOeprands shiftLeft(long n1, int n2) {
		return shiftLeft(n1, n2, null);
	}

	public LongBitsStackOeprands shiftLeft(long n1, int n2, CharSequence name1) {
		return shiftLeft(n1, n2, name1, null);
	}

	public LongBitsStackOeprands shiftLeft(long n1, int n2, CharSequence name1, CharSequence name2) {
		return offer(n1, n2, "<<", name1, name2);
	}

	public LongBitsStackOeprands shiftRightUnsigned(long n1, int n2) {
		return shiftRightUnsigned(n1, n2, null);
	}

	public LongBitsStackOeprands shiftRightUnsigned(long n1, int n2, CharSequence name1) {
		return shiftRightUnsigned(n1, n2, name1, null);
	}

	public LongBitsStackOeprands shiftRightUnsigned(long n1, int n2, CharSequence name1, CharSequence name2) {
		return offer(n1, n2, ">>>", name1, name2);
	}

	// ---------
	// ---------
	// ---------
	// ---------
	// ---------

	public LongBitsStackOeprands add(long n1, long n2, CharSequence name1, CharSequence name2) {
		return offer(n1, n2, "+", name1, name2);
	}

	public LongBitsStackOeprands sub(long n1, long n2, CharSequence name1, CharSequence name2) {
		return offer(n1, n2, "-", name1, name2);
	}

	public LongBitsStackOeprands mul(long n1, long n2, CharSequence name1, CharSequence name2) {
		return offer(n1, n2, "*", name1, name2);
	}

	public LongBitsStackOeprands div(long n1, long n2, CharSequence name1, CharSequence name2) {
		return offer(n1, n2, "/", name1, name2);
	}

	public LongBitsStackOeprands mod(long n1, long n2, CharSequence name1, CharSequence name2) {
		return offer(n1, n2, "%", name1, name2);
	}

	// ---------
	// ---------
	// ---------
	// ---------
	// ---------

	public LongBitsStackOeprands andNot(long n1, long n2) {
		return andNot(n1, n2, null);
	}

	public LongBitsStackOeprands andNot(long n1, long n2, CharSequence name1) {
		return andNot(n1, n2, name1, null);
	}

	public LongBitsStackOeprands andNot(long n1, long n2, CharSequence name1, CharSequence name2) {
		return offer(n1, n2, "&~", name1, name2);
	}

	private LongBitsStackOeprands offer(long n1, long n2, CharSequence ops, CharSequence name1, CharSequence name2) {
		name1list.offer(fixName(name1, "n1"));
		name2list.offer(fixName(name2, "n2"));
		n1list.offer(n1);
		n2list.offer(n2);
		olist.offer(ops.toString());
		return this;
	}

	private static Chars fixName(CharSequence cs, String _defaultname) {
		cs = Lang.length.isNullOrEmpty(cs) ? _defaultname : cs;
		Chars c = Chars.of(cs).toImmutable().sub(0, name_max_length);
		return c.rightPad(name_max_length, ' ');
	}

	public LongBitsStackOeprands clear() {
		n1list.clear();
		n2list.clear();
		olist.clear();
		return this;
	}

	public boolean isEmpty() {
		return n1list.isEmpty();
	}

	public Queue<Chars> calculate() {
		Queue<Chars> results = new LinkedList<Chars>();
		int len = n1list.size();
		for (int i = 0; i < len; i++) {
			long n1 = n1list.poll();
			long n2 = n2list.poll();
			String ops = olist.poll().toString();
			String name1 = name1list.poll().toString();
			String name2 = name2list.poll().toString();

			long r = 0;
			if (ops.contentEquals("&")) {
				r = n1 & n2;
			} else if (ops.contentEquals("|")) {
				r = n1 | n2;
			} else if (ops.contentEquals("^")) {
				r = n1 ^ n2;
			} else if (ops.contentEquals(">>>")) {
				r = n1 >>> n2;
			} else if (ops.contentEquals(">>")) {
				r = n1 >> n2;
			} else if (ops.contentEquals("<<")) {
				r = n1 << n2;
			} else if (ops.contentEquals("~")) {
				r = ~n1;
			} else if (ops.contentEquals("&~")) {
				r = n1 & ~n2;
			} else if (ops.contentEquals("+")) {
				r = n1 + n2;
			} else if (ops.contentEquals("-")) {
				r = n1 - n2;
			} else if (ops.contentEquals("*")) {
				r = n1 * n2;
			} else if (ops.contentEquals("/")) {
				r = n1 / n2;
			} else if (ops.contentEquals("%")) {
				r = n1 % n2;
			} else {
				throw new UnsupportedOperationException(ops);
			}

			Chars rc = null;
			if (ops.contentEquals(">>") || ops.contentEquals("<<") || ops.contentEquals(">>>")) {
				rc = shiftBlock(n1, n2, r, ops, name1);
				results.offer(rc);
			} else if (ops.contentEquals("~")) {
				rc = notBlock(n1, name1);
				results.offer(rc);
			} else if (ops.endsWith("~")) {
				Chars notBlock = notBlock(n2, name2);
				Chars block = block(n1, ~n2, r, ops.substring(0, ops.length() - 1), name1, name2);
				rc = notBlock.ln().ln().append(block);
				results.offer(rc);
			} else {
				rc = block(n1, n2, r, ops, name1, name2);
				results.offer(rc);
			}
		}
		return results;
	}

	Chars notBlock(long n1, String name) {
		Chars src = Bits.of(n1).toBinary(size, true, readable);
		Chars not = Bits.of(~n1).toBinary(size, true, readable);
		Chars rrr = Chars.of().toImmutable().appendFormat("%s: %s (%d)\n%s %s\nresult: %s (%d)", name, src, n1,
				Chars.of().toImmutable().repeat('-', size + name_space), "~", not, ~n1);
		return rrr;
	}

	Chars shiftBlock(long n1, long n2, long r, String ops, String name) {
		Chars src = Bits.of(n1).toBinary(size, true, readable);
		Chars shifted = Bits.of(r).toBinary(size, true, readable);
		Chars rrr = Chars.of().toImmutable().appendFormat("%s: %s (%d)\n%s %s(%d)\nresult: %s (%d)", name, src, n1,
				Chars.of().toImmutable().repeat('-', size + name_space), ops, n2, shifted, r);
		return rrr;
	}

	Chars block(long n1, long n2, long r, String ops, String name1, String name2) {
		Chars src1 = Bits.of(n1).toBinary(size, true, readable);
		Chars src2 = Bits.of(n2).toBinary(size, true, readable);
		Chars rs = Bits.of(r).toBinary(size, true, readable);
		Chars rrr = Chars.of().toImmutable().appendFormat("%s: %s (%d)\n%s: %s (%d)\n%s %s\nresult: %s (%d)", name1,
				src1, n1, name2, src2, n2, Chars.of().toImmutable().repeat('-', size + name_space), ops, rs, r);
		return rrr;
	}

}
