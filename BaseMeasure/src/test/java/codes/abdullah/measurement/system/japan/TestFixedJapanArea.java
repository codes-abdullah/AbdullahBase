package codes.abdullah.measurement.system.japan;

import static codes.abdullah.measurement.system.japan.Japans.area.CHO;
import static codes.abdullah.measurement.system.japan.Japans.area.GO;
import static codes.abdullah.measurement.system.japan.Japans.area.JO;
import static codes.abdullah.measurement.system.japan.Japans.area.SE;
import static codes.abdullah.measurement.system.japan.Japans.area.SHAKU;
import static codes.abdullah.measurement.system.japan.Japans.area.TAN;
import static codes.abdullah.measurement.system.japan.Japans.area.TSUBO;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFixedJapanArea {

    @Test()
    public void testShaku() {
        // from_factor = 0.01
        double from_factor = SHAKU.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SHAKU
        // ====================
        // to_factor = 0.01
        to_factor = SHAKU.getFactor();
        msg = "-1 * (0.01 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SHAKU.toShakus(-1.0), delta);
        msg = "-0.1 * (0.01 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SHAKU.toShakus(-0.1), delta);
        msg = "-0.000456789 * (0.01 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SHAKU.toShakus(-4.56789E-4), delta);
        msg = "-73.25 * (0.01 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SHAKU.toShakus(-73.25), delta);
        msg = "-56229.321 * (0.01 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SHAKU.toShakus(-56229.321), delta);
        msg = "-873.5432456 * (0.01 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SHAKU.toShakus(-873.5432456), delta);
        msg = "0 * (0.01 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SHAKU.toShakus(0.0), delta);
        msg = "0.1 * (0.01 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SHAKU.toShakus(0.1), delta);
        msg = "0.0000876543297 * (0.01 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SHAKU.toShakus(8.76543297E-5), delta);
        msg = "0.33 * (0.01 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SHAKU.toShakus(0.33), delta);
        msg = "0.6543 * (0.01 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SHAKU.toShakus(0.6543), delta);
        msg = "1 * (0.01 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SHAKU.toShakus(1.0), delta);
        msg = "1.6543 * (0.01 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SHAKU.toShakus(1.6543), delta);
        msg = "22.45 * (0.01 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SHAKU.toShakus(22.45), delta);
        msg = "9876.5432 * (0.01 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SHAKU.toShakus(9876.5432), delta);
        msg = "1987654344.3345 * (0.01 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SHAKU.toShakus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.01 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SHAKU.toShakus(784.46789765434), delta);
        // ====================
        // ====================GO
        // ====================
        // to_factor = 0.1
        to_factor = GO.getFactor();
        msg = "-1 / (0.1 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SHAKU.toGos(-1.0), delta);
        msg = "-0.1 / (0.1 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SHAKU.toGos(-0.1), delta);
        msg = "-0.000456789 / (0.1 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SHAKU.toGos(-4.56789E-4), delta);
        msg = "-73.25 / (0.1 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SHAKU.toGos(-73.25), delta);
        msg = "-56229.321 / (0.1 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SHAKU.toGos(-56229.321), delta);
        msg = "-873.5432456 / (0.1 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SHAKU.toGos(-873.5432456), delta);
        msg = "0 / (0.1 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SHAKU.toGos(0.0), delta);
        msg = "0.1 / (0.1 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SHAKU.toGos(0.1), delta);
        msg = "0.0000876543297 / (0.1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SHAKU.toGos(8.76543297E-5), delta);
        msg = "0.33 / (0.1 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SHAKU.toGos(0.33), delta);
        msg = "0.6543 / (0.1 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SHAKU.toGos(0.6543), delta);
        msg = "1 / (0.1 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SHAKU.toGos(1.0), delta);
        msg = "1.6543 / (0.1 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SHAKU.toGos(1.6543), delta);
        msg = "22.45 / (0.1 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SHAKU.toGos(22.45), delta);
        msg = "9876.5432 / (0.1 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SHAKU.toGos(9876.5432), delta);
        msg = "1987654344.3345 / (0.1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SHAKU.toGos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.1 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SHAKU.toGos(784.46789765434), delta);
        // ====================
        // ====================JO
        // ====================
        // to_factor = 0.5
        to_factor = JO.getFactor();
        msg = "-1 / (0.5 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SHAKU.toJos(-1.0), delta);
        msg = "-0.1 / (0.5 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SHAKU.toJos(-0.1), delta);
        msg = "-0.000456789 / (0.5 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SHAKU.toJos(-4.56789E-4), delta);
        msg = "-73.25 / (0.5 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SHAKU.toJos(-73.25), delta);
        msg = "-56229.321 / (0.5 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SHAKU.toJos(-56229.321), delta);
        msg = "-873.5432456 / (0.5 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SHAKU.toJos(-873.5432456), delta);
        msg = "0 / (0.5 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SHAKU.toJos(0.0), delta);
        msg = "0.1 / (0.5 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SHAKU.toJos(0.1), delta);
        msg = "0.0000876543297 / (0.5 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SHAKU.toJos(8.76543297E-5), delta);
        msg = "0.33 / (0.5 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SHAKU.toJos(0.33), delta);
        msg = "0.6543 / (0.5 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SHAKU.toJos(0.6543), delta);
        msg = "1 / (0.5 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SHAKU.toJos(1.0), delta);
        msg = "1.6543 / (0.5 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SHAKU.toJos(1.6543), delta);
        msg = "22.45 / (0.5 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SHAKU.toJos(22.45), delta);
        msg = "9876.5432 / (0.5 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SHAKU.toJos(9876.5432), delta);
        msg = "1987654344.3345 / (0.5 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SHAKU.toJos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.5 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SHAKU.toJos(784.46789765434), delta);
        // ====================
        // ====================TSUBO
        // ====================
        // to_factor = 1.0
        to_factor = TSUBO.getFactor();
        msg = "-1 / (1 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SHAKU.toTsubos(-1.0), delta);
        msg = "-0.1 / (1 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SHAKU.toTsubos(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SHAKU.toTsubos(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SHAKU.toTsubos(-73.25), delta);
        msg = "-56229.321 / (1 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SHAKU.toTsubos(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SHAKU.toTsubos(-873.5432456), delta);
        msg = "0 / (1 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SHAKU.toTsubos(0.0), delta);
        msg = "0.1 / (1 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SHAKU.toTsubos(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SHAKU.toTsubos(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SHAKU.toTsubos(0.33), delta);
        msg = "0.6543 / (1 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SHAKU.toTsubos(0.6543), delta);
        msg = "1 / (1 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SHAKU.toTsubos(1.0), delta);
        msg = "1.6543 / (1 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SHAKU.toTsubos(1.6543), delta);
        msg = "22.45 / (1 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SHAKU.toTsubos(22.45), delta);
        msg = "9876.5432 / (1 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SHAKU.toTsubos(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SHAKU.toTsubos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SHAKU.toTsubos(784.46789765434), delta);
        // ====================
        // ====================SE
        // ====================
        // to_factor = 30.0
        to_factor = SE.getFactor();
        msg = "-1 / (30 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SHAKU.toSes(-1.0), delta);
        msg = "-0.1 / (30 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SHAKU.toSes(-0.1), delta);
        msg = "-0.000456789 / (30 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SHAKU.toSes(-4.56789E-4), delta);
        msg = "-73.25 / (30 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SHAKU.toSes(-73.25), delta);
        msg = "-56229.321 / (30 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SHAKU.toSes(-56229.321), delta);
        msg = "-873.5432456 / (30 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SHAKU.toSes(-873.5432456), delta);
        msg = "0 / (30 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SHAKU.toSes(0.0), delta);
        msg = "0.1 / (30 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SHAKU.toSes(0.1), delta);
        msg = "0.0000876543297 / (30 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SHAKU.toSes(8.76543297E-5), delta);
        msg = "0.33 / (30 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SHAKU.toSes(0.33), delta);
        msg = "0.6543 / (30 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SHAKU.toSes(0.6543), delta);
        msg = "1 / (30 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SHAKU.toSes(1.0), delta);
        msg = "1.6543 / (30 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SHAKU.toSes(1.6543), delta);
        msg = "22.45 / (30 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SHAKU.toSes(22.45), delta);
        msg = "9876.5432 / (30 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SHAKU.toSes(9876.5432), delta);
        msg = "1987654344.3345 / (30 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SHAKU.toSes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (30 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SHAKU.toSes(784.46789765434), delta);
        // ====================
        // ====================TAN
        // ====================
        // to_factor = 300.0
        to_factor = TAN.getFactor();
        msg = "-1 / (300 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SHAKU.toTans(-1.0), delta);
        msg = "-0.1 / (300 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SHAKU.toTans(-0.1), delta);
        msg = "-0.000456789 / (300 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SHAKU.toTans(-4.56789E-4), delta);
        msg = "-73.25 / (300 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SHAKU.toTans(-73.25), delta);
        msg = "-56229.321 / (300 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SHAKU.toTans(-56229.321), delta);
        msg = "-873.5432456 / (300 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SHAKU.toTans(-873.5432456), delta);
        msg = "0 / (300 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SHAKU.toTans(0.0), delta);
        msg = "0.1 / (300 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SHAKU.toTans(0.1), delta);
        msg = "0.0000876543297 / (300 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SHAKU.toTans(8.76543297E-5), delta);
        msg = "0.33 / (300 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SHAKU.toTans(0.33), delta);
        msg = "0.6543 / (300 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SHAKU.toTans(0.6543), delta);
        msg = "1 / (300 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SHAKU.toTans(1.0), delta);
        msg = "1.6543 / (300 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SHAKU.toTans(1.6543), delta);
        msg = "22.45 / (300 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SHAKU.toTans(22.45), delta);
        msg = "9876.5432 / (300 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SHAKU.toTans(9876.5432), delta);
        msg = "1987654344.3345 / (300 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SHAKU.toTans(1.9876543443345E9), delta);
        msg = "784.46789765434 / (300 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SHAKU.toTans(784.46789765434), delta);
        // ====================
        // ====================CHO
        // ====================
        // to_factor = 3000.0
        to_factor = CHO.getFactor();
        msg = "-1 / (3000 / 0.01)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SHAKU.toChos(-1.0), delta);
        msg = "-0.1 / (3000 / 0.01)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SHAKU.toChos(-0.1), delta);
        msg = "-0.000456789 / (3000 / 0.01)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SHAKU.toChos(-4.56789E-4), delta);
        msg = "-73.25 / (3000 / 0.01)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SHAKU.toChos(-73.25), delta);
        msg = "-56229.321 / (3000 / 0.01)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SHAKU.toChos(-56229.321), delta);
        msg = "-873.5432456 / (3000 / 0.01)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SHAKU.toChos(-873.5432456), delta);
        msg = "0 / (3000 / 0.01)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SHAKU.toChos(0.0), delta);
        msg = "0.1 / (3000 / 0.01)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SHAKU.toChos(0.1), delta);
        msg = "0.0000876543297 / (3000 / 0.01)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SHAKU.toChos(8.76543297E-5), delta);
        msg = "0.33 / (3000 / 0.01)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SHAKU.toChos(0.33), delta);
        msg = "0.6543 / (3000 / 0.01)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SHAKU.toChos(0.6543), delta);
        msg = "1 / (3000 / 0.01)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SHAKU.toChos(1.0), delta);
        msg = "1.6543 / (3000 / 0.01)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SHAKU.toChos(1.6543), delta);
        msg = "22.45 / (3000 / 0.01)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SHAKU.toChos(22.45), delta);
        msg = "9876.5432 / (3000 / 0.01)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SHAKU.toChos(9876.5432), delta);
        msg = "1987654344.3345 / (3000 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SHAKU.toChos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (3000 / 0.01)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SHAKU.toChos(784.46789765434), delta);
    }

    @Test()
    public void testGo() {
        // from_factor = 0.1
        double from_factor = GO.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SHAKU
        // ====================
        // to_factor = 0.01
        to_factor = SHAKU.getFactor();
        msg = "-1 * (0.1 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GO.toShakus(-1.0), delta);
        msg = "-0.1 * (0.1 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GO.toShakus(-0.1), delta);
        msg = "-0.000456789 * (0.1 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GO.toShakus(-4.56789E-4), delta);
        msg = "-73.25 * (0.1 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GO.toShakus(-73.25), delta);
        msg = "-56229.321 * (0.1 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GO.toShakus(-56229.321), delta);
        msg = "-873.5432456 * (0.1 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GO.toShakus(-873.5432456), delta);
        msg = "0 * (0.1 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GO.toShakus(0.0), delta);
        msg = "0.1 * (0.1 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GO.toShakus(0.1), delta);
        msg = "0.0000876543297 * (0.1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GO.toShakus(8.76543297E-5), delta);
        msg = "0.33 * (0.1 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GO.toShakus(0.33), delta);
        msg = "0.6543 * (0.1 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GO.toShakus(0.6543), delta);
        msg = "1 * (0.1 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GO.toShakus(1.0), delta);
        msg = "1.6543 * (0.1 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GO.toShakus(1.6543), delta);
        msg = "22.45 * (0.1 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GO.toShakus(22.45), delta);
        msg = "9876.5432 * (0.1 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GO.toShakus(9876.5432), delta);
        msg = "1987654344.3345 * (0.1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GO.toShakus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.1 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GO.toShakus(784.46789765434), delta);
        // ====================
        // ====================GO
        // ====================
        // to_factor = 0.1
        to_factor = GO.getFactor();
        msg = "-1 * (0.1 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GO.toGos(-1.0), delta);
        msg = "-0.1 * (0.1 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GO.toGos(-0.1), delta);
        msg = "-0.000456789 * (0.1 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GO.toGos(-4.56789E-4), delta);
        msg = "-73.25 * (0.1 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GO.toGos(-73.25), delta);
        msg = "-56229.321 * (0.1 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GO.toGos(-56229.321), delta);
        msg = "-873.5432456 * (0.1 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GO.toGos(-873.5432456), delta);
        msg = "0 * (0.1 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GO.toGos(0.0), delta);
        msg = "0.1 * (0.1 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GO.toGos(0.1), delta);
        msg = "0.0000876543297 * (0.1 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GO.toGos(8.76543297E-5), delta);
        msg = "0.33 * (0.1 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GO.toGos(0.33), delta);
        msg = "0.6543 * (0.1 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GO.toGos(0.6543), delta);
        msg = "1 * (0.1 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GO.toGos(1.0), delta);
        msg = "1.6543 * (0.1 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GO.toGos(1.6543), delta);
        msg = "22.45 * (0.1 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GO.toGos(22.45), delta);
        msg = "9876.5432 * (0.1 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GO.toGos(9876.5432), delta);
        msg = "1987654344.3345 * (0.1 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GO.toGos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.1 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GO.toGos(784.46789765434), delta);
        // ====================
        // ====================JO
        // ====================
        // to_factor = 0.5
        to_factor = JO.getFactor();
        msg = "-1 / (0.5 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GO.toJos(-1.0), delta);
        msg = "-0.1 / (0.5 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GO.toJos(-0.1), delta);
        msg = "-0.000456789 / (0.5 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GO.toJos(-4.56789E-4), delta);
        msg = "-73.25 / (0.5 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GO.toJos(-73.25), delta);
        msg = "-56229.321 / (0.5 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GO.toJos(-56229.321), delta);
        msg = "-873.5432456 / (0.5 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GO.toJos(-873.5432456), delta);
        msg = "0 / (0.5 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GO.toJos(0.0), delta);
        msg = "0.1 / (0.5 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GO.toJos(0.1), delta);
        msg = "0.0000876543297 / (0.5 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GO.toJos(8.76543297E-5), delta);
        msg = "0.33 / (0.5 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GO.toJos(0.33), delta);
        msg = "0.6543 / (0.5 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GO.toJos(0.6543), delta);
        msg = "1 / (0.5 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GO.toJos(1.0), delta);
        msg = "1.6543 / (0.5 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GO.toJos(1.6543), delta);
        msg = "22.45 / (0.5 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GO.toJos(22.45), delta);
        msg = "9876.5432 / (0.5 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GO.toJos(9876.5432), delta);
        msg = "1987654344.3345 / (0.5 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GO.toJos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.5 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GO.toJos(784.46789765434), delta);
        // ====================
        // ====================TSUBO
        // ====================
        // to_factor = 1.0
        to_factor = TSUBO.getFactor();
        msg = "-1 / (1 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GO.toTsubos(-1.0), delta);
        msg = "-0.1 / (1 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GO.toTsubos(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GO.toTsubos(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GO.toTsubos(-73.25), delta);
        msg = "-56229.321 / (1 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GO.toTsubos(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GO.toTsubos(-873.5432456), delta);
        msg = "0 / (1 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GO.toTsubos(0.0), delta);
        msg = "0.1 / (1 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GO.toTsubos(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GO.toTsubos(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GO.toTsubos(0.33), delta);
        msg = "0.6543 / (1 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GO.toTsubos(0.6543), delta);
        msg = "1 / (1 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GO.toTsubos(1.0), delta);
        msg = "1.6543 / (1 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GO.toTsubos(1.6543), delta);
        msg = "22.45 / (1 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GO.toTsubos(22.45), delta);
        msg = "9876.5432 / (1 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GO.toTsubos(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GO.toTsubos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GO.toTsubos(784.46789765434), delta);
        // ====================
        // ====================SE
        // ====================
        // to_factor = 30.0
        to_factor = SE.getFactor();
        msg = "-1 / (30 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GO.toSes(-1.0), delta);
        msg = "-0.1 / (30 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GO.toSes(-0.1), delta);
        msg = "-0.000456789 / (30 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GO.toSes(-4.56789E-4), delta);
        msg = "-73.25 / (30 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GO.toSes(-73.25), delta);
        msg = "-56229.321 / (30 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GO.toSes(-56229.321), delta);
        msg = "-873.5432456 / (30 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GO.toSes(-873.5432456), delta);
        msg = "0 / (30 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GO.toSes(0.0), delta);
        msg = "0.1 / (30 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GO.toSes(0.1), delta);
        msg = "0.0000876543297 / (30 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GO.toSes(8.76543297E-5), delta);
        msg = "0.33 / (30 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GO.toSes(0.33), delta);
        msg = "0.6543 / (30 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GO.toSes(0.6543), delta);
        msg = "1 / (30 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GO.toSes(1.0), delta);
        msg = "1.6543 / (30 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GO.toSes(1.6543), delta);
        msg = "22.45 / (30 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GO.toSes(22.45), delta);
        msg = "9876.5432 / (30 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GO.toSes(9876.5432), delta);
        msg = "1987654344.3345 / (30 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GO.toSes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (30 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GO.toSes(784.46789765434), delta);
        // ====================
        // ====================TAN
        // ====================
        // to_factor = 300.0
        to_factor = TAN.getFactor();
        msg = "-1 / (300 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GO.toTans(-1.0), delta);
        msg = "-0.1 / (300 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GO.toTans(-0.1), delta);
        msg = "-0.000456789 / (300 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GO.toTans(-4.56789E-4), delta);
        msg = "-73.25 / (300 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GO.toTans(-73.25), delta);
        msg = "-56229.321 / (300 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GO.toTans(-56229.321), delta);
        msg = "-873.5432456 / (300 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GO.toTans(-873.5432456), delta);
        msg = "0 / (300 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GO.toTans(0.0), delta);
        msg = "0.1 / (300 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GO.toTans(0.1), delta);
        msg = "0.0000876543297 / (300 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GO.toTans(8.76543297E-5), delta);
        msg = "0.33 / (300 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GO.toTans(0.33), delta);
        msg = "0.6543 / (300 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GO.toTans(0.6543), delta);
        msg = "1 / (300 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GO.toTans(1.0), delta);
        msg = "1.6543 / (300 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GO.toTans(1.6543), delta);
        msg = "22.45 / (300 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GO.toTans(22.45), delta);
        msg = "9876.5432 / (300 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GO.toTans(9876.5432), delta);
        msg = "1987654344.3345 / (300 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GO.toTans(1.9876543443345E9), delta);
        msg = "784.46789765434 / (300 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GO.toTans(784.46789765434), delta);
        // ====================
        // ====================CHO
        // ====================
        // to_factor = 3000.0
        to_factor = CHO.getFactor();
        msg = "-1 / (3000 / 0.1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GO.toChos(-1.0), delta);
        msg = "-0.1 / (3000 / 0.1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GO.toChos(-0.1), delta);
        msg = "-0.000456789 / (3000 / 0.1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GO.toChos(-4.56789E-4), delta);
        msg = "-73.25 / (3000 / 0.1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GO.toChos(-73.25), delta);
        msg = "-56229.321 / (3000 / 0.1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GO.toChos(-56229.321), delta);
        msg = "-873.5432456 / (3000 / 0.1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GO.toChos(-873.5432456), delta);
        msg = "0 / (3000 / 0.1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GO.toChos(0.0), delta);
        msg = "0.1 / (3000 / 0.1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GO.toChos(0.1), delta);
        msg = "0.0000876543297 / (3000 / 0.1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GO.toChos(8.76543297E-5), delta);
        msg = "0.33 / (3000 / 0.1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GO.toChos(0.33), delta);
        msg = "0.6543 / (3000 / 0.1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GO.toChos(0.6543), delta);
        msg = "1 / (3000 / 0.1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GO.toChos(1.0), delta);
        msg = "1.6543 / (3000 / 0.1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GO.toChos(1.6543), delta);
        msg = "22.45 / (3000 / 0.1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GO.toChos(22.45), delta);
        msg = "9876.5432 / (3000 / 0.1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GO.toChos(9876.5432), delta);
        msg = "1987654344.3345 / (3000 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GO.toChos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (3000 / 0.1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GO.toChos(784.46789765434), delta);
    }

    @Test()
    public void testJo() {
        // from_factor = 0.5
        double from_factor = JO.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SHAKU
        // ====================
        // to_factor = 0.01
        to_factor = SHAKU.getFactor();
        msg = "-1 * (0.5 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), JO.toShakus(-1.0), delta);
        msg = "-0.1 * (0.5 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), JO.toShakus(-0.1), delta);
        msg = "-0.000456789 * (0.5 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), JO.toShakus(-4.56789E-4), delta);
        msg = "-73.25 * (0.5 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), JO.toShakus(-73.25), delta);
        msg = "-56229.321 * (0.5 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), JO.toShakus(-56229.321), delta);
        msg = "-873.5432456 * (0.5 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), JO.toShakus(-873.5432456), delta);
        msg = "0 * (0.5 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), JO.toShakus(0.0), delta);
        msg = "0.1 * (0.5 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), JO.toShakus(0.1), delta);
        msg = "0.0000876543297 * (0.5 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), JO.toShakus(8.76543297E-5), delta);
        msg = "0.33 * (0.5 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), JO.toShakus(0.33), delta);
        msg = "0.6543 * (0.5 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), JO.toShakus(0.6543), delta);
        msg = "1 * (0.5 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), JO.toShakus(1.0), delta);
        msg = "1.6543 * (0.5 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), JO.toShakus(1.6543), delta);
        msg = "22.45 * (0.5 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), JO.toShakus(22.45), delta);
        msg = "9876.5432 * (0.5 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), JO.toShakus(9876.5432), delta);
        msg = "1987654344.3345 * (0.5 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), JO.toShakus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.5 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), JO.toShakus(784.46789765434), delta);
        // ====================
        // ====================GO
        // ====================
        // to_factor = 0.1
        to_factor = GO.getFactor();
        msg = "-1 * (0.5 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), JO.toGos(-1.0), delta);
        msg = "-0.1 * (0.5 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), JO.toGos(-0.1), delta);
        msg = "-0.000456789 * (0.5 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), JO.toGos(-4.56789E-4), delta);
        msg = "-73.25 * (0.5 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), JO.toGos(-73.25), delta);
        msg = "-56229.321 * (0.5 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), JO.toGos(-56229.321), delta);
        msg = "-873.5432456 * (0.5 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), JO.toGos(-873.5432456), delta);
        msg = "0 * (0.5 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), JO.toGos(0.0), delta);
        msg = "0.1 * (0.5 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), JO.toGos(0.1), delta);
        msg = "0.0000876543297 * (0.5 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), JO.toGos(8.76543297E-5), delta);
        msg = "0.33 * (0.5 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), JO.toGos(0.33), delta);
        msg = "0.6543 * (0.5 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), JO.toGos(0.6543), delta);
        msg = "1 * (0.5 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), JO.toGos(1.0), delta);
        msg = "1.6543 * (0.5 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), JO.toGos(1.6543), delta);
        msg = "22.45 * (0.5 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), JO.toGos(22.45), delta);
        msg = "9876.5432 * (0.5 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), JO.toGos(9876.5432), delta);
        msg = "1987654344.3345 * (0.5 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), JO.toGos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.5 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), JO.toGos(784.46789765434), delta);
        // ====================
        // ====================JO
        // ====================
        // to_factor = 0.5
        to_factor = JO.getFactor();
        msg = "-1 * (0.5 / 0.5)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), JO.toJos(-1.0), delta);
        msg = "-0.1 * (0.5 / 0.5)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), JO.toJos(-0.1), delta);
        msg = "-0.000456789 * (0.5 / 0.5)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), JO.toJos(-4.56789E-4), delta);
        msg = "-73.25 * (0.5 / 0.5)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), JO.toJos(-73.25), delta);
        msg = "-56229.321 * (0.5 / 0.5)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), JO.toJos(-56229.321), delta);
        msg = "-873.5432456 * (0.5 / 0.5)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), JO.toJos(-873.5432456), delta);
        msg = "0 * (0.5 / 0.5)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), JO.toJos(0.0), delta);
        msg = "0.1 * (0.5 / 0.5)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), JO.toJos(0.1), delta);
        msg = "0.0000876543297 * (0.5 / 0.5)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), JO.toJos(8.76543297E-5), delta);
        msg = "0.33 * (0.5 / 0.5)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), JO.toJos(0.33), delta);
        msg = "0.6543 * (0.5 / 0.5)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), JO.toJos(0.6543), delta);
        msg = "1 * (0.5 / 0.5)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), JO.toJos(1.0), delta);
        msg = "1.6543 * (0.5 / 0.5)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), JO.toJos(1.6543), delta);
        msg = "22.45 * (0.5 / 0.5)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), JO.toJos(22.45), delta);
        msg = "9876.5432 * (0.5 / 0.5)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), JO.toJos(9876.5432), delta);
        msg = "1987654344.3345 * (0.5 / 0.5)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), JO.toJos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.5 / 0.5)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), JO.toJos(784.46789765434), delta);
        // ====================
        // ====================TSUBO
        // ====================
        // to_factor = 1.0
        to_factor = TSUBO.getFactor();
        msg = "-1 / (1 / 0.5)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), JO.toTsubos(-1.0), delta);
        msg = "-0.1 / (1 / 0.5)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), JO.toTsubos(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.5)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), JO.toTsubos(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.5)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), JO.toTsubos(-73.25), delta);
        msg = "-56229.321 / (1 / 0.5)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), JO.toTsubos(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.5)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), JO.toTsubos(-873.5432456), delta);
        msg = "0 / (1 / 0.5)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), JO.toTsubos(0.0), delta);
        msg = "0.1 / (1 / 0.5)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), JO.toTsubos(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.5)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), JO.toTsubos(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.5)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), JO.toTsubos(0.33), delta);
        msg = "0.6543 / (1 / 0.5)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), JO.toTsubos(0.6543), delta);
        msg = "1 / (1 / 0.5)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), JO.toTsubos(1.0), delta);
        msg = "1.6543 / (1 / 0.5)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), JO.toTsubos(1.6543), delta);
        msg = "22.45 / (1 / 0.5)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), JO.toTsubos(22.45), delta);
        msg = "9876.5432 / (1 / 0.5)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), JO.toTsubos(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.5)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), JO.toTsubos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.5)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), JO.toTsubos(784.46789765434), delta);
        // ====================
        // ====================SE
        // ====================
        // to_factor = 30.0
        to_factor = SE.getFactor();
        msg = "-1 / (30 / 0.5)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), JO.toSes(-1.0), delta);
        msg = "-0.1 / (30 / 0.5)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), JO.toSes(-0.1), delta);
        msg = "-0.000456789 / (30 / 0.5)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), JO.toSes(-4.56789E-4), delta);
        msg = "-73.25 / (30 / 0.5)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), JO.toSes(-73.25), delta);
        msg = "-56229.321 / (30 / 0.5)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), JO.toSes(-56229.321), delta);
        msg = "-873.5432456 / (30 / 0.5)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), JO.toSes(-873.5432456), delta);
        msg = "0 / (30 / 0.5)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), JO.toSes(0.0), delta);
        msg = "0.1 / (30 / 0.5)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), JO.toSes(0.1), delta);
        msg = "0.0000876543297 / (30 / 0.5)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), JO.toSes(8.76543297E-5), delta);
        msg = "0.33 / (30 / 0.5)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), JO.toSes(0.33), delta);
        msg = "0.6543 / (30 / 0.5)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), JO.toSes(0.6543), delta);
        msg = "1 / (30 / 0.5)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), JO.toSes(1.0), delta);
        msg = "1.6543 / (30 / 0.5)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), JO.toSes(1.6543), delta);
        msg = "22.45 / (30 / 0.5)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), JO.toSes(22.45), delta);
        msg = "9876.5432 / (30 / 0.5)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), JO.toSes(9876.5432), delta);
        msg = "1987654344.3345 / (30 / 0.5)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), JO.toSes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (30 / 0.5)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), JO.toSes(784.46789765434), delta);
        // ====================
        // ====================TAN
        // ====================
        // to_factor = 300.0
        to_factor = TAN.getFactor();
        msg = "-1 / (300 / 0.5)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), JO.toTans(-1.0), delta);
        msg = "-0.1 / (300 / 0.5)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), JO.toTans(-0.1), delta);
        msg = "-0.000456789 / (300 / 0.5)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), JO.toTans(-4.56789E-4), delta);
        msg = "-73.25 / (300 / 0.5)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), JO.toTans(-73.25), delta);
        msg = "-56229.321 / (300 / 0.5)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), JO.toTans(-56229.321), delta);
        msg = "-873.5432456 / (300 / 0.5)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), JO.toTans(-873.5432456), delta);
        msg = "0 / (300 / 0.5)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), JO.toTans(0.0), delta);
        msg = "0.1 / (300 / 0.5)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), JO.toTans(0.1), delta);
        msg = "0.0000876543297 / (300 / 0.5)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), JO.toTans(8.76543297E-5), delta);
        msg = "0.33 / (300 / 0.5)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), JO.toTans(0.33), delta);
        msg = "0.6543 / (300 / 0.5)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), JO.toTans(0.6543), delta);
        msg = "1 / (300 / 0.5)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), JO.toTans(1.0), delta);
        msg = "1.6543 / (300 / 0.5)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), JO.toTans(1.6543), delta);
        msg = "22.45 / (300 / 0.5)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), JO.toTans(22.45), delta);
        msg = "9876.5432 / (300 / 0.5)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), JO.toTans(9876.5432), delta);
        msg = "1987654344.3345 / (300 / 0.5)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), JO.toTans(1.9876543443345E9), delta);
        msg = "784.46789765434 / (300 / 0.5)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), JO.toTans(784.46789765434), delta);
        // ====================
        // ====================CHO
        // ====================
        // to_factor = 3000.0
        to_factor = CHO.getFactor();
        msg = "-1 / (3000 / 0.5)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), JO.toChos(-1.0), delta);
        msg = "-0.1 / (3000 / 0.5)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), JO.toChos(-0.1), delta);
        msg = "-0.000456789 / (3000 / 0.5)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), JO.toChos(-4.56789E-4), delta);
        msg = "-73.25 / (3000 / 0.5)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), JO.toChos(-73.25), delta);
        msg = "-56229.321 / (3000 / 0.5)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), JO.toChos(-56229.321), delta);
        msg = "-873.5432456 / (3000 / 0.5)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), JO.toChos(-873.5432456), delta);
        msg = "0 / (3000 / 0.5)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), JO.toChos(0.0), delta);
        msg = "0.1 / (3000 / 0.5)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), JO.toChos(0.1), delta);
        msg = "0.0000876543297 / (3000 / 0.5)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), JO.toChos(8.76543297E-5), delta);
        msg = "0.33 / (3000 / 0.5)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), JO.toChos(0.33), delta);
        msg = "0.6543 / (3000 / 0.5)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), JO.toChos(0.6543), delta);
        msg = "1 / (3000 / 0.5)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), JO.toChos(1.0), delta);
        msg = "1.6543 / (3000 / 0.5)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), JO.toChos(1.6543), delta);
        msg = "22.45 / (3000 / 0.5)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), JO.toChos(22.45), delta);
        msg = "9876.5432 / (3000 / 0.5)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), JO.toChos(9876.5432), delta);
        msg = "1987654344.3345 / (3000 / 0.5)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), JO.toChos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (3000 / 0.5)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), JO.toChos(784.46789765434), delta);
    }

    @Test()
    public void testTsubo() {
        // from_factor = 1.0
        double from_factor = TSUBO.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SHAKU
        // ====================
        // to_factor = 0.01
        to_factor = SHAKU.getFactor();
        msg = "-1 * (1 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TSUBO.toShakus(-1.0), delta);
        msg = "-0.1 * (1 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TSUBO.toShakus(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TSUBO.toShakus(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TSUBO.toShakus(-73.25), delta);
        msg = "-56229.321 * (1 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TSUBO.toShakus(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TSUBO.toShakus(-873.5432456), delta);
        msg = "0 * (1 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TSUBO.toShakus(0.0), delta);
        msg = "0.1 * (1 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TSUBO.toShakus(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TSUBO.toShakus(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TSUBO.toShakus(0.33), delta);
        msg = "0.6543 * (1 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TSUBO.toShakus(0.6543), delta);
        msg = "1 * (1 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TSUBO.toShakus(1.0), delta);
        msg = "1.6543 * (1 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TSUBO.toShakus(1.6543), delta);
        msg = "22.45 * (1 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TSUBO.toShakus(22.45), delta);
        msg = "9876.5432 * (1 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TSUBO.toShakus(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TSUBO.toShakus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TSUBO.toShakus(784.46789765434), delta);
        // ====================
        // ====================GO
        // ====================
        // to_factor = 0.1
        to_factor = GO.getFactor();
        msg = "-1 * (1 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TSUBO.toGos(-1.0), delta);
        msg = "-0.1 * (1 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TSUBO.toGos(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TSUBO.toGos(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TSUBO.toGos(-73.25), delta);
        msg = "-56229.321 * (1 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TSUBO.toGos(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TSUBO.toGos(-873.5432456), delta);
        msg = "0 * (1 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TSUBO.toGos(0.0), delta);
        msg = "0.1 * (1 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TSUBO.toGos(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TSUBO.toGos(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TSUBO.toGos(0.33), delta);
        msg = "0.6543 * (1 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TSUBO.toGos(0.6543), delta);
        msg = "1 * (1 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TSUBO.toGos(1.0), delta);
        msg = "1.6543 * (1 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TSUBO.toGos(1.6543), delta);
        msg = "22.45 * (1 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TSUBO.toGos(22.45), delta);
        msg = "9876.5432 * (1 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TSUBO.toGos(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TSUBO.toGos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TSUBO.toGos(784.46789765434), delta);
        // ====================
        // ====================JO
        // ====================
        // to_factor = 0.5
        to_factor = JO.getFactor();
        msg = "-1 * (1 / 0.5)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TSUBO.toJos(-1.0), delta);
        msg = "-0.1 * (1 / 0.5)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TSUBO.toJos(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.5)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TSUBO.toJos(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.5)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TSUBO.toJos(-73.25), delta);
        msg = "-56229.321 * (1 / 0.5)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TSUBO.toJos(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.5)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TSUBO.toJos(-873.5432456), delta);
        msg = "0 * (1 / 0.5)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TSUBO.toJos(0.0), delta);
        msg = "0.1 * (1 / 0.5)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TSUBO.toJos(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.5)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TSUBO.toJos(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.5)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TSUBO.toJos(0.33), delta);
        msg = "0.6543 * (1 / 0.5)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TSUBO.toJos(0.6543), delta);
        msg = "1 * (1 / 0.5)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TSUBO.toJos(1.0), delta);
        msg = "1.6543 * (1 / 0.5)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TSUBO.toJos(1.6543), delta);
        msg = "22.45 * (1 / 0.5)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TSUBO.toJos(22.45), delta);
        msg = "9876.5432 * (1 / 0.5)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TSUBO.toJos(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.5)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TSUBO.toJos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.5)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TSUBO.toJos(784.46789765434), delta);
        // ====================
        // ====================TSUBO
        // ====================
        // to_factor = 1.0
        to_factor = TSUBO.getFactor();
        msg = "-1 * (1 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TSUBO.toTsubos(-1.0), delta);
        msg = "-0.1 * (1 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TSUBO.toTsubos(-0.1), delta);
        msg = "-0.000456789 * (1 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TSUBO.toTsubos(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TSUBO.toTsubos(-73.25), delta);
        msg = "-56229.321 * (1 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TSUBO.toTsubos(-56229.321), delta);
        msg = "-873.5432456 * (1 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TSUBO.toTsubos(-873.5432456), delta);
        msg = "0 * (1 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TSUBO.toTsubos(0.0), delta);
        msg = "0.1 * (1 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TSUBO.toTsubos(0.1), delta);
        msg = "0.0000876543297 * (1 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TSUBO.toTsubos(8.76543297E-5), delta);
        msg = "0.33 * (1 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TSUBO.toTsubos(0.33), delta);
        msg = "0.6543 * (1 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TSUBO.toTsubos(0.6543), delta);
        msg = "1 * (1 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TSUBO.toTsubos(1.0), delta);
        msg = "1.6543 * (1 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TSUBO.toTsubos(1.6543), delta);
        msg = "22.45 * (1 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TSUBO.toTsubos(22.45), delta);
        msg = "9876.5432 * (1 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TSUBO.toTsubos(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TSUBO.toTsubos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TSUBO.toTsubos(784.46789765434), delta);
        // ====================
        // ====================SE
        // ====================
        // to_factor = 30.0
        to_factor = SE.getFactor();
        msg = "-1 / (30 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), TSUBO.toSes(-1.0), delta);
        msg = "-0.1 / (30 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), TSUBO.toSes(-0.1), delta);
        msg = "-0.000456789 / (30 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), TSUBO.toSes(-4.56789E-4), delta);
        msg = "-73.25 / (30 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), TSUBO.toSes(-73.25), delta);
        msg = "-56229.321 / (30 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), TSUBO.toSes(-56229.321), delta);
        msg = "-873.5432456 / (30 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), TSUBO.toSes(-873.5432456), delta);
        msg = "0 / (30 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), TSUBO.toSes(0.0), delta);
        msg = "0.1 / (30 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), TSUBO.toSes(0.1), delta);
        msg = "0.0000876543297 / (30 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), TSUBO.toSes(8.76543297E-5), delta);
        msg = "0.33 / (30 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), TSUBO.toSes(0.33), delta);
        msg = "0.6543 / (30 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), TSUBO.toSes(0.6543), delta);
        msg = "1 / (30 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), TSUBO.toSes(1.0), delta);
        msg = "1.6543 / (30 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), TSUBO.toSes(1.6543), delta);
        msg = "22.45 / (30 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), TSUBO.toSes(22.45), delta);
        msg = "9876.5432 / (30 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), TSUBO.toSes(9876.5432), delta);
        msg = "1987654344.3345 / (30 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), TSUBO.toSes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (30 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), TSUBO.toSes(784.46789765434), delta);
        // ====================
        // ====================TAN
        // ====================
        // to_factor = 300.0
        to_factor = TAN.getFactor();
        msg = "-1 / (300 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), TSUBO.toTans(-1.0), delta);
        msg = "-0.1 / (300 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), TSUBO.toTans(-0.1), delta);
        msg = "-0.000456789 / (300 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), TSUBO.toTans(-4.56789E-4), delta);
        msg = "-73.25 / (300 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), TSUBO.toTans(-73.25), delta);
        msg = "-56229.321 / (300 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), TSUBO.toTans(-56229.321), delta);
        msg = "-873.5432456 / (300 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), TSUBO.toTans(-873.5432456), delta);
        msg = "0 / (300 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), TSUBO.toTans(0.0), delta);
        msg = "0.1 / (300 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), TSUBO.toTans(0.1), delta);
        msg = "0.0000876543297 / (300 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), TSUBO.toTans(8.76543297E-5), delta);
        msg = "0.33 / (300 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), TSUBO.toTans(0.33), delta);
        msg = "0.6543 / (300 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), TSUBO.toTans(0.6543), delta);
        msg = "1 / (300 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), TSUBO.toTans(1.0), delta);
        msg = "1.6543 / (300 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), TSUBO.toTans(1.6543), delta);
        msg = "22.45 / (300 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), TSUBO.toTans(22.45), delta);
        msg = "9876.5432 / (300 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), TSUBO.toTans(9876.5432), delta);
        msg = "1987654344.3345 / (300 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), TSUBO.toTans(1.9876543443345E9), delta);
        msg = "784.46789765434 / (300 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), TSUBO.toTans(784.46789765434), delta);
        // ====================
        // ====================CHO
        // ====================
        // to_factor = 3000.0
        to_factor = CHO.getFactor();
        msg = "-1 / (3000 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), TSUBO.toChos(-1.0), delta);
        msg = "-0.1 / (3000 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), TSUBO.toChos(-0.1), delta);
        msg = "-0.000456789 / (3000 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), TSUBO.toChos(-4.56789E-4), delta);
        msg = "-73.25 / (3000 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), TSUBO.toChos(-73.25), delta);
        msg = "-56229.321 / (3000 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), TSUBO.toChos(-56229.321), delta);
        msg = "-873.5432456 / (3000 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), TSUBO.toChos(-873.5432456), delta);
        msg = "0 / (3000 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), TSUBO.toChos(0.0), delta);
        msg = "0.1 / (3000 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), TSUBO.toChos(0.1), delta);
        msg = "0.0000876543297 / (3000 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), TSUBO.toChos(8.76543297E-5), delta);
        msg = "0.33 / (3000 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), TSUBO.toChos(0.33), delta);
        msg = "0.6543 / (3000 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), TSUBO.toChos(0.6543), delta);
        msg = "1 / (3000 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), TSUBO.toChos(1.0), delta);
        msg = "1.6543 / (3000 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), TSUBO.toChos(1.6543), delta);
        msg = "22.45 / (3000 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), TSUBO.toChos(22.45), delta);
        msg = "9876.5432 / (3000 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), TSUBO.toChos(9876.5432), delta);
        msg = "1987654344.3345 / (3000 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), TSUBO.toChos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (3000 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), TSUBO.toChos(784.46789765434), delta);
    }

    @Test()
    public void testSe() {
        // from_factor = 30.0
        double from_factor = SE.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SHAKU
        // ====================
        // to_factor = 0.01
        to_factor = SHAKU.getFactor();
        msg = "-1 * (30 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SE.toShakus(-1.0), delta);
        msg = "-0.1 * (30 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SE.toShakus(-0.1), delta);
        msg = "-0.000456789 * (30 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SE.toShakus(-4.56789E-4), delta);
        msg = "-73.25 * (30 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SE.toShakus(-73.25), delta);
        msg = "-56229.321 * (30 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SE.toShakus(-56229.321), delta);
        msg = "-873.5432456 * (30 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SE.toShakus(-873.5432456), delta);
        msg = "0 * (30 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SE.toShakus(0.0), delta);
        msg = "0.1 * (30 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SE.toShakus(0.1), delta);
        msg = "0.0000876543297 * (30 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SE.toShakus(8.76543297E-5), delta);
        msg = "0.33 * (30 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SE.toShakus(0.33), delta);
        msg = "0.6543 * (30 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SE.toShakus(0.6543), delta);
        msg = "1 * (30 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SE.toShakus(1.0), delta);
        msg = "1.6543 * (30 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SE.toShakus(1.6543), delta);
        msg = "22.45 * (30 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SE.toShakus(22.45), delta);
        msg = "9876.5432 * (30 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SE.toShakus(9876.5432), delta);
        msg = "1987654344.3345 * (30 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SE.toShakus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (30 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SE.toShakus(784.46789765434), delta);
        // ====================
        // ====================GO
        // ====================
        // to_factor = 0.1
        to_factor = GO.getFactor();
        msg = "-1 * (30 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SE.toGos(-1.0), delta);
        msg = "-0.1 * (30 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SE.toGos(-0.1), delta);
        msg = "-0.000456789 * (30 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SE.toGos(-4.56789E-4), delta);
        msg = "-73.25 * (30 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SE.toGos(-73.25), delta);
        msg = "-56229.321 * (30 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SE.toGos(-56229.321), delta);
        msg = "-873.5432456 * (30 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SE.toGos(-873.5432456), delta);
        msg = "0 * (30 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SE.toGos(0.0), delta);
        msg = "0.1 * (30 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SE.toGos(0.1), delta);
        msg = "0.0000876543297 * (30 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SE.toGos(8.76543297E-5), delta);
        msg = "0.33 * (30 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SE.toGos(0.33), delta);
        msg = "0.6543 * (30 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SE.toGos(0.6543), delta);
        msg = "1 * (30 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SE.toGos(1.0), delta);
        msg = "1.6543 * (30 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SE.toGos(1.6543), delta);
        msg = "22.45 * (30 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SE.toGos(22.45), delta);
        msg = "9876.5432 * (30 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SE.toGos(9876.5432), delta);
        msg = "1987654344.3345 * (30 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SE.toGos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (30 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SE.toGos(784.46789765434), delta);
        // ====================
        // ====================JO
        // ====================
        // to_factor = 0.5
        to_factor = JO.getFactor();
        msg = "-1 * (30 / 0.5)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SE.toJos(-1.0), delta);
        msg = "-0.1 * (30 / 0.5)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SE.toJos(-0.1), delta);
        msg = "-0.000456789 * (30 / 0.5)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SE.toJos(-4.56789E-4), delta);
        msg = "-73.25 * (30 / 0.5)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SE.toJos(-73.25), delta);
        msg = "-56229.321 * (30 / 0.5)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SE.toJos(-56229.321), delta);
        msg = "-873.5432456 * (30 / 0.5)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SE.toJos(-873.5432456), delta);
        msg = "0 * (30 / 0.5)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SE.toJos(0.0), delta);
        msg = "0.1 * (30 / 0.5)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SE.toJos(0.1), delta);
        msg = "0.0000876543297 * (30 / 0.5)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SE.toJos(8.76543297E-5), delta);
        msg = "0.33 * (30 / 0.5)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SE.toJos(0.33), delta);
        msg = "0.6543 * (30 / 0.5)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SE.toJos(0.6543), delta);
        msg = "1 * (30 / 0.5)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SE.toJos(1.0), delta);
        msg = "1.6543 * (30 / 0.5)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SE.toJos(1.6543), delta);
        msg = "22.45 * (30 / 0.5)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SE.toJos(22.45), delta);
        msg = "9876.5432 * (30 / 0.5)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SE.toJos(9876.5432), delta);
        msg = "1987654344.3345 * (30 / 0.5)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SE.toJos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (30 / 0.5)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SE.toJos(784.46789765434), delta);
        // ====================
        // ====================TSUBO
        // ====================
        // to_factor = 1.0
        to_factor = TSUBO.getFactor();
        msg = "-1 * (30 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SE.toTsubos(-1.0), delta);
        msg = "-0.1 * (30 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SE.toTsubos(-0.1), delta);
        msg = "-0.000456789 * (30 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SE.toTsubos(-4.56789E-4), delta);
        msg = "-73.25 * (30 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SE.toTsubos(-73.25), delta);
        msg = "-56229.321 * (30 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SE.toTsubos(-56229.321), delta);
        msg = "-873.5432456 * (30 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SE.toTsubos(-873.5432456), delta);
        msg = "0 * (30 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SE.toTsubos(0.0), delta);
        msg = "0.1 * (30 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SE.toTsubos(0.1), delta);
        msg = "0.0000876543297 * (30 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SE.toTsubos(8.76543297E-5), delta);
        msg = "0.33 * (30 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SE.toTsubos(0.33), delta);
        msg = "0.6543 * (30 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SE.toTsubos(0.6543), delta);
        msg = "1 * (30 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SE.toTsubos(1.0), delta);
        msg = "1.6543 * (30 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SE.toTsubos(1.6543), delta);
        msg = "22.45 * (30 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SE.toTsubos(22.45), delta);
        msg = "9876.5432 * (30 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SE.toTsubos(9876.5432), delta);
        msg = "1987654344.3345 * (30 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SE.toTsubos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (30 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SE.toTsubos(784.46789765434), delta);
        // ====================
        // ====================SE
        // ====================
        // to_factor = 30.0
        to_factor = SE.getFactor();
        msg = "-1 * (30 / 30)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SE.toSes(-1.0), delta);
        msg = "-0.1 * (30 / 30)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SE.toSes(-0.1), delta);
        msg = "-0.000456789 * (30 / 30)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SE.toSes(-4.56789E-4), delta);
        msg = "-73.25 * (30 / 30)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SE.toSes(-73.25), delta);
        msg = "-56229.321 * (30 / 30)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SE.toSes(-56229.321), delta);
        msg = "-873.5432456 * (30 / 30)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SE.toSes(-873.5432456), delta);
        msg = "0 * (30 / 30)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SE.toSes(0.0), delta);
        msg = "0.1 * (30 / 30)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SE.toSes(0.1), delta);
        msg = "0.0000876543297 * (30 / 30)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SE.toSes(8.76543297E-5), delta);
        msg = "0.33 * (30 / 30)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SE.toSes(0.33), delta);
        msg = "0.6543 * (30 / 30)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SE.toSes(0.6543), delta);
        msg = "1 * (30 / 30)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SE.toSes(1.0), delta);
        msg = "1.6543 * (30 / 30)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SE.toSes(1.6543), delta);
        msg = "22.45 * (30 / 30)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SE.toSes(22.45), delta);
        msg = "9876.5432 * (30 / 30)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SE.toSes(9876.5432), delta);
        msg = "1987654344.3345 * (30 / 30)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SE.toSes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (30 / 30)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SE.toSes(784.46789765434), delta);
        // ====================
        // ====================TAN
        // ====================
        // to_factor = 300.0
        to_factor = TAN.getFactor();
        msg = "-1 / (300 / 30)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SE.toTans(-1.0), delta);
        msg = "-0.1 / (300 / 30)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SE.toTans(-0.1), delta);
        msg = "-0.000456789 / (300 / 30)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SE.toTans(-4.56789E-4), delta);
        msg = "-73.25 / (300 / 30)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SE.toTans(-73.25), delta);
        msg = "-56229.321 / (300 / 30)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SE.toTans(-56229.321), delta);
        msg = "-873.5432456 / (300 / 30)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SE.toTans(-873.5432456), delta);
        msg = "0 / (300 / 30)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SE.toTans(0.0), delta);
        msg = "0.1 / (300 / 30)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SE.toTans(0.1), delta);
        msg = "0.0000876543297 / (300 / 30)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SE.toTans(8.76543297E-5), delta);
        msg = "0.33 / (300 / 30)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SE.toTans(0.33), delta);
        msg = "0.6543 / (300 / 30)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SE.toTans(0.6543), delta);
        msg = "1 / (300 / 30)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SE.toTans(1.0), delta);
        msg = "1.6543 / (300 / 30)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SE.toTans(1.6543), delta);
        msg = "22.45 / (300 / 30)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SE.toTans(22.45), delta);
        msg = "9876.5432 / (300 / 30)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SE.toTans(9876.5432), delta);
        msg = "1987654344.3345 / (300 / 30)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SE.toTans(1.9876543443345E9), delta);
        msg = "784.46789765434 / (300 / 30)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SE.toTans(784.46789765434), delta);
        // ====================
        // ====================CHO
        // ====================
        // to_factor = 3000.0
        to_factor = CHO.getFactor();
        msg = "-1 / (3000 / 30)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SE.toChos(-1.0), delta);
        msg = "-0.1 / (3000 / 30)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SE.toChos(-0.1), delta);
        msg = "-0.000456789 / (3000 / 30)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SE.toChos(-4.56789E-4), delta);
        msg = "-73.25 / (3000 / 30)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SE.toChos(-73.25), delta);
        msg = "-56229.321 / (3000 / 30)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SE.toChos(-56229.321), delta);
        msg = "-873.5432456 / (3000 / 30)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SE.toChos(-873.5432456), delta);
        msg = "0 / (3000 / 30)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SE.toChos(0.0), delta);
        msg = "0.1 / (3000 / 30)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SE.toChos(0.1), delta);
        msg = "0.0000876543297 / (3000 / 30)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SE.toChos(8.76543297E-5), delta);
        msg = "0.33 / (3000 / 30)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SE.toChos(0.33), delta);
        msg = "0.6543 / (3000 / 30)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SE.toChos(0.6543), delta);
        msg = "1 / (3000 / 30)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SE.toChos(1.0), delta);
        msg = "1.6543 / (3000 / 30)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SE.toChos(1.6543), delta);
        msg = "22.45 / (3000 / 30)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SE.toChos(22.45), delta);
        msg = "9876.5432 / (3000 / 30)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SE.toChos(9876.5432), delta);
        msg = "1987654344.3345 / (3000 / 30)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SE.toChos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (3000 / 30)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SE.toChos(784.46789765434), delta);
    }

    @Test()
    public void testTan() {
        // from_factor = 300.0
        double from_factor = TAN.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SHAKU
        // ====================
        // to_factor = 0.01
        to_factor = SHAKU.getFactor();
        msg = "-1 * (300 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TAN.toShakus(-1.0), delta);
        msg = "-0.1 * (300 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TAN.toShakus(-0.1), delta);
        msg = "-0.000456789 * (300 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TAN.toShakus(-4.56789E-4), delta);
        msg = "-73.25 * (300 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TAN.toShakus(-73.25), delta);
        msg = "-56229.321 * (300 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TAN.toShakus(-56229.321), delta);
        msg = "-873.5432456 * (300 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TAN.toShakus(-873.5432456), delta);
        msg = "0 * (300 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TAN.toShakus(0.0), delta);
        msg = "0.1 * (300 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TAN.toShakus(0.1), delta);
        msg = "0.0000876543297 * (300 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TAN.toShakus(8.76543297E-5), delta);
        msg = "0.33 * (300 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TAN.toShakus(0.33), delta);
        msg = "0.6543 * (300 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TAN.toShakus(0.6543), delta);
        msg = "1 * (300 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TAN.toShakus(1.0), delta);
        msg = "1.6543 * (300 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TAN.toShakus(1.6543), delta);
        msg = "22.45 * (300 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TAN.toShakus(22.45), delta);
        msg = "9876.5432 * (300 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TAN.toShakus(9876.5432), delta);
        msg = "1987654344.3345 * (300 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TAN.toShakus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (300 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TAN.toShakus(784.46789765434), delta);
        // ====================
        // ====================GO
        // ====================
        // to_factor = 0.1
        to_factor = GO.getFactor();
        msg = "-1 * (300 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TAN.toGos(-1.0), delta);
        msg = "-0.1 * (300 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TAN.toGos(-0.1), delta);
        msg = "-0.000456789 * (300 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TAN.toGos(-4.56789E-4), delta);
        msg = "-73.25 * (300 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TAN.toGos(-73.25), delta);
        msg = "-56229.321 * (300 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TAN.toGos(-56229.321), delta);
        msg = "-873.5432456 * (300 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TAN.toGos(-873.5432456), delta);
        msg = "0 * (300 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TAN.toGos(0.0), delta);
        msg = "0.1 * (300 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TAN.toGos(0.1), delta);
        msg = "0.0000876543297 * (300 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TAN.toGos(8.76543297E-5), delta);
        msg = "0.33 * (300 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TAN.toGos(0.33), delta);
        msg = "0.6543 * (300 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TAN.toGos(0.6543), delta);
        msg = "1 * (300 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TAN.toGos(1.0), delta);
        msg = "1.6543 * (300 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TAN.toGos(1.6543), delta);
        msg = "22.45 * (300 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TAN.toGos(22.45), delta);
        msg = "9876.5432 * (300 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TAN.toGos(9876.5432), delta);
        msg = "1987654344.3345 * (300 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TAN.toGos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (300 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TAN.toGos(784.46789765434), delta);
        // ====================
        // ====================JO
        // ====================
        // to_factor = 0.5
        to_factor = JO.getFactor();
        msg = "-1 * (300 / 0.5)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TAN.toJos(-1.0), delta);
        msg = "-0.1 * (300 / 0.5)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TAN.toJos(-0.1), delta);
        msg = "-0.000456789 * (300 / 0.5)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TAN.toJos(-4.56789E-4), delta);
        msg = "-73.25 * (300 / 0.5)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TAN.toJos(-73.25), delta);
        msg = "-56229.321 * (300 / 0.5)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TAN.toJos(-56229.321), delta);
        msg = "-873.5432456 * (300 / 0.5)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TAN.toJos(-873.5432456), delta);
        msg = "0 * (300 / 0.5)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TAN.toJos(0.0), delta);
        msg = "0.1 * (300 / 0.5)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TAN.toJos(0.1), delta);
        msg = "0.0000876543297 * (300 / 0.5)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TAN.toJos(8.76543297E-5), delta);
        msg = "0.33 * (300 / 0.5)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TAN.toJos(0.33), delta);
        msg = "0.6543 * (300 / 0.5)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TAN.toJos(0.6543), delta);
        msg = "1 * (300 / 0.5)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TAN.toJos(1.0), delta);
        msg = "1.6543 * (300 / 0.5)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TAN.toJos(1.6543), delta);
        msg = "22.45 * (300 / 0.5)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TAN.toJos(22.45), delta);
        msg = "9876.5432 * (300 / 0.5)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TAN.toJos(9876.5432), delta);
        msg = "1987654344.3345 * (300 / 0.5)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TAN.toJos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (300 / 0.5)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TAN.toJos(784.46789765434), delta);
        // ====================
        // ====================TSUBO
        // ====================
        // to_factor = 1.0
        to_factor = TSUBO.getFactor();
        msg = "-1 * (300 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TAN.toTsubos(-1.0), delta);
        msg = "-0.1 * (300 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TAN.toTsubos(-0.1), delta);
        msg = "-0.000456789 * (300 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TAN.toTsubos(-4.56789E-4), delta);
        msg = "-73.25 * (300 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TAN.toTsubos(-73.25), delta);
        msg = "-56229.321 * (300 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TAN.toTsubos(-56229.321), delta);
        msg = "-873.5432456 * (300 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TAN.toTsubos(-873.5432456), delta);
        msg = "0 * (300 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TAN.toTsubos(0.0), delta);
        msg = "0.1 * (300 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TAN.toTsubos(0.1), delta);
        msg = "0.0000876543297 * (300 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TAN.toTsubos(8.76543297E-5), delta);
        msg = "0.33 * (300 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TAN.toTsubos(0.33), delta);
        msg = "0.6543 * (300 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TAN.toTsubos(0.6543), delta);
        msg = "1 * (300 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TAN.toTsubos(1.0), delta);
        msg = "1.6543 * (300 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TAN.toTsubos(1.6543), delta);
        msg = "22.45 * (300 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TAN.toTsubos(22.45), delta);
        msg = "9876.5432 * (300 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TAN.toTsubos(9876.5432), delta);
        msg = "1987654344.3345 * (300 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TAN.toTsubos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (300 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TAN.toTsubos(784.46789765434), delta);
        // ====================
        // ====================SE
        // ====================
        // to_factor = 30.0
        to_factor = SE.getFactor();
        msg = "-1 * (300 / 30)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TAN.toSes(-1.0), delta);
        msg = "-0.1 * (300 / 30)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TAN.toSes(-0.1), delta);
        msg = "-0.000456789 * (300 / 30)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TAN.toSes(-4.56789E-4), delta);
        msg = "-73.25 * (300 / 30)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TAN.toSes(-73.25), delta);
        msg = "-56229.321 * (300 / 30)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TAN.toSes(-56229.321), delta);
        msg = "-873.5432456 * (300 / 30)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TAN.toSes(-873.5432456), delta);
        msg = "0 * (300 / 30)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TAN.toSes(0.0), delta);
        msg = "0.1 * (300 / 30)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TAN.toSes(0.1), delta);
        msg = "0.0000876543297 * (300 / 30)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TAN.toSes(8.76543297E-5), delta);
        msg = "0.33 * (300 / 30)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TAN.toSes(0.33), delta);
        msg = "0.6543 * (300 / 30)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TAN.toSes(0.6543), delta);
        msg = "1 * (300 / 30)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TAN.toSes(1.0), delta);
        msg = "1.6543 * (300 / 30)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TAN.toSes(1.6543), delta);
        msg = "22.45 * (300 / 30)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TAN.toSes(22.45), delta);
        msg = "9876.5432 * (300 / 30)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TAN.toSes(9876.5432), delta);
        msg = "1987654344.3345 * (300 / 30)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TAN.toSes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (300 / 30)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TAN.toSes(784.46789765434), delta);
        // ====================
        // ====================TAN
        // ====================
        // to_factor = 300.0
        to_factor = TAN.getFactor();
        msg = "-1 * (300 / 300)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TAN.toTans(-1.0), delta);
        msg = "-0.1 * (300 / 300)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TAN.toTans(-0.1), delta);
        msg = "-0.000456789 * (300 / 300)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TAN.toTans(-4.56789E-4), delta);
        msg = "-73.25 * (300 / 300)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TAN.toTans(-73.25), delta);
        msg = "-56229.321 * (300 / 300)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TAN.toTans(-56229.321), delta);
        msg = "-873.5432456 * (300 / 300)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TAN.toTans(-873.5432456), delta);
        msg = "0 * (300 / 300)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TAN.toTans(0.0), delta);
        msg = "0.1 * (300 / 300)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TAN.toTans(0.1), delta);
        msg = "0.0000876543297 * (300 / 300)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TAN.toTans(8.76543297E-5), delta);
        msg = "0.33 * (300 / 300)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TAN.toTans(0.33), delta);
        msg = "0.6543 * (300 / 300)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TAN.toTans(0.6543), delta);
        msg = "1 * (300 / 300)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TAN.toTans(1.0), delta);
        msg = "1.6543 * (300 / 300)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TAN.toTans(1.6543), delta);
        msg = "22.45 * (300 / 300)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TAN.toTans(22.45), delta);
        msg = "9876.5432 * (300 / 300)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TAN.toTans(9876.5432), delta);
        msg = "1987654344.3345 * (300 / 300)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TAN.toTans(1.9876543443345E9), delta);
        msg = "784.46789765434 * (300 / 300)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TAN.toTans(784.46789765434), delta);
        // ====================
        // ====================CHO
        // ====================
        // to_factor = 3000.0
        to_factor = CHO.getFactor();
        msg = "-1 / (3000 / 300)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), TAN.toChos(-1.0), delta);
        msg = "-0.1 / (3000 / 300)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), TAN.toChos(-0.1), delta);
        msg = "-0.000456789 / (3000 / 300)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), TAN.toChos(-4.56789E-4), delta);
        msg = "-73.25 / (3000 / 300)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), TAN.toChos(-73.25), delta);
        msg = "-56229.321 / (3000 / 300)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), TAN.toChos(-56229.321), delta);
        msg = "-873.5432456 / (3000 / 300)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), TAN.toChos(-873.5432456), delta);
        msg = "0 / (3000 / 300)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), TAN.toChos(0.0), delta);
        msg = "0.1 / (3000 / 300)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), TAN.toChos(0.1), delta);
        msg = "0.0000876543297 / (3000 / 300)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), TAN.toChos(8.76543297E-5), delta);
        msg = "0.33 / (3000 / 300)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), TAN.toChos(0.33), delta);
        msg = "0.6543 / (3000 / 300)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), TAN.toChos(0.6543), delta);
        msg = "1 / (3000 / 300)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), TAN.toChos(1.0), delta);
        msg = "1.6543 / (3000 / 300)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), TAN.toChos(1.6543), delta);
        msg = "22.45 / (3000 / 300)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), TAN.toChos(22.45), delta);
        msg = "9876.5432 / (3000 / 300)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), TAN.toChos(9876.5432), delta);
        msg = "1987654344.3345 / (3000 / 300)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), TAN.toChos(1.9876543443345E9), delta);
        msg = "784.46789765434 / (3000 / 300)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), TAN.toChos(784.46789765434), delta);
    }

    @Test()
    public void testCho() {
        // from_factor = 3000.0
        double from_factor = CHO.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SHAKU
        // ====================
        // to_factor = 0.01
        to_factor = SHAKU.getFactor();
        msg = "-1 * (3000 / 0.01)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CHO.toShakus(-1.0), delta);
        msg = "-0.1 * (3000 / 0.01)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CHO.toShakus(-0.1), delta);
        msg = "-0.000456789 * (3000 / 0.01)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CHO.toShakus(-4.56789E-4), delta);
        msg = "-73.25 * (3000 / 0.01)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CHO.toShakus(-73.25), delta);
        msg = "-56229.321 * (3000 / 0.01)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CHO.toShakus(-56229.321), delta);
        msg = "-873.5432456 * (3000 / 0.01)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CHO.toShakus(-873.5432456), delta);
        msg = "0 * (3000 / 0.01)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CHO.toShakus(0.0), delta);
        msg = "0.1 * (3000 / 0.01)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CHO.toShakus(0.1), delta);
        msg = "0.0000876543297 * (3000 / 0.01)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CHO.toShakus(8.76543297E-5), delta);
        msg = "0.33 * (3000 / 0.01)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CHO.toShakus(0.33), delta);
        msg = "0.6543 * (3000 / 0.01)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CHO.toShakus(0.6543), delta);
        msg = "1 * (3000 / 0.01)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CHO.toShakus(1.0), delta);
        msg = "1.6543 * (3000 / 0.01)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CHO.toShakus(1.6543), delta);
        msg = "22.45 * (3000 / 0.01)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CHO.toShakus(22.45), delta);
        msg = "9876.5432 * (3000 / 0.01)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CHO.toShakus(9876.5432), delta);
        msg = "1987654344.3345 * (3000 / 0.01)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CHO.toShakus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3000 / 0.01)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CHO.toShakus(784.46789765434), delta);
        // ====================
        // ====================GO
        // ====================
        // to_factor = 0.1
        to_factor = GO.getFactor();
        msg = "-1 * (3000 / 0.1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CHO.toGos(-1.0), delta);
        msg = "-0.1 * (3000 / 0.1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CHO.toGos(-0.1), delta);
        msg = "-0.000456789 * (3000 / 0.1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CHO.toGos(-4.56789E-4), delta);
        msg = "-73.25 * (3000 / 0.1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CHO.toGos(-73.25), delta);
        msg = "-56229.321 * (3000 / 0.1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CHO.toGos(-56229.321), delta);
        msg = "-873.5432456 * (3000 / 0.1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CHO.toGos(-873.5432456), delta);
        msg = "0 * (3000 / 0.1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CHO.toGos(0.0), delta);
        msg = "0.1 * (3000 / 0.1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CHO.toGos(0.1), delta);
        msg = "0.0000876543297 * (3000 / 0.1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CHO.toGos(8.76543297E-5), delta);
        msg = "0.33 * (3000 / 0.1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CHO.toGos(0.33), delta);
        msg = "0.6543 * (3000 / 0.1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CHO.toGos(0.6543), delta);
        msg = "1 * (3000 / 0.1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CHO.toGos(1.0), delta);
        msg = "1.6543 * (3000 / 0.1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CHO.toGos(1.6543), delta);
        msg = "22.45 * (3000 / 0.1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CHO.toGos(22.45), delta);
        msg = "9876.5432 * (3000 / 0.1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CHO.toGos(9876.5432), delta);
        msg = "1987654344.3345 * (3000 / 0.1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CHO.toGos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3000 / 0.1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CHO.toGos(784.46789765434), delta);
        // ====================
        // ====================JO
        // ====================
        // to_factor = 0.5
        to_factor = JO.getFactor();
        msg = "-1 * (3000 / 0.5)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CHO.toJos(-1.0), delta);
        msg = "-0.1 * (3000 / 0.5)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CHO.toJos(-0.1), delta);
        msg = "-0.000456789 * (3000 / 0.5)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CHO.toJos(-4.56789E-4), delta);
        msg = "-73.25 * (3000 / 0.5)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CHO.toJos(-73.25), delta);
        msg = "-56229.321 * (3000 / 0.5)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CHO.toJos(-56229.321), delta);
        msg = "-873.5432456 * (3000 / 0.5)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CHO.toJos(-873.5432456), delta);
        msg = "0 * (3000 / 0.5)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CHO.toJos(0.0), delta);
        msg = "0.1 * (3000 / 0.5)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CHO.toJos(0.1), delta);
        msg = "0.0000876543297 * (3000 / 0.5)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CHO.toJos(8.76543297E-5), delta);
        msg = "0.33 * (3000 / 0.5)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CHO.toJos(0.33), delta);
        msg = "0.6543 * (3000 / 0.5)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CHO.toJos(0.6543), delta);
        msg = "1 * (3000 / 0.5)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CHO.toJos(1.0), delta);
        msg = "1.6543 * (3000 / 0.5)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CHO.toJos(1.6543), delta);
        msg = "22.45 * (3000 / 0.5)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CHO.toJos(22.45), delta);
        msg = "9876.5432 * (3000 / 0.5)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CHO.toJos(9876.5432), delta);
        msg = "1987654344.3345 * (3000 / 0.5)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CHO.toJos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3000 / 0.5)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CHO.toJos(784.46789765434), delta);
        // ====================
        // ====================TSUBO
        // ====================
        // to_factor = 1.0
        to_factor = TSUBO.getFactor();
        msg = "-1 * (3000 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CHO.toTsubos(-1.0), delta);
        msg = "-0.1 * (3000 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CHO.toTsubos(-0.1), delta);
        msg = "-0.000456789 * (3000 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CHO.toTsubos(-4.56789E-4), delta);
        msg = "-73.25 * (3000 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CHO.toTsubos(-73.25), delta);
        msg = "-56229.321 * (3000 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CHO.toTsubos(-56229.321), delta);
        msg = "-873.5432456 * (3000 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CHO.toTsubos(-873.5432456), delta);
        msg = "0 * (3000 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CHO.toTsubos(0.0), delta);
        msg = "0.1 * (3000 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CHO.toTsubos(0.1), delta);
        msg = "0.0000876543297 * (3000 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CHO.toTsubos(8.76543297E-5), delta);
        msg = "0.33 * (3000 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CHO.toTsubos(0.33), delta);
        msg = "0.6543 * (3000 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CHO.toTsubos(0.6543), delta);
        msg = "1 * (3000 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CHO.toTsubos(1.0), delta);
        msg = "1.6543 * (3000 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CHO.toTsubos(1.6543), delta);
        msg = "22.45 * (3000 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CHO.toTsubos(22.45), delta);
        msg = "9876.5432 * (3000 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CHO.toTsubos(9876.5432), delta);
        msg = "1987654344.3345 * (3000 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CHO.toTsubos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3000 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CHO.toTsubos(784.46789765434), delta);
        // ====================
        // ====================SE
        // ====================
        // to_factor = 30.0
        to_factor = SE.getFactor();
        msg = "-1 * (3000 / 30)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CHO.toSes(-1.0), delta);
        msg = "-0.1 * (3000 / 30)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CHO.toSes(-0.1), delta);
        msg = "-0.000456789 * (3000 / 30)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CHO.toSes(-4.56789E-4), delta);
        msg = "-73.25 * (3000 / 30)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CHO.toSes(-73.25), delta);
        msg = "-56229.321 * (3000 / 30)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CHO.toSes(-56229.321), delta);
        msg = "-873.5432456 * (3000 / 30)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CHO.toSes(-873.5432456), delta);
        msg = "0 * (3000 / 30)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CHO.toSes(0.0), delta);
        msg = "0.1 * (3000 / 30)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CHO.toSes(0.1), delta);
        msg = "0.0000876543297 * (3000 / 30)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CHO.toSes(8.76543297E-5), delta);
        msg = "0.33 * (3000 / 30)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CHO.toSes(0.33), delta);
        msg = "0.6543 * (3000 / 30)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CHO.toSes(0.6543), delta);
        msg = "1 * (3000 / 30)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CHO.toSes(1.0), delta);
        msg = "1.6543 * (3000 / 30)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CHO.toSes(1.6543), delta);
        msg = "22.45 * (3000 / 30)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CHO.toSes(22.45), delta);
        msg = "9876.5432 * (3000 / 30)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CHO.toSes(9876.5432), delta);
        msg = "1987654344.3345 * (3000 / 30)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CHO.toSes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3000 / 30)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CHO.toSes(784.46789765434), delta);
        // ====================
        // ====================TAN
        // ====================
        // to_factor = 300.0
        to_factor = TAN.getFactor();
        msg = "-1 * (3000 / 300)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CHO.toTans(-1.0), delta);
        msg = "-0.1 * (3000 / 300)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CHO.toTans(-0.1), delta);
        msg = "-0.000456789 * (3000 / 300)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CHO.toTans(-4.56789E-4), delta);
        msg = "-73.25 * (3000 / 300)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CHO.toTans(-73.25), delta);
        msg = "-56229.321 * (3000 / 300)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CHO.toTans(-56229.321), delta);
        msg = "-873.5432456 * (3000 / 300)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CHO.toTans(-873.5432456), delta);
        msg = "0 * (3000 / 300)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CHO.toTans(0.0), delta);
        msg = "0.1 * (3000 / 300)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CHO.toTans(0.1), delta);
        msg = "0.0000876543297 * (3000 / 300)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CHO.toTans(8.76543297E-5), delta);
        msg = "0.33 * (3000 / 300)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CHO.toTans(0.33), delta);
        msg = "0.6543 * (3000 / 300)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CHO.toTans(0.6543), delta);
        msg = "1 * (3000 / 300)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CHO.toTans(1.0), delta);
        msg = "1.6543 * (3000 / 300)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CHO.toTans(1.6543), delta);
        msg = "22.45 * (3000 / 300)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CHO.toTans(22.45), delta);
        msg = "9876.5432 * (3000 / 300)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CHO.toTans(9876.5432), delta);
        msg = "1987654344.3345 * (3000 / 300)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CHO.toTans(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3000 / 300)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CHO.toTans(784.46789765434), delta);
        // ====================
        // ====================CHO
        // ====================
        // to_factor = 3000.0
        to_factor = CHO.getFactor();
        msg = "-1 * (3000 / 3000)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CHO.toChos(-1.0), delta);
        msg = "-0.1 * (3000 / 3000)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CHO.toChos(-0.1), delta);
        msg = "-0.000456789 * (3000 / 3000)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CHO.toChos(-4.56789E-4), delta);
        msg = "-73.25 * (3000 / 3000)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CHO.toChos(-73.25), delta);
        msg = "-56229.321 * (3000 / 3000)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CHO.toChos(-56229.321), delta);
        msg = "-873.5432456 * (3000 / 3000)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CHO.toChos(-873.5432456), delta);
        msg = "0 * (3000 / 3000)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CHO.toChos(0.0), delta);
        msg = "0.1 * (3000 / 3000)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CHO.toChos(0.1), delta);
        msg = "0.0000876543297 * (3000 / 3000)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CHO.toChos(8.76543297E-5), delta);
        msg = "0.33 * (3000 / 3000)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CHO.toChos(0.33), delta);
        msg = "0.6543 * (3000 / 3000)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CHO.toChos(0.6543), delta);
        msg = "1 * (3000 / 3000)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CHO.toChos(1.0), delta);
        msg = "1.6543 * (3000 / 3000)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CHO.toChos(1.6543), delta);
        msg = "22.45 * (3000 / 3000)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CHO.toChos(22.45), delta);
        msg = "9876.5432 * (3000 / 3000)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CHO.toChos(9876.5432), delta);
        msg = "1987654344.3345 * (3000 / 3000)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CHO.toChos(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3000 / 3000)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CHO.toChos(784.46789765434), delta);
    }
}
