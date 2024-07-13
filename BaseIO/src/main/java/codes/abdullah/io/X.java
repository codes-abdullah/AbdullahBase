package codes.abdullah.io;

public class X {
	private static final long L_DIGIT = lowMask('0', '9');
    // Compute a low-order mask for the characters
    // between first and last, inclusive
    private static long lowMask(int first, int last) {
        long m = 0;
        int f = Math.max(Math.min(first, 63), 0);
        int l = Math.max(Math.min(last, 63), 0);
        for (int i = f; i <= l; i++) {
            m |= 1L << i;
            System.out.println(Long.toBinaryString(m));
        }
        return m;
    }

    // Compute a high-order mask for the characters
    // between first and last, inclusive
    private static long highMask(char first, char last) {
        long m = 0;
        int f = Math.max(Math.min(first, 127), 64) - 64;
        int l = Math.max(Math.min(last, 127), 64) - 64;
        for (int i = f; i <= l; i++)
            m |= 1L << i;
        return m;
    }
	public static void main(String[] args) {
		
	}
}
