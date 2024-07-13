package codes.abdullah.measurement.system.imperial;

import static codes.abdullah.measurement.system.imperial.Imperials.DRACHM;
import static codes.abdullah.measurement.system.imperial.Imperials.GRAIN;
import static codes.abdullah.measurement.system.imperial.Imperials.HUNDREDWEIGHT;
import static codes.abdullah.measurement.system.imperial.Imperials.OUNCE;
import static codes.abdullah.measurement.system.imperial.Imperials.POUND;
import static codes.abdullah.measurement.system.imperial.Imperials.QUARTER;
import static codes.abdullah.measurement.system.imperial.Imperials.STONE;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static codes.abdullah.measurement.utils.TestUtils.loops;
import static codes.abdullah.measurement.utils.TestUtils.nextDouble;
import static codes.abdullah.measurement.utils.TestUtils.noE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRandomImperialMass {

    @Test()
    public void testGrain() {
        // from_factor = 0.0023148148148148147
        double from_factor = GRAIN.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================GRAIN
            // ====================
            // to_factor = 0.0023148148148148147
            to_factor = GRAIN.getFactor();
            msg = String.format("%s * (0.0023148148148148147 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GRAIN.toGrains(test), delta);
            // ====================
            // ====================DRACHM
            // ====================
            // to_factor = 0.0023148148148148147
            to_factor = DRACHM.getFactor();
            msg = String.format("%s / (0.0023148148148148147 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GRAIN.toDrachms(test), delta);
            // ====================
            // ====================OUNCE
            // ====================
            // to_factor = 0.0625
            to_factor = OUNCE.getFactor();
            msg = String.format("%s / (0.0625 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GRAIN.toOunces(test), delta);
            // ====================
            // ====================POUND
            // ====================
            // to_factor = 1.0
            to_factor = POUND.getFactor();
            msg = String.format("%s / (1 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GRAIN.toPounds(test), delta);
            // ====================
            // ====================STONE
            // ====================
            // to_factor = 16.0
            to_factor = STONE.getFactor();
            msg = String.format("%s / (16 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GRAIN.toStones(test), delta);
            // ====================
            // ====================QUARTER
            // ====================
            // to_factor = 224.0
            to_factor = QUARTER.getFactor();
            msg = String.format("%s / (224 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GRAIN.toQuarters(test), delta);
            // ====================
            // ====================HUNDREDWEIGHT
            // ====================
            // to_factor = 448.0
            to_factor = HUNDREDWEIGHT.getFactor();
            msg = String.format("%s / (448 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GRAIN.toHundredweights(test), delta);
        }
    }

    @Test()
    public void testDrachm() {
        // from_factor = 0.0023148148148148147
        double from_factor = DRACHM.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================GRAIN
            // ====================
            // to_factor = 0.0023148148148148147
            to_factor = GRAIN.getFactor();
            msg = String.format("%s * (0.0023148148148148147 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DRACHM.toGrains(test), delta);
            // ====================
            // ====================DRACHM
            // ====================
            // to_factor = 0.0023148148148148147
            to_factor = DRACHM.getFactor();
            msg = String.format("%s * (0.0023148148148148147 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), DRACHM.toDrachms(test), delta);
            // ====================
            // ====================OUNCE
            // ====================
            // to_factor = 0.0625
            to_factor = OUNCE.getFactor();
            msg = String.format("%s / (0.0625 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DRACHM.toOunces(test), delta);
            // ====================
            // ====================POUND
            // ====================
            // to_factor = 1.0
            to_factor = POUND.getFactor();
            msg = String.format("%s / (1 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DRACHM.toPounds(test), delta);
            // ====================
            // ====================STONE
            // ====================
            // to_factor = 16.0
            to_factor = STONE.getFactor();
            msg = String.format("%s / (16 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DRACHM.toStones(test), delta);
            // ====================
            // ====================QUARTER
            // ====================
            // to_factor = 224.0
            to_factor = QUARTER.getFactor();
            msg = String.format("%s / (224 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DRACHM.toQuarters(test), delta);
            // ====================
            // ====================HUNDREDWEIGHT
            // ====================
            // to_factor = 448.0
            to_factor = HUNDREDWEIGHT.getFactor();
            msg = String.format("%s / (448 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), DRACHM.toHundredweights(test), delta);
        }
    }

    @Test()
    public void testOunce() {
        // from_factor = 0.0625
        double from_factor = OUNCE.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================GRAIN
            // ====================
            // to_factor = 0.0023148148148148147
            to_factor = GRAIN.getFactor();
            msg = String.format("%s * (0.0625 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), OUNCE.toGrains(test), delta);
            // ====================
            // ====================DRACHM
            // ====================
            // to_factor = 0.0023148148148148147
            to_factor = DRACHM.getFactor();
            msg = String.format("%s * (0.0625 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), OUNCE.toDrachms(test), delta);
            // ====================
            // ====================OUNCE
            // ====================
            // to_factor = 0.0625
            to_factor = OUNCE.getFactor();
            msg = String.format("%s * (0.0625 / 0.0625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), OUNCE.toOunces(test), delta);
            // ====================
            // ====================POUND
            // ====================
            // to_factor = 1.0
            to_factor = POUND.getFactor();
            msg = String.format("%s / (1 / 0.0625)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), OUNCE.toPounds(test), delta);
            // ====================
            // ====================STONE
            // ====================
            // to_factor = 16.0
            to_factor = STONE.getFactor();
            msg = String.format("%s / (16 / 0.0625)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), OUNCE.toStones(test), delta);
            // ====================
            // ====================QUARTER
            // ====================
            // to_factor = 224.0
            to_factor = QUARTER.getFactor();
            msg = String.format("%s / (224 / 0.0625)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), OUNCE.toQuarters(test), delta);
            // ====================
            // ====================HUNDREDWEIGHT
            // ====================
            // to_factor = 448.0
            to_factor = HUNDREDWEIGHT.getFactor();
            msg = String.format("%s / (448 / 0.0625)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), OUNCE.toHundredweights(test), delta);
        }
    }

    @Test()
    public void testPound() {
        // from_factor = 1.0
        double from_factor = POUND.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================GRAIN
            // ====================
            // to_factor = 0.0023148148148148147
            to_factor = GRAIN.getFactor();
            msg = String.format("%s * (1 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), POUND.toGrains(test), delta);
            // ====================
            // ====================DRACHM
            // ====================
            // to_factor = 0.0023148148148148147
            to_factor = DRACHM.getFactor();
            msg = String.format("%s * (1 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), POUND.toDrachms(test), delta);
            // ====================
            // ====================OUNCE
            // ====================
            // to_factor = 0.0625
            to_factor = OUNCE.getFactor();
            msg = String.format("%s * (1 / 0.0625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), POUND.toOunces(test), delta);
            // ====================
            // ====================POUND
            // ====================
            // to_factor = 1.0
            to_factor = POUND.getFactor();
            msg = String.format("%s * (1 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), POUND.toPounds(test), delta);
            // ====================
            // ====================STONE
            // ====================
            // to_factor = 16.0
            to_factor = STONE.getFactor();
            msg = String.format("%s / (16 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), POUND.toStones(test), delta);
            // ====================
            // ====================QUARTER
            // ====================
            // to_factor = 224.0
            to_factor = QUARTER.getFactor();
            msg = String.format("%s / (224 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), POUND.toQuarters(test), delta);
            // ====================
            // ====================HUNDREDWEIGHT
            // ====================
            // to_factor = 448.0
            to_factor = HUNDREDWEIGHT.getFactor();
            msg = String.format("%s / (448 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), POUND.toHundredweights(test), delta);
        }
    }

    @Test()
    public void testStone() {
        // from_factor = 16.0
        double from_factor = STONE.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================GRAIN
            // ====================
            // to_factor = 0.0023148148148148147
            to_factor = GRAIN.getFactor();
            msg = String.format("%s * (16 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), STONE.toGrains(test), delta);
            // ====================
            // ====================DRACHM
            // ====================
            // to_factor = 0.0023148148148148147
            to_factor = DRACHM.getFactor();
            msg = String.format("%s * (16 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), STONE.toDrachms(test), delta);
            // ====================
            // ====================OUNCE
            // ====================
            // to_factor = 0.0625
            to_factor = OUNCE.getFactor();
            msg = String.format("%s * (16 / 0.0625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), STONE.toOunces(test), delta);
            // ====================
            // ====================POUND
            // ====================
            // to_factor = 1.0
            to_factor = POUND.getFactor();
            msg = String.format("%s * (16 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), STONE.toPounds(test), delta);
            // ====================
            // ====================STONE
            // ====================
            // to_factor = 16.0
            to_factor = STONE.getFactor();
            msg = String.format("%s * (16 / 16)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), STONE.toStones(test), delta);
            // ====================
            // ====================QUARTER
            // ====================
            // to_factor = 224.0
            to_factor = QUARTER.getFactor();
            msg = String.format("%s / (224 / 16)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), STONE.toQuarters(test), delta);
            // ====================
            // ====================HUNDREDWEIGHT
            // ====================
            // to_factor = 448.0
            to_factor = HUNDREDWEIGHT.getFactor();
            msg = String.format("%s / (448 / 16)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), STONE.toHundredweights(test), delta);
        }
    }

    @Test()
    public void testQuarter() {
        // from_factor = 224.0
        double from_factor = QUARTER.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================GRAIN
            // ====================
            // to_factor = 0.0023148148148148147
            to_factor = GRAIN.getFactor();
            msg = String.format("%s * (224 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), QUARTER.toGrains(test), delta);
            // ====================
            // ====================DRACHM
            // ====================
            // to_factor = 0.0023148148148148147
            to_factor = DRACHM.getFactor();
            msg = String.format("%s * (224 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), QUARTER.toDrachms(test), delta);
            // ====================
            // ====================OUNCE
            // ====================
            // to_factor = 0.0625
            to_factor = OUNCE.getFactor();
            msg = String.format("%s * (224 / 0.0625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), QUARTER.toOunces(test), delta);
            // ====================
            // ====================POUND
            // ====================
            // to_factor = 1.0
            to_factor = POUND.getFactor();
            msg = String.format("%s * (224 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), QUARTER.toPounds(test), delta);
            // ====================
            // ====================STONE
            // ====================
            // to_factor = 16.0
            to_factor = STONE.getFactor();
            msg = String.format("%s * (224 / 16)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), QUARTER.toStones(test), delta);
            // ====================
            // ====================QUARTER
            // ====================
            // to_factor = 224.0
            to_factor = QUARTER.getFactor();
            msg = String.format("%s * (224 / 224)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), QUARTER.toQuarters(test), delta);
            // ====================
            // ====================HUNDREDWEIGHT
            // ====================
            // to_factor = 448.0
            to_factor = HUNDREDWEIGHT.getFactor();
            msg = String.format("%s / (448 / 224)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), QUARTER.toHundredweights(test), delta);
        }
    }

    @Test()
    public void testHundredweight() {
        // from_factor = 448.0
        double from_factor = HUNDREDWEIGHT.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================GRAIN
            // ====================
            // to_factor = 0.0023148148148148147
            to_factor = GRAIN.getFactor();
            msg = String.format("%s * (448 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HUNDREDWEIGHT.toGrains(test), delta);
            // ====================
            // ====================DRACHM
            // ====================
            // to_factor = 0.0023148148148148147
            to_factor = DRACHM.getFactor();
            msg = String.format("%s * (448 / 0.0023148148148148147)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HUNDREDWEIGHT.toDrachms(test), delta);
            // ====================
            // ====================OUNCE
            // ====================
            // to_factor = 0.0625
            to_factor = OUNCE.getFactor();
            msg = String.format("%s * (448 / 0.0625)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HUNDREDWEIGHT.toOunces(test), delta);
            // ====================
            // ====================POUND
            // ====================
            // to_factor = 1.0
            to_factor = POUND.getFactor();
            msg = String.format("%s * (448 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HUNDREDWEIGHT.toPounds(test), delta);
            // ====================
            // ====================STONE
            // ====================
            // to_factor = 16.0
            to_factor = STONE.getFactor();
            msg = String.format("%s * (448 / 16)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HUNDREDWEIGHT.toStones(test), delta);
            // ====================
            // ====================QUARTER
            // ====================
            // to_factor = 224.0
            to_factor = QUARTER.getFactor();
            msg = String.format("%s * (448 / 224)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HUNDREDWEIGHT.toQuarters(test), delta);
            // ====================
            // ====================HUNDREDWEIGHT
            // ====================
            // to_factor = 448.0
            to_factor = HUNDREDWEIGHT.getFactor();
            msg = String.format("%s * (448 / 448)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), HUNDREDWEIGHT.toHundredweights(test), delta);
        }
    }
}
