package codes.abdullah.measurement.system.metric;

import static codes.abdullah.measurement.system.metric.Metrics.DAY;
import static codes.abdullah.measurement.system.metric.Metrics.HOUR;
import static codes.abdullah.measurement.system.metric.Metrics.MICROSECOND;
import static codes.abdullah.measurement.system.metric.Metrics.MILLISECOND;
import static codes.abdullah.measurement.system.metric.Metrics.MINUTE;
import static codes.abdullah.measurement.system.metric.Metrics.NANOSECOND;
import static codes.abdullah.measurement.system.metric.Metrics.SECOND;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static codes.abdullah.measurement.utils.TestUtils.loops;
import static codes.abdullah.measurement.utils.TestUtils.nextDouble;
import static codes.abdullah.measurement.utils.TestUtils.noE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRandomMetricTime {

    @Test()
    public void testNanosecond() {
        // from_factor = 9.999999999999999E-10
        double from_factor = NANOSECOND.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================NANOSECOND
            // ====================
            // to_factor = 9.999999999999999E-10
            to_factor = NANOSECOND.getFactor();
            msg = String.format("%s * (0.0000000009999999999999999 / 0.0000000009999999999999999)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), NANOSECOND.toNanoseconds(test), delta);
            // ====================
            // ====================MICROSECOND
            // ====================
            // to_factor = 1.0E-6
            to_factor = MICROSECOND.getFactor();
            msg = String.format("%s / (0.000001 / 0.0000000009999999999999999)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), NANOSECOND.toMicroseconds(test), delta);
            // ====================
            // ====================MILLISECOND
            // ====================
            // to_factor = 0.001
            to_factor = MILLISECOND.getFactor();
            msg = String.format("%s / (0.001 / 0.0000000009999999999999999)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), NANOSECOND.toMilliseconds(test), delta);
            // ====================
            // ====================SECOND
            // ====================
            // to_factor = 1.0
            to_factor = SECOND.getFactor();
            msg = String.format("%s / (1 / 0.0000000009999999999999999)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), NANOSECOND.toSeconds(test), delta);
            // ====================
            // ====================MINUTE
            // ====================
            // to_factor = 60.0
            to_factor = MINUTE.getFactor();
            msg = String.format("%s / (60 / 0.0000000009999999999999999)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), NANOSECOND.toMinutes(test), delta);
            // ====================
            // ====================HOUR
            // ====================
            // to_factor = 3600.0
            to_factor = HOUR.getFactor();
            msg = String.format("%s / (3600 / 0.0000000009999999999999999)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), NANOSECOND.toHours(test), delta);
            // ====================
            // ====================DAY
            // ====================
            // to_factor = 86400.0
            to_factor = DAY.getFactor();
            msg = String.format("%s / (86400 / 0.0000000009999999999999999)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), NANOSECOND.toDays(test), delta);
        }
    }

    @Test()
    public void testMicrosecond() {
        // from_factor = 1.0E-6
        double from_factor = MICROSECOND.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================NANOSECOND
            // ====================
            // to_factor = 9.999999999999999E-10
            to_factor = NANOSECOND.getFactor();
            msg = String.format("%s * (0.000001 / 0.0000000009999999999999999)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MICROSECOND.toNanoseconds(test), delta);
            // ====================
            // ====================MICROSECOND
            // ====================
            // to_factor = 1.0E-6
            to_factor = MICROSECOND.getFactor();
            msg = String.format("%s * (0.000001 / 0.000001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MICROSECOND.toMicroseconds(test), delta);
            // ====================
            // ====================MILLISECOND
            // ====================
            // to_factor = 0.001
            to_factor = MILLISECOND.getFactor();
            msg = String.format("%s / (0.001 / 0.000001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MICROSECOND.toMilliseconds(test), delta);
            // ====================
            // ====================SECOND
            // ====================
            // to_factor = 1.0
            to_factor = SECOND.getFactor();
            msg = String.format("%s / (1 / 0.000001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MICROSECOND.toSeconds(test), delta);
            // ====================
            // ====================MINUTE
            // ====================
            // to_factor = 60.0
            to_factor = MINUTE.getFactor();
            msg = String.format("%s / (60 / 0.000001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MICROSECOND.toMinutes(test), delta);
            // ====================
            // ====================HOUR
            // ====================
            // to_factor = 3600.0
            to_factor = HOUR.getFactor();
            msg = String.format("%s / (3600 / 0.000001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MICROSECOND.toHours(test), delta);
            // ====================
            // ====================DAY
            // ====================
            // to_factor = 86400.0
            to_factor = DAY.getFactor();
            msg = String.format("%s / (86400 / 0.000001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MICROSECOND.toDays(test), delta);
        }
    }

    @Test()
    public void testMillisecond() {
        // from_factor = 0.001
        double from_factor = MILLISECOND.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================NANOSECOND
            // ====================
            // to_factor = 9.999999999999999E-10
            to_factor = NANOSECOND.getFactor();
            msg = String.format("%s * (0.001 / 0.0000000009999999999999999)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MILLISECOND.toNanoseconds(test), delta);
            // ====================
            // ====================MICROSECOND
            // ====================
            // to_factor = 1.0E-6
            to_factor = MICROSECOND.getFactor();
            msg = String.format("%s * (0.001 / 0.000001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MILLISECOND.toMicroseconds(test), delta);
            // ====================
            // ====================MILLISECOND
            // ====================
            // to_factor = 0.001
            to_factor = MILLISECOND.getFactor();
            msg = String.format("%s * (0.001 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MILLISECOND.toMilliseconds(test), delta);
            // ====================
            // ====================SECOND
            // ====================
            // to_factor = 1.0
            to_factor = SECOND.getFactor();
            msg = String.format("%s / (1 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLISECOND.toSeconds(test), delta);
            // ====================
            // ====================MINUTE
            // ====================
            // to_factor = 60.0
            to_factor = MINUTE.getFactor();
            msg = String.format("%s / (60 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLISECOND.toMinutes(test), delta);
            // ====================
            // ====================HOUR
            // ====================
            // to_factor = 3600.0
            to_factor = HOUR.getFactor();
            msg = String.format("%s / (3600 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLISECOND.toHours(test), delta);
            // ====================
            // ====================DAY
            // ====================
            // to_factor = 86400.0
            to_factor = DAY.getFactor();
            msg = String.format("%s / (86400 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MILLISECOND.toDays(test), delta);
        }
    }

    @Test()
    public void testSecond() {
        // from_factor = 1.0
        double from_factor = SECOND.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================NANOSECOND
            // ====================
            // to_factor = 9.999999999999999E-10
            to_factor = NANOSECOND.getFactor();
            msg = String.format("%s * (1 / 0.0000000009999999999999999)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SECOND.toNanoseconds(test), delta);
            // ====================
            // ====================MICROSECOND
            // ====================
            // to_factor = 1.0E-6
            to_factor = MICROSECOND.getFactor();
            msg = String.format("%s * (1 / 0.000001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SECOND.toMicroseconds(test), delta);
            // ====================
            // ====================MILLISECOND
            // ====================
            // to_factor = 0.001
            to_factor = MILLISECOND.getFactor();
            msg = String.format("%s * (1 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SECOND.toMilliseconds(test), delta);
            // ====================
            // ====================SECOND
            // ====================
            // to_factor = 1.0
            to_factor = SECOND.getFactor();
            msg = String.format("%s * (1 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SECOND.toSeconds(test), delta);
            // ====================
            // ====================MINUTE
            // ====================
            // to_factor = 60.0
            to_factor = MINUTE.getFactor();
            msg = String.format("%s / (60 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SECOND.toMinutes(test), delta);
            // ====================
            // ====================HOUR
            // ====================
            // to_factor = 3600.0
            to_factor = HOUR.getFactor();
            msg = String.format("%s / (3600 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SECOND.toHours(test), delta);
            // ====================
            // ====================DAY
            // ====================
            // to_factor = 86400.0
            to_factor = DAY.getFactor();
            msg = String.format("%s / (86400 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SECOND.toDays(test), delta);
        }
    }

    @Test()
    public void testMinute() {
        // from_factor = 60.0
        double from_factor = MINUTE.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================NANOSECOND
            // ====================
            // to_factor = 9.999999999999999E-10
            to_factor = NANOSECOND.getFactor();
            msg = String.format("%s * (60 / 0.0000000009999999999999999)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MINUTE.toNanoseconds(test), delta);
            // ====================
            // ====================MICROSECOND
            // ====================
            // to_factor = 1.0E-6
            to_factor = MICROSECOND.getFactor();
            msg = String.format("%s * (60 / 0.000001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MINUTE.toMicroseconds(test), delta);
            // ====================
            // ====================MILLISECOND
            // ====================
            // to_factor = 0.001
            to_factor = MILLISECOND.getFactor();
            msg = String.format("%s * (60 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MINUTE.toMilliseconds(test), delta);
            // ====================
            // ====================SECOND
            // ====================
            // to_factor = 1.0
            to_factor = SECOND.getFactor();
            msg = String.format("%s * (60 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MINUTE.toSeconds(test), delta);
            // ====================
            // ====================MINUTE
            // ====================
            // to_factor = 60.0
            to_factor = MINUTE.getFactor();
            msg = String.format("%s * (60 / 60)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MINUTE.toMinutes(test), delta);
            // ====================
            // ====================HOUR
            // ====================
            // to_factor = 3600.0
            to_factor = HOUR.getFactor();
            msg = String.format("%s / (3600 / 60)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MINUTE.toHours(test), delta);
            // ====================
            // ====================DAY
            // ====================
            // to_factor = 86400.0
            to_factor = DAY.getFactor();
            msg = String.format("%s / (86400 / 60)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MINUTE.toDays(test), delta);
        }
    }

    @Test()
    public void testHour() {
        // from_factor = 3600.0
        double from_factor = HOUR.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================NANOSECOND
            // ====================
            // to_factor = 9.999999999999999E-10
            to_factor = NANOSECOND.getFactor();
            msg = String.format("%s * (3600 / 0.0000000009999999999999999)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HOUR.toNanoseconds(test), delta);
            // ====================
            // ====================MICROSECOND
            // ====================
            // to_factor = 1.0E-6
            to_factor = MICROSECOND.getFactor();
            msg = String.format("%s * (3600 / 0.000001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HOUR.toMicroseconds(test), delta);
            // ====================
            // ====================MILLISECOND
            // ====================
            // to_factor = 0.001
            to_factor = MILLISECOND.getFactor();
            msg = String.format("%s * (3600 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HOUR.toMilliseconds(test), delta);
            // ====================
            // ====================SECOND
            // ====================
            // to_factor = 1.0
            to_factor = SECOND.getFactor();
            msg = String.format("%s * (3600 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HOUR.toSeconds(test), delta);
            // ====================
            // ====================MINUTE
            // ====================
            // to_factor = 60.0
            to_factor = MINUTE.getFactor();
            msg = String.format("%s * (3600 / 60)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HOUR.toMinutes(test), delta);
            // ====================
            // ====================HOUR
            // ====================
            // to_factor = 3600.0
            to_factor = HOUR.getFactor();
            msg = String.format("%s * (3600 / 3600)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HOUR.toHours(test), delta);
            // ====================
            // ====================DAY
            // ====================
            // to_factor = 86400.0
            to_factor = DAY.getFactor();
            msg = String.format("%s / (86400 / 3600)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), HOUR.toDays(test), delta);
        }
    }

    @Test()
    public void testDay() {
        // from_factor = 86400.0
        double from_factor = DAY.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================NANOSECOND
            // ====================
            // to_factor = 9.999999999999999E-10
            to_factor = NANOSECOND.getFactor();
            msg = String.format("%s * (86400 / 0.0000000009999999999999999)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DAY.toNanoseconds(test), delta);
            // ====================
            // ====================MICROSECOND
            // ====================
            // to_factor = 1.0E-6
            to_factor = MICROSECOND.getFactor();
            msg = String.format("%s * (86400 / 0.000001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DAY.toMicroseconds(test), delta);
            // ====================
            // ====================MILLISECOND
            // ====================
            // to_factor = 0.001
            to_factor = MILLISECOND.getFactor();
            msg = String.format("%s * (86400 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DAY.toMilliseconds(test), delta);
            // ====================
            // ====================SECOND
            // ====================
            // to_factor = 1.0
            to_factor = SECOND.getFactor();
            msg = String.format("%s * (86400 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DAY.toSeconds(test), delta);
            // ====================
            // ====================MINUTE
            // ====================
            // to_factor = 60.0
            to_factor = MINUTE.getFactor();
            msg = String.format("%s * (86400 / 60)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DAY.toMinutes(test), delta);
            // ====================
            // ====================HOUR
            // ====================
            // to_factor = 3600.0
            to_factor = HOUR.getFactor();
            msg = String.format("%s * (86400 / 3600)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DAY.toHours(test), delta);
            // ====================
            // ====================DAY
            // ====================
            // to_factor = 86400.0
            to_factor = DAY.getFactor();
            msg = String.format("%s * (86400 / 86400)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DAY.toDays(test), delta);
        }
    }
}
