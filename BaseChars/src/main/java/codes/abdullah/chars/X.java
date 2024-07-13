package codes.abdullah.chars;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class X {
	public static void main(String[] args) throws IOException {
		String path = "/home/abod/Downloads/Video/Jackie Chan/1976 - New Fist Of Fury/xx.srt";
		List<String> l = Files.readAllLines(Paths.get(path)).stream().collect(Collectors.toList());
		List<L> l2 = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < l.size(); i++) {
			try {
				L ll = new L();
				ll.number = Integer.parseInt(l.get(i));
				

//				sb.append(str);
//				System.out.println(str);

			} catch (Exception e) {
				System.out.println("line: " + i);
				e.printStackTrace();
			}
		}

//		System.out.println("doone");
	}

	static class L {
		int number;
		String from, to, text;

		@Override
		public String toString() {
			return number + "\n" + from + " --> " + to + "\n" + text;
		}
	}
}
