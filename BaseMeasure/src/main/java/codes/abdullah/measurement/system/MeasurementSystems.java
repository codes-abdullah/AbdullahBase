package codes.abdullah.measurement.system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import codes.abdullah.digits.Digits;
import codes.abdullah.measurement.dimension.AbstractDimension;
import codes.abdullah.measurement.dimension.Dimension;
import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.dimension.convert.BasicDimensionConverter;
import codes.abdullah.measurement.dimension.convert.DimensionConverter;
import codes.abdullah.measurement.unit.AbstractUnit;
import codes.abdullah.measurement.unit.Unit;
import codes.abdullah.measurement.utils.MeasurementId;
import codes.abdullah.measurement.utils.MeasurementUtils;

public class MeasurementSystems {

	private static final Object lock = new Object();

	private static final List<MeasurementSystem> INSTALLED_SYSTEMS = new ArrayList<>();

	private static final List<Dimension> INSTALLED_DIMENSIONS = new ArrayList<>();

	private static final List<Unit<?>> INSTALLED_UNITS = new ArrayList<>();

	private static final List<DimensionConverter<?>> INSTALLED_CONVERTERS = new ArrayList<>();

	// ==================== SYSTEMS
	public static final MeasurementSystem METRIC_SYSTEM = new BasicMeasurementSystem("Metric");

	public static final MeasurementSystem IMPERIAL_SYSTEM = new BasicMeasurementSystem("Imperial");

	public static final MeasurementSystem JAPAN_SYSTEM = new BasicMeasurementSystem("Japan");

	public static final MeasurementSystem DIGITAL_SYSTEM = new BasicMeasurementSystem("digital");

	public static final MeasurementSystem USC_SYSTEM = new BasicMeasurementSystem("usc");

	// ====================
	static {
		// ## ===== initialization phases ===== ##
		// - Units factory => MeasurementSystems => Dimensions => DimensionsConverter
		// - MeasurementSystems => nothing (safe)
		// - Dimensions => MeasurementSystems => Dimensions => DimensionsConverter
		// (safe)
		// - DimensionsConverter => MeasurementSystems => Dimensions =>
		// DimensionsConverter (safe)
		//
		Dimensions.init();
	}

	private static <T extends MeasurementId> int install0(List<T> installed, T t) {
		synchronized (lock) {
			return install0(installed, t, installed.size(), true);
		}
	}

	@SuppressWarnings("unused")
	private static <T extends MeasurementId> int install0(List<T> installed, T t, int insertAt) {
		return install0(installed, t, insertAt, true);
	}

	private static <T extends MeasurementId> int install0(List<T> installed, T t, boolean bitId) {
		synchronized (lock) {
			return install0(installed, t, installed.size(), bitId);
		}
	}

