package codes.abdullah.measurement.utils;

import static codes.abdullah.measurement.utils.Src.main;
import static codes.abdullah.measurement.utils.Src.test;
import static com.github.javaparser.StaticJavaParser.parse;
import static com.github.javaparser.StaticJavaParser.parseClassOrInterfaceType;
import static com.github.javaparser.StaticJavaParser.parseExpression;
import static com.github.javaparser.ast.Modifier.Keyword.DEFAULT;
import static com.github.javaparser.ast.Modifier.Keyword.FINAL;
import static com.github.javaparser.ast.Modifier.Keyword.PRIVATE;
import static com.github.javaparser.ast.Modifier.Keyword.PUBLIC;
import static com.github.javaparser.ast.Modifier.Keyword.STATIC;
import static com.github.javaparser.ast.expr.AssignExpr.Operator.ASSIGN;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.ArrayCreationLevel;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.ArrayAccessExpr;
import com.github.javaparser.ast.expr.ArrayCreationExpr;
import com.github.javaparser.ast.expr.ArrayInitializerExpr;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.BinaryExpr.Operator;
import com.github.javaparser.ast.expr.ClassExpr;
import com.github.javaparser.ast.expr.DoubleLiteralExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.IntegerLiteralExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.expr.UnaryExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExplicitConstructorInvocationStmt;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.type.ArrayType;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.PrimitiveType;
import com.github.javaparser.ast.type.PrimitiveType.Primitive;
import com.github.javaparser.ast.type.VoidType;

import codes.abdullah.digits.Format;
import codes.abdullah.measurement.dimension.Dimension;
import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.dimension.convert.BasicDimensionConverter;
import codes.abdullah.measurement.dimension.convert.DimensionConverter;
import codes.abdullah.measurement.dimension.convert.DimensionConverters;
import codes.abdullah.measurement.system.BasicMeasurementSystem;
import codes.abdullah.measurement.system.MeasurementSystem;
import codes.abdullah.measurement.system.MeasurementSystems;
import codes.abdullah.measurement.system.digital.Digitals;
import codes.abdullah.measurement.unit.AbstractUnit;
import codes.abdullah.measurement.unit.Unit;

@SuppressWarnings("unused")
class GenV3 {

	// ==============================

	private DataV3 d;

	private static void add(List<? super CharSequence> l) {

	}

