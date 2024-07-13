package codes.abdullah.project;

/**
 * Simple interface represents mutability and immutability of single
 * implementation
 */
public interface Immutable<REF> {
	REF toImmutable();

	REF toMutable();

	boolean isImmutable();
}
