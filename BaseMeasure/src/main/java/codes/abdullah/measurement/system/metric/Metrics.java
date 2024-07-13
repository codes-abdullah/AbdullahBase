package codes.abdullah.measurement.system.metric;

import codes.abdullah.measurement.dimension.Area;
import codes.abdullah.measurement.dimension.Length;
import codes.abdullah.measurement.dimension.Mass;
import codes.abdullah.measurement.dimension.Time;
import codes.abdullah.measurement.dimension.Volume;

@SuppressWarnings(value = "unchecked")
public class Metrics {

    static final double max_millimeters = 10.0;

    static final double max_centimeters = 10.0;

    static final double max_decimeters = 10.0;

    static final double max_meters = 10.0;

    static final double max_dekameters = 10.0;

    static final double max_hecometers = 10.0;

    static final double max_kilometers = 10.0;

    static final double millimeters = 0.001d;

    static final double centimeters = 0.01d;

    static final double decimeters = 0.1d;

    static final double meters = 1d;

    static final double dekameters = 10d;

    static final double hecometers = 100d;

    static final double kilometers = 1000d;

    public static final MetricLength MILLIMETER = new MetricLength(millimeters, "mm", 0, max_millimeters);

    public static final MetricLength CENTIMETER = new MetricLength(centimeters, "cm", 1, max_centimeters);

    public static final MetricLength DECIMETER = new MetricLength(decimeters, "dm", 2, max_decimeters);

    public static final MetricLength METER = new MetricLength(meters, "m", 3, max_meters);

    public static final MetricLength DEKAMETER = new MetricLength(dekameters, "dam", 4, max_dekameters);

    public static final MetricLength HECOMETER = new MetricLength(hecometers, "hm", 5, max_hecometers);

    public static final MetricLength KILOMETER = new MetricLength(kilometers, "km", 6, max_kilometers);

    static final Metric<Length>[] METRIC_LENGTH_UNITS = new Metric[] { MILLIMETER, CENTIMETER, DECIMETER, METER, DEKAMETER, HECOMETER, KILOMETER };

    static final double max_square_millimeters = 10.0;

    static final double max_square_centimeters = 10.0;

    static final double max_square_decimeters = 10.0;

    static final double max_square_meters = 10.0;

    static final double max_square_dekameters = 10.0;

    static final double max_square_hecometers = 10.0;

    static final double max_square_kilometers = 10.0;

    static final double square_millimeters = 0.001d;

    static final double square_centimeters = 0.01d;

    static final double square_decimeters = 0.1d;

    static final double square_meters = 1d;

    static final double square_dekameters = 10d;

    static final double square_hecometers = 100d;

    static final double square_kilometers = 1000d;

    public static final MetricArea SQUARE_MILLIMETER = new MetricArea(square_millimeters, "mm²", 0, max_square_millimeters);

    public static final MetricArea SQUARE_CENTIMETER = new MetricArea(square_centimeters, "cm²", 1, max_square_centimeters);

    public static final MetricArea SQUARE_DECIMETER = new MetricArea(square_decimeters, "dm²", 2, max_square_decimeters);

    public static final MetricArea SQUARE_METER = new MetricArea(square_meters, "m²", 3, max_square_meters);

    public static final MetricArea SQUARE_DEKAMETER = new MetricArea(square_dekameters, "dam²", 4, max_square_dekameters);

    public static final MetricArea SQUARE_HECOMETER = new MetricArea(square_hecometers, "hm²", 5, max_square_hecometers);

    public static final MetricArea SQUARE_KILOMETER = new MetricArea(square_kilometers, "km²", 6, max_square_kilometers);

    static final Metric<Area>[] METRIC_AREA_UNITS = new Metric[] { SQUARE_MILLIMETER, SQUARE_CENTIMETER, SQUARE_DECIMETER, SQUARE_METER, SQUARE_DEKAMETER, SQUARE_HECOMETER, SQUARE_KILOMETER };

    static final double max_milligrams = 10.0;

    static final double max_centigrams = 10.0;

    static final double max_decigrams = 10.0;

    static final double max_grams = 10.0;

    static final double max_dekagrams = 10.0;

    static final double max_hecograms = 10.0;

    static final double max_kilograms = 10.0;

    static final double milligrams = 0.001d;

    static final double centigrams = 0.01d;

    static final double decigrams = 0.1d;

    static final double grams = 1d;

    static final double dekagrams = 10d;

    static final double hecograms = 100d;

    static final double kilograms = 1000d;

    public static final MetricMass MILLIGRAM = new MetricMass(milligrams, "mg", 0, max_milligrams);

    public static final MetricMass CENTIGRAM = new MetricMass(centigrams, "cg", 1, max_centigrams);

    public static final MetricMass DECIGRAM = new MetricMass(decigrams, "dg", 2, max_decigrams);

    public static final MetricMass GRAM = new MetricMass(grams, "g", 3, max_grams);

    public static final MetricMass DEKAGRAM = new MetricMass(dekagrams, "dag", 4, max_dekagrams);

    public static final MetricMass HECOGRAM = new MetricMass(hecograms, "hg", 5, max_hecograms);

    public static final MetricMass KILOGRAM = new MetricMass(kilograms, "kg", 6, max_kilograms);

