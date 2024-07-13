package codes.abdullah.measurement.average;

public class _Average {

	public static void main(String[] args) {
		// numbers
		int[] nums = { 22, 48, 1399, 80 };

		float sum = 0;

		// compute sum
		int i = 0;
		while (i < nums.length) {
			sum += nums[i];
			i++;
		}

		// compute average
		float average = (sum / nums.length);

		System.out.println("Average : " + average);
	}
}
