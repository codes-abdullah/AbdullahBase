package codes.abdullah.project.lang.chars.utils;

public class X {

	public static void main(String[] args) {
		System.out.println(getBlock());
	}
	


	@SuppressWarnings("unused")
	private static String getBlock() {
		return "root|10-class> A {|>20-fn {|> >30- if{   }| >>31-if{|>> >40-do  {    >}|>>  }|>>32-if{  >|>>>41 -do{ >}|>>}  |>}|}"
				.replaceAll("[>]", "\t").replaceAll("[|]", "\n");

	}

}
