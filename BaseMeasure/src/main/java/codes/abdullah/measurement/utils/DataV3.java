package codes.abdullah.measurement.utils;

import static codes.abdullah.measurement.utils.GenV3.cap;
import static codes.abdullah.measurement.utils.GenV3.extractCamelWords;
import static codes.abdullah.measurement.utils.GenV3.plural;
import static codes.abdullah.measurement.utils.GenV3.toLowerCase;
import static codes.abdullah.measurement.utils.Src.main;
import static codes.abdullah.measurement.utils.Src.target;
import static codes.abdullah.measurement.utils.Src.targetTest;
import static codes.abdullah.measurement.utils.Src.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.DoubleLiteralExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.IntegerLiteralExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

import codes.abdullah.measurement.dimension.Dimension;
import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.system.MeasurementSystem;
import codes.abdullah.measurement.system.MeasurementSystems;
import codes.abdullah.measurement.unit.Unit;
import codes.abdullah.project.lang.Lang;

public class DataV3 {

	public final static double[] fixed_decimals_for_testing = { -1, -0.1, -0.0004567890, -73.25, -56229.321,
			-873.5432456, 0, 0.1, 0.0000876543297, 0.33, 0.6543, 1, 1.6543, 22.45, 9876.5432, 1987654344.3345,
			784.46789765434 };
	// =========================
	private final String system;
	private final String dimension;
	private final String baseUnit;
	private final String suffix;
	private final String[] resources;
	private final String interfaceComments;
	private final String[] categories;
	private final boolean categorizeByDimensions;
	private final double[] maxes;
	private final String[] names;
	private final String[] symbols;
	private final double[] factors;

