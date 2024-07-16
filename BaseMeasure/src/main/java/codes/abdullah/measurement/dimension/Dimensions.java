package codes.abdullah.measurement.dimension;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.measurement.dimension.convert.DimensionConverters;

/**
 * Source: <br>
 * <a href=
 * "https://www.ldeo.columbia.edu/~martins/hydro/case_studies/units_dimensions.html">www.ldeo.columbia.edu</a>
 * <brs> <table BORDER BORDERCOLOR="#000000" >
 * <tr>
 * <td WIDTH="94"><a NAME="taba1.1"></a><b>Quantity</b></td>
 * 
 * <td WIDTH="85"><center><b>Dimension</b></center></td>
 * 
 * <td WIDTH="155"><b>Unit</b></td>
 * 
 * <td WIDTH="54"><center><b>SI Symbol</b></center></td>
 * 
 * <td WIDTH="77"><center><b>Formula</b></center></td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94"><b>Base units:</b></td>
 * 
 * <td WIDTH="85"></td>
 * 
 * <td WIDTH="155"></td>
 * 
 * <td WIDTH="54"></td>
 * 
 * <td WIDTH="77"></td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94">length</td>
 * 
 * <td WIDTH="85"><center>[L]</center></td>
 * 
 * <td WIDTH="155">meter</td>
 * 
 * <td WIDTH="54"><center>m</center></td>
 * 
 * <td WIDTH="77"></td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94">mass</td>
 * 
 * <td WIDTH="85"><center>[M]</center></td>
 * 
 * <td WIDTH="155">kilogram</td>
 * 
 * <td WIDTH="54"><center>kg</center></td>
 * 
 * <td WIDTH="77"></td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94">temperature</td>
 * 
 * <td WIDTH="85"><center>[<font face="Symbol">Q</font>]</center></td>
 * 
 * <td WIDTH="155">kelvin</td>
 * 
 * <td WIDTH="54"><center>K</center></td>
 * 
 * <td WIDTH="77"></td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94">time</td>
 * 
 * <td WIDTH="85"><center>[T]</center></td>
 * 
 * <td WIDTH="155">second</td>
 * 
 * <td WIDTH="54"><center>s</center></td>
 * 
 * <td WIDTH="77"></td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94"><b>Derived units:</b></td>
 * 
 * <td WIDTH="85"></td>
 * 
 * <td WIDTH="155"></td>
 * 
 * <td WIDTH="54"></td>
 * 
 * <td WIDTH="77"></td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94">area</td>
 * 
 * <td WIDTH="85"><center>[L<sup>2</sup>]</center></td>
 * 
 * <td WIDTH="155">square meter</td>
 * 
 * <td WIDTH="54"></td>
 * 
 * <td WIDTH="77"><center>m<sup>2</sup></center></td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94">volume</td>
 * 
 * <td WIDTH="85"><center>[L<sup>3</sup>]</center></td>
 * 
 * <td WIDTH="155">cubic meter</td>
 * 
 * <td WIDTH="54"></td>
 * 
 * <td WIDTH="77"><center>m<sup>3</sup></center></td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94">velocity</td>
 * 
 * <td WIDTH="85"><center>[L T<sup><font face="Symbol">-</font>1</sup>]</center>
 * </td>
 * 
 * <td WIDTH="155">meter per second</td>
 * 
 * <td WIDTH="54"></td>
 * 
 * <td WIDTH="77"><center>m s<sup><font face="Symbol">-</font>1</sup></center>
 * </td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94">acceleration</td>
 * 
 * <td WIDTH="85"><center>[L T<sup><font face="Symbol">-</font>2</sup>]</center>
 * </td>
 * 
 * <td WIDTH="155">meter per second squared</td>
 * 
 * <td WIDTH="54"></td>
 * 
 * <td WIDTH="77"><center>m s<sup><font face="Symbol">-</font>2</sup></center>
 * </td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94">density</td>
 * 
 * <td WIDTH="85"><center>[M L<sup><font face="Symbol">-</font>3</sup>]</center>
 * </td>
 * 
 * <td WIDTH="155">kilogram per cubic meter</td>
 * 
 * <td WIDTH="54"></td>
 * 
 * <td WIDTH="77"><center>kg m<sup><font face="Symbol">-</font>3</sup></center>
 * </td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94">force</td>
 * 
 * <td WIDTH="85"><center>[M L
 * T<sup><font face="Symbol">-</font>2</sup>]</center></td>
 * 
 * <td WIDTH="155">newton</td>
 * 
 * <td WIDTH="54"><center>N</center></td>
 * 
 * <td WIDTH="77"><center>kg m
 * s<sup><font face="Symbol">-</font>2</sup></center></td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94">pressure</td>
 * 
 * <td WIDTH="85"><center>[M L<sup><font face="Symbol">-</font>1</sup>
 * T<sup><font face="Symbol">-</font>2</sup>]</center></td>
 * 
 * <td WIDTH="155">pascal</td>
 * 
 * <td WIDTH="54"><center>Pa</center></td>
 * 
 * <td WIDTH="77"><center>N m<sup><font face="Symbol">-</font>2</sup></center>
 * </td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94">stress</td>
 * 
 * <td WIDTH="85"><center>[M L<sup><font face="Symbol">-</font>1</sup>
 * T<sup><font face="Symbol">-</font>2</sup>]</center></td>
 * 
 * <td WIDTH="155">pascal</td>
 * 
 * <td WIDTH="54"><center>Pa</center></td>
 * 
 * <td WIDTH="77"><center>N m<sup><font face="Symbol">-</font>2</sup></center>
 * </td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94">energy</td>
 * 
 * <td WIDTH="85"><center>[M L<sup>2</sup>
 * T<sup><font face="Symbol">-</font>2</sup>]</center></td>
 * 
 * <td WIDTH="155">joule</td>
 * 
 * <td WIDTH="54"><center>J</center></td>
 * 
 * <td WIDTH="77"><center>N&middot;m</center></td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94">quantity of heat</td>
 * 
 * <td WIDTH="85"><center>[M L<sup>2</sup>
 * T<sup><font face="Symbol">-</font>2</sup>]</center></td>
 * 
 * <td WIDTH="155">joule</td>
 * 
 * <td WIDTH="54"><center>J</center></td>
 * 
 * <td WIDTH="77"><center>N&middot;m</center></td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94">work</td>
 * 
 * <td WIDTH="85"><center>[M L<sup>2</sup>
 * T<sup><font face="Symbol">-</font>2</sup>]</center></td>
 * 
 * <td WIDTH="155">joule</td>
 * 
 * <td WIDTH="54"><center>J</center></td>
 * 
 * <td WIDTH="77"><center>N&middot;m</center></td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94">power</td>
 * 
 * <td WIDTH="85"><center>[M L<sup>2</sup>
 * T<sup><font face="Symbol">-</font>3</sup>]</center></td>
 * 
 * <td WIDTH="155">watt</td>
 * 
 * <td WIDTH="54"><center>W</center></td>
 * 
 * <td WIDTH="77"><center>J s<sup><font face="Symbol">-</font>1</sup></center>
 * </td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94">viscosity, dynamic</td>
 * 
 * <td WIDTH="85"><center>[M L<sup><font face="Symbol">-</font>1</sup>
 * T<sup><font face="Symbol">-</font>1</sup>]</center></td>
 * 
 * <td WIDTH="155">pascal-second</td>
 * 
 * <td WIDTH="54"></td>
 * 
 * <td WIDTH="77"><center>Pa&middot;s</center></td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94">viscosity, kinematic</td>
 * 
 * <td WIDTH="85"><center>[L<sup>2</sup>
 * T<sup><font face="Symbol">-</font>1</sup>]</center></td>
 * 
 * <td WIDTH="155">square meter per second</td>
 * 
 * <td WIDTH="54"></td>
 * 
 * <td WIDTH="77"><center>m<sup>2</sup>
 * s<sup><font face="Symbol">-</font>1</sup></center></td>
 * </tr>
 * 
 * <tr>
 * <td WIDTH="94">specific heat</td>
 * 
 * <td WIDTH="85"><center>[L<sup>2</sup>
 * <font face="Symbol">Q<sup>-</sup></font><sup>1</sup>
 * T<sup><font face="Symbol">-</font>2</sup>]</center></td>
 * 
 * <td WIDTH="155">joule per kilogram-kelvin</td>
 * 
 * <td WIDTH="54"></td>
 * 
 * <td WIDTH="77"><center>J kg<sup><font face="Symbol">-</font>1</sup>
 * K<sup><font face="Symbol">-</font>1</sup></center></td>
 * </tr>
 * 
 * <caption ALIGN=BOTTOM><b>Table A1.1 Base and derived units relevant to
 * hydrology in SI measurement</b></caption>
 * </table>
 * 
 */
