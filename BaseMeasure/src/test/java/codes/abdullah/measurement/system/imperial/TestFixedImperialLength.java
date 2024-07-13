package codes.abdullah.measurement.system.imperial;

import static codes.abdullah.measurement.system.imperial.Imperials.CHAIN;
import static codes.abdullah.measurement.system.imperial.Imperials.FOOT;
import static codes.abdullah.measurement.system.imperial.Imperials.FURLONG;
import static codes.abdullah.measurement.system.imperial.Imperials.INCH;
import static codes.abdullah.measurement.system.imperial.Imperials.MILE;
import static codes.abdullah.measurement.system.imperial.Imperials.THOU;
import static codes.abdullah.measurement.system.imperial.Imperials.YARD;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFixedImperialLength {

    @Test()
    public void testThou() {
        // from_factor = 8.333333333333333E-5
        double from_factor = THOU.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================THOU
        // ====================
        // to_factor = 8.333333333333333E-5
        to_factor = THOU.getFactor();
        msg = "-1 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), THOU.toThous(-1.0), delta);
        msg = "-0.1 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), THOU.toThous(-0.1), delta);
        msg = "-0.000456789 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), THOU.toThous(-4.56789E-4), delta);
        msg = "-73.25 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), THOU.toThous(-73.25), delta);
        msg = "-56229.321 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), THOU.toThous(-56229.321), delta);
        msg = "-873.5432456 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), THOU.toThous(-873.5432456), delta);
        msg = "0 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), THOU.toThous(0.0), delta);
        msg = "0.1 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), THOU.toThous(0.1), delta);
        msg = "0.0000876543297 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), THOU.toThous(8.76543297E-5), delta);
        msg = "0.33 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), THOU.toThous(0.33), delta);
        msg = "0.6543 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), THOU.toThous(0.6543), delta);
        msg = "1 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), THOU.toThous(1.0), delta);
        msg = "1.6543 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), THOU.toThous(1.6543), delta);
        msg = "22.45 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), THOU.toThous(22.45), delta);
        msg = "9876.5432 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), THOU.toThous(9876.5432), delta);
        msg = "1987654344.3345 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), THOU.toThous(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.00008333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), THOU.toThous(784.46789765434), delta);
        // ====================
        // ====================INCH
        // ====================
        // to_factor = 0.08333333333333333
        to_factor = INCH.getFactor();
        msg = "-1 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), THOU.toInches(-1.0), delta);
        msg = "-0.1 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), THOU.toInches(-0.1), delta);
        msg = "-0.000456789 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), THOU.toInches(-4.56789E-4), delta);
        msg = "-73.25 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), THOU.toInches(-73.25), delta);
        msg = "-56229.321 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), THOU.toInches(-56229.321), delta);
        msg = "-873.5432456 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), THOU.toInches(-873.5432456), delta);
        msg = "0 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), THOU.toInches(0.0), delta);
        msg = "0.1 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), THOU.toInches(0.1), delta);
        msg = "0.0000876543297 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), THOU.toInches(8.76543297E-5), delta);
        msg = "0.33 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), THOU.toInches(0.33), delta);
        msg = "0.6543 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), THOU.toInches(0.6543), delta);
        msg = "1 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), THOU.toInches(1.0), delta);
        msg = "1.6543 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), THOU.toInches(1.6543), delta);
        msg = "22.45 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), THOU.toInches(22.45), delta);
        msg = "9876.5432 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), THOU.toInches(9876.5432), delta);
        msg = "1987654344.3345 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), THOU.toInches(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), THOU.toInches(784.46789765434), delta);
        // ====================
        // ====================FOOT
        // ====================
        // to_factor = 1.0
        to_factor = FOOT.getFactor();
        msg = "-1 / (1 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), THOU.toFeet(-1.0), delta);
        msg = "-0.1 / (1 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), THOU.toFeet(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), THOU.toFeet(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), THOU.toFeet(-73.25), delta);
        msg = "-56229.321 / (1 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), THOU.toFeet(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), THOU.toFeet(-873.5432456), delta);
        msg = "0 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), THOU.toFeet(0.0), delta);
        msg = "0.1 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), THOU.toFeet(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), THOU.toFeet(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), THOU.toFeet(0.33), delta);
        msg = "0.6543 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), THOU.toFeet(0.6543), delta);
        msg = "1 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), THOU.toFeet(1.0), delta);
        msg = "1.6543 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), THOU.toFeet(1.6543), delta);
        msg = "22.45 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), THOU.toFeet(22.45), delta);
        msg = "9876.5432 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), THOU.toFeet(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), THOU.toFeet(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), THOU.toFeet(784.46789765434), delta);
        // ====================
        // ====================YARD
        // ====================
        // to_factor = 3.0
        to_factor = YARD.getFactor();
        msg = "-1 / (3 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), THOU.toYards(-1.0), delta);
        msg = "-0.1 / (3 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), THOU.toYards(-0.1), delta);
        msg = "-0.000456789 / (3 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), THOU.toYards(-4.56789E-4), delta);
        msg = "-73.25 / (3 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), THOU.toYards(-73.25), delta);
        msg = "-56229.321 / (3 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), THOU.toYards(-56229.321), delta);
        msg = "-873.5432456 / (3 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), THOU.toYards(-873.5432456), delta);
        msg = "0 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), THOU.toYards(0.0), delta);
        msg = "0.1 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), THOU.toYards(0.1), delta);
        msg = "0.0000876543297 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), THOU.toYards(8.76543297E-5), delta);
        msg = "0.33 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), THOU.toYards(0.33), delta);
        msg = "0.6543 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), THOU.toYards(0.6543), delta);
        msg = "1 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), THOU.toYards(1.0), delta);
        msg = "1.6543 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), THOU.toYards(1.6543), delta);
        msg = "22.45 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), THOU.toYards(22.45), delta);
        msg = "9876.5432 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), THOU.toYards(9876.5432), delta);
        msg = "1987654344.3345 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), THOU.toYards(1.9876543443345E9), delta);
        msg = "784.46789765434 / (3 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), THOU.toYards(784.46789765434), delta);
        // ====================
        // ====================CHAIN
        // ====================
        // to_factor = 66.0
        to_factor = CHAIN.getFactor();
        msg = "-1 / (66 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), THOU.toChains(-1.0), delta);
        msg = "-0.1 / (66 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), THOU.toChains(-0.1), delta);
        msg = "-0.000456789 / (66 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), THOU.toChains(-4.56789E-4), delta);
        msg = "-73.25 / (66 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), THOU.toChains(-73.25), delta);
        msg = "-56229.321 / (66 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), THOU.toChains(-56229.321), delta);
        msg = "-873.5432456 / (66 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), THOU.toChains(-873.5432456), delta);
        msg = "0 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), THOU.toChains(0.0), delta);
        msg = "0.1 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), THOU.toChains(0.1), delta);
        msg = "0.0000876543297 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), THOU.toChains(8.76543297E-5), delta);
        msg = "0.33 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), THOU.toChains(0.33), delta);
        msg = "0.6543 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), THOU.toChains(0.6543), delta);
        msg = "1 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), THOU.toChains(1.0), delta);
        msg = "1.6543 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), THOU.toChains(1.6543), delta);
        msg = "22.45 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), THOU.toChains(22.45), delta);
        msg = "9876.5432 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), THOU.toChains(9876.5432), delta);
        msg = "1987654344.3345 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), THOU.toChains(1.9876543443345E9), delta);
        msg = "784.46789765434 / (66 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), THOU.toChains(784.46789765434), delta);
        // ====================
        // ====================FURLONG
        // ====================
        // to_factor = 660.0
        to_factor = FURLONG.getFactor();
        msg = "-1 / (660 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), THOU.toFurlongs(-1.0), delta);
        msg = "-0.1 / (660 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), THOU.toFurlongs(-0.1), delta);
        msg = "-0.000456789 / (660 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), THOU.toFurlongs(-4.56789E-4), delta);
        msg = "-73.25 / (660 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), THOU.toFurlongs(-73.25), delta);
        msg = "-56229.321 / (660 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), THOU.toFurlongs(-56229.321), delta);
        msg = "-873.5432456 / (660 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), THOU.toFurlongs(-873.5432456), delta);
        msg = "0 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), THOU.toFurlongs(0.0), delta);
        msg = "0.1 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), THOU.toFurlongs(0.1), delta);
        msg = "0.0000876543297 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), THOU.toFurlongs(8.76543297E-5), delta);
        msg = "0.33 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), THOU.toFurlongs(0.33), delta);
        msg = "0.6543 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), THOU.toFurlongs(0.6543), delta);
        msg = "1 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), THOU.toFurlongs(1.0), delta);
        msg = "1.6543 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), THOU.toFurlongs(1.6543), delta);
        msg = "22.45 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), THOU.toFurlongs(22.45), delta);
        msg = "9876.5432 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), THOU.toFurlongs(9876.5432), delta);
        msg = "1987654344.3345 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), THOU.toFurlongs(1.9876543443345E9), delta);
        msg = "784.46789765434 / (660 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), THOU.toFurlongs(784.46789765434), delta);
        // ====================
        // ====================MILE
        // ====================
        // to_factor = 5280.0
        to_factor = MILE.getFactor();
        msg = "-1 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), THOU.toMiles(-1.0), delta);
        msg = "-0.1 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), THOU.toMiles(-0.1), delta);
        msg = "-0.000456789 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), THOU.toMiles(-4.56789E-4), delta);
        msg = "-73.25 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), THOU.toMiles(-73.25), delta);
        msg = "-56229.321 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), THOU.toMiles(-56229.321), delta);
        msg = "-873.5432456 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), THOU.toMiles(-873.5432456), delta);
        msg = "0 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), THOU.toMiles(0.0), delta);
        msg = "0.1 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), THOU.toMiles(0.1), delta);
        msg = "0.0000876543297 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), THOU.toMiles(8.76543297E-5), delta);
        msg = "0.33 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), THOU.toMiles(0.33), delta);
        msg = "0.6543 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), THOU.toMiles(0.6543), delta);
        msg = "1 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), THOU.toMiles(1.0), delta);
        msg = "1.6543 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), THOU.toMiles(1.6543), delta);
        msg = "22.45 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), THOU.toMiles(22.45), delta);
        msg = "9876.5432 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), THOU.toMiles(9876.5432), delta);
        msg = "1987654344.3345 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), THOU.toMiles(1.9876543443345E9), delta);
        msg = "784.46789765434 / (5280 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), THOU.toMiles(784.46789765434), delta);
    }

    @Test()
    public void testInch() {
        // from_factor = 0.08333333333333333
        double from_factor = INCH.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================THOU
        // ====================
        // to_factor = 8.333333333333333E-5
        to_factor = THOU.getFactor();
        msg = "-1 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), INCH.toThous(-1.0), delta);
        msg = "-0.1 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), INCH.toThous(-0.1), delta);
        msg = "-0.000456789 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), INCH.toThous(-4.56789E-4), delta);
        msg = "-73.25 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), INCH.toThous(-73.25), delta);
        msg = "-56229.321 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), INCH.toThous(-56229.321), delta);
        msg = "-873.5432456 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), INCH.toThous(-873.5432456), delta);
        msg = "0 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), INCH.toThous(0.0), delta);
        msg = "0.1 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), INCH.toThous(0.1), delta);
        msg = "0.0000876543297 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), INCH.toThous(8.76543297E-5), delta);
        msg = "0.33 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), INCH.toThous(0.33), delta);
        msg = "0.6543 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), INCH.toThous(0.6543), delta);
        msg = "1 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), INCH.toThous(1.0), delta);
        msg = "1.6543 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), INCH.toThous(1.6543), delta);
        msg = "22.45 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), INCH.toThous(22.45), delta);
        msg = "9876.5432 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), INCH.toThous(9876.5432), delta);
        msg = "1987654344.3345 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), INCH.toThous(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.08333333333333333 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), INCH.toThous(784.46789765434), delta);
        // ====================
        // ====================INCH
        // ====================
        // to_factor = 0.08333333333333333
        to_factor = INCH.getFactor();
        msg = "-1 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), INCH.toInches(-1.0), delta);
        msg = "-0.1 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), INCH.toInches(-0.1), delta);
        msg = "-0.000456789 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), INCH.toInches(-4.56789E-4), delta);
        msg = "-73.25 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), INCH.toInches(-73.25), delta);
        msg = "-56229.321 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), INCH.toInches(-56229.321), delta);
        msg = "-873.5432456 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), INCH.toInches(-873.5432456), delta);
        msg = "0 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), INCH.toInches(0.0), delta);
        msg = "0.1 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), INCH.toInches(0.1), delta);
        msg = "0.0000876543297 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), INCH.toInches(8.76543297E-5), delta);
        msg = "0.33 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), INCH.toInches(0.33), delta);
        msg = "0.6543 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), INCH.toInches(0.6543), delta);
        msg = "1 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), INCH.toInches(1.0), delta);
        msg = "1.6543 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), INCH.toInches(1.6543), delta);
        msg = "22.45 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), INCH.toInches(22.45), delta);
        msg = "9876.5432 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), INCH.toInches(9876.5432), delta);
        msg = "1987654344.3345 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), INCH.toInches(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.08333333333333333 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), INCH.toInches(784.46789765434), delta);
        // ====================
        // ====================FOOT
        // ====================
        // to_factor = 1.0
        to_factor = FOOT.getFactor();
        msg = "-1 / (1 / 0.08333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), INCH.toFeet(-1.0), delta);
        msg = "-0.1 / (1 / 0.08333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), INCH.toFeet(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), INCH.toFeet(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.08333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), INCH.toFeet(-73.25), delta);
        msg = "-56229.321 / (1 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), INCH.toFeet(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), INCH.toFeet(-873.5432456), delta);
        msg = "0 / (1 / 0.08333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), INCH.toFeet(0.0), delta);
        msg = "0.1 / (1 / 0.08333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), INCH.toFeet(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), INCH.toFeet(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.08333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), INCH.toFeet(0.33), delta);
        msg = "0.6543 / (1 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), INCH.toFeet(0.6543), delta);
        msg = "1 / (1 / 0.08333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), INCH.toFeet(1.0), delta);
        msg = "1.6543 / (1 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), INCH.toFeet(1.6543), delta);
        msg = "22.45 / (1 / 0.08333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), INCH.toFeet(22.45), delta);
        msg = "9876.5432 / (1 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), INCH.toFeet(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), INCH.toFeet(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), INCH.toFeet(784.46789765434), delta);
        // ====================
        // ====================YARD
        // ====================
        // to_factor = 3.0
        to_factor = YARD.getFactor();
        msg = "-1 / (3 / 0.08333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), INCH.toYards(-1.0), delta);
        msg = "-0.1 / (3 / 0.08333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), INCH.toYards(-0.1), delta);
        msg = "-0.000456789 / (3 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), INCH.toYards(-4.56789E-4), delta);
        msg = "-73.25 / (3 / 0.08333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), INCH.toYards(-73.25), delta);
        msg = "-56229.321 / (3 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), INCH.toYards(-56229.321), delta);
        msg = "-873.5432456 / (3 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), INCH.toYards(-873.5432456), delta);
        msg = "0 / (3 / 0.08333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), INCH.toYards(0.0), delta);
        msg = "0.1 / (3 / 0.08333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), INCH.toYards(0.1), delta);
        msg = "0.0000876543297 / (3 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), INCH.toYards(8.76543297E-5), delta);
        msg = "0.33 / (3 / 0.08333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), INCH.toYards(0.33), delta);
        msg = "0.6543 / (3 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), INCH.toYards(0.6543), delta);
        msg = "1 / (3 / 0.08333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), INCH.toYards(1.0), delta);
        msg = "1.6543 / (3 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), INCH.toYards(1.6543), delta);
        msg = "22.45 / (3 / 0.08333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), INCH.toYards(22.45), delta);
        msg = "9876.5432 / (3 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), INCH.toYards(9876.5432), delta);
        msg = "1987654344.3345 / (3 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), INCH.toYards(1.9876543443345E9), delta);
        msg = "784.46789765434 / (3 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), INCH.toYards(784.46789765434), delta);
        // ====================
        // ====================CHAIN
        // ====================
        // to_factor = 66.0
        to_factor = CHAIN.getFactor();
        msg = "-1 / (66 / 0.08333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), INCH.toChains(-1.0), delta);
        msg = "-0.1 / (66 / 0.08333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), INCH.toChains(-0.1), delta);
        msg = "-0.000456789 / (66 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), INCH.toChains(-4.56789E-4), delta);
        msg = "-73.25 / (66 / 0.08333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), INCH.toChains(-73.25), delta);
        msg = "-56229.321 / (66 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), INCH.toChains(-56229.321), delta);
        msg = "-873.5432456 / (66 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), INCH.toChains(-873.5432456), delta);
        msg = "0 / (66 / 0.08333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), INCH.toChains(0.0), delta);
        msg = "0.1 / (66 / 0.08333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), INCH.toChains(0.1), delta);
        msg = "0.0000876543297 / (66 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), INCH.toChains(8.76543297E-5), delta);
        msg = "0.33 / (66 / 0.08333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), INCH.toChains(0.33), delta);
        msg = "0.6543 / (66 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), INCH.toChains(0.6543), delta);
        msg = "1 / (66 / 0.08333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), INCH.toChains(1.0), delta);
        msg = "1.6543 / (66 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), INCH.toChains(1.6543), delta);
        msg = "22.45 / (66 / 0.08333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), INCH.toChains(22.45), delta);
        msg = "9876.5432 / (66 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), INCH.toChains(9876.5432), delta);
        msg = "1987654344.3345 / (66 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), INCH.toChains(1.9876543443345E9), delta);
        msg = "784.46789765434 / (66 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), INCH.toChains(784.46789765434), delta);
        // ====================
        // ====================FURLONG
        // ====================
        // to_factor = 660.0
        to_factor = FURLONG.getFactor();
        msg = "-1 / (660 / 0.08333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), INCH.toFurlongs(-1.0), delta);
        msg = "-0.1 / (660 / 0.08333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), INCH.toFurlongs(-0.1), delta);
        msg = "-0.000456789 / (660 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), INCH.toFurlongs(-4.56789E-4), delta);
        msg = "-73.25 / (660 / 0.08333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), INCH.toFurlongs(-73.25), delta);
        msg = "-56229.321 / (660 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), INCH.toFurlongs(-56229.321), delta);
        msg = "-873.5432456 / (660 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), INCH.toFurlongs(-873.5432456), delta);
        msg = "0 / (660 / 0.08333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), INCH.toFurlongs(0.0), delta);
        msg = "0.1 / (660 / 0.08333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), INCH.toFurlongs(0.1), delta);
        msg = "0.0000876543297 / (660 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), INCH.toFurlongs(8.76543297E-5), delta);
        msg = "0.33 / (660 / 0.08333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), INCH.toFurlongs(0.33), delta);
        msg = "0.6543 / (660 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), INCH.toFurlongs(0.6543), delta);
        msg = "1 / (660 / 0.08333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), INCH.toFurlongs(1.0), delta);
        msg = "1.6543 / (660 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), INCH.toFurlongs(1.6543), delta);
        msg = "22.45 / (660 / 0.08333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), INCH.toFurlongs(22.45), delta);
        msg = "9876.5432 / (660 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), INCH.toFurlongs(9876.5432), delta);
        msg = "1987654344.3345 / (660 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), INCH.toFurlongs(1.9876543443345E9), delta);
        msg = "784.46789765434 / (660 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), INCH.toFurlongs(784.46789765434), delta);
        // ====================
        // ====================MILE
        // ====================
        // to_factor = 5280.0
        to_factor = MILE.getFactor();
        msg = "-1 / (5280 / 0.08333333333333333)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), INCH.toMiles(-1.0), delta);
        msg = "-0.1 / (5280 / 0.08333333333333333)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), INCH.toMiles(-0.1), delta);
        msg = "-0.000456789 / (5280 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), INCH.toMiles(-4.56789E-4), delta);
        msg = "-73.25 / (5280 / 0.08333333333333333)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), INCH.toMiles(-73.25), delta);
        msg = "-56229.321 / (5280 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), INCH.toMiles(-56229.321), delta);
        msg = "-873.5432456 / (5280 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), INCH.toMiles(-873.5432456), delta);
        msg = "0 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), INCH.toMiles(0.0), delta);
        msg = "0.1 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), INCH.toMiles(0.1), delta);
        msg = "0.0000876543297 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), INCH.toMiles(8.76543297E-5), delta);
        msg = "0.33 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), INCH.toMiles(0.33), delta);
        msg = "0.6543 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), INCH.toMiles(0.6543), delta);
        msg = "1 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), INCH.toMiles(1.0), delta);
        msg = "1.6543 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), INCH.toMiles(1.6543), delta);
        msg = "22.45 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), INCH.toMiles(22.45), delta);
        msg = "9876.5432 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), INCH.toMiles(9876.5432), delta);
        msg = "1987654344.3345 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), INCH.toMiles(1.9876543443345E9), delta);
        msg = "784.46789765434 / (5280 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), INCH.toMiles(784.46789765434), delta);
    }

    @Test()
    public void testFoot() {
        // from_factor = 1.0
        double from_factor = FOOT.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================THOU
        // ====================
        // to_factor = 8.333333333333333E-5
        to_factor = THOU.getFactor();
        msg = "-1 * (1 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), FOOT.toThous(-1.0), delta);
        msg = "-0.1 * (1 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), FOOT.toThous(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), FOOT.toThous(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), FOOT.toThous(-73.25), delta);
        msg = "-56229.321 * (1 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), FOOT.toThous(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), FOOT.toThous(-873.5432456), delta);
        msg = "0 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), FOOT.toThous(0.0), delta);
        msg = "0.1 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), FOOT.toThous(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), FOOT.toThous(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), FOOT.toThous(0.33), delta);
        msg = "0.6543 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), FOOT.toThous(0.6543), delta);
        msg = "1 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), FOOT.toThous(1.0), delta);
        msg = "1.6543 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), FOOT.toThous(1.6543), delta);
        msg = "22.45 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), FOOT.toThous(22.45), delta);
        msg = "9876.5432 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), FOOT.toThous(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), FOOT.toThous(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), FOOT.toThous(784.46789765434), delta);
        // ====================
        // ====================INCH
        // ====================
        // to_factor = 0.08333333333333333
        to_factor = INCH.getFactor();
        msg = "-1 * (1 / 0.08333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), FOOT.toInches(-1.0), delta);
        msg = "-0.1 * (1 / 0.08333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), FOOT.toInches(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), FOOT.toInches(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.08333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), FOOT.toInches(-73.25), delta);
        msg = "-56229.321 * (1 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), FOOT.toInches(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), FOOT.toInches(-873.5432456), delta);
        msg = "0 * (1 / 0.08333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), FOOT.toInches(0.0), delta);
        msg = "0.1 * (1 / 0.08333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), FOOT.toInches(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), FOOT.toInches(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.08333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), FOOT.toInches(0.33), delta);
        msg = "0.6543 * (1 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), FOOT.toInches(0.6543), delta);
        msg = "1 * (1 / 0.08333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), FOOT.toInches(1.0), delta);
        msg = "1.6543 * (1 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), FOOT.toInches(1.6543), delta);
        msg = "22.45 * (1 / 0.08333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), FOOT.toInches(22.45), delta);
        msg = "9876.5432 * (1 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), FOOT.toInches(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), FOOT.toInches(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), FOOT.toInches(784.46789765434), delta);
        // ====================
        // ====================FOOT
        // ====================
        // to_factor = 1.0
        to_factor = FOOT.getFactor();
        msg = "-1 * (1 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), FOOT.toFeet(-1.0), delta);
        msg = "-0.1 * (1 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), FOOT.toFeet(-0.1), delta);
        msg = "-0.000456789 * (1 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), FOOT.toFeet(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), FOOT.toFeet(-73.25), delta);
        msg = "-56229.321 * (1 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), FOOT.toFeet(-56229.321), delta);
        msg = "-873.5432456 * (1 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), FOOT.toFeet(-873.5432456), delta);
        msg = "0 * (1 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), FOOT.toFeet(0.0), delta);
        msg = "0.1 * (1 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), FOOT.toFeet(0.1), delta);
        msg = "0.0000876543297 * (1 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), FOOT.toFeet(8.76543297E-5), delta);
        msg = "0.33 * (1 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), FOOT.toFeet(0.33), delta);
        msg = "0.6543 * (1 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), FOOT.toFeet(0.6543), delta);
        msg = "1 * (1 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), FOOT.toFeet(1.0), delta);
        msg = "1.6543 * (1 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), FOOT.toFeet(1.6543), delta);
        msg = "22.45 * (1 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), FOOT.toFeet(22.45), delta);
        msg = "9876.5432 * (1 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), FOOT.toFeet(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), FOOT.toFeet(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), FOOT.toFeet(784.46789765434), delta);
        // ====================
        // ====================YARD
        // ====================
        // to_factor = 3.0
        to_factor = YARD.getFactor();
        msg = "-1 / (3 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), FOOT.toYards(-1.0), delta);
        msg = "-0.1 / (3 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), FOOT.toYards(-0.1), delta);
        msg = "-0.000456789 / (3 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), FOOT.toYards(-4.56789E-4), delta);
        msg = "-73.25 / (3 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), FOOT.toYards(-73.25), delta);
        msg = "-56229.321 / (3 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), FOOT.toYards(-56229.321), delta);
        msg = "-873.5432456 / (3 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), FOOT.toYards(-873.5432456), delta);
        msg = "0 / (3 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), FOOT.toYards(0.0), delta);
        msg = "0.1 / (3 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), FOOT.toYards(0.1), delta);
        msg = "0.0000876543297 / (3 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), FOOT.toYards(8.76543297E-5), delta);
        msg = "0.33 / (3 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), FOOT.toYards(0.33), delta);
        msg = "0.6543 / (3 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), FOOT.toYards(0.6543), delta);
        msg = "1 / (3 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), FOOT.toYards(1.0), delta);
        msg = "1.6543 / (3 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), FOOT.toYards(1.6543), delta);
        msg = "22.45 / (3 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), FOOT.toYards(22.45), delta);
        msg = "9876.5432 / (3 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), FOOT.toYards(9876.5432), delta);
        msg = "1987654344.3345 / (3 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), FOOT.toYards(1.9876543443345E9), delta);
        msg = "784.46789765434 / (3 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), FOOT.toYards(784.46789765434), delta);
        // ====================
        // ====================CHAIN
        // ====================
        // to_factor = 66.0
        to_factor = CHAIN.getFactor();
        msg = "-1 / (66 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), FOOT.toChains(-1.0), delta);
        msg = "-0.1 / (66 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), FOOT.toChains(-0.1), delta);
        msg = "-0.000456789 / (66 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), FOOT.toChains(-4.56789E-4), delta);
        msg = "-73.25 / (66 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), FOOT.toChains(-73.25), delta);
        msg = "-56229.321 / (66 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), FOOT.toChains(-56229.321), delta);
        msg = "-873.5432456 / (66 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), FOOT.toChains(-873.5432456), delta);
        msg = "0 / (66 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), FOOT.toChains(0.0), delta);
        msg = "0.1 / (66 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), FOOT.toChains(0.1), delta);
        msg = "0.0000876543297 / (66 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), FOOT.toChains(8.76543297E-5), delta);
        msg = "0.33 / (66 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), FOOT.toChains(0.33), delta);
        msg = "0.6543 / (66 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), FOOT.toChains(0.6543), delta);
        msg = "1 / (66 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), FOOT.toChains(1.0), delta);
        msg = "1.6543 / (66 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), FOOT.toChains(1.6543), delta);
        msg = "22.45 / (66 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), FOOT.toChains(22.45), delta);
        msg = "9876.5432 / (66 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), FOOT.toChains(9876.5432), delta);
        msg = "1987654344.3345 / (66 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), FOOT.toChains(1.9876543443345E9), delta);
        msg = "784.46789765434 / (66 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), FOOT.toChains(784.46789765434), delta);
        // ====================
        // ====================FURLONG
        // ====================
        // to_factor = 660.0
        to_factor = FURLONG.getFactor();
        msg = "-1 / (660 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), FOOT.toFurlongs(-1.0), delta);
        msg = "-0.1 / (660 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), FOOT.toFurlongs(-0.1), delta);
        msg = "-0.000456789 / (660 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), FOOT.toFurlongs(-4.56789E-4), delta);
        msg = "-73.25 / (660 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), FOOT.toFurlongs(-73.25), delta);
        msg = "-56229.321 / (660 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), FOOT.toFurlongs(-56229.321), delta);
        msg = "-873.5432456 / (660 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), FOOT.toFurlongs(-873.5432456), delta);
        msg = "0 / (660 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), FOOT.toFurlongs(0.0), delta);
        msg = "0.1 / (660 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), FOOT.toFurlongs(0.1), delta);
        msg = "0.0000876543297 / (660 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), FOOT.toFurlongs(8.76543297E-5), delta);
        msg = "0.33 / (660 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), FOOT.toFurlongs(0.33), delta);
        msg = "0.6543 / (660 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), FOOT.toFurlongs(0.6543), delta);
        msg = "1 / (660 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), FOOT.toFurlongs(1.0), delta);
        msg = "1.6543 / (660 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), FOOT.toFurlongs(1.6543), delta);
        msg = "22.45 / (660 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), FOOT.toFurlongs(22.45), delta);
        msg = "9876.5432 / (660 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), FOOT.toFurlongs(9876.5432), delta);
        msg = "1987654344.3345 / (660 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), FOOT.toFurlongs(1.9876543443345E9), delta);
        msg = "784.46789765434 / (660 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), FOOT.toFurlongs(784.46789765434), delta);
        // ====================
        // ====================MILE
        // ====================
        // to_factor = 5280.0
        to_factor = MILE.getFactor();
        msg = "-1 / (5280 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), FOOT.toMiles(-1.0), delta);
        msg = "-0.1 / (5280 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), FOOT.toMiles(-0.1), delta);
        msg = "-0.000456789 / (5280 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), FOOT.toMiles(-4.56789E-4), delta);
        msg = "-73.25 / (5280 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), FOOT.toMiles(-73.25), delta);
        msg = "-56229.321 / (5280 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), FOOT.toMiles(-56229.321), delta);
        msg = "-873.5432456 / (5280 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), FOOT.toMiles(-873.5432456), delta);
        msg = "0 / (5280 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), FOOT.toMiles(0.0), delta);
        msg = "0.1 / (5280 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), FOOT.toMiles(0.1), delta);
        msg = "0.0000876543297 / (5280 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), FOOT.toMiles(8.76543297E-5), delta);
        msg = "0.33 / (5280 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), FOOT.toMiles(0.33), delta);
        msg = "0.6543 / (5280 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), FOOT.toMiles(0.6543), delta);
        msg = "1 / (5280 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), FOOT.toMiles(1.0), delta);
        msg = "1.6543 / (5280 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), FOOT.toMiles(1.6543), delta);
        msg = "22.45 / (5280 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), FOOT.toMiles(22.45), delta);
        msg = "9876.5432 / (5280 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), FOOT.toMiles(9876.5432), delta);
        msg = "1987654344.3345 / (5280 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), FOOT.toMiles(1.9876543443345E9), delta);
        msg = "784.46789765434 / (5280 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), FOOT.toMiles(784.46789765434), delta);
    }

    @Test()
    public void testYard() {
        // from_factor = 3.0
        double from_factor = YARD.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================THOU
        // ====================
        // to_factor = 8.333333333333333E-5
        to_factor = THOU.getFactor();
        msg = "-1 * (3 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), YARD.toThous(-1.0), delta);
        msg = "-0.1 * (3 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), YARD.toThous(-0.1), delta);
        msg = "-0.000456789 * (3 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), YARD.toThous(-4.56789E-4), delta);
        msg = "-73.25 * (3 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), YARD.toThous(-73.25), delta);
        msg = "-56229.321 * (3 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), YARD.toThous(-56229.321), delta);
        msg = "-873.5432456 * (3 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), YARD.toThous(-873.5432456), delta);
        msg = "0 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), YARD.toThous(0.0), delta);
        msg = "0.1 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), YARD.toThous(0.1), delta);
        msg = "0.0000876543297 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), YARD.toThous(8.76543297E-5), delta);
        msg = "0.33 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), YARD.toThous(0.33), delta);
        msg = "0.6543 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), YARD.toThous(0.6543), delta);
        msg = "1 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), YARD.toThous(1.0), delta);
        msg = "1.6543 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), YARD.toThous(1.6543), delta);
        msg = "22.45 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), YARD.toThous(22.45), delta);
        msg = "9876.5432 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), YARD.toThous(9876.5432), delta);
        msg = "1987654344.3345 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), YARD.toThous(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), YARD.toThous(784.46789765434), delta);
        // ====================
        // ====================INCH
        // ====================
        // to_factor = 0.08333333333333333
        to_factor = INCH.getFactor();
        msg = "-1 * (3 / 0.08333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), YARD.toInches(-1.0), delta);
        msg = "-0.1 * (3 / 0.08333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), YARD.toInches(-0.1), delta);
        msg = "-0.000456789 * (3 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), YARD.toInches(-4.56789E-4), delta);
        msg = "-73.25 * (3 / 0.08333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), YARD.toInches(-73.25), delta);
        msg = "-56229.321 * (3 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), YARD.toInches(-56229.321), delta);
        msg = "-873.5432456 * (3 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), YARD.toInches(-873.5432456), delta);
        msg = "0 * (3 / 0.08333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), YARD.toInches(0.0), delta);
        msg = "0.1 * (3 / 0.08333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), YARD.toInches(0.1), delta);
        msg = "0.0000876543297 * (3 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), YARD.toInches(8.76543297E-5), delta);
        msg = "0.33 * (3 / 0.08333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), YARD.toInches(0.33), delta);
        msg = "0.6543 * (3 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), YARD.toInches(0.6543), delta);
        msg = "1 * (3 / 0.08333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), YARD.toInches(1.0), delta);
        msg = "1.6543 * (3 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), YARD.toInches(1.6543), delta);
        msg = "22.45 * (3 / 0.08333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), YARD.toInches(22.45), delta);
        msg = "9876.5432 * (3 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), YARD.toInches(9876.5432), delta);
        msg = "1987654344.3345 * (3 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), YARD.toInches(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), YARD.toInches(784.46789765434), delta);
        // ====================
        // ====================FOOT
        // ====================
        // to_factor = 1.0
        to_factor = FOOT.getFactor();
        msg = "-1 * (3 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), YARD.toFeet(-1.0), delta);
        msg = "-0.1 * (3 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), YARD.toFeet(-0.1), delta);
        msg = "-0.000456789 * (3 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), YARD.toFeet(-4.56789E-4), delta);
        msg = "-73.25 * (3 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), YARD.toFeet(-73.25), delta);
        msg = "-56229.321 * (3 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), YARD.toFeet(-56229.321), delta);
        msg = "-873.5432456 * (3 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), YARD.toFeet(-873.5432456), delta);
        msg = "0 * (3 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), YARD.toFeet(0.0), delta);
        msg = "0.1 * (3 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), YARD.toFeet(0.1), delta);
        msg = "0.0000876543297 * (3 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), YARD.toFeet(8.76543297E-5), delta);
        msg = "0.33 * (3 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), YARD.toFeet(0.33), delta);
        msg = "0.6543 * (3 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), YARD.toFeet(0.6543), delta);
        msg = "1 * (3 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), YARD.toFeet(1.0), delta);
        msg = "1.6543 * (3 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), YARD.toFeet(1.6543), delta);
        msg = "22.45 * (3 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), YARD.toFeet(22.45), delta);
        msg = "9876.5432 * (3 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), YARD.toFeet(9876.5432), delta);
        msg = "1987654344.3345 * (3 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), YARD.toFeet(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), YARD.toFeet(784.46789765434), delta);
        // ====================
        // ====================YARD
        // ====================
        // to_factor = 3.0
        to_factor = YARD.getFactor();
        msg = "-1 * (3 / 3)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), YARD.toYards(-1.0), delta);
        msg = "-0.1 * (3 / 3)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), YARD.toYards(-0.1), delta);
        msg = "-0.000456789 * (3 / 3)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), YARD.toYards(-4.56789E-4), delta);
        msg = "-73.25 * (3 / 3)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), YARD.toYards(-73.25), delta);
        msg = "-56229.321 * (3 / 3)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), YARD.toYards(-56229.321), delta);
        msg = "-873.5432456 * (3 / 3)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), YARD.toYards(-873.5432456), delta);
        msg = "0 * (3 / 3)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), YARD.toYards(0.0), delta);
        msg = "0.1 * (3 / 3)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), YARD.toYards(0.1), delta);
        msg = "0.0000876543297 * (3 / 3)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), YARD.toYards(8.76543297E-5), delta);
        msg = "0.33 * (3 / 3)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), YARD.toYards(0.33), delta);
        msg = "0.6543 * (3 / 3)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), YARD.toYards(0.6543), delta);
        msg = "1 * (3 / 3)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), YARD.toYards(1.0), delta);
        msg = "1.6543 * (3 / 3)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), YARD.toYards(1.6543), delta);
        msg = "22.45 * (3 / 3)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), YARD.toYards(22.45), delta);
        msg = "9876.5432 * (3 / 3)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), YARD.toYards(9876.5432), delta);
        msg = "1987654344.3345 * (3 / 3)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), YARD.toYards(1.9876543443345E9), delta);
        msg = "784.46789765434 * (3 / 3)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), YARD.toYards(784.46789765434), delta);
        // ====================
        // ====================CHAIN
        // ====================
        // to_factor = 66.0
        to_factor = CHAIN.getFactor();
        msg = "-1 / (66 / 3)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), YARD.toChains(-1.0), delta);
        msg = "-0.1 / (66 / 3)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), YARD.toChains(-0.1), delta);
        msg = "-0.000456789 / (66 / 3)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), YARD.toChains(-4.56789E-4), delta);
        msg = "-73.25 / (66 / 3)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), YARD.toChains(-73.25), delta);
        msg = "-56229.321 / (66 / 3)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), YARD.toChains(-56229.321), delta);
        msg = "-873.5432456 / (66 / 3)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), YARD.toChains(-873.5432456), delta);
        msg = "0 / (66 / 3)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), YARD.toChains(0.0), delta);
        msg = "0.1 / (66 / 3)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), YARD.toChains(0.1), delta);
        msg = "0.0000876543297 / (66 / 3)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), YARD.toChains(8.76543297E-5), delta);
        msg = "0.33 / (66 / 3)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), YARD.toChains(0.33), delta);
        msg = "0.6543 / (66 / 3)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), YARD.toChains(0.6543), delta);
        msg = "1 / (66 / 3)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), YARD.toChains(1.0), delta);
        msg = "1.6543 / (66 / 3)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), YARD.toChains(1.6543), delta);
        msg = "22.45 / (66 / 3)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), YARD.toChains(22.45), delta);
        msg = "9876.5432 / (66 / 3)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), YARD.toChains(9876.5432), delta);
        msg = "1987654344.3345 / (66 / 3)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), YARD.toChains(1.9876543443345E9), delta);
        msg = "784.46789765434 / (66 / 3)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), YARD.toChains(784.46789765434), delta);
        // ====================
        // ====================FURLONG
        // ====================
        // to_factor = 660.0
        to_factor = FURLONG.getFactor();
        msg = "-1 / (660 / 3)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), YARD.toFurlongs(-1.0), delta);
        msg = "-0.1 / (660 / 3)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), YARD.toFurlongs(-0.1), delta);
        msg = "-0.000456789 / (660 / 3)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), YARD.toFurlongs(-4.56789E-4), delta);
        msg = "-73.25 / (660 / 3)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), YARD.toFurlongs(-73.25), delta);
        msg = "-56229.321 / (660 / 3)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), YARD.toFurlongs(-56229.321), delta);
        msg = "-873.5432456 / (660 / 3)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), YARD.toFurlongs(-873.5432456), delta);
        msg = "0 / (660 / 3)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), YARD.toFurlongs(0.0), delta);
        msg = "0.1 / (660 / 3)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), YARD.toFurlongs(0.1), delta);
        msg = "0.0000876543297 / (660 / 3)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), YARD.toFurlongs(8.76543297E-5), delta);
        msg = "0.33 / (660 / 3)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), YARD.toFurlongs(0.33), delta);
        msg = "0.6543 / (660 / 3)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), YARD.toFurlongs(0.6543), delta);
        msg = "1 / (660 / 3)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), YARD.toFurlongs(1.0), delta);
        msg = "1.6543 / (660 / 3)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), YARD.toFurlongs(1.6543), delta);
        msg = "22.45 / (660 / 3)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), YARD.toFurlongs(22.45), delta);
        msg = "9876.5432 / (660 / 3)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), YARD.toFurlongs(9876.5432), delta);
        msg = "1987654344.3345 / (660 / 3)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), YARD.toFurlongs(1.9876543443345E9), delta);
        msg = "784.46789765434 / (660 / 3)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), YARD.toFurlongs(784.46789765434), delta);
        // ====================
        // ====================MILE
        // ====================
        // to_factor = 5280.0
        to_factor = MILE.getFactor();
        msg = "-1 / (5280 / 3)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), YARD.toMiles(-1.0), delta);
        msg = "-0.1 / (5280 / 3)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), YARD.toMiles(-0.1), delta);
        msg = "-0.000456789 / (5280 / 3)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), YARD.toMiles(-4.56789E-4), delta);
        msg = "-73.25 / (5280 / 3)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), YARD.toMiles(-73.25), delta);
        msg = "-56229.321 / (5280 / 3)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), YARD.toMiles(-56229.321), delta);
        msg = "-873.5432456 / (5280 / 3)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), YARD.toMiles(-873.5432456), delta);
        msg = "0 / (5280 / 3)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), YARD.toMiles(0.0), delta);
        msg = "0.1 / (5280 / 3)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), YARD.toMiles(0.1), delta);
        msg = "0.0000876543297 / (5280 / 3)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), YARD.toMiles(8.76543297E-5), delta);
        msg = "0.33 / (5280 / 3)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), YARD.toMiles(0.33), delta);
        msg = "0.6543 / (5280 / 3)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), YARD.toMiles(0.6543), delta);
        msg = "1 / (5280 / 3)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), YARD.toMiles(1.0), delta);
        msg = "1.6543 / (5280 / 3)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), YARD.toMiles(1.6543), delta);
        msg = "22.45 / (5280 / 3)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), YARD.toMiles(22.45), delta);
        msg = "9876.5432 / (5280 / 3)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), YARD.toMiles(9876.5432), delta);
        msg = "1987654344.3345 / (5280 / 3)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), YARD.toMiles(1.9876543443345E9), delta);
        msg = "784.46789765434 / (5280 / 3)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), YARD.toMiles(784.46789765434), delta);
    }

    @Test()
    public void testChain() {
        // from_factor = 66.0
        double from_factor = CHAIN.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================THOU
        // ====================
        // to_factor = 8.333333333333333E-5
        to_factor = THOU.getFactor();
        msg = "-1 * (66 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CHAIN.toThous(-1.0), delta);
        msg = "-0.1 * (66 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CHAIN.toThous(-0.1), delta);
        msg = "-0.000456789 * (66 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CHAIN.toThous(-4.56789E-4), delta);
        msg = "-73.25 * (66 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CHAIN.toThous(-73.25), delta);
        msg = "-56229.321 * (66 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CHAIN.toThous(-56229.321), delta);
        msg = "-873.5432456 * (66 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CHAIN.toThous(-873.5432456), delta);
        msg = "0 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CHAIN.toThous(0.0), delta);
        msg = "0.1 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CHAIN.toThous(0.1), delta);
        msg = "0.0000876543297 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CHAIN.toThous(8.76543297E-5), delta);
        msg = "0.33 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CHAIN.toThous(0.33), delta);
        msg = "0.6543 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CHAIN.toThous(0.6543), delta);
        msg = "1 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CHAIN.toThous(1.0), delta);
        msg = "1.6543 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CHAIN.toThous(1.6543), delta);
        msg = "22.45 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CHAIN.toThous(22.45), delta);
        msg = "9876.5432 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CHAIN.toThous(9876.5432), delta);
        msg = "1987654344.3345 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CHAIN.toThous(1.9876543443345E9), delta);
        msg = "784.46789765434 * (66 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CHAIN.toThous(784.46789765434), delta);
        // ====================
        // ====================INCH
        // ====================
        // to_factor = 0.08333333333333333
        to_factor = INCH.getFactor();
        msg = "-1 * (66 / 0.08333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CHAIN.toInches(-1.0), delta);
        msg = "-0.1 * (66 / 0.08333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CHAIN.toInches(-0.1), delta);
        msg = "-0.000456789 * (66 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CHAIN.toInches(-4.56789E-4), delta);
        msg = "-73.25 * (66 / 0.08333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CHAIN.toInches(-73.25), delta);
        msg = "-56229.321 * (66 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CHAIN.toInches(-56229.321), delta);
        msg = "-873.5432456 * (66 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CHAIN.toInches(-873.5432456), delta);
        msg = "0 * (66 / 0.08333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CHAIN.toInches(0.0), delta);
        msg = "0.1 * (66 / 0.08333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CHAIN.toInches(0.1), delta);
        msg = "0.0000876543297 * (66 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CHAIN.toInches(8.76543297E-5), delta);
        msg = "0.33 * (66 / 0.08333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CHAIN.toInches(0.33), delta);
        msg = "0.6543 * (66 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CHAIN.toInches(0.6543), delta);
        msg = "1 * (66 / 0.08333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CHAIN.toInches(1.0), delta);
        msg = "1.6543 * (66 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CHAIN.toInches(1.6543), delta);
        msg = "22.45 * (66 / 0.08333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CHAIN.toInches(22.45), delta);
        msg = "9876.5432 * (66 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CHAIN.toInches(9876.5432), delta);
        msg = "1987654344.3345 * (66 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CHAIN.toInches(1.9876543443345E9), delta);
        msg = "784.46789765434 * (66 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CHAIN.toInches(784.46789765434), delta);
        // ====================
        // ====================FOOT
        // ====================
        // to_factor = 1.0
        to_factor = FOOT.getFactor();
        msg = "-1 * (66 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CHAIN.toFeet(-1.0), delta);
        msg = "-0.1 * (66 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CHAIN.toFeet(-0.1), delta);
        msg = "-0.000456789 * (66 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CHAIN.toFeet(-4.56789E-4), delta);
        msg = "-73.25 * (66 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CHAIN.toFeet(-73.25), delta);
        msg = "-56229.321 * (66 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CHAIN.toFeet(-56229.321), delta);
        msg = "-873.5432456 * (66 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CHAIN.toFeet(-873.5432456), delta);
        msg = "0 * (66 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CHAIN.toFeet(0.0), delta);
        msg = "0.1 * (66 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CHAIN.toFeet(0.1), delta);
        msg = "0.0000876543297 * (66 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CHAIN.toFeet(8.76543297E-5), delta);
        msg = "0.33 * (66 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CHAIN.toFeet(0.33), delta);
        msg = "0.6543 * (66 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CHAIN.toFeet(0.6543), delta);
        msg = "1 * (66 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CHAIN.toFeet(1.0), delta);
        msg = "1.6543 * (66 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CHAIN.toFeet(1.6543), delta);
        msg = "22.45 * (66 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CHAIN.toFeet(22.45), delta);
        msg = "9876.5432 * (66 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CHAIN.toFeet(9876.5432), delta);
        msg = "1987654344.3345 * (66 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CHAIN.toFeet(1.9876543443345E9), delta);
        msg = "784.46789765434 * (66 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CHAIN.toFeet(784.46789765434), delta);
        // ====================
        // ====================YARD
        // ====================
        // to_factor = 3.0
        to_factor = YARD.getFactor();
        msg = "-1 * (66 / 3)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CHAIN.toYards(-1.0), delta);
        msg = "-0.1 * (66 / 3)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CHAIN.toYards(-0.1), delta);
        msg = "-0.000456789 * (66 / 3)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CHAIN.toYards(-4.56789E-4), delta);
        msg = "-73.25 * (66 / 3)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CHAIN.toYards(-73.25), delta);
        msg = "-56229.321 * (66 / 3)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CHAIN.toYards(-56229.321), delta);
        msg = "-873.5432456 * (66 / 3)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CHAIN.toYards(-873.5432456), delta);
        msg = "0 * (66 / 3)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CHAIN.toYards(0.0), delta);
        msg = "0.1 * (66 / 3)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CHAIN.toYards(0.1), delta);
        msg = "0.0000876543297 * (66 / 3)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CHAIN.toYards(8.76543297E-5), delta);
        msg = "0.33 * (66 / 3)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CHAIN.toYards(0.33), delta);
        msg = "0.6543 * (66 / 3)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CHAIN.toYards(0.6543), delta);
        msg = "1 * (66 / 3)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CHAIN.toYards(1.0), delta);
        msg = "1.6543 * (66 / 3)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CHAIN.toYards(1.6543), delta);
        msg = "22.45 * (66 / 3)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CHAIN.toYards(22.45), delta);
        msg = "9876.5432 * (66 / 3)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CHAIN.toYards(9876.5432), delta);
        msg = "1987654344.3345 * (66 / 3)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CHAIN.toYards(1.9876543443345E9), delta);
        msg = "784.46789765434 * (66 / 3)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CHAIN.toYards(784.46789765434), delta);
        // ====================
        // ====================CHAIN
        // ====================
        // to_factor = 66.0
        to_factor = CHAIN.getFactor();
        msg = "-1 * (66 / 66)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), CHAIN.toChains(-1.0), delta);
        msg = "-0.1 * (66 / 66)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), CHAIN.toChains(-0.1), delta);
        msg = "-0.000456789 * (66 / 66)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), CHAIN.toChains(-4.56789E-4), delta);
        msg = "-73.25 * (66 / 66)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), CHAIN.toChains(-73.25), delta);
        msg = "-56229.321 * (66 / 66)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), CHAIN.toChains(-56229.321), delta);
        msg = "-873.5432456 * (66 / 66)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), CHAIN.toChains(-873.5432456), delta);
        msg = "0 * (66 / 66)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), CHAIN.toChains(0.0), delta);
        msg = "0.1 * (66 / 66)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), CHAIN.toChains(0.1), delta);
        msg = "0.0000876543297 * (66 / 66)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), CHAIN.toChains(8.76543297E-5), delta);
        msg = "0.33 * (66 / 66)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), CHAIN.toChains(0.33), delta);
        msg = "0.6543 * (66 / 66)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), CHAIN.toChains(0.6543), delta);
        msg = "1 * (66 / 66)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), CHAIN.toChains(1.0), delta);
        msg = "1.6543 * (66 / 66)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), CHAIN.toChains(1.6543), delta);
        msg = "22.45 * (66 / 66)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), CHAIN.toChains(22.45), delta);
        msg = "9876.5432 * (66 / 66)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), CHAIN.toChains(9876.5432), delta);
        msg = "1987654344.3345 * (66 / 66)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), CHAIN.toChains(1.9876543443345E9), delta);
        msg = "784.46789765434 * (66 / 66)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), CHAIN.toChains(784.46789765434), delta);
        // ====================
        // ====================FURLONG
        // ====================
        // to_factor = 660.0
        to_factor = FURLONG.getFactor();
        msg = "-1 / (660 / 66)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), CHAIN.toFurlongs(-1.0), delta);
        msg = "-0.1 / (660 / 66)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), CHAIN.toFurlongs(-0.1), delta);
        msg = "-0.000456789 / (660 / 66)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), CHAIN.toFurlongs(-4.56789E-4), delta);
        msg = "-73.25 / (660 / 66)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), CHAIN.toFurlongs(-73.25), delta);
        msg = "-56229.321 / (660 / 66)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), CHAIN.toFurlongs(-56229.321), delta);
        msg = "-873.5432456 / (660 / 66)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), CHAIN.toFurlongs(-873.5432456), delta);
        msg = "0 / (660 / 66)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), CHAIN.toFurlongs(0.0), delta);
        msg = "0.1 / (660 / 66)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), CHAIN.toFurlongs(0.1), delta);
        msg = "0.0000876543297 / (660 / 66)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), CHAIN.toFurlongs(8.76543297E-5), delta);
        msg = "0.33 / (660 / 66)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), CHAIN.toFurlongs(0.33), delta);
        msg = "0.6543 / (660 / 66)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), CHAIN.toFurlongs(0.6543), delta);
        msg = "1 / (660 / 66)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), CHAIN.toFurlongs(1.0), delta);
        msg = "1.6543 / (660 / 66)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), CHAIN.toFurlongs(1.6543), delta);
        msg = "22.45 / (660 / 66)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), CHAIN.toFurlongs(22.45), delta);
        msg = "9876.5432 / (660 / 66)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), CHAIN.toFurlongs(9876.5432), delta);
        msg = "1987654344.3345 / (660 / 66)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), CHAIN.toFurlongs(1.9876543443345E9), delta);
        msg = "784.46789765434 / (660 / 66)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), CHAIN.toFurlongs(784.46789765434), delta);
        // ====================
        // ====================MILE
        // ====================
        // to_factor = 5280.0
        to_factor = MILE.getFactor();
        msg = "-1 / (5280 / 66)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), CHAIN.toMiles(-1.0), delta);
        msg = "-0.1 / (5280 / 66)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), CHAIN.toMiles(-0.1), delta);
        msg = "-0.000456789 / (5280 / 66)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), CHAIN.toMiles(-4.56789E-4), delta);
        msg = "-73.25 / (5280 / 66)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), CHAIN.toMiles(-73.25), delta);
        msg = "-56229.321 / (5280 / 66)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), CHAIN.toMiles(-56229.321), delta);
        msg = "-873.5432456 / (5280 / 66)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), CHAIN.toMiles(-873.5432456), delta);
        msg = "0 / (5280 / 66)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), CHAIN.toMiles(0.0), delta);
        msg = "0.1 / (5280 / 66)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), CHAIN.toMiles(0.1), delta);
        msg = "0.0000876543297 / (5280 / 66)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), CHAIN.toMiles(8.76543297E-5), delta);
        msg = "0.33 / (5280 / 66)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), CHAIN.toMiles(0.33), delta);
        msg = "0.6543 / (5280 / 66)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), CHAIN.toMiles(0.6543), delta);
        msg = "1 / (5280 / 66)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), CHAIN.toMiles(1.0), delta);
        msg = "1.6543 / (5280 / 66)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), CHAIN.toMiles(1.6543), delta);
        msg = "22.45 / (5280 / 66)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), CHAIN.toMiles(22.45), delta);
        msg = "9876.5432 / (5280 / 66)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), CHAIN.toMiles(9876.5432), delta);
        msg = "1987654344.3345 / (5280 / 66)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), CHAIN.toMiles(1.9876543443345E9), delta);
        msg = "784.46789765434 / (5280 / 66)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), CHAIN.toMiles(784.46789765434), delta);
    }

    @Test()
    public void testFurlong() {
        // from_factor = 660.0
        double from_factor = FURLONG.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================THOU
        // ====================
        // to_factor = 8.333333333333333E-5
        to_factor = THOU.getFactor();
        msg = "-1 * (660 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), FURLONG.toThous(-1.0), delta);
        msg = "-0.1 * (660 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), FURLONG.toThous(-0.1), delta);
        msg = "-0.000456789 * (660 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), FURLONG.toThous(-4.56789E-4), delta);
        msg = "-73.25 * (660 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), FURLONG.toThous(-73.25), delta);
        msg = "-56229.321 * (660 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), FURLONG.toThous(-56229.321), delta);
        msg = "-873.5432456 * (660 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), FURLONG.toThous(-873.5432456), delta);
        msg = "0 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), FURLONG.toThous(0.0), delta);
        msg = "0.1 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), FURLONG.toThous(0.1), delta);
        msg = "0.0000876543297 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), FURLONG.toThous(8.76543297E-5), delta);
        msg = "0.33 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), FURLONG.toThous(0.33), delta);
        msg = "0.6543 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), FURLONG.toThous(0.6543), delta);
        msg = "1 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), FURLONG.toThous(1.0), delta);
        msg = "1.6543 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), FURLONG.toThous(1.6543), delta);
        msg = "22.45 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), FURLONG.toThous(22.45), delta);
        msg = "9876.5432 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), FURLONG.toThous(9876.5432), delta);
        msg = "1987654344.3345 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), FURLONG.toThous(1.9876543443345E9), delta);
        msg = "784.46789765434 * (660 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), FURLONG.toThous(784.46789765434), delta);
        // ====================
        // ====================INCH
        // ====================
        // to_factor = 0.08333333333333333
        to_factor = INCH.getFactor();
        msg = "-1 * (660 / 0.08333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), FURLONG.toInches(-1.0), delta);
        msg = "-0.1 * (660 / 0.08333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), FURLONG.toInches(-0.1), delta);
        msg = "-0.000456789 * (660 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), FURLONG.toInches(-4.56789E-4), delta);
        msg = "-73.25 * (660 / 0.08333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), FURLONG.toInches(-73.25), delta);
        msg = "-56229.321 * (660 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), FURLONG.toInches(-56229.321), delta);
        msg = "-873.5432456 * (660 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), FURLONG.toInches(-873.5432456), delta);
        msg = "0 * (660 / 0.08333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), FURLONG.toInches(0.0), delta);
        msg = "0.1 * (660 / 0.08333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), FURLONG.toInches(0.1), delta);
        msg = "0.0000876543297 * (660 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), FURLONG.toInches(8.76543297E-5), delta);
        msg = "0.33 * (660 / 0.08333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), FURLONG.toInches(0.33), delta);
        msg = "0.6543 * (660 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), FURLONG.toInches(0.6543), delta);
        msg = "1 * (660 / 0.08333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), FURLONG.toInches(1.0), delta);
        msg = "1.6543 * (660 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), FURLONG.toInches(1.6543), delta);
        msg = "22.45 * (660 / 0.08333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), FURLONG.toInches(22.45), delta);
        msg = "9876.5432 * (660 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), FURLONG.toInches(9876.5432), delta);
        msg = "1987654344.3345 * (660 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), FURLONG.toInches(1.9876543443345E9), delta);
        msg = "784.46789765434 * (660 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), FURLONG.toInches(784.46789765434), delta);
        // ====================
        // ====================FOOT
        // ====================
        // to_factor = 1.0
        to_factor = FOOT.getFactor();
        msg = "-1 * (660 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), FURLONG.toFeet(-1.0), delta);
        msg = "-0.1 * (660 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), FURLONG.toFeet(-0.1), delta);
        msg = "-0.000456789 * (660 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), FURLONG.toFeet(-4.56789E-4), delta);
        msg = "-73.25 * (660 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), FURLONG.toFeet(-73.25), delta);
        msg = "-56229.321 * (660 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), FURLONG.toFeet(-56229.321), delta);
        msg = "-873.5432456 * (660 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), FURLONG.toFeet(-873.5432456), delta);
        msg = "0 * (660 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), FURLONG.toFeet(0.0), delta);
        msg = "0.1 * (660 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), FURLONG.toFeet(0.1), delta);
        msg = "0.0000876543297 * (660 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), FURLONG.toFeet(8.76543297E-5), delta);
        msg = "0.33 * (660 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), FURLONG.toFeet(0.33), delta);
        msg = "0.6543 * (660 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), FURLONG.toFeet(0.6543), delta);
        msg = "1 * (660 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), FURLONG.toFeet(1.0), delta);
        msg = "1.6543 * (660 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), FURLONG.toFeet(1.6543), delta);
        msg = "22.45 * (660 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), FURLONG.toFeet(22.45), delta);
        msg = "9876.5432 * (660 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), FURLONG.toFeet(9876.5432), delta);
        msg = "1987654344.3345 * (660 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), FURLONG.toFeet(1.9876543443345E9), delta);
        msg = "784.46789765434 * (660 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), FURLONG.toFeet(784.46789765434), delta);
        // ====================
        // ====================YARD
        // ====================
        // to_factor = 3.0
        to_factor = YARD.getFactor();
        msg = "-1 * (660 / 3)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), FURLONG.toYards(-1.0), delta);
        msg = "-0.1 * (660 / 3)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), FURLONG.toYards(-0.1), delta);
        msg = "-0.000456789 * (660 / 3)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), FURLONG.toYards(-4.56789E-4), delta);
        msg = "-73.25 * (660 / 3)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), FURLONG.toYards(-73.25), delta);
        msg = "-56229.321 * (660 / 3)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), FURLONG.toYards(-56229.321), delta);
        msg = "-873.5432456 * (660 / 3)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), FURLONG.toYards(-873.5432456), delta);
        msg = "0 * (660 / 3)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), FURLONG.toYards(0.0), delta);
        msg = "0.1 * (660 / 3)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), FURLONG.toYards(0.1), delta);
        msg = "0.0000876543297 * (660 / 3)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), FURLONG.toYards(8.76543297E-5), delta);
        msg = "0.33 * (660 / 3)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), FURLONG.toYards(0.33), delta);
        msg = "0.6543 * (660 / 3)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), FURLONG.toYards(0.6543), delta);
        msg = "1 * (660 / 3)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), FURLONG.toYards(1.0), delta);
        msg = "1.6543 * (660 / 3)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), FURLONG.toYards(1.6543), delta);
        msg = "22.45 * (660 / 3)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), FURLONG.toYards(22.45), delta);
        msg = "9876.5432 * (660 / 3)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), FURLONG.toYards(9876.5432), delta);
        msg = "1987654344.3345 * (660 / 3)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), FURLONG.toYards(1.9876543443345E9), delta);
        msg = "784.46789765434 * (660 / 3)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), FURLONG.toYards(784.46789765434), delta);
        // ====================
        // ====================CHAIN
        // ====================
        // to_factor = 66.0
        to_factor = CHAIN.getFactor();
        msg = "-1 * (660 / 66)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), FURLONG.toChains(-1.0), delta);
        msg = "-0.1 * (660 / 66)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), FURLONG.toChains(-0.1), delta);
        msg = "-0.000456789 * (660 / 66)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), FURLONG.toChains(-4.56789E-4), delta);
        msg = "-73.25 * (660 / 66)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), FURLONG.toChains(-73.25), delta);
        msg = "-56229.321 * (660 / 66)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), FURLONG.toChains(-56229.321), delta);
        msg = "-873.5432456 * (660 / 66)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), FURLONG.toChains(-873.5432456), delta);
        msg = "0 * (660 / 66)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), FURLONG.toChains(0.0), delta);
        msg = "0.1 * (660 / 66)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), FURLONG.toChains(0.1), delta);
        msg = "0.0000876543297 * (660 / 66)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), FURLONG.toChains(8.76543297E-5), delta);
        msg = "0.33 * (660 / 66)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), FURLONG.toChains(0.33), delta);
        msg = "0.6543 * (660 / 66)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), FURLONG.toChains(0.6543), delta);
        msg = "1 * (660 / 66)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), FURLONG.toChains(1.0), delta);
        msg = "1.6543 * (660 / 66)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), FURLONG.toChains(1.6543), delta);
        msg = "22.45 * (660 / 66)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), FURLONG.toChains(22.45), delta);
        msg = "9876.5432 * (660 / 66)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), FURLONG.toChains(9876.5432), delta);
        msg = "1987654344.3345 * (660 / 66)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), FURLONG.toChains(1.9876543443345E9), delta);
        msg = "784.46789765434 * (660 / 66)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), FURLONG.toChains(784.46789765434), delta);
        // ====================
        // ====================FURLONG
        // ====================
        // to_factor = 660.0
        to_factor = FURLONG.getFactor();
        msg = "-1 * (660 / 660)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), FURLONG.toFurlongs(-1.0), delta);
        msg = "-0.1 * (660 / 660)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), FURLONG.toFurlongs(-0.1), delta);
        msg = "-0.000456789 * (660 / 660)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), FURLONG.toFurlongs(-4.56789E-4), delta);
        msg = "-73.25 * (660 / 660)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), FURLONG.toFurlongs(-73.25), delta);
        msg = "-56229.321 * (660 / 660)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), FURLONG.toFurlongs(-56229.321), delta);
        msg = "-873.5432456 * (660 / 660)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), FURLONG.toFurlongs(-873.5432456), delta);
        msg = "0 * (660 / 660)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), FURLONG.toFurlongs(0.0), delta);
        msg = "0.1 * (660 / 660)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), FURLONG.toFurlongs(0.1), delta);
        msg = "0.0000876543297 * (660 / 660)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), FURLONG.toFurlongs(8.76543297E-5), delta);
        msg = "0.33 * (660 / 660)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), FURLONG.toFurlongs(0.33), delta);
        msg = "0.6543 * (660 / 660)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), FURLONG.toFurlongs(0.6543), delta);
        msg = "1 * (660 / 660)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), FURLONG.toFurlongs(1.0), delta);
        msg = "1.6543 * (660 / 660)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), FURLONG.toFurlongs(1.6543), delta);
        msg = "22.45 * (660 / 660)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), FURLONG.toFurlongs(22.45), delta);
        msg = "9876.5432 * (660 / 660)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), FURLONG.toFurlongs(9876.5432), delta);
        msg = "1987654344.3345 * (660 / 660)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), FURLONG.toFurlongs(1.9876543443345E9), delta);
        msg = "784.46789765434 * (660 / 660)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), FURLONG.toFurlongs(784.46789765434), delta);
        // ====================
        // ====================MILE
        // ====================
        // to_factor = 5280.0
        to_factor = MILE.getFactor();
        msg = "-1 / (5280 / 660)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), FURLONG.toMiles(-1.0), delta);
        msg = "-0.1 / (5280 / 660)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), FURLONG.toMiles(-0.1), delta);
        msg = "-0.000456789 / (5280 / 660)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), FURLONG.toMiles(-4.56789E-4), delta);
        msg = "-73.25 / (5280 / 660)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), FURLONG.toMiles(-73.25), delta);
        msg = "-56229.321 / (5280 / 660)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), FURLONG.toMiles(-56229.321), delta);
        msg = "-873.5432456 / (5280 / 660)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), FURLONG.toMiles(-873.5432456), delta);
        msg = "0 / (5280 / 660)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), FURLONG.toMiles(0.0), delta);
        msg = "0.1 / (5280 / 660)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), FURLONG.toMiles(0.1), delta);
        msg = "0.0000876543297 / (5280 / 660)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), FURLONG.toMiles(8.76543297E-5), delta);
        msg = "0.33 / (5280 / 660)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), FURLONG.toMiles(0.33), delta);
        msg = "0.6543 / (5280 / 660)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), FURLONG.toMiles(0.6543), delta);
        msg = "1 / (5280 / 660)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), FURLONG.toMiles(1.0), delta);
        msg = "1.6543 / (5280 / 660)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), FURLONG.toMiles(1.6543), delta);
        msg = "22.45 / (5280 / 660)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), FURLONG.toMiles(22.45), delta);
        msg = "9876.5432 / (5280 / 660)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), FURLONG.toMiles(9876.5432), delta);
        msg = "1987654344.3345 / (5280 / 660)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), FURLONG.toMiles(1.9876543443345E9), delta);
        msg = "784.46789765434 / (5280 / 660)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), FURLONG.toMiles(784.46789765434), delta);
    }

    @Test()
    public void testMile() {
        // from_factor = 5280.0
        double from_factor = MILE.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================THOU
        // ====================
        // to_factor = 8.333333333333333E-5
        to_factor = THOU.getFactor();
        msg = "-1 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MILE.toThous(-1.0), delta);
        msg = "-0.1 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MILE.toThous(-0.1), delta);
        msg = "-0.000456789 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MILE.toThous(-4.56789E-4), delta);
        msg = "-73.25 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MILE.toThous(-73.25), delta);
        msg = "-56229.321 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MILE.toThous(-56229.321), delta);
        msg = "-873.5432456 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MILE.toThous(-873.5432456), delta);
        msg = "0 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MILE.toThous(0.0), delta);
        msg = "0.1 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MILE.toThous(0.1), delta);
        msg = "0.0000876543297 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MILE.toThous(8.76543297E-5), delta);
        msg = "0.33 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MILE.toThous(0.33), delta);
        msg = "0.6543 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MILE.toThous(0.6543), delta);
        msg = "1 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MILE.toThous(1.0), delta);
        msg = "1.6543 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MILE.toThous(1.6543), delta);
        msg = "22.45 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MILE.toThous(22.45), delta);
        msg = "9876.5432 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MILE.toThous(9876.5432), delta);
        msg = "1987654344.3345 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MILE.toThous(1.9876543443345E9), delta);
        msg = "784.46789765434 * (5280 / 0.00008333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MILE.toThous(784.46789765434), delta);
        // ====================
        // ====================INCH
        // ====================
        // to_factor = 0.08333333333333333
        to_factor = INCH.getFactor();
        msg = "-1 * (5280 / 0.08333333333333333)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MILE.toInches(-1.0), delta);
        msg = "-0.1 * (5280 / 0.08333333333333333)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MILE.toInches(-0.1), delta);
        msg = "-0.000456789 * (5280 / 0.08333333333333333)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MILE.toInches(-4.56789E-4), delta);
        msg = "-73.25 * (5280 / 0.08333333333333333)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MILE.toInches(-73.25), delta);
        msg = "-56229.321 * (5280 / 0.08333333333333333)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MILE.toInches(-56229.321), delta);
        msg = "-873.5432456 * (5280 / 0.08333333333333333)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MILE.toInches(-873.5432456), delta);
        msg = "0 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MILE.toInches(0.0), delta);
        msg = "0.1 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MILE.toInches(0.1), delta);
        msg = "0.0000876543297 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MILE.toInches(8.76543297E-5), delta);
        msg = "0.33 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MILE.toInches(0.33), delta);
        msg = "0.6543 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MILE.toInches(0.6543), delta);
        msg = "1 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MILE.toInches(1.0), delta);
        msg = "1.6543 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MILE.toInches(1.6543), delta);
        msg = "22.45 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MILE.toInches(22.45), delta);
        msg = "9876.5432 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MILE.toInches(9876.5432), delta);
        msg = "1987654344.3345 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MILE.toInches(1.9876543443345E9), delta);
        msg = "784.46789765434 * (5280 / 0.08333333333333333)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MILE.toInches(784.46789765434), delta);
        // ====================
        // ====================FOOT
        // ====================
        // to_factor = 1.0
        to_factor = FOOT.getFactor();
        msg = "-1 * (5280 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MILE.toFeet(-1.0), delta);
        msg = "-0.1 * (5280 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MILE.toFeet(-0.1), delta);
        msg = "-0.000456789 * (5280 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MILE.toFeet(-4.56789E-4), delta);
        msg = "-73.25 * (5280 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MILE.toFeet(-73.25), delta);
        msg = "-56229.321 * (5280 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MILE.toFeet(-56229.321), delta);
        msg = "-873.5432456 * (5280 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MILE.toFeet(-873.5432456), delta);
        msg = "0 * (5280 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MILE.toFeet(0.0), delta);
        msg = "0.1 * (5280 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MILE.toFeet(0.1), delta);
        msg = "0.0000876543297 * (5280 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MILE.toFeet(8.76543297E-5), delta);
        msg = "0.33 * (5280 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MILE.toFeet(0.33), delta);
        msg = "0.6543 * (5280 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MILE.toFeet(0.6543), delta);
        msg = "1 * (5280 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MILE.toFeet(1.0), delta);
        msg = "1.6543 * (5280 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MILE.toFeet(1.6543), delta);
        msg = "22.45 * (5280 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MILE.toFeet(22.45), delta);
        msg = "9876.5432 * (5280 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MILE.toFeet(9876.5432), delta);
        msg = "1987654344.3345 * (5280 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MILE.toFeet(1.9876543443345E9), delta);
        msg = "784.46789765434 * (5280 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MILE.toFeet(784.46789765434), delta);
        // ====================
        // ====================YARD
        // ====================
        // to_factor = 3.0
        to_factor = YARD.getFactor();
        msg = "-1 * (5280 / 3)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MILE.toYards(-1.0), delta);
        msg = "-0.1 * (5280 / 3)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MILE.toYards(-0.1), delta);
        msg = "-0.000456789 * (5280 / 3)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MILE.toYards(-4.56789E-4), delta);
        msg = "-73.25 * (5280 / 3)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MILE.toYards(-73.25), delta);
        msg = "-56229.321 * (5280 / 3)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MILE.toYards(-56229.321), delta);
        msg = "-873.5432456 * (5280 / 3)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MILE.toYards(-873.5432456), delta);
        msg = "0 * (5280 / 3)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MILE.toYards(0.0), delta);
        msg = "0.1 * (5280 / 3)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MILE.toYards(0.1), delta);
        msg = "0.0000876543297 * (5280 / 3)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MILE.toYards(8.76543297E-5), delta);
        msg = "0.33 * (5280 / 3)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MILE.toYards(0.33), delta);
        msg = "0.6543 * (5280 / 3)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MILE.toYards(0.6543), delta);
        msg = "1 * (5280 / 3)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MILE.toYards(1.0), delta);
        msg = "1.6543 * (5280 / 3)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MILE.toYards(1.6543), delta);
        msg = "22.45 * (5280 / 3)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MILE.toYards(22.45), delta);
        msg = "9876.5432 * (5280 / 3)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MILE.toYards(9876.5432), delta);
        msg = "1987654344.3345 * (5280 / 3)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MILE.toYards(1.9876543443345E9), delta);
        msg = "784.46789765434 * (5280 / 3)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MILE.toYards(784.46789765434), delta);
        // ====================
        // ====================CHAIN
        // ====================
        // to_factor = 66.0
        to_factor = CHAIN.getFactor();
        msg = "-1 * (5280 / 66)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MILE.toChains(-1.0), delta);
        msg = "-0.1 * (5280 / 66)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MILE.toChains(-0.1), delta);
        msg = "-0.000456789 * (5280 / 66)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MILE.toChains(-4.56789E-4), delta);
        msg = "-73.25 * (5280 / 66)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MILE.toChains(-73.25), delta);
        msg = "-56229.321 * (5280 / 66)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MILE.toChains(-56229.321), delta);
        msg = "-873.5432456 * (5280 / 66)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MILE.toChains(-873.5432456), delta);
        msg = "0 * (5280 / 66)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MILE.toChains(0.0), delta);
        msg = "0.1 * (5280 / 66)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MILE.toChains(0.1), delta);
        msg = "0.0000876543297 * (5280 / 66)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MILE.toChains(8.76543297E-5), delta);
        msg = "0.33 * (5280 / 66)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MILE.toChains(0.33), delta);
        msg = "0.6543 * (5280 / 66)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MILE.toChains(0.6543), delta);
        msg = "1 * (5280 / 66)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MILE.toChains(1.0), delta);
        msg = "1.6543 * (5280 / 66)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MILE.toChains(1.6543), delta);
        msg = "22.45 * (5280 / 66)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MILE.toChains(22.45), delta);
        msg = "9876.5432 * (5280 / 66)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MILE.toChains(9876.5432), delta);
        msg = "1987654344.3345 * (5280 / 66)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MILE.toChains(1.9876543443345E9), delta);
        msg = "784.46789765434 * (5280 / 66)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MILE.toChains(784.46789765434), delta);
        // ====================
        // ====================FURLONG
        // ====================
        // to_factor = 660.0
        to_factor = FURLONG.getFactor();
        msg = "-1 * (5280 / 660)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MILE.toFurlongs(-1.0), delta);
        msg = "-0.1 * (5280 / 660)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MILE.toFurlongs(-0.1), delta);
        msg = "-0.000456789 * (5280 / 660)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MILE.toFurlongs(-4.56789E-4), delta);
        msg = "-73.25 * (5280 / 660)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MILE.toFurlongs(-73.25), delta);
        msg = "-56229.321 * (5280 / 660)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MILE.toFurlongs(-56229.321), delta);
        msg = "-873.5432456 * (5280 / 660)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MILE.toFurlongs(-873.5432456), delta);
        msg = "0 * (5280 / 660)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MILE.toFurlongs(0.0), delta);
        msg = "0.1 * (5280 / 660)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MILE.toFurlongs(0.1), delta);
        msg = "0.0000876543297 * (5280 / 660)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MILE.toFurlongs(8.76543297E-5), delta);
        msg = "0.33 * (5280 / 660)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MILE.toFurlongs(0.33), delta);
        msg = "0.6543 * (5280 / 660)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MILE.toFurlongs(0.6543), delta);
        msg = "1 * (5280 / 660)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MILE.toFurlongs(1.0), delta);
        msg = "1.6543 * (5280 / 660)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MILE.toFurlongs(1.6543), delta);
        msg = "22.45 * (5280 / 660)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MILE.toFurlongs(22.45), delta);
        msg = "9876.5432 * (5280 / 660)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MILE.toFurlongs(9876.5432), delta);
        msg = "1987654344.3345 * (5280 / 660)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MILE.toFurlongs(1.9876543443345E9), delta);
        msg = "784.46789765434 * (5280 / 660)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MILE.toFurlongs(784.46789765434), delta);
        // ====================
        // ====================MILE
        // ====================
        // to_factor = 5280.0
        to_factor = MILE.getFactor();
        msg = "-1 * (5280 / 5280)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MILE.toMiles(-1.0), delta);
        msg = "-0.1 * (5280 / 5280)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MILE.toMiles(-0.1), delta);
        msg = "-0.000456789 * (5280 / 5280)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MILE.toMiles(-4.56789E-4), delta);
        msg = "-73.25 * (5280 / 5280)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MILE.toMiles(-73.25), delta);
        msg = "-56229.321 * (5280 / 5280)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MILE.toMiles(-56229.321), delta);
        msg = "-873.5432456 * (5280 / 5280)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MILE.toMiles(-873.5432456), delta);
        msg = "0 * (5280 / 5280)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MILE.toMiles(0.0), delta);
        msg = "0.1 * (5280 / 5280)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MILE.toMiles(0.1), delta);
        msg = "0.0000876543297 * (5280 / 5280)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MILE.toMiles(8.76543297E-5), delta);
        msg = "0.33 * (5280 / 5280)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MILE.toMiles(0.33), delta);
        msg = "0.6543 * (5280 / 5280)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MILE.toMiles(0.6543), delta);
        msg = "1 * (5280 / 5280)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MILE.toMiles(1.0), delta);
        msg = "1.6543 * (5280 / 5280)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MILE.toMiles(1.6543), delta);
        msg = "22.45 * (5280 / 5280)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MILE.toMiles(22.45), delta);
        msg = "9876.5432 * (5280 / 5280)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MILE.toMiles(9876.5432), delta);
        msg = "1987654344.3345 * (5280 / 5280)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MILE.toMiles(1.9876543443345E9), delta);
        msg = "784.46789765434 * (5280 / 5280)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MILE.toMiles(784.46789765434), delta);
    }
}
