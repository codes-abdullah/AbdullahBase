package codes.abdullah.project.lang;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import codes.abdullah.project.Endian;
import codes.abdullah.project.lang.chars.chararray.LChararray;
import codes.abdullah.project.lang.chars.codepoint.LCodepoint;
import javafx.print.Collation;

/**
 * 
 * <b>Terms:</b><br>
 * 
 * <br>
 * <b>Extend/Shrink:</b> Applying {@link LExpand} and {@link LShrink}<br>
 * <b>Capacity:</b> Applying {@link LCapacity}<br>
 * <b>Reallocate:</b> The output array is not same as the input reference<br>
 * <b>New length:</b> The new length of the output array<br>
 * <br>
 * <b>Applied: </b>Specific action will be applied to the array<br>
 * <b>If Required: </b> If given array has no meet the requirements<br>
 * <b>N/A: </b>N/A for specific action<br>
 * <b>By invoker: </b>Invoker must take care of this matter/action/data<br>
 * <br>
 * <b>Examples:</b><br>
 * <b>New length: </b>Applied - means the a new length has been applied to given
 * array by invoking {@link LCapacity} or by reallocate it, in both ways<br>
 */

//TODO: all ranges/indexes in Lang impla must be in actual-level, including special implas
//TODO: special implementations such LChararray and LCodepoint must relay on CodepointCounter and not CodepointSupport while reindexing
//TODO: LCompare should support ranges and case-sensitive for char[]
//TODO: LEqual should support ranges and case-sensitive for char[]
//TODO: LHashCode should support ranges 
//TODO: LCount must have count matches, repeat and occupied
//TODO: remove reindexing from LMark
//TODO: LCodepoint set indexes, document the reindex if visual or actual level
//TODO: complete LReplace using displace
//TODO: LReplace must support replaceByRegex !!
//###########################################################
//TODO: codes.abdullah.project.lang.LDisplaceStep
//TODO: codes.abdullah.project.lang.LDisplaceSlide
//TODO: LPrimitive lengthOf + tests
//TODO: methods does alter/convert original array, can't tell what is the newlen
//###########################################################
//TODO: codes.abdullah.project.lang.chars.chararray.LRemove
//TODO: what is this ?? fix, not working if delif = 1
//###########################################################
//TODO: codes.abdullah.project.lang.chars.chararray.LRange
//TODO: needs to be implemented
//###########################################################
//TODO: codes.abdullah.project.lang.chars.chararray.LMark
//TODO: what is this ?? remove reindexing
//TODO: what is this ?? implement same as the top method
//TODO: improve allocation
//TODO: create more test in src/test/resources/mark_underneeth_tests/block01-expected/
//###########################################################
//TODO: codes.abdullah.project.lang.chars.chararray.LCrop
//TODO: is totally relaying on CharArray[], replace by XCharArray and try to find batter implementation
//TODO: needs tests
//###########################################################
//TODO: codes.abdullah.project.lang.chars.chararray.LChararray
//TODO: remove computeHash()
//TODO: do we need offsetByCodePoints() ?? remove or find other place
//TODO:
//###########################################################
//TODO: codes.abdullah.project.lang.chars.chararray.LEnds
//TODO: codes.abdullah.project.lang.chars.chararray.LStarts
//TODO: we need range supoort
//########################################################### 
//TODO: codes.abdullah.project.lang.chars.chararray.LBlock
//TODO: needs to complete implementation
//TODO: needs tests
//TODO:
//###########################################################
//TODO: codes.abdullah.project.lang.chars.codepoint.LCodepoint
//TODO: what is is this works right ??
//########################################################### 
//TODO: codes.abdullah.project.lang.chars.utils.CharsScanner
//TODO: what is this for??
//TODO: 
//TODO: 
//TODO: 
//TODO: 
//TODO: 
//TODO: 
//TODO: 
//TODO: 
//TODO: 
//TODO: 
//TODO: 
//TODO: 
//TODO: 
//TODO: 
//TODO: 

public class Lang {

	/**
	 * Use varargs to create {@link Collation}, {@link List}, {@link Set},
	 * {@link Queue} and {@link Map}
	 */
	public static final LAs as = new LAs();

	/**
	 * Convert an array into another type array, e.g: byte[] to int[], with binary
	 * level consideration
	 * 
	 * @see #toPrimitive
	 */
	public static final LBinary binary = new LBinary();

