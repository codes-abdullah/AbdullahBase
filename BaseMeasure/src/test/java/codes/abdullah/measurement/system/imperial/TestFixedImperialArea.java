package codes.abdullah.measurement.system.imperial;

import static codes.abdullah.measurement.system.imperial.Imperials.SQUARE_CHAIN;
import static codes.abdullah.measurement.system.imperial.Imperials.SQUARE_FOOT;
import static codes.abdullah.measurement.system.imperial.Imperials.SQUARE_FURLONG;
import static codes.abdullah.measurement.system.imperial.Imperials.SQUARE_INCH;
import static codes.abdullah.measurement.system.imperial.Imperials.SQUARE_MILE;
import static codes.abdullah.measurement.system.imperial.Imperials.SQUARE_THOU;
import static codes.abdullah.measurement.system.imperial.Imperials.SQUARE_YARD;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFixedImperialArea {

    @Test()
    public void testSquareThou() {
        // from_factor = 8.333333333333333E-5
        double from_factor = SQUARE_THOU.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SQUARE_THOU
        // ====================
        // to_factor = 8.333333333333333E-5
        to_factor = SQUARE_THOU.getFactor();
        msg = "-1 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_THOU.toSquareThous(-1.0), delta);
        msg = "-0.1 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_THOU.toSquareThous(-0.1), delta);
        msg = "-0.000456789 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_THOU.toSquareThous(-4.56789E-4), delta);
        msg = "-73.25 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_THOU.toSquareThous(-73.25), delta);
        msg = "-56229.321 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_THOU.toSquareThous(-56229.321), delta);
        msg = "-873.5432456 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_THOU.toSquareThous(-873.5432456), delta);
        msg = "0 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_THOU.toSquareThous(0.0), delta);
        msg = "0.1 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_THOU.toSquareThous(0.1), delta);
        msg = "0.0000876543297 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_THOU.toSquareThous(8.76543297E-5), delta);
        msg = "0.33 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_THOU.toSquareThous(0.33), delta);
        msg = "0.6543 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_THOU.toSquareThous(0.6543), delta);
        msg = "1 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_THOU.toSquareThous(1.0), delta);
        msg = "1.6543 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_THOU.toSquareThous(1.6543), delta);
        msg = "22.45 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_THOU.toSquareThous(22.45), delta);
        msg = "9876.5432 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_THOU.toSquareThous(9876.5432), delta);
        msg = "1987654344.3345 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_THOU.toSquareThous(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_THOU.toSquareThous(784.46789765434), delta);
        // ====================
        // ====================SQUARE_INCH
        // ====================
        // to_factor = 0.08333333333333333
        to_factor = SQUARE_INCH.getFactor();
        msg = "-1 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_THOU.toSquareInches(-1.0), delta);
        msg = "-0.1 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_THOU.toSquareInches(-0.1), delta);
        msg = "-0.000456789 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_THOU.toSquareInches(-4.56789E-4), delta);
        msg = "-73.25 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_THOU.toSquareInches(-73.25), delta);
        msg = "-56229.321 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_THOU.toSquareInches(-56229.321), delta);
        msg = "-873.5432456 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_THOU.toSquareInches(-873.5432456), delta);
        msg = "0 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_THOU.toSquareInches(0.0), delta);
        msg = "0.1 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_THOU.toSquareInches(0.1), delta);
        msg = "0.0000876543297 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_THOU.toSquareInches(8.76543297E-5), delta);
        msg = "0.33 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_THOU.toSquareInches(0.33), delta);
        msg = "0.6543 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_THOU.toSquareInches(0.6543), delta);
        msg = "1 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_THOU.toSquareInches(1.0), delta);
        msg = "1.6543 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_THOU.toSquareInches(1.6543), delta);
        msg = "22.45 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_THOU.toSquareInches(22.45), delta);
        msg = "9876.5432 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_THOU.toSquareInches(9876.5432), delta);
        msg = "1987654344.3345 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_THOU.toSquareInches(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_THOU.toSquareInches(784.46789765434), delta);
        // ====================
        // ====================SQUARE_FOOT
        // ====================
        // to_factor = 1.0
        to_factor = SQUARE_FOOT.getFactor();
        msg = "-1 / (1 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_THOU.toSquareFeet(-1.0), delta);
        msg = "-0.1 / (1 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_THOU.toSquareFeet(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_THOU.toSquareFeet(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_THOU.toSquareFeet(-73.25), delta);
        msg = "-56229.321 / (1 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_THOU.toSquareFeet(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_THOU.toSquareFeet(-873.5432456), delta);
        msg = "0 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_THOU.toSquareFeet(0.0), delta);
        msg = "0.1 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_THOU.toSquareFeet(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_THOU.toSquareFeet(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_THOU.toSquareFeet(0.33), delta);
        msg = "0.6543 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_THOU.toSquareFeet(0.6543), delta);
        msg = "1 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_THOU.toSquareFeet(1.0), delta);
        msg = "1.6543 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_THOU.toSquareFeet(1.6543), delta);
        msg = "22.45 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_THOU.toSquareFeet(22.45), delta);
        msg = "9876.5432 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_THOU.toSquareFeet(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_THOU.toSquareFeet(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_THOU.toSquareFeet(784.46789765434), delta);
        // ====================
        // ====================SQUARE_YARD
        // ====================
        // to_factor = 3.0
        to_factor = SQUARE_YARD.getFactor();
        msg = "-1 / (3 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_THOU.toSquareYards(-1.0), delta);
        msg = "-0.1 / (3 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_THOU.toSquareYards(-0.1), delta);
        msg = "-0.000456789 / (3 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_THOU.toSquareYards(-4.56789E-4), delta);
        msg = "-73.25 / (3 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_THOU.toSquareYards(-73.25), delta);
        msg = "-56229.321 / (3 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_THOU.toSquareYards(-56229.321), delta);
        msg = "-873.5432456 / (3 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_THOU.toSquareYards(-873.5432456), delta);
        msg = "0 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_THOU.toSquareYards(0.0), delta);
        msg = "0.1 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_THOU.toSquareYards(0.1), delta);
        msg = "0.0000876543297 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_THOU.toSquareYards(8.76543297E-5), delta);
        msg = "0.33 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_THOU.toSquareYards(0.33), delta);
        msg = "0.6543 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_THOU.toSquareYards(0.6543), delta);
        msg = "1 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_THOU.toSquareYards(1.0), delta);
        msg = "1.6543 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_THOU.toSquareYards(1.6543), delta);
        msg = "22.45 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_THOU.toSquareYards(22.45), delta);
        msg = "9876.5432 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_THOU.toSquareYards(9876.5432), delta);
        msg = "1987654344.3345 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_THOU.toSquareYards(1.9876543443345E9), delta);
        msg = "784.46789765434 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_THOU.toSquareYards(784.46789765434), delta);
        // ====================
        // ====================SQUARE_CHAIN
        // ====================
        // to_factor = 66.0
        to_factor = SQUARE_CHAIN.getFactor();
        msg = "-1 / (66 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_THOU.toSquareChains(-1.0), delta);
        msg = "-0.1 / (66 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_THOU.toSquareChains(-0.1), delta);
        msg = "-0.000456789 / (66 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_THOU.toSquareChains(-4.56789E-4), delta);
        msg = "-73.25 / (66 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_THOU.toSquareChains(-73.25), delta);
        msg = "-56229.321 / (66 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_THOU.toSquareChains(-56229.321), delta);
        msg = "-873.5432456 / (66 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_THOU.toSquareChains(-873.5432456), delta);
        msg = "0 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_THOU.toSquareChains(0.0), delta);
        msg = "0.1 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_THOU.toSquareChains(0.1), delta);
        msg = "0.0000876543297 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_THOU.toSquareChains(8.76543297E-5), delta);
        msg = "0.33 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_THOU.toSquareChains(0.33), delta);
        msg = "0.6543 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_THOU.toSquareChains(0.6543), delta);
        msg = "1 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_THOU.toSquareChains(1.0), delta);
        msg = "1.6543 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_THOU.toSquareChains(1.6543), delta);
        msg = "22.45 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_THOU.toSquareChains(22.45), delta);
        msg = "9876.5432 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_THOU.toSquareChains(9876.5432), delta);
        msg = "1987654344.3345 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_THOU.toSquareChains(1.9876543443345E9), delta);
        msg = "784.46789765434 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_THOU.toSquareChains(784.46789765434), delta);
        // ====================
        // ====================SQUARE_FURLONG
        // ====================
        // to_factor = 660.0
        to_factor = SQUARE_FURLONG.getFactor();
        msg = "-1 / (660 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_THOU.toSquareFurlongs(-1.0), delta);
        msg = "-0.1 / (660 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_THOU.toSquareFurlongs(-0.1), delta);
        msg = "-0.000456789 / (660 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_THOU.toSquareFurlongs(-4.56789E-4), delta);
        msg = "-73.25 / (660 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_THOU.toSquareFurlongs(-73.25), delta);
        msg = "-56229.321 / (660 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_THOU.toSquareFurlongs(-56229.321), delta);
        msg = "-873.5432456 / (660 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_THOU.toSquareFurlongs(-873.5432456), delta);
        msg = "0 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_THOU.toSquareFurlongs(0.0), delta);
        msg = "0.1 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_THOU.toSquareFurlongs(0.1), delta);
        msg = "0.0000876543297 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_THOU.toSquareFurlongs(8.76543297E-5), delta);
        msg = "0.33 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_THOU.toSquareFurlongs(0.33), delta);
        msg = "0.6543 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_THOU.toSquareFurlongs(0.6543), delta);
        msg = "1 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_THOU.toSquareFurlongs(1.0), delta);
        msg = "1.6543 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_THOU.toSquareFurlongs(1.6543), delta);
        msg = "22.45 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_THOU.toSquareFurlongs(22.45), delta);
        msg = "9876.5432 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_THOU.toSquareFurlongs(9876.5432), delta);
        msg = "1987654344.3345 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_THOU.toSquareFurlongs(1.9876543443345E9), delta);
        msg = "784.46789765434 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_THOU.toSquareFurlongs(784.46789765434), delta);
        // ====================
        // ====================SQUARE_MILE
        // ====================
        // to_factor = 5280.0
        to_factor = SQUARE_MILE.getFactor();
        msg = "-1 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_THOU.toSquareMiles(-1.0), delta);
        msg = "-0.1 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_THOU.toSquareMiles(-0.1), delta);
        msg = "-0.000456789 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_THOU.toSquareMiles(-4.56789E-4), delta);
        msg = "-73.25 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_THOU.toSquareMiles(-73.25), delta);
        msg = "-56229.321 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_THOU.toSquareMiles(-56229.321), delta);
        msg = "-873.5432456 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_THOU.toSquareMiles(-873.5432456), delta);
        msg = "0 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_THOU.toSquareMiles(0.0), delta);
        msg = "0.1 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_THOU.toSquareMiles(0.1), delta);
        msg = "0.0000876543297 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_THOU.toSquareMiles(8.76543297E-5), delta);
        msg = "0.33 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_THOU.toSquareMiles(0.33), delta);
        msg = "0.6543 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_THOU.toSquareMiles(0.6543), delta);
        msg = "1 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_THOU.toSquareMiles(1.0), delta);
        msg = "1.6543 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_THOU.toSquareMiles(1.6543), delta);
        msg = "22.45 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_THOU.toSquareMiles(22.45), delta);
        msg = "9876.5432 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_THOU.toSquareMiles(9876.5432), delta);
        msg = "1987654344.3345 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_THOU.toSquareMiles(1.9876543443345E9), delta);
        msg = "784.46789765434 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_THOU.toSquareMiles(784.46789765434), delta);
    }

    @Test()
    public void testSquareInch() {
        // from_factor = 0.08333333333333333
        double from_factor = SQUARE_INCH.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SQUARE_THOU
        // ====================
        // to_factor = 8.333333333333333E-5
        to_factor = SQUARE_THOU.getFactor();
        msg = "-1 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_INCH.toSquareThous(-1.0), delta);
        msg = "-0.1 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_INCH.toSquareThous(-0.1), delta);
        msg = "-0.000456789 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_INCH.toSquareThous(-4.56789E-4), delta);
        msg = "-73.25 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_INCH.toSquareThous(-73.25), delta);
        msg = "-56229.321 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_INCH.toSquareThous(-56229.321), delta);
        msg = "-873.5432456 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_INCH.toSquareThous(-873.5432456), delta);
        msg = "0 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_INCH.toSquareThous(0.0), delta);
        msg = "0.1 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_INCH.toSquareThous(0.1), delta);
        msg = "0.0000876543297 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_INCH.toSquareThous(8.76543297E-5), delta);
        msg = "0.33 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_INCH.toSquareThous(0.33), delta);
        msg = "0.6543 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_INCH.toSquareThous(0.6543), delta);
        msg = "1 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_INCH.toSquareThous(1.0), delta);
        msg = "1.6543 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_INCH.toSquareThous(1.6543), delta);
        msg = "22.45 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_INCH.toSquareThous(22.45), delta);
        msg = "9876.5432 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_INCH.toSquareThous(9876.5432), delta);
        msg = "1987654344.3345 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_INCH.toSquareThous(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_INCH.toSquareThous(784.46789765434), delta);
        // ====================
        // ====================SQUARE_INCH
        // ====================
        // to_factor = 0.08333333333333333
        to_factor = SQUARE_INCH.getFactor();
        msg = "-1 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_INCH.toSquareInches(-1.0), delta);
        msg = "-0.1 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_INCH.toSquareInches(-0.1), delta);
        msg = "-0.000456789 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_INCH.toSquareInches(-4.56789E-4), delta);
        msg = "-73.25 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_INCH.toSquareInches(-73.25), delta);
        msg = "-56229.321 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_INCH.toSquareInches(-56229.321), delta);
        msg = "-873.5432456 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_INCH.toSquareInches(-873.5432456), delta);
        msg = "0 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_INCH.toSquareInches(0.0), delta);
        msg = "0.1 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_INCH.toSquareInches(0.1), delta);
        msg = "0.0000876543297 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_INCH.toSquareInches(8.76543297E-5), delta);
        msg = "0.33 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_INCH.toSquareInches(0.33), delta);
        msg = "0.6543 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_INCH.toSquareInches(0.6543), delta);
        msg = "1 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_INCH.toSquareInches(1.0), delta);
        msg = "1.6543 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_INCH.toSquareInches(1.6543), delta);
        msg = "22.45 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_INCH.toSquareInches(22.45), delta);
        msg = "9876.5432 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_INCH.toSquareInches(9876.5432), delta);
        msg = "1987654344.3345 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_INCH.toSquareInches(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_INCH.toSquareInches(784.46789765434), delta);
        // ====================
        // ====================SQUARE_FOOT
        // ====================
        // to_factor = 1.0
        to_factor = SQUARE_FOOT.getFactor();
        msg = "-1 / (1 / 0.08333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_INCH.toSquareFeet(-1.0), delta);
        msg = "-0.1 / (1 / 0.08333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_INCH.toSquareFeet(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_INCH.toSquareFeet(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.08333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_INCH.toSquareFeet(-73.25), delta);
        msg = "-56229.321 / (1 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_INCH.toSquareFeet(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_INCH.toSquareFeet(-873.5432456), delta);
        msg = "0 / (1 / 0.08333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_INCH.toSquareFeet(0.0), delta);
        msg = "0.1 / (1 / 0.08333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_INCH.toSquareFeet(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_INCH.toSquareFeet(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.08333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_INCH.toSquareFeet(0.33), delta);
        msg = "0.6543 / (1 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_INCH.toSquareFeet(0.6543), delta);
        msg = "1 / (1 / 0.08333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_INCH.toSquareFeet(1.0), delta);
        msg = "1.6543 / (1 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_INCH.toSquareFeet(1.6543), delta);
        msg = "22.45 / (1 / 0.08333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_INCH.toSquareFeet(22.45), delta);
        msg = "9876.5432 / (1 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_INCH.toSquareFeet(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_INCH.toSquareFeet(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_INCH.toSquareFeet(784.46789765434), delta);
        // ====================
        // ====================SQUARE_YARD
        // ====================
        // to_factor = 3.0
        to_factor = SQUARE_YARD.getFactor();
        msg = "-1 / (3 / 0.08333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_INCH.toSquareYards(-1.0), delta);
        msg = "-0.1 / (3 / 0.08333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_INCH.toSquareYards(-0.1), delta);
        msg = "-0.000456789 / (3 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_INCH.toSquareYards(-4.56789E-4), delta);
        msg = "-73.25 / (3 / 0.08333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_INCH.toSquareYards(-73.25), delta);
        msg = "-56229.321 / (3 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_INCH.toSquareYards(-56229.321), delta);
        msg = "-873.5432456 / (3 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_INCH.toSquareYards(-873.5432456), delta);
        msg = "0 / (3 / 0.08333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_INCH.toSquareYards(0.0), delta);
        msg = "0.1 / (3 / 0.08333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_INCH.toSquareYards(0.1), delta);
        msg = "0.0000876543297 / (3 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_INCH.toSquareYards(8.76543297E-5), delta);
        msg = "0.33 / (3 / 0.08333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_INCH.toSquareYards(0.33), delta);
        msg = "0.6543 / (3 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_INCH.toSquareYards(0.6543), delta);
        msg = "1 / (3 / 0.08333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_INCH.toSquareYards(1.0), delta);
        msg = "1.6543 / (3 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_INCH.toSquareYards(1.6543), delta);
        msg = "22.45 / (3 / 0.08333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_INCH.toSquareYards(22.45), delta);
        msg = "9876.5432 / (3 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_INCH.toSquareYards(9876.5432), delta);
        msg = "1987654344.3345 / (3 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_INCH.toSquareYards(1.9876543443345E9), delta);
        msg = "784.46789765434 / (3 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_INCH.toSquareYards(784.46789765434), delta);
        // ====================
        // ====================SQUARE_CHAIN
        // ====================
        // to_factor = 66.0
        to_factor = SQUARE_CHAIN.getFactor();
        msg = "-1 / (66 / 0.08333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_INCH.toSquareChains(-1.0), delta);
        msg = "-0.1 / (66 / 0.08333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_INCH.toSquareChains(-0.1), delta);
        msg = "-0.000456789 / (66 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_INCH.toSquareChains(-4.56789E-4), delta);
        msg = "-73.25 / (66 / 0.08333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_INCH.toSquareChains(-73.25), delta);
        msg = "-56229.321 / (66 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_INCH.toSquareChains(-56229.321), delta);
        msg = "-873.5432456 / (66 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_INCH.toSquareChains(-873.5432456), delta);
        msg = "0 / (66 / 0.08333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_INCH.toSquareChains(0.0), delta);
        msg = "0.1 / (66 / 0.08333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_INCH.toSquareChains(0.1), delta);
        msg = "0.0000876543297 / (66 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_INCH.toSquareChains(8.76543297E-5), delta);
        msg = "0.33 / (66 / 0.08333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_INCH.toSquareChains(0.33), delta);
        msg = "0.6543 / (66 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_INCH.toSquareChains(0.6543), delta);
        msg = "1 / (66 / 0.08333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_INCH.toSquareChains(1.0), delta);
        msg = "1.6543 / (66 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_INCH.toSquareChains(1.6543), delta);
        msg = "22.45 / (66 / 0.08333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_INCH.toSquareChains(22.45), delta);
        msg = "9876.5432 / (66 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_INCH.toSquareChains(9876.5432), delta);
        msg = "1987654344.3345 / (66 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_INCH.toSquareChains(1.9876543443345E9), delta);
        msg = "784.46789765434 / (66 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_INCH.toSquareChains(784.46789765434), delta);
        // ====================
        // ====================SQUARE_FURLONG
        // ====================
        // to_factor = 660.0
        to_factor = SQUARE_FURLONG.getFactor();
        msg = "-1 / (660 / 0.08333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_INCH.toSquareFurlongs(-1.0), delta);
        msg = "-0.1 / (660 / 0.08333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_INCH.toSquareFurlongs(-0.1), delta);
        msg = "-0.000456789 / (660 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_INCH.toSquareFurlongs(-4.56789E-4), delta);
        msg = "-73.25 / (660 / 0.08333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_INCH.toSquareFurlongs(-73.25), delta);
        msg = "-56229.321 / (660 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_INCH.toSquareFurlongs(-56229.321), delta);
        msg = "-873.5432456 / (660 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_INCH.toSquareFurlongs(-873.5432456), delta);
        msg = "0 / (660 / 0.08333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_INCH.toSquareFurlongs(0.0), delta);
        msg = "0.1 / (660 / 0.08333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_INCH.toSquareFurlongs(0.1), delta);
        msg = "0.0000876543297 / (660 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_INCH.toSquareFurlongs(8.76543297E-5), delta);
        msg = "0.33 / (660 / 0.08333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_INCH.toSquareFurlongs(0.33), delta);
        msg = "0.6543 / (660 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_INCH.toSquareFurlongs(0.6543), delta);
        msg = "1 / (660 / 0.08333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_INCH.toSquareFurlongs(1.0), delta);
        msg = "1.6543 / (660 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_INCH.toSquareFurlongs(1.6543), delta);
        msg = "22.45 / (660 / 0.08333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_INCH.toSquareFurlongs(22.45), delta);
        msg = "9876.5432 / (660 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_INCH.toSquareFurlongs(9876.5432), delta);
        msg = "1987654344.3345 / (660 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_INCH.toSquareFurlongs(1.9876543443345E9), delta);
        msg = "784.46789765434 / (660 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_INCH.toSquareFurlongs(784.46789765434), delta);
        // ====================
        // ====================SQUARE_MILE
        // ====================
        // to_factor = 5280.0
        to_factor = SQUARE_MILE.getFactor();
        msg = "-1 / (5280 / 0.08333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_INCH.toSquareMiles(-1.0), delta);
        msg = "-0.1 / (5280 / 0.08333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_INCH.toSquareMiles(-0.1), delta);
        msg = "-0.000456789 / (5280 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_INCH.toSquareMiles(-4.56789E-4), delta);
        msg = "-73.25 / (5280 / 0.08333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_INCH.toSquareMiles(-73.25), delta);
        msg = "-56229.321 / (5280 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_INCH.toSquareMiles(-56229.321), delta);
        msg = "-873.5432456 / (5280 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_INCH.toSquareMiles(-873.5432456), delta);
        msg = "0 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_INCH.toSquareMiles(0.0), delta);
        msg = "0.1 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_INCH.toSquareMiles(0.1), delta);
        msg = "0.0000876543297 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_INCH.toSquareMiles(8.76543297E-5), delta);
        msg = "0.33 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_INCH.toSquareMiles(0.33), delta);
        msg = "0.6543 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_INCH.toSquareMiles(0.6543), delta);
        msg = "1 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_INCH.toSquareMiles(1.0), delta);
        msg = "1.6543 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_INCH.toSquareMiles(1.6543), delta);
        msg = "22.45 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_INCH.toSquareMiles(22.45), delta);
        msg = "9876.5432 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_INCH.toSquareMiles(9876.5432), delta);
        msg = "1987654344.3345 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_INCH.toSquareMiles(1.9876543443345E9), delta);
        msg = "784.46789765434 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_INCH.toSquareMiles(784.46789765434), delta);
    }

    @Test()
    public void testSquareFoot() {
        // from_factor = 1.0
        double from_factor = SQUARE_FOOT.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SQUARE_THOU
        // ====================
        // to_factor = 8.333333333333333E-5
        to_factor = SQUARE_THOU.getFactor();
        msg = "-1 * (1 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_FOOT.toSquareThous(-1.0), delta);
        msg = "-0.1 * (1 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_FOOT.toSquareThous(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_FOOT.toSquareThous(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_FOOT.toSquareThous(-73.25), delta);
        msg = "-56229.321 * (1 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_FOOT.toSquareThous(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_FOOT.toSquareThous(-873.5432456), delta);
        msg = "0 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_FOOT.toSquareThous(0.0), delta);
        msg = "0.1 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_FOOT.toSquareThous(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_FOOT.toSquareThous(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_FOOT.toSquareThous(0.33), delta);
        msg = "0.6543 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_FOOT.toSquareThous(0.6543), delta);
        msg = "1 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_FOOT.toSquareThous(1.0), delta);
        msg = "1.6543 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_FOOT.toSquareThous(1.6543), delta);
        msg = "22.45 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_FOOT.toSquareThous(22.45), delta);
        msg = "9876.5432 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_FOOT.toSquareThous(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_FOOT.toSquareThous(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_FOOT.toSquareThous(784.46789765434), delta);
        // ====================
        // ====================SQUARE_INCH
        // ====================
        // to_factor = 0.08333333333333333
        to_factor = SQUARE_INCH.getFactor();
        msg = "-1 * (1 / 0.08333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_FOOT.toSquareInches(-1.0), delta);
        msg = "-0.1 * (1 / 0.08333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_FOOT.toSquareInches(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_FOOT.toSquareInches(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.08333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_FOOT.toSquareInches(-73.25), delta);
        msg = "-56229.321 * (1 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_FOOT.toSquareInches(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_FOOT.toSquareInches(-873.5432456), delta);
        msg = "0 * (1 / 0.08333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_FOOT.toSquareInches(0.0), delta);
        msg = "0.1 * (1 / 0.08333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_FOOT.toSquareInches(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_FOOT.toSquareInches(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.08333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_FOOT.toSquareInches(0.33), delta);
        msg = "0.6543 * (1 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_FOOT.toSquareInches(0.6543), delta);
        msg = "1 * (1 / 0.08333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_FOOT.toSquareInches(1.0), delta);
        msg = "1.6543 * (1 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_FOOT.toSquareInches(1.6543), delta);
        msg = "22.45 * (1 / 0.08333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_FOOT.toSquareInches(22.45), delta);
        msg = "9876.5432 * (1 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_FOOT.toSquareInches(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_FOOT.toSquareInches(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_FOOT.toSquareInches(784.46789765434), delta);
        // ====================
        // ====================SQUARE_FOOT
        // ====================
        // to_factor = 1.0
        to_factor = SQUARE_FOOT.getFactor();
        msg = "-1 * (1 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_FOOT.toSquareFeet(-1.0), delta);
        msg = "-0.1 * (1 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_FOOT.toSquareFeet(-0.1), delta);
        msg = "-0.000456789 * (1 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_FOOT.toSquareFeet(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_FOOT.toSquareFeet(-73.25), delta);
        msg = "-56229.321 * (1 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_FOOT.toSquareFeet(-56229.321), delta);
        msg = "-873.5432456 * (1 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_FOOT.toSquareFeet(-873.5432456), delta);
        msg = "0 * (1 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_FOOT.toSquareFeet(0.0), delta);
        msg = "0.1 * (1 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_FOOT.toSquareFeet(0.1), delta);
        msg = "0.0000876543297 * (1 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_FOOT.toSquareFeet(8.76543297E-5), delta);
        msg = "0.33 * (1 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_FOOT.toSquareFeet(0.33), delta);
        msg = "0.6543 * (1 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_FOOT.toSquareFeet(0.6543), delta);
        msg = "1 * (1 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_FOOT.toSquareFeet(1.0), delta);
        msg = "1.6543 * (1 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_FOOT.toSquareFeet(1.6543), delta);
        msg = "22.45 * (1 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_FOOT.toSquareFeet(22.45), delta);
        msg = "9876.5432 * (1 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_FOOT.toSquareFeet(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_FOOT.toSquareFeet(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_FOOT.toSquareFeet(784.46789765434), delta);
        // ====================
        // ====================SQUARE_YARD
        // ====================
        // to_factor = 3.0
        to_factor = SQUARE_YARD.getFactor();
        msg = "-1 / (3 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_FOOT.toSquareYards(-1.0), delta);
        msg = "-0.1 / (3 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_FOOT.toSquareYards(-0.1), delta);
        msg = "-0.000456789 / (3 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_FOOT.toSquareYards(-4.56789E-4), delta);
        msg = "-73.25 / (3 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_FOOT.toSquareYards(-73.25), delta);
        msg = "-56229.321 / (3 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_FOOT.toSquareYards(-56229.321), delta);
        msg = "-873.5432456 / (3 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_FOOT.toSquareYards(-873.5432456), delta);
        msg = "0 / (3 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_FOOT.toSquareYards(0.0), delta);
        msg = "0.1 / (3 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_FOOT.toSquareYards(0.1), delta);
        msg = "0.0000876543297 / (3 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_FOOT.toSquareYards(8.76543297E-5), delta);
        msg = "0.33 / (3 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_FOOT.toSquareYards(0.33), delta);
        msg = "0.6543 / (3 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_FOOT.toSquareYards(0.6543), delta);
        msg = "1 / (3 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_FOOT.toSquareYards(1.0), delta);
        msg = "1.6543 / (3 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_FOOT.toSquareYards(1.6543), delta);
        msg = "22.45 / (3 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_FOOT.toSquareYards(22.45), delta);
        msg = "9876.5432 / (3 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_FOOT.toSquareYards(9876.5432), delta);
        msg = "1987654344.3345 / (3 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_FOOT.toSquareYards(1.9876543443345E9), delta);
        msg = "784.46789765434 / (3 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_FOOT.toSquareYards(784.46789765434), delta);
        // ====================
        // ====================SQUARE_CHAIN
        // ====================
        // to_factor = 66.0
        to_factor = SQUARE_CHAIN.getFactor();
        msg = "-1 / (66 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_FOOT.toSquareChains(-1.0), delta);
        msg = "-0.1 / (66 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_FOOT.toSquareChains(-0.1), delta);
        msg = "-0.000456789 / (66 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_FOOT.toSquareChains(-4.56789E-4), delta);
        msg = "-73.25 / (66 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_FOOT.toSquareChains(-73.25), delta);
        msg = "-56229.321 / (66 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_FOOT.toSquareChains(-56229.321), delta);
        msg = "-873.5432456 / (66 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_FOOT.toSquareChains(-873.5432456), delta);
        msg = "0 / (66 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_FOOT.toSquareChains(0.0), delta);
        msg = "0.1 / (66 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_FOOT.toSquareChains(0.1), delta);
        msg = "0.0000876543297 / (66 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_FOOT.toSquareChains(8.76543297E-5), delta);
        msg = "0.33 / (66 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_FOOT.toSquareChains(0.33), delta);
        msg = "0.6543 / (66 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_FOOT.toSquareChains(0.6543), delta);
        msg = "1 / (66 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_FOOT.toSquareChains(1.0), delta);
        msg = "1.6543 / (66 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_FOOT.toSquareChains(1.6543), delta);
        msg = "22.45 / (66 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_FOOT.toSquareChains(22.45), delta);
        msg = "9876.5432 / (66 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_FOOT.toSquareChains(9876.5432), delta);
        msg = "1987654344.3345 / (66 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_FOOT.toSquareChains(1.9876543443345E9), delta);
        msg = "784.46789765434 / (66 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_FOOT.toSquareChains(784.46789765434), delta);
        // ====================
        // ====================SQUARE_FURLONG
        // ====================
        // to_factor = 660.0
        to_factor = SQUARE_FURLONG.getFactor();
        msg = "-1 / (660 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_FOOT.toSquareFurlongs(-1.0), delta);
        msg = "-0.1 / (660 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_FOOT.toSquareFurlongs(-0.1), delta);
        msg = "-0.000456789 / (660 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_FOOT.toSquareFurlongs(-4.56789E-4), delta);
        msg = "-73.25 / (660 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_FOOT.toSquareFurlongs(-73.25), delta);
        msg = "-56229.321 / (660 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_FOOT.toSquareFurlongs(-56229.321), delta);
        msg = "-873.5432456 / (660 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_FOOT.toSquareFurlongs(-873.5432456), delta);
        msg = "0 / (660 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_FOOT.toSquareFurlongs(0.0), delta);
        msg = "0.1 / (660 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_FOOT.toSquareFurlongs(0.1), delta);
        msg = "0.0000876543297 / (660 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_FOOT.toSquareFurlongs(8.76543297E-5), delta);
        msg = "0.33 / (660 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_FOOT.toSquareFurlongs(0.33), delta);
        msg = "0.6543 / (660 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_FOOT.toSquareFurlongs(0.6543), delta);
        msg = "1 / (660 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_FOOT.toSquareFurlongs(1.0), delta);
        msg = "1.6543 / (660 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_FOOT.toSquareFurlongs(1.6543), delta);
        msg = "22.45 / (660 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_FOOT.toSquareFurlongs(22.45), delta);
        msg = "9876.5432 / (660 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_FOOT.toSquareFurlongs(9876.5432), delta);
        msg = "1987654344.3345 / (660 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_FOOT.toSquareFurlongs(1.9876543443345E9), delta);
        msg = "784.46789765434 / (660 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_FOOT.toSquareFurlongs(784.46789765434), delta);
        // ====================
        // ====================SQUARE_MILE
        // ====================
        // to_factor = 5280.0
        to_factor = SQUARE_MILE.getFactor();
        msg = "-1 / (5280 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_FOOT.toSquareMiles(-1.0), delta);
        msg = "-0.1 / (5280 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_FOOT.toSquareMiles(-0.1), delta);
        msg = "-0.000456789 / (5280 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_FOOT.toSquareMiles(-4.56789E-4), delta);
        msg = "-73.25 / (5280 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_FOOT.toSquareMiles(-73.25), delta);
        msg = "-56229.321 / (5280 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_FOOT.toSquareMiles(-56229.321), delta);
        msg = "-873.5432456 / (5280 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_FOOT.toSquareMiles(-873.5432456), delta);
        msg = "0 / (5280 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_FOOT.toSquareMiles(0.0), delta);
        msg = "0.1 / (5280 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_FOOT.toSquareMiles(0.1), delta);
        msg = "0.0000876543297 / (5280 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_FOOT.toSquareMiles(8.76543297E-5), delta);
        msg = "0.33 / (5280 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_FOOT.toSquareMiles(0.33), delta);
        msg = "0.6543 / (5280 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_FOOT.toSquareMiles(0.6543), delta);
        msg = "1 / (5280 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_FOOT.toSquareMiles(1.0), delta);
        msg = "1.6543 / (5280 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_FOOT.toSquareMiles(1.6543), delta);
        msg = "22.45 / (5280 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_FOOT.toSquareMiles(22.45), delta);
        msg = "9876.5432 / (5280 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_FOOT.toSquareMiles(9876.5432), delta);
        msg = "1987654344.3345 / (5280 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_FOOT.toSquareMiles(1.9876543443345E9), delta);
        msg = "784.46789765434 / (5280 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_FOOT.toSquareMiles(784.46789765434), delta);
    }

    @Test()
    public void testSquareYard() {
        // from_factor = 3.0
        double from_factor = SQUARE_YARD.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SQUARE_THOU
        // ====================
        // to_factor = 8.333333333333333E-5
        to_factor = SQUARE_THOU.getFactor();
        msg = "-1 * (3 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_YARD.toSquareThous(-1.0), delta);
        msg = "-0.1 * (3 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_YARD.toSquareThous(-0.1), delta);
        msg = "-0.000456789 * (3 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_YARD.toSquareThous(-4.56789E-4), delta);
        msg = "-73.25 * (3 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_YARD.toSquareThous(-73.25), delta);
        msg = "-56229.321 * (3 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_YARD.toSquareThous(-56229.321), delta);
        msg = "-873.5432456 * (3 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_YARD.toSquareThous(-873.5432456), delta);
        msg = "0 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_YARD.toSquareThous(0.0), delta);
        msg = "0.1 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_YARD.toSquareThous(0.1), delta);
        msg = "0.0000876543297 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_YARD.toSquareThous(8.76543297E-5), delta);
        msg = "0.33 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_YARD.toSquareThous(0.33), delta);
        msg = "0.6543 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_YARD.toSquareThous(0.6543), delta);
        msg = "1 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_YARD.toSquareThous(1.0), delta);
        msg = "1.6543 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_YARD.toSquareThous(1.6543), delta);
        msg = "22.45 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_YARD.toSquareThous(22.45), delta);
        msg = "9876.5432 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_YARD.toSquareThous(9876.5432), delta);
        msg = "1987654344.3345 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_YARD.toSquareThous(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_YARD.toSquareThous(784.46789765434), delta);
        // ====================
        // ====================SQUARE_INCH
        // ====================
        // to_factor = 0.08333333333333333
        to_factor = SQUARE_INCH.getFactor();
        msg = "-1 * (3 / 0.08333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_YARD.toSquareInches(-1.0), delta);
        msg = "-0.1 * (3 / 0.08333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_YARD.toSquareInches(-0.1), delta);
        msg = "-0.000456789 * (3 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_YARD.toSquareInches(-4.56789E-4), delta);
        msg = "-73.25 * (3 / 0.08333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_YARD.toSquareInches(-73.25), delta);
        msg = "-56229.321 * (3 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_YARD.toSquareInches(-56229.321), delta);
        msg = "-873.5432456 * (3 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_YARD.toSquareInches(-873.5432456), delta);
        msg = "0 * (3 / 0.08333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_YARD.toSquareInches(0.0), delta);
        msg = "0.1 * (3 / 0.08333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_YARD.toSquareInches(0.1), delta);
        msg = "0.0000876543297 * (3 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_YARD.toSquareInches(8.76543297E-5), delta);
        msg = "0.33 * (3 / 0.08333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_YARD.toSquareInches(0.33), delta);
        msg = "0.6543 * (3 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_YARD.toSquareInches(0.6543), delta);
        msg = "1 * (3 / 0.08333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_YARD.toSquareInches(1.0), delta);
        msg = "1.6543 * (3 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_YARD.toSquareInches(1.6543), delta);
        msg = "22.45 * (3 / 0.08333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_YARD.toSquareInches(22.45), delta);
        msg = "9876.5432 * (3 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_YARD.toSquareInches(9876.5432), delta);
        msg = "1987654344.3345 * (3 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_YARD.toSquareInches(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_YARD.toSquareInches(784.46789765434), delta);
        // ====================
        // ====================SQUARE_FOOT
        // ====================
        // to_factor = 1.0
        to_factor = SQUARE_FOOT.getFactor();
        msg = "-1 * (3 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_YARD.toSquareFeet(-1.0), delta);
        msg = "-0.1 * (3 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_YARD.toSquareFeet(-0.1), delta);
        msg = "-0.000456789 * (3 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_YARD.toSquareFeet(-4.56789E-4), delta);
        msg = "-73.25 * (3 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_YARD.toSquareFeet(-73.25), delta);
        msg = "-56229.321 * (3 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_YARD.toSquareFeet(-56229.321), delta);
        msg = "-873.5432456 * (3 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_YARD.toSquareFeet(-873.5432456), delta);
        msg = "0 * (3 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_YARD.toSquareFeet(0.0), delta);
        msg = "0.1 * (3 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_YARD.toSquareFeet(0.1), delta);
        msg = "0.0000876543297 * (3 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_YARD.toSquareFeet(8.76543297E-5), delta);
        msg = "0.33 * (3 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_YARD.toSquareFeet(0.33), delta);
        msg = "0.6543 * (3 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_YARD.toSquareFeet(0.6543), delta);
        msg = "1 * (3 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_YARD.toSquareFeet(1.0), delta);
        msg = "1.6543 * (3 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_YARD.toSquareFeet(1.6543), delta);
        msg = "22.45 * (3 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_YARD.toSquareFeet(22.45), delta);
        msg = "9876.5432 * (3 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_YARD.toSquareFeet(9876.5432), delta);
        msg = "1987654344.3345 * (3 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_YARD.toSquareFeet(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_YARD.toSquareFeet(784.46789765434), delta);
        // ====================
        // ====================SQUARE_YARD
        // ====================
        // to_factor = 3.0
        to_factor = SQUARE_YARD.getFactor();
        msg = "-1 * (3 / 3)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_YARD.toSquareYards(-1.0), delta);
        msg = "-0.1 * (3 / 3)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_YARD.toSquareYards(-0.1), delta);
        msg = "-0.000456789 * (3 / 3)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_YARD.toSquareYards(-4.56789E-4), delta);
        msg = "-73.25 * (3 / 3)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_YARD.toSquareYards(-73.25), delta);
        msg = "-56229.321 * (3 / 3)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_YARD.toSquareYards(-56229.321), delta);
        msg = "-873.5432456 * (3 / 3)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_YARD.toSquareYards(-873.5432456), delta);
        msg = "0 * (3 / 3)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_YARD.toSquareYards(0.0), delta);
        msg = "0.1 * (3 / 3)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_YARD.toSquareYards(0.1), delta);
        msg = "0.0000876543297 * (3 / 3)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_YARD.toSquareYards(8.76543297E-5), delta);
        msg = "0.33 * (3 / 3)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_YARD.toSquareYards(0.33), delta);
        msg = "0.6543 * (3 / 3)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_YARD.toSquareYards(0.6543), delta);
        msg = "1 * (3 / 3)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_YARD.toSquareYards(1.0), delta);
        msg = "1.6543 * (3 / 3)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_YARD.toSquareYards(1.6543), delta);
        msg = "22.45 * (3 / 3)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_YARD.toSquareYards(22.45), delta);
        msg = "9876.5432 * (3 / 3)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_YARD.toSquareYards(9876.5432), delta);
        msg = "1987654344.3345 * (3 / 3)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_YARD.toSquareYards(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3 / 3)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_YARD.toSquareYards(784.46789765434), delta);
        // ====================
        // ====================SQUARE_CHAIN
        // ====================
        // to_factor = 66.0
        to_factor = SQUARE_CHAIN.getFactor();
        msg = "-1 / (66 / 3)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_YARD.toSquareChains(-1.0), delta);
        msg = "-0.1 / (66 / 3)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_YARD.toSquareChains(-0.1), delta);
        msg = "-0.000456789 / (66 / 3)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_YARD.toSquareChains(-4.56789E-4), delta);
        msg = "-73.25 / (66 / 3)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_YARD.toSquareChains(-73.25), delta);
        msg = "-56229.321 / (66 / 3)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_YARD.toSquareChains(-56229.321), delta);
        msg = "-873.5432456 / (66 / 3)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_YARD.toSquareChains(-873.5432456), delta);
        msg = "0 / (66 / 3)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_YARD.toSquareChains(0.0), delta);
        msg = "0.1 / (66 / 3)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_YARD.toSquareChains(0.1), delta);
        msg = "0.0000876543297 / (66 / 3)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_YARD.toSquareChains(8.76543297E-5), delta);
        msg = "0.33 / (66 / 3)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_YARD.toSquareChains(0.33), delta);
        msg = "0.6543 / (66 / 3)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_YARD.toSquareChains(0.6543), delta);
        msg = "1 / (66 / 3)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_YARD.toSquareChains(1.0), delta);
        msg = "1.6543 / (66 / 3)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_YARD.toSquareChains(1.6543), delta);
        msg = "22.45 / (66 / 3)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_YARD.toSquareChains(22.45), delta);
        msg = "9876.5432 / (66 / 3)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_YARD.toSquareChains(9876.5432), delta);
        msg = "1987654344.3345 / (66 / 3)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_YARD.toSquareChains(1.9876543443345E9), delta);
        msg = "784.46789765434 / (66 / 3)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_YARD.toSquareChains(784.46789765434), delta);
        // ====================
        // ====================SQUARE_FURLONG
        // ====================
        // to_factor = 660.0
        to_factor = SQUARE_FURLONG.getFactor();
        msg = "-1 / (660 / 3)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_YARD.toSquareFurlongs(-1.0), delta);
        msg = "-0.1 / (660 / 3)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_YARD.toSquareFurlongs(-0.1), delta);
        msg = "-0.000456789 / (660 / 3)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_YARD.toSquareFurlongs(-4.56789E-4), delta);
        msg = "-73.25 / (660 / 3)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_YARD.toSquareFurlongs(-73.25), delta);
        msg = "-56229.321 / (660 / 3)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_YARD.toSquareFurlongs(-56229.321), delta);
        msg = "-873.5432456 / (660 / 3)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_YARD.toSquareFurlongs(-873.5432456), delta);
        msg = "0 / (660 / 3)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_YARD.toSquareFurlongs(0.0), delta);
        msg = "0.1 / (660 / 3)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_YARD.toSquareFurlongs(0.1), delta);
        msg = "0.0000876543297 / (660 / 3)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_YARD.toSquareFurlongs(8.76543297E-5), delta);
        msg = "0.33 / (660 / 3)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_YARD.toSquareFurlongs(0.33), delta);
        msg = "0.6543 / (660 / 3)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_YARD.toSquareFurlongs(0.6543), delta);
        msg = "1 / (660 / 3)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_YARD.toSquareFurlongs(1.0), delta);
        msg = "1.6543 / (660 / 3)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_YARD.toSquareFurlongs(1.6543), delta);
        msg = "22.45 / (660 / 3)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_YARD.toSquareFurlongs(22.45), delta);
        msg = "9876.5432 / (660 / 3)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_YARD.toSquareFurlongs(9876.5432), delta);
        msg = "1987654344.3345 / (660 / 3)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_YARD.toSquareFurlongs(1.9876543443345E9), delta);
        msg = "784.46789765434 / (660 / 3)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_YARD.toSquareFurlongs(784.46789765434), delta);
        // ====================
        // ====================SQUARE_MILE
        // ====================
        // to_factor = 5280.0
        to_factor = SQUARE_MILE.getFactor();
        msg = "-1 / (5280 / 3)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_YARD.toSquareMiles(-1.0), delta);
        msg = "-0.1 / (5280 / 3)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_YARD.toSquareMiles(-0.1), delta);
        msg = "-0.000456789 / (5280 / 3)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_YARD.toSquareMiles(-4.56789E-4), delta);
        msg = "-73.25 / (5280 / 3)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_YARD.toSquareMiles(-73.25), delta);
        msg = "-56229.321 / (5280 / 3)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_YARD.toSquareMiles(-56229.321), delta);
        msg = "-873.5432456 / (5280 / 3)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_YARD.toSquareMiles(-873.5432456), delta);
        msg = "0 / (5280 / 3)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_YARD.toSquareMiles(0.0), delta);
        msg = "0.1 / (5280 / 3)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_YARD.toSquareMiles(0.1), delta);
        msg = "0.0000876543297 / (5280 / 3)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_YARD.toSquareMiles(8.76543297E-5), delta);
        msg = "0.33 / (5280 / 3)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_YARD.toSquareMiles(0.33), delta);
        msg = "0.6543 / (5280 / 3)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_YARD.toSquareMiles(0.6543), delta);
        msg = "1 / (5280 / 3)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_YARD.toSquareMiles(1.0), delta);
        msg = "1.6543 / (5280 / 3)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_YARD.toSquareMiles(1.6543), delta);
        msg = "22.45 / (5280 / 3)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_YARD.toSquareMiles(22.45), delta);
        msg = "9876.5432 / (5280 / 3)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_YARD.toSquareMiles(9876.5432), delta);
        msg = "1987654344.3345 / (5280 / 3)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_YARD.toSquareMiles(1.9876543443345E9), delta);
        msg = "784.46789765434 / (5280 / 3)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_YARD.toSquareMiles(784.46789765434), delta);
    }

    @Test()
    public void testSquareChain() {
        // from_factor = 66.0
        double from_factor = SQUARE_CHAIN.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SQUARE_THOU
        // ====================
        // to_factor = 8.333333333333333E-5
        to_factor = SQUARE_THOU.getFactor();
        msg = "-1 * (66 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_CHAIN.toSquareThous(-1.0), delta);
        msg = "-0.1 * (66 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_CHAIN.toSquareThous(-0.1), delta);
        msg = "-0.000456789 * (66 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_CHAIN.toSquareThous(-4.56789E-4), delta);
        msg = "-73.25 * (66 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_CHAIN.toSquareThous(-73.25), delta);
        msg = "-56229.321 * (66 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_CHAIN.toSquareThous(-56229.321), delta);
        msg = "-873.5432456 * (66 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_CHAIN.toSquareThous(-873.5432456), delta);
        msg = "0 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_CHAIN.toSquareThous(0.0), delta);
        msg = "0.1 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_CHAIN.toSquareThous(0.1), delta);
        msg = "0.0000876543297 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_CHAIN.toSquareThous(8.76543297E-5), delta);
        msg = "0.33 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_CHAIN.toSquareThous(0.33), delta);
        msg = "0.6543 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_CHAIN.toSquareThous(0.6543), delta);
        msg = "1 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_CHAIN.toSquareThous(1.0), delta);
        msg = "1.6543 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_CHAIN.toSquareThous(1.6543), delta);
        msg = "22.45 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_CHAIN.toSquareThous(22.45), delta);
        msg = "9876.5432 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_CHAIN.toSquareThous(9876.5432), delta);
        msg = "1987654344.3345 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_CHAIN.toSquareThous(1.9876543443345E9), delta);
        msg = "784.46789765434 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_CHAIN.toSquareThous(784.46789765434), delta);
        // ====================
        // ====================SQUARE_INCH
        // ====================
        // to_factor = 0.08333333333333333
        to_factor = SQUARE_INCH.getFactor();
        msg = "-1 * (66 / 0.08333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_CHAIN.toSquareInches(-1.0), delta);
        msg = "-0.1 * (66 / 0.08333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_CHAIN.toSquareInches(-0.1), delta);
        msg = "-0.000456789 * (66 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_CHAIN.toSquareInches(-4.56789E-4), delta);
        msg = "-73.25 * (66 / 0.08333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_CHAIN.toSquareInches(-73.25), delta);
        msg = "-56229.321 * (66 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_CHAIN.toSquareInches(-56229.321), delta);
        msg = "-873.5432456 * (66 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_CHAIN.toSquareInches(-873.5432456), delta);
        msg = "0 * (66 / 0.08333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_CHAIN.toSquareInches(0.0), delta);
        msg = "0.1 * (66 / 0.08333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_CHAIN.toSquareInches(0.1), delta);
        msg = "0.0000876543297 * (66 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_CHAIN.toSquareInches(8.76543297E-5), delta);
        msg = "0.33 * (66 / 0.08333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_CHAIN.toSquareInches(0.33), delta);
        msg = "0.6543 * (66 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_CHAIN.toSquareInches(0.6543), delta);
        msg = "1 * (66 / 0.08333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_CHAIN.toSquareInches(1.0), delta);
        msg = "1.6543 * (66 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_CHAIN.toSquareInches(1.6543), delta);
        msg = "22.45 * (66 / 0.08333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_CHAIN.toSquareInches(22.45), delta);
        msg = "9876.5432 * (66 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_CHAIN.toSquareInches(9876.5432), delta);
        msg = "1987654344.3345 * (66 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_CHAIN.toSquareInches(1.9876543443345E9), delta);
        msg = "784.46789765434 * (66 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_CHAIN.toSquareInches(784.46789765434), delta);
        // ====================
        // ====================SQUARE_FOOT
        // ====================
        // to_factor = 1.0
        to_factor = SQUARE_FOOT.getFactor();
        msg = "-1 * (66 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_CHAIN.toSquareFeet(-1.0), delta);
        msg = "-0.1 * (66 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_CHAIN.toSquareFeet(-0.1), delta);
        msg = "-0.000456789 * (66 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_CHAIN.toSquareFeet(-4.56789E-4), delta);
        msg = "-73.25 * (66 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_CHAIN.toSquareFeet(-73.25), delta);
        msg = "-56229.321 * (66 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_CHAIN.toSquareFeet(-56229.321), delta);
        msg = "-873.5432456 * (66 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_CHAIN.toSquareFeet(-873.5432456), delta);
        msg = "0 * (66 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_CHAIN.toSquareFeet(0.0), delta);
        msg = "0.1 * (66 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_CHAIN.toSquareFeet(0.1), delta);
        msg = "0.0000876543297 * (66 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_CHAIN.toSquareFeet(8.76543297E-5), delta);
        msg = "0.33 * (66 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_CHAIN.toSquareFeet(0.33), delta);
        msg = "0.6543 * (66 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_CHAIN.toSquareFeet(0.6543), delta);
        msg = "1 * (66 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_CHAIN.toSquareFeet(1.0), delta);
        msg = "1.6543 * (66 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_CHAIN.toSquareFeet(1.6543), delta);
        msg = "22.45 * (66 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_CHAIN.toSquareFeet(22.45), delta);
        msg = "9876.5432 * (66 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_CHAIN.toSquareFeet(9876.5432), delta);
        msg = "1987654344.3345 * (66 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_CHAIN.toSquareFeet(1.9876543443345E9), delta);
        msg = "784.46789765434 * (66 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_CHAIN.toSquareFeet(784.46789765434), delta);
        // ====================
        // ====================SQUARE_YARD
        // ====================
        // to_factor = 3.0
        to_factor = SQUARE_YARD.getFactor();
        msg = "-1 * (66 / 3)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_CHAIN.toSquareYards(-1.0), delta);
        msg = "-0.1 * (66 / 3)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_CHAIN.toSquareYards(-0.1), delta);
        msg = "-0.000456789 * (66 / 3)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_CHAIN.toSquareYards(-4.56789E-4), delta);
        msg = "-73.25 * (66 / 3)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_CHAIN.toSquareYards(-73.25), delta);
        msg = "-56229.321 * (66 / 3)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_CHAIN.toSquareYards(-56229.321), delta);
        msg = "-873.5432456 * (66 / 3)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_CHAIN.toSquareYards(-873.5432456), delta);
        msg = "0 * (66 / 3)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_CHAIN.toSquareYards(0.0), delta);
        msg = "0.1 * (66 / 3)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_CHAIN.toSquareYards(0.1), delta);
        msg = "0.0000876543297 * (66 / 3)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_CHAIN.toSquareYards(8.76543297E-5), delta);
        msg = "0.33 * (66 / 3)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_CHAIN.toSquareYards(0.33), delta);
        msg = "0.6543 * (66 / 3)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_CHAIN.toSquareYards(0.6543), delta);
        msg = "1 * (66 / 3)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_CHAIN.toSquareYards(1.0), delta);
        msg = "1.6543 * (66 / 3)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_CHAIN.toSquareYards(1.6543), delta);
        msg = "22.45 * (66 / 3)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_CHAIN.toSquareYards(22.45), delta);
        msg = "9876.5432 * (66 / 3)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_CHAIN.toSquareYards(9876.5432), delta);
        msg = "1987654344.3345 * (66 / 3)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_CHAIN.toSquareYards(1.9876543443345E9), delta);
        msg = "784.46789765434 * (66 / 3)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_CHAIN.toSquareYards(784.46789765434), delta);
        // ====================
        // ====================SQUARE_CHAIN
        // ====================
        // to_factor = 66.0
        to_factor = SQUARE_CHAIN.getFactor();
        msg = "-1 * (66 / 66)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_CHAIN.toSquareChains(-1.0), delta);
        msg = "-0.1 * (66 / 66)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_CHAIN.toSquareChains(-0.1), delta);
        msg = "-0.000456789 * (66 / 66)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_CHAIN.toSquareChains(-4.56789E-4), delta);
        msg = "-73.25 * (66 / 66)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_CHAIN.toSquareChains(-73.25), delta);
        msg = "-56229.321 * (66 / 66)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_CHAIN.toSquareChains(-56229.321), delta);
        msg = "-873.5432456 * (66 / 66)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_CHAIN.toSquareChains(-873.5432456), delta);
        msg = "0 * (66 / 66)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_CHAIN.toSquareChains(0.0), delta);
        msg = "0.1 * (66 / 66)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_CHAIN.toSquareChains(0.1), delta);
        msg = "0.0000876543297 * (66 / 66)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_CHAIN.toSquareChains(8.76543297E-5), delta);
        msg = "0.33 * (66 / 66)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_CHAIN.toSquareChains(0.33), delta);
        msg = "0.6543 * (66 / 66)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_CHAIN.toSquareChains(0.6543), delta);
        msg = "1 * (66 / 66)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_CHAIN.toSquareChains(1.0), delta);
        msg = "1.6543 * (66 / 66)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_CHAIN.toSquareChains(1.6543), delta);
        msg = "22.45 * (66 / 66)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_CHAIN.toSquareChains(22.45), delta);
        msg = "9876.5432 * (66 / 66)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_CHAIN.toSquareChains(9876.5432), delta);
        msg = "1987654344.3345 * (66 / 66)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_CHAIN.toSquareChains(1.9876543443345E9), delta);
        msg = "784.46789765434 * (66 / 66)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_CHAIN.toSquareChains(784.46789765434), delta);
        // ====================
        // ====================SQUARE_FURLONG
        // ====================
        // to_factor = 660.0
        to_factor = SQUARE_FURLONG.getFactor();
        msg = "-1 / (660 / 66)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_CHAIN.toSquareFurlongs(-1.0), delta);
        msg = "-0.1 / (660 / 66)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_CHAIN.toSquareFurlongs(-0.1), delta);
        msg = "-0.000456789 / (660 / 66)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_CHAIN.toSquareFurlongs(-4.56789E-4), delta);
        msg = "-73.25 / (660 / 66)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_CHAIN.toSquareFurlongs(-73.25), delta);
        msg = "-56229.321 / (660 / 66)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_CHAIN.toSquareFurlongs(-56229.321), delta);
        msg = "-873.5432456 / (660 / 66)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_CHAIN.toSquareFurlongs(-873.5432456), delta);
        msg = "0 / (660 / 66)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_CHAIN.toSquareFurlongs(0.0), delta);
        msg = "0.1 / (660 / 66)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_CHAIN.toSquareFurlongs(0.1), delta);
        msg = "0.0000876543297 / (660 / 66)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_CHAIN.toSquareFurlongs(8.76543297E-5), delta);
        msg = "0.33 / (660 / 66)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_CHAIN.toSquareFurlongs(0.33), delta);
        msg = "0.6543 / (660 / 66)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_CHAIN.toSquareFurlongs(0.6543), delta);
        msg = "1 / (660 / 66)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_CHAIN.toSquareFurlongs(1.0), delta);
        msg = "1.6543 / (660 / 66)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_CHAIN.toSquareFurlongs(1.6543), delta);
        msg = "22.45 / (660 / 66)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_CHAIN.toSquareFurlongs(22.45), delta);
        msg = "9876.5432 / (660 / 66)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_CHAIN.toSquareFurlongs(9876.5432), delta);
        msg = "1987654344.3345 / (660 / 66)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_CHAIN.toSquareFurlongs(1.9876543443345E9), delta);
        msg = "784.46789765434 / (660 / 66)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_CHAIN.toSquareFurlongs(784.46789765434), delta);
        // ====================
        // ====================SQUARE_MILE
        // ====================
        // to_factor = 5280.0
        to_factor = SQUARE_MILE.getFactor();
        msg = "-1 / (5280 / 66)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_CHAIN.toSquareMiles(-1.0), delta);
        msg = "-0.1 / (5280 / 66)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_CHAIN.toSquareMiles(-0.1), delta);
        msg = "-0.000456789 / (5280 / 66)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_CHAIN.toSquareMiles(-4.56789E-4), delta);
        msg = "-73.25 / (5280 / 66)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_CHAIN.toSquareMiles(-73.25), delta);
        msg = "-56229.321 / (5280 / 66)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_CHAIN.toSquareMiles(-56229.321), delta);
        msg = "-873.5432456 / (5280 / 66)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_CHAIN.toSquareMiles(-873.5432456), delta);
        msg = "0 / (5280 / 66)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_CHAIN.toSquareMiles(0.0), delta);
        msg = "0.1 / (5280 / 66)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_CHAIN.toSquareMiles(0.1), delta);
        msg = "0.0000876543297 / (5280 / 66)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_CHAIN.toSquareMiles(8.76543297E-5), delta);
        msg = "0.33 / (5280 / 66)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_CHAIN.toSquareMiles(0.33), delta);
        msg = "0.6543 / (5280 / 66)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_CHAIN.toSquareMiles(0.6543), delta);
        msg = "1 / (5280 / 66)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_CHAIN.toSquareMiles(1.0), delta);
        msg = "1.6543 / (5280 / 66)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_CHAIN.toSquareMiles(1.6543), delta);
        msg = "22.45 / (5280 / 66)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_CHAIN.toSquareMiles(22.45), delta);
        msg = "9876.5432 / (5280 / 66)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_CHAIN.toSquareMiles(9876.5432), delta);
        msg = "1987654344.3345 / (5280 / 66)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_CHAIN.toSquareMiles(1.9876543443345E9), delta);
        msg = "784.46789765434 / (5280 / 66)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_CHAIN.toSquareMiles(784.46789765434), delta);
    }

    @Test()
    public void testSquareFurlong() {
        // from_factor = 660.0
        double from_factor = SQUARE_FURLONG.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SQUARE_THOU
        // ====================
        // to_factor = 8.333333333333333E-5
        to_factor = SQUARE_THOU.getFactor();
        msg = "-1 * (660 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_FURLONG.toSquareThous(-1.0), delta);
        msg = "-0.1 * (660 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_FURLONG.toSquareThous(-0.1), delta);
        msg = "-0.000456789 * (660 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_FURLONG.toSquareThous(-4.56789E-4), delta);
        msg = "-73.25 * (660 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_FURLONG.toSquareThous(-73.25), delta);
        msg = "-56229.321 * (660 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_FURLONG.toSquareThous(-56229.321), delta);
        msg = "-873.5432456 * (660 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_FURLONG.toSquareThous(-873.5432456), delta);
        msg = "0 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_FURLONG.toSquareThous(0.0), delta);
        msg = "0.1 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_FURLONG.toSquareThous(0.1), delta);
        msg = "0.0000876543297 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_FURLONG.toSquareThous(8.76543297E-5), delta);
        msg = "0.33 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_FURLONG.toSquareThous(0.33), delta);
        msg = "0.6543 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_FURLONG.toSquareThous(0.6543), delta);
        msg = "1 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_FURLONG.toSquareThous(1.0), delta);
        msg = "1.6543 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_FURLONG.toSquareThous(1.6543), delta);
        msg = "22.45 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_FURLONG.toSquareThous(22.45), delta);
        msg = "9876.5432 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_FURLONG.toSquareThous(9876.5432), delta);
        msg = "1987654344.3345 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_FURLONG.toSquareThous(1.9876543443345E9), delta);
        msg = "784.46789765434 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_FURLONG.toSquareThous(784.46789765434), delta);
        // ====================
        // ====================SQUARE_INCH
        // ====================
        // to_factor = 0.08333333333333333
        to_factor = SQUARE_INCH.getFactor();
        msg = "-1 * (660 / 0.08333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_FURLONG.toSquareInches(-1.0), delta);
        msg = "-0.1 * (660 / 0.08333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_FURLONG.toSquareInches(-0.1), delta);
        msg = "-0.000456789 * (660 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_FURLONG.toSquareInches(-4.56789E-4), delta);
        msg = "-73.25 * (660 / 0.08333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_FURLONG.toSquareInches(-73.25), delta);
        msg = "-56229.321 * (660 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_FURLONG.toSquareInches(-56229.321), delta);
        msg = "-873.5432456 * (660 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_FURLONG.toSquareInches(-873.5432456), delta);
        msg = "0 * (660 / 0.08333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_FURLONG.toSquareInches(0.0), delta);
        msg = "0.1 * (660 / 0.08333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_FURLONG.toSquareInches(0.1), delta);
        msg = "0.0000876543297 * (660 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_FURLONG.toSquareInches(8.76543297E-5), delta);
        msg = "0.33 * (660 / 0.08333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_FURLONG.toSquareInches(0.33), delta);
        msg = "0.6543 * (660 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_FURLONG.toSquareInches(0.6543), delta);
        msg = "1 * (660 / 0.08333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_FURLONG.toSquareInches(1.0), delta);
        msg = "1.6543 * (660 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_FURLONG.toSquareInches(1.6543), delta);
        msg = "22.45 * (660 / 0.08333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_FURLONG.toSquareInches(22.45), delta);
        msg = "9876.5432 * (660 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_FURLONG.toSquareInches(9876.5432), delta);
        msg = "1987654344.3345 * (660 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_FURLONG.toSquareInches(1.9876543443345E9), delta);
        msg = "784.46789765434 * (660 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_FURLONG.toSquareInches(784.46789765434), delta);
        // ====================
        // ====================SQUARE_FOOT
        // ====================
        // to_factor = 1.0
        to_factor = SQUARE_FOOT.getFactor();
        msg = "-1 * (660 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFeet(-1.0), delta);
        msg = "-0.1 * (660 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFeet(-0.1), delta);
        msg = "-0.000456789 * (660 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFeet(-4.56789E-4), delta);
        msg = "-73.25 * (660 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFeet(-73.25), delta);
        msg = "-56229.321 * (660 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFeet(-56229.321), delta);
        msg = "-873.5432456 * (660 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFeet(-873.5432456), delta);
        msg = "0 * (660 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFeet(0.0), delta);
        msg = "0.1 * (660 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFeet(0.1), delta);
        msg = "0.0000876543297 * (660 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFeet(8.76543297E-5), delta);
        msg = "0.33 * (660 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFeet(0.33), delta);
        msg = "0.6543 * (660 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFeet(0.6543), delta);
        msg = "1 * (660 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFeet(1.0), delta);
        msg = "1.6543 * (660 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFeet(1.6543), delta);
        msg = "22.45 * (660 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFeet(22.45), delta);
        msg = "9876.5432 * (660 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFeet(9876.5432), delta);
        msg = "1987654344.3345 * (660 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFeet(1.9876543443345E9), delta);
        msg = "784.46789765434 * (660 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFeet(784.46789765434), delta);
        // ====================
        // ====================SQUARE_YARD
        // ====================
        // to_factor = 3.0
        to_factor = SQUARE_YARD.getFactor();
        msg = "-1 * (660 / 3)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_FURLONG.toSquareYards(-1.0), delta);
        msg = "-0.1 * (660 / 3)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_FURLONG.toSquareYards(-0.1), delta);
        msg = "-0.000456789 * (660 / 3)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_FURLONG.toSquareYards(-4.56789E-4), delta);
        msg = "-73.25 * (660 / 3)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_FURLONG.toSquareYards(-73.25), delta);
        msg = "-56229.321 * (660 / 3)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_FURLONG.toSquareYards(-56229.321), delta);
        msg = "-873.5432456 * (660 / 3)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_FURLONG.toSquareYards(-873.5432456), delta);
        msg = "0 * (660 / 3)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_FURLONG.toSquareYards(0.0), delta);
        msg = "0.1 * (660 / 3)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_FURLONG.toSquareYards(0.1), delta);
        msg = "0.0000876543297 * (660 / 3)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_FURLONG.toSquareYards(8.76543297E-5), delta);
        msg = "0.33 * (660 / 3)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_FURLONG.toSquareYards(0.33), delta);
        msg = "0.6543 * (660 / 3)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_FURLONG.toSquareYards(0.6543), delta);
        msg = "1 * (660 / 3)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_FURLONG.toSquareYards(1.0), delta);
        msg = "1.6543 * (660 / 3)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_FURLONG.toSquareYards(1.6543), delta);
        msg = "22.45 * (660 / 3)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_FURLONG.toSquareYards(22.45), delta);
        msg = "9876.5432 * (660 / 3)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_FURLONG.toSquareYards(9876.5432), delta);
        msg = "1987654344.3345 * (660 / 3)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_FURLONG.toSquareYards(1.9876543443345E9), delta);
        msg = "784.46789765434 * (660 / 3)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_FURLONG.toSquareYards(784.46789765434), delta);
        // ====================
        // ====================SQUARE_CHAIN
        // ====================
        // to_factor = 66.0
        to_factor = SQUARE_CHAIN.getFactor();
        msg = "-1 * (660 / 66)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_FURLONG.toSquareChains(-1.0), delta);
        msg = "-0.1 * (660 / 66)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_FURLONG.toSquareChains(-0.1), delta);
        msg = "-0.000456789 * (660 / 66)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_FURLONG.toSquareChains(-4.56789E-4), delta);
        msg = "-73.25 * (660 / 66)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_FURLONG.toSquareChains(-73.25), delta);
        msg = "-56229.321 * (660 / 66)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_FURLONG.toSquareChains(-56229.321), delta);
        msg = "-873.5432456 * (660 / 66)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_FURLONG.toSquareChains(-873.5432456), delta);
        msg = "0 * (660 / 66)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_FURLONG.toSquareChains(0.0), delta);
        msg = "0.1 * (660 / 66)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_FURLONG.toSquareChains(0.1), delta);
        msg = "0.0000876543297 * (660 / 66)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_FURLONG.toSquareChains(8.76543297E-5), delta);
        msg = "0.33 * (660 / 66)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_FURLONG.toSquareChains(0.33), delta);
        msg = "0.6543 * (660 / 66)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_FURLONG.toSquareChains(0.6543), delta);
        msg = "1 * (660 / 66)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_FURLONG.toSquareChains(1.0), delta);
        msg = "1.6543 * (660 / 66)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_FURLONG.toSquareChains(1.6543), delta);
        msg = "22.45 * (660 / 66)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_FURLONG.toSquareChains(22.45), delta);
        msg = "9876.5432 * (660 / 66)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_FURLONG.toSquareChains(9876.5432), delta);
        msg = "1987654344.3345 * (660 / 66)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_FURLONG.toSquareChains(1.9876543443345E9), delta);
        msg = "784.46789765434 * (660 / 66)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_FURLONG.toSquareChains(784.46789765434), delta);
        // ====================
        // ====================SQUARE_FURLONG
        // ====================
        // to_factor = 660.0
        to_factor = SQUARE_FURLONG.getFactor();
        msg = "-1 * (660 / 660)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFurlongs(-1.0), delta);
        msg = "-0.1 * (660 / 660)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFurlongs(-0.1), delta);
        msg = "-0.000456789 * (660 / 660)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFurlongs(-4.56789E-4), delta);
        msg = "-73.25 * (660 / 660)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFurlongs(-73.25), delta);
        msg = "-56229.321 * (660 / 660)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFurlongs(-56229.321), delta);
        msg = "-873.5432456 * (660 / 660)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFurlongs(-873.5432456), delta);
        msg = "0 * (660 / 660)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFurlongs(0.0), delta);
        msg = "0.1 * (660 / 660)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFurlongs(0.1), delta);
        msg = "0.0000876543297 * (660 / 660)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFurlongs(8.76543297E-5), delta);
        msg = "0.33 * (660 / 660)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFurlongs(0.33), delta);
        msg = "0.6543 * (660 / 660)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFurlongs(0.6543), delta);
        msg = "1 * (660 / 660)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFurlongs(1.0), delta);
        msg = "1.6543 * (660 / 660)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFurlongs(1.6543), delta);
        msg = "22.45 * (660 / 660)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFurlongs(22.45), delta);
        msg = "9876.5432 * (660 / 660)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFurlongs(9876.5432), delta);
        msg = "1987654344.3345 * (660 / 660)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFurlongs(1.9876543443345E9), delta);
        msg = "784.46789765434 * (660 / 660)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_FURLONG.toSquareFurlongs(784.46789765434), delta);
        // ====================
        // ====================SQUARE_MILE
        // ====================
        // to_factor = 5280.0
        to_factor = SQUARE_MILE.getFactor();
        msg = "-1 / (5280 / 660)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), SQUARE_FURLONG.toSquareMiles(-1.0), delta);
        msg = "-0.1 / (5280 / 660)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), SQUARE_FURLONG.toSquareMiles(-0.1), delta);
        msg = "-0.000456789 / (5280 / 660)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), SQUARE_FURLONG.toSquareMiles(-4.56789E-4), delta);
        msg = "-73.25 / (5280 / 660)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), SQUARE_FURLONG.toSquareMiles(-73.25), delta);
        msg = "-56229.321 / (5280 / 660)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), SQUARE_FURLONG.toSquareMiles(-56229.321), delta);
        msg = "-873.5432456 / (5280 / 660)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), SQUARE_FURLONG.toSquareMiles(-873.5432456), delta);
        msg = "0 / (5280 / 660)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), SQUARE_FURLONG.toSquareMiles(0.0), delta);
        msg = "0.1 / (5280 / 660)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), SQUARE_FURLONG.toSquareMiles(0.1), delta);
        msg = "0.0000876543297 / (5280 / 660)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), SQUARE_FURLONG.toSquareMiles(8.76543297E-5), delta);
        msg = "0.33 / (5280 / 660)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), SQUARE_FURLONG.toSquareMiles(0.33), delta);
        msg = "0.6543 / (5280 / 660)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), SQUARE_FURLONG.toSquareMiles(0.6543), delta);
        msg = "1 / (5280 / 660)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), SQUARE_FURLONG.toSquareMiles(1.0), delta);
        msg = "1.6543 / (5280 / 660)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), SQUARE_FURLONG.toSquareMiles(1.6543), delta);
        msg = "22.45 / (5280 / 660)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), SQUARE_FURLONG.toSquareMiles(22.45), delta);
        msg = "9876.5432 / (5280 / 660)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), SQUARE_FURLONG.toSquareMiles(9876.5432), delta);
        msg = "1987654344.3345 / (5280 / 660)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), SQUARE_FURLONG.toSquareMiles(1.9876543443345E9), delta);
        msg = "784.46789765434 / (5280 / 660)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), SQUARE_FURLONG.toSquareMiles(784.46789765434), delta);
    }

    @Test()
    public void testSquareMile() {
        // from_factor = 5280.0
        double from_factor = SQUARE_MILE.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================SQUARE_THOU
        // ====================
        // to_factor = 8.333333333333333E-5
        to_factor = SQUARE_THOU.getFactor();
        msg = "-1 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_MILE.toSquareThous(-1.0), delta);
        msg = "-0.1 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_MILE.toSquareThous(-0.1), delta);
        msg = "-0.000456789 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_MILE.toSquareThous(-4.56789E-4), delta);
        msg = "-73.25 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_MILE.toSquareThous(-73.25), delta);
        msg = "-56229.321 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_MILE.toSquareThous(-56229.321), delta);
        msg = "-873.5432456 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_MILE.toSquareThous(-873.5432456), delta);
        msg = "0 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_MILE.toSquareThous(0.0), delta);
        msg = "0.1 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_MILE.toSquareThous(0.1), delta);
        msg = "0.0000876543297 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_MILE.toSquareThous(8.76543297E-5), delta);
        msg = "0.33 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_MILE.toSquareThous(0.33), delta);
        msg = "0.6543 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_MILE.toSquareThous(0.6543), delta);
        msg = "1 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_MILE.toSquareThous(1.0), delta);
        msg = "1.6543 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_MILE.toSquareThous(1.6543), delta);
        msg = "22.45 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_MILE.toSquareThous(22.45), delta);
        msg = "9876.5432 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_MILE.toSquareThous(9876.5432), delta);
        msg = "1987654344.3345 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_MILE.toSquareThous(1.9876543443345E9), delta);
        msg = "784.46789765434 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_MILE.toSquareThous(784.46789765434), delta);
        // ====================
        // ====================SQUARE_INCH
        // ====================
        // to_factor = 0.08333333333333333
        to_factor = SQUARE_INCH.getFactor();
        msg = "-1 * (5280 / 0.08333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_MILE.toSquareInches(-1.0), delta);
        msg = "-0.1 * (5280 / 0.08333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_MILE.toSquareInches(-0.1), delta);
        msg = "-0.000456789 * (5280 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_MILE.toSquareInches(-4.56789E-4), delta);
        msg = "-73.25 * (5280 / 0.08333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_MILE.toSquareInches(-73.25), delta);
        msg = "-56229.321 * (5280 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_MILE.toSquareInches(-56229.321), delta);
        msg = "-873.5432456 * (5280 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_MILE.toSquareInches(-873.5432456), delta);
        msg = "0 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_MILE.toSquareInches(0.0), delta);
        msg = "0.1 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_MILE.toSquareInches(0.1), delta);
        msg = "0.0000876543297 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_MILE.toSquareInches(8.76543297E-5), delta);
        msg = "0.33 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_MILE.toSquareInches(0.33), delta);
        msg = "0.6543 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_MILE.toSquareInches(0.6543), delta);
        msg = "1 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_MILE.toSquareInches(1.0), delta);
        msg = "1.6543 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_MILE.toSquareInches(1.6543), delta);
        msg = "22.45 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_MILE.toSquareInches(22.45), delta);
        msg = "9876.5432 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_MILE.toSquareInches(9876.5432), delta);
        msg = "1987654344.3345 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_MILE.toSquareInches(1.9876543443345E9), delta);
        msg = "784.46789765434 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_MILE.toSquareInches(784.46789765434), delta);
        // ====================
        // ====================SQUARE_FOOT
        // ====================
        // to_factor = 1.0
        to_factor = SQUARE_FOOT.getFactor();
        msg = "-1 * (5280 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_MILE.toSquareFeet(-1.0), delta);
        msg = "-0.1 * (5280 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_MILE.toSquareFeet(-0.1), delta);
        msg = "-0.000456789 * (5280 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_MILE.toSquareFeet(-4.56789E-4), delta);
        msg = "-73.25 * (5280 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_MILE.toSquareFeet(-73.25), delta);
        msg = "-56229.321 * (5280 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_MILE.toSquareFeet(-56229.321), delta);
        msg = "-873.5432456 * (5280 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_MILE.toSquareFeet(-873.5432456), delta);
        msg = "0 * (5280 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_MILE.toSquareFeet(0.0), delta);
        msg = "0.1 * (5280 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_MILE.toSquareFeet(0.1), delta);
        msg = "0.0000876543297 * (5280 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_MILE.toSquareFeet(8.76543297E-5), delta);
        msg = "0.33 * (5280 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_MILE.toSquareFeet(0.33), delta);
        msg = "0.6543 * (5280 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_MILE.toSquareFeet(0.6543), delta);
        msg = "1 * (5280 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_MILE.toSquareFeet(1.0), delta);
        msg = "1.6543 * (5280 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_MILE.toSquareFeet(1.6543), delta);
        msg = "22.45 * (5280 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_MILE.toSquareFeet(22.45), delta);
        msg = "9876.5432 * (5280 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_MILE.toSquareFeet(9876.5432), delta);
        msg = "1987654344.3345 * (5280 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_MILE.toSquareFeet(1.9876543443345E9), delta);
        msg = "784.46789765434 * (5280 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_MILE.toSquareFeet(784.46789765434), delta);
        // ====================
        // ====================SQUARE_YARD
        // ====================
        // to_factor = 3.0
        to_factor = SQUARE_YARD.getFactor();
        msg = "-1 * (5280 / 3)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_MILE.toSquareYards(-1.0), delta);
        msg = "-0.1 * (5280 / 3)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_MILE.toSquareYards(-0.1), delta);
        msg = "-0.000456789 * (5280 / 3)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_MILE.toSquareYards(-4.56789E-4), delta);
        msg = "-73.25 * (5280 / 3)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_MILE.toSquareYards(-73.25), delta);
        msg = "-56229.321 * (5280 / 3)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_MILE.toSquareYards(-56229.321), delta);
        msg = "-873.5432456 * (5280 / 3)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_MILE.toSquareYards(-873.5432456), delta);
        msg = "0 * (5280 / 3)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_MILE.toSquareYards(0.0), delta);
        msg = "0.1 * (5280 / 3)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_MILE.toSquareYards(0.1), delta);
        msg = "0.0000876543297 * (5280 / 3)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_MILE.toSquareYards(8.76543297E-5), delta);
        msg = "0.33 * (5280 / 3)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_MILE.toSquareYards(0.33), delta);
        msg = "0.6543 * (5280 / 3)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_MILE.toSquareYards(0.6543), delta);
        msg = "1 * (5280 / 3)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_MILE.toSquareYards(1.0), delta);
        msg = "1.6543 * (5280 / 3)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_MILE.toSquareYards(1.6543), delta);
        msg = "22.45 * (5280 / 3)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_MILE.toSquareYards(22.45), delta);
        msg = "9876.5432 * (5280 / 3)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_MILE.toSquareYards(9876.5432), delta);
        msg = "1987654344.3345 * (5280 / 3)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_MILE.toSquareYards(1.9876543443345E9), delta);
        msg = "784.46789765434 * (5280 / 3)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_MILE.toSquareYards(784.46789765434), delta);
        // ====================
        // ====================SQUARE_CHAIN
        // ====================
        // to_factor = 66.0
        to_factor = SQUARE_CHAIN.getFactor();
        msg = "-1 * (5280 / 66)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_MILE.toSquareChains(-1.0), delta);
        msg = "-0.1 * (5280 / 66)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_MILE.toSquareChains(-0.1), delta);
        msg = "-0.000456789 * (5280 / 66)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_MILE.toSquareChains(-4.56789E-4), delta);
        msg = "-73.25 * (5280 / 66)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_MILE.toSquareChains(-73.25), delta);
        msg = "-56229.321 * (5280 / 66)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_MILE.toSquareChains(-56229.321), delta);
        msg = "-873.5432456 * (5280 / 66)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_MILE.toSquareChains(-873.5432456), delta);
        msg = "0 * (5280 / 66)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_MILE.toSquareChains(0.0), delta);
        msg = "0.1 * (5280 / 66)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_MILE.toSquareChains(0.1), delta);
        msg = "0.0000876543297 * (5280 / 66)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_MILE.toSquareChains(8.76543297E-5), delta);
        msg = "0.33 * (5280 / 66)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_MILE.toSquareChains(0.33), delta);
        msg = "0.6543 * (5280 / 66)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_MILE.toSquareChains(0.6543), delta);
        msg = "1 * (5280 / 66)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_MILE.toSquareChains(1.0), delta);
        msg = "1.6543 * (5280 / 66)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_MILE.toSquareChains(1.6543), delta);
        msg = "22.45 * (5280 / 66)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_MILE.toSquareChains(22.45), delta);
        msg = "9876.5432 * (5280 / 66)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_MILE.toSquareChains(9876.5432), delta);
        msg = "1987654344.3345 * (5280 / 66)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_MILE.toSquareChains(1.9876543443345E9), delta);
        msg = "784.46789765434 * (5280 / 66)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_MILE.toSquareChains(784.46789765434), delta);
        // ====================
        // ====================SQUARE_FURLONG
        // ====================
        // to_factor = 660.0
        to_factor = SQUARE_FURLONG.getFactor();
        msg = "-1 * (5280 / 660)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_MILE.toSquareFurlongs(-1.0), delta);
        msg = "-0.1 * (5280 / 660)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_MILE.toSquareFurlongs(-0.1), delta);
        msg = "-0.000456789 * (5280 / 660)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_MILE.toSquareFurlongs(-4.56789E-4), delta);
        msg = "-73.25 * (5280 / 660)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_MILE.toSquareFurlongs(-73.25), delta);
        msg = "-56229.321 * (5280 / 660)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_MILE.toSquareFurlongs(-56229.321), delta);
        msg = "-873.5432456 * (5280 / 660)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_MILE.toSquareFurlongs(-873.5432456), delta);
        msg = "0 * (5280 / 660)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_MILE.toSquareFurlongs(0.0), delta);
        msg = "0.1 * (5280 / 660)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_MILE.toSquareFurlongs(0.1), delta);
        msg = "0.0000876543297 * (5280 / 660)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_MILE.toSquareFurlongs(8.76543297E-5), delta);
        msg = "0.33 * (5280 / 660)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_MILE.toSquareFurlongs(0.33), delta);
        msg = "0.6543 * (5280 / 660)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_MILE.toSquareFurlongs(0.6543), delta);
        msg = "1 * (5280 / 660)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_MILE.toSquareFurlongs(1.0), delta);
        msg = "1.6543 * (5280 / 660)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_MILE.toSquareFurlongs(1.6543), delta);
        msg = "22.45 * (5280 / 660)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_MILE.toSquareFurlongs(22.45), delta);
        msg = "9876.5432 * (5280 / 660)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_MILE.toSquareFurlongs(9876.5432), delta);
        msg = "1987654344.3345 * (5280 / 660)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_MILE.toSquareFurlongs(1.9876543443345E9), delta);
        msg = "784.46789765434 * (5280 / 660)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_MILE.toSquareFurlongs(784.46789765434), delta);
        // ====================
        // ====================SQUARE_MILE
        // ====================
        // to_factor = 5280.0
        to_factor = SQUARE_MILE.getFactor();
        msg = "-1 * (5280 / 5280)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), SQUARE_MILE.toSquareMiles(-1.0), delta);
        msg = "-0.1 * (5280 / 5280)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), SQUARE_MILE.toSquareMiles(-0.1), delta);
        msg = "-0.000456789 * (5280 / 5280)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), SQUARE_MILE.toSquareMiles(-4.56789E-4), delta);
        msg = "-73.25 * (5280 / 5280)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), SQUARE_MILE.toSquareMiles(-73.25), delta);
        msg = "-56229.321 * (5280 / 5280)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), SQUARE_MILE.toSquareMiles(-56229.321), delta);
        msg = "-873.5432456 * (5280 / 5280)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), SQUARE_MILE.toSquareMiles(-873.5432456), delta);
        msg = "0 * (5280 / 5280)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), SQUARE_MILE.toSquareMiles(0.0), delta);
        msg = "0.1 * (5280 / 5280)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), SQUARE_MILE.toSquareMiles(0.1), delta);
        msg = "0.0000876543297 * (5280 / 5280)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), SQUARE_MILE.toSquareMiles(8.76543297E-5), delta);
        msg = "0.33 * (5280 / 5280)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), SQUARE_MILE.toSquareMiles(0.33), delta);
        msg = "0.6543 * (5280 / 5280)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), SQUARE_MILE.toSquareMiles(0.6543), delta);
        msg = "1 * (5280 / 5280)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), SQUARE_MILE.toSquareMiles(1.0), delta);
        msg = "1.6543 * (5280 / 5280)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), SQUARE_MILE.toSquareMiles(1.6543), delta);
        msg = "22.45 * (5280 / 5280)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), SQUARE_MILE.toSquareMiles(22.45), delta);
        msg = "9876.5432 * (5280 / 5280)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), SQUARE_MILE.toSquareMiles(9876.5432), delta);
        msg = "1987654344.3345 * (5280 / 5280)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), SQUARE_MILE.toSquareMiles(1.9876543443345E9), delta);
        msg = "784.46789765434 * (5280 / 5280)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), SQUARE_MILE.toSquareMiles(784.46789765434), delta);
    }
}
