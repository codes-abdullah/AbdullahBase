package codes.abdullah.measurement.system.metric;

import static codes.abdullah.measurement.system.metric.Metrics.CENTILITER;
import static codes.abdullah.measurement.system.metric.Metrics.DECILITER;
import static codes.abdullah.measurement.system.metric.Metrics.DEKALITER;
import static codes.abdullah.measurement.system.metric.Metrics.HECTOLITER;
import static codes.abdullah.measurement.system.metric.Metrics.KILOLITER;
import static codes.abdullah.measurement.system.metric.Metrics.LITER;
import static codes.abdullah.measurement.system.metric.Metrics.MILLILITER;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static codes.abdullah.measurement.utils.TestUtils.loops;
import static codes.abdullah.measurement.utils.TestUtils.nextDouble;
import static codes.abdullah.measurement.utils.TestUtils.noE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRandomMetricVolume {

    @Test()
    public void testMilliliter() {
        // from_factor = 0.001
        double from_factor = MILLILITER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLILITER
            // ====================
            // to_factor = 0.001
            to_factor = MILLILITER.getFactor();
            msg = String.format("%s * (0.001 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MILLILITER.toMilliliters(test), delta);
            // ====================
            // ====================CENTILITER
            // ====================
            // to_factor = 0.01
            to_factor = CENTILITER.getFactor();
            msg = String.format("%s / (0.01 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLILITER.toCentiliters(test), delta);
            // ====================
            // ====================DECILITER
            // ====================
            // to_factor = 0.1
            to_factor = DECILITER.getFactor();
            msg = String.format("%s / (0.1 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLILITER.toDeciliters(test), delta);
            // ====================
            // ====================LITER
            // ====================
            // to_factor = 1.0
            to_factor = LITER.getFactor();
            msg = String.format("%s / (1 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLILITER.toLiters(test), delta);
            // ====================
            // ====================DEKALITER
            // ====================
            // to_factor = 10.0
            to_factor = DEKALITER.getFactor();
            msg = String.format("%s / (10 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLILITER.toDekaliters(test), delta);
            // ====================
            // ====================HECTOLITER
            // ====================
            // to_factor = 100.0
            to_factor = HECTOLITER.getFactor();
            msg = String.format("%s / (100 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLILITER.toHectoliters(test), delta);
            // ====================
            // ====================KILOLITER
            // ====================
            // to_factor = 1000.0
            to_factor = KILOLITER.getFactor();
            msg = String.format("%s / (1000 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLILITER.toKiloliters(test), delta);
        }
    }

    @Test()
    public void testCentiliter() {
        // from_factor = 0.01
        double from_factor = CENTILITER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLILITER
            // ====================
            // to_factor = 0.001
            to_factor = MILLILITER.getFactor();
            msg = String.format("%s * (0.01 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CENTILITER.toMilliliters(test), delta);
            // ====================
            // ====================CENTILITER
            // ====================
            // to_factor = 0.01
            to_factor = CENTILITER.getFactor();
            msg = String.format("%s * (0.01 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CENTILITER.toCentiliters(test), delta);
            // ====================
            // ====================DECILITER
            // ====================
            // to_factor = 0.1
            to_factor = DECILITER.getFactor();
            msg = String.format("%s / (0.1 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), CENTILITER.toDeciliters(test), delta);
            // ====================
            // ====================LITER
            // ====================
            // to_factor = 1.0
            to_factor = LITER.getFactor();
            msg = String.format("%s / (1 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), CENTILITER.toLiters(test), delta);
            // ====================
            // ====================DEKALITER
            // ====================
            // to_factor = 10.0
            to_factor = DEKALITER.getFactor();
            msg = String.format("%s / (10 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), CENTILITER.toDekaliters(test), delta);
            // ====================
            // ====================HECTOLITER
            // ====================
            // to_factor = 100.0
            to_factor = HECTOLITER.getFactor();
            msg = String.format("%s / (100 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), CENTILITER.toHectoliters(test), delta);
            // ====================
            // ====================KILOLITER
            // ====================
            // to_factor = 1000.0
            to_factor = KILOLITER.getFactor();
            msg = String.format("%s / (1000 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), CENTILITER.toKiloliters(test), delta);
        }
    }

    @Test()
    public void testDeciliter() {
        // from_factor = 0.1
        double from_factor = DECILITER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLILITER
            // ====================
            // to_factor = 0.001
            to_factor = MILLILITER.getFactor();
            msg = String.format("%s * (0.1 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DECILITER.toMilliliters(test), delta);
            // ====================
            // ====================CENTILITER
            // ====================
            // to_factor = 0.01
            to_factor = CENTILITER.getFactor();
            msg = String.format("%s * (0.1 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DECILITER.toCentiliters(test), delta);
            // ====================
            // ====================DECILITER
            // ====================
            // to_factor = 0.1
            to_factor = DECILITER.getFactor();
            msg = String.format("%s * (0.1 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DECILITER.toDeciliters(test), delta);
            // ====================
            // ====================LITER
            // ====================
            // to_factor = 1.0
            to_factor = LITER.getFactor();
            msg = String.format("%s / (1 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DECILITER.toLiters(test), delta);
            // ====================
            // ====================DEKALITER
            // ====================
            // to_factor = 10.0
            to_factor = DEKALITER.getFactor();
            msg = String.format("%s / (10 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DECILITER.toDekaliters(test), delta);
            // ====================
            // ====================HECTOLITER
            // ====================
            // to_factor = 100.0
            to_factor = HECTOLITER.getFactor();
            msg = String.format("%s / (100 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DECILITER.toHectoliters(test), delta);
            // ====================
            // ====================KILOLITER
            // ====================
            // to_factor = 1000.0
            to_factor = KILOLITER.getFactor();
            msg = String.format("%s / (1000 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DECILITER.toKiloliters(test), delta);
        }
    }

    @Test()
    public void testLiter() {
        // from_factor = 1.0
        double from_factor = LITER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLILITER
            // ====================
            // to_factor = 0.001
            to_factor = MILLILITER.getFactor();
            msg = String.format("%s * (1 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), LITER.toMilliliters(test), delta);
            // ====================
            // ====================CENTILITER
            // ====================
            // to_factor = 0.01
            to_factor = CENTILITER.getFactor();
            msg = String.format("%s * (1 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), LITER.toCentiliters(test), delta);
            // ====================
            // ====================DECILITER
            // ====================
            // to_factor = 0.1
            to_factor = DECILITER.getFactor();
            msg = String.format("%s * (1 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), LITER.toDeciliters(test), delta);
            // ====================
            // ====================LITER
            // ====================
            // to_factor = 1.0
            to_factor = LITER.getFactor();
            msg = String.format("%s * (1 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), LITER.toLiters(test), delta);
            // ====================
            // ====================DEKALITER
            // ====================
            // to_factor = 10.0
            to_factor = DEKALITER.getFactor();
            msg = String.format("%s / (10 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), LITER.toDekaliters(test), delta);
            // ====================
            // ====================HECTOLITER
            // ====================
            // to_factor = 100.0
            to_factor = HECTOLITER.getFactor();
            msg = String.format("%s / (100 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), LITER.toHectoliters(test), delta);
            // ====================
            // ====================KILOLITER
            // ====================
            // to_factor = 1000.0
            to_factor = KILOLITER.getFactor();
            msg = String.format("%s / (1000 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), LITER.toKiloliters(test), delta);
        }
    }

    @Test()
    public void testDekaliter() {
        // from_factor = 10.0
        double from_factor = DEKALITER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLILITER
            // ====================
            // to_factor = 0.001
            to_factor = MILLILITER.getFactor();
            msg = String.format("%s * (10 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DEKALITER.toMilliliters(test), delta);
            // ====================
            // ====================CENTILITER
            // ====================
            // to_factor = 0.01
            to_factor = CENTILITER.getFactor();
            msg = String.format("%s * (10 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DEKALITER.toCentiliters(test), delta);
            // ====================
            // ====================DECILITER
            // ====================
            // to_factor = 0.1
            to_factor = DECILITER.getFactor();
            msg = String.format("%s * (10 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DEKALITER.toDeciliters(test), delta);
            // ====================
            // ====================LITER
            // ====================
            // to_factor = 1.0
            to_factor = LITER.getFactor();
            msg = String.format("%s * (10 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DEKALITER.toLiters(test), delta);
            // ====================
            // ====================DEKALITER
            // ====================
            // to_factor = 10.0
            to_factor = DEKALITER.getFactor();
            msg = String.format("%s * (10 / 10)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DEKALITER.toDekaliters(test), delta);
            // ====================
            // ====================HECTOLITER
            // ====================
            // to_factor = 100.0
            to_factor = HECTOLITER.getFactor();
            msg = String.format("%s / (100 / 10)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DEKALITER.toHectoliters(test), delta);
            // ====================
            // ====================KILOLITER
            // ====================
            // to_factor = 1000.0
            to_factor = KILOLITER.getFactor();
            msg = String.format("%s / (1000 / 10)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DEKALITER.toKiloliters(test), delta);
        }
    }

    @Test()
    public void testHectoliter() {
        // from_factor = 100.0
        double from_factor = HECTOLITER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLILITER
            // ====================
            // to_factor = 0.001
            to_factor = MILLILITER.getFactor();
            msg = String.format("%s * (100 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HECTOLITER.toMilliliters(test), delta);
            // ====================
            // ====================CENTILITER
            // ====================
            // to_factor = 0.01
            to_factor = CENTILITER.getFactor();
            msg = String.format("%s * (100 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HECTOLITER.toCentiliters(test), delta);
            // ====================
            // ====================DECILITER
            // ====================
            // to_factor = 0.1
            to_factor = DECILITER.getFactor();
            msg = String.format("%s * (100 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HECTOLITER.toDeciliters(test), delta);
            // ====================
            // ====================LITER
            // ====================
            // to_factor = 1.0
            to_factor = LITER.getFactor();
            msg = String.format("%s * (100 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HECTOLITER.toLiters(test), delta);
            // ====================
            // ====================DEKALITER
            // ====================
            // to_factor = 10.0
            to_factor = DEKALITER.getFactor();
            msg = String.format("%s * (100 / 10)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HECTOLITER.toDekaliters(test), delta);
            // ====================
            // ====================HECTOLITER
            // ====================
            // to_factor = 100.0
            to_factor = HECTOLITER.getFactor();
            msg = String.format("%s * (100 / 100)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HECTOLITER.toHectoliters(test), delta);
            // ====================
            // ====================KILOLITER
            // ====================
            // to_factor = 1000.0
            to_factor = KILOLITER.getFactor();
            msg = String.format("%s / (1000 / 100)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), HECTOLITER.toKiloliters(test), delta);
        }
    }

    @Test()
    public void testKiloliter() {
        // from_factor = 1000.0
        double from_factor = KILOLITER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLILITER
            // ====================
            // to_factor = 0.001
            to_factor = MILLILITER.getFactor();
            msg = String.format("%s * (1000 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOLITER.toMilliliters(test), delta);
            // ====================
            // ====================CENTILITER
            // ====================
            // to_factor = 0.01
            to_factor = CENTILITER.getFactor();
            msg = String.format("%s * (1000 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOLITER.toCentiliters(test), delta);
            // ====================
            // ====================DECILITER
            // ====================
            // to_factor = 0.1
            to_factor = DECILITER.getFactor();
            msg = String.format("%s * (1000 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOLITER.toDeciliters(test), delta);
            // ====================
            // ====================LITER
            // ====================
            // to_factor = 1.0
            to_factor = LITER.getFactor();
            msg = String.format("%s * (1000 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOLITER.toLiters(test), delta);
            // ====================
            // ====================DEKALITER
            // ====================
            // to_factor = 10.0
            to_factor = DEKALITER.getFactor();
            msg = String.format("%s * (1000 / 10)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOLITER.toDekaliters(test), delta);
            // ====================
            // ====================HECTOLITER
            // ====================
            // to_factor = 100.0
            to_factor = HECTOLITER.getFactor();
            msg = String.format("%s * (1000 / 100)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOLITER.toHectoliters(test), delta);
            // ====================
            // ====================KILOLITER
            // ====================
            // to_factor = 1000.0
            to_factor = KILOLITER.getFactor();
            msg = String.format("%s * (1000 / 1000)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOLITER.toKiloliters(test), delta);
        }
    }
}
