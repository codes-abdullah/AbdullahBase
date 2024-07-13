package codes.abdullah.measurement.system.japan;

import static codes.abdullah.measurement.system.japan.Japans.area.CHO;
import static codes.abdullah.measurement.system.japan.Japans.area.GO;
import static codes.abdullah.measurement.system.japan.Japans.area.JO;
import static codes.abdullah.measurement.system.japan.Japans.area.SE;
import static codes.abdullah.measurement.system.japan.Japans.area.SHAKU;
import static codes.abdullah.measurement.system.japan.Japans.area.TAN;
import static codes.abdullah.measurement.system.japan.Japans.area.TSUBO;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static codes.abdullah.measurement.utils.TestUtils.loops;
import static codes.abdullah.measurement.utils.TestUtils.nextDouble;
import static codes.abdullah.measurement.utils.TestUtils.noE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRandomJapanArea {

    @Test()
    public void testShaku() {
        // from_factor = 0.01
        double from_factor = SHAKU.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SHAKU
            // ====================
            // to_factor = 0.01
            to_factor = SHAKU.getFactor();
            msg = String.format("%s * (0.01 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SHAKU.toShakus(test), delta);
            // ====================
            // ====================GO
            // ====================
            // to_factor = 0.1
            to_factor = GO.getFactor();
            msg = String.format("%s / (0.1 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SHAKU.toGos(test), delta);
            // ====================
            // ====================JO
            // ====================
            // to_factor = 0.5
            to_factor = JO.getFactor();
            msg = String.format("%s / (0.5 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SHAKU.toJos(test), delta);
            // ====================
            // ====================TSUBO
            // ====================
            // to_factor = 1.0
            to_factor = TSUBO.getFactor();
            msg = String.format("%s / (1 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SHAKU.toTsubos(test), delta);
            // ====================
            // ====================SE
            // ====================
            // to_factor = 30.0
            to_factor = SE.getFactor();
            msg = String.format("%s / (30 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SHAKU.toSes(test), delta);
            // ====================
            // ====================TAN
            // ====================
            // to_factor = 300.0
            to_factor = TAN.getFactor();
            msg = String.format("%s / (300 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SHAKU.toTans(test), delta);
            // ====================
            // ====================CHO
            // ====================
            // to_factor = 3000.0
            to_factor = CHO.getFactor();
            msg = String.format("%s / (3000 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SHAKU.toChos(test), delta);
        }
    }

    @Test()
    public void testGo() {
        // from_factor = 0.1
        double from_factor = GO.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SHAKU
            // ====================
            // to_factor = 0.01
            to_factor = SHAKU.getFactor();
            msg = String.format("%s * (0.1 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GO.toShakus(test), delta);
            // ====================
            // ====================GO
            // ====================
            // to_factor = 0.1
            to_factor = GO.getFactor();
            msg = String.format("%s * (0.1 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GO.toGos(test), delta);
            // ====================
            // ====================JO
            // ====================
            // to_factor = 0.5
            to_factor = JO.getFactor();
            msg = String.format("%s / (0.5 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GO.toJos(test), delta);
            // ====================
            // ====================TSUBO
            // ====================
            // to_factor = 1.0
            to_factor = TSUBO.getFactor();
            msg = String.format("%s / (1 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GO.toTsubos(test), delta);
            // ====================
            // ====================SE
            // ====================
            // to_factor = 30.0
            to_factor = SE.getFactor();
            msg = String.format("%s / (30 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GO.toSes(test), delta);
            // ====================
            // ====================TAN
            // ====================
            // to_factor = 300.0
            to_factor = TAN.getFactor();
            msg = String.format("%s / (300 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GO.toTans(test), delta);
            // ====================
            // ====================CHO
            // ====================
            // to_factor = 3000.0
            to_factor = CHO.getFactor();
            msg = String.format("%s / (3000 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GO.toChos(test), delta);
        }
    }

    @Test()
    public void testJo() {
        // from_factor = 0.5
        double from_factor = JO.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SHAKU
            // ====================
            // to_factor = 0.01
            to_factor = SHAKU.getFactor();
            msg = String.format("%s * (0.5 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), JO.toShakus(test), delta);
            // ====================
            // ====================GO
            // ====================
            // to_factor = 0.1
            to_factor = GO.getFactor();
            msg = String.format("%s * (0.5 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), JO.toGos(test), delta);
            // ====================
            // ====================JO
            // ====================
            // to_factor = 0.5
            to_factor = JO.getFactor();
            msg = String.format("%s * (0.5 / 0.5)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), JO.toJos(test), delta);
            // ====================
            // ====================TSUBO
            // ====================
            // to_factor = 1.0
            to_factor = TSUBO.getFactor();
            msg = String.format("%s / (1 / 0.5)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), JO.toTsubos(test), delta);
            // ====================
            // ====================SE
            // ====================
            // to_factor = 30.0
            to_factor = SE.getFactor();
            msg = String.format("%s / (30 / 0.5)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), JO.toSes(test), delta);
            // ====================
            // ====================TAN
            // ====================
            // to_factor = 300.0
            to_factor = TAN.getFactor();
            msg = String.format("%s / (300 / 0.5)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), JO.toTans(test), delta);
            // ====================
            // ====================CHO
            // ====================
            // to_factor = 3000.0
            to_factor = CHO.getFactor();
            msg = String.format("%s / (3000 / 0.5)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), JO.toChos(test), delta);
        }
    }

    @Test()
    public void testTsubo() {
        // from_factor = 1.0
        double from_factor = TSUBO.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SHAKU
            // ====================
            // to_factor = 0.01
            to_factor = SHAKU.getFactor();
            msg = String.format("%s * (1 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TSUBO.toShakus(test), delta);
            // ====================
            // ====================GO
            // ====================
            // to_factor = 0.1
            to_factor = GO.getFactor();
            msg = String.format("%s * (1 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TSUBO.toGos(test), delta);
            // ====================
            // ====================JO
            // ====================
            // to_factor = 0.5
            to_factor = JO.getFactor();
            msg = String.format("%s * (1 / 0.5)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TSUBO.toJos(test), delta);
            // ====================
            // ====================TSUBO
            // ====================
            // to_factor = 1.0
            to_factor = TSUBO.getFactor();
            msg = String.format("%s * (1 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TSUBO.toTsubos(test), delta);
            // ====================
            // ====================SE
            // ====================
            // to_factor = 30.0
            to_factor = SE.getFactor();
            msg = String.format("%s / (30 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), TSUBO.toSes(test), delta);
            // ====================
            // ====================TAN
            // ====================
            // to_factor = 300.0
            to_factor = TAN.getFactor();
            msg = String.format("%s / (300 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), TSUBO.toTans(test), delta);
            // ====================
            // ====================CHO
            // ====================
            // to_factor = 3000.0
            to_factor = CHO.getFactor();
            msg = String.format("%s / (3000 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), TSUBO.toChos(test), delta);
        }
    }

    @Test()
    public void testSe() {
        // from_factor = 30.0
        double from_factor = SE.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SHAKU
            // ====================
            // to_factor = 0.01
            to_factor = SHAKU.getFactor();
            msg = String.format("%s * (30 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SE.toShakus(test), delta);
            // ====================
            // ====================GO
            // ====================
            // to_factor = 0.1
            to_factor = GO.getFactor();
            msg = String.format("%s * (30 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SE.toGos(test), delta);
            // ====================
            // ====================JO
            // ====================
            // to_factor = 0.5
            to_factor = JO.getFactor();
            msg = String.format("%s * (30 / 0.5)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SE.toJos(test), delta);
            // ====================
            // ====================TSUBO
            // ====================
            // to_factor = 1.0
            to_factor = TSUBO.getFactor();
            msg = String.format("%s * (30 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SE.toTsubos(test), delta);
            // ====================
            // ====================SE
            // ====================
            // to_factor = 30.0
            to_factor = SE.getFactor();
            msg = String.format("%s * (30 / 30)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SE.toSes(test), delta);
            // ====================
            // ====================TAN
            // ====================
            // to_factor = 300.0
            to_factor = TAN.getFactor();
            msg = String.format("%s / (300 / 30)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SE.toTans(test), delta);
            // ====================
            // ====================CHO
            // ====================
            // to_factor = 3000.0
            to_factor = CHO.getFactor();
            msg = String.format("%s / (3000 / 30)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SE.toChos(test), delta);
        }
    }

    @Test()
    public void testTan() {
        // from_factor = 300.0
        double from_factor = TAN.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SHAKU
            // ====================
            // to_factor = 0.01
            to_factor = SHAKU.getFactor();
            msg = String.format("%s * (300 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TAN.toShakus(test), delta);
            // ====================
            // ====================GO
            // ====================
            // to_factor = 0.1
            to_factor = GO.getFactor();
            msg = String.format("%s * (300 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TAN.toGos(test), delta);
            // ====================
            // ====================JO
            // ====================
            // to_factor = 0.5
            to_factor = JO.getFactor();
            msg = String.format("%s * (300 / 0.5)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TAN.toJos(test), delta);
            // ====================
            // ====================TSUBO
            // ====================
            // to_factor = 1.0
            to_factor = TSUBO.getFactor();
            msg = String.format("%s * (300 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TAN.toTsubos(test), delta);
            // ====================
            // ====================SE
            // ====================
            // to_factor = 30.0
            to_factor = SE.getFactor();
            msg = String.format("%s * (300 / 30)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TAN.toSes(test), delta);
            // ====================
            // ====================TAN
            // ====================
            // to_factor = 300.0
            to_factor = TAN.getFactor();
            msg = String.format("%s * (300 / 300)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TAN.toTans(test), delta);
            // ====================
            // ====================CHO
            // ====================
            // to_factor = 3000.0
            to_factor = CHO.getFactor();
            msg = String.format("%s / (3000 / 300)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), TAN.toChos(test), delta);
        }
    }

    @Test()
    public void testCho() {
        // from_factor = 3000.0
        double from_factor = CHO.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SHAKU
            // ====================
            // to_factor = 0.01
            to_factor = SHAKU.getFactor();
            msg = String.format("%s * (3000 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CHO.toShakus(test), delta);
            // ====================
            // ====================GO
            // ====================
            // to_factor = 0.1
            to_factor = GO.getFactor();
            msg = String.format("%s * (3000 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CHO.toGos(test), delta);
            // ====================
            // ====================JO
            // ====================
            // to_factor = 0.5
            to_factor = JO.getFactor();
            msg = String.format("%s * (3000 / 0.5)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CHO.toJos(test), delta);
            // ====================
            // ====================TSUBO
            // ====================
            // to_factor = 1.0
            to_factor = TSUBO.getFactor();
            msg = String.format("%s * (3000 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CHO.toTsubos(test), delta);
            // ====================
            // ====================SE
            // ====================
            // to_factor = 30.0
            to_factor = SE.getFactor();
            msg = String.format("%s * (3000 / 30)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CHO.toSes(test), delta);
            // ====================
            // ====================TAN
            // ====================
            // to_factor = 300.0
            to_factor = TAN.getFactor();
            msg = String.format("%s * (3000 / 300)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CHO.toTans(test), delta);
            // ====================
            // ====================CHO
            // ====================
            // to_factor = 3000.0
            to_factor = CHO.getFactor();
            msg = String.format("%s * (3000 / 3000)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CHO.toChos(test), delta);
        }
    }
}
