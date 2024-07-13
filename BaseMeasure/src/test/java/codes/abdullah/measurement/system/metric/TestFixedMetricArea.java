package codes.abdullah.measurement.system.metric;

import static codes.abdullah.measurement.system.metric.Metrics.SQUARE_CENTIMETER;
import static codes.abdullah.measurement.system.metric.Metrics.SQUARE_DECIMETER;
import static codes.abdullah.measurement.system.metric.Metrics.SQUARE_DEKAMETER;
import static codes.abdullah.measurement.system.metric.Metrics.SQUARE_HECOMETER;
import static codes.abdullah.measurement.system.metric.Metrics.SQUARE_KILOMETER;
import static codes.abdullah.measurement.system.metric.Metrics.SQUARE_METER;
import static codes.abdullah.measurement.system.metric.Metrics.SQUARE_MILLIMETER;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFixedMetricArea {

    @Test()
    public void testSquareMillimeter() {
        // from_factor = 0.001
        double from_factor = SQUARE_MILLIMETER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SQUARE_MILLIMETER
        // ====================
        // to_factor = 0.001
        to_factor = SQUARE_MILLIMETER.getFactor();
        msg = "-1 * (0.001 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_MILLIMETER.toSquareMillimeters(-1.0), delta);
        msg = "-0.1 * (0.001 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_MILLIMETER.toSquareMillimeters(-0.1), delta);
        msg = "-0.000456789 * (0.001 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_MILLIMETER.toSquareMillimeters(-4.56789E-4), delta);
        msg = "-73.25 * (0.001 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_MILLIMETER.toSquareMillimeters(-73.25), delta);
        msg = "-56229.321 * (0.001 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_MILLIMETER.toSquareMillimeters(-56229.321), delta);
        msg = "-873.5432456 * (0.001 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_MILLIMETER.toSquareMillimeters(-873.5432456), delta);
        msg = "0 * (0.001 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_MILLIMETER.toSquareMillimeters(0.0), delta);
        msg = "0.1 * (0.001 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_MILLIMETER.toSquareMillimeters(0.1), delta);
        msg = "0.0000876543297 * (0.001 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_MILLIMETER.toSquareMillimeters(8.76543297E-5), delta);
        msg = "0.33 * (0.001 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_MILLIMETER.toSquareMillimeters(0.33), delta);
        msg = "0.6543 * (0.001 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_MILLIMETER.toSquareMillimeters(0.6543), delta);
        msg = "1 * (0.001 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_MILLIMETER.toSquareMillimeters(1.0), delta);
        msg = "1.6543 * (0.001 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_MILLIMETER.toSquareMillimeters(1.6543), delta);
        msg = "22.45 * (0.001 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_MILLIMETER.toSquareMillimeters(22.45), delta);
        msg = "9876.5432 * (0.001 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_MILLIMETER.toSquareMillimeters(9876.5432), delta);
        msg = "1987654344.3345 * (0.001 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_MILLIMETER.toSquareMillimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.001 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_MILLIMETER.toSquareMillimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_CENTIMETER
        // ====================
        // to_factor = 0.01
        to_factor = SQUARE_CENTIMETER.getFactor();
        msg = "-1 / (0.01 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareCentimeters(-1.0), delta);
        msg = "-0.1 / (0.01 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareCentimeters(-0.1), delta);
        msg = "-0.000456789 / (0.01 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareCentimeters(-4.56789E-4), delta);
        msg = "-73.25 / (0.01 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareCentimeters(-73.25), delta);
        msg = "-56229.321 / (0.01 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareCentimeters(-56229.321), delta);
        msg = "-873.5432456 / (0.01 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareCentimeters(-873.5432456), delta);
        msg = "0 / (0.01 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareCentimeters(0.0), delta);
        msg = "0.1 / (0.01 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareCentimeters(0.1), delta);
        msg = "0.0000876543297 / (0.01 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareCentimeters(8.76543297E-5), delta);
        msg = "0.33 / (0.01 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareCentimeters(0.33), delta);
        msg = "0.6543 / (0.01 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareCentimeters(0.6543), delta);
        msg = "1 / (0.01 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareCentimeters(1.0), delta);
        msg = "1.6543 / (0.01 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareCentimeters(1.6543), delta);
        msg = "22.45 / (0.01 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareCentimeters(22.45), delta);
        msg = "9876.5432 / (0.01 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareCentimeters(9876.5432), delta);
        msg = "1987654344.3345 / (0.01 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareCentimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.01 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareCentimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_DECIMETER
        // ====================
        // to_factor = 0.1
        to_factor = SQUARE_DECIMETER.getFactor();
        msg = "-1 / (0.1 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDecimeters(-1.0), delta);
        msg = "-0.1 / (0.1 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDecimeters(-0.1), delta);
        msg = "-0.000456789 / (0.1 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDecimeters(-4.56789E-4), delta);
        msg = "-73.25 / (0.1 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDecimeters(-73.25), delta);
        msg = "-56229.321 / (0.1 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDecimeters(-56229.321), delta);
        msg = "-873.5432456 / (0.1 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDecimeters(-873.5432456), delta);
        msg = "0 / (0.1 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDecimeters(0.0), delta);
        msg = "0.1 / (0.1 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDecimeters(0.1), delta);
        msg = "0.0000876543297 / (0.1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDecimeters(8.76543297E-5), delta);
        msg = "0.33 / (0.1 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDecimeters(0.33), delta);
        msg = "0.6543 / (0.1 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDecimeters(0.6543), delta);
        msg = "1 / (0.1 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDecimeters(1.0), delta);
        msg = "1.6543 / (0.1 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDecimeters(1.6543), delta);
        msg = "22.45 / (0.1 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDecimeters(22.45), delta);
        msg = "9876.5432 / (0.1 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDecimeters(9876.5432), delta);
        msg = "1987654344.3345 / (0.1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDecimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.1 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDecimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_METER
        // ====================
        // to_factor = 1.0
        to_factor = SQUARE_METER.getFactor();
        msg = "-1 / (1 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareMeters(-1.0), delta);
        msg = "-0.1 / (1 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareMeters(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareMeters(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareMeters(-73.25), delta);
        msg = "-56229.321 / (1 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareMeters(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareMeters(-873.5432456), delta);
        msg = "0 / (1 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareMeters(0.0), delta);
        msg = "0.1 / (1 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareMeters(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareMeters(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareMeters(0.33), delta);
        msg = "0.6543 / (1 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareMeters(0.6543), delta);
        msg = "1 / (1 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareMeters(1.0), delta);
        msg = "1.6543 / (1 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareMeters(1.6543), delta);
        msg = "22.45 / (1 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareMeters(22.45), delta);
        msg = "9876.5432 / (1 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareMeters(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareMeters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareMeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_DEKAMETER
        // ====================
        // to_factor = 10.0
        to_factor = SQUARE_DEKAMETER.getFactor();
        msg = "-1 / (10 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDekameters(-1.0), delta);
        msg = "-0.1 / (10 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDekameters(-0.1), delta);
        msg = "-0.000456789 / (10 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDekameters(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDekameters(-73.25), delta);
        msg = "-56229.321 / (10 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDekameters(-56229.321), delta);
        msg = "-873.5432456 / (10 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDekameters(-873.5432456), delta);
        msg = "0 / (10 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDekameters(0.0), delta);
        msg = "0.1 / (10 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDekameters(0.1), delta);
        msg = "0.0000876543297 / (10 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDekameters(8.76543297E-5), delta);
        msg = "0.33 / (10 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDekameters(0.33), delta);
        msg = "0.6543 / (10 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDekameters(0.6543), delta);
        msg = "1 / (10 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDekameters(1.0), delta);
        msg = "1.6543 / (10 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDekameters(1.6543), delta);
        msg = "22.45 / (10 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDekameters(22.45), delta);
        msg = "9876.5432 / (10 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDekameters(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDekameters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDekameters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_HECOMETER
        // ====================
        // to_factor = 100.0
        to_factor = SQUARE_HECOMETER.getFactor();
        msg = "-1 / (100 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareHecometers(-1.0), delta);
        msg = "-0.1 / (100 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareHecometers(-0.1), delta);
        msg = "-0.000456789 / (100 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareHecometers(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareHecometers(-73.25), delta);
        msg = "-56229.321 / (100 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareHecometers(-56229.321), delta);
        msg = "-873.5432456 / (100 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareHecometers(-873.5432456), delta);
        msg = "0 / (100 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareHecometers(0.0), delta);
        msg = "0.1 / (100 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareHecometers(0.1), delta);
        msg = "0.0000876543297 / (100 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareHecometers(8.76543297E-5), delta);
        msg = "0.33 / (100 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareHecometers(0.33), delta);
        msg = "0.6543 / (100 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareHecometers(0.6543), delta);
        msg = "1 / (100 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareHecometers(1.0), delta);
        msg = "1.6543 / (100 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareHecometers(1.6543), delta);
        msg = "22.45 / (100 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareHecometers(22.45), delta);
        msg = "9876.5432 / (100 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareHecometers(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareHecometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareHecometers(784.46789765434), delta);
        // ====================
        // ====================SQUARE_KILOMETER
        // ====================
        // to_factor = 1000.0
        to_factor = SQUARE_KILOMETER.getFactor();
        msg = "-1 / (1000 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareKilometers(-1.0), delta);
        msg = "-0.1 / (1000 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareKilometers(-0.1), delta);
        msg = "-0.000456789 / (1000 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareKilometers(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareKilometers(-73.25), delta);
        msg = "-56229.321 / (1000 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareKilometers(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareKilometers(-873.5432456), delta);
        msg = "0 / (1000 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareKilometers(0.0), delta);
        msg = "0.1 / (1000 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareKilometers(0.1), delta);
        msg = "0.0000876543297 / (1000 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareKilometers(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareKilometers(0.33), delta);
        msg = "0.6543 / (1000 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareKilometers(0.6543), delta);
        msg = "1 / (1000 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareKilometers(1.0), delta);
        msg = "1.6543 / (1000 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareKilometers(1.6543), delta);
        msg = "22.45 / (1000 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareKilometers(22.45), delta);
        msg = "9876.5432 / (1000 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareKilometers(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareKilometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareKilometers(784.46789765434), delta);
    }

    @Test()
    public void testSquareCentimeter() {
        // from_factor = 0.01
        double from_factor = SQUARE_CENTIMETER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SQUARE_MILLIMETER
        // ====================
        // to_factor = 0.001
        to_factor = SQUARE_MILLIMETER.getFactor();
        msg = "-1 * (0.01 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareMillimeters(-1.0), delta);
        msg = "-0.1 * (0.01 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareMillimeters(-0.1), delta);
        msg = "-0.000456789 * (0.01 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareMillimeters(-4.56789E-4), delta);
        msg = "-73.25 * (0.01 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareMillimeters(-73.25), delta);
        msg = "-56229.321 * (0.01 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareMillimeters(-56229.321), delta);
        msg = "-873.5432456 * (0.01 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareMillimeters(-873.5432456), delta);
        msg = "0 * (0.01 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareMillimeters(0.0), delta);
        msg = "0.1 * (0.01 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareMillimeters(0.1), delta);
        msg = "0.0000876543297 * (0.01 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareMillimeters(8.76543297E-5), delta);
        msg = "0.33 * (0.01 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareMillimeters(0.33), delta);
        msg = "0.6543 * (0.01 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareMillimeters(0.6543), delta);
        msg = "1 * (0.01 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareMillimeters(1.0), delta);
        msg = "1.6543 * (0.01 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareMillimeters(1.6543), delta);
        msg = "22.45 * (0.01 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareMillimeters(22.45), delta);
        msg = "9876.5432 * (0.01 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareMillimeters(9876.5432), delta);
        msg = "1987654344.3345 * (0.01 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareMillimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.01 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareMillimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_CENTIMETER
        // ====================
        // to_factor = 0.01
        to_factor = SQUARE_CENTIMETER.getFactor();
        msg = "-1 * (0.01 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareCentimeters(-1.0), delta);
        msg = "-0.1 * (0.01 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareCentimeters(-0.1), delta);
        msg = "-0.000456789 * (0.01 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareCentimeters(-4.56789E-4), delta);
        msg = "-73.25 * (0.01 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareCentimeters(-73.25), delta);
        msg = "-56229.321 * (0.01 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareCentimeters(-56229.321), delta);
        msg = "-873.5432456 * (0.01 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareCentimeters(-873.5432456), delta);
        msg = "0 * (0.01 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareCentimeters(0.0), delta);
        msg = "0.1 * (0.01 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareCentimeters(0.1), delta);
        msg = "0.0000876543297 * (0.01 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareCentimeters(8.76543297E-5), delta);
        msg = "0.33 * (0.01 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareCentimeters(0.33), delta);
        msg = "0.6543 * (0.01 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareCentimeters(0.6543), delta);
        msg = "1 * (0.01 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareCentimeters(1.0), delta);
        msg = "1.6543 * (0.01 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareCentimeters(1.6543), delta);
        msg = "22.45 * (0.01 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareCentimeters(22.45), delta);
        msg = "9876.5432 * (0.01 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareCentimeters(9876.5432), delta);
        msg = "1987654344.3345 * (0.01 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareCentimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.01 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareCentimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_DECIMETER
        // ====================
        // to_factor = 0.1
        to_factor = SQUARE_DECIMETER.getFactor();
        msg = "-1 / (0.1 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDecimeters(-1.0), delta);
        msg = "-0.1 / (0.1 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDecimeters(-0.1), delta);
        msg = "-0.000456789 / (0.1 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDecimeters(-4.56789E-4), delta);
        msg = "-73.25 / (0.1 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDecimeters(-73.25), delta);
        msg = "-56229.321 / (0.1 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDecimeters(-56229.321), delta);
        msg = "-873.5432456 / (0.1 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDecimeters(-873.5432456), delta);
        msg = "0 / (0.1 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDecimeters(0.0), delta);
        msg = "0.1 / (0.1 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDecimeters(0.1), delta);
        msg = "0.0000876543297 / (0.1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDecimeters(8.76543297E-5), delta);
        msg = "0.33 / (0.1 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDecimeters(0.33), delta);
        msg = "0.6543 / (0.1 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDecimeters(0.6543), delta);
        msg = "1 / (0.1 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDecimeters(1.0), delta);
        msg = "1.6543 / (0.1 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDecimeters(1.6543), delta);
        msg = "22.45 / (0.1 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDecimeters(22.45), delta);
        msg = "9876.5432 / (0.1 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDecimeters(9876.5432), delta);
        msg = "1987654344.3345 / (0.1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDecimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.1 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDecimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_METER
        // ====================
        // to_factor = 1.0
        to_factor = SQUARE_METER.getFactor();
        msg = "-1 / (1 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareMeters(-1.0), delta);
        msg = "-0.1 / (1 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareMeters(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareMeters(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareMeters(-73.25), delta);
        msg = "-56229.321 / (1 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareMeters(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareMeters(-873.5432456), delta);
        msg = "0 / (1 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareMeters(0.0), delta);
        msg = "0.1 / (1 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareMeters(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareMeters(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareMeters(0.33), delta);
        msg = "0.6543 / (1 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareMeters(0.6543), delta);
        msg = "1 / (1 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareMeters(1.0), delta);
        msg = "1.6543 / (1 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareMeters(1.6543), delta);
        msg = "22.45 / (1 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareMeters(22.45), delta);
        msg = "9876.5432 / (1 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareMeters(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareMeters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareMeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_DEKAMETER
        // ====================
        // to_factor = 10.0
        to_factor = SQUARE_DEKAMETER.getFactor();
        msg = "-1 / (10 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDekameters(-1.0), delta);
        msg = "-0.1 / (10 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDekameters(-0.1), delta);
        msg = "-0.000456789 / (10 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDekameters(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDekameters(-73.25), delta);
        msg = "-56229.321 / (10 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDekameters(-56229.321), delta);
        msg = "-873.5432456 / (10 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDekameters(-873.5432456), delta);
        msg = "0 / (10 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDekameters(0.0), delta);
        msg = "0.1 / (10 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDekameters(0.1), delta);
        msg = "0.0000876543297 / (10 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDekameters(8.76543297E-5), delta);
        msg = "0.33 / (10 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDekameters(0.33), delta);
        msg = "0.6543 / (10 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDekameters(0.6543), delta);
        msg = "1 / (10 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDekameters(1.0), delta);
        msg = "1.6543 / (10 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDekameters(1.6543), delta);
        msg = "22.45 / (10 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDekameters(22.45), delta);
        msg = "9876.5432 / (10 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDekameters(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDekameters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDekameters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_HECOMETER
        // ====================
        // to_factor = 100.0
        to_factor = SQUARE_HECOMETER.getFactor();
        msg = "-1 / (100 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareHecometers(-1.0), delta);
        msg = "-0.1 / (100 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareHecometers(-0.1), delta);
        msg = "-0.000456789 / (100 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareHecometers(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareHecometers(-73.25), delta);
        msg = "-56229.321 / (100 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareHecometers(-56229.321), delta);
        msg = "-873.5432456 / (100 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareHecometers(-873.5432456), delta);
        msg = "0 / (100 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareHecometers(0.0), delta);
        msg = "0.1 / (100 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareHecometers(0.1), delta);
        msg = "0.0000876543297 / (100 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareHecometers(8.76543297E-5), delta);
        msg = "0.33 / (100 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareHecometers(0.33), delta);
        msg = "0.6543 / (100 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareHecometers(0.6543), delta);
        msg = "1 / (100 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareHecometers(1.0), delta);
        msg = "1.6543 / (100 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareHecometers(1.6543), delta);
        msg = "22.45 / (100 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareHecometers(22.45), delta);
        msg = "9876.5432 / (100 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareHecometers(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareHecometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareHecometers(784.46789765434), delta);
        // ====================
        // ====================SQUARE_KILOMETER
        // ====================
        // to_factor = 1000.0
        to_factor = SQUARE_KILOMETER.getFactor();
        msg = "-1 / (1000 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareKilometers(-1.0), delta);
        msg = "-0.1 / (1000 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareKilometers(-0.1), delta);
        msg = "-0.000456789 / (1000 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareKilometers(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareKilometers(-73.25), delta);
        msg = "-56229.321 / (1000 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareKilometers(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareKilometers(-873.5432456), delta);
        msg = "0 / (1000 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareKilometers(0.0), delta);
        msg = "0.1 / (1000 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareKilometers(0.1), delta);
        msg = "0.0000876543297 / (1000 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareKilometers(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareKilometers(0.33), delta);
        msg = "0.6543 / (1000 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareKilometers(0.6543), delta);
        msg = "1 / (1000 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareKilometers(1.0), delta);
        msg = "1.6543 / (1000 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareKilometers(1.6543), delta);
        msg = "22.45 / (1000 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareKilometers(22.45), delta);
        msg = "9876.5432 / (1000 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareKilometers(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareKilometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareKilometers(784.46789765434), delta);
    }

    @Test()
    public void testSquareDecimeter() {
        // from_factor = 0.1
        double from_factor = SQUARE_DECIMETER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SQUARE_MILLIMETER
        // ====================
        // to_factor = 0.001
        to_factor = SQUARE_MILLIMETER.getFactor();
        msg = "-1 * (0.1 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareMillimeters(-1.0), delta);
        msg = "-0.1 * (0.1 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareMillimeters(-0.1), delta);
        msg = "-0.000456789 * (0.1 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareMillimeters(-4.56789E-4), delta);
        msg = "-73.25 * (0.1 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareMillimeters(-73.25), delta);
        msg = "-56229.321 * (0.1 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareMillimeters(-56229.321), delta);
        msg = "-873.5432456 * (0.1 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareMillimeters(-873.5432456), delta);
        msg = "0 * (0.1 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareMillimeters(0.0), delta);
        msg = "0.1 * (0.1 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareMillimeters(0.1), delta);
        msg = "0.0000876543297 * (0.1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareMillimeters(8.76543297E-5), delta);
        msg = "0.33 * (0.1 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareMillimeters(0.33), delta);
        msg = "0.6543 * (0.1 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareMillimeters(0.6543), delta);
        msg = "1 * (0.1 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareMillimeters(1.0), delta);
        msg = "1.6543 * (0.1 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareMillimeters(1.6543), delta);
        msg = "22.45 * (0.1 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareMillimeters(22.45), delta);
        msg = "9876.5432 * (0.1 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareMillimeters(9876.5432), delta);
        msg = "1987654344.3345 * (0.1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareMillimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.1 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareMillimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_CENTIMETER
        // ====================
        // to_factor = 0.01
        to_factor = SQUARE_CENTIMETER.getFactor();
        msg = "-1 * (0.1 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareCentimeters(-1.0), delta);
        msg = "-0.1 * (0.1 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareCentimeters(-0.1), delta);
        msg = "-0.000456789 * (0.1 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareCentimeters(-4.56789E-4), delta);
        msg = "-73.25 * (0.1 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareCentimeters(-73.25), delta);
        msg = "-56229.321 * (0.1 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareCentimeters(-56229.321), delta);
        msg = "-873.5432456 * (0.1 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareCentimeters(-873.5432456), delta);
        msg = "0 * (0.1 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareCentimeters(0.0), delta);
        msg = "0.1 * (0.1 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareCentimeters(0.1), delta);
        msg = "0.0000876543297 * (0.1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareCentimeters(8.76543297E-5), delta);
        msg = "0.33 * (0.1 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareCentimeters(0.33), delta);
        msg = "0.6543 * (0.1 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareCentimeters(0.6543), delta);
        msg = "1 * (0.1 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareCentimeters(1.0), delta);
        msg = "1.6543 * (0.1 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareCentimeters(1.6543), delta);
        msg = "22.45 * (0.1 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareCentimeters(22.45), delta);
        msg = "9876.5432 * (0.1 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareCentimeters(9876.5432), delta);
        msg = "1987654344.3345 * (0.1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareCentimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.1 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareCentimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_DECIMETER
        // ====================
        // to_factor = 0.1
        to_factor = SQUARE_DECIMETER.getFactor();
        msg = "-1 * (0.1 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareDecimeters(-1.0), delta);
        msg = "-0.1 * (0.1 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareDecimeters(-0.1), delta);
        msg = "-0.000456789 * (0.1 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareDecimeters(-4.56789E-4), delta);
        msg = "-73.25 * (0.1 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareDecimeters(-73.25), delta);
        msg = "-56229.321 * (0.1 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareDecimeters(-56229.321), delta);
        msg = "-873.5432456 * (0.1 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareDecimeters(-873.5432456), delta);
        msg = "0 * (0.1 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareDecimeters(0.0), delta);
        msg = "0.1 * (0.1 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareDecimeters(0.1), delta);
        msg = "0.0000876543297 * (0.1 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareDecimeters(8.76543297E-5), delta);
        msg = "0.33 * (0.1 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareDecimeters(0.33), delta);
        msg = "0.6543 * (0.1 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareDecimeters(0.6543), delta);
        msg = "1 * (0.1 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareDecimeters(1.0), delta);
        msg = "1.6543 * (0.1 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareDecimeters(1.6543), delta);
        msg = "22.45 * (0.1 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareDecimeters(22.45), delta);
        msg = "9876.5432 * (0.1 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareDecimeters(9876.5432), delta);
        msg = "1987654344.3345 * (0.1 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareDecimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.1 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_DECIMETER.toSquareDecimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_METER
        // ====================
        // to_factor = 1.0
        to_factor = SQUARE_METER.getFactor();
        msg = "-1 / (1 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareMeters(-1.0), delta);
        msg = "-0.1 / (1 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareMeters(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareMeters(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareMeters(-73.25), delta);
        msg = "-56229.321 / (1 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareMeters(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareMeters(-873.5432456), delta);
        msg = "0 / (1 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareMeters(0.0), delta);
        msg = "0.1 / (1 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareMeters(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareMeters(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareMeters(0.33), delta);
        msg = "0.6543 / (1 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareMeters(0.6543), delta);
        msg = "1 / (1 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareMeters(1.0), delta);
        msg = "1.6543 / (1 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareMeters(1.6543), delta);
        msg = "22.45 / (1 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareMeters(22.45), delta);
        msg = "9876.5432 / (1 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareMeters(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareMeters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareMeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_DEKAMETER
        // ====================
        // to_factor = 10.0
        to_factor = SQUARE_DEKAMETER.getFactor();
        msg = "-1 / (10 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareDekameters(-1.0), delta);
        msg = "-0.1 / (10 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareDekameters(-0.1), delta);
        msg = "-0.000456789 / (10 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareDekameters(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareDekameters(-73.25), delta);
        msg = "-56229.321 / (10 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareDekameters(-56229.321), delta);
        msg = "-873.5432456 / (10 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareDekameters(-873.5432456), delta);
        msg = "0 / (10 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareDekameters(0.0), delta);
        msg = "0.1 / (10 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareDekameters(0.1), delta);
        msg = "0.0000876543297 / (10 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareDekameters(8.76543297E-5), delta);
        msg = "0.33 / (10 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareDekameters(0.33), delta);
        msg = "0.6543 / (10 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareDekameters(0.6543), delta);
        msg = "1 / (10 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareDekameters(1.0), delta);
        msg = "1.6543 / (10 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareDekameters(1.6543), delta);
        msg = "22.45 / (10 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareDekameters(22.45), delta);
        msg = "9876.5432 / (10 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareDekameters(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareDekameters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareDekameters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_HECOMETER
        // ====================
        // to_factor = 100.0
        to_factor = SQUARE_HECOMETER.getFactor();
        msg = "-1 / (100 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareHecometers(-1.0), delta);
        msg = "-0.1 / (100 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareHecometers(-0.1), delta);
        msg = "-0.000456789 / (100 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareHecometers(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareHecometers(-73.25), delta);
        msg = "-56229.321 / (100 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareHecometers(-56229.321), delta);
        msg = "-873.5432456 / (100 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareHecometers(-873.5432456), delta);
        msg = "0 / (100 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareHecometers(0.0), delta);
        msg = "0.1 / (100 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareHecometers(0.1), delta);
        msg = "0.0000876543297 / (100 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareHecometers(8.76543297E-5), delta);
        msg = "0.33 / (100 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareHecometers(0.33), delta);
        msg = "0.6543 / (100 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareHecometers(0.6543), delta);
        msg = "1 / (100 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareHecometers(1.0), delta);
        msg = "1.6543 / (100 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareHecometers(1.6543), delta);
        msg = "22.45 / (100 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareHecometers(22.45), delta);
        msg = "9876.5432 / (100 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareHecometers(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareHecometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareHecometers(784.46789765434), delta);
        // ====================
        // ====================SQUARE_KILOMETER
        // ====================
        // to_factor = 1000.0
        to_factor = SQUARE_KILOMETER.getFactor();
        msg = "-1 / (1000 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareKilometers(-1.0), delta);
        msg = "-0.1 / (1000 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareKilometers(-0.1), delta);
        msg = "-0.000456789 / (1000 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareKilometers(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareKilometers(-73.25), delta);
        msg = "-56229.321 / (1000 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareKilometers(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareKilometers(-873.5432456), delta);
        msg = "0 / (1000 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareKilometers(0.0), delta);
        msg = "0.1 / (1000 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareKilometers(0.1), delta);
        msg = "0.0000876543297 / (1000 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareKilometers(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareKilometers(0.33), delta);
        msg = "0.6543 / (1000 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareKilometers(0.6543), delta);
        msg = "1 / (1000 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareKilometers(1.0), delta);
        msg = "1.6543 / (1000 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareKilometers(1.6543), delta);
        msg = "22.45 / (1000 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareKilometers(22.45), delta);
        msg = "9876.5432 / (1000 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareKilometers(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareKilometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_DECIMETER.toSquareKilometers(784.46789765434), delta);
    }

    @Test()
    public void testSquareMeter() {
        // from_factor = 1.0
        double from_factor = SQUARE_METER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SQUARE_MILLIMETER
        // ====================
        // to_factor = 0.001
        to_factor = SQUARE_MILLIMETER.getFactor();
        msg = "-1 * (1 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_METER.toSquareMillimeters(-1.0), delta);
        msg = "-0.1 * (1 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_METER.toSquareMillimeters(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_METER.toSquareMillimeters(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_METER.toSquareMillimeters(-73.25), delta);
        msg = "-56229.321 * (1 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_METER.toSquareMillimeters(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_METER.toSquareMillimeters(-873.5432456), delta);
        msg = "0 * (1 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_METER.toSquareMillimeters(0.0), delta);
        msg = "0.1 * (1 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_METER.toSquareMillimeters(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_METER.toSquareMillimeters(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_METER.toSquareMillimeters(0.33), delta);
        msg = "0.6543 * (1 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_METER.toSquareMillimeters(0.6543), delta);
        msg = "1 * (1 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_METER.toSquareMillimeters(1.0), delta);
        msg = "1.6543 * (1 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_METER.toSquareMillimeters(1.6543), delta);
        msg = "22.45 * (1 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_METER.toSquareMillimeters(22.45), delta);
        msg = "9876.5432 * (1 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_METER.toSquareMillimeters(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_METER.toSquareMillimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_METER.toSquareMillimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_CENTIMETER
        // ====================
        // to_factor = 0.01
        to_factor = SQUARE_CENTIMETER.getFactor();
        msg = "-1 * (1 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_METER.toSquareCentimeters(-1.0), delta);
        msg = "-0.1 * (1 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_METER.toSquareCentimeters(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_METER.toSquareCentimeters(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_METER.toSquareCentimeters(-73.25), delta);
        msg = "-56229.321 * (1 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_METER.toSquareCentimeters(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_METER.toSquareCentimeters(-873.5432456), delta);
        msg = "0 * (1 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_METER.toSquareCentimeters(0.0), delta);
        msg = "0.1 * (1 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_METER.toSquareCentimeters(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_METER.toSquareCentimeters(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_METER.toSquareCentimeters(0.33), delta);
        msg = "0.6543 * (1 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_METER.toSquareCentimeters(0.6543), delta);
        msg = "1 * (1 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_METER.toSquareCentimeters(1.0), delta);
        msg = "1.6543 * (1 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_METER.toSquareCentimeters(1.6543), delta);
        msg = "22.45 * (1 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_METER.toSquareCentimeters(22.45), delta);
        msg = "9876.5432 * (1 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_METER.toSquareCentimeters(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_METER.toSquareCentimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_METER.toSquareCentimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_DECIMETER
        // ====================
        // to_factor = 0.1
        to_factor = SQUARE_DECIMETER.getFactor();
        msg = "-1 * (1 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_METER.toSquareDecimeters(-1.0), delta);
        msg = "-0.1 * (1 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_METER.toSquareDecimeters(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_METER.toSquareDecimeters(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_METER.toSquareDecimeters(-73.25), delta);
        msg = "-56229.321 * (1 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_METER.toSquareDecimeters(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_METER.toSquareDecimeters(-873.5432456), delta);
        msg = "0 * (1 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_METER.toSquareDecimeters(0.0), delta);
        msg = "0.1 * (1 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_METER.toSquareDecimeters(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_METER.toSquareDecimeters(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_METER.toSquareDecimeters(0.33), delta);
        msg = "0.6543 * (1 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_METER.toSquareDecimeters(0.6543), delta);
        msg = "1 * (1 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_METER.toSquareDecimeters(1.0), delta);
        msg = "1.6543 * (1 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_METER.toSquareDecimeters(1.6543), delta);
        msg = "22.45 * (1 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_METER.toSquareDecimeters(22.45), delta);
        msg = "9876.5432 * (1 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_METER.toSquareDecimeters(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_METER.toSquareDecimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_METER.toSquareDecimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_METER
        // ====================
        // to_factor = 1.0
        to_factor = SQUARE_METER.getFactor();
        msg = "-1 * (1 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_METER.toSquareMeters(-1.0), delta);
        msg = "-0.1 * (1 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_METER.toSquareMeters(-0.1), delta);
        msg = "-0.000456789 * (1 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_METER.toSquareMeters(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_METER.toSquareMeters(-73.25), delta);
        msg = "-56229.321 * (1 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_METER.toSquareMeters(-56229.321), delta);
        msg = "-873.5432456 * (1 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_METER.toSquareMeters(-873.5432456), delta);
        msg = "0 * (1 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_METER.toSquareMeters(0.0), delta);
        msg = "0.1 * (1 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_METER.toSquareMeters(0.1), delta);
        msg = "0.0000876543297 * (1 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_METER.toSquareMeters(8.76543297E-5), delta);
        msg = "0.33 * (1 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_METER.toSquareMeters(0.33), delta);
        msg = "0.6543 * (1 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_METER.toSquareMeters(0.6543), delta);
        msg = "1 * (1 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_METER.toSquareMeters(1.0), delta);
        msg = "1.6543 * (1 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_METER.toSquareMeters(1.6543), delta);
        msg = "22.45 * (1 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_METER.toSquareMeters(22.45), delta);
        msg = "9876.5432 * (1 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_METER.toSquareMeters(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_METER.toSquareMeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_METER.toSquareMeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_DEKAMETER
        // ====================
        // to_factor = 10.0
        to_factor = SQUARE_DEKAMETER.getFactor();
        msg = "-1 / (10 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_METER.toSquareDekameters(-1.0), delta);
        msg = "-0.1 / (10 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_METER.toSquareDekameters(-0.1), delta);
        msg = "-0.000456789 / (10 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_METER.toSquareDekameters(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_METER.toSquareDekameters(-73.25), delta);
        msg = "-56229.321 / (10 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_METER.toSquareDekameters(-56229.321), delta);
        msg = "-873.5432456 / (10 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_METER.toSquareDekameters(-873.5432456), delta);
        msg = "0 / (10 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_METER.toSquareDekameters(0.0), delta);
        msg = "0.1 / (10 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_METER.toSquareDekameters(0.1), delta);
        msg = "0.0000876543297 / (10 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_METER.toSquareDekameters(8.76543297E-5), delta);
        msg = "0.33 / (10 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_METER.toSquareDekameters(0.33), delta);
        msg = "0.6543 / (10 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_METER.toSquareDekameters(0.6543), delta);
        msg = "1 / (10 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_METER.toSquareDekameters(1.0), delta);
        msg = "1.6543 / (10 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_METER.toSquareDekameters(1.6543), delta);
        msg = "22.45 / (10 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_METER.toSquareDekameters(22.45), delta);
        msg = "9876.5432 / (10 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_METER.toSquareDekameters(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_METER.toSquareDekameters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_METER.toSquareDekameters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_HECOMETER
        // ====================
        // to_factor = 100.0
        to_factor = SQUARE_HECOMETER.getFactor();
        msg = "-1 / (100 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_METER.toSquareHecometers(-1.0), delta);
        msg = "-0.1 / (100 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_METER.toSquareHecometers(-0.1), delta);
        msg = "-0.000456789 / (100 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_METER.toSquareHecometers(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_METER.toSquareHecometers(-73.25), delta);
        msg = "-56229.321 / (100 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_METER.toSquareHecometers(-56229.321), delta);
        msg = "-873.5432456 / (100 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_METER.toSquareHecometers(-873.5432456), delta);
        msg = "0 / (100 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_METER.toSquareHecometers(0.0), delta);
        msg = "0.1 / (100 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_METER.toSquareHecometers(0.1), delta);
        msg = "0.0000876543297 / (100 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_METER.toSquareHecometers(8.76543297E-5), delta);
        msg = "0.33 / (100 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_METER.toSquareHecometers(0.33), delta);
        msg = "0.6543 / (100 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_METER.toSquareHecometers(0.6543), delta);
        msg = "1 / (100 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_METER.toSquareHecometers(1.0), delta);
        msg = "1.6543 / (100 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_METER.toSquareHecometers(1.6543), delta);
        msg = "22.45 / (100 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_METER.toSquareHecometers(22.45), delta);
        msg = "9876.5432 / (100 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_METER.toSquareHecometers(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_METER.toSquareHecometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_METER.toSquareHecometers(784.46789765434), delta);
        // ====================
        // ====================SQUARE_KILOMETER
        // ====================
        // to_factor = 1000.0
        to_factor = SQUARE_KILOMETER.getFactor();
        msg = "-1 / (1000 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_METER.toSquareKilometers(-1.0), delta);
        msg = "-0.1 / (1000 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_METER.toSquareKilometers(-0.1), delta);
        msg = "-0.000456789 / (1000 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_METER.toSquareKilometers(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_METER.toSquareKilometers(-73.25), delta);
        msg = "-56229.321 / (1000 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_METER.toSquareKilometers(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_METER.toSquareKilometers(-873.5432456), delta);
        msg = "0 / (1000 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_METER.toSquareKilometers(0.0), delta);
        msg = "0.1 / (1000 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_METER.toSquareKilometers(0.1), delta);
        msg = "0.0000876543297 / (1000 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_METER.toSquareKilometers(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_METER.toSquareKilometers(0.33), delta);
        msg = "0.6543 / (1000 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_METER.toSquareKilometers(0.6543), delta);
        msg = "1 / (1000 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_METER.toSquareKilometers(1.0), delta);
        msg = "1.6543 / (1000 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_METER.toSquareKilometers(1.6543), delta);
        msg = "22.45 / (1000 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_METER.toSquareKilometers(22.45), delta);
        msg = "9876.5432 / (1000 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_METER.toSquareKilometers(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_METER.toSquareKilometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_METER.toSquareKilometers(784.46789765434), delta);
    }

    @Test()
    public void testSquareDekameter() {
        // from_factor = 10.0
        double from_factor = SQUARE_DEKAMETER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SQUARE_MILLIMETER
        // ====================
        // to_factor = 0.001
        to_factor = SQUARE_MILLIMETER.getFactor();
        msg = "-1 * (10 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMillimeters(-1.0), delta);
        msg = "-0.1 * (10 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMillimeters(-0.1), delta);
        msg = "-0.000456789 * (10 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMillimeters(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMillimeters(-73.25), delta);
        msg = "-56229.321 * (10 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMillimeters(-56229.321), delta);
        msg = "-873.5432456 * (10 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMillimeters(-873.5432456), delta);
        msg = "0 * (10 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMillimeters(0.0), delta);
        msg = "0.1 * (10 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMillimeters(0.1), delta);
        msg = "0.0000876543297 * (10 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMillimeters(8.76543297E-5), delta);
        msg = "0.33 * (10 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMillimeters(0.33), delta);
        msg = "0.6543 * (10 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMillimeters(0.6543), delta);
        msg = "1 * (10 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMillimeters(1.0), delta);
        msg = "1.6543 * (10 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMillimeters(1.6543), delta);
        msg = "22.45 * (10 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMillimeters(22.45), delta);
        msg = "9876.5432 * (10 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMillimeters(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMillimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMillimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_CENTIMETER
        // ====================
        // to_factor = 0.01
        to_factor = SQUARE_CENTIMETER.getFactor();
        msg = "-1 * (10 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareCentimeters(-1.0), delta);
        msg = "-0.1 * (10 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareCentimeters(-0.1), delta);
        msg = "-0.000456789 * (10 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareCentimeters(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareCentimeters(-73.25), delta);
        msg = "-56229.321 * (10 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareCentimeters(-56229.321), delta);
        msg = "-873.5432456 * (10 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareCentimeters(-873.5432456), delta);
        msg = "0 * (10 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareCentimeters(0.0), delta);
        msg = "0.1 * (10 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareCentimeters(0.1), delta);
        msg = "0.0000876543297 * (10 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareCentimeters(8.76543297E-5), delta);
        msg = "0.33 * (10 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareCentimeters(0.33), delta);
        msg = "0.6543 * (10 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareCentimeters(0.6543), delta);
        msg = "1 * (10 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareCentimeters(1.0), delta);
        msg = "1.6543 * (10 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareCentimeters(1.6543), delta);
        msg = "22.45 * (10 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareCentimeters(22.45), delta);
        msg = "9876.5432 * (10 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareCentimeters(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareCentimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareCentimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_DECIMETER
        // ====================
        // to_factor = 0.1
        to_factor = SQUARE_DECIMETER.getFactor();
        msg = "-1 * (10 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDecimeters(-1.0), delta);
        msg = "-0.1 * (10 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDecimeters(-0.1), delta);
        msg = "-0.000456789 * (10 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDecimeters(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDecimeters(-73.25), delta);
        msg = "-56229.321 * (10 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDecimeters(-56229.321), delta);
        msg = "-873.5432456 * (10 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDecimeters(-873.5432456), delta);
        msg = "0 * (10 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDecimeters(0.0), delta);
        msg = "0.1 * (10 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDecimeters(0.1), delta);
        msg = "0.0000876543297 * (10 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDecimeters(8.76543297E-5), delta);
        msg = "0.33 * (10 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDecimeters(0.33), delta);
        msg = "0.6543 * (10 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDecimeters(0.6543), delta);
        msg = "1 * (10 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDecimeters(1.0), delta);
        msg = "1.6543 * (10 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDecimeters(1.6543), delta);
        msg = "22.45 * (10 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDecimeters(22.45), delta);
        msg = "9876.5432 * (10 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDecimeters(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDecimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDecimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_METER
        // ====================
        // to_factor = 1.0
        to_factor = SQUARE_METER.getFactor();
        msg = "-1 * (10 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMeters(-1.0), delta);
        msg = "-0.1 * (10 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMeters(-0.1), delta);
        msg = "-0.000456789 * (10 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMeters(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMeters(-73.25), delta);
        msg = "-56229.321 * (10 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMeters(-56229.321), delta);
        msg = "-873.5432456 * (10 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMeters(-873.5432456), delta);
        msg = "0 * (10 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMeters(0.0), delta);
        msg = "0.1 * (10 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMeters(0.1), delta);
        msg = "0.0000876543297 * (10 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMeters(8.76543297E-5), delta);
        msg = "0.33 * (10 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMeters(0.33), delta);
        msg = "0.6543 * (10 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMeters(0.6543), delta);
        msg = "1 * (10 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMeters(1.0), delta);
        msg = "1.6543 * (10 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMeters(1.6543), delta);
        msg = "22.45 * (10 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMeters(22.45), delta);
        msg = "9876.5432 * (10 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMeters(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_DEKAMETER
        // ====================
        // to_factor = 10.0
        to_factor = SQUARE_DEKAMETER.getFactor();
        msg = "-1 * (10 / 10)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDekameters(-1.0), delta);
        msg = "-0.1 * (10 / 10)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDekameters(-0.1), delta);
        msg = "-0.000456789 * (10 / 10)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDekameters(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 10)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDekameters(-73.25), delta);
        msg = "-56229.321 * (10 / 10)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDekameters(-56229.321), delta);
        msg = "-873.5432456 * (10 / 10)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDekameters(-873.5432456), delta);
        msg = "0 * (10 / 10)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDekameters(0.0), delta);
        msg = "0.1 * (10 / 10)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDekameters(0.1), delta);
        msg = "0.0000876543297 * (10 / 10)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDekameters(8.76543297E-5), delta);
        msg = "0.33 * (10 / 10)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDekameters(0.33), delta);
        msg = "0.6543 * (10 / 10)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDekameters(0.6543), delta);
        msg = "1 * (10 / 10)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDekameters(1.0), delta);
        msg = "1.6543 * (10 / 10)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDekameters(1.6543), delta);
        msg = "22.45 * (10 / 10)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDekameters(22.45), delta);
        msg = "9876.5432 * (10 / 10)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDekameters(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 10)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDekameters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 10)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDekameters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_HECOMETER
        // ====================
        // to_factor = 100.0
        to_factor = SQUARE_HECOMETER.getFactor();
        msg = "-1 / (100 / 10)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareHecometers(-1.0), delta);
        msg = "-0.1 / (100 / 10)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareHecometers(-0.1), delta);
        msg = "-0.000456789 / (100 / 10)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareHecometers(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 10)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareHecometers(-73.25), delta);
        msg = "-56229.321 / (100 / 10)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareHecometers(-56229.321), delta);
        msg = "-873.5432456 / (100 / 10)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareHecometers(-873.5432456), delta);
        msg = "0 / (100 / 10)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareHecometers(0.0), delta);
        msg = "0.1 / (100 / 10)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareHecometers(0.1), delta);
        msg = "0.0000876543297 / (100 / 10)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareHecometers(8.76543297E-5), delta);
        msg = "0.33 / (100 / 10)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareHecometers(0.33), delta);
        msg = "0.6543 / (100 / 10)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareHecometers(0.6543), delta);
        msg = "1 / (100 / 10)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareHecometers(1.0), delta);
        msg = "1.6543 / (100 / 10)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareHecometers(1.6543), delta);
        msg = "22.45 / (100 / 10)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareHecometers(22.45), delta);
        msg = "9876.5432 / (100 / 10)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareHecometers(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 10)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareHecometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 10)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareHecometers(784.46789765434), delta);
        // ====================
        // ====================SQUARE_KILOMETER
        // ====================
        // to_factor = 1000.0
        to_factor = SQUARE_KILOMETER.getFactor();
        msg = "-1 / (1000 / 10)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareKilometers(-1.0), delta);
        msg = "-0.1 / (1000 / 10)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareKilometers(-0.1), delta);
        msg = "-0.000456789 / (1000 / 10)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareKilometers(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 10)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareKilometers(-73.25), delta);
        msg = "-56229.321 / (1000 / 10)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareKilometers(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 10)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareKilometers(-873.5432456), delta);
        msg = "0 / (1000 / 10)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareKilometers(0.0), delta);
        msg = "0.1 / (1000 / 10)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareKilometers(0.1), delta);
        msg = "0.0000876543297 / (1000 / 10)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareKilometers(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 10)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareKilometers(0.33), delta);
        msg = "0.6543 / (1000 / 10)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareKilometers(0.6543), delta);
        msg = "1 / (1000 / 10)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareKilometers(1.0), delta);
        msg = "1.6543 / (1000 / 10)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareKilometers(1.6543), delta);
        msg = "22.45 / (1000 / 10)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareKilometers(22.45), delta);
        msg = "9876.5432 / (1000 / 10)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareKilometers(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 10)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareKilometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 10)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareKilometers(784.46789765434), delta);
    }

    @Test()
    public void testSquareHecometer() {
        // from_factor = 100.0
        double from_factor = SQUARE_HECOMETER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SQUARE_MILLIMETER
        // ====================
        // to_factor = 0.001
        to_factor = SQUARE_MILLIMETER.getFactor();
        msg = "-1 * (100 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMillimeters(-1.0), delta);
        msg = "-0.1 * (100 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMillimeters(-0.1), delta);
        msg = "-0.000456789 * (100 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMillimeters(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMillimeters(-73.25), delta);
        msg = "-56229.321 * (100 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMillimeters(-56229.321), delta);
        msg = "-873.5432456 * (100 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMillimeters(-873.5432456), delta);
        msg = "0 * (100 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMillimeters(0.0), delta);
        msg = "0.1 * (100 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMillimeters(0.1), delta);
        msg = "0.0000876543297 * (100 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMillimeters(8.76543297E-5), delta);
        msg = "0.33 * (100 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMillimeters(0.33), delta);
        msg = "0.6543 * (100 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMillimeters(0.6543), delta);
        msg = "1 * (100 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMillimeters(1.0), delta);
        msg = "1.6543 * (100 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMillimeters(1.6543), delta);
        msg = "22.45 * (100 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMillimeters(22.45), delta);
        msg = "9876.5432 * (100 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMillimeters(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMillimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMillimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_CENTIMETER
        // ====================
        // to_factor = 0.01
        to_factor = SQUARE_CENTIMETER.getFactor();
        msg = "-1 * (100 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareCentimeters(-1.0), delta);
        msg = "-0.1 * (100 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareCentimeters(-0.1), delta);
        msg = "-0.000456789 * (100 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareCentimeters(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareCentimeters(-73.25), delta);
        msg = "-56229.321 * (100 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareCentimeters(-56229.321), delta);
        msg = "-873.5432456 * (100 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareCentimeters(-873.5432456), delta);
        msg = "0 * (100 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareCentimeters(0.0), delta);
        msg = "0.1 * (100 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareCentimeters(0.1), delta);
        msg = "0.0000876543297 * (100 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareCentimeters(8.76543297E-5), delta);
        msg = "0.33 * (100 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareCentimeters(0.33), delta);
        msg = "0.6543 * (100 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareCentimeters(0.6543), delta);
        msg = "1 * (100 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareCentimeters(1.0), delta);
        msg = "1.6543 * (100 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareCentimeters(1.6543), delta);
        msg = "22.45 * (100 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareCentimeters(22.45), delta);
        msg = "9876.5432 * (100 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareCentimeters(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareCentimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareCentimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_DECIMETER
        // ====================
        // to_factor = 0.1
        to_factor = SQUARE_DECIMETER.getFactor();
        msg = "-1 * (100 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDecimeters(-1.0), delta);
        msg = "-0.1 * (100 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDecimeters(-0.1), delta);
        msg = "-0.000456789 * (100 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDecimeters(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDecimeters(-73.25), delta);
        msg = "-56229.321 * (100 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDecimeters(-56229.321), delta);
        msg = "-873.5432456 * (100 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDecimeters(-873.5432456), delta);
        msg = "0 * (100 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDecimeters(0.0), delta);
        msg = "0.1 * (100 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDecimeters(0.1), delta);
        msg = "0.0000876543297 * (100 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDecimeters(8.76543297E-5), delta);
        msg = "0.33 * (100 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDecimeters(0.33), delta);
        msg = "0.6543 * (100 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDecimeters(0.6543), delta);
        msg = "1 * (100 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDecimeters(1.0), delta);
        msg = "1.6543 * (100 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDecimeters(1.6543), delta);
        msg = "22.45 * (100 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDecimeters(22.45), delta);
        msg = "9876.5432 * (100 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDecimeters(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDecimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDecimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_METER
        // ====================
        // to_factor = 1.0
        to_factor = SQUARE_METER.getFactor();
        msg = "-1 * (100 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMeters(-1.0), delta);
        msg = "-0.1 * (100 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMeters(-0.1), delta);
        msg = "-0.000456789 * (100 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMeters(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMeters(-73.25), delta);
        msg = "-56229.321 * (100 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMeters(-56229.321), delta);
        msg = "-873.5432456 * (100 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMeters(-873.5432456), delta);
        msg = "0 * (100 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMeters(0.0), delta);
        msg = "0.1 * (100 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMeters(0.1), delta);
        msg = "0.0000876543297 * (100 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMeters(8.76543297E-5), delta);
        msg = "0.33 * (100 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMeters(0.33), delta);
        msg = "0.6543 * (100 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMeters(0.6543), delta);
        msg = "1 * (100 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMeters(1.0), delta);
        msg = "1.6543 * (100 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMeters(1.6543), delta);
        msg = "22.45 * (100 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMeters(22.45), delta);
        msg = "9876.5432 * (100 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMeters(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_DEKAMETER
        // ====================
        // to_factor = 10.0
        to_factor = SQUARE_DEKAMETER.getFactor();
        msg = "-1 * (100 / 10)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDekameters(-1.0), delta);
        msg = "-0.1 * (100 / 10)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDekameters(-0.1), delta);
        msg = "-0.000456789 * (100 / 10)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDekameters(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 10)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDekameters(-73.25), delta);
        msg = "-56229.321 * (100 / 10)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDekameters(-56229.321), delta);
        msg = "-873.5432456 * (100 / 10)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDekameters(-873.5432456), delta);
        msg = "0 * (100 / 10)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDekameters(0.0), delta);
        msg = "0.1 * (100 / 10)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDekameters(0.1), delta);
        msg = "0.0000876543297 * (100 / 10)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDekameters(8.76543297E-5), delta);
        msg = "0.33 * (100 / 10)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDekameters(0.33), delta);
        msg = "0.6543 * (100 / 10)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDekameters(0.6543), delta);
        msg = "1 * (100 / 10)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDekameters(1.0), delta);
        msg = "1.6543 * (100 / 10)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDekameters(1.6543), delta);
        msg = "22.45 * (100 / 10)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDekameters(22.45), delta);
        msg = "9876.5432 * (100 / 10)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDekameters(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 10)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDekameters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 10)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDekameters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_HECOMETER
        // ====================
        // to_factor = 100.0
        to_factor = SQUARE_HECOMETER.getFactor();
        msg = "-1 * (100 / 100)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareHecometers(-1.0), delta);
        msg = "-0.1 * (100 / 100)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareHecometers(-0.1), delta);
        msg = "-0.000456789 * (100 / 100)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareHecometers(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 100)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareHecometers(-73.25), delta);
        msg = "-56229.321 * (100 / 100)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareHecometers(-56229.321), delta);
        msg = "-873.5432456 * (100 / 100)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareHecometers(-873.5432456), delta);
        msg = "0 * (100 / 100)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareHecometers(0.0), delta);
        msg = "0.1 * (100 / 100)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareHecometers(0.1), delta);
        msg = "0.0000876543297 * (100 / 100)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareHecometers(8.76543297E-5), delta);
        msg = "0.33 * (100 / 100)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareHecometers(0.33), delta);
        msg = "0.6543 * (100 / 100)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareHecometers(0.6543), delta);
        msg = "1 * (100 / 100)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareHecometers(1.0), delta);
        msg = "1.6543 * (100 / 100)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareHecometers(1.6543), delta);
        msg = "22.45 * (100 / 100)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareHecometers(22.45), delta);
        msg = "9876.5432 * (100 / 100)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareHecometers(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 100)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareHecometers(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 100)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_HECOMETER.toSquareHecometers(784.46789765434), delta);
        // ====================
        // ====================SQUARE_KILOMETER
        // ====================
        // to_factor = 1000.0
        to_factor = SQUARE_KILOMETER.getFactor();
        msg = "-1 / (1000 / 100)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_HECOMETER.toSquareKilometers(-1.0), delta);
        msg = "-0.1 / (1000 / 100)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_HECOMETER.toSquareKilometers(-0.1), delta);
        msg = "-0.000456789 / (1000 / 100)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_HECOMETER.toSquareKilometers(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 100)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_HECOMETER.toSquareKilometers(-73.25), delta);
        msg = "-56229.321 / (1000 / 100)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_HECOMETER.toSquareKilometers(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 100)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_HECOMETER.toSquareKilometers(-873.5432456), delta);
        msg = "0 / (1000 / 100)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_HECOMETER.toSquareKilometers(0.0), delta);
        msg = "0.1 / (1000 / 100)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_HECOMETER.toSquareKilometers(0.1), delta);
        msg = "0.0000876543297 / (1000 / 100)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_HECOMETER.toSquareKilometers(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 100)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_HECOMETER.toSquareKilometers(0.33), delta);
        msg = "0.6543 / (1000 / 100)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_HECOMETER.toSquareKilometers(0.6543), delta);
        msg = "1 / (1000 / 100)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_HECOMETER.toSquareKilometers(1.0), delta);
        msg = "1.6543 / (1000 / 100)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_HECOMETER.toSquareKilometers(1.6543), delta);
        msg = "22.45 / (1000 / 100)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_HECOMETER.toSquareKilometers(22.45), delta);
        msg = "9876.5432 / (1000 / 100)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_HECOMETER.toSquareKilometers(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 100)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_HECOMETER.toSquareKilometers(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 100)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_HECOMETER.toSquareKilometers(784.46789765434), delta);
    }

    @Test()
    public void testSquareKilometer() {
        // from_factor = 1000.0
        double from_factor = SQUARE_KILOMETER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SQUARE_MILLIMETER
        // ====================
        // to_factor = 0.001
        to_factor = SQUARE_MILLIMETER.getFactor();
        msg = "-1 * (1000 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMillimeters(-1.0), delta);
        msg = "-0.1 * (1000 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMillimeters(-0.1), delta);
        msg = "-0.000456789 * (1000 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMillimeters(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMillimeters(-73.25), delta);
        msg = "-56229.321 * (1000 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMillimeters(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMillimeters(-873.5432456), delta);
        msg = "0 * (1000 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMillimeters(0.0), delta);
        msg = "0.1 * (1000 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMillimeters(0.1), delta);
        msg = "0.0000876543297 * (1000 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMillimeters(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMillimeters(0.33), delta);
        msg = "0.6543 * (1000 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMillimeters(0.6543), delta);
        msg = "1 * (1000 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMillimeters(1.0), delta);
        msg = "1.6543 * (1000 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMillimeters(1.6543), delta);
        msg = "22.45 * (1000 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMillimeters(22.45), delta);
        msg = "9876.5432 * (1000 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMillimeters(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMillimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMillimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_CENTIMETER
        // ====================
        // to_factor = 0.01
        to_factor = SQUARE_CENTIMETER.getFactor();
        msg = "-1 * (1000 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareCentimeters(-1.0), delta);
        msg = "-0.1 * (1000 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareCentimeters(-0.1), delta);
        msg = "-0.000456789 * (1000 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareCentimeters(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareCentimeters(-73.25), delta);
        msg = "-56229.321 * (1000 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareCentimeters(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareCentimeters(-873.5432456), delta);
        msg = "0 * (1000 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareCentimeters(0.0), delta);
        msg = "0.1 * (1000 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareCentimeters(0.1), delta);
        msg = "0.0000876543297 * (1000 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareCentimeters(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareCentimeters(0.33), delta);
        msg = "0.6543 * (1000 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareCentimeters(0.6543), delta);
        msg = "1 * (1000 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareCentimeters(1.0), delta);
        msg = "1.6543 * (1000 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareCentimeters(1.6543), delta);
        msg = "22.45 * (1000 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareCentimeters(22.45), delta);
        msg = "9876.5432 * (1000 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareCentimeters(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareCentimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareCentimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_DECIMETER
        // ====================
        // to_factor = 0.1
        to_factor = SQUARE_DECIMETER.getFactor();
        msg = "-1 * (1000 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDecimeters(-1.0), delta);
        msg = "-0.1 * (1000 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDecimeters(-0.1), delta);
        msg = "-0.000456789 * (1000 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDecimeters(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDecimeters(-73.25), delta);
        msg = "-56229.321 * (1000 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDecimeters(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDecimeters(-873.5432456), delta);
        msg = "0 * (1000 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDecimeters(0.0), delta);
        msg = "0.1 * (1000 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDecimeters(0.1), delta);
        msg = "0.0000876543297 * (1000 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDecimeters(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDecimeters(0.33), delta);
        msg = "0.6543 * (1000 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDecimeters(0.6543), delta);
        msg = "1 * (1000 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDecimeters(1.0), delta);
        msg = "1.6543 * (1000 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDecimeters(1.6543), delta);
        msg = "22.45 * (1000 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDecimeters(22.45), delta);
        msg = "9876.5432 * (1000 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDecimeters(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDecimeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDecimeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_METER
        // ====================
        // to_factor = 1.0
        to_factor = SQUARE_METER.getFactor();
        msg = "-1 * (1000 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMeters(-1.0), delta);
        msg = "-0.1 * (1000 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMeters(-0.1), delta);
        msg = "-0.000456789 * (1000 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMeters(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMeters(-73.25), delta);
        msg = "-56229.321 * (1000 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMeters(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMeters(-873.5432456), delta);
        msg = "0 * (1000 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMeters(0.0), delta);
        msg = "0.1 * (1000 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMeters(0.1), delta);
        msg = "0.0000876543297 * (1000 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMeters(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMeters(0.33), delta);
        msg = "0.6543 * (1000 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMeters(0.6543), delta);
        msg = "1 * (1000 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMeters(1.0), delta);
        msg = "1.6543 * (1000 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMeters(1.6543), delta);
        msg = "22.45 * (1000 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMeters(22.45), delta);
        msg = "9876.5432 * (1000 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMeters(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMeters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMeters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_DEKAMETER
        // ====================
        // to_factor = 10.0
        to_factor = SQUARE_DEKAMETER.getFactor();
        msg = "-1 * (1000 / 10)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDekameters(-1.0), delta);
        msg = "-0.1 * (1000 / 10)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDekameters(-0.1), delta);
        msg = "-0.000456789 * (1000 / 10)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDekameters(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 10)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDekameters(-73.25), delta);
        msg = "-56229.321 * (1000 / 10)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDekameters(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 10)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDekameters(-873.5432456), delta);
        msg = "0 * (1000 / 10)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDekameters(0.0), delta);
        msg = "0.1 * (1000 / 10)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDekameters(0.1), delta);
        msg = "0.0000876543297 * (1000 / 10)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDekameters(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 10)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDekameters(0.33), delta);
        msg = "0.6543 * (1000 / 10)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDekameters(0.6543), delta);
        msg = "1 * (1000 / 10)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDekameters(1.0), delta);
        msg = "1.6543 * (1000 / 10)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDekameters(1.6543), delta);
        msg = "22.45 * (1000 / 10)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDekameters(22.45), delta);
        msg = "9876.5432 * (1000 / 10)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDekameters(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 10)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDekameters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 10)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDekameters(784.46789765434), delta);
        // ====================
        // ====================SQUARE_HECOMETER
        // ====================
        // to_factor = 100.0
        to_factor = SQUARE_HECOMETER.getFactor();
        msg = "-1 * (1000 / 100)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareHecometers(-1.0), delta);
        msg = "-0.1 * (1000 / 100)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareHecometers(-0.1), delta);
        msg = "-0.000456789 * (1000 / 100)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareHecometers(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 100)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareHecometers(-73.25), delta);
        msg = "-56229.321 * (1000 / 100)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareHecometers(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 100)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareHecometers(-873.5432456), delta);
        msg = "0 * (1000 / 100)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareHecometers(0.0), delta);
        msg = "0.1 * (1000 / 100)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareHecometers(0.1), delta);
        msg = "0.0000876543297 * (1000 / 100)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareHecometers(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 100)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareHecometers(0.33), delta);
        msg = "0.6543 * (1000 / 100)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareHecometers(0.6543), delta);
        msg = "1 * (1000 / 100)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareHecometers(1.0), delta);
        msg = "1.6543 * (1000 / 100)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareHecometers(1.6543), delta);
        msg = "22.45 * (1000 / 100)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareHecometers(22.45), delta);
        msg = "9876.5432 * (1000 / 100)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareHecometers(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 100)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareHecometers(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 100)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareHecometers(784.46789765434), delta);
        // ====================
        // ====================SQUARE_KILOMETER
        // ====================
        // to_factor = 1000.0
        to_factor = SQUARE_KILOMETER.getFactor();
        msg = "-1 * (1000 / 1000)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareKilometers(-1.0), delta);
        msg = "-0.1 * (1000 / 1000)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareKilometers(-0.1), delta);
        msg = "-0.000456789 * (1000 / 1000)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareKilometers(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 1000)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareKilometers(-73.25), delta);
        msg = "-56229.321 * (1000 / 1000)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareKilometers(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 1000)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareKilometers(-873.5432456), delta);
        msg = "0 * (1000 / 1000)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareKilometers(0.0), delta);
        msg = "0.1 * (1000 / 1000)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareKilometers(0.1), delta);
        msg = "0.0000876543297 * (1000 / 1000)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareKilometers(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 1000)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareKilometers(0.33), delta);
        msg = "0.6543 * (1000 / 1000)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareKilometers(0.6543), delta);
        msg = "1 * (1000 / 1000)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareKilometers(1.0), delta);
        msg = "1.6543 * (1000 / 1000)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareKilometers(1.6543), delta);
        msg = "22.45 * (1000 / 1000)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareKilometers(22.45), delta);
        msg = "9876.5432 * (1000 / 1000)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareKilometers(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 1000)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareKilometers(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 1000)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_KILOMETER.toSquareKilometers(784.46789765434), delta);
    }
}
