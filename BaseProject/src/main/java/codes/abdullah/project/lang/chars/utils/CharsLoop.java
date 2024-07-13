package codes.abdullah.project.lang.chars.utils;

import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.LConstants;

public interface CharsLoop {
	public static final CharsLoop INDEX_OF = new CharsLoopIndexOf();
	public static final CharsLoop LAST_INDEX_OF = new CharsLoopLastIndexOf();
	public static final CharsLoop FORWARD_COUNT_OF = new CharsLoopForwardCountOf();
	public static final CharsLoop BACKWARD_COUNT_OF = new CharsLoopBackwardCountOf();

	/**
	 * Loop over code-points based on implementation (forward loop/backward loop)
	 * trying to match provided target according to provided {@link CharsMatcher}
	 * <br>
	 * 
	 * @param arr     src array
	 * @param len     src length
	 * @param from    inclusive index (left-side), this must be always inclusive
	 *                index (left-side) in all implementations
	 * @param to      exclusive index (right-side), this must be always exclusive
	 *                index (right-side) in all implementations
	 * @param target  target to try to match
	 * @param flags   see {@link LConstants#FLAG_ALWAYS_IGNORE_CASE} and
	 *                {@link LConstants#FLAG_RETURN_VISUAL_LEVEL}
	 * @param spcount surrogate-pairs count before <b>from</b> index, this will be
	 *                used to return visual-level index if <b>flags</b> contains
	 *                {@link LConstants#FLAG_RETURN_VISUAL_LEVEL}
	 * @param m       matcher
	 * @param cps
	 */
	int codePoint(char[] arr, int len, int from, int to, int target, int flags, int spcount, CharsMatcher m,
			CodepointSupport cps);

	/**
	 * Loop over code-points based on implementation (forward loop/backward loop)
	 * trying to match any target according to provided {@link CharsMatcher} <br>
	 * 
	 * @param arr        src array
	 * @param len        src length
	 * @param from       inclusive index (left-side), this must be always inclusive
	 *                   index (left-side) in all implementations
	 * @param to         exclusive index (right-side), this must be always exclusive
	 *                   index (right-side) in all implementations
	 * @param targets    targets to try match any of them
	 * @param targetsLen length of targets array
	 * @param flags      see {@link LConstants#FLAG_ALWAYS_IGNORE_CASE} and
	 *                   {@link LConstants#FLAG_RETURN_VISUAL_LEVEL}
	 * @param spcount    surrogate-pairs count before <b>from</b> index, this will
	 *                   be used to return visual-level index if <b>flags</b>
	 *                   contains {@link LConstants#FLAG_RETURN_VISUAL_LEVEL}
	 * @param m          matcher
	 * @param cps
	 */
	int codePoints(char[] arr, int len, int from, int to, int[] targets, int targetsLen, int flags, int spcount,
			CharsMatcher m, CodepointSupport cps);

	/**
	 * Loop over code-points based on implementation (forward loop/backward loop)
	 * trying to match any target (individually) according to provided
	 * {@link CharsMatcher} <br>
	 * 
	 * @param arr        src array
	 * @param len        src length
	 * @param from       inclusive index (left-side), this must be always inclusive
	 *                   index (left-side) in all implementations
	 * @param to         exclusive index (right-side), this must be always exclusive
	 *                   index (right-side) in all implementations
	 * @param targets    targets to try match any of them (individually)
	 * @param targetsLen length of targets array
	 * @param flags      see {@link LConstants#FLAG_ALWAYS_IGNORE_CASE} and
	 *                   {@link LConstants#FLAG_RETURN_VISUAL_LEVEL}
	 * @param spcount    surrogate-pairs count before <b>from</b> index, this will
	 *                   be used to return visual-level index if <b>flags</b>
	 *                   contains {@link LConstants#FLAG_RETURN_VISUAL_LEVEL}
	 * @param m          matcher
	 * @param cps
	 */
	int codePoints(char[] arr, int len, int from, int to, char[] targets, int targetsLen, int flags, int spcount,
			CharsMatcher m, CodepointSupport cps);

	/**
	 * Loop over code-points based on implementation (forward loop/backward loop)
	 * trying to match target (sequence) according to provided {@link CharsMatcher}
	 * <br>
	 * 
	 * @param arr       src array
	 * @param len       src length
	 * @param from      inclusive index (left-side), this must be always inclusive
	 *                  index (left-side) in all implementations
	 * @param to        exclusive index (right-side), this must be always exclusive
	 *                  index (right-side) in all implementations
	 * @param target    target to try match (sequence)
	 * @param targetLen length of target array
	 * @param flags     see {@link LConstants#FLAG_ALWAYS_IGNORE_CASE} and
	 *                  {@link LConstants#FLAG_RETURN_VISUAL_LEVEL}
	 * @param spcount   surrogate-pairs count before <b>from</b> index, this will be
	 *                  used to return visual-level index if <b>flags</b> contains
	 *                  {@link LConstants#FLAG_RETURN_VISUAL_LEVEL}
	 * @param m         matcher
	 * @param cps
	 */
	int array(char[] arr, int len, int from, int to, char[] target, int targetLength, int flags, int spcount,
			CharsMatcher m, CodepointSupport cps);

}
