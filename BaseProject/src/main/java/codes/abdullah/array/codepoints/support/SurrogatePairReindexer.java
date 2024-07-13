package codes.abdullah.array.codepoints.support;

import codes.abdullah.project.CodepointSupport;

/**
 * Useful delegation of
 * {@link CodepointSupport#reindex(CharSequence, int)}<br>
 * method for internal-use-only on {@link CodepointArray} implementations<br>
 * The problem: The wrappers of {@link CodepointArray} needs to take control of
 * re-indexing and supply ready to use indexes, therefore this delegation can
 * help without removing the invocations of reindex methods in
 * {@link CodepointArray} implementations<br>
 * So, basically, if wrapper want to take care of re-indexing, just supply the
 * {@link #IQNORE} to {@link CodepointArray} implementation<br>
 */
public interface SurrogatePairReindexer {

	SurrogatePairReindexer REINDEX = new ReindexSurrogatePair();
	SurrogatePairReindexer IQNORE = new IgnoreSurrogatePair();

	/**
	 * {@link CodepointSupport#reindex(char[], int, int)} will always re-index
	 * if supported, this method does rely on {@link SurrogatePairReindexer}
	 * implementation instead of {@link CodepointSupport} directly, the reason
	 * is sometimes we need surrogate-pair support, but we don't want re-indexing,
	 * which should be delegated to {@link CodepointArray} wrapper<br>
	 * The {@link #IQNORE} implementation will always ignore invokes to this method
	 * and will return the given index again, the {@link #REINDEX} will invoke
	 * {@link CodepointSupport#reindex(char[], int, int)}
	 */
	int reindex(char[] arr, int len, int index, CodepointSupport cps);

	public static class IgnoreSurrogatePair implements SurrogatePairReindexer {
		private IgnoreSurrogatePair() {

		}

		@Override
		public int reindex(char[] arr, int len, int index, CodepointSupport cps) {
			return index;
		}
	}

	public static class ReindexSurrogatePair implements SurrogatePairReindexer {
		private ReindexSurrogatePair() {

		}

		@Override
		public int reindex(char[] arr, int len, int index, CodepointSupport cps) {
			return cps.reindex(arr, len, index);
		}
	}
}
