package codes.abdullah.measurement.system.digital;

import static codes.abdullah.measurement.system.digital.Digitals.BIT;
import static codes.abdullah.measurement.system.digital.Digitals.GIGABIT;
import static codes.abdullah.measurement.system.digital.Digitals.KILOBIT;
import static codes.abdullah.measurement.system.digital.Digitals.MEGABIT;
import static codes.abdullah.measurement.system.digital.Digitals.PETABIT;
import static codes.abdullah.measurement.system.digital.Digitals.TERABIT;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFixedDigitalBit {

    @Test()
    public void testBit() {
        // from_factor = 1.0E-6
        double from_factor = BIT.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================BIT
        // ====================
        // to_factor = 1.0E-6
        to_factor = BIT.getFactor();
        msg = "-1 * (0.000001 / 0.000001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), BIT.toBits(-1.0), delta);
        msg = "-0.1 * (0.000001 / 0.000001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), BIT.toBits(-0.1), delta);
        msg = "-0.000456789 * (0.000001 / 0.000001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), BIT.toBits(-4.56789E-4), delta);
        msg = "-73.25 * (0.000001 / 0.000001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), BIT.toBits(-73.25), delta);
        msg = "-56229.321 * (0.000001 / 0.000001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), BIT.toBits(-56229.321), delta);
        msg = "-873.5432456 * (0.000001 / 0.000001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), BIT.toBits(-873.5432456), delta);
        msg = "0 * (0.000001 / 0.000001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), BIT.toBits(0.0), delta);
        msg = "0.1 * (0.000001 / 0.000001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), BIT.toBits(0.1), delta);
        msg = "0.0000876543297 * (0.000001 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), BIT.toBits(8.76543297E-5), delta);
        msg = "0.33 * (0.000001 / 0.000001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), BIT.toBits(0.33), delta);
        msg = "0.6543 * (0.000001 / 0.000001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), BIT.toBits(0.6543), delta);
        msg = "1 * (0.000001 / 0.000001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), BIT.toBits(1.0), delta);
        msg = "1.6543 * (0.000001 / 0.000001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), BIT.toBits(1.6543), delta);
        msg = "22.45 * (0.000001 / 0.000001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), BIT.toBits(22.45), delta);
        msg = "9876.5432 * (0.000001 / 0.000001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), BIT.toBits(9876.5432), delta);
        msg = "1987654344.3345 * (0.000001 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), BIT.toBits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.000001 / 0.000001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), BIT.toBits(784.46789765434), delta);
        // ====================
        // ====================KILOBIT
        // ====================
        // to_factor = 0.001
        to_factor = KILOBIT.getFactor();
        msg = "-1 / (0.001 / 0.000001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), BIT.toKilobits(-1.0), delta);
        msg = "-0.1 / (0.001 / 0.000001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), BIT.toKilobits(-0.1), delta);
        msg = "-0.000456789 / (0.001 / 0.000001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), BIT.toKilobits(-4.56789E-4), delta);
        msg = "-73.25 / (0.001 / 0.000001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), BIT.toKilobits(-73.25), delta);
        msg = "-56229.321 / (0.001 / 0.000001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), BIT.toKilobits(-56229.321), delta);
        msg = "-873.5432456 / (0.001 / 0.000001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), BIT.toKilobits(-873.5432456), delta);
        msg = "0 / (0.001 / 0.000001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), BIT.toKilobits(0.0), delta);
        msg = "0.1 / (0.001 / 0.000001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), BIT.toKilobits(0.1), delta);
        msg = "0.0000876543297 / (0.001 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), BIT.toKilobits(8.76543297E-5), delta);
        msg = "0.33 / (0.001 / 0.000001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), BIT.toKilobits(0.33), delta);
        msg = "0.6543 / (0.001 / 0.000001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), BIT.toKilobits(0.6543), delta);
        msg = "1 / (0.001 / 0.000001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), BIT.toKilobits(1.0), delta);
        msg = "1.6543 / (0.001 / 0.000001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), BIT.toKilobits(1.6543), delta);
        msg = "22.45 / (0.001 / 0.000001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), BIT.toKilobits(22.45), delta);
        msg = "9876.5432 / (0.001 / 0.000001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), BIT.toKilobits(9876.5432), delta);
        msg = "1987654344.3345 / (0.001 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), BIT.toKilobits(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.001 / 0.000001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), BIT.toKilobits(784.46789765434), delta);
        // ====================
        // ====================MEGABIT
        // ====================
        // to_factor = 1.0
        to_factor = MEGABIT.getFactor();
        msg = "-1 / (1 / 0.000001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), BIT.toMegabits(-1.0), delta);
        msg = "-0.1 / (1 / 0.000001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), BIT.toMegabits(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.000001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), BIT.toMegabits(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.000001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), BIT.toMegabits(-73.25), delta);
        msg = "-56229.321 / (1 / 0.000001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), BIT.toMegabits(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.000001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), BIT.toMegabits(-873.5432456), delta);
        msg = "0 / (1 / 0.000001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), BIT.toMegabits(0.0), delta);
        msg = "0.1 / (1 / 0.000001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), BIT.toMegabits(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), BIT.toMegabits(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.000001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), BIT.toMegabits(0.33), delta);
        msg = "0.6543 / (1 / 0.000001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), BIT.toMegabits(0.6543), delta);
        msg = "1 / (1 / 0.000001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), BIT.toMegabits(1.0), delta);
        msg = "1.6543 / (1 / 0.000001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), BIT.toMegabits(1.6543), delta);
        msg = "22.45 / (1 / 0.000001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), BIT.toMegabits(22.45), delta);
        msg = "9876.5432 / (1 / 0.000001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), BIT.toMegabits(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), BIT.toMegabits(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.000001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), BIT.toMegabits(784.46789765434), delta);
        // ====================
        // ====================GIGABIT
        // ====================
        // to_factor = 1000.0
        to_factor = GIGABIT.getFactor();
        msg = "-1 / (1000 / 0.000001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), BIT.toGigabits(-1.0), delta);
        msg = "-0.1 / (1000 / 0.000001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), BIT.toGigabits(-0.1), delta);
        msg = "-0.000456789 / (1000 / 0.000001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), BIT.toGigabits(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 0.000001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), BIT.toGigabits(-73.25), delta);
        msg = "-56229.321 / (1000 / 0.000001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), BIT.toGigabits(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 0.000001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), BIT.toGigabits(-873.5432456), delta);
        msg = "0 / (1000 / 0.000001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), BIT.toGigabits(0.0), delta);
        msg = "0.1 / (1000 / 0.000001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), BIT.toGigabits(0.1), delta);
        msg = "0.0000876543297 / (1000 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), BIT.toGigabits(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 0.000001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), BIT.toGigabits(0.33), delta);
        msg = "0.6543 / (1000 / 0.000001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), BIT.toGigabits(0.6543), delta);
        msg = "1 / (1000 / 0.000001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), BIT.toGigabits(1.0), delta);
        msg = "1.6543 / (1000 / 0.000001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), BIT.toGigabits(1.6543), delta);
        msg = "22.45 / (1000 / 0.000001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), BIT.toGigabits(22.45), delta);
        msg = "9876.5432 / (1000 / 0.000001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), BIT.toGigabits(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), BIT.toGigabits(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 0.000001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), BIT.toGigabits(784.46789765434), delta);
        // ====================
        // ====================TERABIT
        // ====================
        // to_factor = 1000000.0
        to_factor = TERABIT.getFactor();
        msg = "-1 / (1000000 / 0.000001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), BIT.toTerabits(-1.0), delta);
        msg = "-0.1 / (1000000 / 0.000001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), BIT.toTerabits(-0.1), delta);
        msg = "-0.000456789 / (1000000 / 0.000001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), BIT.toTerabits(-4.56789E-4), delta);
        msg = "-73.25 / (1000000 / 0.000001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), BIT.toTerabits(-73.25), delta);
        msg = "-56229.321 / (1000000 / 0.000001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), BIT.toTerabits(-56229.321), delta);
        msg = "-873.5432456 / (1000000 / 0.000001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), BIT.toTerabits(-873.5432456), delta);
        msg = "0 / (1000000 / 0.000001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), BIT.toTerabits(0.0), delta);
        msg = "0.1 / (1000000 / 0.000001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), BIT.toTerabits(0.1), delta);
        msg = "0.0000876543297 / (1000000 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), BIT.toTerabits(8.76543297E-5), delta);
        msg = "0.33 / (1000000 / 0.000001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), BIT.toTerabits(0.33), delta);
        msg = "0.6543 / (1000000 / 0.000001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), BIT.toTerabits(0.6543), delta);
        msg = "1 / (1000000 / 0.000001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), BIT.toTerabits(1.0), delta);
        msg = "1.6543 / (1000000 / 0.000001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), BIT.toTerabits(1.6543), delta);
        msg = "22.45 / (1000000 / 0.000001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), BIT.toTerabits(22.45), delta);
        msg = "9876.5432 / (1000000 / 0.000001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), BIT.toTerabits(9876.5432), delta);
        msg = "1987654344.3345 / (1000000 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), BIT.toTerabits(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000000 / 0.000001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), BIT.toTerabits(784.46789765434), delta);
        // ====================
        // ====================PETABIT
        // ====================
        // to_factor = 1.0E9
        to_factor = PETABIT.getFactor();
        msg = "-1 / (1000000000 / 0.000001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), BIT.toPetabits(-1.0), delta);
        msg = "-0.1 / (1000000000 / 0.000001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), BIT.toPetabits(-0.1), delta);
        msg = "-0.000456789 / (1000000000 / 0.000001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), BIT.toPetabits(-4.56789E-4), delta);
        msg = "-73.25 / (1000000000 / 0.000001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), BIT.toPetabits(-73.25), delta);
        msg = "-56229.321 / (1000000000 / 0.000001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), BIT.toPetabits(-56229.321), delta);
        msg = "-873.5432456 / (1000000000 / 0.000001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), BIT.toPetabits(-873.5432456), delta);
        msg = "0 / (1000000000 / 0.000001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), BIT.toPetabits(0.0), delta);
        msg = "0.1 / (1000000000 / 0.000001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), BIT.toPetabits(0.1), delta);
        msg = "0.0000876543297 / (1000000000 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), BIT.toPetabits(8.76543297E-5), delta);
        msg = "0.33 / (1000000000 / 0.000001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), BIT.toPetabits(0.33), delta);
        msg = "0.6543 / (1000000000 / 0.000001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), BIT.toPetabits(0.6543), delta);
        msg = "1 / (1000000000 / 0.000001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), BIT.toPetabits(1.0), delta);
        msg = "1.6543 / (1000000000 / 0.000001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), BIT.toPetabits(1.6543), delta);
        msg = "22.45 / (1000000000 / 0.000001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), BIT.toPetabits(22.45), delta);
        msg = "9876.5432 / (1000000000 / 0.000001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), BIT.toPetabits(9876.5432), delta);
        msg = "1987654344.3345 / (1000000000 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), BIT.toPetabits(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000000000 / 0.000001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), BIT.toPetabits(784.46789765434), delta);
    }

    @Test()
    public void testKilobit() {
        // from_factor = 0.001
        double from_factor = KILOBIT.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================BIT
        // ====================
        // to_factor = 1.0E-6
        to_factor = BIT.getFactor();
        msg = "-1 * (0.001 / 0.000001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOBIT.toBits(-1.0), delta);
        msg = "-0.1 * (0.001 / 0.000001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOBIT.toBits(-0.1), delta);
        msg = "-0.000456789 * (0.001 / 0.000001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOBIT.toBits(-4.56789E-4), delta);
        msg = "-73.25 * (0.001 / 0.000001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOBIT.toBits(-73.25), delta);
        msg = "-56229.321 * (0.001 / 0.000001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOBIT.toBits(-56229.321), delta);
        msg = "-873.5432456 * (0.001 / 0.000001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOBIT.toBits(-873.5432456), delta);
        msg = "0 * (0.001 / 0.000001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOBIT.toBits(0.0), delta);
        msg = "0.1 * (0.001 / 0.000001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOBIT.toBits(0.1), delta);
        msg = "0.0000876543297 * (0.001 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOBIT.toBits(8.76543297E-5), delta);
        msg = "0.33 * (0.001 / 0.000001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOBIT.toBits(0.33), delta);
        msg = "0.6543 * (0.001 / 0.000001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOBIT.toBits(0.6543), delta);
        msg = "1 * (0.001 / 0.000001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOBIT.toBits(1.0), delta);
        msg = "1.6543 * (0.001 / 0.000001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOBIT.toBits(1.6543), delta);
        msg = "22.45 * (0.001 / 0.000001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOBIT.toBits(22.45), delta);
        msg = "9876.5432 * (0.001 / 0.000001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOBIT.toBits(9876.5432), delta);
        msg = "1987654344.3345 * (0.001 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOBIT.toBits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.001 / 0.000001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOBIT.toBits(784.46789765434), delta);
        // ====================
        // ====================KILOBIT
        // ====================
        // to_factor = 0.001
        to_factor = KILOBIT.getFactor();
        msg = "-1 * (0.001 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KILOBIT.toKilobits(-1.0), delta);
        msg = "-0.1 * (0.001 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KILOBIT.toKilobits(-0.1), delta);
        msg = "-0.000456789 * (0.001 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KILOBIT.toKilobits(-4.56789E-4), delta);
        msg = "-73.25 * (0.001 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KILOBIT.toKilobits(-73.25), delta);
        msg = "-56229.321 * (0.001 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KILOBIT.toKilobits(-56229.321), delta);
        msg = "-873.5432456 * (0.001 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KILOBIT.toKilobits(-873.5432456), delta);
        msg = "0 * (0.001 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KILOBIT.toKilobits(0.0), delta);
        msg = "0.1 * (0.001 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KILOBIT.toKilobits(0.1), delta);
        msg = "0.0000876543297 * (0.001 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KILOBIT.toKilobits(8.76543297E-5), delta);
        msg = "0.33 * (0.001 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KILOBIT.toKilobits(0.33), delta);
        msg = "0.6543 * (0.001 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KILOBIT.toKilobits(0.6543), delta);
        msg = "1 * (0.001 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KILOBIT.toKilobits(1.0), delta);
        msg = "1.6543 * (0.001 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KILOBIT.toKilobits(1.6543), delta);
        msg = "22.45 * (0.001 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KILOBIT.toKilobits(22.45), delta);
        msg = "9876.5432 * (0.001 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KILOBIT.toKilobits(9876.5432), delta);
        msg = "1987654344.3345 * (0.001 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KILOBIT.toKilobits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.001 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KILOBIT.toKilobits(784.46789765434), delta);
        // ====================
        // ====================MEGABIT
        // ====================
        // to_factor = 1.0
        to_factor = MEGABIT.getFactor();
        msg = "-1 / (1 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), KILOBIT.toMegabits(-1.0), delta);
        msg = "-0.1 / (1 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), KILOBIT.toMegabits(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), KILOBIT.toMegabits(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), KILOBIT.toMegabits(-73.25), delta);
        msg = "-56229.321 / (1 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), KILOBIT.toMegabits(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), KILOBIT.toMegabits(-873.5432456), delta);
        msg = "0 / (1 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), KILOBIT.toMegabits(0.0), delta);
        msg = "0.1 / (1 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), KILOBIT.toMegabits(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), KILOBIT.toMegabits(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), KILOBIT.toMegabits(0.33), delta);
        msg = "0.6543 / (1 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), KILOBIT.toMegabits(0.6543), delta);
        msg = "1 / (1 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), KILOBIT.toMegabits(1.0), delta);
        msg = "1.6543 / (1 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), KILOBIT.toMegabits(1.6543), delta);
        msg = "22.45 / (1 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), KILOBIT.toMegabits(22.45), delta);
        msg = "9876.5432 / (1 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), KILOBIT.toMegabits(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), KILOBIT.toMegabits(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), KILOBIT.toMegabits(784.46789765434), delta);
        // ====================
        // ====================GIGABIT
        // ====================
        // to_factor = 1000.0
        to_factor = GIGABIT.getFactor();
        msg = "-1 / (1000 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), KILOBIT.toGigabits(-1.0), delta);
        msg = "-0.1 / (1000 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), KILOBIT.toGigabits(-0.1), delta);
        msg = "-0.000456789 / (1000 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), KILOBIT.toGigabits(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), KILOBIT.toGigabits(-73.25), delta);
        msg = "-56229.321 / (1000 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), KILOBIT.toGigabits(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), KILOBIT.toGigabits(-873.5432456), delta);
        msg = "0 / (1000 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), KILOBIT.toGigabits(0.0), delta);
        msg = "0.1 / (1000 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), KILOBIT.toGigabits(0.1), delta);
        msg = "0.0000876543297 / (1000 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), KILOBIT.toGigabits(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), KILOBIT.toGigabits(0.33), delta);
        msg = "0.6543 / (1000 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), KILOBIT.toGigabits(0.6543), delta);
        msg = "1 / (1000 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), KILOBIT.toGigabits(1.0), delta);
        msg = "1.6543 / (1000 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), KILOBIT.toGigabits(1.6543), delta);
        msg = "22.45 / (1000 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), KILOBIT.toGigabits(22.45), delta);
        msg = "9876.5432 / (1000 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), KILOBIT.toGigabits(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), KILOBIT.toGigabits(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), KILOBIT.toGigabits(784.46789765434), delta);
        // ====================
        // ====================TERABIT
        // ====================
        // to_factor = 1000000.0
        to_factor = TERABIT.getFactor();
        msg = "-1 / (1000000 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), KILOBIT.toTerabits(-1.0), delta);
        msg = "-0.1 / (1000000 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), KILOBIT.toTerabits(-0.1), delta);
        msg = "-0.000456789 / (1000000 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), KILOBIT.toTerabits(-4.56789E-4), delta);
        msg = "-73.25 / (1000000 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), KILOBIT.toTerabits(-73.25), delta);
        msg = "-56229.321 / (1000000 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), KILOBIT.toTerabits(-56229.321), delta);
        msg = "-873.5432456 / (1000000 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), KILOBIT.toTerabits(-873.5432456), delta);
        msg = "0 / (1000000 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), KILOBIT.toTerabits(0.0), delta);
        msg = "0.1 / (1000000 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), KILOBIT.toTerabits(0.1), delta);
        msg = "0.0000876543297 / (1000000 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), KILOBIT.toTerabits(8.76543297E-5), delta);
        msg = "0.33 / (1000000 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), KILOBIT.toTerabits(0.33), delta);
        msg = "0.6543 / (1000000 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), KILOBIT.toTerabits(0.6543), delta);
        msg = "1 / (1000000 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), KILOBIT.toTerabits(1.0), delta);
        msg = "1.6543 / (1000000 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), KILOBIT.toTerabits(1.6543), delta);
        msg = "22.45 / (1000000 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), KILOBIT.toTerabits(22.45), delta);
        msg = "9876.5432 / (1000000 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), KILOBIT.toTerabits(9876.5432), delta);
        msg = "1987654344.3345 / (1000000 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), KILOBIT.toTerabits(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000000 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), KILOBIT.toTerabits(784.46789765434), delta);
        // ====================
        // ====================PETABIT
        // ====================
        // to_factor = 1.0E9
        to_factor = PETABIT.getFactor();
        msg = "-1 / (1000000000 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), KILOBIT.toPetabits(-1.0), delta);
        msg = "-0.1 / (1000000000 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), KILOBIT.toPetabits(-0.1), delta);
        msg = "-0.000456789 / (1000000000 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), KILOBIT.toPetabits(-4.56789E-4), delta);
        msg = "-73.25 / (1000000000 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), KILOBIT.toPetabits(-73.25), delta);
        msg = "-56229.321 / (1000000000 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), KILOBIT.toPetabits(-56229.321), delta);
        msg = "-873.5432456 / (1000000000 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), KILOBIT.toPetabits(-873.5432456), delta);
        msg = "0 / (1000000000 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), KILOBIT.toPetabits(0.0), delta);
        msg = "0.1 / (1000000000 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), KILOBIT.toPetabits(0.1), delta);
        msg = "0.0000876543297 / (1000000000 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), KILOBIT.toPetabits(8.76543297E-5), delta);
        msg = "0.33 / (1000000000 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), KILOBIT.toPetabits(0.33), delta);
        msg = "0.6543 / (1000000000 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), KILOBIT.toPetabits(0.6543), delta);
        msg = "1 / (1000000000 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), KILOBIT.toPetabits(1.0), delta);
        msg = "1.6543 / (1000000000 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), KILOBIT.toPetabits(1.6543), delta);
        msg = "22.45 / (1000000000 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), KILOBIT.toPetabits(22.45), delta);
        msg = "9876.5432 / (1000000000 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), KILOBIT.toPetabits(9876.5432), delta);
        msg = "1987654344.3345 / (1000000000 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), KILOBIT.toPetabits(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000000000 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), KILOBIT.toPetabits(784.46789765434), delta);
    }

    @Test()
    public void testMegabit() {
        // from_factor = 1.0
        double from_factor = MEGABIT.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================BIT
        // ====================
        // to_factor = 1.0E-6
        to_factor = BIT.getFactor();
        msg = "-1 * (1 / 0.000001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MEGABIT.toBits(-1.0), delta);
        msg = "-0.1 * (1 / 0.000001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MEGABIT.toBits(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.000001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MEGABIT.toBits(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.000001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MEGABIT.toBits(-73.25), delta);
        msg = "-56229.321 * (1 / 0.000001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MEGABIT.toBits(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.000001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MEGABIT.toBits(-873.5432456), delta);
        msg = "0 * (1 / 0.000001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MEGABIT.toBits(0.0), delta);
        msg = "0.1 * (1 / 0.000001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MEGABIT.toBits(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MEGABIT.toBits(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.000001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MEGABIT.toBits(0.33), delta);
        msg = "0.6543 * (1 / 0.000001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MEGABIT.toBits(0.6543), delta);
        msg = "1 * (1 / 0.000001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MEGABIT.toBits(1.0), delta);
        msg = "1.6543 * (1 / 0.000001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MEGABIT.toBits(1.6543), delta);
        msg = "22.45 * (1 / 0.000001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MEGABIT.toBits(22.45), delta);
        msg = "9876.5432 * (1 / 0.000001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MEGABIT.toBits(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MEGABIT.toBits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.000001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MEGABIT.toBits(784.46789765434), delta);
        // ====================
        // ====================KILOBIT
        // ====================
        // to_factor = 0.001
        to_factor = KILOBIT.getFactor();
        msg = "-1 * (1 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MEGABIT.toKilobits(-1.0), delta);
        msg = "-0.1 * (1 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MEGABIT.toKilobits(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MEGABIT.toKilobits(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MEGABIT.toKilobits(-73.25), delta);
        msg = "-56229.321 * (1 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MEGABIT.toKilobits(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MEGABIT.toKilobits(-873.5432456), delta);
        msg = "0 * (1 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MEGABIT.toKilobits(0.0), delta);
        msg = "0.1 * (1 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MEGABIT.toKilobits(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MEGABIT.toKilobits(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MEGABIT.toKilobits(0.33), delta);
        msg = "0.6543 * (1 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MEGABIT.toKilobits(0.6543), delta);
        msg = "1 * (1 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MEGABIT.toKilobits(1.0), delta);
        msg = "1.6543 * (1 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MEGABIT.toKilobits(1.6543), delta);
        msg = "22.45 * (1 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MEGABIT.toKilobits(22.45), delta);
        msg = "9876.5432 * (1 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MEGABIT.toKilobits(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MEGABIT.toKilobits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MEGABIT.toKilobits(784.46789765434), delta);
        // ====================
        // ====================MEGABIT
        // ====================
        // to_factor = 1.0
        to_factor = MEGABIT.getFactor();
        msg = "-1 * (1 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MEGABIT.toMegabits(-1.0), delta);
        msg = "-0.1 * (1 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MEGABIT.toMegabits(-0.1), delta);
        msg = "-0.000456789 * (1 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MEGABIT.toMegabits(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MEGABIT.toMegabits(-73.25), delta);
        msg = "-56229.321 * (1 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MEGABIT.toMegabits(-56229.321), delta);
        msg = "-873.5432456 * (1 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MEGABIT.toMegabits(-873.5432456), delta);
        msg = "0 * (1 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MEGABIT.toMegabits(0.0), delta);
        msg = "0.1 * (1 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MEGABIT.toMegabits(0.1), delta);
        msg = "0.0000876543297 * (1 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MEGABIT.toMegabits(8.76543297E-5), delta);
        msg = "0.33 * (1 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MEGABIT.toMegabits(0.33), delta);
        msg = "0.6543 * (1 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MEGABIT.toMegabits(0.6543), delta);
        msg = "1 * (1 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MEGABIT.toMegabits(1.0), delta);
        msg = "1.6543 * (1 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MEGABIT.toMegabits(1.6543), delta);
        msg = "22.45 * (1 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MEGABIT.toMegabits(22.45), delta);
        msg = "9876.5432 * (1 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MEGABIT.toMegabits(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MEGABIT.toMegabits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MEGABIT.toMegabits(784.46789765434), delta);
        // ====================
        // ====================GIGABIT
        // ====================
        // to_factor = 1000.0
        to_factor = GIGABIT.getFactor();
        msg = "-1 / (1000 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MEGABIT.toGigabits(-1.0), delta);
        msg = "-0.1 / (1000 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MEGABIT.toGigabits(-0.1), delta);
        msg = "-0.000456789 / (1000 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MEGABIT.toGigabits(-4.56789E-4), delta);
        msg = "-73.25 / (1000 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MEGABIT.toGigabits(-73.25), delta);
        msg = "-56229.321 / (1000 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MEGABIT.toGigabits(-56229.321), delta);
        msg = "-873.5432456 / (1000 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MEGABIT.toGigabits(-873.5432456), delta);
        msg = "0 / (1000 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MEGABIT.toGigabits(0.0), delta);
        msg = "0.1 / (1000 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MEGABIT.toGigabits(0.1), delta);
        msg = "0.0000876543297 / (1000 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MEGABIT.toGigabits(8.76543297E-5), delta);
        msg = "0.33 / (1000 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MEGABIT.toGigabits(0.33), delta);
        msg = "0.6543 / (1000 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MEGABIT.toGigabits(0.6543), delta);
        msg = "1 / (1000 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MEGABIT.toGigabits(1.0), delta);
        msg = "1.6543 / (1000 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MEGABIT.toGigabits(1.6543), delta);
        msg = "22.45 / (1000 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MEGABIT.toGigabits(22.45), delta);
        msg = "9876.5432 / (1000 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MEGABIT.toGigabits(9876.5432), delta);
        msg = "1987654344.3345 / (1000 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MEGABIT.toGigabits(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MEGABIT.toGigabits(784.46789765434), delta);
        // ====================
        // ====================TERABIT
        // ====================
        // to_factor = 1000000.0
        to_factor = TERABIT.getFactor();
        msg = "-1 / (1000000 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MEGABIT.toTerabits(-1.0), delta);
        msg = "-0.1 / (1000000 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MEGABIT.toTerabits(-0.1), delta);
        msg = "-0.000456789 / (1000000 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MEGABIT.toTerabits(-4.56789E-4), delta);
        msg = "-73.25 / (1000000 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MEGABIT.toTerabits(-73.25), delta);
        msg = "-56229.321 / (1000000 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MEGABIT.toTerabits(-56229.321), delta);
        msg = "-873.5432456 / (1000000 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MEGABIT.toTerabits(-873.5432456), delta);
        msg = "0 / (1000000 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MEGABIT.toTerabits(0.0), delta);
        msg = "0.1 / (1000000 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MEGABIT.toTerabits(0.1), delta);
        msg = "0.0000876543297 / (1000000 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MEGABIT.toTerabits(8.76543297E-5), delta);
        msg = "0.33 / (1000000 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MEGABIT.toTerabits(0.33), delta);
        msg = "0.6543 / (1000000 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MEGABIT.toTerabits(0.6543), delta);
        msg = "1 / (1000000 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MEGABIT.toTerabits(1.0), delta);
        msg = "1.6543 / (1000000 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MEGABIT.toTerabits(1.6543), delta);
        msg = "22.45 / (1000000 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MEGABIT.toTerabits(22.45), delta);
        msg = "9876.5432 / (1000000 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MEGABIT.toTerabits(9876.5432), delta);
        msg = "1987654344.3345 / (1000000 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MEGABIT.toTerabits(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000000 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MEGABIT.toTerabits(784.46789765434), delta);
        // ====================
        // ====================PETABIT
        // ====================
        // to_factor = 1.0E9
        to_factor = PETABIT.getFactor();
        msg = "-1 / (1000000000 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MEGABIT.toPetabits(-1.0), delta);
        msg = "-0.1 / (1000000000 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MEGABIT.toPetabits(-0.1), delta);
        msg = "-0.000456789 / (1000000000 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MEGABIT.toPetabits(-4.56789E-4), delta);
        msg = "-73.25 / (1000000000 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MEGABIT.toPetabits(-73.25), delta);
        msg = "-56229.321 / (1000000000 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MEGABIT.toPetabits(-56229.321), delta);
        msg = "-873.5432456 / (1000000000 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MEGABIT.toPetabits(-873.5432456), delta);
        msg = "0 / (1000000000 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MEGABIT.toPetabits(0.0), delta);
        msg = "0.1 / (1000000000 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MEGABIT.toPetabits(0.1), delta);
        msg = "0.0000876543297 / (1000000000 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MEGABIT.toPetabits(8.76543297E-5), delta);
        msg = "0.33 / (1000000000 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MEGABIT.toPetabits(0.33), delta);
        msg = "0.6543 / (1000000000 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MEGABIT.toPetabits(0.6543), delta);
        msg = "1 / (1000000000 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MEGABIT.toPetabits(1.0), delta);
        msg = "1.6543 / (1000000000 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MEGABIT.toPetabits(1.6543), delta);
        msg = "22.45 / (1000000000 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MEGABIT.toPetabits(22.45), delta);
        msg = "9876.5432 / (1000000000 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MEGABIT.toPetabits(9876.5432), delta);
        msg = "1987654344.3345 / (1000000000 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MEGABIT.toPetabits(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000000000 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MEGABIT.toPetabits(784.46789765434), delta);
    }

    @Test()
    public void testGigabit() {
        // from_factor = 1000.0
        double from_factor = GIGABIT.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================BIT
        // ====================
        // to_factor = 1.0E-6
        to_factor = BIT.getFactor();
        msg = "-1 * (1000 / 0.000001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GIGABIT.toBits(-1.0), delta);
        msg = "-0.1 * (1000 / 0.000001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GIGABIT.toBits(-0.1), delta);
        msg = "-0.000456789 * (1000 / 0.000001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GIGABIT.toBits(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 0.000001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GIGABIT.toBits(-73.25), delta);
        msg = "-56229.321 * (1000 / 0.000001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GIGABIT.toBits(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 0.000001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GIGABIT.toBits(-873.5432456), delta);
        msg = "0 * (1000 / 0.000001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GIGABIT.toBits(0.0), delta);
        msg = "0.1 * (1000 / 0.000001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GIGABIT.toBits(0.1), delta);
        msg = "0.0000876543297 * (1000 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GIGABIT.toBits(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 0.000001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GIGABIT.toBits(0.33), delta);
        msg = "0.6543 * (1000 / 0.000001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GIGABIT.toBits(0.6543), delta);
        msg = "1 * (1000 / 0.000001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GIGABIT.toBits(1.0), delta);
        msg = "1.6543 * (1000 / 0.000001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GIGABIT.toBits(1.6543), delta);
        msg = "22.45 * (1000 / 0.000001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GIGABIT.toBits(22.45), delta);
        msg = "9876.5432 * (1000 / 0.000001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GIGABIT.toBits(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GIGABIT.toBits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 0.000001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GIGABIT.toBits(784.46789765434), delta);
        // ====================
        // ====================KILOBIT
        // ====================
        // to_factor = 0.001
        to_factor = KILOBIT.getFactor();
        msg = "-1 * (1000 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GIGABIT.toKilobits(-1.0), delta);
        msg = "-0.1 * (1000 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GIGABIT.toKilobits(-0.1), delta);
        msg = "-0.000456789 * (1000 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GIGABIT.toKilobits(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GIGABIT.toKilobits(-73.25), delta);
        msg = "-56229.321 * (1000 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GIGABIT.toKilobits(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GIGABIT.toKilobits(-873.5432456), delta);
        msg = "0 * (1000 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GIGABIT.toKilobits(0.0), delta);
        msg = "0.1 * (1000 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GIGABIT.toKilobits(0.1), delta);
        msg = "0.0000876543297 * (1000 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GIGABIT.toKilobits(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GIGABIT.toKilobits(0.33), delta);
        msg = "0.6543 * (1000 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GIGABIT.toKilobits(0.6543), delta);
        msg = "1 * (1000 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GIGABIT.toKilobits(1.0), delta);
        msg = "1.6543 * (1000 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GIGABIT.toKilobits(1.6543), delta);
        msg = "22.45 * (1000 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GIGABIT.toKilobits(22.45), delta);
        msg = "9876.5432 * (1000 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GIGABIT.toKilobits(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GIGABIT.toKilobits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GIGABIT.toKilobits(784.46789765434), delta);
        // ====================
        // ====================MEGABIT
        // ====================
        // to_factor = 1.0
        to_factor = MEGABIT.getFactor();
        msg = "-1 * (1000 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GIGABIT.toMegabits(-1.0), delta);
        msg = "-0.1 * (1000 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GIGABIT.toMegabits(-0.1), delta);
        msg = "-0.000456789 * (1000 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GIGABIT.toMegabits(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GIGABIT.toMegabits(-73.25), delta);
        msg = "-56229.321 * (1000 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GIGABIT.toMegabits(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GIGABIT.toMegabits(-873.5432456), delta);
        msg = "0 * (1000 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GIGABIT.toMegabits(0.0), delta);
        msg = "0.1 * (1000 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GIGABIT.toMegabits(0.1), delta);
        msg = "0.0000876543297 * (1000 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GIGABIT.toMegabits(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GIGABIT.toMegabits(0.33), delta);
        msg = "0.6543 * (1000 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GIGABIT.toMegabits(0.6543), delta);
        msg = "1 * (1000 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GIGABIT.toMegabits(1.0), delta);
        msg = "1.6543 * (1000 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GIGABIT.toMegabits(1.6543), delta);
        msg = "22.45 * (1000 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GIGABIT.toMegabits(22.45), delta);
        msg = "9876.5432 * (1000 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GIGABIT.toMegabits(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GIGABIT.toMegabits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GIGABIT.toMegabits(784.46789765434), delta);
        // ====================
        // ====================GIGABIT
        // ====================
        // to_factor = 1000.0
        to_factor = GIGABIT.getFactor();
        msg = "-1 * (1000 / 1000)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GIGABIT.toGigabits(-1.0), delta);
        msg = "-0.1 * (1000 / 1000)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GIGABIT.toGigabits(-0.1), delta);
        msg = "-0.000456789 * (1000 / 1000)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GIGABIT.toGigabits(-4.56789E-4), delta);
        msg = "-73.25 * (1000 / 1000)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GIGABIT.toGigabits(-73.25), delta);
        msg = "-56229.321 * (1000 / 1000)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GIGABIT.toGigabits(-56229.321), delta);
        msg = "-873.5432456 * (1000 / 1000)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GIGABIT.toGigabits(-873.5432456), delta);
        msg = "0 * (1000 / 1000)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GIGABIT.toGigabits(0.0), delta);
        msg = "0.1 * (1000 / 1000)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GIGABIT.toGigabits(0.1), delta);
        msg = "0.0000876543297 * (1000 / 1000)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GIGABIT.toGigabits(8.76543297E-5), delta);
        msg = "0.33 * (1000 / 1000)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GIGABIT.toGigabits(0.33), delta);
        msg = "0.6543 * (1000 / 1000)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GIGABIT.toGigabits(0.6543), delta);
        msg = "1 * (1000 / 1000)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GIGABIT.toGigabits(1.0), delta);
        msg = "1.6543 * (1000 / 1000)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GIGABIT.toGigabits(1.6543), delta);
        msg = "22.45 * (1000 / 1000)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GIGABIT.toGigabits(22.45), delta);
        msg = "9876.5432 * (1000 / 1000)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GIGABIT.toGigabits(9876.5432), delta);
        msg = "1987654344.3345 * (1000 / 1000)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GIGABIT.toGigabits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000 / 1000)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GIGABIT.toGigabits(784.46789765434), delta);
        // ====================
        // ====================TERABIT
        // ====================
        // to_factor = 1000000.0
        to_factor = TERABIT.getFactor();
        msg = "-1 / (1000000 / 1000)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GIGABIT.toTerabits(-1.0), delta);
        msg = "-0.1 / (1000000 / 1000)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GIGABIT.toTerabits(-0.1), delta);
        msg = "-0.000456789 / (1000000 / 1000)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GIGABIT.toTerabits(-4.56789E-4), delta);
        msg = "-73.25 / (1000000 / 1000)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GIGABIT.toTerabits(-73.25), delta);
        msg = "-56229.321 / (1000000 / 1000)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GIGABIT.toTerabits(-56229.321), delta);
        msg = "-873.5432456 / (1000000 / 1000)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GIGABIT.toTerabits(-873.5432456), delta);
        msg = "0 / (1000000 / 1000)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GIGABIT.toTerabits(0.0), delta);
        msg = "0.1 / (1000000 / 1000)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GIGABIT.toTerabits(0.1), delta);
        msg = "0.0000876543297 / (1000000 / 1000)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GIGABIT.toTerabits(8.76543297E-5), delta);
        msg = "0.33 / (1000000 / 1000)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GIGABIT.toTerabits(0.33), delta);
        msg = "0.6543 / (1000000 / 1000)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GIGABIT.toTerabits(0.6543), delta);
        msg = "1 / (1000000 / 1000)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GIGABIT.toTerabits(1.0), delta);
        msg = "1.6543 / (1000000 / 1000)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GIGABIT.toTerabits(1.6543), delta);
        msg = "22.45 / (1000000 / 1000)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GIGABIT.toTerabits(22.45), delta);
        msg = "9876.5432 / (1000000 / 1000)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GIGABIT.toTerabits(9876.5432), delta);
        msg = "1987654344.3345 / (1000000 / 1000)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GIGABIT.toTerabits(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000000 / 1000)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GIGABIT.toTerabits(784.46789765434), delta);
        // ====================
        // ====================PETABIT
        // ====================
        // to_factor = 1.0E9
        to_factor = PETABIT.getFactor();
        msg = "-1 / (1000000000 / 1000)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GIGABIT.toPetabits(-1.0), delta);
        msg = "-0.1 / (1000000000 / 1000)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GIGABIT.toPetabits(-0.1), delta);
        msg = "-0.000456789 / (1000000000 / 1000)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GIGABIT.toPetabits(-4.56789E-4), delta);
        msg = "-73.25 / (1000000000 / 1000)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GIGABIT.toPetabits(-73.25), delta);
        msg = "-56229.321 / (1000000000 / 1000)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GIGABIT.toPetabits(-56229.321), delta);
        msg = "-873.5432456 / (1000000000 / 1000)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GIGABIT.toPetabits(-873.5432456), delta);
        msg = "0 / (1000000000 / 1000)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GIGABIT.toPetabits(0.0), delta);
        msg = "0.1 / (1000000000 / 1000)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GIGABIT.toPetabits(0.1), delta);
        msg = "0.0000876543297 / (1000000000 / 1000)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GIGABIT.toPetabits(8.76543297E-5), delta);
        msg = "0.33 / (1000000000 / 1000)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GIGABIT.toPetabits(0.33), delta);
        msg = "0.6543 / (1000000000 / 1000)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GIGABIT.toPetabits(0.6543), delta);
        msg = "1 / (1000000000 / 1000)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GIGABIT.toPetabits(1.0), delta);
        msg = "1.6543 / (1000000000 / 1000)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GIGABIT.toPetabits(1.6543), delta);
        msg = "22.45 / (1000000000 / 1000)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GIGABIT.toPetabits(22.45), delta);
        msg = "9876.5432 / (1000000000 / 1000)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GIGABIT.toPetabits(9876.5432), delta);
        msg = "1987654344.3345 / (1000000000 / 1000)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GIGABIT.toPetabits(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000000000 / 1000)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GIGABIT.toPetabits(784.46789765434), delta);
    }

    @Test()
    public void testTerabit() {
        // from_factor = 1000000.0
        double from_factor = TERABIT.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================BIT
        // ====================
        // to_factor = 1.0E-6
        to_factor = BIT.getFactor();
        msg = "-1 * (1000000 / 0.000001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TERABIT.toBits(-1.0), delta);
        msg = "-0.1 * (1000000 / 0.000001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TERABIT.toBits(-0.1), delta);
        msg = "-0.000456789 * (1000000 / 0.000001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TERABIT.toBits(-4.56789E-4), delta);
        msg = "-73.25 * (1000000 / 0.000001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TERABIT.toBits(-73.25), delta);
        msg = "-56229.321 * (1000000 / 0.000001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TERABIT.toBits(-56229.321), delta);
        msg = "-873.5432456 * (1000000 / 0.000001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TERABIT.toBits(-873.5432456), delta);
        msg = "0 * (1000000 / 0.000001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TERABIT.toBits(0.0), delta);
        msg = "0.1 * (1000000 / 0.000001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TERABIT.toBits(0.1), delta);
        msg = "0.0000876543297 * (1000000 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TERABIT.toBits(8.76543297E-5), delta);
        msg = "0.33 * (1000000 / 0.000001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TERABIT.toBits(0.33), delta);
        msg = "0.6543 * (1000000 / 0.000001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TERABIT.toBits(0.6543), delta);
        msg = "1 * (1000000 / 0.000001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TERABIT.toBits(1.0), delta);
        msg = "1.6543 * (1000000 / 0.000001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TERABIT.toBits(1.6543), delta);
        msg = "22.45 * (1000000 / 0.000001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TERABIT.toBits(22.45), delta);
        msg = "9876.5432 * (1000000 / 0.000001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TERABIT.toBits(9876.5432), delta);
        msg = "1987654344.3345 * (1000000 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TERABIT.toBits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000 / 0.000001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TERABIT.toBits(784.46789765434), delta);
        // ====================
        // ====================KILOBIT
        // ====================
        // to_factor = 0.001
        to_factor = KILOBIT.getFactor();
        msg = "-1 * (1000000 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TERABIT.toKilobits(-1.0), delta);
        msg = "-0.1 * (1000000 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TERABIT.toKilobits(-0.1), delta);
        msg = "-0.000456789 * (1000000 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TERABIT.toKilobits(-4.56789E-4), delta);
        msg = "-73.25 * (1000000 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TERABIT.toKilobits(-73.25), delta);
        msg = "-56229.321 * (1000000 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TERABIT.toKilobits(-56229.321), delta);
        msg = "-873.5432456 * (1000000 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TERABIT.toKilobits(-873.5432456), delta);
        msg = "0 * (1000000 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TERABIT.toKilobits(0.0), delta);
        msg = "0.1 * (1000000 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TERABIT.toKilobits(0.1), delta);
        msg = "0.0000876543297 * (1000000 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TERABIT.toKilobits(8.76543297E-5), delta);
        msg = "0.33 * (1000000 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TERABIT.toKilobits(0.33), delta);
        msg = "0.6543 * (1000000 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TERABIT.toKilobits(0.6543), delta);
        msg = "1 * (1000000 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TERABIT.toKilobits(1.0), delta);
        msg = "1.6543 * (1000000 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TERABIT.toKilobits(1.6543), delta);
        msg = "22.45 * (1000000 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TERABIT.toKilobits(22.45), delta);
        msg = "9876.5432 * (1000000 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TERABIT.toKilobits(9876.5432), delta);
        msg = "1987654344.3345 * (1000000 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TERABIT.toKilobits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TERABIT.toKilobits(784.46789765434), delta);
        // ====================
        // ====================MEGABIT
        // ====================
        // to_factor = 1.0
        to_factor = MEGABIT.getFactor();
        msg = "-1 * (1000000 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TERABIT.toMegabits(-1.0), delta);
        msg = "-0.1 * (1000000 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TERABIT.toMegabits(-0.1), delta);
        msg = "-0.000456789 * (1000000 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TERABIT.toMegabits(-4.56789E-4), delta);
        msg = "-73.25 * (1000000 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TERABIT.toMegabits(-73.25), delta);
        msg = "-56229.321 * (1000000 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TERABIT.toMegabits(-56229.321), delta);
        msg = "-873.5432456 * (1000000 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TERABIT.toMegabits(-873.5432456), delta);
        msg = "0 * (1000000 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TERABIT.toMegabits(0.0), delta);
        msg = "0.1 * (1000000 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TERABIT.toMegabits(0.1), delta);
        msg = "0.0000876543297 * (1000000 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TERABIT.toMegabits(8.76543297E-5), delta);
        msg = "0.33 * (1000000 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TERABIT.toMegabits(0.33), delta);
        msg = "0.6543 * (1000000 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TERABIT.toMegabits(0.6543), delta);
        msg = "1 * (1000000 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TERABIT.toMegabits(1.0), delta);
        msg = "1.6543 * (1000000 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TERABIT.toMegabits(1.6543), delta);
        msg = "22.45 * (1000000 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TERABIT.toMegabits(22.45), delta);
        msg = "9876.5432 * (1000000 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TERABIT.toMegabits(9876.5432), delta);
        msg = "1987654344.3345 * (1000000 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TERABIT.toMegabits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TERABIT.toMegabits(784.46789765434), delta);
        // ====================
        // ====================GIGABIT
        // ====================
        // to_factor = 1000.0
        to_factor = GIGABIT.getFactor();
        msg = "-1 * (1000000 / 1000)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TERABIT.toGigabits(-1.0), delta);
        msg = "-0.1 * (1000000 / 1000)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TERABIT.toGigabits(-0.1), delta);
        msg = "-0.000456789 * (1000000 / 1000)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TERABIT.toGigabits(-4.56789E-4), delta);
        msg = "-73.25 * (1000000 / 1000)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TERABIT.toGigabits(-73.25), delta);
        msg = "-56229.321 * (1000000 / 1000)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TERABIT.toGigabits(-56229.321), delta);
        msg = "-873.5432456 * (1000000 / 1000)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TERABIT.toGigabits(-873.5432456), delta);
        msg = "0 * (1000000 / 1000)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TERABIT.toGigabits(0.0), delta);
        msg = "0.1 * (1000000 / 1000)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TERABIT.toGigabits(0.1), delta);
        msg = "0.0000876543297 * (1000000 / 1000)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TERABIT.toGigabits(8.76543297E-5), delta);
        msg = "0.33 * (1000000 / 1000)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TERABIT.toGigabits(0.33), delta);
        msg = "0.6543 * (1000000 / 1000)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TERABIT.toGigabits(0.6543), delta);
        msg = "1 * (1000000 / 1000)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TERABIT.toGigabits(1.0), delta);
        msg = "1.6543 * (1000000 / 1000)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TERABIT.toGigabits(1.6543), delta);
        msg = "22.45 * (1000000 / 1000)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TERABIT.toGigabits(22.45), delta);
        msg = "9876.5432 * (1000000 / 1000)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TERABIT.toGigabits(9876.5432), delta);
        msg = "1987654344.3345 * (1000000 / 1000)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TERABIT.toGigabits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000 / 1000)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TERABIT.toGigabits(784.46789765434), delta);
        // ====================
        // ====================TERABIT
        // ====================
        // to_factor = 1000000.0
        to_factor = TERABIT.getFactor();
        msg = "-1 * (1000000 / 1000000)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TERABIT.toTerabits(-1.0), delta);
        msg = "-0.1 * (1000000 / 1000000)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TERABIT.toTerabits(-0.1), delta);
        msg = "-0.000456789 * (1000000 / 1000000)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TERABIT.toTerabits(-4.56789E-4), delta);
        msg = "-73.25 * (1000000 / 1000000)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TERABIT.toTerabits(-73.25), delta);
        msg = "-56229.321 * (1000000 / 1000000)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TERABIT.toTerabits(-56229.321), delta);
        msg = "-873.5432456 * (1000000 / 1000000)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TERABIT.toTerabits(-873.5432456), delta);
        msg = "0 * (1000000 / 1000000)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TERABIT.toTerabits(0.0), delta);
        msg = "0.1 * (1000000 / 1000000)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TERABIT.toTerabits(0.1), delta);
        msg = "0.0000876543297 * (1000000 / 1000000)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TERABIT.toTerabits(8.76543297E-5), delta);
        msg = "0.33 * (1000000 / 1000000)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TERABIT.toTerabits(0.33), delta);
        msg = "0.6543 * (1000000 / 1000000)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TERABIT.toTerabits(0.6543), delta);
        msg = "1 * (1000000 / 1000000)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TERABIT.toTerabits(1.0), delta);
        msg = "1.6543 * (1000000 / 1000000)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TERABIT.toTerabits(1.6543), delta);
        msg = "22.45 * (1000000 / 1000000)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TERABIT.toTerabits(22.45), delta);
        msg = "9876.5432 * (1000000 / 1000000)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TERABIT.toTerabits(9876.5432), delta);
        msg = "1987654344.3345 * (1000000 / 1000000)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TERABIT.toTerabits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000 / 1000000)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TERABIT.toTerabits(784.46789765434), delta);
        // ====================
        // ====================PETABIT
        // ====================
        // to_factor = 1.0E9
        to_factor = PETABIT.getFactor();
        msg = "-1 / (1000000000 / 1000000)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), TERABIT.toPetabits(-1.0), delta);
        msg = "-0.1 / (1000000000 / 1000000)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), TERABIT.toPetabits(-0.1), delta);
        msg = "-0.000456789 / (1000000000 / 1000000)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), TERABIT.toPetabits(-4.56789E-4), delta);
        msg = "-73.25 / (1000000000 / 1000000)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), TERABIT.toPetabits(-73.25), delta);
        msg = "-56229.321 / (1000000000 / 1000000)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), TERABIT.toPetabits(-56229.321), delta);
        msg = "-873.5432456 / (1000000000 / 1000000)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), TERABIT.toPetabits(-873.5432456), delta);
        msg = "0 / (1000000000 / 1000000)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), TERABIT.toPetabits(0.0), delta);
        msg = "0.1 / (1000000000 / 1000000)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), TERABIT.toPetabits(0.1), delta);
        msg = "0.0000876543297 / (1000000000 / 1000000)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), TERABIT.toPetabits(8.76543297E-5), delta);
        msg = "0.33 / (1000000000 / 1000000)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), TERABIT.toPetabits(0.33), delta);
        msg = "0.6543 / (1000000000 / 1000000)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), TERABIT.toPetabits(0.6543), delta);
        msg = "1 / (1000000000 / 1000000)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), TERABIT.toPetabits(1.0), delta);
        msg = "1.6543 / (1000000000 / 1000000)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), TERABIT.toPetabits(1.6543), delta);
        msg = "22.45 / (1000000000 / 1000000)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), TERABIT.toPetabits(22.45), delta);
        msg = "9876.5432 / (1000000000 / 1000000)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), TERABIT.toPetabits(9876.5432), delta);
        msg = "1987654344.3345 / (1000000000 / 1000000)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), TERABIT.toPetabits(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1000000000 / 1000000)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), TERABIT.toPetabits(784.46789765434), delta);
    }

    @Test()
    public void testPetabit() {
        // from_factor = 1.0E9
        double from_factor = PETABIT.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================BIT
        // ====================
        // to_factor = 1.0E-6
        to_factor = BIT.getFactor();
        msg = "-1 * (1000000000 / 0.000001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), PETABIT.toBits(-1.0), delta);
        msg = "-0.1 * (1000000000 / 0.000001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), PETABIT.toBits(-0.1), delta);
        msg = "-0.000456789 * (1000000000 / 0.000001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), PETABIT.toBits(-4.56789E-4), delta);
        msg = "-73.25 * (1000000000 / 0.000001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), PETABIT.toBits(-73.25), delta);
        msg = "-56229.321 * (1000000000 / 0.000001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), PETABIT.toBits(-56229.321), delta);
        msg = "-873.5432456 * (1000000000 / 0.000001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), PETABIT.toBits(-873.5432456), delta);
        msg = "0 * (1000000000 / 0.000001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), PETABIT.toBits(0.0), delta);
        msg = "0.1 * (1000000000 / 0.000001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), PETABIT.toBits(0.1), delta);
        msg = "0.0000876543297 * (1000000000 / 0.000001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), PETABIT.toBits(8.76543297E-5), delta);
        msg = "0.33 * (1000000000 / 0.000001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), PETABIT.toBits(0.33), delta);
        msg = "0.6543 * (1000000000 / 0.000001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), PETABIT.toBits(0.6543), delta);
        msg = "1 * (1000000000 / 0.000001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), PETABIT.toBits(1.0), delta);
        msg = "1.6543 * (1000000000 / 0.000001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), PETABIT.toBits(1.6543), delta);
        msg = "22.45 * (1000000000 / 0.000001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), PETABIT.toBits(22.45), delta);
        msg = "9876.5432 * (1000000000 / 0.000001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), PETABIT.toBits(9876.5432), delta);
        msg = "1987654344.3345 * (1000000000 / 0.000001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), PETABIT.toBits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000000 / 0.000001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), PETABIT.toBits(784.46789765434), delta);
        // ====================
        // ====================KILOBIT
        // ====================
        // to_factor = 0.001
        to_factor = KILOBIT.getFactor();
        msg = "-1 * (1000000000 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), PETABIT.toKilobits(-1.0), delta);
        msg = "-0.1 * (1000000000 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), PETABIT.toKilobits(-0.1), delta);
        msg = "-0.000456789 * (1000000000 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), PETABIT.toKilobits(-4.56789E-4), delta);
        msg = "-73.25 * (1000000000 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), PETABIT.toKilobits(-73.25), delta);
        msg = "-56229.321 * (1000000000 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), PETABIT.toKilobits(-56229.321), delta);
        msg = "-873.5432456 * (1000000000 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), PETABIT.toKilobits(-873.5432456), delta);
        msg = "0 * (1000000000 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), PETABIT.toKilobits(0.0), delta);
        msg = "0.1 * (1000000000 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), PETABIT.toKilobits(0.1), delta);
        msg = "0.0000876543297 * (1000000000 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), PETABIT.toKilobits(8.76543297E-5), delta);
        msg = "0.33 * (1000000000 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), PETABIT.toKilobits(0.33), delta);
        msg = "0.6543 * (1000000000 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), PETABIT.toKilobits(0.6543), delta);
        msg = "1 * (1000000000 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), PETABIT.toKilobits(1.0), delta);
        msg = "1.6543 * (1000000000 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), PETABIT.toKilobits(1.6543), delta);
        msg = "22.45 * (1000000000 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), PETABIT.toKilobits(22.45), delta);
        msg = "9876.5432 * (1000000000 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), PETABIT.toKilobits(9876.5432), delta);
        msg = "1987654344.3345 * (1000000000 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), PETABIT.toKilobits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000000 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), PETABIT.toKilobits(784.46789765434), delta);
        // ====================
        // ====================MEGABIT
        // ====================
        // to_factor = 1.0
        to_factor = MEGABIT.getFactor();
        msg = "-1 * (1000000000 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), PETABIT.toMegabits(-1.0), delta);
        msg = "-0.1 * (1000000000 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), PETABIT.toMegabits(-0.1), delta);
        msg = "-0.000456789 * (1000000000 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), PETABIT.toMegabits(-4.56789E-4), delta);
        msg = "-73.25 * (1000000000 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), PETABIT.toMegabits(-73.25), delta);
        msg = "-56229.321 * (1000000000 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), PETABIT.toMegabits(-56229.321), delta);
        msg = "-873.5432456 * (1000000000 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), PETABIT.toMegabits(-873.5432456), delta);
        msg = "0 * (1000000000 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), PETABIT.toMegabits(0.0), delta);
        msg = "0.1 * (1000000000 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), PETABIT.toMegabits(0.1), delta);
        msg = "0.0000876543297 * (1000000000 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), PETABIT.toMegabits(8.76543297E-5), delta);
        msg = "0.33 * (1000000000 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), PETABIT.toMegabits(0.33), delta);
        msg = "0.6543 * (1000000000 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), PETABIT.toMegabits(0.6543), delta);
        msg = "1 * (1000000000 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), PETABIT.toMegabits(1.0), delta);
        msg = "1.6543 * (1000000000 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), PETABIT.toMegabits(1.6543), delta);
        msg = "22.45 * (1000000000 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), PETABIT.toMegabits(22.45), delta);
        msg = "9876.5432 * (1000000000 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), PETABIT.toMegabits(9876.5432), delta);
        msg = "1987654344.3345 * (1000000000 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), PETABIT.toMegabits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000000 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), PETABIT.toMegabits(784.46789765434), delta);
        // ====================
        // ====================GIGABIT
        // ====================
        // to_factor = 1000.0
        to_factor = GIGABIT.getFactor();
        msg = "-1 * (1000000000 / 1000)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), PETABIT.toGigabits(-1.0), delta);
        msg = "-0.1 * (1000000000 / 1000)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), PETABIT.toGigabits(-0.1), delta);
        msg = "-0.000456789 * (1000000000 / 1000)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), PETABIT.toGigabits(-4.56789E-4), delta);
        msg = "-73.25 * (1000000000 / 1000)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), PETABIT.toGigabits(-73.25), delta);
        msg = "-56229.321 * (1000000000 / 1000)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), PETABIT.toGigabits(-56229.321), delta);
        msg = "-873.5432456 * (1000000000 / 1000)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), PETABIT.toGigabits(-873.5432456), delta);
        msg = "0 * (1000000000 / 1000)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), PETABIT.toGigabits(0.0), delta);
        msg = "0.1 * (1000000000 / 1000)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), PETABIT.toGigabits(0.1), delta);
        msg = "0.0000876543297 * (1000000000 / 1000)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), PETABIT.toGigabits(8.76543297E-5), delta);
        msg = "0.33 * (1000000000 / 1000)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), PETABIT.toGigabits(0.33), delta);
        msg = "0.6543 * (1000000000 / 1000)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), PETABIT.toGigabits(0.6543), delta);
        msg = "1 * (1000000000 / 1000)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), PETABIT.toGigabits(1.0), delta);
        msg = "1.6543 * (1000000000 / 1000)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), PETABIT.toGigabits(1.6543), delta);
        msg = "22.45 * (1000000000 / 1000)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), PETABIT.toGigabits(22.45), delta);
        msg = "9876.5432 * (1000000000 / 1000)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), PETABIT.toGigabits(9876.5432), delta);
        msg = "1987654344.3345 * (1000000000 / 1000)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), PETABIT.toGigabits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000000 / 1000)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), PETABIT.toGigabits(784.46789765434), delta);
        // ====================
        // ====================TERABIT
        // ====================
        // to_factor = 1000000.0
        to_factor = TERABIT.getFactor();
        msg = "-1 * (1000000000 / 1000000)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), PETABIT.toTerabits(-1.0), delta);
        msg = "-0.1 * (1000000000 / 1000000)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), PETABIT.toTerabits(-0.1), delta);
        msg = "-0.000456789 * (1000000000 / 1000000)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), PETABIT.toTerabits(-4.56789E-4), delta);
        msg = "-73.25 * (1000000000 / 1000000)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), PETABIT.toTerabits(-73.25), delta);
        msg = "-56229.321 * (1000000000 / 1000000)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), PETABIT.toTerabits(-56229.321), delta);
        msg = "-873.5432456 * (1000000000 / 1000000)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), PETABIT.toTerabits(-873.5432456), delta);
        msg = "0 * (1000000000 / 1000000)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), PETABIT.toTerabits(0.0), delta);
        msg = "0.1 * (1000000000 / 1000000)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), PETABIT.toTerabits(0.1), delta);
        msg = "0.0000876543297 * (1000000000 / 1000000)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), PETABIT.toTerabits(8.76543297E-5), delta);
        msg = "0.33 * (1000000000 / 1000000)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), PETABIT.toTerabits(0.33), delta);
        msg = "0.6543 * (1000000000 / 1000000)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), PETABIT.toTerabits(0.6543), delta);
        msg = "1 * (1000000000 / 1000000)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), PETABIT.toTerabits(1.0), delta);
        msg = "1.6543 * (1000000000 / 1000000)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), PETABIT.toTerabits(1.6543), delta);
        msg = "22.45 * (1000000000 / 1000000)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), PETABIT.toTerabits(22.45), delta);
        msg = "9876.5432 * (1000000000 / 1000000)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), PETABIT.toTerabits(9876.5432), delta);
        msg = "1987654344.3345 * (1000000000 / 1000000)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), PETABIT.toTerabits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000000 / 1000000)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), PETABIT.toTerabits(784.46789765434), delta);
        // ====================
        // ====================PETABIT
        // ====================
        // to_factor = 1.0E9
        to_factor = PETABIT.getFactor();
        msg = "-1 * (1000000000 / 1000000000)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), PETABIT.toPetabits(-1.0), delta);
        msg = "-0.1 * (1000000000 / 1000000000)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), PETABIT.toPetabits(-0.1), delta);
        msg = "-0.000456789 * (1000000000 / 1000000000)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), PETABIT.toPetabits(-4.56789E-4), delta);
        msg = "-73.25 * (1000000000 / 1000000000)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), PETABIT.toPetabits(-73.25), delta);
        msg = "-56229.321 * (1000000000 / 1000000000)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), PETABIT.toPetabits(-56229.321), delta);
        msg = "-873.5432456 * (1000000000 / 1000000000)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), PETABIT.toPetabits(-873.5432456), delta);
        msg = "0 * (1000000000 / 1000000000)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), PETABIT.toPetabits(0.0), delta);
        msg = "0.1 * (1000000000 / 1000000000)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), PETABIT.toPetabits(0.1), delta);
        msg = "0.0000876543297 * (1000000000 / 1000000000)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), PETABIT.toPetabits(8.76543297E-5), delta);
        msg = "0.33 * (1000000000 / 1000000000)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), PETABIT.toPetabits(0.33), delta);
        msg = "0.6543 * (1000000000 / 1000000000)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), PETABIT.toPetabits(0.6543), delta);
        msg = "1 * (1000000000 / 1000000000)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), PETABIT.toPetabits(1.0), delta);
        msg = "1.6543 * (1000000000 / 1000000000)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), PETABIT.toPetabits(1.6543), delta);
        msg = "22.45 * (1000000000 / 1000000000)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), PETABIT.toPetabits(22.45), delta);
        msg = "9876.5432 * (1000000000 / 1000000000)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), PETABIT.toPetabits(9876.5432), delta);
        msg = "1987654344.3345 * (1000000000 / 1000000000)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), PETABIT.toPetabits(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1000000000 / 1000000000)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), PETABIT.toPetabits(784.46789765434), delta);
    }
}