	public static void main(String[] args) throws Exception {
		List<String> l = null;
		List<Integer> l2 = null;

//		test();
//		metric();
//		imperial();
//		japan();
		digital();
//		usc();
//		generateDimensionConverters();
		
		System.out.println("done");

	
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenV3(DataV3 d) throws Exception {
		this.d = d;
		Files.createDirectories(Paths.get(d.getPackagePath()));

		generateSystemFiles();
		generateUnitInterfaceFile();
		generateFactoryFiles();
		generateUnitFiles();

//		generateTestFixedFiles();
//		generateTestRandomFiles();
//		generateTestAllSuite();
//		generateTestDimensionConvertersFiles(true);
//		generateTestDimensionConvertersFiles(false);
//		generateTestAllSuiteDimensionConvert();

	}

	private static void test() throws Exception {
		final String system = "bla";
		// ================================
		String dimension = "length";
		String baseUnit = "bla1";
		String[] names = new String[] { "bla0", "bla1", "bla2" };
		String[] symbols = new String[] { "mm", "cm", "d" };
		double[] maxes = new double[] { 10, 10, 10 };
		new BuilderV2().maxes(maxes).symbols(symbols).names(names).dimension(dimension).baseUnit(baseUnit)
				.system(system).categories("foo.bar").categorizedByDimension(true).build();
	}

	private static void metric() throws Exception {
		final String system = "metric";
		// ================================
		String dimension = "length";
		String baseUnit = "meter";
		String[] names = new String[] { "millimeter", "centimeter", "decimeter", "meter", "dekameter", "hecometer",
				"kilometer" };
		String[] symbols = new String[] { "mm", "cm", "dm", "m", "dam", "hm", "km" };
		double[] maxes = new double[] { 10, 10, 10, 10, 10, 10, 10 };
		new BuilderV2().maxes(maxes).symbols(symbols).names(names).dimension(dimension).baseUnit(baseUnit)
				.system(system).build();

		// ================================"²"
		dimension = "area";
		baseUnit = "square_" + baseUnit;
		names = prefixIt("square_", names);
		symbols = new String[] { "mm", "cm", "dm", "m", "dam", "hm", "km" };
		symbols = suffixIt(symbols, Dimensions.e2 + "");
		maxes = new double[] { 10, 10, 10, 10, 10, 10, 10 };
		new BuilderV2().maxes(maxes).symbols(symbols).names(names).dimension(dimension).baseUnit(baseUnit)
				.system(system).build();
		// ================================

		dimension = "mass";
		baseUnit = "gram";
		names = new String[] { "milligram", "centigram", "decigram", "gram", "dekagram", "hecogram", "kilogram" };
		symbols = new String[] { "mg", "cg", "dg", "g", "dag", "hg", "kg" };
		maxes = new double[] { 10, 10, 10, 10, 10, 10, 10 };
		new BuilderV2().maxes(maxes).symbols(symbols).names(names).dimension(dimension).baseUnit(baseUnit)
				.system(system).build();
		// ================================

		dimension = "volume";
		baseUnit = "cubic_" + baseUnit;
		names = prefixIt("cubic_", names);
		symbols = new String[] { "mm", "cm", "dm", "m", "dam", "hm", "km" };
		symbols = suffixIt(symbols, Dimensions.e3 + "");
		maxes = new double[] { 10, 10, 10, 10, 10, 10, 10 };
		new BuilderV2().maxes(maxes).symbols(symbols).names(names).dimension(dimension).baseUnit(baseUnit)
				.system(system).build();

		// ==================================
		dimension = "volume";
		baseUnit = "liter";
		names = new String[] { "milliliter", "centiliter", "deciliter", "liter", "dekaliter", "hectoliter",
				"kiloliter" };
		symbols = new String[] { "ml", "cl", "dl", "l", "dal", "hl", "kl" };
		maxes = new double[] { 10, 10, 10, 10, 10, 10, 10 };

		new BuilderV2().maxes(maxes).symbols(symbols).names(names).dimension(dimension).baseUnit(baseUnit)
				.system(system).build();
		// ================================

		dimension = "time";
		baseUnit = "second";
		names = new String[] { "nanosecond", "microsecond", "millisecond", "second", "minute", "hour", "day" };
		symbols = new String[] { "ns", "μs", "ms", "sec", "min", "hour", "day" };
		maxes = new double[] { 1000, 1000, 1000, 60, 60, 24, -1 };
		new BuilderV2().maxes(maxes).symbols(symbols).names(names).dimension(dimension).baseUnit(baseUnit)
				.system(system).build();
		// ================================

		// ================================

		// ================================

	}

	private static void imperial() throws Exception {
		final String system = "imperial";
		// ================================
		String dimension = "length";
		String baseUnit = "foot";
		String[] names = new String[] { "thou", "inch", "foot", "yard", "chain", "furlong", "mile" };
		String[] symbols = new String[] { "th", "in", "ft", "yd", "ch", "fur", "mi" };
		double[] maxes = new double[] { 1000, 12, 3, 22, 10, 8, -1 };

		new BuilderV2().maxes(maxes).symbols(symbols).names(names).dimension(dimension).baseUnit(baseUnit)
				.system(system).build();
		// ================================
		dimension = "area";
		baseUnit = "square_" + baseUnit;
		names = prefixIt("square_", names);
		symbols = suffixIt(symbols, Dimensions.e2 + "");

		new BuilderV2().maxes(maxes).symbols(symbols).names(names).dimension(dimension).baseUnit(baseUnit)
				.system(system).build();
		// ================================
		dimension = "mass";
		baseUnit = "pound";
		names = new String[] { "grain", "drachm", "ounce", "pound", "stone", "quarter", "hundredweight" };
		symbols = new String[] { "gr", "dr", "oz", "lb", "st", "qr", "cwt" };
		maxes = new double[] { 1, 27, 16, 16, 14, 2, -1 };

		new BuilderV2().maxes(maxes).symbols(symbols).names(names).dimension(dimension).baseUnit(baseUnit)
				.system(system).build();
		// ================================

		dimension = "volume";
		baseUnit = "fluid_ounce";
		names = new String[] { "tea_spoon", "table_spoon", "fluid_ounce", "gill", "pint", "quart", "gallon" };
		symbols = new String[] { "tsp", "tbsp", "fl.oz", "gi", "pt", "qt", "gal" };
		maxes = new double[] { 3, 2, 5, 4, 2, 4, -1 };

		new BuilderV2().maxes(maxes).symbols(symbols).names(names).dimension(dimension).baseUnit(baseUnit)
				.system(system).build();

	}

	private static void usc() throws Exception {
		final String system = "usc";
		final String interfaceComments = "United States Customary Units";
		String[] resources = {
				//
				"https://en.wikipedia.org/wiki/United_States_customary_units"
				//
		};

		// ================================
		String dimension = "length";
		String baseUnit = "foot";
		String[] names = new String[] { "point", "pica", "inch", "foot", "yard", "mile" };
		String[] symbols = new String[] { "p", "P", "in", "ft", "yd", "mi" };
		double[] maxes = new double[] { 12, 6, 12, 3, 1760, -1 };

		new BuilderV2().maxes(maxes).symbols(symbols).names(names).dimension(dimension).baseUnit(baseUnit)
				.system(system).build();
		// ================================
		dimension = "volume";
		baseUnit = "fluid_ounce";
		names = new String[] { "tea_spoon", "table_spoon", "fluid_ounce", "cup", "pint", "quart", "gallon" };
		symbols = new String[] { "tsp", "tbsp", "fl.oz", "gi", "pt", "qt", "gal" };
		maxes = new double[] { 3, 2, 8, 2, 2, 4, -1 };

		new BuilderV2().maxes(maxes).symbols(symbols).names(names).dimension(dimension).baseUnit(baseUnit)
				.system(system).build();

		// ================================

		dimension = "length";
		baseUnit = "cable";
		names = new String[] { "fathom", "cable", "nautical_mile" };
		symbols = new String[] { "ftm", "cb", "NM" };
		maxes = new double[] { 6, 608, -1 };

		new BuilderV2().maxes(maxes).symbols(symbols).names(names).dimension(dimension).baseUnit(baseUnit)
				.system(system).suffix("nautical").build();
//		
	}

	private static void japan() throws Exception {
		final String system = "japan";
		// ================================
		String dimension = "length";
		String baseUnit = "shaku";
		String[] names = new String[] { "mo", "rin", "bu", "sun", "shaku", "ken", "jo", "cho", "ri" };
		String[] symbols = new String[] { "毛", "厘", "分", "寸", "尺", "間", "丈", "町", "里" };
		double[] maxes = new double[] { 10, 10, 10, 10, 6.0, 1.6666666666666667, 36.0, 36.0, -1 };

		new BuilderV2().maxes(maxes).symbols(symbols).names(names).dimension(dimension).baseUnit(baseUnit)
				.system(system).build();

		// ================================
		dimension = "area";
		baseUnit = "tsubo";
		names = new String[] { "shaku", "go", "jo", "tsubo", "se", "tan", "cho" };
		symbols = new String[] { "勺", "合", "畳", "坪", "畝", "段", "町" };
		maxes = new double[] { 10.0, 5.0, 2.0, 30.0, 10.0, 10.0, -1, };
		new BuilderV2().maxes(maxes).symbols(symbols).names(names).dimension(dimension).baseUnit(baseUnit)
				.system(system).categorizedByDimension(true).build();
		// ================================
		dimension = "mass";
		baseUnit = "kin";
		names = new String[] { "fun", "momme", "hyakume", "kin", "kan", "maru", "tan" };
		symbols = new String[] { "分", "匁", "百目", "斤", "貫", "丸", "担" };
		maxes = new double[] { 10, 100, 1.6, 6.25, 8.0, 2.0, -1, };

		new BuilderV2().maxes(maxes).symbols(symbols).names(names).dimension(dimension).baseUnit(baseUnit)
				.system(system).build();
		// ================================

		dimension = "volume";
		baseUnit = "sho";
		names = new String[] { "sai", "shaku", "go", "sho", "to", "koku" };
		symbols = new String[] { "才", "勺", "合", "升", "斗", "石" };
		maxes = new double[] { 0.001, 0.01, 0.1, 1, 10, -1, };

		new BuilderV2().maxes(maxes).symbols(symbols).names(names).dimension(dimension).baseUnit(baseUnit)
				.system(system).categorizedByDimension(true).build();
		// ================================

	}

	private static void digital() throws Exception {
		final String system = "digital";
		// ================================

		String dimension = "data";
		String baseUnit = "megabyte";
		String[] names = new String[] { "byte", "kilobyte", "megabyte", "gigabyte", "terabyte", "petabyte" };
		String[] symbols = new String[] { "b", "kb", "mb", "gb", "tb", "pb" };
		double[] maxes = new double[] { 1000, 1000, 1000, 1000, 1000, -1 };

		new BuilderV2().maxes(maxes).symbols(symbols).names(names).dimension(dimension).baseUnit(baseUnit)
				.system(system).suffix("byte").build();

		// ================================
		dimension = "data";
		baseUnit = "megabit";
		names = new String[] { "bit", "kilobit", "megabit", "gigabit", "terabit", "petabit" };
		symbols = new String[] { "bit", "kbit", "mbit", "gbit", "tbit", "pbit" };
		maxes = new double[] { 1000, 1000, 1000, 1000, 1000, -1 };
		new BuilderV2().maxes(maxes).symbols(symbols).names(names).dimension(dimension).baseUnit(baseUnit)
				.system(system).suffix("bit").build();
Digitals.BYTE.to(1, Digitals.BIT);
		// ================================

	}

	// ======================================
	// ======================================
	// ======================================
	// ======================================
	// ======================================
	// ======================================
	// ======================================
	// ======================================
	// ======================================
	// ======================================
	// ======================================
	// ======================================

	private void generateSystemFiles() throws Exception {
		File file = new File(main.getMeasurementSystemFactorySourcePath());

		if (!file.exists()) {
			throw new FileNotFoundException(main.getMeasurementSystemFactorySourcePath());
		}

		CompilationUnit cu = parse(file);
		ClassOrInterfaceDeclaration cd = cu.getClassByName(main.getMeasurementSystemFactoryName()).get();
		if (cd.getFieldByName(d.getSystemFieldName()).isPresent())
			return;
		ClassOrInterfaceType leftSide = new ClassOrInterfaceType(null, MeasurementSystem.class.getSimpleName());
		ClassOrInterfaceType righSide = new ClassOrInterfaceType(null, BasicMeasurementSystem.class.getSimpleName());
		NodeList<Expression> args = NodeList.nodeList(new StringLiteralExpr(d.getSystemName()));
		Expression initializer = new ObjectCreationExpr(null, righSide, args);
		cd.addFieldWithInitializer(leftSide, d.getSystemFieldName(), initializer, PUBLIC, STATIC, FINAL);
		overwrite(file.toString(), cu.toString());
	}

	private void generateUnitInterfaceFile() throws URISyntaxException, IOException {
		File file = new File(d.getInterfaceSourcePath());
		CompilationUnit cu = new CompilationUnit();
		ClassOrInterfaceDeclaration i = null;
		if (!file.exists()) {
			cu.setPackageDeclaration(d.getPackageFQN());
			i = cu.addInterface(d.getInterfaceName())
					.addTypeParameter(String.format("D extends %s", Dimension.class.getSimpleName())).addExtendedType(
							new ClassOrInterfaceType(null, String.format("%s<D>", Unit.class.getSimpleName())));
		} else {
			cu = parse(file);
			i = cu.getInterfaceByName(d.getInterfaceName()).get();
		}

		cu.addImport(Dimension.class);
		cu.addImport(Unit.class);
		cu.addImport(MeasurementSystem.class);
		cu.addImport(MeasurementSystems.class);

		if (i.getMethodsByName("getSystem").isEmpty()) {
			cu.addImport(MeasurementSystem.class);
			cu.addImport(MeasurementSystems.class);
			i.addMethod("getSystem", DEFAULT).addAnnotation(Override.class).setType(MeasurementSystem.class)
					.createBody()
					.addStatement(new ReturnStmt(String.format("MeasurementSystems.%s", d.getSystemFieldName())));
		}
		overwrite(d.getInterfaceSourcePath(), cu.toString());
	}

	private void generateFactoryFiles() throws Exception {
		File factoryFile = new File(d.getFactorySourcePath());
		ClassOrInterfaceDeclaration factory = null;
		CompilationUnit cu = new CompilationUnit();
		if (!factoryFile.exists()) {
			cu.setPackageDeclaration(d.getPackageFQN());
			factory = cu.addClass(d.getFactoryName());
			factory.addAndGetAnnotation(SuppressWarnings.class).addPair("value", new StringLiteralExpr("unchecked"));
		} else {
			cu = parse(factoryFile);
			factory = cu.getClassByName(d.getFactoryName()).get();
		}
		ImportDeclaration importDimension = new ImportDeclaration(d.getDimensionFQN(), false, false);
		cu.addImport(importDimension);
		// ==========
		// ==========

		if (d.isCategorized()) {
			Optional<ClassOrInterfaceDeclaration> o = factory.findAll(ClassOrInterfaceDeclaration.class).stream()
					.filter(p -> p.getNameAsString().equals(d.getCategoryName())).findFirst();
			ClassOrInterfaceDeclaration subFactory;
			if (o.isPresent()) {
				subFactory = o.get();
			} else {
				subFactory = factory;
				int i = 0;
				do {
					ClassOrInterfaceDeclaration sf = new ClassOrInterfaceDeclaration()
							.setModifiers(PUBLIC, STATIC, FINAL).setName(d.getCategoryNameAt(i));
					sf.addConstructor(PRIVATE);
					subFactory.addMember(sf);
					subFactory = sf;
					i++;
				} while (i < d.getCategoriesCount());

			}
			factory = subFactory;
		}

		// ==========
		// ========== max, i.e: static final double max_centimeters = max_millimeters *
		// millimeters;
		// ==========
		String max_format = "max_%s";

		for (int i = 0; i < d.getUnitsCount(); i++) {
			String unitname = d.getUnitNameAt(i);
			String maxfieldname = String.format(max_format, plural(unitname));
			if (!factory.getFieldByName(maxfieldname).isPresent()) {
				double factor = d.getUnitMaxAt(i);
				Expression initializer = new DoubleLiteralExpr(factor);
				factory.addFieldWithInitializer(double.class, maxfieldname, initializer, STATIC, FINAL);
			}

		}

		// ==========
		// ========== factor, i.e: static final double square_gos = max_square_shakus *
		// square_shakus;
		// ==========

		for (int i = 0; i < d.getUnitsCount(); i++) {
			String unitname = plural(d.getUnitNameAt(i));
			String fieldname = unitname;
			if (!factory.getFieldByName(fieldname).isPresent()) {
				Expression initializer;
				initializer = new DoubleLiteralExpr(noE(d.getUnitFactorAt(i)) + "d");
				factory.addFieldWithInitializer(double.class, fieldname, initializer, STATIC, FINAL);
			}

		}

		// e.g: MetricLength METER = new MetricLength(..);
		ClassOrInterfaceType unitDimType = parseClassOrInterfaceType(d.getUnitName());
		for (int i = 0; i < d.getUnitsCount(); i++) {
			String fieldname = d.getUnitNameAt(i).toUpperCase();
			if (!factory.getFieldByName(fieldname).isPresent()) {
				NodeList<Expression> args = new NodeList<>();
				args.add(new NameExpr(plural(d.getUnitNameAt(i))));
				args.add(new StringLiteralExpr(d.getUnitSymbolAt(i)));
				args.add(new IntegerLiteralExpr(String.valueOf(i)));
				args.add(new NameExpr(String.format(max_format, plural(d.getUnitNameAt(i)))));
				Expression initializer = new ObjectCreationExpr(null, unitDimType, args);
				factory.addFieldWithInitializer(unitDimType, fieldname, initializer, PUBLIC, STATIC, FINAL);
			}
		}

		// e.g: Metric<Length>[] METRIC_LENGTH_UNITS = new Metric[]{..};
		if (!factory.getFieldByName(d.getUnitsArrayFieldName()).isPresent()) {
			ArrayType arrayLeftType = new ArrayType(new ClassOrInterfaceType(null,
					String.format("%s<%s>", d.getInterfaceName(), d.getDimensionName())));
			ArrayType arrayRightType = new ArrayType(new ClassOrInterfaceType(null, d.getInterfaceName()));
			NodeList<Expression> args = new NodeList<>();
			for (int i = 0; i < d.getUnitNamesArray().length; i++) {
				args.add(new NameExpr(d.getUnitNameAt(i).toUpperCase()));
			}
			ArrayInitializerExpr arrayInitializer = new ArrayInitializerExpr(args);
			Expression initializer = new ArrayCreationExpr(arrayRightType, new NodeList<ArrayCreationLevel>(),
					arrayInitializer);
			factory.addFieldWithInitializer(arrayLeftType, d.getUnitsArrayFieldName(), initializer, STATIC, FINAL);
		}

		// ==========

		// ==========
		overwrite(d.getFactorySourcePath(), cu.toString());
//		System.out.println(cu);
	}

	private void generateUnitFiles() throws Exception {
		CompilationUnit cu = new CompilationUnit();
		File unitFile = new File(d.getUnitSourcePath());
		ClassOrInterfaceDeclaration unit;

		cu.setPackageDeclaration(d.getPackageFQN());
		unit = cu.addClass(d.getUnitName())
				.addExtendedType(new ClassOrInterfaceType(null,
						String.format("%s<%s>", AbstractUnit.class.getSimpleName(), d.getDimensionName())))
				.addImplementedType(String.format("%s<%s>", d.getInterfaceName(), d.getDimensionName()));

		cu.addImport(d.getDimensionClass());
		cu.addImport(main.getDimensionFactoryClass());
		cu.addImport(AbstractUnit.class);
		cu.addImport(Unit.class);
		cu.addImport(Arrays.class);
		// =============

		SimpleName nfactor = new SimpleName("factor");
		SimpleName nsymbol = new SimpleName("symbol");
		SimpleName nunitIndex = new SimpleName("unitIndex");
		SimpleName nmax = new SimpleName("max");

		Parameter pfactor = new Parameter(PrimitiveType.doubleType(), nfactor);
		Parameter psymbol = new Parameter(new ClassOrInterfaceType(null, "String"), nsymbol);
		Parameter punitIndex = new Parameter(PrimitiveType.intType(), nunitIndex);
		Parameter pmax = new Parameter(PrimitiveType.doubleType(), nmax);

		// default constructor
		if (!unit.getConstructorByParameterTypes(double.class, String.class, int.class, double.class).isPresent()) {
			// e.g: Dimensions.LENGTH
			Expression staticDim = parseExpression(
					String.format("%s.%s", Dimensions.class.getSimpleName(), d.getDimensionName().toUpperCase()));

			ConstructorDeclaration cd = unit.addConstructor();
			cd.addParameter(pfactor).addParameter(psymbol).addParameter(punitIndex).addParameter(pmax);
			NodeList<Expression> args2 = NodeList.nodeList(new NameExpr(nfactor), staticDim, new NameExpr(nsymbol),
					new NameExpr(nunitIndex), new NameExpr(nmax));
			Statement _super = new ExplicitConstructorInvocationStmt(false, null, args2);
			cd.createBody().addStatement(_super);
		}
		// ===================== most common types in a unit methods are below, will be
		// used a lot
		String returnExp = null;
		ClassOrInterfaceType unitDimReturnType = StaticJavaParser
				.parseClassOrInterfaceType(String.format("%s<%s>", Unit.class.getSimpleName(), d.getDimensionName()));
		ArrayType unitsReturnType = (ArrayType) StaticJavaParser
				.parseType(String.format("%s<%s>[]", Unit.class.getSimpleName(), d.getDimensionName()));
		String methodName = null;
		String factoryOrFactoryCategory = d.getFactoryName();

		if (d.isCategorized()) {
			factoryOrFactoryCategory += "." + d.getCategoriesTree();
		}

//		if (d.isCategorized() || d.isSubfactored())cu.addImport(String.format("%s.%s", d.getPackageFQN(), factoryOrFactoryCategory));

		// ======================

		// ====================== getBaseUnit method
		methodName = "getBaseUnit";
		if (unit.getMethodsByName(methodName).isEmpty()) {
			returnExp = String.format("%s.%s", factoryOrFactoryCategory, d.getBaseUnitName().toUpperCase());
			MethodDeclaration baseUnitMethod = unit.addMethod(methodName, PUBLIC).setType(unitDimReturnType);
			ReturnStmt baseUnitMethodReturnStmt = new ReturnStmt(returnExp);
			baseUnitMethod.createBody().addStatement(baseUnitMethodReturnStmt);
			baseUnitMethod.addAnnotation(Override.class);
		}
		// ======================

		// ====================== unitAt method
		methodName = "unitAt";
		if (unit.getMethodsByName(methodName).isEmpty()) {
			SimpleName paramName = new SimpleName("i");
			Parameter param = new Parameter(PrimitiveType.intType(), paramName);
			MethodDeclaration unitAtMethod = unit.addMethod(methodName, PUBLIC).setType(unitDimReturnType);
			unitAtMethod.addParameter(param);
			returnExp = String.format("%s.%s[%s]", factoryOrFactoryCategory, d.getUnitsArrayFieldName(),
					paramName.asString());
			ReturnStmt unitAtReturnStmt = new ReturnStmt(returnExp);
			unitAtMethod.createBody().addStatement(unitAtReturnStmt);
			unitAtMethod.addAnnotation(Override.class);
		}
		// ======================

		// ====================== units method
		methodName = "units";
		if (unit.getMethodsByName(methodName).isEmpty()) {
			returnExp = String.format("Arrays.copyOf(%s.%s, %s.%s.length)", factoryOrFactoryCategory,
					d.getUnitsArrayFieldName(), factoryOrFactoryCategory, d.getUnitsArrayFieldName());
			MethodDeclaration unitsMethod = unit.addMethod(methodName, PUBLIC).setType(unitsReturnType);
			ReturnStmt unitsReturnStmt = new ReturnStmt(returnExp);
			unitsMethod.createBody().addStatement(unitsReturnStmt);
			unitsMethod.addAnnotation(Override.class);
		}
		// ======================

		// ====================== unitsCount method
		methodName = "unitsCount";
		if (unit.getMethodsByName(methodName).isEmpty()) {
			returnExp = String.format("%s.%s.length", factoryOrFactoryCategory, d.getUnitsArrayFieldName());
			MethodDeclaration unitsCountMethod = unit.addMethod(methodName, PUBLIC).setType(PrimitiveType.intType());
			ReturnStmt unitsCountReturnStmt = new ReturnStmt(returnExp);
			unitsCountMethod.createBody().addStatement(unitsCountReturnStmt);
			unitsCountMethod.addAnnotation(Override.class);
		}
		// ======================

		// ====================== to** methods
		for (int i = 0; i < d.getUnitsCount(); i++) {
			returnExp = String.format("to(n, %s.%s)", factoryOrFactoryCategory, d.getUnitNameAt(i).toUpperCase());
			methodName = String.format("to%s", cap(plural(d.getUnitNameAt(i))));
			if (unit.getMethodsByName(methodName).isEmpty()) {
				MethodDeclaration method = unit.addMethod(methodName, PUBLIC).setType(PrimitiveType.doubleType())
						.addParameter(double.class, "n");
				ReturnStmt returnStmt = new ReturnStmt(returnExp);
				method.createBody().addStatement(returnStmt);
			}
		}
		// ======================

		// ======================
		overwrite(d.getUnitSourcePath(), cu.toString());
//		System.out.println(cu);
	}

	private static void generateDimensionConverters() throws Exception {
		CompilationUnit cu = new CompilationUnit();
		File file = new File(main.getDimensionConverterFactorySourcePath());
		ClassOrInterfaceDeclaration cd;
		if (!file.exists()) {
			throw new IllegalStateException(file.toString() + " should be exists");
		} else {
			cu = parse(file);
			cd = cu.getClassByName(main.getDimensionConverterFactoryName()).get();
		}

		List<MeasurementSystem> lm = new ArrayList<MeasurementSystem>(MeasurementSystems.getInstalledSystems());
		List<Dimension> ld = MeasurementSystems.getInstalledDimensions();
		lm.sort((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));

		for (Dimension dimension : ld) {
			for (int i = 0; i < lm.size(); i++) {
				MeasurementSystem s1 = lm.get(i);
				for (int j = i + 1; j < lm.size(); j++) {
					MeasurementSystem s2 = lm.get(j);
					DataV3 d1, d2;
					try {
						d1 = new DataV3(s1, dimension);
						d2 = new DataV3(s2, dimension);
					} catch (FileNotFoundException e) {
						// e.g: MetricArea defined but no JapanArea found, skip
						continue;
					}
					cu.addImport(
							"static " + Src.main.getDimensionFactoryFQN() + "." + d1.getDimensionName().toUpperCase());
					cu.addImport(
							"static " + Src.main.getDimensionFactoryFQN() + "." + d2.getDimensionName().toUpperCase());
					cu.addImport("static " + Src.main.getMeasurementSystemFactoryFQN() + "."
							+ d1.getSystemFieldName().toUpperCase());
					cu.addImport("static " + Src.main.getMeasurementSystemFactoryFQN() + "."
							+ d2.getSystemFieldName().toUpperCase());
					cu.addImport(d1.getDimensionFQN());
					cu.addImport(d2.getDimensionFQN());

//					System.out.printf("%s vs %s @ %s\n", s1, s2, dimension);
					// ================
					// e.g: METRIC_METER_PER_IMPERIAL_FOOT
					String factorVar = String.format("%s_%s_PER_%s_%s", d1.getInterfaceName(), d1.getBaseUnitName(),
							d2.getInterfaceName(), d2.getBaseUnitName()).toUpperCase();
//					System.out.println("\t\t"+factorVar);
					// e.g: METRIC_TO_IMPERIAL_LENGTH
					String staticName = String
							.format("%s_TO_%s_%s", d1.getInterfaceName(), d2.getInterfaceName(), d1.getDimensionName())
							.toUpperCase();

					// ================
					if (!cd.getFieldByName(factorVar).isPresent()) {
						Expression factorInitializer = new DoubleLiteralExpr(0);
						FieldDeclaration fd = cd.addFieldWithInitializer(double.class, factorVar, factorInitializer,
								STATIC, FINAL);
					}
					if (!cd.getFieldByName(staticName).isPresent()) {
						NodeList<Expression> args = new NodeList<Expression>();
						args.add(new NameExpr(new SimpleName(factorVar)));
						args.add(new NameExpr(new SimpleName(dimension.toString().toUpperCase())));
						args.add(new NameExpr(new SimpleName(d1.getSystemFieldName())));
						args.add(new NameExpr(new SimpleName(d2.getSystemFieldName())));

						ClassOrInterfaceType declareType = new ClassOrInterfaceType(null,
								String.format("%s<%s>", DimensionConverter.class.getSimpleName(), dimension));
						ClassOrInterfaceType initializerType = new ClassOrInterfaceType(null,
								String.format("%s<%s>", BasicDimensionConverter.class.getSimpleName(), dimension));

						Expression factorInitializer = new ObjectCreationExpr(null, initializerType, args);
						cd.addFieldWithInitializer(declareType, staticName, factorInitializer, STATIC, FINAL);

					}

					// ================
					// ================
					// ================
					// ================
					// ================
					// ================
					// ================
				}
//				System.out.println();
			}

		}
//		System.out.println(cu);
		overwrite(main.getDimensionConverterFactorySourcePath(), cu.toString());
	}

	private void generateTestFixedFiles() throws ClassNotFoundException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, IOException {

		CompilationUnit cu = new CompilationUnit();
		File file = new File(d.getTestFixedSourcePath());
		ClassOrInterfaceDeclaration fixed = cu.addClass(d.getTestFixedName());
		cu.setPackageDeclaration(d.getPackageFQN());

		List<MeasurementSystem> lm = new ArrayList<MeasurementSystem>(MeasurementSystems.getInstalledSystems());
		List<Dimension> ld = MeasurementSystems.getInstalledDimensions();
		lm.sort((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));

		cu.addImport("org.junit.Test");
		cu.addImport("static codes.abdullah.measurement.utils.TestUtils.delta");
		cu.addImport("static org.junit.Assert.assertEquals");

		for (int i = 0; i < d.getUnitsCount(); i++) {
			cu.addImport("static " + d.getFactoryFieldFQNAt(i));
			Unit<?> fromUnit = d.loadUnitAt(i);
			String fromUnitName = d.getUnitNameAt(i);

			String methodName = String.format("test%s", cap(fromUnitName));
			NodeList<Modifier> modifiers = NodeList.nodeList(Modifier.publicModifier());

			MethodDeclaration fromMethod = fixed.addMethod(methodName, PUBLIC).setType(new VoidType());
			BlockStmt fromMethodBlock = fromMethod.createBody();
			fromMethod.addAnnotation("Test");

			String from_factor_varname = "from_factor";
			String to_factor_varname = "to_factor";
			// =========
			// from_factor = 1.0
			// final double from_factor = MILLIMETER.getFactor();
			// double to_factor = 0;
			// String msg;
			// =========

			VariableDeclarationExpr to_factor_vde = new VariableDeclarationExpr(new PrimitiveType(Primitive.DOUBLE),
					to_factor_varname);
			fromMethodBlock.addOrphanComment(
					new LineComment(String.format("%s = %s", from_factor_varname, fromUnit.getFactor())));
			fromMethodBlock.addStatement(new VariableDeclarationExpr(new VariableDeclarator(
					new PrimitiveType(Primitive.DOUBLE), from_factor_varname,
					new MethodCallExpr(new NameExpr(d.getFactoryFieldNameAt(i)), new SimpleName("getFactor")))));
			fromMethodBlock
					.addStatement(new VariableDeclarationExpr(new PrimitiveType(Primitive.DOUBLE), to_factor_varname));
			fromMethodBlock.addStatement(new VariableDeclarationExpr(new ClassOrInterfaceType(null, "String"),
					new SimpleName("msg").asString()));

			for (int j = 0; j < d.getUnitsCount(); j++) {
				final String toMethodName = String.format("to%s", cap(plural(d.getUnitNameAt(j))));
				Unit<?> toUnit = d.loadUnitAt(j);
				fromMethodBlock.addOrphanComment(new LineComment("===================="));
				fromMethodBlock.addOrphanComment(new LineComment("====================" + d.getFactoryFieldNameAt(j)));
				fromMethodBlock.addOrphanComment(new LineComment("===================="));

				// // to_factor = 1.0
				// to_factor = MILLIMETER.getFactor();
				fromMethodBlock.addOrphanComment(
						new LineComment(String.format("%s = %s", to_factor_varname, toUnit.getFactor())));
				fromMethodBlock.addStatement(new AssignExpr(new NameExpr(to_factor_varname),
						new MethodCallExpr(new NameExpr(d.getFactoryFieldNameAt(j)), new SimpleName("getFactor")),
						ASSIGN));
				for (int k = 0; k < MeasurementUtils.fixed_decimals_for_testing.length; k++) {
					double test = MeasurementUtils.fixed_decimals_for_testing[k];

					String msg, expected;
					if (i < j) {
						// message = "-1 / (10 / 1)";
						msg = String.format("%s / (%s / %s)", Format.NO_EXPONENT.format(test),
								Format.NO_EXPONENT.format(toUnit.getFactor()),
								Format.NO_EXPONENT.format(fromUnit.getFactor()));
						expected = String.format("%s / (to_factor / from_factor)", test);
					} else {
						// message = "-1 * (10 / 1)";
						msg = String.format("%s * (%s / %s)", Format.NO_EXPONENT.format(test),
								Format.NO_EXPONENT.format(fromUnit.getFactor()),
								Format.NO_EXPONENT.format(toUnit.getFactor()));
						expected = String.format("%s * (from_factor / to_factor)", test);
					}

					//
					// assertEquals(message, -1.0 / (to_factor / from_factor),
					// MILLIMETER.toCentimeters(-1.0), delta);
					NodeList<Expression> args = new NodeList<>();
					args.add(new NameExpr(new SimpleName("msg")));
					args.add(parseExpression(expected));
					args.add(new MethodCallExpr(new NameExpr(d.getFactoryFieldNameAt(i)), toMethodName)
							.addArgument(new DoubleLiteralExpr(test)));
					args.add(new NameExpr(new SimpleName("delta")));

					MethodCallExpr assertCall = new MethodCallExpr(null, new NameExpr("assertEquals").getName(), args);
					fromMethodBlock.addStatement(
							new AssignExpr(new NameExpr(new SimpleName("msg")), new StringLiteralExpr(msg), ASSIGN));
					fromMethodBlock.addStatement(assertCall);
				}
			}
		}

//		System.out.println(cu);
		overwrite(d.getTestFixedSourcePath(), cu.toString());
	}

	private void generateTestRandomFiles() throws ClassNotFoundException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, IOException {

		CompilationUnit cu = new CompilationUnit();
		File file = new File(d.getTestRandomSourcePath());
		ClassOrInterfaceDeclaration random = cu.addClass(d.getTestRandomName());
		cu.setPackageDeclaration(d.getPackageFQN());

		List<MeasurementSystem> lm = new ArrayList<MeasurementSystem>(MeasurementSystems.getInstalledSystems());
		List<Dimension> ld = MeasurementSystems.getInstalledDimensions();
		lm.sort((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));

		cu.addImport("org.junit.Test");
		cu.addImport("static org.junit.Assert.assertEquals");
		cu.addImport("static codes.abdullah.measurement.utils.TestUtils.delta");
		cu.addImport("static codes.abdullah.measurement.utils.TestUtils.nextDouble");
		cu.addImport("static codes.abdullah.measurement.utils.TestUtils.loops");
		cu.addImport("static codes.abdullah.measurement.utils.TestUtils.noE");
		for (int i = 0; i < d.getUnitsCount(); i++) {
			cu.addImport("static " + d.getFactoryFieldFQNAt(i));
			Unit<?> fromUnit = d.loadUnitAt(i);
			String fromUnitName = d.getUnitNameAt(i);

			String methodName = String.format("test%s", cap(fromUnitName));
			NodeList<Modifier> modifiers = NodeList.nodeList(Modifier.publicModifier());

			MethodDeclaration fromMethod = random.addMethod(methodName, PUBLIC).setType(new VoidType());
			BlockStmt fromMethodBlock = fromMethod.createBody();
			fromMethod.addAnnotation("Test");

			String from_factor_varname = "from_factor";
			String to_factor_varname = "to_factor";
			// =========
			// from_factor = 1.0
			// final double from_factor = MILLIMETER.getFactor();
			// double to_factor = 0;
			// String msg;
			// =========

			VariableDeclarationExpr to_factor_vde = new VariableDeclarationExpr(new PrimitiveType(Primitive.DOUBLE),
					to_factor_varname);
			fromMethodBlock.addOrphanComment(
					new LineComment(String.format("%s = %s", from_factor_varname, fromUnit.getFactor())));
			fromMethodBlock.addStatement(new VariableDeclarationExpr(new VariableDeclarator(
					new PrimitiveType(Primitive.DOUBLE), from_factor_varname,
					new MethodCallExpr(new NameExpr(d.getFactoryFieldNameAt(i)), new SimpleName("getFactor")))));
			fromMethodBlock
					.addStatement(new VariableDeclarationExpr(new PrimitiveType(Primitive.DOUBLE), to_factor_varname));
			fromMethodBlock.addStatement(new VariableDeclarationExpr(new ClassOrInterfaceType(null, "String"),
					new SimpleName("msg").asString()));

			// ================ for(int i = 0; i < loops; i++){}
			NodeList<Expression> forloopInitialization = new NodeList<>();
			forloopInitialization.add(
					new AssignExpr(new VariableDeclarationExpr(new VariableDeclarator(PrimitiveType.intType(), "i")),
							new IntegerLiteralExpr("0"), ASSIGN));
			NodeList<Expression> forloopUpdate = new NodeList<>();
			forloopUpdate.add(new UnaryExpr(new NameExpr("i"),
					com.github.javaparser.ast.expr.UnaryExpr.Operator.POSTFIX_INCREMENT));
			BinaryExpr forloopComperation = new BinaryExpr(new NameExpr("i"), new NameExpr("loops"), Operator.LESS);
			BlockStmt forloopBody = new BlockStmt();

			ForStmt forStmt = new ForStmt(forloopInitialization, forloopComperation, forloopUpdate, forloopBody);
			fromMethodBlock.addStatement(forStmt);
			// ================

			// double test = nextDouble();
			VariableDeclarationExpr test = new VariableDeclarationExpr(
					new VariableDeclarator(PrimitiveType.doubleType(), "test"));
			forloopBody.addStatement(new AssignExpr(test, new MethodCallExpr(null, "nextDouble"), ASSIGN));

			for (int j = 0; j < d.getUnitsCount(); j++) {
				final String toMethodName = String.format("to%s", cap(plural(d.getUnitNameAt(j))));
				Unit<?> toUnit = d.loadUnitAt(j);
				forloopBody.addOrphanComment(new LineComment("===================="));
				forloopBody.addOrphanComment(new LineComment("====================" + d.getFactoryFieldNameAt(j)));
				forloopBody.addOrphanComment(new LineComment("===================="));

				// // to_factor = 1.0
				// to_factor = MILLIMETER.getFactor();
				forloopBody.addOrphanComment(
						new LineComment(String.format("%s = %s", to_factor_varname, toUnit.getFactor())));
				forloopBody.addStatement(new AssignExpr(new NameExpr(to_factor_varname),
						new MethodCallExpr(new NameExpr(d.getFactoryFieldNameAt(j)), new SimpleName("getFactor")),
						ASSIGN));

				String msg, expected;
				if (i < j) {
					// message = "-1 / (10 / 1)";
					msg = String.format("%%s / (%s / %s)", Format.NO_EXPONENT.format(toUnit.getFactor()),
							Format.NO_EXPONENT.format(fromUnit.getFactor()));
					expected = String.format("test / (to_factor / from_factor)");
				} else {
					// message = "-1 * (10 / 1)";
					msg = String.format("%%s * (%s / %s)", Format.NO_EXPONENT.format(fromUnit.getFactor()),
							Format.NO_EXPONENT.format(toUnit.getFactor()));
					expected = String.format("test * (from_factor / to_factor)");
				}

				// msg = String.format("%s * (1000000 / 10)", test);
				NodeList<Expression> args = NodeList.nodeList(new StringLiteralExpr(msg),
						new MethodCallExpr("noE", new NameExpr("test")));
				MethodCallExpr formatMsg = new MethodCallExpr(new NameExpr("String"), "format", args);//
				forloopBody.addStatement(new AssignExpr(new NameExpr("msg"), formatMsg, ASSIGN));

				// assertEquals(message, -1.0 / (to_factor / from_factor),
				// MILLIMETER.toCentimeters(-1.0), delta);
				NodeList<Expression> assertArgs = new NodeList<>();
				assertArgs.add(new NameExpr(new SimpleName("msg")));
				assertArgs.add(parseExpression(expected));
				assertArgs.add(new MethodCallExpr(new NameExpr(d.getFactoryFieldNameAt(i)), toMethodName)
						.addArgument(new NameExpr("test")));
				assertArgs.add(new NameExpr(new SimpleName("delta")));

				MethodCallExpr assertCall = new MethodCallExpr(null, new NameExpr("assertEquals").getName(),
						assertArgs);

				forloopBody.addStatement(assertCall);
			}
		}

//		System.out.println(cu);
		overwrite(d.getTestRandomSourcePath(), cu.toString());
	}

	private void generateTestAllSuite() throws IOException {
		List<DataV3> data = DataV3.getAllBySystem(d.getSystemName());

		CompilationUnit cu = new CompilationUnit();
		File file = new File(d.getTestAllSuiteSourcePath());
		ClassOrInterfaceDeclaration all = cu.addClass(d.getTestAllSuiteName());
		cu.setPackageDeclaration(d.getPackageFQN());

		List<MeasurementSystem> lm = new ArrayList<MeasurementSystem>(MeasurementSystems.getInstalledSystems());
		List<Dimension> ld = MeasurementSystems.getInstalledDimensions();
		lm.sort((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));

		cu.addImport("org.junit.runner.RunWith");
		cu.addImport("org.junit.runners.Suite");
		cu.addImport("org.junit.runners.Suite.SuiteClasses");

		File testDir = new File(d.getTestAllSuiteSourcePath()).getParentFile();
		List<String> testSourceNames = Arrays
				.stream(testDir.listFiles(f -> !f.getName().startsWith(d.getTestAllSuiteName()))).map(f -> f.getName())
				.collect(Collectors.toList()).stream().map(n -> n.substring(0, n.lastIndexOf('.')))
				.collect(Collectors.toList());

		// @RunWith(Suite.class)
		SingleMemberAnnotationExpr ae = new SingleMemberAnnotationExpr(new Name("RunWith"),
				new ClassExpr(new ClassOrInterfaceType(null, "Suite")));
		all.addAnnotation(ae);

		// e.g: @SuiteClasses({ TestRandomMetricMass.class,TestFixedMetricMass.class })
		NodeList<Expression> suiteClassesArrayArgs = new NodeList<>();
		testSourceNames.forEach(c -> suiteClassesArrayArgs.add(new ClassExpr(new ClassOrInterfaceType(null, c))));
		ArrayInitializerExpr suiteClassesArrayInitExpr = new ArrayInitializerExpr(suiteClassesArrayArgs);
		SingleMemberAnnotationExpr suiteClassesAnno = new SingleMemberAnnotationExpr(new Name("SuiteClasses"),
				suiteClassesArrayInitExpr);
		all.addAnnotation(suiteClassesAnno);

//		System.out.println(cu);
		overwrite(d.getTestAllSuiteSourcePath(), cu.toString());
	}

	private void generateTestDimensionConvertersFiles(boolean fixed) throws ClassNotFoundException,
			NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException {

		final Map<String, Double> dimensionConvertersFactors = getDimesionConvertersFactors();

		// Test[Fixed|Random]MetricToImperialLength
		List<DataV3> dataList = DataV3.getAllByDimension(d.getDimensionName());
		List<MeasurementSystem> lm = new ArrayList<MeasurementSystem>(MeasurementSystems.getInstalledSystems());
		List<Dimension> ld = MeasurementSystems.getInstalledDimensions();
		lm.sort((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));

		for (DataV3 d2 : dataList) {

			if (d2.getSystemName().equalsIgnoreCase(d.getSystemName())) {
				continue;
			}
//			System.out.println(d.getSystemFieldName() + " vs " + d2.getSystemFieldName());

			CompilationUnit cu = new CompilationUnit();
			File file = new File(d.getTestDimensionConverterSourcePath(fixed, d2));
			ClassOrInterfaceDeclaration cls = cu.addClass(d.getTestDimensionConverterName(fixed, d2));
			cu.setPackageDeclaration(test.getDimensionConverterPackageFQN());

			if (!fixed) {
				cu.addImport("static codes.abdullah.measurement.utils.TestUtils.loops");
				cu.addImport("static codes.abdullah.measurement.utils.TestUtils.nextDouble");
			} else {
				cu.addImport("static codes.abdullah.measurement.utils.TestUtils.fixed_decimals_for_testing");
			}
			cu.addImport("static codes.abdullah.measurement.utils.TestUtils.delta");
			cu.addImport("static codes.abdullah.measurement.utils.TestUtils.noE");
			cu.addImport("static org.junit.Assert.assertEquals");
			cu.addImport("org.junit.Test");
			cu.addImport(d.getDimensionFQN());
			cu.addImport(main.getDimensionConverterInterfaceFQN());
			cu.addImport(main.getMeasurementSystemInterfaceFQN());
			cu.addImport(main.getMeasurementSystemFactoryFQN());
			cu.addImport(main.getUnitInterfaceFQN());

			// ==========================

			for (int i = 0; i < d.getUnitsCount(); i++) {
				for (int j = 0; j < d2.getUnitsCount(); j++) {
//					System.out.println(d.getUnitNameAt(i)+" vs "+d2.getUnitNameAt(j));
					cu.addImport("static " + d.getFactoryFieldFQNAt(i));
					cu.addImport("static " + d2.getFactoryFieldFQNAt(j));

					Unit<?> fromUnit = d.loadUnitAt(i);
					String fromUnitName = d.getUnitNameAt(i);
					Unit<?> toUnit = d2.loadUnitAt(j);
					String toUnitName = d2.getUnitNameAt(j);

					/*
					 * @Test() public void testMillimeterToThou() { }
					 */
					String methodName = String.format("test%sTo%s", cap(fromUnitName), cap(toUnitName));
					MethodDeclaration fromMethod = cls.addMethod(methodName, PUBLIC).setType(new VoidType());
					BlockStmt fromMethodBlock = fromMethod.createBody();
					fromMethod.addAnnotation("Test");

					// Unit<Length> from = MILLIMETER;
					fromMethodBlock
							.addStatement(new AssignExpr(
									new VariableDeclarationExpr(new ClassOrInterfaceType(null,
											String.format("Unit<%s>", d.getDimensionName())), "from"),
									new NameExpr(d.loadFactoryFieldAt(i).getName()), ASSIGN));

					// Unit<Length> fromBase = MILLIMETER.getBaseUnit();
					fromMethodBlock
							.addStatement(new AssignExpr(
									new VariableDeclarationExpr(new ClassOrInterfaceType(null,
											String.format("Unit<%s>", d.getDimensionName())), "fromBase"),
									new NameExpr(d.loadFactoryFieldAt(i).getName() + ".getBaseUnit()"), ASSIGN));

					// Unit<Length> to = THOU;
					fromMethodBlock
							.addStatement(new AssignExpr(
									new VariableDeclarationExpr(new ClassOrInterfaceType(null,
											String.format("Unit<%s>", d.getDimensionName())), "to"),
									new NameExpr(d2.loadFactoryFieldAt(j).getName()), ASSIGN));

					// Unit<Length> toBase = THOU.getBaseUnit();
					fromMethodBlock
							.addStatement(new AssignExpr(
									new VariableDeclarationExpr(new ClassOrInterfaceType(null,
											String.format("Unit<%s>", d.getDimensionName())), "toBase"),
									new NameExpr(d2.loadFactoryFieldAt(j).getName() + ".getBaseUnit()"), ASSIGN));

					// double fromFactor = from.getFactor();
					fromMethodBlock.addStatement(new VariableDeclarationExpr(
							new VariableDeclarator(new PrimitiveType(Primitive.DOUBLE), "fromFactor",
									new MethodCallExpr(new NameExpr("from"), new SimpleName("getFactor")))));

					// double fromBaseFactor = fromBase.getFactor();
					fromMethodBlock.addStatement(new VariableDeclarationExpr(
							new VariableDeclarator(new PrimitiveType(Primitive.DOUBLE), "fromBaseFactor",
									new MethodCallExpr(new NameExpr("fromBase"), new SimpleName("getFactor")))));

					// double toFactor = to.getFactor();
					fromMethodBlock.addStatement(
							new VariableDeclarationExpr(new VariableDeclarator(new PrimitiveType(Primitive.DOUBLE),
									"toFactor", new MethodCallExpr(new NameExpr("to"), new SimpleName("getFactor")))));

					// double toBaseFactor = toBase.getFactor();
					fromMethodBlock.addStatement(new VariableDeclarationExpr(
							new VariableDeclarator(new PrimitiveType(Primitive.DOUBLE), "toBaseFactor",
									new MethodCallExpr(new NameExpr("toBase"), new SimpleName("getFactor")))));

					// MeasurementSystem fromSystem = from.getSystem();
					fromMethodBlock
							.addStatement(
									new AssignExpr(
											new VariableDeclarationExpr(
													new ClassOrInterfaceType(null, "MeasurementSystem"), "fromSystem"),
											new NameExpr("from.getSystem()"), ASSIGN));

					// DimensionConverter<Length> dc = MeasurementSystems.findConverter(from, to);
					fromMethodBlock.addStatement(new AssignExpr(
							new VariableDeclarationExpr(new ClassOrInterfaceType(null,
									String.format("DimensionConverter<%s>", d.getDimensionName())), "dc"),
							new NameExpr("MeasurementSystems.findConverter(from, to)"), ASSIGN));

					// double superiorPerInferiorFactor = MeasurementSystems.findConverter(from,
					// to).getFactor();
					fromMethodBlock.addStatement(new AssignExpr(
							new VariableDeclarationExpr(PrimitiveType.doubleType(), "superiorPerInferiorFactor"),
							new NameExpr("dc.getFactor()"), ASSIGN));

					// for(int i = 0; i < loops|fixed_decimals_for_testing.length; i++){}
					NodeList<Expression> forloopInitialization = new NodeList<>();
					forloopInitialization.add(new AssignExpr(
							new VariableDeclarationExpr(new VariableDeclarator(PrimitiveType.intType(), "i")),
							new IntegerLiteralExpr("0"), ASSIGN));
					NodeList<Expression> forloopUpdate = new NodeList<>();
					forloopUpdate.add(new UnaryExpr(new NameExpr("i"),
							com.github.javaparser.ast.expr.UnaryExpr.Operator.POSTFIX_INCREMENT));
					BinaryExpr forloopComperation = new BinaryExpr(new NameExpr("i"),
							new NameExpr(fixed ? "fixed_decimals_for_testing.length" : "loops"), Operator.LESS);
					BlockStmt forloopBody = new BlockStmt();

					ForStmt forStmt = new ForStmt(forloopInitialization, forloopComperation, forloopUpdate,
							forloopBody);
					fromMethodBlock.addStatement(forStmt);

					if (fixed) {
						// final double src = fixed_decimals_for_testing[i];
						forloopBody.addStatement(new VariableDeclarationExpr(new VariableDeclarator(
								PrimitiveType.doubleType(), "src",
								new ArrayAccessExpr(new NameExpr("fixed_decimals_for_testing"), new NameExpr("i"))))
										.addModifier(FINAL));
					} else {
						// final double src = nextRandom();
						VariableDeclarationExpr src = new VariableDeclarationExpr(
								new VariableDeclarator(PrimitiveType.doubleType(), "src")).addModifier(FINAL);
						forloopBody.addStatement(new AssignExpr(src, new MethodCallExpr(null, "nextDouble"), ASSIGN));
					}

					// double n = src;
					forloopBody.addStatement(new AssignExpr(
							new VariableDeclarationExpr(PrimitiveType.doubleType(), "n"), new NameExpr("src"), ASSIGN));

					forloopBody.addOrphanComment(new LineComment("========================"));
					forloopBody.addOrphanComment(new LineComment("TEST CONVERT TO SUPERIOR BASE"));
					forloopBody.addOrphanComment(new LineComment("========================"));

					// double nFromBase = n * (fromFactor / fromBaseFactor);
					String str = "n * (fromFactor / fromBaseFactor)";
					forloopBody.addStatement(
							new AssignExpr(new VariableDeclarationExpr(PrimitiveType.doubleType(), "nFromBase"),
									parseExpression(str), ASSIGN));

					// String message1 = String.format("n(%s) * (fromFactor(%s) /
					// fromBaseFactor(%s)) = nFromBase(%s)", noE(n),
					// noE(fromFactor), noE(fromBaseFactor), noE(nFromBase));
					str = "String.format(\"n(%s) * (fromFactor(%s) / fromBaseFactor(%s)) = nFromBase(%s)\", noE(n), noE(fromFactor), noE(fromBaseFactor), noE(nFromBase))";
					forloopBody.addStatement(new AssignExpr(
							new VariableDeclarationExpr(new ClassOrInterfaceType(null, "String"), "message1"),
							parseExpression(str), ASSIGN));

					// assertEquals(message1, from.toBase(n), nFromBase, delta);
					str = "assertEquals(message1, from.toBase(n), nFromBase, delta)";
					forloopBody.addStatement(parseExpression(str));

					forloopBody.addOrphanComment(new LineComment("========================"));
					str = "fromSystem == dc.getSuperior() ? (nFromBase / superiorPerInferiorFactor) : (nFromBase * superiorPerInferiorFactor)";
					forloopBody.addStatement(
							new AssignExpr(new VariableDeclarationExpr(PrimitiveType.doubleType(), "nFromBaseAsToBase"),
									parseExpression(str), ASSIGN));

					str = "fromSystem == dc.getSuperior() ? String.format(\"nFromBase(%s) / superiorPerInferiorFactor(%s) = nFromBaseAsToBase(%s)\", noE(nFromBase), noE(superiorPerInferiorFactor), noE(nFromBaseAsToBase)): String.format(\"nFromBase(%s) * superiorPerInferiorFactor(%s) = nFromBaseAsToBase(%s)\", noE(nFromBase), noE(superiorPerInferiorFactor), noE(nFromBaseAsToBase))";
					forloopBody.addStatement(new AssignExpr(
							new VariableDeclarationExpr(new ClassOrInterfaceType(null, "String"), "message2"),
							parseExpression(str), ASSIGN));

					forloopBody.addOrphanComment(new LineComment("========================"));
					forloopBody.addOrphanComment(new LineComment("TEST CONVERT TO INFERIOR BASE"));
					forloopBody.addOrphanComment(new LineComment("========================"));

					// double nToBase = n * (toFactor / toBaseFactor);
					str = "n * (toFactor / toBaseFactor)";
					forloopBody.addStatement(
							new AssignExpr(new VariableDeclarationExpr(PrimitiveType.doubleType(), "nToBase"),
									parseExpression(str), ASSIGN));

					// String message2 = String.format("n(%s) * (toFactor(%s) /
					// toBaseFactor(%s)) = nToBase(%s)", noE(n),
					// noE(toFactor), noE(toBaseFactor), noE(nToBase));
					str = "String.format(\"n(%s) * (toFactor(%s) / toBaseFactor(%s)) = nToBase(%s)\", noE(n), noE(toFactor), noE(toBaseFactor), noE(nToBase))";
					forloopBody.addStatement(new AssignExpr(
							new VariableDeclarationExpr(new ClassOrInterfaceType(null, "String"), "message3"),
							parseExpression(str), ASSIGN));

					// assertEquals(message3, to.toBase(n), nToBase, delta);
					str = "assertEquals(message3, to.toBase(n), nToBase, delta)";
					forloopBody.addStatement(parseExpression(str));

					forloopBody.addOrphanComment(new LineComment("========================"));
					forloopBody.addOrphanComment(new LineComment("note the order is changed"));
					// n = nFromBaseAsToBase * (toBaseFactor / toFactor);
					str = "nFromBaseAsToBase * (toBaseFactor / toFactor)";
					forloopBody.addStatement(new AssignExpr(new NameExpr("n"), parseExpression(str), ASSIGN));

					// String message4 = String.format("nFromBaseAsToBase(%s) * (toBaseFactor(%s) /
					// toFactor(%s)) = n(%s)", noE(nFromBaseAsToBase), noE(toBaseFactor),
					// noE(toFactor), noE(n));
					str = "String.format(\"nFromBaseAsToBase(%s) * (toBaseFactor(%s) / toFactor(%s)) = n(%s)\", noE(nFromBaseAsToBase), noE(toBaseFactor), noE(toFactor), noE(n))";
					forloopBody.addStatement(new AssignExpr(
							new VariableDeclarationExpr(new ClassOrInterfaceType(null, "String"), "message4"),
							parseExpression(str), ASSIGN));

					forloopBody.addOrphanComment(new LineComment("========================"));
					forloopBody.addOrphanComment(new LineComment("COMPARE n to CONVERTER RESULTS"));
					forloopBody.addOrphanComment(new LineComment("========================"));

					// String message5 = message1 + "\n" + message2 + "\n" + message3 + "\n" +
					// message4;
					str = "message1 + \"\\n\" + message2 + \"\\n\" + message3 + \"\\n\" + message4";
					forloopBody.addStatement(new AssignExpr(
							new VariableDeclarationExpr(new ClassOrInterfaceType(null, "String"), "message5"),
							parseExpression(str), ASSIGN));
					forloopBody.addStatement(parseExpression("assertEquals(message5, n, from.to(src, to), delta)"));
				}
			}
			overwrite(d.getTestDimensionConverterSourcePath(fixed, d2), cu.toString());

//			System.out.println(cu);
		}

	}

	private void generateTestAllSuiteDimensionConvert() throws IOException {
		List<DataV3> data = DataV3.getAllBySystem(d.getSystemName());

		CompilationUnit cu = new CompilationUnit();
		File file = new File(d.getTestAllDimensionConvertersSuiteSourcePath());
		ClassOrInterfaceDeclaration all = cu.addClass(d.getTestAllDimensionConvertersSuiteName());
		cu.setPackageDeclaration(main.getDimensionConverterPackageFQN());

		List<MeasurementSystem> lm = new ArrayList<MeasurementSystem>(MeasurementSystems.getInstalledSystems());
		List<Dimension> ld = MeasurementSystems.getInstalledDimensions();
		lm.sort((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));

		cu.addImport("org.junit.runner.RunWith");
		cu.addImport("org.junit.runners.Suite");
		cu.addImport("org.junit.runners.Suite.SuiteClasses");
		// e.g: Test*MetricTo*
		String findClasses = cap(d.getSystemName()) + "To";
		File testDir = new File(d.getTestAllDimensionConvertersSuiteSourcePath()).getParentFile();
		List<String> testSourceNames = Arrays
				.stream(testDir.listFiles(f -> !f.getName().equals(d.getTestAllDimensionConvertersSuiteName())))
				.map(f -> f.getName()).collect(Collectors.toList()).stream()
				.map(n -> n.substring(0, n.lastIndexOf('.'))).filter(s -> s.contains(findClasses))
				.collect(Collectors.toList());

		// @RunWith(Suite.class)
		SingleMemberAnnotationExpr ae = new SingleMemberAnnotationExpr(new Name("RunWith"),
				new ClassExpr(new ClassOrInterfaceType(null, "Suite")));
		all.addAnnotation(ae);

		// e.g: @SuiteClasses({ TestRandomMetricMass.class,TestFixedMetricMass.class })
		NodeList<Expression> suiteClassesArrayArgs = new NodeList<>();
		testSourceNames.forEach(c -> suiteClassesArrayArgs.add(new ClassExpr(new ClassOrInterfaceType(null, c))));
		ArrayInitializerExpr suiteClassesArrayInitExpr = new ArrayInitializerExpr(suiteClassesArrayArgs);
		SingleMemberAnnotationExpr suiteClassesAnno = new SingleMemberAnnotationExpr(new Name("SuiteClasses"),
				suiteClassesArrayInitExpr);
		all.addAnnotation(suiteClassesAnno);

//		System.out.println(cu);
		overwrite(d.getTestAllDimensionConvertersSuiteSourcePath(), cu.toString());
	}

	private void assertEquals(String message3, double base, double nToBase, double delta2) {
	}

	public static String noE(double d) {
		return MeasurementUtils.noE(d);
	}

	static final double delta = 1;

	/**
	 * return map contains fields names and factors, e.g:
	 * key=IMPERIAL_FOOT_PER_JAPAN_SHAKU, value=0.994193
	 */
	private static Map<String, Double> getDimesionConvertersFactors() throws FileNotFoundException {
		File file = new File(main.getDimensionConverterFactorySourcePath());
		CompilationUnit cu = parse(file);
		ClassOrInterfaceDeclaration c = cu.getClassByName(DimensionConverters.class.getSimpleName()).get();
		List<FieldDeclaration> l = c.findAll(FieldDeclaration.class).stream()
				.filter(p -> (p.getVariable(0).getType() instanceof PrimitiveType)).collect(Collectors.toList());
		List<FieldDeclaration> l2 = l.stream()
				.filter(p -> ((PrimitiveType) p.getVariable(0).getType()).equals(PrimitiveType.doubleType()))
				.collect(Collectors.toList());
		Map<String, Double> map = new HashMap<>();
		l2.forEach(p -> {
			VariableDeclarator vd = (VariableDeclarator) p.getChildNodes().get(2);
			map.put(vd.getNameAsString(),
					vd.getInitializer().isPresent() ? Double.parseDouble(vd.getInitializer().get().toString()) : 0);
		});
//		map.forEach((k, v) -> System.out.println(k + ":" + v));
		return map;
	}

	// =================
	// =================
	// =================
	// =================
	// =================
	// =================
	// =================
	// =================
	// =================
	// =================
	// =================
	// =================
	// =================
	// =================

	private static void overwrite(String path, String content) throws IOException {
		Path outfile = Paths.get(path);
		if (Files.exists(outfile)) {
			Files.delete(outfile);
		}
		Files.createDirectories(outfile.getParent());
		Files.write(outfile, content.getBytes());
	}

	static String cap(String s) {
		s = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
		int index = s.indexOf('_');
		if (index >= 0) {
			s = new StringBuilder(s).deleteCharAt(index).deleteCharAt(index)
					.insert(index, Character.toUpperCase(s.charAt(index + 1))).toString();
		}
		return s;
	}

	static String[] toLowerCase(String[] arr) {
		String[] arr2 = Arrays.copyOf(arr, arr.length);
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = arr[i].toLowerCase();
		}
		return arr2;
	}

