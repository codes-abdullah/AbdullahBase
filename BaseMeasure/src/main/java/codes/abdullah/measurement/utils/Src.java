package codes.abdullah.measurement.utils;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

import codes.abdullah.measurement.dimension.Dimension;
import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.dimension.convert.DimensionConverter;
import codes.abdullah.measurement.dimension.convert.DimensionConverters;
import codes.abdullah.measurement.system.MeasurementSystem;
import codes.abdullah.measurement.system.MeasurementSystems;
import codes.abdullah.measurement.unit.Unit;
import codes.abdullah.measurement.unit.Units;

public abstract class Src {

	private static String MASTER_PACKAGE = "codes.abdullah";

	public final static String project_dir = BuilderV2.class.getResource("/").getPath().replace("target/classes/", "");
	/** e.g:../${project.name}/src/main/java/ */
	public static final Main main = new Main();
	/** e.g:../${project.name}/src/test/java/ */
	public static final Test test = new Test();
	/** e.g:../${project.name}/target/classes/ */
	public static final Target target = new Target();
	/** e.g:../${project.name}/target/test-classes/ */
	public static final TargetTest targetTest = new TargetTest();

	abstract String getDir();

	public static synchronized String getMasterPackage() {
		return MASTER_PACKAGE;
	}

	public static synchronized void setMasterPackage(String mp) {
		MASTER_PACKAGE = mp;
	}

	/**
	 * e.g: codes.abdullah
	 */
	public String getMasterPackageFQN() {
		return MASTER_PACKAGE;
	}

	/**
	 * e.g: codes.abdullah.measurement
	 */
	public String getMeasurementPackageFQN() {
		return getMasterPackage() + ".measurement";
	}

	/**
	 * e.g: codes.abdullah.measurement.system
	 */
	public String getMeasurementSystemPackageFQN() {
		return getMeasurementPackageFQN() + ".system";
	}

	/**
	 * e.g: codes.abdullah.measurement.unit
	 */
	public String getUnitPackageFQN() {
		return getMeasurementPackageFQN() + ".unit";
	}

	/**
	 * e.g: codes.abdullah.measurement.dimension
	 */
	public String getDimensionPackageFQN() {
		return getMeasurementPackageFQN() + ".dimension";
	}

	/**
	 * e.g: codes.abdullah.measurement.dimension.convert
	 */
	public String getDimensionConverterPackageFQN() {
		return getMeasurementPackageFQN() + ".dimension.convert";
	}

	/**
	 * e.g: codes.abdullah.measurement.utils
	 */
	public String getUtilsPackageFQN() {
		return getMeasurementPackageFQN() + ".util";
	}

	/**
	 * [0]: codes.abdullah, [1]: src/main/java, [2]: src/test/java, [3]:
	 * target/classes, [4]: target/test-classes<br>
	 * e.g:../${project.name}/[1-4]/[0]/
	 */
	public String getMasterPackageDir() {
		return getDir() + getMasterPackageFQN().replace('.', '/') + "/";
	}

	/**
	 * [0]: codes.abdullah, [1]: src/main/java, [2]: src/test/java, [3]:
	 * target/classes, [4]: target/test-classes<br>
	 * e.g:../${project.name}/[1-4]/[0]/measurement
	 */
	public String getMeasurementPackageDir() {
		return getDir() + getMeasurementPackageDir().replace('.', '/') + "/";
	}

	/**
	 * [0]: codes.abdullah, [1]: src/main/java, [2]: src/test/java, [3]:
	 * target/classes, [4]: target/test-classes<br>
	 * e.g:../${project.name}/[1-4]/[0]/measurement/system/
	 */
	public String getMeasurementSystemPackageDir() {
		return getDir() + getMeasurementSystemPackageFQN().replace('.', '/') + "/";
	}

	/**
	 * [0]: codes.abdullah, [1]: src/main/java, [2]: src/test/java, [3]:
	 * target/classes, [4]: target/test-classes<br>
	 * e.g:../${project.name}/[1-4]/[0]/measurement/unit/
	 */
	public String getUnitPackageDir() {
		return getDir() + getUnitPackageFQN().replace('.', '/') + "/";
	}

