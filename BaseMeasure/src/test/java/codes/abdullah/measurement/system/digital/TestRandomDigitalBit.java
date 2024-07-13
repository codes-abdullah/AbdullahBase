package codes.abdullah.measurement.system.digital;

import static codes.abdullah.measurement.system.digital.Digitals.BIT;
import static codes.abdullah.measurement.system.digital.Digitals.GIGABIT;
import static codes.abdullah.measurement.system.digital.Digitals.KILOBIT;
import static codes.abdullah.measurement.system.digital.Digitals.MEGABIT;
import static codes.abdullah.measurement.system.digital.Digitals.PETABIT;
import static codes.abdullah.measurement.system.digital.Digitals.TERABIT;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static codes.abdullah.measurement.utils.TestUtils.loops;
import static codes.abdullah.measurement.utils.TestUtils.nextDouble;
import static codes.abdullah.measurement.utils.TestUtils.noE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRandomDigitalBit {

    @Test()
    public void testBit() {
        // from_factor = 1.0E-6
        double from_factor = BIT.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================BIT
            // ====================
            // to_factor = 1.0E-6
            to_factor = BIT.getFactor();
            msg = String.format("%s * (0.000001 / 0.000001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), BIT.toBits(test), delta);
            // ====================
            // ====================KILOBIT
            // ====================
            // to_factor = 0.001
            to_factor = KILOBIT.getFactor();
            msg = String.format("%s / (0.001 / 0.000001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), BIT.toKilobits(test), delta);
            // ====================
            // ====================MEGABIT
            // ====================
            // to_factor = 1.0
            to_factor = MEGABIT.getFactor();
            msg = String.format("%s / (1 / 0.000001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), BIT.toMegabits(test), delta);
            // ====================
            // ====================GIGABIT
            // ====================
            // to_factor = 1000.0
            to_factor = GIGABIT.getFactor();
            msg = String.format("%s / (1000 / 0.000001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), BIT.toGigabits(test), delta);
            // ====================
            // ====================TERABIT
            // ====================
            // to_factor = 1000000.0
            to_factor = TERABIT.getFactor();
            msg = String.format("%s / (1000000 / 0.000001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), BIT.toTerabits(test), delta);
            // ====================
            // ====================PETABIT
            // ====================
            // to_factor = 1.0E9
            to_factor = PETABIT.getFactor();
            msg = String.format("%s / (1000000000 / 0.000001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), BIT.toPetabits(test), delta);
        }
    }

    @Test()
    public void testKilobit() {
        // from_factor = 0.001
        double from_factor = KILOBIT.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================BIT
            // ====================
            // to_factor = 1.0E-6
            to_factor = BIT.getFactor();
            msg = String.format("%s * (0.001 / 0.000001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOBIT.toBits(test), delta);
            // ====================
            // ====================KILOBIT
            // ====================
            // to_factor = 0.001
            to_factor = KILOBIT.getFactor();
            msg = String.format("%s * (0.001 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOBIT.toKilobits(test), delta);
            // ====================
            // ====================MEGABIT
            // ====================
            // to_factor = 1.0
            to_factor = MEGABIT.getFactor();
            msg = String.format("%s / (1 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), KILOBIT.toMegabits(test), delta);
            // ====================
            // ====================GIGABIT
            // ====================
            // to_factor = 1000.0
            to_factor = GIGABIT.getFactor();
            msg = String.format("%s / (1000 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), KILOBIT.toGigabits(test), delta);
            // ====================
            // ====================TERABIT
            // ====================
            // to_factor = 1000000.0
            to_factor = TERABIT.getFactor();
            msg = String.format("%s / (1000000 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), KILOBIT.toTerabits(test), delta);
            // ====================
            // ====================PETABIT
            // ====================
            // to_factor = 1.0E9
            to_factor = PETABIT.getFactor();
            msg = String.format("%s / (1000000000 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), KILOBIT.toPetabits(test), delta);
        }
    }

    @Test()
    public void testMegabit() {
        // from_factor = 1.0
        double from_factor = MEGABIT.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================BIT
            // ====================
            // to_factor = 1.0E-6
            to_factor = BIT.getFactor();
            msg = String.format("%s * (1 / 0.000001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MEGABIT.toBits(test), delta);
            // ====================
            // ====================KILOBIT
            // ====================
            // to_factor = 0.001
            to_factor = KILOBIT.getFactor();
            msg = String.format("%s * (1 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MEGABIT.toKilobits(test), delta);
            // ====================
            // ====================MEGABIT
            // ====================
            // to_factor = 1.0
            to_factor = MEGABIT.getFactor();
            msg = String.format("%s * (1 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MEGABIT.toMegabits(test), delta);
            // ====================
            // ====================GIGABIT
            // ====================
            // to_factor = 1000.0
            to_factor = GIGABIT.getFactor();
            msg = String.format("%s / (1000 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MEGABIT.toGigabits(test), delta);
            // ====================
            // ====================TERABIT
            // ====================
            // to_factor = 1000000.0
            to_factor = TERABIT.getFactor();
            msg = String.format("%s / (1000000 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MEGABIT.toTerabits(test), delta);
            // ====================
            // ====================PETABIT
            // ====================
            // to_factor = 1.0E9
            to_factor = PETABIT.getFactor();
            msg = String.format("%s / (1000000000 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MEGABIT.toPetabits(test), delta);
        }
    }

    @Test()
    public void testGigabit() {
        // from_factor = 1000.0
        double from_factor = GIGABIT.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================BIT
            // ====================
            // to_factor = 1.0E-6
            to_factor = BIT.getFactor();
            msg = String.format("%s * (1000 / 0.000001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GIGABIT.toBits(test), delta);
            // ====================
            // ====================KILOBIT
            // ====================
            // to_factor = 0.001
            to_factor = KILOBIT.getFactor();
            msg = String.format("%s * (1000 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GIGABIT.toKilobits(test), delta);
            // ====================
            // ====================MEGABIT
            // ====================
            // to_factor = 1.0
            to_factor = MEGABIT.getFactor();
            msg = String.format("%s * (1000 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GIGABIT.toMegabits(test), delta);
            // ====================
            // ====================GIGABIT
            // ====================
            // to_factor = 1000.0
            to_factor = GIGABIT.getFactor();
            msg = String.format("%s * (1000 / 1000)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GIGABIT.toGigabits(test), delta);
            // ====================
            // ====================TERABIT
            // ====================
            // to_factor = 1000000.0
            to_factor = TERABIT.getFactor();
            msg = String.format("%s / (1000000 / 1000)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GIGABIT.toTerabits(test), delta);
            // ====================
            // ====================PETABIT
            // ====================
            // to_factor = 1.0E9
            to_factor = PETABIT.getFactor();
            msg = String.format("%s / (1000000000 / 1000)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GIGABIT.toPetabits(test), delta);
        }
    }

    @Test()
    public void testTerabit() {
        // from_factor = 1000000.0
        double from_factor = TERABIT.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================BIT
            // ====================
            // to_factor = 1.0E-6
            to_factor = BIT.getFactor();
            msg = String.format("%s * (1000000 / 0.000001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TERABIT.toBits(test), delta);
            // ====================
            // ====================KILOBIT
            // ====================
            // to_factor = 0.001
            to_factor = KILOBIT.getFactor();
            msg = String.format("%s * (1000000 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TERABIT.toKilobits(test), delta);
            // ====================
            // ====================MEGABIT
            // ====================
            // to_factor = 1.0
            to_factor = MEGABIT.getFactor();
            msg = String.format("%s * (1000000 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TERABIT.toMegabits(test), delta);
            // ====================
            // ====================GIGABIT
            // ====================
            // to_factor = 1000.0
            to_factor = GIGABIT.getFactor();
            msg = String.format("%s * (1000000 / 1000)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TERABIT.toGigabits(test), delta);
            // ====================
            // ====================TERABIT
            // ====================
            // to_factor = 1000000.0
            to_factor = TERABIT.getFactor();
            msg = String.format("%s * (1000000 / 1000000)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TERABIT.toTerabits(test), delta);
            // ====================
            // ====================PETABIT
            // ====================
            // to_factor = 1.0E9
            to_factor = PETABIT.getFactor();
            msg = String.format("%s / (1000000000 / 1000000)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), TERABIT.toPetabits(test), delta);
        }
    }

    @Test()
    public void testPetabit() {
        // from_factor = 1.0E9
        double from_factor = PETABIT.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================BIT
            // ====================
            // to_factor = 1.0E-6
            to_factor = BIT.getFactor();
            msg = String.format("%s * (1000000000 / 0.000001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), PETABIT.toBits(test), delta);
            // ====================
            // ====================KILOBIT
            // ====================
            // to_factor = 0.001
            to_factor = KILOBIT.getFactor();
            msg = String.format("%s * (1000000000 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), PETABIT.toKilobits(test), delta);
            // ====================
            // ====================MEGABIT
            // ====================
            // to_factor = 1.0
            to_factor = MEGABIT.getFactor();
            msg = String.format("%s * (1000000000 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), PETABIT.toMegabits(test), delta);
            // ====================
            // ====================GIGABIT
            // ====================
            // to_factor = 1000.0
            to_factor = GIGABIT.getFactor();
            msg = String.format("%s * (1000000000 / 1000)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), PETABIT.toGigabits(test), delta);
            // ====================
            // ====================TERABIT
            // ====================
            // to_factor = 1000000.0
            to_factor = TERABIT.getFactor();
            msg = String.format("%s * (1000000000 / 1000000)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), PETABIT.toTerabits(test), delta);
            // ====================
            // ====================PETABIT
            // ====================
            // to_factor = 1.0E9
            to_factor = PETABIT.getFactor();
            msg = String.format("%s * (1000000000 / 1000000000)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), PETABIT.toPetabits(test), delta);
        }
    }
}