	static String plural(String s) {
		int index = s.indexOf("inch");
		if (index >= 0) {
			return s.replace("inch", "inches");
		}
		index = s.indexOf("foot");
		if (index >= 0) {
			return s.replace("foot", "feet");
		}

		if (s.equals("us")) {
			return s;
		}
		return s.toString() + "s";
	}

	private static double[] powIt(double[] maxes, double pow) {
		for (int i = 0; i < maxes.length; i++) {
			maxes[i] = Math.pow(maxes[i], pow);
		}
		return maxes;
	}

//	
	private static String[] prefixIt(String prefix, String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = prefix + arr[i];
		}
		return arr;
	}

	private static String[] suffixIt(String[] arr, String suffix) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] + suffix;
		}
		return arr;
	}

	/**
	 * e.g: _getMethod -> [_get, Method], or MethodName -> [Method, Name]
	 */
	protected static String[] extractCamelWords(String s) {

		int skip = 0;
		while (s.charAt(skip) == '_') {
			skip++;
		}

		// e.g: _JavaString, will skip 1 underscore and whatever follow it, so will
		// start looking from skip + 1
		int from = 0;
		int to = indexOfUpperCase(s, skip + 1);
		if (to < 0) {
			return new String[] { s };
		}

		List<String> l = new ArrayList<>();

		do {
			l.add(s.substring(from, to));
			from = to;
		} while ((to = indexOfUpperCase(s, to + 1)) >= 0);
		l.add(s.substring(from, s.length()));
		return l.toArray(new String[l.size()]);
	}

	private static int indexOfUpperCase(String s, int offset) {
		for (int i = offset; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i)))
				return i;
		}
		return -1;
	}

}