public class Dimensions {

	/**
	 * SUPERSCRIPT TWO (the exponent of 2 symbol)
	 */
	public static final char e2 = 0x00B2;
	/**
	 * SUPERSCRIPT THREE (the exponent of 3 symbol)
	 */
	public static final char e3 = 0x00B3;

	// --------------
	public static final String LENGTH_SYMBOL = "L";
	public static final String AREA_SYMBOL = "L" + e2;
	public static final String VOLUME_SYMBOL = "L" + e3;

	public static final String MASS_SYMBOL = "M";

	public static final String TIME_SYMBOL = "t";
	public static final String TEMPERATURE_SYMBOL = "Q";
	public static final String ELECTRIC_CURRENT_SYMBOL = "I";
	/**
	 * Luminous Intensity
	 */
	public static final String AMOUNT_OF_LIGHT_SYMBOL = "C";
	public static final String AMOUNT_OF_MATTER_SYMBOL = "n";

	public static final String DATA_SYMBOL = "data";

	// --------------------------
	public static final Length LENGTH = new Length();
	public static final Area AREA = new Area();
	public static final Volume VOLUME = new Volume();
	public static final Mass MASS = new Mass();
	public static final Time TIME = new Time();
	public static final Data DATA = new Data();
	public static final Nautical NAUTICAL = new Nautical();

	static {
		// immediately, initial DimensionsConverter class after this class
		DimensionConverters.init();
	}

	public static void init() {

	}

	static int getExponent(String symbol) {
		if (symbol.length() == 1)
			return 1;
		int i = symbol.length();
		while (i - 1 >= 0 && CodepointSupport.BMP.isSuperscriptDigit(symbol.charAt(i - 1))) {
			i--;
		}

		String s = symbol.substring(i);
		if (s.length() == 0)
			return 1;
		StringBuilder sb = new StringBuilder();
		for (; i < symbol.length(); i++) {
			sb.append((char) CodepointSupport.BMP.superscriptToAscii(symbol.charAt(i)));
		}
		return Integer.parseInt(sb.toString());
	}
}