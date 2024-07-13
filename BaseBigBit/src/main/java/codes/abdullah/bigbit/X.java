package codes.abdullah.bigbit;

import java.util.Arrays;
import java.util.BitSet;

public class X {

	public static void main(String[] args) {
		int b = 0b00011000;
		byte[] arr = Utils.bs.assign(new BitSet(), -2).toByteArray();
		System.out.println(Arrays.toString(arr));
	}

}