	DataV3(String[] resources, String interfaceComments, String system, String dimension, double[] maxes,
			String[] unitSymbols, String[] unitNames, String baseUnitName, String categories,
			boolean categorizeByDimensions, String unitClassSuffix) {
		if (maxes.length != unitNames.length)
			throw new IllegalArgumentException("unitMaxes.length != unitNames.length");
		if (maxes.length != unitSymbols.length)
			throw new IllegalArgumentException("unitMaxes.length != unitSymbols.length");
		this.system = system.toLowerCase();
		this.dimension = dimension.toLowerCase();
		this.maxes = Arrays.copyOf(maxes, maxes.length);
		this.names = Arrays.copyOf(toLowerCase(unitNames), unitNames.length);
		this.symbols = Arrays.copyOf(unitSymbols, unitSymbols.length);
		this.resources = resources == null ? new String[0] : Arrays.copyOf(resources, resources.length);
		this.interfaceComments = interfaceComments == null ? "" : interfaceComments;
		this.suffix = unitClassSuffix;
		List<String> lcategories = new ArrayList<>();
		if (categories != null && !categories.trim().isEmpty()) {
			lcategories.addAll(
					Arrays.stream(categories.split("[.]")).map(g -> g.toLowerCase()).collect(Collectors.toList()));
		}
		if (categorizeByDimensions)
			lcategories.add(dimension.toLowerCase());
		this.categories = lcategories.toArray(new String[lcategories.size()]);
		this.baseUnit = baseUnitName.toLowerCase();
		this.categorizeByDimensions = categorizeByDimensions;
		List<Double> factors = new ArrayList<>();
		for (int i = 0; i < maxes.length; i++) {
			factors.add(0d);
		}

//		for (int i = 0; i < Imperials.YARD.unitsCount(); i++) {
//			ImperialLength u = (ImperialLength) Imperials.YARD.unitAt(i); 
//			System.out.printf("1 %s = %f yard\n", u.getSymbol(), u.toYards(1));
//		}

		int baseIndex = -1;

		main: for (int i = 0; i < unitNames.length; i++) {
			if (unitNames[i].equals(baseUnitName)) {
				baseIndex = i;
				break main;
			}
		}

		if (baseIndex == -1)
			throw new java.lang.IndexOutOfBoundsException(
					"can't find " + baseUnitName + " in " + Arrays.toString(unitNames));

		double result = 1;
		for (int i = baseIndex - 1; i >= 0; i--) {
			result = result / maxes[i];
//			System.out.printf("%d: %s(%s) = %s\n", i, unitNames[i], unitSymbols[i], noE(result));
			factors.set(i, result);
		}
//
		result = 1;
		for (int i = baseIndex; i < maxes.length; i++) {
//			System.out.printf("%d: %s(%s) = %s\n", i, unitNames[i], unitSymbols[i], noE(result));
			factors.set(i, result);
			result = result * maxes[i];

		}

		this.factors = Lang.primitive.to.doubles(factors);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj instanceof DataV3) {
			DataV3 o = (DataV3) obj;
			return system.equals(o.system)//
					&& dimension.equals(o.dimension)//
					&& baseUnit.equals(o.baseUnit)//
					&& categorizeByDimensions == o.categorizeByDimensions//
					&& Arrays.equals(maxes, o.maxes)//
					&& Arrays.equals(names, o.names)//
					&& Arrays.equals(symbols, o.symbols);
		}
		return super.equals(obj);
	}

	DataV3(MeasurementSystem ms, Dimension d)
			throws FileNotFoundException, ClassNotFoundException, SecurityException, MalformedURLException {
//		System.out.println(ms+":"+d);
		List<Double> dMaxes = new ArrayList<Double>();
		List<Double> dFactors = new ArrayList<Double>();
		List<String> sSymboles = new ArrayList<>();
		List<String> sNames = new ArrayList<>();
		List<String> sCategories = new ArrayList<>();
		String suffix = null;
		String baseUnitName = null;
		this.system = ms.getName().toLowerCase();
		this.dimension = d.toString().toLowerCase();
		CompilationUnit cu = StaticJavaParser.parse(new File(getFactorySourcePath()));
		ClassOrInterfaceDeclaration factory = cu.getClassByName(getFactoryName()).get();
		Optional<ClassOrInterfaceDeclaration> categorizeByDimensionsOptional = factory
				.findAll(ClassOrInterfaceDeclaration.class).stream().filter(p -> p.getNameAsString().equals(dimension))
				.findFirst();

		categorizeByDimensions = categorizeByDimensionsOptional.isPresent();
		factory = categorizeByDimensions ? categorizeByDimensionsOptional.get() : factory;
		// all fields
		List<FieldDeclaration> factoryFields = factory.getFields();
		// e.g: public static final MetricLength MILLIMETER = new
		// MetricLength(millimeters, "mm", 0, max_millimeters);
		List<FieldDeclaration> units = factoryFields.stream()
				.filter(p -> p.getVariable(0).getTypeAsString().equals(getUnitName())).collect(Collectors.toList());

		List<Integer> indexes = new ArrayList<>();
		for (FieldDeclaration fd : units) {
			// e.g: JapanArea, SHAKU, new JapanArea(shakus, "勺", 0, max_shakus)
			List<Node> vd = fd.getVariable(0).getChildNodes();
			// e.g: new JapanArea(shakus, "勺", 0, max_shakus);
			ObjectCreationExpr obe = (ObjectCreationExpr) vd.get(2);
			// e.g: [JapanArea, shakus, "勺", 0, max_shakus]
			// =================

			if (suffix == null) {
				String type = ((ClassOrInterfaceType) vd.get(0)).asString();
				String[] words = extractCamelWords(type);
				suffix = words[words.length - 1];
			}

			sNames.add(((SimpleName) vd.get(1)).asString().toLowerCase());
			sSymboles.add(((StringLiteralExpr) obe.getChildNodes().get(2)).asString());
			indexes.add(((IntegerLiteralExpr) obe.getChildNodes().get(3)).asNumber().intValue());
			String factorFieldName = ((NameExpr) obe.getChildNodes().get(1)).getNameAsString();
			String maxFieldName = ((NameExpr) obe.getChildNodes().get(4)).getNameAsString();

			// e.g: static final double gos = 10d;
			FieldDeclaration factorField = factoryFields.stream()
					.filter(p -> p.getVariable(0).getNameAsString().equals(factorFieldName)).findFirst().get();

			Expression e = (Expression) factorField.getVariable(0).getChildNodes().get(2);
			dFactors.add(((DoubleLiteralExpr) e).asDouble());

			FieldDeclaration maxField = factoryFields.stream()
					.filter(p -> p.getVariable(0).getNameAsString().equals(maxFieldName)).findFirst().get();
			Expression max = (Expression) maxField.getVariable(0).getChildNodes().get(2);
			dMaxes.add(Double.parseDouble(max.toString()));
		}

//		System.out.println(sNames);
//		System.out.println(sSymboles);
//		System.out.println(indexes);
//		System.out.println(dMaxes);
//		System.out.println(dFactors);

		cu = StaticJavaParser.parse(new File(getUnitSourcePath()));
		ClassOrInterfaceDeclaration unit = cu.getClassByName(getUnitName()).get();
		MethodDeclaration md = unit.getMethodsByName("getBaseUnit").get(0);
		ReturnStmt returnstmt = (ReturnStmt) md.getBody().get().getStatements().get(0);
		// e.g: return Blas.foo.bar.length.BLA1;
		String sReturnStmt = returnstmt.toString();
		baseUnitName = sReturnStmt.substring(sReturnStmt.lastIndexOf('.') + 1, sReturnStmt.indexOf(';'));
		// e.g: return Metrics.METER;
		// e.g: return Metrics.length.METER;
		// e.g: return Metrics.foo.bar.length.METER;
		int indexOfDot = sReturnStmt.indexOf('.');
		int lastIndexOfOfDot = sReturnStmt.indexOf('.');
		if (indexOfDot < lastIndexOfOfDot) {
			String categories = sReturnStmt.substring(indexOfDot + 1, lastIndexOfOfDot);
			// in-case detect only: METER, and categorizeByDimensions is true, throw
			// exception
			if (categories.equals(baseUnitName)) {
				if (categorizeByDimensions) {
					throw new IllegalStateException(
							String.format("detect categorizeByDimensions(%s), but %s.equals(%s) is true as well",
									categorizeByDimensions, categories, baseUnitName));
				}

				// no categories detected here
			} else {
//			categories detected here
				List<String> l = Arrays.stream(categories.split("[.]")).collect(Collectors.toList());
				if (categorizeByDimensions && l.get(l.size() - 1).equals(dimension))
					l.remove(l.size() - 1);
				sCategories.addAll(l);
			}
		}
		this.maxes = Lang.primitive.to.doubles(dMaxes);
		this.names = sNames.toArray(new String[sNames.size()]);
		this.symbols = sSymboles.toArray(new String[sSymboles.size()]);
		this.baseUnit = baseUnitName.toLowerCase();
		this.factors = Lang.primitive.to.doubles(dFactors);
		this.categories = sCategories.toArray(new String[sCategories.size()]);
		this.suffix = suffix.toLowerCase().equals(dimension) ? null : suffix.toLowerCase();
		//TODO
		this.interfaceComments = "";
		this.resources = new String[0];
	}

	public static void main(String[] args) throws Exception {
		final String system = "bla";
		// ================================
		String dimension = "length";
		String baseUnit = "bla1";
		String[] names = new String[] { "bla0", "bla1", "bla2" };
		String[] symbols = new String[] { "mm", "cm", "d" };
		double[] maxes = new double[] { 10, 10, 10 };
//		DataV3 s = new DataV3(system, dimension, maxes, symbols, names, baseUnit, "foo.bar", true);
//		System.out.println(s.getBaseUnitName());
		getAll();
//		printAllMethods();
		new DataV3(MeasurementSystems.METRIC_SYSTEM, Dimensions.AREA);

	}

	/**
	 * suffix that been used for generated unit-class names, e.g: MetricSuffix, if
	 * this suffix is null, will use given dimension name, e.g: MetricLength<br>
	 * This can be useful in case of having 2 different implementations of 1 system
	 * and 1 dimension, e.g: byte and bit
	 * 
	 * @return if suffix == null, return {@link #getDimensionName()}
	 */
	public String getSuffix() {
		return suffix == null ? getDimensionName() : cap(suffix);
	}

	/**
	 * resources which contains all the information collected about the system, e.g:
	 * wikipedia url, or a book name<br>
	 * resources will be added to {@link #getInterfaceClass()}
	 */
	public String[] getResources() {
		return Arrays.copyOf(resources, resources.length);
	}

	/**
	 * comments to be added to {@link #getInterfaceClass()}
	 */
	public String getInterfaceComments() {
		return interfaceComments;
	}

	// ===================
	// =================== Category
	// ===================

	/**
	 * Some systems have same units for different dimensions, so we need to make
	 * category (inner-class for each dimension) to avoid collisions, e.g: Japan
	 * system, has unit shakus for length and area, we can leave shakus for length
	 * normal and make an inner class for area dimension inside factory class, e.g:
	 * Japans.area.SHAKUS
	 * 
	 * @return true if categorized by dimension
	 */
	public boolean isCategorized() {
		return categories.length != 0;
	}

	/**
	 * e.g: category is current dimension name in case {@link #isCategorized()} is
	 * true
	 * 
	 * @return always will return dimension-name in lower-case
	 */
	public String getCategoryName() {
		return getCategoryNameAt(getCategoriesCount() - 1);
	}

	/**
	 * return all categories, except dimension name if
	 * {@link #categorizeByDimensions} is true, e.g: us.foo.bar
	 */
	public String getCategoriesTree() {
		return Arrays.stream(categories).collect(Collectors.joining("."));
	}

	/**
	 * count of categories
	 */
	public int getCategoriesCount() {
		return categories.length;
	}

	public String getCategoryNameAt(int i) {
		return categories[i];
	}

	/**
	 * @return e.g: for Japan system with area dimension, return class
	 *         codes.abdullah.measurement.system.japan.Japans$area, otherwise will
	 *         always return factory class itself
	 * @throws MalformedURLException
	 * @throws SecurityException
	 */
	public Class<?> getCategoryClass() throws ClassNotFoundException, SecurityException, MalformedURLException {
		if (isCategorized()) {
			Class<?> cls = findInnerClass(getFactoryClass(), getCategoryName());
			if (cls != null)
				return cls;
			throw new IllegalStateException("not found category class: " + getCategoryName());
		}
		return getFactoryClass();
	}

	private static Class<?> findInnerClass(Class<?> cls, String target) {
		Class<?>[] arr = cls.getDeclaredClasses();
		for (Class<?> c : arr) {
			if (c.getSimpleName().equals(target)) {
				return c;
			}
			return findInnerClass(c, target);
		}
		return null;
	}

	/**
	 * e.g: ..measurement.system.metric.Metrics, and if {@link #isCategorized()}
	 * true, will return e.g: ..measurement.system.metric.Metrics.length
	 */
	public String getCategoryFQN() {
		if (isCategorized())
			return getPackageFQN() + "." + getFactoryName() + "." + getCategoriesTree();
		return getPackageFQN() + "." + getFactoryName();
	}

	// ===================
	// =================== package
	// ===================

	/**
	 * e.g: metric
	 */
	public String getSystemName() {
		return system.toLowerCase();
	}

	/**
	 * e.g: ../measurement/system/metric/
	 */
	public String getPackagePath() {
		return main.getMeasurementSystemPackageDir() + getSystemName() + "/";
	}

	/**
	 * e.g: ../measurement/system/metric/
	 */
	public String getTestPackagePath() {
		return test.getMeasurementSystemPackageDir() + getSystemName() + "/";
	}

	/**
	 * e.g: ..measurement.system.metric
	 */
	public String getPackageFQN() {
		return main.getMeasurementSystemPackageFQN() + "." + getSystemName();
	}

	// ===================
	// =================== dimension
	// ===================

	/**
	 * e.g: Length
	 */
	public String getDimensionName() {
		return cap(this.dimension);
	}

	/**
	 * e.g: ..measurement.dimension.Length
	 */
	public String getDimensionFQN() {
		return main.getDimensionPackageFQN() + "." + getDimensionName();
	}

	/**
	 * e.g: ..measurement.dimension.Length.class
	 */
	public Class<?> getDimensionClass() throws ClassNotFoundException {
		return Class.forName(getDimensionFQN());
	}

	// ===================
	// =================== interface
	// ===================

	/**
	 * e.g: Metric
	 */
	public String getInterfaceName() {
		return cap(system);
	}

	/**
	 * e.g: Metric.java
	 */
	public String getInterfaceSourceName() {
		return getInterfaceName() + ".java";
	}

	/**
	 * e.g: ../measurement/system/metric/Metric.java
	 */
	public String getInterfaceSourcePath() {
		return getPackagePath() + "/" + getInterfaceSourceName();
	}

	/**
	 * e.g: ..system.metric.Metric.class
	 * 
	 * @throws MalformedURLException
	 */
	public Class<?> getInterfaceClass() throws ClassNotFoundException, MalformedURLException {
		return target.getClassLoader().loadClass(getInterfaceFQN());
	}

	/**
	 * e.g: ..system.metric.Metric
	 */
	public String getInterfaceFQN() {
		return getPackageFQN() + "." + getInterfaceName();
	}

	// ===================
	// =================== factory
	// ===================

	/**
	 * e.g: Metrics
	 */
	public String getFactoryName() {
		return getInterfaceName() + "s";
	}

	/**
	 * e.g: Metrics.java
	 */
	public String getFactorySourceName() {
		return getFactoryName() + ".java";
	}

	/**
	 * e.g: ../measurement/system/metric/Metrics.java
	 */
	public String getFactorySourcePath() {
		return getPackagePath() + "/" + getFactorySourceName();
	}

	/**
	 * e.g: ..measurement.system.metric.Metrics
	 */
	public String getFactoryFQN() {
		return getPackageFQN() + "." + getFactoryName();
	}

	/**
	 * e.g: ..measurement.system.metric.Metrics.class
	 * 
	 * @throws MalformedURLException
	 */
	public Class<?> getFactoryClass() throws ClassNotFoundException, MalformedURLException {
		return target.getClassLoader().loadClass(getFactoryFQN());
	}

	// ===================
	// =================== unit
	// ===================

	/**
	 * e.g: MetricLength
	 */
	public String getUnitName() {
		return cap(system) + getSuffix();
	}

	/**
	 * e.g: MetricLength.java
	 */
	public String getUnitSourceName() {
		return getUnitName() + ".java";
	}

	/**
	 * e.g: ../measurement/system/metric/MetricLength.java
	 */
	public String getUnitSourcePath() {
		return getPackagePath() + "/" + getUnitSourceName();
	}

	/**
	 * e.g: ..measurement.system.metric.MetricLength.class
	 * 
	 * @throws MalformedURLException
	 */
	public Class<?> getUnitClass() throws ClassNotFoundException, MalformedURLException {
		return target.getClassLoader().loadClass(getUnitFQN());
	}

	/**
	 * e.g: ..measurement.system.metric.MetricLength
	 */
	public String getUnitFQN() {
		return getPackageFQN() + "." + getUnitName();
	}

	// ===================
	// =================== test-fixed
	// ===================

	/**
	 * e.g: TestFixedMetricLength
	 */
	public String getTestFixedName() {
		return String.format("TestFixed%s%s", cap(getSystemName()), getSuffix());
	}

	/**
	 * e.g: TestFixedMetricLength.java
	 */
	public String getTestFixedSourceName() {
		return getTestFixedName() + ".java";
	}

	/**
	 * e.g: ../measurement/system/metric/TestFixedMetricLength.java
	 */
	public String getTestFixedSourcePath() {
		return getTestPackagePath() + getTestFixedSourceName();
	}

	/**
	 * e.g: ..system.metric.TestFixedMetricLength.class
	 * 
	 * @throws MalformedURLException
	 */
	public Class<?> getTestFixedClass() throws ClassNotFoundException, MalformedURLException {
		return targetTest.getClassLoader().loadClass(getTestFixedFQN());
	}

	/**
	 * e.g: ..system.metric.TestFixedMetricLength
	 */
	public String getTestFixedFQN() {
		return getPackageFQN() + "." + getTestFixedName();
	}

	// ===================
	// =================== test-random
	// ===================

	/**
	 * e.g: TestRandomMetricLength
	 */
	public String getTestRandomName() {
		return String.format("TestRandom%s%s", cap(getSystemName()), getSuffix());
	}

	/**
	 * e.g: TestRandomMetricLength.java
	 */
	public String getTestRandomSourceName() {
		return getTestRandomName() + ".java";
	}

	/**
	 * e.g: ../measurement/system/metric/TestRandomMetricLength.java
	 */
	public String getTestRandomSourcePath() {
		return getTestPackagePath() + getTestRandomSourceName();
	}

	/**
	 * e.g: ..system.metric.TestRandomMetricLength.class
	 * 
	 * @throws MalformedURLException
	 */
	public Class<?> getTestRandomClass() throws ClassNotFoundException, MalformedURLException {
		return targetTest.getClassLoader().loadClass(getTestRandomFQN());
	}

	/**
	 * e.g: ..system.metric.TestRandomMetricLength
	 */
	public String getTestRandomFQN() {
		return getPackageFQN() + "." + getTestRandomName();
	}

	// ===================
	// =================== test-suite
	// ===================

	/**
	 * e.g: TestAllMetricsSuite
	 */
	public String getTestAllSuiteName() {
		return String.format("TestAll%sSuite", cap(plural(getSystemName())));
	}

	/**
	 * e.g: TestAllMetricsSuite.java
	 */
	public String getTestAllSuiteSourceName() {
		return getTestAllSuiteName() + ".java";
	}

	/**
	 * e.g: ../measurement/system/metric/TestAllMetricsSuite.java
	 */
	public String getTestAllSuiteSourcePath() {
		return getTestPackagePath() + "/" + getTestAllSuiteSourceName();
	}

	/**
	 * e.g: ..system.metric.TestAllMetricsSuite.class
	 * 
	 * @throws MalformedURLException
	 */
	public Class<?> getTestAllSuiteClass() throws ClassNotFoundException, MalformedURLException {
		return targetTest.getClassLoader().loadClass(getTestAllSuiteFQN());
	}

	/**
	 * e.g: ..system.metric.TestAllMetricsSuite
	 */
	public String getTestAllSuiteFQN() {
		return getPackageFQN() + "." + getTestAllSuiteName();
	}

	// ===================
	// =================== test dimension-converters
	// ===================

	/**
	 * e.g: Test[Fixed|Random]MetricToImperialLength
	 */
	public String getTestDimensionConverterName(boolean fixed, DataV3 to) {
		return String.format("Test%s%sTo%s%s", fixed ? "Fixed" : "Random", cap(getSystemName()),
				cap(to.getSystemName()), getSuffix());
	}

	/**
	 * e.g: Test[Fixed|Random]MetricToImperialLength.java
	 */
	public String getTestDimensionConverterSourceName(boolean fixed, DataV3 to) {
		return getTestDimensionConverterName(fixed, to) + ".java";
	}

	/**
	 * e.g:
	 * ../measurement/dimension/convert/Test[Fixed|Random]MetricToImperialLength.java
	 */
	public String getTestDimensionConverterSourcePath(boolean fixed, DataV3 to) {
		return test.getDimensionConverterPackageDir() + getTestDimensionConverterSourceName(fixed, to);
	}

	/**
	 * e.g:
	 * ..measurement.dimension.convert.Test[Fixed|Random]MetricToImperialLength.class
	 * 
	 * @throws MalformedURLException
	 */
	public Class<?> getTestDimensionConverterClass(boolean fixed, DataV3 to)
			throws ClassNotFoundException, MalformedURLException {
		return targetTest.getClassLoader().loadClass(getTestDimensionConverterFQN(fixed, to));
	}

	/**
	 * e.g: ..measurement.dimension.convert.Test[Fixed|Random]MetricToImperialLength
	 */
	public String getTestDimensionConverterFQN(boolean fixed, DataV3 to) {
		return test.getDimensionConverterPackageFQN() + "." + getTestDimensionConverterName(fixed, to);
	}

	// ===================
	// =================== test-dimension-convert-suite
	// ===================

	/**
	 * e.g: TestAllMetricsDimensionConvertersSuite
	 */
	public String getTestAllDimensionConvertersSuiteName() {
		return String.format("TestAll%sDimensionConvertersSuite", cap(plural(getSystemName())));
	}

	/**
	 * e.g: TestAllMetricsDimensionConvertersSuite.java
	 */
	public String getTestAllDimensionConvertersSuiteSourceName() {
		return getTestAllDimensionConvertersSuiteName() + ".java";
	}

	/**
	 * e.g:
	 * ../measurement/dimension/convert/TestAllMetricsDimensionConvertersSuite.java
	 */
	public String getTestAllDimensionConvertersSuiteSourcePath() {
		return test.getDimensionConverterPackageDir() + getTestAllDimensionConvertersSuiteSourceName();
	}

	/**
	 * e.g: ..dimension.convert.TestAllMetricsDimensionConvertersSuite.class
	 * 
	 * @throws MalformedURLException
	 */
	public Class<?> getTestAllDimensionConvertersSuiteClass() throws ClassNotFoundException, MalformedURLException {
		return targetTest.getClassLoader().loadClass(getTestAllDimensionConvertersSuiteFQN());
	}

	/**
	 * e.g: ..system.dimension.convert.TestAllMetricsDimensionConvertersSuite
	 */
	public String getTestAllDimensionConvertersSuiteFQN() {
		return test.getDimensionConverterPackageFQN() + "." + getTestAllDimensionConvertersSuiteName();
	}

	// ===================
	// =================== provided data
	// ===================

	/**
	 * e.g: meter
	 */
	public String getBaseUnitName() {
		return baseUnit;
	}

	/**
	 * e.g: {..10,10,10..}
	 */
	public double[] getUnitMaxesArray() {
		return Arrays.copyOf(maxes, maxes.length);
	}

	/**
	 * e.g:
	 */
	public double getUnitMaxAt(int i) {
		return maxes[i];
	}

	public double getUnitFactorAt(int i) {
		return factors[i];
	}

	/**
	 * e.g: {..cm,m,dm,km..}
	 */
	public String[] getUnitSymbolsArray() {
		return Arrays.copyOf(symbols, symbols.length);
	}

	/**
	 * e.g:
	 */
	public String getUnitSymbolAt(int i) {
		return symbols[i];
	}

	/**
	 * e.g: {..centimeter,meter,kilometer..}
	 */
	public String[] getUnitNamesArray() {
		return Arrays.copyOf(names, names.length);
	}

	/**
	 * e.g:
	 */
	public String getUnitNameAt(int i) {
		return names[i];
	}

	/**
	 * e.g:
	 */
	public int getUnitsCount() {
		return names.length;
	}

