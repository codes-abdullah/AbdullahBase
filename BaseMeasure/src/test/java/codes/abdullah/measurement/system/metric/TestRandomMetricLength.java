package codes.abdullah.measurement.system.metric;

import static codes.abdullah.measurement.system.metric.Metrics.CENTIMETER;
import static codes.abdullah.measurement.system.metric.Metrics.DECIMETER;
import static codes.abdullah.measurement.system.metric.Metrics.DEKAMETER;
import static codes.abdullah.measurement.system.metric.Metrics.HECOMETER;
import static codes.abdullah.measurement.system.metric.Metrics.KILOMETER;
import static codes.abdullah.measurement.system.metric.Metrics.METER;
import static codes.abdullah.measurement.system.metric.Metrics.MILLIMETER;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static codes.abdullah.measurement.utils.TestUtils.loops;
import static codes.abdullah.measurement.utils.TestUtils.nextDouble;
import static codes.abdullah.measurement.utils.TestUtils.noE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRandomMetricLength {

    @Test()
    public void testMillimeter() {
        // from_factor = 0.001
        double from_factor = MILLIMETER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLIMETER
            // ====================
            // to_factor = 0.001
            to_factor = MILLIMETER.getFactor();
            msg = String.format("%s * (0.001 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MILLIMETER.toMillimeters(test), delta);
            // ====================
            // ====================CENTIMETER
            // ====================
            // to_factor = 0.01
            to_factor = CENTIMETER.getFactor();
            msg = String.format("%s / (0.01 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLIMETER.toCentimeters(test), delta);
            // ====================
            // ====================DECIMETER
            // ====================
            // to_factor = 0.1
            to_factor = DECIMETER.getFactor();
            msg = String.format("%s / (0.1 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLIMETER.toDecimeters(test), delta);
            // ====================
            // ====================METER
            // ====================
            // to_factor = 1.0
            to_factor = METER.getFactor();
            msg = String.format("%s / (1 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLIMETER.toMeters(test), delta);
            // ====================
            // ====================DEKAMETER
            // ====================
            // to_factor = 10.0
            to_factor = DEKAMETER.getFactor();
            msg = String.format("%s / (10 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLIMETER.toDekameters(test), delta);
            // ====================
            // ====================HECOMETER
            // ====================
            // to_factor = 100.0
            to_factor = HECOMETER.getFactor();
            msg = String.format("%s / (100 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLIMETER.toHecometers(test), delta);
            // ====================
            // ====================KILOMETER
            // ====================
            // to_factor = 1000.0
            to_factor = KILOMETER.getFactor();
            msg = String.format("%s / (1000 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLIMETER.toKilometers(test), delta);
        }
    }

    @Test()
    public void testCentimeter() {
        // from_factor = 0.01
        double from_factor = CENTIMETER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLIMETER
            // ====================
            // to_factor = 0.001
            to_factor = MILLIMETER.getFactor();
            msg = String.format("%s * (0.01 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CENTIMETER.toMillimeters(test), delta);
            // ====================
            // ====================CENTIMETER
            // ====================
            // to_factor = 0.01
            to_factor = CENTIMETER.getFactor();
            msg = String.format("%s * (0.01 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CENTIMETER.toCentimeters(test), delta);
            // ====================
            // ====================DECIMETER
            // ====================
            // to_factor = 0.1
            to_factor = DECIMETER.getFactor();
            msg = String.format("%s / (0.1 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), CENTIMETER.toDecimeters(test), delta);
            // ====================
            // ====================METER
            // ====================
            // to_factor = 1.0
            to_factor = METER.getFactor();
            msg = String.format("%s / (1 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), CENTIMETER.toMeters(test), delta);
            // ====================
            // ====================DEKAMETER
            // ====================
            // to_factor = 10.0
            to_factor = DEKAMETER.getFactor();
            msg = String.format("%s / (10 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), CENTIMETER.toDekameters(test), delta);
            // ====================
            // ====================HECOMETER
            // ====================
            // to_factor = 100.0
            to_factor = HECOMETER.getFactor();
            msg = String.format("%s / (100 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), CENTIMETER.toHecometers(test), delta);
            // ====================
            // ====================KILOMETER
            // ====================
            // to_factor = 1000.0
            to_factor = KILOMETER.getFactor();
            msg = String.format("%s / (1000 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), CENTIMETER.toKilometers(test), delta);
        }
    }

    @Test()
    public void testDecimeter() {
        // from_factor = 0.1
        double from_factor = DECIMETER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLIMETER
            // ====================
            // to_factor = 0.001
            to_factor = MILLIMETER.getFactor();
            msg = String.format("%s * (0.1 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DECIMETER.toMillimeters(test), delta);
            // ====================
            // ====================CENTIMETER
            // ====================
            // to_factor = 0.01
            to_factor = CENTIMETER.getFactor();
            msg = String.format("%s * (0.1 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DECIMETER.toCentimeters(test), delta);
            // ====================
            // ====================DECIMETER
            // ====================
            // to_factor = 0.1
            to_factor = DECIMETER.getFactor();
            msg = String.format("%s * (0.1 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DECIMETER.toDecimeters(test), delta);
            // ====================
            // ====================METER
            // ====================
            // to_factor = 1.0
            to_factor = METER.getFactor();
            msg = String.format("%s / (1 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DECIMETER.toMeters(test), delta);
            // ====================
            // ====================DEKAMETER
            // ====================
            // to_factor = 10.0
            to_factor = DEKAMETER.getFactor();
            msg = String.format("%s / (10 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DECIMETER.toDekameters(test), delta);
            // ====================
            // ====================HECOMETER
            // ====================
            // to_factor = 100.0
            to_factor = HECOMETER.getFactor();
            msg = String.format("%s / (100 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DECIMETER.toHecometers(test), delta);
            // ====================
            // ====================KILOMETER
            // ====================
            // to_factor = 1000.0
            to_factor = KILOMETER.getFactor();
            msg = String.format("%s / (1000 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DECIMETER.toKilometers(test), delta);
        }
    }

    @Test()
    public void testMeter() {
        // from_factor = 1.0
        double from_factor = METER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLIMETER
            // ====================
            // to_factor = 0.001
            to_factor = MILLIMETER.getFactor();
            msg = String.format("%s * (1 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), METER.toMillimeters(test), delta);
            // ====================
            // ====================CENTIMETER
            // ====================
            // to_factor = 0.01
            to_factor = CENTIMETER.getFactor();
            msg = String.format("%s * (1 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), METER.toCentimeters(test), delta);
            // ====================
            // ====================DECIMETER
            // ====================
            // to_factor = 0.1
            to_factor = DECIMETER.getFactor();
            msg = String.format("%s * (1 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), METER.toDecimeters(test), delta);
            // ====================
            // ====================METER
            // ====================
            // to_factor = 1.0
            to_factor = METER.getFactor();
            msg = String.format("%s * (1 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), METER.toMeters(test), delta);
            // ====================
            // ====================DEKAMETER
            // ====================
            // to_factor = 10.0
            to_factor = DEKAMETER.getFactor();
            msg = String.format("%s / (10 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), METER.toDekameters(test), delta);
            // ====================
            // ====================HECOMETER
            // ====================
            // to_factor = 100.0
            to_factor = HECOMETER.getFactor();
            msg = String.format("%s / (100 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), METER.toHecometers(test), delta);
            // ====================
            // ====================KILOMETER
            // ====================
            // to_factor = 1000.0
            to_factor = KILOMETER.getFactor();
            msg = String.format("%s / (1000 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), METER.toKilometers(test), delta);
        }
    }

    @Test()
    public void testDekameter() {
        // from_factor = 10.0
        double from_factor = DEKAMETER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLIMETER
            // ====================
            // to_factor = 0.001
            to_factor = MILLIMETER.getFactor();
            msg = String.format("%s * (10 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DEKAMETER.toMillimeters(test), delta);
            // ====================
            // ====================CENTIMETER
            // ====================
            // to_factor = 0.01
            to_factor = CENTIMETER.getFactor();
            msg = String.format("%s * (10 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DEKAMETER.toCentimeters(test), delta);
            // ====================
            // ====================DECIMETER
            // ====================
            // to_factor = 0.1
            to_factor = DECIMETER.getFactor();
            msg = String.format("%s * (10 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DEKAMETER.toDecimeters(test), delta);
            // ====================
            // ====================METER
            // ====================
            // to_factor = 1.0
            to_factor = METER.getFactor();
            msg = String.format("%s * (10 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DEKAMETER.toMeters(test), delta);
            // ====================
            // ====================DEKAMETER
            // ====================
            // to_factor = 10.0
            to_factor = DEKAMETER.getFactor();
            msg = String.format("%s * (10 / 10)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DEKAMETER.toDekameters(test), delta);
            // ====================
            // ====================HECOMETER
            // ====================
            // to_factor = 100.0
            to_factor = HECOMETER.getFactor();
            msg = String.format("%s / (100 / 10)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DEKAMETER.toHecometers(test), delta);
            // ====================
            // ====================KILOMETER
            // ====================
            // to_factor = 1000.0
            to_factor = KILOMETER.getFactor();
            msg = String.format("%s / (1000 / 10)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DEKAMETER.toKilometers(test), delta);
        }
    }

    @Test()
    public void testHecometer() {
        // from_factor = 100.0
        double from_factor = HECOMETER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLIMETER
            // ====================
            // to_factor = 0.001
            to_factor = MILLIMETER.getFactor();
            msg = String.format("%s * (100 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HECOMETER.toMillimeters(test), delta);
            // ====================
            // ====================CENTIMETER
            // ====================
            // to_factor = 0.01
            to_factor = CENTIMETER.getFactor();
            msg = String.format("%s * (100 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HECOMETER.toCentimeters(test), delta);
            // ====================
            // ====================DECIMETER
            // ====================
            // to_factor = 0.1
            to_factor = DECIMETER.getFactor();
            msg = String.format("%s * (100 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HECOMETER.toDecimeters(test), delta);
            // ====================
            // ====================METER
            // ====================
            // to_factor = 1.0
            to_factor = METER.getFactor();
            msg = String.format("%s * (100 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HECOMETER.toMeters(test), delta);
            // ====================
            // ====================DEKAMETER
            // ====================
            // to_factor = 10.0
            to_factor = DEKAMETER.getFactor();
            msg = String.format("%s * (100 / 10)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HECOMETER.toDekameters(test), delta);
            // ====================
            // ====================HECOMETER
            // ====================
            // to_factor = 100.0
            to_factor = HECOMETER.getFactor();
            msg = String.format("%s * (100 / 100)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HECOMETER.toHecometers(test), delta);
            // ====================
            // ====================KILOMETER
            // ====================
            // to_factor = 1000.0
            to_factor = KILOMETER.getFactor();
            msg = String.format("%s / (1000 / 100)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), HECOMETER.toKilometers(test), delta);
        }
    }

    @Test()
    public void testKilometer() {
        // from_factor = 1000.0
        double from_factor = KILOMETER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MILLIMETER
            // ====================
            // to_factor = 0.001
            to_factor = MILLIMETER.getFactor();
            msg = String.format("%s * (1000 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOMETER.toMillimeters(test), delta);
            // ====================
            // ====================CENTIMETER
            // ====================
            // to_factor = 0.01
            to_factor = CENTIMETER.getFactor();
            msg = String.format("%s * (1000 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOMETER.toCentimeters(test), delta);
            // ====================
            // ====================DECIMETER
            // ====================
            // to_factor = 0.1
            to_factor = DECIMETER.getFactor();
            msg = String.format("%s * (1000 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOMETER.toDecimeters(test), delta);
            // ====================
            // ====================METER
            // ====================
            // to_factor = 1.0
            to_factor = METER.getFactor();
            msg = String.format("%s * (1000 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOMETER.toMeters(test), delta);
            // ====================
            // ====================DEKAMETER
            // ====================
            // to_factor = 10.0
            to_factor = DEKAMETER.getFactor();
            msg = String.format("%s * (1000 / 10)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOMETER.toDekameters(test), delta);
            // ====================
            // ====================HECOMETER
            // ====================
            // to_factor = 100.0
            to_factor = HECOMETER.getFactor();
            msg = String.format("%s * (1000 / 100)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOMETER.toHecometers(test), delta);
            // ====================
            // ====================KILOMETER
            // ====================
            // to_factor = 1000.0
            to_factor = KILOMETER.getFactor();
            msg = String.format("%s * (1000 / 1000)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOMETER.toKilometers(test), delta);
        }
    }
}
