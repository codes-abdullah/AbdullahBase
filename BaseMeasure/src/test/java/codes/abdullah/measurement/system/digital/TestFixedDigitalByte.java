package codes.abdullah.measurement.system.digital;

import static codes.abdullah.measurement.system.digital.Digitals.BYTE;
import static codes.abdullah.measurement.system.digital.Digitals.GIGABYTE;
import static codes.abdullah.measurement.system.digital.Digitals.KILOBYTE;
import static codes.abdullah.measurement.system.digital.Digitals.MEGABYTE;
import static codes.abdullah.measurement.system.digital.Digitals.PETABYTE;
import static codes.abdullah.measurement.system.digital.Digitals.TERABYTE;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFixedDigitalByte {

    @Test()
    public void testByte() {
        // from_factor = 1.0E-6
        double from_factor = BYTE.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================BYTE
        // ====================
        // to_factor = 1.0E-6
        to_factor = BYTE.getFactor();
        msg = "-1 * (0.000001 / 0.000001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), BYTE.toBytes(-1.0), delta);
        msg = "-0.1 * (0.000001 / 0.000001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), BYTE.toBytes(-0.1), delta);
        msg = "-0.000456789 * (0.000001 / 0.000001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), BYTE.toBytes(-4.56789E-4), delta);
        msg = "-73.25 * (0.000001 / 0.000001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), BYTE.toBytes(-73.25), delta);
        msg = "-56229.321 * (0.000001 / 0.000001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), BYTE.toBytes(-56229.321), delta);
        msg = "-873.5432456 * (0.000001 / 0.000001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), BYTE.toBytes(-873.5432456), delta);
        msg = "0 * (0.000001 / 0.000001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), BYTE.toBytes(0.0), delta);
        msg = "0.1 * (0.000001 / 0.000001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), BYTE.toBytes(0.1), delta);
        msg = "0.0000876543297 * (0.000001 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), BYTE.toBytes(8.76543297E-5), delta);
        msg = "0.33 * (0.000001 / 0.000001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), BYTE.toBytes(0.33), delta);
        msg = "0.6543 * (0.000001 / 0.000001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), BYTE.toBytes(0.6543), delta);
        msg = "1 * (0.000001 / 0.000001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), BYTE.toBytes(1.0), delta);
        msg = "1.6543 * (0.000001 / 0.000001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), BYTE.toBytes(1.6543), delta);
        msg = "22.45 * (0.000001 / 0.000001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), BYTE.toBytes(22.45), delta);
        msg = "9876.5432 * (0.000001 / 0.000001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), BYTE.toBytes(9876.5432), delta);
        msg = "1987654344.3345 * (0.000001 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), BYTE.toBytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.000001 / 0.000001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), BYTE.toBytes(784.46789765434), delta);
        // ====================
        // ====================KILOBYTE
        // ====================
        // to_factor = 0.001
        to_factor = KILOBYTE.getFactor();
        msg = "-1 / (0.001 / 0.000001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), BYTE.toKilobytes(-1.0), delta);
        msg = "-0.1 / (0.001 / 0.000001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), BYTE.toKilobytes(-0.1), delta);
        msg = "-0.000456789 / (0.001 / 0.000001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), BYTE.toKilobytes(-4.56789E-4), delta);
        msg = "-73.25 / (0.001 / 0.000001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), BYTE.toKilobytes(-73.25), delta);
        msg = "-56229.321 / (0.001 / 0.000001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), BYTE.toKilobytes(-56229.321), delta);
        msg = "-873.5432456 / (0.001 / 0.000001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), BYTE.toKilobytes(-873.5432456), delta);
        msg = "0 / (0.001 / 0.000001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), BYTE.toKilobytes(0.0), delta);
        msg = "0.1 / (0.001 / 0.000001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), BYTE.toKilobytes(0.1), delta);
        msg = "0.0000876543297 / (0.001 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), BYTE.toKilobytes(8.76543297E-5), delta);
        msg = "0.33 / (0.001 / 0.000001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), BYTE.toKilobytes(0.33), delta);
        msg = "0.6543 / (0.001 / 0.000001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), BYTE.toKilobytes(0.6543), delta);
        msg = "1 / (0.001 / 0.000001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), BYTE.toKilobytes(1.0), delta);
        msg = "1.6543 / (0.001 / 0.000001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), BYTE.toKilobytes(1.6543), delta);
        msg = "22.45 / (0.001 / 0.000001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), BYTE.toKilobytes(22.45), delta);
        msg = "9876.5432 / (0.001 / 0.000001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), BYTE.toKilobytes(9876.5432), delta);
        msg = "1987654344.3345 / (0.001 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), BYTE.toKilobytes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.001 / 0.000001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), BYTE.toKilobytes(784.46789765434), delta);
        // ====================
        // ====================MEGABYTE
        // ====================
        // to_factor = 1.0
        to_factor = MEGABYTE.getFactor();
        msg = "-1 / (1 / 0.000001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), BYTE.toMegabytes(-1.0), delta);
        msg = "-0.1 / (1 / 0.000001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), BYTE.toMegabytes(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.000001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), BYTE.toMegabytes(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.000001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), BYTE.toMegabytes(-73.25), delta);
        msg = "-56229.321 / (1 / 0.000001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), BYTE.toMegabytes(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.000001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), BYTE.toMegabytes(-873.5432456), delta);
        msg = "0 / (1 / 0.000001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), BYTE.toMegabytes(0.0), delta);
        msg = "0.1 / (1 / 0.000001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), BYTE.toMegabytes(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), BYTE.toMegabytes(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.000001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), BYTE.toMegabytes(0.33), delta);
        msg = "0.6543 / (1 / 0.000001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), BYTE.toMegabytes(0.6543), delta);
        msg = "1 / (1 / 0.000001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), BYTE.toMegabytes(1.0), delta);
        msg = "1.6543 / (1 / 0.000001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), BYTE.toMegabytes(1.6543), delta);
        msg = "22.45 / (1 / 0.000001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), BYTE.toMegabytes(22.45), delta);
        msg = "9876.5432 / (1 / 0.000001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), BYTE.toMegabytes(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), BYTE.toMegabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.000001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), BYTE.toMegabytes(784.46789765434), delta);
        // ====================
        // ====================GIGABYTE
        // ====================
        // to_factor = 1000.0
        to_factor = GIGABYTE.getFactor();
        msg = "-1 / (1000 / 0.000001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), BYTE.toGigabytes(-1.0), delta);
        msg = "-0.1 / (1000 / 0.000001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), BYTE.toGigabytes(-0.1), delta);
        msg = "-0.000456789 / (1000 / 0.000001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), BYTE.toGigabytes(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 0.000001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), BYTE.toGigabytes(-73.25), delta);
        msg = "-56229.321 / (1000 / 0.000001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), BYTE.toGigabytes(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 0.000001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), BYTE.toGigabytes(-873.5432456), delta);
        msg = "0 / (1000 / 0.000001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), BYTE.toGigabytes(0.0), delta);
        msg = "0.1 / (1000 / 0.000001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), BYTE.toGigabytes(0.1), delta);
        msg = "0.0000876543297 / (1000 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), BYTE.toGigabytes(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 0.000001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), BYTE.toGigabytes(0.33), delta);
        msg = "0.6543 / (1000 / 0.000001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), BYTE.toGigabytes(0.6543), delta);
        msg = "1 / (1000 / 0.000001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), BYTE.toGigabytes(1.0), delta);
        msg = "1.6543 / (1000 / 0.000001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), BYTE.toGigabytes(1.6543), delta);
        msg = "22.45 / (1000 / 0.000001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), BYTE.toGigabytes(22.45), delta);
        msg = "9876.5432 / (1000 / 0.000001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), BYTE.toGigabytes(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), BYTE.toGigabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 0.000001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), BYTE.toGigabytes(784.46789765434), delta);
        // ====================
        // ====================TERABYTE
        // ====================
        // to_factor = 1000000.0
        to_factor = TERABYTE.getFactor();
        msg = "-1 / (1000000 / 0.000001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), BYTE.toTerabytes(-1.0), delta);
        msg = "-0.1 / (1000000 / 0.000001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), BYTE.toTerabytes(-0.1), delta);
        msg = "-0.000456789 / (1000000 / 0.000001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), BYTE.toTerabytes(-4.56789E-4), delta);
        msg = "-73.25 / (1000000 / 0.000001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), BYTE.toTerabytes(-73.25), delta);
        msg = "-56229.321 / (1000000 / 0.000001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), BYTE.toTerabytes(-56229.321), delta);
        msg = "-873.5432456 / (1000000 / 0.000001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), BYTE.toTerabytes(-873.5432456), delta);
        msg = "0 / (1000000 / 0.000001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), BYTE.toTerabytes(0.0), delta);
        msg = "0.1 / (1000000 / 0.000001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), BYTE.toTerabytes(0.1), delta);
        msg = "0.0000876543297 / (1000000 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), BYTE.toTerabytes(8.76543297E-5), delta);
        msg = "0.33 / (1000000 / 0.000001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), BYTE.toTerabytes(0.33), delta);
        msg = "0.6543 / (1000000 / 0.000001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), BYTE.toTerabytes(0.6543), delta);
        msg = "1 / (1000000 / 0.000001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), BYTE.toTerabytes(1.0), delta);
        msg = "1.6543 / (1000000 / 0.000001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), BYTE.toTerabytes(1.6543), delta);
        msg = "22.45 / (1000000 / 0.000001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), BYTE.toTerabytes(22.45), delta);
        msg = "9876.5432 / (1000000 / 0.000001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), BYTE.toTerabytes(9876.5432), delta);
        msg = "1987654344.3345 / (1000000 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), BYTE.toTerabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000000 / 0.000001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), BYTE.toTerabytes(784.46789765434), delta);
        // ====================
        // ====================PETABYTE
        // ====================
        // to_factor = 1.0E9
        to_factor = PETABYTE.getFactor();
        msg = "-1 / (1000000000 / 0.000001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), BYTE.toPetabytes(-1.0), delta);
        msg = "-0.1 / (1000000000 / 0.000001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), BYTE.toPetabytes(-0.1), delta);
        msg = "-0.000456789 / (1000000000 / 0.000001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), BYTE.toPetabytes(-4.56789E-4), delta);
        msg = "-73.25 / (1000000000 / 0.000001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), BYTE.toPetabytes(-73.25), delta);
        msg = "-56229.321 / (1000000000 / 0.000001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), BYTE.toPetabytes(-56229.321), delta);
        msg = "-873.5432456 / (1000000000 / 0.000001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), BYTE.toPetabytes(-873.5432456), delta);
        msg = "0 / (1000000000 / 0.000001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), BYTE.toPetabytes(0.0), delta);
        msg = "0.1 / (1000000000 / 0.000001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), BYTE.toPetabytes(0.1), delta);
        msg = "0.0000876543297 / (1000000000 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), BYTE.toPetabytes(8.76543297E-5), delta);
        msg = "0.33 / (1000000000 / 0.000001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), BYTE.toPetabytes(0.33), delta);
        msg = "0.6543 / (1000000000 / 0.000001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), BYTE.toPetabytes(0.6543), delta);
        msg = "1 / (1000000000 / 0.000001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), BYTE.toPetabytes(1.0), delta);
        msg = "1.6543 / (1000000000 / 0.000001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), BYTE.toPetabytes(1.6543), delta);
        msg = "22.45 / (1000000000 / 0.000001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), BYTE.toPetabytes(22.45), delta);
        msg = "9876.5432 / (1000000000 / 0.000001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), BYTE.toPetabytes(9876.5432), delta);
        msg = "1987654344.3345 / (1000000000 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), BYTE.toPetabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000000000 / 0.000001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), BYTE.toPetabytes(784.46789765434), delta);
    }

    @Test()
    public void testKilobyte() {
        // from_factor = 0.001
        double from_factor = KILOBYTE.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================BYTE
        // ====================
        // to_factor = 1.0E-6
        to_factor = BYTE.getFactor();
        msg = "-1 * (0.001 / 0.000001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOBYTE.toBytes(-1.0), delta);
        msg = "-0.1 * (0.001 / 0.000001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOBYTE.toBytes(-0.1), delta);
        msg = "-0.000456789 * (0.001 / 0.000001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOBYTE.toBytes(-4.56789E-4), delta);
        msg = "-73.25 * (0.001 / 0.000001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOBYTE.toBytes(-73.25), delta);
        msg = "-56229.321 * (0.001 / 0.000001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOBYTE.toBytes(-56229.321), delta);
        msg = "-873.5432456 * (0.001 / 0.000001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOBYTE.toBytes(-873.5432456), delta);
        msg = "0 * (0.001 / 0.000001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOBYTE.toBytes(0.0), delta);
        msg = "0.1 * (0.001 / 0.000001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOBYTE.toBytes(0.1), delta);
        msg = "0.0000876543297 * (0.001 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOBYTE.toBytes(8.76543297E-5), delta);
        msg = "0.33 * (0.001 / 0.000001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOBYTE.toBytes(0.33), delta);
        msg = "0.6543 * (0.001 / 0.000001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOBYTE.toBytes(0.6543), delta);
        msg = "1 * (0.001 / 0.000001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOBYTE.toBytes(1.0), delta);
        msg = "1.6543 * (0.001 / 0.000001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOBYTE.toBytes(1.6543), delta);
        msg = "22.45 * (0.001 / 0.000001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOBYTE.toBytes(22.45), delta);
        msg = "9876.5432 * (0.001 / 0.000001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOBYTE.toBytes(9876.5432), delta);
        msg = "1987654344.3345 * (0.001 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOBYTE.toBytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.001 / 0.000001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOBYTE.toBytes(784.46789765434), delta);
        // ====================
        // ====================KILOBYTE
        // ====================
        // to_factor = 0.001
        to_factor = KILOBYTE.getFactor();
        msg = "-1 * (0.001 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOBYTE.toKilobytes(-1.0), delta);
        msg = "-0.1 * (0.001 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOBYTE.toKilobytes(-0.1), delta);
        msg = "-0.000456789 * (0.001 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOBYTE.toKilobytes(-4.56789E-4), delta);
        msg = "-73.25 * (0.001 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOBYTE.toKilobytes(-73.25), delta);
        msg = "-56229.321 * (0.001 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOBYTE.toKilobytes(-56229.321), delta);
        msg = "-873.5432456 * (0.001 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOBYTE.toKilobytes(-873.5432456), delta);
        msg = "0 * (0.001 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOBYTE.toKilobytes(0.0), delta);
        msg = "0.1 * (0.001 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOBYTE.toKilobytes(0.1), delta);
        msg = "0.0000876543297 * (0.001 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOBYTE.toKilobytes(8.76543297E-5), delta);
        msg = "0.33 * (0.001 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOBYTE.toKilobytes(0.33), delta);
        msg = "0.6543 * (0.001 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOBYTE.toKilobytes(0.6543), delta);
        msg = "1 * (0.001 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOBYTE.toKilobytes(1.0), delta);
        msg = "1.6543 * (0.001 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOBYTE.toKilobytes(1.6543), delta);
        msg = "22.45 * (0.001 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOBYTE.toKilobytes(22.45), delta);
        msg = "9876.5432 * (0.001 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOBYTE.toKilobytes(9876.5432), delta);
        msg = "1987654344.3345 * (0.001 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOBYTE.toKilobytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.001 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOBYTE.toKilobytes(784.46789765434), delta);
        // ====================
        // ====================MEGABYTE
        // ====================
        // to_factor = 1.0
        to_factor = MEGABYTE.getFactor();
        msg = "-1 / (1 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), KILOBYTE.toMegabytes(-1.0), delta);
        msg = "-0.1 / (1 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), KILOBYTE.toMegabytes(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), KILOBYTE.toMegabytes(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), KILOBYTE.toMegabytes(-73.25), delta);
        msg = "-56229.321 / (1 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), KILOBYTE.toMegabytes(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), KILOBYTE.toMegabytes(-873.5432456), delta);
        msg = "0 / (1 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), KILOBYTE.toMegabytes(0.0), delta);
        msg = "0.1 / (1 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), KILOBYTE.toMegabytes(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), KILOBYTE.toMegabytes(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), KILOBYTE.toMegabytes(0.33), delta);
        msg = "0.6543 / (1 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), KILOBYTE.toMegabytes(0.6543), delta);
        msg = "1 / (1 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), KILOBYTE.toMegabytes(1.0), delta);
        msg = "1.6543 / (1 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), KILOBYTE.toMegabytes(1.6543), delta);
        msg = "22.45 / (1 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), KILOBYTE.toMegabytes(22.45), delta);
        msg = "9876.5432 / (1 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), KILOBYTE.toMegabytes(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), KILOBYTE.toMegabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), KILOBYTE.toMegabytes(784.46789765434), delta);
        // ====================
        // ====================GIGABYTE
        // ====================
        // to_factor = 1000.0
        to_factor = GIGABYTE.getFactor();
        msg = "-1 / (1000 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), KILOBYTE.toGigabytes(-1.0), delta);
        msg = "-0.1 / (1000 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), KILOBYTE.toGigabytes(-0.1), delta);
        msg = "-0.000456789 / (1000 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), KILOBYTE.toGigabytes(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), KILOBYTE.toGigabytes(-73.25), delta);
        msg = "-56229.321 / (1000 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), KILOBYTE.toGigabytes(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), KILOBYTE.toGigabytes(-873.5432456), delta);
        msg = "0 / (1000 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), KILOBYTE.toGigabytes(0.0), delta);
        msg = "0.1 / (1000 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), KILOBYTE.toGigabytes(0.1), delta);
        msg = "0.0000876543297 / (1000 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), KILOBYTE.toGigabytes(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), KILOBYTE.toGigabytes(0.33), delta);
        msg = "0.6543 / (1000 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), KILOBYTE.toGigabytes(0.6543), delta);
        msg = "1 / (1000 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), KILOBYTE.toGigabytes(1.0), delta);
        msg = "1.6543 / (1000 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), KILOBYTE.toGigabytes(1.6543), delta);
        msg = "22.45 / (1000 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), KILOBYTE.toGigabytes(22.45), delta);
        msg = "9876.5432 / (1000 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), KILOBYTE.toGigabytes(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), KILOBYTE.toGigabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), KILOBYTE.toGigabytes(784.46789765434), delta);
        // ====================
        // ====================TERABYTE
        // ====================
        // to_factor = 1000000.0
        to_factor = TERABYTE.getFactor();
        msg = "-1 / (1000000 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), KILOBYTE.toTerabytes(-1.0), delta);
        msg = "-0.1 / (1000000 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), KILOBYTE.toTerabytes(-0.1), delta);
        msg = "-0.000456789 / (1000000 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), KILOBYTE.toTerabytes(-4.56789E-4), delta);
        msg = "-73.25 / (1000000 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), KILOBYTE.toTerabytes(-73.25), delta);
        msg = "-56229.321 / (1000000 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), KILOBYTE.toTerabytes(-56229.321), delta);
        msg = "-873.5432456 / (1000000 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), KILOBYTE.toTerabytes(-873.5432456), delta);
        msg = "0 / (1000000 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), KILOBYTE.toTerabytes(0.0), delta);
        msg = "0.1 / (1000000 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), KILOBYTE.toTerabytes(0.1), delta);
        msg = "0.0000876543297 / (1000000 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), KILOBYTE.toTerabytes(8.76543297E-5), delta);
        msg = "0.33 / (1000000 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), KILOBYTE.toTerabytes(0.33), delta);
        msg = "0.6543 / (1000000 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), KILOBYTE.toTerabytes(0.6543), delta);
        msg = "1 / (1000000 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), KILOBYTE.toTerabytes(1.0), delta);
        msg = "1.6543 / (1000000 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), KILOBYTE.toTerabytes(1.6543), delta);
        msg = "22.45 / (1000000 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), KILOBYTE.toTerabytes(22.45), delta);
        msg = "9876.5432 / (1000000 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), KILOBYTE.toTerabytes(9876.5432), delta);
        msg = "1987654344.3345 / (1000000 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), KILOBYTE.toTerabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000000 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), KILOBYTE.toTerabytes(784.46789765434), delta);
        // ====================
        // ====================PETABYTE
        // ====================
        // to_factor = 1.0E9
        to_factor = PETABYTE.getFactor();
        msg = "-1 / (1000000000 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), KILOBYTE.toPetabytes(-1.0), delta);
        msg = "-0.1 / (1000000000 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), KILOBYTE.toPetabytes(-0.1), delta);
        msg = "-0.000456789 / (1000000000 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), KILOBYTE.toPetabytes(-4.56789E-4), delta);
        msg = "-73.25 / (1000000000 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), KILOBYTE.toPetabytes(-73.25), delta);
        msg = "-56229.321 / (1000000000 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), KILOBYTE.toPetabytes(-56229.321), delta);
        msg = "-873.5432456 / (1000000000 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), KILOBYTE.toPetabytes(-873.5432456), delta);
        msg = "0 / (1000000000 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), KILOBYTE.toPetabytes(0.0), delta);
        msg = "0.1 / (1000000000 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), KILOBYTE.toPetabytes(0.1), delta);
        msg = "0.0000876543297 / (1000000000 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), KILOBYTE.toPetabytes(8.76543297E-5), delta);
        msg = "0.33 / (1000000000 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), KILOBYTE.toPetabytes(0.33), delta);
        msg = "0.6543 / (1000000000 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), KILOBYTE.toPetabytes(0.6543), delta);
        msg = "1 / (1000000000 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), KILOBYTE.toPetabytes(1.0), delta);
        msg = "1.6543 / (1000000000 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), KILOBYTE.toPetabytes(1.6543), delta);
        msg = "22.45 / (1000000000 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), KILOBYTE.toPetabytes(22.45), delta);
        msg = "9876.5432 / (1000000000 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), KILOBYTE.toPetabytes(9876.5432), delta);
        msg = "1987654344.3345 / (1000000000 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), KILOBYTE.toPetabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000000000 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), KILOBYTE.toPetabytes(784.46789765434), delta);
    }

    @Test()
    public void testMegabyte() {
        // from_factor = 1.0
        double from_factor = MEGABYTE.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================BYTE
        // ====================
        // to_factor = 1.0E-6
        to_factor = BYTE.getFactor();
        msg = "-1 * (1 / 0.000001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MEGABYTE.toBytes(-1.0), delta);
        msg = "-0.1 * (1 / 0.000001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MEGABYTE.toBytes(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.000001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MEGABYTE.toBytes(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.000001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MEGABYTE.toBytes(-73.25), delta);
        msg = "-56229.321 * (1 / 0.000001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MEGABYTE.toBytes(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.000001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MEGABYTE.toBytes(-873.5432456), delta);
        msg = "0 * (1 / 0.000001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MEGABYTE.toBytes(0.0), delta);
        msg = "0.1 * (1 / 0.000001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MEGABYTE.toBytes(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MEGABYTE.toBytes(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.000001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MEGABYTE.toBytes(0.33), delta);
        msg = "0.6543 * (1 / 0.000001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MEGABYTE.toBytes(0.6543), delta);
        msg = "1 * (1 / 0.000001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MEGABYTE.toBytes(1.0), delta);
        msg = "1.6543 * (1 / 0.000001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MEGABYTE.toBytes(1.6543), delta);
        msg = "22.45 * (1 / 0.000001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MEGABYTE.toBytes(22.45), delta);
        msg = "9876.5432 * (1 / 0.000001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MEGABYTE.toBytes(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MEGABYTE.toBytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.000001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MEGABYTE.toBytes(784.46789765434), delta);
        // ====================
        // ====================KILOBYTE
        // ====================
        // to_factor = 0.001
        to_factor = KILOBYTE.getFactor();
        msg = "-1 * (1 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MEGABYTE.toKilobytes(-1.0), delta);
        msg = "-0.1 * (1 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MEGABYTE.toKilobytes(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MEGABYTE.toKilobytes(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MEGABYTE.toKilobytes(-73.25), delta);
        msg = "-56229.321 * (1 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MEGABYTE.toKilobytes(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MEGABYTE.toKilobytes(-873.5432456), delta);
        msg = "0 * (1 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MEGABYTE.toKilobytes(0.0), delta);
        msg = "0.1 * (1 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MEGABYTE.toKilobytes(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MEGABYTE.toKilobytes(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MEGABYTE.toKilobytes(0.33), delta);
        msg = "0.6543 * (1 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MEGABYTE.toKilobytes(0.6543), delta);
        msg = "1 * (1 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MEGABYTE.toKilobytes(1.0), delta);
        msg = "1.6543 * (1 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MEGABYTE.toKilobytes(1.6543), delta);
        msg = "22.45 * (1 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MEGABYTE.toKilobytes(22.45), delta);
        msg = "9876.5432 * (1 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MEGABYTE.toKilobytes(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MEGABYTE.toKilobytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MEGABYTE.toKilobytes(784.46789765434), delta);
        // ====================
        // ====================MEGABYTE
        // ====================
        // to_factor = 1.0
        to_factor = MEGABYTE.getFactor();
        msg = "-1 * (1 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MEGABYTE.toMegabytes(-1.0), delta);
        msg = "-0.1 * (1 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MEGABYTE.toMegabytes(-0.1), delta);
        msg = "-0.000456789 * (1 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MEGABYTE.toMegabytes(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MEGABYTE.toMegabytes(-73.25), delta);
        msg = "-56229.321 * (1 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MEGABYTE.toMegabytes(-56229.321), delta);
        msg = "-873.5432456 * (1 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MEGABYTE.toMegabytes(-873.5432456), delta);
        msg = "0 * (1 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MEGABYTE.toMegabytes(0.0), delta);
        msg = "0.1 * (1 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MEGABYTE.toMegabytes(0.1), delta);
        msg = "0.0000876543297 * (1 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MEGABYTE.toMegabytes(8.76543297E-5), delta);
        msg = "0.33 * (1 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MEGABYTE.toMegabytes(0.33), delta);
        msg = "0.6543 * (1 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MEGABYTE.toMegabytes(0.6543), delta);
        msg = "1 * (1 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MEGABYTE.toMegabytes(1.0), delta);
        msg = "1.6543 * (1 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MEGABYTE.toMegabytes(1.6543), delta);
        msg = "22.45 * (1 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MEGABYTE.toMegabytes(22.45), delta);
        msg = "9876.5432 * (1 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MEGABYTE.toMegabytes(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MEGABYTE.toMegabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MEGABYTE.toMegabytes(784.46789765434), delta);
        // ====================
        // ====================GIGABYTE
        // ====================
        // to_factor = 1000.0
        to_factor = GIGABYTE.getFactor();
        msg = "-1 / (1000 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MEGABYTE.toGigabytes(-1.0), delta);
        msg = "-0.1 / (1000 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MEGABYTE.toGigabytes(-0.1), delta);
        msg = "-0.000456789 / (1000 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MEGABYTE.toGigabytes(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MEGABYTE.toGigabytes(-73.25), delta);
        msg = "-56229.321 / (1000 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MEGABYTE.toGigabytes(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MEGABYTE.toGigabytes(-873.5432456), delta);
        msg = "0 / (1000 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MEGABYTE.toGigabytes(0.0), delta);
        msg = "0.1 / (1000 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MEGABYTE.toGigabytes(0.1), delta);
        msg = "0.0000876543297 / (1000 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MEGABYTE.toGigabytes(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MEGABYTE.toGigabytes(0.33), delta);
        msg = "0.6543 / (1000 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MEGABYTE.toGigabytes(0.6543), delta);
        msg = "1 / (1000 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MEGABYTE.toGigabytes(1.0), delta);
        msg = "1.6543 / (1000 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MEGABYTE.toGigabytes(1.6543), delta);
        msg = "22.45 / (1000 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MEGABYTE.toGigabytes(22.45), delta);
        msg = "9876.5432 / (1000 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MEGABYTE.toGigabytes(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MEGABYTE.toGigabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MEGABYTE.toGigabytes(784.46789765434), delta);
        // ====================
        // ====================TERABYTE
        // ====================
        // to_factor = 1000000.0
        to_factor = TERABYTE.getFactor();
        msg = "-1 / (1000000 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MEGABYTE.toTerabytes(-1.0), delta);
        msg = "-0.1 / (1000000 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MEGABYTE.toTerabytes(-0.1), delta);
        msg = "-0.000456789 / (1000000 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MEGABYTE.toTerabytes(-4.56789E-4), delta);
        msg = "-73.25 / (1000000 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MEGABYTE.toTerabytes(-73.25), delta);
        msg = "-56229.321 / (1000000 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MEGABYTE.toTerabytes(-56229.321), delta);
        msg = "-873.5432456 / (1000000 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MEGABYTE.toTerabytes(-873.5432456), delta);
        msg = "0 / (1000000 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MEGABYTE.toTerabytes(0.0), delta);
        msg = "0.1 / (1000000 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MEGABYTE.toTerabytes(0.1), delta);
        msg = "0.0000876543297 / (1000000 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MEGABYTE.toTerabytes(8.76543297E-5), delta);
        msg = "0.33 / (1000000 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MEGABYTE.toTerabytes(0.33), delta);
        msg = "0.6543 / (1000000 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MEGABYTE.toTerabytes(0.6543), delta);
        msg = "1 / (1000000 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MEGABYTE.toTerabytes(1.0), delta);
        msg = "1.6543 / (1000000 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MEGABYTE.toTerabytes(1.6543), delta);
        msg = "22.45 / (1000000 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MEGABYTE.toTerabytes(22.45), delta);
        msg = "9876.5432 / (1000000 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MEGABYTE.toTerabytes(9876.5432), delta);
        msg = "1987654344.3345 / (1000000 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MEGABYTE.toTerabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000000 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MEGABYTE.toTerabytes(784.46789765434), delta);
        // ====================
        // ====================PETABYTE
        // ====================
        // to_factor = 1.0E9
        to_factor = PETABYTE.getFactor();
        msg = "-1 / (1000000000 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MEGABYTE.toPetabytes(-1.0), delta);
        msg = "-0.1 / (1000000000 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MEGABYTE.toPetabytes(-0.1), delta);
        msg = "-0.000456789 / (1000000000 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MEGABYTE.toPetabytes(-4.56789E-4), delta);
        msg = "-73.25 / (1000000000 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MEGABYTE.toPetabytes(-73.25), delta);
        msg = "-56229.321 / (1000000000 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MEGABYTE.toPetabytes(-56229.321), delta);
        msg = "-873.5432456 / (1000000000 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MEGABYTE.toPetabytes(-873.5432456), delta);
        msg = "0 / (1000000000 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MEGABYTE.toPetabytes(0.0), delta);
        msg = "0.1 / (1000000000 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MEGABYTE.toPetabytes(0.1), delta);
        msg = "0.0000876543297 / (1000000000 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MEGABYTE.toPetabytes(8.76543297E-5), delta);
        msg = "0.33 / (1000000000 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MEGABYTE.toPetabytes(0.33), delta);
        msg = "0.6543 / (1000000000 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MEGABYTE.toPetabytes(0.6543), delta);
        msg = "1 / (1000000000 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MEGABYTE.toPetabytes(1.0), delta);
        msg = "1.6543 / (1000000000 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MEGABYTE.toPetabytes(1.6543), delta);
        msg = "22.45 / (1000000000 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MEGABYTE.toPetabytes(22.45), delta);
        msg = "9876.5432 / (1000000000 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MEGABYTE.toPetabytes(9876.5432), delta);
        msg = "1987654344.3345 / (1000000000 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MEGABYTE.toPetabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000000000 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MEGABYTE.toPetabytes(784.46789765434), delta);
    }

    @Test()
    public void testGigabyte() {
        // from_factor = 1000.0
        double from_factor = GIGABYTE.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================BYTE
        // ====================
        // to_factor = 1.0E-6
        to_factor = BYTE.getFactor();
        msg = "-1 * (1000 / 0.000001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GIGABYTE.toBytes(-1.0), delta);
        msg = "-0.1 * (1000 / 0.000001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GIGABYTE.toBytes(-0.1), delta);
        msg = "-0.000456789 * (1000 / 0.000001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GIGABYTE.toBytes(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 0.000001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GIGABYTE.toBytes(-73.25), delta);
        msg = "-56229.321 * (1000 / 0.000001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GIGABYTE.toBytes(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 0.000001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GIGABYTE.toBytes(-873.5432456), delta);
        msg = "0 * (1000 / 0.000001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GIGABYTE.toBytes(0.0), delta);
        msg = "0.1 * (1000 / 0.000001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GIGABYTE.toBytes(0.1), delta);
        msg = "0.0000876543297 * (1000 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GIGABYTE.toBytes(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 0.000001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GIGABYTE.toBytes(0.33), delta);
        msg = "0.6543 * (1000 / 0.000001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GIGABYTE.toBytes(0.6543), delta);
        msg = "1 * (1000 / 0.000001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GIGABYTE.toBytes(1.0), delta);
        msg = "1.6543 * (1000 / 0.000001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GIGABYTE.toBytes(1.6543), delta);
        msg = "22.45 * (1000 / 0.000001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GIGABYTE.toBytes(22.45), delta);
        msg = "9876.5432 * (1000 / 0.000001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GIGABYTE.toBytes(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GIGABYTE.toBytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 0.000001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GIGABYTE.toBytes(784.46789765434), delta);
        // ====================
        // ====================KILOBYTE
        // ====================
        // to_factor = 0.001
        to_factor = KILOBYTE.getFactor();
        msg = "-1 * (1000 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GIGABYTE.toKilobytes(-1.0), delta);
        msg = "-0.1 * (1000 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GIGABYTE.toKilobytes(-0.1), delta);
        msg = "-0.000456789 * (1000 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GIGABYTE.toKilobytes(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GIGABYTE.toKilobytes(-73.25), delta);
        msg = "-56229.321 * (1000 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GIGABYTE.toKilobytes(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GIGABYTE.toKilobytes(-873.5432456), delta);
        msg = "0 * (1000 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GIGABYTE.toKilobytes(0.0), delta);
        msg = "0.1 * (1000 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GIGABYTE.toKilobytes(0.1), delta);
        msg = "0.0000876543297 * (1000 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GIGABYTE.toKilobytes(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GIGABYTE.toKilobytes(0.33), delta);
        msg = "0.6543 * (1000 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GIGABYTE.toKilobytes(0.6543), delta);
        msg = "1 * (1000 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GIGABYTE.toKilobytes(1.0), delta);
        msg = "1.6543 * (1000 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GIGABYTE.toKilobytes(1.6543), delta);
        msg = "22.45 * (1000 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GIGABYTE.toKilobytes(22.45), delta);
        msg = "9876.5432 * (1000 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GIGABYTE.toKilobytes(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GIGABYTE.toKilobytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GIGABYTE.toKilobytes(784.46789765434), delta);
        // ====================
        // ====================MEGABYTE
        // ====================
        // to_factor = 1.0
        to_factor = MEGABYTE.getFactor();
        msg = "-1 * (1000 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GIGABYTE.toMegabytes(-1.0), delta);
        msg = "-0.1 * (1000 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GIGABYTE.toMegabytes(-0.1), delta);
        msg = "-0.000456789 * (1000 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GIGABYTE.toMegabytes(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GIGABYTE.toMegabytes(-73.25), delta);
        msg = "-56229.321 * (1000 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GIGABYTE.toMegabytes(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GIGABYTE.toMegabytes(-873.5432456), delta);
        msg = "0 * (1000 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GIGABYTE.toMegabytes(0.0), delta);
        msg = "0.1 * (1000 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GIGABYTE.toMegabytes(0.1), delta);
        msg = "0.0000876543297 * (1000 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GIGABYTE.toMegabytes(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GIGABYTE.toMegabytes(0.33), delta);
        msg = "0.6543 * (1000 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GIGABYTE.toMegabytes(0.6543), delta);
        msg = "1 * (1000 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GIGABYTE.toMegabytes(1.0), delta);
        msg = "1.6543 * (1000 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GIGABYTE.toMegabytes(1.6543), delta);
        msg = "22.45 * (1000 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GIGABYTE.toMegabytes(22.45), delta);
        msg = "9876.5432 * (1000 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GIGABYTE.toMegabytes(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GIGABYTE.toMegabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GIGABYTE.toMegabytes(784.46789765434), delta);
        // ====================
        // ====================GIGABYTE
        // ====================
        // to_factor = 1000.0
        to_factor = GIGABYTE.getFactor();
        msg = "-1 * (1000 / 1000)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GIGABYTE.toGigabytes(-1.0), delta);
        msg = "-0.1 * (1000 / 1000)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GIGABYTE.toGigabytes(-0.1), delta);
        msg = "-0.000456789 * (1000 / 1000)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GIGABYTE.toGigabytes(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 1000)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GIGABYTE.toGigabytes(-73.25), delta);
        msg = "-56229.321 * (1000 / 1000)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GIGABYTE.toGigabytes(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 1000)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GIGABYTE.toGigabytes(-873.5432456), delta);
        msg = "0 * (1000 / 1000)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GIGABYTE.toGigabytes(0.0), delta);
        msg = "0.1 * (1000 / 1000)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GIGABYTE.toGigabytes(0.1), delta);
        msg = "0.0000876543297 * (1000 / 1000)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GIGABYTE.toGigabytes(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 1000)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GIGABYTE.toGigabytes(0.33), delta);
        msg = "0.6543 * (1000 / 1000)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GIGABYTE.toGigabytes(0.6543), delta);
        msg = "1 * (1000 / 1000)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GIGABYTE.toGigabytes(1.0), delta);
        msg = "1.6543 * (1000 / 1000)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GIGABYTE.toGigabytes(1.6543), delta);
        msg = "22.45 * (1000 / 1000)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GIGABYTE.toGigabytes(22.45), delta);
        msg = "9876.5432 * (1000 / 1000)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GIGABYTE.toGigabytes(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 1000)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GIGABYTE.toGigabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 1000)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GIGABYTE.toGigabytes(784.46789765434), delta);
        // ====================
        // ====================TERABYTE
        // ====================
        // to_factor = 1000000.0
        to_factor = TERABYTE.getFactor();
        msg = "-1 / (1000000 / 1000)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GIGABYTE.toTerabytes(-1.0), delta);
        msg = "-0.1 / (1000000 / 1000)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GIGABYTE.toTerabytes(-0.1), delta);
        msg = "-0.000456789 / (1000000 / 1000)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GIGABYTE.toTerabytes(-4.56789E-4), delta);
        msg = "-73.25 / (1000000 / 1000)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GIGABYTE.toTerabytes(-73.25), delta);
        msg = "-56229.321 / (1000000 / 1000)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GIGABYTE.toTerabytes(-56229.321), delta);
        msg = "-873.5432456 / (1000000 / 1000)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GIGABYTE.toTerabytes(-873.5432456), delta);
        msg = "0 / (1000000 / 1000)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GIGABYTE.toTerabytes(0.0), delta);
        msg = "0.1 / (1000000 / 1000)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GIGABYTE.toTerabytes(0.1), delta);
        msg = "0.0000876543297 / (1000000 / 1000)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GIGABYTE.toTerabytes(8.76543297E-5), delta);
        msg = "0.33 / (1000000 / 1000)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GIGABYTE.toTerabytes(0.33), delta);
        msg = "0.6543 / (1000000 / 1000)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GIGABYTE.toTerabytes(0.6543), delta);
        msg = "1 / (1000000 / 1000)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GIGABYTE.toTerabytes(1.0), delta);
        msg = "1.6543 / (1000000 / 1000)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GIGABYTE.toTerabytes(1.6543), delta);
        msg = "22.45 / (1000000 / 1000)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GIGABYTE.toTerabytes(22.45), delta);
        msg = "9876.5432 / (1000000 / 1000)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GIGABYTE.toTerabytes(9876.5432), delta);
        msg = "1987654344.3345 / (1000000 / 1000)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GIGABYTE.toTerabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000000 / 1000)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GIGABYTE.toTerabytes(784.46789765434), delta);
        // ====================
        // ====================PETABYTE
        // ====================
        // to_factor = 1.0E9
        to_factor = PETABYTE.getFactor();
        msg = "-1 / (1000000000 / 1000)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GIGABYTE.toPetabytes(-1.0), delta);
        msg = "-0.1 / (1000000000 / 1000)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GIGABYTE.toPetabytes(-0.1), delta);
        msg = "-0.000456789 / (1000000000 / 1000)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GIGABYTE.toPetabytes(-4.56789E-4), delta);
        msg = "-73.25 / (1000000000 / 1000)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GIGABYTE.toPetabytes(-73.25), delta);
        msg = "-56229.321 / (1000000000 / 1000)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GIGABYTE.toPetabytes(-56229.321), delta);
        msg = "-873.5432456 / (1000000000 / 1000)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GIGABYTE.toPetabytes(-873.5432456), delta);
        msg = "0 / (1000000000 / 1000)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GIGABYTE.toPetabytes(0.0), delta);
        msg = "0.1 / (1000000000 / 1000)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GIGABYTE.toPetabytes(0.1), delta);
        msg = "0.0000876543297 / (1000000000 / 1000)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GIGABYTE.toPetabytes(8.76543297E-5), delta);
        msg = "0.33 / (1000000000 / 1000)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GIGABYTE.toPetabytes(0.33), delta);
        msg = "0.6543 / (1000000000 / 1000)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GIGABYTE.toPetabytes(0.6543), delta);
        msg = "1 / (1000000000 / 1000)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GIGABYTE.toPetabytes(1.0), delta);
        msg = "1.6543 / (1000000000 / 1000)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GIGABYTE.toPetabytes(1.6543), delta);
        msg = "22.45 / (1000000000 / 1000)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GIGABYTE.toPetabytes(22.45), delta);
        msg = "9876.5432 / (1000000000 / 1000)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GIGABYTE.toPetabytes(9876.5432), delta);
        msg = "1987654344.3345 / (1000000000 / 1000)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GIGABYTE.toPetabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000000000 / 1000)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GIGABYTE.toPetabytes(784.46789765434), delta);
    }

    @Test()
    public void testTerabyte() {
        // from_factor = 1000000.0
        double from_factor = TERABYTE.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================BYTE
        // ====================
        // to_factor = 1.0E-6
        to_factor = BYTE.getFactor();
        msg = "-1 * (1000000 / 0.000001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TERABYTE.toBytes(-1.0), delta);
        msg = "-0.1 * (1000000 / 0.000001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TERABYTE.toBytes(-0.1), delta);
        msg = "-0.000456789 * (1000000 / 0.000001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TERABYTE.toBytes(-4.56789E-4), delta);
        msg = "-73.25 * (1000000 / 0.000001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TERABYTE.toBytes(-73.25), delta);
        msg = "-56229.321 * (1000000 / 0.000001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TERABYTE.toBytes(-56229.321), delta);
        msg = "-873.5432456 * (1000000 / 0.000001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TERABYTE.toBytes(-873.5432456), delta);
        msg = "0 * (1000000 / 0.000001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TERABYTE.toBytes(0.0), delta);
        msg = "0.1 * (1000000 / 0.000001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TERABYTE.toBytes(0.1), delta);
        msg = "0.0000876543297 * (1000000 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TERABYTE.toBytes(8.76543297E-5), delta);
        msg = "0.33 * (1000000 / 0.000001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TERABYTE.toBytes(0.33), delta);
        msg = "0.6543 * (1000000 / 0.000001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TERABYTE.toBytes(0.6543), delta);
        msg = "1 * (1000000 / 0.000001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TERABYTE.toBytes(1.0), delta);
        msg = "1.6543 * (1000000 / 0.000001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TERABYTE.toBytes(1.6543), delta);
        msg = "22.45 * (1000000 / 0.000001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TERABYTE.toBytes(22.45), delta);
        msg = "9876.5432 * (1000000 / 0.000001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TERABYTE.toBytes(9876.5432), delta);
        msg = "1987654344.3345 * (1000000 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TERABYTE.toBytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000 / 0.000001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TERABYTE.toBytes(784.46789765434), delta);
        // ====================
        // ====================KILOBYTE
        // ====================
        // to_factor = 0.001
        to_factor = KILOBYTE.getFactor();
        msg = "-1 * (1000000 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TERABYTE.toKilobytes(-1.0), delta);
        msg = "-0.1 * (1000000 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TERABYTE.toKilobytes(-0.1), delta);
        msg = "-0.000456789 * (1000000 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TERABYTE.toKilobytes(-4.56789E-4), delta);
        msg = "-73.25 * (1000000 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TERABYTE.toKilobytes(-73.25), delta);
        msg = "-56229.321 * (1000000 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TERABYTE.toKilobytes(-56229.321), delta);
        msg = "-873.5432456 * (1000000 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TERABYTE.toKilobytes(-873.5432456), delta);
        msg = "0 * (1000000 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TERABYTE.toKilobytes(0.0), delta);
        msg = "0.1 * (1000000 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TERABYTE.toKilobytes(0.1), delta);
        msg = "0.0000876543297 * (1000000 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TERABYTE.toKilobytes(8.76543297E-5), delta);
        msg = "0.33 * (1000000 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TERABYTE.toKilobytes(0.33), delta);
        msg = "0.6543 * (1000000 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TERABYTE.toKilobytes(0.6543), delta);
        msg = "1 * (1000000 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TERABYTE.toKilobytes(1.0), delta);
        msg = "1.6543 * (1000000 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TERABYTE.toKilobytes(1.6543), delta);
        msg = "22.45 * (1000000 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TERABYTE.toKilobytes(22.45), delta);
        msg = "9876.5432 * (1000000 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TERABYTE.toKilobytes(9876.5432), delta);
        msg = "1987654344.3345 * (1000000 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TERABYTE.toKilobytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TERABYTE.toKilobytes(784.46789765434), delta);
        // ====================
        // ====================MEGABYTE
        // ====================
        // to_factor = 1.0
        to_factor = MEGABYTE.getFactor();
        msg = "-1 * (1000000 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TERABYTE.toMegabytes(-1.0), delta);
        msg = "-0.1 * (1000000 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TERABYTE.toMegabytes(-0.1), delta);
        msg = "-0.000456789 * (1000000 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TERABYTE.toMegabytes(-4.56789E-4), delta);
        msg = "-73.25 * (1000000 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TERABYTE.toMegabytes(-73.25), delta);
        msg = "-56229.321 * (1000000 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TERABYTE.toMegabytes(-56229.321), delta);
        msg = "-873.5432456 * (1000000 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TERABYTE.toMegabytes(-873.5432456), delta);
        msg = "0 * (1000000 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TERABYTE.toMegabytes(0.0), delta);
        msg = "0.1 * (1000000 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TERABYTE.toMegabytes(0.1), delta);
        msg = "0.0000876543297 * (1000000 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TERABYTE.toMegabytes(8.76543297E-5), delta);
        msg = "0.33 * (1000000 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TERABYTE.toMegabytes(0.33), delta);
        msg = "0.6543 * (1000000 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TERABYTE.toMegabytes(0.6543), delta);
        msg = "1 * (1000000 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TERABYTE.toMegabytes(1.0), delta);
        msg = "1.6543 * (1000000 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TERABYTE.toMegabytes(1.6543), delta);
        msg = "22.45 * (1000000 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TERABYTE.toMegabytes(22.45), delta);
        msg = "9876.5432 * (1000000 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TERABYTE.toMegabytes(9876.5432), delta);
        msg = "1987654344.3345 * (1000000 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TERABYTE.toMegabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TERABYTE.toMegabytes(784.46789765434), delta);
        // ====================
        // ====================GIGABYTE
        // ====================
        // to_factor = 1000.0
        to_factor = GIGABYTE.getFactor();
        msg = "-1 * (1000000 / 1000)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TERABYTE.toGigabytes(-1.0), delta);
        msg = "-0.1 * (1000000 / 1000)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TERABYTE.toGigabytes(-0.1), delta);
        msg = "-0.000456789 * (1000000 / 1000)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TERABYTE.toGigabytes(-4.56789E-4), delta);
        msg = "-73.25 * (1000000 / 1000)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TERABYTE.toGigabytes(-73.25), delta);
        msg = "-56229.321 * (1000000 / 1000)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TERABYTE.toGigabytes(-56229.321), delta);
        msg = "-873.5432456 * (1000000 / 1000)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TERABYTE.toGigabytes(-873.5432456), delta);
        msg = "0 * (1000000 / 1000)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TERABYTE.toGigabytes(0.0), delta);
        msg = "0.1 * (1000000 / 1000)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TERABYTE.toGigabytes(0.1), delta);
        msg = "0.0000876543297 * (1000000 / 1000)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TERABYTE.toGigabytes(8.76543297E-5), delta);
        msg = "0.33 * (1000000 / 1000)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TERABYTE.toGigabytes(0.33), delta);
        msg = "0.6543 * (1000000 / 1000)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TERABYTE.toGigabytes(0.6543), delta);
        msg = "1 * (1000000 / 1000)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TERABYTE.toGigabytes(1.0), delta);
        msg = "1.6543 * (1000000 / 1000)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TERABYTE.toGigabytes(1.6543), delta);
        msg = "22.45 * (1000000 / 1000)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TERABYTE.toGigabytes(22.45), delta);
        msg = "9876.5432 * (1000000 / 1000)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TERABYTE.toGigabytes(9876.5432), delta);
        msg = "1987654344.3345 * (1000000 / 1000)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TERABYTE.toGigabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000 / 1000)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TERABYTE.toGigabytes(784.46789765434), delta);
        // ====================
        // ====================TERABYTE
        // ====================
        // to_factor = 1000000.0
        to_factor = TERABYTE.getFactor();
        msg = "-1 * (1000000 / 1000000)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TERABYTE.toTerabytes(-1.0), delta);
        msg = "-0.1 * (1000000 / 1000000)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TERABYTE.toTerabytes(-0.1), delta);
        msg = "-0.000456789 * (1000000 / 1000000)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TERABYTE.toTerabytes(-4.56789E-4), delta);
        msg = "-73.25 * (1000000 / 1000000)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TERABYTE.toTerabytes(-73.25), delta);
        msg = "-56229.321 * (1000000 / 1000000)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TERABYTE.toTerabytes(-56229.321), delta);
        msg = "-873.5432456 * (1000000 / 1000000)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TERABYTE.toTerabytes(-873.5432456), delta);
        msg = "0 * (1000000 / 1000000)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TERABYTE.toTerabytes(0.0), delta);
        msg = "0.1 * (1000000 / 1000000)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TERABYTE.toTerabytes(0.1), delta);
        msg = "0.0000876543297 * (1000000 / 1000000)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TERABYTE.toTerabytes(8.76543297E-5), delta);
        msg = "0.33 * (1000000 / 1000000)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TERABYTE.toTerabytes(0.33), delta);
        msg = "0.6543 * (1000000 / 1000000)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TERABYTE.toTerabytes(0.6543), delta);
        msg = "1 * (1000000 / 1000000)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TERABYTE.toTerabytes(1.0), delta);
        msg = "1.6543 * (1000000 / 1000000)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TERABYTE.toTerabytes(1.6543), delta);
        msg = "22.45 * (1000000 / 1000000)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TERABYTE.toTerabytes(22.45), delta);
        msg = "9876.5432 * (1000000 / 1000000)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TERABYTE.toTerabytes(9876.5432), delta);
        msg = "1987654344.3345 * (1000000 / 1000000)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TERABYTE.toTerabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000 / 1000000)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TERABYTE.toTerabytes(784.46789765434), delta);
        // ====================
        // ====================PETABYTE
        // ====================
        // to_factor = 1.0E9
        to_factor = PETABYTE.getFactor();
        msg = "-1 / (1000000000 / 1000000)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), TERABYTE.toPetabytes(-1.0), delta);
        msg = "-0.1 / (1000000000 / 1000000)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), TERABYTE.toPetabytes(-0.1), delta);
        msg = "-0.000456789 / (1000000000 / 1000000)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), TERABYTE.toPetabytes(-4.56789E-4), delta);
        msg = "-73.25 / (1000000000 / 1000000)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), TERABYTE.toPetabytes(-73.25), delta);
        msg = "-56229.321 / (1000000000 / 1000000)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), TERABYTE.toPetabytes(-56229.321), delta);
        msg = "-873.5432456 / (1000000000 / 1000000)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), TERABYTE.toPetabytes(-873.5432456), delta);
        msg = "0 / (1000000000 / 1000000)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), TERABYTE.toPetabytes(0.0), delta);
        msg = "0.1 / (1000000000 / 1000000)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), TERABYTE.toPetabytes(0.1), delta);
        msg = "0.0000876543297 / (1000000000 / 1000000)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), TERABYTE.toPetabytes(8.76543297E-5), delta);
        msg = "0.33 / (1000000000 / 1000000)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), TERABYTE.toPetabytes(0.33), delta);
        msg = "0.6543 / (1000000000 / 1000000)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), TERABYTE.toPetabytes(0.6543), delta);
        msg = "1 / (1000000000 / 1000000)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), TERABYTE.toPetabytes(1.0), delta);
        msg = "1.6543 / (1000000000 / 1000000)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), TERABYTE.toPetabytes(1.6543), delta);
        msg = "22.45 / (1000000000 / 1000000)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), TERABYTE.toPetabytes(22.45), delta);
        msg = "9876.5432 / (1000000000 / 1000000)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), TERABYTE.toPetabytes(9876.5432), delta);
        msg = "1987654344.3345 / (1000000000 / 1000000)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), TERABYTE.toPetabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000000000 / 1000000)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), TERABYTE.toPetabytes(784.46789765434), delta);
    }

    @Test()
    public void testPetabyte() {
        // from_factor = 1.0E9
        double from_factor = PETABYTE.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================BYTE
        // ====================
        // to_factor = 1.0E-6
        to_factor = BYTE.getFactor();
        msg = "-1 * (1000000000 / 0.000001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), PETABYTE.toBytes(-1.0), delta);
        msg = "-0.1 * (1000000000 / 0.000001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), PETABYTE.toBytes(-0.1), delta);
        msg = "-0.000456789 * (1000000000 / 0.000001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), PETABYTE.toBytes(-4.56789E-4), delta);
        msg = "-73.25 * (1000000000 / 0.000001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), PETABYTE.toBytes(-73.25), delta);
        msg = "-56229.321 * (1000000000 / 0.000001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), PETABYTE.toBytes(-56229.321), delta);
        msg = "-873.5432456 * (1000000000 / 0.000001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), PETABYTE.toBytes(-873.5432456), delta);
        msg = "0 * (1000000000 / 0.000001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), PETABYTE.toBytes(0.0), delta);
        msg = "0.1 * (1000000000 / 0.000001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), PETABYTE.toBytes(0.1), delta);
        msg = "0.0000876543297 * (1000000000 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), PETABYTE.toBytes(8.76543297E-5), delta);
        msg = "0.33 * (1000000000 / 0.000001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), PETABYTE.toBytes(0.33), delta);
        msg = "0.6543 * (1000000000 / 0.000001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), PETABYTE.toBytes(0.6543), delta);
        msg = "1 * (1000000000 / 0.000001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), PETABYTE.toBytes(1.0), delta);
        msg = "1.6543 * (1000000000 / 0.000001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), PETABYTE.toBytes(1.6543), delta);
        msg = "22.45 * (1000000000 / 0.000001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), PETABYTE.toBytes(22.45), delta);
        msg = "9876.5432 * (1000000000 / 0.000001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), PETABYTE.toBytes(9876.5432), delta);
        msg = "1987654344.3345 * (1000000000 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), PETABYTE.toBytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000000 / 0.000001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), PETABYTE.toBytes(784.46789765434), delta);
        // ====================
        // ====================KILOBYTE
        // ====================
        // to_factor = 0.001
        to_factor = KILOBYTE.getFactor();
        msg = "-1 * (1000000000 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), PETABYTE.toKilobytes(-1.0), delta);
        msg = "-0.1 * (1000000000 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), PETABYTE.toKilobytes(-0.1), delta);
        msg = "-0.000456789 * (1000000000 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), PETABYTE.toKilobytes(-4.56789E-4), delta);
        msg = "-73.25 * (1000000000 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), PETABYTE.toKilobytes(-73.25), delta);
        msg = "-56229.321 * (1000000000 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), PETABYTE.toKilobytes(-56229.321), delta);
        msg = "-873.5432456 * (1000000000 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), PETABYTE.toKilobytes(-873.5432456), delta);
        msg = "0 * (1000000000 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), PETABYTE.toKilobytes(0.0), delta);
        msg = "0.1 * (1000000000 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), PETABYTE.toKilobytes(0.1), delta);
        msg = "0.0000876543297 * (1000000000 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), PETABYTE.toKilobytes(8.76543297E-5), delta);
        msg = "0.33 * (1000000000 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), PETABYTE.toKilobytes(0.33), delta);
        msg = "0.6543 * (1000000000 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), PETABYTE.toKilobytes(0.6543), delta);
        msg = "1 * (1000000000 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), PETABYTE.toKilobytes(1.0), delta);
        msg = "1.6543 * (1000000000 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), PETABYTE.toKilobytes(1.6543), delta);
        msg = "22.45 * (1000000000 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), PETABYTE.toKilobytes(22.45), delta);
        msg = "9876.5432 * (1000000000 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), PETABYTE.toKilobytes(9876.5432), delta);
        msg = "1987654344.3345 * (1000000000 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), PETABYTE.toKilobytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000000 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), PETABYTE.toKilobytes(784.46789765434), delta);
        // ====================
        // ====================MEGABYTE
        // ====================
        // to_factor = 1.0
        to_factor = MEGABYTE.getFactor();
        msg = "-1 * (1000000000 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), PETABYTE.toMegabytes(-1.0), delta);
        msg = "-0.1 * (1000000000 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), PETABYTE.toMegabytes(-0.1), delta);
        msg = "-0.000456789 * (1000000000 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), PETABYTE.toMegabytes(-4.56789E-4), delta);
        msg = "-73.25 * (1000000000 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), PETABYTE.toMegabytes(-73.25), delta);
        msg = "-56229.321 * (1000000000 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), PETABYTE.toMegabytes(-56229.321), delta);
        msg = "-873.5432456 * (1000000000 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), PETABYTE.toMegabytes(-873.5432456), delta);
        msg = "0 * (1000000000 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), PETABYTE.toMegabytes(0.0), delta);
        msg = "0.1 * (1000000000 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), PETABYTE.toMegabytes(0.1), delta);
        msg = "0.0000876543297 * (1000000000 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), PETABYTE.toMegabytes(8.76543297E-5), delta);
        msg = "0.33 * (1000000000 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), PETABYTE.toMegabytes(0.33), delta);
        msg = "0.6543 * (1000000000 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), PETABYTE.toMegabytes(0.6543), delta);
        msg = "1 * (1000000000 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), PETABYTE.toMegabytes(1.0), delta);
        msg = "1.6543 * (1000000000 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), PETABYTE.toMegabytes(1.6543), delta);
        msg = "22.45 * (1000000000 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), PETABYTE.toMegabytes(22.45), delta);
        msg = "9876.5432 * (1000000000 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), PETABYTE.toMegabytes(9876.5432), delta);
        msg = "1987654344.3345 * (1000000000 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), PETABYTE.toMegabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000000 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), PETABYTE.toMegabytes(784.46789765434), delta);
        // ====================
        // ====================GIGABYTE
        // ====================
        // to_factor = 1000.0
        to_factor = GIGABYTE.getFactor();
        msg = "-1 * (1000000000 / 1000)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), PETABYTE.toGigabytes(-1.0), delta);
        msg = "-0.1 * (1000000000 / 1000)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), PETABYTE.toGigabytes(-0.1), delta);
        msg = "-0.000456789 * (1000000000 / 1000)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), PETABYTE.toGigabytes(-4.56789E-4), delta);
        msg = "-73.25 * (1000000000 / 1000)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), PETABYTE.toGigabytes(-73.25), delta);
        msg = "-56229.321 * (1000000000 / 1000)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), PETABYTE.toGigabytes(-56229.321), delta);
        msg = "-873.5432456 * (1000000000 / 1000)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), PETABYTE.toGigabytes(-873.5432456), delta);
        msg = "0 * (1000000000 / 1000)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), PETABYTE.toGigabytes(0.0), delta);
        msg = "0.1 * (1000000000 / 1000)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), PETABYTE.toGigabytes(0.1), delta);
        msg = "0.0000876543297 * (1000000000 / 1000)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), PETABYTE.toGigabytes(8.76543297E-5), delta);
        msg = "0.33 * (1000000000 / 1000)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), PETABYTE.toGigabytes(0.33), delta);
        msg = "0.6543 * (1000000000 / 1000)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), PETABYTE.toGigabytes(0.6543), delta);
        msg = "1 * (1000000000 / 1000)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), PETABYTE.toGigabytes(1.0), delta);
        msg = "1.6543 * (1000000000 / 1000)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), PETABYTE.toGigabytes(1.6543), delta);
        msg = "22.45 * (1000000000 / 1000)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), PETABYTE.toGigabytes(22.45), delta);
        msg = "9876.5432 * (1000000000 / 1000)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), PETABYTE.toGigabytes(9876.5432), delta);
        msg = "1987654344.3345 * (1000000000 / 1000)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), PETABYTE.toGigabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000000 / 1000)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), PETABYTE.toGigabytes(784.46789765434), delta);
        // ====================
        // ====================TERABYTE
        // ====================
        // to_factor = 1000000.0
        to_factor = TERABYTE.getFactor();
        msg = "-1 * (1000000000 / 1000000)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), PETABYTE.toTerabytes(-1.0), delta);
        msg = "-0.1 * (1000000000 / 1000000)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), PETABYTE.toTerabytes(-0.1), delta);
        msg = "-0.000456789 * (1000000000 / 1000000)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), PETABYTE.toTerabytes(-4.56789E-4), delta);
        msg = "-73.25 * (1000000000 / 1000000)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), PETABYTE.toTerabytes(-73.25), delta);
        msg = "-56229.321 * (1000000000 / 1000000)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), PETABYTE.toTerabytes(-56229.321), delta);
        msg = "-873.5432456 * (1000000000 / 1000000)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), PETABYTE.toTerabytes(-873.5432456), delta);
        msg = "0 * (1000000000 / 1000000)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), PETABYTE.toTerabytes(0.0), delta);
        msg = "0.1 * (1000000000 / 1000000)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), PETABYTE.toTerabytes(0.1), delta);
        msg = "0.0000876543297 * (1000000000 / 1000000)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), PETABYTE.toTerabytes(8.76543297E-5), delta);
        msg = "0.33 * (1000000000 / 1000000)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), PETABYTE.toTerabytes(0.33), delta);
        msg = "0.6543 * (1000000000 / 1000000)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), PETABYTE.toTerabytes(0.6543), delta);
        msg = "1 * (1000000000 / 1000000)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), PETABYTE.toTerabytes(1.0), delta);
        msg = "1.6543 * (1000000000 / 1000000)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), PETABYTE.toTerabytes(1.6543), delta);
        msg = "22.45 * (1000000000 / 1000000)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), PETABYTE.toTerabytes(22.45), delta);
        msg = "9876.5432 * (1000000000 / 1000000)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), PETABYTE.toTerabytes(9876.5432), delta);
        msg = "1987654344.3345 * (1000000000 / 1000000)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), PETABYTE.toTerabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000000 / 1000000)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), PETABYTE.toTerabytes(784.46789765434), delta);
        // ====================
        // ====================PETABYTE
        // ====================
        // to_factor = 1.0E9
        to_factor = PETABYTE.getFactor();
        msg = "-1 * (1000000000 / 1000000000)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), PETABYTE.toPetabytes(-1.0), delta);
        msg = "-0.1 * (1000000000 / 1000000000)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), PETABYTE.toPetabytes(-0.1), delta);
        msg = "-0.000456789 * (1000000000 / 1000000000)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), PETABYTE.toPetabytes(-4.56789E-4), delta);
        msg = "-73.25 * (1000000000 / 1000000000)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), PETABYTE.toPetabytes(-73.25), delta);
        msg = "-56229.321 * (1000000000 / 1000000000)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), PETABYTE.toPetabytes(-56229.321), delta);
        msg = "-873.5432456 * (1000000000 / 1000000000)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), PETABYTE.toPetabytes(-873.5432456), delta);
        msg = "0 * (1000000000 / 1000000000)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), PETABYTE.toPetabytes(0.0), delta);
        msg = "0.1 * (1000000000 / 1000000000)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), PETABYTE.toPetabytes(0.1), delta);
        msg = "0.0000876543297 * (1000000000 / 1000000000)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), PETABYTE.toPetabytes(8.76543297E-5), delta);
        msg = "0.33 * (1000000000 / 1000000000)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), PETABYTE.toPetabytes(0.33), delta);
        msg = "0.6543 * (1000000000 / 1000000000)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), PETABYTE.toPetabytes(0.6543), delta);
        msg = "1 * (1000000000 / 1000000000)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), PETABYTE.toPetabytes(1.0), delta);
        msg = "1.6543 * (1000000000 / 1000000000)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), PETABYTE.toPetabytes(1.6543), delta);
        msg = "22.45 * (1000000000 / 1000000000)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), PETABYTE.toPetabytes(22.45), delta);
        msg = "9876.5432 * (1000000000 / 1000000000)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), PETABYTE.toPetabytes(9876.5432), delta);
        msg = "1987654344.3345 * (1000000000 / 1000000000)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), PETABYTE.toPetabytes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000000 / 1000000000)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), PETABYTE.toPetabytes(784.46789765434), delta);
    }
}
