package codes.abdullah.measurement.system.imperial;

import static codes.abdullah.measurement.system.imperial.Imperials.FLUID_OUNCE;
import static codes.abdullah.measurement.system.imperial.Imperials.GALLON;
import static codes.abdullah.measurement.system.imperial.Imperials.GILL;
import static codes.abdullah.measurement.system.imperial.Imperials.PINT;
import static codes.abdullah.measurement.system.imperial.Imperials.QUART;
import static codes.abdullah.measurement.system.imperial.Imperials.TABLE_SPOON;
import static codes.abdullah.measurement.system.imperial.Imperials.TEA_SPOON;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFixedImperialVolume {

    @Test()
    public void testTeaSpoon() {
        // from_factor = 0.16666666666666666
        double from_factor = TEA_SPOON.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================TEA_SPOON
        // ====================
        // to_factor = 0.16666666666666666
        to_factor = TEA_SPOON.getFactor();
        msg = "-1 * (0.16666666666666666 / 0.16666666666666666)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TEA_SPOON.toTeaSpoons(-1.0), delta);
        msg = "-0.1 * (0.16666666666666666 / 0.16666666666666666)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TEA_SPOON.toTeaSpoons(-0.1), delta);
        msg = "-0.000456789 * (0.16666666666666666 / 0.16666666666666666)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TEA_SPOON.toTeaSpoons(-4.56789E-4), delta);
        msg = "-73.25 * (0.16666666666666666 / 0.16666666666666666)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TEA_SPOON.toTeaSpoons(-73.25), delta);
        msg = "-56229.321 * (0.16666666666666666 / 0.16666666666666666)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TEA_SPOON.toTeaSpoons(-56229.321), delta);
        msg = "-873.5432456 * (0.16666666666666666 / 0.16666666666666666)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TEA_SPOON.toTeaSpoons(-873.5432456), delta);
        msg = "0 * (0.16666666666666666 / 0.16666666666666666)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TEA_SPOON.toTeaSpoons(0.0), delta);
        msg = "0.1 * (0.16666666666666666 / 0.16666666666666666)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TEA_SPOON.toTeaSpoons(0.1), delta);
        msg = "0.0000876543297 * (0.16666666666666666 / 0.16666666666666666)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TEA_SPOON.toTeaSpoons(8.76543297E-5), delta);
        msg = "0.33 * (0.16666666666666666 / 0.16666666666666666)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TEA_SPOON.toTeaSpoons(0.33), delta);
        msg = "0.6543 * (0.16666666666666666 / 0.16666666666666666)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TEA_SPOON.toTeaSpoons(0.6543), delta);
        msg = "1 * (0.16666666666666666 / 0.16666666666666666)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TEA_SPOON.toTeaSpoons(1.0), delta);
        msg = "1.6543 * (0.16666666666666666 / 0.16666666666666666)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TEA_SPOON.toTeaSpoons(1.6543), delta);
        msg = "22.45 * (0.16666666666666666 / 0.16666666666666666)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TEA_SPOON.toTeaSpoons(22.45), delta);
        msg = "9876.5432 * (0.16666666666666666 / 0.16666666666666666)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TEA_SPOON.toTeaSpoons(9876.5432), delta);
        msg = "1987654344.3345 * (0.16666666666666666 / 0.16666666666666666)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TEA_SPOON.toTeaSpoons(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.16666666666666666 / 0.16666666666666666)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TEA_SPOON.toTeaSpoons(784.46789765434), delta);
        // ====================
        // ====================TABLE_SPOON
        // ====================
        // to_factor = 0.5
        to_factor = TABLE_SPOON.getFactor();
        msg = "-1 / (0.5 / 0.16666666666666666)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), TEA_SPOON.toTableSpoons(-1.0), delta);
        msg = "-0.1 / (0.5 / 0.16666666666666666)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), TEA_SPOON.toTableSpoons(-0.1), delta);
        msg = "-0.000456789 / (0.5 / 0.16666666666666666)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), TEA_SPOON.toTableSpoons(-4.56789E-4), delta);
        msg = "-73.25 / (0.5 / 0.16666666666666666)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), TEA_SPOON.toTableSpoons(-73.25), delta);
        msg = "-56229.321 / (0.5 / 0.16666666666666666)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), TEA_SPOON.toTableSpoons(-56229.321), delta);
        msg = "-873.5432456 / (0.5 / 0.16666666666666666)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), TEA_SPOON.toTableSpoons(-873.5432456), delta);
        msg = "0 / (0.5 / 0.16666666666666666)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), TEA_SPOON.toTableSpoons(0.0), delta);
        msg = "0.1 / (0.5 / 0.16666666666666666)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), TEA_SPOON.toTableSpoons(0.1), delta);
        msg = "0.0000876543297 / (0.5 / 0.16666666666666666)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), TEA_SPOON.toTableSpoons(8.76543297E-5), delta);
        msg = "0.33 / (0.5 / 0.16666666666666666)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), TEA_SPOON.toTableSpoons(0.33), delta);
        msg = "0.6543 / (0.5 / 0.16666666666666666)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), TEA_SPOON.toTableSpoons(0.6543), delta);
        msg = "1 / (0.5 / 0.16666666666666666)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), TEA_SPOON.toTableSpoons(1.0), delta);
        msg = "1.6543 / (0.5 / 0.16666666666666666)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), TEA_SPOON.toTableSpoons(1.6543), delta);
        msg = "22.45 / (0.5 / 0.16666666666666666)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), TEA_SPOON.toTableSpoons(22.45), delta);
        msg = "9876.5432 / (0.5 / 0.16666666666666666)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), TEA_SPOON.toTableSpoons(9876.5432), delta);
        msg = "1987654344.3345 / (0.5 / 0.16666666666666666)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), TEA_SPOON.toTableSpoons(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.5 / 0.16666666666666666)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), TEA_SPOON.toTableSpoons(784.46789765434), delta);
        // ====================
        // ====================FLUID_OUNCE
        // ====================
        // to_factor = 1.0
        to_factor = FLUID_OUNCE.getFactor();
        msg = "-1 / (1 / 0.16666666666666666)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), TEA_SPOON.toFluidOunces(-1.0), delta);
        msg = "-0.1 / (1 / 0.16666666666666666)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), TEA_SPOON.toFluidOunces(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.16666666666666666)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), TEA_SPOON.toFluidOunces(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.16666666666666666)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), TEA_SPOON.toFluidOunces(-73.25), delta);
        msg = "-56229.321 / (1 / 0.16666666666666666)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), TEA_SPOON.toFluidOunces(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.16666666666666666)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), TEA_SPOON.toFluidOunces(-873.5432456), delta);
        msg = "0 / (1 / 0.16666666666666666)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), TEA_SPOON.toFluidOunces(0.0), delta);
        msg = "0.1 / (1 / 0.16666666666666666)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), TEA_SPOON.toFluidOunces(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.16666666666666666)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), TEA_SPOON.toFluidOunces(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.16666666666666666)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), TEA_SPOON.toFluidOunces(0.33), delta);
        msg = "0.6543 / (1 / 0.16666666666666666)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), TEA_SPOON.toFluidOunces(0.6543), delta);
        msg = "1 / (1 / 0.16666666666666666)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), TEA_SPOON.toFluidOunces(1.0), delta);
        msg = "1.6543 / (1 / 0.16666666666666666)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), TEA_SPOON.toFluidOunces(1.6543), delta);
        msg = "22.45 / (1 / 0.16666666666666666)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), TEA_SPOON.toFluidOunces(22.45), delta);
        msg = "9876.5432 / (1 / 0.16666666666666666)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), TEA_SPOON.toFluidOunces(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.16666666666666666)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), TEA_SPOON.toFluidOunces(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.16666666666666666)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), TEA_SPOON.toFluidOunces(784.46789765434), delta);
        // ====================
        // ====================GILL
        // ====================
        // to_factor = 5.0
        to_factor = GILL.getFactor();
        msg = "-1 / (5 / 0.16666666666666666)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), TEA_SPOON.toGills(-1.0), delta);
        msg = "-0.1 / (5 / 0.16666666666666666)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), TEA_SPOON.toGills(-0.1), delta);
        msg = "-0.000456789 / (5 / 0.16666666666666666)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), TEA_SPOON.toGills(-4.56789E-4), delta);
        msg = "-73.25 / (5 / 0.16666666666666666)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), TEA_SPOON.toGills(-73.25), delta);
        msg = "-56229.321 / (5 / 0.16666666666666666)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), TEA_SPOON.toGills(-56229.321), delta);
        msg = "-873.5432456 / (5 / 0.16666666666666666)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), TEA_SPOON.toGills(-873.5432456), delta);
        msg = "0 / (5 / 0.16666666666666666)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), TEA_SPOON.toGills(0.0), delta);
        msg = "0.1 / (5 / 0.16666666666666666)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), TEA_SPOON.toGills(0.1), delta);
        msg = "0.0000876543297 / (5 / 0.16666666666666666)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), TEA_SPOON.toGills(8.76543297E-5), delta);
        msg = "0.33 / (5 / 0.16666666666666666)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), TEA_SPOON.toGills(0.33), delta);
        msg = "0.6543 / (5 / 0.16666666666666666)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), TEA_SPOON.toGills(0.6543), delta);
        msg = "1 / (5 / 0.16666666666666666)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), TEA_SPOON.toGills(1.0), delta);
        msg = "1.6543 / (5 / 0.16666666666666666)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), TEA_SPOON.toGills(1.6543), delta);
        msg = "22.45 / (5 / 0.16666666666666666)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), TEA_SPOON.toGills(22.45), delta);
        msg = "9876.5432 / (5 / 0.16666666666666666)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), TEA_SPOON.toGills(9876.5432), delta);
        msg = "1987654344.3345 / (5 / 0.16666666666666666)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), TEA_SPOON.toGills(1.9876543443345E9), delta);
        msg = "784.46789765434 / (5 / 0.16666666666666666)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), TEA_SPOON.toGills(784.46789765434), delta);
        // ====================
        // ====================PINT
        // ====================
        // to_factor = 20.0
        to_factor = PINT.getFactor();
        msg = "-1 / (20 / 0.16666666666666666)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), TEA_SPOON.toPints(-1.0), delta);
        msg = "-0.1 / (20 / 0.16666666666666666)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), TEA_SPOON.toPints(-0.1), delta);
        msg = "-0.000456789 / (20 / 0.16666666666666666)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), TEA_SPOON.toPints(-4.56789E-4), delta);
        msg = "-73.25 / (20 / 0.16666666666666666)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), TEA_SPOON.toPints(-73.25), delta);
        msg = "-56229.321 / (20 / 0.16666666666666666)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), TEA_SPOON.toPints(-56229.321), delta);
        msg = "-873.5432456 / (20 / 0.16666666666666666)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), TEA_SPOON.toPints(-873.5432456), delta);
        msg = "0 / (20 / 0.16666666666666666)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), TEA_SPOON.toPints(0.0), delta);
        msg = "0.1 / (20 / 0.16666666666666666)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), TEA_SPOON.toPints(0.1), delta);
        msg = "0.0000876543297 / (20 / 0.16666666666666666)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), TEA_SPOON.toPints(8.76543297E-5), delta);
        msg = "0.33 / (20 / 0.16666666666666666)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), TEA_SPOON.toPints(0.33), delta);
        msg = "0.6543 / (20 / 0.16666666666666666)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), TEA_SPOON.toPints(0.6543), delta);
        msg = "1 / (20 / 0.16666666666666666)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), TEA_SPOON.toPints(1.0), delta);
        msg = "1.6543 / (20 / 0.16666666666666666)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), TEA_SPOON.toPints(1.6543), delta);
        msg = "22.45 / (20 / 0.16666666666666666)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), TEA_SPOON.toPints(22.45), delta);
        msg = "9876.5432 / (20 / 0.16666666666666666)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), TEA_SPOON.toPints(9876.5432), delta);
        msg = "1987654344.3345 / (20 / 0.16666666666666666)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), TEA_SPOON.toPints(1.9876543443345E9), delta);
        msg = "784.46789765434 / (20 / 0.16666666666666666)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), TEA_SPOON.toPints(784.46789765434), delta);
        // ====================
        // ====================QUART
        // ====================
        // to_factor = 40.0
        to_factor = QUART.getFactor();
        msg = "-1 / (40 / 0.16666666666666666)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), TEA_SPOON.toQuarts(-1.0), delta);
        msg = "-0.1 / (40 / 0.16666666666666666)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), TEA_SPOON.toQuarts(-0.1), delta);
        msg = "-0.000456789 / (40 / 0.16666666666666666)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), TEA_SPOON.toQuarts(-4.56789E-4), delta);
        msg = "-73.25 / (40 / 0.16666666666666666)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), TEA_SPOON.toQuarts(-73.25), delta);
        msg = "-56229.321 / (40 / 0.16666666666666666)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), TEA_SPOON.toQuarts(-56229.321), delta);
        msg = "-873.5432456 / (40 / 0.16666666666666666)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), TEA_SPOON.toQuarts(-873.5432456), delta);
        msg = "0 / (40 / 0.16666666666666666)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), TEA_SPOON.toQuarts(0.0), delta);
        msg = "0.1 / (40 / 0.16666666666666666)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), TEA_SPOON.toQuarts(0.1), delta);
        msg = "0.0000876543297 / (40 / 0.16666666666666666)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), TEA_SPOON.toQuarts(8.76543297E-5), delta);
        msg = "0.33 / (40 / 0.16666666666666666)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), TEA_SPOON.toQuarts(0.33), delta);
        msg = "0.6543 / (40 / 0.16666666666666666)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), TEA_SPOON.toQuarts(0.6543), delta);
        msg = "1 / (40 / 0.16666666666666666)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), TEA_SPOON.toQuarts(1.0), delta);
        msg = "1.6543 / (40 / 0.16666666666666666)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), TEA_SPOON.toQuarts(1.6543), delta);
        msg = "22.45 / (40 / 0.16666666666666666)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), TEA_SPOON.toQuarts(22.45), delta);
        msg = "9876.5432 / (40 / 0.16666666666666666)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), TEA_SPOON.toQuarts(9876.5432), delta);
        msg = "1987654344.3345 / (40 / 0.16666666666666666)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), TEA_SPOON.toQuarts(1.9876543443345E9), delta);
        msg = "784.46789765434 / (40 / 0.16666666666666666)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), TEA_SPOON.toQuarts(784.46789765434), delta);
        // ====================
        // ====================GALLON
        // ====================
        // to_factor = 160.0
        to_factor = GALLON.getFactor();
        msg = "-1 / (160 / 0.16666666666666666)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), TEA_SPOON.toGallons(-1.0), delta);
        msg = "-0.1 / (160 / 0.16666666666666666)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), TEA_SPOON.toGallons(-0.1), delta);
        msg = "-0.000456789 / (160 / 0.16666666666666666)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), TEA_SPOON.toGallons(-4.56789E-4), delta);
        msg = "-73.25 / (160 / 0.16666666666666666)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), TEA_SPOON.toGallons(-73.25), delta);
        msg = "-56229.321 / (160 / 0.16666666666666666)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), TEA_SPOON.toGallons(-56229.321), delta);
        msg = "-873.5432456 / (160 / 0.16666666666666666)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), TEA_SPOON.toGallons(-873.5432456), delta);
        msg = "0 / (160 / 0.16666666666666666)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), TEA_SPOON.toGallons(0.0), delta);
        msg = "0.1 / (160 / 0.16666666666666666)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), TEA_SPOON.toGallons(0.1), delta);
        msg = "0.0000876543297 / (160 / 0.16666666666666666)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), TEA_SPOON.toGallons(8.76543297E-5), delta);
        msg = "0.33 / (160 / 0.16666666666666666)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), TEA_SPOON.toGallons(0.33), delta);
        msg = "0.6543 / (160 / 0.16666666666666666)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), TEA_SPOON.toGallons(0.6543), delta);
        msg = "1 / (160 / 0.16666666666666666)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), TEA_SPOON.toGallons(1.0), delta);
        msg = "1.6543 / (160 / 0.16666666666666666)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), TEA_SPOON.toGallons(1.6543), delta);
        msg = "22.45 / (160 / 0.16666666666666666)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), TEA_SPOON.toGallons(22.45), delta);
        msg = "9876.5432 / (160 / 0.16666666666666666)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), TEA_SPOON.toGallons(9876.5432), delta);
        msg = "1987654344.3345 / (160 / 0.16666666666666666)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), TEA_SPOON.toGallons(1.9876543443345E9), delta);
        msg = "784.46789765434 / (160 / 0.16666666666666666)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), TEA_SPOON.toGallons(784.46789765434), delta);
    }

    @Test()
    public void testTableSpoon() {
        // from_factor = 0.5
        double from_factor = TABLE_SPOON.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================TEA_SPOON
        // ====================
        // to_factor = 0.16666666666666666
        to_factor = TEA_SPOON.getFactor();
        msg = "-1 * (0.5 / 0.16666666666666666)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TABLE_SPOON.toTeaSpoons(-1.0), delta);
        msg = "-0.1 * (0.5 / 0.16666666666666666)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TABLE_SPOON.toTeaSpoons(-0.1), delta);
        msg = "-0.000456789 * (0.5 / 0.16666666666666666)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TABLE_SPOON.toTeaSpoons(-4.56789E-4), delta);
        msg = "-73.25 * (0.5 / 0.16666666666666666)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TABLE_SPOON.toTeaSpoons(-73.25), delta);
        msg = "-56229.321 * (0.5 / 0.16666666666666666)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TABLE_SPOON.toTeaSpoons(-56229.321), delta);
        msg = "-873.5432456 * (0.5 / 0.16666666666666666)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TABLE_SPOON.toTeaSpoons(-873.5432456), delta);
        msg = "0 * (0.5 / 0.16666666666666666)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TABLE_SPOON.toTeaSpoons(0.0), delta);
        msg = "0.1 * (0.5 / 0.16666666666666666)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TABLE_SPOON.toTeaSpoons(0.1), delta);
        msg = "0.0000876543297 * (0.5 / 0.16666666666666666)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TABLE_SPOON.toTeaSpoons(8.76543297E-5), delta);
        msg = "0.33 * (0.5 / 0.16666666666666666)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TABLE_SPOON.toTeaSpoons(0.33), delta);
        msg = "0.6543 * (0.5 / 0.16666666666666666)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TABLE_SPOON.toTeaSpoons(0.6543), delta);
        msg = "1 * (0.5 / 0.16666666666666666)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TABLE_SPOON.toTeaSpoons(1.0), delta);
        msg = "1.6543 * (0.5 / 0.16666666666666666)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TABLE_SPOON.toTeaSpoons(1.6543), delta);
        msg = "22.45 * (0.5 / 0.16666666666666666)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TABLE_SPOON.toTeaSpoons(22.45), delta);
        msg = "9876.5432 * (0.5 / 0.16666666666666666)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TABLE_SPOON.toTeaSpoons(9876.5432), delta);
        msg = "1987654344.3345 * (0.5 / 0.16666666666666666)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TABLE_SPOON.toTeaSpoons(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.5 / 0.16666666666666666)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TABLE_SPOON.toTeaSpoons(784.46789765434), delta);
        // ====================
        // ====================TABLE_SPOON
        // ====================
        // to_factor = 0.5
        to_factor = TABLE_SPOON.getFactor();
        msg = "-1 * (0.5 / 0.5)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TABLE_SPOON.toTableSpoons(-1.0), delta);
        msg = "-0.1 * (0.5 / 0.5)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TABLE_SPOON.toTableSpoons(-0.1), delta);
        msg = "-0.000456789 * (0.5 / 0.5)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TABLE_SPOON.toTableSpoons(-4.56789E-4), delta);
        msg = "-73.25 * (0.5 / 0.5)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TABLE_SPOON.toTableSpoons(-73.25), delta);
        msg = "-56229.321 * (0.5 / 0.5)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TABLE_SPOON.toTableSpoons(-56229.321), delta);
        msg = "-873.5432456 * (0.5 / 0.5)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TABLE_SPOON.toTableSpoons(-873.5432456), delta);
        msg = "0 * (0.5 / 0.5)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TABLE_SPOON.toTableSpoons(0.0), delta);
        msg = "0.1 * (0.5 / 0.5)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TABLE_SPOON.toTableSpoons(0.1), delta);
        msg = "0.0000876543297 * (0.5 / 0.5)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TABLE_SPOON.toTableSpoons(8.76543297E-5), delta);
        msg = "0.33 * (0.5 / 0.5)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TABLE_SPOON.toTableSpoons(0.33), delta);
        msg = "0.6543 * (0.5 / 0.5)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TABLE_SPOON.toTableSpoons(0.6543), delta);
        msg = "1 * (0.5 / 0.5)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TABLE_SPOON.toTableSpoons(1.0), delta);
        msg = "1.6543 * (0.5 / 0.5)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TABLE_SPOON.toTableSpoons(1.6543), delta);
        msg = "22.45 * (0.5 / 0.5)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TABLE_SPOON.toTableSpoons(22.45), delta);
        msg = "9876.5432 * (0.5 / 0.5)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TABLE_SPOON.toTableSpoons(9876.5432), delta);
        msg = "1987654344.3345 * (0.5 / 0.5)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TABLE_SPOON.toTableSpoons(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.5 / 0.5)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TABLE_SPOON.toTableSpoons(784.46789765434), delta);
        // ====================
        // ====================FLUID_OUNCE
        // ====================
        // to_factor = 1.0
        to_factor = FLUID_OUNCE.getFactor();
        msg = "-1 / (1 / 0.5)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), TABLE_SPOON.toFluidOunces(-1.0), delta);
        msg = "-0.1 / (1 / 0.5)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), TABLE_SPOON.toFluidOunces(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.5)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), TABLE_SPOON.toFluidOunces(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.5)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), TABLE_SPOON.toFluidOunces(-73.25), delta);
        msg = "-56229.321 / (1 / 0.5)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), TABLE_SPOON.toFluidOunces(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.5)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), TABLE_SPOON.toFluidOunces(-873.5432456), delta);
        msg = "0 / (1 / 0.5)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), TABLE_SPOON.toFluidOunces(0.0), delta);
        msg = "0.1 / (1 / 0.5)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), TABLE_SPOON.toFluidOunces(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.5)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), TABLE_SPOON.toFluidOunces(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.5)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), TABLE_SPOON.toFluidOunces(0.33), delta);
        msg = "0.6543 / (1 / 0.5)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), TABLE_SPOON.toFluidOunces(0.6543), delta);
        msg = "1 / (1 / 0.5)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), TABLE_SPOON.toFluidOunces(1.0), delta);
        msg = "1.6543 / (1 / 0.5)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), TABLE_SPOON.toFluidOunces(1.6543), delta);
        msg = "22.45 / (1 / 0.5)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), TABLE_SPOON.toFluidOunces(22.45), delta);
        msg = "9876.5432 / (1 / 0.5)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), TABLE_SPOON.toFluidOunces(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.5)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), TABLE_SPOON.toFluidOunces(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.5)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), TABLE_SPOON.toFluidOunces(784.46789765434), delta);
        // ====================
        // ====================GILL
        // ====================
        // to_factor = 5.0
        to_factor = GILL.getFactor();
        msg = "-1 / (5 / 0.5)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), TABLE_SPOON.toGills(-1.0), delta);
        msg = "-0.1 / (5 / 0.5)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), TABLE_SPOON.toGills(-0.1), delta);
        msg = "-0.000456789 / (5 / 0.5)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), TABLE_SPOON.toGills(-4.56789E-4), delta);
        msg = "-73.25 / (5 / 0.5)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), TABLE_SPOON.toGills(-73.25), delta);
        msg = "-56229.321 / (5 / 0.5)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), TABLE_SPOON.toGills(-56229.321), delta);
        msg = "-873.5432456 / (5 / 0.5)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), TABLE_SPOON.toGills(-873.5432456), delta);
        msg = "0 / (5 / 0.5)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), TABLE_SPOON.toGills(0.0), delta);
        msg = "0.1 / (5 / 0.5)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), TABLE_SPOON.toGills(0.1), delta);
        msg = "0.0000876543297 / (5 / 0.5)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), TABLE_SPOON.toGills(8.76543297E-5), delta);
        msg = "0.33 / (5 / 0.5)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), TABLE_SPOON.toGills(0.33), delta);
        msg = "0.6543 / (5 / 0.5)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), TABLE_SPOON.toGills(0.6543), delta);
        msg = "1 / (5 / 0.5)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), TABLE_SPOON.toGills(1.0), delta);
        msg = "1.6543 / (5 / 0.5)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), TABLE_SPOON.toGills(1.6543), delta);
        msg = "22.45 / (5 / 0.5)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), TABLE_SPOON.toGills(22.45), delta);
        msg = "9876.5432 / (5 / 0.5)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), TABLE_SPOON.toGills(9876.5432), delta);
        msg = "1987654344.3345 / (5 / 0.5)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), TABLE_SPOON.toGills(1.9876543443345E9), delta);
        msg = "784.46789765434 / (5 / 0.5)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), TABLE_SPOON.toGills(784.46789765434), delta);
        // ====================
        // ====================PINT
        // ====================
        // to_factor = 20.0
        to_factor = PINT.getFactor();
        msg = "-1 / (20 / 0.5)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), TABLE_SPOON.toPints(-1.0), delta);
        msg = "-0.1 / (20 / 0.5)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), TABLE_SPOON.toPints(-0.1), delta);
        msg = "-0.000456789 / (20 / 0.5)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), TABLE_SPOON.toPints(-4.56789E-4), delta);
        msg = "-73.25 / (20 / 0.5)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), TABLE_SPOON.toPints(-73.25), delta);
        msg = "-56229.321 / (20 / 0.5)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), TABLE_SPOON.toPints(-56229.321), delta);
        msg = "-873.5432456 / (20 / 0.5)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), TABLE_SPOON.toPints(-873.5432456), delta);
        msg = "0 / (20 / 0.5)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), TABLE_SPOON.toPints(0.0), delta);
        msg = "0.1 / (20 / 0.5)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), TABLE_SPOON.toPints(0.1), delta);
        msg = "0.0000876543297 / (20 / 0.5)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), TABLE_SPOON.toPints(8.76543297E-5), delta);
        msg = "0.33 / (20 / 0.5)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), TABLE_SPOON.toPints(0.33), delta);
        msg = "0.6543 / (20 / 0.5)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), TABLE_SPOON.toPints(0.6543), delta);
        msg = "1 / (20 / 0.5)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), TABLE_SPOON.toPints(1.0), delta);
        msg = "1.6543 / (20 / 0.5)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), TABLE_SPOON.toPints(1.6543), delta);
        msg = "22.45 / (20 / 0.5)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), TABLE_SPOON.toPints(22.45), delta);
        msg = "9876.5432 / (20 / 0.5)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), TABLE_SPOON.toPints(9876.5432), delta);
        msg = "1987654344.3345 / (20 / 0.5)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), TABLE_SPOON.toPints(1.9876543443345E9), delta);
        msg = "784.46789765434 / (20 / 0.5)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), TABLE_SPOON.toPints(784.46789765434), delta);
        // ====================
        // ====================QUART
        // ====================
        // to_factor = 40.0
        to_factor = QUART.getFactor();
        msg = "-1 / (40 / 0.5)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), TABLE_SPOON.toQuarts(-1.0), delta);
        msg = "-0.1 / (40 / 0.5)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), TABLE_SPOON.toQuarts(-0.1), delta);
        msg = "-0.000456789 / (40 / 0.5)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), TABLE_SPOON.toQuarts(-4.56789E-4), delta);
        msg = "-73.25 / (40 / 0.5)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), TABLE_SPOON.toQuarts(-73.25), delta);
        msg = "-56229.321 / (40 / 0.5)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), TABLE_SPOON.toQuarts(-56229.321), delta);
        msg = "-873.5432456 / (40 / 0.5)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), TABLE_SPOON.toQuarts(-873.5432456), delta);
        msg = "0 / (40 / 0.5)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), TABLE_SPOON.toQuarts(0.0), delta);
        msg = "0.1 / (40 / 0.5)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), TABLE_SPOON.toQuarts(0.1), delta);
        msg = "0.0000876543297 / (40 / 0.5)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), TABLE_SPOON.toQuarts(8.76543297E-5), delta);
        msg = "0.33 / (40 / 0.5)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), TABLE_SPOON.toQuarts(0.33), delta);
        msg = "0.6543 / (40 / 0.5)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), TABLE_SPOON.toQuarts(0.6543), delta);
        msg = "1 / (40 / 0.5)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), TABLE_SPOON.toQuarts(1.0), delta);
        msg = "1.6543 / (40 / 0.5)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), TABLE_SPOON.toQuarts(1.6543), delta);
        msg = "22.45 / (40 / 0.5)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), TABLE_SPOON.toQuarts(22.45), delta);
        msg = "9876.5432 / (40 / 0.5)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), TABLE_SPOON.toQuarts(9876.5432), delta);
        msg = "1987654344.3345 / (40 / 0.5)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), TABLE_SPOON.toQuarts(1.9876543443345E9), delta);
        msg = "784.46789765434 / (40 / 0.5)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), TABLE_SPOON.toQuarts(784.46789765434), delta);
        // ====================
        // ====================GALLON
        // ====================
        // to_factor = 160.0
        to_factor = GALLON.getFactor();
        msg = "-1 / (160 / 0.5)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), TABLE_SPOON.toGallons(-1.0), delta);
        msg = "-0.1 / (160 / 0.5)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), TABLE_SPOON.toGallons(-0.1), delta);
        msg = "-0.000456789 / (160 / 0.5)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), TABLE_SPOON.toGallons(-4.56789E-4), delta);
        msg = "-73.25 / (160 / 0.5)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), TABLE_SPOON.toGallons(-73.25), delta);
        msg = "-56229.321 / (160 / 0.5)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), TABLE_SPOON.toGallons(-56229.321), delta);
        msg = "-873.5432456 / (160 / 0.5)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), TABLE_SPOON.toGallons(-873.5432456), delta);
        msg = "0 / (160 / 0.5)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), TABLE_SPOON.toGallons(0.0), delta);
        msg = "0.1 / (160 / 0.5)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), TABLE_SPOON.toGallons(0.1), delta);
        msg = "0.0000876543297 / (160 / 0.5)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), TABLE_SPOON.toGallons(8.76543297E-5), delta);
        msg = "0.33 / (160 / 0.5)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), TABLE_SPOON.toGallons(0.33), delta);
        msg = "0.6543 / (160 / 0.5)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), TABLE_SPOON.toGallons(0.6543), delta);
        msg = "1 / (160 / 0.5)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), TABLE_SPOON.toGallons(1.0), delta);
        msg = "1.6543 / (160 / 0.5)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), TABLE_SPOON.toGallons(1.6543), delta);
        msg = "22.45 / (160 / 0.5)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), TABLE_SPOON.toGallons(22.45), delta);
        msg = "9876.5432 / (160 / 0.5)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), TABLE_SPOON.toGallons(9876.5432), delta);
        msg = "1987654344.3345 / (160 / 0.5)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), TABLE_SPOON.toGallons(1.9876543443345E9), delta);
        msg = "784.46789765434 / (160 / 0.5)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), TABLE_SPOON.toGallons(784.46789765434), delta);
    }

    @Test()
    public void testFluidOunce() {
        // from_factor = 1.0
        double from_factor = FLUID_OUNCE.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================TEA_SPOON
        // ====================
        // to_factor = 0.16666666666666666
        to_factor = TEA_SPOON.getFactor();
        msg = "-1 * (1 / 0.16666666666666666)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), FLUID_OUNCE.toTeaSpoons(-1.0), delta);
        msg = "-0.1 * (1 / 0.16666666666666666)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), FLUID_OUNCE.toTeaSpoons(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.16666666666666666)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), FLUID_OUNCE.toTeaSpoons(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.16666666666666666)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), FLUID_OUNCE.toTeaSpoons(-73.25), delta);
        msg = "-56229.321 * (1 / 0.16666666666666666)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), FLUID_OUNCE.toTeaSpoons(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.16666666666666666)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), FLUID_OUNCE.toTeaSpoons(-873.5432456), delta);
        msg = "0 * (1 / 0.16666666666666666)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), FLUID_OUNCE.toTeaSpoons(0.0), delta);
        msg = "0.1 * (1 / 0.16666666666666666)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), FLUID_OUNCE.toTeaSpoons(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.16666666666666666)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), FLUID_OUNCE.toTeaSpoons(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.16666666666666666)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), FLUID_OUNCE.toTeaSpoons(0.33), delta);
        msg = "0.6543 * (1 / 0.16666666666666666)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), FLUID_OUNCE.toTeaSpoons(0.6543), delta);
        msg = "1 * (1 / 0.16666666666666666)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), FLUID_OUNCE.toTeaSpoons(1.0), delta);
        msg = "1.6543 * (1 / 0.16666666666666666)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), FLUID_OUNCE.toTeaSpoons(1.6543), delta);
        msg = "22.45 * (1 / 0.16666666666666666)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), FLUID_OUNCE.toTeaSpoons(22.45), delta);
        msg = "9876.5432 * (1 / 0.16666666666666666)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), FLUID_OUNCE.toTeaSpoons(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.16666666666666666)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), FLUID_OUNCE.toTeaSpoons(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.16666666666666666)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), FLUID_OUNCE.toTeaSpoons(784.46789765434), delta);
        // ====================
        // ====================TABLE_SPOON
        // ====================
        // to_factor = 0.5
        to_factor = TABLE_SPOON.getFactor();
        msg = "-1 * (1 / 0.5)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), FLUID_OUNCE.toTableSpoons(-1.0), delta);
        msg = "-0.1 * (1 / 0.5)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), FLUID_OUNCE.toTableSpoons(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.5)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), FLUID_OUNCE.toTableSpoons(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.5)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), FLUID_OUNCE.toTableSpoons(-73.25), delta);
        msg = "-56229.321 * (1 / 0.5)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), FLUID_OUNCE.toTableSpoons(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.5)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), FLUID_OUNCE.toTableSpoons(-873.5432456), delta);
        msg = "0 * (1 / 0.5)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), FLUID_OUNCE.toTableSpoons(0.0), delta);
        msg = "0.1 * (1 / 0.5)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), FLUID_OUNCE.toTableSpoons(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.5)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), FLUID_OUNCE.toTableSpoons(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.5)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), FLUID_OUNCE.toTableSpoons(0.33), delta);
        msg = "0.6543 * (1 / 0.5)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), FLUID_OUNCE.toTableSpoons(0.6543), delta);
        msg = "1 * (1 / 0.5)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), FLUID_OUNCE.toTableSpoons(1.0), delta);
        msg = "1.6543 * (1 / 0.5)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), FLUID_OUNCE.toTableSpoons(1.6543), delta);
        msg = "22.45 * (1 / 0.5)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), FLUID_OUNCE.toTableSpoons(22.45), delta);
        msg = "9876.5432 * (1 / 0.5)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), FLUID_OUNCE.toTableSpoons(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.5)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), FLUID_OUNCE.toTableSpoons(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.5)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), FLUID_OUNCE.toTableSpoons(784.46789765434), delta);
        // ====================
        // ====================FLUID_OUNCE
        // ====================
        // to_factor = 1.0
        to_factor = FLUID_OUNCE.getFactor();
        msg = "-1 * (1 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), FLUID_OUNCE.toFluidOunces(-1.0), delta);
        msg = "-0.1 * (1 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), FLUID_OUNCE.toFluidOunces(-0.1), delta);
        msg = "-0.000456789 * (1 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), FLUID_OUNCE.toFluidOunces(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), FLUID_OUNCE.toFluidOunces(-73.25), delta);
        msg = "-56229.321 * (1 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), FLUID_OUNCE.toFluidOunces(-56229.321), delta);
        msg = "-873.5432456 * (1 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), FLUID_OUNCE.toFluidOunces(-873.5432456), delta);
        msg = "0 * (1 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), FLUID_OUNCE.toFluidOunces(0.0), delta);
        msg = "0.1 * (1 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), FLUID_OUNCE.toFluidOunces(0.1), delta);
        msg = "0.0000876543297 * (1 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), FLUID_OUNCE.toFluidOunces(8.76543297E-5), delta);
        msg = "0.33 * (1 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), FLUID_OUNCE.toFluidOunces(0.33), delta);
        msg = "0.6543 * (1 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), FLUID_OUNCE.toFluidOunces(0.6543), delta);
        msg = "1 * (1 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), FLUID_OUNCE.toFluidOunces(1.0), delta);
        msg = "1.6543 * (1 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), FLUID_OUNCE.toFluidOunces(1.6543), delta);
        msg = "22.45 * (1 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), FLUID_OUNCE.toFluidOunces(22.45), delta);
        msg = "9876.5432 * (1 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), FLUID_OUNCE.toFluidOunces(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), FLUID_OUNCE.toFluidOunces(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), FLUID_OUNCE.toFluidOunces(784.46789765434), delta);
        // ====================
        // ====================GILL
        // ====================
        // to_factor = 5.0
        to_factor = GILL.getFactor();
        msg = "-1 / (5 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), FLUID_OUNCE.toGills(-1.0), delta);
        msg = "-0.1 / (5 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), FLUID_OUNCE.toGills(-0.1), delta);
        msg = "-0.000456789 / (5 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), FLUID_OUNCE.toGills(-4.56789E-4), delta);
        msg = "-73.25 / (5 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), FLUID_OUNCE.toGills(-73.25), delta);
        msg = "-56229.321 / (5 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), FLUID_OUNCE.toGills(-56229.321), delta);
        msg = "-873.5432456 / (5 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), FLUID_OUNCE.toGills(-873.5432456), delta);
        msg = "0 / (5 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), FLUID_OUNCE.toGills(0.0), delta);
        msg = "0.1 / (5 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), FLUID_OUNCE.toGills(0.1), delta);
        msg = "0.0000876543297 / (5 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), FLUID_OUNCE.toGills(8.76543297E-5), delta);
        msg = "0.33 / (5 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), FLUID_OUNCE.toGills(0.33), delta);
        msg = "0.6543 / (5 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), FLUID_OUNCE.toGills(0.6543), delta);
        msg = "1 / (5 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), FLUID_OUNCE.toGills(1.0), delta);
        msg = "1.6543 / (5 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), FLUID_OUNCE.toGills(1.6543), delta);
        msg = "22.45 / (5 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), FLUID_OUNCE.toGills(22.45), delta);
        msg = "9876.5432 / (5 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), FLUID_OUNCE.toGills(9876.5432), delta);
        msg = "1987654344.3345 / (5 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), FLUID_OUNCE.toGills(1.9876543443345E9), delta);
        msg = "784.46789765434 / (5 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), FLUID_OUNCE.toGills(784.46789765434), delta);
        // ====================
        // ====================PINT
        // ====================
        // to_factor = 20.0
        to_factor = PINT.getFactor();
        msg = "-1 / (20 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), FLUID_OUNCE.toPints(-1.0), delta);
        msg = "-0.1 / (20 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), FLUID_OUNCE.toPints(-0.1), delta);
        msg = "-0.000456789 / (20 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), FLUID_OUNCE.toPints(-4.56789E-4), delta);
        msg = "-73.25 / (20 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), FLUID_OUNCE.toPints(-73.25), delta);
        msg = "-56229.321 / (20 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), FLUID_OUNCE.toPints(-56229.321), delta);
        msg = "-873.5432456 / (20 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), FLUID_OUNCE.toPints(-873.5432456), delta);
        msg = "0 / (20 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), FLUID_OUNCE.toPints(0.0), delta);
        msg = "0.1 / (20 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), FLUID_OUNCE.toPints(0.1), delta);
        msg = "0.0000876543297 / (20 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), FLUID_OUNCE.toPints(8.76543297E-5), delta);
        msg = "0.33 / (20 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), FLUID_OUNCE.toPints(0.33), delta);
        msg = "0.6543 / (20 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), FLUID_OUNCE.toPints(0.6543), delta);
        msg = "1 / (20 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), FLUID_OUNCE.toPints(1.0), delta);
        msg = "1.6543 / (20 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), FLUID_OUNCE.toPints(1.6543), delta);
        msg = "22.45 / (20 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), FLUID_OUNCE.toPints(22.45), delta);
        msg = "9876.5432 / (20 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), FLUID_OUNCE.toPints(9876.5432), delta);
        msg = "1987654344.3345 / (20 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), FLUID_OUNCE.toPints(1.9876543443345E9), delta);
        msg = "784.46789765434 / (20 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), FLUID_OUNCE.toPints(784.46789765434), delta);
        // ====================
        // ====================QUART
        // ====================
        // to_factor = 40.0
        to_factor = QUART.getFactor();
        msg = "-1 / (40 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), FLUID_OUNCE.toQuarts(-1.0), delta);
        msg = "-0.1 / (40 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), FLUID_OUNCE.toQuarts(-0.1), delta);
        msg = "-0.000456789 / (40 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), FLUID_OUNCE.toQuarts(-4.56789E-4), delta);
        msg = "-73.25 / (40 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), FLUID_OUNCE.toQuarts(-73.25), delta);
        msg = "-56229.321 / (40 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), FLUID_OUNCE.toQuarts(-56229.321), delta);
        msg = "-873.5432456 / (40 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), FLUID_OUNCE.toQuarts(-873.5432456), delta);
        msg = "0 / (40 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), FLUID_OUNCE.toQuarts(0.0), delta);
        msg = "0.1 / (40 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), FLUID_OUNCE.toQuarts(0.1), delta);
        msg = "0.0000876543297 / (40 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), FLUID_OUNCE.toQuarts(8.76543297E-5), delta);
        msg = "0.33 / (40 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), FLUID_OUNCE.toQuarts(0.33), delta);
        msg = "0.6543 / (40 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), FLUID_OUNCE.toQuarts(0.6543), delta);
        msg = "1 / (40 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), FLUID_OUNCE.toQuarts(1.0), delta);
        msg = "1.6543 / (40 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), FLUID_OUNCE.toQuarts(1.6543), delta);
        msg = "22.45 / (40 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), FLUID_OUNCE.toQuarts(22.45), delta);
        msg = "9876.5432 / (40 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), FLUID_OUNCE.toQuarts(9876.5432), delta);
        msg = "1987654344.3345 / (40 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), FLUID_OUNCE.toQuarts(1.9876543443345E9), delta);
        msg = "784.46789765434 / (40 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), FLUID_OUNCE.toQuarts(784.46789765434), delta);
        // ====================
        // ====================GALLON
        // ====================
        // to_factor = 160.0
        to_factor = GALLON.getFactor();
        msg = "-1 / (160 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), FLUID_OUNCE.toGallons(-1.0), delta);
        msg = "-0.1 / (160 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), FLUID_OUNCE.toGallons(-0.1), delta);
        msg = "-0.000456789 / (160 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), FLUID_OUNCE.toGallons(-4.56789E-4), delta);
        msg = "-73.25 / (160 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), FLUID_OUNCE.toGallons(-73.25), delta);
        msg = "-56229.321 / (160 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), FLUID_OUNCE.toGallons(-56229.321), delta);
        msg = "-873.5432456 / (160 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), FLUID_OUNCE.toGallons(-873.5432456), delta);
        msg = "0 / (160 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), FLUID_OUNCE.toGallons(0.0), delta);
        msg = "0.1 / (160 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), FLUID_OUNCE.toGallons(0.1), delta);
        msg = "0.0000876543297 / (160 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), FLUID_OUNCE.toGallons(8.76543297E-5), delta);
        msg = "0.33 / (160 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), FLUID_OUNCE.toGallons(0.33), delta);
        msg = "0.6543 / (160 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), FLUID_OUNCE.toGallons(0.6543), delta);
        msg = "1 / (160 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), FLUID_OUNCE.toGallons(1.0), delta);
        msg = "1.6543 / (160 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), FLUID_OUNCE.toGallons(1.6543), delta);
        msg = "22.45 / (160 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), FLUID_OUNCE.toGallons(22.45), delta);
        msg = "9876.5432 / (160 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), FLUID_OUNCE.toGallons(9876.5432), delta);
        msg = "1987654344.3345 / (160 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), FLUID_OUNCE.toGallons(1.9876543443345E9), delta);
        msg = "784.46789765434 / (160 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), FLUID_OUNCE.toGallons(784.46789765434), delta);
    }

    @Test()
    public void testGill() {
        // from_factor = 5.0
        double from_factor = GILL.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================TEA_SPOON
        // ====================
        // to_factor = 0.16666666666666666
        to_factor = TEA_SPOON.getFactor();
        msg = "-1 * (5 / 0.16666666666666666)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GILL.toTeaSpoons(-1.0), delta);
        msg = "-0.1 * (5 / 0.16666666666666666)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GILL.toTeaSpoons(-0.1), delta);
        msg = "-0.000456789 * (5 / 0.16666666666666666)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GILL.toTeaSpoons(-4.56789E-4), delta);
        msg = "-73.25 * (5 / 0.16666666666666666)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GILL.toTeaSpoons(-73.25), delta);
        msg = "-56229.321 * (5 / 0.16666666666666666)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GILL.toTeaSpoons(-56229.321), delta);
        msg = "-873.5432456 * (5 / 0.16666666666666666)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GILL.toTeaSpoons(-873.5432456), delta);
        msg = "0 * (5 / 0.16666666666666666)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GILL.toTeaSpoons(0.0), delta);
        msg = "0.1 * (5 / 0.16666666666666666)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GILL.toTeaSpoons(0.1), delta);
        msg = "0.0000876543297 * (5 / 0.16666666666666666)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GILL.toTeaSpoons(8.76543297E-5), delta);
        msg = "0.33 * (5 / 0.16666666666666666)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GILL.toTeaSpoons(0.33), delta);
        msg = "0.6543 * (5 / 0.16666666666666666)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GILL.toTeaSpoons(0.6543), delta);
        msg = "1 * (5 / 0.16666666666666666)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GILL.toTeaSpoons(1.0), delta);
        msg = "1.6543 * (5 / 0.16666666666666666)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GILL.toTeaSpoons(1.6543), delta);
        msg = "22.45 * (5 / 0.16666666666666666)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GILL.toTeaSpoons(22.45), delta);
        msg = "9876.5432 * (5 / 0.16666666666666666)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GILL.toTeaSpoons(9876.5432), delta);
        msg = "1987654344.3345 * (5 / 0.16666666666666666)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GILL.toTeaSpoons(1.9876543443345E9), delta);
        msg = "784.46789765434 * (5 / 0.16666666666666666)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GILL.toTeaSpoons(784.46789765434), delta);
        // ====================
        // ====================TABLE_SPOON
        // ====================
        // to_factor = 0.5
        to_factor = TABLE_SPOON.getFactor();
        msg = "-1 * (5 / 0.5)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GILL.toTableSpoons(-1.0), delta);
        msg = "-0.1 * (5 / 0.5)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GILL.toTableSpoons(-0.1), delta);
        msg = "-0.000456789 * (5 / 0.5)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GILL.toTableSpoons(-4.56789E-4), delta);
        msg = "-73.25 * (5 / 0.5)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GILL.toTableSpoons(-73.25), delta);
        msg = "-56229.321 * (5 / 0.5)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GILL.toTableSpoons(-56229.321), delta);
        msg = "-873.5432456 * (5 / 0.5)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GILL.toTableSpoons(-873.5432456), delta);
        msg = "0 * (5 / 0.5)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GILL.toTableSpoons(0.0), delta);
        msg = "0.1 * (5 / 0.5)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GILL.toTableSpoons(0.1), delta);
        msg = "0.0000876543297 * (5 / 0.5)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GILL.toTableSpoons(8.76543297E-5), delta);
        msg = "0.33 * (5 / 0.5)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GILL.toTableSpoons(0.33), delta);
        msg = "0.6543 * (5 / 0.5)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GILL.toTableSpoons(0.6543), delta);
        msg = "1 * (5 / 0.5)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GILL.toTableSpoons(1.0), delta);
        msg = "1.6543 * (5 / 0.5)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GILL.toTableSpoons(1.6543), delta);
        msg = "22.45 * (5 / 0.5)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GILL.toTableSpoons(22.45), delta);
        msg = "9876.5432 * (5 / 0.5)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GILL.toTableSpoons(9876.5432), delta);
        msg = "1987654344.3345 * (5 / 0.5)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GILL.toTableSpoons(1.9876543443345E9), delta);
        msg = "784.46789765434 * (5 / 0.5)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GILL.toTableSpoons(784.46789765434), delta);
        // ====================
        // ====================FLUID_OUNCE
        // ====================
        // to_factor = 1.0
        to_factor = FLUID_OUNCE.getFactor();
        msg = "-1 * (5 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GILL.toFluidOunces(-1.0), delta);
        msg = "-0.1 * (5 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GILL.toFluidOunces(-0.1), delta);
        msg = "-0.000456789 * (5 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GILL.toFluidOunces(-4.56789E-4), delta);
        msg = "-73.25 * (5 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GILL.toFluidOunces(-73.25), delta);
        msg = "-56229.321 * (5 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GILL.toFluidOunces(-56229.321), delta);
        msg = "-873.5432456 * (5 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GILL.toFluidOunces(-873.5432456), delta);
        msg = "0 * (5 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GILL.toFluidOunces(0.0), delta);
        msg = "0.1 * (5 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GILL.toFluidOunces(0.1), delta);
        msg = "0.0000876543297 * (5 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GILL.toFluidOunces(8.76543297E-5), delta);
        msg = "0.33 * (5 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GILL.toFluidOunces(0.33), delta);
        msg = "0.6543 * (5 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GILL.toFluidOunces(0.6543), delta);
        msg = "1 * (5 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GILL.toFluidOunces(1.0), delta);
        msg = "1.6543 * (5 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GILL.toFluidOunces(1.6543), delta);
        msg = "22.45 * (5 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GILL.toFluidOunces(22.45), delta);
        msg = "9876.5432 * (5 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GILL.toFluidOunces(9876.5432), delta);
        msg = "1987654344.3345 * (5 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GILL.toFluidOunces(1.9876543443345E9), delta);
        msg = "784.46789765434 * (5 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GILL.toFluidOunces(784.46789765434), delta);
        // ====================
        // ====================GILL
        // ====================
        // to_factor = 5.0
        to_factor = GILL.getFactor();
        msg = "-1 * (5 / 5)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GILL.toGills(-1.0), delta);
        msg = "-0.1 * (5 / 5)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GILL.toGills(-0.1), delta);
        msg = "-0.000456789 * (5 / 5)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GILL.toGills(-4.56789E-4), delta);
        msg = "-73.25 * (5 / 5)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GILL.toGills(-73.25), delta);
        msg = "-56229.321 * (5 / 5)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GILL.toGills(-56229.321), delta);
        msg = "-873.5432456 * (5 / 5)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GILL.toGills(-873.5432456), delta);
        msg = "0 * (5 / 5)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GILL.toGills(0.0), delta);
        msg = "0.1 * (5 / 5)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GILL.toGills(0.1), delta);
        msg = "0.0000876543297 * (5 / 5)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GILL.toGills(8.76543297E-5), delta);
        msg = "0.33 * (5 / 5)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GILL.toGills(0.33), delta);
        msg = "0.6543 * (5 / 5)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GILL.toGills(0.6543), delta);
        msg = "1 * (5 / 5)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GILL.toGills(1.0), delta);
        msg = "1.6543 * (5 / 5)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GILL.toGills(1.6543), delta);
        msg = "22.45 * (5 / 5)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GILL.toGills(22.45), delta);
        msg = "9876.5432 * (5 / 5)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GILL.toGills(9876.5432), delta);
        msg = "1987654344.3345 * (5 / 5)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GILL.toGills(1.9876543443345E9), delta);
        msg = "784.46789765434 * (5 / 5)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GILL.toGills(784.46789765434), delta);
        // ====================
        // ====================PINT
        // ====================
        // to_factor = 20.0
        to_factor = PINT.getFactor();
        msg = "-1 / (20 / 5)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GILL.toPints(-1.0), delta);
        msg = "-0.1 / (20 / 5)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GILL.toPints(-0.1), delta);
        msg = "-0.000456789 / (20 / 5)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GILL.toPints(-4.56789E-4), delta);
        msg = "-73.25 / (20 / 5)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GILL.toPints(-73.25), delta);
        msg = "-56229.321 / (20 / 5)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GILL.toPints(-56229.321), delta);
        msg = "-873.5432456 / (20 / 5)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GILL.toPints(-873.5432456), delta);
        msg = "0 / (20 / 5)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GILL.toPints(0.0), delta);
        msg = "0.1 / (20 / 5)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GILL.toPints(0.1), delta);
        msg = "0.0000876543297 / (20 / 5)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GILL.toPints(8.76543297E-5), delta);
        msg = "0.33 / (20 / 5)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GILL.toPints(0.33), delta);
        msg = "0.6543 / (20 / 5)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GILL.toPints(0.6543), delta);
        msg = "1 / (20 / 5)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GILL.toPints(1.0), delta);
        msg = "1.6543 / (20 / 5)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GILL.toPints(1.6543), delta);
        msg = "22.45 / (20 / 5)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GILL.toPints(22.45), delta);
        msg = "9876.5432 / (20 / 5)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GILL.toPints(9876.5432), delta);
        msg = "1987654344.3345 / (20 / 5)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GILL.toPints(1.9876543443345E9), delta);
        msg = "784.46789765434 / (20 / 5)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GILL.toPints(784.46789765434), delta);
        // ====================
        // ====================QUART
        // ====================
        // to_factor = 40.0
        to_factor = QUART.getFactor();
        msg = "-1 / (40 / 5)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GILL.toQuarts(-1.0), delta);
        msg = "-0.1 / (40 / 5)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GILL.toQuarts(-0.1), delta);
        msg = "-0.000456789 / (40 / 5)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GILL.toQuarts(-4.56789E-4), delta);
        msg = "-73.25 / (40 / 5)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GILL.toQuarts(-73.25), delta);
        msg = "-56229.321 / (40 / 5)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GILL.toQuarts(-56229.321), delta);
        msg = "-873.5432456 / (40 / 5)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GILL.toQuarts(-873.5432456), delta);
        msg = "0 / (40 / 5)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GILL.toQuarts(0.0), delta);
        msg = "0.1 / (40 / 5)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GILL.toQuarts(0.1), delta);
        msg = "0.0000876543297 / (40 / 5)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GILL.toQuarts(8.76543297E-5), delta);
        msg = "0.33 / (40 / 5)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GILL.toQuarts(0.33), delta);
        msg = "0.6543 / (40 / 5)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GILL.toQuarts(0.6543), delta);
        msg = "1 / (40 / 5)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GILL.toQuarts(1.0), delta);
        msg = "1.6543 / (40 / 5)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GILL.toQuarts(1.6543), delta);
        msg = "22.45 / (40 / 5)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GILL.toQuarts(22.45), delta);
        msg = "9876.5432 / (40 / 5)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GILL.toQuarts(9876.5432), delta);
        msg = "1987654344.3345 / (40 / 5)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GILL.toQuarts(1.9876543443345E9), delta);
        msg = "784.46789765434 / (40 / 5)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GILL.toQuarts(784.46789765434), delta);
        // ====================
        // ====================GALLON
        // ====================
        // to_factor = 160.0
        to_factor = GALLON.getFactor();
        msg = "-1 / (160 / 5)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GILL.toGallons(-1.0), delta);
        msg = "-0.1 / (160 / 5)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GILL.toGallons(-0.1), delta);
        msg = "-0.000456789 / (160 / 5)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GILL.toGallons(-4.56789E-4), delta);
        msg = "-73.25 / (160 / 5)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GILL.toGallons(-73.25), delta);
        msg = "-56229.321 / (160 / 5)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GILL.toGallons(-56229.321), delta);
        msg = "-873.5432456 / (160 / 5)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GILL.toGallons(-873.5432456), delta);
        msg = "0 / (160 / 5)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GILL.toGallons(0.0), delta);
        msg = "0.1 / (160 / 5)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GILL.toGallons(0.1), delta);
        msg = "0.0000876543297 / (160 / 5)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GILL.toGallons(8.76543297E-5), delta);
        msg = "0.33 / (160 / 5)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GILL.toGallons(0.33), delta);
        msg = "0.6543 / (160 / 5)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GILL.toGallons(0.6543), delta);
        msg = "1 / (160 / 5)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GILL.toGallons(1.0), delta);
        msg = "1.6543 / (160 / 5)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GILL.toGallons(1.6543), delta);
        msg = "22.45 / (160 / 5)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GILL.toGallons(22.45), delta);
        msg = "9876.5432 / (160 / 5)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GILL.toGallons(9876.5432), delta);
        msg = "1987654344.3345 / (160 / 5)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GILL.toGallons(1.9876543443345E9), delta);
        msg = "784.46789765434 / (160 / 5)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GILL.toGallons(784.46789765434), delta);
    }

    @Test()
    public void testPint() {
        // from_factor = 20.0
        double from_factor = PINT.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================TEA_SPOON
        // ====================
        // to_factor = 0.16666666666666666
        to_factor = TEA_SPOON.getFactor();
        msg = "-1 * (20 / 0.16666666666666666)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), PINT.toTeaSpoons(-1.0), delta);
        msg = "-0.1 * (20 / 0.16666666666666666)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), PINT.toTeaSpoons(-0.1), delta);
        msg = "-0.000456789 * (20 / 0.16666666666666666)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), PINT.toTeaSpoons(-4.56789E-4), delta);
        msg = "-73.25 * (20 / 0.16666666666666666)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), PINT.toTeaSpoons(-73.25), delta);
        msg = "-56229.321 * (20 / 0.16666666666666666)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), PINT.toTeaSpoons(-56229.321), delta);
        msg = "-873.5432456 * (20 / 0.16666666666666666)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), PINT.toTeaSpoons(-873.5432456), delta);
        msg = "0 * (20 / 0.16666666666666666)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), PINT.toTeaSpoons(0.0), delta);
        msg = "0.1 * (20 / 0.16666666666666666)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), PINT.toTeaSpoons(0.1), delta);
        msg = "0.0000876543297 * (20 / 0.16666666666666666)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), PINT.toTeaSpoons(8.76543297E-5), delta);
        msg = "0.33 * (20 / 0.16666666666666666)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), PINT.toTeaSpoons(0.33), delta);
        msg = "0.6543 * (20 / 0.16666666666666666)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), PINT.toTeaSpoons(0.6543), delta);
        msg = "1 * (20 / 0.16666666666666666)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), PINT.toTeaSpoons(1.0), delta);
        msg = "1.6543 * (20 / 0.16666666666666666)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), PINT.toTeaSpoons(1.6543), delta);
        msg = "22.45 * (20 / 0.16666666666666666)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), PINT.toTeaSpoons(22.45), delta);
        msg = "9876.5432 * (20 / 0.16666666666666666)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), PINT.toTeaSpoons(9876.5432), delta);
        msg = "1987654344.3345 * (20 / 0.16666666666666666)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), PINT.toTeaSpoons(1.9876543443345E9), delta);
        msg = "784.46789765434 * (20 / 0.16666666666666666)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), PINT.toTeaSpoons(784.46789765434), delta);
        // ====================
        // ====================TABLE_SPOON
        // ====================
        // to_factor = 0.5
        to_factor = TABLE_SPOON.getFactor();
        msg = "-1 * (20 / 0.5)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), PINT.toTableSpoons(-1.0), delta);
        msg = "-0.1 * (20 / 0.5)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), PINT.toTableSpoons(-0.1), delta);
        msg = "-0.000456789 * (20 / 0.5)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), PINT.toTableSpoons(-4.56789E-4), delta);
        msg = "-73.25 * (20 / 0.5)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), PINT.toTableSpoons(-73.25), delta);
        msg = "-56229.321 * (20 / 0.5)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), PINT.toTableSpoons(-56229.321), delta);
        msg = "-873.5432456 * (20 / 0.5)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), PINT.toTableSpoons(-873.5432456), delta);
        msg = "0 * (20 / 0.5)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), PINT.toTableSpoons(0.0), delta);
        msg = "0.1 * (20 / 0.5)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), PINT.toTableSpoons(0.1), delta);
        msg = "0.0000876543297 * (20 / 0.5)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), PINT.toTableSpoons(8.76543297E-5), delta);
        msg = "0.33 * (20 / 0.5)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), PINT.toTableSpoons(0.33), delta);
        msg = "0.6543 * (20 / 0.5)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), PINT.toTableSpoons(0.6543), delta);
        msg = "1 * (20 / 0.5)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), PINT.toTableSpoons(1.0), delta);
        msg = "1.6543 * (20 / 0.5)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), PINT.toTableSpoons(1.6543), delta);
        msg = "22.45 * (20 / 0.5)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), PINT.toTableSpoons(22.45), delta);
        msg = "9876.5432 * (20 / 0.5)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), PINT.toTableSpoons(9876.5432), delta);
        msg = "1987654344.3345 * (20 / 0.5)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), PINT.toTableSpoons(1.9876543443345E9), delta);
        msg = "784.46789765434 * (20 / 0.5)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), PINT.toTableSpoons(784.46789765434), delta);
        // ====================
        // ====================FLUID_OUNCE
        // ====================
        // to_factor = 1.0
        to_factor = FLUID_OUNCE.getFactor();
        msg = "-1 * (20 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), PINT.toFluidOunces(-1.0), delta);
        msg = "-0.1 * (20 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), PINT.toFluidOunces(-0.1), delta);
        msg = "-0.000456789 * (20 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), PINT.toFluidOunces(-4.56789E-4), delta);
        msg = "-73.25 * (20 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), PINT.toFluidOunces(-73.25), delta);
        msg = "-56229.321 * (20 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), PINT.toFluidOunces(-56229.321), delta);
        msg = "-873.5432456 * (20 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), PINT.toFluidOunces(-873.5432456), delta);
        msg = "0 * (20 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), PINT.toFluidOunces(0.0), delta);
        msg = "0.1 * (20 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), PINT.toFluidOunces(0.1), delta);
        msg = "0.0000876543297 * (20 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), PINT.toFluidOunces(8.76543297E-5), delta);
        msg = "0.33 * (20 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), PINT.toFluidOunces(0.33), delta);
        msg = "0.6543 * (20 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), PINT.toFluidOunces(0.6543), delta);
        msg = "1 * (20 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), PINT.toFluidOunces(1.0), delta);
        msg = "1.6543 * (20 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), PINT.toFluidOunces(1.6543), delta);
        msg = "22.45 * (20 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), PINT.toFluidOunces(22.45), delta);
        msg = "9876.5432 * (20 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), PINT.toFluidOunces(9876.5432), delta);
        msg = "1987654344.3345 * (20 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), PINT.toFluidOunces(1.9876543443345E9), delta);
        msg = "784.46789765434 * (20 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), PINT.toFluidOunces(784.46789765434), delta);
        // ====================
        // ====================GILL
        // ====================
        // to_factor = 5.0
        to_factor = GILL.getFactor();
        msg = "-1 * (20 / 5)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), PINT.toGills(-1.0), delta);
        msg = "-0.1 * (20 / 5)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), PINT.toGills(-0.1), delta);
        msg = "-0.000456789 * (20 / 5)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), PINT.toGills(-4.56789E-4), delta);
        msg = "-73.25 * (20 / 5)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), PINT.toGills(-73.25), delta);
        msg = "-56229.321 * (20 / 5)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), PINT.toGills(-56229.321), delta);
        msg = "-873.5432456 * (20 / 5)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), PINT.toGills(-873.5432456), delta);
        msg = "0 * (20 / 5)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), PINT.toGills(0.0), delta);
        msg = "0.1 * (20 / 5)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), PINT.toGills(0.1), delta);
        msg = "0.0000876543297 * (20 / 5)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), PINT.toGills(8.76543297E-5), delta);
        msg = "0.33 * (20 / 5)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), PINT.toGills(0.33), delta);
        msg = "0.6543 * (20 / 5)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), PINT.toGills(0.6543), delta);
        msg = "1 * (20 / 5)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), PINT.toGills(1.0), delta);
        msg = "1.6543 * (20 / 5)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), PINT.toGills(1.6543), delta);
        msg = "22.45 * (20 / 5)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), PINT.toGills(22.45), delta);
        msg = "9876.5432 * (20 / 5)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), PINT.toGills(9876.5432), delta);
        msg = "1987654344.3345 * (20 / 5)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), PINT.toGills(1.9876543443345E9), delta);
        msg = "784.46789765434 * (20 / 5)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), PINT.toGills(784.46789765434), delta);
        // ====================
        // ====================PINT
        // ====================
        // to_factor = 20.0
        to_factor = PINT.getFactor();
        msg = "-1 * (20 / 20)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), PINT.toPints(-1.0), delta);
        msg = "-0.1 * (20 / 20)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), PINT.toPints(-0.1), delta);
        msg = "-0.000456789 * (20 / 20)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), PINT.toPints(-4.56789E-4), delta);
        msg = "-73.25 * (20 / 20)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), PINT.toPints(-73.25), delta);
        msg = "-56229.321 * (20 / 20)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), PINT.toPints(-56229.321), delta);
        msg = "-873.5432456 * (20 / 20)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), PINT.toPints(-873.5432456), delta);
        msg = "0 * (20 / 20)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), PINT.toPints(0.0), delta);
        msg = "0.1 * (20 / 20)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), PINT.toPints(0.1), delta);
        msg = "0.0000876543297 * (20 / 20)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), PINT.toPints(8.76543297E-5), delta);
        msg = "0.33 * (20 / 20)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), PINT.toPints(0.33), delta);
        msg = "0.6543 * (20 / 20)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), PINT.toPints(0.6543), delta);
        msg = "1 * (20 / 20)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), PINT.toPints(1.0), delta);
        msg = "1.6543 * (20 / 20)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), PINT.toPints(1.6543), delta);
        msg = "22.45 * (20 / 20)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), PINT.toPints(22.45), delta);
        msg = "9876.5432 * (20 / 20)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), PINT.toPints(9876.5432), delta);
        msg = "1987654344.3345 * (20 / 20)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), PINT.toPints(1.9876543443345E9), delta);
        msg = "784.46789765434 * (20 / 20)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), PINT.toPints(784.46789765434), delta);
        // ====================
        // ====================QUART
        // ====================
        // to_factor = 40.0
        to_factor = QUART.getFactor();
        msg = "-1 / (40 / 20)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), PINT.toQuarts(-1.0), delta);
        msg = "-0.1 / (40 / 20)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), PINT.toQuarts(-0.1), delta);
        msg = "-0.000456789 / (40 / 20)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), PINT.toQuarts(-4.56789E-4), delta);
        msg = "-73.25 / (40 / 20)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), PINT.toQuarts(-73.25), delta);
        msg = "-56229.321 / (40 / 20)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), PINT.toQuarts(-56229.321), delta);
        msg = "-873.5432456 / (40 / 20)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), PINT.toQuarts(-873.5432456), delta);
        msg = "0 / (40 / 20)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), PINT.toQuarts(0.0), delta);
        msg = "0.1 / (40 / 20)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), PINT.toQuarts(0.1), delta);
        msg = "0.0000876543297 / (40 / 20)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), PINT.toQuarts(8.76543297E-5), delta);
        msg = "0.33 / (40 / 20)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), PINT.toQuarts(0.33), delta);
        msg = "0.6543 / (40 / 20)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), PINT.toQuarts(0.6543), delta);
        msg = "1 / (40 / 20)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), PINT.toQuarts(1.0), delta);
        msg = "1.6543 / (40 / 20)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), PINT.toQuarts(1.6543), delta);
        msg = "22.45 / (40 / 20)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), PINT.toQuarts(22.45), delta);
        msg = "9876.5432 / (40 / 20)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), PINT.toQuarts(9876.5432), delta);
        msg = "1987654344.3345 / (40 / 20)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), PINT.toQuarts(1.9876543443345E9), delta);
        msg = "784.46789765434 / (40 / 20)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), PINT.toQuarts(784.46789765434), delta);
        // ====================
        // ====================GALLON
        // ====================
        // to_factor = 160.0
        to_factor = GALLON.getFactor();
        msg = "-1 / (160 / 20)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), PINT.toGallons(-1.0), delta);
        msg = "-0.1 / (160 / 20)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), PINT.toGallons(-0.1), delta);
        msg = "-0.000456789 / (160 / 20)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), PINT.toGallons(-4.56789E-4), delta);
        msg = "-73.25 / (160 / 20)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), PINT.toGallons(-73.25), delta);
        msg = "-56229.321 / (160 / 20)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), PINT.toGallons(-56229.321), delta);
        msg = "-873.5432456 / (160 / 20)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), PINT.toGallons(-873.5432456), delta);
        msg = "0 / (160 / 20)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), PINT.toGallons(0.0), delta);
        msg = "0.1 / (160 / 20)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), PINT.toGallons(0.1), delta);
        msg = "0.0000876543297 / (160 / 20)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), PINT.toGallons(8.76543297E-5), delta);
        msg = "0.33 / (160 / 20)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), PINT.toGallons(0.33), delta);
        msg = "0.6543 / (160 / 20)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), PINT.toGallons(0.6543), delta);
        msg = "1 / (160 / 20)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), PINT.toGallons(1.0), delta);
        msg = "1.6543 / (160 / 20)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), PINT.toGallons(1.6543), delta);
        msg = "22.45 / (160 / 20)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), PINT.toGallons(22.45), delta);
        msg = "9876.5432 / (160 / 20)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), PINT.toGallons(9876.5432), delta);
        msg = "1987654344.3345 / (160 / 20)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), PINT.toGallons(1.9876543443345E9), delta);
        msg = "784.46789765434 / (160 / 20)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), PINT.toGallons(784.46789765434), delta);
    }

    @Test()
    public void testQuart() {
        // from_factor = 40.0
        double from_factor = QUART.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================TEA_SPOON
        // ====================
        // to_factor = 0.16666666666666666
        to_factor = TEA_SPOON.getFactor();
        msg = "-1 * (40 / 0.16666666666666666)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), QUART.toTeaSpoons(-1.0), delta);
        msg = "-0.1 * (40 / 0.16666666666666666)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), QUART.toTeaSpoons(-0.1), delta);
        msg = "-0.000456789 * (40 / 0.16666666666666666)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), QUART.toTeaSpoons(-4.56789E-4), delta);
        msg = "-73.25 * (40 / 0.16666666666666666)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), QUART.toTeaSpoons(-73.25), delta);
        msg = "-56229.321 * (40 / 0.16666666666666666)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), QUART.toTeaSpoons(-56229.321), delta);
        msg = "-873.5432456 * (40 / 0.16666666666666666)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), QUART.toTeaSpoons(-873.5432456), delta);
        msg = "0 * (40 / 0.16666666666666666)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), QUART.toTeaSpoons(0.0), delta);
        msg = "0.1 * (40 / 0.16666666666666666)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), QUART.toTeaSpoons(0.1), delta);
        msg = "0.0000876543297 * (40 / 0.16666666666666666)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), QUART.toTeaSpoons(8.76543297E-5), delta);
        msg = "0.33 * (40 / 0.16666666666666666)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), QUART.toTeaSpoons(0.33), delta);
        msg = "0.6543 * (40 / 0.16666666666666666)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), QUART.toTeaSpoons(0.6543), delta);
        msg = "1 * (40 / 0.16666666666666666)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), QUART.toTeaSpoons(1.0), delta);
        msg = "1.6543 * (40 / 0.16666666666666666)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), QUART.toTeaSpoons(1.6543), delta);
        msg = "22.45 * (40 / 0.16666666666666666)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), QUART.toTeaSpoons(22.45), delta);
        msg = "9876.5432 * (40 / 0.16666666666666666)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), QUART.toTeaSpoons(9876.5432), delta);
        msg = "1987654344.3345 * (40 / 0.16666666666666666)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), QUART.toTeaSpoons(1.9876543443345E9), delta);
        msg = "784.46789765434 * (40 / 0.16666666666666666)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), QUART.toTeaSpoons(784.46789765434), delta);
        // ====================
        // ====================TABLE_SPOON
        // ====================
        // to_factor = 0.5
        to_factor = TABLE_SPOON.getFactor();
        msg = "-1 * (40 / 0.5)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), QUART.toTableSpoons(-1.0), delta);
        msg = "-0.1 * (40 / 0.5)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), QUART.toTableSpoons(-0.1), delta);
        msg = "-0.000456789 * (40 / 0.5)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), QUART.toTableSpoons(-4.56789E-4), delta);
        msg = "-73.25 * (40 / 0.5)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), QUART.toTableSpoons(-73.25), delta);
        msg = "-56229.321 * (40 / 0.5)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), QUART.toTableSpoons(-56229.321), delta);
        msg = "-873.5432456 * (40 / 0.5)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), QUART.toTableSpoons(-873.5432456), delta);
        msg = "0 * (40 / 0.5)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), QUART.toTableSpoons(0.0), delta);
        msg = "0.1 * (40 / 0.5)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), QUART.toTableSpoons(0.1), delta);
        msg = "0.0000876543297 * (40 / 0.5)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), QUART.toTableSpoons(8.76543297E-5), delta);
        msg = "0.33 * (40 / 0.5)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), QUART.toTableSpoons(0.33), delta);
        msg = "0.6543 * (40 / 0.5)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), QUART.toTableSpoons(0.6543), delta);
        msg = "1 * (40 / 0.5)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), QUART.toTableSpoons(1.0), delta);
        msg = "1.6543 * (40 / 0.5)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), QUART.toTableSpoons(1.6543), delta);
        msg = "22.45 * (40 / 0.5)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), QUART.toTableSpoons(22.45), delta);
        msg = "9876.5432 * (40 / 0.5)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), QUART.toTableSpoons(9876.5432), delta);
        msg = "1987654344.3345 * (40 / 0.5)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), QUART.toTableSpoons(1.9876543443345E9), delta);
        msg = "784.46789765434 * (40 / 0.5)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), QUART.toTableSpoons(784.46789765434), delta);
        // ====================
        // ====================FLUID_OUNCE
        // ====================
        // to_factor = 1.0
        to_factor = FLUID_OUNCE.getFactor();
        msg = "-1 * (40 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), QUART.toFluidOunces(-1.0), delta);
        msg = "-0.1 * (40 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), QUART.toFluidOunces(-0.1), delta);
        msg = "-0.000456789 * (40 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), QUART.toFluidOunces(-4.56789E-4), delta);
        msg = "-73.25 * (40 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), QUART.toFluidOunces(-73.25), delta);
        msg = "-56229.321 * (40 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), QUART.toFluidOunces(-56229.321), delta);
        msg = "-873.5432456 * (40 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), QUART.toFluidOunces(-873.5432456), delta);
        msg = "0 * (40 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), QUART.toFluidOunces(0.0), delta);
        msg = "0.1 * (40 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), QUART.toFluidOunces(0.1), delta);
        msg = "0.0000876543297 * (40 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), QUART.toFluidOunces(8.76543297E-5), delta);
        msg = "0.33 * (40 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), QUART.toFluidOunces(0.33), delta);
        msg = "0.6543 * (40 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), QUART.toFluidOunces(0.6543), delta);
        msg = "1 * (40 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), QUART.toFluidOunces(1.0), delta);
        msg = "1.6543 * (40 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), QUART.toFluidOunces(1.6543), delta);
        msg = "22.45 * (40 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), QUART.toFluidOunces(22.45), delta);
        msg = "9876.5432 * (40 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), QUART.toFluidOunces(9876.5432), delta);
        msg = "1987654344.3345 * (40 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), QUART.toFluidOunces(1.9876543443345E9), delta);
        msg = "784.46789765434 * (40 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), QUART.toFluidOunces(784.46789765434), delta);
        // ====================
        // ====================GILL
        // ====================
        // to_factor = 5.0
        to_factor = GILL.getFactor();
        msg = "-1 * (40 / 5)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), QUART.toGills(-1.0), delta);
        msg = "-0.1 * (40 / 5)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), QUART.toGills(-0.1), delta);
        msg = "-0.000456789 * (40 / 5)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), QUART.toGills(-4.56789E-4), delta);
        msg = "-73.25 * (40 / 5)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), QUART.toGills(-73.25), delta);
        msg = "-56229.321 * (40 / 5)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), QUART.toGills(-56229.321), delta);
        msg = "-873.5432456 * (40 / 5)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), QUART.toGills(-873.5432456), delta);
        msg = "0 * (40 / 5)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), QUART.toGills(0.0), delta);
        msg = "0.1 * (40 / 5)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), QUART.toGills(0.1), delta);
        msg = "0.0000876543297 * (40 / 5)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), QUART.toGills(8.76543297E-5), delta);
        msg = "0.33 * (40 / 5)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), QUART.toGills(0.33), delta);
        msg = "0.6543 * (40 / 5)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), QUART.toGills(0.6543), delta);
        msg = "1 * (40 / 5)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), QUART.toGills(1.0), delta);
        msg = "1.6543 * (40 / 5)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), QUART.toGills(1.6543), delta);
        msg = "22.45 * (40 / 5)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), QUART.toGills(22.45), delta);
        msg = "9876.5432 * (40 / 5)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), QUART.toGills(9876.5432), delta);
        msg = "1987654344.3345 * (40 / 5)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), QUART.toGills(1.9876543443345E9), delta);
        msg = "784.46789765434 * (40 / 5)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), QUART.toGills(784.46789765434), delta);
        // ====================
        // ====================PINT
        // ====================
        // to_factor = 20.0
        to_factor = PINT.getFactor();
        msg = "-1 * (40 / 20)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), QUART.toPints(-1.0), delta);
        msg = "-0.1 * (40 / 20)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), QUART.toPints(-0.1), delta);
        msg = "-0.000456789 * (40 / 20)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), QUART.toPints(-4.56789E-4), delta);
        msg = "-73.25 * (40 / 20)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), QUART.toPints(-73.25), delta);
        msg = "-56229.321 * (40 / 20)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), QUART.toPints(-56229.321), delta);
        msg = "-873.5432456 * (40 / 20)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), QUART.toPints(-873.5432456), delta);
        msg = "0 * (40 / 20)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), QUART.toPints(0.0), delta);
        msg = "0.1 * (40 / 20)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), QUART.toPints(0.1), delta);
        msg = "0.0000876543297 * (40 / 20)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), QUART.toPints(8.76543297E-5), delta);
        msg = "0.33 * (40 / 20)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), QUART.toPints(0.33), delta);
        msg = "0.6543 * (40 / 20)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), QUART.toPints(0.6543), delta);
        msg = "1 * (40 / 20)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), QUART.toPints(1.0), delta);
        msg = "1.6543 * (40 / 20)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), QUART.toPints(1.6543), delta);
        msg = "22.45 * (40 / 20)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), QUART.toPints(22.45), delta);
        msg = "9876.5432 * (40 / 20)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), QUART.toPints(9876.5432), delta);
        msg = "1987654344.3345 * (40 / 20)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), QUART.toPints(1.9876543443345E9), delta);
        msg = "784.46789765434 * (40 / 20)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), QUART.toPints(784.46789765434), delta);
        // ====================
        // ====================QUART
        // ====================
        // to_factor = 40.0
        to_factor = QUART.getFactor();
        msg = "-1 * (40 / 40)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), QUART.toQuarts(-1.0), delta);
        msg = "-0.1 * (40 / 40)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), QUART.toQuarts(-0.1), delta);
        msg = "-0.000456789 * (40 / 40)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), QUART.toQuarts(-4.56789E-4), delta);
        msg = "-73.25 * (40 / 40)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), QUART.toQuarts(-73.25), delta);
        msg = "-56229.321 * (40 / 40)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), QUART.toQuarts(-56229.321), delta);
        msg = "-873.5432456 * (40 / 40)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), QUART.toQuarts(-873.5432456), delta);
        msg = "0 * (40 / 40)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), QUART.toQuarts(0.0), delta);
        msg = "0.1 * (40 / 40)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), QUART.toQuarts(0.1), delta);
        msg = "0.0000876543297 * (40 / 40)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), QUART.toQuarts(8.76543297E-5), delta);
        msg = "0.33 * (40 / 40)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), QUART.toQuarts(0.33), delta);
        msg = "0.6543 * (40 / 40)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), QUART.toQuarts(0.6543), delta);
        msg = "1 * (40 / 40)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), QUART.toQuarts(1.0), delta);
        msg = "1.6543 * (40 / 40)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), QUART.toQuarts(1.6543), delta);
        msg = "22.45 * (40 / 40)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), QUART.toQuarts(22.45), delta);
        msg = "9876.5432 * (40 / 40)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), QUART.toQuarts(9876.5432), delta);
        msg = "1987654344.3345 * (40 / 40)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), QUART.toQuarts(1.9876543443345E9), delta);
        msg = "784.46789765434 * (40 / 40)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), QUART.toQuarts(784.46789765434), delta);
        // ====================
        // ====================GALLON
        // ====================
        // to_factor = 160.0
        to_factor = GALLON.getFactor();
        msg = "-1 / (160 / 40)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), QUART.toGallons(-1.0), delta);
        msg = "-0.1 / (160 / 40)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), QUART.toGallons(-0.1), delta);
        msg = "-0.000456789 / (160 / 40)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), QUART.toGallons(-4.56789E-4), delta);
        msg = "-73.25 / (160 / 40)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), QUART.toGallons(-73.25), delta);
        msg = "-56229.321 / (160 / 40)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), QUART.toGallons(-56229.321), delta);
        msg = "-873.5432456 / (160 / 40)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), QUART.toGallons(-873.5432456), delta);
        msg = "0 / (160 / 40)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), QUART.toGallons(0.0), delta);
        msg = "0.1 / (160 / 40)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), QUART.toGallons(0.1), delta);
        msg = "0.0000876543297 / (160 / 40)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), QUART.toGallons(8.76543297E-5), delta);
        msg = "0.33 / (160 / 40)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), QUART.toGallons(0.33), delta);
        msg = "0.6543 / (160 / 40)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), QUART.toGallons(0.6543), delta);
        msg = "1 / (160 / 40)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), QUART.toGallons(1.0), delta);
        msg = "1.6543 / (160 / 40)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), QUART.toGallons(1.6543), delta);
        msg = "22.45 / (160 / 40)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), QUART.toGallons(22.45), delta);
        msg = "9876.5432 / (160 / 40)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), QUART.toGallons(9876.5432), delta);
        msg = "1987654344.3345 / (160 / 40)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), QUART.toGallons(1.9876543443345E9), delta);
        msg = "784.46789765434 / (160 / 40)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), QUART.toGallons(784.46789765434), delta);
    }

    @Test()
    public void testGallon() {
        // from_factor = 160.0
        double from_factor = GALLON.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================TEA_SPOON
        // ====================
        // to_factor = 0.16666666666666666
        to_factor = TEA_SPOON.getFactor();
        msg = "-1 * (160 / 0.16666666666666666)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GALLON.toTeaSpoons(-1.0), delta);
        msg = "-0.1 * (160 / 0.16666666666666666)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GALLON.toTeaSpoons(-0.1), delta);
        msg = "-0.000456789 * (160 / 0.16666666666666666)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GALLON.toTeaSpoons(-4.56789E-4), delta);
        msg = "-73.25 * (160 / 0.16666666666666666)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GALLON.toTeaSpoons(-73.25), delta);
        msg = "-56229.321 * (160 / 0.16666666666666666)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GALLON.toTeaSpoons(-56229.321), delta);
        msg = "-873.5432456 * (160 / 0.16666666666666666)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GALLON.toTeaSpoons(-873.5432456), delta);
        msg = "0 * (160 / 0.16666666666666666)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GALLON.toTeaSpoons(0.0), delta);
        msg = "0.1 * (160 / 0.16666666666666666)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GALLON.toTeaSpoons(0.1), delta);
        msg = "0.0000876543297 * (160 / 0.16666666666666666)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GALLON.toTeaSpoons(8.76543297E-5), delta);
        msg = "0.33 * (160 / 0.16666666666666666)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GALLON.toTeaSpoons(0.33), delta);
        msg = "0.6543 * (160 / 0.16666666666666666)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GALLON.toTeaSpoons(0.6543), delta);
        msg = "1 * (160 / 0.16666666666666666)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GALLON.toTeaSpoons(1.0), delta);
        msg = "1.6543 * (160 / 0.16666666666666666)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GALLON.toTeaSpoons(1.6543), delta);
        msg = "22.45 * (160 / 0.16666666666666666)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GALLON.toTeaSpoons(22.45), delta);
        msg = "9876.5432 * (160 / 0.16666666666666666)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GALLON.toTeaSpoons(9876.5432), delta);
        msg = "1987654344.3345 * (160 / 0.16666666666666666)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GALLON.toTeaSpoons(1.9876543443345E9), delta);
        msg = "784.46789765434 * (160 / 0.16666666666666666)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GALLON.toTeaSpoons(784.46789765434), delta);
        // ====================
        // ====================TABLE_SPOON
        // ====================
        // to_factor = 0.5
        to_factor = TABLE_SPOON.getFactor();
        msg = "-1 * (160 / 0.5)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GALLON.toTableSpoons(-1.0), delta);
        msg = "-0.1 * (160 / 0.5)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GALLON.toTableSpoons(-0.1), delta);
        msg = "-0.000456789 * (160 / 0.5)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GALLON.toTableSpoons(-4.56789E-4), delta);
        msg = "-73.25 * (160 / 0.5)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GALLON.toTableSpoons(-73.25), delta);
        msg = "-56229.321 * (160 / 0.5)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GALLON.toTableSpoons(-56229.321), delta);
        msg = "-873.5432456 * (160 / 0.5)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GALLON.toTableSpoons(-873.5432456), delta);
        msg = "0 * (160 / 0.5)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GALLON.toTableSpoons(0.0), delta);
        msg = "0.1 * (160 / 0.5)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GALLON.toTableSpoons(0.1), delta);
        msg = "0.0000876543297 * (160 / 0.5)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GALLON.toTableSpoons(8.76543297E-5), delta);
        msg = "0.33 * (160 / 0.5)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GALLON.toTableSpoons(0.33), delta);
        msg = "0.6543 * (160 / 0.5)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GALLON.toTableSpoons(0.6543), delta);
        msg = "1 * (160 / 0.5)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GALLON.toTableSpoons(1.0), delta);
        msg = "1.6543 * (160 / 0.5)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GALLON.toTableSpoons(1.6543), delta);
        msg = "22.45 * (160 / 0.5)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GALLON.toTableSpoons(22.45), delta);
        msg = "9876.5432 * (160 / 0.5)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GALLON.toTableSpoons(9876.5432), delta);
        msg = "1987654344.3345 * (160 / 0.5)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GALLON.toTableSpoons(1.9876543443345E9), delta);
        msg = "784.46789765434 * (160 / 0.5)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GALLON.toTableSpoons(784.46789765434), delta);
        // ====================
        // ====================FLUID_OUNCE
        // ====================
        // to_factor = 1.0
        to_factor = FLUID_OUNCE.getFactor();
        msg = "-1 * (160 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GALLON.toFluidOunces(-1.0), delta);
        msg = "-0.1 * (160 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GALLON.toFluidOunces(-0.1), delta);
        msg = "-0.000456789 * (160 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GALLON.toFluidOunces(-4.56789E-4), delta);
        msg = "-73.25 * (160 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GALLON.toFluidOunces(-73.25), delta);
        msg = "-56229.321 * (160 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GALLON.toFluidOunces(-56229.321), delta);
        msg = "-873.5432456 * (160 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GALLON.toFluidOunces(-873.5432456), delta);
        msg = "0 * (160 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GALLON.toFluidOunces(0.0), delta);
        msg = "0.1 * (160 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GALLON.toFluidOunces(0.1), delta);
        msg = "0.0000876543297 * (160 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GALLON.toFluidOunces(8.76543297E-5), delta);
        msg = "0.33 * (160 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GALLON.toFluidOunces(0.33), delta);
        msg = "0.6543 * (160 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GALLON.toFluidOunces(0.6543), delta);
        msg = "1 * (160 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GALLON.toFluidOunces(1.0), delta);
        msg = "1.6543 * (160 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GALLON.toFluidOunces(1.6543), delta);
        msg = "22.45 * (160 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GALLON.toFluidOunces(22.45), delta);
        msg = "9876.5432 * (160 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GALLON.toFluidOunces(9876.5432), delta);
        msg = "1987654344.3345 * (160 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GALLON.toFluidOunces(1.9876543443345E9), delta);
        msg = "784.46789765434 * (160 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GALLON.toFluidOunces(784.46789765434), delta);
        // ====================
        // ====================GILL
        // ====================
        // to_factor = 5.0
        to_factor = GILL.getFactor();
        msg = "-1 * (160 / 5)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GALLON.toGills(-1.0), delta);
        msg = "-0.1 * (160 / 5)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GALLON.toGills(-0.1), delta);
        msg = "-0.000456789 * (160 / 5)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GALLON.toGills(-4.56789E-4), delta);
        msg = "-73.25 * (160 / 5)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GALLON.toGills(-73.25), delta);
        msg = "-56229.321 * (160 / 5)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GALLON.toGills(-56229.321), delta);
        msg = "-873.5432456 * (160 / 5)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GALLON.toGills(-873.5432456), delta);
        msg = "0 * (160 / 5)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GALLON.toGills(0.0), delta);
        msg = "0.1 * (160 / 5)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GALLON.toGills(0.1), delta);
        msg = "0.0000876543297 * (160 / 5)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GALLON.toGills(8.76543297E-5), delta);
        msg = "0.33 * (160 / 5)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GALLON.toGills(0.33), delta);
        msg = "0.6543 * (160 / 5)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GALLON.toGills(0.6543), delta);
        msg = "1 * (160 / 5)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GALLON.toGills(1.0), delta);
        msg = "1.6543 * (160 / 5)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GALLON.toGills(1.6543), delta);
        msg = "22.45 * (160 / 5)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GALLON.toGills(22.45), delta);
        msg = "9876.5432 * (160 / 5)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GALLON.toGills(9876.5432), delta);
        msg = "1987654344.3345 * (160 / 5)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GALLON.toGills(1.9876543443345E9), delta);
        msg = "784.46789765434 * (160 / 5)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GALLON.toGills(784.46789765434), delta);
        // ====================
        // ====================PINT
        // ====================
        // to_factor = 20.0
        to_factor = PINT.getFactor();
        msg = "-1 * (160 / 20)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GALLON.toPints(-1.0), delta);
        msg = "-0.1 * (160 / 20)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GALLON.toPints(-0.1), delta);
        msg = "-0.000456789 * (160 / 20)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GALLON.toPints(-4.56789E-4), delta);
        msg = "-73.25 * (160 / 20)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GALLON.toPints(-73.25), delta);
        msg = "-56229.321 * (160 / 20)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GALLON.toPints(-56229.321), delta);
        msg = "-873.5432456 * (160 / 20)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GALLON.toPints(-873.5432456), delta);
        msg = "0 * (160 / 20)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GALLON.toPints(0.0), delta);
        msg = "0.1 * (160 / 20)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GALLON.toPints(0.1), delta);
        msg = "0.0000876543297 * (160 / 20)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GALLON.toPints(8.76543297E-5), delta);
        msg = "0.33 * (160 / 20)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GALLON.toPints(0.33), delta);
        msg = "0.6543 * (160 / 20)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GALLON.toPints(0.6543), delta);
        msg = "1 * (160 / 20)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GALLON.toPints(1.0), delta);
        msg = "1.6543 * (160 / 20)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GALLON.toPints(1.6543), delta);
        msg = "22.45 * (160 / 20)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GALLON.toPints(22.45), delta);
        msg = "9876.5432 * (160 / 20)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GALLON.toPints(9876.5432), delta);
        msg = "1987654344.3345 * (160 / 20)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GALLON.toPints(1.9876543443345E9), delta);
        msg = "784.46789765434 * (160 / 20)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GALLON.toPints(784.46789765434), delta);
        // ====================
        // ====================QUART
        // ====================
        // to_factor = 40.0
        to_factor = QUART.getFactor();
        msg = "-1 * (160 / 40)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GALLON.toQuarts(-1.0), delta);
        msg = "-0.1 * (160 / 40)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GALLON.toQuarts(-0.1), delta);
        msg = "-0.000456789 * (160 / 40)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GALLON.toQuarts(-4.56789E-4), delta);
        msg = "-73.25 * (160 / 40)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GALLON.toQuarts(-73.25), delta);
        msg = "-56229.321 * (160 / 40)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GALLON.toQuarts(-56229.321), delta);
        msg = "-873.5432456 * (160 / 40)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GALLON.toQuarts(-873.5432456), delta);
        msg = "0 * (160 / 40)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GALLON.toQuarts(0.0), delta);
        msg = "0.1 * (160 / 40)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GALLON.toQuarts(0.1), delta);
        msg = "0.0000876543297 * (160 / 40)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GALLON.toQuarts(8.76543297E-5), delta);
        msg = "0.33 * (160 / 40)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GALLON.toQuarts(0.33), delta);
        msg = "0.6543 * (160 / 40)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GALLON.toQuarts(0.6543), delta);
        msg = "1 * (160 / 40)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GALLON.toQuarts(1.0), delta);
        msg = "1.6543 * (160 / 40)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GALLON.toQuarts(1.6543), delta);
        msg = "22.45 * (160 / 40)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GALLON.toQuarts(22.45), delta);
        msg = "9876.5432 * (160 / 40)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GALLON.toQuarts(9876.5432), delta);
        msg = "1987654344.3345 * (160 / 40)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GALLON.toQuarts(1.9876543443345E9), delta);
        msg = "784.46789765434 * (160 / 40)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GALLON.toQuarts(784.46789765434), delta);
        // ====================
        // ====================GALLON
        // ====================
        // to_factor = 160.0
        to_factor = GALLON.getFactor();
        msg = "-1 * (160 / 160)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GALLON.toGallons(-1.0), delta);
        msg = "-0.1 * (160 / 160)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GALLON.toGallons(-0.1), delta);
        msg = "-0.000456789 * (160 / 160)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GALLON.toGallons(-4.56789E-4), delta);
        msg = "-73.25 * (160 / 160)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GALLON.toGallons(-73.25), delta);
        msg = "-56229.321 * (160 / 160)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GALLON.toGallons(-56229.321), delta);
        msg = "-873.5432456 * (160 / 160)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GALLON.toGallons(-873.5432456), delta);
        msg = "0 * (160 / 160)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GALLON.toGallons(0.0), delta);
        msg = "0.1 * (160 / 160)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GALLON.toGallons(0.1), delta);
        msg = "0.0000876543297 * (160 / 160)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GALLON.toGallons(8.76543297E-5), delta);
        msg = "0.33 * (160 / 160)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GALLON.toGallons(0.33), delta);
        msg = "0.6543 * (160 / 160)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GALLON.toGallons(0.6543), delta);
        msg = "1 * (160 / 160)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GALLON.toGallons(1.0), delta);
        msg = "1.6543 * (160 / 160)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GALLON.toGallons(1.6543), delta);
        msg = "22.45 * (160 / 160)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GALLON.toGallons(22.45), delta);
        msg = "9876.5432 * (160 / 160)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GALLON.toGallons(9876.5432), delta);
        msg = "1987654344.3345 * (160 / 160)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GALLON.toGallons(1.9876543443345E9), delta);
        msg = "784.46789765434 * (160 / 160)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GALLON.toGallons(784.46789765434), delta);
    }
}
