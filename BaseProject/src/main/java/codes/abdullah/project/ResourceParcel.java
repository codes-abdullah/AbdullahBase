package codes.abdullah.project;

import java.util.Enumeration;
import java.util.Map;
import java.util.ResourceBundle;

import codes.abdullah.digits.Digits;

/**
 * <b>IMPORTANT:</b> don't use {@link ResourceBundle#getBundle(String)} or
 * {@link ResourceParcel#getBundle(String)} since this class does this
 * internally, only pass the paths without extension such as: new
 * String[]{"langs/strings", "langs/errors"}..etc
 * <p>
 * just simple wrapper over mutable {@link Map} which represent resources<br>
 * the most important of this class is the possibility of combined multiple
 * .properties file in one bundle with full support of localization
 */
public final class ResourceParcel extends ResourceBundle {
	public static final String DEFAULT_ARRAY_ITEAMS_SEPARATOR_REGEX = "[,]";
	private Map<String, Object> map;

	private ResourceParcel(String... paths) {
		for (String r : paths) {
			putAll(ResourceBundle.getBundle(Project.resolveResourcePath(r)));
		}
	}

	private ResourceParcel(ResourceBundle res) {
		putAll(res);
	}

	// ==============
	// ==============put
	// ==============

	public void putAll(ResourceBundle res) {
		Enumeration<String> keys = res.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String val = res.getString(key);
			map.put(key, val);
		}
	}

	public void putAll(ResourceParcel par) {
		map.putAll(par.map);
	}

	public void putAll(Map<String, Object> m) {
		map.putAll(m);
	}

	public void put(String key, Object val) {
		map.put(key, val);
	}

	// ==============
	// ==============boolean
	// ==============
	public boolean getBoolean(String key) {
		return Boolean.parseBoolean((String) handleGetObject(key));
	}

	public boolean getBoolean(String key, boolean defaultVal) {
		try {
			return getBoolean(key);
		} catch (Exception e) {
		}
		return defaultVal;
	}

	// ==============
	// ==============byte
	// ==============
	public byte getByte(String key) {
		return (byte) Digits.ints.parse((String) handleGetObject(key));
	}

	public byte getByte(String key, byte defaultVal) {
		try {
			return getByte(key);
		} catch (Exception e) {
		}
		return defaultVal;
	}

	// ==============
	// ==============short
	// ==============
	public short getShort(String key) {
		return (short) Digits.ints.parse((String) handleGetObject(key));
	}

	public short getShort(String key, short defaultVal) {
		try {
			return getShort(key);
		} catch (Exception e) {
		}
		return defaultVal;
	}

	// ==============
	// ==============int
	// ==============
	public int getInt(String key) {
		return Digits.ints.parse((String) handleGetObject(key));
	}

	public int getInt(String key, int defaultVal) {
		try {
			return getInt(key);
		} catch (Exception e) {
		}
		return defaultVal;
	}

	// ==============
	// ==============long
	// ==============
	public long getLong(String key) {
		return Long.parseLong((String) handleGetObject(key));
	}

	public long getLong(String key, long defaultVal) {
		try {
			return getLong(key);
		} catch (Exception e) {
		}
		return defaultVal;
	}

	// ==============
	// ==============float
	// ==============
	public float getFloat(String key) {
		return Float.parseFloat((String) handleGetObject(key));
	}

	public float getFloat(String key, float defaultVal) {
		try {
			return getFloat(key);
		} catch (Exception e) {
		}
		return defaultVal;
	}

	// ==============
	// ==============double
	// ==============
	public double getDouble(String key) {
		return Double.parseDouble((String) handleGetObject(key));
	}

	public double getDouble(String key, double defaultVal) {
		try {
			return getDouble(key);
		} catch (Exception e) {
		}
		return defaultVal;
	}

	// ==============
	// ==============String
	// ==============

	public String getString(String key, String defaultVal) {
		String val = getString(key);
		return val == null ? defaultVal : val;
	}

	// ==============
	// ==============boolean-array
	// ==============
	public boolean[] getBooleanArray(String key) {
		return getBooleanArray(key, null);
	}

	public boolean[] getBooleanArray(String key, boolean[] defaultValue) {
		return getBooleanArray(key, defaultValue, DEFAULT_ARRAY_ITEAMS_SEPARATOR_REGEX);
	}

	public boolean[] getBooleanArray(String key, boolean[] defaultValue, String splitRegex) {
		try {
			String[] arr = ((String) handleGetObject(key)).split(splitRegex);
			boolean[] arr2 = new boolean[arr.length];
			for (int i = 0; i < arr.length; i++) {
				arr2[i] = Boolean.parseBoolean(arr[i]);
			}
		} catch (Exception e) {
			if (defaultValue == null) {
				e.printStackTrace();
				return null;
			}
		}
		return defaultValue;
	}

	// ==============
	// ==============byte-array
	// ==============
	public byte[] getByteArray(String key) {
		return getByteArray(key, null);
	}

	public byte[] getByteArray(String key, byte[] defaultValue) {
		return getByteArray(key, defaultValue, DEFAULT_ARRAY_ITEAMS_SEPARATOR_REGEX);
	}

	public byte[] getByteArray(String key, byte[] defaultValue, String splitRegex) {
		try {
			String[] arr = ((String) handleGetObject(key)).split(splitRegex);
			byte[] arr2 = new byte[arr.length];
			for (int i = 0; i < arr.length; i++) {
				arr2[i] = (byte) Digits.ints.parse(arr[i]);
			}
		} catch (Exception e) {
			if (defaultValue == null) {
				e.printStackTrace();
				return null;
			}
		}
		return defaultValue;
	}

	// ==============
	// ==============short-array
	// ==============
	public short[] getShortArray(String key) {
		return getShortArray(key, null);
	}

	public short[] getShortArray(String key, short[] defaultValue) {
		return getShortArray(key, defaultValue, DEFAULT_ARRAY_ITEAMS_SEPARATOR_REGEX);
	}

	public short[] getShortArray(String key, short[] defaultValue, String splitRegex) {
		try {
			String[] arr = ((String) handleGetObject(key)).split(splitRegex);
			short[] arr2 = new short[arr.length];
			for (int i = 0; i < arr.length; i++) {
				arr2[i] = (short) Digits.ints.parse(arr[i]);
			}
		} catch (Exception e) {
			if (defaultValue == null) {
				e.printStackTrace();
				return null;
			}
		}
		return defaultValue;
	}

	// ==============
	// ==============int-array
	// ==============
	public int[] getIntArray(String key) {
		return getIntArray(key, null);
	}

	public int[] getIntArray(String key, int[] defaultValue) {
		return getIntArray(key, defaultValue, DEFAULT_ARRAY_ITEAMS_SEPARATOR_REGEX);
	}

	public int[] getIntArray(String key, int[] defaultValue, String splitRegex) {
		try {
			String[] arr = ((String) handleGetObject(key)).split(splitRegex);
			int[] arr2 = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				arr2[i] = Digits.ints.parse(arr[i]);
			}
		} catch (Exception e) {
			if (defaultValue == null) {
				e.printStackTrace();
				return null;
			}
		}
		return defaultValue;
	}

	// ==============
	// ==============long-array
	// ==============
	public long[] getLongArray(String key) {
		return getLongArray(key, null);
	}

	public long[] getLongArray(String key, long[] defaultValue) {
		return getLongArray(key, defaultValue, DEFAULT_ARRAY_ITEAMS_SEPARATOR_REGEX);
	}

	public long[] getLongArray(String key, long[] defaultValue, String splitRegex) {
		try {
			String[] arr = ((String) handleGetObject(key)).split(splitRegex);
			long[] arr2 = new long[arr.length];
			for (int i = 0; i < arr.length; i++) {
				arr2[i] = Digits.longs.parse(arr[i]);
			}
		} catch (Exception e) {
			if (defaultValue == null) {
				e.printStackTrace();
				return null;
			}
		}
		return defaultValue;
	}

	// ==============
	// ==============float-array
	// ==============
	public float[] getFloatArray(String key) {
		return getFloatArray(key, null);
	}

	public float[] getFloatArray(String key, float[] defaultValue) {
		return getFloatArray(key, defaultValue, DEFAULT_ARRAY_ITEAMS_SEPARATOR_REGEX);
	}

	public float[] getFloatArray(String key, float[] defaultValue, String splitRegex) {
		try {
			String[] arr = ((String) handleGetObject(key)).split(splitRegex);
			float[] arr2 = new float[arr.length];
			for (int i = 0; i < arr.length; i++) {
				arr2[i] = Float.parseFloat(arr[i]);
			}
		} catch (Exception e) {
			if (defaultValue == null) {
				e.printStackTrace();
				return null;
			}
		}
		return defaultValue;
	}

	// ==============
	// ==============double-array
	// ==============
	public double[] getDoubleArray(String key) {
		return getDoubleArray(key, null);
	}

	public double[] getDoubleArray(String key, double[] defaultValue) {
		return getDoubleArray(key, defaultValue, DEFAULT_ARRAY_ITEAMS_SEPARATOR_REGEX);
	}

	public double[] getDoubleArray(String key, double[] defaultValue, String splitRegex) {
		try {
			String[] arr = ((String) handleGetObject(key)).split(splitRegex);
			double[] arr2 = new double[arr.length];
			for (int i = 0; i < arr.length; i++) {
				arr2[i] = Double.parseDouble(arr[i]);
			}
		} catch (Exception e) {
			if (defaultValue == null) {
				e.printStackTrace();
				return null;
			}
		}
		return defaultValue;
	}

	// ==============
	// ==============String-array
	// ==============
	public String[] getStringArrayV2(String key) {
		return getStringArray(key, null);
	}

	public String[] getStringArray(String key, String[] defaultValue) {
		return getStringArray(key, defaultValue, DEFAULT_ARRAY_ITEAMS_SEPARATOR_REGEX);
	}

	public String[] getStringArray(String key, String[] defaultValue, String splitRegex) {
		try {
			return ((String) handleGetObject(key)).split(splitRegex);
		} catch (Exception e) {
			if (defaultValue == null) {
				e.printStackTrace();
				return null;
			}
		}
		return defaultValue;
	}

	@Override
	protected Object handleGetObject(String key) {
		return map.get(key);
	}

	@Override
	public final Enumeration<String> getKeys() {
		ResourceBundle parent = this.parent;
		return new ResourceParcelEnumeration_old(map.keySet(), (parent != null) ? parent.getKeys() : null);
	}

	@Override
	public String toString() {
		return map.toString();
	}

	public static void main(String[] args) {
		String s = "public boolean getBoolean(String key) {\n"
				+ "		return Boolean.parseBoolean((String) handleGetObject(key));\n" + "	}\n" + "\n"
				+ "	public boolean getBoolean(String key, boolean defaultVal) {\n" + "		try {\n"
				+ "			return getBoolean(key);\n" + "		} catch (Exception e) {\n" + "		}\n"
				+ "		return defaultVal;\n" + "	}\n" + "	";

		String[] xx = "boolean,byte,short,int,long,float,double".split(DEFAULT_ARRAY_ITEAMS_SEPARATOR_REGEX);
//		String[] xx = "String".split(DEFAULT_ARRAY_ITEAMS_SEPARATOR_REGEX);
		for (int i = 0; i < xx.length; i++) {
			String x = xx[i];

			String s2 = s.replaceAll("boolean", x);
			s2 = s2.replaceAll("Boolean", cap(x));
			System.out.println("//==============");
			System.out.println("//==============" + x);
			System.out.println("//==============");
			System.out.println(s2);

		}

	}

	private static String cap(String s) {
		return Character.toUpperCase(s.charAt(0)) + s.substring(1);
	}

}