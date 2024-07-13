/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package codes.abdullah.digits.java;

public enum UnicodeProp {

	/**
	 * @return {@link Character#isAlphabetic(int)}
	 */
	ALPHABETIC {
		public boolean is(int ch) {
			return Character.isAlphabetic(ch);
		}
	},

	/**
	 * @return {@link Character#isLetter(int)}
	 */
	LETTER {
		public boolean is(int ch) {
			return Character.isLetter(ch);
		}
	},

	/**
	 * @return {@link Character#isIdeographic(int)}
	 */
	IDEOGRAPHIC {
		public boolean is(int ch) {
			return Character.isIdeographic(ch);
		}
	},

	/**
	 * @return {@link Character#isLowerCase(int)}
	 */
	LOWERCASE {
		public boolean is(int ch) {
			return Character.isLowerCase(ch);
		}
	},

	/**
	 * @return {@link Character#isUpperCase(int)}
	 */
	UPPERCASE {
		public boolean is(int ch) {
			return Character.isUpperCase(ch);
		}
	},

	/**
	 * @return {@link Character#isTitleCase(int)}
	 */
	TITLECASE {
		public boolean is(int ch) {
			return Character.isTitleCase(ch);
		}
	},

	/**
	 * {Whitespace}<br>
	 * 
	 * @return {@link Character#isWhitespace(int)}
	 */
	WHITESPACE {
		public boolean is(int ch) {
			return Character.isWhitespace(ch);
		}
	},

	/**
	 * {gc=Control}<br>
	 * 
	 * @return {@link Character#getType(int)} == {@link Character#CONTROL}
	 */
	CONTROL {
		public boolean is(int ch) {
			return Character.getType(ch) == Character.CONTROL;
		}
	},

	/**
	 * {gc=Punctuation}<br>
	 * 
	 * @return true any punctuation such as <code>!, ", #, %, &,</code> including
	 *         632 (all possible punctuation including supplementary)
	 */
	PUNCTUATION {
		public boolean is(int ch) {
			return ((((1 << Character.CONNECTOR_PUNCTUATION) | (1 << Character.DASH_PUNCTUATION)
					| (1 << Character.START_PUNCTUATION) | (1 << Character.END_PUNCTUATION)
					| (1 << Character.OTHER_PUNCTUATION) | (1 << Character.INITIAL_QUOTE_PUNCTUATION)
					| (1 << Character.FINAL_QUOTE_PUNCTUATION)) >> Character.getType(ch)) & 1) != 0;
		}
	},

	/**
	 * {gc=Decimal_Number}<br>
	 * {Hex_Digit} -> PropList.txt: Hex_Digit
	 * 
	 * @return true for any unicode code-point representing digit according to
	 *         {@link UnicodeProp#DIGIT}, or if code-point in unicode-shape of (a-f)
	 *         and (A-F)
	 */
	HEX_DIGIT {
		public boolean is(int ch) {
			return DIGIT.is(ch) || (ch >= 0x0030 && ch <= 0x0039) || (ch >= 0x0041 && ch <= 0x0046)
					|| (ch >= 0x0061 && ch <= 0x0066) || (ch >= 0xFF10 && ch <= 0xFF19)
					|| (ch >= 0xFF21 && ch <= 0xFF26) || (ch >= 0xFF41 && ch <= 0xFF46);
		}
	},

	/**
	 * @return {@link Character#getType(int)} != {@link Character#UNASSIGNED}
	 */
	ASSIGNED {
		public boolean is(int ch) {
			return Character.getType(ch) != Character.UNASSIGNED;
		}
	},

	NONCHARACTER_CODE_POINT {
		public boolean is(int ch) {
			return (ch & 0xfffe) == 0xfffe || (ch >= 0xfdd0 && ch <= 0xfdef);
		}
	},

	/**
	 * {gc=Decimal_Number}<br>
	 * 
	 * @return {@link Character#isDigit(int)}
	 */
	DIGIT {
		public boolean is(int ch) {
			return Character.isDigit(ch);
		}
	},

	/**
	 * {alpha} <br>
	 * {digit}<br>
	 * 
	 * @return {@link UnicodeProp#ALPHABETIC} || {@link UnicodeProp#DIGIT}
	 */
	ALNUM {
		public boolean is(int ch) {
			return ALPHABETIC.is(ch) || DIGIT.is(ch);
		}
	},

