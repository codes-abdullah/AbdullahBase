package codes.abdullah.project;

import java.nio.ByteOrder;

public enum Endian implements EndianIndex {
	LITTLE {

		@Override
		public int direction() {
			return 1;
		}
		
		@Override
		public int index(int index, int len, int capacity) {
			return index;
		}

		@Override
		public int insertIndex(int index, int len, int capacity, int insertionLength) {
			return index;
		}

		@Override
		public int from(int from, int to, int len, int capacity) {
			return from;
		}

		@Override
		public int to(int from, int to, int len, int capacity) {
			return to;
		}

		@Override
		public int msb(int[] mag, int len) {
			return mag[len - 1];
		}

		@Override
		public int lsb(int[] mag, int len) {
			return mag[0];
		}

		@Override
		public boolean isLittle() {
			return true;
		}

		@Override
		public boolean isBig() {
			return false;
		}

		@Override
		public ByteOrder toByteOrder() {
			return ByteOrder.LITTLE_ENDIAN;
		}

		@Override
		public Endian flip() {
			return BIG;
		}
	},
	BIG {

		
		@Override
		public int direction() {
			return -1;
		}
		
		@Override
		public int index(int index, int len, int capacity) {
			return (capacity - len) + ((len - 1) - index);
		}

		@Override
		public int insertIndex(int index, int len, int capacity, int insertionLength) {
			return (index(index, len, capacity) - insertionLength) + 1;
		}

		@Override
		public int from(int from, int to, int len, int capacity) {
//			return (capacity - len) +((len - 1) - to) + 1;
			return index(to, len, capacity) + 1;
		}

		@Override
		public int to(int from, int to, int len, int capacity) {
//			return (capacity - len) +((len - 1) - from) + 1;
			return index(from, len, capacity) + 1;
		}

		@Override
		public int msb(int[] mag, int len) {
			return mag[0];
		}

		@Override
		public int lsb(int[] mag, int len) {
			return mag[len - 1];
		}

		@Override
		public boolean isLittle() {
			return false;
		}

		@Override
		public boolean isBig() {
			return true;
		}

		@Override
		public ByteOrder toByteOrder() {
			return ByteOrder.BIG_ENDIAN;
		}

		@Override
		public Endian flip() {
			return LITTLE;
		}

	};

	public static Endian nativeOrder() {
		return ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN ? LITTLE : BIG;
	}

	public static Endian of(ByteOrder bo) {
		return bo == ByteOrder.LITTLE_ENDIAN ? LITTLE : BIG;
	}

}
