package codes.abdullah.chars;

import codes.abdullah.array.wrapper.character.CharArray;
import codes.abdullah.array.wrapper.codepoint.CodepointArray;
import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.ImplementationRequiredException;
import codes.abdullah.project.lang.Lang;

public class MutableChars extends Chars {
	private static final long serialVersionUID = -5125020195396734192L;
	private CodepointArray cpa;
	private int flags;

	public MutableChars(CodepointArray cpa, int flags) {
		this.cpa = Lang.emptyOrNull.requireNoNull(cpa, "cpa should not be null");
		this.flags = flags;
	}

	@Override
	public Chars setPairsSupport(CodepointSupport cps) {
		cpa = cpa.setPairsSupport(cps);
		return assign(cpa);
	}

	@Override
	public Chars setIgnoreCase(boolean b) {
		return reflag(Lang.constant.FLAG_ALWAYS_IGNORE_CASE, b);
	}

	@Override
	public boolean isIgnoreCase() {
		return isFlagged(Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
	}

	@Override
	public Chars toImmutable() {
		throw new ImplementationRequiredException();
	}

	@Override
	public Chars toMutable() {
		return this;
	}

	@Override
	public boolean isImmutable() {
		return false;
	}

	@Override
	CodepointArray safe() {
		return cpa;
	}

	@Override
	CodepointArray unsafe() {
		return cpa;
	}

	@Override
	Chars assign(CodepointArray cpa) {
		this.cpa = cpa;
		return this;
	}

	@Override
	Chars newInstance(CharSequence cs) {
		char[] tarr = null;
		int tlen = 0;
		if (cs instanceof Chars) {
			Chars c = (Chars) cs;
			CodepointArray cpa = c.unsafe();
			tarr = cpa.toCharArray();
			tlen = cpa.lengthActual();
		} else if (cs != null) {
			tarr = cs.toString().toCharArray();
			tlen = cs.length();
		}

		return newInstance(cpa.newInstance(tarr, tlen));
	}

	@Override
	Chars newInstance(CodepointArray cpa) {
		return new MutableChars(cpa, flags);
	}

	@Override
	CodepointArray newCodepointArray(CharSequence cs) {
		char[] tarr = null;
		int tlen = 0;
		if (cs instanceof Chars) {
			Chars c = (Chars) cs;
			CodepointArray cpa = c.unsafe();
			tarr = cpa.toCharArray();
			tlen = cpa.lengthActual();
		} else if (cs != null) {
			tarr = cs.toString().toCharArray();
			tlen = cs.length();
		}
		return cpa.newInstance(tarr, tlen);
	}

	@Override
	CodepointArray newCodepointArray(char[] arr, int len, int spcount) {
		return cpa.newInstance(arr, len, spcount, cpa.getPairsSupport());
	}

	@Override
	CodepointArray newCodepointArray(char[] arr, int len) {
		return cpa.newInstance(arr, len);
	}

	@Override
	CodepointArray newCodepointArray(CharArray ca) {
		return cpa.newInstance(ca.getArray(), ca.getLength());
	}

	@Override
	Chars[] newArray(int len) {
		return new MutableChars[len];
	}

	@Override
	public int getFlags() {
		return flags;
	}

	@Override
	public Chars setFlags(int flags) {
		this.flags = flags;
		return this;
	}

	@Override
	Chars newInstance() {
		return new MutableChars(cpa.newInstance(), flags);
	}
}
