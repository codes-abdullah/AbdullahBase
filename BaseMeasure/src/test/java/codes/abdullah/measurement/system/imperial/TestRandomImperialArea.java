package codes.abdullah.measurement.system.imperial;

import static codes.abdullah.measurement.system.imperial.Imperials.SQUARE_CHAIN;
import static codes.abdullah.measurement.system.imperial.Imperials.SQUARE_FOOT;
import static codes.abdullah.measurement.system.imperial.Imperials.SQUARE_FURLONG;
import static codes.abdullah.measurement.system.imperial.Imperials.SQUARE_INCH;
import static codes.abdullah.measurement.system.imperial.Imperials.SQUARE_MILE;
import static codes.abdullah.measurement.system.imperial.Imperials.SQUARE_THOU;
import static codes.abdullah.measurement.system.imperial.Imperials.SQUARE_YARD;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static codes.abdullah.measurement.utils.TestUtils.loops;
import static codes.abdullah.measurement.utils.TestUtils.nextDouble;
import static codes.abdullah.measurement.utils.TestUtils.noE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRandomImperialArea {

    @Test()
    public void testSquareThou() {
        // from_factor = 8.333333333333333E-5
        double from_factor = SQUARE_THOU.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SQUARE_THOU
            // ====================
            // to_factor = 8.333333333333333E-5
            to_factor = SQUARE_THOU.getFactor();
            msg = String.format("%s * (0.00008333333333333333 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_THOU.toSquareThous(test), delta);
            // ====================
            // ====================SQUARE_INCH
            // ====================
            // to_factor = 0.08333333333333333
            to_factor = SQUARE_INCH.getFactor();
            msg = String.format("%s / (0.08333333333333333 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_THOU.toSquareInches(test), delta);
            // ====================
            // ====================SQUARE_FOOT
            // ====================
            // to_factor = 1.0
            to_factor = SQUARE_FOOT.getFactor();
            msg = String.format("%s / (1 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_THOU.toSquareFeet(test), delta);
            // ====================
            // ====================SQUARE_YARD
            // ====================
            // to_factor = 3.0
            to_factor = SQUARE_YARD.getFactor();
            msg = String.format("%s / (3 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_THOU.toSquareYards(test), delta);
            // ====================
            // ====================SQUARE_CHAIN
            // ====================
            // to_factor = 66.0
            to_factor = SQUARE_CHAIN.getFactor();
            msg = String.format("%s / (66 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_THOU.toSquareChains(test), delta);
            // ====================
            // ====================SQUARE_FURLONG
            // ====================
            // to_factor = 660.0
            to_factor = SQUARE_FURLONG.getFactor();
            msg = String.format("%s / (660 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_THOU.toSquareFurlongs(test), delta);
            // ====================
            // ====================SQUARE_MILE
            // ====================
            // to_factor = 5280.0
            to_factor = SQUARE_MILE.getFactor();
            msg = String.format("%s / (5280 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_THOU.toSquareMiles(test), delta);
        }
    }

    @Test()
    public void testSquareInch() {
        // from_factor = 0.08333333333333333
        double from_factor = SQUARE_INCH.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SQUARE_THOU
            // ====================
            // to_factor = 8.333333333333333E-5
            to_factor = SQUARE_THOU.getFactor();
            msg = String.format("%s * (0.08333333333333333 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_INCH.toSquareThous(test), delta);
            // ====================
            // ====================SQUARE_INCH
            // ====================
            // to_factor = 0.08333333333333333
            to_factor = SQUARE_INCH.getFactor();
            msg = String.format("%s * (0.08333333333333333 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_INCH.toSquareInches(test), delta);
            // ====================
            // ====================SQUARE_FOOT
            // ====================
            // to_factor = 1.0
            to_factor = SQUARE_FOOT.getFactor();
            msg = String.format("%s / (1 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_INCH.toSquareFeet(test), delta);
            // ====================
            // ====================SQUARE_YARD
            // ====================
            // to_factor = 3.0
            to_factor = SQUARE_YARD.getFactor();
            msg = String.format("%s / (3 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_INCH.toSquareYards(test), delta);
            // ====================
            // ====================SQUARE_CHAIN
            // ====================
            // to_factor = 66.0
            to_factor = SQUARE_CHAIN.getFactor();
            msg = String.format("%s / (66 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_INCH.toSquareChains(test), delta);
            // ====================
            // ====================SQUARE_FURLONG
            // ====================
            // to_factor = 660.0
            to_factor = SQUARE_FURLONG.getFactor();
            msg = String.format("%s / (660 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_INCH.toSquareFurlongs(test), delta);
            // ====================
            // ====================SQUARE_MILE
            // ====================
            // to_factor = 5280.0
            to_factor = SQUARE_MILE.getFactor();
            msg = String.format("%s / (5280 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_INCH.toSquareMiles(test), delta);
        }
    }

    @Test()
    public void testSquareFoot() {
        // from_factor = 1.0
        double from_factor = SQUARE_FOOT.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SQUARE_THOU
            // ====================
            // to_factor = 8.333333333333333E-5
            to_factor = SQUARE_THOU.getFactor();
            msg = String.format("%s * (1 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_FOOT.toSquareThous(test), delta);
            // ====================
            // ====================SQUARE_INCH
            // ====================
            // to_factor = 0.08333333333333333
            to_factor = SQUARE_INCH.getFactor();
            msg = String.format("%s * (1 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_FOOT.toSquareInches(test), delta);
            // ====================
            // ====================SQUARE_FOOT
            // ====================
            // to_factor = 1.0
            to_factor = SQUARE_FOOT.getFactor();
            msg = String.format("%s * (1 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_FOOT.toSquareFeet(test), delta);
            // ====================
            // ====================SQUARE_YARD
            // ====================
            // to_factor = 3.0
            to_factor = SQUARE_YARD.getFactor();
            msg = String.format("%s / (3 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_FOOT.toSquareYards(test), delta);
            // ====================
            // ====================SQUARE_CHAIN
            // ====================
            // to_factor = 66.0
            to_factor = SQUARE_CHAIN.getFactor();
            msg = String.format("%s / (66 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_FOOT.toSquareChains(test), delta);
            // ====================
            // ====================SQUARE_FURLONG
            // ====================
            // to_factor = 660.0
            to_factor = SQUARE_FURLONG.getFactor();
            msg = String.format("%s / (660 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_FOOT.toSquareFurlongs(test), delta);
            // ====================
            // ====================SQUARE_MILE
            // ====================
            // to_factor = 5280.0
            to_factor = SQUARE_MILE.getFactor();
            msg = String.format("%s / (5280 / 1)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_FOOT.toSquareMiles(test), delta);
        }
    }

    @Test()
    public void testSquareYard() {
        // from_factor = 3.0
        double from_factor = SQUARE_YARD.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SQUARE_THOU
            // ====================
            // to_factor = 8.333333333333333E-5
            to_factor = SQUARE_THOU.getFactor();
            msg = String.format("%s * (3 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_YARD.toSquareThous(test), delta);
            // ====================
            // ====================SQUARE_INCH
            // ====================
            // to_factor = 0.08333333333333333
            to_factor = SQUARE_INCH.getFactor();
            msg = String.format("%s * (3 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_YARD.toSquareInches(test), delta);
            // ====================
            // ====================SQUARE_FOOT
            // ====================
            // to_factor = 1.0
            to_factor = SQUARE_FOOT.getFactor();
            msg = String.format("%s * (3 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_YARD.toSquareFeet(test), delta);
            // ====================
            // ====================SQUARE_YARD
            // ====================
            // to_factor = 3.0
            to_factor = SQUARE_YARD.getFactor();
            msg = String.format("%s * (3 / 3)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_YARD.toSquareYards(test), delta);
            // ====================
            // ====================SQUARE_CHAIN
            // ====================
            // to_factor = 66.0
            to_factor = SQUARE_CHAIN.getFactor();
            msg = String.format("%s / (66 / 3)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_YARD.toSquareChains(test), delta);
            // ====================
            // ====================SQUARE_FURLONG
            // ====================
            // to_factor = 660.0
            to_factor = SQUARE_FURLONG.getFactor();
            msg = String.format("%s / (660 / 3)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_YARD.toSquareFurlongs(test), delta);
            // ====================
            // ====================SQUARE_MILE
            // ====================
            // to_factor = 5280.0
            to_factor = SQUARE_MILE.getFactor();
            msg = String.format("%s / (5280 / 3)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_YARD.toSquareMiles(test), delta);
        }
    }

    @Test()
    public void testSquareChain() {
        // from_factor = 66.0
        double from_factor = SQUARE_CHAIN.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SQUARE_THOU
            // ====================
            // to_factor = 8.333333333333333E-5
            to_factor = SQUARE_THOU.getFactor();
            msg = String.format("%s * (66 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_CHAIN.toSquareThous(test), delta);
            // ====================
            // ====================SQUARE_INCH
            // ====================
            // to_factor = 0.08333333333333333
            to_factor = SQUARE_INCH.getFactor();
            msg = String.format("%s * (66 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_CHAIN.toSquareInches(test), delta);
            // ====================
            // ====================SQUARE_FOOT
            // ====================
            // to_factor = 1.0
            to_factor = SQUARE_FOOT.getFactor();
            msg = String.format("%s * (66 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_CHAIN.toSquareFeet(test), delta);
            // ====================
            // ====================SQUARE_YARD
            // ====================
            // to_factor = 3.0
            to_factor = SQUARE_YARD.getFactor();
            msg = String.format("%s * (66 / 3)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_CHAIN.toSquareYards(test), delta);
            // ====================
            // ====================SQUARE_CHAIN
            // ====================
            // to_factor = 66.0
            to_factor = SQUARE_CHAIN.getFactor();
            msg = String.format("%s * (66 / 66)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_CHAIN.toSquareChains(test), delta);
            // ====================
            // ====================SQUARE_FURLONG
            // ====================
            // to_factor = 660.0
            to_factor = SQUARE_FURLONG.getFactor();
            msg = String.format("%s / (660 / 66)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_CHAIN.toSquareFurlongs(test), delta);
            // ====================
            // ====================SQUARE_MILE
            // ====================
            // to_factor = 5280.0
            to_factor = SQUARE_MILE.getFactor();
            msg = String.format("%s / (5280 / 66)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_CHAIN.toSquareMiles(test), delta);
        }
    }

    @Test()
    public void testSquareFurlong() {
        // from_factor = 660.0
        double from_factor = SQUARE_FURLONG.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SQUARE_THOU
            // ====================
            // to_factor = 8.333333333333333E-5
            to_factor = SQUARE_THOU.getFactor();
            msg = String.format("%s * (660 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_FURLONG.toSquareThous(test), delta);
            // ====================
            // ====================SQUARE_INCH
            // ====================
            // to_factor = 0.08333333333333333
            to_factor = SQUARE_INCH.getFactor();
            msg = String.format("%s * (660 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_FURLONG.toSquareInches(test), delta);
            // ====================
            // ====================SQUARE_FOOT
            // ====================
            // to_factor = 1.0
            to_factor = SQUARE_FOOT.getFactor();
            msg = String.format("%s * (660 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_FURLONG.toSquareFeet(test), delta);
            // ====================
            // ====================SQUARE_YARD
            // ====================
            // to_factor = 3.0
            to_factor = SQUARE_YARD.getFactor();
            msg = String.format("%s * (660 / 3)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_FURLONG.toSquareYards(test), delta);
            // ====================
            // ====================SQUARE_CHAIN
            // ====================
            // to_factor = 66.0
            to_factor = SQUARE_CHAIN.getFactor();
            msg = String.format("%s * (660 / 66)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_FURLONG.toSquareChains(test), delta);
            // ====================
            // ====================SQUARE_FURLONG
            // ====================
            // to_factor = 660.0
            to_factor = SQUARE_FURLONG.getFactor();
            msg = String.format("%s * (660 / 660)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_FURLONG.toSquareFurlongs(test), delta);
            // ====================
            // ====================SQUARE_MILE
            // ====================
            // to_factor = 5280.0
            to_factor = SQUARE_MILE.getFactor();
            msg = String.format("%s / (5280 / 660)", noE(test));
            assertEquals(msg, test / (to_factor / from_factor), SQUARE_FURLONG.toSquareMiles(test), delta);
        }
    }

    @Test()
    public void testSquareMile() {
        // from_factor = 5280.0
        double from_factor = SQUARE_MILE.getFactor();
        double to_factor;
        String msg;
        for (int i = 0; i < loops; i++) {
            double test = nextDouble();
            // ====================
            // ====================SQUARE_THOU
            // ====================
            // to_factor = 8.333333333333333E-5
            to_factor = SQUARE_THOU.getFactor();
            msg = String.format("%s * (5280 / 0.00008333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_MILE.toSquareThous(test), delta);
            // ====================
            // ====================SQUARE_INCH
            // ====================
            // to_factor = 0.08333333333333333
            to_factor = SQUARE_INCH.getFactor();
            msg = String.format("%s * (5280 / 0.08333333333333333)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_MILE.toSquareInches(test), delta);
            // ====================
            // ====================SQUARE_FOOT
            // ====================
            // to_factor = 1.0
            to_factor = SQUARE_FOOT.getFactor();
            msg = String.format("%s * (5280 / 1)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_MILE.toSquareFeet(test), delta);
            // ====================
            // ====================SQUARE_YARD
            // ====================
            // to_factor = 3.0
            to_factor = SQUARE_YARD.getFactor();
            msg = String.format("%s * (5280 / 3)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_MILE.toSquareYards(test), delta);
            // ====================
            // ====================SQUARE_CHAIN
            // ====================
            // to_factor = 66.0
            to_factor = SQUARE_CHAIN.getFactor();
            msg = String.format("%s * (5280 / 66)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_MILE.toSquareChains(test), delta);
            // ====================
            // ====================SQUARE_FURLONG
            // ====================
            // to_factor = 660.0
            to_factor = SQUARE_FURLONG.getFactor();
            msg = String.format("%s * (5280 / 660)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_MILE.toSquareFurlongs(test), delta);
            // ====================
            // ====================SQUARE_MILE
            // ====================
            // to_factor = 5280.0
            to_factor = SQUARE_MILE.getFactor();
            msg = String.format("%s * (5280 / 5280)", noE(test));
            assertEquals(msg, test * (from_factor / to_factor), SQUARE_MILE.toSquareMiles(test), delta);
        }
    }
}