	/**
	 * [0]: codes.abdullah, [1]: src/main/java, [2]: src/test/java, [3]:
	 * target/classes, [4]: target/test-classes<br>
	 * e.g:../${project.name}/[1-4]/[0]/measurement/dimension/
	 */
	public String getDimensionPackageDir() {
		return getDir() + getDimensionPackageFQN().replace('.', '/') + "/";
	}

	/**
	 * [0]: codes.abdullah, [1]: src/main/java, [2]: src/test/java, [3]:
	 * target/classes, [4]: target/test-classes<br>
	 * e.g:../${project.name}/[1-4]/[0]/measurement/dimension/convert/
	 */
	public String getDimensionConverterPackageDir() {
		return getDir() + getDimensionConverterPackageFQN().replace('.', '/') + "/";
	}

	/**
	 * [0]: codes.abdullah, [1]: src/main/java, [2]: src/test/java, [3]:
	 * target/classes, [4]: target/test-classes<br>
	 * e.g:../${project.name}/[1-4]/[0]/measurement/utils/
	 */
	public String getUtilsPackageDir() {
		return getDir() + getUtilsPackageFQN().replace('.', '/') + "/";
	}

	// ==============================
	// ============================== MeasurementSystem
	// ==============================

	/**
	 * e.g: MeasurementSystem
	 */
	public String getMeasurementSystemInterfaceName() {
		return MeasurementSystem.class.getSimpleName();
	}

	/**
	 * e.g: MeasurementSystem.java
	 */
	public String getMeasurementSystemInterfaceSourceName() {
		return getMeasurementSystemInterfaceName() + ".java";
	}

	/**
	 * e.g: ../measurement/system/MeasurementSystem.java
	 */
	public String getMeasurementSystemInterfaceSourcePath() {
		return getMeasurementSystemPackageDir() + getMeasurementSystemInterfaceSourceName();
	}

	/**
	 * e.g: ..system.MeasurementSystem
	 */
	public String getMeasurementSystemInterfaceFQN() {
		return getMeasurementSystemPackageFQN() + "." + getMeasurementSystemInterfaceName();
	}

	/**
	 * e.g: ..system.MeasurementSystem.class
	 * 
	 * @throws MalformedURLException
	 */
	public Class<?> getMeasurementSystemInterfaceClass() throws ClassNotFoundException, MalformedURLException {
		return target.getClassLoader().loadClass(getMeasurementSystemInterfaceFQN());
	}

	// ==============================
	// ============================== MeasurementSystems
	// ==============================

	/**
	 * e.g: MeasurementSystems
	 */
	public String getMeasurementSystemFactoryName() {
		return MeasurementSystems.class.getSimpleName();
	}

	/**
	 * e.g: MeasurementSystems.java
	 */
	public String getMeasurementSystemFactorySourceName() {
		return getMeasurementSystemFactoryName() + ".java";
	}

	/**
	 * e.g: ../measurement/system/MeasurementSystems.java
	 */
	public String getMeasurementSystemFactorySourcePath() {
		return getMeasurementSystemPackageDir() + getMeasurementSystemFactorySourceName();
	}

	/**
	 * e.g: ..system.MeasurementSystems
	 */
	public String getMeasurementSystemFactoryFQN() {
		return getMeasurementSystemPackageFQN() + "." + getMeasurementSystemFactoryName();
	}

	/**
	 * e.g: ..system.MeasurementSystems.class
	 * 
	 * @throws MalformedURLException
	 */
	public Class<?> getMeasurementSystemFactoryClass() throws ClassNotFoundException, MalformedURLException {
		return target.getClassLoader().loadClass(getMeasurementSystemFactoryFQN());
	}

	// ==============================
	// ============================== Dimension
	// ==============================

	/**
	 * e.g: Dimension
	 */
	public String getDimensionInterfaceName() {
		return Dimension.class.getSimpleName();
	}

	/**
	 * e.g: Dimension.java
	 */
	public String getDimensionInterfaceSourceName() {
		return getDimensionInterfaceName() + ".java";
	}

	/**
	 * e.g: ../measurement/dimension/Dimension.java
	 */
	public String getDimensionInterfaceSourcePath() {
		return getDimensionPackageDir() + getDimensionInterfaceSourceName();
	}

