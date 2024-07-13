package codes.abdullah.measurement.system.imperial;

import static codes.abdullah.measurement.system.imperial.Imperials.FLUID_OUNCE;
import static codes.abdullah.measurement.system.imperial.Imperials.GALLON;
import static codes.abdullah.measurement.system.imperial.Imperials.GILL;
import static codes.abdullah.measurement.system.imperial.Imperials.PINT;
import static codes.abdullah.measurement.system.imperial.Imperials.QUART;
import static codes.abdullah.measurement.system.imperial.Imperials.TABLE_SPOON;
import static codes.abdullah.measurement.system.imperial.Imperials.TEA_SPOON;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static codes.abdullah.measurement.utils.TestUtils.loops;
import static codes.abdullah.measurement.utils.TestUtils.nextDouble;
import static codes.abdullah.measurement.utils.TestUtils.noE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRandomImperialVolume {

    @Test()
    public void testTeaSpoon() {
        // from_factor = 0.16666666666666666
        double from_factor = TEA_SPOON.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================TEA_SPOON
            // ====================
            // to_factor = 0.16666666666666666
            to_factor = TEA_SPOON.getFactor();
            msg = String.format("%s * (0.16666666666666666 / 0.16666666666666666)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TEA_SPOON.toTeaSpoons(test), delta);
            // ====================
            // ====================TABLE_SPOON
            // ====================
            // to_factor = 0.5
            to_factor = TABLE_SPOON.getFactor();
            msg = String.format("%s / (0.5 / 0.16666666666666666)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), TEA_SPOON.toTableSpoons(test), delta);
            // ====================
            // ====================FLUID_OUNCE
            // ====================
            // to_factor = 1.0
            to_factor = FLUID_OUNCE.getFactor();
            msg = String.format("%s / (1 / 0.16666666666666666)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), TEA_SPOON.toFluidOunces(test), delta);
            // ====================
            // ====================GILL
            // ====================
            // to_factor = 5.0
            to_factor = GILL.getFactor();
            msg = String.format("%s / (5 / 0.16666666666666666)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), TEA_SPOON.toGills(test), delta);
            // ====================
            // ====================PINT
            // ====================
            // to_factor = 20.0
            to_factor = PINT.getFactor();
            msg = String.format("%s / (20 / 0.16666666666666666)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), TEA_SPOON.toPints(test), delta);
            // ====================
            // ====================QUART
            // ====================
            // to_factor = 40.0
            to_factor = QUART.getFactor();
            msg = String.format("%s / (40 / 0.16666666666666666)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), TEA_SPOON.toQuarts(test), delta);
            // ====================
            // ====================GALLON
            // ====================
            // to_factor = 160.0
            to_factor = GALLON.getFactor();
            msg = String.format("%s / (160 / 0.16666666666666666)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), TEA_SPOON.toGallons(test), delta);
        }
    }

    @Test()
    public void testTableSpoon() {
        // from_factor = 0.5
        double from_factor = TABLE_SPOON.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================TEA_SPOON
            // ====================
            // to_factor = 0.16666666666666666
            to_factor = TEA_SPOON.getFactor();
            msg = String.format("%s * (0.5 / 0.16666666666666666)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TABLE_SPOON.toTeaSpoons(test), delta);
            // ====================
            // ====================TABLE_SPOON
            // ====================
            // to_factor = 0.5
            to_factor = TABLE_SPOON.getFactor();
            msg = String.format("%s * (0.5 / 0.5)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), TABLE_SPOON.toTableSpoons(test), delta);
            // ====================
            // ====================FLUID_OUNCE
            // ====================
            // to_factor = 1.0
            to_factor = FLUID_OUNCE.getFactor();
            msg = String.format("%s / (1 / 0.5)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), TABLE_SPOON.toFluidOunces(test), delta);
            // ====================
            // ====================GILL
            // ====================
            // to_factor = 5.0
            to_factor = GILL.getFactor();
            msg = String.format("%s / (5 / 0.5)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), TABLE_SPOON.toGills(test), delta);
            // ====================
            // ====================PINT
            // ====================
            // to_factor = 20.0
            to_factor = PINT.getFactor();
            msg = String.format("%s / (20 / 0.5)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), TABLE_SPOON.toPints(test), delta);
            // ====================
            // ====================QUART
            // ====================
            // to_factor = 40.0
            to_factor = QUART.getFactor();
            msg = String.format("%s / (40 / 0.5)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), TABLE_SPOON.toQuarts(test), delta);
            // ====================
            // ====================GALLON
            // ====================
            // to_factor = 160.0
            to_factor = GALLON.getFactor();
            msg = String.format("%s / (160 / 0.5)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), TABLE_SPOON.toGallons(test), delta);
        }
    }

    @Test()
    public void testFluidOunce() {
        // from_factor = 1.0
        double from_factor = FLUID_OUNCE.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================TEA_SPOON
            // ====================
            // to_factor = 0.16666666666666666
            to_factor = TEA_SPOON.getFactor();
            msg = String.format("%s * (1 / 0.16666666666666666)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), FLUID_OUNCE.toTeaSpoons(test), delta);
            // ====================
            // ====================TABLE_SPOON
            // ====================
            // to_factor = 0.5
            to_factor = TABLE_SPOON.getFactor();
            msg = String.format("%s * (1 / 0.5)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), FLUID_OUNCE.toTableSpoons(test), delta);
            // ====================
            // ====================FLUID_OUNCE
            // ====================
            // to_factor = 1.0
            to_factor = FLUID_OUNCE.getFactor();
            msg = String.format("%s * (1 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), FLUID_OUNCE.toFluidOunces(test), delta);
            // ====================
            // ====================GILL
            // ====================
            // to_factor = 5.0
            to_factor = GILL.getFactor();
            msg = String.format("%s / (5 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), FLUID_OUNCE.toGills(test), delta);
            // ====================
            // ====================PINT
            // ====================
            // to_factor = 20.0
            to_factor = PINT.getFactor();
            msg = String.format("%s / (20 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), FLUID_OUNCE.toPints(test), delta);
            // ====================
            // ====================QUART
            // ====================
            // to_factor = 40.0
            to_factor = QUART.getFactor();
            msg = String.format("%s / (40 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), FLUID_OUNCE.toQuarts(test), delta);
            // ====================
            // ====================GALLON
            // ====================
            // to_factor = 160.0
            to_factor = GALLON.getFactor();
            msg = String.format("%s / (160 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), FLUID_OUNCE.toGallons(test), delta);
        }
    }

    @Test()
    public void testGill() {
        // from_factor = 5.0
        double from_factor = GILL.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================TEA_SPOON
            // ====================
            // to_factor = 0.16666666666666666
            to_factor = TEA_SPOON.getFactor();
            msg = String.format("%s * (5 / 0.16666666666666666)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GILL.toTeaSpoons(test), delta);
            // ====================
            // ====================TABLE_SPOON
            // ====================
            // to_factor = 0.5
            to_factor = TABLE_SPOON.getFactor();
            msg = String.format("%s * (5 / 0.5)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GILL.toTableSpoons(test), delta);
            // ====================
            // ====================FLUID_OUNCE
            // ====================
            // to_factor = 1.0
            to_factor = FLUID_OUNCE.getFactor();
            msg = String.format("%s * (5 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GILL.toFluidOunces(test), delta);
            // ====================
            // ====================GILL
            // ====================
            // to_factor = 5.0
            to_factor = GILL.getFactor();
            msg = String.format("%s * (5 / 5)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GILL.toGills(test), delta);
            // ====================
            // ====================PINT
            // ====================
            // to_factor = 20.0
            to_factor = PINT.getFactor();
            msg = String.format("%s / (20 / 5)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GILL.toPints(test), delta);
            // ====================
            // ====================QUART
            // ====================
            // to_factor = 40.0
            to_factor = QUART.getFactor();
            msg = String.format("%s / (40 / 5)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GILL.toQuarts(test), delta);
            // ====================
            // ====================GALLON
            // ====================
            // to_factor = 160.0
            to_factor = GALLON.getFactor();
            msg = String.format("%s / (160 / 5)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), GILL.toGallons(test), delta);
        }
    }

    @Test()
    public void testPint() {
        // from_factor = 20.0
        double from_factor = PINT.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================TEA_SPOON
            // ====================
            // to_factor = 0.16666666666666666
            to_factor = TEA_SPOON.getFactor();
            msg = String.format("%s * (20 / 0.16666666666666666)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), PINT.toTeaSpoons(test), delta);
            // ====================
            // ====================TABLE_SPOON
            // ====================
            // to_factor = 0.5
            to_factor = TABLE_SPOON.getFactor();
            msg = String.format("%s * (20 / 0.5)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), PINT.toTableSpoons(test), delta);
            // ====================
            // ====================FLUID_OUNCE
            // ====================
            // to_factor = 1.0
            to_factor = FLUID_OUNCE.getFactor();
            msg = String.format("%s * (20 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), PINT.toFluidOunces(test), delta);
            // ====================
            // ====================GILL
            // ====================
            // to_factor = 5.0
            to_factor = GILL.getFactor();
            msg = String.format("%s * (20 / 5)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), PINT.toGills(test), delta);
            // ====================
            // ====================PINT
            // ====================
            // to_factor = 20.0
            to_factor = PINT.getFactor();
            msg = String.format("%s * (20 / 20)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), PINT.toPints(test), delta);
            // ====================
            // ====================QUART
            // ====================
            // to_factor = 40.0
            to_factor = QUART.getFactor();
            msg = String.format("%s / (40 / 20)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), PINT.toQuarts(test), delta);
            // ====================
            // ====================GALLON
            // ====================
            // to_factor = 160.0
            to_factor = GALLON.getFactor();
            msg = String.format("%s / (160 / 20)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), PINT.toGallons(test), delta);
        }
    }

    @Test()
    public void testQuart() {
        // from_factor = 40.0
        double from_factor = QUART.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================TEA_SPOON
            // ====================
            // to_factor = 0.16666666666666666
            to_factor = TEA_SPOON.getFactor();
            msg = String.format("%s * (40 / 0.16666666666666666)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), QUART.toTeaSpoons(test), delta);
            // ====================
            // ====================TABLE_SPOON
            // ====================
            // to_factor = 0.5
            to_factor = TABLE_SPOON.getFactor();
            msg = String.format("%s * (40 / 0.5)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), QUART.toTableSpoons(test), delta);
            // ====================
            // ====================FLUID_OUNCE
            // ====================
            // to_factor = 1.0
            to_factor = FLUID_OUNCE.getFactor();
            msg = String.format("%s * (40 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), QUART.toFluidOunces(test), delta);
            // ====================
            // ====================GILL
            // ====================
            // to_factor = 5.0
            to_factor = GILL.getFactor();
            msg = String.format("%s * (40 / 5)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), QUART.toGills(test), delta);
            // ====================
            // ====================PINT
            // ====================
            // to_factor = 20.0
            to_factor = PINT.getFactor();
            msg = String.format("%s * (40 / 20)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), QUART.toPints(test), delta);
            // ====================
            // ====================QUART
            // ====================
            // to_factor = 40.0
            to_factor = QUART.getFactor();
            msg = String.format("%s * (40 / 40)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), QUART.toQuarts(test), delta);
            // ====================
            // ====================GALLON
            // ====================
            // to_factor = 160.0
            to_factor = GALLON.getFactor();
            msg = String.format("%s / (160 / 40)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), QUART.toGallons(test), delta);
        }
    }

    @Test()
    public void testGallon() {
        // from_factor = 160.0
        double from_factor = GALLON.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================TEA_SPOON
            // ====================
            // to_factor = 0.16666666666666666
            to_factor = TEA_SPOON.getFactor();
            msg = String.format("%s * (160 / 0.16666666666666666)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GALLON.toTeaSpoons(test), delta);
            // ====================
            // ====================TABLE_SPOON
            // ====================
            // to_factor = 0.5
            to_factor = TABLE_SPOON.getFactor();
            msg = String.format("%s * (160 / 0.5)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GALLON.toTableSpoons(test), delta);
            // ====================
            // ====================FLUID_OUNCE
            // ====================
            // to_factor = 1.0
            to_factor = FLUID_OUNCE.getFactor();
            msg = String.format("%s * (160 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GALLON.toFluidOunces(test), delta);
            // ====================
            // ====================GILL
            // ====================
            // to_factor = 5.0
            to_factor = GILL.getFactor();
            msg = String.format("%s * (160 / 5)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GALLON.toGills(test), delta);
            // ====================
            // ====================PINT
            // ====================
            // to_factor = 20.0
            to_factor = PINT.getFactor();
            msg = String.format("%s * (160 / 20)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GALLON.toPints(test), delta);
            // ====================
            // ====================QUART
            // ====================
            // to_factor = 40.0
            to_factor = QUART.getFactor();
            msg = String.format("%s * (160 / 40)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GALLON.toQuarts(test), delta);
            // ====================
            // ====================GALLON
            // ====================
            // to_factor = 160.0
            to_factor = GALLON.getFactor();
            msg = String.format("%s * (160 / 160)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), GALLON.toGallons(test), delta);
        }
    }
}
