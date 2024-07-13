package codes.abdullah.measurement.system.digital;

import static codes.abdullah.measurement.system.digital.Digitals.BYTE;
import static codes.abdullah.measurement.system.digital.Digitals.GIGABYTE;
import static codes.abdullah.measurement.system.digital.Digitals.KILOBYTE;
import static codes.abdullah.measurement.system.digital.Digitals.MEGABYTE;
import static codes.abdullah.measurement.system.digital.Digitals.PETABYTE;
import static codes.abdullah.measurement.system.digital.Digitals.TERABYTE;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static codes.abdullah.measurement.utils.TestUtils.loops;
import static codes.abdullah.measurement.utils.TestUtils.nextDouble;
import static codes.abdullah.measurement.utils.TestUtils.noE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRandomDigitalByte {

    @Test()
    public void testByte() {
        // from_factor = 1.0E-6
        double from_factor = BYTE.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================BYTE
            // ====================
            // to_factor = 1.0E-6
            to_factor = BYTE.getFactor();
            msg = String.format("%s * (0.000001 / 0.000001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), BYTE.toBytes(test), delta);
            // ====================
            // ====================KILOBYTE
            // ====================
            // to_factor = 0.001
            to_factor = KILOBYTE.getFactor();
            msg = String.format("%s / (0.001 / 0.000001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), BYTE.toKilobytes(test), delta);
            // ====================
            // ====================MEGABYTE
            // ====================
            // to_factor = 1.0
            to_factor = MEGABYTE.getFactor();
            msg = String.format("%s / (1 / 0.000001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), BYTE.toMegabytes(test), delta);
            // ====================
            // ====================GIGABYTE
            // ====================
            // to_factor = 1000.0
            to_factor = GIGABYTE.getFactor();
            msg = String.format("%s / (1000 / 0.000001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), BYTE.toGigabytes(test), delta);
            // ====================
            // ====================TERABYTE
            // ====================
            // to_factor = 1000000.0
            to_factor = TERABYTE.getFactor();
            msg = String.format("%s / (1000000 / 0.000001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), BYTE.toTerabytes(test), delta);
            // ====================
            // ====================PETABYTE
            // ====================
            // to_factor = 1.0E9
            to_factor = PETABYTE.getFactor();
            msg = String.format("%s / (1000000000 / 0.000001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), BYTE.toPetabytes(test), delta);
        }
    }

    @Test()
    public void testKilobyte() {
        // from_factor = 0.001
        double from_factor = KILOBYTE.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================BYTE
            // ====================
            // to_factor = 1.0E-6
            to_factor = BYTE.getFactor();
            msg = String.format("%s * (0.001 / 0.000001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOBYTE.toBytes(test), delta);
            // ====================
            // ====================KILOBYTE
            // ====================
            // to_factor = 0.001
            to_factor = KILOBYTE.getFactor();
            msg = String.format("%s * (0.001 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), KILOBYTE.toKilobytes(test), delta);
            // ====================
            // ====================MEGABYTE
            // ====================
            // to_factor = 1.0
            to_factor = MEGABYTE.getFactor();
            msg = String.format("%s / (1 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), KILOBYTE.toMegabytes(test), delta);
            // ====================
            // ====================GIGABYTE
            // ====================
            // to_factor = 1000.0
            to_factor = GIGABYTE.getFactor();
            msg = String.format("%s / (1000 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), KILOBYTE.toGigabytes(test), delta);
            // ====================
            // ====================TERABYTE
            // ====================
            // to_factor = 1000000.0
            to_factor = TERABYTE.getFactor();
            msg = String.format("%s / (1000000 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), KILOBYTE.toTerabytes(test), delta);
            // ====================
            // ====================PETABYTE
            // ====================
            // to_factor = 1.0E9
            to_factor = PETABYTE.getFactor();
            msg = String.format("%s / (1000000000 / 0.001)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), KILOBYTE.toPetabytes(test), delta);
        }
    }

    @Test()
    public void testMegabyte() {
        // from_factor = 1.0
        double from_factor = MEGABYTE.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================BYTE
            // ====================
            // to_factor = 1.0E-6
            to_factor = BYTE.getFactor();
            msg = String.format("%s * (1 / 0.000001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MEGABYTE.toBytes(test), delta);
            // ====================
            // ====================KILOBYTE
            // ====================
            // to_factor = 0.001
            to_factor = KILOBYTE.getFactor();
            msg = String.format("%s * (1 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MEGABYTE.toKilobytes(test), delta);
            // ====================
            // ====================MEGABYTE
            // ====================
            // to_factor = 1.0
            to_factor = MEGABYTE.getFactor();
            msg = String.format("%s * (1 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MEGABYTE.toMegabytes(test), delta);
            // ====================
            // ====================GIGABYTE
            // ====================
            // to_factor = 1000.0
            to_factor = GIGABYTE.getFactor();
            msg = String.format("%s / (1000 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MEGABYTE.toGigabytes(test), delta);
            // ====================
            // ====================TERABYTE
            // ====================
            // to_factor = 1000000.0
            to_factor = TERABYTE.getFactor();
            msg = String.format("%s / (1000000 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MEGABYTE.toTerabytes(test), delta);
            // ====================
            // ====================PETABYTE
            // ====================
            // to_factor = 1.0E9
            to_factor = PETABYTE.getFactor();
            msg = String.format("%s / (1000000000 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), MEGABYTE.toPetabytes(test), delta);
        }
    }

    @Test()
    public void testGigabyte() {
        // from_factor = 1000.0
        double from_factor = GIGABYTE.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================BYTE
            // ====================
            // to_factor = 1.0E-6
            to_factor = BYTE.getFactor();
            msg = String.format("%s * (1000 / 0.000001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GIGABYTE.toBytes(test), delta);
            // ====================
            // ====================KILOBYTE
            // ====================
            // to_factor = 0.001
            to_factor = KILOBYTE.getFactor();
            msg = String.format("%s * (1000 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GIGABYTE.toKilobytes(test), delta);
            // ====================
            // ====================MEGABYTE
            // ====================
            // to_factor = 1.0
            to_factor = MEGABYTE.getFactor();
            msg = String.format("%s * (1000 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GIGABYTE.toMegabytes(test), delta);
            // ====================
            // ====================GIGABYTE
            // ====================
            // to_factor = 1000.0
            to_factor = GIGABYTE.getFactor();
            msg = String.format("%s * (1000 / 1000)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GIGABYTE.toGigabytes(test), delta);
            // ====================
            // ====================TERABYTE
            // ====================
            // to_factor = 1000000.0
            to_factor = TERABYTE.getFactor();
            msg = String.format("%s / (1000000 / 1000)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GIGABYTE.toTerabytes(test), delta);
            // ====================
            // ====================PETABYTE
            // ====================
            // to_factor = 1.0E9
            to_factor = PETABYTE.getFactor();
            msg = String.format("%s / (1000000000 / 1000)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GIGABYTE.toPetabytes(test), delta);
        }
    }

    @Test()
    public void testTerabyte() {
        // from_factor = 1000000.0
        double from_factor = TERABYTE.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================BYTE
            // ====================
            // to_factor = 1.0E-6
            to_factor = BYTE.getFactor();
            msg = String.format("%s * (1000000 / 0.000001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TERABYTE.toBytes(test), delta);
            // ====================
            // ====================KILOBYTE
            // ====================
            // to_factor = 0.001
            to_factor = KILOBYTE.getFactor();
            msg = String.format("%s * (1000000 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TERABYTE.toKilobytes(test), delta);
            // ====================
            // ====================MEGABYTE
            // ====================
            // to_factor = 1.0
            to_factor = MEGABYTE.getFactor();
            msg = String.format("%s * (1000000 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TERABYTE.toMegabytes(test), delta);
            // ====================
            // ====================GIGABYTE
            // ====================
            // to_factor = 1000.0
            to_factor = GIGABYTE.getFactor();
            msg = String.format("%s * (1000000 / 1000)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TERABYTE.toGigabytes(test), delta);
            // ====================
            // ====================TERABYTE
            // ====================
            // to_factor = 1000000.0
            to_factor = TERABYTE.getFactor();
            msg = String.format("%s * (1000000 / 1000000)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TERABYTE.toTerabytes(test), delta);
            // ====================
            // ====================PETABYTE
            // ====================
            // to_factor = 1.0E9
            to_factor = PETABYTE.getFactor();
            msg = String.format("%s / (1000000000 / 1000000)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), TERABYTE.toPetabytes(test), delta);
        }
    }

    @Test()
    public void testPetabyte() {
        // from_factor = 1.0E9
        double from_factor = PETABYTE.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================BYTE
            // ====================
            // to_factor = 1.0E-6
            to_factor = BYTE.getFactor();
            msg = String.format("%s * (1000000000 / 0.000001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), PETABYTE.toBytes(test), delta);
            // ====================
            // ====================KILOBYTE
            // ====================
            // to_factor = 0.001
            to_factor = KILOBYTE.getFactor();
            msg = String.format("%s * (1000000000 / 0.001)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), PETABYTE.toKilobytes(test), delta);
            // ====================
            // ====================MEGABYTE
            // ====================
            // to_factor = 1.0
            to_factor = MEGABYTE.getFactor();
            msg = String.format("%s * (1000000000 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), PETABYTE.toMegabytes(test), delta);
            // ====================
            // ====================GIGABYTE
            // ====================
            // to_factor = 1000.0
            to_factor = GIGABYTE.getFactor();
            msg = String.format("%s * (1000000000 / 1000)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), PETABYTE.toGigabytes(test), delta);
            // ====================
            // ====================TERABYTE
            // ====================
            // to_factor = 1000000.0
            to_factor = TERABYTE.getFactor();
            msg = String.format("%s * (1000000000 / 1000000)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), PETABYTE.toTerabytes(test), delta);
            // ====================
            // ====================PETABYTE
            // ====================
            // to_factor = 1.0E9
            to_factor = PETABYTE.getFactor();
            msg = String.format("%s * (1000000000 / 1000000000)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), PETABYTE.toPetabytes(test), delta);
        }
    }
}