	/**
	 * e.g: ..dimension.Dimension
	 */
	public String getDimensionInterfaceFQN() {
		return getDimensionPackageFQN() + "." + getDimensionInterfaceName();
	}

	/**
	 * e.g: ..system.Dimension.class
	 * 
	 * @throws MalformedURLException
	 */
	public Class<?> getDimensionInterfaceClass() throws ClassNotFoundException, MalformedURLException {
		return target.getClassLoader().loadClass(getDimensionInterfaceFQN());
	}

	// ==============================
	// ============================== Dimensions
	// ==============================

	/**
	 * e.g: Dimensions
	 */
	public String getDimensionFactoryName() {
		return Dimensions.class.getSimpleName();
	}

	/**
	 * e.g: Dimensions.java
	 */
	public String getDimensionFactorySourceName() {
		return getDimensionFactoryName() + ".java";
	}

	/**
	 * e.g: ../measurement/dimension/Dimensions.java
	 */
	public String getDimensionFactorySourcePath() {
		return getDimensionPackageDir() + getDimensionFactorySourceName();
	}

	/**
	 * e.g: ..dimension.Dimensions
	 */
	public String getDimensionFactoryFQN() {
		return getDimensionPackageFQN() + "." + getDimensionFactoryName();
	}

	/**
	 * e.g: ..dimension.Dimensions.class
	 * 
	 * @throws MalformedURLException
	 */
	public Class<?> getDimensionFactoryClass() throws ClassNotFoundException, MalformedURLException {
		return target.getClassLoader().loadClass(getDimensionFactoryFQN());
	}

	// ==============================
	// ============================== DimensionConverter
	// ==============================

	/**
	 * e.g: DimensionConverter
	 */
	public String getDimensionConverterInterfaceName() {
		return DimensionConverter.class.getSimpleName();
	}

	/**
	 * e.g: DimensionConverter.java
	 */
	public String getDimensionConverterInterfaceSourceName() {
		return getDimensionConverterInterfaceName() + ".java";
	}

	/**
	 * e.g: ../measurement/dimension/DimensionConverter.java
	 */
	public String getDimensionConverterInterfaceSourcePath() {
		return getDimensionConverterPackageDir() + getDimensionConverterInterfaceSourceName();
	}

	/**
	 * e.g: ..dimension.DimensionConverter
	 */
	public String getDimensionConverterInterfaceFQN() {
		return getDimensionConverterPackageFQN() + "." + getDimensionConverterInterfaceName();
	}

	/**
	 * e.g: ..system.DimensionConverter.class
	 * 
	 * @throws MalformedURLException
	 */
	public Class<?> getDimensionConverterInterfaceClass() throws ClassNotFoundException, MalformedURLException {
		return target.getClassLoader().loadClass(getDimensionConverterInterfaceFQN());
	}

	// ==============================
	// ============================== DimensionConverters
	// ==============================

	/**
	 * e.g: DimensionConverters
	 */
	public String getDimensionConverterFactoryName() {
		return DimensionConverters.class.getSimpleName();
	}

	/**
	 * e.g: DimensionConverters.java
	 */
	public String getDimensionConverterFactorySourceName() {
		return getDimensionConverterFactoryName() + ".java";
	}

	/**
	 * e.g: ../measurement/dimension/DimensionConverters.java
	 */
	public String getDimensionConverterFactorySourcePath() {
		return getDimensionConverterPackageDir() + getDimensionConverterFactorySourceName();
	}

	/**
	 * e.g: ..dimension.DimensionConverters
	 */
	public String getDimensionConverterFactoryFQN() {
		return getDimensionConverterPackageFQN() + "." + getDimensionConverterFactoryName();
	}

	/**
	 * e.g: ..system.DimensionConverters.class
	 * 
	 * @throws MalformedURLException
	 */
	public Class<?> getDimensionConverterFactoryClass() throws ClassNotFoundException, MalformedURLException {
		return target.getClassLoader().loadClass(getDimensionConverterFactoryFQN());
	}

	// ==============================
	// ============================== Unit
	// ==============================