	/**
	 * {Whitespace} --<br>
	 * [\N{LF} \N{VT} \N{FF} \N{CR} \N{NEL} -> 0xa, 0xb, 0xc, 0xd, 0x85 <br>
	 * {gc=Line_Separator} <br>
	 * {gc=Paragraph_Separator}]
	 * 
	 * @return {@link Character.getType(ch)} == {@link Character#SPACE_SEPARATOR} ||
	 *         ch == 0x9
	 */
	BLANK {
		public boolean is(int ch) {
			return Character.getType(ch) == Character.SPACE_SEPARATOR || ch == 0x9; // \N{HT}
		}
	},

	/**
	 * [^ <br>
	 * {space} <br>
	 * {gc=Control} <br>
	 * {gc=Surrogate} <br>
	 * {gc=Unassigned}<br>
	 * ]
	 */
	GRAPH {
		public boolean is(int ch) {
			return ((((1 << Character.SPACE_SEPARATOR) | (1 << Character.LINE_SEPARATOR)
					| (1 << Character.PARAGRAPH_SEPARATOR) | (1 << Character.CONTROL) | (1 << Character.SURROGATE)
					| (1 << Character.UNASSIGNED)) >> Character.getType(ch)) & 1) == 0;
		}
	},

	/**
	 * {graph} <br>
	 * {blank} -- <br>
	 * {cntrl}
	 */
	PRINT {
		//
		public boolean is(int ch) {
			return (GRAPH.is(ch) || BLANK.is(ch)) && !CONTROL.is(ch);
		}
	},

	/**
	 * {alpha}<br>
	 * {gc=Mark} <br>
	 * {digit} <br>
	 * {gc=Connector_Punctuation} <br>
	 * {Join_Control} 200C..200D
	 */
	WORD {
		public boolean is(int ch) {
			return ALPHABETIC.is(ch)
					|| ((((1 << Character.NON_SPACING_MARK) | (1 << Character.ENCLOSING_MARK)
							| (1 << Character.COMBINING_SPACING_MARK) | (1 << Character.DECIMAL_DIGIT_NUMBER)
							| (1 << Character.CONNECTOR_PUNCTUATION)) >> Character.getType(ch)) & 1) != 0
					|| JOIN_CONTROL.is(ch);
		}
	},

	/**
	 * Join_Control
	 * */
	JOIN_CONTROL {
		public boolean is(int ch) {
			return (ch == 0x200C || ch == 0x200D);
		}
	};

	

	public abstract boolean is(int ch);

//74867
//1113957	
	public static void main(String[] args) {
		int x = 0;
		int max = Character.MAX_CODE_POINT;
//		max = 0;
		System.out.println(GRAPH.is('a'));
		for (int i = 0; i < max; i++) {
			char c = (char) i;
			String s = c + "";
			if (i > Character.MIN_SUPPLEMENTARY_CODE_POINT)
				s = new String(Character.toChars(i));
			// if (GRAPH.is(i) != (Character.getType(Character.GRA)))
			// System.out.println(i + ": " + s);

			// System.out.println(i+": "+c+", "+Integer.toHexString(i));
		}

		for (int ch = 0xFF41; (ch >= 0xFF41 && ch <= 0xFF46); ch++) {
			char c = (char) ch;
			String s = c + "";
			if (ch > Character.MIN_SUPPLEMENTARY_CODE_POINT)
				s = new String(Character.toChars(ch));
			// if(HEX_DIGIT.is(i))System.out.println(i+": "+s);

			// System.out.println(ch+": "+c+", "+Integer.toHexString(ch));
		}

	}

//
//	HEX_DIGIT {
//		// <br>{gc=Decimal_Number}
//		// <br>{Hex_Digit} -> PropList.txt: Hex_Digit
//		public boolean is(int ch) {
//			return DIGIT.is(ch) || (ch >= 0x0030 && ch <= 0x0039) || (ch >= 0x0041 && ch <= 0x0046)
//					|| (ch >= 0x0061 && ch <= 0x0066) || (ch >= 0xFF10 && ch <= 0xFF19)
//					|| (ch >= 0xFF21 && ch <= 0xFF26) || (ch >= 0xFF41 && ch <= 0xFF46);
//		}
//	},

}