	/**
	 * Ensure an array has enough capacity
	 */
	public static final LCapacity capacity = new LCapacity();

	/**
	 * Compare two arrays
	 */
	public static final LCompare compare = new LCompare();

	/**
	 * Tools to copy to/of array, <b>copy.of.this_</b> and <b>copy.to.that</b>
	 */
	public static final LCopy copy = new LCopy();

	/**
	 * Displace element of array
	 */
	public static final LDisplace displace = new LDisplace();

	/**
	 * Test equality of two arrays
	 */
	public static final LEqual equal = new LEqual();

	/**
	 * Expend an array
	 */
	public static final LExpand expand = new LExpand();

	/**
	 * Fill array based on range
	 */
	public static final LFill fill = new LFill();

	/**
	 * Basic generic based tools to create arrays
	 */
	public static final LGeneric generic = new LGeneric();

	/**
	 * Hashcode of array
	 */
	public static final LHashCode hashCode = new LHashCode();

	/**
	 * General index-of implementation with range support<br>
	 * 
	 * @see LChararray#index
	 * @see LChararray#indexes
	 * @see LChararray#lastIndex
	 * @see LCodepoint#index
	 * @see LCodepoint#indexes
	 * @see LCodepoint#lastIndex
	 */
	public static final LIndex index = new LIndex();

	/**
	 * Regular index of implementation with range support
	 * 
	 * @see LChararray#index
	 * @see LChararray#indexes
	 * @see LChararray#lastIndex
	 * @see LCodepoint#index
	 * @see LCodepoint#indexes
	 * @see LCodepoint#lastIndex
	 */
	public static final LLastIndex lastIndex = new LLastIndex();

	/**
	 * Length of array with additional options
	 */
	public static final LLength length = new LLength();

	/**
	 * Convert an array into another type array, e.g: byte[] to int[], without
	 * binary level consideration
	 * 
	 * @see #toBinary
	 */
	public static final LPrimitive primitive = new LPrimitive();

	/**
	 * Reverse array
	 */
	public static final LReverse reverse = new LReverse();

	/**
	 * Shrink array based on given size and index
	 */
	public static final LShrink shrink = new LShrink();

	/**
	 * Shuffle array based on given range
	 */
	public static final LShuffle shuffle = new LShuffle();

	/**
	 * Skip zeros/falses/nulls elements of array
	 */
	public static final LSkip skip = new LSkip();

	/**
	 * Swap elements of array
	 */
	public static final LSwap swap = new LSwap();

	/**
	 * Similar to {@link Arrays#toString()}, with addition to range and
	 * {@link Endian}
	 */
	public static final LToString toString = new LToString();

	/**
	 * Trim array based on given length
	 */
	public static final LTrim trim = new LTrim();

	/**
	 * Cheat compiler while work with varargs, also wrap varargs
	 */
	public static final LVarargs varargs = new LVarargs();

	/**
	 * Convert primitive-array from/to wrapper-array
	 */
	public static final LWrapper wrapper = new LWrapper();

	/**
	 * Checker for null or empty array
	 */
	public static final LEmptyOrNull emptyOrNull = new LEmptyOrNull();

	/**
	 * Sub-range of elements of given array
	 */
	public static final LSub sub = new LSub();

	/**
	 * Constants holder for all {@link Lang} internal usage
	 */
	public static final LConstants constant = new LConstants();

	/**
	 * Get null array to avoid compiler ambiguous warning caused by overriding
	 */
	public static final LNull nuller = new LNull();
	// ======================
	// ======================
	// ======================

	// =======================
	// =======================
	public static final LChararray chararray = LChararray.getInstance();
	public static final LCodepoint codepoint = LCodepoint.getInstance();

	public static void main(String[] args) {

		File[] ff = new File(
				"/home/abod/.local/bin/eclipse/jse/2022-12/workspace/AbdullahBase/BaseProject/src/main/java/codes/abdullah/project/lang")
				.listFiles();
		Arrays.sort(ff);
		for (int i = 0; i < ff.length; i++) {
			File f = ff[i];
			String s = f.getName().substring(0, f.getName().lastIndexOf('.'));

			System.out.printf("public static final %s %s = new %s();\n", s, s.toLowerCase(), s);
		}
	}
}
