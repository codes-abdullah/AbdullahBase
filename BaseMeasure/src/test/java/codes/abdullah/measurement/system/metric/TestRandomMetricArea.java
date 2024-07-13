package codes.abdullah.measurement.system.metric;

import static codes.abdullah.measurement.system.metric.Metrics.SQUARE_CENTIMETER;
import static codes.abdullah.measurement.system.metric.Metrics.SQUARE_DECIMETER;
import static codes.abdullah.measurement.system.metric.Metrics.SQUARE_DEKAMETER;
import static codes.abdullah.measurement.system.metric.Metrics.SQUARE_HECOMETER;
import static codes.abdullah.measurement.system.metric.Metrics.SQUARE_KILOMETER;
import static codes.abdullah.measurement.system.metric.Metrics.SQUARE_METER;
import static codes.abdullah.measurement.system.metric.Metrics.SQUARE_MILLIMETER;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static codes.abdullah.measurement.utils.TestUtils.loops;
import static codes.abdullah.measurement.utils.TestUtils.nextDouble;
import static codes.abdullah.measurement.utils.TestUtils.noE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRandomMetricArea {

    @Test()
    public void testSquareMillimeter() {
        // from_factor = 0.001
        double from_factor = SQUARE_MILLIMETER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SQUARE_MILLIMETER
            // ====================
            // to_factor = 0.001
            to_factor = SQUARE_MILLIMETER.getFactor();
            msg = String.format("%s * (0.001 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_MILLIMETER.toSquareMillimeters(test), delta);
            // ====================
            // ====================SQUARE_CENTIMETER
            // ====================
            // to_factor = 0.01
            to_factor = SQUARE_CENTIMETER.getFactor();
            msg = String.format("%s / (0.01 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareCentimeters(test), delta);
            // ====================
            // ====================SQUARE_DECIMETER
            // ====================
            // to_factor = 0.1
            to_factor = SQUARE_DECIMETER.getFactor();
            msg = String.format("%s / (0.1 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDecimeters(test), delta);
            // ====================
            // ====================SQUARE_METER
            // ====================
            // to_factor = 1.0
            to_factor = SQUARE_METER.getFactor();
            msg = String.format("%s / (1 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareMeters(test), delta);
            // ====================
            // ====================SQUARE_DEKAMETER
            // ====================
            // to_factor = 10.0
            to_factor = SQUARE_DEKAMETER.getFactor();
            msg = String.format("%s / (10 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareDekameters(test), delta);
            // ====================
            // ====================SQUARE_HECOMETER
            // ====================
            // to_factor = 100.0
            to_factor = SQUARE_HECOMETER.getFactor();
            msg = String.format("%s / (100 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareHecometers(test), delta);
            // ====================
            // ====================SQUARE_KILOMETER
            // ====================
            // to_factor = 1000.0
            to_factor = SQUARE_KILOMETER.getFactor();
            msg = String.format("%s / (1000 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_MILLIMETER.toSquareKilometers(test), delta);
        }
    }

    @Test()
    public void testSquareCentimeter() {
        // from_factor = 0.01
        double from_factor = SQUARE_CENTIMETER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SQUARE_MILLIMETER
            // ====================
            // to_factor = 0.001
            to_factor = SQUARE_MILLIMETER.getFactor();
            msg = String.format("%s * (0.01 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareMillimeters(test), delta);
            // ====================
            // ====================SQUARE_CENTIMETER
            // ====================
            // to_factor = 0.01
            to_factor = SQUARE_CENTIMETER.getFactor();
            msg = String.format("%s * (0.01 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_CENTIMETER.toSquareCentimeters(test), delta);
            // ====================
            // ====================SQUARE_DECIMETER
            // ====================
            // to_factor = 0.1
            to_factor = SQUARE_DECIMETER.getFactor();
            msg = String.format("%s / (0.1 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDecimeters(test), delta);
            // ====================
            // ====================SQUARE_METER
            // ====================
            // to_factor = 1.0
            to_factor = SQUARE_METER.getFactor();
            msg = String.format("%s / (1 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareMeters(test), delta);
            // ====================
            // ====================SQUARE_DEKAMETER
            // ====================
            // to_factor = 10.0
            to_factor = SQUARE_DEKAMETER.getFactor();
            msg = String.format("%s / (10 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareDekameters(test), delta);
            // ====================
            // ====================SQUARE_HECOMETER
            // ====================
            // to_factor = 100.0
            to_factor = SQUARE_HECOMETER.getFactor();
            msg = String.format("%s / (100 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareHecometers(test), delta);
            // ====================
            // ====================SQUARE_KILOMETER
            // ====================
            // to_factor = 1000.0
            to_factor = SQUARE_KILOMETER.getFactor();
            msg = String.format("%s / (1000 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_CENTIMETER.toSquareKilometers(test), delta);
        }
    }

    @Test()
    public void testSquareDecimeter() {
        // from_factor = 0.1
        double from_factor = SQUARE_DECIMETER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SQUARE_MILLIMETER
            // ====================
            // to_factor = 0.001
            to_factor = SQUARE_MILLIMETER.getFactor();
            msg = String.format("%s * (0.1 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_DECIMETER.toSquareMillimeters(test), delta);
            // ====================
            // ====================SQUARE_CENTIMETER
            // ====================
            // to_factor = 0.01
            to_factor = SQUARE_CENTIMETER.getFactor();
            msg = String.format("%s * (0.1 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_DECIMETER.toSquareCentimeters(test), delta);
            // ====================
            // ====================SQUARE_DECIMETER
            // ====================
            // to_factor = 0.1
            to_factor = SQUARE_DECIMETER.getFactor();
            msg = String.format("%s * (0.1 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_DECIMETER.toSquareDecimeters(test), delta);
            // ====================
            // ====================SQUARE_METER
            // ====================
            // to_factor = 1.0
            to_factor = SQUARE_METER.getFactor();
            msg = String.format("%s / (1 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_DECIMETER.toSquareMeters(test), delta);
            // ====================
            // ====================SQUARE_DEKAMETER
            // ====================
            // to_factor = 10.0
            to_factor = SQUARE_DEKAMETER.getFactor();
            msg = String.format("%s / (10 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_DECIMETER.toSquareDekameters(test), delta);
            // ====================
            // ====================SQUARE_HECOMETER
            // ====================
            // to_factor = 100.0
            to_factor = SQUARE_HECOMETER.getFactor();
            msg = String.format("%s / (100 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_DECIMETER.toSquareHecometers(test), delta);
            // ====================
            // ====================SQUARE_KILOMETER
            // ====================
            // to_factor = 1000.0
            to_factor = SQUARE_KILOMETER.getFactor();
            msg = String.format("%s / (1000 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_DECIMETER.toSquareKilometers(test), delta);
        }
    }

    @Test()
    public void testSquareMeter() {
        // from_factor = 1.0
        double from_factor = SQUARE_METER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SQUARE_MILLIMETER
            // ====================
            // to_factor = 0.001
            to_factor = SQUARE_MILLIMETER.getFactor();
            msg = String.format("%s * (1 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_METER.toSquareMillimeters(test), delta);
            // ====================
            // ====================SQUARE_CENTIMETER
            // ====================
            // to_factor = 0.01
            to_factor = SQUARE_CENTIMETER.getFactor();
            msg = String.format("%s * (1 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_METER.toSquareCentimeters(test), delta);
            // ====================
            // ====================SQUARE_DECIMETER
            // ====================
            // to_factor = 0.1
            to_factor = SQUARE_DECIMETER.getFactor();
            msg = String.format("%s * (1 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_METER.toSquareDecimeters(test), delta);
            // ====================
            // ====================SQUARE_METER
            // ====================
            // to_factor = 1.0
            to_factor = SQUARE_METER.getFactor();
            msg = String.format("%s * (1 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_METER.toSquareMeters(test), delta);
            // ====================
            // ====================SQUARE_DEKAMETER
            // ====================
            // to_factor = 10.0
            to_factor = SQUARE_DEKAMETER.getFactor();
            msg = String.format("%s / (10 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_METER.toSquareDekameters(test), delta);
            // ====================
            // ====================SQUARE_HECOMETER
            // ====================
            // to_factor = 100.0
            to_factor = SQUARE_HECOMETER.getFactor();
            msg = String.format("%s / (100 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_METER.toSquareHecometers(test), delta);
            // ====================
            // ====================SQUARE_KILOMETER
            // ====================
            // to_factor = 1000.0
            to_factor = SQUARE_KILOMETER.getFactor();
            msg = String.format("%s / (1000 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_METER.toSquareKilometers(test), delta);
        }
    }

    @Test()
    public void testSquareDekameter() {
        // from_factor = 10.0
        double from_factor = SQUARE_DEKAMETER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SQUARE_MILLIMETER
            // ====================
            // to_factor = 0.001
            to_factor = SQUARE_MILLIMETER.getFactor();
            msg = String.format("%s * (10 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMillimeters(test), delta);
            // ====================
            // ====================SQUARE_CENTIMETER
            // ====================
            // to_factor = 0.01
            to_factor = SQUARE_CENTIMETER.getFactor();
            msg = String.format("%s * (10 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareCentimeters(test), delta);
            // ====================
            // ====================SQUARE_DECIMETER
            // ====================
            // to_factor = 0.1
            to_factor = SQUARE_DECIMETER.getFactor();
            msg = String.format("%s * (10 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDecimeters(test), delta);
            // ====================
            // ====================SQUARE_METER
            // ====================
            // to_factor = 1.0
            to_factor = SQUARE_METER.getFactor();
            msg = String.format("%s * (10 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareMeters(test), delta);
            // ====================
            // ====================SQUARE_DEKAMETER
            // ====================
            // to_factor = 10.0
            to_factor = SQUARE_DEKAMETER.getFactor();
            msg = String.format("%s * (10 / 10)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_DEKAMETER.toSquareDekameters(test), delta);
            // ====================
            // ====================SQUARE_HECOMETER
            // ====================
            // to_factor = 100.0
            to_factor = SQUARE_HECOMETER.getFactor();
            msg = String.format("%s / (100 / 10)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareHecometers(test), delta);
            // ====================
            // ====================SQUARE_KILOMETER
            // ====================
            // to_factor = 1000.0
            to_factor = SQUARE_KILOMETER.getFactor();
            msg = String.format("%s / (1000 / 10)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_DEKAMETER.toSquareKilometers(test), delta);
        }
    }

    @Test()
    public void testSquareHecometer() {
        // from_factor = 100.0
        double from_factor = SQUARE_HECOMETER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SQUARE_MILLIMETER
            // ====================
            // to_factor = 0.001
            to_factor = SQUARE_MILLIMETER.getFactor();
            msg = String.format("%s * (100 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMillimeters(test), delta);
            // ====================
            // ====================SQUARE_CENTIMETER
            // ====================
            // to_factor = 0.01
            to_factor = SQUARE_CENTIMETER.getFactor();
            msg = String.format("%s * (100 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_HECOMETER.toSquareCentimeters(test), delta);
            // ====================
            // ====================SQUARE_DECIMETER
            // ====================
            // to_factor = 0.1
            to_factor = SQUARE_DECIMETER.getFactor();
            msg = String.format("%s * (100 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDecimeters(test), delta);
            // ====================
            // ====================SQUARE_METER
            // ====================
            // to_factor = 1.0
            to_factor = SQUARE_METER.getFactor();
            msg = String.format("%s * (100 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_HECOMETER.toSquareMeters(test), delta);
            // ====================
            // ====================SQUARE_DEKAMETER
            // ====================
            // to_factor = 10.0
            to_factor = SQUARE_DEKAMETER.getFactor();
            msg = String.format("%s * (100 / 10)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_HECOMETER.toSquareDekameters(test), delta);
            // ====================
            // ====================SQUARE_HECOMETER
            // ====================
            // to_factor = 100.0
            to_factor = SQUARE_HECOMETER.getFactor();
            msg = String.format("%s * (100 / 100)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_HECOMETER.toSquareHecometers(test), delta);
            // ====================
            // ====================SQUARE_KILOMETER
            // ====================
            // to_factor = 1000.0
            to_factor = SQUARE_KILOMETER.getFactor();
            msg = String.format("%s / (1000 / 100)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_HECOMETER.toSquareKilometers(test), delta);
        }
    }

    @Test()
    public void testSquareKilometer() {
        // from_factor = 1000.0
        double from_factor = SQUARE_KILOMETER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SQUARE_MILLIMETER
            // ====================
            // to_factor = 0.001
            to_factor = SQUARE_MILLIMETER.getFactor();
            msg = String.format("%s * (1000 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMillimeters(test), delta);
            // ====================
            // ====================SQUARE_CENTIMETER
            // ====================
            // to_factor = 0.01
            to_factor = SQUARE_CENTIMETER.getFactor();
            msg = String.format("%s * (1000 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_KILOMETER.toSquareCentimeters(test), delta);
            // ====================
            // ====================SQUARE_DECIMETER
            // ====================
            // to_factor = 0.1
            to_factor = SQUARE_DECIMETER.getFactor();
            msg = String.format("%s * (1000 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDecimeters(test), delta);
            // ====================
            // ====================SQUARE_METER
            // ====================
            // to_factor = 1.0
            to_factor = SQUARE_METER.getFactor();
            msg = String.format("%s * (1000 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_KILOMETER.toSquareMeters(test), delta);
            // ====================
            // ====================SQUARE_DEKAMETER
            // ====================
            // to_factor = 10.0
            to_factor = SQUARE_DEKAMETER.getFactor();
            msg = String.format("%s * (1000 / 10)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_KILOMETER.toSquareDekameters(test), delta);
            // ====================
            // ====================SQUARE_HECOMETER
            // ====================
            // to_factor = 100.0
            to_factor = SQUARE_HECOMETER.getFactor();
            msg = String.format("%s * (1000 / 100)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_KILOMETER.toSquareHecometers(test), delta);
            // ====================
            // ====================SQUARE_KILOMETER
            // ====================
            // to_factor = 1000.0
            to_factor = SQUARE_KILOMETER.getFactor();
            msg = String.format("%s * (1000 / 1000)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_KILOMETER.toSquareKilometers(test), delta);
        }
    }
}