	/**
	 * insert <code>T</code> at <code>insertAt</code>, replace if null exists at
	 * given index, and return installation id for given <code>T</code> <br>
	 * The installation mechanism:<br>
	 * id-index-based: if <code>assignBitAsId = false</code>, the returned id is
	 * same as the <code>insertAt</code><br>
	 * id-bit-based: if <code>assignBitAsId = false</code>, the returned id is
	 * <code>1 << installed.size</code><br>
	 * <br>
	 * 
	 * Futures and limitations:<br>
	 * id-index-based<br>
	 * futures:<br>
	 * 1- can install a lot<br>
	 * 2- index can be re-converted to original binary-combination if needed<br>
	 * 3- <br>
	 * limitations:<br>
	 * 1- invoker must maintain this index<br>
	 * <br>
	 * id-bit-based<br>
	 * futures:<br>
	 * 1- binary based, which can be used in further combinations<br>
	 * 2- invoker does not need to maintain this (auto-generated)<br>
	 * limitations:<br>
	 * 1- very limited to current implementation (int)<br>
	 * <br>
	 * 
	 */
	private static <T extends MeasurementId> int install0(List<T> installed, T t, int insertAt, boolean assignBitAsId) {
		synchronized (lock) {
			final int size = installed.size();
			if (assignBitAsId) {
				if (size > 30)
					throw new IllegalStateException("no more space for shift: " + size);
				int bitid = 1 << size;
				for (int i = 0; i < size; i++) {
					MeasurementId id = installed.get(i);
					if (id != null && id.getId() == bitid) {
						throw new InstallationException(
								"already installed: " + t.getClass() + "(" + t + ")\ninstalled: \n" + installed);
					}
				}
			} else {
				MeasurementId id = insertAt < installed.size() ? installed.get(insertAt) : null;
				if (id != null) {
					throw new InstallationException(
							"already installed: " + t.getClass() + "(" + t + ")\ninstalled: \n" + installed);
				}
			}

			// ===========
			// if not using bitId, then we need to fill the empty gaps by nulls
			// ===========
			if (!assignBitAsId) {
				int installed_size = installed.size();
				int diff = insertAt - installed_size;
				for (int i = installed_size; i < diff + installed_size; i++) {
					installed.add(i, null);
				}
			}
			// if something exists (may be null), replace it (don't shift the list)
			if (insertAt < installed.size())
				installed.set(insertAt, t);
			else
				installed.add(insertAt, t);
			int id = assignBitAsId ? 1 << size : insertAt;
			return id;
		}
//		synchronized (lock) {
//			final int size = installed.size();
//			for (int i = 0; i < size; i++) {
//				MeasurementId id = installed.get(i);
//				if (id != null && id.equals(t)) {
//					throw new InstallationException(
//							"already installed: " + t.getClass() + "(" + t + ")\ninstalled: \n" + installed);
//				}
//			}
//			if (bitId && size > 30)
//				throw new IllegalStateException("no more space for shift: " + size);
//
//			// ===========
//			// if not using bitId, then we need to fill the empty gaps by nulls
//			// ===========
//			if (!bitId) {
//				int installed_size = installed.size();
//				int diff = insertAt - installed_size;
//				for (int i = installed_size; i < diff + installed_size; i++) {
//					installed.add(i, null);
//				}
//			}
//			// if something exists (may be null), replace it (don't shift the list)
//			if (insertAt < installed.size())
//				installed.remove(insertAt);
//			installed.add(insertAt, t);
//			int id = bitId ? 1 << size : insertAt;
//			if (t instanceof DimensionConverter) {
////				 System.out.println("insalled id: "+id);
//			}
////			System.out.printf("%s, insertAt(%s), id(%s)\n", t, insertAt, id);
//
//			return id;
//		}
	}

	/**
	 * install given system into the framework<br>
	 * <b>You can't install new system without extending the
	 * {@link BasicMeasurementSystem}</b> <br>
	 * <b>If you extends it, you don't have to invoke this method manually</b>
	 *
	 * @return unique bit-mapping id
	 */
	public static int install(MeasurementSystem t) {
		if (!(t instanceof BasicMeasurementSystem)) {
			throw new InstallationException("not instance of " + BasicMeasurementSystem.class);
		}
		// measurement-systems must always use bitId future
		return install0(INSTALLED_SYSTEMS, t);
	}

	/**
	 * install given converter into the framework<br>
	 * <b>You can't install new converter without extending the
	 * {@link BasicDimensionConverter}</b> <br>
	 * <b>If you extends it, you don't have to invoke this method manually</b>
	 *
	 * @return unique index-mapping id
	 */
	public static int install(DimensionConverter<?> t) {
		synchronized (lock) {
			final long combination = ((long) t.getDimension().getId() << 32)
					| (t.getSuperior().getId() | t.getInferior().getId());
			final int insertAt = MeasurementUtils.findBitMappingIndex(combination, INSTALLED_SYSTEMS.size(),
					INSTALLED_DIMENSIONS.size());
			if (!(t instanceof BasicDimensionConverter)) {
				throw new InstallationException("not instance of " + BasicDimensionConverter.class);
			}
			final int id = install0(INSTALLED_CONVERTERS, t, insertAt, false);
			return id;
		}
	}

	public static void main(String[] args) {
		//draw(INSTALLED_DIMENSIONS, INSTALLED_SYSTEMS);
		explainAllInstallations();
	}
	
	

