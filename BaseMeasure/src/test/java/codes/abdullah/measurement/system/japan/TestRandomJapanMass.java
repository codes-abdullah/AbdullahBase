package codes.abdullah.measurement.system.japan;

import static codes.abdullah.measurement.system.japan.Japans.FUN;
import static codes.abdullah.measurement.system.japan.Japans.HYAKUME;
import static codes.abdullah.measurement.system.japan.Japans.KAN;
import static codes.abdullah.measurement.system.japan.Japans.KIN;
import static codes.abdullah.measurement.system.japan.Japans.MARU;
import static codes.abdullah.measurement.system.japan.Japans.MOMME;
import static codes.abdullah.measurement.system.japan.Japans.TAN;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static codes.abdullah.measurement.utils.TestUtils.loops;
import static codes.abdullah.measurement.utils.TestUtils.nextDouble;
import static codes.abdullah.measurement.utils.TestUtils.noE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRandomJapanMass {

    @Test()
    public void testFun() {
        // from_factor = 6.25E-4
        double from_factor = FUN.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================FUN
            // ====================
            // to_factor = 6.25E-4
            to_factor = FUN.getFactor();
            msg = String.format("%s * (0.000625 / 0.000625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), FUN.toFuns(test), delta);
            // ====================
            // ====================MOMME
            // ====================
            // to_factor = 0.00625
            to_factor = MOMME.getFactor();
            msg = String.format("%s / (0.00625 / 0.000625)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), FUN.toMommes(test), delta);
            // ====================
            // ====================HYAKUME
            // ====================
            // to_factor = 0.625
            to_factor = HYAKUME.getFactor();
            msg = String.format("%s / (0.625 / 0.000625)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), FUN.toHyakumes(test), delta);
            // ====================
            // ====================KIN
            // ====================
            // to_factor = 1.0
            to_factor = KIN.getFactor();
            msg = String.format("%s / (1 / 0.000625)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), FUN.toKins(test), delta);
            // ====================
            // ====================KAN
            // ====================
            // to_factor = 6.25
            to_factor = KAN.getFactor();
            msg = String.format("%s / (6.25 / 0.000625)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), FUN.toKans(test), delta);
            // ====================
            // ====================MARU
            // ====================
            // to_factor = 50.0
            to_factor = MARU.getFactor();
            msg = String.format("%s / (50 / 0.000625)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), FUN.toMarus(test), delta);
            // ====================
            // ====================TAN
            // ====================
            // to_factor = 100.0
            to_factor = TAN.getFactor();
            msg = String.format("%s / (100 / 0.000625)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), FUN.toTans(test), delta);
        }
    }

    @Test()
    public void testMomme() {
        // from_factor = 0.00625
        double from_factor = MOMME.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================FUN
            // ====================
            // to_factor = 6.25E-4
            to_factor = FUN.getFactor();
            msg = String.format("%s * (0.00625 / 0.000625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MOMME.toFuns(test), delta);
            // ====================
            // ====================MOMME
            // ====================
            // to_factor = 0.00625
            to_factor = MOMME.getFactor();
            msg = String.format("%s * (0.00625 / 0.00625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MOMME.toMommes(test), delta);
            // ====================
            // ====================HYAKUME
            // ====================
            // to_factor = 0.625
            to_factor = HYAKUME.getFactor();
            msg = String.format("%s / (0.625 / 0.00625)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MOMME.toHyakumes(test), delta);
            // ====================
            // ====================KIN
            // ====================
            // to_factor = 1.0
            to_factor = KIN.getFactor();
            msg = String.format("%s / (1 / 0.00625)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MOMME.toKins(test), delta);
            // ====================
            // ====================KAN
            // ====================
            // to_factor = 6.25
            to_factor = KAN.getFactor();
            msg = String.format("%s / (6.25 / 0.00625)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MOMME.toKans(test), delta);
            // ====================
            // ====================MARU
            // ====================
            // to_factor = 50.0
            to_factor = MARU.getFactor();
            msg = String.format("%s / (50 / 0.00625)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MOMME.toMarus(test), delta);
            // ====================
            // ====================TAN
            // ====================
            // to_factor = 100.0
            to_factor = TAN.getFactor();
            msg = String.format("%s / (100 / 0.00625)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MOMME.toTans(test), delta);
        }
    }

    @Test()
    public void testHyakume() {
        // from_factor = 0.625
        double from_factor = HYAKUME.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================FUN
            // ====================
            // to_factor = 6.25E-4
            to_factor = FUN.getFactor();
            msg = String.format("%s * (0.625 / 0.000625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HYAKUME.toFuns(test), delta);
            // ====================
            // ====================MOMME
            // ====================
            // to_factor = 0.00625
            to_factor = MOMME.getFactor();
            msg = String.format("%s * (0.625 / 0.00625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HYAKUME.toMommes(test), delta);
            // ====================
            // ====================HYAKUME
            // ====================
            // to_factor = 0.625
            to_factor = HYAKUME.getFactor();
            msg = String.format("%s * (0.625 / 0.625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HYAKUME.toHyakumes(test), delta);
            // ====================
            // ====================KIN
            // ====================
            // to_factor = 1.0
            to_factor = KIN.getFactor();
            msg = String.format("%s / (1 / 0.625)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), HYAKUME.toKins(test), delta);
            // ====================
            // ====================KAN
            // ====================
            // to_factor = 6.25
            to_factor = KAN.getFactor();
            msg = String.format("%s / (6.25 / 0.625)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), HYAKUME.toKans(test), delta);
            // ====================
            // ====================MARU
            // ====================
            // to_factor = 50.0
            to_factor = MARU.getFactor();
            msg = String.format("%s / (50 / 0.625)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), HYAKUME.toMarus(test), delta);
            // ====================
            // ====================TAN
            // ====================
            // to_factor = 100.0
            to_factor = TAN.getFactor();
            msg = String.format("%s / (100 / 0.625)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), HYAKUME.toTans(test), delta);
        }
    }

    @Test()
    public void testKin() {
        // from_factor = 1.0
        double from_factor = KIN.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================FUN
            // ====================
            // to_factor = 6.25E-4
            to_factor = FUN.getFactor();
            msg = String.format("%s * (1 / 0.000625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KIN.toFuns(test), delta);
            // ====================
            // ====================MOMME
            // ====================
            // to_factor = 0.00625
            to_factor = MOMME.getFactor();
            msg = String.format("%s * (1 / 0.00625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KIN.toMommes(test), delta);
            // ====================
            // ====================HYAKUME
            // ====================
            // to_factor = 0.625
            to_factor = HYAKUME.getFactor();
            msg = String.format("%s * (1 / 0.625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KIN.toHyakumes(test), delta);
            // ====================
            // ====================KIN
            // ====================
            // to_factor = 1.0
            to_factor = KIN.getFactor();
            msg = String.format("%s * (1 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KIN.toKins(test), delta);
            // ====================
            // ====================KAN
            // ====================
            // to_factor = 6.25
            to_factor = KAN.getFactor();
            msg = String.format("%s / (6.25 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), KIN.toKans(test), delta);
            // ====================
            // ====================MARU
            // ====================
            // to_factor = 50.0
            to_factor = MARU.getFactor();
            msg = String.format("%s / (50 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), KIN.toMarus(test), delta);
            // ====================
            // ====================TAN
            // ====================
            // to_factor = 100.0
            to_factor = TAN.getFactor();
            msg = String.format("%s / (100 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), KIN.toTans(test), delta);
        }
    }

    @Test()
    public void testKan() {
        // from_factor = 6.25
        double from_factor = KAN.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================FUN
            // ====================
            // to_factor = 6.25E-4
            to_factor = FUN.getFactor();
            msg = String.format("%s * (6.25 / 0.000625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KAN.toFuns(test), delta);
            // ====================
            // ====================MOMME
            // ====================
            // to_factor = 0.00625
            to_factor = MOMME.getFactor();
            msg = String.format("%s * (6.25 / 0.00625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KAN.toMommes(test), delta);
            // ====================
            // ====================HYAKUME
            // ====================
            // to_factor = 0.625
            to_factor = HYAKUME.getFactor();
            msg = String.format("%s * (6.25 / 0.625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KAN.toHyakumes(test), delta);
            // ====================
            // ====================KIN
            // ====================
            // to_factor = 1.0
            to_factor = KIN.getFactor();
            msg = String.format("%s * (6.25 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KAN.toKins(test), delta);
            // ====================
            // ====================KAN
            // ====================
            // to_factor = 6.25
            to_factor = KAN.getFactor();
            msg = String.format("%s * (6.25 / 6.25)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KAN.toKans(test), delta);
            // ====================
            // ====================MARU
            // ====================
            // to_factor = 50.0
            to_factor = MARU.getFactor();
            msg = String.format("%s / (50 / 6.25)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), KAN.toMarus(test), delta);
            // ====================
            // ====================TAN
            // ====================
            // to_factor = 100.0
            to_factor = TAN.getFactor();
            msg = String.format("%s / (100 / 6.25)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), KAN.toTans(test), delta);
        }
    }

    @Test()
    public void testMaru() {
        // from_factor = 50.0
        double from_factor = MARU.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================FUN
            // ====================
            // to_factor = 6.25E-4
            to_factor = FUN.getFactor();
            msg = String.format("%s * (50 / 0.000625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MARU.toFuns(test), delta);
            // ====================
            // ====================MOMME
            // ====================
            // to_factor = 0.00625
            to_factor = MOMME.getFactor();
            msg = String.format("%s * (50 / 0.00625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MARU.toMommes(test), delta);
            // ====================
            // ====================HYAKUME
            // ====================
            // to_factor = 0.625
            to_factor = HYAKUME.getFactor();
            msg = String.format("%s * (50 / 0.625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MARU.toHyakumes(test), delta);
            // ====================
            // ====================KIN
            // ====================
            // to_factor = 1.0
            to_factor = KIN.getFactor();
            msg = String.format("%s * (50 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MARU.toKins(test), delta);
            // ====================
            // ====================KAN
            // ====================
            // to_factor = 6.25
            to_factor = KAN.getFactor();
            msg = String.format("%s * (50 / 6.25)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MARU.toKans(test), delta);
            // ====================
            // ====================MARU
            // ====================
            // to_factor = 50.0
            to_factor = MARU.getFactor();
            msg = String.format("%s * (50 / 50)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MARU.toMarus(test), delta);
            // ====================
            // ====================TAN
            // ====================
            // to_factor = 100.0
            to_factor = TAN.getFactor();
            msg = String.format("%s / (100 / 50)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MARU.toTans(test), delta);
        }
    }

    @Test()
    public void testTan() {
        // from_factor = 100.0
        double from_factor = TAN.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================FUN
            // ====================
            // to_factor = 6.25E-4
            to_factor = FUN.getFactor();
            msg = String.format("%s * (100 / 0.000625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TAN.toFuns(test), delta);
            // ====================
            // ====================MOMME
            // ====================
            // to_factor = 0.00625
            to_factor = MOMME.getFactor();
            msg = String.format("%s * (100 / 0.00625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TAN.toMommes(test), delta);
            // ====================
            // ====================HYAKUME
            // ====================
            // to_factor = 0.625
            to_factor = HYAKUME.getFactor();
            msg = String.format("%s * (100 / 0.625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TAN.toHyakumes(test), delta);
            // ====================
            // ====================KIN
            // ====================
            // to_factor = 1.0
            to_factor = KIN.getFactor();
            msg = String.format("%s * (100 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TAN.toKins(test), delta);
            // ====================
            // ====================KAN
            // ====================
            // to_factor = 6.25
            to_factor = KAN.getFactor();
            msg = String.format("%s * (100 / 6.25)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TAN.toKans(test), delta);
            // ====================
            // ====================MARU
            // ====================
            // to_factor = 50.0
            to_factor = MARU.getFactor();
            msg = String.format("%s * (100 / 50)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TAN.toMarus(test), delta);
            // ====================
            // ====================TAN
            // ====================
            // to_factor = 100.0
            to_factor = TAN.getFactor();
            msg = String.format("%s * (100 / 100)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TAN.toTans(test), delta);
        }
    }
}
