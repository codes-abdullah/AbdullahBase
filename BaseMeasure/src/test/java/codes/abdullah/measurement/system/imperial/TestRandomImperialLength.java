package codes.abdullah.measurement.system.imperial;

import static codes.abdullah.measurement.system.imperial.Imperials.CHAIN;
import static codes.abdullah.measurement.system.imperial.Imperials.FOOT;
import static codes.abdullah.measurement.system.imperial.Imperials.FURLONG;
import static codes.abdullah.measurement.system.imperial.Imperials.INCH;
import static codes.abdullah.measurement.system.imperial.Imperials.MILE;
import static codes.abdullah.measurement.system.imperial.Imperials.THOU;
import static codes.abdullah.measurement.system.imperial.Imperials.YARD;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static codes.abdullah.measurement.utils.TestUtils.loops;
import static codes.abdullah.measurement.utils.TestUtils.nextDouble;
import static codes.abdullah.measurement.utils.TestUtils.noE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRandomImperialLength {

    @Test()
    public void testThou() {
        // from_factor = 8.333333333333333E-5
        double from_factor = THOU.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================THOU
            // ====================
            // to_factor = 8.333333333333333E-5
            to_factor = THOU.getFactor();
            msg = String.format("%s * (0.00008333333333333333 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), THOU.toThous(test), delta);
            // ====================
            // ====================INCH
            // ====================
            // to_factor = 0.08333333333333333
            to_factor = INCH.getFactor();
            msg = String.format("%s / (0.08333333333333333 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), THOU.toInches(test), delta);
            // ====================
            // ====================FOOT
            // ====================
            // to_factor = 1.0
            to_factor = FOOT.getFactor();
            msg = String.format("%s / (1 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), THOU.toFeet(test), delta);
            // ====================
            // ====================YARD
            // ====================
            // to_factor = 3.0
            to_factor = YARD.getFactor();
            msg = String.format("%s / (3 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), THOU.toYards(test), delta);
            // ====================
            // ====================CHAIN
            // ====================
            // to_factor = 66.0
            to_factor = CHAIN.getFactor();
            msg = String.format("%s / (66 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), THOU.toChains(test), delta);
            // ====================
            // ====================FURLONG
            // ====================
            // to_factor = 660.0
            to_factor = FURLONG.getFactor();
            msg = String.format("%s / (660 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), THOU.toFurlongs(test), delta);
            // ====================
            // ====================MILE
            // ====================
            // to_factor = 5280.0
            to_factor = MILE.getFactor();
            msg = String.format("%s / (5280 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), THOU.toMiles(test), delta);
        }
    }

    @Test()
    public void testInch() {
        // from_factor = 0.08333333333333333
        double from_factor = INCH.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================THOU
            // ====================
            // to_factor = 8.333333333333333E-5
            to_factor = THOU.getFactor();
            msg = String.format("%s * (0.08333333333333333 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), INCH.toThous(test), delta);
            // ====================
            // ====================INCH
            // ====================
            // to_factor = 0.08333333333333333
            to_factor = INCH.getFactor();
            msg = String.format("%s * (0.08333333333333333 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), INCH.toInches(test), delta);
            // ====================
            // ====================FOOT
            // ====================
            // to_factor = 1.0
            to_factor = FOOT.getFactor();
            msg = String.format("%s / (1 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), INCH.toFeet(test), delta);
            // ====================
            // ====================YARD
            // ====================
            // to_factor = 3.0
            to_factor = YARD.getFactor();
            msg = String.format("%s / (3 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), INCH.toYards(test), delta);
            // ====================
            // ====================CHAIN
            // ====================
            // to_factor = 66.0
            to_factor = CHAIN.getFactor();
            msg = String.format("%s / (66 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), INCH.toChains(test), delta);
            // ====================
            // ====================FURLONG
            // ====================
            // to_factor = 660.0
            to_factor = FURLONG.getFactor();
            msg = String.format("%s / (660 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), INCH.toFurlongs(test), delta);
            // ====================
            // ====================MILE
            // ====================
            // to_factor = 5280.0
            to_factor = MILE.getFactor();
            msg = String.format("%s / (5280 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), INCH.toMiles(test), delta);
        }
    }

    @Test()
    public void testFoot() {
        // from_factor = 1.0
        double from_factor = FOOT.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================THOU
            // ====================
            // to_factor = 8.333333333333333E-5
            to_factor = THOU.getFactor();
            msg = String.format("%s * (1 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), FOOT.toThous(test), delta);
            // ====================
            // ====================INCH
            // ====================
            // to_factor = 0.08333333333333333
            to_factor = INCH.getFactor();
            msg = String.format("%s * (1 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), FOOT.toInches(test), delta);
            // ====================
            // ====================FOOT
            // ====================
            // to_factor = 1.0
            to_factor = FOOT.getFactor();
            msg = String.format("%s * (1 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), FOOT.toFeet(test), delta);
            // ====================
            // ====================YARD
            // ====================
            // to_factor = 3.0
            to_factor = YARD.getFactor();
            msg = String.format("%s / (3 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), FOOT.toYards(test), delta);
            // ====================
            // ====================CHAIN
            // ====================
            // to_factor = 66.0
            to_factor = CHAIN.getFactor();
            msg = String.format("%s / (66 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), FOOT.toChains(test), delta);
            // ====================
            // ====================FURLONG
            // ====================
            // to_factor = 660.0
            to_factor = FURLONG.getFactor();
            msg = String.format("%s / (660 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), FOOT.toFurlongs(test), delta);
            // ====================
            // ====================MILE
            // ====================
            // to_factor = 5280.0
            to_factor = MILE.getFactor();
            msg = String.format("%s / (5280 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), FOOT.toMiles(test), delta);
        }
    }

    @Test()
    public void testYard() {
        // from_factor = 3.0
        double from_factor = YARD.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================THOU
            // ====================
            // to_factor = 8.333333333333333E-5
            to_factor = THOU.getFactor();
            msg = String.format("%s * (3 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), YARD.toThous(test), delta);
            // ====================
            // ====================INCH
            // ====================
            // to_factor = 0.08333333333333333
            to_factor = INCH.getFactor();
            msg = String.format("%s * (3 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), YARD.toInches(test), delta);
            // ====================
            // ====================FOOT
            // ====================
            // to_factor = 1.0
            to_factor = FOOT.getFactor();
            msg = String.format("%s * (3 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), YARD.toFeet(test), delta);
            // ====================
            // ====================YARD
            // ====================
            // to_factor = 3.0
            to_factor = YARD.getFactor();
            msg = String.format("%s * (3 / 3)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), YARD.toYards(test), delta);
            // ====================
            // ====================CHAIN
            // ====================
            // to_factor = 66.0
            to_factor = CHAIN.getFactor();
            msg = String.format("%s / (66 / 3)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), YARD.toChains(test), delta);
            // ====================
            // ====================FURLONG
            // ====================
            // to_factor = 660.0
            to_factor = FURLONG.getFactor();
            msg = String.format("%s / (660 / 3)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), YARD.toFurlongs(test), delta);
            // ====================
            // ====================MILE
            // ====================
            // to_factor = 5280.0
            to_factor = MILE.getFactor();
            msg = String.format("%s / (5280 / 3)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), YARD.toMiles(test), delta);
        }
    }

    @Test()
    public void testChain() {
        // from_factor = 66.0
        double from_factor = CHAIN.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================THOU
            // ====================
            // to_factor = 8.333333333333333E-5
            to_factor = THOU.getFactor();
            msg = String.format("%s * (66 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CHAIN.toThous(test), delta);
            // ====================
            // ====================INCH
            // ====================
            // to_factor = 0.08333333333333333
            to_factor = INCH.getFactor();
            msg = String.format("%s * (66 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CHAIN.toInches(test), delta);
            // ====================
            // ====================FOOT
            // ====================
            // to_factor = 1.0
            to_factor = FOOT.getFactor();
            msg = String.format("%s * (66 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CHAIN.toFeet(test), delta);
            // ====================
            // ====================YARD
            // ====================
            // to_factor = 3.0
            to_factor = YARD.getFactor();
            msg = String.format("%s * (66 / 3)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CHAIN.toYards(test), delta);
            // ====================
            // ====================CHAIN
            // ====================
            // to_factor = 66.0
            to_factor = CHAIN.getFactor();
            msg = String.format("%s * (66 / 66)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), CHAIN.toChains(test), delta);
            // ====================
            // ====================FURLONG
            // ====================
            // to_factor = 660.0
            to_factor = FURLONG.getFactor();
            msg = String.format("%s / (660 / 66)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), CHAIN.toFurlongs(test), delta);
            // ====================
            // ====================MILE
            // ====================
            // to_factor = 5280.0
            to_factor = MILE.getFactor();
            msg = String.format("%s / (5280 / 66)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), CHAIN.toMiles(test), delta);
        }
    }

    @Test()
    public void testFurlong() {
        // from_factor = 660.0
        double from_factor = FURLONG.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================THOU
            // ====================
            // to_factor = 8.333333333333333E-5
            to_factor = THOU.getFactor();
            msg = String.format("%s * (660 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), FURLONG.toThous(test), delta);
            // ====================
            // ====================INCH
            // ====================
            // to_factor = 0.08333333333333333
            to_factor = INCH.getFactor();
            msg = String.format("%s * (660 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), FURLONG.toInches(test), delta);
            // ====================
            // ====================FOOT
            // ====================
            // to_factor = 1.0
            to_factor = FOOT.getFactor();
            msg = String.format("%s * (660 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), FURLONG.toFeet(test), delta);
            // ====================
            // ====================YARD
            // ====================
            // to_factor = 3.0
            to_factor = YARD.getFactor();
            msg = String.format("%s * (660 / 3)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), FURLONG.toYards(test), delta);
            // ====================
            // ====================CHAIN
            // ====================
            // to_factor = 66.0
            to_factor = CHAIN.getFactor();
            msg = String.format("%s * (660 / 66)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), FURLONG.toChains(test), delta);
            // ====================
            // ====================FURLONG
            // ====================
            // to_factor = 660.0
            to_factor = FURLONG.getFactor();
            msg = String.format("%s * (660 / 660)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), FURLONG.toFurlongs(test), delta);
            // ====================
            // ====================MILE
            // ====================
            // to_factor = 5280.0
            to_factor = MILE.getFactor();
            msg = String.format("%s / (5280 / 660)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), FURLONG.toMiles(test), delta);
        }
    }

    @Test()
    public void testMile() {
        // from_factor = 5280.0
        double from_factor = MILE.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================THOU
            // ====================
            // to_factor = 8.333333333333333E-5
            to_factor = THOU.getFactor();
            msg = String.format("%s * (5280 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MILE.toThous(test), delta);
            // ====================
            // ====================INCH
            // ====================
            // to_factor = 0.08333333333333333
            to_factor = INCH.getFactor();
            msg = String.format("%s * (5280 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MILE.toInches(test), delta);
            // ====================
            // ====================FOOT
            // ====================
            // to_factor = 1.0
            to_factor = FOOT.getFactor();
            msg = String.format("%s * (5280 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MILE.toFeet(test), delta);
            // ====================
            // ====================YARD
            // ====================
            // to_factor = 3.0
            to_factor = YARD.getFactor();
            msg = String.format("%s * (5280 / 3)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MILE.toYards(test), delta);
            // ====================
            // ====================CHAIN
            // ====================
            // to_factor = 66.0
            to_factor = CHAIN.getFactor();
            msg = String.format("%s * (5280 / 66)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MILE.toChains(test), delta);
            // ====================
            // ====================FURLONG
            // ====================
            // to_factor = 660.0
            to_factor = FURLONG.getFactor();
            msg = String.format("%s * (5280 / 660)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MILE.toFurlongs(test), delta);
            // ====================
            // ====================MILE
            // ====================
            // to_factor = 5280.0
            to_factor = MILE.getFactor();
            msg = String.format("%s * (5280 / 5280)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), MILE.toMiles(test), delta);
        }
    }
}
