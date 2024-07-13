package codes.abdullah.chars;

import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.Lang;

public class CharsUtils {

	// ============
	// ============ starts/ends with
	// ============

	public static boolean startsWith(Chars src, int offset, Chars target) {
		return Lang.chararray.startsWith(src.unsafe(), src.lengthActual(), offset, target.unsafe(),
				target.lengthActual(), src.isIgnoreCase());
	}

	public static boolean endsWith(Chars src, int offset, Chars target) {
		return Lang.chararray.endsWith(src.unsafe(), src.lengthActual(), offset, target.unsafe(), target.lengthActual(),
				src.isIgnoreCase());
	}

	public static boolean startsWith(CharSequence src, int offset, CharSequence target, boolean ignoreCase) {
		if (src.charAt(offset) != target.charAt(0)) {
			return false;
		}
		int targetIndex = 0;
		int targetLength = target.length();
		while (--targetLength >= 0) {
			if (!CodepointSupport.BMP.equals(src.charAt(offset++), target.charAt(targetIndex++), ignoreCase)) {
				return false;
			}
		}
		return true;
	}

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============
	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============ index-of(code-point)-end
	// ============

	// ============
	// ============ indexes-of(code-point) as array
	// ============

}
