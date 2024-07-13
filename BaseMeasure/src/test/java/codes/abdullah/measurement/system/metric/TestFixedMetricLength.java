package codes.abdullah.measurement.system.metric;

import static codes.abdullah.measurement.system.metric.Metrics.CENTIMETER;
import static codes.abdullah.measurement.system.metric.Metrics.DECIMETER;
import static codes.abdullah.measurement.system.metric.Metrics.DEKAMETER;
import static codes.abdullah.measurement.system.metric.Metrics.HECOMETER;
import static codes.abdullah.measurement.system.metric.Metrics.KILOMETER;
import static codes.abdullah.measurement.system.metric.Metrics.METER;
import static codes.abdullah.measurement.system.metric.Metrics.MILLIMETER;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFixedMetricLength {

    @Test()
    public void testMillimeter() {
        // from_factor = 0.001
        double from_factor = MILLIMETER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLIMETER
        // ====================
        // to_factor = 0.001
        to_factor = MILLIMETER.getFactor();
        msg = "-1 * (0.001 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MILLIMETER.toMillimeters(-1.0), delta);
        msg = "-0.1 * (0.001 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MILLIMETER.toMillimeters(-0.1), delta);
        msg = "-0.000456789 * (0.001 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MILLIMETER.toMillimeters(-4.56789E-4), delta);
        msg = "-73.25 * (0.001 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MILLIMETER.toMillimeters(-73.25), delta);
        msg = "-56229.321 * (0.001 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MILLIMETER.toMillimeters(-56229.321), delta);
        msg = "-873.5432456 * (0.001 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MILLIMETER.toMillimeters(-873.5432456), delta);
        msg = "0 * (0.001 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MILLIMETER.toMillimeters(0.0), delta);
        msg = "0.1 * (0.001 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MILLIMETER.toMillimeters(0.1), delta);
        msg = "0.0000876543297 * (0.001 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MILLIMETER.toMillimeters(8.76543297E-5), delta);
        msg = "0.33 * (0.001 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MILLIMETER.toMillimeters(0.33), delta);
        msg = "0.6543 * (0.001 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MILLIMETER.toMillimeters(0.6543), delta);
        msg = "1 * (0.001 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MILLIMETER.toMillimeters(1.0), delta);
        msg = "1.6543 * (0.001 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MILLIMETER.toMillimeters(1.6543), delta);
        msg = "22.45 * (0.001 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MILLIMETER.toMillimeters(22.45), delta);
        msg = "9876.5432 * (0.001 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MILLIMETER.toMillimeters(9876.5432), delta);
        msg = "1987654344.3345 * (0.001 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MILLIMETER.toMillimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.001 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MILLIMETER.toMillimeters(784.46789765434), delta);
        // ====================
        // ====================CENTIMETER
        // ====================
        // to_factor = 0.01
        to_factor = CENTIMETER.getFactor();
        msg = "-1 / (0.01 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLIMETER.toCentimeters(-1.0), delta);
        msg = "-0.1 / (0.01 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLIMETER.toCentimeters(-0.1), delta);
        msg = "-0.000456789 / (0.01 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLIMETER.toCentimeters(-4.56789E-4), delta);
        msg = "-73.25 / (0.01 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLIMETER.toCentimeters(-73.25), delta);
        msg = "-56229.321 / (0.01 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLIMETER.toCentimeters(-56229.321), delta);
        msg = "-873.5432456 / (0.01 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLIMETER.toCentimeters(-873.5432456), delta);
        msg = "0 / (0.01 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLIMETER.toCentimeters(0.0), delta);
        msg = "0.1 / (0.01 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLIMETER.toCentimeters(0.1), delta);
        msg = "0.0000876543297 / (0.01 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLIMETER.toCentimeters(8.76543297E-5), delta);
        msg = "0.33 / (0.01 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLIMETER.toCentimeters(0.33), delta);
        msg = "0.6543 / (0.01 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLIMETER.toCentimeters(0.6543), delta);
        msg = "1 / (0.01 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLIMETER.toCentimeters(1.0), delta);
        msg = "1.6543 / (0.01 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLIMETER.toCentimeters(1.6543), delta);
        msg = "22.45 / (0.01 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLIMETER.toCentimeters(22.45), delta);
        msg = "9876.5432 / (0.01 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLIMETER.toCentimeters(9876.5432), delta);
        msg = "1987654344.3345 / (0.01 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLIMETER.toCentimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.01 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLIMETER.toCentimeters(784.46789765434), delta);
        // ====================
        // ====================DECIMETER
        // ====================
        // to_factor = 0.1
        to_factor = DECIMETER.getFactor();
        msg = "-1 / (0.1 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLIMETER.toDecimeters(-1.0), delta);
        msg = "-0.1 / (0.1 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLIMETER.toDecimeters(-0.1), delta);
        msg = "-0.000456789 / (0.1 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLIMETER.toDecimeters(-4.56789E-4), delta);
        msg = "-73.25 / (0.1 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLIMETER.toDecimeters(-73.25), delta);
        msg = "-56229.321 / (0.1 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLIMETER.toDecimeters(-56229.321), delta);
        msg = "-873.5432456 / (0.1 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLIMETER.toDecimeters(-873.5432456), delta);
        msg = "0 / (0.1 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLIMETER.toDecimeters(0.0), delta);
        msg = "0.1 / (0.1 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLIMETER.toDecimeters(0.1), delta);
        msg = "0.0000876543297 / (0.1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLIMETER.toDecimeters(8.76543297E-5), delta);
        msg = "0.33 / (0.1 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLIMETER.toDecimeters(0.33), delta);
        msg = "0.6543 / (0.1 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLIMETER.toDecimeters(0.6543), delta);
        msg = "1 / (0.1 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLIMETER.toDecimeters(1.0), delta);
        msg = "1.6543 / (0.1 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLIMETER.toDecimeters(1.6543), delta);
        msg = "22.45 / (0.1 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLIMETER.toDecimeters(22.45), delta);
        msg = "9876.5432 / (0.1 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLIMETER.toDecimeters(9876.5432), delta);
        msg = "1987654344.3345 / (0.1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLIMETER.toDecimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.1 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLIMETER.toDecimeters(784.46789765434), delta);
        // ====================
        // ====================METER
        // ====================
        // to_factor = 1.0
        to_factor = METER.getFactor();
        msg = "-1 / (1 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLIMETER.toMeters(-1.0), delta);
        msg = "-0.1 / (1 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLIMETER.toMeters(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLIMETER.toMeters(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLIMETER.toMeters(-73.25), delta);
        msg = "-56229.321 / (1 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLIMETER.toMeters(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLIMETER.toMeters(-873.5432456), delta);
        msg = "0 / (1 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLIMETER.toMeters(0.0), delta);
        msg = "0.1 / (1 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLIMETER.toMeters(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLIMETER.toMeters(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLIMETER.toMeters(0.33), delta);
        msg = "0.6543 / (1 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLIMETER.toMeters(0.6543), delta);
        msg = "1 / (1 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLIMETER.toMeters(1.0), delta);
        msg = "1.6543 / (1 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLIMETER.toMeters(1.6543), delta);
        msg = "22.45 / (1 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLIMETER.toMeters(22.45), delta);
        msg = "9876.5432 / (1 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLIMETER.toMeters(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLIMETER.toMeters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLIMETER.toMeters(784.46789765434), delta);
        // ====================
        // ====================DEKAMETER
        // ====================
        // to_factor = 10.0
        to_factor = DEKAMETER.getFactor();
        msg = "-1 / (10 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLIMETER.toDekameters(-1.0), delta);
        msg = "-0.1 / (10 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLIMETER.toDekameters(-0.1), delta);
        msg = "-0.000456789 / (10 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLIMETER.toDekameters(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLIMETER.toDekameters(-73.25), delta);
        msg = "-56229.321 / (10 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLIMETER.toDekameters(-56229.321), delta);
        msg = "-873.5432456 / (10 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLIMETER.toDekameters(-873.5432456), delta);
        msg = "0 / (10 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLIMETER.toDekameters(0.0), delta);
        msg = "0.1 / (10 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLIMETER.toDekameters(0.1), delta);
        msg = "0.0000876543297 / (10 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLIMETER.toDekameters(8.76543297E-5), delta);
        msg = "0.33 / (10 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLIMETER.toDekameters(0.33), delta);
        msg = "0.6543 / (10 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLIMETER.toDekameters(0.6543), delta);
        msg = "1 / (10 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLIMETER.toDekameters(1.0), delta);
        msg = "1.6543 / (10 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLIMETER.toDekameters(1.6543), delta);
        msg = "22.45 / (10 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLIMETER.toDekameters(22.45), delta);
        msg = "9876.5432 / (10 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLIMETER.toDekameters(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLIMETER.toDekameters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLIMETER.toDekameters(784.46789765434), delta);
        // ====================
        // ====================HECOMETER
        // ====================
        // to_factor = 100.0
        to_factor = HECOMETER.getFactor();
        msg = "-1 / (100 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLIMETER.toHecometers(-1.0), delta);
        msg = "-0.1 / (100 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLIMETER.toHecometers(-0.1), delta);
        msg = "-0.000456789 / (100 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLIMETER.toHecometers(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLIMETER.toHecometers(-73.25), delta);
        msg = "-56229.321 / (100 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLIMETER.toHecometers(-56229.321), delta);
        msg = "-873.5432456 / (100 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLIMETER.toHecometers(-873.5432456), delta);
        msg = "0 / (100 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLIMETER.toHecometers(0.0), delta);
        msg = "0.1 / (100 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLIMETER.toHecometers(0.1), delta);
        msg = "0.0000876543297 / (100 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLIMETER.toHecometers(8.76543297E-5), delta);
        msg = "0.33 / (100 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLIMETER.toHecometers(0.33), delta);
        msg = "0.6543 / (100 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLIMETER.toHecometers(0.6543), delta);
        msg = "1 / (100 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLIMETER.toHecometers(1.0), delta);
        msg = "1.6543 / (100 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLIMETER.toHecometers(1.6543), delta);
        msg = "22.45 / (100 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLIMETER.toHecometers(22.45), delta);
        msg = "9876.5432 / (100 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLIMETER.toHecometers(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLIMETER.toHecometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLIMETER.toHecometers(784.46789765434), delta);
        // ====================
        // ====================KILOMETER
        // ====================
        // to_factor = 1000.0
        to_factor = KILOMETER.getFactor();
        msg = "-1 / (1000 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLIMETER.toKilometers(-1.0), delta);
        msg = "-0.1 / (1000 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLIMETER.toKilometers(-0.1), delta);
        msg = "-0.000456789 / (1000 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLIMETER.toKilometers(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLIMETER.toKilometers(-73.25), delta);
        msg = "-56229.321 / (1000 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLIMETER.toKilometers(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLIMETER.toKilometers(-873.5432456), delta);
        msg = "0 / (1000 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLIMETER.toKilometers(0.0), delta);
        msg = "0.1 / (1000 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLIMETER.toKilometers(0.1), delta);
        msg = "0.0000876543297 / (1000 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLIMETER.toKilometers(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLIMETER.toKilometers(0.33), delta);
        msg = "0.6543 / (1000 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLIMETER.toKilometers(0.6543), delta);
        msg = "1 / (1000 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLIMETER.toKilometers(1.0), delta);
        msg = "1.6543 / (1000 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLIMETER.toKilometers(1.6543), delta);
        msg = "22.45 / (1000 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLIMETER.toKilometers(22.45), delta);
        msg = "9876.5432 / (1000 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLIMETER.toKilometers(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLIMETER.toKilometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLIMETER.toKilometers(784.46789765434), delta);
    }

    @Test()
    public void testCentimeter() {
        // from_factor = 0.01
        double from_factor = CENTIMETER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLIMETER
        // ====================
        // to_factor = 0.001
        to_factor = MILLIMETER.getFactor();
        msg = "-1 * (0.01 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CENTIMETER.toMillimeters(-1.0), delta);
        msg = "-0.1 * (0.01 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CENTIMETER.toMillimeters(-0.1), delta);
        msg = "-0.000456789 * (0.01 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CENTIMETER.toMillimeters(-4.56789E-4), delta);
        msg = "-73.25 * (0.01 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CENTIMETER.toMillimeters(-73.25), delta);
        msg = "-56229.321 * (0.01 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CENTIMETER.toMillimeters(-56229.321), delta);
        msg = "-873.5432456 * (0.01 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CENTIMETER.toMillimeters(-873.5432456), delta);
        msg = "0 * (0.01 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CENTIMETER.toMillimeters(0.0), delta);
        msg = "0.1 * (0.01 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CENTIMETER.toMillimeters(0.1), delta);
        msg = "0.0000876543297 * (0.01 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CENTIMETER.toMillimeters(8.76543297E-5), delta);
        msg = "0.33 * (0.01 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CENTIMETER.toMillimeters(0.33), delta);
        msg = "0.6543 * (0.01 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CENTIMETER.toMillimeters(0.6543), delta);
        msg = "1 * (0.01 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CENTIMETER.toMillimeters(1.0), delta);
        msg = "1.6543 * (0.01 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CENTIMETER.toMillimeters(1.6543), delta);
        msg = "22.45 * (0.01 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CENTIMETER.toMillimeters(22.45), delta);
        msg = "9876.5432 * (0.01 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CENTIMETER.toMillimeters(9876.5432), delta);
        msg = "1987654344.3345 * (0.01 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CENTIMETER.toMillimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.01 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CENTIMETER.toMillimeters(784.46789765434), delta);
        // ====================
        // ====================CENTIMETER
        // ====================
        // to_factor = 0.01
        to_factor = CENTIMETER.getFactor();
        msg = "-1 * (0.01 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CENTIMETER.toCentimeters(-1.0), delta);
        msg = "-0.1 * (0.01 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CENTIMETER.toCentimeters(-0.1), delta);
        msg = "-0.000456789 * (0.01 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CENTIMETER.toCentimeters(-4.56789E-4), delta);
        msg = "-73.25 * (0.01 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CENTIMETER.toCentimeters(-73.25), delta);
        msg = "-56229.321 * (0.01 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CENTIMETER.toCentimeters(-56229.321), delta);
        msg = "-873.5432456 * (0.01 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CENTIMETER.toCentimeters(-873.5432456), delta);
        msg = "0 * (0.01 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CENTIMETER.toCentimeters(0.0), delta);
        msg = "0.1 * (0.01 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CENTIMETER.toCentimeters(0.1), delta);
        msg = "0.0000876543297 * (0.01 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CENTIMETER.toCentimeters(8.76543297E-5), delta);
        msg = "0.33 * (0.01 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CENTIMETER.toCentimeters(0.33), delta);
        msg = "0.6543 * (0.01 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CENTIMETER.toCentimeters(0.6543), delta);
        msg = "1 * (0.01 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CENTIMETER.toCentimeters(1.0), delta);
        msg = "1.6543 * (0.01 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CENTIMETER.toCentimeters(1.6543), delta);
        msg = "22.45 * (0.01 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CENTIMETER.toCentimeters(22.45), delta);
        msg = "9876.5432 * (0.01 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CENTIMETER.toCentimeters(9876.5432), delta);
        msg = "1987654344.3345 * (0.01 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CENTIMETER.toCentimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.01 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CENTIMETER.toCentimeters(784.46789765434), delta);
        // ====================
        // ====================DECIMETER
        // ====================
        // to_factor = 0.1
        to_factor = DECIMETER.getFactor();
        msg = "-1 / (0.1 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), CENTIMETER.toDecimeters(-1.0), delta);
        msg = "-0.1 / (0.1 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), CENTIMETER.toDecimeters(-0.1), delta);
        msg = "-0.000456789 / (0.1 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), CENTIMETER.toDecimeters(-4.56789E-4), delta);
        msg = "-73.25 / (0.1 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), CENTIMETER.toDecimeters(-73.25), delta);
        msg = "-56229.321 / (0.1 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), CENTIMETER.toDecimeters(-56229.321), delta);
        msg = "-873.5432456 / (0.1 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), CENTIMETER.toDecimeters(-873.5432456), delta);
        msg = "0 / (0.1 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), CENTIMETER.toDecimeters(0.0), delta);
        msg = "0.1 / (0.1 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), CENTIMETER.toDecimeters(0.1), delta);
        msg = "0.0000876543297 / (0.1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), CENTIMETER.toDecimeters(8.76543297E-5), delta);
        msg = "0.33 / (0.1 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), CENTIMETER.toDecimeters(0.33), delta);
        msg = "0.6543 / (0.1 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), CENTIMETER.toDecimeters(0.6543), delta);
        msg = "1 / (0.1 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), CENTIMETER.toDecimeters(1.0), delta);
        msg = "1.6543 / (0.1 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), CENTIMETER.toDecimeters(1.6543), delta);
        msg = "22.45 / (0.1 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), CENTIMETER.toDecimeters(22.45), delta);
        msg = "9876.5432 / (0.1 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), CENTIMETER.toDecimeters(9876.5432), delta);
        msg = "1987654344.3345 / (0.1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), CENTIMETER.toDecimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.1 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), CENTIMETER.toDecimeters(784.46789765434), delta);
        // ====================
        // ====================METER
        // ====================
        // to_factor = 1.0
        to_factor = METER.getFactor();
        msg = "-1 / (1 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), CENTIMETER.toMeters(-1.0), delta);
        msg = "-0.1 / (1 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), CENTIMETER.toMeters(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), CENTIMETER.toMeters(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), CENTIMETER.toMeters(-73.25), delta);
        msg = "-56229.321 / (1 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), CENTIMETER.toMeters(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), CENTIMETER.toMeters(-873.5432456), delta);
        msg = "0 / (1 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), CENTIMETER.toMeters(0.0), delta);
        msg = "0.1 / (1 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), CENTIMETER.toMeters(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), CENTIMETER.toMeters(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), CENTIMETER.toMeters(0.33), delta);
        msg = "0.6543 / (1 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), CENTIMETER.toMeters(0.6543), delta);
        msg = "1 / (1 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), CENTIMETER.toMeters(1.0), delta);
        msg = "1.6543 / (1 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), CENTIMETER.toMeters(1.6543), delta);
        msg = "22.45 / (1 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), CENTIMETER.toMeters(22.45), delta);
        msg = "9876.5432 / (1 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), CENTIMETER.toMeters(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), CENTIMETER.toMeters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), CENTIMETER.toMeters(784.46789765434), delta);
        // ====================
        // ====================DEKAMETER
        // ====================
        // to_factor = 10.0
        to_factor = DEKAMETER.getFactor();
        msg = "-1 / (10 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), CENTIMETER.toDekameters(-1.0), delta);
        msg = "-0.1 / (10 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), CENTIMETER.toDekameters(-0.1), delta);
        msg = "-0.000456789 / (10 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), CENTIMETER.toDekameters(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), CENTIMETER.toDekameters(-73.25), delta);
        msg = "-56229.321 / (10 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), CENTIMETER.toDekameters(-56229.321), delta);
        msg = "-873.5432456 / (10 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), CENTIMETER.toDekameters(-873.5432456), delta);
        msg = "0 / (10 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), CENTIMETER.toDekameters(0.0), delta);
        msg = "0.1 / (10 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), CENTIMETER.toDekameters(0.1), delta);
        msg = "0.0000876543297 / (10 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), CENTIMETER.toDekameters(8.76543297E-5), delta);
        msg = "0.33 / (10 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), CENTIMETER.toDekameters(0.33), delta);
        msg = "0.6543 / (10 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), CENTIMETER.toDekameters(0.6543), delta);
        msg = "1 / (10 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), CENTIMETER.toDekameters(1.0), delta);
        msg = "1.6543 / (10 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), CENTIMETER.toDekameters(1.6543), delta);
        msg = "22.45 / (10 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), CENTIMETER.toDekameters(22.45), delta);
        msg = "9876.5432 / (10 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), CENTIMETER.toDekameters(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), CENTIMETER.toDekameters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), CENTIMETER.toDekameters(784.46789765434), delta);
        // ====================
        // ====================HECOMETER
        // ====================
        // to_factor = 100.0
        to_factor = HECOMETER.getFactor();
        msg = "-1 / (100 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), CENTIMETER.toHecometers(-1.0), delta);
        msg = "-0.1 / (100 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), CENTIMETER.toHecometers(-0.1), delta);
        msg = "-0.000456789 / (100 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), CENTIMETER.toHecometers(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), CENTIMETER.toHecometers(-73.25), delta);
        msg = "-56229.321 / (100 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), CENTIMETER.toHecometers(-56229.321), delta);
        msg = "-873.5432456 / (100 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), CENTIMETER.toHecometers(-873.5432456), delta);
        msg = "0 / (100 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), CENTIMETER.toHecometers(0.0), delta);
        msg = "0.1 / (100 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), CENTIMETER.toHecometers(0.1), delta);
        msg = "0.0000876543297 / (100 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), CENTIMETER.toHecometers(8.76543297E-5), delta);
        msg = "0.33 / (100 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), CENTIMETER.toHecometers(0.33), delta);
        msg = "0.6543 / (100 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), CENTIMETER.toHecometers(0.6543), delta);
        msg = "1 / (100 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), CENTIMETER.toHecometers(1.0), delta);
        msg = "1.6543 / (100 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), CENTIMETER.toHecometers(1.6543), delta);
        msg = "22.45 / (100 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), CENTIMETER.toHecometers(22.45), delta);
        msg = "9876.5432 / (100 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), CENTIMETER.toHecometers(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), CENTIMETER.toHecometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), CENTIMETER.toHecometers(784.46789765434), delta);
        // ====================
        // ====================KILOMETER
        // ====================
        // to_factor = 1000.0
        to_factor = KILOMETER.getFactor();
        msg = "-1 / (1000 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), CENTIMETER.toKilometers(-1.0), delta);
        msg = "-0.1 / (1000 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), CENTIMETER.toKilometers(-0.1), delta);
        msg = "-0.000456789 / (1000 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), CENTIMETER.toKilometers(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), CENTIMETER.toKilometers(-73.25), delta);
        msg = "-56229.321 / (1000 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), CENTIMETER.toKilometers(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), CENTIMETER.toKilometers(-873.5432456), delta);
        msg = "0 / (1000 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), CENTIMETER.toKilometers(0.0), delta);
        msg = "0.1 / (1000 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), CENTIMETER.toKilometers(0.1), delta);
        msg = "0.0000876543297 / (1000 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), CENTIMETER.toKilometers(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), CENTIMETER.toKilometers(0.33), delta);
        msg = "0.6543 / (1000 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), CENTIMETER.toKilometers(0.6543), delta);
        msg = "1 / (1000 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), CENTIMETER.toKilometers(1.0), delta);
        msg = "1.6543 / (1000 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), CENTIMETER.toKilometers(1.6543), delta);
        msg = "22.45 / (1000 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), CENTIMETER.toKilometers(22.45), delta);
        msg = "9876.5432 / (1000 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), CENTIMETER.toKilometers(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), CENTIMETER.toKilometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), CENTIMETER.toKilometers(784.46789765434), delta);
    }

    @Test()
    public void testDecimeter() {
        // from_factor = 0.1
        double from_factor = DECIMETER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLIMETER
        // ====================
        // to_factor = 0.001
        to_factor = MILLIMETER.getFactor();
        msg = "-1 * (0.1 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DECIMETER.toMillimeters(-1.0), delta);
        msg = "-0.1 * (0.1 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DECIMETER.toMillimeters(-0.1), delta);
        msg = "-0.000456789 * (0.1 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DECIMETER.toMillimeters(-4.56789E-4), delta);
        msg = "-73.25 * (0.1 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DECIMETER.toMillimeters(-73.25), delta);
        msg = "-56229.321 * (0.1 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DECIMETER.toMillimeters(-56229.321), delta);
        msg = "-873.5432456 * (0.1 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DECIMETER.toMillimeters(-873.5432456), delta);
        msg = "0 * (0.1 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DECIMETER.toMillimeters(0.0), delta);
        msg = "0.1 * (0.1 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DECIMETER.toMillimeters(0.1), delta);
        msg = "0.0000876543297 * (0.1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DECIMETER.toMillimeters(8.76543297E-5), delta);
        msg = "0.33 * (0.1 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DECIMETER.toMillimeters(0.33), delta);
        msg = "0.6543 * (0.1 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DECIMETER.toMillimeters(0.6543), delta);
        msg = "1 * (0.1 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DECIMETER.toMillimeters(1.0), delta);
        msg = "1.6543 * (0.1 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DECIMETER.toMillimeters(1.6543), delta);
        msg = "22.45 * (0.1 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DECIMETER.toMillimeters(22.45), delta);
        msg = "9876.5432 * (0.1 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DECIMETER.toMillimeters(9876.5432), delta);
        msg = "1987654344.3345 * (0.1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DECIMETER.toMillimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.1 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DECIMETER.toMillimeters(784.46789765434), delta);
        // ====================
        // ====================CENTIMETER
        // ====================
        // to_factor = 0.01
        to_factor = CENTIMETER.getFactor();
        msg = "-1 * (0.1 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DECIMETER.toCentimeters(-1.0), delta);
        msg = "-0.1 * (0.1 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DECIMETER.toCentimeters(-0.1), delta);
        msg = "-0.000456789 * (0.1 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DECIMETER.toCentimeters(-4.56789E-4), delta);
        msg = "-73.25 * (0.1 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DECIMETER.toCentimeters(-73.25), delta);
        msg = "-56229.321 * (0.1 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DECIMETER.toCentimeters(-56229.321), delta);
        msg = "-873.5432456 * (0.1 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DECIMETER.toCentimeters(-873.5432456), delta);
        msg = "0 * (0.1 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DECIMETER.toCentimeters(0.0), delta);
        msg = "0.1 * (0.1 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DECIMETER.toCentimeters(0.1), delta);
        msg = "0.0000876543297 * (0.1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DECIMETER.toCentimeters(8.76543297E-5), delta);
        msg = "0.33 * (0.1 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DECIMETER.toCentimeters(0.33), delta);
        msg = "0.6543 * (0.1 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DECIMETER.toCentimeters(0.6543), delta);
        msg = "1 * (0.1 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DECIMETER.toCentimeters(1.0), delta);
        msg = "1.6543 * (0.1 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DECIMETER.toCentimeters(1.6543), delta);
        msg = "22.45 * (0.1 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DECIMETER.toCentimeters(22.45), delta);
        msg = "9876.5432 * (0.1 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DECIMETER.toCentimeters(9876.5432), delta);
        msg = "1987654344.3345 * (0.1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DECIMETER.toCentimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.1 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DECIMETER.toCentimeters(784.46789765434), delta);
        // ====================
        // ====================DECIMETER
        // ====================
        // to_factor = 0.1
        to_factor = DECIMETER.getFactor();
        msg = "-1 * (0.1 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DECIMETER.toDecimeters(-1.0), delta);
        msg = "-0.1 * (0.1 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DECIMETER.toDecimeters(-0.1), delta);
        msg = "-0.000456789 * (0.1 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DECIMETER.toDecimeters(-4.56789E-4), delta);
        msg = "-73.25 * (0.1 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DECIMETER.toDecimeters(-73.25), delta);
        msg = "-56229.321 * (0.1 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DECIMETER.toDecimeters(-56229.321), delta);
        msg = "-873.5432456 * (0.1 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DECIMETER.toDecimeters(-873.5432456), delta);
        msg = "0 * (0.1 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DECIMETER.toDecimeters(0.0), delta);
        msg = "0.1 * (0.1 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DECIMETER.toDecimeters(0.1), delta);
        msg = "0.0000876543297 * (0.1 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DECIMETER.toDecimeters(8.76543297E-5), delta);
        msg = "0.33 * (0.1 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DECIMETER.toDecimeters(0.33), delta);
        msg = "0.6543 * (0.1 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DECIMETER.toDecimeters(0.6543), delta);
        msg = "1 * (0.1 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DECIMETER.toDecimeters(1.0), delta);
        msg = "1.6543 * (0.1 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DECIMETER.toDecimeters(1.6543), delta);
        msg = "22.45 * (0.1 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DECIMETER.toDecimeters(22.45), delta);
        msg = "9876.5432 * (0.1 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DECIMETER.toDecimeters(9876.5432), delta);
        msg = "1987654344.3345 * (0.1 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DECIMETER.toDecimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.1 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DECIMETER.toDecimeters(784.46789765434), delta);
        // ====================
        // ====================METER
        // ====================
        // to_factor = 1.0
        to_factor = METER.getFactor();
        msg = "-1 / (1 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DECIMETER.toMeters(-1.0), delta);
        msg = "-0.1 / (1 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DECIMETER.toMeters(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DECIMETER.toMeters(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DECIMETER.toMeters(-73.25), delta);
        msg = "-56229.321 / (1 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DECIMETER.toMeters(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DECIMETER.toMeters(-873.5432456), delta);
        msg = "0 / (1 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DECIMETER.toMeters(0.0), delta);
        msg = "0.1 / (1 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DECIMETER.toMeters(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DECIMETER.toMeters(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DECIMETER.toMeters(0.33), delta);
        msg = "0.6543 / (1 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DECIMETER.toMeters(0.6543), delta);
        msg = "1 / (1 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DECIMETER.toMeters(1.0), delta);
        msg = "1.6543 / (1 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DECIMETER.toMeters(1.6543), delta);
        msg = "22.45 / (1 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DECIMETER.toMeters(22.45), delta);
        msg = "9876.5432 / (1 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DECIMETER.toMeters(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DECIMETER.toMeters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DECIMETER.toMeters(784.46789765434), delta);
        // ====================
        // ====================DEKAMETER
        // ====================
        // to_factor = 10.0
        to_factor = DEKAMETER.getFactor();
        msg = "-1 / (10 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DECIMETER.toDekameters(-1.0), delta);
        msg = "-0.1 / (10 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DECIMETER.toDekameters(-0.1), delta);
        msg = "-0.000456789 / (10 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DECIMETER.toDekameters(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DECIMETER.toDekameters(-73.25), delta);
        msg = "-56229.321 / (10 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DECIMETER.toDekameters(-56229.321), delta);
        msg = "-873.5432456 / (10 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DECIMETER.toDekameters(-873.5432456), delta);
        msg = "0 / (10 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DECIMETER.toDekameters(0.0), delta);
        msg = "0.1 / (10 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DECIMETER.toDekameters(0.1), delta);
        msg = "0.0000876543297 / (10 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DECIMETER.toDekameters(8.76543297E-5), delta);
        msg = "0.33 / (10 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DECIMETER.toDekameters(0.33), delta);
        msg = "0.6543 / (10 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DECIMETER.toDekameters(0.6543), delta);
        msg = "1 / (10 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DECIMETER.toDekameters(1.0), delta);
        msg = "1.6543 / (10 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DECIMETER.toDekameters(1.6543), delta);
        msg = "22.45 / (10 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DECIMETER.toDekameters(22.45), delta);
        msg = "9876.5432 / (10 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DECIMETER.toDekameters(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DECIMETER.toDekameters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DECIMETER.toDekameters(784.46789765434), delta);
        // ====================
        // ====================HECOMETER
        // ====================
        // to_factor = 100.0
        to_factor = HECOMETER.getFactor();
        msg = "-1 / (100 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DECIMETER.toHecometers(-1.0), delta);
        msg = "-0.1 / (100 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DECIMETER.toHecometers(-0.1), delta);
        msg = "-0.000456789 / (100 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DECIMETER.toHecometers(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DECIMETER.toHecometers(-73.25), delta);
        msg = "-56229.321 / (100 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DECIMETER.toHecometers(-56229.321), delta);
        msg = "-873.5432456 / (100 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DECIMETER.toHecometers(-873.5432456), delta);
        msg = "0 / (100 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DECIMETER.toHecometers(0.0), delta);
        msg = "0.1 / (100 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DECIMETER.toHecometers(0.1), delta);
        msg = "0.0000876543297 / (100 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DECIMETER.toHecometers(8.76543297E-5), delta);
        msg = "0.33 / (100 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DECIMETER.toHecometers(0.33), delta);
        msg = "0.6543 / (100 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DECIMETER.toHecometers(0.6543), delta);
        msg = "1 / (100 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DECIMETER.toHecometers(1.0), delta);
        msg = "1.6543 / (100 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DECIMETER.toHecometers(1.6543), delta);
        msg = "22.45 / (100 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DECIMETER.toHecometers(22.45), delta);
        msg = "9876.5432 / (100 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DECIMETER.toHecometers(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DECIMETER.toHecometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DECIMETER.toHecometers(784.46789765434), delta);
        // ====================
        // ====================KILOMETER
        // ====================
        // to_factor = 1000.0
        to_factor = KILOMETER.getFactor();
        msg = "-1 / (1000 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DECIMETER.toKilometers(-1.0), delta);
        msg = "-0.1 / (1000 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DECIMETER.toKilometers(-0.1), delta);
        msg = "-0.000456789 / (1000 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DECIMETER.toKilometers(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DECIMETER.toKilometers(-73.25), delta);
        msg = "-56229.321 / (1000 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DECIMETER.toKilometers(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DECIMETER.toKilometers(-873.5432456), delta);
        msg = "0 / (1000 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DECIMETER.toKilometers(0.0), delta);
        msg = "0.1 / (1000 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DECIMETER.toKilometers(0.1), delta);
        msg = "0.0000876543297 / (1000 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DECIMETER.toKilometers(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DECIMETER.toKilometers(0.33), delta);
        msg = "0.6543 / (1000 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DECIMETER.toKilometers(0.6543), delta);
        msg = "1 / (1000 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DECIMETER.toKilometers(1.0), delta);
        msg = "1.6543 / (1000 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DECIMETER.toKilometers(1.6543), delta);
        msg = "22.45 / (1000 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DECIMETER.toKilometers(22.45), delta);
        msg = "9876.5432 / (1000 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DECIMETER.toKilometers(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DECIMETER.toKilometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DECIMETER.toKilometers(784.46789765434), delta);
    }

    @Test()
    public void testMeter() {
        // from_factor = 1.0
        double from_factor = METER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLIMETER
        // ====================
        // to_factor = 0.001
        to_factor = MILLIMETER.getFactor();
        msg = "-1 * (1 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), METER.toMillimeters(-1.0), delta);
        msg = "-0.1 * (1 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), METER.toMillimeters(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), METER.toMillimeters(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), METER.toMillimeters(-73.25), delta);
        msg = "-56229.321 * (1 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), METER.toMillimeters(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), METER.toMillimeters(-873.5432456), delta);
        msg = "0 * (1 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), METER.toMillimeters(0.0), delta);
        msg = "0.1 * (1 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), METER.toMillimeters(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), METER.toMillimeters(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), METER.toMillimeters(0.33), delta);
        msg = "0.6543 * (1 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), METER.toMillimeters(0.6543), delta);
        msg = "1 * (1 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), METER.toMillimeters(1.0), delta);
        msg = "1.6543 * (1 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), METER.toMillimeters(1.6543), delta);
        msg = "22.45 * (1 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), METER.toMillimeters(22.45), delta);
        msg = "9876.5432 * (1 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), METER.toMillimeters(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), METER.toMillimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), METER.toMillimeters(784.46789765434), delta);
        // ====================
        // ====================CENTIMETER
        // ====================
        // to_factor = 0.01
        to_factor = CENTIMETER.getFactor();
        msg = "-1 * (1 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), METER.toCentimeters(-1.0), delta);
        msg = "-0.1 * (1 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), METER.toCentimeters(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), METER.toCentimeters(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), METER.toCentimeters(-73.25), delta);
        msg = "-56229.321 * (1 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), METER.toCentimeters(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), METER.toCentimeters(-873.5432456), delta);
        msg = "0 * (1 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), METER.toCentimeters(0.0), delta);
        msg = "0.1 * (1 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), METER.toCentimeters(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), METER.toCentimeters(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), METER.toCentimeters(0.33), delta);
        msg = "0.6543 * (1 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), METER.toCentimeters(0.6543), delta);
        msg = "1 * (1 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), METER.toCentimeters(1.0), delta);
        msg = "1.6543 * (1 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), METER.toCentimeters(1.6543), delta);
        msg = "22.45 * (1 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), METER.toCentimeters(22.45), delta);
        msg = "9876.5432 * (1 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), METER.toCentimeters(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), METER.toCentimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), METER.toCentimeters(784.46789765434), delta);
        // ====================
        // ====================DECIMETER
        // ====================
        // to_factor = 0.1
        to_factor = DECIMETER.getFactor();
        msg = "-1 * (1 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), METER.toDecimeters(-1.0), delta);
        msg = "-0.1 * (1 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), METER.toDecimeters(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), METER.toDecimeters(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), METER.toDecimeters(-73.25), delta);
        msg = "-56229.321 * (1 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), METER.toDecimeters(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), METER.toDecimeters(-873.5432456), delta);
        msg = "0 * (1 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), METER.toDecimeters(0.0), delta);
        msg = "0.1 * (1 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), METER.toDecimeters(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), METER.toDecimeters(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), METER.toDecimeters(0.33), delta);
        msg = "0.6543 * (1 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), METER.toDecimeters(0.6543), delta);
        msg = "1 * (1 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), METER.toDecimeters(1.0), delta);
        msg = "1.6543 * (1 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), METER.toDecimeters(1.6543), delta);
        msg = "22.45 * (1 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), METER.toDecimeters(22.45), delta);
        msg = "9876.5432 * (1 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), METER.toDecimeters(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), METER.toDecimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), METER.toDecimeters(784.46789765434), delta);
        // ====================
        // ====================METER
        // ====================
        // to_factor = 1.0
        to_factor = METER.getFactor();
        msg = "-1 * (1 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), METER.toMeters(-1.0), delta);
        msg = "-0.1 * (1 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), METER.toMeters(-0.1), delta);
        msg = "-0.000456789 * (1 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), METER.toMeters(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), METER.toMeters(-73.25), delta);
        msg = "-56229.321 * (1 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), METER.toMeters(-56229.321), delta);
        msg = "-873.5432456 * (1 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), METER.toMeters(-873.5432456), delta);
        msg = "0 * (1 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), METER.toMeters(0.0), delta);
        msg = "0.1 * (1 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), METER.toMeters(0.1), delta);
        msg = "0.0000876543297 * (1 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), METER.toMeters(8.76543297E-5), delta);
        msg = "0.33 * (1 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), METER.toMeters(0.33), delta);
        msg = "0.6543 * (1 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), METER.toMeters(0.6543), delta);
        msg = "1 * (1 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), METER.toMeters(1.0), delta);
        msg = "1.6543 * (1 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), METER.toMeters(1.6543), delta);
        msg = "22.45 * (1 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), METER.toMeters(22.45), delta);
        msg = "9876.5432 * (1 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), METER.toMeters(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), METER.toMeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), METER.toMeters(784.46789765434), delta);
        // ====================
        // ====================DEKAMETER
        // ====================
        // to_factor = 10.0
        to_factor = DEKAMETER.getFactor();
        msg = "-1 / (10 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), METER.toDekameters(-1.0), delta);
        msg = "-0.1 / (10 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), METER.toDekameters(-0.1), delta);
        msg = "-0.000456789 / (10 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), METER.toDekameters(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), METER.toDekameters(-73.25), delta);
        msg = "-56229.321 / (10 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), METER.toDekameters(-56229.321), delta);
        msg = "-873.5432456 / (10 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), METER.toDekameters(-873.5432456), delta);
        msg = "0 / (10 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), METER.toDekameters(0.0), delta);
        msg = "0.1 / (10 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), METER.toDekameters(0.1), delta);
        msg = "0.0000876543297 / (10 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), METER.toDekameters(8.76543297E-5), delta);
        msg = "0.33 / (10 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), METER.toDekameters(0.33), delta);
        msg = "0.6543 / (10 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), METER.toDekameters(0.6543), delta);
        msg = "1 / (10 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), METER.toDekameters(1.0), delta);
        msg = "1.6543 / (10 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), METER.toDekameters(1.6543), delta);
        msg = "22.45 / (10 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), METER.toDekameters(22.45), delta);
        msg = "9876.5432 / (10 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), METER.toDekameters(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), METER.toDekameters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), METER.toDekameters(784.46789765434), delta);
        // ====================
        // ====================HECOMETER
        // ====================
        // to_factor = 100.0
        to_factor = HECOMETER.getFactor();
        msg = "-1 / (100 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), METER.toHecometers(-1.0), delta);
        msg = "-0.1 / (100 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), METER.toHecometers(-0.1), delta);
        msg = "-0.000456789 / (100 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), METER.toHecometers(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), METER.toHecometers(-73.25), delta);
        msg = "-56229.321 / (100 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), METER.toHecometers(-56229.321), delta);
        msg = "-873.5432456 / (100 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), METER.toHecometers(-873.5432456), delta);
        msg = "0 / (100 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), METER.toHecometers(0.0), delta);
        msg = "0.1 / (100 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), METER.toHecometers(0.1), delta);
        msg = "0.0000876543297 / (100 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), METER.toHecometers(8.76543297E-5), delta);
        msg = "0.33 / (100 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), METER.toHecometers(0.33), delta);
        msg = "0.6543 / (100 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), METER.toHecometers(0.6543), delta);
        msg = "1 / (100 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), METER.toHecometers(1.0), delta);
        msg = "1.6543 / (100 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), METER.toHecometers(1.6543), delta);
        msg = "22.45 / (100 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), METER.toHecometers(22.45), delta);
        msg = "9876.5432 / (100 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), METER.toHecometers(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), METER.toHecometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), METER.toHecometers(784.46789765434), delta);
        // ====================
        // ====================KILOMETER
        // ====================
        // to_factor = 1000.0
        to_factor = KILOMETER.getFactor();
        msg = "-1 / (1000 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), METER.toKilometers(-1.0), delta);
        msg = "-0.1 / (1000 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), METER.toKilometers(-0.1), delta);
        msg = "-0.000456789 / (1000 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), METER.toKilometers(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), METER.toKilometers(-73.25), delta);
        msg = "-56229.321 / (1000 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), METER.toKilometers(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), METER.toKilometers(-873.5432456), delta);
        msg = "0 / (1000 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), METER.toKilometers(0.0), delta);
        msg = "0.1 / (1000 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), METER.toKilometers(0.1), delta);
        msg = "0.0000876543297 / (1000 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), METER.toKilometers(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), METER.toKilometers(0.33), delta);
        msg = "0.6543 / (1000 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), METER.toKilometers(0.6543), delta);
        msg = "1 / (1000 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), METER.toKilometers(1.0), delta);
        msg = "1.6543 / (1000 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), METER.toKilometers(1.6543), delta);
        msg = "22.45 / (1000 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), METER.toKilometers(22.45), delta);
        msg = "9876.5432 / (1000 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), METER.toKilometers(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), METER.toKilometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), METER.toKilometers(784.46789765434), delta);
    }

    @Test()
    public void testDekameter() {
        // from_factor = 10.0
        double from_factor = DEKAMETER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLIMETER
        // ====================
        // to_factor = 0.001
        to_factor = MILLIMETER.getFactor();
        msg = "-1 * (10 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DEKAMETER.toMillimeters(-1.0), delta);
        msg = "-0.1 * (10 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DEKAMETER.toMillimeters(-0.1), delta);
        msg = "-0.000456789 * (10 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DEKAMETER.toMillimeters(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DEKAMETER.toMillimeters(-73.25), delta);
        msg = "-56229.321 * (10 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DEKAMETER.toMillimeters(-56229.321), delta);
        msg = "-873.5432456 * (10 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DEKAMETER.toMillimeters(-873.5432456), delta);
        msg = "0 * (10 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DEKAMETER.toMillimeters(0.0), delta);
        msg = "0.1 * (10 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DEKAMETER.toMillimeters(0.1), delta);
        msg = "0.0000876543297 * (10 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DEKAMETER.toMillimeters(8.76543297E-5), delta);
        msg = "0.33 * (10 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DEKAMETER.toMillimeters(0.33), delta);
        msg = "0.6543 * (10 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DEKAMETER.toMillimeters(0.6543), delta);
        msg = "1 * (10 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DEKAMETER.toMillimeters(1.0), delta);
        msg = "1.6543 * (10 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DEKAMETER.toMillimeters(1.6543), delta);
        msg = "22.45 * (10 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DEKAMETER.toMillimeters(22.45), delta);
        msg = "9876.5432 * (10 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DEKAMETER.toMillimeters(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DEKAMETER.toMillimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DEKAMETER.toMillimeters(784.46789765434), delta);
        // ====================
        // ====================CENTIMETER
        // ====================
        // to_factor = 0.01
        to_factor = CENTIMETER.getFactor();
        msg = "-1 * (10 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DEKAMETER.toCentimeters(-1.0), delta);
        msg = "-0.1 * (10 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DEKAMETER.toCentimeters(-0.1), delta);
        msg = "-0.000456789 * (10 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DEKAMETER.toCentimeters(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DEKAMETER.toCentimeters(-73.25), delta);
        msg = "-56229.321 * (10 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DEKAMETER.toCentimeters(-56229.321), delta);
        msg = "-873.5432456 * (10 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DEKAMETER.toCentimeters(-873.5432456), delta);
        msg = "0 * (10 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DEKAMETER.toCentimeters(0.0), delta);
        msg = "0.1 * (10 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DEKAMETER.toCentimeters(0.1), delta);
        msg = "0.0000876543297 * (10 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DEKAMETER.toCentimeters(8.76543297E-5), delta);
        msg = "0.33 * (10 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DEKAMETER.toCentimeters(0.33), delta);
        msg = "0.6543 * (10 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DEKAMETER.toCentimeters(0.6543), delta);
        msg = "1 * (10 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DEKAMETER.toCentimeters(1.0), delta);
        msg = "1.6543 * (10 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DEKAMETER.toCentimeters(1.6543), delta);
        msg = "22.45 * (10 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DEKAMETER.toCentimeters(22.45), delta);
        msg = "9876.5432 * (10 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DEKAMETER.toCentimeters(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DEKAMETER.toCentimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DEKAMETER.toCentimeters(784.46789765434), delta);
        // ====================
        // ====================DECIMETER
        // ====================
        // to_factor = 0.1
        to_factor = DECIMETER.getFactor();
        msg = "-1 * (10 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DEKAMETER.toDecimeters(-1.0), delta);
        msg = "-0.1 * (10 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DEKAMETER.toDecimeters(-0.1), delta);
        msg = "-0.000456789 * (10 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DEKAMETER.toDecimeters(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DEKAMETER.toDecimeters(-73.25), delta);
        msg = "-56229.321 * (10 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DEKAMETER.toDecimeters(-56229.321), delta);
        msg = "-873.5432456 * (10 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DEKAMETER.toDecimeters(-873.5432456), delta);
        msg = "0 * (10 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DEKAMETER.toDecimeters(0.0), delta);
        msg = "0.1 * (10 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DEKAMETER.toDecimeters(0.1), delta);
        msg = "0.0000876543297 * (10 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DEKAMETER.toDecimeters(8.76543297E-5), delta);
        msg = "0.33 * (10 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DEKAMETER.toDecimeters(0.33), delta);
        msg = "0.6543 * (10 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DEKAMETER.toDecimeters(0.6543), delta);
        msg = "1 * (10 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DEKAMETER.toDecimeters(1.0), delta);
        msg = "1.6543 * (10 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DEKAMETER.toDecimeters(1.6543), delta);
        msg = "22.45 * (10 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DEKAMETER.toDecimeters(22.45), delta);
        msg = "9876.5432 * (10 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DEKAMETER.toDecimeters(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DEKAMETER.toDecimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DEKAMETER.toDecimeters(784.46789765434), delta);
        // ====================
        // ====================METER
        // ====================
        // to_factor = 1.0
        to_factor = METER.getFactor();
        msg = "-1 * (10 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DEKAMETER.toMeters(-1.0), delta);
        msg = "-0.1 * (10 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DEKAMETER.toMeters(-0.1), delta);
        msg = "-0.000456789 * (10 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DEKAMETER.toMeters(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DEKAMETER.toMeters(-73.25), delta);
        msg = "-56229.321 * (10 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DEKAMETER.toMeters(-56229.321), delta);
        msg = "-873.5432456 * (10 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DEKAMETER.toMeters(-873.5432456), delta);
        msg = "0 * (10 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DEKAMETER.toMeters(0.0), delta);
        msg = "0.1 * (10 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DEKAMETER.toMeters(0.1), delta);
        msg = "0.0000876543297 * (10 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DEKAMETER.toMeters(8.76543297E-5), delta);
        msg = "0.33 * (10 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DEKAMETER.toMeters(0.33), delta);
        msg = "0.6543 * (10 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DEKAMETER.toMeters(0.6543), delta);
        msg = "1 * (10 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DEKAMETER.toMeters(1.0), delta);
        msg = "1.6543 * (10 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DEKAMETER.toMeters(1.6543), delta);
        msg = "22.45 * (10 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DEKAMETER.toMeters(22.45), delta);
        msg = "9876.5432 * (10 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DEKAMETER.toMeters(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DEKAMETER.toMeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DEKAMETER.toMeters(784.46789765434), delta);
        // ====================
        // ====================DEKAMETER
        // ====================
        // to_factor = 10.0
        to_factor = DEKAMETER.getFactor();
        msg = "-1 * (10 / 10)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DEKAMETER.toDekameters(-1.0), delta);
        msg = "-0.1 * (10 / 10)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DEKAMETER.toDekameters(-0.1), delta);
        msg = "-0.000456789 * (10 / 10)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DEKAMETER.toDekameters(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 10)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DEKAMETER.toDekameters(-73.25), delta);
        msg = "-56229.321 * (10 / 10)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DEKAMETER.toDekameters(-56229.321), delta);
        msg = "-873.5432456 * (10 / 10)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DEKAMETER.toDekameters(-873.5432456), delta);
        msg = "0 * (10 / 10)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DEKAMETER.toDekameters(0.0), delta);
        msg = "0.1 * (10 / 10)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DEKAMETER.toDekameters(0.1), delta);
        msg = "0.0000876543297 * (10 / 10)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DEKAMETER.toDekameters(8.76543297E-5), delta);
        msg = "0.33 * (10 / 10)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DEKAMETER.toDekameters(0.33), delta);
        msg = "0.6543 * (10 / 10)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DEKAMETER.toDekameters(0.6543), delta);
        msg = "1 * (10 / 10)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DEKAMETER.toDekameters(1.0), delta);
        msg = "1.6543 * (10 / 10)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DEKAMETER.toDekameters(1.6543), delta);
        msg = "22.45 * (10 / 10)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DEKAMETER.toDekameters(22.45), delta);
        msg = "9876.5432 * (10 / 10)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DEKAMETER.toDekameters(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 10)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DEKAMETER.toDekameters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 10)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DEKAMETER.toDekameters(784.46789765434), delta);
        // ====================
        // ====================HECOMETER
        // ====================
        // to_factor = 100.0
        to_factor = HECOMETER.getFactor();
        msg = "-1 / (100 / 10)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DEKAMETER.toHecometers(-1.0), delta);
        msg = "-0.1 / (100 / 10)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DEKAMETER.toHecometers(-0.1), delta);
        msg = "-0.000456789 / (100 / 10)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DEKAMETER.toHecometers(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 10)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DEKAMETER.toHecometers(-73.25), delta);
        msg = "-56229.321 / (100 / 10)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DEKAMETER.toHecometers(-56229.321), delta);
        msg = "-873.5432456 / (100 / 10)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DEKAMETER.toHecometers(-873.5432456), delta);
        msg = "0 / (100 / 10)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DEKAMETER.toHecometers(0.0), delta);
        msg = "0.1 / (100 / 10)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DEKAMETER.toHecometers(0.1), delta);
        msg = "0.0000876543297 / (100 / 10)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DEKAMETER.toHecometers(8.76543297E-5), delta);
        msg = "0.33 / (100 / 10)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DEKAMETER.toHecometers(0.33), delta);
        msg = "0.6543 / (100 / 10)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DEKAMETER.toHecometers(0.6543), delta);
        msg = "1 / (100 / 10)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DEKAMETER.toHecometers(1.0), delta);
        msg = "1.6543 / (100 / 10)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DEKAMETER.toHecometers(1.6543), delta);
        msg = "22.45 / (100 / 10)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DEKAMETER.toHecometers(22.45), delta);
        msg = "9876.5432 / (100 / 10)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DEKAMETER.toHecometers(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 10)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DEKAMETER.toHecometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 10)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DEKAMETER.toHecometers(784.46789765434), delta);
        // ====================
        // ====================KILOMETER
        // ====================
        // to_factor = 1000.0
        to_factor = KILOMETER.getFactor();
        msg = "-1 / (1000 / 10)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DEKAMETER.toKilometers(-1.0), delta);
        msg = "-0.1 / (1000 / 10)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DEKAMETER.toKilometers(-0.1), delta);
        msg = "-0.000456789 / (1000 / 10)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DEKAMETER.toKilometers(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 10)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DEKAMETER.toKilometers(-73.25), delta);
        msg = "-56229.321 / (1000 / 10)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DEKAMETER.toKilometers(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 10)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DEKAMETER.toKilometers(-873.5432456), delta);
        msg = "0 / (1000 / 10)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DEKAMETER.toKilometers(0.0), delta);
        msg = "0.1 / (1000 / 10)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DEKAMETER.toKilometers(0.1), delta);
        msg = "0.0000876543297 / (1000 / 10)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DEKAMETER.toKilometers(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 10)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DEKAMETER.toKilometers(0.33), delta);
        msg = "0.6543 / (1000 / 10)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DEKAMETER.toKilometers(0.6543), delta);
        msg = "1 / (1000 / 10)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DEKAMETER.toKilometers(1.0), delta);
        msg = "1.6543 / (1000 / 10)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DEKAMETER.toKilometers(1.6543), delta);
        msg = "22.45 / (1000 / 10)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DEKAMETER.toKilometers(22.45), delta);
        msg = "9876.5432 / (1000 / 10)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DEKAMETER.toKilometers(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 10)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DEKAMETER.toKilometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 10)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DEKAMETER.toKilometers(784.46789765434), delta);
    }

    @Test()
    public void testHecometer() {
        // from_factor = 100.0
        double from_factor = HECOMETER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLIMETER
        // ====================
        // to_factor = 0.001
        to_factor = MILLIMETER.getFactor();
        msg = "-1 * (100 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HECOMETER.toMillimeters(-1.0), delta);
        msg = "-0.1 * (100 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HECOMETER.toMillimeters(-0.1), delta);
        msg = "-0.000456789 * (100 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HECOMETER.toMillimeters(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HECOMETER.toMillimeters(-73.25), delta);
        msg = "-56229.321 * (100 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HECOMETER.toMillimeters(-56229.321), delta);
        msg = "-873.5432456 * (100 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HECOMETER.toMillimeters(-873.5432456), delta);
        msg = "0 * (100 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HECOMETER.toMillimeters(0.0), delta);
        msg = "0.1 * (100 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HECOMETER.toMillimeters(0.1), delta);
        msg = "0.0000876543297 * (100 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HECOMETER.toMillimeters(8.76543297E-5), delta);
        msg = "0.33 * (100 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HECOMETER.toMillimeters(0.33), delta);
        msg = "0.6543 * (100 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HECOMETER.toMillimeters(0.6543), delta);
        msg = "1 * (100 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HECOMETER.toMillimeters(1.0), delta);
        msg = "1.6543 * (100 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HECOMETER.toMillimeters(1.6543), delta);
        msg = "22.45 * (100 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HECOMETER.toMillimeters(22.45), delta);
        msg = "9876.5432 * (100 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HECOMETER.toMillimeters(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HECOMETER.toMillimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HECOMETER.toMillimeters(784.46789765434), delta);
        // ====================
        // ====================CENTIMETER
        // ====================
        // to_factor = 0.01
        to_factor = CENTIMETER.getFactor();
        msg = "-1 * (100 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HECOMETER.toCentimeters(-1.0), delta);
        msg = "-0.1 * (100 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HECOMETER.toCentimeters(-0.1), delta);
        msg = "-0.000456789 * (100 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HECOMETER.toCentimeters(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HECOMETER.toCentimeters(-73.25), delta);
        msg = "-56229.321 * (100 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HECOMETER.toCentimeters(-56229.321), delta);
        msg = "-873.5432456 * (100 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HECOMETER.toCentimeters(-873.5432456), delta);
        msg = "0 * (100 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HECOMETER.toCentimeters(0.0), delta);
        msg = "0.1 * (100 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HECOMETER.toCentimeters(0.1), delta);
        msg = "0.0000876543297 * (100 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HECOMETER.toCentimeters(8.76543297E-5), delta);
        msg = "0.33 * (100 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HECOMETER.toCentimeters(0.33), delta);
        msg = "0.6543 * (100 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HECOMETER.toCentimeters(0.6543), delta);
        msg = "1 * (100 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HECOMETER.toCentimeters(1.0), delta);
        msg = "1.6543 * (100 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HECOMETER.toCentimeters(1.6543), delta);
        msg = "22.45 * (100 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HECOMETER.toCentimeters(22.45), delta);
        msg = "9876.5432 * (100 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HECOMETER.toCentimeters(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HECOMETER.toCentimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HECOMETER.toCentimeters(784.46789765434), delta);
        // ====================
        // ====================DECIMETER
        // ====================
        // to_factor = 0.1
        to_factor = DECIMETER.getFactor();
        msg = "-1 * (100 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HECOMETER.toDecimeters(-1.0), delta);
        msg = "-0.1 * (100 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HECOMETER.toDecimeters(-0.1), delta);
        msg = "-0.000456789 * (100 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HECOMETER.toDecimeters(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HECOMETER.toDecimeters(-73.25), delta);
        msg = "-56229.321 * (100 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HECOMETER.toDecimeters(-56229.321), delta);
        msg = "-873.5432456 * (100 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HECOMETER.toDecimeters(-873.5432456), delta);
        msg = "0 * (100 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HECOMETER.toDecimeters(0.0), delta);
        msg = "0.1 * (100 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HECOMETER.toDecimeters(0.1), delta);
        msg = "0.0000876543297 * (100 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HECOMETER.toDecimeters(8.76543297E-5), delta);
        msg = "0.33 * (100 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HECOMETER.toDecimeters(0.33), delta);
        msg = "0.6543 * (100 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HECOMETER.toDecimeters(0.6543), delta);
        msg = "1 * (100 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HECOMETER.toDecimeters(1.0), delta);
        msg = "1.6543 * (100 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HECOMETER.toDecimeters(1.6543), delta);
        msg = "22.45 * (100 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HECOMETER.toDecimeters(22.45), delta);
        msg = "9876.5432 * (100 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HECOMETER.toDecimeters(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HECOMETER.toDecimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HECOMETER.toDecimeters(784.46789765434), delta);
        // ====================
        // ====================METER
        // ====================
        // to_factor = 1.0
        to_factor = METER.getFactor();
        msg = "-1 * (100 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HECOMETER.toMeters(-1.0), delta);
        msg = "-0.1 * (100 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HECOMETER.toMeters(-0.1), delta);
        msg = "-0.000456789 * (100 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HECOMETER.toMeters(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HECOMETER.toMeters(-73.25), delta);
        msg = "-56229.321 * (100 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HECOMETER.toMeters(-56229.321), delta);
        msg = "-873.5432456 * (100 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HECOMETER.toMeters(-873.5432456), delta);
        msg = "0 * (100 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HECOMETER.toMeters(0.0), delta);
        msg = "0.1 * (100 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HECOMETER.toMeters(0.1), delta);
        msg = "0.0000876543297 * (100 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HECOMETER.toMeters(8.76543297E-5), delta);
        msg = "0.33 * (100 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HECOMETER.toMeters(0.33), delta);
        msg = "0.6543 * (100 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HECOMETER.toMeters(0.6543), delta);
        msg = "1 * (100 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HECOMETER.toMeters(1.0), delta);
        msg = "1.6543 * (100 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HECOMETER.toMeters(1.6543), delta);
        msg = "22.45 * (100 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HECOMETER.toMeters(22.45), delta);
        msg = "9876.5432 * (100 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HECOMETER.toMeters(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HECOMETER.toMeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HECOMETER.toMeters(784.46789765434), delta);
        // ====================
        // ====================DEKAMETER
        // ====================
        // to_factor = 10.0
        to_factor = DEKAMETER.getFactor();
        msg = "-1 * (100 / 10)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HECOMETER.toDekameters(-1.0), delta);
        msg = "-0.1 * (100 / 10)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HECOMETER.toDekameters(-0.1), delta);
        msg = "-0.000456789 * (100 / 10)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HECOMETER.toDekameters(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 10)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HECOMETER.toDekameters(-73.25), delta);
        msg = "-56229.321 * (100 / 10)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HECOMETER.toDekameters(-56229.321), delta);
        msg = "-873.5432456 * (100 / 10)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HECOMETER.toDekameters(-873.5432456), delta);
        msg = "0 * (100 / 10)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HECOMETER.toDekameters(0.0), delta);
        msg = "0.1 * (100 / 10)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HECOMETER.toDekameters(0.1), delta);
        msg = "0.0000876543297 * (100 / 10)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HECOMETER.toDekameters(8.76543297E-5), delta);
        msg = "0.33 * (100 / 10)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HECOMETER.toDekameters(0.33), delta);
        msg = "0.6543 * (100 / 10)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HECOMETER.toDekameters(0.6543), delta);
        msg = "1 * (100 / 10)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HECOMETER.toDekameters(1.0), delta);
        msg = "1.6543 * (100 / 10)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HECOMETER.toDekameters(1.6543), delta);
        msg = "22.45 * (100 / 10)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HECOMETER.toDekameters(22.45), delta);
        msg = "9876.5432 * (100 / 10)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HECOMETER.toDekameters(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 10)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HECOMETER.toDekameters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 10)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HECOMETER.toDekameters(784.46789765434), delta);
        // ====================
        // ====================HECOMETER
        // ====================
        // to_factor = 100.0
        to_factor = HECOMETER.getFactor();
        msg = "-1 * (100 / 100)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HECOMETER.toHecometers(-1.0), delta);
        msg = "-0.1 * (100 / 100)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HECOMETER.toHecometers(-0.1), delta);
        msg = "-0.000456789 * (100 / 100)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HECOMETER.toHecometers(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 100)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HECOMETER.toHecometers(-73.25), delta);
        msg = "-56229.321 * (100 / 100)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HECOMETER.toHecometers(-56229.321), delta);
        msg = "-873.5432456 * (100 / 100)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HECOMETER.toHecometers(-873.5432456), delta);
        msg = "0 * (100 / 100)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HECOMETER.toHecometers(0.0), delta);
        msg = "0.1 * (100 / 100)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HECOMETER.toHecometers(0.1), delta);
        msg = "0.0000876543297 * (100 / 100)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HECOMETER.toHecometers(8.76543297E-5), delta);
        msg = "0.33 * (100 / 100)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HECOMETER.toHecometers(0.33), delta);
        msg = "0.6543 * (100 / 100)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HECOMETER.toHecometers(0.6543), delta);
        msg = "1 * (100 / 100)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HECOMETER.toHecometers(1.0), delta);
        msg = "1.6543 * (100 / 100)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HECOMETER.toHecometers(1.6543), delta);
        msg = "22.45 * (100 / 100)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HECOMETER.toHecometers(22.45), delta);
        msg = "9876.5432 * (100 / 100)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HECOMETER.toHecometers(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 100)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HECOMETER.toHecometers(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 100)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HECOMETER.toHecometers(784.46789765434), delta);
        // ====================
        // ====================KILOMETER
        // ====================
        // to_factor = 1000.0
        to_factor = KILOMETER.getFactor();
        msg = "-1 / (1000 / 100)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), HECOMETER.toKilometers(-1.0), delta);
        msg = "-0.1 / (1000 / 100)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), HECOMETER.toKilometers(-0.1), delta);
        msg = "-0.000456789 / (1000 / 100)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), HECOMETER.toKilometers(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 100)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), HECOMETER.toKilometers(-73.25), delta);
        msg = "-56229.321 / (1000 / 100)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), HECOMETER.toKilometers(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 100)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), HECOMETER.toKilometers(-873.5432456), delta);
        msg = "0 / (1000 / 100)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), HECOMETER.toKilometers(0.0), delta);
        msg = "0.1 / (1000 / 100)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), HECOMETER.toKilometers(0.1), delta);
        msg = "0.0000876543297 / (1000 / 100)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), HECOMETER.toKilometers(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 100)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), HECOMETER.toKilometers(0.33), delta);
        msg = "0.6543 / (1000 / 100)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), HECOMETER.toKilometers(0.6543), delta);
        msg = "1 / (1000 / 100)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), HECOMETER.toKilometers(1.0), delta);
        msg = "1.6543 / (1000 / 100)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), HECOMETER.toKilometers(1.6543), delta);
        msg = "22.45 / (1000 / 100)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), HECOMETER.toKilometers(22.45), delta);
        msg = "9876.5432 / (1000 / 100)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), HECOMETER.toKilometers(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 100)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), HECOMETER.toKilometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 100)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), HECOMETER.toKilometers(784.46789765434), delta);
    }

    @Test()
    public void testKilometer() {
        // from_factor = 1000.0
        double from_factor = KILOMETER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLIMETER
        // ====================
        // to_factor = 0.001
        to_factor = MILLIMETER.getFactor();
        msg = "-1 * (1000 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOMETER.toMillimeters(-1.0), delta);
        msg = "-0.1 * (1000 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOMETER.toMillimeters(-0.1), delta);
        msg = "-0.000456789 * (1000 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOMETER.toMillimeters(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOMETER.toMillimeters(-73.25), delta);
        msg = "-56229.321 * (1000 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOMETER.toMillimeters(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOMETER.toMillimeters(-873.5432456), delta);
        msg = "0 * (1000 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOMETER.toMillimeters(0.0), delta);
        msg = "0.1 * (1000 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOMETER.toMillimeters(0.1), delta);
        msg = "0.0000876543297 * (1000 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOMETER.toMillimeters(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOMETER.toMillimeters(0.33), delta);
        msg = "0.6543 * (1000 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOMETER.toMillimeters(0.6543), delta);
        msg = "1 * (1000 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOMETER.toMillimeters(1.0), delta);
        msg = "1.6543 * (1000 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOMETER.toMillimeters(1.6543), delta);
        msg = "22.45 * (1000 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOMETER.toMillimeters(22.45), delta);
        msg = "9876.5432 * (1000 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOMETER.toMillimeters(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOMETER.toMillimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOMETER.toMillimeters(784.46789765434), delta);
        // ====================
        // ====================CENTIMETER
        // ====================
        // to_factor = 0.01
        to_factor = CENTIMETER.getFactor();
        msg = "-1 * (1000 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOMETER.toCentimeters(-1.0), delta);
        msg = "-0.1 * (1000 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOMETER.toCentimeters(-0.1), delta);
        msg = "-0.000456789 * (1000 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOMETER.toCentimeters(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOMETER.toCentimeters(-73.25), delta);
        msg = "-56229.321 * (1000 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOMETER.toCentimeters(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOMETER.toCentimeters(-873.5432456), delta);
        msg = "0 * (1000 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOMETER.toCentimeters(0.0), delta);
        msg = "0.1 * (1000 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOMETER.toCentimeters(0.1), delta);
        msg = "0.0000876543297 * (1000 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOMETER.toCentimeters(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOMETER.toCentimeters(0.33), delta);
        msg = "0.6543 * (1000 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOMETER.toCentimeters(0.6543), delta);
        msg = "1 * (1000 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOMETER.toCentimeters(1.0), delta);
        msg = "1.6543 * (1000 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOMETER.toCentimeters(1.6543), delta);
        msg = "22.45 * (1000 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOMETER.toCentimeters(22.45), delta);
        msg = "9876.5432 * (1000 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOMETER.toCentimeters(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOMETER.toCentimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOMETER.toCentimeters(784.46789765434), delta);
        // ====================
        // ====================DECIMETER
        // ====================
        // to_factor = 0.1
        to_factor = DECIMETER.getFactor();
        msg = "-1 * (1000 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOMETER.toDecimeters(-1.0), delta);
        msg = "-0.1 * (1000 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOMETER.toDecimeters(-0.1), delta);
        msg = "-0.000456789 * (1000 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOMETER.toDecimeters(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOMETER.toDecimeters(-73.25), delta);
        msg = "-56229.321 * (1000 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOMETER.toDecimeters(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOMETER.toDecimeters(-873.5432456), delta);
        msg = "0 * (1000 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOMETER.toDecimeters(0.0), delta);
        msg = "0.1 * (1000 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOMETER.toDecimeters(0.1), delta);
        msg = "0.0000876543297 * (1000 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOMETER.toDecimeters(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOMETER.toDecimeters(0.33), delta);
        msg = "0.6543 * (1000 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOMETER.toDecimeters(0.6543), delta);
        msg = "1 * (1000 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOMETER.toDecimeters(1.0), delta);
        msg = "1.6543 * (1000 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOMETER.toDecimeters(1.6543), delta);
        msg = "22.45 * (1000 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOMETER.toDecimeters(22.45), delta);
        msg = "9876.5432 * (1000 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOMETER.toDecimeters(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOMETER.toDecimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOMETER.toDecimeters(784.46789765434), delta);
        // ====================
        // ====================METER
        // ====================
        // to_factor = 1.0
        to_factor = METER.getFactor();
        msg = "-1 * (1000 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOMETER.toMeters(-1.0), delta);
        msg = "-0.1 * (1000 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOMETER.toMeters(-0.1), delta);
        msg = "-0.000456789 * (1000 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOMETER.toMeters(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOMETER.toMeters(-73.25), delta);
        msg = "-56229.321 * (1000 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOMETER.toMeters(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOMETER.toMeters(-873.5432456), delta);
        msg = "0 * (1000 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOMETER.toMeters(0.0), delta);
        msg = "0.1 * (1000 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOMETER.toMeters(0.1), delta);
        msg = "0.0000876543297 * (1000 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOMETER.toMeters(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOMETER.toMeters(0.33), delta);
        msg = "0.6543 * (1000 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOMETER.toMeters(0.6543), delta);
        msg = "1 * (1000 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOMETER.toMeters(1.0), delta);
        msg = "1.6543 * (1000 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOMETER.toMeters(1.6543), delta);
        msg = "22.45 * (1000 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOMETER.toMeters(22.45), delta);
        msg = "9876.5432 * (1000 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOMETER.toMeters(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOMETER.toMeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOMETER.toMeters(784.46789765434), delta);
        // ====================
        // ====================DEKAMETER
        // ====================
        // to_factor = 10.0
        to_factor = DEKAMETER.getFactor();
        msg = "-1 * (1000 / 10)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOMETER.toDekameters(-1.0), delta);
        msg = "-0.1 * (1000 / 10)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOMETER.toDekameters(-0.1), delta);
        msg = "-0.000456789 * (1000 / 10)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOMETER.toDekameters(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 10)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOMETER.toDekameters(-73.25), delta);
        msg = "-56229.321 * (1000 / 10)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOMETER.toDekameters(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 10)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOMETER.toDekameters(-873.5432456), delta);
        msg = "0 * (1000 / 10)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOMETER.toDekameters(0.0), delta);
        msg = "0.1 * (1000 / 10)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOMETER.toDekameters(0.1), delta);
        msg = "0.0000876543297 * (1000 / 10)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOMETER.toDekameters(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 10)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOMETER.toDekameters(0.33), delta);
        msg = "0.6543 * (1000 / 10)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOMETER.toDekameters(0.6543), delta);
        msg = "1 * (1000 / 10)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOMETER.toDekameters(1.0), delta);
        msg = "1.6543 * (1000 / 10)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOMETER.toDekameters(1.6543), delta);
        msg = "22.45 * (1000 / 10)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOMETER.toDekameters(22.45), delta);
        msg = "9876.5432 * (1000 / 10)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOMETER.toDekameters(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 10)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOMETER.toDekameters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 10)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOMETER.toDekameters(784.46789765434), delta);
        // ====================
        // ====================HECOMETER
        // ====================
        // to_factor = 100.0
        to_factor = HECOMETER.getFactor();
        msg = "-1 * (1000 / 100)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOMETER.toHecometers(-1.0), delta);
        msg = "-0.1 * (1000 / 100)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOMETER.toHecometers(-0.1), delta);
        msg = "-0.000456789 * (1000 / 100)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOMETER.toHecometers(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 100)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOMETER.toHecometers(-73.25), delta);
        msg = "-56229.321 * (1000 / 100)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOMETER.toHecometers(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 100)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOMETER.toHecometers(-873.5432456), delta);
        msg = "0 * (1000 / 100)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOMETER.toHecometers(0.0), delta);
        msg = "0.1 * (1000 / 100)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOMETER.toHecometers(0.1), delta);
        msg = "0.0000876543297 * (1000 / 100)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOMETER.toHecometers(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 100)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOMETER.toHecometers(0.33), delta);
        msg = "0.6543 * (1000 / 100)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOMETER.toHecometers(0.6543), delta);
        msg = "1 * (1000 / 100)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOMETER.toHecometers(1.0), delta);
        msg = "1.6543 * (1000 / 100)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOMETER.toHecometers(1.6543), delta);
        msg = "22.45 * (1000 / 100)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOMETER.toHecometers(22.45), delta);
        msg = "9876.5432 * (1000 / 100)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOMETER.toHecometers(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 100)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOMETER.toHecometers(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 100)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOMETER.toHecometers(784.46789765434), delta);
        // ====================
        // ====================KILOMETER
        // ====================
        // to_factor = 1000.0
        to_factor = KILOMETER.getFactor();
        msg = "-1 * (1000 / 1000)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOMETER.toKilometers(-1.0), delta);
        msg = "-0.1 * (1000 / 1000)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOMETER.toKilometers(-0.1), delta);
        msg = "-0.000456789 * (1000 / 1000)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOMETER.toKilometers(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 1000)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOMETER.toKilometers(-73.25), delta);
        msg = "-56229.321 * (1000 / 1000)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOMETER.toKilometers(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 1000)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOMETER.toKilometers(-873.5432456), delta);
        msg = "0 * (1000 / 1000)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOMETER.toKilometers(0.0), delta);
        msg = "0.1 * (1000 / 1000)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOMETER.toKilometers(0.1), delta);
        msg = "0.0000876543297 * (1000 / 1000)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOMETER.toKilometers(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 1000)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOMETER.toKilometers(0.33), delta);
        msg = "0.6543 * (1000 / 1000)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOMETER.toKilometers(0.6543), delta);
        msg = "1 * (1000 / 1000)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOMETER.toKilometers(1.0), delta);
        msg = "1.6543 * (1000 / 1000)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOMETER.toKilometers(1.6543), delta);
        msg = "22.45 * (1000 / 1000)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOMETER.toKilometers(22.45), delta);
        msg = "9876.5432 * (1000 / 1000)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOMETER.toKilometers(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 1000)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOMETER.toKilometers(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 1000)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOMETER.toKilometers(784.46789765434), delta);
    }
}
