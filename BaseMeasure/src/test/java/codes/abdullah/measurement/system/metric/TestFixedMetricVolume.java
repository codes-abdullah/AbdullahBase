package codes.abdullah.measurement.system.metric;

import static codes.abdullah.measurement.system.metric.Metrics.CENTILITER;
import static codes.abdullah.measurement.system.metric.Metrics.DECILITER;
import static codes.abdullah.measurement.system.metric.Metrics.DEKALITER;
import static codes.abdullah.measurement.system.metric.Metrics.HECTOLITER;
import static codes.abdullah.measurement.system.metric.Metrics.KILOLITER;
import static codes.abdullah.measurement.system.metric.Metrics.LITER;
import static codes.abdullah.measurement.system.metric.Metrics.MILLILITER;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFixedMetricVolume {

    @Test()
    public void testMilliliter() {
        // from_factor = 0.001
        double from_factor = MILLILITER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLILITER
        // ====================
        // to_factor = 0.001
        to_factor = MILLILITER.getFactor();
        msg = "-1 * (0.001 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MILLILITER.toMilliliters(-1.0), delta);
        msg = "-0.1 * (0.001 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MILLILITER.toMilliliters(-0.1), delta);
        msg = "-0.000456789 * (0.001 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MILLILITER.toMilliliters(-4.56789E-4), delta);
        msg = "-73.25 * (0.001 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MILLILITER.toMilliliters(-73.25), delta);
        msg = "-56229.321 * (0.001 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MILLILITER.toMilliliters(-56229.321), delta);
        msg = "-873.5432456 * (0.001 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MILLILITER.toMilliliters(-873.5432456), delta);
        msg = "0 * (0.001 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MILLILITER.toMilliliters(0.0), delta);
        msg = "0.1 * (0.001 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MILLILITER.toMilliliters(0.1), delta);
        msg = "0.0000876543297 * (0.001 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MILLILITER.toMilliliters(8.76543297E-5), delta);
        msg = "0.33 * (0.001 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MILLILITER.toMilliliters(0.33), delta);
        msg = "0.6543 * (0.001 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MILLILITER.toMilliliters(0.6543), delta);
        msg = "1 * (0.001 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MILLILITER.toMilliliters(1.0), delta);
        msg = "1.6543 * (0.001 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MILLILITER.toMilliliters(1.6543), delta);
        msg = "22.45 * (0.001 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MILLILITER.toMilliliters(22.45), delta);
        msg = "9876.5432 * (0.001 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MILLILITER.toMilliliters(9876.5432), delta);
        msg = "1987654344.3345 * (0.001 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MILLILITER.toMilliliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.001 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MILLILITER.toMilliliters(784.46789765434), delta);
        // ====================
        // ====================CENTILITER
        // ====================
        // to_factor = 0.01
        to_factor = CENTILITER.getFactor();
        msg = "-1 / (0.01 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLILITER.toCentiliters(-1.0), delta);
        msg = "-0.1 / (0.01 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLILITER.toCentiliters(-0.1), delta);
        msg = "-0.000456789 / (0.01 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLILITER.toCentiliters(-4.56789E-4), delta);
        msg = "-73.25 / (0.01 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLILITER.toCentiliters(-73.25), delta);
        msg = "-56229.321 / (0.01 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLILITER.toCentiliters(-56229.321), delta);
        msg = "-873.5432456 / (0.01 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLILITER.toCentiliters(-873.5432456), delta);
        msg = "0 / (0.01 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLILITER.toCentiliters(0.0), delta);
        msg = "0.1 / (0.01 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLILITER.toCentiliters(0.1), delta);
        msg = "0.0000876543297 / (0.01 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLILITER.toCentiliters(8.76543297E-5), delta);
        msg = "0.33 / (0.01 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLILITER.toCentiliters(0.33), delta);
        msg = "0.6543 / (0.01 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLILITER.toCentiliters(0.6543), delta);
        msg = "1 / (0.01 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLILITER.toCentiliters(1.0), delta);
        msg = "1.6543 / (0.01 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLILITER.toCentiliters(1.6543), delta);
        msg = "22.45 / (0.01 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLILITER.toCentiliters(22.45), delta);
        msg = "9876.5432 / (0.01 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLILITER.toCentiliters(9876.5432), delta);
        msg = "1987654344.3345 / (0.01 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLILITER.toCentiliters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.01 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLILITER.toCentiliters(784.46789765434), delta);
        // ====================
        // ====================DECILITER
        // ====================
        // to_factor = 0.1
        to_factor = DECILITER.getFactor();
        msg = "-1 / (0.1 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLILITER.toDeciliters(-1.0), delta);
        msg = "-0.1 / (0.1 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLILITER.toDeciliters(-0.1), delta);
        msg = "-0.000456789 / (0.1 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLILITER.toDeciliters(-4.56789E-4), delta);
        msg = "-73.25 / (0.1 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLILITER.toDeciliters(-73.25), delta);
        msg = "-56229.321 / (0.1 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLILITER.toDeciliters(-56229.321), delta);
        msg = "-873.5432456 / (0.1 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLILITER.toDeciliters(-873.5432456), delta);
        msg = "0 / (0.1 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLILITER.toDeciliters(0.0), delta);
        msg = "0.1 / (0.1 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLILITER.toDeciliters(0.1), delta);
        msg = "0.0000876543297 / (0.1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLILITER.toDeciliters(8.76543297E-5), delta);
        msg = "0.33 / (0.1 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLILITER.toDeciliters(0.33), delta);
        msg = "0.6543 / (0.1 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLILITER.toDeciliters(0.6543), delta);
        msg = "1 / (0.1 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLILITER.toDeciliters(1.0), delta);
        msg = "1.6543 / (0.1 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLILITER.toDeciliters(1.6543), delta);
        msg = "22.45 / (0.1 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLILITER.toDeciliters(22.45), delta);
        msg = "9876.5432 / (0.1 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLILITER.toDeciliters(9876.5432), delta);
        msg = "1987654344.3345 / (0.1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLILITER.toDeciliters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.1 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLILITER.toDeciliters(784.46789765434), delta);
        // ====================
        // ====================LITER
        // ====================
        // to_factor = 1.0
        to_factor = LITER.getFactor();
        msg = "-1 / (1 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLILITER.toLiters(-1.0), delta);
        msg = "-0.1 / (1 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLILITER.toLiters(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLILITER.toLiters(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLILITER.toLiters(-73.25), delta);
        msg = "-56229.321 / (1 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLILITER.toLiters(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLILITER.toLiters(-873.5432456), delta);
        msg = "0 / (1 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLILITER.toLiters(0.0), delta);
        msg = "0.1 / (1 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLILITER.toLiters(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLILITER.toLiters(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLILITER.toLiters(0.33), delta);
        msg = "0.6543 / (1 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLILITER.toLiters(0.6543), delta);
        msg = "1 / (1 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLILITER.toLiters(1.0), delta);
        msg = "1.6543 / (1 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLILITER.toLiters(1.6543), delta);
        msg = "22.45 / (1 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLILITER.toLiters(22.45), delta);
        msg = "9876.5432 / (1 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLILITER.toLiters(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLILITER.toLiters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLILITER.toLiters(784.46789765434), delta);
        // ====================
        // ====================DEKALITER
        // ====================
        // to_factor = 10.0
        to_factor = DEKALITER.getFactor();
        msg = "-1 / (10 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLILITER.toDekaliters(-1.0), delta);
        msg = "-0.1 / (10 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLILITER.toDekaliters(-0.1), delta);
        msg = "-0.000456789 / (10 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLILITER.toDekaliters(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLILITER.toDekaliters(-73.25), delta);
        msg = "-56229.321 / (10 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLILITER.toDekaliters(-56229.321), delta);
        msg = "-873.5432456 / (10 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLILITER.toDekaliters(-873.5432456), delta);
        msg = "0 / (10 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLILITER.toDekaliters(0.0), delta);
        msg = "0.1 / (10 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLILITER.toDekaliters(0.1), delta);
        msg = "0.0000876543297 / (10 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLILITER.toDekaliters(8.76543297E-5), delta);
        msg = "0.33 / (10 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLILITER.toDekaliters(0.33), delta);
        msg = "0.6543 / (10 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLILITER.toDekaliters(0.6543), delta);
        msg = "1 / (10 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLILITER.toDekaliters(1.0), delta);
        msg = "1.6543 / (10 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLILITER.toDekaliters(1.6543), delta);
        msg = "22.45 / (10 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLILITER.toDekaliters(22.45), delta);
        msg = "9876.5432 / (10 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLILITER.toDekaliters(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLILITER.toDekaliters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLILITER.toDekaliters(784.46789765434), delta);
        // ====================
        // ====================HECTOLITER
        // ====================
        // to_factor = 100.0
        to_factor = HECTOLITER.getFactor();
        msg = "-1 / (100 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLILITER.toHectoliters(-1.0), delta);
        msg = "-0.1 / (100 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLILITER.toHectoliters(-0.1), delta);
        msg = "-0.000456789 / (100 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLILITER.toHectoliters(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLILITER.toHectoliters(-73.25), delta);
        msg = "-56229.321 / (100 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLILITER.toHectoliters(-56229.321), delta);
        msg = "-873.5432456 / (100 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLILITER.toHectoliters(-873.5432456), delta);
        msg = "0 / (100 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLILITER.toHectoliters(0.0), delta);
        msg = "0.1 / (100 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLILITER.toHectoliters(0.1), delta);
        msg = "0.0000876543297 / (100 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLILITER.toHectoliters(8.76543297E-5), delta);
        msg = "0.33 / (100 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLILITER.toHectoliters(0.33), delta);
        msg = "0.6543 / (100 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLILITER.toHectoliters(0.6543), delta);
        msg = "1 / (100 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLILITER.toHectoliters(1.0), delta);
        msg = "1.6543 / (100 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLILITER.toHectoliters(1.6543), delta);
        msg = "22.45 / (100 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLILITER.toHectoliters(22.45), delta);
        msg = "9876.5432 / (100 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLILITER.toHectoliters(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLILITER.toHectoliters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLILITER.toHectoliters(784.46789765434), delta);
        // ====================
        // ====================KILOLITER
        // ====================
        // to_factor = 1000.0
        to_factor = KILOLITER.getFactor();
        msg = "-1 / (1000 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLILITER.toKiloliters(-1.0), delta);
        msg = "-0.1 / (1000 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLILITER.toKiloliters(-0.1), delta);
        msg = "-0.000456789 / (1000 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLILITER.toKiloliters(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLILITER.toKiloliters(-73.25), delta);
        msg = "-56229.321 / (1000 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLILITER.toKiloliters(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLILITER.toKiloliters(-873.5432456), delta);
        msg = "0 / (1000 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLILITER.toKiloliters(0.0), delta);
        msg = "0.1 / (1000 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLILITER.toKiloliters(0.1), delta);
        msg = "0.0000876543297 / (1000 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLILITER.toKiloliters(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLILITER.toKiloliters(0.33), delta);
        msg = "0.6543 / (1000 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLILITER.toKiloliters(0.6543), delta);
        msg = "1 / (1000 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLILITER.toKiloliters(1.0), delta);
        msg = "1.6543 / (1000 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLILITER.toKiloliters(1.6543), delta);
        msg = "22.45 / (1000 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLILITER.toKiloliters(22.45), delta);
        msg = "9876.5432 / (1000 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLILITER.toKiloliters(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLILITER.toKiloliters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLILITER.toKiloliters(784.46789765434), delta);
    }

    @Test()
    public void testCentiliter() {
        // from_factor = 0.01
        double from_factor = CENTILITER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLILITER
        // ====================
        // to_factor = 0.001
        to_factor = MILLILITER.getFactor();
        msg = "-1 * (0.01 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CENTILITER.toMilliliters(-1.0), delta);
        msg = "-0.1 * (0.01 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CENTILITER.toMilliliters(-0.1), delta);
        msg = "-0.000456789 * (0.01 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CENTILITER.toMilliliters(-4.56789E-4), delta);
        msg = "-73.25 * (0.01 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CENTILITER.toMilliliters(-73.25), delta);
        msg = "-56229.321 * (0.01 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CENTILITER.toMilliliters(-56229.321), delta);
        msg = "-873.5432456 * (0.01 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CENTILITER.toMilliliters(-873.5432456), delta);
        msg = "0 * (0.01 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CENTILITER.toMilliliters(0.0), delta);
        msg = "0.1 * (0.01 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CENTILITER.toMilliliters(0.1), delta);
        msg = "0.0000876543297 * (0.01 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CENTILITER.toMilliliters(8.76543297E-5), delta);
        msg = "0.33 * (0.01 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CENTILITER.toMilliliters(0.33), delta);
        msg = "0.6543 * (0.01 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CENTILITER.toMilliliters(0.6543), delta);
        msg = "1 * (0.01 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CENTILITER.toMilliliters(1.0), delta);
        msg = "1.6543 * (0.01 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CENTILITER.toMilliliters(1.6543), delta);
        msg = "22.45 * (0.01 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CENTILITER.toMilliliters(22.45), delta);
        msg = "9876.5432 * (0.01 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CENTILITER.toMilliliters(9876.5432), delta);
        msg = "1987654344.3345 * (0.01 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CENTILITER.toMilliliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.01 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CENTILITER.toMilliliters(784.46789765434), delta);
        // ====================
        // ====================CENTILITER
        // ====================
        // to_factor = 0.01
        to_factor = CENTILITER.getFactor();
        msg = "-1 * (0.01 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CENTILITER.toCentiliters(-1.0), delta);
        msg = "-0.1 * (0.01 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CENTILITER.toCentiliters(-0.1), delta);
        msg = "-0.000456789 * (0.01 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CENTILITER.toCentiliters(-4.56789E-4), delta);
        msg = "-73.25 * (0.01 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CENTILITER.toCentiliters(-73.25), delta);
        msg = "-56229.321 * (0.01 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CENTILITER.toCentiliters(-56229.321), delta);
        msg = "-873.5432456 * (0.01 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CENTILITER.toCentiliters(-873.5432456), delta);
        msg = "0 * (0.01 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CENTILITER.toCentiliters(0.0), delta);
        msg = "0.1 * (0.01 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CENTILITER.toCentiliters(0.1), delta);
        msg = "0.0000876543297 * (0.01 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CENTILITER.toCentiliters(8.76543297E-5), delta);
        msg = "0.33 * (0.01 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CENTILITER.toCentiliters(0.33), delta);
        msg = "0.6543 * (0.01 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CENTILITER.toCentiliters(0.6543), delta);
        msg = "1 * (0.01 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CENTILITER.toCentiliters(1.0), delta);
        msg = "1.6543 * (0.01 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CENTILITER.toCentiliters(1.6543), delta);
        msg = "22.45 * (0.01 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CENTILITER.toCentiliters(22.45), delta);
        msg = "9876.5432 * (0.01 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CENTILITER.toCentiliters(9876.5432), delta);
        msg = "1987654344.3345 * (0.01 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CENTILITER.toCentiliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.01 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CENTILITER.toCentiliters(784.46789765434), delta);
        // ====================
        // ====================DECILITER
        // ====================
        // to_factor = 0.1
        to_factor = DECILITER.getFactor();
        msg = "-1 / (0.1 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), CENTILITER.toDeciliters(-1.0), delta);
        msg = "-0.1 / (0.1 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), CENTILITER.toDeciliters(-0.1), delta);
        msg = "-0.000456789 / (0.1 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), CENTILITER.toDeciliters(-4.56789E-4), delta);
        msg = "-73.25 / (0.1 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), CENTILITER.toDeciliters(-73.25), delta);
        msg = "-56229.321 / (0.1 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), CENTILITER.toDeciliters(-56229.321), delta);
        msg = "-873.5432456 / (0.1 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), CENTILITER.toDeciliters(-873.5432456), delta);
        msg = "0 / (0.1 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), CENTILITER.toDeciliters(0.0), delta);
        msg = "0.1 / (0.1 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), CENTILITER.toDeciliters(0.1), delta);
        msg = "0.0000876543297 / (0.1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), CENTILITER.toDeciliters(8.76543297E-5), delta);
        msg = "0.33 / (0.1 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), CENTILITER.toDeciliters(0.33), delta);
        msg = "0.6543 / (0.1 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), CENTILITER.toDeciliters(0.6543), delta);
        msg = "1 / (0.1 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), CENTILITER.toDeciliters(1.0), delta);
        msg = "1.6543 / (0.1 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), CENTILITER.toDeciliters(1.6543), delta);
        msg = "22.45 / (0.1 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), CENTILITER.toDeciliters(22.45), delta);
        msg = "9876.5432 / (0.1 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), CENTILITER.toDeciliters(9876.5432), delta);
        msg = "1987654344.3345 / (0.1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), CENTILITER.toDeciliters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.1 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), CENTILITER.toDeciliters(784.46789765434), delta);
        // ====================
        // ====================LITER
        // ====================
        // to_factor = 1.0
        to_factor = LITER.getFactor();
        msg = "-1 / (1 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), CENTILITER.toLiters(-1.0), delta);
        msg = "-0.1 / (1 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), CENTILITER.toLiters(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), CENTILITER.toLiters(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), CENTILITER.toLiters(-73.25), delta);
        msg = "-56229.321 / (1 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), CENTILITER.toLiters(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), CENTILITER.toLiters(-873.5432456), delta);
        msg = "0 / (1 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), CENTILITER.toLiters(0.0), delta);
        msg = "0.1 / (1 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), CENTILITER.toLiters(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), CENTILITER.toLiters(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), CENTILITER.toLiters(0.33), delta);
        msg = "0.6543 / (1 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), CENTILITER.toLiters(0.6543), delta);
        msg = "1 / (1 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), CENTILITER.toLiters(1.0), delta);
        msg = "1.6543 / (1 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), CENTILITER.toLiters(1.6543), delta);
        msg = "22.45 / (1 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), CENTILITER.toLiters(22.45), delta);
        msg = "9876.5432 / (1 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), CENTILITER.toLiters(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), CENTILITER.toLiters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), CENTILITER.toLiters(784.46789765434), delta);
        // ====================
        // ====================DEKALITER
        // ====================
        // to_factor = 10.0
        to_factor = DEKALITER.getFactor();
        msg = "-1 / (10 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), CENTILITER.toDekaliters(-1.0), delta);
        msg = "-0.1 / (10 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), CENTILITER.toDekaliters(-0.1), delta);
        msg = "-0.000456789 / (10 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), CENTILITER.toDekaliters(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), CENTILITER.toDekaliters(-73.25), delta);
        msg = "-56229.321 / (10 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), CENTILITER.toDekaliters(-56229.321), delta);
        msg = "-873.5432456 / (10 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), CENTILITER.toDekaliters(-873.5432456), delta);
        msg = "0 / (10 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), CENTILITER.toDekaliters(0.0), delta);
        msg = "0.1 / (10 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), CENTILITER.toDekaliters(0.1), delta);
        msg = "0.0000876543297 / (10 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), CENTILITER.toDekaliters(8.76543297E-5), delta);
        msg = "0.33 / (10 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), CENTILITER.toDekaliters(0.33), delta);
        msg = "0.6543 / (10 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), CENTILITER.toDekaliters(0.6543), delta);
        msg = "1 / (10 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), CENTILITER.toDekaliters(1.0), delta);
        msg = "1.6543 / (10 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), CENTILITER.toDekaliters(1.6543), delta);
        msg = "22.45 / (10 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), CENTILITER.toDekaliters(22.45), delta);
        msg = "9876.5432 / (10 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), CENTILITER.toDekaliters(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), CENTILITER.toDekaliters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), CENTILITER.toDekaliters(784.46789765434), delta);
        // ====================
        // ====================HECTOLITER
        // ====================
        // to_factor = 100.0
        to_factor = HECTOLITER.getFactor();
        msg = "-1 / (100 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), CENTILITER.toHectoliters(-1.0), delta);
        msg = "-0.1 / (100 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), CENTILITER.toHectoliters(-0.1), delta);
        msg = "-0.000456789 / (100 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), CENTILITER.toHectoliters(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), CENTILITER.toHectoliters(-73.25), delta);
        msg = "-56229.321 / (100 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), CENTILITER.toHectoliters(-56229.321), delta);
        msg = "-873.5432456 / (100 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), CENTILITER.toHectoliters(-873.5432456), delta);
        msg = "0 / (100 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), CENTILITER.toHectoliters(0.0), delta);
        msg = "0.1 / (100 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), CENTILITER.toHectoliters(0.1), delta);
        msg = "0.0000876543297 / (100 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), CENTILITER.toHectoliters(8.76543297E-5), delta);
        msg = "0.33 / (100 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), CENTILITER.toHectoliters(0.33), delta);
        msg = "0.6543 / (100 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), CENTILITER.toHectoliters(0.6543), delta);
        msg = "1 / (100 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), CENTILITER.toHectoliters(1.0), delta);
        msg = "1.6543 / (100 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), CENTILITER.toHectoliters(1.6543), delta);
        msg = "22.45 / (100 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), CENTILITER.toHectoliters(22.45), delta);
        msg = "9876.5432 / (100 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), CENTILITER.toHectoliters(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), CENTILITER.toHectoliters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), CENTILITER.toHectoliters(784.46789765434), delta);
        // ====================
        // ====================KILOLITER
        // ====================
        // to_factor = 1000.0
        to_factor = KILOLITER.getFactor();
        msg = "-1 / (1000 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), CENTILITER.toKiloliters(-1.0), delta);
        msg = "-0.1 / (1000 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), CENTILITER.toKiloliters(-0.1), delta);
        msg = "-0.000456789 / (1000 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), CENTILITER.toKiloliters(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), CENTILITER.toKiloliters(-73.25), delta);
        msg = "-56229.321 / (1000 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), CENTILITER.toKiloliters(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), CENTILITER.toKiloliters(-873.5432456), delta);
        msg = "0 / (1000 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), CENTILITER.toKiloliters(0.0), delta);
        msg = "0.1 / (1000 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), CENTILITER.toKiloliters(0.1), delta);
        msg = "0.0000876543297 / (1000 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), CENTILITER.toKiloliters(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), CENTILITER.toKiloliters(0.33), delta);
        msg = "0.6543 / (1000 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), CENTILITER.toKiloliters(0.6543), delta);
        msg = "1 / (1000 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), CENTILITER.toKiloliters(1.0), delta);
        msg = "1.6543 / (1000 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), CENTILITER.toKiloliters(1.6543), delta);
        msg = "22.45 / (1000 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), CENTILITER.toKiloliters(22.45), delta);
        msg = "9876.5432 / (1000 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), CENTILITER.toKiloliters(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), CENTILITER.toKiloliters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), CENTILITER.toKiloliters(784.46789765434), delta);
    }

    @Test()
    public void testDeciliter() {
        // from_factor = 0.1
        double from_factor = DECILITER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLILITER
        // ====================
        // to_factor = 0.001
        to_factor = MILLILITER.getFactor();
        msg = "-1 * (0.1 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DECILITER.toMilliliters(-1.0), delta);
        msg = "-0.1 * (0.1 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DECILITER.toMilliliters(-0.1), delta);
        msg = "-0.000456789 * (0.1 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DECILITER.toMilliliters(-4.56789E-4), delta);
        msg = "-73.25 * (0.1 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DECILITER.toMilliliters(-73.25), delta);
        msg = "-56229.321 * (0.1 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DECILITER.toMilliliters(-56229.321), delta);
        msg = "-873.5432456 * (0.1 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DECILITER.toMilliliters(-873.5432456), delta);
        msg = "0 * (0.1 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DECILITER.toMilliliters(0.0), delta);
        msg = "0.1 * (0.1 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DECILITER.toMilliliters(0.1), delta);
        msg = "0.0000876543297 * (0.1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DECILITER.toMilliliters(8.76543297E-5), delta);
        msg = "0.33 * (0.1 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DECILITER.toMilliliters(0.33), delta);
        msg = "0.6543 * (0.1 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DECILITER.toMilliliters(0.6543), delta);
        msg = "1 * (0.1 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DECILITER.toMilliliters(1.0), delta);
        msg = "1.6543 * (0.1 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DECILITER.toMilliliters(1.6543), delta);
        msg = "22.45 * (0.1 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DECILITER.toMilliliters(22.45), delta);
        msg = "9876.5432 * (0.1 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DECILITER.toMilliliters(9876.5432), delta);
        msg = "1987654344.3345 * (0.1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DECILITER.toMilliliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.1 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DECILITER.toMilliliters(784.46789765434), delta);
        // ====================
        // ====================CENTILITER
        // ====================
        // to_factor = 0.01
        to_factor = CENTILITER.getFactor();
        msg = "-1 * (0.1 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DECILITER.toCentiliters(-1.0), delta);
        msg = "-0.1 * (0.1 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DECILITER.toCentiliters(-0.1), delta);
        msg = "-0.000456789 * (0.1 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DECILITER.toCentiliters(-4.56789E-4), delta);
        msg = "-73.25 * (0.1 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DECILITER.toCentiliters(-73.25), delta);
        msg = "-56229.321 * (0.1 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DECILITER.toCentiliters(-56229.321), delta);
        msg = "-873.5432456 * (0.1 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DECILITER.toCentiliters(-873.5432456), delta);
        msg = "0 * (0.1 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DECILITER.toCentiliters(0.0), delta);
        msg = "0.1 * (0.1 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DECILITER.toCentiliters(0.1), delta);
        msg = "0.0000876543297 * (0.1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DECILITER.toCentiliters(8.76543297E-5), delta);
        msg = "0.33 * (0.1 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DECILITER.toCentiliters(0.33), delta);
        msg = "0.6543 * (0.1 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DECILITER.toCentiliters(0.6543), delta);
        msg = "1 * (0.1 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DECILITER.toCentiliters(1.0), delta);
        msg = "1.6543 * (0.1 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DECILITER.toCentiliters(1.6543), delta);
        msg = "22.45 * (0.1 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DECILITER.toCentiliters(22.45), delta);
        msg = "9876.5432 * (0.1 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DECILITER.toCentiliters(9876.5432), delta);
        msg = "1987654344.3345 * (0.1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DECILITER.toCentiliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.1 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DECILITER.toCentiliters(784.46789765434), delta);
        // ====================
        // ====================DECILITER
        // ====================
        // to_factor = 0.1
        to_factor = DECILITER.getFactor();
        msg = "-1 * (0.1 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DECILITER.toDeciliters(-1.0), delta);
        msg = "-0.1 * (0.1 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DECILITER.toDeciliters(-0.1), delta);
        msg = "-0.000456789 * (0.1 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DECILITER.toDeciliters(-4.56789E-4), delta);
        msg = "-73.25 * (0.1 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DECILITER.toDeciliters(-73.25), delta);
        msg = "-56229.321 * (0.1 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DECILITER.toDeciliters(-56229.321), delta);
        msg = "-873.5432456 * (0.1 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DECILITER.toDeciliters(-873.5432456), delta);
        msg = "0 * (0.1 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DECILITER.toDeciliters(0.0), delta);
        msg = "0.1 * (0.1 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DECILITER.toDeciliters(0.1), delta);
        msg = "0.0000876543297 * (0.1 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DECILITER.toDeciliters(8.76543297E-5), delta);
        msg = "0.33 * (0.1 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DECILITER.toDeciliters(0.33), delta);
        msg = "0.6543 * (0.1 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DECILITER.toDeciliters(0.6543), delta);
        msg = "1 * (0.1 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DECILITER.toDeciliters(1.0), delta);
        msg = "1.6543 * (0.1 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DECILITER.toDeciliters(1.6543), delta);
        msg = "22.45 * (0.1 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DECILITER.toDeciliters(22.45), delta);
        msg = "9876.5432 * (0.1 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DECILITER.toDeciliters(9876.5432), delta);
        msg = "1987654344.3345 * (0.1 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DECILITER.toDeciliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.1 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DECILITER.toDeciliters(784.46789765434), delta);
        // ====================
        // ====================LITER
        // ====================
        // to_factor = 1.0
        to_factor = LITER.getFactor();
        msg = "-1 / (1 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DECILITER.toLiters(-1.0), delta);
        msg = "-0.1 / (1 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DECILITER.toLiters(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DECILITER.toLiters(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DECILITER.toLiters(-73.25), delta);
        msg = "-56229.321 / (1 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DECILITER.toLiters(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DECILITER.toLiters(-873.5432456), delta);
        msg = "0 / (1 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DECILITER.toLiters(0.0), delta);
        msg = "0.1 / (1 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DECILITER.toLiters(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DECILITER.toLiters(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DECILITER.toLiters(0.33), delta);
        msg = "0.6543 / (1 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DECILITER.toLiters(0.6543), delta);
        msg = "1 / (1 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DECILITER.toLiters(1.0), delta);
        msg = "1.6543 / (1 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DECILITER.toLiters(1.6543), delta);
        msg = "22.45 / (1 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DECILITER.toLiters(22.45), delta);
        msg = "9876.5432 / (1 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DECILITER.toLiters(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DECILITER.toLiters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DECILITER.toLiters(784.46789765434), delta);
        // ====================
        // ====================DEKALITER
        // ====================
        // to_factor = 10.0
        to_factor = DEKALITER.getFactor();
        msg = "-1 / (10 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DECILITER.toDekaliters(-1.0), delta);
        msg = "-0.1 / (10 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DECILITER.toDekaliters(-0.1), delta);
        msg = "-0.000456789 / (10 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DECILITER.toDekaliters(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DECILITER.toDekaliters(-73.25), delta);
        msg = "-56229.321 / (10 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DECILITER.toDekaliters(-56229.321), delta);
        msg = "-873.5432456 / (10 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DECILITER.toDekaliters(-873.5432456), delta);
        msg = "0 / (10 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DECILITER.toDekaliters(0.0), delta);
        msg = "0.1 / (10 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DECILITER.toDekaliters(0.1), delta);
        msg = "0.0000876543297 / (10 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DECILITER.toDekaliters(8.76543297E-5), delta);
        msg = "0.33 / (10 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DECILITER.toDekaliters(0.33), delta);
        msg = "0.6543 / (10 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DECILITER.toDekaliters(0.6543), delta);
        msg = "1 / (10 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DECILITER.toDekaliters(1.0), delta);
        msg = "1.6543 / (10 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DECILITER.toDekaliters(1.6543), delta);
        msg = "22.45 / (10 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DECILITER.toDekaliters(22.45), delta);
        msg = "9876.5432 / (10 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DECILITER.toDekaliters(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DECILITER.toDekaliters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DECILITER.toDekaliters(784.46789765434), delta);
        // ====================
        // ====================HECTOLITER
        // ====================
        // to_factor = 100.0
        to_factor = HECTOLITER.getFactor();
        msg = "-1 / (100 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DECILITER.toHectoliters(-1.0), delta);
        msg = "-0.1 / (100 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DECILITER.toHectoliters(-0.1), delta);
        msg = "-0.000456789 / (100 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DECILITER.toHectoliters(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DECILITER.toHectoliters(-73.25), delta);
        msg = "-56229.321 / (100 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DECILITER.toHectoliters(-56229.321), delta);
        msg = "-873.5432456 / (100 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DECILITER.toHectoliters(-873.5432456), delta);
        msg = "0 / (100 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DECILITER.toHectoliters(0.0), delta);
        msg = "0.1 / (100 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DECILITER.toHectoliters(0.1), delta);
        msg = "0.0000876543297 / (100 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DECILITER.toHectoliters(8.76543297E-5), delta);
        msg = "0.33 / (100 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DECILITER.toHectoliters(0.33), delta);
        msg = "0.6543 / (100 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DECILITER.toHectoliters(0.6543), delta);
        msg = "1 / (100 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DECILITER.toHectoliters(1.0), delta);
        msg = "1.6543 / (100 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DECILITER.toHectoliters(1.6543), delta);
        msg = "22.45 / (100 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DECILITER.toHectoliters(22.45), delta);
        msg = "9876.5432 / (100 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DECILITER.toHectoliters(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DECILITER.toHectoliters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DECILITER.toHectoliters(784.46789765434), delta);
        // ====================
        // ====================KILOLITER
        // ====================
        // to_factor = 1000.0
        to_factor = KILOLITER.getFactor();
        msg = "-1 / (1000 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DECILITER.toKiloliters(-1.0), delta);
        msg = "-0.1 / (1000 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DECILITER.toKiloliters(-0.1), delta);
        msg = "-0.000456789 / (1000 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DECILITER.toKiloliters(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DECILITER.toKiloliters(-73.25), delta);
        msg = "-56229.321 / (1000 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DECILITER.toKiloliters(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DECILITER.toKiloliters(-873.5432456), delta);
        msg = "0 / (1000 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DECILITER.toKiloliters(0.0), delta);
        msg = "0.1 / (1000 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DECILITER.toKiloliters(0.1), delta);
        msg = "0.0000876543297 / (1000 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DECILITER.toKiloliters(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DECILITER.toKiloliters(0.33), delta);
        msg = "0.6543 / (1000 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DECILITER.toKiloliters(0.6543), delta);
        msg = "1 / (1000 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DECILITER.toKiloliters(1.0), delta);
        msg = "1.6543 / (1000 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DECILITER.toKiloliters(1.6543), delta);
        msg = "22.45 / (1000 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DECILITER.toKiloliters(22.45), delta);
        msg = "9876.5432 / (1000 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DECILITER.toKiloliters(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DECILITER.toKiloliters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DECILITER.toKiloliters(784.46789765434), delta);
    }

    @Test()
    public void testLiter() {
        // from_factor = 1.0
        double from_factor = LITER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLILITER
        // ====================
        // to_factor = 0.001
        to_factor = MILLILITER.getFactor();
        msg = "-1 * (1 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), LITER.toMilliliters(-1.0), delta);
        msg = "-0.1 * (1 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), LITER.toMilliliters(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), LITER.toMilliliters(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), LITER.toMilliliters(-73.25), delta);
        msg = "-56229.321 * (1 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), LITER.toMilliliters(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), LITER.toMilliliters(-873.5432456), delta);
        msg = "0 * (1 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), LITER.toMilliliters(0.0), delta);
        msg = "0.1 * (1 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), LITER.toMilliliters(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), LITER.toMilliliters(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), LITER.toMilliliters(0.33), delta);
        msg = "0.6543 * (1 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), LITER.toMilliliters(0.6543), delta);
        msg = "1 * (1 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), LITER.toMilliliters(1.0), delta);
        msg = "1.6543 * (1 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), LITER.toMilliliters(1.6543), delta);
        msg = "22.45 * (1 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), LITER.toMilliliters(22.45), delta);
        msg = "9876.5432 * (1 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), LITER.toMilliliters(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), LITER.toMilliliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), LITER.toMilliliters(784.46789765434), delta);
        // ====================
        // ====================CENTILITER
        // ====================
        // to_factor = 0.01
        to_factor = CENTILITER.getFactor();
        msg = "-1 * (1 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), LITER.toCentiliters(-1.0), delta);
        msg = "-0.1 * (1 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), LITER.toCentiliters(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), LITER.toCentiliters(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), LITER.toCentiliters(-73.25), delta);
        msg = "-56229.321 * (1 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), LITER.toCentiliters(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), LITER.toCentiliters(-873.5432456), delta);
        msg = "0 * (1 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), LITER.toCentiliters(0.0), delta);
        msg = "0.1 * (1 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), LITER.toCentiliters(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), LITER.toCentiliters(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), LITER.toCentiliters(0.33), delta);
        msg = "0.6543 * (1 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), LITER.toCentiliters(0.6543), delta);
        msg = "1 * (1 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), LITER.toCentiliters(1.0), delta);
        msg = "1.6543 * (1 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), LITER.toCentiliters(1.6543), delta);
        msg = "22.45 * (1 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), LITER.toCentiliters(22.45), delta);
        msg = "9876.5432 * (1 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), LITER.toCentiliters(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), LITER.toCentiliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), LITER.toCentiliters(784.46789765434), delta);
        // ====================
        // ====================DECILITER
        // ====================
        // to_factor = 0.1
        to_factor = DECILITER.getFactor();
        msg = "-1 * (1 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), LITER.toDeciliters(-1.0), delta);
        msg = "-0.1 * (1 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), LITER.toDeciliters(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), LITER.toDeciliters(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), LITER.toDeciliters(-73.25), delta);
        msg = "-56229.321 * (1 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), LITER.toDeciliters(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), LITER.toDeciliters(-873.5432456), delta);
        msg = "0 * (1 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), LITER.toDeciliters(0.0), delta);
        msg = "0.1 * (1 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), LITER.toDeciliters(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), LITER.toDeciliters(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), LITER.toDeciliters(0.33), delta);
        msg = "0.6543 * (1 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), LITER.toDeciliters(0.6543), delta);
        msg = "1 * (1 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), LITER.toDeciliters(1.0), delta);
        msg = "1.6543 * (1 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), LITER.toDeciliters(1.6543), delta);
        msg = "22.45 * (1 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), LITER.toDeciliters(22.45), delta);
        msg = "9876.5432 * (1 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), LITER.toDeciliters(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), LITER.toDeciliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), LITER.toDeciliters(784.46789765434), delta);
        // ====================
        // ====================LITER
        // ====================
        // to_factor = 1.0
        to_factor = LITER.getFactor();
        msg = "-1 * (1 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), LITER.toLiters(-1.0), delta);
        msg = "-0.1 * (1 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), LITER.toLiters(-0.1), delta);
        msg = "-0.000456789 * (1 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), LITER.toLiters(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), LITER.toLiters(-73.25), delta);
        msg = "-56229.321 * (1 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), LITER.toLiters(-56229.321), delta);
        msg = "-873.5432456 * (1 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), LITER.toLiters(-873.5432456), delta);
        msg = "0 * (1 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), LITER.toLiters(0.0), delta);
        msg = "0.1 * (1 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), LITER.toLiters(0.1), delta);
        msg = "0.0000876543297 * (1 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), LITER.toLiters(8.76543297E-5), delta);
        msg = "0.33 * (1 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), LITER.toLiters(0.33), delta);
        msg = "0.6543 * (1 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), LITER.toLiters(0.6543), delta);
        msg = "1 * (1 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), LITER.toLiters(1.0), delta);
        msg = "1.6543 * (1 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), LITER.toLiters(1.6543), delta);
        msg = "22.45 * (1 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), LITER.toLiters(22.45), delta);
        msg = "9876.5432 * (1 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), LITER.toLiters(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), LITER.toLiters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), LITER.toLiters(784.46789765434), delta);
        // ====================
        // ====================DEKALITER
        // ====================
        // to_factor = 10.0
        to_factor = DEKALITER.getFactor();
        msg = "-1 / (10 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), LITER.toDekaliters(-1.0), delta);
        msg = "-0.1 / (10 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), LITER.toDekaliters(-0.1), delta);
        msg = "-0.000456789 / (10 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), LITER.toDekaliters(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), LITER.toDekaliters(-73.25), delta);
        msg = "-56229.321 / (10 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), LITER.toDekaliters(-56229.321), delta);
        msg = "-873.5432456 / (10 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), LITER.toDekaliters(-873.5432456), delta);
        msg = "0 / (10 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), LITER.toDekaliters(0.0), delta);
        msg = "0.1 / (10 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), LITER.toDekaliters(0.1), delta);
        msg = "0.0000876543297 / (10 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), LITER.toDekaliters(8.76543297E-5), delta);
        msg = "0.33 / (10 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), LITER.toDekaliters(0.33), delta);
        msg = "0.6543 / (10 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), LITER.toDekaliters(0.6543), delta);
        msg = "1 / (10 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), LITER.toDekaliters(1.0), delta);
        msg = "1.6543 / (10 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), LITER.toDekaliters(1.6543), delta);
        msg = "22.45 / (10 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), LITER.toDekaliters(22.45), delta);
        msg = "9876.5432 / (10 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), LITER.toDekaliters(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), LITER.toDekaliters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), LITER.toDekaliters(784.46789765434), delta);
        // ====================
        // ====================HECTOLITER
        // ====================
        // to_factor = 100.0
        to_factor = HECTOLITER.getFactor();
        msg = "-1 / (100 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), LITER.toHectoliters(-1.0), delta);
        msg = "-0.1 / (100 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), LITER.toHectoliters(-0.1), delta);
        msg = "-0.000456789 / (100 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), LITER.toHectoliters(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), LITER.toHectoliters(-73.25), delta);
        msg = "-56229.321 / (100 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), LITER.toHectoliters(-56229.321), delta);
        msg = "-873.5432456 / (100 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), LITER.toHectoliters(-873.5432456), delta);
        msg = "0 / (100 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), LITER.toHectoliters(0.0), delta);
        msg = "0.1 / (100 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), LITER.toHectoliters(0.1), delta);
        msg = "0.0000876543297 / (100 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), LITER.toHectoliters(8.76543297E-5), delta);
        msg = "0.33 / (100 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), LITER.toHectoliters(0.33), delta);
        msg = "0.6543 / (100 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), LITER.toHectoliters(0.6543), delta);
        msg = "1 / (100 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), LITER.toHectoliters(1.0), delta);
        msg = "1.6543 / (100 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), LITER.toHectoliters(1.6543), delta);
        msg = "22.45 / (100 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), LITER.toHectoliters(22.45), delta);
        msg = "9876.5432 / (100 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), LITER.toHectoliters(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), LITER.toHectoliters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), LITER.toHectoliters(784.46789765434), delta);
        // ====================
        // ====================KILOLITER
        // ====================
        // to_factor = 1000.0
        to_factor = KILOLITER.getFactor();
        msg = "-1 / (1000 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), LITER.toKiloliters(-1.0), delta);
        msg = "-0.1 / (1000 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), LITER.toKiloliters(-0.1), delta);
        msg = "-0.000456789 / (1000 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), LITER.toKiloliters(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), LITER.toKiloliters(-73.25), delta);
        msg = "-56229.321 / (1000 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), LITER.toKiloliters(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), LITER.toKiloliters(-873.5432456), delta);
        msg = "0 / (1000 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), LITER.toKiloliters(0.0), delta);
        msg = "0.1 / (1000 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), LITER.toKiloliters(0.1), delta);
        msg = "0.0000876543297 / (1000 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), LITER.toKiloliters(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), LITER.toKiloliters(0.33), delta);
        msg = "0.6543 / (1000 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), LITER.toKiloliters(0.6543), delta);
        msg = "1 / (1000 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), LITER.toKiloliters(1.0), delta);
        msg = "1.6543 / (1000 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), LITER.toKiloliters(1.6543), delta);
        msg = "22.45 / (1000 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), LITER.toKiloliters(22.45), delta);
        msg = "9876.5432 / (1000 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), LITER.toKiloliters(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), LITER.toKiloliters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), LITER.toKiloliters(784.46789765434), delta);
    }

    @Test()
    public void testDekaliter() {
        // from_factor = 10.0
        double from_factor = DEKALITER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLILITER
        // ====================
        // to_factor = 0.001
        to_factor = MILLILITER.getFactor();
        msg = "-1 * (10 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DEKALITER.toMilliliters(-1.0), delta);
        msg = "-0.1 * (10 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DEKALITER.toMilliliters(-0.1), delta);
        msg = "-0.000456789 * (10 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DEKALITER.toMilliliters(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DEKALITER.toMilliliters(-73.25), delta);
        msg = "-56229.321 * (10 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DEKALITER.toMilliliters(-56229.321), delta);
        msg = "-873.5432456 * (10 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DEKALITER.toMilliliters(-873.5432456), delta);
        msg = "0 * (10 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DEKALITER.toMilliliters(0.0), delta);
        msg = "0.1 * (10 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DEKALITER.toMilliliters(0.1), delta);
        msg = "0.0000876543297 * (10 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DEKALITER.toMilliliters(8.76543297E-5), delta);
        msg = "0.33 * (10 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DEKALITER.toMilliliters(0.33), delta);
        msg = "0.6543 * (10 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DEKALITER.toMilliliters(0.6543), delta);
        msg = "1 * (10 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DEKALITER.toMilliliters(1.0), delta);
        msg = "1.6543 * (10 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DEKALITER.toMilliliters(1.6543), delta);
        msg = "22.45 * (10 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DEKALITER.toMilliliters(22.45), delta);
        msg = "9876.5432 * (10 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DEKALITER.toMilliliters(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DEKALITER.toMilliliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DEKALITER.toMilliliters(784.46789765434), delta);
        // ====================
        // ====================CENTILITER
        // ====================
        // to_factor = 0.01
        to_factor = CENTILITER.getFactor();
        msg = "-1 * (10 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DEKALITER.toCentiliters(-1.0), delta);
        msg = "-0.1 * (10 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DEKALITER.toCentiliters(-0.1), delta);
        msg = "-0.000456789 * (10 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DEKALITER.toCentiliters(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DEKALITER.toCentiliters(-73.25), delta);
        msg = "-56229.321 * (10 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DEKALITER.toCentiliters(-56229.321), delta);
        msg = "-873.5432456 * (10 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DEKALITER.toCentiliters(-873.5432456), delta);
        msg = "0 * (10 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DEKALITER.toCentiliters(0.0), delta);
        msg = "0.1 * (10 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DEKALITER.toCentiliters(0.1), delta);
        msg = "0.0000876543297 * (10 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DEKALITER.toCentiliters(8.76543297E-5), delta);
        msg = "0.33 * (10 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DEKALITER.toCentiliters(0.33), delta);
        msg = "0.6543 * (10 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DEKALITER.toCentiliters(0.6543), delta);
        msg = "1 * (10 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DEKALITER.toCentiliters(1.0), delta);
        msg = "1.6543 * (10 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DEKALITER.toCentiliters(1.6543), delta);
        msg = "22.45 * (10 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DEKALITER.toCentiliters(22.45), delta);
        msg = "9876.5432 * (10 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DEKALITER.toCentiliters(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DEKALITER.toCentiliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DEKALITER.toCentiliters(784.46789765434), delta);
        // ====================
        // ====================DECILITER
        // ====================
        // to_factor = 0.1
        to_factor = DECILITER.getFactor();
        msg = "-1 * (10 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DEKALITER.toDeciliters(-1.0), delta);
        msg = "-0.1 * (10 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DEKALITER.toDeciliters(-0.1), delta);
        msg = "-0.000456789 * (10 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DEKALITER.toDeciliters(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DEKALITER.toDeciliters(-73.25), delta);
        msg = "-56229.321 * (10 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DEKALITER.toDeciliters(-56229.321), delta);
        msg = "-873.5432456 * (10 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DEKALITER.toDeciliters(-873.5432456), delta);
        msg = "0 * (10 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DEKALITER.toDeciliters(0.0), delta);
        msg = "0.1 * (10 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DEKALITER.toDeciliters(0.1), delta);
        msg = "0.0000876543297 * (10 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DEKALITER.toDeciliters(8.76543297E-5), delta);
        msg = "0.33 * (10 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DEKALITER.toDeciliters(0.33), delta);
        msg = "0.6543 * (10 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DEKALITER.toDeciliters(0.6543), delta);
        msg = "1 * (10 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DEKALITER.toDeciliters(1.0), delta);
        msg = "1.6543 * (10 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DEKALITER.toDeciliters(1.6543), delta);
        msg = "22.45 * (10 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DEKALITER.toDeciliters(22.45), delta);
        msg = "9876.5432 * (10 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DEKALITER.toDeciliters(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DEKALITER.toDeciliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DEKALITER.toDeciliters(784.46789765434), delta);
        // ====================
        // ====================LITER
        // ====================
        // to_factor = 1.0
        to_factor = LITER.getFactor();
        msg = "-1 * (10 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DEKALITER.toLiters(-1.0), delta);
        msg = "-0.1 * (10 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DEKALITER.toLiters(-0.1), delta);
        msg = "-0.000456789 * (10 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DEKALITER.toLiters(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DEKALITER.toLiters(-73.25), delta);
        msg = "-56229.321 * (10 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DEKALITER.toLiters(-56229.321), delta);
        msg = "-873.5432456 * (10 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DEKALITER.toLiters(-873.5432456), delta);
        msg = "0 * (10 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DEKALITER.toLiters(0.0), delta);
        msg = "0.1 * (10 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DEKALITER.toLiters(0.1), delta);
        msg = "0.0000876543297 * (10 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DEKALITER.toLiters(8.76543297E-5), delta);
        msg = "0.33 * (10 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DEKALITER.toLiters(0.33), delta);
        msg = "0.6543 * (10 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DEKALITER.toLiters(0.6543), delta);
        msg = "1 * (10 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DEKALITER.toLiters(1.0), delta);
        msg = "1.6543 * (10 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DEKALITER.toLiters(1.6543), delta);
        msg = "22.45 * (10 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DEKALITER.toLiters(22.45), delta);
        msg = "9876.5432 * (10 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DEKALITER.toLiters(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DEKALITER.toLiters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DEKALITER.toLiters(784.46789765434), delta);
        // ====================
        // ====================DEKALITER
        // ====================
        // to_factor = 10.0
        to_factor = DEKALITER.getFactor();
        msg = "-1 * (10 / 10)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DEKALITER.toDekaliters(-1.0), delta);
        msg = "-0.1 * (10 / 10)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DEKALITER.toDekaliters(-0.1), delta);
        msg = "-0.000456789 * (10 / 10)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DEKALITER.toDekaliters(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 10)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DEKALITER.toDekaliters(-73.25), delta);
        msg = "-56229.321 * (10 / 10)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DEKALITER.toDekaliters(-56229.321), delta);
        msg = "-873.5432456 * (10 / 10)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DEKALITER.toDekaliters(-873.5432456), delta);
        msg = "0 * (10 / 10)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DEKALITER.toDekaliters(0.0), delta);
        msg = "0.1 * (10 / 10)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DEKALITER.toDekaliters(0.1), delta);
        msg = "0.0000876543297 * (10 / 10)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DEKALITER.toDekaliters(8.76543297E-5), delta);
        msg = "0.33 * (10 / 10)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DEKALITER.toDekaliters(0.33), delta);
        msg = "0.6543 * (10 / 10)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DEKALITER.toDekaliters(0.6543), delta);
        msg = "1 * (10 / 10)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DEKALITER.toDekaliters(1.0), delta);
        msg = "1.6543 * (10 / 10)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DEKALITER.toDekaliters(1.6543), delta);
        msg = "22.45 * (10 / 10)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DEKALITER.toDekaliters(22.45), delta);
        msg = "9876.5432 * (10 / 10)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DEKALITER.toDekaliters(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 10)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DEKALITER.toDekaliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 10)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DEKALITER.toDekaliters(784.46789765434), delta);
        // ====================
        // ====================HECTOLITER
        // ====================
        // to_factor = 100.0
        to_factor = HECTOLITER.getFactor();
        msg = "-1 / (100 / 10)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DEKALITER.toHectoliters(-1.0), delta);
        msg = "-0.1 / (100 / 10)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DEKALITER.toHectoliters(-0.1), delta);
        msg = "-0.000456789 / (100 / 10)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DEKALITER.toHectoliters(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 10)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DEKALITER.toHectoliters(-73.25), delta);
        msg = "-56229.321 / (100 / 10)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DEKALITER.toHectoliters(-56229.321), delta);
        msg = "-873.5432456 / (100 / 10)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DEKALITER.toHectoliters(-873.5432456), delta);
        msg = "0 / (100 / 10)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DEKALITER.toHectoliters(0.0), delta);
        msg = "0.1 / (100 / 10)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DEKALITER.toHectoliters(0.1), delta);
        msg = "0.0000876543297 / (100 / 10)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DEKALITER.toHectoliters(8.76543297E-5), delta);
        msg = "0.33 / (100 / 10)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DEKALITER.toHectoliters(0.33), delta);
        msg = "0.6543 / (100 / 10)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DEKALITER.toHectoliters(0.6543), delta);
        msg = "1 / (100 / 10)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DEKALITER.toHectoliters(1.0), delta);
        msg = "1.6543 / (100 / 10)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DEKALITER.toHectoliters(1.6543), delta);
        msg = "22.45 / (100 / 10)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DEKALITER.toHectoliters(22.45), delta);
        msg = "9876.5432 / (100 / 10)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DEKALITER.toHectoliters(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 10)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DEKALITER.toHectoliters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 10)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DEKALITER.toHectoliters(784.46789765434), delta);
        // ====================
        // ====================KILOLITER
        // ====================
        // to_factor = 1000.0
        to_factor = KILOLITER.getFactor();
        msg = "-1 / (1000 / 10)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DEKALITER.toKiloliters(-1.0), delta);
        msg = "-0.1 / (1000 / 10)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DEKALITER.toKiloliters(-0.1), delta);
        msg = "-0.000456789 / (1000 / 10)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DEKALITER.toKiloliters(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 10)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DEKALITER.toKiloliters(-73.25), delta);
        msg = "-56229.321 / (1000 / 10)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DEKALITER.toKiloliters(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 10)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DEKALITER.toKiloliters(-873.5432456), delta);
        msg = "0 / (1000 / 10)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DEKALITER.toKiloliters(0.0), delta);
        msg = "0.1 / (1000 / 10)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DEKALITER.toKiloliters(0.1), delta);
        msg = "0.0000876543297 / (1000 / 10)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DEKALITER.toKiloliters(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 10)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DEKALITER.toKiloliters(0.33), delta);
        msg = "0.6543 / (1000 / 10)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DEKALITER.toKiloliters(0.6543), delta);
        msg = "1 / (1000 / 10)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DEKALITER.toKiloliters(1.0), delta);
        msg = "1.6543 / (1000 / 10)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DEKALITER.toKiloliters(1.6543), delta);
        msg = "22.45 / (1000 / 10)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DEKALITER.toKiloliters(22.45), delta);
        msg = "9876.5432 / (1000 / 10)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DEKALITER.toKiloliters(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 10)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DEKALITER.toKiloliters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 10)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DEKALITER.toKiloliters(784.46789765434), delta);
    }

    @Test()
    public void testHectoliter() {
        // from_factor = 100.0
        double from_factor = HECTOLITER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLILITER
        // ====================
        // to_factor = 0.001
        to_factor = MILLILITER.getFactor();
        msg = "-1 * (100 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HECTOLITER.toMilliliters(-1.0), delta);
        msg = "-0.1 * (100 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HECTOLITER.toMilliliters(-0.1), delta);
        msg = "-0.000456789 * (100 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HECTOLITER.toMilliliters(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HECTOLITER.toMilliliters(-73.25), delta);
        msg = "-56229.321 * (100 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HECTOLITER.toMilliliters(-56229.321), delta);
        msg = "-873.5432456 * (100 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HECTOLITER.toMilliliters(-873.5432456), delta);
        msg = "0 * (100 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HECTOLITER.toMilliliters(0.0), delta);
        msg = "0.1 * (100 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HECTOLITER.toMilliliters(0.1), delta);
        msg = "0.0000876543297 * (100 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HECTOLITER.toMilliliters(8.76543297E-5), delta);
        msg = "0.33 * (100 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HECTOLITER.toMilliliters(0.33), delta);
        msg = "0.6543 * (100 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HECTOLITER.toMilliliters(0.6543), delta);
        msg = "1 * (100 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HECTOLITER.toMilliliters(1.0), delta);
        msg = "1.6543 * (100 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HECTOLITER.toMilliliters(1.6543), delta);
        msg = "22.45 * (100 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HECTOLITER.toMilliliters(22.45), delta);
        msg = "9876.5432 * (100 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HECTOLITER.toMilliliters(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HECTOLITER.toMilliliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HECTOLITER.toMilliliters(784.46789765434), delta);
        // ====================
        // ====================CENTILITER
        // ====================
        // to_factor = 0.01
        to_factor = CENTILITER.getFactor();
        msg = "-1 * (100 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HECTOLITER.toCentiliters(-1.0), delta);
        msg = "-0.1 * (100 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HECTOLITER.toCentiliters(-0.1), delta);
        msg = "-0.000456789 * (100 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HECTOLITER.toCentiliters(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HECTOLITER.toCentiliters(-73.25), delta);
        msg = "-56229.321 * (100 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HECTOLITER.toCentiliters(-56229.321), delta);
        msg = "-873.5432456 * (100 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HECTOLITER.toCentiliters(-873.5432456), delta);
        msg = "0 * (100 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HECTOLITER.toCentiliters(0.0), delta);
        msg = "0.1 * (100 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HECTOLITER.toCentiliters(0.1), delta);
        msg = "0.0000876543297 * (100 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HECTOLITER.toCentiliters(8.76543297E-5), delta);
        msg = "0.33 * (100 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HECTOLITER.toCentiliters(0.33), delta);
        msg = "0.6543 * (100 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HECTOLITER.toCentiliters(0.6543), delta);
        msg = "1 * (100 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HECTOLITER.toCentiliters(1.0), delta);
        msg = "1.6543 * (100 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HECTOLITER.toCentiliters(1.6543), delta);
        msg = "22.45 * (100 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HECTOLITER.toCentiliters(22.45), delta);
        msg = "9876.5432 * (100 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HECTOLITER.toCentiliters(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HECTOLITER.toCentiliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HECTOLITER.toCentiliters(784.46789765434), delta);
        // ====================
        // ====================DECILITER
        // ====================
        // to_factor = 0.1
        to_factor = DECILITER.getFactor();
        msg = "-1 * (100 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HECTOLITER.toDeciliters(-1.0), delta);
        msg = "-0.1 * (100 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HECTOLITER.toDeciliters(-0.1), delta);
        msg = "-0.000456789 * (100 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HECTOLITER.toDeciliters(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HECTOLITER.toDeciliters(-73.25), delta);
        msg = "-56229.321 * (100 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HECTOLITER.toDeciliters(-56229.321), delta);
        msg = "-873.5432456 * (100 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HECTOLITER.toDeciliters(-873.5432456), delta);
        msg = "0 * (100 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HECTOLITER.toDeciliters(0.0), delta);
        msg = "0.1 * (100 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HECTOLITER.toDeciliters(0.1), delta);
        msg = "0.0000876543297 * (100 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HECTOLITER.toDeciliters(8.76543297E-5), delta);
        msg = "0.33 * (100 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HECTOLITER.toDeciliters(0.33), delta);
        msg = "0.6543 * (100 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HECTOLITER.toDeciliters(0.6543), delta);
        msg = "1 * (100 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HECTOLITER.toDeciliters(1.0), delta);
        msg = "1.6543 * (100 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HECTOLITER.toDeciliters(1.6543), delta);
        msg = "22.45 * (100 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HECTOLITER.toDeciliters(22.45), delta);
        msg = "9876.5432 * (100 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HECTOLITER.toDeciliters(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HECTOLITER.toDeciliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HECTOLITER.toDeciliters(784.46789765434), delta);
        // ====================
        // ====================LITER
        // ====================
        // to_factor = 1.0
        to_factor = LITER.getFactor();
        msg = "-1 * (100 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HECTOLITER.toLiters(-1.0), delta);
        msg = "-0.1 * (100 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HECTOLITER.toLiters(-0.1), delta);
        msg = "-0.000456789 * (100 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HECTOLITER.toLiters(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HECTOLITER.toLiters(-73.25), delta);
        msg = "-56229.321 * (100 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HECTOLITER.toLiters(-56229.321), delta);
        msg = "-873.5432456 * (100 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HECTOLITER.toLiters(-873.5432456), delta);
        msg = "0 * (100 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HECTOLITER.toLiters(0.0), delta);
        msg = "0.1 * (100 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HECTOLITER.toLiters(0.1), delta);
        msg = "0.0000876543297 * (100 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HECTOLITER.toLiters(8.76543297E-5), delta);
        msg = "0.33 * (100 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HECTOLITER.toLiters(0.33), delta);
        msg = "0.6543 * (100 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HECTOLITER.toLiters(0.6543), delta);
        msg = "1 * (100 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HECTOLITER.toLiters(1.0), delta);
        msg = "1.6543 * (100 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HECTOLITER.toLiters(1.6543), delta);
        msg = "22.45 * (100 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HECTOLITER.toLiters(22.45), delta);
        msg = "9876.5432 * (100 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HECTOLITER.toLiters(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HECTOLITER.toLiters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HECTOLITER.toLiters(784.46789765434), delta);
        // ====================
        // ====================DEKALITER
        // ====================
        // to_factor = 10.0
        to_factor = DEKALITER.getFactor();
        msg = "-1 * (100 / 10)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HECTOLITER.toDekaliters(-1.0), delta);
        msg = "-0.1 * (100 / 10)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HECTOLITER.toDekaliters(-0.1), delta);
        msg = "-0.000456789 * (100 / 10)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HECTOLITER.toDekaliters(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 10)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HECTOLITER.toDekaliters(-73.25), delta);
        msg = "-56229.321 * (100 / 10)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HECTOLITER.toDekaliters(-56229.321), delta);
        msg = "-873.5432456 * (100 / 10)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HECTOLITER.toDekaliters(-873.5432456), delta);
        msg = "0 * (100 / 10)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HECTOLITER.toDekaliters(0.0), delta);
        msg = "0.1 * (100 / 10)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HECTOLITER.toDekaliters(0.1), delta);
        msg = "0.0000876543297 * (100 / 10)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HECTOLITER.toDekaliters(8.76543297E-5), delta);
        msg = "0.33 * (100 / 10)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HECTOLITER.toDekaliters(0.33), delta);
        msg = "0.6543 * (100 / 10)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HECTOLITER.toDekaliters(0.6543), delta);
        msg = "1 * (100 / 10)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HECTOLITER.toDekaliters(1.0), delta);
        msg = "1.6543 * (100 / 10)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HECTOLITER.toDekaliters(1.6543), delta);
        msg = "22.45 * (100 / 10)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HECTOLITER.toDekaliters(22.45), delta);
        msg = "9876.5432 * (100 / 10)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HECTOLITER.toDekaliters(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 10)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HECTOLITER.toDekaliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 10)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HECTOLITER.toDekaliters(784.46789765434), delta);
        // ====================
        // ====================HECTOLITER
        // ====================
        // to_factor = 100.0
        to_factor = HECTOLITER.getFactor();
        msg = "-1 * (100 / 100)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HECTOLITER.toHectoliters(-1.0), delta);
        msg = "-0.1 * (100 / 100)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HECTOLITER.toHectoliters(-0.1), delta);
        msg = "-0.000456789 * (100 / 100)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HECTOLITER.toHectoliters(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 100)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HECTOLITER.toHectoliters(-73.25), delta);
        msg = "-56229.321 * (100 / 100)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HECTOLITER.toHectoliters(-56229.321), delta);
        msg = "-873.5432456 * (100 / 100)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HECTOLITER.toHectoliters(-873.5432456), delta);
        msg = "0 * (100 / 100)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HECTOLITER.toHectoliters(0.0), delta);
        msg = "0.1 * (100 / 100)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HECTOLITER.toHectoliters(0.1), delta);
        msg = "0.0000876543297 * (100 / 100)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HECTOLITER.toHectoliters(8.76543297E-5), delta);
        msg = "0.33 * (100 / 100)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HECTOLITER.toHectoliters(0.33), delta);
        msg = "0.6543 * (100 / 100)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HECTOLITER.toHectoliters(0.6543), delta);
        msg = "1 * (100 / 100)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HECTOLITER.toHectoliters(1.0), delta);
        msg = "1.6543 * (100 / 100)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HECTOLITER.toHectoliters(1.6543), delta);
        msg = "22.45 * (100 / 100)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HECTOLITER.toHectoliters(22.45), delta);
        msg = "9876.5432 * (100 / 100)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HECTOLITER.toHectoliters(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 100)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HECTOLITER.toHectoliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 100)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HECTOLITER.toHectoliters(784.46789765434), delta);
        // ====================
        // ====================KILOLITER
        // ====================
        // to_factor = 1000.0
        to_factor = KILOLITER.getFactor();
        msg = "-1 / (1000 / 100)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), HECTOLITER.toKiloliters(-1.0), delta);
        msg = "-0.1 / (1000 / 100)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), HECTOLITER.toKiloliters(-0.1), delta);
        msg = "-0.000456789 / (1000 / 100)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), HECTOLITER.toKiloliters(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 100)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), HECTOLITER.toKiloliters(-73.25), delta);
        msg = "-56229.321 / (1000 / 100)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), HECTOLITER.toKiloliters(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 100)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), HECTOLITER.toKiloliters(-873.5432456), delta);
        msg = "0 / (1000 / 100)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), HECTOLITER.toKiloliters(0.0), delta);
        msg = "0.1 / (1000 / 100)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), HECTOLITER.toKiloliters(0.1), delta);
        msg = "0.0000876543297 / (1000 / 100)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), HECTOLITER.toKiloliters(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 100)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), HECTOLITER.toKiloliters(0.33), delta);
        msg = "0.6543 / (1000 / 100)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), HECTOLITER.toKiloliters(0.6543), delta);
        msg = "1 / (1000 / 100)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), HECTOLITER.toKiloliters(1.0), delta);
        msg = "1.6543 / (1000 / 100)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), HECTOLITER.toKiloliters(1.6543), delta);
        msg = "22.45 / (1000 / 100)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), HECTOLITER.toKiloliters(22.45), delta);
        msg = "9876.5432 / (1000 / 100)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), HECTOLITER.toKiloliters(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 100)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), HECTOLITER.toKiloliters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 100)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), HECTOLITER.toKiloliters(784.46789765434), delta);
    }

    @Test()
    public void testKiloliter() {
        // from_factor = 1000.0
        double from_factor = KILOLITER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLILITER
        // ====================
        // to_factor = 0.001
        to_factor = MILLILITER.getFactor();
        msg = "-1 * (1000 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOLITER.toMilliliters(-1.0), delta);
        msg = "-0.1 * (1000 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOLITER.toMilliliters(-0.1), delta);
        msg = "-0.000456789 * (1000 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOLITER.toMilliliters(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOLITER.toMilliliters(-73.25), delta);
        msg = "-56229.321 * (1000 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOLITER.toMilliliters(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOLITER.toMilliliters(-873.5432456), delta);
        msg = "0 * (1000 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOLITER.toMilliliters(0.0), delta);
        msg = "0.1 * (1000 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOLITER.toMilliliters(0.1), delta);
        msg = "0.0000876543297 * (1000 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOLITER.toMilliliters(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOLITER.toMilliliters(0.33), delta);
        msg = "0.6543 * (1000 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOLITER.toMilliliters(0.6543), delta);
        msg = "1 * (1000 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOLITER.toMilliliters(1.0), delta);
        msg = "1.6543 * (1000 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOLITER.toMilliliters(1.6543), delta);
        msg = "22.45 * (1000 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOLITER.toMilliliters(22.45), delta);
        msg = "9876.5432 * (1000 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOLITER.toMilliliters(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOLITER.toMilliliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOLITER.toMilliliters(784.46789765434), delta);
        // ====================
        // ====================CENTILITER
        // ====================
        // to_factor = 0.01
        to_factor = CENTILITER.getFactor();
        msg = "-1 * (1000 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOLITER.toCentiliters(-1.0), delta);
        msg = "-0.1 * (1000 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOLITER.toCentiliters(-0.1), delta);
        msg = "-0.000456789 * (1000 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOLITER.toCentiliters(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOLITER.toCentiliters(-73.25), delta);
        msg = "-56229.321 * (1000 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOLITER.toCentiliters(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOLITER.toCentiliters(-873.5432456), delta);
        msg = "0 * (1000 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOLITER.toCentiliters(0.0), delta);
        msg = "0.1 * (1000 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOLITER.toCentiliters(0.1), delta);
        msg = "0.0000876543297 * (1000 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOLITER.toCentiliters(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOLITER.toCentiliters(0.33), delta);
        msg = "0.6543 * (1000 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOLITER.toCentiliters(0.6543), delta);
        msg = "1 * (1000 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOLITER.toCentiliters(1.0), delta);
        msg = "1.6543 * (1000 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOLITER.toCentiliters(1.6543), delta);
        msg = "22.45 * (1000 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOLITER.toCentiliters(22.45), delta);
        msg = "9876.5432 * (1000 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOLITER.toCentiliters(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOLITER.toCentiliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOLITER.toCentiliters(784.46789765434), delta);
        // ====================
        // ====================DECILITER
        // ====================
        // to_factor = 0.1
        to_factor = DECILITER.getFactor();
        msg = "-1 * (1000 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOLITER.toDeciliters(-1.0), delta);
        msg = "-0.1 * (1000 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOLITER.toDeciliters(-0.1), delta);
        msg = "-0.000456789 * (1000 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOLITER.toDeciliters(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOLITER.toDeciliters(-73.25), delta);
        msg = "-56229.321 * (1000 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOLITER.toDeciliters(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOLITER.toDeciliters(-873.5432456), delta);
        msg = "0 * (1000 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOLITER.toDeciliters(0.0), delta);
        msg = "0.1 * (1000 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOLITER.toDeciliters(0.1), delta);
        msg = "0.0000876543297 * (1000 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOLITER.toDeciliters(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOLITER.toDeciliters(0.33), delta);
        msg = "0.6543 * (1000 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOLITER.toDeciliters(0.6543), delta);
        msg = "1 * (1000 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOLITER.toDeciliters(1.0), delta);
        msg = "1.6543 * (1000 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOLITER.toDeciliters(1.6543), delta);
        msg = "22.45 * (1000 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOLITER.toDeciliters(22.45), delta);
        msg = "9876.5432 * (1000 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOLITER.toDeciliters(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOLITER.toDeciliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOLITER.toDeciliters(784.46789765434), delta);
        // ====================
        // ====================LITER
        // ====================
        // to_factor = 1.0
        to_factor = LITER.getFactor();
        msg = "-1 * (1000 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOLITER.toLiters(-1.0), delta);
        msg = "-0.1 * (1000 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOLITER.toLiters(-0.1), delta);
        msg = "-0.000456789 * (1000 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOLITER.toLiters(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOLITER.toLiters(-73.25), delta);
        msg = "-56229.321 * (1000 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOLITER.toLiters(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOLITER.toLiters(-873.5432456), delta);
        msg = "0 * (1000 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOLITER.toLiters(0.0), delta);
        msg = "0.1 * (1000 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOLITER.toLiters(0.1), delta);
        msg = "0.0000876543297 * (1000 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOLITER.toLiters(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOLITER.toLiters(0.33), delta);
        msg = "0.6543 * (1000 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOLITER.toLiters(0.6543), delta);
        msg = "1 * (1000 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOLITER.toLiters(1.0), delta);
        msg = "1.6543 * (1000 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOLITER.toLiters(1.6543), delta);
        msg = "22.45 * (1000 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOLITER.toLiters(22.45), delta);
        msg = "9876.5432 * (1000 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOLITER.toLiters(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOLITER.toLiters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOLITER.toLiters(784.46789765434), delta);
        // ====================
        // ====================DEKALITER
        // ====================
        // to_factor = 10.0
        to_factor = DEKALITER.getFactor();
        msg = "-1 * (1000 / 10)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOLITER.toDekaliters(-1.0), delta);
        msg = "-0.1 * (1000 / 10)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOLITER.toDekaliters(-0.1), delta);
        msg = "-0.000456789 * (1000 / 10)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOLITER.toDekaliters(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 10)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOLITER.toDekaliters(-73.25), delta);
        msg = "-56229.321 * (1000 / 10)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOLITER.toDekaliters(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 10)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOLITER.toDekaliters(-873.5432456), delta);
        msg = "0 * (1000 / 10)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOLITER.toDekaliters(0.0), delta);
        msg = "0.1 * (1000 / 10)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOLITER.toDekaliters(0.1), delta);
        msg = "0.0000876543297 * (1000 / 10)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOLITER.toDekaliters(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 10)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOLITER.toDekaliters(0.33), delta);
        msg = "0.6543 * (1000 / 10)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOLITER.toDekaliters(0.6543), delta);
        msg = "1 * (1000 / 10)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOLITER.toDekaliters(1.0), delta);
        msg = "1.6543 * (1000 / 10)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOLITER.toDekaliters(1.6543), delta);
        msg = "22.45 * (1000 / 10)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOLITER.toDekaliters(22.45), delta);
        msg = "9876.5432 * (1000 / 10)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOLITER.toDekaliters(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 10)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOLITER.toDekaliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 10)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOLITER.toDekaliters(784.46789765434), delta);
        // ====================
        // ====================HECTOLITER
        // ====================
        // to_factor = 100.0
        to_factor = HECTOLITER.getFactor();
        msg = "-1 * (1000 / 100)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOLITER.toHectoliters(-1.0), delta);
        msg = "-0.1 * (1000 / 100)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOLITER.toHectoliters(-0.1), delta);
        msg = "-0.000456789 * (1000 / 100)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOLITER.toHectoliters(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 100)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOLITER.toHectoliters(-73.25), delta);
        msg = "-56229.321 * (1000 / 100)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOLITER.toHectoliters(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 100)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOLITER.toHectoliters(-873.5432456), delta);
        msg = "0 * (1000 / 100)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOLITER.toHectoliters(0.0), delta);
        msg = "0.1 * (1000 / 100)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOLITER.toHectoliters(0.1), delta);
        msg = "0.0000876543297 * (1000 / 100)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOLITER.toHectoliters(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 100)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOLITER.toHectoliters(0.33), delta);
        msg = "0.6543 * (1000 / 100)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOLITER.toHectoliters(0.6543), delta);
        msg = "1 * (1000 / 100)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOLITER.toHectoliters(1.0), delta);
        msg = "1.6543 * (1000 / 100)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOLITER.toHectoliters(1.6543), delta);
        msg = "22.45 * (1000 / 100)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOLITER.toHectoliters(22.45), delta);
        msg = "9876.5432 * (1000 / 100)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOLITER.toHectoliters(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 100)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOLITER.toHectoliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 100)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOLITER.toHectoliters(784.46789765434), delta);
        // ====================
        // ====================KILOLITER
        // ====================
        // to_factor = 1000.0
        to_factor = KILOLITER.getFactor();
        msg = "-1 * (1000 / 1000)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOLITER.toKiloliters(-1.0), delta);
        msg = "-0.1 * (1000 / 1000)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOLITER.toKiloliters(-0.1), delta);
        msg = "-0.000456789 * (1000 / 1000)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOLITER.toKiloliters(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 1000)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOLITER.toKiloliters(-73.25), delta);
        msg = "-56229.321 * (1000 / 1000)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOLITER.toKiloliters(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 1000)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOLITER.toKiloliters(-873.5432456), delta);
        msg = "0 * (1000 / 1000)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOLITER.toKiloliters(0.0), delta);
        msg = "0.1 * (1000 / 1000)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOLITER.toKiloliters(0.1), delta);
        msg = "0.0000876543297 * (1000 / 1000)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOLITER.toKiloliters(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 1000)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOLITER.toKiloliters(0.33), delta);
        msg = "0.6543 * (1000 / 1000)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOLITER.toKiloliters(0.6543), delta);
        msg = "1 * (1000 / 1000)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOLITER.toKiloliters(1.0), delta);
        msg = "1.6543 * (1000 / 1000)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOLITER.toKiloliters(1.6543), delta);
        msg = "22.45 * (1000 / 1000)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOLITER.toKiloliters(22.45), delta);
        msg = "9876.5432 * (1000 / 1000)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOLITER.toKiloliters(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 1000)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOLITER.toKiloliters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 1000)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOLITER.toKiloliters(784.46789765434), delta);
    }
}
