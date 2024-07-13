package codes.abdullah.measurement.system.metric;

import static codes.abdullah.measurement.system.metric.Metrics.DAY;
import static codes.abdullah.measurement.system.metric.Metrics.HOUR;
import static codes.abdullah.measurement.system.metric.Metrics.MICROSECOND;
import static codes.abdullah.measurement.system.metric.Metrics.MILLISECOND;
import static codes.abdullah.measurement.system.metric.Metrics.MINUTE;
import static codes.abdullah.measurement.system.metric.Metrics.NANOSECOND;
import static codes.abdullah.measurement.system.metric.Metrics.SECOND;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFixedMetricTime {

    @Test()
    public void testNanosecond() {
        // from_factor = 9.999999999999999E-10
        double from_factor = NANOSECOND.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================NANOSECOND
        // ====================
        // to_factor = 9.999999999999999E-10
        to_factor = NANOSECOND.getFactor();
        msg = "-1 * (0.0000000009999999999999999 / 0.0000000009999999999999999)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), NANOSECOND.toNanoseconds(-1.0), delta);
        msg = "-0.1 * (0.0000000009999999999999999 / 0.0000000009999999999999999)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), NANOSECOND.toNanoseconds(-0.1), delta);
        msg = "-0.000456789 * (0.0000000009999999999999999 / 0.0000000009999999999999999)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), NANOSECOND.toNanoseconds(-4.56789E-4), delta);
        msg = "-73.25 * (0.0000000009999999999999999 / 0.0000000009999999999999999)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), NANOSECOND.toNanoseconds(-73.25), delta);
        msg = "-56229.321 * (0.0000000009999999999999999 / 0.0000000009999999999999999)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), NANOSECOND.toNanoseconds(-56229.321), delta);
        msg = "-873.5432456 * (0.0000000009999999999999999 / 0.0000000009999999999999999)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), NANOSECOND.toNanoseconds(-873.5432456), delta);
        msg = "0 * (0.0000000009999999999999999 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), NANOSECOND.toNanoseconds(0.0), delta);
        msg = "0.1 * (0.0000000009999999999999999 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), NANOSECOND.toNanoseconds(0.1), delta);
        msg = "0.0000876543297 * (0.0000000009999999999999999 / 0.0000000009999999999999999)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), NANOSECOND.toNanoseconds(8.76543297E-5), delta);
        msg = "0.33 * (0.0000000009999999999999999 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), NANOSECOND.toNanoseconds(0.33), delta);
        msg = "0.6543 * (0.0000000009999999999999999 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), NANOSECOND.toNanoseconds(0.6543), delta);
        msg = "1 * (0.0000000009999999999999999 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), NANOSECOND.toNanoseconds(1.0), delta);
        msg = "1.6543 * (0.0000000009999999999999999 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), NANOSECOND.toNanoseconds(1.6543), delta);
        msg = "22.45 * (0.0000000009999999999999999 / 0.0000000009999999999999999)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), NANOSECOND.toNanoseconds(22.45), delta);
        msg = "9876.5432 * (0.0000000009999999999999999 / 0.0000000009999999999999999)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), NANOSECOND.toNanoseconds(9876.5432), delta);
        msg = "1987654344.3345 * (0.0000000009999999999999999 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), NANOSECOND.toNanoseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.0000000009999999999999999 / 0.0000000009999999999999999)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), NANOSECOND.toNanoseconds(784.46789765434), delta);
        // ====================
        // ====================MICROSECOND
        // ====================
        // to_factor = 1.0E-6
        to_factor = MICROSECOND.getFactor();
        msg = "-1 / (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), NANOSECOND.toMicroseconds(-1.0), delta);
        msg = "-0.1 / (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), NANOSECOND.toMicroseconds(-0.1), delta);
        msg = "-0.000456789 / (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), NANOSECOND.toMicroseconds(-4.56789E-4), delta);
        msg = "-73.25 / (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), NANOSECOND.toMicroseconds(-73.25), delta);
        msg = "-56229.321 / (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), NANOSECOND.toMicroseconds(-56229.321), delta);
        msg = "-873.5432456 / (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), NANOSECOND.toMicroseconds(-873.5432456), delta);
        msg = "0 / (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), NANOSECOND.toMicroseconds(0.0), delta);
        msg = "0.1 / (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), NANOSECOND.toMicroseconds(0.1), delta);
        msg = "0.0000876543297 / (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), NANOSECOND.toMicroseconds(8.76543297E-5), delta);
        msg = "0.33 / (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), NANOSECOND.toMicroseconds(0.33), delta);
        msg = "0.6543 / (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), NANOSECOND.toMicroseconds(0.6543), delta);
        msg = "1 / (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), NANOSECOND.toMicroseconds(1.0), delta);
        msg = "1.6543 / (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), NANOSECOND.toMicroseconds(1.6543), delta);
        msg = "22.45 / (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), NANOSECOND.toMicroseconds(22.45), delta);
        msg = "9876.5432 / (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), NANOSECOND.toMicroseconds(9876.5432), delta);
        msg = "1987654344.3345 / (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), NANOSECOND.toMicroseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), NANOSECOND.toMicroseconds(784.46789765434), delta);
        // ====================
        // ====================MILLISECOND
        // ====================
        // to_factor = 0.001
        to_factor = MILLISECOND.getFactor();
        msg = "-1 / (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), NANOSECOND.toMilliseconds(-1.0), delta);
        msg = "-0.1 / (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), NANOSECOND.toMilliseconds(-0.1), delta);
        msg = "-0.000456789 / (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), NANOSECOND.toMilliseconds(-4.56789E-4), delta);
        msg = "-73.25 / (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), NANOSECOND.toMilliseconds(-73.25), delta);
        msg = "-56229.321 / (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), NANOSECOND.toMilliseconds(-56229.321), delta);
        msg = "-873.5432456 / (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), NANOSECOND.toMilliseconds(-873.5432456), delta);
        msg = "0 / (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), NANOSECOND.toMilliseconds(0.0), delta);
        msg = "0.1 / (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), NANOSECOND.toMilliseconds(0.1), delta);
        msg = "0.0000876543297 / (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), NANOSECOND.toMilliseconds(8.76543297E-5), delta);
        msg = "0.33 / (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), NANOSECOND.toMilliseconds(0.33), delta);
        msg = "0.6543 / (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), NANOSECOND.toMilliseconds(0.6543), delta);
        msg = "1 / (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), NANOSECOND.toMilliseconds(1.0), delta);
        msg = "1.6543 / (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), NANOSECOND.toMilliseconds(1.6543), delta);
        msg = "22.45 / (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), NANOSECOND.toMilliseconds(22.45), delta);
        msg = "9876.5432 / (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), NANOSECOND.toMilliseconds(9876.5432), delta);
        msg = "1987654344.3345 / (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), NANOSECOND.toMilliseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), NANOSECOND.toMilliseconds(784.46789765434), delta);
        // ====================
        // ====================SECOND
        // ====================
        // to_factor = 1.0
        to_factor = SECOND.getFactor();
        msg = "-1 / (1 / 0.0000000009999999999999999)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), NANOSECOND.toSeconds(-1.0), delta);
        msg = "-0.1 / (1 / 0.0000000009999999999999999)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), NANOSECOND.toSeconds(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.0000000009999999999999999)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), NANOSECOND.toSeconds(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.0000000009999999999999999)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), NANOSECOND.toSeconds(-73.25), delta);
        msg = "-56229.321 / (1 / 0.0000000009999999999999999)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), NANOSECOND.toSeconds(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.0000000009999999999999999)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), NANOSECOND.toSeconds(-873.5432456), delta);
        msg = "0 / (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), NANOSECOND.toSeconds(0.0), delta);
        msg = "0.1 / (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), NANOSECOND.toSeconds(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), NANOSECOND.toSeconds(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), NANOSECOND.toSeconds(0.33), delta);
        msg = "0.6543 / (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), NANOSECOND.toSeconds(0.6543), delta);
        msg = "1 / (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), NANOSECOND.toSeconds(1.0), delta);
        msg = "1.6543 / (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), NANOSECOND.toSeconds(1.6543), delta);
        msg = "22.45 / (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), NANOSECOND.toSeconds(22.45), delta);
        msg = "9876.5432 / (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), NANOSECOND.toSeconds(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), NANOSECOND.toSeconds(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), NANOSECOND.toSeconds(784.46789765434), delta);
        // ====================
        // ====================MINUTE
        // ====================
        // to_factor = 60.0
        to_factor = MINUTE.getFactor();
        msg = "-1 / (60 / 0.0000000009999999999999999)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), NANOSECOND.toMinutes(-1.0), delta);
        msg = "-0.1 / (60 / 0.0000000009999999999999999)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), NANOSECOND.toMinutes(-0.1), delta);
        msg = "-0.000456789 / (60 / 0.0000000009999999999999999)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), NANOSECOND.toMinutes(-4.56789E-4), delta);
        msg = "-73.25 / (60 / 0.0000000009999999999999999)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), NANOSECOND.toMinutes(-73.25), delta);
        msg = "-56229.321 / (60 / 0.0000000009999999999999999)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), NANOSECOND.toMinutes(-56229.321), delta);
        msg = "-873.5432456 / (60 / 0.0000000009999999999999999)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), NANOSECOND.toMinutes(-873.5432456), delta);
        msg = "0 / (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), NANOSECOND.toMinutes(0.0), delta);
        msg = "0.1 / (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), NANOSECOND.toMinutes(0.1), delta);
        msg = "0.0000876543297 / (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), NANOSECOND.toMinutes(8.76543297E-5), delta);
        msg = "0.33 / (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), NANOSECOND.toMinutes(0.33), delta);
        msg = "0.6543 / (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), NANOSECOND.toMinutes(0.6543), delta);
        msg = "1 / (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), NANOSECOND.toMinutes(1.0), delta);
        msg = "1.6543 / (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), NANOSECOND.toMinutes(1.6543), delta);
        msg = "22.45 / (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), NANOSECOND.toMinutes(22.45), delta);
        msg = "9876.5432 / (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), NANOSECOND.toMinutes(9876.5432), delta);
        msg = "1987654344.3345 / (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), NANOSECOND.toMinutes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), NANOSECOND.toMinutes(784.46789765434), delta);
        // ====================
        // ====================HOUR
        // ====================
        // to_factor = 3600.0
        to_factor = HOUR.getFactor();
        msg = "-1 / (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), NANOSECOND.toHours(-1.0), delta);
        msg = "-0.1 / (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), NANOSECOND.toHours(-0.1), delta);
        msg = "-0.000456789 / (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), NANOSECOND.toHours(-4.56789E-4), delta);
        msg = "-73.25 / (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), NANOSECOND.toHours(-73.25), delta);
        msg = "-56229.321 / (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), NANOSECOND.toHours(-56229.321), delta);
        msg = "-873.5432456 / (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), NANOSECOND.toHours(-873.5432456), delta);
        msg = "0 / (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), NANOSECOND.toHours(0.0), delta);
        msg = "0.1 / (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), NANOSECOND.toHours(0.1), delta);
        msg = "0.0000876543297 / (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), NANOSECOND.toHours(8.76543297E-5), delta);
        msg = "0.33 / (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), NANOSECOND.toHours(0.33), delta);
        msg = "0.6543 / (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), NANOSECOND.toHours(0.6543), delta);
        msg = "1 / (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), NANOSECOND.toHours(1.0), delta);
        msg = "1.6543 / (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), NANOSECOND.toHours(1.6543), delta);
        msg = "22.45 / (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), NANOSECOND.toHours(22.45), delta);
        msg = "9876.5432 / (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), NANOSECOND.toHours(9876.5432), delta);
        msg = "1987654344.3345 / (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), NANOSECOND.toHours(1.9876543443345E9), delta);
        msg = "784.46789765434 / (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), NANOSECOND.toHours(784.46789765434), delta);
        // ====================
        // ====================DAY
        // ====================
        // to_factor = 86400.0
        to_factor = DAY.getFactor();
        msg = "-1 / (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), NANOSECOND.toDays(-1.0), delta);
        msg = "-0.1 / (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), NANOSECOND.toDays(-0.1), delta);
        msg = "-0.000456789 / (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), NANOSECOND.toDays(-4.56789E-4), delta);
        msg = "-73.25 / (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), NANOSECOND.toDays(-73.25), delta);
        msg = "-56229.321 / (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), NANOSECOND.toDays(-56229.321), delta);
        msg = "-873.5432456 / (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), NANOSECOND.toDays(-873.5432456), delta);
        msg = "0 / (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), NANOSECOND.toDays(0.0), delta);
        msg = "0.1 / (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), NANOSECOND.toDays(0.1), delta);
        msg = "0.0000876543297 / (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), NANOSECOND.toDays(8.76543297E-5), delta);
        msg = "0.33 / (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), NANOSECOND.toDays(0.33), delta);
        msg = "0.6543 / (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), NANOSECOND.toDays(0.6543), delta);
        msg = "1 / (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), NANOSECOND.toDays(1.0), delta);
        msg = "1.6543 / (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), NANOSECOND.toDays(1.6543), delta);
        msg = "22.45 / (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), NANOSECOND.toDays(22.45), delta);
        msg = "9876.5432 / (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), NANOSECOND.toDays(9876.5432), delta);
        msg = "1987654344.3345 / (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), NANOSECOND.toDays(1.9876543443345E9), delta);
        msg = "784.46789765434 / (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), NANOSECOND.toDays(784.46789765434), delta);
    }

    @Test()
    public void testMicrosecond() {
        // from_factor = 1.0E-6
        double from_factor = MICROSECOND.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================NANOSECOND
        // ====================
        // to_factor = 9.999999999999999E-10
        to_factor = NANOSECOND.getFactor();
        msg = "-1 * (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MICROSECOND.toNanoseconds(-1.0), delta);
        msg = "-0.1 * (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MICROSECOND.toNanoseconds(-0.1), delta);
        msg = "-0.000456789 * (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MICROSECOND.toNanoseconds(-4.56789E-4), delta);
        msg = "-73.25 * (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MICROSECOND.toNanoseconds(-73.25), delta);
        msg = "-56229.321 * (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MICROSECOND.toNanoseconds(-56229.321), delta);
        msg = "-873.5432456 * (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MICROSECOND.toNanoseconds(-873.5432456), delta);
        msg = "0 * (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MICROSECOND.toNanoseconds(0.0), delta);
        msg = "0.1 * (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MICROSECOND.toNanoseconds(0.1), delta);
        msg = "0.0000876543297 * (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MICROSECOND.toNanoseconds(8.76543297E-5), delta);
        msg = "0.33 * (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MICROSECOND.toNanoseconds(0.33), delta);
        msg = "0.6543 * (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MICROSECOND.toNanoseconds(0.6543), delta);
        msg = "1 * (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MICROSECOND.toNanoseconds(1.0), delta);
        msg = "1.6543 * (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MICROSECOND.toNanoseconds(1.6543), delta);
        msg = "22.45 * (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MICROSECOND.toNanoseconds(22.45), delta);
        msg = "9876.5432 * (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MICROSECOND.toNanoseconds(9876.5432), delta);
        msg = "1987654344.3345 * (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MICROSECOND.toNanoseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.000001 / 0.0000000009999999999999999)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MICROSECOND.toNanoseconds(784.46789765434), delta);
        // ====================
        // ====================MICROSECOND
        // ====================
        // to_factor = 1.0E-6
        to_factor = MICROSECOND.getFactor();
        msg = "-1 * (0.000001 / 0.000001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MICROSECOND.toMicroseconds(-1.0), delta);
        msg = "-0.1 * (0.000001 / 0.000001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MICROSECOND.toMicroseconds(-0.1), delta);
        msg = "-0.000456789 * (0.000001 / 0.000001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MICROSECOND.toMicroseconds(-4.56789E-4), delta);
        msg = "-73.25 * (0.000001 / 0.000001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MICROSECOND.toMicroseconds(-73.25), delta);
        msg = "-56229.321 * (0.000001 / 0.000001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MICROSECOND.toMicroseconds(-56229.321), delta);
        msg = "-873.5432456 * (0.000001 / 0.000001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MICROSECOND.toMicroseconds(-873.5432456), delta);
        msg = "0 * (0.000001 / 0.000001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MICROSECOND.toMicroseconds(0.0), delta);
        msg = "0.1 * (0.000001 / 0.000001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MICROSECOND.toMicroseconds(0.1), delta);
        msg = "0.0000876543297 * (0.000001 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MICROSECOND.toMicroseconds(8.76543297E-5), delta);
        msg = "0.33 * (0.000001 / 0.000001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MICROSECOND.toMicroseconds(0.33), delta);
        msg = "0.6543 * (0.000001 / 0.000001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MICROSECOND.toMicroseconds(0.6543), delta);
        msg = "1 * (0.000001 / 0.000001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MICROSECOND.toMicroseconds(1.0), delta);
        msg = "1.6543 * (0.000001 / 0.000001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MICROSECOND.toMicroseconds(1.6543), delta);
        msg = "22.45 * (0.000001 / 0.000001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MICROSECOND.toMicroseconds(22.45), delta);
        msg = "9876.5432 * (0.000001 / 0.000001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MICROSECOND.toMicroseconds(9876.5432), delta);
        msg = "1987654344.3345 * (0.000001 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MICROSECOND.toMicroseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.000001 / 0.000001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MICROSECOND.toMicroseconds(784.46789765434), delta);
        // ====================
        // ====================MILLISECOND
        // ====================
        // to_factor = 0.001
        to_factor = MILLISECOND.getFactor();
        msg = "-1 / (0.001 / 0.000001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MICROSECOND.toMilliseconds(-1.0), delta);
        msg = "-0.1 / (0.001 / 0.000001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MICROSECOND.toMilliseconds(-0.1), delta);
        msg = "-0.000456789 / (0.001 / 0.000001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MICROSECOND.toMilliseconds(-4.56789E-4), delta);
        msg = "-73.25 / (0.001 / 0.000001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MICROSECOND.toMilliseconds(-73.25), delta);
        msg = "-56229.321 / (0.001 / 0.000001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MICROSECOND.toMilliseconds(-56229.321), delta);
        msg = "-873.5432456 / (0.001 / 0.000001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MICROSECOND.toMilliseconds(-873.5432456), delta);
        msg = "0 / (0.001 / 0.000001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MICROSECOND.toMilliseconds(0.0), delta);
        msg = "0.1 / (0.001 / 0.000001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MICROSECOND.toMilliseconds(0.1), delta);
        msg = "0.0000876543297 / (0.001 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MICROSECOND.toMilliseconds(8.76543297E-5), delta);
        msg = "0.33 / (0.001 / 0.000001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MICROSECOND.toMilliseconds(0.33), delta);
        msg = "0.6543 / (0.001 / 0.000001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MICROSECOND.toMilliseconds(0.6543), delta);
        msg = "1 / (0.001 / 0.000001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MICROSECOND.toMilliseconds(1.0), delta);
        msg = "1.6543 / (0.001 / 0.000001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MICROSECOND.toMilliseconds(1.6543), delta);
        msg = "22.45 / (0.001 / 0.000001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MICROSECOND.toMilliseconds(22.45), delta);
        msg = "9876.5432 / (0.001 / 0.000001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MICROSECOND.toMilliseconds(9876.5432), delta);
        msg = "1987654344.3345 / (0.001 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MICROSECOND.toMilliseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.001 / 0.000001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MICROSECOND.toMilliseconds(784.46789765434), delta);
        // ====================
        // ====================SECOND
        // ====================
        // to_factor = 1.0
        to_factor = SECOND.getFactor();
        msg = "-1 / (1 / 0.000001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MICROSECOND.toSeconds(-1.0), delta);
        msg = "-0.1 / (1 / 0.000001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MICROSECOND.toSeconds(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.000001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MICROSECOND.toSeconds(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.000001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MICROSECOND.toSeconds(-73.25), delta);
        msg = "-56229.321 / (1 / 0.000001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MICROSECOND.toSeconds(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.000001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MICROSECOND.toSeconds(-873.5432456), delta);
        msg = "0 / (1 / 0.000001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MICROSECOND.toSeconds(0.0), delta);
        msg = "0.1 / (1 / 0.000001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MICROSECOND.toSeconds(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MICROSECOND.toSeconds(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.000001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MICROSECOND.toSeconds(0.33), delta);
        msg = "0.6543 / (1 / 0.000001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MICROSECOND.toSeconds(0.6543), delta);
        msg = "1 / (1 / 0.000001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MICROSECOND.toSeconds(1.0), delta);
        msg = "1.6543 / (1 / 0.000001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MICROSECOND.toSeconds(1.6543), delta);
        msg = "22.45 / (1 / 0.000001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MICROSECOND.toSeconds(22.45), delta);
        msg = "9876.5432 / (1 / 0.000001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MICROSECOND.toSeconds(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MICROSECOND.toSeconds(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.000001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MICROSECOND.toSeconds(784.46789765434), delta);
        // ====================
        // ====================MINUTE
        // ====================
        // to_factor = 60.0
        to_factor = MINUTE.getFactor();
        msg = "-1 / (60 / 0.000001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MICROSECOND.toMinutes(-1.0), delta);
        msg = "-0.1 / (60 / 0.000001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MICROSECOND.toMinutes(-0.1), delta);
        msg = "-0.000456789 / (60 / 0.000001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MICROSECOND.toMinutes(-4.56789E-4), delta);
        msg = "-73.25 / (60 / 0.000001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MICROSECOND.toMinutes(-73.25), delta);
        msg = "-56229.321 / (60 / 0.000001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MICROSECOND.toMinutes(-56229.321), delta);
        msg = "-873.5432456 / (60 / 0.000001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MICROSECOND.toMinutes(-873.5432456), delta);
        msg = "0 / (60 / 0.000001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MICROSECOND.toMinutes(0.0), delta);
        msg = "0.1 / (60 / 0.000001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MICROSECOND.toMinutes(0.1), delta);
        msg = "0.0000876543297 / (60 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MICROSECOND.toMinutes(8.76543297E-5), delta);
        msg = "0.33 / (60 / 0.000001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MICROSECOND.toMinutes(0.33), delta);
        msg = "0.6543 / (60 / 0.000001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MICROSECOND.toMinutes(0.6543), delta);
        msg = "1 / (60 / 0.000001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MICROSECOND.toMinutes(1.0), delta);
        msg = "1.6543 / (60 / 0.000001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MICROSECOND.toMinutes(1.6543), delta);
        msg = "22.45 / (60 / 0.000001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MICROSECOND.toMinutes(22.45), delta);
        msg = "9876.5432 / (60 / 0.000001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MICROSECOND.toMinutes(9876.5432), delta);
        msg = "1987654344.3345 / (60 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MICROSECOND.toMinutes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (60 / 0.000001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MICROSECOND.toMinutes(784.46789765434), delta);
        // ====================
        // ====================HOUR
        // ====================
        // to_factor = 3600.0
        to_factor = HOUR.getFactor();
        msg = "-1 / (3600 / 0.000001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MICROSECOND.toHours(-1.0), delta);
        msg = "-0.1 / (3600 / 0.000001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MICROSECOND.toHours(-0.1), delta);
        msg = "-0.000456789 / (3600 / 0.000001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MICROSECOND.toHours(-4.56789E-4), delta);
        msg = "-73.25 / (3600 / 0.000001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MICROSECOND.toHours(-73.25), delta);
        msg = "-56229.321 / (3600 / 0.000001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MICROSECOND.toHours(-56229.321), delta);
        msg = "-873.5432456 / (3600 / 0.000001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MICROSECOND.toHours(-873.5432456), delta);
        msg = "0 / (3600 / 0.000001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MICROSECOND.toHours(0.0), delta);
        msg = "0.1 / (3600 / 0.000001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MICROSECOND.toHours(0.1), delta);
        msg = "0.0000876543297 / (3600 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MICROSECOND.toHours(8.76543297E-5), delta);
        msg = "0.33 / (3600 / 0.000001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MICROSECOND.toHours(0.33), delta);
        msg = "0.6543 / (3600 / 0.000001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MICROSECOND.toHours(0.6543), delta);
        msg = "1 / (3600 / 0.000001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MICROSECOND.toHours(1.0), delta);
        msg = "1.6543 / (3600 / 0.000001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MICROSECOND.toHours(1.6543), delta);
        msg = "22.45 / (3600 / 0.000001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MICROSECOND.toHours(22.45), delta);
        msg = "9876.5432 / (3600 / 0.000001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MICROSECOND.toHours(9876.5432), delta);
        msg = "1987654344.3345 / (3600 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MICROSECOND.toHours(1.9876543443345E9), delta);
        msg = "784.46789765434 / (3600 / 0.000001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MICROSECOND.toHours(784.46789765434), delta);
        // ====================
        // ====================DAY
        // ====================
        // to_factor = 86400.0
        to_factor = DAY.getFactor();
        msg = "-1 / (86400 / 0.000001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MICROSECOND.toDays(-1.0), delta);
        msg = "-0.1 / (86400 / 0.000001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MICROSECOND.toDays(-0.1), delta);
        msg = "-0.000456789 / (86400 / 0.000001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MICROSECOND.toDays(-4.56789E-4), delta);
        msg = "-73.25 / (86400 / 0.000001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MICROSECOND.toDays(-73.25), delta);
        msg = "-56229.321 / (86400 / 0.000001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MICROSECOND.toDays(-56229.321), delta);
        msg = "-873.5432456 / (86400 / 0.000001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MICROSECOND.toDays(-873.5432456), delta);
        msg = "0 / (86400 / 0.000001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MICROSECOND.toDays(0.0), delta);
        msg = "0.1 / (86400 / 0.000001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MICROSECOND.toDays(0.1), delta);
        msg = "0.0000876543297 / (86400 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MICROSECOND.toDays(8.76543297E-5), delta);
        msg = "0.33 / (86400 / 0.000001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MICROSECOND.toDays(0.33), delta);
        msg = "0.6543 / (86400 / 0.000001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MICROSECOND.toDays(0.6543), delta);
        msg = "1 / (86400 / 0.000001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MICROSECOND.toDays(1.0), delta);
        msg = "1.6543 / (86400 / 0.000001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MICROSECOND.toDays(1.6543), delta);
        msg = "22.45 / (86400 / 0.000001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MICROSECOND.toDays(22.45), delta);
        msg = "9876.5432 / (86400 / 0.000001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MICROSECOND.toDays(9876.5432), delta);
        msg = "1987654344.3345 / (86400 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MICROSECOND.toDays(1.9876543443345E9), delta);
        msg = "784.46789765434 / (86400 / 0.000001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MICROSECOND.toDays(784.46789765434), delta);
    }

    @Test()
    public void testMillisecond() {
        // from_factor = 0.001
        double from_factor = MILLISECOND.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================NANOSECOND
        // ====================
        // to_factor = 9.999999999999999E-10
        to_factor = NANOSECOND.getFactor();
        msg = "-1 * (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MILLISECOND.toNanoseconds(-1.0), delta);
        msg = "-0.1 * (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MILLISECOND.toNanoseconds(-0.1), delta);
        msg = "-0.000456789 * (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MILLISECOND.toNanoseconds(-4.56789E-4), delta);
        msg = "-73.25 * (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MILLISECOND.toNanoseconds(-73.25), delta);
        msg = "-56229.321 * (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MILLISECOND.toNanoseconds(-56229.321), delta);
        msg = "-873.5432456 * (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MILLISECOND.toNanoseconds(-873.5432456), delta);
        msg = "0 * (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MILLISECOND.toNanoseconds(0.0), delta);
        msg = "0.1 * (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MILLISECOND.toNanoseconds(0.1), delta);
        msg = "0.0000876543297 * (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MILLISECOND.toNanoseconds(8.76543297E-5), delta);
        msg = "0.33 * (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MILLISECOND.toNanoseconds(0.33), delta);
        msg = "0.6543 * (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MILLISECOND.toNanoseconds(0.6543), delta);
        msg = "1 * (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MILLISECOND.toNanoseconds(1.0), delta);
        msg = "1.6543 * (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MILLISECOND.toNanoseconds(1.6543), delta);
        msg = "22.45 * (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MILLISECOND.toNanoseconds(22.45), delta);
        msg = "9876.5432 * (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MILLISECOND.toNanoseconds(9876.5432), delta);
        msg = "1987654344.3345 * (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MILLISECOND.toNanoseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.001 / 0.0000000009999999999999999)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MILLISECOND.toNanoseconds(784.46789765434), delta);
        // ====================
        // ====================MICROSECOND
        // ====================
        // to_factor = 1.0E-6
        to_factor = MICROSECOND.getFactor();
        msg = "-1 * (0.001 / 0.000001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MILLISECOND.toMicroseconds(-1.0), delta);
        msg = "-0.1 * (0.001 / 0.000001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MILLISECOND.toMicroseconds(-0.1), delta);
        msg = "-0.000456789 * (0.001 / 0.000001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MILLISECOND.toMicroseconds(-4.56789E-4), delta);
        msg = "-73.25 * (0.001 / 0.000001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MILLISECOND.toMicroseconds(-73.25), delta);
        msg = "-56229.321 * (0.001 / 0.000001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MILLISECOND.toMicroseconds(-56229.321), delta);
        msg = "-873.5432456 * (0.001 / 0.000001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MILLISECOND.toMicroseconds(-873.5432456), delta);
        msg = "0 * (0.001 / 0.000001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MILLISECOND.toMicroseconds(0.0), delta);
        msg = "0.1 * (0.001 / 0.000001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MILLISECOND.toMicroseconds(0.1), delta);
        msg = "0.0000876543297 * (0.001 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MILLISECOND.toMicroseconds(8.76543297E-5), delta);
        msg = "0.33 * (0.001 / 0.000001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MILLISECOND.toMicroseconds(0.33), delta);
        msg = "0.6543 * (0.001 / 0.000001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MILLISECOND.toMicroseconds(0.6543), delta);
        msg = "1 * (0.001 / 0.000001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MILLISECOND.toMicroseconds(1.0), delta);
        msg = "1.6543 * (0.001 / 0.000001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MILLISECOND.toMicroseconds(1.6543), delta);
        msg = "22.45 * (0.001 / 0.000001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MILLISECOND.toMicroseconds(22.45), delta);
        msg = "9876.5432 * (0.001 / 0.000001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MILLISECOND.toMicroseconds(9876.5432), delta);
        msg = "1987654344.3345 * (0.001 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MILLISECOND.toMicroseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.001 / 0.000001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MILLISECOND.toMicroseconds(784.46789765434), delta);
        // ====================
        // ====================MILLISECOND
        // ====================
        // to_factor = 0.001
        to_factor = MILLISECOND.getFactor();
        msg = "-1 * (0.001 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MILLISECOND.toMilliseconds(-1.0), delta);
        msg = "-0.1 * (0.001 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MILLISECOND.toMilliseconds(-0.1), delta);
        msg = "-0.000456789 * (0.001 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MILLISECOND.toMilliseconds(-4.56789E-4), delta);
        msg = "-73.25 * (0.001 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MILLISECOND.toMilliseconds(-73.25), delta);
        msg = "-56229.321 * (0.001 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MILLISECOND.toMilliseconds(-56229.321), delta);
        msg = "-873.5432456 * (0.001 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MILLISECOND.toMilliseconds(-873.5432456), delta);
        msg = "0 * (0.001 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MILLISECOND.toMilliseconds(0.0), delta);
        msg = "0.1 * (0.001 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MILLISECOND.toMilliseconds(0.1), delta);
        msg = "0.0000876543297 * (0.001 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MILLISECOND.toMilliseconds(8.76543297E-5), delta);
        msg = "0.33 * (0.001 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MILLISECOND.toMilliseconds(0.33), delta);
        msg = "0.6543 * (0.001 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MILLISECOND.toMilliseconds(0.6543), delta);
        msg = "1 * (0.001 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MILLISECOND.toMilliseconds(1.0), delta);
        msg = "1.6543 * (0.001 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MILLISECOND.toMilliseconds(1.6543), delta);
        msg = "22.45 * (0.001 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MILLISECOND.toMilliseconds(22.45), delta);
        msg = "9876.5432 * (0.001 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MILLISECOND.toMilliseconds(9876.5432), delta);
        msg = "1987654344.3345 * (0.001 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MILLISECOND.toMilliseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.001 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MILLISECOND.toMilliseconds(784.46789765434), delta);
        // ====================
        // ====================SECOND
        // ====================
        // to_factor = 1.0
        to_factor = SECOND.getFactor();
        msg = "-1 / (1 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLISECOND.toSeconds(-1.0), delta);
        msg = "-0.1 / (1 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLISECOND.toSeconds(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLISECOND.toSeconds(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLISECOND.toSeconds(-73.25), delta);
        msg = "-56229.321 / (1 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLISECOND.toSeconds(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLISECOND.toSeconds(-873.5432456), delta);
        msg = "0 / (1 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLISECOND.toSeconds(0.0), delta);
        msg = "0.1 / (1 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLISECOND.toSeconds(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLISECOND.toSeconds(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLISECOND.toSeconds(0.33), delta);
        msg = "0.6543 / (1 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLISECOND.toSeconds(0.6543), delta);
        msg = "1 / (1 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLISECOND.toSeconds(1.0), delta);
        msg = "1.6543 / (1 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLISECOND.toSeconds(1.6543), delta);
        msg = "22.45 / (1 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLISECOND.toSeconds(22.45), delta);
        msg = "9876.5432 / (1 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLISECOND.toSeconds(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLISECOND.toSeconds(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLISECOND.toSeconds(784.46789765434), delta);
        // ====================
        // ====================MINUTE
        // ====================
        // to_factor = 60.0
        to_factor = MINUTE.getFactor();
        msg = "-1 / (60 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLISECOND.toMinutes(-1.0), delta);
        msg = "-0.1 / (60 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLISECOND.toMinutes(-0.1), delta);
        msg = "-0.000456789 / (60 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLISECOND.toMinutes(-4.56789E-4), delta);
        msg = "-73.25 / (60 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLISECOND.toMinutes(-73.25), delta);
        msg = "-56229.321 / (60 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLISECOND.toMinutes(-56229.321), delta);
        msg = "-873.5432456 / (60 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLISECOND.toMinutes(-873.5432456), delta);
        msg = "0 / (60 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLISECOND.toMinutes(0.0), delta);
        msg = "0.1 / (60 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLISECOND.toMinutes(0.1), delta);
        msg = "0.0000876543297 / (60 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLISECOND.toMinutes(8.76543297E-5), delta);
        msg = "0.33 / (60 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLISECOND.toMinutes(0.33), delta);
        msg = "0.6543 / (60 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLISECOND.toMinutes(0.6543), delta);
        msg = "1 / (60 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLISECOND.toMinutes(1.0), delta);
        msg = "1.6543 / (60 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLISECOND.toMinutes(1.6543), delta);
        msg = "22.45 / (60 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLISECOND.toMinutes(22.45), delta);
        msg = "9876.5432 / (60 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLISECOND.toMinutes(9876.5432), delta);
        msg = "1987654344.3345 / (60 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLISECOND.toMinutes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (60 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLISECOND.toMinutes(784.46789765434), delta);
        // ====================
        // ====================HOUR
        // ====================
        // to_factor = 3600.0
        to_factor = HOUR.getFactor();
        msg = "-1 / (3600 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLISECOND.toHours(-1.0), delta);
        msg = "-0.1 / (3600 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLISECOND.toHours(-0.1), delta);
        msg = "-0.000456789 / (3600 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLISECOND.toHours(-4.56789E-4), delta);
        msg = "-73.25 / (3600 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLISECOND.toHours(-73.25), delta);
        msg = "-56229.321 / (3600 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLISECOND.toHours(-56229.321), delta);
        msg = "-873.5432456 / (3600 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLISECOND.toHours(-873.5432456), delta);
        msg = "0 / (3600 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLISECOND.toHours(0.0), delta);
        msg = "0.1 / (3600 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLISECOND.toHours(0.1), delta);
        msg = "0.0000876543297 / (3600 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLISECOND.toHours(8.76543297E-5), delta);
        msg = "0.33 / (3600 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLISECOND.toHours(0.33), delta);
        msg = "0.6543 / (3600 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLISECOND.toHours(0.6543), delta);
        msg = "1 / (3600 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLISECOND.toHours(1.0), delta);
        msg = "1.6543 / (3600 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLISECOND.toHours(1.6543), delta);
        msg = "22.45 / (3600 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLISECOND.toHours(22.45), delta);
        msg = "9876.5432 / (3600 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLISECOND.toHours(9876.5432), delta);
        msg = "1987654344.3345 / (3600 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLISECOND.toHours(1.9876543443345E9), delta);
        msg = "784.46789765434 / (3600 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLISECOND.toHours(784.46789765434), delta);
        // ====================
        // ====================DAY
        // ====================
        // to_factor = 86400.0
        to_factor = DAY.getFactor();
        msg = "-1 / (86400 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MILLISECOND.toDays(-1.0), delta);
        msg = "-0.1 / (86400 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MILLISECOND.toDays(-0.1), delta);
        msg = "-0.000456789 / (86400 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MILLISECOND.toDays(-4.56789E-4), delta);
        msg = "-73.25 / (86400 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MILLISECOND.toDays(-73.25), delta);
        msg = "-56229.321 / (86400 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MILLISECOND.toDays(-56229.321), delta);
        msg = "-873.5432456 / (86400 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MILLISECOND.toDays(-873.5432456), delta);
        msg = "0 / (86400 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MILLISECOND.toDays(0.0), delta);
        msg = "0.1 / (86400 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MILLISECOND.toDays(0.1), delta);
        msg = "0.0000876543297 / (86400 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MILLISECOND.toDays(8.76543297E-5), delta);
        msg = "0.33 / (86400 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MILLISECOND.toDays(0.33), delta);
        msg = "0.6543 / (86400 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MILLISECOND.toDays(0.6543), delta);
        msg = "1 / (86400 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MILLISECOND.toDays(1.0), delta);
        msg = "1.6543 / (86400 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MILLISECOND.toDays(1.6543), delta);
        msg = "22.45 / (86400 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MILLISECOND.toDays(22.45), delta);
        msg = "9876.5432 / (86400 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MILLISECOND.toDays(9876.5432), delta);
        msg = "1987654344.3345 / (86400 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MILLISECOND.toDays(1.9876543443345E9), delta);
        msg = "784.46789765434 / (86400 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MILLISECOND.toDays(784.46789765434), delta);
    }

    @Test()
    public void testSecond() {
        // from_factor = 1.0
        double from_factor = SECOND.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================NANOSECOND
        // ====================
        // to_factor = 9.999999999999999E-10
        to_factor = NANOSECOND.getFactor();
        msg = "-1 * (1 / 0.0000000009999999999999999)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SECOND.toNanoseconds(-1.0), delta);
        msg = "-0.1 * (1 / 0.0000000009999999999999999)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SECOND.toNanoseconds(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.0000000009999999999999999)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SECOND.toNanoseconds(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.0000000009999999999999999)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SECOND.toNanoseconds(-73.25), delta);
        msg = "-56229.321 * (1 / 0.0000000009999999999999999)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SECOND.toNanoseconds(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.0000000009999999999999999)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SECOND.toNanoseconds(-873.5432456), delta);
        msg = "0 * (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SECOND.toNanoseconds(0.0), delta);
        msg = "0.1 * (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SECOND.toNanoseconds(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SECOND.toNanoseconds(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SECOND.toNanoseconds(0.33), delta);
        msg = "0.6543 * (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SECOND.toNanoseconds(0.6543), delta);
        msg = "1 * (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SECOND.toNanoseconds(1.0), delta);
        msg = "1.6543 * (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SECOND.toNanoseconds(1.6543), delta);
        msg = "22.45 * (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SECOND.toNanoseconds(22.45), delta);
        msg = "9876.5432 * (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SECOND.toNanoseconds(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SECOND.toNanoseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.0000000009999999999999999)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SECOND.toNanoseconds(784.46789765434), delta);
        // ====================
        // ====================MICROSECOND
        // ====================
        // to_factor = 1.0E-6
        to_factor = MICROSECOND.getFactor();
        msg = "-1 * (1 / 0.000001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SECOND.toMicroseconds(-1.0), delta);
        msg = "-0.1 * (1 / 0.000001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SECOND.toMicroseconds(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.000001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SECOND.toMicroseconds(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.000001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SECOND.toMicroseconds(-73.25), delta);
        msg = "-56229.321 * (1 / 0.000001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SECOND.toMicroseconds(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.000001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SECOND.toMicroseconds(-873.5432456), delta);
        msg = "0 * (1 / 0.000001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SECOND.toMicroseconds(0.0), delta);
        msg = "0.1 * (1 / 0.000001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SECOND.toMicroseconds(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SECOND.toMicroseconds(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.000001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SECOND.toMicroseconds(0.33), delta);
        msg = "0.6543 * (1 / 0.000001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SECOND.toMicroseconds(0.6543), delta);
        msg = "1 * (1 / 0.000001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SECOND.toMicroseconds(1.0), delta);
        msg = "1.6543 * (1 / 0.000001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SECOND.toMicroseconds(1.6543), delta);
        msg = "22.45 * (1 / 0.000001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SECOND.toMicroseconds(22.45), delta);
        msg = "9876.5432 * (1 / 0.000001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SECOND.toMicroseconds(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SECOND.toMicroseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.000001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SECOND.toMicroseconds(784.46789765434), delta);
        // ====================
        // ====================MILLISECOND
        // ====================
        // to_factor = 0.001
        to_factor = MILLISECOND.getFactor();
        msg = "-1 * (1 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SECOND.toMilliseconds(-1.0), delta);
        msg = "-0.1 * (1 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SECOND.toMilliseconds(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SECOND.toMilliseconds(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SECOND.toMilliseconds(-73.25), delta);
        msg = "-56229.321 * (1 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SECOND.toMilliseconds(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SECOND.toMilliseconds(-873.5432456), delta);
        msg = "0 * (1 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SECOND.toMilliseconds(0.0), delta);
        msg = "0.1 * (1 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SECOND.toMilliseconds(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SECOND.toMilliseconds(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SECOND.toMilliseconds(0.33), delta);
        msg = "0.6543 * (1 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SECOND.toMilliseconds(0.6543), delta);
        msg = "1 * (1 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SECOND.toMilliseconds(1.0), delta);
        msg = "1.6543 * (1 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SECOND.toMilliseconds(1.6543), delta);
        msg = "22.45 * (1 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SECOND.toMilliseconds(22.45), delta);
        msg = "9876.5432 * (1 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SECOND.toMilliseconds(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SECOND.toMilliseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SECOND.toMilliseconds(784.46789765434), delta);
        // ====================
        // ====================SECOND
        // ====================
        // to_factor = 1.0
        to_factor = SECOND.getFactor();
        msg = "-1 * (1 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SECOND.toSeconds(-1.0), delta);
        msg = "-0.1 * (1 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SECOND.toSeconds(-0.1), delta);
        msg = "-0.000456789 * (1 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SECOND.toSeconds(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SECOND.toSeconds(-73.25), delta);
        msg = "-56229.321 * (1 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SECOND.toSeconds(-56229.321), delta);
        msg = "-873.5432456 * (1 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SECOND.toSeconds(-873.5432456), delta);
        msg = "0 * (1 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SECOND.toSeconds(0.0), delta);
        msg = "0.1 * (1 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SECOND.toSeconds(0.1), delta);
        msg = "0.0000876543297 * (1 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SECOND.toSeconds(8.76543297E-5), delta);
        msg = "0.33 * (1 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SECOND.toSeconds(0.33), delta);
        msg = "0.6543 * (1 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SECOND.toSeconds(0.6543), delta);
        msg = "1 * (1 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SECOND.toSeconds(1.0), delta);
        msg = "1.6543 * (1 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SECOND.toSeconds(1.6543), delta);
        msg = "22.45 * (1 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SECOND.toSeconds(22.45), delta);
        msg = "9876.5432 * (1 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SECOND.toSeconds(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SECOND.toSeconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SECOND.toSeconds(784.46789765434), delta);
        // ====================
        // ====================MINUTE
        // ====================
        // to_factor = 60.0
        to_factor = MINUTE.getFactor();
        msg = "-1 / (60 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SECOND.toMinutes(-1.0), delta);
        msg = "-0.1 / (60 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SECOND.toMinutes(-0.1), delta);
        msg = "-0.000456789 / (60 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SECOND.toMinutes(-4.56789E-4), delta);
        msg = "-73.25 / (60 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SECOND.toMinutes(-73.25), delta);
        msg = "-56229.321 / (60 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SECOND.toMinutes(-56229.321), delta);
        msg = "-873.5432456 / (60 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SECOND.toMinutes(-873.5432456), delta);
        msg = "0 / (60 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SECOND.toMinutes(0.0), delta);
        msg = "0.1 / (60 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SECOND.toMinutes(0.1), delta);
        msg = "0.0000876543297 / (60 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SECOND.toMinutes(8.76543297E-5), delta);
        msg = "0.33 / (60 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SECOND.toMinutes(0.33), delta);
        msg = "0.6543 / (60 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SECOND.toMinutes(0.6543), delta);
        msg = "1 / (60 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SECOND.toMinutes(1.0), delta);
        msg = "1.6543 / (60 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SECOND.toMinutes(1.6543), delta);
        msg = "22.45 / (60 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SECOND.toMinutes(22.45), delta);
        msg = "9876.5432 / (60 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SECOND.toMinutes(9876.5432), delta);
        msg = "1987654344.3345 / (60 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SECOND.toMinutes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (60 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SECOND.toMinutes(784.46789765434), delta);
        // ====================
        // ====================HOUR
        // ====================
        // to_factor = 3600.0
        to_factor = HOUR.getFactor();
        msg = "-1 / (3600 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SECOND.toHours(-1.0), delta);
        msg = "-0.1 / (3600 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SECOND.toHours(-0.1), delta);
        msg = "-0.000456789 / (3600 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SECOND.toHours(-4.56789E-4), delta);
        msg = "-73.25 / (3600 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SECOND.toHours(-73.25), delta);
        msg = "-56229.321 / (3600 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SECOND.toHours(-56229.321), delta);
        msg = "-873.5432456 / (3600 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SECOND.toHours(-873.5432456), delta);
        msg = "0 / (3600 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SECOND.toHours(0.0), delta);
        msg = "0.1 / (3600 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SECOND.toHours(0.1), delta);
        msg = "0.0000876543297 / (3600 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SECOND.toHours(8.76543297E-5), delta);
        msg = "0.33 / (3600 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SECOND.toHours(0.33), delta);
        msg = "0.6543 / (3600 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SECOND.toHours(0.6543), delta);
        msg = "1 / (3600 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SECOND.toHours(1.0), delta);
        msg = "1.6543 / (3600 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SECOND.toHours(1.6543), delta);
        msg = "22.45 / (3600 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SECOND.toHours(22.45), delta);
        msg = "9876.5432 / (3600 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SECOND.toHours(9876.5432), delta);
        msg = "1987654344.3345 / (3600 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SECOND.toHours(1.9876543443345E9), delta);
        msg = "784.46789765434 / (3600 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SECOND.toHours(784.46789765434), delta);
        // ====================
        // ====================DAY
        // ====================
        // to_factor = 86400.0
        to_factor = DAY.getFactor();
        msg = "-1 / (86400 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SECOND.toDays(-1.0), delta);
        msg = "-0.1 / (86400 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SECOND.toDays(-0.1), delta);
        msg = "-0.000456789 / (86400 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SECOND.toDays(-4.56789E-4), delta);
        msg = "-73.25 / (86400 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SECOND.toDays(-73.25), delta);
        msg = "-56229.321 / (86400 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SECOND.toDays(-56229.321), delta);
        msg = "-873.5432456 / (86400 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SECOND.toDays(-873.5432456), delta);
        msg = "0 / (86400 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SECOND.toDays(0.0), delta);
        msg = "0.1 / (86400 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SECOND.toDays(0.1), delta);
        msg = "0.0000876543297 / (86400 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SECOND.toDays(8.76543297E-5), delta);
        msg = "0.33 / (86400 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SECOND.toDays(0.33), delta);
        msg = "0.6543 / (86400 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SECOND.toDays(0.6543), delta);
        msg = "1 / (86400 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SECOND.toDays(1.0), delta);
        msg = "1.6543 / (86400 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SECOND.toDays(1.6543), delta);
        msg = "22.45 / (86400 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SECOND.toDays(22.45), delta);
        msg = "9876.5432 / (86400 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SECOND.toDays(9876.5432), delta);
        msg = "1987654344.3345 / (86400 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SECOND.toDays(1.9876543443345E9), delta);
        msg = "784.46789765434 / (86400 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SECOND.toDays(784.46789765434), delta);
    }

    @Test()
    public void testMinute() {
        // from_factor = 60.0
        double from_factor = MINUTE.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================NANOSECOND
        // ====================
        // to_factor = 9.999999999999999E-10
        to_factor = NANOSECOND.getFactor();
        msg = "-1 * (60 / 0.0000000009999999999999999)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MINUTE.toNanoseconds(-1.0), delta);
        msg = "-0.1 * (60 / 0.0000000009999999999999999)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MINUTE.toNanoseconds(-0.1), delta);
        msg = "-0.000456789 * (60 / 0.0000000009999999999999999)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MINUTE.toNanoseconds(-4.56789E-4), delta);
        msg = "-73.25 * (60 / 0.0000000009999999999999999)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MINUTE.toNanoseconds(-73.25), delta);
        msg = "-56229.321 * (60 / 0.0000000009999999999999999)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MINUTE.toNanoseconds(-56229.321), delta);
        msg = "-873.5432456 * (60 / 0.0000000009999999999999999)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MINUTE.toNanoseconds(-873.5432456), delta);
        msg = "0 * (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MINUTE.toNanoseconds(0.0), delta);
        msg = "0.1 * (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MINUTE.toNanoseconds(0.1), delta);
        msg = "0.0000876543297 * (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MINUTE.toNanoseconds(8.76543297E-5), delta);
        msg = "0.33 * (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MINUTE.toNanoseconds(0.33), delta);
        msg = "0.6543 * (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MINUTE.toNanoseconds(0.6543), delta);
        msg = "1 * (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MINUTE.toNanoseconds(1.0), delta);
        msg = "1.6543 * (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MINUTE.toNanoseconds(1.6543), delta);
        msg = "22.45 * (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MINUTE.toNanoseconds(22.45), delta);
        msg = "9876.5432 * (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MINUTE.toNanoseconds(9876.5432), delta);
        msg = "1987654344.3345 * (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MINUTE.toNanoseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (60 / 0.0000000009999999999999999)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MINUTE.toNanoseconds(784.46789765434), delta);
        // ====================
        // ====================MICROSECOND
        // ====================
        // to_factor = 1.0E-6
        to_factor = MICROSECOND.getFactor();
        msg = "-1 * (60 / 0.000001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MINUTE.toMicroseconds(-1.0), delta);
        msg = "-0.1 * (60 / 0.000001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MINUTE.toMicroseconds(-0.1), delta);
        msg = "-0.000456789 * (60 / 0.000001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MINUTE.toMicroseconds(-4.56789E-4), delta);
        msg = "-73.25 * (60 / 0.000001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MINUTE.toMicroseconds(-73.25), delta);
        msg = "-56229.321 * (60 / 0.000001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MINUTE.toMicroseconds(-56229.321), delta);
        msg = "-873.5432456 * (60 / 0.000001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MINUTE.toMicroseconds(-873.5432456), delta);
        msg = "0 * (60 / 0.000001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MINUTE.toMicroseconds(0.0), delta);
        msg = "0.1 * (60 / 0.000001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MINUTE.toMicroseconds(0.1), delta);
        msg = "0.0000876543297 * (60 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MINUTE.toMicroseconds(8.76543297E-5), delta);
        msg = "0.33 * (60 / 0.000001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MINUTE.toMicroseconds(0.33), delta);
        msg = "0.6543 * (60 / 0.000001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MINUTE.toMicroseconds(0.6543), delta);
        msg = "1 * (60 / 0.000001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MINUTE.toMicroseconds(1.0), delta);
        msg = "1.6543 * (60 / 0.000001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MINUTE.toMicroseconds(1.6543), delta);
        msg = "22.45 * (60 / 0.000001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MINUTE.toMicroseconds(22.45), delta);
        msg = "9876.5432 * (60 / 0.000001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MINUTE.toMicroseconds(9876.5432), delta);
        msg = "1987654344.3345 * (60 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MINUTE.toMicroseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (60 / 0.000001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MINUTE.toMicroseconds(784.46789765434), delta);
        // ====================
        // ====================MILLISECOND
        // ====================
        // to_factor = 0.001
        to_factor = MILLISECOND.getFactor();
        msg = "-1 * (60 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MINUTE.toMilliseconds(-1.0), delta);
        msg = "-0.1 * (60 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MINUTE.toMilliseconds(-0.1), delta);
        msg = "-0.000456789 * (60 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MINUTE.toMilliseconds(-4.56789E-4), delta);
        msg = "-73.25 * (60 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MINUTE.toMilliseconds(-73.25), delta);
        msg = "-56229.321 * (60 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MINUTE.toMilliseconds(-56229.321), delta);
        msg = "-873.5432456 * (60 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MINUTE.toMilliseconds(-873.5432456), delta);
        msg = "0 * (60 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MINUTE.toMilliseconds(0.0), delta);
        msg = "0.1 * (60 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MINUTE.toMilliseconds(0.1), delta);
        msg = "0.0000876543297 * (60 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MINUTE.toMilliseconds(8.76543297E-5), delta);
        msg = "0.33 * (60 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MINUTE.toMilliseconds(0.33), delta);
        msg = "0.6543 * (60 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MINUTE.toMilliseconds(0.6543), delta);
        msg = "1 * (60 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MINUTE.toMilliseconds(1.0), delta);
        msg = "1.6543 * (60 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MINUTE.toMilliseconds(1.6543), delta);
        msg = "22.45 * (60 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MINUTE.toMilliseconds(22.45), delta);
        msg = "9876.5432 * (60 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MINUTE.toMilliseconds(9876.5432), delta);
        msg = "1987654344.3345 * (60 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MINUTE.toMilliseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (60 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MINUTE.toMilliseconds(784.46789765434), delta);
        // ====================
        // ====================SECOND
        // ====================
        // to_factor = 1.0
        to_factor = SECOND.getFactor();
        msg = "-1 * (60 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MINUTE.toSeconds(-1.0), delta);
        msg = "-0.1 * (60 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MINUTE.toSeconds(-0.1), delta);
        msg = "-0.000456789 * (60 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MINUTE.toSeconds(-4.56789E-4), delta);
        msg = "-73.25 * (60 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MINUTE.toSeconds(-73.25), delta);
        msg = "-56229.321 * (60 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MINUTE.toSeconds(-56229.321), delta);
        msg = "-873.5432456 * (60 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MINUTE.toSeconds(-873.5432456), delta);
        msg = "0 * (60 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MINUTE.toSeconds(0.0), delta);
        msg = "0.1 * (60 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MINUTE.toSeconds(0.1), delta);
        msg = "0.0000876543297 * (60 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MINUTE.toSeconds(8.76543297E-5), delta);
        msg = "0.33 * (60 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MINUTE.toSeconds(0.33), delta);
        msg = "0.6543 * (60 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MINUTE.toSeconds(0.6543), delta);
        msg = "1 * (60 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MINUTE.toSeconds(1.0), delta);
        msg = "1.6543 * (60 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MINUTE.toSeconds(1.6543), delta);
        msg = "22.45 * (60 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MINUTE.toSeconds(22.45), delta);
        msg = "9876.5432 * (60 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MINUTE.toSeconds(9876.5432), delta);
        msg = "1987654344.3345 * (60 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MINUTE.toSeconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (60 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MINUTE.toSeconds(784.46789765434), delta);
        // ====================
        // ====================MINUTE
        // ====================
        // to_factor = 60.0
        to_factor = MINUTE.getFactor();
        msg = "-1 * (60 / 60)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MINUTE.toMinutes(-1.0), delta);
        msg = "-0.1 * (60 / 60)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MINUTE.toMinutes(-0.1), delta);
        msg = "-0.000456789 * (60 / 60)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MINUTE.toMinutes(-4.56789E-4), delta);
        msg = "-73.25 * (60 / 60)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MINUTE.toMinutes(-73.25), delta);
        msg = "-56229.321 * (60 / 60)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MINUTE.toMinutes(-56229.321), delta);
        msg = "-873.5432456 * (60 / 60)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MINUTE.toMinutes(-873.5432456), delta);
        msg = "0 * (60 / 60)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MINUTE.toMinutes(0.0), delta);
        msg = "0.1 * (60 / 60)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MINUTE.toMinutes(0.1), delta);
        msg = "0.0000876543297 * (60 / 60)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MINUTE.toMinutes(8.76543297E-5), delta);
        msg = "0.33 * (60 / 60)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MINUTE.toMinutes(0.33), delta);
        msg = "0.6543 * (60 / 60)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MINUTE.toMinutes(0.6543), delta);
        msg = "1 * (60 / 60)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MINUTE.toMinutes(1.0), delta);
        msg = "1.6543 * (60 / 60)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MINUTE.toMinutes(1.6543), delta);
        msg = "22.45 * (60 / 60)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MINUTE.toMinutes(22.45), delta);
        msg = "9876.5432 * (60 / 60)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MINUTE.toMinutes(9876.5432), delta);
        msg = "1987654344.3345 * (60 / 60)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MINUTE.toMinutes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (60 / 60)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MINUTE.toMinutes(784.46789765434), delta);
        // ====================
        // ====================HOUR
        // ====================
        // to_factor = 3600.0
        to_factor = HOUR.getFactor();
        msg = "-1 / (3600 / 60)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MINUTE.toHours(-1.0), delta);
        msg = "-0.1 / (3600 / 60)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MINUTE.toHours(-0.1), delta);
        msg = "-0.000456789 / (3600 / 60)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MINUTE.toHours(-4.56789E-4), delta);
        msg = "-73.25 / (3600 / 60)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MINUTE.toHours(-73.25), delta);
        msg = "-56229.321 / (3600 / 60)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MINUTE.toHours(-56229.321), delta);
        msg = "-873.5432456 / (3600 / 60)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MINUTE.toHours(-873.5432456), delta);
        msg = "0 / (3600 / 60)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MINUTE.toHours(0.0), delta);
        msg = "0.1 / (3600 / 60)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MINUTE.toHours(0.1), delta);
        msg = "0.0000876543297 / (3600 / 60)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MINUTE.toHours(8.76543297E-5), delta);
        msg = "0.33 / (3600 / 60)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MINUTE.toHours(0.33), delta);
        msg = "0.6543 / (3600 / 60)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MINUTE.toHours(0.6543), delta);
        msg = "1 / (3600 / 60)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MINUTE.toHours(1.0), delta);
        msg = "1.6543 / (3600 / 60)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MINUTE.toHours(1.6543), delta);
        msg = "22.45 / (3600 / 60)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MINUTE.toHours(22.45), delta);
        msg = "9876.5432 / (3600 / 60)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MINUTE.toHours(9876.5432), delta);
        msg = "1987654344.3345 / (3600 / 60)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MINUTE.toHours(1.9876543443345E9), delta);
        msg = "784.46789765434 / (3600 / 60)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MINUTE.toHours(784.46789765434), delta);
        // ====================
        // ====================DAY
        // ====================
        // to_factor = 86400.0
        to_factor = DAY.getFactor();
        msg = "-1 / (86400 / 60)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MINUTE.toDays(-1.0), delta);
        msg = "-0.1 / (86400 / 60)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MINUTE.toDays(-0.1), delta);
        msg = "-0.000456789 / (86400 / 60)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MINUTE.toDays(-4.56789E-4), delta);
        msg = "-73.25 / (86400 / 60)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MINUTE.toDays(-73.25), delta);
        msg = "-56229.321 / (86400 / 60)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MINUTE.toDays(-56229.321), delta);
        msg = "-873.5432456 / (86400 / 60)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MINUTE.toDays(-873.5432456), delta);
        msg = "0 / (86400 / 60)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MINUTE.toDays(0.0), delta);
        msg = "0.1 / (86400 / 60)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MINUTE.toDays(0.1), delta);
        msg = "0.0000876543297 / (86400 / 60)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MINUTE.toDays(8.76543297E-5), delta);
        msg = "0.33 / (86400 / 60)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MINUTE.toDays(0.33), delta);
        msg = "0.6543 / (86400 / 60)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MINUTE.toDays(0.6543), delta);
        msg = "1 / (86400 / 60)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MINUTE.toDays(1.0), delta);
        msg = "1.6543 / (86400 / 60)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MINUTE.toDays(1.6543), delta);
        msg = "22.45 / (86400 / 60)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MINUTE.toDays(22.45), delta);
        msg = "9876.5432 / (86400 / 60)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MINUTE.toDays(9876.5432), delta);
        msg = "1987654344.3345 / (86400 / 60)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MINUTE.toDays(1.9876543443345E9), delta);
        msg = "784.46789765434 / (86400 / 60)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MINUTE.toDays(784.46789765434), delta);
    }

    @Test()
    public void testHour() {
        // from_factor = 3600.0
        double from_factor = HOUR.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================NANOSECOND
        // ====================
        // to_factor = 9.999999999999999E-10
        to_factor = NANOSECOND.getFactor();
        msg = "-1 * (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HOUR.toNanoseconds(-1.0), delta);
        msg = "-0.1 * (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HOUR.toNanoseconds(-0.1), delta);
        msg = "-0.000456789 * (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HOUR.toNanoseconds(-4.56789E-4), delta);
        msg = "-73.25 * (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HOUR.toNanoseconds(-73.25), delta);
        msg = "-56229.321 * (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HOUR.toNanoseconds(-56229.321), delta);
        msg = "-873.5432456 * (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HOUR.toNanoseconds(-873.5432456), delta);
        msg = "0 * (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HOUR.toNanoseconds(0.0), delta);
        msg = "0.1 * (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HOUR.toNanoseconds(0.1), delta);
        msg = "0.0000876543297 * (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HOUR.toNanoseconds(8.76543297E-5), delta);
        msg = "0.33 * (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HOUR.toNanoseconds(0.33), delta);
        msg = "0.6543 * (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HOUR.toNanoseconds(0.6543), delta);
        msg = "1 * (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HOUR.toNanoseconds(1.0), delta);
        msg = "1.6543 * (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HOUR.toNanoseconds(1.6543), delta);
        msg = "22.45 * (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HOUR.toNanoseconds(22.45), delta);
        msg = "9876.5432 * (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HOUR.toNanoseconds(9876.5432), delta);
        msg = "1987654344.3345 * (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HOUR.toNanoseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3600 / 0.0000000009999999999999999)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HOUR.toNanoseconds(784.46789765434), delta);
        // ====================
        // ====================MICROSECOND
        // ====================
        // to_factor = 1.0E-6
        to_factor = MICROSECOND.getFactor();
        msg = "-1 * (3600 / 0.000001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HOUR.toMicroseconds(-1.0), delta);
        msg = "-0.1 * (3600 / 0.000001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HOUR.toMicroseconds(-0.1), delta);
        msg = "-0.000456789 * (3600 / 0.000001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HOUR.toMicroseconds(-4.56789E-4), delta);
        msg = "-73.25 * (3600 / 0.000001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HOUR.toMicroseconds(-73.25), delta);
        msg = "-56229.321 * (3600 / 0.000001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HOUR.toMicroseconds(-56229.321), delta);
        msg = "-873.5432456 * (3600 / 0.000001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HOUR.toMicroseconds(-873.5432456), delta);
        msg = "0 * (3600 / 0.000001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HOUR.toMicroseconds(0.0), delta);
        msg = "0.1 * (3600 / 0.000001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HOUR.toMicroseconds(0.1), delta);
        msg = "0.0000876543297 * (3600 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HOUR.toMicroseconds(8.76543297E-5), delta);
        msg = "0.33 * (3600 / 0.000001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HOUR.toMicroseconds(0.33), delta);
        msg = "0.6543 * (3600 / 0.000001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HOUR.toMicroseconds(0.6543), delta);
        msg = "1 * (3600 / 0.000001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HOUR.toMicroseconds(1.0), delta);
        msg = "1.6543 * (3600 / 0.000001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HOUR.toMicroseconds(1.6543), delta);
        msg = "22.45 * (3600 / 0.000001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HOUR.toMicroseconds(22.45), delta);
        msg = "9876.5432 * (3600 / 0.000001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HOUR.toMicroseconds(9876.5432), delta);
        msg = "1987654344.3345 * (3600 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HOUR.toMicroseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3600 / 0.000001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HOUR.toMicroseconds(784.46789765434), delta);
        // ====================
        // ====================MILLISECOND
        // ====================
        // to_factor = 0.001
        to_factor = MILLISECOND.getFactor();
        msg = "-1 * (3600 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HOUR.toMilliseconds(-1.0), delta);
        msg = "-0.1 * (3600 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HOUR.toMilliseconds(-0.1), delta);
        msg = "-0.000456789 * (3600 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HOUR.toMilliseconds(-4.56789E-4), delta);
        msg = "-73.25 * (3600 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HOUR.toMilliseconds(-73.25), delta);
        msg = "-56229.321 * (3600 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HOUR.toMilliseconds(-56229.321), delta);
        msg = "-873.5432456 * (3600 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HOUR.toMilliseconds(-873.5432456), delta);
        msg = "0 * (3600 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HOUR.toMilliseconds(0.0), delta);
        msg = "0.1 * (3600 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HOUR.toMilliseconds(0.1), delta);
        msg = "0.0000876543297 * (3600 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HOUR.toMilliseconds(8.76543297E-5), delta);
        msg = "0.33 * (3600 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HOUR.toMilliseconds(0.33), delta);
        msg = "0.6543 * (3600 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HOUR.toMilliseconds(0.6543), delta);
        msg = "1 * (3600 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HOUR.toMilliseconds(1.0), delta);
        msg = "1.6543 * (3600 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HOUR.toMilliseconds(1.6543), delta);
        msg = "22.45 * (3600 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HOUR.toMilliseconds(22.45), delta);
        msg = "9876.5432 * (3600 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HOUR.toMilliseconds(9876.5432), delta);
        msg = "1987654344.3345 * (3600 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HOUR.toMilliseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3600 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HOUR.toMilliseconds(784.46789765434), delta);
        // ====================
        // ====================SECOND
        // ====================
        // to_factor = 1.0
        to_factor = SECOND.getFactor();
        msg = "-1 * (3600 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HOUR.toSeconds(-1.0), delta);
        msg = "-0.1 * (3600 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HOUR.toSeconds(-0.1), delta);
        msg = "-0.000456789 * (3600 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HOUR.toSeconds(-4.56789E-4), delta);
        msg = "-73.25 * (3600 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HOUR.toSeconds(-73.25), delta);
        msg = "-56229.321 * (3600 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HOUR.toSeconds(-56229.321), delta);
        msg = "-873.5432456 * (3600 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HOUR.toSeconds(-873.5432456), delta);
        msg = "0 * (3600 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HOUR.toSeconds(0.0), delta);
        msg = "0.1 * (3600 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HOUR.toSeconds(0.1), delta);
        msg = "0.0000876543297 * (3600 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HOUR.toSeconds(8.76543297E-5), delta);
        msg = "0.33 * (3600 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HOUR.toSeconds(0.33), delta);
        msg = "0.6543 * (3600 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HOUR.toSeconds(0.6543), delta);
        msg = "1 * (3600 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HOUR.toSeconds(1.0), delta);
        msg = "1.6543 * (3600 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HOUR.toSeconds(1.6543), delta);
        msg = "22.45 * (3600 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HOUR.toSeconds(22.45), delta);
        msg = "9876.5432 * (3600 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HOUR.toSeconds(9876.5432), delta);
        msg = "1987654344.3345 * (3600 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HOUR.toSeconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3600 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HOUR.toSeconds(784.46789765434), delta);
        // ====================
        // ====================MINUTE
        // ====================
        // to_factor = 60.0
        to_factor = MINUTE.getFactor();
        msg = "-1 * (3600 / 60)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HOUR.toMinutes(-1.0), delta);
        msg = "-0.1 * (3600 / 60)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HOUR.toMinutes(-0.1), delta);
        msg = "-0.000456789 * (3600 / 60)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HOUR.toMinutes(-4.56789E-4), delta);
        msg = "-73.25 * (3600 / 60)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HOUR.toMinutes(-73.25), delta);
        msg = "-56229.321 * (3600 / 60)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HOUR.toMinutes(-56229.321), delta);
        msg = "-873.5432456 * (3600 / 60)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HOUR.toMinutes(-873.5432456), delta);
        msg = "0 * (3600 / 60)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HOUR.toMinutes(0.0), delta);
        msg = "0.1 * (3600 / 60)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HOUR.toMinutes(0.1), delta);
        msg = "0.0000876543297 * (3600 / 60)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HOUR.toMinutes(8.76543297E-5), delta);
        msg = "0.33 * (3600 / 60)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HOUR.toMinutes(0.33), delta);
        msg = "0.6543 * (3600 / 60)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HOUR.toMinutes(0.6543), delta);
        msg = "1 * (3600 / 60)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HOUR.toMinutes(1.0), delta);
        msg = "1.6543 * (3600 / 60)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HOUR.toMinutes(1.6543), delta);
        msg = "22.45 * (3600 / 60)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HOUR.toMinutes(22.45), delta);
        msg = "9876.5432 * (3600 / 60)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HOUR.toMinutes(9876.5432), delta);
        msg = "1987654344.3345 * (3600 / 60)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HOUR.toMinutes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3600 / 60)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HOUR.toMinutes(784.46789765434), delta);
        // ====================
        // ====================HOUR
        // ====================
        // to_factor = 3600.0
        to_factor = HOUR.getFactor();
        msg = "-1 * (3600 / 3600)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HOUR.toHours(-1.0), delta);
        msg = "-0.1 * (3600 / 3600)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HOUR.toHours(-0.1), delta);
        msg = "-0.000456789 * (3600 / 3600)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HOUR.toHours(-4.56789E-4), delta);
        msg = "-73.25 * (3600 / 3600)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HOUR.toHours(-73.25), delta);
        msg = "-56229.321 * (3600 / 3600)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HOUR.toHours(-56229.321), delta);
        msg = "-873.5432456 * (3600 / 3600)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HOUR.toHours(-873.5432456), delta);
        msg = "0 * (3600 / 3600)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HOUR.toHours(0.0), delta);
        msg = "0.1 * (3600 / 3600)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HOUR.toHours(0.1), delta);
        msg = "0.0000876543297 * (3600 / 3600)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HOUR.toHours(8.76543297E-5), delta);
        msg = "0.33 * (3600 / 3600)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HOUR.toHours(0.33), delta);
        msg = "0.6543 * (3600 / 3600)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HOUR.toHours(0.6543), delta);
        msg = "1 * (3600 / 3600)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HOUR.toHours(1.0), delta);
        msg = "1.6543 * (3600 / 3600)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HOUR.toHours(1.6543), delta);
        msg = "22.45 * (3600 / 3600)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HOUR.toHours(22.45), delta);
        msg = "9876.5432 * (3600 / 3600)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HOUR.toHours(9876.5432), delta);
        msg = "1987654344.3345 * (3600 / 3600)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HOUR.toHours(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3600 / 3600)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HOUR.toHours(784.46789765434), delta);
        // ====================
        // ====================DAY
        // ====================
        // to_factor = 86400.0
        to_factor = DAY.getFactor();
        msg = "-1 / (86400 / 3600)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), HOUR.toDays(-1.0), delta);
        msg = "-0.1 / (86400 / 3600)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), HOUR.toDays(-0.1), delta);
        msg = "-0.000456789 / (86400 / 3600)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), HOUR.toDays(-4.56789E-4), delta);
        msg = "-73.25 / (86400 / 3600)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), HOUR.toDays(-73.25), delta);
        msg = "-56229.321 / (86400 / 3600)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), HOUR.toDays(-56229.321), delta);
        msg = "-873.5432456 / (86400 / 3600)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), HOUR.toDays(-873.5432456), delta);
        msg = "0 / (86400 / 3600)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), HOUR.toDays(0.0), delta);
        msg = "0.1 / (86400 / 3600)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), HOUR.toDays(0.1), delta);
        msg = "0.0000876543297 / (86400 / 3600)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), HOUR.toDays(8.76543297E-5), delta);
        msg = "0.33 / (86400 / 3600)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), HOUR.toDays(0.33), delta);
        msg = "0.6543 / (86400 / 3600)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), HOUR.toDays(0.6543), delta);
        msg = "1 / (86400 / 3600)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), HOUR.toDays(1.0), delta);
        msg = "1.6543 / (86400 / 3600)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), HOUR.toDays(1.6543), delta);
        msg = "22.45 / (86400 / 3600)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), HOUR.toDays(22.45), delta);
        msg = "9876.5432 / (86400 / 3600)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), HOUR.toDays(9876.5432), delta);
        msg = "1987654344.3345 / (86400 / 3600)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), HOUR.toDays(1.9876543443345E9), delta);
        msg = "784.46789765434 / (86400 / 3600)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), HOUR.toDays(784.46789765434), delta);
    }

    @Test()
    public void testDay() {
        // from_factor = 86400.0
        double from_factor = DAY.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================NANOSECOND
        // ====================
        // to_factor = 9.999999999999999E-10
        to_factor = NANOSECOND.getFactor();
        msg = "-1 * (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DAY.toNanoseconds(-1.0), delta);
        msg = "-0.1 * (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DAY.toNanoseconds(-0.1), delta);
        msg = "-0.000456789 * (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DAY.toNanoseconds(-4.56789E-4), delta);
        msg = "-73.25 * (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DAY.toNanoseconds(-73.25), delta);
        msg = "-56229.321 * (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DAY.toNanoseconds(-56229.321), delta);
        msg = "-873.5432456 * (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DAY.toNanoseconds(-873.5432456), delta);
        msg = "0 * (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DAY.toNanoseconds(0.0), delta);
        msg = "0.1 * (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DAY.toNanoseconds(0.1), delta);
        msg = "0.0000876543297 * (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DAY.toNanoseconds(8.76543297E-5), delta);
        msg = "0.33 * (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DAY.toNanoseconds(0.33), delta);
        msg = "0.6543 * (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DAY.toNanoseconds(0.6543), delta);
        msg = "1 * (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DAY.toNanoseconds(1.0), delta);
        msg = "1.6543 * (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DAY.toNanoseconds(1.6543), delta);
        msg = "22.45 * (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DAY.toNanoseconds(22.45), delta);
        msg = "9876.5432 * (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DAY.toNanoseconds(9876.5432), delta);
        msg = "1987654344.3345 * (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DAY.toNanoseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (86400 / 0.0000000009999999999999999)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DAY.toNanoseconds(784.46789765434), delta);
        // ====================
        // ====================MICROSECOND
        // ====================
        // to_factor = 1.0E-6
        to_factor = MICROSECOND.getFactor();
        msg = "-1 * (86400 / 0.000001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DAY.toMicroseconds(-1.0), delta);
        msg = "-0.1 * (86400 / 0.000001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DAY.toMicroseconds(-0.1), delta);
        msg = "-0.000456789 * (86400 / 0.000001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DAY.toMicroseconds(-4.56789E-4), delta);
        msg = "-73.25 * (86400 / 0.000001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DAY.toMicroseconds(-73.25), delta);
        msg = "-56229.321 * (86400 / 0.000001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DAY.toMicroseconds(-56229.321), delta);
        msg = "-873.5432456 * (86400 / 0.000001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DAY.toMicroseconds(-873.5432456), delta);
        msg = "0 * (86400 / 0.000001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DAY.toMicroseconds(0.0), delta);
        msg = "0.1 * (86400 / 0.000001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DAY.toMicroseconds(0.1), delta);
        msg = "0.0000876543297 * (86400 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DAY.toMicroseconds(8.76543297E-5), delta);
        msg = "0.33 * (86400 / 0.000001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DAY.toMicroseconds(0.33), delta);
        msg = "0.6543 * (86400 / 0.000001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DAY.toMicroseconds(0.6543), delta);
        msg = "1 * (86400 / 0.000001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DAY.toMicroseconds(1.0), delta);
        msg = "1.6543 * (86400 / 0.000001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DAY.toMicroseconds(1.6543), delta);
        msg = "22.45 * (86400 / 0.000001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DAY.toMicroseconds(22.45), delta);
        msg = "9876.5432 * (86400 / 0.000001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DAY.toMicroseconds(9876.5432), delta);
        msg = "1987654344.3345 * (86400 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DAY.toMicroseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (86400 / 0.000001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DAY.toMicroseconds(784.46789765434), delta);
        // ====================
        // ====================MILLISECOND
        // ====================
        // to_factor = 0.001
        to_factor = MILLISECOND.getFactor();
        msg = "-1 * (86400 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DAY.toMilliseconds(-1.0), delta);
        msg = "-0.1 * (86400 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DAY.toMilliseconds(-0.1), delta);
        msg = "-0.000456789 * (86400 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DAY.toMilliseconds(-4.56789E-4), delta);
        msg = "-73.25 * (86400 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DAY.toMilliseconds(-73.25), delta);
        msg = "-56229.321 * (86400 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DAY.toMilliseconds(-56229.321), delta);
        msg = "-873.5432456 * (86400 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DAY.toMilliseconds(-873.5432456), delta);
        msg = "0 * (86400 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DAY.toMilliseconds(0.0), delta);
        msg = "0.1 * (86400 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DAY.toMilliseconds(0.1), delta);
        msg = "0.0000876543297 * (86400 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DAY.toMilliseconds(8.76543297E-5), delta);
        msg = "0.33 * (86400 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DAY.toMilliseconds(0.33), delta);
        msg = "0.6543 * (86400 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DAY.toMilliseconds(0.6543), delta);
        msg = "1 * (86400 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DAY.toMilliseconds(1.0), delta);
        msg = "1.6543 * (86400 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DAY.toMilliseconds(1.6543), delta);
        msg = "22.45 * (86400 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DAY.toMilliseconds(22.45), delta);
        msg = "9876.5432 * (86400 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DAY.toMilliseconds(9876.5432), delta);
        msg = "1987654344.3345 * (86400 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DAY.toMilliseconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (86400 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DAY.toMilliseconds(784.46789765434), delta);
        // ====================
        // ====================SECOND
        // ====================
        // to_factor = 1.0
        to_factor = SECOND.getFactor();
        msg = "-1 * (86400 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DAY.toSeconds(-1.0), delta);
        msg = "-0.1 * (86400 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DAY.toSeconds(-0.1), delta);
        msg = "-0.000456789 * (86400 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DAY.toSeconds(-4.56789E-4), delta);
        msg = "-73.25 * (86400 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DAY.toSeconds(-73.25), delta);
        msg = "-56229.321 * (86400 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DAY.toSeconds(-56229.321), delta);
        msg = "-873.5432456 * (86400 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DAY.toSeconds(-873.5432456), delta);
        msg = "0 * (86400 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DAY.toSeconds(0.0), delta);
        msg = "0.1 * (86400 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DAY.toSeconds(0.1), delta);
        msg = "0.0000876543297 * (86400 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DAY.toSeconds(8.76543297E-5), delta);
        msg = "0.33 * (86400 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DAY.toSeconds(0.33), delta);
        msg = "0.6543 * (86400 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DAY.toSeconds(0.6543), delta);
        msg = "1 * (86400 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DAY.toSeconds(1.0), delta);
        msg = "1.6543 * (86400 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DAY.toSeconds(1.6543), delta);
        msg = "22.45 * (86400 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DAY.toSeconds(22.45), delta);
        msg = "9876.5432 * (86400 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DAY.toSeconds(9876.5432), delta);
        msg = "1987654344.3345 * (86400 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DAY.toSeconds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (86400 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DAY.toSeconds(784.46789765434), delta);
        // ====================
        // ====================MINUTE
        // ====================
        // to_factor = 60.0
        to_factor = MINUTE.getFactor();
        msg = "-1 * (86400 / 60)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DAY.toMinutes(-1.0), delta);
        msg = "-0.1 * (86400 / 60)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DAY.toMinutes(-0.1), delta);
        msg = "-0.000456789 * (86400 / 60)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DAY.toMinutes(-4.56789E-4), delta);
        msg = "-73.25 * (86400 / 60)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DAY.toMinutes(-73.25), delta);
        msg = "-56229.321 * (86400 / 60)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DAY.toMinutes(-56229.321), delta);
        msg = "-873.5432456 * (86400 / 60)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DAY.toMinutes(-873.5432456), delta);
        msg = "0 * (86400 / 60)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DAY.toMinutes(0.0), delta);
        msg = "0.1 * (86400 / 60)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DAY.toMinutes(0.1), delta);
        msg = "0.0000876543297 * (86400 / 60)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DAY.toMinutes(8.76543297E-5), delta);
        msg = "0.33 * (86400 / 60)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DAY.toMinutes(0.33), delta);
        msg = "0.6543 * (86400 / 60)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DAY.toMinutes(0.6543), delta);
        msg = "1 * (86400 / 60)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DAY.toMinutes(1.0), delta);
        msg = "1.6543 * (86400 / 60)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DAY.toMinutes(1.6543), delta);
        msg = "22.45 * (86400 / 60)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DAY.toMinutes(22.45), delta);
        msg = "9876.5432 * (86400 / 60)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DAY.toMinutes(9876.5432), delta);
        msg = "1987654344.3345 * (86400 / 60)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DAY.toMinutes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (86400 / 60)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DAY.toMinutes(784.46789765434), delta);
        // ====================
        // ====================HOUR
        // ====================
        // to_factor = 3600.0
        to_factor = HOUR.getFactor();
        msg = "-1 * (86400 / 3600)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DAY.toHours(-1.0), delta);
        msg = "-0.1 * (86400 / 3600)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DAY.toHours(-0.1), delta);
        msg = "-0.000456789 * (86400 / 3600)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DAY.toHours(-4.56789E-4), delta);
        msg = "-73.25 * (86400 / 3600)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DAY.toHours(-73.25), delta);
        msg = "-56229.321 * (86400 / 3600)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DAY.toHours(-56229.321), delta);
        msg = "-873.5432456 * (86400 / 3600)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DAY.toHours(-873.5432456), delta);
        msg = "0 * (86400 / 3600)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DAY.toHours(0.0), delta);
        msg = "0.1 * (86400 / 3600)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DAY.toHours(0.1), delta);
        msg = "0.0000876543297 * (86400 / 3600)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DAY.toHours(8.76543297E-5), delta);
        msg = "0.33 * (86400 / 3600)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DAY.toHours(0.33), delta);
        msg = "0.6543 * (86400 / 3600)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DAY.toHours(0.6543), delta);
        msg = "1 * (86400 / 3600)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DAY.toHours(1.0), delta);
        msg = "1.6543 * (86400 / 3600)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DAY.toHours(1.6543), delta);
        msg = "22.45 * (86400 / 3600)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DAY.toHours(22.45), delta);
        msg = "9876.5432 * (86400 / 3600)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DAY.toHours(9876.5432), delta);
        msg = "1987654344.3345 * (86400 / 3600)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DAY.toHours(1.9876543443345E9), delta);
        msg = "784.46789765434 * (86400 / 3600)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DAY.toHours(784.46789765434), delta);
        // ====================
        // ====================DAY
        // ====================
        // to_factor = 86400.0
        to_factor = DAY.getFactor();
        msg = "-1 * (86400 / 86400)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DAY.toDays(-1.0), delta);
        msg = "-0.1 * (86400 / 86400)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DAY.toDays(-0.1), delta);
        msg = "-0.000456789 * (86400 / 86400)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DAY.toDays(-4.56789E-4), delta);
        msg = "-73.25 * (86400 / 86400)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DAY.toDays(-73.25), delta);
        msg = "-56229.321 * (86400 / 86400)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DAY.toDays(-56229.321), delta);
        msg = "-873.5432456 * (86400 / 86400)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DAY.toDays(-873.5432456), delta);
        msg = "0 * (86400 / 86400)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DAY.toDays(0.0), delta);
        msg = "0.1 * (86400 / 86400)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DAY.toDays(0.1), delta);
        msg = "0.0000876543297 * (86400 / 86400)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DAY.toDays(8.76543297E-5), delta);
        msg = "0.33 * (86400 / 86400)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DAY.toDays(0.33), delta);
        msg = "0.6543 * (86400 / 86400)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DAY.toDays(0.6543), delta);
        msg = "1 * (86400 / 86400)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DAY.toDays(1.0), delta);
        msg = "1.6543 * (86400 / 86400)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DAY.toDays(1.6543), delta);
        msg = "22.45 * (86400 / 86400)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DAY.toDays(22.45), delta);
        msg = "9876.5432 * (86400 / 86400)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DAY.toDays(9876.5432), delta);
        msg = "1987654344.3345 * (86400 / 86400)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DAY.toDays(1.9876543443345E9), delta);
        msg = "784.46789765434 * (86400 / 86400)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DAY.toDays(784.46789765434), delta);
    }
}
