package codes.abdullah.measurement.system.japan;

import static codes.abdullah.measurement.system.japan.Japans.BU;
import static codes.abdullah.measurement.system.japan.Japans.CHO;
import static codes.abdullah.measurement.system.japan.Japans.JO;
import static codes.abdullah.measurement.system.japan.Japans.KEN;
import static codes.abdullah.measurement.system.japan.Japans.MO;
import static codes.abdullah.measurement.system.japan.Japans.RI;
import static codes.abdullah.measurement.system.japan.Japans.RIN;
import static codes.abdullah.measurement.system.japan.Japans.SHAKU;
import static codes.abdullah.measurement.system.japan.Japans.SUN;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFixedJapanLength {

    @Test()
    public void testMo() {
        // from_factor = 1.0E-4
        double from_factor = MO.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MO
        // ====================
        // to_factor = 1.0E-4
        to_factor = MO.getFactor();
        msg = "-1 * (0.0001 / 0.0001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MO.toMos(-1.0), delta);
        msg = "-0.1 * (0.0001 / 0.0001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MO.toMos(-0.1), delta);
        msg = "-0.000456789 * (0.0001 / 0.0001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MO.toMos(-4.56789E-4), delta);
        msg = "-73.25 * (0.0001 / 0.0001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MO.toMos(-73.25), delta);
        msg = "-56229.321 * (0.0001 / 0.0001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MO.toMos(-56229.321), delta);
        msg = "-873.5432456 * (0.0001 / 0.0001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MO.toMos(-873.5432456), delta);
        msg = "0 * (0.0001 / 0.0001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MO.toMos(0.0), delta);
        msg = "0.1 * (0.0001 / 0.0001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MO.toMos(0.1), delta);
        msg = "0.0000876543297 * (0.0001 / 0.0001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MO.toMos(8.76543297E-5), delta);
        msg = "0.33 * (0.0001 / 0.0001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MO.toMos(0.33), delta);
        msg = "0.6543 * (0.0001 / 0.0001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MO.toMos(0.6543), delta);
        msg = "1 * (0.0001 / 0.0001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MO.toMos(1.0), delta);
        msg = "1.6543 * (0.0001 / 0.0001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MO.toMos(1.6543), delta);
        msg = "22.45 * (0.0001 / 0.0001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MO.toMos(22.45), delta);
        msg = "9876.5432 * (0.0001 / 0.0001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MO.toMos(9876.5432), delta);
        msg = "1987654344.3345 * (0.0001 / 0.0001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MO.toMos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.0001 / 0.0001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MO.toMos(784.46789765434), delta);
        // ====================
        // ====================RIN
        // ====================
        // to_factor = 0.001
        to_factor = RIN.getFactor();
        msg = "-1 / (0.001 / 0.0001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MO.toRins(-1.0), delta);
        msg = "-0.1 / (0.001 / 0.0001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MO.toRins(-0.1), delta);
        msg = "-0.000456789 / (0.001 / 0.0001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MO.toRins(-4.56789E-4), delta);
        msg = "-73.25 / (0.001 / 0.0001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MO.toRins(-73.25), delta);
        msg = "-56229.321 / (0.001 / 0.0001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MO.toRins(-56229.321), delta);
        msg = "-873.5432456 / (0.001 / 0.0001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MO.toRins(-873.5432456), delta);
        msg = "0 / (0.001 / 0.0001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MO.toRins(0.0), delta);
        msg = "0.1 / (0.001 / 0.0001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MO.toRins(0.1), delta);
        msg = "0.0000876543297 / (0.001 / 0.0001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MO.toRins(8.76543297E-5), delta);
        msg = "0.33 / (0.001 / 0.0001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MO.toRins(0.33), delta);
        msg = "0.6543 / (0.001 / 0.0001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MO.toRins(0.6543), delta);
        msg = "1 / (0.001 / 0.0001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MO.toRins(1.0), delta);
        msg = "1.6543 / (0.001 / 0.0001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MO.toRins(1.6543), delta);
        msg = "22.45 / (0.001 / 0.0001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MO.toRins(22.45), delta);
        msg = "9876.5432 / (0.001 / 0.0001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MO.toRins(9876.5432), delta);
        msg = "1987654344.3345 / (0.001 / 0.0001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MO.toRins(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.001 / 0.0001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MO.toRins(784.46789765434), delta);
        // ====================
        // ====================BU
        // ====================
        // to_factor = 0.01
        to_factor = BU.getFactor();
        msg = "-1 / (0.01 / 0.0001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MO.toBus(-1.0), delta);
        msg = "-0.1 / (0.01 / 0.0001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MO.toBus(-0.1), delta);
        msg = "-0.000456789 / (0.01 / 0.0001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MO.toBus(-4.56789E-4), delta);
        msg = "-73.25 / (0.01 / 0.0001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MO.toBus(-73.25), delta);
        msg = "-56229.321 / (0.01 / 0.0001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MO.toBus(-56229.321), delta);
        msg = "-873.5432456 / (0.01 / 0.0001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MO.toBus(-873.5432456), delta);
        msg = "0 / (0.01 / 0.0001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MO.toBus(0.0), delta);
        msg = "0.1 / (0.01 / 0.0001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MO.toBus(0.1), delta);
        msg = "0.0000876543297 / (0.01 / 0.0001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MO.toBus(8.76543297E-5), delta);
        msg = "0.33 / (0.01 / 0.0001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MO.toBus(0.33), delta);
        msg = "0.6543 / (0.01 / 0.0001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MO.toBus(0.6543), delta);
        msg = "1 / (0.01 / 0.0001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MO.toBus(1.0), delta);
        msg = "1.6543 / (0.01 / 0.0001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MO.toBus(1.6543), delta);
        msg = "22.45 / (0.01 / 0.0001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MO.toBus(22.45), delta);
        msg = "9876.5432 / (0.01 / 0.0001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MO.toBus(9876.5432), delta);
        msg = "1987654344.3345 / (0.01 / 0.0001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MO.toBus(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.01 / 0.0001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MO.toBus(784.46789765434), delta);
        // ====================
        // ====================SUN
        // ====================
        // to_factor = 0.1
        to_factor = SUN.getFactor();
        msg = "-1 / (0.1 / 0.0001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MO.toSuns(-1.0), delta);
        msg = "-0.1 / (0.1 / 0.0001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MO.toSuns(-0.1), delta);
        msg = "-0.000456789 / (0.1 / 0.0001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MO.toSuns(-4.56789E-4), delta);
        msg = "-73.25 / (0.1 / 0.0001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MO.toSuns(-73.25), delta);
        msg = "-56229.321 / (0.1 / 0.0001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MO.toSuns(-56229.321), delta);
        msg = "-873.5432456 / (0.1 / 0.0001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MO.toSuns(-873.5432456), delta);
        msg = "0 / (0.1 / 0.0001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MO.toSuns(0.0), delta);
        msg = "0.1 / (0.1 / 0.0001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MO.toSuns(0.1), delta);
        msg = "0.0000876543297 / (0.1 / 0.0001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MO.toSuns(8.76543297E-5), delta);
        msg = "0.33 / (0.1 / 0.0001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MO.toSuns(0.33), delta);
        msg = "0.6543 / (0.1 / 0.0001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MO.toSuns(0.6543), delta);
        msg = "1 / (0.1 / 0.0001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MO.toSuns(1.0), delta);
        msg = "1.6543 / (0.1 / 0.0001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MO.toSuns(1.6543), delta);
        msg = "22.45 / (0.1 / 0.0001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MO.toSuns(22.45), delta);
        msg = "9876.5432 / (0.1 / 0.0001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MO.toSuns(9876.5432), delta);
        msg = "1987654344.3345 / (0.1 / 0.0001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MO.toSuns(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.1 / 0.0001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MO.toSuns(784.46789765434), delta);
        // ====================
        // ====================SHAKU
        // ====================
        // to_factor = 1.0
        to_factor = SHAKU.getFactor();
        msg = "-1 / (1 / 0.0001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MO.toShakus(-1.0), delta);
        msg = "-0.1 / (1 / 0.0001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MO.toShakus(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.0001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MO.toShakus(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.0001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MO.toShakus(-73.25), delta);
        msg = "-56229.321 / (1 / 0.0001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MO.toShakus(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.0001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MO.toShakus(-873.5432456), delta);
        msg = "0 / (1 / 0.0001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MO.toShakus(0.0), delta);
        msg = "0.1 / (1 / 0.0001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MO.toShakus(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.0001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MO.toShakus(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.0001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MO.toShakus(0.33), delta);
        msg = "0.6543 / (1 / 0.0001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MO.toShakus(0.6543), delta);
        msg = "1 / (1 / 0.0001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MO.toShakus(1.0), delta);
        msg = "1.6543 / (1 / 0.0001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MO.toShakus(1.6543), delta);
        msg = "22.45 / (1 / 0.0001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MO.toShakus(22.45), delta);
        msg = "9876.5432 / (1 / 0.0001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MO.toShakus(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.0001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MO.toShakus(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.0001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MO.toShakus(784.46789765434), delta);
        // ====================
        // ====================KEN
        // ====================
        // to_factor = 6.0
        to_factor = KEN.getFactor();
        msg = "-1 / (6 / 0.0001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MO.toKens(-1.0), delta);
        msg = "-0.1 / (6 / 0.0001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MO.toKens(-0.1), delta);
        msg = "-0.000456789 / (6 / 0.0001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MO.toKens(-4.56789E-4), delta);
        msg = "-73.25 / (6 / 0.0001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MO.toKens(-73.25), delta);
        msg = "-56229.321 / (6 / 0.0001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MO.toKens(-56229.321), delta);
        msg = "-873.5432456 / (6 / 0.0001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MO.toKens(-873.5432456), delta);
        msg = "0 / (6 / 0.0001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MO.toKens(0.0), delta);
        msg = "0.1 / (6 / 0.0001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MO.toKens(0.1), delta);
        msg = "0.0000876543297 / (6 / 0.0001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MO.toKens(8.76543297E-5), delta);
        msg = "0.33 / (6 / 0.0001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MO.toKens(0.33), delta);
        msg = "0.6543 / (6 / 0.0001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MO.toKens(0.6543), delta);
        msg = "1 / (6 / 0.0001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MO.toKens(1.0), delta);
        msg = "1.6543 / (6 / 0.0001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MO.toKens(1.6543), delta);
        msg = "22.45 / (6 / 0.0001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MO.toKens(22.45), delta);
        msg = "9876.5432 / (6 / 0.0001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MO.toKens(9876.5432), delta);
        msg = "1987654344.3345 / (6 / 0.0001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MO.toKens(1.9876543443345E9), delta);
        msg = "784.46789765434 / (6 / 0.0001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MO.toKens(784.46789765434), delta);
        // ====================
        // ====================JO
        // ====================
        // to_factor = 10.0
        to_factor = JO.getFactor();
        msg = "-1 / (10 / 0.0001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MO.toJos(-1.0), delta);
        msg = "-0.1 / (10 / 0.0001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MO.toJos(-0.1), delta);
        msg = "-0.000456789 / (10 / 0.0001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MO.toJos(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 0.0001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MO.toJos(-73.25), delta);
        msg = "-56229.321 / (10 / 0.0001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MO.toJos(-56229.321), delta);
        msg = "-873.5432456 / (10 / 0.0001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MO.toJos(-873.5432456), delta);
        msg = "0 / (10 / 0.0001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MO.toJos(0.0), delta);
        msg = "0.1 / (10 / 0.0001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MO.toJos(0.1), delta);
        msg = "0.0000876543297 / (10 / 0.0001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MO.toJos(8.76543297E-5), delta);
        msg = "0.33 / (10 / 0.0001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MO.toJos(0.33), delta);
        msg = "0.6543 / (10 / 0.0001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MO.toJos(0.6543), delta);
        msg = "1 / (10 / 0.0001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MO.toJos(1.0), delta);
        msg = "1.6543 / (10 / 0.0001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MO.toJos(1.6543), delta);
        msg = "22.45 / (10 / 0.0001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MO.toJos(22.45), delta);
        msg = "9876.5432 / (10 / 0.0001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MO.toJos(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 0.0001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MO.toJos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 0.0001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MO.toJos(784.46789765434), delta);
        // ====================
        // ====================CHO
        // ====================
        // to_factor = 360.0
        to_factor = CHO.getFactor();
        msg = "-1 / (360 / 0.0001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MO.toChos(-1.0), delta);
        msg = "-0.1 / (360 / 0.0001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MO.toChos(-0.1), delta);
        msg = "-0.000456789 / (360 / 0.0001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MO.toChos(-4.56789E-4), delta);
        msg = "-73.25 / (360 / 0.0001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MO.toChos(-73.25), delta);
        msg = "-56229.321 / (360 / 0.0001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MO.toChos(-56229.321), delta);
        msg = "-873.5432456 / (360 / 0.0001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MO.toChos(-873.5432456), delta);
        msg = "0 / (360 / 0.0001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MO.toChos(0.0), delta);
        msg = "0.1 / (360 / 0.0001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MO.toChos(0.1), delta);
        msg = "0.0000876543297 / (360 / 0.0001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MO.toChos(8.76543297E-5), delta);
        msg = "0.33 / (360 / 0.0001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MO.toChos(0.33), delta);
        msg = "0.6543 / (360 / 0.0001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MO.toChos(0.6543), delta);
        msg = "1 / (360 / 0.0001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MO.toChos(1.0), delta);
        msg = "1.6543 / (360 / 0.0001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MO.toChos(1.6543), delta);
        msg = "22.45 / (360 / 0.0001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MO.toChos(22.45), delta);
        msg = "9876.5432 / (360 / 0.0001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MO.toChos(9876.5432), delta);
        msg = "1987654344.3345 / (360 / 0.0001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MO.toChos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (360 / 0.0001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MO.toChos(784.46789765434), delta);
        // ====================
        // ====================RI
        // ====================
        // to_factor = 12960.0
        to_factor = RI.getFactor();
        msg = "-1 / (12960 / 0.0001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MO.toRis(-1.0), delta);
        msg = "-0.1 / (12960 / 0.0001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MO.toRis(-0.1), delta);
        msg = "-0.000456789 / (12960 / 0.0001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MO.toRis(-4.56789E-4), delta);
        msg = "-73.25 / (12960 / 0.0001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MO.toRis(-73.25), delta);
        msg = "-56229.321 / (12960 / 0.0001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MO.toRis(-56229.321), delta);
        msg = "-873.5432456 / (12960 / 0.0001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MO.toRis(-873.5432456), delta);
        msg = "0 / (12960 / 0.0001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MO.toRis(0.0), delta);
        msg = "0.1 / (12960 / 0.0001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MO.toRis(0.1), delta);
        msg = "0.0000876543297 / (12960 / 0.0001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MO.toRis(8.76543297E-5), delta);
        msg = "0.33 / (12960 / 0.0001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MO.toRis(0.33), delta);
        msg = "0.6543 / (12960 / 0.0001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MO.toRis(0.6543), delta);
        msg = "1 / (12960 / 0.0001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MO.toRis(1.0), delta);
        msg = "1.6543 / (12960 / 0.0001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MO.toRis(1.6543), delta);
        msg = "22.45 / (12960 / 0.0001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MO.toRis(22.45), delta);
        msg = "9876.5432 / (12960 / 0.0001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MO.toRis(9876.5432), delta);
        msg = "1987654344.3345 / (12960 / 0.0001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MO.toRis(1.9876543443345E9), delta);
        msg = "784.46789765434 / (12960 / 0.0001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MO.toRis(784.46789765434), delta);
    }

    @Test()
    public void testRin() {
        // from_factor = 0.001
        double from_factor = RIN.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MO
        // ====================
        // to_factor = 1.0E-4
        to_factor = MO.getFactor();
        msg = "-1 * (0.001 / 0.0001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), RIN.toMos(-1.0), delta);
        msg = "-0.1 * (0.001 / 0.0001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), RIN.toMos(-0.1), delta);
        msg = "-0.000456789 * (0.001 / 0.0001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), RIN.toMos(-4.56789E-4), delta);
        msg = "-73.25 * (0.001 / 0.0001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), RIN.toMos(-73.25), delta);
        msg = "-56229.321 * (0.001 / 0.0001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), RIN.toMos(-56229.321), delta);
        msg = "-873.5432456 * (0.001 / 0.0001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), RIN.toMos(-873.5432456), delta);
        msg = "0 * (0.001 / 0.0001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), RIN.toMos(0.0), delta);
        msg = "0.1 * (0.001 / 0.0001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), RIN.toMos(0.1), delta);
        msg = "0.0000876543297 * (0.001 / 0.0001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), RIN.toMos(8.76543297E-5), delta);
        msg = "0.33 * (0.001 / 0.0001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), RIN.toMos(0.33), delta);
        msg = "0.6543 * (0.001 / 0.0001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), RIN.toMos(0.6543), delta);
        msg = "1 * (0.001 / 0.0001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), RIN.toMos(1.0), delta);
        msg = "1.6543 * (0.001 / 0.0001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), RIN.toMos(1.6543), delta);
        msg = "22.45 * (0.001 / 0.0001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), RIN.toMos(22.45), delta);
        msg = "9876.5432 * (0.001 / 0.0001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), RIN.toMos(9876.5432), delta);
        msg = "1987654344.3345 * (0.001 / 0.0001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), RIN.toMos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.001 / 0.0001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), RIN.toMos(784.46789765434), delta);
        // ====================
        // ====================RIN
        // ====================
        // to_factor = 0.001
        to_factor = RIN.getFactor();
        msg = "-1 * (0.001 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), RIN.toRins(-1.0), delta);
        msg = "-0.1 * (0.001 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), RIN.toRins(-0.1), delta);
        msg = "-0.000456789 * (0.001 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), RIN.toRins(-4.56789E-4), delta);
        msg = "-73.25 * (0.001 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), RIN.toRins(-73.25), delta);
        msg = "-56229.321 * (0.001 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), RIN.toRins(-56229.321), delta);
        msg = "-873.5432456 * (0.001 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), RIN.toRins(-873.5432456), delta);
        msg = "0 * (0.001 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), RIN.toRins(0.0), delta);
        msg = "0.1 * (0.001 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), RIN.toRins(0.1), delta);
        msg = "0.0000876543297 * (0.001 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), RIN.toRins(8.76543297E-5), delta);
        msg = "0.33 * (0.001 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), RIN.toRins(0.33), delta);
        msg = "0.6543 * (0.001 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), RIN.toRins(0.6543), delta);
        msg = "1 * (0.001 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), RIN.toRins(1.0), delta);
        msg = "1.6543 * (0.001 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), RIN.toRins(1.6543), delta);
        msg = "22.45 * (0.001 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), RIN.toRins(22.45), delta);
        msg = "9876.5432 * (0.001 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), RIN.toRins(9876.5432), delta);
        msg = "1987654344.3345 * (0.001 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), RIN.toRins(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.001 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), RIN.toRins(784.46789765434), delta);
        // ====================
        // ====================BU
        // ====================
        // to_factor = 0.01
        to_factor = BU.getFactor();
        msg = "-1 / (0.01 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), RIN.toBus(-1.0), delta);
        msg = "-0.1 / (0.01 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), RIN.toBus(-0.1), delta);
        msg = "-0.000456789 / (0.01 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), RIN.toBus(-4.56789E-4), delta);
        msg = "-73.25 / (0.01 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), RIN.toBus(-73.25), delta);
        msg = "-56229.321 / (0.01 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), RIN.toBus(-56229.321), delta);
        msg = "-873.5432456 / (0.01 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), RIN.toBus(-873.5432456), delta);
        msg = "0 / (0.01 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), RIN.toBus(0.0), delta);
        msg = "0.1 / (0.01 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), RIN.toBus(0.1), delta);
        msg = "0.0000876543297 / (0.01 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), RIN.toBus(8.76543297E-5), delta);
        msg = "0.33 / (0.01 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), RIN.toBus(0.33), delta);
        msg = "0.6543 / (0.01 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), RIN.toBus(0.6543), delta);
        msg = "1 / (0.01 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), RIN.toBus(1.0), delta);
        msg = "1.6543 / (0.01 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), RIN.toBus(1.6543), delta);
        msg = "22.45 / (0.01 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), RIN.toBus(22.45), delta);
        msg = "9876.5432 / (0.01 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), RIN.toBus(9876.5432), delta);
        msg = "1987654344.3345 / (0.01 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), RIN.toBus(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.01 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), RIN.toBus(784.46789765434), delta);
        // ====================
        // ====================SUN
        // ====================
        // to_factor = 0.1
        to_factor = SUN.getFactor();
        msg = "-1 / (0.1 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), RIN.toSuns(-1.0), delta);
        msg = "-0.1 / (0.1 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), RIN.toSuns(-0.1), delta);
        msg = "-0.000456789 / (0.1 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), RIN.toSuns(-4.56789E-4), delta);
        msg = "-73.25 / (0.1 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), RIN.toSuns(-73.25), delta);
        msg = "-56229.321 / (0.1 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), RIN.toSuns(-56229.321), delta);
        msg = "-873.5432456 / (0.1 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), RIN.toSuns(-873.5432456), delta);
        msg = "0 / (0.1 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), RIN.toSuns(0.0), delta);
        msg = "0.1 / (0.1 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), RIN.toSuns(0.1), delta);
        msg = "0.0000876543297 / (0.1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), RIN.toSuns(8.76543297E-5), delta);
        msg = "0.33 / (0.1 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), RIN.toSuns(0.33), delta);
        msg = "0.6543 / (0.1 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), RIN.toSuns(0.6543), delta);
        msg = "1 / (0.1 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), RIN.toSuns(1.0), delta);
        msg = "1.6543 / (0.1 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), RIN.toSuns(1.6543), delta);
        msg = "22.45 / (0.1 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), RIN.toSuns(22.45), delta);
        msg = "9876.5432 / (0.1 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), RIN.toSuns(9876.5432), delta);
        msg = "1987654344.3345 / (0.1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), RIN.toSuns(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.1 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), RIN.toSuns(784.46789765434), delta);
        // ====================
        // ====================SHAKU
        // ====================
        // to_factor = 1.0
        to_factor = SHAKU.getFactor();
        msg = "-1 / (1 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), RIN.toShakus(-1.0), delta);
        msg = "-0.1 / (1 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), RIN.toShakus(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), RIN.toShakus(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), RIN.toShakus(-73.25), delta);
        msg = "-56229.321 / (1 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), RIN.toShakus(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), RIN.toShakus(-873.5432456), delta);
        msg = "0 / (1 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), RIN.toShakus(0.0), delta);
        msg = "0.1 / (1 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), RIN.toShakus(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), RIN.toShakus(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), RIN.toShakus(0.33), delta);
        msg = "0.6543 / (1 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), RIN.toShakus(0.6543), delta);
        msg = "1 / (1 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), RIN.toShakus(1.0), delta);
        msg = "1.6543 / (1 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), RIN.toShakus(1.6543), delta);
        msg = "22.45 / (1 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), RIN.toShakus(22.45), delta);
        msg = "9876.5432 / (1 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), RIN.toShakus(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), RIN.toShakus(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), RIN.toShakus(784.46789765434), delta);
        // ====================
        // ====================KEN
        // ====================
        // to_factor = 6.0
        to_factor = KEN.getFactor();
        msg = "-1 / (6 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), RIN.toKens(-1.0), delta);
        msg = "-0.1 / (6 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), RIN.toKens(-0.1), delta);
        msg = "-0.000456789 / (6 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), RIN.toKens(-4.56789E-4), delta);
        msg = "-73.25 / (6 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), RIN.toKens(-73.25), delta);
        msg = "-56229.321 / (6 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), RIN.toKens(-56229.321), delta);
        msg = "-873.5432456 / (6 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), RIN.toKens(-873.5432456), delta);
        msg = "0 / (6 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), RIN.toKens(0.0), delta);
        msg = "0.1 / (6 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), RIN.toKens(0.1), delta);
        msg = "0.0000876543297 / (6 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), RIN.toKens(8.76543297E-5), delta);
        msg = "0.33 / (6 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), RIN.toKens(0.33), delta);
        msg = "0.6543 / (6 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), RIN.toKens(0.6543), delta);
        msg = "1 / (6 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), RIN.toKens(1.0), delta);
        msg = "1.6543 / (6 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), RIN.toKens(1.6543), delta);
        msg = "22.45 / (6 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), RIN.toKens(22.45), delta);
        msg = "9876.5432 / (6 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), RIN.toKens(9876.5432), delta);
        msg = "1987654344.3345 / (6 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), RIN.toKens(1.9876543443345E9), delta);
        msg = "784.46789765434 / (6 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), RIN.toKens(784.46789765434), delta);
        // ====================
        // ====================JO
        // ====================
        // to_factor = 10.0
        to_factor = JO.getFactor();
        msg = "-1 / (10 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), RIN.toJos(-1.0), delta);
        msg = "-0.1 / (10 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), RIN.toJos(-0.1), delta);
        msg = "-0.000456789 / (10 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), RIN.toJos(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), RIN.toJos(-73.25), delta);
        msg = "-56229.321 / (10 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), RIN.toJos(-56229.321), delta);
        msg = "-873.5432456 / (10 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), RIN.toJos(-873.5432456), delta);
        msg = "0 / (10 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), RIN.toJos(0.0), delta);
        msg = "0.1 / (10 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), RIN.toJos(0.1), delta);
        msg = "0.0000876543297 / (10 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), RIN.toJos(8.76543297E-5), delta);
        msg = "0.33 / (10 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), RIN.toJos(0.33), delta);
        msg = "0.6543 / (10 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), RIN.toJos(0.6543), delta);
        msg = "1 / (10 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), RIN.toJos(1.0), delta);
        msg = "1.6543 / (10 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), RIN.toJos(1.6543), delta);
        msg = "22.45 / (10 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), RIN.toJos(22.45), delta);
        msg = "9876.5432 / (10 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), RIN.toJos(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), RIN.toJos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), RIN.toJos(784.46789765434), delta);
        // ====================
        // ====================CHO
        // ====================
        // to_factor = 360.0
        to_factor = CHO.getFactor();
        msg = "-1 / (360 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), RIN.toChos(-1.0), delta);
        msg = "-0.1 / (360 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), RIN.toChos(-0.1), delta);
        msg = "-0.000456789 / (360 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), RIN.toChos(-4.56789E-4), delta);
        msg = "-73.25 / (360 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), RIN.toChos(-73.25), delta);
        msg = "-56229.321 / (360 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), RIN.toChos(-56229.321), delta);
        msg = "-873.5432456 / (360 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), RIN.toChos(-873.5432456), delta);
        msg = "0 / (360 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), RIN.toChos(0.0), delta);
        msg = "0.1 / (360 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), RIN.toChos(0.1), delta);
        msg = "0.0000876543297 / (360 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), RIN.toChos(8.76543297E-5), delta);
        msg = "0.33 / (360 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), RIN.toChos(0.33), delta);
        msg = "0.6543 / (360 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), RIN.toChos(0.6543), delta);
        msg = "1 / (360 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), RIN.toChos(1.0), delta);
        msg = "1.6543 / (360 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), RIN.toChos(1.6543), delta);
        msg = "22.45 / (360 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), RIN.toChos(22.45), delta);
        msg = "9876.5432 / (360 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), RIN.toChos(9876.5432), delta);
        msg = "1987654344.3345 / (360 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), RIN.toChos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (360 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), RIN.toChos(784.46789765434), delta);
        // ====================
        // ====================RI
        // ====================
        // to_factor = 12960.0
        to_factor = RI.getFactor();
        msg = "-1 / (12960 / 0.001)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), RIN.toRis(-1.0), delta);
        msg = "-0.1 / (12960 / 0.001)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), RIN.toRis(-0.1), delta);
        msg = "-0.000456789 / (12960 / 0.001)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), RIN.toRis(-4.56789E-4), delta);
        msg = "-73.25 / (12960 / 0.001)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), RIN.toRis(-73.25), delta);
        msg = "-56229.321 / (12960 / 0.001)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), RIN.toRis(-56229.321), delta);
        msg = "-873.5432456 / (12960 / 0.001)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), RIN.toRis(-873.5432456), delta);
        msg = "0 / (12960 / 0.001)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), RIN.toRis(0.0), delta);
        msg = "0.1 / (12960 / 0.001)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), RIN.toRis(0.1), delta);
        msg = "0.0000876543297 / (12960 / 0.001)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), RIN.toRis(8.76543297E-5), delta);
        msg = "0.33 / (12960 / 0.001)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), RIN.toRis(0.33), delta);
        msg = "0.6543 / (12960 / 0.001)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), RIN.toRis(0.6543), delta);
        msg = "1 / (12960 / 0.001)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), RIN.toRis(1.0), delta);
        msg = "1.6543 / (12960 / 0.001)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), RIN.toRis(1.6543), delta);
        msg = "22.45 / (12960 / 0.001)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), RIN.toRis(22.45), delta);
        msg = "9876.5432 / (12960 / 0.001)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), RIN.toRis(9876.5432), delta);
        msg = "1987654344.3345 / (12960 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), RIN.toRis(1.9876543443345E9), delta);
        msg = "784.46789765434 / (12960 / 0.001)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), RIN.toRis(784.46789765434), delta);
    }

    @Test()
    public void testBu() {
        // from_factor = 0.01
        double from_factor = BU.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MO
        // ====================
        // to_factor = 1.0E-4
        to_factor = MO.getFactor();
        msg = "-1 * (0.01 / 0.0001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), BU.toMos(-1.0), delta);
        msg = "-0.1 * (0.01 / 0.0001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), BU.toMos(-0.1), delta);
        msg = "-0.000456789 * (0.01 / 0.0001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), BU.toMos(-4.56789E-4), delta);
        msg = "-73.25 * (0.01 / 0.0001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), BU.toMos(-73.25), delta);
        msg = "-56229.321 * (0.01 / 0.0001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), BU.toMos(-56229.321), delta);
        msg = "-873.5432456 * (0.01 / 0.0001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), BU.toMos(-873.5432456), delta);
        msg = "0 * (0.01 / 0.0001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), BU.toMos(0.0), delta);
        msg = "0.1 * (0.01 / 0.0001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), BU.toMos(0.1), delta);
        msg = "0.0000876543297 * (0.01 / 0.0001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), BU.toMos(8.76543297E-5), delta);
        msg = "0.33 * (0.01 / 0.0001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), BU.toMos(0.33), delta);
        msg = "0.6543 * (0.01 / 0.0001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), BU.toMos(0.6543), delta);
        msg = "1 * (0.01 / 0.0001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), BU.toMos(1.0), delta);
        msg = "1.6543 * (0.01 / 0.0001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), BU.toMos(1.6543), delta);
        msg = "22.45 * (0.01 / 0.0001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), BU.toMos(22.45), delta);
        msg = "9876.5432 * (0.01 / 0.0001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), BU.toMos(9876.5432), delta);
        msg = "1987654344.3345 * (0.01 / 0.0001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), BU.toMos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.01 / 0.0001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), BU.toMos(784.46789765434), delta);
        // ====================
        // ====================RIN
        // ====================
        // to_factor = 0.001
        to_factor = RIN.getFactor();
        msg = "-1 * (0.01 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), BU.toRins(-1.0), delta);
        msg = "-0.1 * (0.01 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), BU.toRins(-0.1), delta);
        msg = "-0.000456789 * (0.01 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), BU.toRins(-4.56789E-4), delta);
        msg = "-73.25 * (0.01 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), BU.toRins(-73.25), delta);
        msg = "-56229.321 * (0.01 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), BU.toRins(-56229.321), delta);
        msg = "-873.5432456 * (0.01 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), BU.toRins(-873.5432456), delta);
        msg = "0 * (0.01 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), BU.toRins(0.0), delta);
        msg = "0.1 * (0.01 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), BU.toRins(0.1), delta);
        msg = "0.0000876543297 * (0.01 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), BU.toRins(8.76543297E-5), delta);
        msg = "0.33 * (0.01 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), BU.toRins(0.33), delta);
        msg = "0.6543 * (0.01 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), BU.toRins(0.6543), delta);
        msg = "1 * (0.01 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), BU.toRins(1.0), delta);
        msg = "1.6543 * (0.01 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), BU.toRins(1.6543), delta);
        msg = "22.45 * (0.01 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), BU.toRins(22.45), delta);
        msg = "9876.5432 * (0.01 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), BU.toRins(9876.5432), delta);
        msg = "1987654344.3345 * (0.01 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), BU.toRins(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.01 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), BU.toRins(784.46789765434), delta);
        // ====================
        // ====================BU
        // ====================
        // to_factor = 0.01
        to_factor = BU.getFactor();
        msg = "-1 * (0.01 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), BU.toBus(-1.0), delta);
        msg = "-0.1 * (0.01 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), BU.toBus(-0.1), delta);
        msg = "-0.000456789 * (0.01 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), BU.toBus(-4.56789E-4), delta);
        msg = "-73.25 * (0.01 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), BU.toBus(-73.25), delta);
        msg = "-56229.321 * (0.01 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), BU.toBus(-56229.321), delta);
        msg = "-873.5432456 * (0.01 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), BU.toBus(-873.5432456), delta);
        msg = "0 * (0.01 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), BU.toBus(0.0), delta);
        msg = "0.1 * (0.01 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), BU.toBus(0.1), delta);
        msg = "0.0000876543297 * (0.01 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), BU.toBus(8.76543297E-5), delta);
        msg = "0.33 * (0.01 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), BU.toBus(0.33), delta);
        msg = "0.6543 * (0.01 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), BU.toBus(0.6543), delta);
        msg = "1 * (0.01 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), BU.toBus(1.0), delta);
        msg = "1.6543 * (0.01 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), BU.toBus(1.6543), delta);
        msg = "22.45 * (0.01 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), BU.toBus(22.45), delta);
        msg = "9876.5432 * (0.01 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), BU.toBus(9876.5432), delta);
        msg = "1987654344.3345 * (0.01 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), BU.toBus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.01 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), BU.toBus(784.46789765434), delta);
        // ====================
        // ====================SUN
        // ====================
        // to_factor = 0.1
        to_factor = SUN.getFactor();
        msg = "-1 / (0.1 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), BU.toSuns(-1.0), delta);
        msg = "-0.1 / (0.1 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), BU.toSuns(-0.1), delta);
        msg = "-0.000456789 / (0.1 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), BU.toSuns(-4.56789E-4), delta);
        msg = "-73.25 / (0.1 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), BU.toSuns(-73.25), delta);
        msg = "-56229.321 / (0.1 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), BU.toSuns(-56229.321), delta);
        msg = "-873.5432456 / (0.1 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), BU.toSuns(-873.5432456), delta);
        msg = "0 / (0.1 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), BU.toSuns(0.0), delta);
        msg = "0.1 / (0.1 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), BU.toSuns(0.1), delta);
        msg = "0.0000876543297 / (0.1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), BU.toSuns(8.76543297E-5), delta);
        msg = "0.33 / (0.1 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), BU.toSuns(0.33), delta);
        msg = "0.6543 / (0.1 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), BU.toSuns(0.6543), delta);
        msg = "1 / (0.1 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), BU.toSuns(1.0), delta);
        msg = "1.6543 / (0.1 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), BU.toSuns(1.6543), delta);
        msg = "22.45 / (0.1 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), BU.toSuns(22.45), delta);
        msg = "9876.5432 / (0.1 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), BU.toSuns(9876.5432), delta);
        msg = "1987654344.3345 / (0.1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), BU.toSuns(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.1 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), BU.toSuns(784.46789765434), delta);
        // ====================
        // ====================SHAKU
        // ====================
        // to_factor = 1.0
        to_factor = SHAKU.getFactor();
        msg = "-1 / (1 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), BU.toShakus(-1.0), delta);
        msg = "-0.1 / (1 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), BU.toShakus(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), BU.toShakus(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), BU.toShakus(-73.25), delta);
        msg = "-56229.321 / (1 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), BU.toShakus(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), BU.toShakus(-873.5432456), delta);
        msg = "0 / (1 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), BU.toShakus(0.0), delta);
        msg = "0.1 / (1 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), BU.toShakus(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), BU.toShakus(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), BU.toShakus(0.33), delta);
        msg = "0.6543 / (1 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), BU.toShakus(0.6543), delta);
        msg = "1 / (1 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), BU.toShakus(1.0), delta);
        msg = "1.6543 / (1 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), BU.toShakus(1.6543), delta);
        msg = "22.45 / (1 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), BU.toShakus(22.45), delta);
        msg = "9876.5432 / (1 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), BU.toShakus(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), BU.toShakus(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), BU.toShakus(784.46789765434), delta);
        // ====================
        // ====================KEN
        // ====================
        // to_factor = 6.0
        to_factor = KEN.getFactor();
        msg = "-1 / (6 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), BU.toKens(-1.0), delta);
        msg = "-0.1 / (6 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), BU.toKens(-0.1), delta);
        msg = "-0.000456789 / (6 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), BU.toKens(-4.56789E-4), delta);
        msg = "-73.25 / (6 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), BU.toKens(-73.25), delta);
        msg = "-56229.321 / (6 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), BU.toKens(-56229.321), delta);
        msg = "-873.5432456 / (6 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), BU.toKens(-873.5432456), delta);
        msg = "0 / (6 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), BU.toKens(0.0), delta);
        msg = "0.1 / (6 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), BU.toKens(0.1), delta);
        msg = "0.0000876543297 / (6 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), BU.toKens(8.76543297E-5), delta);
        msg = "0.33 / (6 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), BU.toKens(0.33), delta);
        msg = "0.6543 / (6 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), BU.toKens(0.6543), delta);
        msg = "1 / (6 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), BU.toKens(1.0), delta);
        msg = "1.6543 / (6 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), BU.toKens(1.6543), delta);
        msg = "22.45 / (6 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), BU.toKens(22.45), delta);
        msg = "9876.5432 / (6 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), BU.toKens(9876.5432), delta);
        msg = "1987654344.3345 / (6 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), BU.toKens(1.9876543443345E9), delta);
        msg = "784.46789765434 / (6 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), BU.toKens(784.46789765434), delta);
        // ====================
        // ====================JO
        // ====================
        // to_factor = 10.0
        to_factor = JO.getFactor();
        msg = "-1 / (10 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), BU.toJos(-1.0), delta);
        msg = "-0.1 / (10 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), BU.toJos(-0.1), delta);
        msg = "-0.000456789 / (10 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), BU.toJos(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), BU.toJos(-73.25), delta);
        msg = "-56229.321 / (10 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), BU.toJos(-56229.321), delta);
        msg = "-873.5432456 / (10 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), BU.toJos(-873.5432456), delta);
        msg = "0 / (10 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), BU.toJos(0.0), delta);
        msg = "0.1 / (10 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), BU.toJos(0.1), delta);
        msg = "0.0000876543297 / (10 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), BU.toJos(8.76543297E-5), delta);
        msg = "0.33 / (10 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), BU.toJos(0.33), delta);
        msg = "0.6543 / (10 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), BU.toJos(0.6543), delta);
        msg = "1 / (10 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), BU.toJos(1.0), delta);
        msg = "1.6543 / (10 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), BU.toJos(1.6543), delta);
        msg = "22.45 / (10 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), BU.toJos(22.45), delta);
        msg = "9876.5432 / (10 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), BU.toJos(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), BU.toJos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), BU.toJos(784.46789765434), delta);
        // ====================
        // ====================CHO
        // ====================
        // to_factor = 360.0
        to_factor = CHO.getFactor();
        msg = "-1 / (360 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), BU.toChos(-1.0), delta);
        msg = "-0.1 / (360 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), BU.toChos(-0.1), delta);
        msg = "-0.000456789 / (360 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), BU.toChos(-4.56789E-4), delta);
        msg = "-73.25 / (360 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), BU.toChos(-73.25), delta);
        msg = "-56229.321 / (360 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), BU.toChos(-56229.321), delta);
        msg = "-873.5432456 / (360 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), BU.toChos(-873.5432456), delta);
        msg = "0 / (360 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), BU.toChos(0.0), delta);
        msg = "0.1 / (360 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), BU.toChos(0.1), delta);
        msg = "0.0000876543297 / (360 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), BU.toChos(8.76543297E-5), delta);
        msg = "0.33 / (360 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), BU.toChos(0.33), delta);
        msg = "0.6543 / (360 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), BU.toChos(0.6543), delta);
        msg = "1 / (360 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), BU.toChos(1.0), delta);
        msg = "1.6543 / (360 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), BU.toChos(1.6543), delta);
        msg = "22.45 / (360 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), BU.toChos(22.45), delta);
        msg = "9876.5432 / (360 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), BU.toChos(9876.5432), delta);
        msg = "1987654344.3345 / (360 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), BU.toChos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (360 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), BU.toChos(784.46789765434), delta);
        // ====================
        // ====================RI
        // ====================
        // to_factor = 12960.0
        to_factor = RI.getFactor();
        msg = "-1 / (12960 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), BU.toRis(-1.0), delta);
        msg = "-0.1 / (12960 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), BU.toRis(-0.1), delta);
        msg = "-0.000456789 / (12960 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), BU.toRis(-4.56789E-4), delta);
        msg = "-73.25 / (12960 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), BU.toRis(-73.25), delta);
        msg = "-56229.321 / (12960 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), BU.toRis(-56229.321), delta);
        msg = "-873.5432456 / (12960 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), BU.toRis(-873.5432456), delta);
        msg = "0 / (12960 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), BU.toRis(0.0), delta);
        msg = "0.1 / (12960 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), BU.toRis(0.1), delta);
        msg = "0.0000876543297 / (12960 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), BU.toRis(8.76543297E-5), delta);
        msg = "0.33 / (12960 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), BU.toRis(0.33), delta);
        msg = "0.6543 / (12960 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), BU.toRis(0.6543), delta);
        msg = "1 / (12960 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), BU.toRis(1.0), delta);
        msg = "1.6543 / (12960 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), BU.toRis(1.6543), delta);
        msg = "22.45 / (12960 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), BU.toRis(22.45), delta);
        msg = "9876.5432 / (12960 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), BU.toRis(9876.5432), delta);
        msg = "1987654344.3345 / (12960 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), BU.toRis(1.9876543443345E9), delta);
        msg = "784.46789765434 / (12960 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), BU.toRis(784.46789765434), delta);
    }

    @Test()
    public void testSun() {
        // from_factor = 0.1
        double from_factor = SUN.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MO
        // ====================
        // to_factor = 1.0E-4
        to_factor = MO.getFactor();
        msg = "-1 * (0.1 / 0.0001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SUN.toMos(-1.0), delta);
        msg = "-0.1 * (0.1 / 0.0001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SUN.toMos(-0.1), delta);
        msg = "-0.000456789 * (0.1 / 0.0001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SUN.toMos(-4.56789E-4), delta);
        msg = "-73.25 * (0.1 / 0.0001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SUN.toMos(-73.25), delta);
        msg = "-56229.321 * (0.1 / 0.0001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SUN.toMos(-56229.321), delta);
        msg = "-873.5432456 * (0.1 / 0.0001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SUN.toMos(-873.5432456), delta);
        msg = "0 * (0.1 / 0.0001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SUN.toMos(0.0), delta);
        msg = "0.1 * (0.1 / 0.0001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SUN.toMos(0.1), delta);
        msg = "0.0000876543297 * (0.1 / 0.0001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SUN.toMos(8.76543297E-5), delta);
        msg = "0.33 * (0.1 / 0.0001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SUN.toMos(0.33), delta);
        msg = "0.6543 * (0.1 / 0.0001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SUN.toMos(0.6543), delta);
        msg = "1 * (0.1 / 0.0001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SUN.toMos(1.0), delta);
        msg = "1.6543 * (0.1 / 0.0001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SUN.toMos(1.6543), delta);
        msg = "22.45 * (0.1 / 0.0001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SUN.toMos(22.45), delta);
        msg = "9876.5432 * (0.1 / 0.0001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SUN.toMos(9876.5432), delta);
        msg = "1987654344.3345 * (0.1 / 0.0001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SUN.toMos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.1 / 0.0001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SUN.toMos(784.46789765434), delta);
        // ====================
        // ====================RIN
        // ====================
        // to_factor = 0.001
        to_factor = RIN.getFactor();
        msg = "-1 * (0.1 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SUN.toRins(-1.0), delta);
        msg = "-0.1 * (0.1 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SUN.toRins(-0.1), delta);
        msg = "-0.000456789 * (0.1 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SUN.toRins(-4.56789E-4), delta);
        msg = "-73.25 * (0.1 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SUN.toRins(-73.25), delta);
        msg = "-56229.321 * (0.1 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SUN.toRins(-56229.321), delta);
        msg = "-873.5432456 * (0.1 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SUN.toRins(-873.5432456), delta);
        msg = "0 * (0.1 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SUN.toRins(0.0), delta);
        msg = "0.1 * (0.1 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SUN.toRins(0.1), delta);
        msg = "0.0000876543297 * (0.1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SUN.toRins(8.76543297E-5), delta);
        msg = "0.33 * (0.1 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SUN.toRins(0.33), delta);
        msg = "0.6543 * (0.1 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SUN.toRins(0.6543), delta);
        msg = "1 * (0.1 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SUN.toRins(1.0), delta);
        msg = "1.6543 * (0.1 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SUN.toRins(1.6543), delta);
        msg = "22.45 * (0.1 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SUN.toRins(22.45), delta);
        msg = "9876.5432 * (0.1 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SUN.toRins(9876.5432), delta);
        msg = "1987654344.3345 * (0.1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SUN.toRins(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.1 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SUN.toRins(784.46789765434), delta);
        // ====================
        // ====================BU
        // ====================
        // to_factor = 0.01
        to_factor = BU.getFactor();
        msg = "-1 * (0.1 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SUN.toBus(-1.0), delta);
        msg = "-0.1 * (0.1 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SUN.toBus(-0.1), delta);
        msg = "-0.000456789 * (0.1 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SUN.toBus(-4.56789E-4), delta);
        msg = "-73.25 * (0.1 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SUN.toBus(-73.25), delta);
        msg = "-56229.321 * (0.1 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SUN.toBus(-56229.321), delta);
        msg = "-873.5432456 * (0.1 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SUN.toBus(-873.5432456), delta);
        msg = "0 * (0.1 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SUN.toBus(0.0), delta);
        msg = "0.1 * (0.1 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SUN.toBus(0.1), delta);
        msg = "0.0000876543297 * (0.1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SUN.toBus(8.76543297E-5), delta);
        msg = "0.33 * (0.1 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SUN.toBus(0.33), delta);
        msg = "0.6543 * (0.1 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SUN.toBus(0.6543), delta);
        msg = "1 * (0.1 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SUN.toBus(1.0), delta);
        msg = "1.6543 * (0.1 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SUN.toBus(1.6543), delta);
        msg = "22.45 * (0.1 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SUN.toBus(22.45), delta);
        msg = "9876.5432 * (0.1 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SUN.toBus(9876.5432), delta);
        msg = "1987654344.3345 * (0.1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SUN.toBus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.1 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SUN.toBus(784.46789765434), delta);
        // ====================
        // ====================SUN
        // ====================
        // to_factor = 0.1
        to_factor = SUN.getFactor();
        msg = "-1 * (0.1 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SUN.toSuns(-1.0), delta);
        msg = "-0.1 * (0.1 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SUN.toSuns(-0.1), delta);
        msg = "-0.000456789 * (0.1 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SUN.toSuns(-4.56789E-4), delta);
        msg = "-73.25 * (0.1 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SUN.toSuns(-73.25), delta);
        msg = "-56229.321 * (0.1 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SUN.toSuns(-56229.321), delta);
        msg = "-873.5432456 * (0.1 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SUN.toSuns(-873.5432456), delta);
        msg = "0 * (0.1 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SUN.toSuns(0.0), delta);
        msg = "0.1 * (0.1 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SUN.toSuns(0.1), delta);
        msg = "0.0000876543297 * (0.1 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SUN.toSuns(8.76543297E-5), delta);
        msg = "0.33 * (0.1 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SUN.toSuns(0.33), delta);
        msg = "0.6543 * (0.1 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SUN.toSuns(0.6543), delta);
        msg = "1 * (0.1 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SUN.toSuns(1.0), delta);
        msg = "1.6543 * (0.1 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SUN.toSuns(1.6543), delta);
        msg = "22.45 * (0.1 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SUN.toSuns(22.45), delta);
        msg = "9876.5432 * (0.1 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SUN.toSuns(9876.5432), delta);
        msg = "1987654344.3345 * (0.1 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SUN.toSuns(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.1 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SUN.toSuns(784.46789765434), delta);
        // ====================
        // ====================SHAKU
        // ====================
        // to_factor = 1.0
        to_factor = SHAKU.getFactor();
        msg = "-1 / (1 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SUN.toShakus(-1.0), delta);
        msg = "-0.1 / (1 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SUN.toShakus(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SUN.toShakus(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SUN.toShakus(-73.25), delta);
        msg = "-56229.321 / (1 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SUN.toShakus(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SUN.toShakus(-873.5432456), delta);
        msg = "0 / (1 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SUN.toShakus(0.0), delta);
        msg = "0.1 / (1 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SUN.toShakus(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SUN.toShakus(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SUN.toShakus(0.33), delta);
        msg = "0.6543 / (1 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SUN.toShakus(0.6543), delta);
        msg = "1 / (1 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SUN.toShakus(1.0), delta);
        msg = "1.6543 / (1 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SUN.toShakus(1.6543), delta);
        msg = "22.45 / (1 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SUN.toShakus(22.45), delta);
        msg = "9876.5432 / (1 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SUN.toShakus(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SUN.toShakus(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SUN.toShakus(784.46789765434), delta);
        // ====================
        // ====================KEN
        // ====================
        // to_factor = 6.0
        to_factor = KEN.getFactor();
        msg = "-1 / (6 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SUN.toKens(-1.0), delta);
        msg = "-0.1 / (6 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SUN.toKens(-0.1), delta);
        msg = "-0.000456789 / (6 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SUN.toKens(-4.56789E-4), delta);
        msg = "-73.25 / (6 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SUN.toKens(-73.25), delta);
        msg = "-56229.321 / (6 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SUN.toKens(-56229.321), delta);
        msg = "-873.5432456 / (6 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SUN.toKens(-873.5432456), delta);
        msg = "0 / (6 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SUN.toKens(0.0), delta);
        msg = "0.1 / (6 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SUN.toKens(0.1), delta);
        msg = "0.0000876543297 / (6 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SUN.toKens(8.76543297E-5), delta);
        msg = "0.33 / (6 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SUN.toKens(0.33), delta);
        msg = "0.6543 / (6 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SUN.toKens(0.6543), delta);
        msg = "1 / (6 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SUN.toKens(1.0), delta);
        msg = "1.6543 / (6 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SUN.toKens(1.6543), delta);
        msg = "22.45 / (6 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SUN.toKens(22.45), delta);
        msg = "9876.5432 / (6 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SUN.toKens(9876.5432), delta);
        msg = "1987654344.3345 / (6 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SUN.toKens(1.9876543443345E9), delta);
        msg = "784.46789765434 / (6 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SUN.toKens(784.46789765434), delta);
        // ====================
        // ====================JO
        // ====================
        // to_factor = 10.0
        to_factor = JO.getFactor();
        msg = "-1 / (10 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SUN.toJos(-1.0), delta);
        msg = "-0.1 / (10 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SUN.toJos(-0.1), delta);
        msg = "-0.000456789 / (10 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SUN.toJos(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SUN.toJos(-73.25), delta);
        msg = "-56229.321 / (10 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SUN.toJos(-56229.321), delta);
        msg = "-873.5432456 / (10 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SUN.toJos(-873.5432456), delta);
        msg = "0 / (10 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SUN.toJos(0.0), delta);
        msg = "0.1 / (10 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SUN.toJos(0.1), delta);
        msg = "0.0000876543297 / (10 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SUN.toJos(8.76543297E-5), delta);
        msg = "0.33 / (10 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SUN.toJos(0.33), delta);
        msg = "0.6543 / (10 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SUN.toJos(0.6543), delta);
        msg = "1 / (10 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SUN.toJos(1.0), delta);
        msg = "1.6543 / (10 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SUN.toJos(1.6543), delta);
        msg = "22.45 / (10 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SUN.toJos(22.45), delta);
        msg = "9876.5432 / (10 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SUN.toJos(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SUN.toJos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SUN.toJos(784.46789765434), delta);
        // ====================
        // ====================CHO
        // ====================
        // to_factor = 360.0
        to_factor = CHO.getFactor();
        msg = "-1 / (360 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SUN.toChos(-1.0), delta);
        msg = "-0.1 / (360 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SUN.toChos(-0.1), delta);
        msg = "-0.000456789 / (360 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SUN.toChos(-4.56789E-4), delta);
        msg = "-73.25 / (360 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SUN.toChos(-73.25), delta);
        msg = "-56229.321 / (360 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SUN.toChos(-56229.321), delta);
        msg = "-873.5432456 / (360 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SUN.toChos(-873.5432456), delta);
        msg = "0 / (360 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SUN.toChos(0.0), delta);
        msg = "0.1 / (360 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SUN.toChos(0.1), delta);
        msg = "0.0000876543297 / (360 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SUN.toChos(8.76543297E-5), delta);
        msg = "0.33 / (360 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SUN.toChos(0.33), delta);
        msg = "0.6543 / (360 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SUN.toChos(0.6543), delta);
        msg = "1 / (360 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SUN.toChos(1.0), delta);
        msg = "1.6543 / (360 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SUN.toChos(1.6543), delta);
        msg = "22.45 / (360 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SUN.toChos(22.45), delta);
        msg = "9876.5432 / (360 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SUN.toChos(9876.5432), delta);
        msg = "1987654344.3345 / (360 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SUN.toChos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (360 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SUN.toChos(784.46789765434), delta);
        // ====================
        // ====================RI
        // ====================
        // to_factor = 12960.0
        to_factor = RI.getFactor();
        msg = "-1 / (12960 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SUN.toRis(-1.0), delta);
        msg = "-0.1 / (12960 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SUN.toRis(-0.1), delta);
        msg = "-0.000456789 / (12960 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SUN.toRis(-4.56789E-4), delta);
        msg = "-73.25 / (12960 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SUN.toRis(-73.25), delta);
        msg = "-56229.321 / (12960 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SUN.toRis(-56229.321), delta);
        msg = "-873.5432456 / (12960 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SUN.toRis(-873.5432456), delta);
        msg = "0 / (12960 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SUN.toRis(0.0), delta);
        msg = "0.1 / (12960 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SUN.toRis(0.1), delta);
        msg = "0.0000876543297 / (12960 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SUN.toRis(8.76543297E-5), delta);
        msg = "0.33 / (12960 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SUN.toRis(0.33), delta);
        msg = "0.6543 / (12960 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SUN.toRis(0.6543), delta);
        msg = "1 / (12960 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SUN.toRis(1.0), delta);
        msg = "1.6543 / (12960 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SUN.toRis(1.6543), delta);
        msg = "22.45 / (12960 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SUN.toRis(22.45), delta);
        msg = "9876.5432 / (12960 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SUN.toRis(9876.5432), delta);
        msg = "1987654344.3345 / (12960 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SUN.toRis(1.9876543443345E9), delta);
        msg = "784.46789765434 / (12960 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SUN.toRis(784.46789765434), delta);
    }

    @Test()
    public void testShaku() {
        // from_factor = 1.0
        double from_factor = SHAKU.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MO
        // ====================
        // to_factor = 1.0E-4
        to_factor = MO.getFactor();
        msg = "-1 * (1 / 0.0001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SHAKU.toMos(-1.0), delta);
        msg = "-0.1 * (1 / 0.0001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SHAKU.toMos(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.0001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SHAKU.toMos(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.0001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SHAKU.toMos(-73.25), delta);
        msg = "-56229.321 * (1 / 0.0001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SHAKU.toMos(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.0001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SHAKU.toMos(-873.5432456), delta);
        msg = "0 * (1 / 0.0001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SHAKU.toMos(0.0), delta);
        msg = "0.1 * (1 / 0.0001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SHAKU.toMos(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.0001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SHAKU.toMos(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.0001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SHAKU.toMos(0.33), delta);
        msg = "0.6543 * (1 / 0.0001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SHAKU.toMos(0.6543), delta);
        msg = "1 * (1 / 0.0001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SHAKU.toMos(1.0), delta);
        msg = "1.6543 * (1 / 0.0001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SHAKU.toMos(1.6543), delta);
        msg = "22.45 * (1 / 0.0001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SHAKU.toMos(22.45), delta);
        msg = "9876.5432 * (1 / 0.0001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SHAKU.toMos(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.0001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SHAKU.toMos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.0001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SHAKU.toMos(784.46789765434), delta);
        // ====================
        // ====================RIN
        // ====================
        // to_factor = 0.001
        to_factor = RIN.getFactor();
        msg = "-1 * (1 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SHAKU.toRins(-1.0), delta);
        msg = "-0.1 * (1 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SHAKU.toRins(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SHAKU.toRins(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SHAKU.toRins(-73.25), delta);
        msg = "-56229.321 * (1 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SHAKU.toRins(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SHAKU.toRins(-873.5432456), delta);
        msg = "0 * (1 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SHAKU.toRins(0.0), delta);
        msg = "0.1 * (1 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SHAKU.toRins(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SHAKU.toRins(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SHAKU.toRins(0.33), delta);
        msg = "0.6543 * (1 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SHAKU.toRins(0.6543), delta);
        msg = "1 * (1 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SHAKU.toRins(1.0), delta);
        msg = "1.6543 * (1 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SHAKU.toRins(1.6543), delta);
        msg = "22.45 * (1 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SHAKU.toRins(22.45), delta);
        msg = "9876.5432 * (1 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SHAKU.toRins(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SHAKU.toRins(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SHAKU.toRins(784.46789765434), delta);
        // ====================
        // ====================BU
        // ====================
        // to_factor = 0.01
        to_factor = BU.getFactor();
        msg = "-1 * (1 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SHAKU.toBus(-1.0), delta);
        msg = "-0.1 * (1 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SHAKU.toBus(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SHAKU.toBus(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SHAKU.toBus(-73.25), delta);
        msg = "-56229.321 * (1 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SHAKU.toBus(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SHAKU.toBus(-873.5432456), delta);
        msg = "0 * (1 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SHAKU.toBus(0.0), delta);
        msg = "0.1 * (1 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SHAKU.toBus(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SHAKU.toBus(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SHAKU.toBus(0.33), delta);
        msg = "0.6543 * (1 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SHAKU.toBus(0.6543), delta);
        msg = "1 * (1 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SHAKU.toBus(1.0), delta);
        msg = "1.6543 * (1 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SHAKU.toBus(1.6543), delta);
        msg = "22.45 * (1 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SHAKU.toBus(22.45), delta);
        msg = "9876.5432 * (1 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SHAKU.toBus(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SHAKU.toBus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SHAKU.toBus(784.46789765434), delta);
        // ====================
        // ====================SUN
        // ====================
        // to_factor = 0.1
        to_factor = SUN.getFactor();
        msg = "-1 * (1 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SHAKU.toSuns(-1.0), delta);
        msg = "-0.1 * (1 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SHAKU.toSuns(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SHAKU.toSuns(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SHAKU.toSuns(-73.25), delta);
        msg = "-56229.321 * (1 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SHAKU.toSuns(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SHAKU.toSuns(-873.5432456), delta);
        msg = "0 * (1 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SHAKU.toSuns(0.0), delta);
        msg = "0.1 * (1 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SHAKU.toSuns(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SHAKU.toSuns(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SHAKU.toSuns(0.33), delta);
        msg = "0.6543 * (1 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SHAKU.toSuns(0.6543), delta);
        msg = "1 * (1 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SHAKU.toSuns(1.0), delta);
        msg = "1.6543 * (1 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SHAKU.toSuns(1.6543), delta);
        msg = "22.45 * (1 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SHAKU.toSuns(22.45), delta);
        msg = "9876.5432 * (1 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SHAKU.toSuns(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SHAKU.toSuns(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SHAKU.toSuns(784.46789765434), delta);
        // ====================
        // ====================SHAKU
        // ====================
        // to_factor = 1.0
        to_factor = SHAKU.getFactor();
        msg = "-1 * (1 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SHAKU.toShakus(-1.0), delta);
        msg = "-0.1 * (1 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SHAKU.toShakus(-0.1), delta);
        msg = "-0.000456789 * (1 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SHAKU.toShakus(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SHAKU.toShakus(-73.25), delta);
        msg = "-56229.321 * (1 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SHAKU.toShakus(-56229.321), delta);
        msg = "-873.5432456 * (1 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SHAKU.toShakus(-873.5432456), delta);
        msg = "0 * (1 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SHAKU.toShakus(0.0), delta);
        msg = "0.1 * (1 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SHAKU.toShakus(0.1), delta);
        msg = "0.0000876543297 * (1 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SHAKU.toShakus(8.76543297E-5), delta);
        msg = "0.33 * (1 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SHAKU.toShakus(0.33), delta);
        msg = "0.6543 * (1 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SHAKU.toShakus(0.6543), delta);
        msg = "1 * (1 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SHAKU.toShakus(1.0), delta);
        msg = "1.6543 * (1 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SHAKU.toShakus(1.6543), delta);
        msg = "22.45 * (1 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SHAKU.toShakus(22.45), delta);
        msg = "9876.5432 * (1 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SHAKU.toShakus(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SHAKU.toShakus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SHAKU.toShakus(784.46789765434), delta);
        // ====================
        // ====================KEN
        // ====================
        // to_factor = 6.0
        to_factor = KEN.getFactor();
        msg = "-1 / (6 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SHAKU.toKens(-1.0), delta);
        msg = "-0.1 / (6 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SHAKU.toKens(-0.1), delta);
        msg = "-0.000456789 / (6 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SHAKU.toKens(-4.56789E-4), delta);
        msg = "-73.25 / (6 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SHAKU.toKens(-73.25), delta);
        msg = "-56229.321 / (6 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SHAKU.toKens(-56229.321), delta);
        msg = "-873.5432456 / (6 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SHAKU.toKens(-873.5432456), delta);
        msg = "0 / (6 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SHAKU.toKens(0.0), delta);
        msg = "0.1 / (6 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SHAKU.toKens(0.1), delta);
        msg = "0.0000876543297 / (6 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SHAKU.toKens(8.76543297E-5), delta);
        msg = "0.33 / (6 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SHAKU.toKens(0.33), delta);
        msg = "0.6543 / (6 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SHAKU.toKens(0.6543), delta);
        msg = "1 / (6 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SHAKU.toKens(1.0), delta);
        msg = "1.6543 / (6 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SHAKU.toKens(1.6543), delta);
        msg = "22.45 / (6 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SHAKU.toKens(22.45), delta);
        msg = "9876.5432 / (6 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SHAKU.toKens(9876.5432), delta);
        msg = "1987654344.3345 / (6 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SHAKU.toKens(1.9876543443345E9), delta);
        msg = "784.46789765434 / (6 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SHAKU.toKens(784.46789765434), delta);
        // ====================
        // ====================JO
        // ====================
        // to_factor = 10.0
        to_factor = JO.getFactor();
        msg = "-1 / (10 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SHAKU.toJos(-1.0), delta);
        msg = "-0.1 / (10 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SHAKU.toJos(-0.1), delta);
        msg = "-0.000456789 / (10 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SHAKU.toJos(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SHAKU.toJos(-73.25), delta);
        msg = "-56229.321 / (10 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SHAKU.toJos(-56229.321), delta);
        msg = "-873.5432456 / (10 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SHAKU.toJos(-873.5432456), delta);
        msg = "0 / (10 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SHAKU.toJos(0.0), delta);
        msg = "0.1 / (10 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SHAKU.toJos(0.1), delta);
        msg = "0.0000876543297 / (10 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SHAKU.toJos(8.76543297E-5), delta);
        msg = "0.33 / (10 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SHAKU.toJos(0.33), delta);
        msg = "0.6543 / (10 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SHAKU.toJos(0.6543), delta);
        msg = "1 / (10 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SHAKU.toJos(1.0), delta);
        msg = "1.6543 / (10 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SHAKU.toJos(1.6543), delta);
        msg = "22.45 / (10 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SHAKU.toJos(22.45), delta);
        msg = "9876.5432 / (10 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SHAKU.toJos(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SHAKU.toJos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SHAKU.toJos(784.46789765434), delta);
        // ====================
        // ====================CHO
        // ====================
        // to_factor = 360.0
        to_factor = CHO.getFactor();
        msg = "-1 / (360 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SHAKU.toChos(-1.0), delta);
        msg = "-0.1 / (360 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SHAKU.toChos(-0.1), delta);
        msg = "-0.000456789 / (360 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SHAKU.toChos(-4.56789E-4), delta);
        msg = "-73.25 / (360 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SHAKU.toChos(-73.25), delta);
        msg = "-56229.321 / (360 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SHAKU.toChos(-56229.321), delta);
        msg = "-873.5432456 / (360 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SHAKU.toChos(-873.5432456), delta);
        msg = "0 / (360 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SHAKU.toChos(0.0), delta);
        msg = "0.1 / (360 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SHAKU.toChos(0.1), delta);
        msg = "0.0000876543297 / (360 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SHAKU.toChos(8.76543297E-5), delta);
        msg = "0.33 / (360 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SHAKU.toChos(0.33), delta);
        msg = "0.6543 / (360 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SHAKU.toChos(0.6543), delta);
        msg = "1 / (360 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SHAKU.toChos(1.0), delta);
        msg = "1.6543 / (360 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SHAKU.toChos(1.6543), delta);
        msg = "22.45 / (360 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SHAKU.toChos(22.45), delta);
        msg = "9876.5432 / (360 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SHAKU.toChos(9876.5432), delta);
        msg = "1987654344.3345 / (360 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SHAKU.toChos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (360 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SHAKU.toChos(784.46789765434), delta);
        // ====================
        // ====================RI
        // ====================
        // to_factor = 12960.0
        to_factor = RI.getFactor();
        msg = "-1 / (12960 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SHAKU.toRis(-1.0), delta);
        msg = "-0.1 / (12960 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SHAKU.toRis(-0.1), delta);
        msg = "-0.000456789 / (12960 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SHAKU.toRis(-4.56789E-4), delta);
        msg = "-73.25 / (12960 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SHAKU.toRis(-73.25), delta);
        msg = "-56229.321 / (12960 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SHAKU.toRis(-56229.321), delta);
        msg = "-873.5432456 / (12960 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SHAKU.toRis(-873.5432456), delta);
        msg = "0 / (12960 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SHAKU.toRis(0.0), delta);
        msg = "0.1 / (12960 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SHAKU.toRis(0.1), delta);
        msg = "0.0000876543297 / (12960 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SHAKU.toRis(8.76543297E-5), delta);
        msg = "0.33 / (12960 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SHAKU.toRis(0.33), delta);
        msg = "0.6543 / (12960 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SHAKU.toRis(0.6543), delta);
        msg = "1 / (12960 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SHAKU.toRis(1.0), delta);
        msg = "1.6543 / (12960 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SHAKU.toRis(1.6543), delta);
        msg = "22.45 / (12960 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SHAKU.toRis(22.45), delta);
        msg = "9876.5432 / (12960 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SHAKU.toRis(9876.5432), delta);
        msg = "1987654344.3345 / (12960 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SHAKU.toRis(1.9876543443345E9), delta);
        msg = "784.46789765434 / (12960 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SHAKU.toRis(784.46789765434), delta);
    }

    @Test()
    public void testKen() {
        // from_factor = 6.0
        double from_factor = KEN.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MO
        // ====================
        // to_factor = 1.0E-4
        to_factor = MO.getFactor();
        msg = "-1 * (6 / 0.0001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KEN.toMos(-1.0), delta);
        msg = "-0.1 * (6 / 0.0001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KEN.toMos(-0.1), delta);
        msg = "-0.000456789 * (6 / 0.0001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KEN.toMos(-4.56789E-4), delta);
        msg = "-73.25 * (6 / 0.0001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KEN.toMos(-73.25), delta);
        msg = "-56229.321 * (6 / 0.0001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KEN.toMos(-56229.321), delta);
        msg = "-873.5432456 * (6 / 0.0001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KEN.toMos(-873.5432456), delta);
        msg = "0 * (6 / 0.0001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KEN.toMos(0.0), delta);
        msg = "0.1 * (6 / 0.0001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KEN.toMos(0.1), delta);
        msg = "0.0000876543297 * (6 / 0.0001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KEN.toMos(8.76543297E-5), delta);
        msg = "0.33 * (6 / 0.0001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KEN.toMos(0.33), delta);
        msg = "0.6543 * (6 / 0.0001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KEN.toMos(0.6543), delta);
        msg = "1 * (6 / 0.0001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KEN.toMos(1.0), delta);
        msg = "1.6543 * (6 / 0.0001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KEN.toMos(1.6543), delta);
        msg = "22.45 * (6 / 0.0001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KEN.toMos(22.45), delta);
        msg = "9876.5432 * (6 / 0.0001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KEN.toMos(9876.5432), delta);
        msg = "1987654344.3345 * (6 / 0.0001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KEN.toMos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (6 / 0.0001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KEN.toMos(784.46789765434), delta);
        // ====================
        // ====================RIN
        // ====================
        // to_factor = 0.001
        to_factor = RIN.getFactor();
        msg = "-1 * (6 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KEN.toRins(-1.0), delta);
        msg = "-0.1 * (6 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KEN.toRins(-0.1), delta);
        msg = "-0.000456789 * (6 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KEN.toRins(-4.56789E-4), delta);
        msg = "-73.25 * (6 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KEN.toRins(-73.25), delta);
        msg = "-56229.321 * (6 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KEN.toRins(-56229.321), delta);
        msg = "-873.5432456 * (6 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KEN.toRins(-873.5432456), delta);
        msg = "0 * (6 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KEN.toRins(0.0), delta);
        msg = "0.1 * (6 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KEN.toRins(0.1), delta);
        msg = "0.0000876543297 * (6 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KEN.toRins(8.76543297E-5), delta);
        msg = "0.33 * (6 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KEN.toRins(0.33), delta);
        msg = "0.6543 * (6 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KEN.toRins(0.6543), delta);
        msg = "1 * (6 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KEN.toRins(1.0), delta);
        msg = "1.6543 * (6 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KEN.toRins(1.6543), delta);
        msg = "22.45 * (6 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KEN.toRins(22.45), delta);
        msg = "9876.5432 * (6 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KEN.toRins(9876.5432), delta);
        msg = "1987654344.3345 * (6 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KEN.toRins(1.9876543443345E9), delta);
        msg = "784.46789765434 * (6 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KEN.toRins(784.46789765434), delta);
        // ====================
        // ====================BU
        // ====================
        // to_factor = 0.01
        to_factor = BU.getFactor();
        msg = "-1 * (6 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KEN.toBus(-1.0), delta);
        msg = "-0.1 * (6 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KEN.toBus(-0.1), delta);
        msg = "-0.000456789 * (6 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KEN.toBus(-4.56789E-4), delta);
        msg = "-73.25 * (6 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KEN.toBus(-73.25), delta);
        msg = "-56229.321 * (6 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KEN.toBus(-56229.321), delta);
        msg = "-873.5432456 * (6 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KEN.toBus(-873.5432456), delta);
        msg = "0 * (6 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KEN.toBus(0.0), delta);
        msg = "0.1 * (6 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KEN.toBus(0.1), delta);
        msg = "0.0000876543297 * (6 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KEN.toBus(8.76543297E-5), delta);
        msg = "0.33 * (6 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KEN.toBus(0.33), delta);
        msg = "0.6543 * (6 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KEN.toBus(0.6543), delta);
        msg = "1 * (6 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KEN.toBus(1.0), delta);
        msg = "1.6543 * (6 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KEN.toBus(1.6543), delta);
        msg = "22.45 * (6 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KEN.toBus(22.45), delta);
        msg = "9876.5432 * (6 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KEN.toBus(9876.5432), delta);
        msg = "1987654344.3345 * (6 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KEN.toBus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (6 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KEN.toBus(784.46789765434), delta);
        // ====================
        // ====================SUN
        // ====================
        // to_factor = 0.1
        to_factor = SUN.getFactor();
        msg = "-1 * (6 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KEN.toSuns(-1.0), delta);
        msg = "-0.1 * (6 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KEN.toSuns(-0.1), delta);
        msg = "-0.000456789 * (6 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KEN.toSuns(-4.56789E-4), delta);
        msg = "-73.25 * (6 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KEN.toSuns(-73.25), delta);
        msg = "-56229.321 * (6 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KEN.toSuns(-56229.321), delta);
        msg = "-873.5432456 * (6 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KEN.toSuns(-873.5432456), delta);
        msg = "0 * (6 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KEN.toSuns(0.0), delta);
        msg = "0.1 * (6 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KEN.toSuns(0.1), delta);
        msg = "0.0000876543297 * (6 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KEN.toSuns(8.76543297E-5), delta);
        msg = "0.33 * (6 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KEN.toSuns(0.33), delta);
        msg = "0.6543 * (6 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KEN.toSuns(0.6543), delta);
        msg = "1 * (6 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KEN.toSuns(1.0), delta);
        msg = "1.6543 * (6 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KEN.toSuns(1.6543), delta);
        msg = "22.45 * (6 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KEN.toSuns(22.45), delta);
        msg = "9876.5432 * (6 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KEN.toSuns(9876.5432), delta);
        msg = "1987654344.3345 * (6 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KEN.toSuns(1.9876543443345E9), delta);
        msg = "784.46789765434 * (6 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KEN.toSuns(784.46789765434), delta);
        // ====================
        // ====================SHAKU
        // ====================
        // to_factor = 1.0
        to_factor = SHAKU.getFactor();
        msg = "-1 * (6 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KEN.toShakus(-1.0), delta);
        msg = "-0.1 * (6 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KEN.toShakus(-0.1), delta);
        msg = "-0.000456789 * (6 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KEN.toShakus(-4.56789E-4), delta);
        msg = "-73.25 * (6 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KEN.toShakus(-73.25), delta);
        msg = "-56229.321 * (6 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KEN.toShakus(-56229.321), delta);
        msg = "-873.5432456 * (6 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KEN.toShakus(-873.5432456), delta);
        msg = "0 * (6 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KEN.toShakus(0.0), delta);
        msg = "0.1 * (6 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KEN.toShakus(0.1), delta);
        msg = "0.0000876543297 * (6 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KEN.toShakus(8.76543297E-5), delta);
        msg = "0.33 * (6 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KEN.toShakus(0.33), delta);
        msg = "0.6543 * (6 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KEN.toShakus(0.6543), delta);
        msg = "1 * (6 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KEN.toShakus(1.0), delta);
        msg = "1.6543 * (6 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KEN.toShakus(1.6543), delta);
        msg = "22.45 * (6 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KEN.toShakus(22.45), delta);
        msg = "9876.5432 * (6 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KEN.toShakus(9876.5432), delta);
        msg = "1987654344.3345 * (6 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KEN.toShakus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (6 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KEN.toShakus(784.46789765434), delta);
        // ====================
        // ====================KEN
        // ====================
        // to_factor = 6.0
        to_factor = KEN.getFactor();
        msg = "-1 * (6 / 6)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KEN.toKens(-1.0), delta);
        msg = "-0.1 * (6 / 6)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KEN.toKens(-0.1), delta);
        msg = "-0.000456789 * (6 / 6)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KEN.toKens(-4.56789E-4), delta);
        msg = "-73.25 * (6 / 6)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KEN.toKens(-73.25), delta);
        msg = "-56229.321 * (6 / 6)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KEN.toKens(-56229.321), delta);
        msg = "-873.5432456 * (6 / 6)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KEN.toKens(-873.5432456), delta);
        msg = "0 * (6 / 6)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KEN.toKens(0.0), delta);
        msg = "0.1 * (6 / 6)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KEN.toKens(0.1), delta);
        msg = "0.0000876543297 * (6 / 6)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KEN.toKens(8.76543297E-5), delta);
        msg = "0.33 * (6 / 6)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KEN.toKens(0.33), delta);
        msg = "0.6543 * (6 / 6)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KEN.toKens(0.6543), delta);
        msg = "1 * (6 / 6)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KEN.toKens(1.0), delta);
        msg = "1.6543 * (6 / 6)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KEN.toKens(1.6543), delta);
        msg = "22.45 * (6 / 6)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KEN.toKens(22.45), delta);
        msg = "9876.5432 * (6 / 6)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KEN.toKens(9876.5432), delta);
        msg = "1987654344.3345 * (6 / 6)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KEN.toKens(1.9876543443345E9), delta);
        msg = "784.46789765434 * (6 / 6)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KEN.toKens(784.46789765434), delta);
        // ====================
        // ====================JO
        // ====================
        // to_factor = 10.0
        to_factor = JO.getFactor();
        msg = "-1 / (10 / 6)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), KEN.toJos(-1.0), delta);
        msg = "-0.1 / (10 / 6)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), KEN.toJos(-0.1), delta);
        msg = "-0.000456789 / (10 / 6)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), KEN.toJos(-4.56789E-4), delta);
        msg = "-73.25 / (10 / 6)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), KEN.toJos(-73.25), delta);
        msg = "-56229.321 / (10 / 6)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), KEN.toJos(-56229.321), delta);
        msg = "-873.5432456 / (10 / 6)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), KEN.toJos(-873.5432456), delta);
        msg = "0 / (10 / 6)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), KEN.toJos(0.0), delta);
        msg = "0.1 / (10 / 6)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), KEN.toJos(0.1), delta);
        msg = "0.0000876543297 / (10 / 6)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), KEN.toJos(8.76543297E-5), delta);
        msg = "0.33 / (10 / 6)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), KEN.toJos(0.33), delta);
        msg = "0.6543 / (10 / 6)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), KEN.toJos(0.6543), delta);
        msg = "1 / (10 / 6)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), KEN.toJos(1.0), delta);
        msg = "1.6543 / (10 / 6)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), KEN.toJos(1.6543), delta);
        msg = "22.45 / (10 / 6)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), KEN.toJos(22.45), delta);
        msg = "9876.5432 / (10 / 6)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), KEN.toJos(9876.5432), delta);
        msg = "1987654344.3345 / (10 / 6)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), KEN.toJos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (10 / 6)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), KEN.toJos(784.46789765434), delta);
        // ====================
        // ====================CHO
        // ====================
        // to_factor = 360.0
        to_factor = CHO.getFactor();
        msg = "-1 / (360 / 6)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), KEN.toChos(-1.0), delta);
        msg = "-0.1 / (360 / 6)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), KEN.toChos(-0.1), delta);
        msg = "-0.000456789 / (360 / 6)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), KEN.toChos(-4.56789E-4), delta);
        msg = "-73.25 / (360 / 6)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), KEN.toChos(-73.25), delta);
        msg = "-56229.321 / (360 / 6)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), KEN.toChos(-56229.321), delta);
        msg = "-873.5432456 / (360 / 6)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), KEN.toChos(-873.5432456), delta);
        msg = "0 / (360 / 6)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), KEN.toChos(0.0), delta);
        msg = "0.1 / (360 / 6)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), KEN.toChos(0.1), delta);
        msg = "0.0000876543297 / (360 / 6)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), KEN.toChos(8.76543297E-5), delta);
        msg = "0.33 / (360 / 6)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), KEN.toChos(0.33), delta);
        msg = "0.6543 / (360 / 6)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), KEN.toChos(0.6543), delta);
        msg = "1 / (360 / 6)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), KEN.toChos(1.0), delta);
        msg = "1.6543 / (360 / 6)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), KEN.toChos(1.6543), delta);
        msg = "22.45 / (360 / 6)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), KEN.toChos(22.45), delta);
        msg = "9876.5432 / (360 / 6)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), KEN.toChos(9876.5432), delta);
        msg = "1987654344.3345 / (360 / 6)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), KEN.toChos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (360 / 6)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), KEN.toChos(784.46789765434), delta);
        // ====================
        // ====================RI
        // ====================
        // to_factor = 12960.0
        to_factor = RI.getFactor();
        msg = "-1 / (12960 / 6)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), KEN.toRis(-1.0), delta);
        msg = "-0.1 / (12960 / 6)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), KEN.toRis(-0.1), delta);
        msg = "-0.000456789 / (12960 / 6)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), KEN.toRis(-4.56789E-4), delta);
        msg = "-73.25 / (12960 / 6)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), KEN.toRis(-73.25), delta);
        msg = "-56229.321 / (12960 / 6)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), KEN.toRis(-56229.321), delta);
        msg = "-873.5432456 / (12960 / 6)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), KEN.toRis(-873.5432456), delta);
        msg = "0 / (12960 / 6)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), KEN.toRis(0.0), delta);
        msg = "0.1 / (12960 / 6)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), KEN.toRis(0.1), delta);
        msg = "0.0000876543297 / (12960 / 6)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), KEN.toRis(8.76543297E-5), delta);
        msg = "0.33 / (12960 / 6)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), KEN.toRis(0.33), delta);
        msg = "0.6543 / (12960 / 6)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), KEN.toRis(0.6543), delta);
        msg = "1 / (12960 / 6)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), KEN.toRis(1.0), delta);
        msg = "1.6543 / (12960 / 6)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), KEN.toRis(1.6543), delta);
        msg = "22.45 / (12960 / 6)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), KEN.toRis(22.45), delta);
        msg = "9876.5432 / (12960 / 6)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), KEN.toRis(9876.5432), delta);
        msg = "1987654344.3345 / (12960 / 6)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), KEN.toRis(1.9876543443345E9), delta);
        msg = "784.46789765434 / (12960 / 6)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), KEN.toRis(784.46789765434), delta);
    }

    @Test()
    public void testJo() {
        // from_factor = 10.0
        double from_factor = JO.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MO
        // ====================
        // to_factor = 1.0E-4
        to_factor = MO.getFactor();
        msg = "-1 * (10 / 0.0001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), JO.toMos(-1.0), delta);
        msg = "-0.1 * (10 / 0.0001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), JO.toMos(-0.1), delta);
        msg = "-0.000456789 * (10 / 0.0001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), JO.toMos(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 0.0001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), JO.toMos(-73.25), delta);
        msg = "-56229.321 * (10 / 0.0001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), JO.toMos(-56229.321), delta);
        msg = "-873.5432456 * (10 / 0.0001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), JO.toMos(-873.5432456), delta);
        msg = "0 * (10 / 0.0001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), JO.toMos(0.0), delta);
        msg = "0.1 * (10 / 0.0001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), JO.toMos(0.1), delta);
        msg = "0.0000876543297 * (10 / 0.0001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), JO.toMos(8.76543297E-5), delta);
        msg = "0.33 * (10 / 0.0001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), JO.toMos(0.33), delta);
        msg = "0.6543 * (10 / 0.0001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), JO.toMos(0.6543), delta);
        msg = "1 * (10 / 0.0001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), JO.toMos(1.0), delta);
        msg = "1.6543 * (10 / 0.0001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), JO.toMos(1.6543), delta);
        msg = "22.45 * (10 / 0.0001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), JO.toMos(22.45), delta);
        msg = "9876.5432 * (10 / 0.0001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), JO.toMos(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 0.0001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), JO.toMos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 0.0001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), JO.toMos(784.46789765434), delta);
        // ====================
        // ====================RIN
        // ====================
        // to_factor = 0.001
        to_factor = RIN.getFactor();
        msg = "-1 * (10 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), JO.toRins(-1.0), delta);
        msg = "-0.1 * (10 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), JO.toRins(-0.1), delta);
        msg = "-0.000456789 * (10 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), JO.toRins(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), JO.toRins(-73.25), delta);
        msg = "-56229.321 * (10 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), JO.toRins(-56229.321), delta);
        msg = "-873.5432456 * (10 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), JO.toRins(-873.5432456), delta);
        msg = "0 * (10 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), JO.toRins(0.0), delta);
        msg = "0.1 * (10 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), JO.toRins(0.1), delta);
        msg = "0.0000876543297 * (10 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), JO.toRins(8.76543297E-5), delta);
        msg = "0.33 * (10 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), JO.toRins(0.33), delta);
        msg = "0.6543 * (10 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), JO.toRins(0.6543), delta);
        msg = "1 * (10 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), JO.toRins(1.0), delta);
        msg = "1.6543 * (10 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), JO.toRins(1.6543), delta);
        msg = "22.45 * (10 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), JO.toRins(22.45), delta);
        msg = "9876.5432 * (10 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), JO.toRins(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), JO.toRins(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), JO.toRins(784.46789765434), delta);
        // ====================
        // ====================BU
        // ====================
        // to_factor = 0.01
        to_factor = BU.getFactor();
        msg = "-1 * (10 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), JO.toBus(-1.0), delta);
        msg = "-0.1 * (10 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), JO.toBus(-0.1), delta);
        msg = "-0.000456789 * (10 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), JO.toBus(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), JO.toBus(-73.25), delta);
        msg = "-56229.321 * (10 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), JO.toBus(-56229.321), delta);
        msg = "-873.5432456 * (10 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), JO.toBus(-873.5432456), delta);
        msg = "0 * (10 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), JO.toBus(0.0), delta);
        msg = "0.1 * (10 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), JO.toBus(0.1), delta);
        msg = "0.0000876543297 * (10 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), JO.toBus(8.76543297E-5), delta);
        msg = "0.33 * (10 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), JO.toBus(0.33), delta);
        msg = "0.6543 * (10 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), JO.toBus(0.6543), delta);
        msg = "1 * (10 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), JO.toBus(1.0), delta);
        msg = "1.6543 * (10 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), JO.toBus(1.6543), delta);
        msg = "22.45 * (10 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), JO.toBus(22.45), delta);
        msg = "9876.5432 * (10 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), JO.toBus(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), JO.toBus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), JO.toBus(784.46789765434), delta);
        // ====================
        // ====================SUN
        // ====================
        // to_factor = 0.1
        to_factor = SUN.getFactor();
        msg = "-1 * (10 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), JO.toSuns(-1.0), delta);
        msg = "-0.1 * (10 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), JO.toSuns(-0.1), delta);
        msg = "-0.000456789 * (10 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), JO.toSuns(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), JO.toSuns(-73.25), delta);
        msg = "-56229.321 * (10 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), JO.toSuns(-56229.321), delta);
        msg = "-873.5432456 * (10 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), JO.toSuns(-873.5432456), delta);
        msg = "0 * (10 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), JO.toSuns(0.0), delta);
        msg = "0.1 * (10 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), JO.toSuns(0.1), delta);
        msg = "0.0000876543297 * (10 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), JO.toSuns(8.76543297E-5), delta);
        msg = "0.33 * (10 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), JO.toSuns(0.33), delta);
        msg = "0.6543 * (10 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), JO.toSuns(0.6543), delta);
        msg = "1 * (10 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), JO.toSuns(1.0), delta);
        msg = "1.6543 * (10 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), JO.toSuns(1.6543), delta);
        msg = "22.45 * (10 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), JO.toSuns(22.45), delta);
        msg = "9876.5432 * (10 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), JO.toSuns(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), JO.toSuns(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), JO.toSuns(784.46789765434), delta);
        // ====================
        // ====================SHAKU
        // ====================
        // to_factor = 1.0
        to_factor = SHAKU.getFactor();
        msg = "-1 * (10 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), JO.toShakus(-1.0), delta);
        msg = "-0.1 * (10 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), JO.toShakus(-0.1), delta);
        msg = "-0.000456789 * (10 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), JO.toShakus(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), JO.toShakus(-73.25), delta);
        msg = "-56229.321 * (10 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), JO.toShakus(-56229.321), delta);
        msg = "-873.5432456 * (10 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), JO.toShakus(-873.5432456), delta);
        msg = "0 * (10 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), JO.toShakus(0.0), delta);
        msg = "0.1 * (10 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), JO.toShakus(0.1), delta);
        msg = "0.0000876543297 * (10 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), JO.toShakus(8.76543297E-5), delta);
        msg = "0.33 * (10 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), JO.toShakus(0.33), delta);
        msg = "0.6543 * (10 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), JO.toShakus(0.6543), delta);
        msg = "1 * (10 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), JO.toShakus(1.0), delta);
        msg = "1.6543 * (10 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), JO.toShakus(1.6543), delta);
        msg = "22.45 * (10 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), JO.toShakus(22.45), delta);
        msg = "9876.5432 * (10 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), JO.toShakus(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), JO.toShakus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), JO.toShakus(784.46789765434), delta);
        // ====================
        // ====================KEN
        // ====================
        // to_factor = 6.0
        to_factor = KEN.getFactor();
        msg = "-1 * (10 / 6)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), JO.toKens(-1.0), delta);
        msg = "-0.1 * (10 / 6)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), JO.toKens(-0.1), delta);
        msg = "-0.000456789 * (10 / 6)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), JO.toKens(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 6)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), JO.toKens(-73.25), delta);
        msg = "-56229.321 * (10 / 6)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), JO.toKens(-56229.321), delta);
        msg = "-873.5432456 * (10 / 6)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), JO.toKens(-873.5432456), delta);
        msg = "0 * (10 / 6)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), JO.toKens(0.0), delta);
        msg = "0.1 * (10 / 6)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), JO.toKens(0.1), delta);
        msg = "0.0000876543297 * (10 / 6)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), JO.toKens(8.76543297E-5), delta);
        msg = "0.33 * (10 / 6)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), JO.toKens(0.33), delta);
        msg = "0.6543 * (10 / 6)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), JO.toKens(0.6543), delta);
        msg = "1 * (10 / 6)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), JO.toKens(1.0), delta);
        msg = "1.6543 * (10 / 6)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), JO.toKens(1.6543), delta);
        msg = "22.45 * (10 / 6)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), JO.toKens(22.45), delta);
        msg = "9876.5432 * (10 / 6)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), JO.toKens(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 6)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), JO.toKens(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 6)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), JO.toKens(784.46789765434), delta);
        // ====================
        // ====================JO
        // ====================
        // to_factor = 10.0
        to_factor = JO.getFactor();
        msg = "-1 * (10 / 10)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), JO.toJos(-1.0), delta);
        msg = "-0.1 * (10 / 10)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), JO.toJos(-0.1), delta);
        msg = "-0.000456789 * (10 / 10)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), JO.toJos(-4.56789E-4), delta);
        msg = "-73.25 * (10 / 10)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), JO.toJos(-73.25), delta);
        msg = "-56229.321 * (10 / 10)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), JO.toJos(-56229.321), delta);
        msg = "-873.5432456 * (10 / 10)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), JO.toJos(-873.5432456), delta);
        msg = "0 * (10 / 10)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), JO.toJos(0.0), delta);
        msg = "0.1 * (10 / 10)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), JO.toJos(0.1), delta);
        msg = "0.0000876543297 * (10 / 10)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), JO.toJos(8.76543297E-5), delta);
        msg = "0.33 * (10 / 10)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), JO.toJos(0.33), delta);
        msg = "0.6543 * (10 / 10)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), JO.toJos(0.6543), delta);
        msg = "1 * (10 / 10)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), JO.toJos(1.0), delta);
        msg = "1.6543 * (10 / 10)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), JO.toJos(1.6543), delta);
        msg = "22.45 * (10 / 10)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), JO.toJos(22.45), delta);
        msg = "9876.5432 * (10 / 10)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), JO.toJos(9876.5432), delta);
        msg = "1987654344.3345 * (10 / 10)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), JO.toJos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (10 / 10)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), JO.toJos(784.46789765434), delta);
        // ====================
        // ====================CHO
        // ====================
        // to_factor = 360.0
        to_factor = CHO.getFactor();
        msg = "-1 / (360 / 10)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), JO.toChos(-1.0), delta);
        msg = "-0.1 / (360 / 10)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), JO.toChos(-0.1), delta);
        msg = "-0.000456789 / (360 / 10)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), JO.toChos(-4.56789E-4), delta);
        msg = "-73.25 / (360 / 10)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), JO.toChos(-73.25), delta);
        msg = "-56229.321 / (360 / 10)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), JO.toChos(-56229.321), delta);
        msg = "-873.5432456 / (360 / 10)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), JO.toChos(-873.5432456), delta);
        msg = "0 / (360 / 10)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), JO.toChos(0.0), delta);
        msg = "0.1 / (360 / 10)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), JO.toChos(0.1), delta);
        msg = "0.0000876543297 / (360 / 10)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), JO.toChos(8.76543297E-5), delta);
        msg = "0.33 / (360 / 10)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), JO.toChos(0.33), delta);
        msg = "0.6543 / (360 / 10)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), JO.toChos(0.6543), delta);
        msg = "1 / (360 / 10)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), JO.toChos(1.0), delta);
        msg = "1.6543 / (360 / 10)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), JO.toChos(1.6543), delta);
        msg = "22.45 / (360 / 10)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), JO.toChos(22.45), delta);
        msg = "9876.5432 / (360 / 10)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), JO.toChos(9876.5432), delta);
        msg = "1987654344.3345 / (360 / 10)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), JO.toChos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (360 / 10)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), JO.toChos(784.46789765434), delta);
        // ====================
        // ====================RI
        // ====================
        // to_factor = 12960.0
        to_factor = RI.getFactor();
        msg = "-1 / (12960 / 10)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), JO.toRis(-1.0), delta);
        msg = "-0.1 / (12960 / 10)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), JO.toRis(-0.1), delta);
        msg = "-0.000456789 / (12960 / 10)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), JO.toRis(-4.56789E-4), delta);
        msg = "-73.25 / (12960 / 10)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), JO.toRis(-73.25), delta);
        msg = "-56229.321 / (12960 / 10)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), JO.toRis(-56229.321), delta);
        msg = "-873.5432456 / (12960 / 10)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), JO.toRis(-873.5432456), delta);
        msg = "0 / (12960 / 10)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), JO.toRis(0.0), delta);
        msg = "0.1 / (12960 / 10)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), JO.toRis(0.1), delta);
        msg = "0.0000876543297 / (12960 / 10)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), JO.toRis(8.76543297E-5), delta);
        msg = "0.33 / (12960 / 10)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), JO.toRis(0.33), delta);
        msg = "0.6543 / (12960 / 10)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), JO.toRis(0.6543), delta);
        msg = "1 / (12960 / 10)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), JO.toRis(1.0), delta);
        msg = "1.6543 / (12960 / 10)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), JO.toRis(1.6543), delta);
        msg = "22.45 / (12960 / 10)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), JO.toRis(22.45), delta);
        msg = "9876.5432 / (12960 / 10)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), JO.toRis(9876.5432), delta);
        msg = "1987654344.3345 / (12960 / 10)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), JO.toRis(1.9876543443345E9), delta);
        msg = "784.46789765434 / (12960 / 10)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), JO.toRis(784.46789765434), delta);
    }

    @Test()
    public void testCho() {
        // from_factor = 360.0
        double from_factor = CHO.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MO
        // ====================
        // to_factor = 1.0E-4
        to_factor = MO.getFactor();
        msg = "-1 * (360 / 0.0001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CHO.toMos(-1.0), delta);
        msg = "-0.1 * (360 / 0.0001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CHO.toMos(-0.1), delta);
        msg = "-0.000456789 * (360 / 0.0001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CHO.toMos(-4.56789E-4), delta);
        msg = "-73.25 * (360 / 0.0001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CHO.toMos(-73.25), delta);
        msg = "-56229.321 * (360 / 0.0001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CHO.toMos(-56229.321), delta);
        msg = "-873.5432456 * (360 / 0.0001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CHO.toMos(-873.5432456), delta);
        msg = "0 * (360 / 0.0001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CHO.toMos(0.0), delta);
        msg = "0.1 * (360 / 0.0001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CHO.toMos(0.1), delta);
        msg = "0.0000876543297 * (360 / 0.0001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CHO.toMos(8.76543297E-5), delta);
        msg = "0.33 * (360 / 0.0001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CHO.toMos(0.33), delta);
        msg = "0.6543 * (360 / 0.0001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CHO.toMos(0.6543), delta);
        msg = "1 * (360 / 0.0001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CHO.toMos(1.0), delta);
        msg = "1.6543 * (360 / 0.0001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CHO.toMos(1.6543), delta);
        msg = "22.45 * (360 / 0.0001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CHO.toMos(22.45), delta);
        msg = "9876.5432 * (360 / 0.0001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CHO.toMos(9876.5432), delta);
        msg = "1987654344.3345 * (360 / 0.0001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CHO.toMos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (360 / 0.0001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CHO.toMos(784.46789765434), delta);
        // ====================
        // ====================RIN
        // ====================
        // to_factor = 0.001
        to_factor = RIN.getFactor();
        msg = "-1 * (360 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CHO.toRins(-1.0), delta);
        msg = "-0.1 * (360 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CHO.toRins(-0.1), delta);
        msg = "-0.000456789 * (360 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CHO.toRins(-4.56789E-4), delta);
        msg = "-73.25 * (360 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CHO.toRins(-73.25), delta);
        msg = "-56229.321 * (360 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CHO.toRins(-56229.321), delta);
        msg = "-873.5432456 * (360 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CHO.toRins(-873.5432456), delta);
        msg = "0 * (360 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CHO.toRins(0.0), delta);
        msg = "0.1 * (360 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CHO.toRins(0.1), delta);
        msg = "0.0000876543297 * (360 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CHO.toRins(8.76543297E-5), delta);
        msg = "0.33 * (360 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CHO.toRins(0.33), delta);
        msg = "0.6543 * (360 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CHO.toRins(0.6543), delta);
        msg = "1 * (360 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CHO.toRins(1.0), delta);
        msg = "1.6543 * (360 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CHO.toRins(1.6543), delta);
        msg = "22.45 * (360 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CHO.toRins(22.45), delta);
        msg = "9876.5432 * (360 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CHO.toRins(9876.5432), delta);
        msg = "1987654344.3345 * (360 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CHO.toRins(1.9876543443345E9), delta);
        msg = "784.46789765434 * (360 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CHO.toRins(784.46789765434), delta);
        // ====================
        // ====================BU
        // ====================
        // to_factor = 0.01
        to_factor = BU.getFactor();
        msg = "-1 * (360 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CHO.toBus(-1.0), delta);
        msg = "-0.1 * (360 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CHO.toBus(-0.1), delta);
        msg = "-0.000456789 * (360 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CHO.toBus(-4.56789E-4), delta);
        msg = "-73.25 * (360 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CHO.toBus(-73.25), delta);
        msg = "-56229.321 * (360 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CHO.toBus(-56229.321), delta);
        msg = "-873.5432456 * (360 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CHO.toBus(-873.5432456), delta);
        msg = "0 * (360 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CHO.toBus(0.0), delta);
        msg = "0.1 * (360 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CHO.toBus(0.1), delta);
        msg = "0.0000876543297 * (360 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CHO.toBus(8.76543297E-5), delta);
        msg = "0.33 * (360 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CHO.toBus(0.33), delta);
        msg = "0.6543 * (360 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CHO.toBus(0.6543), delta);
        msg = "1 * (360 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CHO.toBus(1.0), delta);
        msg = "1.6543 * (360 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CHO.toBus(1.6543), delta);
        msg = "22.45 * (360 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CHO.toBus(22.45), delta);
        msg = "9876.5432 * (360 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CHO.toBus(9876.5432), delta);
        msg = "1987654344.3345 * (360 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CHO.toBus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (360 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CHO.toBus(784.46789765434), delta);
        // ====================
        // ====================SUN
        // ====================
        // to_factor = 0.1
        to_factor = SUN.getFactor();
        msg = "-1 * (360 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CHO.toSuns(-1.0), delta);
        msg = "-0.1 * (360 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CHO.toSuns(-0.1), delta);
        msg = "-0.000456789 * (360 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CHO.toSuns(-4.56789E-4), delta);
        msg = "-73.25 * (360 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CHO.toSuns(-73.25), delta);
        msg = "-56229.321 * (360 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CHO.toSuns(-56229.321), delta);
        msg = "-873.5432456 * (360 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CHO.toSuns(-873.5432456), delta);
        msg = "0 * (360 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CHO.toSuns(0.0), delta);
        msg = "0.1 * (360 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CHO.toSuns(0.1), delta);
        msg = "0.0000876543297 * (360 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CHO.toSuns(8.76543297E-5), delta);
        msg = "0.33 * (360 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CHO.toSuns(0.33), delta);
        msg = "0.6543 * (360 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CHO.toSuns(0.6543), delta);
        msg = "1 * (360 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CHO.toSuns(1.0), delta);
        msg = "1.6543 * (360 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CHO.toSuns(1.6543), delta);
        msg = "22.45 * (360 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CHO.toSuns(22.45), delta);
        msg = "9876.5432 * (360 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CHO.toSuns(9876.5432), delta);
        msg = "1987654344.3345 * (360 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CHO.toSuns(1.9876543443345E9), delta);
        msg = "784.46789765434 * (360 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CHO.toSuns(784.46789765434), delta);
        // ====================
        // ====================SHAKU
        // ====================
        // to_factor = 1.0
        to_factor = SHAKU.getFactor();
        msg = "-1 * (360 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CHO.toShakus(-1.0), delta);
        msg = "-0.1 * (360 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CHO.toShakus(-0.1), delta);
        msg = "-0.000456789 * (360 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CHO.toShakus(-4.56789E-4), delta);
        msg = "-73.25 * (360 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CHO.toShakus(-73.25), delta);
        msg = "-56229.321 * (360 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CHO.toShakus(-56229.321), delta);
        msg = "-873.5432456 * (360 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CHO.toShakus(-873.5432456), delta);
        msg = "0 * (360 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CHO.toShakus(0.0), delta);
        msg = "0.1 * (360 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CHO.toShakus(0.1), delta);
        msg = "0.0000876543297 * (360 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CHO.toShakus(8.76543297E-5), delta);
        msg = "0.33 * (360 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CHO.toShakus(0.33), delta);
        msg = "0.6543 * (360 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CHO.toShakus(0.6543), delta);
        msg = "1 * (360 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CHO.toShakus(1.0), delta);
        msg = "1.6543 * (360 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CHO.toShakus(1.6543), delta);
        msg = "22.45 * (360 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CHO.toShakus(22.45), delta);
        msg = "9876.5432 * (360 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CHO.toShakus(9876.5432), delta);
        msg = "1987654344.3345 * (360 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CHO.toShakus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (360 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CHO.toShakus(784.46789765434), delta);
        // ====================
        // ====================KEN
        // ====================
        // to_factor = 6.0
        to_factor = KEN.getFactor();
        msg = "-1 * (360 / 6)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CHO.toKens(-1.0), delta);
        msg = "-0.1 * (360 / 6)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CHO.toKens(-0.1), delta);
        msg = "-0.000456789 * (360 / 6)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CHO.toKens(-4.56789E-4), delta);
        msg = "-73.25 * (360 / 6)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CHO.toKens(-73.25), delta);
        msg = "-56229.321 * (360 / 6)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CHO.toKens(-56229.321), delta);
        msg = "-873.5432456 * (360 / 6)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CHO.toKens(-873.5432456), delta);
        msg = "0 * (360 / 6)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CHO.toKens(0.0), delta);
        msg = "0.1 * (360 / 6)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CHO.toKens(0.1), delta);
        msg = "0.0000876543297 * (360 / 6)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CHO.toKens(8.76543297E-5), delta);
        msg = "0.33 * (360 / 6)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CHO.toKens(0.33), delta);
        msg = "0.6543 * (360 / 6)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CHO.toKens(0.6543), delta);
        msg = "1 * (360 / 6)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CHO.toKens(1.0), delta);
        msg = "1.6543 * (360 / 6)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CHO.toKens(1.6543), delta);
        msg = "22.45 * (360 / 6)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CHO.toKens(22.45), delta);
        msg = "9876.5432 * (360 / 6)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CHO.toKens(9876.5432), delta);
        msg = "1987654344.3345 * (360 / 6)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CHO.toKens(1.9876543443345E9), delta);
        msg = "784.46789765434 * (360 / 6)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CHO.toKens(784.46789765434), delta);
        // ====================
        // ====================JO
        // ====================
        // to_factor = 10.0
        to_factor = JO.getFactor();
        msg = "-1 * (360 / 10)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CHO.toJos(-1.0), delta);
        msg = "-0.1 * (360 / 10)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CHO.toJos(-0.1), delta);
        msg = "-0.000456789 * (360 / 10)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CHO.toJos(-4.56789E-4), delta);
        msg = "-73.25 * (360 / 10)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CHO.toJos(-73.25), delta);
        msg = "-56229.321 * (360 / 10)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CHO.toJos(-56229.321), delta);
        msg = "-873.5432456 * (360 / 10)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CHO.toJos(-873.5432456), delta);
        msg = "0 * (360 / 10)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CHO.toJos(0.0), delta);
        msg = "0.1 * (360 / 10)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CHO.toJos(0.1), delta);
        msg = "0.0000876543297 * (360 / 10)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CHO.toJos(8.76543297E-5), delta);
        msg = "0.33 * (360 / 10)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CHO.toJos(0.33), delta);
        msg = "0.6543 * (360 / 10)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CHO.toJos(0.6543), delta);
        msg = "1 * (360 / 10)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CHO.toJos(1.0), delta);
        msg = "1.6543 * (360 / 10)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CHO.toJos(1.6543), delta);
        msg = "22.45 * (360 / 10)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CHO.toJos(22.45), delta);
        msg = "9876.5432 * (360 / 10)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CHO.toJos(9876.5432), delta);
        msg = "1987654344.3345 * (360 / 10)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CHO.toJos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (360 / 10)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CHO.toJos(784.46789765434), delta);
        // ====================
        // ====================CHO
        // ====================
        // to_factor = 360.0
        to_factor = CHO.getFactor();
        msg = "-1 * (360 / 360)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CHO.toChos(-1.0), delta);
        msg = "-0.1 * (360 / 360)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CHO.toChos(-0.1), delta);
        msg = "-0.000456789 * (360 / 360)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CHO.toChos(-4.56789E-4), delta);
        msg = "-73.25 * (360 / 360)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CHO.toChos(-73.25), delta);
        msg = "-56229.321 * (360 / 360)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CHO.toChos(-56229.321), delta);
        msg = "-873.5432456 * (360 / 360)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CHO.toChos(-873.5432456), delta);
        msg = "0 * (360 / 360)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CHO.toChos(0.0), delta);
        msg = "0.1 * (360 / 360)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CHO.toChos(0.1), delta);
        msg = "0.0000876543297 * (360 / 360)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CHO.toChos(8.76543297E-5), delta);
        msg = "0.33 * (360 / 360)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CHO.toChos(0.33), delta);
        msg = "0.6543 * (360 / 360)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CHO.toChos(0.6543), delta);
        msg = "1 * (360 / 360)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CHO.toChos(1.0), delta);
        msg = "1.6543 * (360 / 360)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CHO.toChos(1.6543), delta);
        msg = "22.45 * (360 / 360)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CHO.toChos(22.45), delta);
        msg = "9876.5432 * (360 / 360)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CHO.toChos(9876.5432), delta);
        msg = "1987654344.3345 * (360 / 360)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CHO.toChos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (360 / 360)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CHO.toChos(784.46789765434), delta);
        // ====================
        // ====================RI
        // ====================
        // to_factor = 12960.0
        to_factor = RI.getFactor();
        msg = "-1 / (12960 / 360)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), CHO.toRis(-1.0), delta);
        msg = "-0.1 / (12960 / 360)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), CHO.toRis(-0.1), delta);
        msg = "-0.000456789 / (12960 / 360)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), CHO.toRis(-4.56789E-4), delta);
        msg = "-73.25 / (12960 / 360)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), CHO.toRis(-73.25), delta);
        msg = "-56229.321 / (12960 / 360)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), CHO.toRis(-56229.321), delta);
        msg = "-873.5432456 / (12960 / 360)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), CHO.toRis(-873.5432456), delta);
        msg = "0 / (12960 / 360)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), CHO.toRis(0.0), delta);
        msg = "0.1 / (12960 / 360)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), CHO.toRis(0.1), delta);
        msg = "0.0000876543297 / (12960 / 360)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), CHO.toRis(8.76543297E-5), delta);
        msg = "0.33 / (12960 / 360)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), CHO.toRis(0.33), delta);
        msg = "0.6543 / (12960 / 360)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), CHO.toRis(0.6543), delta);
        msg = "1 / (12960 / 360)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), CHO.toRis(1.0), delta);
        msg = "1.6543 / (12960 / 360)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), CHO.toRis(1.6543), delta);
        msg = "22.45 / (12960 / 360)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), CHO.toRis(22.45), delta);
        msg = "9876.5432 / (12960 / 360)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), CHO.toRis(9876.5432), delta);
        msg = "1987654344.3345 / (12960 / 360)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), CHO.toRis(1.9876543443345E9), delta);
        msg = "784.46789765434 / (12960 / 360)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), CHO.toRis(784.46789765434), delta);
    }

    @Test()
    public void testRi() {
        // from_factor = 12960.0
        double from_factor = RI.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================MO
        // ====================
        // to_factor = 1.0E-4
        to_factor = MO.getFactor();
        msg = "-1 * (12960 / 0.0001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), RI.toMos(-1.0), delta);
        msg = "-0.1 * (12960 / 0.0001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), RI.toMos(-0.1), delta);
        msg = "-0.000456789 * (12960 / 0.0001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), RI.toMos(-4.56789E-4), delta);
        msg = "-73.25 * (12960 / 0.0001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), RI.toMos(-73.25), delta);
        msg = "-56229.321 * (12960 / 0.0001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), RI.toMos(-56229.321), delta);
        msg = "-873.5432456 * (12960 / 0.0001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), RI.toMos(-873.5432456), delta);
        msg = "0 * (12960 / 0.0001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), RI.toMos(0.0), delta);
        msg = "0.1 * (12960 / 0.0001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), RI.toMos(0.1), delta);
        msg = "0.0000876543297 * (12960 / 0.0001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), RI.toMos(8.76543297E-5), delta);
        msg = "0.33 * (12960 / 0.0001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), RI.toMos(0.33), delta);
        msg = "0.6543 * (12960 / 0.0001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), RI.toMos(0.6543), delta);
        msg = "1 * (12960 / 0.0001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), RI.toMos(1.0), delta);
        msg = "1.6543 * (12960 / 0.0001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), RI.toMos(1.6543), delta);
        msg = "22.45 * (12960 / 0.0001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), RI.toMos(22.45), delta);
        msg = "9876.5432 * (12960 / 0.0001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), RI.toMos(9876.5432), delta);
        msg = "1987654344.3345 * (12960 / 0.0001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), RI.toMos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (12960 / 0.0001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), RI.toMos(784.46789765434), delta);
        // ====================
        // ====================RIN
        // ====================
        // to_factor = 0.001
        to_factor = RIN.getFactor();
        msg = "-1 * (12960 / 0.001)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), RI.toRins(-1.0), delta);
        msg = "-0.1 * (12960 / 0.001)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), RI.toRins(-0.1), delta);
        msg = "-0.000456789 * (12960 / 0.001)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), RI.toRins(-4.56789E-4), delta);
        msg = "-73.25 * (12960 / 0.001)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), RI.toRins(-73.25), delta);
        msg = "-56229.321 * (12960 / 0.001)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), RI.toRins(-56229.321), delta);
        msg = "-873.5432456 * (12960 / 0.001)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), RI.toRins(-873.5432456), delta);
        msg = "0 * (12960 / 0.001)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), RI.toRins(0.0), delta);
        msg = "0.1 * (12960 / 0.001)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), RI.toRins(0.1), delta);
        msg = "0.0000876543297 * (12960 / 0.001)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), RI.toRins(8.76543297E-5), delta);
        msg = "0.33 * (12960 / 0.001)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), RI.toRins(0.33), delta);
        msg = "0.6543 * (12960 / 0.001)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), RI.toRins(0.6543), delta);
        msg = "1 * (12960 / 0.001)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), RI.toRins(1.0), delta);
        msg = "1.6543 * (12960 / 0.001)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), RI.toRins(1.6543), delta);
        msg = "22.45 * (12960 / 0.001)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), RI.toRins(22.45), delta);
        msg = "9876.5432 * (12960 / 0.001)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), RI.toRins(9876.5432), delta);
        msg = "1987654344.3345 * (12960 / 0.001)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), RI.toRins(1.9876543443345E9), delta);
        msg = "784.46789765434 * (12960 / 0.001)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), RI.toRins(784.46789765434), delta);
        // ====================
        // ====================BU
        // ====================
        // to_factor = 0.01
        to_factor = BU.getFactor();
        msg = "-1 * (12960 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), RI.toBus(-1.0), delta);
        msg = "-0.1 * (12960 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), RI.toBus(-0.1), delta);
        msg = "-0.000456789 * (12960 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), RI.toBus(-4.56789E-4), delta);
        msg = "-73.25 * (12960 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), RI.toBus(-73.25), delta);
        msg = "-56229.321 * (12960 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), RI.toBus(-56229.321), delta);
        msg = "-873.5432456 * (12960 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), RI.toBus(-873.5432456), delta);
        msg = "0 * (12960 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), RI.toBus(0.0), delta);
        msg = "0.1 * (12960 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), RI.toBus(0.1), delta);
        msg = "0.0000876543297 * (12960 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), RI.toBus(8.76543297E-5), delta);
        msg = "0.33 * (12960 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), RI.toBus(0.33), delta);
        msg = "0.6543 * (12960 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), RI.toBus(0.6543), delta);
        msg = "1 * (12960 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), RI.toBus(1.0), delta);
        msg = "1.6543 * (12960 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), RI.toBus(1.6543), delta);
        msg = "22.45 * (12960 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), RI.toBus(22.45), delta);
        msg = "9876.5432 * (12960 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), RI.toBus(9876.5432), delta);
        msg = "1987654344.3345 * (12960 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), RI.toBus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (12960 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), RI.toBus(784.46789765434), delta);
        // ====================
        // ====================SUN
        // ====================
        // to_factor = 0.1
        to_factor = SUN.getFactor();
        msg = "-1 * (12960 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), RI.toSuns(-1.0), delta);
        msg = "-0.1 * (12960 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), RI.toSuns(-0.1), delta);
        msg = "-0.000456789 * (12960 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), RI.toSuns(-4.56789E-4), delta);
        msg = "-73.25 * (12960 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), RI.toSuns(-73.25), delta);
        msg = "-56229.321 * (12960 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), RI.toSuns(-56229.321), delta);
        msg = "-873.5432456 * (12960 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), RI.toSuns(-873.5432456), delta);
        msg = "0 * (12960 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), RI.toSuns(0.0), delta);
        msg = "0.1 * (12960 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), RI.toSuns(0.1), delta);
        msg = "0.0000876543297 * (12960 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), RI.toSuns(8.76543297E-5), delta);
        msg = "0.33 * (12960 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), RI.toSuns(0.33), delta);
        msg = "0.6543 * (12960 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), RI.toSuns(0.6543), delta);
        msg = "1 * (12960 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), RI.toSuns(1.0), delta);
        msg = "1.6543 * (12960 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), RI.toSuns(1.6543), delta);
        msg = "22.45 * (12960 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), RI.toSuns(22.45), delta);
        msg = "9876.5432 * (12960 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), RI.toSuns(9876.5432), delta);
        msg = "1987654344.3345 * (12960 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), RI.toSuns(1.9876543443345E9), delta);
        msg = "784.46789765434 * (12960 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), RI.toSuns(784.46789765434), delta);
        // ====================
        // ====================SHAKU
        // ====================
        // to_factor = 1.0
        to_factor = SHAKU.getFactor();
        msg = "-1 * (12960 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), RI.toShakus(-1.0), delta);
        msg = "-0.1 * (12960 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), RI.toShakus(-0.1), delta);
        msg = "-0.000456789 * (12960 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), RI.toShakus(-4.56789E-4), delta);
        msg = "-73.25 * (12960 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), RI.toShakus(-73.25), delta);
        msg = "-56229.321 * (12960 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), RI.toShakus(-56229.321), delta);
        msg = "-873.5432456 * (12960 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), RI.toShakus(-873.5432456), delta);
        msg = "0 * (12960 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), RI.toShakus(0.0), delta);
        msg = "0.1 * (12960 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), RI.toShakus(0.1), delta);
        msg = "0.0000876543297 * (12960 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), RI.toShakus(8.76543297E-5), delta);
        msg = "0.33 * (12960 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), RI.toShakus(0.33), delta);
        msg = "0.6543 * (12960 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), RI.toShakus(0.6543), delta);
        msg = "1 * (12960 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), RI.toShakus(1.0), delta);
        msg = "1.6543 * (12960 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), RI.toShakus(1.6543), delta);
        msg = "22.45 * (12960 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), RI.toShakus(22.45), delta);
        msg = "9876.5432 * (12960 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), RI.toShakus(9876.5432), delta);
        msg = "1987654344.3345 * (12960 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), RI.toShakus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (12960 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), RI.toShakus(784.46789765434), delta);
        // ====================
        // ====================KEN
        // ====================
        // to_factor = 6.0
        to_factor = KEN.getFactor();
        msg = "-1 * (12960 / 6)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), RI.toKens(-1.0), delta);
        msg = "-0.1 * (12960 / 6)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), RI.toKens(-0.1), delta);
        msg = "-0.000456789 * (12960 / 6)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), RI.toKens(-4.56789E-4), delta);
        msg = "-73.25 * (12960 / 6)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), RI.toKens(-73.25), delta);
        msg = "-56229.321 * (12960 / 6)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), RI.toKens(-56229.321), delta);
        msg = "-873.5432456 * (12960 / 6)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), RI.toKens(-873.5432456), delta);
        msg = "0 * (12960 / 6)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), RI.toKens(0.0), delta);
        msg = "0.1 * (12960 / 6)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), RI.toKens(0.1), delta);
        msg = "0.0000876543297 * (12960 / 6)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), RI.toKens(8.76543297E-5), delta);
        msg = "0.33 * (12960 / 6)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), RI.toKens(0.33), delta);
        msg = "0.6543 * (12960 / 6)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), RI.toKens(0.6543), delta);
        msg = "1 * (12960 / 6)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), RI.toKens(1.0), delta);
        msg = "1.6543 * (12960 / 6)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), RI.toKens(1.6543), delta);
        msg = "22.45 * (12960 / 6)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), RI.toKens(22.45), delta);
        msg = "9876.5432 * (12960 / 6)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), RI.toKens(9876.5432), delta);
        msg = "1987654344.3345 * (12960 / 6)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), RI.toKens(1.9876543443345E9), delta);
        msg = "784.46789765434 * (12960 / 6)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), RI.toKens(784.46789765434), delta);
        // ====================
        // ====================JO
        // ====================
        // to_factor = 10.0
        to_factor = JO.getFactor();
        msg = "-1 * (12960 / 10)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), RI.toJos(-1.0), delta);
        msg = "-0.1 * (12960 / 10)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), RI.toJos(-0.1), delta);
        msg = "-0.000456789 * (12960 / 10)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), RI.toJos(-4.56789E-4), delta);
        msg = "-73.25 * (12960 / 10)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), RI.toJos(-73.25), delta);
        msg = "-56229.321 * (12960 / 10)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), RI.toJos(-56229.321), delta);
        msg = "-873.5432456 * (12960 / 10)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), RI.toJos(-873.5432456), delta);
        msg = "0 * (12960 / 10)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), RI.toJos(0.0), delta);
        msg = "0.1 * (12960 / 10)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), RI.toJos(0.1), delta);
        msg = "0.0000876543297 * (12960 / 10)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), RI.toJos(8.76543297E-5), delta);
        msg = "0.33 * (12960 / 10)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), RI.toJos(0.33), delta);
        msg = "0.6543 * (12960 / 10)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), RI.toJos(0.6543), delta);
        msg = "1 * (12960 / 10)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), RI.toJos(1.0), delta);
        msg = "1.6543 * (12960 / 10)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), RI.toJos(1.6543), delta);
        msg = "22.45 * (12960 / 10)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), RI.toJos(22.45), delta);
        msg = "9876.5432 * (12960 / 10)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), RI.toJos(9876.5432), delta);
        msg = "1987654344.3345 * (12960 / 10)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), RI.toJos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (12960 / 10)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), RI.toJos(784.46789765434), delta);
        // ====================
        // ====================CHO
        // ====================
        // to_factor = 360.0
        to_factor = CHO.getFactor();
        msg = "-1 * (12960 / 360)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), RI.toChos(-1.0), delta);
        msg = "-0.1 * (12960 / 360)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), RI.toChos(-0.1), delta);
        msg = "-0.000456789 * (12960 / 360)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), RI.toChos(-4.56789E-4), delta);
        msg = "-73.25 * (12960 / 360)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), RI.toChos(-73.25), delta);
        msg = "-56229.321 * (12960 / 360)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), RI.toChos(-56229.321), delta);
        msg = "-873.5432456 * (12960 / 360)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), RI.toChos(-873.5432456), delta);
        msg = "0 * (12960 / 360)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), RI.toChos(0.0), delta);
        msg = "0.1 * (12960 / 360)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), RI.toChos(0.1), delta);
        msg = "0.0000876543297 * (12960 / 360)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), RI.toChos(8.76543297E-5), delta);
        msg = "0.33 * (12960 / 360)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), RI.toChos(0.33), delta);
        msg = "0.6543 * (12960 / 360)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), RI.toChos(0.6543), delta);
        msg = "1 * (12960 / 360)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), RI.toChos(1.0), delta);
        msg = "1.6543 * (12960 / 360)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), RI.toChos(1.6543), delta);
        msg = "22.45 * (12960 / 360)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), RI.toChos(22.45), delta);
        msg = "9876.5432 * (12960 / 360)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), RI.toChos(9876.5432), delta);
        msg = "1987654344.3345 * (12960 / 360)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), RI.toChos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (12960 / 360)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), RI.toChos(784.46789765434), delta);
        // ====================
        // ====================RI
        // ====================
        // to_factor = 12960.0
        to_factor = RI.getFactor();
        msg = "-1 * (12960 / 12960)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), RI.toRis(-1.0), delta);
        msg = "-0.1 * (12960 / 12960)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), RI.toRis(-0.1), delta);
        msg = "-0.000456789 * (12960 / 12960)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), RI.toRis(-4.56789E-4), delta);
        msg = "-73.25 * (12960 / 12960)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), RI.toRis(-73.25), delta);
        msg = "-56229.321 * (12960 / 12960)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), RI.toRis(-56229.321), delta);
        msg = "-873.5432456 * (12960 / 12960)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), RI.toRis(-873.5432456), delta);
        msg = "0 * (12960 / 12960)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), RI.toRis(0.0), delta);
        msg = "0.1 * (12960 / 12960)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), RI.toRis(0.1), delta);
        msg = "0.0000876543297 * (12960 / 12960)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), RI.toRis(8.76543297E-5), delta);
        msg = "0.33 * (12960 / 12960)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), RI.toRis(0.33), delta);
        msg = "0.6543 * (12960 / 12960)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), RI.toRis(0.6543), delta);
        msg = "1 * (12960 / 12960)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), RI.toRis(1.0), delta);
        msg = "1.6543 * (12960 / 12960)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), RI.toRis(1.6543), delta);
        msg = "22.45 * (12960 / 12960)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), RI.toRis(22.45), delta);
        msg = "9876.5432 * (12960 / 12960)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), RI.toRis(9876.5432), delta);
        msg = "1987654344.3345 * (12960 / 12960)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), RI.toRis(1.9876543443345E9), delta);
        msg = "784.46789765434 * (12960 / 12960)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), RI.toRis(784.46789765434), delta);
    }
}