	@SuppressWarnings({ "rawtypes", "unused" })
	private static void draw(List high_list, List low_list) {	
		int index = 0;
		System.out.printf("index\tsuperiorBit\tsuperior\tinferiorBit\tinferior\thighBit\thigh\tcombination\n");
		for (int i = 0; i < low_list.size(); i++) {
			Object superior = low_list.get(i);
			int superiorBit = 1 << i;
			for (int j = i + 1; j < low_list.size(); j++) {
				Object inferior = low_list.get(j);
				int inferiorBit = 1 << j;
				for (int k = 0; k < high_list.size(); k++) {
					Object high = high_list.get(k);
					int highBit = 1 << k;
					System.out.printf("%d\t%d\t%s\t%d\t%s\t%d\t%s\t%s\n", index, superiorBit, superior, inferiorBit,
							inferior, highBit, high,
							Digits.ints.toBinary(highBit) + " " + Digits.ints.toBinary(superiorBit | inferiorBit));
					index++;
				}
				System.out.println();

			}
		}

		System.exit(0);
	}

	/**
	 * install given dimension into the framework<br>
	 * <b>You can't install new dimension without extending the
	 * {@link AbstractDimension}</b> <br>
	 * <b>If you extends it, you don't have to invoke this method manually</b>
	 *
	 * @return unique bit-mapping id
	 */
	public static int install(Dimension t) {
		if (!(t instanceof AbstractDimension)) {
			throw new InstallationException("not instance of " + AbstractDimension.class);
		}
		return install0(INSTALLED_DIMENSIONS, t);
	}

	/**
	 * install given unit into the framework<br>
	 * <b>You can't install new unit without extending the {@link AbstractUnit}</b>
	 * <br>
	 * <b>If you extends it, you don't have to invoke this method manually</b>
	 *
	 * @return unique index as id
	 */
	public static int install(Unit<?> t) {
		if (!(t instanceof AbstractUnit)) {
			throw new InstallationException("not instance of " + AbstractUnit.class);
		}
		return install0(INSTALLED_UNITS, t, false);
	}

	// ------------------------
	// ------------------------
	// ------------------------
	public static List<Unit<?>> getInstalledUnits() {
		synchronized (lock) {
			return Collections.unmodifiableList(INSTALLED_UNITS);
		}
	}

	public static List<MeasurementSystem> getInstalledSystems() {
		synchronized (lock) {
			return Collections.unmodifiableList(INSTALLED_SYSTEMS);
		}
	}

	public static List<Dimension> getInstalledDimensions() {
		synchronized (lock) {
			return Collections.unmodifiableList(INSTALLED_DIMENSIONS);
		}
	}

	/**
	 * the returned list may contains null holders which been inserted to hold
	 * positions for later installation
	 */
	public static List<DimensionConverter<?>> getInstalledConverters() {
		synchronized (lock) {
			return Collections.unmodifiableList(INSTALLED_CONVERTERS);
		}
	}

	/**
	 * @return true if
	 */
	public static boolean isExists(MeasurementSystem system) {
		List<MeasurementSystem> installed = getInstalledSystems();
		for (MeasurementSystem s : installed) {
			if (s.equals(system))
				return true;
		}
		return false;
	}

	public static boolean isExists(Dimension dimension) {
		List<Dimension> installed = getInstalledDimensions();
		for (Dimension s : installed) {
			if (s.equals(dimension))
				return true;
		}
		return false;
	}

	public static boolean isExists(DimensionConverter<?> dc) {
		List<DimensionConverter<?>> installed = getInstalledConverters();
		for (DimensionConverter<?> s : installed) {
			if (s != null && s.equals(dc))
				return true;
		}
		return false;
	}

	public static boolean isExists(Unit<?> dc) {
		List<Unit<?>> installed = getInstalledUnits();
		for (Unit<?> s : installed) {
			if (s.equals(dc))
				return true;
		}
		return false;
	}

