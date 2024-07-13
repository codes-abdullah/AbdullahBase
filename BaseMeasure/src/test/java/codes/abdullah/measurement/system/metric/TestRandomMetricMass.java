package codes.abdullah.measurement.system.metric;

import static codes.abdullah.measurement.system.metric.Metrics.CENTIGRAM;
import static codes.abdullah.measurement.system.metric.Metrics.DECIGRAM;
import static codes.abdullah.measurement.system.metric.Metrics.DEKAGRAM;
import static codes.abdullah.measurement.system.metric.Metrics.GRAM;
import static codes.abdullah.measurement.system.metric.Metrics.HECOGRAM;
import static codes.abdullah.measurement.system.metric.Metrics.KILOGRAM;
import static codes.abdullah.measurement.system.metric.Metrics.MILLIGRAM;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static codes.abdullah.measurement.utils.TestUtils.loops;
import static codes.abdullah.measurement.utils.TestUtils.nextDouble;
import static codes.abdullah.measurement.utils.TestUtils.noE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRandomMetricMass {

    @Test()
    public void testMilligram() {
        // from_factor = 0.001
        double from_factor = MILLIGRAM.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLIGRAM
            // ====================
            // to_factor = 0.001
            to_factor = MILLIGRAM.getFactor();
            msg = String.format("%s * (0.001 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MILLIGRAM.toMilligrams(test), delta);
            // ====================
            // ====================CENTIGRAM
            // ====================
            // to_factor = 0.01
            to_factor = CENTIGRAM.getFactor();
            msg = String.format("%s / (0.01 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLIGRAM.toCentigrams(test), delta);
            // ====================
            // ====================DECIGRAM
            // ====================
            // to_factor = 0.1
            to_factor = DECIGRAM.getFactor();
            msg = String.format("%s / (0.1 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLIGRAM.toDecigrams(test), delta);
            // ====================
            // ====================GRAM
            // ====================
            // to_factor = 1.0
            to_factor = GRAM.getFactor();
            msg = String.format("%s / (1 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLIGRAM.toGrams(test), delta);
            // ====================
            // ====================DEKAGRAM
            // ====================
            // to_factor = 10.0
            to_factor = DEKAGRAM.getFactor();
            msg = String.format("%s / (10 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLIGRAM.toDekagrams(test), delta);
            // ====================
            // ====================HECOGRAM
            // ====================
            // to_factor = 100.0
            to_factor = HECOGRAM.getFactor();
            msg = String.format("%s / (100 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLIGRAM.toHecograms(test), delta);
            // ====================
            // ====================KILOGRAM
            // ====================
            // to_factor = 1000.0
            to_factor = KILOGRAM.getFactor();
            msg = String.format("%s / (1000 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLIGRAM.toKilograms(test), delta);
        }
    }

    @Test()
    public void testCentigram() {
        // from_factor = 0.01
        double from_factor = CENTIGRAM.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLIGRAM
            // ====================
            // to_factor = 0.001
            to_factor = MILLIGRAM.getFactor();
            msg = String.format("%s * (0.01 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CENTIGRAM.toMilligrams(test), delta);
            // ====================
            // ====================CENTIGRAM
            // ====================
            // to_factor = 0.01
            to_factor = CENTIGRAM.getFactor();
            msg = String.format("%s * (0.01 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CENTIGRAM.toCentigrams(test), delta);
            // ====================
            // ====================DECIGRAM
            // ====================
            // to_factor = 0.1
            to_factor = DECIGRAM.getFactor();
            msg = String.format("%s / (0.1 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), CENTIGRAM.toDecigrams(test), delta);
            // ====================
            // ====================GRAM
            // ====================
            // to_factor = 1.0
            to_factor = GRAM.getFactor();
            msg = String.format("%s / (1 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), CENTIGRAM.toGrams(test), delta);
            // ====================
            // ====================DEKAGRAM
            // ====================
            // to_factor = 10.0
            to_factor = DEKAGRAM.getFactor();
            msg = String.format("%s / (10 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), CENTIGRAM.toDekagrams(test), delta);
            // ====================
            // ====================HECOGRAM
            // ====================
            // to_factor = 100.0
            to_factor = HECOGRAM.getFactor();
            msg = String.format("%s / (100 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), CENTIGRAM.toHecograms(test), delta);
            // ====================
            // ====================KILOGRAM
            // ====================
            // to_factor = 1000.0
            to_factor = KILOGRAM.getFactor();
            msg = String.format("%s / (1000 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), CENTIGRAM.toKilograms(test), delta);
        }
    }

    @Test()
    public void testDecigram() {
        // from_factor = 0.1
        double from_factor = DECIGRAM.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLIGRAM
            // ====================
            // to_factor = 0.001
            to_factor = MILLIGRAM.getFactor();
            msg = String.format("%s * (0.1 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DECIGRAM.toMilligrams(test), delta);
            // ====================
            // ====================CENTIGRAM
            // ====================
            // to_factor = 0.01
            to_factor = CENTIGRAM.getFactor();
            msg = String.format("%s * (0.1 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DECIGRAM.toCentigrams(test), delta);
            // ====================
            // ====================DECIGRAM
            // ====================
            // to_factor = 0.1
            to_factor = DECIGRAM.getFactor();
            msg = String.format("%s * (0.1 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DECIGRAM.toDecigrams(test), delta);
            // ====================
            // ====================GRAM
            // ====================
            // to_factor = 1.0
            to_factor = GRAM.getFactor();
            msg = String.format("%s / (1 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DECIGRAM.toGrams(test), delta);
            // ====================
            // ====================DEKAGRAM
            // ====================
            // to_factor = 10.0
            to_factor = DEKAGRAM.getFactor();
            msg = String.format("%s / (10 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DECIGRAM.toDekagrams(test), delta);
            // ====================
            // ====================HECOGRAM
            // ====================
            // to_factor = 100.0
            to_factor = HECOGRAM.getFactor();
            msg = String.format("%s / (100 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DECIGRAM.toHecograms(test), delta);
            // ====================
            // ====================KILOGRAM
            // ====================
            // to_factor = 1000.0
            to_factor = KILOGRAM.getFactor();
            msg = String.format("%s / (1000 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DECIGRAM.toKilograms(test), delta);
        }
    }

    @Test()
    public void testGram() {
        // from_factor = 1.0
        double from_factor = GRAM.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLIGRAM
            // ====================
            // to_factor = 0.001
            to_factor = MILLIGRAM.getFactor();
            msg = String.format("%s * (1 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GRAM.toMilligrams(test), delta);
            // ====================
            // ====================CENTIGRAM
            // ====================
            // to_factor = 0.01
            to_factor = CENTIGRAM.getFactor();
            msg = String.format("%s * (1 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GRAM.toCentigrams(test), delta);
            // ====================
            // ====================DECIGRAM
            // ====================
            // to_factor = 0.1
            to_factor = DECIGRAM.getFactor();
            msg = String.format("%s * (1 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GRAM.toDecigrams(test), delta);
            // ====================
            // ====================GRAM
            // ====================
            // to_factor = 1.0
            to_factor = GRAM.getFactor();
            msg = String.format("%s * (1 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GRAM.toGrams(test), delta);
            // ====================
            // ====================DEKAGRAM
            // ====================
            // to_factor = 10.0
            to_factor = DEKAGRAM.getFactor();
            msg = String.format("%s / (10 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GRAM.toDekagrams(test), delta);
            // ====================
            // ====================HECOGRAM
            // ====================
            // to_factor = 100.0
            to_factor = HECOGRAM.getFactor();
            msg = String.format("%s / (100 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GRAM.toHecograms(test), delta);
            // ====================
            // ====================KILOGRAM
            // ====================
            // to_factor = 1000.0
            to_factor = KILOGRAM.getFactor();
            msg = String.format("%s / (1000 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GRAM.toKilograms(test), delta);
        }
    }

    @Test()
    public void testDekagram() {
        // from_factor = 10.0
        double from_factor = DEKAGRAM.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLIGRAM
            // ====================
            // to_factor = 0.001
            to_factor = MILLIGRAM.getFactor();
            msg = String.format("%s * (10 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DEKAGRAM.toMilligrams(test), delta);
            // ====================
            // ====================CENTIGRAM
            // ====================
            // to_factor = 0.01
            to_factor = CENTIGRAM.getFactor();
            msg = String.format("%s * (10 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DEKAGRAM.toCentigrams(test), delta);
            // ====================
            // ====================DECIGRAM
            // ====================
            // to_factor = 0.1
            to_factor = DECIGRAM.getFactor();
            msg = String.format("%s * (10 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DEKAGRAM.toDecigrams(test), delta);
            // ====================
            // ====================GRAM
            // ====================
            // to_factor = 1.0
            to_factor = GRAM.getFactor();
            msg = String.format("%s * (10 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DEKAGRAM.toGrams(test), delta);
            // ====================
            // ====================DEKAGRAM
            // ====================
            // to_factor = 10.0
            to_factor = DEKAGRAM.getFactor();
            msg = String.format("%s * (10 / 10)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DEKAGRAM.toDekagrams(test), delta);
            // ====================
            // ====================HECOGRAM
            // ====================
            // to_factor = 100.0
            to_factor = HECOGRAM.getFactor();
            msg = String.format("%s / (100 / 10)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DEKAGRAM.toHecograms(test), delta);
            // ====================
            // ====================KILOGRAM
            // ====================
            // to_factor = 1000.0
            to_factor = KILOGRAM.getFactor();
            msg = String.format("%s / (1000 / 10)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DEKAGRAM.toKilograms(test), delta);
        }
    }

    @Test()
    public void testHecogram() {
        // from_factor = 100.0
        double from_factor = HECOGRAM.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLIGRAM
            // ====================
            // to_factor = 0.001
            to_factor = MILLIGRAM.getFactor();
            msg = String.format("%s * (100 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HECOGRAM.toMilligrams(test), delta);
            // ====================
            // ====================CENTIGRAM
            // ====================
            // to_factor = 0.01
            to_factor = CENTIGRAM.getFactor();
            msg = String.format("%s * (100 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HECOGRAM.toCentigrams(test), delta);
            // ====================
            // ====================DECIGRAM
            // ====================
            // to_factor = 0.1
            to_factor = DECIGRAM.getFactor();
            msg = String.format("%s * (100 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HECOGRAM.toDecigrams(test), delta);
            // ====================
            // ====================GRAM
            // ====================
            // to_factor = 1.0
            to_factor = GRAM.getFactor();
            msg = String.format("%s * (100 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HECOGRAM.toGrams(test), delta);
            // ====================
            // ====================DEKAGRAM
            // ====================
            // to_factor = 10.0
            to_factor = DEKAGRAM.getFactor();
            msg = String.format("%s * (100 / 10)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HECOGRAM.toDekagrams(test), delta);
            // ====================
            // ====================HECOGRAM
            // ====================
            // to_factor = 100.0
            to_factor = HECOGRAM.getFactor();
            msg = String.format("%s * (100 / 100)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HECOGRAM.toHecograms(test), delta);
            // ====================
            // ====================KILOGRAM
            // ====================
            // to_factor = 1000.0
            to_factor = KILOGRAM.getFactor();
            msg = String.format("%s / (1000 / 100)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), HECOGRAM.toKilograms(test), delta);
        }
    }

    @Test()
    public void testKilogram() {
        // from_factor = 1000.0
        double from_factor = KILOGRAM.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLIGRAM
            // ====================
            // to_factor = 0.001
            to_factor = MILLIGRAM.getFactor();
            msg = String.format("%s * (1000 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOGRAM.toMilligrams(test), delta);
            // ====================
            // ====================CENTIGRAM
            // ====================
            // to_factor = 0.01
            to_factor = CENTIGRAM.getFactor();
            msg = String.format("%s * (1000 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOGRAM.toCentigrams(test), delta);
            // ====================
            // ====================DECIGRAM
            // ====================
            // to_factor = 0.1
            to_factor = DECIGRAM.getFactor();
            msg = String.format("%s * (1000 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOGRAM.toDecigrams(test), delta);
            // ====================
            // ====================GRAM
            // ====================
            // to_factor = 1.0
            to_factor = GRAM.getFactor();
            msg = String.format("%s * (1000 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOGRAM.toGrams(test), delta);
            // ====================
            // ====================DEKAGRAM
            // ====================
            // to_factor = 10.0
            to_factor = DEKAGRAM.getFactor();
            msg = String.format("%s * (1000 / 10)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOGRAM.toDekagrams(test), delta);
            // ====================
            // ====================HECOGRAM
            // ====================
            // to_factor = 100.0
            to_factor = HECOGRAM.getFactor();
            msg = String.format("%s * (1000 / 100)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOGRAM.toHecograms(test), delta);
            // ====================
            // ====================KILOGRAM
            // ====================
            // to_factor = 1000.0
            to_factor = KILOGRAM.getFactor();
            msg = String.format("%s * (1000 / 1000)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOGRAM.toKilograms(test), delta);
        }
    }
}
