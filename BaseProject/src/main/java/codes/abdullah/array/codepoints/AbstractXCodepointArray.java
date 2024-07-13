package codes.abdullah.array.codepoints;

import codes.abdullah.array.chars.XCharArray;
import codes.abdullah.array.codepoints.support.XCodepointSupport;
import codes.abdullah.project.lang.Lang;

public abstract class AbstractXCodepointArray implements XCodepointArray {

	private static final long serialVersionUID = -8832819248658855779L;

	abstract XCharArray unsafe();

	@Override
	public boolean isEmpty() {
		return length() == 0;
	}
	
	@Override
	public XCodepointArray ensureCapacity(int required) {
		XCharArray xarr = getArray();
		xarr = xarr.ensureCapacity(required);
		return assign(xarr, getPairsCount(), getPairsSupport());
	}
	
	@Override
	public XCodepointArray expand(int index, int size) {
		XCharArray xarr = getArray();
		xarr = xarr.expand(index, size);
		return assign(xarr, getPairsCount(), getPairsSupport());
	}

	
	@Override
	public XCodepointArray reverse(int from, int to) {
		XCharArray xarr = getArray();
		char[] arr = xarr.getArray();
		int len = xarr.length();
		XCodepointSupport cps = getPairsSupport();		
		xarr = Lang.chararray.reverse.in(arr, len, from, to, cps);
		return assign(xarr, getPairsCount(), getPairsSupport());
	}

}
