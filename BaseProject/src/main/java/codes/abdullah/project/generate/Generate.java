package codes.abdullah.project.generate;

import java.lang.reflect.Field;

import codes.abdullah.project.lang.Lang;

class Generate {
	public static void main(String[] args) {
//		generateTestMethods();
	}

	private static void generateTestMethods() {
		Field[] ff = Lang.codepoint.getClass().getDeclaredFields();
		for (Field f : ff) {
			System.out.printf("@Test public void test%s(){assertEquals(\"required impl\", \"\");}\n", cap(f.getName()));
		}
	}
	
	private static void generatePrimitives(String src) {
		
	}
	
	private static String cap(String s) {
		if (s.equals("int"))
			s = "integer";
		else if (s.equals("char"))
			s = "character";
		return Character.toUpperCase(s.charAt(0)) + s.substring(1);
	}
	
	
	
}
