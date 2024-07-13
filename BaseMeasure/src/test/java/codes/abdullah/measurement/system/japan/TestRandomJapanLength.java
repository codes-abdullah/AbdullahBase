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
import static codes.abdullah.measurement.utils.TestUtils.loops;
import static codes.abdullah.measurement.utils.TestUtils.nextDouble;
import static codes.abdullah.measurement.utils.TestUtils.noE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRandomJapanLength {

    @Test()
    public void testMo() {
        // from_factor = 1.0E-4
        double from_factor = MO.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MO
            // ====================
            // to_factor = 1.0E-4
            to_factor = MO.getFactor();
            msg = String.format("%s * (0.0001 / 0.0001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MO.toMos(test), delta);
            // ====================
            // ====================RIN
            // ====================
            // to_factor = 0.001
            to_factor = RIN.getFactor();
            msg = String.format("%s / (0.001 / 0.0001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MO.toRins(test), delta);
            // ====================
            // ====================BU
            // ====================
            // to_factor = 0.01
            to_factor = BU.getFactor();
            msg = String.format("%s / (0.01 / 0.0001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MO.toBus(test), delta);
            // ====================
            // ====================SUN
            // ====================
            // to_factor = 0.1
            to_factor = SUN.getFactor();
            msg = String.format("%s / (0.1 / 0.0001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MO.toSuns(test), delta);
            // ====================
            // ====================SHAKU
            // ====================
            // to_factor = 1.0
            to_factor = SHAKU.getFactor();
            msg = String.format("%s / (1 / 0.0001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MO.toShakus(test), delta);
            // ====================
            // ====================KEN
            // ====================
            // to_factor = 6.0
            to_factor = KEN.getFactor();
            msg = String.format("%s / (6 / 0.0001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MO.toKens(test), delta);
            // ====================
            // ====================JO
            // ====================
            // to_factor = 10.0
            to_factor = JO.getFactor();
            msg = String.format("%s / (10 / 0.0001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MO.toJos(test), delta);
            // ====================
            // ====================CHO
            // ====================
            // to_factor = 360.0
            to_factor = CHO.getFactor();
            msg = String.format("%s / (360 / 0.0001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MO.toChos(test), delta);
            // ====================
            // ====================RI
            // ====================
            // to_factor = 12960.0
            to_factor = RI.getFactor();
            msg = String.format("%s / (12960 / 0.0001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MO.toRis(test), delta);
        }
    }

    @Test()
    public void testRin() {
        // from_factor = 0.001
        double from_factor = RIN.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MO
            // ====================
            // to_factor = 1.0E-4
            to_factor = MO.getFactor();
            msg = String.format("%s * (0.001 / 0.0001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), RIN.toMos(test), delta);
            // ====================
            // ====================RIN
            // ====================
            // to_factor = 0.001
            to_factor = RIN.getFactor();
            msg = String.format("%s * (0.001 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), RIN.toRins(test), delta);
            // ====================
            // ====================BU
            // ====================
            // to_factor = 0.01
            to_factor = BU.getFactor();
            msg = String.format("%s / (0.01 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), RIN.toBus(test), delta);
            // ====================
            // ====================SUN
            // ====================
            // to_factor = 0.1
            to_factor = SUN.getFactor();
            msg = String.format("%s / (0.1 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), RIN.toSuns(test), delta);
            // ====================
            // ====================SHAKU
            // ====================
            // to_factor = 1.0
            to_factor = SHAKU.getFactor();
            msg = String.format("%s / (1 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), RIN.toShakus(test), delta);
            // ====================
            // ====================KEN
            // ====================
            // to_factor = 6.0
            to_factor = KEN.getFactor();
            msg = String.format("%s / (6 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), RIN.toKens(test), delta);
            // ====================
            // ====================JO
            // ====================
            // to_factor = 10.0
            to_factor = JO.getFactor();
            msg = String.format("%s / (10 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), RIN.toJos(test), delta);
            // ====================
            // ====================CHO
            // ====================
            // to_factor = 360.0
            to_factor = CHO.getFactor();
            msg = String.format("%s / (360 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), RIN.toChos(test), delta);
            // ====================
            // ====================RI
            // ====================
            // to_factor = 12960.0
            to_factor = RI.getFactor();
            msg = String.format("%s / (12960 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), RIN.toRis(test), delta);
        }
    }

    @Test()
    public void testBu() {
        // from_factor = 0.01
        double from_factor = BU.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MO
            // ====================
            // to_factor = 1.0E-4
            to_factor = MO.getFactor();
            msg = String.format("%s * (0.01 / 0.0001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), BU.toMos(test), delta);
            // ====================
            // ====================RIN
            // ====================
            // to_factor = 0.001
            to_factor = RIN.getFactor();
            msg = String.format("%s * (0.01 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), BU.toRins(test), delta);
            // ====================
            // ====================BU
            // ====================
            // to_factor = 0.01
            to_factor = BU.getFactor();
            msg = String.format("%s * (0.01 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), BU.toBus(test), delta);
            // ====================
            // ====================SUN
            // ====================
            // to_factor = 0.1
            to_factor = SUN.getFactor();
            msg = String.format("%s / (0.1 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), BU.toSuns(test), delta);
            // ====================
            // ====================SHAKU
            // ====================
            // to_factor = 1.0
            to_factor = SHAKU.getFactor();
            msg = String.format("%s / (1 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), BU.toShakus(test), delta);
            // ====================
            // ====================KEN
            // ====================
            // to_factor = 6.0
            to_factor = KEN.getFactor();
            msg = String.format("%s / (6 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), BU.toKens(test), delta);
            // ====================
            // ====================JO
            // ====================
            // to_factor = 10.0
            to_factor = JO.getFactor();
            msg = String.format("%s / (10 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), BU.toJos(test), delta);
            // ====================
            // ====================CHO
            // ====================
            // to_factor = 360.0
            to_factor = CHO.getFactor();
            msg = String.format("%s / (360 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), BU.toChos(test), delta);
            // ====================
            // ====================RI
            // ====================
            // to_factor = 12960.0
            to_factor = RI.getFactor();
            msg = String.format("%s / (12960 / 0.01)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), BU.toRis(test), delta);
        }
    }

    @Test()
    public void testSun() {
        // from_factor = 0.1
        double from_factor = SUN.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MO
            // ====================
            // to_factor = 1.0E-4
            to_factor = MO.getFactor();
            msg = String.format("%s * (0.1 / 0.0001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SUN.toMos(test), delta);
            // ====================
            // ====================RIN
            // ====================
            // to_factor = 0.001
            to_factor = RIN.getFactor();
            msg = String.format("%s * (0.1 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SUN.toRins(test), delta);
            // ====================
            // ====================BU
            // ====================
            // to_factor = 0.01
            to_factor = BU.getFactor();
            msg = String.format("%s * (0.1 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SUN.toBus(test), delta);
            // ====================
            // ====================SUN
            // ====================
            // to_factor = 0.1
            to_factor = SUN.getFactor();
            msg = String.format("%s * (0.1 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SUN.toSuns(test), delta);
            // ====================
            // ====================SHAKU
            // ====================
            // to_factor = 1.0
            to_factor = SHAKU.getFactor();
            msg = String.format("%s / (1 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SUN.toShakus(test), delta);
            // ====================
            // ====================KEN
            // ====================
            // to_factor = 6.0
            to_factor = KEN.getFactor();
            msg = String.format("%s / (6 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SUN.toKens(test), delta);
            // ====================
            // ====================JO
            // ====================
            // to_factor = 10.0
            to_factor = JO.getFactor();
            msg = String.format("%s / (10 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SUN.toJos(test), delta);
            // ====================
            // ====================CHO
            // ====================
            // to_factor = 360.0
            to_factor = CHO.getFactor();
            msg = String.format("%s / (360 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SUN.toChos(test), delta);
            // ====================
            // ====================RI
            // ====================
            // to_factor = 12960.0
            to_factor = RI.getFactor();
            msg = String.format("%s / (12960 / 0.1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SUN.toRis(test), delta);
        }
    }

    @Test()
    public void testShaku() {
        // from_factor = 1.0
        double from_factor = SHAKU.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MO
            // ====================
            // to_factor = 1.0E-4
            to_factor = MO.getFactor();
            msg = String.format("%s * (1 / 0.0001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SHAKU.toMos(test), delta);
            // ====================
            // ====================RIN
            // ====================
            // to_factor = 0.001
            to_factor = RIN.getFactor();
            msg = String.format("%s * (1 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SHAKU.toRins(test), delta);
            // ====================
            // ====================BU
            // ====================
            // to_factor = 0.01
            to_factor = BU.getFactor();
            msg = String.format("%s * (1 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SHAKU.toBus(test), delta);
            // ====================
            // ====================SUN
            // ====================
            // to_factor = 0.1
            to_factor = SUN.getFactor();
            msg = String.format("%s * (1 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SHAKU.toSuns(test), delta);
            // ====================
            // ====================SHAKU
            // ====================
            // to_factor = 1.0
            to_factor = SHAKU.getFactor();
            msg = String.format("%s * (1 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SHAKU.toShakus(test), delta);
            // ====================
            // ====================KEN
            // ====================
            // to_factor = 6.0
            to_factor = KEN.getFactor();
            msg = String.format("%s / (6 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SHAKU.toKens(test), delta);
            // ====================
            // ====================JO
            // ====================
            // to_factor = 10.0
            to_factor = JO.getFactor();
            msg = String.format("%s / (10 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SHAKU.toJos(test), delta);
            // ====================
            // ====================CHO
            // ====================
            // to_factor = 360.0
            to_factor = CHO.getFactor();
            msg = String.format("%s / (360 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SHAKU.toChos(test), delta);
            // ====================
            // ====================RI
            // ====================
            // to_factor = 12960.0
            to_factor = RI.getFactor();
            msg = String.format("%s / (12960 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SHAKU.toRis(test), delta);
        }
    }

    @Test()
    public void testKen() {
        // from_factor = 6.0
        double from_factor = KEN.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MO
            // ====================
            // to_factor = 1.0E-4
            to_factor = MO.getFactor();
            msg = String.format("%s * (6 / 0.0001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KEN.toMos(test), delta);
            // ====================
            // ====================RIN
            // ====================
            // to_factor = 0.001
            to_factor = RIN.getFactor();
            msg = String.format("%s * (6 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KEN.toRins(test), delta);
            // ====================
            // ====================BU
            // ====================
            // to_factor = 0.01
            to_factor = BU.getFactor();
            msg = String.format("%s * (6 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KEN.toBus(test), delta);
            // ====================
            // ====================SUN
            // ====================
            // to_factor = 0.1
            to_factor = SUN.getFactor();
            msg = String.format("%s * (6 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KEN.toSuns(test), delta);
            // ====================
            // ====================SHAKU
            // ====================
            // to_factor = 1.0
            to_factor = SHAKU.getFactor();
            msg = String.format("%s * (6 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KEN.toShakus(test), delta);
            // ====================
            // ====================KEN
            // ====================
            // to_factor = 6.0
            to_factor = KEN.getFactor();
            msg = String.format("%s * (6 / 6)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KEN.toKens(test), delta);
            // ====================
            // ====================JO
            // ====================
            // to_factor = 10.0
            to_factor = JO.getFactor();
            msg = String.format("%s / (10 / 6)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), KEN.toJos(test), delta);
            // ====================
            // ====================CHO
            // ====================
            // to_factor = 360.0
            to_factor = CHO.getFactor();
            msg = String.format("%s / (360 / 6)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), KEN.toChos(test), delta);
            // ====================
            // ====================RI
            // ====================
            // to_factor = 12960.0
            to_factor = RI.getFactor();
            msg = String.format("%s / (12960 / 6)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), KEN.toRis(test), delta);
        }
    }

    @Test()
    public void testJo() {
        // from_factor = 10.0
        double from_factor = JO.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MO
            // ====================
            // to_factor = 1.0E-4
            to_factor = MO.getFactor();
            msg = String.format("%s * (10 / 0.0001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), JO.toMos(test), delta);
            // ====================
            // ====================RIN
            // ====================
            // to_factor = 0.001
            to_factor = RIN.getFactor();
            msg = String.format("%s * (10 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), JO.toRins(test), delta);
            // ====================
            // ====================BU
            // ====================
            // to_factor = 0.01
            to_factor = BU.getFactor();
            msg = String.format("%s * (10 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), JO.toBus(test), delta);
            // ====================
            // ====================SUN
            // ====================
            // to_factor = 0.1
            to_factor = SUN.getFactor();
            msg = String.format("%s * (10 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), JO.toSuns(test), delta);
            // ====================
            // ====================SHAKU
            // ====================
            // to_factor = 1.0
            to_factor = SHAKU.getFactor();
            msg = String.format("%s * (10 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), JO.toShakus(test), delta);
            // ====================
            // ====================KEN
            // ====================
            // to_factor = 6.0
            to_factor = KEN.getFactor();
            msg = String.format("%s * (10 / 6)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), JO.toKens(test), delta);
            // ====================
            // ====================JO
            // ====================
            // to_factor = 10.0
            to_factor = JO.getFactor();
            msg = String.format("%s * (10 / 10)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), JO.toJos(test), delta);
            // ====================
            // ====================CHO
            // ====================
            // to_factor = 360.0
            to_factor = CHO.getFactor();
            msg = String.format("%s / (360 / 10)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), JO.toChos(test), delta);
            // ====================
            // ====================RI
            // ====================
            // to_factor = 12960.0
            to_factor = RI.getFactor();
            msg = String.format("%s / (12960 / 10)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), JO.toRis(test), delta);
        }
    }

    @Test()
    public void testCho() {
        // from_factor = 360.0
        double from_factor = CHO.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MO
            // ====================
            // to_factor = 1.0E-4
            to_factor = MO.getFactor();
            msg = String.format("%s * (360 / 0.0001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CHO.toMos(test), delta);
            // ====================
            // ====================RIN
            // ====================
            // to_factor = 0.001
            to_factor = RIN.getFactor();
            msg = String.format("%s * (360 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CHO.toRins(test), delta);
            // ====================
            // ====================BU
            // ====================
            // to_factor = 0.01
            to_factor = BU.getFactor();
            msg = String.format("%s * (360 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CHO.toBus(test), delta);
            // ====================
            // ====================SUN
            // ====================
            // to_factor = 0.1
            to_factor = SUN.getFactor();
            msg = String.format("%s * (360 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CHO.toSuns(test), delta);
            // ====================
            // ====================SHAKU
            // ====================
            // to_factor = 1.0
            to_factor = SHAKU.getFactor();
            msg = String.format("%s * (360 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CHO.toShakus(test), delta);
            // ====================
            // ====================KEN
            // ====================
            // to_factor = 6.0
            to_factor = KEN.getFactor();
            msg = String.format("%s * (360 / 6)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CHO.toKens(test), delta);
            // ====================
            // ====================JO
            // ====================
            // to_factor = 10.0
            to_factor = JO.getFactor();
            msg = String.format("%s * (360 / 10)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CHO.toJos(test), delta);
            // ====================
            // ====================CHO
            // ====================
            // to_factor = 360.0
            to_factor = CHO.getFactor();
            msg = String.format("%s * (360 / 360)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CHO.toChos(test), delta);
            // ====================
            // ====================RI
            // ====================
            // to_factor = 12960.0
            to_factor = RI.getFactor();
            msg = String.format("%s / (12960 / 360)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), CHO.toRis(test), delta);
        }
    }

    @Test()
    public void testRi() {
        // from_factor = 12960.0
        double from_factor = RI.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================MO
            // ====================
            // to_factor = 1.0E-4
            to_factor = MO.getFactor();
            msg = String.format("%s * (12960 / 0.0001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), RI.toMos(test), delta);
            // ====================
            // ====================RIN
            // ====================
            // to_factor = 0.001
            to_factor = RIN.getFactor();
            msg = String.format("%s * (12960 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), RI.toRins(test), delta);
            // ====================
            // ====================BU
            // ====================
            // to_factor = 0.01
            to_factor = BU.getFactor();
            msg = String.format("%s * (12960 / 0.01)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), RI.toBus(test), delta);
            // ====================
            // ====================SUN
            // ====================
            // to_factor = 0.1
            to_factor = SUN.getFactor();
            msg = String.format("%s * (12960 / 0.1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), RI.toSuns(test), delta);
            // ====================
            // ====================SHAKU
            // ====================
            // to_factor = 1.0
            to_factor = SHAKU.getFactor();
            msg = String.format("%s * (12960 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), RI.toShakus(test), delta);
            // ====================
            // ====================KEN
            // ====================
            // to_factor = 6.0
            to_factor = KEN.getFactor();
            msg = String.format("%s * (12960 / 6)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), RI.toKens(test), delta);
            // ====================
            // ====================JO
            // ====================
            // to_factor = 10.0
            to_factor = JO.getFactor();
            msg = String.format("%s * (12960 / 10)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), RI.toJos(test), delta);
            // ====================
            // ====================CHO
            // ====================
            // to_factor = 360.0
            to_factor = CHO.getFactor();
            msg = String.format("%s * (12960 / 360)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), RI.toChos(test), delta);
            // ====================
            // ====================RI
            // ====================
            // to_factor = 12960.0
            to_factor = RI.getFactor();
            msg = String.format("%s * (12960 / 12960)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), RI.toRis(test), delta);
        }
    }
}