//	public int getExponentAt(int i) {
//		return exponents[i];
//	}

	/**
	 * e.g: METRICS_LENGTH_UNITS
	 */
	public String getUnitsArrayFieldName() {
		return String.format("%s_%s_UNITS", getInterfaceName(), getSuffix()).toUpperCase();
	}

	// ===================
	// =================== fields
	// ===================

	/**
	 * e.g: METRIC_SYSTEM
	 */
	public String getSystemFieldName() {
		return getSystemName().toUpperCase() + "_SYSTEM";
	}

	/**
	 * e.g: METER
	 */
	public String getFactoryFieldNameAt(int i) throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		return getUnitNameAt(i).toUpperCase();
	}

	/**
	 * @return e.g: ..measurement.system.metric.Metrics.MILLIMETER, or if
	 *         {@link #isCategorized()} true, will return e.g:
	 *         ..measurement.system.metric.Metrics$length.MILLIMETER
	 */
	public String getFactoryFieldFQNAt(int i) {
		return getCategoryFQN() + "." + getUnitNameAt(i).toUpperCase();
	}

	/**
	 * e.g: Metrics.METER field
	 * 
	 * @throws MalformedURLException
	 * 
	 * @see #isCategorized()
	 * @see #getCategoryClass()
	 */
	public Field loadFactoryFieldAt(int i)
			throws ClassNotFoundException, NoSuchFieldException, SecurityException, MalformedURLException {
		Class<?> category = getCategoryClass();
		return category.getField(getFactoryFieldNameAt(i));
	}

	// ===================
	// =================== load
	// ===================
	/**
	 * e.g: installed LENGTH
	 */
	public Dimension loadDimension() {
		return MeasurementSystems.findDimension(dimension);
	}

	/**
	 * e.g: installed METRIC_SYSTEM
	 */
	public MeasurementSystem loadSystem() {
		return MeasurementSystems.findMeasurementSystem(system);
	}

	@SuppressWarnings("unchecked")
	public <D extends Dimension> Unit<D> loadUnitAt(int i) throws ClassNotFoundException, NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException, MalformedURLException {
		return (Unit<D>) loadFactoryFieldAt(i).get(null);
	}

	//

	public static List<DataV3> getAll() {
		return getAllBy(null, null);
	}

	public static List<DataV3> getAllBySystem(String system) {
		return getAllBy(system, null);
	}

	public static List<DataV3> getAllByDimension(String dimension) {
		return getAllBy(null, dimension);
	}

	public static List<DataV3> getAllBy(String system, String dimension) {
		List<DataV3> l = new ArrayList<>();
		MeasurementSystems.getInstalledSystems().forEach(ms -> {
			MeasurementSystems.getInstalledDimensions().forEach(dim -> {
				try {
					l.add(new DataV3(ms, dim));
				} catch (FileNotFoundException e) {
					System.err.println(e);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			});
		});
		if (system != null) {
			List<DataV3> l2 = l.stream().filter(p -> p.getSystemName().equals(system)).collect(Collectors.toList());
			l.clear();
			l.addAll(l2);
		}
		if (dimension != null) {
			List<DataV3> l2 = l.stream().filter(p -> p.getDimensionName().equals(dimension))
					.collect(Collectors.toList());
			l.clear();
			l.addAll(l2);
		}
		return l;
	}

	public static void printAllMethods() throws ClassNotFoundException, MalformedURLException {
		// TODO support params
		List<DataV3> all = DataV3.getAll();
		DataV3 s = all.get(0);
		DataV3 other = all.stream().filter(d -> d.getUnitName().equals("ImperialLength")).findFirst().get();
//		System.out.println(s);
//		System.out.println(other);
//		System.out.println(s.getTestFixedDimensionConverterSourcePath(other));
//		s.getTestFixedDimensionConverterClass(other);
//		System.exit(0);

		Method[] mm = s.getClass().getMethods();
		Arrays.sort(mm, (m1, m2) -> m1.getName().compareTo(m2.getName()));
		Arrays.stream(mm).forEach(m -> {

			try {
				boolean skip = Arrays.stream(Object.class.getMethods()).filter((Method m0) -> m0.equals(m)).findFirst()
						.isPresent() || m.getName().equals("main") || m.getName().equals("equals")
						|| m.getName().contains("getAll") || m.getName().contains("printAllMethods");

				if (!skip) {

					Object[] params = new Object[0];
					if (m.getParameterCount() == 1) {
						Class<?>[] types = m.getParameterTypes();
						if (types[0].equals(DataV3.class))
							params = new Object[] { other };
						else if (types[0].isPrimitive())
							params = new Object[] { 0 };
					}

					String ss = m.getName();
					if (ss.endsWith("Dir") || ss.endsWith("Path")) {
						ss = m.invoke(s, params).toString();
						if (!new File(ss).exists())
							throw new java.io.FileNotFoundException(ss);
					}

//					System.out.println(m.getName()+", "+m.getParameterCount()+", "+params.length);
					System.out.println(m.getName() + "\t\t" + m.invoke(s, params));
				}

//				Thread.sleep(500);
			} catch (Exception e) {
				System.err.println(m.getName() + ": " + e);
//				System.out.println(m.getName() + "################################### " + m.getParameterCount());
//				e.printStackTrace();
//				System.exit(0);

			}
		});
	}

	@Override
	public String toString() {
		return "DataV3 [system=" + system + ", dimension=" + dimension + ", baseUnit=" + baseUnit
				+ ", categorizeByDimensions=" + categorizeByDimensions + ", unitMaxes=" + Arrays.toString(maxes)
				+ ", unitNames=" + Arrays.toString(names) + ", unitSymbols=" + Arrays.toString(symbols) + "]";
	}

}