	/**
	 * e.g: Unit
	 */
	public String getUnitInterfaceName() {
		return Unit.class.getSimpleName();
	}

	/**
	 * e.g: Unit.java
	 */
	public String getUnitInterfaceSourceName() {
		return getUnitInterfaceName() + ".java";
	}

	/**
	 * e.g: ../measurement/unit/Unit.java
	 */
	public String getUnitInterfaceSourcePath() {
		return getUnitPackageDir() + getUnitInterfaceSourceName();
	}

	/**
	 * e.g: ..unit.Unit
	 */
	public String getUnitInterfaceFQN() {
		return getUnitPackageFQN() + "." + getUnitInterfaceName();
	}

	/**
	 * e.g: ..unit.Unit.class
	 * 
	 * @throws MalformedURLException
	 */
	public Class<?> getUnitInterfaceClass() throws ClassNotFoundException, MalformedURLException {
		return target.getClassLoader().loadClass(getUnitInterfaceFQN());
	}

	// ==============================
	// ============================== Units
	// ==============================

	/**
	 * e.g: Units
	 */
	public String getUnitFactoryName() {
		return Units.class.getSimpleName();
	}

	/**
	 * e.g: Units.java
	 */
	public String getUnitFactorySourceName() {
		return getUnitFactoryName() + ".java";
	}

	/**
	 * e.g: ../measurement/unit/Units.java
	 */
	public String getUnitFactorySourcePath() {
		return getUnitPackageDir() + getUnitFactorySourceName();
	}

	/**
	 * e.g: ..unit.Units
	 */
	public String getUnitFactoryFQN() {
		return getUnitPackageFQN() + "." + getUnitFactoryName();
	}

	/**
	 * e.g: ..unit.Units.class
	 * 
	 * @throws MalformedURLException
	 */
	public Class<?> getUnitFactoryClass() throws ClassNotFoundException, MalformedURLException {
		return target.getClassLoader().loadClass(getUnitFactoryFQN());
	}

	// ==============================
	// ==============================
	// ==============================

	/** e.g:../${project.name}/src/main/java/ */
	public static class Main extends Src {
		/** e.g:../${project.name}/src/main/java/ */
		@Override
		public String getDir() {
			return project_dir + "src/main/java/";
		}

	}

	public static class Test extends Src {

		/** e.g:../${project.name}/src/test/java/ */
		@Override
		public String getDir() {
			return project_dir + "src/test/java/";
		}
	}

	public static class Target extends Src {
		private URLClassLoader cl;

		/** e.g:../${project.name}/target/classes/ */
		@Override
		public String getDir() {
			return project_dir + "target/classes/";
		}

		/**
		 * class loader for target/classes and target/test-classes
		 * */
		public URLClassLoader getClassLoader() throws MalformedURLException {
			if (cl == null)
				cl = new URLClassLoader(new URL[] { new File(getDir()).toURI().toURL() });
			return cl;
		}

	}

	public static class TargetTest extends Target {

		/** e.g:../${project.name}/target/test-classes/ */
		@Override
		public String getDir() {
			return project_dir + "target/test-classes/";
		}

	}

	public static void main(String[] args) throws Exception {
		Object o = new Object();
		Src s = main;
		Src.setMasterPackage("com.google.j");
		System.out.println(main.getUnitInterfaceFQN());
		System.out.println(main.getDimensionConverterInterfaceSourcePath());
		System.exit(0);

//		System.out.println(main.getMeasurementSystemClass());
		for (Method m : s.getClass().getMethods()) {
			try {
				if (Arrays.stream(Object.class.getMethods()).filter((Method mm) -> mm.equals(m)).findFirst().isPresent()
						|| m.getName().equals("main"))
					continue;
//				System.out.println(m.getName());
				String ss = m.getName();
				if (ss.endsWith("Dir") || ss.endsWith("Path")) {
					ss = m.invoke(s).toString();
					if (!new File(ss).exists())
						throw new java.io.FileNotFoundException(ss);
				}
				System.out.println(m.getName() + "\t\t" + m.invoke(s));
			} catch (Exception e) {
				System.err.println(m.getName() + ": " + e);
			}
		}
	}

}