package codes.abdullah.measurement.utils;

import java.util.Arrays;
import java.util.Objects;

public class BuilderV2 {
	public static void main(String[] args) {

	}

	private String[] resources;
	private String interfaceComments;
	private double[] maxes;
	private String[] names;
	private String[] symbols;
	private String system;
	private String dimension;
	private String suffix;
	private String baseUnit;
	private boolean categorizedByDimension;
	private String categories;
	private String extensionOf;

	public BuilderV2() {

	}

	public void build() throws Exception {
		if (names.length != maxes.length)
			throw new IllegalArgumentException();
		if (names.length != symbols.length)
			throw new IllegalArgumentException();
		if (!Arrays.stream(names).anyMatch(p -> p.equals(baseUnit)))
			throw new IllegalArgumentException("not found baseUnit in names");
		Objects.requireNonNull(system);
		Objects.requireNonNull(baseUnit);
		DataV3 d = new DataV3(resources, interfaceComments, system, dimension, maxes, symbols, names, baseUnit,
				categories, categorizedByDimension, suffix);
		new GenV3(d);
	}

	public BuilderV2 resources(String[] resources) {
		this.resources = resources;
		return this;
	}

	public BuilderV2(String interfaceComments) {
		this.interfaceComments = interfaceComments;
	}

	public BuilderV2 maxes(double[] maxes) {
		this.maxes = maxes;
		return this;
	}

	/**
	 * specify the names of units
	 */
	public BuilderV2 names(String[] names) {
		this.names = names;
		return this;
	}

	/**
	 * specify the symbols of units
	 */
	public BuilderV2 symbols(String[] symbols) {
		this.symbols = symbols;
		return this;
	}

	/**
	 * specify the system name
	 */
	public BuilderV2 system(String systemName) {
		this.system = systemName.toLowerCase();
		return this;
	}

	/**
	 * specify the dimension name
	 */
	public BuilderV2 dimension(String dimension) {
		this.dimension = dimension.toLowerCase();
		return this;
	}

	/**
	 * specify the base-unit name
	 */
	public BuilderV2 baseUnit(String baseUnitName) {
		this.baseUnit = baseUnitName.toLowerCase();
		return this;
	}

	/**
	 * if true, will create inner-class by name of given dimension, e.g:
	 * Metrics.length.METER
	 */
	public BuilderV2 categorizedByDimension(boolean b) {
		this.categorizedByDimension = b;
		return this;
	}

	/**
	 * if true, will create chin of inner-classes, categories my be separated by .,
	 * e.g: us.foo.bar, which will result: Metrics.us.foo.bar.METER
	 */
	public BuilderV2 categories(String categories) {
		this.categories = categories;
		return this;
	}

	/**
	 * if no suffix provided, generated unit-class names will be suffixed with
	 * provided dimension, e.g: MetricLength, or MetricSuffix
	 */
	public BuilderV2 suffix(String suffix) {
		this.suffix = suffix;
		return this;
	}

	/**
	 * must be extension of existing implementation of the same dimension, e.g:
	 * MetricLength, and extension will be MetricNautical, so extensionOf must be 
	 */
	public BuilderV2 extensionOf(String extensionOf) {
		this.extensionOf = extensionOf;
		return this;
	}

}