	// ------------------------
	// ------------------------
	// ------------------------
	/**
	 * e.g: name = metric, return {@link MetricMeasurementSystem}
	 */
	public static MeasurementSystem findMeasurementSystem(String name) {
		try {
			return getInstalledSystems().stream().filter(ms -> ms.getName().equalsIgnoreCase(name)).findFirst().get();
		} catch (Exception e) {
			throw new RuntimeException(name, e);
		}
	}

	public static Dimension findDimension(String name) {
		try {
			return getInstalledDimensions().stream().filter(ms -> ms.getClass().getSimpleName().equalsIgnoreCase(name))
					.findFirst().get();
		} catch (Exception e) {
			throw new RuntimeException(name, e);
		}
	}

	// ------------------------
	// ------------------------
	// ------------------------
	public static <T extends Dimension> DimensionConverter<T> findConverter(Unit<T> u1, Unit<T> u2) {
		return findConverter(u1.getDimension(), u1.getSystem(), u2.getSystem());
	}

	/**
	 * <b>Note</b>: this method may return null if no converter installed yet, or may throw
	 * {@link IndexOutOfBoundsException} if combination index refers to out-of-bound
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dimension> DimensionConverter<T> findConverter(T d, MeasurementSystem m1,
			MeasurementSystem m2) {
		long combination = 0;
		int at = 0;
		try {
			combination = ((long) d.getId() << 32) | (m1.getId() | m2.getId());
			at = MeasurementUtils.findBitMappingIndex(combination, INSTALLED_SYSTEMS.size(),
					INSTALLED_DIMENSIONS.size());
			return (DimensionConverter<T>) INSTALLED_CONVERTERS.get(at);
		} catch (IndexOutOfBoundsException e) {
			throw new InstallationException(
					"no converter found, have you installed the converter by instantiating the class somewhere??\n\n"
							+ toString(d, m1, m2, at, combination),
					e);
		}
	}

	// ------------------------
	// ------------------------
	// ------------------------
	protected static void explainAllInstallations() {
		MeasurementSystem m1, m2;
		Dimension d;
		for (int i = 0; i < INSTALLED_SYSTEMS.size(); i++) {
			m1 = INSTALLED_SYSTEMS.get(i);
			for (int j = i + 1; j < INSTALLED_SYSTEMS.size(); j++) {
				m2 = INSTALLED_SYSTEMS.get(j);
				for (int k = 0; k < INSTALLED_DIMENSIONS.size(); k++) {
					d = INSTALLED_DIMENSIONS.get(k);
					System.out.println(toString(d, m1, m2));
				}
			}
		}
	}

	public static <T extends Dimension> String toString(T d, MeasurementSystem m1, MeasurementSystem m2) {
		long combination = ((long) d.getId() << 32) | (m1.getId() | m2.getId());
		int at = MeasurementUtils.findBitMappingIndex(combination, INSTALLED_SYSTEMS.size(),
				INSTALLED_DIMENSIONS.size());
		return toString(d, m1, m2, at, combination);
	}

	public static <T extends Dimension> String toString(T d, MeasurementSystem m1, MeasurementSystem m2, int at,
			long combination) {
		return String.format("at(%s), bin(%s), sup(%s) vs inf(%s) @ dim(%s)", Digits.ints.considerTen(at), tobin(combination), m1.getName(),
				m2.getName(), d.getClass().getSimpleName());
	}

	// ------------------------
	// ------------------------
	// ------------------------
	static String tobin(long n) {
		int rem = Long.numberOfLeadingZeros(n);
		StringBuilder sb = new StringBuilder(Long.toBinaryString(n));
		for (int i = 0; i < rem; i++) {
			sb.insert(0, '0');
		}
		for (int i = 8; i < 64; i += 9) {
			sb.insert(i, '_');
		}
		return sb.toString();
	}

	static String tobin(int n) {
		int rem = Integer.numberOfLeadingZeros(n);
		StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
		for (int i = 0; i < rem; i++) {
			sb.insert(0, '0');
		}
		for (int i = 8; i < 32; i += 9) {
			sb.insert(i, '_');
		}
		return sb.toString();
	}

}
