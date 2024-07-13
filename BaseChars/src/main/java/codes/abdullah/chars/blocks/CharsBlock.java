package codes.abdullah.chars.blocks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import codes.abdullah.chars.CharsUtils;
import codes.abdullah.project.CodepointSupport;

public class CharsBlock implements Iterator<CharsBlock> {
	private final String src, prefix, suffix, esc;
	private int currentDepth = 0, pindex, sindex = -1, escapedCount;
	private final boolean fullScan;
	private CodepointSupport sps;

	CharsBlock(String src, String prefix, String suffix, String esc) {
		this(src, prefix, suffix, esc, false, CodepointSupport.BMP);
	}

	CharsBlock(String src, String prefix, String suffix, String esc, boolean fullScan, CodepointSupport sps) {
		if (prefix.equals(suffix)) {
			throw new UnsupportedOperationException("prefix == suffix");
		}
		this.fullScan = fullScan;
		this.src = src;
		this.prefix = prefix;
		this.suffix = suffix;
		this.esc = esc;
		this.sps = sps;

	}

	// <test < test >>
	// <<1 <2 <3> >>

	//
	//

	public static CharsBlock of(String src, String prefix, String suffix, String esc, boolean fullScan) {
		return new CharsBlock(src, prefix, suffix, esc, fullScan, CodepointSupport.BMP);
	}

	/**
	 * targetDepth by default: 0
	 * 
	 * @see #hasNext(int)
	 */

	@Override
	public boolean hasNext() {
		return hasNext(0);
	}

	/**
	 * @param targetDepth 0 based indexing, 0 means the first element has been
	 *                    found, e.g: escape is \ and source is below<br>
	 *                    aaa[A1[1]B2[mid]\\[2\\]C3[3]]aaa<br>
	 *                    0: [A1[1]B2[mid][2]C3[3]]<br>
	 *                    1: [1], [mid], and [3]<br>
	 *                    2: nothing<br>
	 * @throws IllegalArgumentException if prefixes count < suffixes, e.g: if escape
	 *                                  is \\ and given source: [1][mid]\\[2][3]
	 */
	public boolean hasNext(int targetDepth) {
		// internally, depth of 0 is actually equals to 1, because depth of 0 represents
		// the text outside first pair
		targetDepth++;
		pindex = sindex + 1;
		boolean set = false;
		int len = 0;
		for (int i = pindex; i < src.length(); i += len) {
			// ===============
			// in case of pairs detected, no need to check low-surrogate, so will
			// use len to increment i
			// ===============
			len = sps.lengthOf(src, i);

			// ===============
			// check if escape detected
			// ===============
			if (CharsUtils.startsWith(src, i, esc, false)) {
				i += esc.length();
				continue;
			}
			if (CharsUtils.startsWith(src, i, prefix, false)) {
				currentDepth++;
				if (currentDepth == targetDepth && !set) {
					pindex = i;
					i = i + prefix.length() - 1;
					set = true;
				}
				continue;
			}

			if (CharsUtils.startsWith(src, i, suffix, false)) {
				if (currentDepth == targetDepth) {
					currentDepth--;
					sindex = i + suffix.length() - 1;
					return true;
				}

				currentDepth--;

			}

		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		String c = "c{m1{f1{x}}m2{f2{y}}}";
		final String prefix = "{", suffix = "}", esc = "\\";
		int targetDepth = 0;

		String s = "";
		while (true) {
			int i = 0;
			CharsBlock cbi = new CharsBlock(c, prefix, suffix, esc);
			while (cbi.hasNext(targetDepth)) {
				s = cbi.next().toString();
				System.out.println(targetDepth + ": " + s);
			}
			i++;
			targetDepth++;
			if (s.isEmpty())
				break;
			s = "";
		}
		// c = c.assign("ou[0[11]]");
		// cbi = new CharsBlock(c, prefix, suffix, esc);
		// cbi.hn(1, 0, 2);
	}

	// full scan
	public void balance() {
		int prefixesCount = 0, suffixesCount = 0;
		int currentDepth = 0;
		int suffix_index = -1;
		int prefix_index = suffix_index + 1;
		int len = 0;
		for (int i = prefix_index; i < src.length(); i += len) {
			len = sps.lengthOf(src, i);
			if (CharsUtils.startsWith(src, i, esc, false)) {
				i++;
				continue;
			}
			if (CharsUtils.startsWith(src, i, prefix, false)) {
				prefixesCount++;
				currentDepth++;
				prefix_index = i;
				i = i + prefix.length() - 1;
				continue;
			}

			if (CharsUtils.startsWith(src, i, suffix, false)) {
				suffixesCount++;
				currentDepth--;
				i = i + suffix.length() - 1;
			}
		}

		//
		// []]
		//
	}

	public int getCount(int targetDepth) {
		int c = 0, cd = currentDepth, pi = pindex, si = sindex;
		while (hasNext(targetDepth)) {
			c++;
		}
		currentDepth = cd;
		pindex = pi;
		sindex = si;
		return c;
	}

	public List<CharsBlock> getList(int targetDepth) {
		List<CharsBlock> list = new ArrayList<>();
		while (hasNext(targetDepth)) {
			list.add(next());
		}
		return list;
	}

	public CharsBlock get(int targetDepth, int index) {
		CharsBlock cb = null;
		int i = 0;
		while (hasNext(targetDepth)) {
			cb = next();
			if (i == index) {
				reset();
				return cb;
			}
		}
		return null;
	}

	@Override
	public CharsBlock next() {
		return new CharsBlock(src.substring(pindex, sindex + 1), prefix, suffix, esc);
	}

	public String getSource() {
		return src;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public int getPrefixIndex() {
		return pindex;
	}

	public int getSuffixIndex() {
		return sindex;
	}

	public void reset() {
		pindex = 0;
		sindex = -1;
		currentDepth = 0;
	}

	@Override
	public String toString() {
		return src.toString();
	}

}
