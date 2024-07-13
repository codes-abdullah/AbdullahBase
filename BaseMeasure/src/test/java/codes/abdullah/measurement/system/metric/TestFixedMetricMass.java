package codes.abdullah.measurement.system.metric;

import static codes.abdullah.measurement.system.metric.Metrics.CENTIGRAM;
import static codes.abdullah.measurement.system.metric.Metrics.DECIGRAM;
import static codes.abdullah.measurement.system.metric.Metrics.DEKAGRAM;
import static codes.abdullah.measurement.system.metric.Metrics.GRAM;
import static codes.abdullah.measurement.system.metric.Metrics.HECOGRAM;
import static codes.abdullah.measurement.system.metric.Metrics.KILOGRAM;
import static codes.abdullah.measurement.system.metric.Metrics.MILLIGRAM;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFixedMetricMass {

    @Test()
    public void testMilligram() {
        // from_factor = 0.001
        double from_factor = MILLIGRAM.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLIGRAM
        // ====================
        // to_factor = 0.001
        to_factor = MILLIGRAM.getFactor();
        msg = "-1 * (0.001 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MILLIGRAM.toMilligrams(-1.0), delta);
        msg = "-0.1 * (0.001 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MILLIGRAM.toMilligrams(-0.1), delta);
        msg = "-0.000456789 * (0.001 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MILLIGRAM.toMilligrams(-4.56789E-4), delta);
        msg = "-73.25 * (0.001 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MILLIGRAM.toMilligrams(-73.25), delta);
        msg = "-56229.321 * (0.001 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MILLIGRAM.toMilligrams(-56229.321), delta);
        msg = "-873.5432456 * (0.001 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MILLIGRAM.toMilligrams(-873.5432456), delta);
        msg = "0 * (0.001 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MILLIGRAM.toMilligrams(0.0), delta);
        msg = "0.1 * (0.001 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MILLIGRAM.toMilligrams(0.1), delta);
        msg = "0.0000876543297 * (0.001 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MILLIGRAM.toMilligrams(8.76543297E-5), delta);
        msg = "0.33 * (0.001 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MILLIGRAM.toMilligrams(0.33), delta);
        msg = "0.6543 * (0.001 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MILLIGRAM.toMilligrams(0.6543), delta);
        msg = "1 * (0.001 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MILLIGRAM.toMilligrams(1.0), delta);
        msg = "1.6543 * (0.001 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MILLIGRAM.toMilligrams(1.6543), delta);
        msg = "22.45 * (0.001 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MILLIGRAM.toMilligrams(22.45), delta);
        msg = "9876.5432 * (0.001 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MILLIGRAM.toMilligrams(9876.5432), delta);
        msg = "1987654344.3345 * (0.001 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MILLIGRAM.toMilligrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.001 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MILLIGRAM.toMilligrams(784.46789765434), delta);
        // ====================
        // ====================CENTIGRAM
        // ====================
        // to_factor = 0.01
        to_factor = CENTIGRAM.getFactor();
        msg = "-1 / (0.01 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLIGRAM.toCentigrams(-1.0), delta);
        msg = "-0.1 / (0.01 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLIGRAM.toCentigrams(-0.1), delta);
        msg = "-0.000456789 / (0.01 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLIGRAM.toCentigrams(-4.56789E-4), delta);
        msg = "-73.25 / (0.01 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLIGRAM.toCentigrams(-73.25), delta);
        msg = "-56229.321 / (0.01 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLIGRAM.toCentigrams(-56229.321), delta);
        msg = "-873.5432456 / (0.01 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLIGRAM.toCentigrams(-873.5432456), delta);
        msg = "0 / (0.01 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLIGRAM.toCentigrams(0.0), delta);
        msg = "0.1 / (0.01 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLIGRAM.toCentigrams(0.1), delta);
        msg = "0.0000876543297 / (0.01 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLIGRAM.toCentigrams(8.76543297E-5), delta);
        msg = "0.33 / (0.01 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLIGRAM.toCentigrams(0.33), delta);
        msg = "0.6543 / (0.01 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLIGRAM.toCentigrams(0.6543), delta);
        msg = "1 / (0.01 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLIGRAM.toCentigrams(1.0), delta);
        msg = "1.6543 / (0.01 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLIGRAM.toCentigrams(1.6543), delta);
        msg = "22.45 / (0.01 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLIGRAM.toCentigrams(22.45), delta);
        msg = "9876.5432 / (0.01 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLIGRAM.toCentigrams(9876.5432), delta);
        msg = "1987654344.3345 / (0.01 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLIGRAM.toCentigrams(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.01 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLIGRAM.toCentigrams(784.46789765434), delta);
        // ====================
        // ====================DECIGRAM
        // ====================
        // to_factor = 0.1
        to_factor = DECIGRAM.getFactor();
        msg = "-1 / (0.1 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLIGRAM.toDecigrams(-1.0), delta);
        msg = "-0.1 / (0.1 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLIGRAM.toDecigrams(-0.1), delta);
        msg = "-0.000456789 / (0.1 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLIGRAM.toDecigrams(-4.56789E-4), delta);
        msg = "-73.25 / (0.1 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLIGRAM.toDecigrams(-73.25), delta);
        msg = "-56229.321 / (0.1 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLIGRAM.toDecigrams(-56229.321), delta);
        msg = "-873.5432456 / (0.1 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLIGRAM.toDecigrams(-873.5432456), delta);
        msg = "0 / (0.1 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLIGRAM.toDecigrams(0.0), delta);
        msg = "0.1 / (0.1 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLIGRAM.toDecigrams(0.1), delta);
        msg = "0.0000876543297 / (0.1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLIGRAM.toDecigrams(8.76543297E-5), delta);
        msg = "0.33 / (0.1 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLIGRAM.toDecigrams(0.33), delta);
        msg = "0.6543 / (0.1 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLIGRAM.toDecigrams(0.6543), delta);
        msg = "1 / (0.1 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLIGRAM.toDecigrams(1.0), delta);
        msg = "1.6543 / (0.1 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLIGRAM.toDecigrams(1.6543), delta);
        msg = "22.45 / (0.1 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLIGRAM.toDecigrams(22.45), delta);
        msg = "9876.5432 / (0.1 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLIGRAM.toDecigrams(9876.5432), delta);
        msg = "1987654344.3345 / (0.1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLIGRAM.toDecigrams(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.1 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLIGRAM.toDecigrams(784.46789765434), delta);
        // ====================
        // ====================GRAM
        // ====================
        // to_factor = 1.0
        to_factor = GRAM.getFactor();
        msg = "-1 / (1 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLIGRAM.toGrams(-1.0), delta);
        msg = "-0.1 / (1 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLIGRAM.toGrams(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLIGRAM.toGrams(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLIGRAM.toGrams(-73.25), delta);
        msg = "-56229.321 / (1 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLIGRAM.toGrams(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLIGRAM.toGrams(-873.5432456), delta);
        msg = "0 / (1 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLIGRAM.toGrams(0.0), delta);
        msg = "0.1 / (1 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLIGRAM.toGrams(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLIGRAM.toGrams(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLIGRAM.toGrams(0.33), delta);
        msg = "0.6543 / (1 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLIGRAM.toGrams(0.6543), delta);
        msg = "1 / (1 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLIGRAM.toGrams(1.0), delta);
        msg = "1.6543 / (1 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLIGRAM.toGrams(1.6543), delta);
        msg = "22.45 / (1 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLIGRAM.toGrams(22.45), delta);
        msg = "9876.5432 / (1 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLIGRAM.toGrams(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLIGRAM.toGrams(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLIGRAM.toGrams(784.46789765434), delta);
        // ====================
        // ====================DEKAGRAM
        // ====================
        // to_factor = 10.0
        to_factor = DEKAGRAM.getFactor();
        msg = "-1 / (10 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLIGRAM.toDekagrams(-1.0), delta);
        msg = "-0.1 / (10 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLIGRAM.toDekagrams(-0.1), delta);
        msg = "-0.000456789 / (10 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLIGRAM.toDekagrams(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLIGRAM.toDekagrams(-73.25), delta);
        msg = "-56229.321 / (10 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLIGRAM.toDekagrams(-56229.321), delta);
        msg = "-873.5432456 / (10 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLIGRAM.toDekagrams(-873.5432456), delta);
        msg = "0 / (10 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLIGRAM.toDekagrams(0.0), delta);
        msg = "0.1 / (10 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLIGRAM.toDekagrams(0.1), delta);
        msg = "0.0000876543297 / (10 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLIGRAM.toDekagrams(8.76543297E-5), delta);
        msg = "0.33 / (10 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLIGRAM.toDekagrams(0.33), delta);
        msg = "0.6543 / (10 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLIGRAM.toDekagrams(0.6543), delta);
        msg = "1 / (10 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLIGRAM.toDekagrams(1.0), delta);
        msg = "1.6543 / (10 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLIGRAM.toDekagrams(1.6543), delta);
        msg = "22.45 / (10 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLIGRAM.toDekagrams(22.45), delta);
        msg = "9876.5432 / (10 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLIGRAM.toDekagrams(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLIGRAM.toDekagrams(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLIGRAM.toDekagrams(784.46789765434), delta);
        // ====================
        // ====================HECOGRAM
        // ====================
        // to_factor = 100.0
        to_factor = HECOGRAM.getFactor();
        msg = "-1 / (100 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLIGRAM.toHecograms(-1.0), delta);
        msg = "-0.1 / (100 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLIGRAM.toHecograms(-0.1), delta);
        msg = "-0.000456789 / (100 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLIGRAM.toHecograms(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLIGRAM.toHecograms(-73.25), delta);
        msg = "-56229.321 / (100 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLIGRAM.toHecograms(-56229.321), delta);
        msg = "-873.5432456 / (100 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLIGRAM.toHecograms(-873.5432456), delta);
        msg = "0 / (100 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLIGRAM.toHecograms(0.0), delta);
        msg = "0.1 / (100 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLIGRAM.toHecograms(0.1), delta);
        msg = "0.0000876543297 / (100 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLIGRAM.toHecograms(8.76543297E-5), delta);
        msg = "0.33 / (100 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLIGRAM.toHecograms(0.33), delta);
        msg = "0.6543 / (100 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLIGRAM.toHecograms(0.6543), delta);
        msg = "1 / (100 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLIGRAM.toHecograms(1.0), delta);
        msg = "1.6543 / (100 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLIGRAM.toHecograms(1.6543), delta);
        msg = "22.45 / (100 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLIGRAM.toHecograms(22.45), delta);
        msg = "9876.5432 / (100 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLIGRAM.toHecograms(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLIGRAM.toHecograms(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLIGRAM.toHecograms(784.46789765434), delta);
        // ====================
        // ====================KILOGRAM
        // ====================
        // to_factor = 1000.0
        to_factor = KILOGRAM.getFactor();
        msg = "-1 / (1000 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLIGRAM.toKilograms(-1.0), delta);
        msg = "-0.1 / (1000 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLIGRAM.toKilograms(-0.1), delta);
        msg = "-0.000456789 / (1000 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLIGRAM.toKilograms(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLIGRAM.toKilograms(-73.25), delta);
        msg = "-56229.321 / (1000 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLIGRAM.toKilograms(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLIGRAM.toKilograms(-873.5432456), delta);
        msg = "0 / (1000 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLIGRAM.toKilograms(0.0), delta);
        msg = "0.1 / (1000 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLIGRAM.toKilograms(0.1), delta);
        msg = "0.0000876543297 / (1000 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLIGRAM.toKilograms(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLIGRAM.toKilograms(0.33), delta);
        msg = "0.6543 / (1000 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLIGRAM.toKilograms(0.6543), delta);
        msg = "1 / (1000 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLIGRAM.toKilograms(1.0), delta);
        msg = "1.6543 / (1000 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLIGRAM.toKilograms(1.6543), delta);
        msg = "22.45 / (1000 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLIGRAM.toKilograms(22.45), delta);
        msg = "9876.5432 / (1000 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLIGRAM.toKilograms(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLIGRAM.toKilograms(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLIGRAM.toKilograms(784.46789765434), delta);
    }

    @Test()
    public void testCentigram() {
        // from_factor = 0.01
        double from_factor = CENTIGRAM.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLIGRAM
        // ====================
        // to_factor = 0.001
        to_factor = MILLIGRAM.getFactor();
        msg = "-1 * (0.01 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CENTIGRAM.toMilligrams(-1.0), delta);
        msg = "-0.1 * (0.01 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CENTIGRAM.toMilligrams(-0.1), delta);
        msg = "-0.000456789 * (0.01 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CENTIGRAM.toMilligrams(-4.56789E-4), delta);
        msg = "-73.25 * (0.01 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CENTIGRAM.toMilligrams(-73.25), delta);
        msg = "-56229.321 * (0.01 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CENTIGRAM.toMilligrams(-56229.321), delta);
        msg = "-873.5432456 * (0.01 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CENTIGRAM.toMilligrams(-873.5432456), delta);
        msg = "0 * (0.01 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CENTIGRAM.toMilligrams(0.0), delta);
        msg = "0.1 * (0.01 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CENTIGRAM.toMilligrams(0.1), delta);
        msg = "0.0000876543297 * (0.01 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CENTIGRAM.toMilligrams(8.76543297E-5), delta);
        msg = "0.33 * (0.01 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CENTIGRAM.toMilligrams(0.33), delta);
        msg = "0.6543 * (0.01 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CENTIGRAM.toMilligrams(0.6543), delta);
        msg = "1 * (0.01 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CENTIGRAM.toMilligrams(1.0), delta);
        msg = "1.6543 * (0.01 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CENTIGRAM.toMilligrams(1.6543), delta);
        msg = "22.45 * (0.01 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CENTIGRAM.toMilligrams(22.45), delta);
        msg = "9876.5432 * (0.01 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CENTIGRAM.toMilligrams(9876.5432), delta);
        msg = "1987654344.3345 * (0.01 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CENTIGRAM.toMilligrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.01 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CENTIGRAM.toMilligrams(784.46789765434), delta);
        // ====================
        // ====================CENTIGRAM
        // ====================
        // to_factor = 0.01
        to_factor = CENTIGRAM.getFactor();
        msg = "-1 * (0.01 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CENTIGRAM.toCentigrams(-1.0), delta);
        msg = "-0.1 * (0.01 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CENTIGRAM.toCentigrams(-0.1), delta);
        msg = "-0.000456789 * (0.01 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CENTIGRAM.toCentigrams(-4.56789E-4), delta);
        msg = "-73.25 * (0.01 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CENTIGRAM.toCentigrams(-73.25), delta);
        msg = "-56229.321 * (0.01 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CENTIGRAM.toCentigrams(-56229.321), delta);
        msg = "-873.5432456 * (0.01 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CENTIGRAM.toCentigrams(-873.5432456), delta);
        msg = "0 * (0.01 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CENTIGRAM.toCentigrams(0.0), delta);
        msg = "0.1 * (0.01 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CENTIGRAM.toCentigrams(0.1), delta);
        msg = "0.0000876543297 * (0.01 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CENTIGRAM.toCentigrams(8.76543297E-5), delta);
        msg = "0.33 * (0.01 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CENTIGRAM.toCentigrams(0.33), delta);
        msg = "0.6543 * (0.01 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CENTIGRAM.toCentigrams(0.6543), delta);
        msg = "1 * (0.01 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CENTIGRAM.toCentigrams(1.0), delta);
        msg = "1.6543 * (0.01 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CENTIGRAM.toCentigrams(1.6543), delta);
        msg = "22.45 * (0.01 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CENTIGRAM.toCentigrams(22.45), delta);
        msg = "9876.5432 * (0.01 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CENTIGRAM.toCentigrams(9876.5432), delta);
        msg = "1987654344.3345 * (0.01 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CENTIGRAM.toCentigrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.01 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CENTIGRAM.toCentigrams(784.46789765434), delta);
        // ====================
        // ====================DECIGRAM
        // ====================
        // to_factor = 0.1
        to_factor = DECIGRAM.getFactor();
        msg = "-1 / (0.1 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), CENTIGRAM.toDecigrams(-1.0), delta);
        msg = "-0.1 / (0.1 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), CENTIGRAM.toDecigrams(-0.1), delta);
        msg = "-0.000456789 / (0.1 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), CENTIGRAM.toDecigrams(-4.56789E-4), delta);
        msg = "-73.25 / (0.1 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), CENTIGRAM.toDecigrams(-73.25), delta);
        msg = "-56229.321 / (0.1 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), CENTIGRAM.toDecigrams(-56229.321), delta);
        msg = "-873.5432456 / (0.1 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), CENTIGRAM.toDecigrams(-873.5432456), delta);
        msg = "0 / (0.1 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), CENTIGRAM.toDecigrams(0.0), delta);
        msg = "0.1 / (0.1 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), CENTIGRAM.toDecigrams(0.1), delta);
        msg = "0.0000876543297 / (0.1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), CENTIGRAM.toDecigrams(8.76543297E-5), delta);
        msg = "0.33 / (0.1 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), CENTIGRAM.toDecigrams(0.33), delta);
        msg = "0.6543 / (0.1 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), CENTIGRAM.toDecigrams(0.6543), delta);
        msg = "1 / (0.1 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), CENTIGRAM.toDecigrams(1.0), delta);
        msg = "1.6543 / (0.1 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), CENTIGRAM.toDecigrams(1.6543), delta);
        msg = "22.45 / (0.1 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), CENTIGRAM.toDecigrams(22.45), delta);
        msg = "9876.5432 / (0.1 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), CENTIGRAM.toDecigrams(9876.5432), delta);
        msg = "1987654344.3345 / (0.1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), CENTIGRAM.toDecigrams(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.1 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), CENTIGRAM.toDecigrams(784.46789765434), delta);
        // ====================
        // ====================GRAM
        // ====================
        // to_factor = 1.0
        to_factor = GRAM.getFactor();
        msg = "-1 / (1 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), CENTIGRAM.toGrams(-1.0), delta);
        msg = "-0.1 / (1 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), CENTIGRAM.toGrams(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), CENTIGRAM.toGrams(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), CENTIGRAM.toGrams(-73.25), delta);
        msg = "-56229.321 / (1 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), CENTIGRAM.toGrams(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), CENTIGRAM.toGrams(-873.5432456), delta);
        msg = "0 / (1 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), CENTIGRAM.toGrams(0.0), delta);
        msg = "0.1 / (1 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), CENTIGRAM.toGrams(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), CENTIGRAM.toGrams(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), CENTIGRAM.toGrams(0.33), delta);
        msg = "0.6543 / (1 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), CENTIGRAM.toGrams(0.6543), delta);
        msg = "1 / (1 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), CENTIGRAM.toGrams(1.0), delta);
        msg = "1.6543 / (1 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), CENTIGRAM.toGrams(1.6543), delta);
        msg = "22.45 / (1 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), CENTIGRAM.toGrams(22.45), delta);
        msg = "9876.5432 / (1 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), CENTIGRAM.toGrams(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), CENTIGRAM.toGrams(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), CENTIGRAM.toGrams(784.46789765434), delta);
        // ====================
        // ====================DEKAGRAM
        // ====================
        // to_factor = 10.0
        to_factor = DEKAGRAM.getFactor();
        msg = "-1 / (10 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), CENTIGRAM.toDekagrams(-1.0), delta);
        msg = "-0.1 / (10 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), CENTIGRAM.toDekagrams(-0.1), delta);
        msg = "-0.000456789 / (10 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), CENTIGRAM.toDekagrams(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), CENTIGRAM.toDekagrams(-73.25), delta);
        msg = "-56229.321 / (10 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), CENTIGRAM.toDekagrams(-56229.321), delta);
        msg = "-873.5432456 / (10 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), CENTIGRAM.toDekagrams(-873.5432456), delta);
        msg = "0 / (10 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), CENTIGRAM.toDekagrams(0.0), delta);
        msg = "0.1 / (10 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), CENTIGRAM.toDekagrams(0.1), delta);
        msg = "0.0000876543297 / (10 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), CENTIGRAM.toDekagrams(8.76543297E-5), delta);
        msg = "0.33 / (10 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), CENTIGRAM.toDekagrams(0.33), delta);
        msg = "0.6543 / (10 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), CENTIGRAM.toDekagrams(0.6543), delta);
        msg = "1 / (10 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), CENTIGRAM.toDekagrams(1.0), delta);
        msg = "1.6543 / (10 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), CENTIGRAM.toDekagrams(1.6543), delta);
        msg = "22.45 / (10 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), CENTIGRAM.toDekagrams(22.45), delta);
        msg = "9876.5432 / (10 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), CENTIGRAM.toDekagrams(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), CENTIGRAM.toDekagrams(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), CENTIGRAM.toDekagrams(784.46789765434), delta);
        // ====================
        // ====================HECOGRAM
        // ====================
        // to_factor = 100.0
        to_factor = HECOGRAM.getFactor();
        msg = "-1 / (100 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), CENTIGRAM.toHecograms(-1.0), delta);
        msg = "-0.1 / (100 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), CENTIGRAM.toHecograms(-0.1), delta);
        msg = "-0.000456789 / (100 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), CENTIGRAM.toHecograms(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), CENTIGRAM.toHecograms(-73.25), delta);
        msg = "-56229.321 / (100 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), CENTIGRAM.toHecograms(-56229.321), delta);
        msg = "-873.5432456 / (100 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), CENTIGRAM.toHecograms(-873.5432456), delta);
        msg = "0 / (100 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), CENTIGRAM.toHecograms(0.0), delta);
        msg = "0.1 / (100 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), CENTIGRAM.toHecograms(0.1), delta);
        msg = "0.0000876543297 / (100 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), CENTIGRAM.toHecograms(8.76543297E-5), delta);
        msg = "0.33 / (100 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), CENTIGRAM.toHecograms(0.33), delta);
        msg = "0.6543 / (100 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), CENTIGRAM.toHecograms(0.6543), delta);
        msg = "1 / (100 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), CENTIGRAM.toHecograms(1.0), delta);
        msg = "1.6543 / (100 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), CENTIGRAM.toHecograms(1.6543), delta);
        msg = "22.45 / (100 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), CENTIGRAM.toHecograms(22.45), delta);
        msg = "9876.5432 / (100 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), CENTIGRAM.toHecograms(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), CENTIGRAM.toHecograms(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), CENTIGRAM.toHecograms(784.46789765434), delta);
        // ====================
        // ====================KILOGRAM
        // ====================
        // to_factor = 1000.0
        to_factor = KILOGRAM.getFactor();
        msg = "-1 / (1000 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), CENTIGRAM.toKilograms(-1.0), delta);
        msg = "-0.1 / (1000 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), CENTIGRAM.toKilograms(-0.1), delta);
        msg = "-0.000456789 / (1000 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), CENTIGRAM.toKilograms(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), CENTIGRAM.toKilograms(-73.25), delta);
        msg = "-56229.321 / (1000 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), CENTIGRAM.toKilograms(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), CENTIGRAM.toKilograms(-873.5432456), delta);
        msg = "0 / (1000 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), CENTIGRAM.toKilograms(0.0), delta);
        msg = "0.1 / (1000 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), CENTIGRAM.toKilograms(0.1), delta);
        msg = "0.0000876543297 / (1000 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), CENTIGRAM.toKilograms(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), CENTIGRAM.toKilograms(0.33), delta);
        msg = "0.6543 / (1000 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), CENTIGRAM.toKilograms(0.6543), delta);
        msg = "1 / (1000 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), CENTIGRAM.toKilograms(1.0), delta);
        msg = "1.6543 / (1000 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), CENTIGRAM.toKilograms(1.6543), delta);
        msg = "22.45 / (1000 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), CENTIGRAM.toKilograms(22.45), delta);
        msg = "9876.5432 / (1000 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), CENTIGRAM.toKilograms(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), CENTIGRAM.toKilograms(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), CENTIGRAM.toKilograms(784.46789765434), delta);
    }

    @Test()
    public void testDecigram() {
        // from_factor = 0.1
        double from_factor = DECIGRAM.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLIGRAM
        // ====================
        // to_factor = 0.001
        to_factor = MILLIGRAM.getFactor();
        msg = "-1 * (0.1 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DECIGRAM.toMilligrams(-1.0), delta);
        msg = "-0.1 * (0.1 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DECIGRAM.toMilligrams(-0.1), delta);
        msg = "-0.000456789 * (0.1 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DECIGRAM.toMilligrams(-4.56789E-4), delta);
        msg = "-73.25 * (0.1 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DECIGRAM.toMilligrams(-73.25), delta);
        msg = "-56229.321 * (0.1 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DECIGRAM.toMilligrams(-56229.321), delta);
        msg = "-873.5432456 * (0.1 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DECIGRAM.toMilligrams(-873.5432456), delta);
        msg = "0 * (0.1 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DECIGRAM.toMilligrams(0.0), delta);
        msg = "0.1 * (0.1 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DECIGRAM.toMilligrams(0.1), delta);
        msg = "0.0000876543297 * (0.1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DECIGRAM.toMilligrams(8.76543297E-5), delta);
        msg = "0.33 * (0.1 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DECIGRAM.toMilligrams(0.33), delta);
        msg = "0.6543 * (0.1 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DECIGRAM.toMilligrams(0.6543), delta);
        msg = "1 * (0.1 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DECIGRAM.toMilligrams(1.0), delta);
        msg = "1.6543 * (0.1 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DECIGRAM.toMilligrams(1.6543), delta);
        msg = "22.45 * (0.1 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DECIGRAM.toMilligrams(22.45), delta);
        msg = "9876.5432 * (0.1 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DECIGRAM.toMilligrams(9876.5432), delta);
        msg = "1987654344.3345 * (0.1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DECIGRAM.toMilligrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.1 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DECIGRAM.toMilligrams(784.46789765434), delta);
        // ====================
        // ====================CENTIGRAM
        // ====================
        // to_factor = 0.01
        to_factor = CENTIGRAM.getFactor();
        msg = "-1 * (0.1 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DECIGRAM.toCentigrams(-1.0), delta);
        msg = "-0.1 * (0.1 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DECIGRAM.toCentigrams(-0.1), delta);
        msg = "-0.000456789 * (0.1 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DECIGRAM.toCentigrams(-4.56789E-4), delta);
        msg = "-73.25 * (0.1 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DECIGRAM.toCentigrams(-73.25), delta);
        msg = "-56229.321 * (0.1 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DECIGRAM.toCentigrams(-56229.321), delta);
        msg = "-873.5432456 * (0.1 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DECIGRAM.toCentigrams(-873.5432456), delta);
        msg = "0 * (0.1 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DECIGRAM.toCentigrams(0.0), delta);
        msg = "0.1 * (0.1 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DECIGRAM.toCentigrams(0.1), delta);
        msg = "0.0000876543297 * (0.1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DECIGRAM.toCentigrams(8.76543297E-5), delta);
        msg = "0.33 * (0.1 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DECIGRAM.toCentigrams(0.33), delta);
        msg = "0.6543 * (0.1 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DECIGRAM.toCentigrams(0.6543), delta);
        msg = "1 * (0.1 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DECIGRAM.toCentigrams(1.0), delta);
        msg = "1.6543 * (0.1 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DECIGRAM.toCentigrams(1.6543), delta);
        msg = "22.45 * (0.1 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DECIGRAM.toCentigrams(22.45), delta);
        msg = "9876.5432 * (0.1 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DECIGRAM.toCentigrams(9876.5432), delta);
        msg = "1987654344.3345 * (0.1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DECIGRAM.toCentigrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.1 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DECIGRAM.toCentigrams(784.46789765434), delta);
        // ====================
        // ====================DECIGRAM
        // ====================
        // to_factor = 0.1
        to_factor = DECIGRAM.getFactor();
        msg = "-1 * (0.1 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DECIGRAM.toDecigrams(-1.0), delta);
        msg = "-0.1 * (0.1 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DECIGRAM.toDecigrams(-0.1), delta);
        msg = "-0.000456789 * (0.1 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DECIGRAM.toDecigrams(-4.56789E-4), delta);
        msg = "-73.25 * (0.1 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DECIGRAM.toDecigrams(-73.25), delta);
        msg = "-56229.321 * (0.1 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DECIGRAM.toDecigrams(-56229.321), delta);
        msg = "-873.5432456 * (0.1 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DECIGRAM.toDecigrams(-873.5432456), delta);
        msg = "0 * (0.1 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DECIGRAM.toDecigrams(0.0), delta);
        msg = "0.1 * (0.1 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DECIGRAM.toDecigrams(0.1), delta);
        msg = "0.0000876543297 * (0.1 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DECIGRAM.toDecigrams(8.76543297E-5), delta);
        msg = "0.33 * (0.1 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DECIGRAM.toDecigrams(0.33), delta);
        msg = "0.6543 * (0.1 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DECIGRAM.toDecigrams(0.6543), delta);
        msg = "1 * (0.1 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DECIGRAM.toDecigrams(1.0), delta);
        msg = "1.6543 * (0.1 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DECIGRAM.toDecigrams(1.6543), delta);
        msg = "22.45 * (0.1 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DECIGRAM.toDecigrams(22.45), delta);
        msg = "9876.5432 * (0.1 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DECIGRAM.toDecigrams(9876.5432), delta);
        msg = "1987654344.3345 * (0.1 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DECIGRAM.toDecigrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.1 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DECIGRAM.toDecigrams(784.46789765434), delta);
        // ====================
        // ====================GRAM
        // ====================
        // to_factor = 1.0
        to_factor = GRAM.getFactor();
        msg = "-1 / (1 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DECIGRAM.toGrams(-1.0), delta);
        msg = "-0.1 / (1 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DECIGRAM.toGrams(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DECIGRAM.toGrams(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DECIGRAM.toGrams(-73.25), delta);
        msg = "-56229.321 / (1 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DECIGRAM.toGrams(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DECIGRAM.toGrams(-873.5432456), delta);
        msg = "0 / (1 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DECIGRAM.toGrams(0.0), delta);
        msg = "0.1 / (1 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DECIGRAM.toGrams(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DECIGRAM.toGrams(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DECIGRAM.toGrams(0.33), delta);
        msg = "0.6543 / (1 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DECIGRAM.toGrams(0.6543), delta);
        msg = "1 / (1 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DECIGRAM.toGrams(1.0), delta);
        msg = "1.6543 / (1 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DECIGRAM.toGrams(1.6543), delta);
        msg = "22.45 / (1 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DECIGRAM.toGrams(22.45), delta);
        msg = "9876.5432 / (1 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DECIGRAM.toGrams(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DECIGRAM.toGrams(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DECIGRAM.toGrams(784.46789765434), delta);
        // ====================
        // ====================DEKAGRAM
        // ====================
        // to_factor = 10.0
        to_factor = DEKAGRAM.getFactor();
        msg = "-1 / (10 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DECIGRAM.toDekagrams(-1.0), delta);
        msg = "-0.1 / (10 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DECIGRAM.toDekagrams(-0.1), delta);
        msg = "-0.000456789 / (10 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DECIGRAM.toDekagrams(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DECIGRAM.toDekagrams(-73.25), delta);
        msg = "-56229.321 / (10 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DECIGRAM.toDekagrams(-56229.321), delta);
        msg = "-873.5432456 / (10 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DECIGRAM.toDekagrams(-873.5432456), delta);
        msg = "0 / (10 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DECIGRAM.toDekagrams(0.0), delta);
        msg = "0.1 / (10 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DECIGRAM.toDekagrams(0.1), delta);
        msg = "0.0000876543297 / (10 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DECIGRAM.toDekagrams(8.76543297E-5), delta);
        msg = "0.33 / (10 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DECIGRAM.toDekagrams(0.33), delta);
        msg = "0.6543 / (10 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DECIGRAM.toDekagrams(0.6543), delta);
        msg = "1 / (10 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DECIGRAM.toDekagrams(1.0), delta);
        msg = "1.6543 / (10 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DECIGRAM.toDekagrams(1.6543), delta);
        msg = "22.45 / (10 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DECIGRAM.toDekagrams(22.45), delta);
        msg = "9876.5432 / (10 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DECIGRAM.toDekagrams(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DECIGRAM.toDekagrams(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DECIGRAM.toDekagrams(784.46789765434), delta);
        // ====================
        // ====================HECOGRAM
        // ====================
        // to_factor = 100.0
        to_factor = HECOGRAM.getFactor();
        msg = "-1 / (100 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DECIGRAM.toHecograms(-1.0), delta);
        msg = "-0.1 / (100 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DECIGRAM.toHecograms(-0.1), delta);
        msg = "-0.000456789 / (100 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DECIGRAM.toHecograms(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DECIGRAM.toHecograms(-73.25), delta);
        msg = "-56229.321 / (100 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DECIGRAM.toHecograms(-56229.321), delta);
        msg = "-873.5432456 / (100 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DECIGRAM.toHecograms(-873.5432456), delta);
        msg = "0 / (100 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DECIGRAM.toHecograms(0.0), delta);
        msg = "0.1 / (100 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DECIGRAM.toHecograms(0.1), delta);
        msg = "0.0000876543297 / (100 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DECIGRAM.toHecograms(8.76543297E-5), delta);
        msg = "0.33 / (100 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DECIGRAM.toHecograms(0.33), delta);
        msg = "0.6543 / (100 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DECIGRAM.toHecograms(0.6543), delta);
        msg = "1 / (100 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DECIGRAM.toHecograms(1.0), delta);
        msg = "1.6543 / (100 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DECIGRAM.toHecograms(1.6543), delta);
        msg = "22.45 / (100 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DECIGRAM.toHecograms(22.45), delta);
        msg = "9876.5432 / (100 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DECIGRAM.toHecograms(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DECIGRAM.toHecograms(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DECIGRAM.toHecograms(784.46789765434), delta);
        // ====================
        // ====================KILOGRAM
        // ====================
        // to_factor = 1000.0
        to_factor = KILOGRAM.getFactor();
        msg = "-1 / (1000 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DECIGRAM.toKilograms(-1.0), delta);
        msg = "-0.1 / (1000 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DECIGRAM.toKilograms(-0.1), delta);
        msg = "-0.000456789 / (1000 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DECIGRAM.toKilograms(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DECIGRAM.toKilograms(-73.25), delta);
        msg = "-56229.321 / (1000 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DECIGRAM.toKilograms(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DECIGRAM.toKilograms(-873.5432456), delta);
        msg = "0 / (1000 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DECIGRAM.toKilograms(0.0), delta);
        msg = "0.1 / (1000 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DECIGRAM.toKilograms(0.1), delta);
        msg = "0.0000876543297 / (1000 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DECIGRAM.toKilograms(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DECIGRAM.toKilograms(0.33), delta);
        msg = "0.6543 / (1000 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DECIGRAM.toKilograms(0.6543), delta);
        msg = "1 / (1000 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DECIGRAM.toKilograms(1.0), delta);
        msg = "1.6543 / (1000 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DECIGRAM.toKilograms(1.6543), delta);
        msg = "22.45 / (1000 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DECIGRAM.toKilograms(22.45), delta);
        msg = "9876.5432 / (1000 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DECIGRAM.toKilograms(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DECIGRAM.toKilograms(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DECIGRAM.toKilograms(784.46789765434), delta);
    }

    @Test()
    public void testGram() {
        // from_factor = 1.0
        double from_factor = GRAM.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLIGRAM
        // ====================
        // to_factor = 0.001
        to_factor = MILLIGRAM.getFactor();
        msg = "-1 * (1 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GRAM.toMilligrams(-1.0), delta);
        msg = "-0.1 * (1 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GRAM.toMilligrams(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GRAM.toMilligrams(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GRAM.toMilligrams(-73.25), delta);
        msg = "-56229.321 * (1 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GRAM.toMilligrams(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GRAM.toMilligrams(-873.5432456), delta);
        msg = "0 * (1 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GRAM.toMilligrams(0.0), delta);
        msg = "0.1 * (1 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GRAM.toMilligrams(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GRAM.toMilligrams(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GRAM.toMilligrams(0.33), delta);
        msg = "0.6543 * (1 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GRAM.toMilligrams(0.6543), delta);
        msg = "1 * (1 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GRAM.toMilligrams(1.0), delta);
        msg = "1.6543 * (1 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GRAM.toMilligrams(1.6543), delta);
        msg = "22.45 * (1 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GRAM.toMilligrams(22.45), delta);
        msg = "9876.5432 * (1 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GRAM.toMilligrams(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GRAM.toMilligrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GRAM.toMilligrams(784.46789765434), delta);
        // ====================
        // ====================CENTIGRAM
        // ====================
        // to_factor = 0.01
        to_factor = CENTIGRAM.getFactor();
        msg = "-1 * (1 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GRAM.toCentigrams(-1.0), delta);
        msg = "-0.1 * (1 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GRAM.toCentigrams(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GRAM.toCentigrams(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GRAM.toCentigrams(-73.25), delta);
        msg = "-56229.321 * (1 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GRAM.toCentigrams(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GRAM.toCentigrams(-873.5432456), delta);
        msg = "0 * (1 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GRAM.toCentigrams(0.0), delta);
        msg = "0.1 * (1 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GRAM.toCentigrams(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GRAM.toCentigrams(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GRAM.toCentigrams(0.33), delta);
        msg = "0.6543 * (1 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GRAM.toCentigrams(0.6543), delta);
        msg = "1 * (1 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GRAM.toCentigrams(1.0), delta);
        msg = "1.6543 * (1 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GRAM.toCentigrams(1.6543), delta);
        msg = "22.45 * (1 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GRAM.toCentigrams(22.45), delta);
        msg = "9876.5432 * (1 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GRAM.toCentigrams(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GRAM.toCentigrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GRAM.toCentigrams(784.46789765434), delta);
        // ====================
        // ====================DECIGRAM
        // ====================
        // to_factor = 0.1
        to_factor = DECIGRAM.getFactor();
        msg = "-1 * (1 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GRAM.toDecigrams(-1.0), delta);
        msg = "-0.1 * (1 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GRAM.toDecigrams(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GRAM.toDecigrams(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GRAM.toDecigrams(-73.25), delta);
        msg = "-56229.321 * (1 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GRAM.toDecigrams(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GRAM.toDecigrams(-873.5432456), delta);
        msg = "0 * (1 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GRAM.toDecigrams(0.0), delta);
        msg = "0.1 * (1 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GRAM.toDecigrams(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GRAM.toDecigrams(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GRAM.toDecigrams(0.33), delta);
        msg = "0.6543 * (1 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GRAM.toDecigrams(0.6543), delta);
        msg = "1 * (1 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GRAM.toDecigrams(1.0), delta);
        msg = "1.6543 * (1 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GRAM.toDecigrams(1.6543), delta);
        msg = "22.45 * (1 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GRAM.toDecigrams(22.45), delta);
        msg = "9876.5432 * (1 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GRAM.toDecigrams(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GRAM.toDecigrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GRAM.toDecigrams(784.46789765434), delta);
        // ====================
        // ====================GRAM
        // ====================
        // to_factor = 1.0
        to_factor = GRAM.getFactor();
        msg = "-1 * (1 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GRAM.toGrams(-1.0), delta);
        msg = "-0.1 * (1 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GRAM.toGrams(-0.1), delta);
        msg = "-0.000456789 * (1 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GRAM.toGrams(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GRAM.toGrams(-73.25), delta);
        msg = "-56229.321 * (1 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GRAM.toGrams(-56229.321), delta);
        msg = "-873.5432456 * (1 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GRAM.toGrams(-873.5432456), delta);
        msg = "0 * (1 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GRAM.toGrams(0.0), delta);
        msg = "0.1 * (1 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GRAM.toGrams(0.1), delta);
        msg = "0.0000876543297 * (1 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GRAM.toGrams(8.76543297E-5), delta);
        msg = "0.33 * (1 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GRAM.toGrams(0.33), delta);
        msg = "0.6543 * (1 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GRAM.toGrams(0.6543), delta);
        msg = "1 * (1 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GRAM.toGrams(1.0), delta);
        msg = "1.6543 * (1 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GRAM.toGrams(1.6543), delta);
        msg = "22.45 * (1 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GRAM.toGrams(22.45), delta);
        msg = "9876.5432 * (1 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GRAM.toGrams(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GRAM.toGrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GRAM.toGrams(784.46789765434), delta);
        // ====================
        // ====================DEKAGRAM
        // ====================
        // to_factor = 10.0
        to_factor = DEKAGRAM.getFactor();
        msg = "-1 / (10 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GRAM.toDekagrams(-1.0), delta);
        msg = "-0.1 / (10 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GRAM.toDekagrams(-0.1), delta);
        msg = "-0.000456789 / (10 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GRAM.toDekagrams(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GRAM.toDekagrams(-73.25), delta);
        msg = "-56229.321 / (10 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GRAM.toDekagrams(-56229.321), delta);
        msg = "-873.5432456 / (10 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GRAM.toDekagrams(-873.5432456), delta);
        msg = "0 / (10 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GRAM.toDekagrams(0.0), delta);
        msg = "0.1 / (10 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GRAM.toDekagrams(0.1), delta);
        msg = "0.0000876543297 / (10 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GRAM.toDekagrams(8.76543297E-5), delta);
        msg = "0.33 / (10 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GRAM.toDekagrams(0.33), delta);
        msg = "0.6543 / (10 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GRAM.toDekagrams(0.6543), delta);
        msg = "1 / (10 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GRAM.toDekagrams(1.0), delta);
        msg = "1.6543 / (10 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GRAM.toDekagrams(1.6543), delta);
        msg = "22.45 / (10 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GRAM.toDekagrams(22.45), delta);
        msg = "9876.5432 / (10 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GRAM.toDekagrams(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GRAM.toDekagrams(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GRAM.toDekagrams(784.46789765434), delta);
        // ====================
        // ====================HECOGRAM
        // ====================
        // to_factor = 100.0
        to_factor = HECOGRAM.getFactor();
        msg = "-1 / (100 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GRAM.toHecograms(-1.0), delta);
        msg = "-0.1 / (100 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GRAM.toHecograms(-0.1), delta);
        msg = "-0.000456789 / (100 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GRAM.toHecograms(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GRAM.toHecograms(-73.25), delta);
        msg = "-56229.321 / (100 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GRAM.toHecograms(-56229.321), delta);
        msg = "-873.5432456 / (100 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GRAM.toHecograms(-873.5432456), delta);
        msg = "0 / (100 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GRAM.toHecograms(0.0), delta);
        msg = "0.1 / (100 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GRAM.toHecograms(0.1), delta);
        msg = "0.0000876543297 / (100 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GRAM.toHecograms(8.76543297E-5), delta);
        msg = "0.33 / (100 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GRAM.toHecograms(0.33), delta);
        msg = "0.6543 / (100 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GRAM.toHecograms(0.6543), delta);
        msg = "1 / (100 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GRAM.toHecograms(1.0), delta);
        msg = "1.6543 / (100 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GRAM.toHecograms(1.6543), delta);
        msg = "22.45 / (100 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GRAM.toHecograms(22.45), delta);
        msg = "9876.5432 / (100 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GRAM.toHecograms(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GRAM.toHecograms(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GRAM.toHecograms(784.46789765434), delta);
        // ====================
        // ====================KILOGRAM
        // ====================
        // to_factor = 1000.0
        to_factor = KILOGRAM.getFactor();
        msg = "-1 / (1000 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GRAM.toKilograms(-1.0), delta);
        msg = "-0.1 / (1000 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GRAM.toKilograms(-0.1), delta);
        msg = "-0.000456789 / (1000 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GRAM.toKilograms(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GRAM.toKilograms(-73.25), delta);
        msg = "-56229.321 / (1000 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GRAM.toKilograms(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GRAM.toKilograms(-873.5432456), delta);
        msg = "0 / (1000 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GRAM.toKilograms(0.0), delta);
        msg = "0.1 / (1000 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GRAM.toKilograms(0.1), delta);
        msg = "0.0000876543297 / (1000 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GRAM.toKilograms(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GRAM.toKilograms(0.33), delta);
        msg = "0.6543 / (1000 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GRAM.toKilograms(0.6543), delta);
        msg = "1 / (1000 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GRAM.toKilograms(1.0), delta);
        msg = "1.6543 / (1000 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GRAM.toKilograms(1.6543), delta);
        msg = "22.45 / (1000 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GRAM.toKilograms(22.45), delta);
        msg = "9876.5432 / (1000 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GRAM.toKilograms(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GRAM.toKilograms(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GRAM.toKilograms(784.46789765434), delta);
    }

    @Test()
    public void testDekagram() {
        // from_factor = 10.0
        double from_factor = DEKAGRAM.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLIGRAM
        // ====================
        // to_factor = 0.001
        to_factor = MILLIGRAM.getFactor();
        msg = "-1 * (10 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DEKAGRAM.toMilligrams(-1.0), delta);
        msg = "-0.1 * (10 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DEKAGRAM.toMilligrams(-0.1), delta);
        msg = "-0.000456789 * (10 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DEKAGRAM.toMilligrams(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DEKAGRAM.toMilligrams(-73.25), delta);
        msg = "-56229.321 * (10 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DEKAGRAM.toMilligrams(-56229.321), delta);
        msg = "-873.5432456 * (10 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DEKAGRAM.toMilligrams(-873.5432456), delta);
        msg = "0 * (10 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DEKAGRAM.toMilligrams(0.0), delta);
        msg = "0.1 * (10 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DEKAGRAM.toMilligrams(0.1), delta);
        msg = "0.0000876543297 * (10 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DEKAGRAM.toMilligrams(8.76543297E-5), delta);
        msg = "0.33 * (10 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DEKAGRAM.toMilligrams(0.33), delta);
        msg = "0.6543 * (10 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DEKAGRAM.toMilligrams(0.6543), delta);
        msg = "1 * (10 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DEKAGRAM.toMilligrams(1.0), delta);
        msg = "1.6543 * (10 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DEKAGRAM.toMilligrams(1.6543), delta);
        msg = "22.45 * (10 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DEKAGRAM.toMilligrams(22.45), delta);
        msg = "9876.5432 * (10 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DEKAGRAM.toMilligrams(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DEKAGRAM.toMilligrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DEKAGRAM.toMilligrams(784.46789765434), delta);
        // ====================
        // ====================CENTIGRAM
        // ====================
        // to_factor = 0.01
        to_factor = CENTIGRAM.getFactor();
        msg = "-1 * (10 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DEKAGRAM.toCentigrams(-1.0), delta);
        msg = "-0.1 * (10 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DEKAGRAM.toCentigrams(-0.1), delta);
        msg = "-0.000456789 * (10 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DEKAGRAM.toCentigrams(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DEKAGRAM.toCentigrams(-73.25), delta);
        msg = "-56229.321 * (10 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DEKAGRAM.toCentigrams(-56229.321), delta);
        msg = "-873.5432456 * (10 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DEKAGRAM.toCentigrams(-873.5432456), delta);
        msg = "0 * (10 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DEKAGRAM.toCentigrams(0.0), delta);
        msg = "0.1 * (10 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DEKAGRAM.toCentigrams(0.1), delta);
        msg = "0.0000876543297 * (10 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DEKAGRAM.toCentigrams(8.76543297E-5), delta);
        msg = "0.33 * (10 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DEKAGRAM.toCentigrams(0.33), delta);
        msg = "0.6543 * (10 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DEKAGRAM.toCentigrams(0.6543), delta);
        msg = "1 * (10 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DEKAGRAM.toCentigrams(1.0), delta);
        msg = "1.6543 * (10 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DEKAGRAM.toCentigrams(1.6543), delta);
        msg = "22.45 * (10 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DEKAGRAM.toCentigrams(22.45), delta);
        msg = "9876.5432 * (10 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DEKAGRAM.toCentigrams(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DEKAGRAM.toCentigrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DEKAGRAM.toCentigrams(784.46789765434), delta);
        // ====================
        // ====================DECIGRAM
        // ====================
        // to_factor = 0.1
        to_factor = DECIGRAM.getFactor();
        msg = "-1 * (10 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DEKAGRAM.toDecigrams(-1.0), delta);
        msg = "-0.1 * (10 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DEKAGRAM.toDecigrams(-0.1), delta);
        msg = "-0.000456789 * (10 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DEKAGRAM.toDecigrams(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DEKAGRAM.toDecigrams(-73.25), delta);
        msg = "-56229.321 * (10 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DEKAGRAM.toDecigrams(-56229.321), delta);
        msg = "-873.5432456 * (10 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DEKAGRAM.toDecigrams(-873.5432456), delta);
        msg = "0 * (10 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DEKAGRAM.toDecigrams(0.0), delta);
        msg = "0.1 * (10 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DEKAGRAM.toDecigrams(0.1), delta);
        msg = "0.0000876543297 * (10 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DEKAGRAM.toDecigrams(8.76543297E-5), delta);
        msg = "0.33 * (10 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DEKAGRAM.toDecigrams(0.33), delta);
        msg = "0.6543 * (10 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DEKAGRAM.toDecigrams(0.6543), delta);
        msg = "1 * (10 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DEKAGRAM.toDecigrams(1.0), delta);
        msg = "1.6543 * (10 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DEKAGRAM.toDecigrams(1.6543), delta);
        msg = "22.45 * (10 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DEKAGRAM.toDecigrams(22.45), delta);
        msg = "9876.5432 * (10 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DEKAGRAM.toDecigrams(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DEKAGRAM.toDecigrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DEKAGRAM.toDecigrams(784.46789765434), delta);
        // ====================
        // ====================GRAM
        // ====================
        // to_factor = 1.0
        to_factor = GRAM.getFactor();
        msg = "-1 * (10 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DEKAGRAM.toGrams(-1.0), delta);
        msg = "-0.1 * (10 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DEKAGRAM.toGrams(-0.1), delta);
        msg = "-0.000456789 * (10 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DEKAGRAM.toGrams(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DEKAGRAM.toGrams(-73.25), delta);
        msg = "-56229.321 * (10 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DEKAGRAM.toGrams(-56229.321), delta);
        msg = "-873.5432456 * (10 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DEKAGRAM.toGrams(-873.5432456), delta);
        msg = "0 * (10 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DEKAGRAM.toGrams(0.0), delta);
        msg = "0.1 * (10 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DEKAGRAM.toGrams(0.1), delta);
        msg = "0.0000876543297 * (10 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DEKAGRAM.toGrams(8.76543297E-5), delta);
        msg = "0.33 * (10 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DEKAGRAM.toGrams(0.33), delta);
        msg = "0.6543 * (10 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DEKAGRAM.toGrams(0.6543), delta);
        msg = "1 * (10 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DEKAGRAM.toGrams(1.0), delta);
        msg = "1.6543 * (10 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DEKAGRAM.toGrams(1.6543), delta);
        msg = "22.45 * (10 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DEKAGRAM.toGrams(22.45), delta);
        msg = "9876.5432 * (10 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DEKAGRAM.toGrams(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DEKAGRAM.toGrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DEKAGRAM.toGrams(784.46789765434), delta);
        // ====================
        // ====================DEKAGRAM
        // ====================
        // to_factor = 10.0
        to_factor = DEKAGRAM.getFactor();
        msg = "-1 * (10 / 10)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DEKAGRAM.toDekagrams(-1.0), delta);
        msg = "-0.1 * (10 / 10)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DEKAGRAM.toDekagrams(-0.1), delta);
        msg = "-0.000456789 * (10 / 10)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DEKAGRAM.toDekagrams(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 10)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DEKAGRAM.toDekagrams(-73.25), delta);
        msg = "-56229.321 * (10 / 10)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DEKAGRAM.toDekagrams(-56229.321), delta);
        msg = "-873.5432456 * (10 / 10)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DEKAGRAM.toDekagrams(-873.5432456), delta);
        msg = "0 * (10 / 10)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DEKAGRAM.toDekagrams(0.0), delta);
        msg = "0.1 * (10 / 10)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DEKAGRAM.toDekagrams(0.1), delta);
        msg = "0.0000876543297 * (10 / 10)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DEKAGRAM.toDekagrams(8.76543297E-5), delta);
        msg = "0.33 * (10 / 10)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DEKAGRAM.toDekagrams(0.33), delta);
        msg = "0.6543 * (10 / 10)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DEKAGRAM.toDekagrams(0.6543), delta);
        msg = "1 * (10 / 10)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DEKAGRAM.toDekagrams(1.0), delta);
        msg = "1.6543 * (10 / 10)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DEKAGRAM.toDekagrams(1.6543), delta);
        msg = "22.45 * (10 / 10)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DEKAGRAM.toDekagrams(22.45), delta);
        msg = "9876.5432 * (10 / 10)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DEKAGRAM.toDekagrams(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 10)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DEKAGRAM.toDekagrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 10)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DEKAGRAM.toDekagrams(784.46789765434), delta);
        // ====================
        // ====================HECOGRAM
        // ====================
        // to_factor = 100.0
        to_factor = HECOGRAM.getFactor();
        msg = "-1 / (100 / 10)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DEKAGRAM.toHecograms(-1.0), delta);
        msg = "-0.1 / (100 / 10)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DEKAGRAM.toHecograms(-0.1), delta);
        msg = "-0.000456789 / (100 / 10)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DEKAGRAM.toHecograms(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 10)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DEKAGRAM.toHecograms(-73.25), delta);
        msg = "-56229.321 / (100 / 10)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DEKAGRAM.toHecograms(-56229.321), delta);
        msg = "-873.5432456 / (100 / 10)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DEKAGRAM.toHecograms(-873.5432456), delta);
        msg = "0 / (100 / 10)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DEKAGRAM.toHecograms(0.0), delta);
        msg = "0.1 / (100 / 10)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DEKAGRAM.toHecograms(0.1), delta);
        msg = "0.0000876543297 / (100 / 10)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DEKAGRAM.toHecograms(8.76543297E-5), delta);
        msg = "0.33 / (100 / 10)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DEKAGRAM.toHecograms(0.33), delta);
        msg = "0.6543 / (100 / 10)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DEKAGRAM.toHecograms(0.6543), delta);
        msg = "1 / (100 / 10)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DEKAGRAM.toHecograms(1.0), delta);
        msg = "1.6543 / (100 / 10)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DEKAGRAM.toHecograms(1.6543), delta);
        msg = "22.45 / (100 / 10)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DEKAGRAM.toHecograms(22.45), delta);
        msg = "9876.5432 / (100 / 10)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DEKAGRAM.toHecograms(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 10)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DEKAGRAM.toHecograms(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 10)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DEKAGRAM.toHecograms(784.46789765434), delta);
        // ====================
        // ====================KILOGRAM
        // ====================
        // to_factor = 1000.0
        to_factor = KILOGRAM.getFactor();
        msg = "-1 / (1000 / 10)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DEKAGRAM.toKilograms(-1.0), delta);
        msg = "-0.1 / (1000 / 10)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DEKAGRAM.toKilograms(-0.1), delta);
        msg = "-0.000456789 / (1000 / 10)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DEKAGRAM.toKilograms(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 10)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DEKAGRAM.toKilograms(-73.25), delta);
        msg = "-56229.321 / (1000 / 10)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DEKAGRAM.toKilograms(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 10)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DEKAGRAM.toKilograms(-873.5432456), delta);
        msg = "0 / (1000 / 10)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DEKAGRAM.toKilograms(0.0), delta);
        msg = "0.1 / (1000 / 10)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DEKAGRAM.toKilograms(0.1), delta);
        msg = "0.0000876543297 / (1000 / 10)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DEKAGRAM.toKilograms(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 10)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DEKAGRAM.toKilograms(0.33), delta);
        msg = "0.6543 / (1000 / 10)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DEKAGRAM.toKilograms(0.6543), delta);
        msg = "1 / (1000 / 10)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DEKAGRAM.toKilograms(1.0), delta);
        msg = "1.6543 / (1000 / 10)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DEKAGRAM.toKilograms(1.6543), delta);
        msg = "22.45 / (1000 / 10)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DEKAGRAM.toKilograms(22.45), delta);
        msg = "9876.5432 / (1000 / 10)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DEKAGRAM.toKilograms(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 10)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DEKAGRAM.toKilograms(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 10)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DEKAGRAM.toKilograms(784.46789765434), delta);
    }

    @Test()
    public void testHecogram() {
        // from_factor = 100.0
        double from_factor = HECOGRAM.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLIGRAM
        // ====================
        // to_factor = 0.001
        to_factor = MILLIGRAM.getFactor();
        msg = "-1 * (100 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HECOGRAM.toMilligrams(-1.0), delta);
        msg = "-0.1 * (100 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HECOGRAM.toMilligrams(-0.1), delta);
        msg = "-0.000456789 * (100 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HECOGRAM.toMilligrams(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HECOGRAM.toMilligrams(-73.25), delta);
        msg = "-56229.321 * (100 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HECOGRAM.toMilligrams(-56229.321), delta);
        msg = "-873.5432456 * (100 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HECOGRAM.toMilligrams(-873.5432456), delta);
        msg = "0 * (100 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HECOGRAM.toMilligrams(0.0), delta);
        msg = "0.1 * (100 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HECOGRAM.toMilligrams(0.1), delta);
        msg = "0.0000876543297 * (100 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HECOGRAM.toMilligrams(8.76543297E-5), delta);
        msg = "0.33 * (100 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HECOGRAM.toMilligrams(0.33), delta);
        msg = "0.6543 * (100 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HECOGRAM.toMilligrams(0.6543), delta);
        msg = "1 * (100 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HECOGRAM.toMilligrams(1.0), delta);
        msg = "1.6543 * (100 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HECOGRAM.toMilligrams(1.6543), delta);
        msg = "22.45 * (100 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HECOGRAM.toMilligrams(22.45), delta);
        msg = "9876.5432 * (100 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HECOGRAM.toMilligrams(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HECOGRAM.toMilligrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HECOGRAM.toMilligrams(784.46789765434), delta);
        // ====================
        // ====================CENTIGRAM
        // ====================
        // to_factor = 0.01
        to_factor = CENTIGRAM.getFactor();
        msg = "-1 * (100 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HECOGRAM.toCentigrams(-1.0), delta);
        msg = "-0.1 * (100 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HECOGRAM.toCentigrams(-0.1), delta);
        msg = "-0.000456789 * (100 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HECOGRAM.toCentigrams(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HECOGRAM.toCentigrams(-73.25), delta);
        msg = "-56229.321 * (100 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HECOGRAM.toCentigrams(-56229.321), delta);
        msg = "-873.5432456 * (100 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HECOGRAM.toCentigrams(-873.5432456), delta);
        msg = "0 * (100 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HECOGRAM.toCentigrams(0.0), delta);
        msg = "0.1 * (100 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HECOGRAM.toCentigrams(0.1), delta);
        msg = "0.0000876543297 * (100 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HECOGRAM.toCentigrams(8.76543297E-5), delta);
        msg = "0.33 * (100 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HECOGRAM.toCentigrams(0.33), delta);
        msg = "0.6543 * (100 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HECOGRAM.toCentigrams(0.6543), delta);
        msg = "1 * (100 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HECOGRAM.toCentigrams(1.0), delta);
        msg = "1.6543 * (100 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HECOGRAM.toCentigrams(1.6543), delta);
        msg = "22.45 * (100 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HECOGRAM.toCentigrams(22.45), delta);
        msg = "9876.5432 * (100 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HECOGRAM.toCentigrams(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HECOGRAM.toCentigrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HECOGRAM.toCentigrams(784.46789765434), delta);
        // ====================
        // ====================DECIGRAM
        // ====================
        // to_factor = 0.1
        to_factor = DECIGRAM.getFactor();
        msg = "-1 * (100 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HECOGRAM.toDecigrams(-1.0), delta);
        msg = "-0.1 * (100 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HECOGRAM.toDecigrams(-0.1), delta);
        msg = "-0.000456789 * (100 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HECOGRAM.toDecigrams(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HECOGRAM.toDecigrams(-73.25), delta);
        msg = "-56229.321 * (100 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HECOGRAM.toDecigrams(-56229.321), delta);
        msg = "-873.5432456 * (100 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HECOGRAM.toDecigrams(-873.5432456), delta);
        msg = "0 * (100 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HECOGRAM.toDecigrams(0.0), delta);
        msg = "0.1 * (100 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HECOGRAM.toDecigrams(0.1), delta);
        msg = "0.0000876543297 * (100 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HECOGRAM.toDecigrams(8.76543297E-5), delta);
        msg = "0.33 * (100 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HECOGRAM.toDecigrams(0.33), delta);
        msg = "0.6543 * (100 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HECOGRAM.toDecigrams(0.6543), delta);
        msg = "1 * (100 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HECOGRAM.toDecigrams(1.0), delta);
        msg = "1.6543 * (100 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HECOGRAM.toDecigrams(1.6543), delta);
        msg = "22.45 * (100 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HECOGRAM.toDecigrams(22.45), delta);
        msg = "9876.5432 * (100 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HECOGRAM.toDecigrams(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HECOGRAM.toDecigrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HECOGRAM.toDecigrams(784.46789765434), delta);
        // ====================
        // ====================GRAM
        // ====================
        // to_factor = 1.0
        to_factor = GRAM.getFactor();
        msg = "-1 * (100 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HECOGRAM.toGrams(-1.0), delta);
        msg = "-0.1 * (100 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HECOGRAM.toGrams(-0.1), delta);
        msg = "-0.000456789 * (100 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HECOGRAM.toGrams(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HECOGRAM.toGrams(-73.25), delta);
        msg = "-56229.321 * (100 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HECOGRAM.toGrams(-56229.321), delta);
        msg = "-873.5432456 * (100 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HECOGRAM.toGrams(-873.5432456), delta);
        msg = "0 * (100 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HECOGRAM.toGrams(0.0), delta);
        msg = "0.1 * (100 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HECOGRAM.toGrams(0.1), delta);
        msg = "0.0000876543297 * (100 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HECOGRAM.toGrams(8.76543297E-5), delta);
        msg = "0.33 * (100 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HECOGRAM.toGrams(0.33), delta);
        msg = "0.6543 * (100 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HECOGRAM.toGrams(0.6543), delta);
        msg = "1 * (100 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HECOGRAM.toGrams(1.0), delta);
        msg = "1.6543 * (100 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HECOGRAM.toGrams(1.6543), delta);
        msg = "22.45 * (100 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HECOGRAM.toGrams(22.45), delta);
        msg = "9876.5432 * (100 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HECOGRAM.toGrams(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HECOGRAM.toGrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HECOGRAM.toGrams(784.46789765434), delta);
        // ====================
        // ====================DEKAGRAM
        // ====================
        // to_factor = 10.0
        to_factor = DEKAGRAM.getFactor();
        msg = "-1 * (100 / 10)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HECOGRAM.toDekagrams(-1.0), delta);
        msg = "-0.1 * (100 / 10)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HECOGRAM.toDekagrams(-0.1), delta);
        msg = "-0.000456789 * (100 / 10)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HECOGRAM.toDekagrams(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 10)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HECOGRAM.toDekagrams(-73.25), delta);
        msg = "-56229.321 * (100 / 10)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HECOGRAM.toDekagrams(-56229.321), delta);
        msg = "-873.5432456 * (100 / 10)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HECOGRAM.toDekagrams(-873.5432456), delta);
        msg = "0 * (100 / 10)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HECOGRAM.toDekagrams(0.0), delta);
        msg = "0.1 * (100 / 10)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HECOGRAM.toDekagrams(0.1), delta);
        msg = "0.0000876543297 * (100 / 10)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HECOGRAM.toDekagrams(8.76543297E-5), delta);
        msg = "0.33 * (100 / 10)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HECOGRAM.toDekagrams(0.33), delta);
        msg = "0.6543 * (100 / 10)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HECOGRAM.toDekagrams(0.6543), delta);
        msg = "1 * (100 / 10)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HECOGRAM.toDekagrams(1.0), delta);
        msg = "1.6543 * (100 / 10)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HECOGRAM.toDekagrams(1.6543), delta);
        msg = "22.45 * (100 / 10)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HECOGRAM.toDekagrams(22.45), delta);
        msg = "9876.5432 * (100 / 10)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HECOGRAM.toDekagrams(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 10)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HECOGRAM.toDekagrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 10)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HECOGRAM.toDekagrams(784.46789765434), delta);
        // ====================
        // ====================HECOGRAM
        // ====================
        // to_factor = 100.0
        to_factor = HECOGRAM.getFactor();
        msg = "-1 * (100 / 100)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HECOGRAM.toHecograms(-1.0), delta);
        msg = "-0.1 * (100 / 100)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HECOGRAM.toHecograms(-0.1), delta);
        msg = "-0.000456789 * (100 / 100)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HECOGRAM.toHecograms(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 100)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HECOGRAM.toHecograms(-73.25), delta);
        msg = "-56229.321 * (100 / 100)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HECOGRAM.toHecograms(-56229.321), delta);
        msg = "-873.5432456 * (100 / 100)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HECOGRAM.toHecograms(-873.5432456), delta);
        msg = "0 * (100 / 100)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HECOGRAM.toHecograms(0.0), delta);
        msg = "0.1 * (100 / 100)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HECOGRAM.toHecograms(0.1), delta);
        msg = "0.0000876543297 * (100 / 100)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HECOGRAM.toHecograms(8.76543297E-5), delta);
        msg = "0.33 * (100 / 100)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HECOGRAM.toHecograms(0.33), delta);
        msg = "0.6543 * (100 / 100)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HECOGRAM.toHecograms(0.6543), delta);
        msg = "1 * (100 / 100)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HECOGRAM.toHecograms(1.0), delta);
        msg = "1.6543 * (100 / 100)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HECOGRAM.toHecograms(1.6543), delta);
        msg = "22.45 * (100 / 100)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HECOGRAM.toHecograms(22.45), delta);
        msg = "9876.5432 * (100 / 100)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HECOGRAM.toHecograms(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 100)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HECOGRAM.toHecograms(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 100)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HECOGRAM.toHecograms(784.46789765434), delta);
        // ====================
        // ====================KILOGRAM
        // ====================
        // to_factor = 1000.0
        to_factor = KILOGRAM.getFactor();
        msg = "-1 / (1000 / 100)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), HECOGRAM.toKilograms(-1.0), delta);
        msg = "-0.1 / (1000 / 100)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), HECOGRAM.toKilograms(-0.1), delta);
        msg = "-0.000456789 / (1000 / 100)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), HECOGRAM.toKilograms(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 100)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), HECOGRAM.toKilograms(-73.25), delta);
        msg = "-56229.321 / (1000 / 100)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), HECOGRAM.toKilograms(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 100)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), HECOGRAM.toKilograms(-873.5432456), delta);
        msg = "0 / (1000 / 100)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), HECOGRAM.toKilograms(0.0), delta);
        msg = "0.1 / (1000 / 100)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), HECOGRAM.toKilograms(0.1), delta);
        msg = "0.0000876543297 / (1000 / 100)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), HECOGRAM.toKilograms(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 100)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), HECOGRAM.toKilograms(0.33), delta);
        msg = "0.6543 / (1000 / 100)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), HECOGRAM.toKilograms(0.6543), delta);
        msg = "1 / (1000 / 100)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), HECOGRAM.toKilograms(1.0), delta);
        msg = "1.6543 / (1000 / 100)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), HECOGRAM.toKilograms(1.6543), delta);
        msg = "22.45 / (1000 / 100)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), HECOGRAM.toKilograms(22.45), delta);
        msg = "9876.5432 / (1000 / 100)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), HECOGRAM.toKilograms(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 100)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), HECOGRAM.toKilograms(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 100)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), HECOGRAM.toKilograms(784.46789765434), delta);
    }

    @Test()
    public void testKilogram() {
        // from_factor = 1000.0
        double from_factor = KILOGRAM.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MILLIGRAM
        // ====================
        // to_factor = 0.001
        to_factor = MILLIGRAM.getFactor();
        msg = "-1 * (1000 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOGRAM.toMilligrams(-1.0), delta);
        msg = "-0.1 * (1000 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOGRAM.toMilligrams(-0.1), delta);
        msg = "-0.000456789 * (1000 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOGRAM.toMilligrams(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOGRAM.toMilligrams(-73.25), delta);
        msg = "-56229.321 * (1000 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOGRAM.toMilligrams(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOGRAM.toMilligrams(-873.5432456), delta);
        msg = "0 * (1000 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOGRAM.toMilligrams(0.0), delta);
        msg = "0.1 * (1000 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOGRAM.toMilligrams(0.1), delta);
        msg = "0.0000876543297 * (1000 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOGRAM.toMilligrams(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOGRAM.toMilligrams(0.33), delta);
        msg = "0.6543 * (1000 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOGRAM.toMilligrams(0.6543), delta);
        msg = "1 * (1000 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOGRAM.toMilligrams(1.0), delta);
        msg = "1.6543 * (1000 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOGRAM.toMilligrams(1.6543), delta);
        msg = "22.45 * (1000 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOGRAM.toMilligrams(22.45), delta);
        msg = "9876.5432 * (1000 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOGRAM.toMilligrams(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOGRAM.toMilligrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOGRAM.toMilligrams(784.46789765434), delta);
        // ====================
        // ====================CENTIGRAM
        // ====================
        // to_factor = 0.01
        to_factor = CENTIGRAM.getFactor();
        msg = "-1 * (1000 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOGRAM.toCentigrams(-1.0), delta);
        msg = "-0.1 * (1000 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOGRAM.toCentigrams(-0.1), delta);
        msg = "-0.000456789 * (1000 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOGRAM.toCentigrams(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOGRAM.toCentigrams(-73.25), delta);
        msg = "-56229.321 * (1000 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOGRAM.toCentigrams(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOGRAM.toCentigrams(-873.5432456), delta);
        msg = "0 * (1000 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOGRAM.toCentigrams(0.0), delta);
        msg = "0.1 * (1000 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOGRAM.toCentigrams(0.1), delta);
        msg = "0.0000876543297 * (1000 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOGRAM.toCentigrams(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOGRAM.toCentigrams(0.33), delta);
        msg = "0.6543 * (1000 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOGRAM.toCentigrams(0.6543), delta);
        msg = "1 * (1000 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOGRAM.toCentigrams(1.0), delta);
        msg = "1.6543 * (1000 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOGRAM.toCentigrams(1.6543), delta);
        msg = "22.45 * (1000 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOGRAM.toCentigrams(22.45), delta);
        msg = "9876.5432 * (1000 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOGRAM.toCentigrams(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOGRAM.toCentigrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOGRAM.toCentigrams(784.46789765434), delta);
        // ====================
        // ====================DECIGRAM
        // ====================
        // to_factor = 0.1
        to_factor = DECIGRAM.getFactor();
        msg = "-1 * (1000 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOGRAM.toDecigrams(-1.0), delta);
        msg = "-0.1 * (1000 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOGRAM.toDecigrams(-0.1), delta);
        msg = "-0.000456789 * (1000 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOGRAM.toDecigrams(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOGRAM.toDecigrams(-73.25), delta);
        msg = "-56229.321 * (1000 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOGRAM.toDecigrams(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOGRAM.toDecigrams(-873.5432456), delta);
        msg = "0 * (1000 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOGRAM.toDecigrams(0.0), delta);
        msg = "0.1 * (1000 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOGRAM.toDecigrams(0.1), delta);
        msg = "0.0000876543297 * (1000 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOGRAM.toDecigrams(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOGRAM.toDecigrams(0.33), delta);
        msg = "0.6543 * (1000 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOGRAM.toDecigrams(0.6543), delta);
        msg = "1 * (1000 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOGRAM.toDecigrams(1.0), delta);
        msg = "1.6543 * (1000 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOGRAM.toDecigrams(1.6543), delta);
        msg = "22.45 * (1000 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOGRAM.toDecigrams(22.45), delta);
        msg = "9876.5432 * (1000 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOGRAM.toDecigrams(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOGRAM.toDecigrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOGRAM.toDecigrams(784.46789765434), delta);
        // ====================
        // ====================GRAM
        // ====================
        // to_factor = 1.0
        to_factor = GRAM.getFactor();
        msg = "-1 * (1000 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOGRAM.toGrams(-1.0), delta);
        msg = "-0.1 * (1000 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOGRAM.toGrams(-0.1), delta);
        msg = "-0.000456789 * (1000 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOGRAM.toGrams(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOGRAM.toGrams(-73.25), delta);
        msg = "-56229.321 * (1000 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOGRAM.toGrams(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOGRAM.toGrams(-873.5432456), delta);
        msg = "0 * (1000 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOGRAM.toGrams(0.0), delta);
        msg = "0.1 * (1000 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOGRAM.toGrams(0.1), delta);
        msg = "0.0000876543297 * (1000 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOGRAM.toGrams(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOGRAM.toGrams(0.33), delta);
        msg = "0.6543 * (1000 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOGRAM.toGrams(0.6543), delta);
        msg = "1 * (1000 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOGRAM.toGrams(1.0), delta);
        msg = "1.6543 * (1000 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOGRAM.toGrams(1.6543), delta);
        msg = "22.45 * (1000 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOGRAM.toGrams(22.45), delta);
        msg = "9876.5432 * (1000 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOGRAM.toGrams(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOGRAM.toGrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOGRAM.toGrams(784.46789765434), delta);
        // ====================
        // ====================DEKAGRAM
        // ====================
        // to_factor = 10.0
        to_factor = DEKAGRAM.getFactor();
        msg = "-1 * (1000 / 10)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOGRAM.toDekagrams(-1.0), delta);
        msg = "-0.1 * (1000 / 10)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOGRAM.toDekagrams(-0.1), delta);
        msg = "-0.000456789 * (1000 / 10)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOGRAM.toDekagrams(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 10)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOGRAM.toDekagrams(-73.25), delta);
        msg = "-56229.321 * (1000 / 10)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOGRAM.toDekagrams(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 10)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOGRAM.toDekagrams(-873.5432456), delta);
        msg = "0 * (1000 / 10)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOGRAM.toDekagrams(0.0), delta);
        msg = "0.1 * (1000 / 10)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOGRAM.toDekagrams(0.1), delta);
        msg = "0.0000876543297 * (1000 / 10)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOGRAM.toDekagrams(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 10)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOGRAM.toDekagrams(0.33), delta);
        msg = "0.6543 * (1000 / 10)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOGRAM.toDekagrams(0.6543), delta);
        msg = "1 * (1000 / 10)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOGRAM.toDekagrams(1.0), delta);
        msg = "1.6543 * (1000 / 10)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOGRAM.toDekagrams(1.6543), delta);
        msg = "22.45 * (1000 / 10)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOGRAM.toDekagrams(22.45), delta);
        msg = "9876.5432 * (1000 / 10)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOGRAM.toDekagrams(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 10)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOGRAM.toDekagrams(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 10)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOGRAM.toDekagrams(784.46789765434), delta);
        // ====================
        // ====================HECOGRAM
        // ====================
        // to_factor = 100.0
        to_factor = HECOGRAM.getFactor();
        msg = "-1 * (1000 / 100)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOGRAM.toHecograms(-1.0), delta);
        msg = "-0.1 * (1000 / 100)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOGRAM.toHecograms(-0.1), delta);
        msg = "-0.000456789 * (1000 / 100)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOGRAM.toHecograms(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 100)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOGRAM.toHecograms(-73.25), delta);
        msg = "-56229.321 * (1000 / 100)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOGRAM.toHecograms(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 100)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOGRAM.toHecograms(-873.5432456), delta);
        msg = "0 * (1000 / 100)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOGRAM.toHecograms(0.0), delta);
        msg = "0.1 * (1000 / 100)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOGRAM.toHecograms(0.1), delta);
        msg = "0.0000876543297 * (1000 / 100)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOGRAM.toHecograms(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 100)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOGRAM.toHecograms(0.33), delta);
        msg = "0.6543 * (1000 / 100)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOGRAM.toHecograms(0.6543), delta);
        msg = "1 * (1000 / 100)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOGRAM.toHecograms(1.0), delta);
        msg = "1.6543 * (1000 / 100)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOGRAM.toHecograms(1.6543), delta);
        msg = "22.45 * (1000 / 100)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOGRAM.toHecograms(22.45), delta);
        msg = "9876.5432 * (1000 / 100)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOGRAM.toHecograms(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 100)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOGRAM.toHecograms(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 100)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOGRAM.toHecograms(784.46789765434), delta);
        // ====================
        // ====================KILOGRAM
        // ====================
        // to_factor = 1000.0
        to_factor = KILOGRAM.getFactor();
        msg = "-1 * (1000 / 1000)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOGRAM.toKilograms(-1.0), delta);
        msg = "-0.1 * (1000 / 1000)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOGRAM.toKilograms(-0.1), delta);
        msg = "-0.000456789 * (1000 / 1000)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOGRAM.toKilograms(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 1000)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOGRAM.toKilograms(-73.25), delta);
        msg = "-56229.321 * (1000 / 1000)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOGRAM.toKilograms(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 1000)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOGRAM.toKilograms(-873.5432456), delta);
        msg = "0 * (1000 / 1000)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOGRAM.toKilograms(0.0), delta);
        msg = "0.1 * (1000 / 1000)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOGRAM.toKilograms(0.1), delta);
        msg = "0.0000876543297 * (1000 / 1000)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOGRAM.toKilograms(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 1000)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOGRAM.toKilograms(0.33), delta);
        msg = "0.6543 * (1000 / 1000)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOGRAM.toKilograms(0.6543), delta);
        msg = "1 * (1000 / 1000)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOGRAM.toKilograms(1.0), delta);
        msg = "1.6543 * (1000 / 1000)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOGRAM.toKilograms(1.6543), delta);
        msg = "22.45 * (1000 / 1000)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOGRAM.toKilograms(22.45), delta);
        msg = "9876.5432 * (1000 / 1000)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOGRAM.toKilograms(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 1000)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOGRAM.toKilograms(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 1000)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOGRAM.toKilograms(784.46789765434), delta);
    }
}
