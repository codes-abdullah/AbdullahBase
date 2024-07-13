package codes.abdullah.measurement.dimension.convert;

import static codes.abdullah.measurement.dimension.Dimensions.AREA;
import static codes.abdullah.measurement.dimension.Dimensions.LENGTH;
import static codes.abdullah.measurement.dimension.Dimensions.MASS;
import static codes.abdullah.measurement.dimension.Dimensions.VOLUME;
import static codes.abdullah.measurement.system.MeasurementSystems.IMPERIAL_SYSTEM;
import static codes.abdullah.measurement.system.MeasurementSystems.JAPAN_SYSTEM;
import static codes.abdullah.measurement.system.MeasurementSystems.METRIC_SYSTEM;
import static codes.abdullah.measurement.system.MeasurementSystems.USC_SYSTEM;

import codes.abdullah.measurement.dimension.Area;
import codes.abdullah.measurement.dimension.Length;
import codes.abdullah.measurement.dimension.Mass;
import codes.abdullah.measurement.dimension.Volume;

public class DimensionConverters {

    static final double IMPERIAL_FLUID_OUNCE_PER_JAPAN_SHO = 0.0;

    static final double IMPERIAL_FLUID_OUNCE_PER_US_FLUID_OUNCE = 0.0;

    static final double IMPERIAL_FLUID_OUNCE_PER_USC_FLUID_OUNCE = 0.0;

    static final double IMPERIAL_FOOT_PER_JAPAN_SHAKU = 0.994193;

    static final double IMPERIAL_FOOT_PER_USC_FOOT = 1;

    static final double IMPERIAL_POUND_PER_JAPAN_KIN = 1.323;

    static final double IMPERIAL_SQUARE_FOOT_PER_JAPAN_TSUBO = 35.58;

    static final double JAPAN_SHAKU_PER_USC_FOOT = 0.0;

    static final double JAPAN_SHO_PER_USC_FLUID_OUNCE = 0.0;

    static final double METRIC_GRAM_PER_IMPERIAL_POUND = 453.592;

    static final double METRIC_GRAM_PER_JAPAN_KIN = 600;

    static final double METRIC_LITER_PER_IMPERIAL_FLUID_OUNCE = 0.0;

    static final double METRIC_LITER_PER_JAPAN_SHO = 0.0;

    static final double METRIC_LITER_PER_US_FLUID_OUNCE = 0.0;

    static final double METRIC_LITER_PER_USC_FLUID_OUNCE = 0.0;

    static final double METRIC_METER_PER_IMPERIAL_FOOT = 0.3048;

    static final double METRIC_METER_PER_JAPAN_SHAKU = 0.3030;

    static final double METRIC_METER_PER_USC_FOOT = 0.3048;

    static final double METRIC_SQUARE_METER_PER_IMPERIAL_SQUARE_FOOT = 0.09290304;

    static final double METRIC_SQUARE_METER_PER_JAPAN_TSUBO = 3.3057851239669422;

    static final DimensionConverter<Area> IMPERIAL_TO_JAPAN_AREA = new BasicDimensionConverter<Area>(IMPERIAL_SQUARE_FOOT_PER_JAPAN_TSUBO, AREA, IMPERIAL_SYSTEM, JAPAN_SYSTEM);

    static final DimensionConverter<Length> IMPERIAL_TO_JAPAN_LENGTH = new BasicDimensionConverter<Length>(IMPERIAL_FOOT_PER_JAPAN_SHAKU, LENGTH, IMPERIAL_SYSTEM, JAPAN_SYSTEM);

    static final DimensionConverter<Mass> IMPERIAL_TO_JAPAN_MASS = new BasicDimensionConverter<Mass>(IMPERIAL_POUND_PER_JAPAN_KIN, MASS, IMPERIAL_SYSTEM, JAPAN_SYSTEM);

    static final DimensionConverter<Volume> IMPERIAL_TO_JAPAN_VOLUME = new BasicDimensionConverter<Volume>(IMPERIAL_FLUID_OUNCE_PER_JAPAN_SHO, VOLUME, IMPERIAL_SYSTEM, JAPAN_SYSTEM);