    static final Metric<Mass>[] METRIC_MASS_UNITS = new Metric[] { MILLIGRAM, CENTIGRAM, DECIGRAM, GRAM, DEKAGRAM, HECOGRAM, KILOGRAM };

    static final double max_cubic_milligrams = 10.0;

    static final double max_cubic_centigrams = 10.0;

    static final double max_cubic_decigrams = 10.0;

    static final double max_cubic_grams = 10.0;

    static final double max_cubic_dekagrams = 10.0;

    static final double max_cubic_hecograms = 10.0;

    static final double max_cubic_kilograms = 10.0;

    static final double cubic_milligrams = 0.001d;

    static final double cubic_centigrams = 0.01d;

    static final double cubic_decigrams = 0.1d;

    static final double cubic_grams = 1d;

    static final double cubic_dekagrams = 10d;

    static final double cubic_hecograms = 100d;

    static final double cubic_kilograms = 1000d;

    public static final MetricVolume CUBIC_MILLIGRAM = new MetricVolume(cubic_milligrams, "mm³", 0, max_cubic_milligrams);

    public static final MetricVolume CUBIC_CENTIGRAM = new MetricVolume(cubic_centigrams, "cm³", 1, max_cubic_centigrams);

    public static final MetricVolume CUBIC_DECIGRAM = new MetricVolume(cubic_decigrams, "dm³", 2, max_cubic_decigrams);

    public static final MetricVolume CUBIC_GRAM = new MetricVolume(cubic_grams, "m³", 3, max_cubic_grams);

    public static final MetricVolume CUBIC_DEKAGRAM = new MetricVolume(cubic_dekagrams, "dam³", 4, max_cubic_dekagrams);

    public static final MetricVolume CUBIC_HECOGRAM = new MetricVolume(cubic_hecograms, "hm³", 5, max_cubic_hecograms);

    public static final MetricVolume CUBIC_KILOGRAM = new MetricVolume(cubic_kilograms, "km³", 6, max_cubic_kilograms);

    static final Metric<Volume>[] METRIC_VOLUME_UNITS = new Metric[] { CUBIC_MILLIGRAM, CUBIC_CENTIGRAM, CUBIC_DECIGRAM, CUBIC_GRAM, CUBIC_DEKAGRAM, CUBIC_HECOGRAM, CUBIC_KILOGRAM };

    static final double max_milliliters = 10.0;

    static final double max_centiliters = 10.0;

    static final double max_deciliters = 10.0;

    static final double max_liters = 10.0;

    static final double max_dekaliters = 10.0;

    static final double max_hectoliters = 10.0;

    static final double max_kiloliters = 10.0;

    static final double milliliters = 0.001d;

    static final double centiliters = 0.01d;

    static final double deciliters = 0.1d;

    static final double liters = 1d;

    static final double dekaliters = 10d;

    static final double hectoliters = 100d;

    static final double kiloliters = 1000d;

    public static final MetricVolume MILLILITER = new MetricVolume(milliliters, "ml", 0, max_milliliters);

    public static final MetricVolume CENTILITER = new MetricVolume(centiliters, "cl", 1, max_centiliters);

    public static final MetricVolume DECILITER = new MetricVolume(deciliters, "dl", 2, max_deciliters);

    public static final MetricVolume LITER = new MetricVolume(liters, "l", 3, max_liters);

    public static final MetricVolume DEKALITER = new MetricVolume(dekaliters, "dal", 4, max_dekaliters);

    public static final MetricVolume HECTOLITER = new MetricVolume(hectoliters, "hl", 5, max_hectoliters);

    public static final MetricVolume KILOLITER = new MetricVolume(kiloliters, "kl", 6, max_kiloliters);

    static final double max_nanoseconds = 1000.0;

    static final double max_microseconds = 1000.0;

    static final double max_milliseconds = 1000.0;

    static final double max_seconds = 60.0;

    static final double max_minutes = 60.0;

    static final double max_hours = 24.0;

    static final double max_days = -1.0;

    static final double nanoseconds = 0.0000000009999999999999999d;

    static final double microseconds = 0.000001d;

    static final double milliseconds = 0.001d;

    static final double seconds = 1d;

    static final double minutes = 60d;

    static final double hours = 3600d;

    static final double days = 86400d;

    public static final MetricTime NANOSECOND = new MetricTime(nanoseconds, "ns", 0, max_nanoseconds);

    public static final MetricTime MICROSECOND = new MetricTime(microseconds, "μs", 1, max_microseconds);

    public static final MetricTime MILLISECOND = new MetricTime(milliseconds, "ms", 2, max_milliseconds);

    public static final MetricTime SECOND = new MetricTime(seconds, "sec", 3, max_seconds);

    public static final MetricTime MINUTE = new MetricTime(minutes, "min", 4, max_minutes);

    public static final MetricTime HOUR = new MetricTime(hours, "hour", 5, max_hours);

    public static final MetricTime DAY = new MetricTime(days, "day", 6, max_days);

    static final Metric<Time>[] METRIC_TIME_UNITS = new Metric[] { NANOSECOND, MICROSECOND, MILLISECOND, SECOND, MINUTE, HOUR, DAY };
}