    static final DimensionConverter<Length> IMPERIAL_TO_USC_LENGTH = new BasicDimensionConverter<Length>(IMPERIAL_FOOT_PER_USC_FOOT, LENGTH, IMPERIAL_SYSTEM, USC_SYSTEM);

    static final DimensionConverter<Volume> IMPERIAL_TO_USC_VOLUME = new BasicDimensionConverter<Volume>(IMPERIAL_FLUID_OUNCE_PER_USC_FLUID_OUNCE, VOLUME, IMPERIAL_SYSTEM, USC_SYSTEM);

    static final DimensionConverter<Length> JAPAN_TO_USC_LENGTH = new BasicDimensionConverter<Length>(JAPAN_SHAKU_PER_USC_FOOT, LENGTH, JAPAN_SYSTEM, USC_SYSTEM);

    static final DimensionConverter<Volume> JAPAN_TO_USC_VOLUME = new BasicDimensionConverter<Volume>(JAPAN_SHO_PER_USC_FLUID_OUNCE, VOLUME, JAPAN_SYSTEM, USC_SYSTEM);

    static final DimensionConverter<Area> METRIC_TO_IMPERIAL_AREA = new BasicDimensionConverter<Area>(METRIC_SQUARE_METER_PER_IMPERIAL_SQUARE_FOOT, AREA, METRIC_SYSTEM, IMPERIAL_SYSTEM);

    static final DimensionConverter<Length> METRIC_TO_IMPERIAL_LENGTH = new BasicDimensionConverter<Length>(METRIC_METER_PER_IMPERIAL_FOOT, LENGTH, METRIC_SYSTEM, IMPERIAL_SYSTEM);

    static final DimensionConverter<Mass> METRIC_TO_IMPERIAL_MASS = new BasicDimensionConverter<Mass>(METRIC_GRAM_PER_IMPERIAL_POUND, MASS, METRIC_SYSTEM, IMPERIAL_SYSTEM);

    static final DimensionConverter<Volume> METRIC_TO_IMPERIAL_VOLUME = new BasicDimensionConverter<Volume>(METRIC_LITER_PER_IMPERIAL_FLUID_OUNCE, VOLUME, METRIC_SYSTEM, IMPERIAL_SYSTEM);

    static final DimensionConverter<Area> METRIC_TO_JAPAN_AREA = new BasicDimensionConverter<Area>(METRIC_SQUARE_METER_PER_JAPAN_TSUBO, AREA, METRIC_SYSTEM, JAPAN_SYSTEM);

    static final DimensionConverter<Length> METRIC_TO_JAPAN_LENGTH = new BasicDimensionConverter<Length>(METRIC_METER_PER_JAPAN_SHAKU, LENGTH, METRIC_SYSTEM, JAPAN_SYSTEM);

    static final DimensionConverter<Mass> METRIC_TO_JAPAN_MASS = new BasicDimensionConverter<Mass>(METRIC_GRAM_PER_JAPAN_KIN, MASS, METRIC_SYSTEM, JAPAN_SYSTEM);

    static final DimensionConverter<Volume> METRIC_TO_JAPAN_VOLUME = new BasicDimensionConverter<Volume>(METRIC_LITER_PER_JAPAN_SHO, VOLUME, METRIC_SYSTEM, JAPAN_SYSTEM);

    static final DimensionConverter<Length> METRIC_TO_USC_LENGTH = new BasicDimensionConverter<Length>(METRIC_METER_PER_USC_FOOT, LENGTH, METRIC_SYSTEM, USC_SYSTEM);

    static final DimensionConverter<Volume> METRIC_TO_USC_VOLUME = new BasicDimensionConverter<Volume>(METRIC_LITER_PER_USC_FLUID_OUNCE, VOLUME, METRIC_SYSTEM, USC_SYSTEM);

    // ====================
    // ==================== STATICS
    // ====================
    public static void init() {
        // initial this class to install all static-final fields
        // this is required by Dimensions class
    }
}
