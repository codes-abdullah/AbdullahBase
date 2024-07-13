package codes.abdullah.measurement.system.imperial;

import static codes.abdullah.measurement.system.imperial.Imperials.DRACHM;
import static codes.abdullah.measurement.system.imperial.Imperials.GRAIN;
import static codes.abdullah.measurement.system.imperial.Imperials.HUNDREDWEIGHT;
import static codes.abdullah.measurement.system.imperial.Imperials.OUNCE;
import static codes.abdullah.measurement.system.imperial.Imperials.POUND;
import static codes.abdullah.measurement.system.imperial.Imperials.QUARTER;
import static codes.abdullah.measurement.system.imperial.Imperials.STONE;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFixedImperialMass {

    @Test()
    public void testGrain() {
        // from_factor = 0.0023148148148148147
        double from_factor = GRAIN.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================GRAIN
        // ====================
        // to_factor = 0.0023148148148148147
        to_factor = GRAIN.getFactor();
        msg = "-1 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), GRAIN.toGrains(-1.0), delta);
        msg = "-0.1 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), GRAIN.toGrains(-0.1), delta);
        msg = "-0.000456789 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), GRAIN.toGrains(-4.56789E-4), delta);
        msg = "-73.25 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), GRAIN.toGrains(-73.25), delta);
        msg = "-56229.321 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), GRAIN.toGrains(-56229.321), delta);
        msg = "-873.5432456 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), GRAIN.toGrains(-873.5432456), delta);
        msg = "0 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), GRAIN.toGrains(0.0), delta);
        msg = "0.1 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), GRAIN.toGrains(0.1), delta);
        msg = "0.0000876543297 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), GRAIN.toGrains(8.76543297E-5), delta);
        msg = "0.33 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), GRAIN.toGrains(0.33), delta);
        msg = "0.6543 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), GRAIN.toGrains(0.6543), delta);
        msg = "1 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), GRAIN.toGrains(1.0), delta);
        msg = "1.6543 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), GRAIN.toGrains(1.6543), delta);
        msg = "22.45 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), GRAIN.toGrains(22.45), delta);
        msg = "9876.5432 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), GRAIN.toGrains(9876.5432), delta);
        msg = "1987654344.3345 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), GRAIN.toGrains(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), GRAIN.toGrains(784.46789765434), delta);
        // ====================
        // ====================DRACHM
        // ====================
        // to_factor = 0.0023148148148148147
        to_factor = DRACHM.getFactor();
        msg = "-1 / (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GRAIN.toDrachms(-1.0), delta);
        msg = "-0.1 / (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GRAIN.toDrachms(-0.1), delta);
        msg = "-0.000456789 / (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GRAIN.toDrachms(-4.56789E-4), delta);
        msg = "-73.25 / (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GRAIN.toDrachms(-73.25), delta);
        msg = "-56229.321 / (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GRAIN.toDrachms(-56229.321), delta);
        msg = "-873.5432456 / (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GRAIN.toDrachms(-873.5432456), delta);
        msg = "0 / (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GRAIN.toDrachms(0.0), delta);
        msg = "0.1 / (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GRAIN.toDrachms(0.1), delta);
        msg = "0.0000876543297 / (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GRAIN.toDrachms(8.76543297E-5), delta);
        msg = "0.33 / (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GRAIN.toDrachms(0.33), delta);
        msg = "0.6543 / (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GRAIN.toDrachms(0.6543), delta);
        msg = "1 / (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GRAIN.toDrachms(1.0), delta);
        msg = "1.6543 / (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GRAIN.toDrachms(1.6543), delta);
        msg = "22.45 / (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GRAIN.toDrachms(22.45), delta);
        msg = "9876.5432 / (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GRAIN.toDrachms(9876.5432), delta);
        msg = "1987654344.3345 / (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GRAIN.toDrachms(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GRAIN.toDrachms(784.46789765434), delta);
        // ====================
        // ====================OUNCE
        // ====================
        // to_factor = 0.0625
        to_factor = OUNCE.getFactor();
        msg = "-1 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GRAIN.toOunces(-1.0), delta);
        msg = "-0.1 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GRAIN.toOunces(-0.1), delta);
        msg = "-0.000456789 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GRAIN.toOunces(-4.56789E-4), delta);
        msg = "-73.25 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GRAIN.toOunces(-73.25), delta);
        msg = "-56229.321 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GRAIN.toOunces(-56229.321), delta);
        msg = "-873.5432456 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GRAIN.toOunces(-873.5432456), delta);
        msg = "0 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GRAIN.toOunces(0.0), delta);
        msg = "0.1 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GRAIN.toOunces(0.1), delta);
        msg = "0.0000876543297 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GRAIN.toOunces(8.76543297E-5), delta);
        msg = "0.33 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GRAIN.toOunces(0.33), delta);
        msg = "0.6543 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GRAIN.toOunces(0.6543), delta);
        msg = "1 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GRAIN.toOunces(1.0), delta);
        msg = "1.6543 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GRAIN.toOunces(1.6543), delta);
        msg = "22.45 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GRAIN.toOunces(22.45), delta);
        msg = "9876.5432 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GRAIN.toOunces(9876.5432), delta);
        msg = "1987654344.3345 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GRAIN.toOunces(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GRAIN.toOunces(784.46789765434), delta);
        // ====================
        // ====================POUND
        // ====================
        // to_factor = 1.0
        to_factor = POUND.getFactor();
        msg = "-1 / (1 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GRAIN.toPounds(-1.0), delta);
        msg = "-0.1 / (1 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GRAIN.toPounds(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GRAIN.toPounds(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GRAIN.toPounds(-73.25), delta);
        msg = "-56229.321 / (1 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GRAIN.toPounds(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GRAIN.toPounds(-873.5432456), delta);
        msg = "0 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GRAIN.toPounds(0.0), delta);
        msg = "0.1 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GRAIN.toPounds(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GRAIN.toPounds(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GRAIN.toPounds(0.33), delta);
        msg = "0.6543 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GRAIN.toPounds(0.6543), delta);
        msg = "1 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GRAIN.toPounds(1.0), delta);
        msg = "1.6543 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GRAIN.toPounds(1.6543), delta);
        msg = "22.45 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GRAIN.toPounds(22.45), delta);
        msg = "9876.5432 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GRAIN.toPounds(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GRAIN.toPounds(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GRAIN.toPounds(784.46789765434), delta);
        // ====================
        // ====================STONE
        // ====================
        // to_factor = 16.0
        to_factor = STONE.getFactor();
        msg = "-1 / (16 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GRAIN.toStones(-1.0), delta);
        msg = "-0.1 / (16 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GRAIN.toStones(-0.1), delta);
        msg = "-0.000456789 / (16 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GRAIN.toStones(-4.56789E-4), delta);
        msg = "-73.25 / (16 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GRAIN.toStones(-73.25), delta);
        msg = "-56229.321 / (16 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GRAIN.toStones(-56229.321), delta);
        msg = "-873.5432456 / (16 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GRAIN.toStones(-873.5432456), delta);
        msg = "0 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GRAIN.toStones(0.0), delta);
        msg = "0.1 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GRAIN.toStones(0.1), delta);
        msg = "0.0000876543297 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GRAIN.toStones(8.76543297E-5), delta);
        msg = "0.33 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GRAIN.toStones(0.33), delta);
        msg = "0.6543 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GRAIN.toStones(0.6543), delta);
        msg = "1 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GRAIN.toStones(1.0), delta);
        msg = "1.6543 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GRAIN.toStones(1.6543), delta);
        msg = "22.45 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GRAIN.toStones(22.45), delta);
        msg = "9876.5432 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GRAIN.toStones(9876.5432), delta);
        msg = "1987654344.3345 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GRAIN.toStones(1.9876543443345E9), delta);
        msg = "784.46789765434 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GRAIN.toStones(784.46789765434), delta);
        // ====================
        // ====================QUARTER
        // ====================
        // to_factor = 224.0
        to_factor = QUARTER.getFactor();
        msg = "-1 / (224 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GRAIN.toQuarters(-1.0), delta);
        msg = "-0.1 / (224 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GRAIN.toQuarters(-0.1), delta);
        msg = "-0.000456789 / (224 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GRAIN.toQuarters(-4.56789E-4), delta);
        msg = "-73.25 / (224 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GRAIN.toQuarters(-73.25), delta);
        msg = "-56229.321 / (224 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GRAIN.toQuarters(-56229.321), delta);
        msg = "-873.5432456 / (224 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GRAIN.toQuarters(-873.5432456), delta);
        msg = "0 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GRAIN.toQuarters(0.0), delta);
        msg = "0.1 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GRAIN.toQuarters(0.1), delta);
        msg = "0.0000876543297 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GRAIN.toQuarters(8.76543297E-5), delta);
        msg = "0.33 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GRAIN.toQuarters(0.33), delta);
        msg = "0.6543 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GRAIN.toQuarters(0.6543), delta);
        msg = "1 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GRAIN.toQuarters(1.0), delta);
        msg = "1.6543 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GRAIN.toQuarters(1.6543), delta);
        msg = "22.45 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GRAIN.toQuarters(22.45), delta);
        msg = "9876.5432 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GRAIN.toQuarters(9876.5432), delta);
        msg = "1987654344.3345 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GRAIN.toQuarters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GRAIN.toQuarters(784.46789765434), delta);
        // ====================
        // ====================HUNDREDWEIGHT
        // ====================
        // to_factor = 448.0
        to_factor = HUNDREDWEIGHT.getFactor();
        msg = "-1 / (448 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), GRAIN.toHundredweights(-1.0), delta);
        msg = "-0.1 / (448 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), GRAIN.toHundredweights(-0.1), delta);
        msg = "-0.000456789 / (448 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), GRAIN.toHundredweights(-4.56789E-4), delta);
        msg = "-73.25 / (448 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), GRAIN.toHundredweights(-73.25), delta);
        msg = "-56229.321 / (448 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), GRAIN.toHundredweights(-56229.321), delta);
        msg = "-873.5432456 / (448 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), GRAIN.toHundredweights(-873.5432456), delta);
        msg = "0 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), GRAIN.toHundredweights(0.0), delta);
        msg = "0.1 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), GRAIN.toHundredweights(0.1), delta);
        msg = "0.0000876543297 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), GRAIN.toHundredweights(8.76543297E-5), delta);
        msg = "0.33 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), GRAIN.toHundredweights(0.33), delta);
        msg = "0.6543 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), GRAIN.toHundredweights(0.6543), delta);
        msg = "1 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), GRAIN.toHundredweights(1.0), delta);
        msg = "1.6543 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), GRAIN.toHundredweights(1.6543), delta);
        msg = "22.45 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), GRAIN.toHundredweights(22.45), delta);
        msg = "9876.5432 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), GRAIN.toHundredweights(9876.5432), delta);
        msg = "1987654344.3345 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), GRAIN.toHundredweights(1.9876543443345E9), delta);
        msg = "784.46789765434 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), GRAIN.toHundredweights(784.46789765434), delta);
    }

    @Test()
    public void testDrachm() {
        // from_factor = 0.0023148148148148147
        double from_factor = DRACHM.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================GRAIN
        // ====================
        // to_factor = 0.0023148148148148147
        to_factor = GRAIN.getFactor();
        msg = "-1 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DRACHM.toGrains(-1.0), delta);
        msg = "-0.1 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DRACHM.toGrains(-0.1), delta);
        msg = "-0.000456789 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DRACHM.toGrains(-4.56789E-4), delta);
        msg = "-73.25 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DRACHM.toGrains(-73.25), delta);
        msg = "-56229.321 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DRACHM.toGrains(-56229.321), delta);
        msg = "-873.5432456 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DRACHM.toGrains(-873.5432456), delta);
        msg = "0 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DRACHM.toGrains(0.0), delta);
        msg = "0.1 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DRACHM.toGrains(0.1), delta);
        msg = "0.0000876543297 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DRACHM.toGrains(8.76543297E-5), delta);
        msg = "0.33 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DRACHM.toGrains(0.33), delta);
        msg = "0.6543 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DRACHM.toGrains(0.6543), delta);
        msg = "1 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DRACHM.toGrains(1.0), delta);
        msg = "1.6543 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DRACHM.toGrains(1.6543), delta);
        msg = "22.45 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DRACHM.toGrains(22.45), delta);
        msg = "9876.5432 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DRACHM.toGrains(9876.5432), delta);
        msg = "1987654344.3345 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DRACHM.toGrains(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DRACHM.toGrains(784.46789765434), delta);
        // ====================
        // ====================DRACHM
        // ====================
        // to_factor = 0.0023148148148148147
        to_factor = DRACHM.getFactor();
        msg = "-1 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), DRACHM.toDrachms(-1.0), delta);
        msg = "-0.1 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), DRACHM.toDrachms(-0.1), delta);
        msg = "-0.000456789 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), DRACHM.toDrachms(-4.56789E-4), delta);
        msg = "-73.25 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), DRACHM.toDrachms(-73.25), delta);
        msg = "-56229.321 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), DRACHM.toDrachms(-56229.321), delta);
        msg = "-873.5432456 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), DRACHM.toDrachms(-873.5432456), delta);
        msg = "0 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), DRACHM.toDrachms(0.0), delta);
        msg = "0.1 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), DRACHM.toDrachms(0.1), delta);
        msg = "0.0000876543297 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), DRACHM.toDrachms(8.76543297E-5), delta);
        msg = "0.33 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), DRACHM.toDrachms(0.33), delta);
        msg = "0.6543 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), DRACHM.toDrachms(0.6543), delta);
        msg = "1 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), DRACHM.toDrachms(1.0), delta);
        msg = "1.6543 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), DRACHM.toDrachms(1.6543), delta);
        msg = "22.45 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), DRACHM.toDrachms(22.45), delta);
        msg = "9876.5432 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), DRACHM.toDrachms(9876.5432), delta);
        msg = "1987654344.3345 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), DRACHM.toDrachms(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.0023148148148148147 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), DRACHM.toDrachms(784.46789765434), delta);
        // ====================
        // ====================OUNCE
        // ====================
        // to_factor = 0.0625
        to_factor = OUNCE.getFactor();
        msg = "-1 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DRACHM.toOunces(-1.0), delta);
        msg = "-0.1 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DRACHM.toOunces(-0.1), delta);
        msg = "-0.000456789 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DRACHM.toOunces(-4.56789E-4), delta);
        msg = "-73.25 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DRACHM.toOunces(-73.25), delta);
        msg = "-56229.321 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DRACHM.toOunces(-56229.321), delta);
        msg = "-873.5432456 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DRACHM.toOunces(-873.5432456), delta);
        msg = "0 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DRACHM.toOunces(0.0), delta);
        msg = "0.1 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DRACHM.toOunces(0.1), delta);
        msg = "0.0000876543297 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DRACHM.toOunces(8.76543297E-5), delta);
        msg = "0.33 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DRACHM.toOunces(0.33), delta);
        msg = "0.6543 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DRACHM.toOunces(0.6543), delta);
        msg = "1 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DRACHM.toOunces(1.0), delta);
        msg = "1.6543 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DRACHM.toOunces(1.6543), delta);
        msg = "22.45 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DRACHM.toOunces(22.45), delta);
        msg = "9876.5432 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DRACHM.toOunces(9876.5432), delta);
        msg = "1987654344.3345 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DRACHM.toOunces(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DRACHM.toOunces(784.46789765434), delta);
        // ====================
        // ====================POUND
        // ====================
        // to_factor = 1.0
        to_factor = POUND.getFactor();
        msg = "-1 / (1 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DRACHM.toPounds(-1.0), delta);
        msg = "-0.1 / (1 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DRACHM.toPounds(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DRACHM.toPounds(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DRACHM.toPounds(-73.25), delta);
        msg = "-56229.321 / (1 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DRACHM.toPounds(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DRACHM.toPounds(-873.5432456), delta);
        msg = "0 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DRACHM.toPounds(0.0), delta);
        msg = "0.1 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DRACHM.toPounds(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DRACHM.toPounds(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DRACHM.toPounds(0.33), delta);
        msg = "0.6543 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DRACHM.toPounds(0.6543), delta);
        msg = "1 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DRACHM.toPounds(1.0), delta);
        msg = "1.6543 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DRACHM.toPounds(1.6543), delta);
        msg = "22.45 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DRACHM.toPounds(22.45), delta);
        msg = "9876.5432 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DRACHM.toPounds(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DRACHM.toPounds(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DRACHM.toPounds(784.46789765434), delta);
        // ====================
        // ====================STONE
        // ====================
        // to_factor = 16.0
        to_factor = STONE.getFactor();
        msg = "-1 / (16 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DRACHM.toStones(-1.0), delta);
        msg = "-0.1 / (16 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DRACHM.toStones(-0.1), delta);
        msg = "-0.000456789 / (16 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DRACHM.toStones(-4.56789E-4), delta);
        msg = "-73.25 / (16 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DRACHM.toStones(-73.25), delta);
        msg = "-56229.321 / (16 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DRACHM.toStones(-56229.321), delta);
        msg = "-873.5432456 / (16 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DRACHM.toStones(-873.5432456), delta);
        msg = "0 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DRACHM.toStones(0.0), delta);
        msg = "0.1 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DRACHM.toStones(0.1), delta);
        msg = "0.0000876543297 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DRACHM.toStones(8.76543297E-5), delta);
        msg = "0.33 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DRACHM.toStones(0.33), delta);
        msg = "0.6543 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DRACHM.toStones(0.6543), delta);
        msg = "1 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DRACHM.toStones(1.0), delta);
        msg = "1.6543 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DRACHM.toStones(1.6543), delta);
        msg = "22.45 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DRACHM.toStones(22.45), delta);
        msg = "9876.5432 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DRACHM.toStones(9876.5432), delta);
        msg = "1987654344.3345 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DRACHM.toStones(1.9876543443345E9), delta);
        msg = "784.46789765434 / (16 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DRACHM.toStones(784.46789765434), delta);
        // ====================
        // ====================QUARTER
        // ====================
        // to_factor = 224.0
        to_factor = QUARTER.getFactor();
        msg = "-1 / (224 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DRACHM.toQuarters(-1.0), delta);
        msg = "-0.1 / (224 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DRACHM.toQuarters(-0.1), delta);
        msg = "-0.000456789 / (224 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DRACHM.toQuarters(-4.56789E-4), delta);
        msg = "-73.25 / (224 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DRACHM.toQuarters(-73.25), delta);
        msg = "-56229.321 / (224 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DRACHM.toQuarters(-56229.321), delta);
        msg = "-873.5432456 / (224 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DRACHM.toQuarters(-873.5432456), delta);
        msg = "0 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DRACHM.toQuarters(0.0), delta);
        msg = "0.1 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DRACHM.toQuarters(0.1), delta);
        msg = "0.0000876543297 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DRACHM.toQuarters(8.76543297E-5), delta);
        msg = "0.33 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DRACHM.toQuarters(0.33), delta);
        msg = "0.6543 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DRACHM.toQuarters(0.6543), delta);
        msg = "1 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DRACHM.toQuarters(1.0), delta);
        msg = "1.6543 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DRACHM.toQuarters(1.6543), delta);
        msg = "22.45 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DRACHM.toQuarters(22.45), delta);
        msg = "9876.5432 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DRACHM.toQuarters(9876.5432), delta);
        msg = "1987654344.3345 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DRACHM.toQuarters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (224 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DRACHM.toQuarters(784.46789765434), delta);
        // ====================
        // ====================HUNDREDWEIGHT
        // ====================
        // to_factor = 448.0
        to_factor = HUNDREDWEIGHT.getFactor();
        msg = "-1 / (448 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), DRACHM.toHundredweights(-1.0), delta);
        msg = "-0.1 / (448 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), DRACHM.toHundredweights(-0.1), delta);
        msg = "-0.000456789 / (448 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), DRACHM.toHundredweights(-4.56789E-4), delta);
        msg = "-73.25 / (448 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), DRACHM.toHundredweights(-73.25), delta);
        msg = "-56229.321 / (448 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), DRACHM.toHundredweights(-56229.321), delta);
        msg = "-873.5432456 / (448 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), DRACHM.toHundredweights(-873.5432456), delta);
        msg = "0 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), DRACHM.toHundredweights(0.0), delta);
        msg = "0.1 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), DRACHM.toHundredweights(0.1), delta);
        msg = "0.0000876543297 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), DRACHM.toHundredweights(8.76543297E-5), delta);
        msg = "0.33 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), DRACHM.toHundredweights(0.33), delta);
        msg = "0.6543 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), DRACHM.toHundredweights(0.6543), delta);
        msg = "1 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), DRACHM.toHundredweights(1.0), delta);
        msg = "1.6543 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), DRACHM.toHundredweights(1.6543), delta);
        msg = "22.45 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), DRACHM.toHundredweights(22.45), delta);
        msg = "9876.5432 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), DRACHM.toHundredweights(9876.5432), delta);
        msg = "1987654344.3345 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), DRACHM.toHundredweights(1.9876543443345E9), delta);
        msg = "784.46789765434 / (448 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), DRACHM.toHundredweights(784.46789765434), delta);
    }

    @Test()
    public void testOunce() {
        // from_factor = 0.0625
        double from_factor = OUNCE.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================GRAIN
        // ====================
        // to_factor = 0.0023148148148148147
        to_factor = GRAIN.getFactor();
        msg = "-1 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), OUNCE.toGrains(-1.0), delta);
        msg = "-0.1 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), OUNCE.toGrains(-0.1), delta);
        msg = "-0.000456789 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), OUNCE.toGrains(-4.56789E-4), delta);
        msg = "-73.25 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), OUNCE.toGrains(-73.25), delta);
        msg = "-56229.321 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), OUNCE.toGrains(-56229.321), delta);
        msg = "-873.5432456 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), OUNCE.toGrains(-873.5432456), delta);
        msg = "0 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), OUNCE.toGrains(0.0), delta);
        msg = "0.1 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), OUNCE.toGrains(0.1), delta);
        msg = "0.0000876543297 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), OUNCE.toGrains(8.76543297E-5), delta);
        msg = "0.33 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), OUNCE.toGrains(0.33), delta);
        msg = "0.6543 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), OUNCE.toGrains(0.6543), delta);
        msg = "1 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), OUNCE.toGrains(1.0), delta);
        msg = "1.6543 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), OUNCE.toGrains(1.6543), delta);
        msg = "22.45 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), OUNCE.toGrains(22.45), delta);
        msg = "9876.5432 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), OUNCE.toGrains(9876.5432), delta);
        msg = "1987654344.3345 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), OUNCE.toGrains(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), OUNCE.toGrains(784.46789765434), delta);
        // ====================
        // ====================DRACHM
        // ====================
        // to_factor = 0.0023148148148148147
        to_factor = DRACHM.getFactor();
        msg = "-1 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), OUNCE.toDrachms(-1.0), delta);
        msg = "-0.1 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), OUNCE.toDrachms(-0.1), delta);
        msg = "-0.000456789 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), OUNCE.toDrachms(-4.56789E-4), delta);
        msg = "-73.25 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), OUNCE.toDrachms(-73.25), delta);
        msg = "-56229.321 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), OUNCE.toDrachms(-56229.321), delta);
        msg = "-873.5432456 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), OUNCE.toDrachms(-873.5432456), delta);
        msg = "0 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), OUNCE.toDrachms(0.0), delta);
        msg = "0.1 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), OUNCE.toDrachms(0.1), delta);
        msg = "0.0000876543297 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), OUNCE.toDrachms(8.76543297E-5), delta);
        msg = "0.33 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), OUNCE.toDrachms(0.33), delta);
        msg = "0.6543 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), OUNCE.toDrachms(0.6543), delta);
        msg = "1 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), OUNCE.toDrachms(1.0), delta);
        msg = "1.6543 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), OUNCE.toDrachms(1.6543), delta);
        msg = "22.45 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), OUNCE.toDrachms(22.45), delta);
        msg = "9876.5432 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), OUNCE.toDrachms(9876.5432), delta);
        msg = "1987654344.3345 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), OUNCE.toDrachms(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.0625 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), OUNCE.toDrachms(784.46789765434), delta);
        // ====================
        // ====================OUNCE
        // ====================
        // to_factor = 0.0625
        to_factor = OUNCE.getFactor();
        msg = "-1 * (0.0625 / 0.0625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), OUNCE.toOunces(-1.0), delta);
        msg = "-0.1 * (0.0625 / 0.0625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), OUNCE.toOunces(-0.1), delta);
        msg = "-0.000456789 * (0.0625 / 0.0625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), OUNCE.toOunces(-4.56789E-4), delta);
        msg = "-73.25 * (0.0625 / 0.0625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), OUNCE.toOunces(-73.25), delta);
        msg = "-56229.321 * (0.0625 / 0.0625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), OUNCE.toOunces(-56229.321), delta);
        msg = "-873.5432456 * (0.0625 / 0.0625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), OUNCE.toOunces(-873.5432456), delta);
        msg = "0 * (0.0625 / 0.0625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), OUNCE.toOunces(0.0), delta);
        msg = "0.1 * (0.0625 / 0.0625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), OUNCE.toOunces(0.1), delta);
        msg = "0.0000876543297 * (0.0625 / 0.0625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), OUNCE.toOunces(8.76543297E-5), delta);
        msg = "0.33 * (0.0625 / 0.0625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), OUNCE.toOunces(0.33), delta);
        msg = "0.6543 * (0.0625 / 0.0625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), OUNCE.toOunces(0.6543), delta);
        msg = "1 * (0.0625 / 0.0625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), OUNCE.toOunces(1.0), delta);
        msg = "1.6543 * (0.0625 / 0.0625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), OUNCE.toOunces(1.6543), delta);
        msg = "22.45 * (0.0625 / 0.0625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), OUNCE.toOunces(22.45), delta);
        msg = "9876.5432 * (0.0625 / 0.0625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), OUNCE.toOunces(9876.5432), delta);
        msg = "1987654344.3345 * (0.0625 / 0.0625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), OUNCE.toOunces(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.0625 / 0.0625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), OUNCE.toOunces(784.46789765434), delta);
        // ====================
        // ====================POUND
        // ====================
        // to_factor = 1.0
        to_factor = POUND.getFactor();
        msg = "-1 / (1 / 0.0625)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), OUNCE.toPounds(-1.0), delta);
        msg = "-0.1 / (1 / 0.0625)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), OUNCE.toPounds(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.0625)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), OUNCE.toPounds(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.0625)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), OUNCE.toPounds(-73.25), delta);
        msg = "-56229.321 / (1 / 0.0625)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), OUNCE.toPounds(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.0625)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), OUNCE.toPounds(-873.5432456), delta);
        msg = "0 / (1 / 0.0625)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), OUNCE.toPounds(0.0), delta);
        msg = "0.1 / (1 / 0.0625)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), OUNCE.toPounds(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.0625)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), OUNCE.toPounds(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.0625)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), OUNCE.toPounds(0.33), delta);
        msg = "0.6543 / (1 / 0.0625)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), OUNCE.toPounds(0.6543), delta);
        msg = "1 / (1 / 0.0625)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), OUNCE.toPounds(1.0), delta);
        msg = "1.6543 / (1 / 0.0625)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), OUNCE.toPounds(1.6543), delta);
        msg = "22.45 / (1 / 0.0625)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), OUNCE.toPounds(22.45), delta);
        msg = "9876.5432 / (1 / 0.0625)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), OUNCE.toPounds(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.0625)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), OUNCE.toPounds(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.0625)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), OUNCE.toPounds(784.46789765434), delta);
        // ====================
        // ====================STONE
        // ====================
        // to_factor = 16.0
        to_factor = STONE.getFactor();
        msg = "-1 / (16 / 0.0625)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), OUNCE.toStones(-1.0), delta);
        msg = "-0.1 / (16 / 0.0625)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), OUNCE.toStones(-0.1), delta);
        msg = "-0.000456789 / (16 / 0.0625)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), OUNCE.toStones(-4.56789E-4), delta);
        msg = "-73.25 / (16 / 0.0625)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), OUNCE.toStones(-73.25), delta);
        msg = "-56229.321 / (16 / 0.0625)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), OUNCE.toStones(-56229.321), delta);
        msg = "-873.5432456 / (16 / 0.0625)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), OUNCE.toStones(-873.5432456), delta);
        msg = "0 / (16 / 0.0625)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), OUNCE.toStones(0.0), delta);
        msg = "0.1 / (16 / 0.0625)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), OUNCE.toStones(0.1), delta);
        msg = "0.0000876543297 / (16 / 0.0625)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), OUNCE.toStones(8.76543297E-5), delta);
        msg = "0.33 / (16 / 0.0625)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), OUNCE.toStones(0.33), delta);
        msg = "0.6543 / (16 / 0.0625)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), OUNCE.toStones(0.6543), delta);
        msg = "1 / (16 / 0.0625)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), OUNCE.toStones(1.0), delta);
        msg = "1.6543 / (16 / 0.0625)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), OUNCE.toStones(1.6543), delta);
        msg = "22.45 / (16 / 0.0625)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), OUNCE.toStones(22.45), delta);
        msg = "9876.5432 / (16 / 0.0625)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), OUNCE.toStones(9876.5432), delta);
        msg = "1987654344.3345 / (16 / 0.0625)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), OUNCE.toStones(1.9876543443345E9), delta);
        msg = "784.46789765434 / (16 / 0.0625)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), OUNCE.toStones(784.46789765434), delta);
        // ====================
        // ====================QUARTER
        // ====================
        // to_factor = 224.0
        to_factor = QUARTER.getFactor();
        msg = "-1 / (224 / 0.0625)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), OUNCE.toQuarters(-1.0), delta);
        msg = "-0.1 / (224 / 0.0625)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), OUNCE.toQuarters(-0.1), delta);
        msg = "-0.000456789 / (224 / 0.0625)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), OUNCE.toQuarters(-4.56789E-4), delta);
        msg = "-73.25 / (224 / 0.0625)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), OUNCE.toQuarters(-73.25), delta);
        msg = "-56229.321 / (224 / 0.0625)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), OUNCE.toQuarters(-56229.321), delta);
        msg = "-873.5432456 / (224 / 0.0625)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), OUNCE.toQuarters(-873.5432456), delta);
        msg = "0 / (224 / 0.0625)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), OUNCE.toQuarters(0.0), delta);
        msg = "0.1 / (224 / 0.0625)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), OUNCE.toQuarters(0.1), delta);
        msg = "0.0000876543297 / (224 / 0.0625)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), OUNCE.toQuarters(8.76543297E-5), delta);
        msg = "0.33 / (224 / 0.0625)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), OUNCE.toQuarters(0.33), delta);
        msg = "0.6543 / (224 / 0.0625)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), OUNCE.toQuarters(0.6543), delta);
        msg = "1 / (224 / 0.0625)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), OUNCE.toQuarters(1.0), delta);
        msg = "1.6543 / (224 / 0.0625)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), OUNCE.toQuarters(1.6543), delta);
        msg = "22.45 / (224 / 0.0625)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), OUNCE.toQuarters(22.45), delta);
        msg = "9876.5432 / (224 / 0.0625)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), OUNCE.toQuarters(9876.5432), delta);
        msg = "1987654344.3345 / (224 / 0.0625)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), OUNCE.toQuarters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (224 / 0.0625)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), OUNCE.toQuarters(784.46789765434), delta);
        // ====================
        // ====================HUNDREDWEIGHT
        // ====================
        // to_factor = 448.0
        to_factor = HUNDREDWEIGHT.getFactor();
        msg = "-1 / (448 / 0.0625)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), OUNCE.toHundredweights(-1.0), delta);
        msg = "-0.1 / (448 / 0.0625)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), OUNCE.toHundredweights(-0.1), delta);
        msg = "-0.000456789 / (448 / 0.0625)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), OUNCE.toHundredweights(-4.56789E-4), delta);
        msg = "-73.25 / (448 / 0.0625)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), OUNCE.toHundredweights(-73.25), delta);
        msg = "-56229.321 / (448 / 0.0625)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), OUNCE.toHundredweights(-56229.321), delta);
        msg = "-873.5432456 / (448 / 0.0625)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), OUNCE.toHundredweights(-873.5432456), delta);
        msg = "0 / (448 / 0.0625)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), OUNCE.toHundredweights(0.0), delta);
        msg = "0.1 / (448 / 0.0625)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), OUNCE.toHundredweights(0.1), delta);
        msg = "0.0000876543297 / (448 / 0.0625)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), OUNCE.toHundredweights(8.76543297E-5), delta);
        msg = "0.33 / (448 / 0.0625)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), OUNCE.toHundredweights(0.33), delta);
        msg = "0.6543 / (448 / 0.0625)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), OUNCE.toHundredweights(0.6543), delta);
        msg = "1 / (448 / 0.0625)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), OUNCE.toHundredweights(1.0), delta);
        msg = "1.6543 / (448 / 0.0625)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), OUNCE.toHundredweights(1.6543), delta);
        msg = "22.45 / (448 / 0.0625)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), OUNCE.toHundredweights(22.45), delta);
        msg = "9876.5432 / (448 / 0.0625)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), OUNCE.toHundredweights(9876.5432), delta);
        msg = "1987654344.3345 / (448 / 0.0625)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), OUNCE.toHundredweights(1.9876543443345E9), delta);
        msg = "784.46789765434 / (448 / 0.0625)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), OUNCE.toHundredweights(784.46789765434), delta);
    }

    @Test()
    public void testPound() {
        // from_factor = 1.0
        double from_factor = POUND.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================GRAIN
        // ====================
        // to_factor = 0.0023148148148148147
        to_factor = GRAIN.getFactor();
        msg = "-1 * (1 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), POUND.toGrains(-1.0), delta);
        msg = "-0.1 * (1 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), POUND.toGrains(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), POUND.toGrains(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), POUND.toGrains(-73.25), delta);
        msg = "-56229.321 * (1 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), POUND.toGrains(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), POUND.toGrains(-873.5432456), delta);
        msg = "0 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), POUND.toGrains(0.0), delta);
        msg = "0.1 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), POUND.toGrains(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), POUND.toGrains(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), POUND.toGrains(0.33), delta);
        msg = "0.6543 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), POUND.toGrains(0.6543), delta);
        msg = "1 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), POUND.toGrains(1.0), delta);
        msg = "1.6543 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), POUND.toGrains(1.6543), delta);
        msg = "22.45 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), POUND.toGrains(22.45), delta);
        msg = "9876.5432 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), POUND.toGrains(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), POUND.toGrains(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), POUND.toGrains(784.46789765434), delta);
        // ====================
        // ====================DRACHM
        // ====================
        // to_factor = 0.0023148148148148147
        to_factor = DRACHM.getFactor();
        msg = "-1 * (1 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), POUND.toDrachms(-1.0), delta);
        msg = "-0.1 * (1 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), POUND.toDrachms(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), POUND.toDrachms(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), POUND.toDrachms(-73.25), delta);
        msg = "-56229.321 * (1 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), POUND.toDrachms(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), POUND.toDrachms(-873.5432456), delta);
        msg = "0 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), POUND.toDrachms(0.0), delta);
        msg = "0.1 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), POUND.toDrachms(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), POUND.toDrachms(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), POUND.toDrachms(0.33), delta);
        msg = "0.6543 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), POUND.toDrachms(0.6543), delta);
        msg = "1 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), POUND.toDrachms(1.0), delta);
        msg = "1.6543 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), POUND.toDrachms(1.6543), delta);
        msg = "22.45 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), POUND.toDrachms(22.45), delta);
        msg = "9876.5432 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), POUND.toDrachms(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), POUND.toDrachms(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), POUND.toDrachms(784.46789765434), delta);
        // ====================
        // ====================OUNCE
        // ====================
        // to_factor = 0.0625
        to_factor = OUNCE.getFactor();
        msg = "-1 * (1 / 0.0625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), POUND.toOunces(-1.0), delta);
        msg = "-0.1 * (1 / 0.0625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), POUND.toOunces(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.0625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), POUND.toOunces(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.0625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), POUND.toOunces(-73.25), delta);
        msg = "-56229.321 * (1 / 0.0625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), POUND.toOunces(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.0625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), POUND.toOunces(-873.5432456), delta);
        msg = "0 * (1 / 0.0625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), POUND.toOunces(0.0), delta);
        msg = "0.1 * (1 / 0.0625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), POUND.toOunces(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.0625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), POUND.toOunces(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.0625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), POUND.toOunces(0.33), delta);
        msg = "0.6543 * (1 / 0.0625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), POUND.toOunces(0.6543), delta);
        msg = "1 * (1 / 0.0625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), POUND.toOunces(1.0), delta);
        msg = "1.6543 * (1 / 0.0625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), POUND.toOunces(1.6543), delta);
        msg = "22.45 * (1 / 0.0625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), POUND.toOunces(22.45), delta);
        msg = "9876.5432 * (1 / 0.0625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), POUND.toOunces(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.0625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), POUND.toOunces(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.0625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), POUND.toOunces(784.46789765434), delta);
        // ====================
        // ====================POUND
        // ====================
        // to_factor = 1.0
        to_factor = POUND.getFactor();
        msg = "-1 * (1 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), POUND.toPounds(-1.0), delta);
        msg = "-0.1 * (1 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), POUND.toPounds(-0.1), delta);
        msg = "-0.000456789 * (1 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), POUND.toPounds(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), POUND.toPounds(-73.25), delta);
        msg = "-56229.321 * (1 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), POUND.toPounds(-56229.321), delta);
        msg = "-873.5432456 * (1 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), POUND.toPounds(-873.5432456), delta);
        msg = "0 * (1 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), POUND.toPounds(0.0), delta);
        msg = "0.1 * (1 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), POUND.toPounds(0.1), delta);
        msg = "0.0000876543297 * (1 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), POUND.toPounds(8.76543297E-5), delta);
        msg = "0.33 * (1 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), POUND.toPounds(0.33), delta);
        msg = "0.6543 * (1 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), POUND.toPounds(0.6543), delta);
        msg = "1 * (1 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), POUND.toPounds(1.0), delta);
        msg = "1.6543 * (1 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), POUND.toPounds(1.6543), delta);
        msg = "22.45 * (1 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), POUND.toPounds(22.45), delta);
        msg = "9876.5432 * (1 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), POUND.toPounds(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), POUND.toPounds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), POUND.toPounds(784.46789765434), delta);
        // ====================
        // ====================STONE
        // ====================
        // to_factor = 16.0
        to_factor = STONE.getFactor();
        msg = "-1 / (16 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), POUND.toStones(-1.0), delta);
        msg = "-0.1 / (16 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), POUND.toStones(-0.1), delta);
        msg = "-0.000456789 / (16 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), POUND.toStones(-4.56789E-4), delta);
        msg = "-73.25 / (16 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), POUND.toStones(-73.25), delta);
        msg = "-56229.321 / (16 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), POUND.toStones(-56229.321), delta);
        msg = "-873.5432456 / (16 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), POUND.toStones(-873.5432456), delta);
        msg = "0 / (16 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), POUND.toStones(0.0), delta);
        msg = "0.1 / (16 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), POUND.toStones(0.1), delta);
        msg = "0.0000876543297 / (16 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), POUND.toStones(8.76543297E-5), delta);
        msg = "0.33 / (16 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), POUND.toStones(0.33), delta);
        msg = "0.6543 / (16 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), POUND.toStones(0.6543), delta);
        msg = "1 / (16 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), POUND.toStones(1.0), delta);
        msg = "1.6543 / (16 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), POUND.toStones(1.6543), delta);
        msg = "22.45 / (16 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), POUND.toStones(22.45), delta);
        msg = "9876.5432 / (16 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), POUND.toStones(9876.5432), delta);
        msg = "1987654344.3345 / (16 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), POUND.toStones(1.9876543443345E9), delta);
        msg = "784.46789765434 / (16 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), POUND.toStones(784.46789765434), delta);
        // ====================
        // ====================QUARTER
        // ====================
        // to_factor = 224.0
        to_factor = QUARTER.getFactor();
        msg = "-1 / (224 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), POUND.toQuarters(-1.0), delta);
        msg = "-0.1 / (224 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), POUND.toQuarters(-0.1), delta);
        msg = "-0.000456789 / (224 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), POUND.toQuarters(-4.56789E-4), delta);
        msg = "-73.25 / (224 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), POUND.toQuarters(-73.25), delta);
        msg = "-56229.321 / (224 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), POUND.toQuarters(-56229.321), delta);
        msg = "-873.5432456 / (224 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), POUND.toQuarters(-873.5432456), delta);
        msg = "0 / (224 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), POUND.toQuarters(0.0), delta);
        msg = "0.1 / (224 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), POUND.toQuarters(0.1), delta);
        msg = "0.0000876543297 / (224 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), POUND.toQuarters(8.76543297E-5), delta);
        msg = "0.33 / (224 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), POUND.toQuarters(0.33), delta);
        msg = "0.6543 / (224 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), POUND.toQuarters(0.6543), delta);
        msg = "1 / (224 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), POUND.toQuarters(1.0), delta);
        msg = "1.6543 / (224 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), POUND.toQuarters(1.6543), delta);
        msg = "22.45 / (224 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), POUND.toQuarters(22.45), delta);
        msg = "9876.5432 / (224 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), POUND.toQuarters(9876.5432), delta);
        msg = "1987654344.3345 / (224 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), POUND.toQuarters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (224 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), POUND.toQuarters(784.46789765434), delta);
        // ====================
        // ====================HUNDREDWEIGHT
        // ====================
        // to_factor = 448.0
        to_factor = HUNDREDWEIGHT.getFactor();
        msg = "-1 / (448 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), POUND.toHundredweights(-1.0), delta);
        msg = "-0.1 / (448 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), POUND.toHundredweights(-0.1), delta);
        msg = "-0.000456789 / (448 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), POUND.toHundredweights(-4.56789E-4), delta);
        msg = "-73.25 / (448 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), POUND.toHundredweights(-73.25), delta);
        msg = "-56229.321 / (448 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), POUND.toHundredweights(-56229.321), delta);
        msg = "-873.5432456 / (448 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), POUND.toHundredweights(-873.5432456), delta);
        msg = "0 / (448 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), POUND.toHundredweights(0.0), delta);
        msg = "0.1 / (448 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), POUND.toHundredweights(0.1), delta);
        msg = "0.0000876543297 / (448 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), POUND.toHundredweights(8.76543297E-5), delta);
        msg = "0.33 / (448 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), POUND.toHundredweights(0.33), delta);
        msg = "0.6543 / (448 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), POUND.toHundredweights(0.6543), delta);
        msg = "1 / (448 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), POUND.toHundredweights(1.0), delta);
        msg = "1.6543 / (448 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), POUND.toHundredweights(1.6543), delta);
        msg = "22.45 / (448 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), POUND.toHundredweights(22.45), delta);
        msg = "9876.5432 / (448 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), POUND.toHundredweights(9876.5432), delta);
        msg = "1987654344.3345 / (448 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), POUND.toHundredweights(1.9876543443345E9), delta);
        msg = "784.46789765434 / (448 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), POUND.toHundredweights(784.46789765434), delta);
    }

    @Test()
    public void testStone() {
        // from_factor = 16.0
        double from_factor = STONE.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================GRAIN
        // ====================
        // to_factor = 0.0023148148148148147
        to_factor = GRAIN.getFactor();
        msg = "-1 * (16 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), STONE.toGrains(-1.0), delta);
        msg = "-0.1 * (16 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), STONE.toGrains(-0.1), delta);
        msg = "-0.000456789 * (16 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), STONE.toGrains(-4.56789E-4), delta);
        msg = "-73.25 * (16 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), STONE.toGrains(-73.25), delta);
        msg = "-56229.321 * (16 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), STONE.toGrains(-56229.321), delta);
        msg = "-873.5432456 * (16 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), STONE.toGrains(-873.5432456), delta);
        msg = "0 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), STONE.toGrains(0.0), delta);
        msg = "0.1 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), STONE.toGrains(0.1), delta);
        msg = "0.0000876543297 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), STONE.toGrains(8.76543297E-5), delta);
        msg = "0.33 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), STONE.toGrains(0.33), delta);
        msg = "0.6543 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), STONE.toGrains(0.6543), delta);
        msg = "1 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), STONE.toGrains(1.0), delta);
        msg = "1.6543 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), STONE.toGrains(1.6543), delta);
        msg = "22.45 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), STONE.toGrains(22.45), delta);
        msg = "9876.5432 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), STONE.toGrains(9876.5432), delta);
        msg = "1987654344.3345 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), STONE.toGrains(1.9876543443345E9), delta);
        msg = "784.46789765434 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), STONE.toGrains(784.46789765434), delta);
        // ====================
        // ====================DRACHM
        // ====================
        // to_factor = 0.0023148148148148147
        to_factor = DRACHM.getFactor();
        msg = "-1 * (16 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), STONE.toDrachms(-1.0), delta);
        msg = "-0.1 * (16 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), STONE.toDrachms(-0.1), delta);
        msg = "-0.000456789 * (16 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), STONE.toDrachms(-4.56789E-4), delta);
        msg = "-73.25 * (16 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), STONE.toDrachms(-73.25), delta);
        msg = "-56229.321 * (16 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), STONE.toDrachms(-56229.321), delta);
        msg = "-873.5432456 * (16 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), STONE.toDrachms(-873.5432456), delta);
        msg = "0 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), STONE.toDrachms(0.0), delta);
        msg = "0.1 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), STONE.toDrachms(0.1), delta);
        msg = "0.0000876543297 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), STONE.toDrachms(8.76543297E-5), delta);
        msg = "0.33 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), STONE.toDrachms(0.33), delta);
        msg = "0.6543 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), STONE.toDrachms(0.6543), delta);
        msg = "1 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), STONE.toDrachms(1.0), delta);
        msg = "1.6543 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), STONE.toDrachms(1.6543), delta);
        msg = "22.45 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), STONE.toDrachms(22.45), delta);
        msg = "9876.5432 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), STONE.toDrachms(9876.5432), delta);
        msg = "1987654344.3345 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), STONE.toDrachms(1.9876543443345E9), delta);
        msg = "784.46789765434 * (16 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), STONE.toDrachms(784.46789765434), delta);
        // ====================
        // ====================OUNCE
        // ====================
        // to_factor = 0.0625
        to_factor = OUNCE.getFactor();
        msg = "-1 * (16 / 0.0625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), STONE.toOunces(-1.0), delta);
        msg = "-0.1 * (16 / 0.0625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), STONE.toOunces(-0.1), delta);
        msg = "-0.000456789 * (16 / 0.0625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), STONE.toOunces(-4.56789E-4), delta);
        msg = "-73.25 * (16 / 0.0625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), STONE.toOunces(-73.25), delta);
        msg = "-56229.321 * (16 / 0.0625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), STONE.toOunces(-56229.321), delta);
        msg = "-873.5432456 * (16 / 0.0625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), STONE.toOunces(-873.5432456), delta);
        msg = "0 * (16 / 0.0625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), STONE.toOunces(0.0), delta);
        msg = "0.1 * (16 / 0.0625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), STONE.toOunces(0.1), delta);
        msg = "0.0000876543297 * (16 / 0.0625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), STONE.toOunces(8.76543297E-5), delta);
        msg = "0.33 * (16 / 0.0625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), STONE.toOunces(0.33), delta);
        msg = "0.6543 * (16 / 0.0625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), STONE.toOunces(0.6543), delta);
        msg = "1 * (16 / 0.0625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), STONE.toOunces(1.0), delta);
        msg = "1.6543 * (16 / 0.0625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), STONE.toOunces(1.6543), delta);
        msg = "22.45 * (16 / 0.0625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), STONE.toOunces(22.45), delta);
        msg = "9876.5432 * (16 / 0.0625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), STONE.toOunces(9876.5432), delta);
        msg = "1987654344.3345 * (16 / 0.0625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), STONE.toOunces(1.9876543443345E9), delta);
        msg = "784.46789765434 * (16 / 0.0625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), STONE.toOunces(784.46789765434), delta);
        // ====================
        // ====================POUND
        // ====================
        // to_factor = 1.0
        to_factor = POUND.getFactor();
        msg = "-1 * (16 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), STONE.toPounds(-1.0), delta);
        msg = "-0.1 * (16 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), STONE.toPounds(-0.1), delta);
        msg = "-0.000456789 * (16 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), STONE.toPounds(-4.56789E-4), delta);
        msg = "-73.25 * (16 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), STONE.toPounds(-73.25), delta);
        msg = "-56229.321 * (16 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), STONE.toPounds(-56229.321), delta);
        msg = "-873.5432456 * (16 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), STONE.toPounds(-873.5432456), delta);
        msg = "0 * (16 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), STONE.toPounds(0.0), delta);
        msg = "0.1 * (16 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), STONE.toPounds(0.1), delta);
        msg = "0.0000876543297 * (16 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), STONE.toPounds(8.76543297E-5), delta);
        msg = "0.33 * (16 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), STONE.toPounds(0.33), delta);
        msg = "0.6543 * (16 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), STONE.toPounds(0.6543), delta);
        msg = "1 * (16 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), STONE.toPounds(1.0), delta);
        msg = "1.6543 * (16 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), STONE.toPounds(1.6543), delta);
        msg = "22.45 * (16 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), STONE.toPounds(22.45), delta);
        msg = "9876.5432 * (16 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), STONE.toPounds(9876.5432), delta);
        msg = "1987654344.3345 * (16 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), STONE.toPounds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (16 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), STONE.toPounds(784.46789765434), delta);
        // ====================
        // ====================STONE
        // ====================
        // to_factor = 16.0
        to_factor = STONE.getFactor();
        msg = "-1 * (16 / 16)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), STONE.toStones(-1.0), delta);
        msg = "-0.1 * (16 / 16)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), STONE.toStones(-0.1), delta);
        msg = "-0.000456789 * (16 / 16)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), STONE.toStones(-4.56789E-4), delta);
        msg = "-73.25 * (16 / 16)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), STONE.toStones(-73.25), delta);
        msg = "-56229.321 * (16 / 16)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), STONE.toStones(-56229.321), delta);
        msg = "-873.5432456 * (16 / 16)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), STONE.toStones(-873.5432456), delta);
        msg = "0 * (16 / 16)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), STONE.toStones(0.0), delta);
        msg = "0.1 * (16 / 16)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), STONE.toStones(0.1), delta);
        msg = "0.0000876543297 * (16 / 16)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), STONE.toStones(8.76543297E-5), delta);
        msg = "0.33 * (16 / 16)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), STONE.toStones(0.33), delta);
        msg = "0.6543 * (16 / 16)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), STONE.toStones(0.6543), delta);
        msg = "1 * (16 / 16)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), STONE.toStones(1.0), delta);
        msg = "1.6543 * (16 / 16)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), STONE.toStones(1.6543), delta);
        msg = "22.45 * (16 / 16)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), STONE.toStones(22.45), delta);
        msg = "9876.5432 * (16 / 16)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), STONE.toStones(9876.5432), delta);
        msg = "1987654344.3345 * (16 / 16)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), STONE.toStones(1.9876543443345E9), delta);
        msg = "784.46789765434 * (16 / 16)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), STONE.toStones(784.46789765434), delta);
        // ====================
        // ====================QUARTER
        // ====================
        // to_factor = 224.0
        to_factor = QUARTER.getFactor();
        msg = "-1 / (224 / 16)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), STONE.toQuarters(-1.0), delta);
        msg = "-0.1 / (224 / 16)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), STONE.toQuarters(-0.1), delta);
        msg = "-0.000456789 / (224 / 16)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), STONE.toQuarters(-4.56789E-4), delta);
        msg = "-73.25 / (224 / 16)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), STONE.toQuarters(-73.25), delta);
        msg = "-56229.321 / (224 / 16)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), STONE.toQuarters(-56229.321), delta);
        msg = "-873.5432456 / (224 / 16)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), STONE.toQuarters(-873.5432456), delta);
        msg = "0 / (224 / 16)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), STONE.toQuarters(0.0), delta);
        msg = "0.1 / (224 / 16)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), STONE.toQuarters(0.1), delta);
        msg = "0.0000876543297 / (224 / 16)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), STONE.toQuarters(8.76543297E-5), delta);
        msg = "0.33 / (224 / 16)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), STONE.toQuarters(0.33), delta);
        msg = "0.6543 / (224 / 16)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), STONE.toQuarters(0.6543), delta);
        msg = "1 / (224 / 16)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), STONE.toQuarters(1.0), delta);
        msg = "1.6543 / (224 / 16)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), STONE.toQuarters(1.6543), delta);
        msg = "22.45 / (224 / 16)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), STONE.toQuarters(22.45), delta);
        msg = "9876.5432 / (224 / 16)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), STONE.toQuarters(9876.5432), delta);
        msg = "1987654344.3345 / (224 / 16)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), STONE.toQuarters(1.9876543443345E9), delta);
        msg = "784.46789765434 / (224 / 16)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), STONE.toQuarters(784.46789765434), delta);
        // ====================
        // ====================HUNDREDWEIGHT
        // ====================
        // to_factor = 448.0
        to_factor = HUNDREDWEIGHT.getFactor();
        msg = "-1 / (448 / 16)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), STONE.toHundredweights(-1.0), delta);
        msg = "-0.1 / (448 / 16)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), STONE.toHundredweights(-0.1), delta);
        msg = "-0.000456789 / (448 / 16)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), STONE.toHundredweights(-4.56789E-4), delta);
        msg = "-73.25 / (448 / 16)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), STONE.toHundredweights(-73.25), delta);
        msg = "-56229.321 / (448 / 16)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), STONE.toHundredweights(-56229.321), delta);
        msg = "-873.5432456 / (448 / 16)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), STONE.toHundredweights(-873.5432456), delta);
        msg = "0 / (448 / 16)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), STONE.toHundredweights(0.0), delta);
        msg = "0.1 / (448 / 16)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), STONE.toHundredweights(0.1), delta);
        msg = "0.0000876543297 / (448 / 16)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), STONE.toHundredweights(8.76543297E-5), delta);
        msg = "0.33 / (448 / 16)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), STONE.toHundredweights(0.33), delta);
        msg = "0.6543 / (448 / 16)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), STONE.toHundredweights(0.6543), delta);
        msg = "1 / (448 / 16)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), STONE.toHundredweights(1.0), delta);
        msg = "1.6543 / (448 / 16)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), STONE.toHundredweights(1.6543), delta);
        msg = "22.45 / (448 / 16)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), STONE.toHundredweights(22.45), delta);
        msg = "9876.5432 / (448 / 16)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), STONE.toHundredweights(9876.5432), delta);
        msg = "1987654344.3345 / (448 / 16)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), STONE.toHundredweights(1.9876543443345E9), delta);
        msg = "784.46789765434 / (448 / 16)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), STONE.toHundredweights(784.46789765434), delta);
    }

    @Test()
    public void testQuarter() {
        // from_factor = 224.0
        double from_factor = QUARTER.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================GRAIN
        // ====================
        // to_factor = 0.0023148148148148147
        to_factor = GRAIN.getFactor();
        msg = "-1 * (224 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), QUARTER.toGrains(-1.0), delta);
        msg = "-0.1 * (224 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), QUARTER.toGrains(-0.1), delta);
        msg = "-0.000456789 * (224 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), QUARTER.toGrains(-4.56789E-4), delta);
        msg = "-73.25 * (224 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), QUARTER.toGrains(-73.25), delta);
        msg = "-56229.321 * (224 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), QUARTER.toGrains(-56229.321), delta);
        msg = "-873.5432456 * (224 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), QUARTER.toGrains(-873.5432456), delta);
        msg = "0 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), QUARTER.toGrains(0.0), delta);
        msg = "0.1 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), QUARTER.toGrains(0.1), delta);
        msg = "0.0000876543297 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), QUARTER.toGrains(8.76543297E-5), delta);
        msg = "0.33 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), QUARTER.toGrains(0.33), delta);
        msg = "0.6543 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), QUARTER.toGrains(0.6543), delta);
        msg = "1 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), QUARTER.toGrains(1.0), delta);
        msg = "1.6543 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), QUARTER.toGrains(1.6543), delta);
        msg = "22.45 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), QUARTER.toGrains(22.45), delta);
        msg = "9876.5432 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), QUARTER.toGrains(9876.5432), delta);
        msg = "1987654344.3345 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), QUARTER.toGrains(1.9876543443345E9), delta);
        msg = "784.46789765434 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), QUARTER.toGrains(784.46789765434), delta);
        // ====================
        // ====================DRACHM
        // ====================
        // to_factor = 0.0023148148148148147
        to_factor = DRACHM.getFactor();
        msg = "-1 * (224 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), QUARTER.toDrachms(-1.0), delta);
        msg = "-0.1 * (224 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), QUARTER.toDrachms(-0.1), delta);
        msg = "-0.000456789 * (224 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), QUARTER.toDrachms(-4.56789E-4), delta);
        msg = "-73.25 * (224 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), QUARTER.toDrachms(-73.25), delta);
        msg = "-56229.321 * (224 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), QUARTER.toDrachms(-56229.321), delta);
        msg = "-873.5432456 * (224 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), QUARTER.toDrachms(-873.5432456), delta);
        msg = "0 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), QUARTER.toDrachms(0.0), delta);
        msg = "0.1 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), QUARTER.toDrachms(0.1), delta);
        msg = "0.0000876543297 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), QUARTER.toDrachms(8.76543297E-5), delta);
        msg = "0.33 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), QUARTER.toDrachms(0.33), delta);
        msg = "0.6543 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), QUARTER.toDrachms(0.6543), delta);
        msg = "1 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), QUARTER.toDrachms(1.0), delta);
        msg = "1.6543 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), QUARTER.toDrachms(1.6543), delta);
        msg = "22.45 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), QUARTER.toDrachms(22.45), delta);
        msg = "9876.5432 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), QUARTER.toDrachms(9876.5432), delta);
        msg = "1987654344.3345 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), QUARTER.toDrachms(1.9876543443345E9), delta);
        msg = "784.46789765434 * (224 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), QUARTER.toDrachms(784.46789765434), delta);
        // ====================
        // ====================OUNCE
        // ====================
        // to_factor = 0.0625
        to_factor = OUNCE.getFactor();
        msg = "-1 * (224 / 0.0625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), QUARTER.toOunces(-1.0), delta);
        msg = "-0.1 * (224 / 0.0625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), QUARTER.toOunces(-0.1), delta);
        msg = "-0.000456789 * (224 / 0.0625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), QUARTER.toOunces(-4.56789E-4), delta);
        msg = "-73.25 * (224 / 0.0625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), QUARTER.toOunces(-73.25), delta);
        msg = "-56229.321 * (224 / 0.0625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), QUARTER.toOunces(-56229.321), delta);
        msg = "-873.5432456 * (224 / 0.0625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), QUARTER.toOunces(-873.5432456), delta);
        msg = "0 * (224 / 0.0625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), QUARTER.toOunces(0.0), delta);
        msg = "0.1 * (224 / 0.0625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), QUARTER.toOunces(0.1), delta);
        msg = "0.0000876543297 * (224 / 0.0625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), QUARTER.toOunces(8.76543297E-5), delta);
        msg = "0.33 * (224 / 0.0625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), QUARTER.toOunces(0.33), delta);
        msg = "0.6543 * (224 / 0.0625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), QUARTER.toOunces(0.6543), delta);
        msg = "1 * (224 / 0.0625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), QUARTER.toOunces(1.0), delta);
        msg = "1.6543 * (224 / 0.0625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), QUARTER.toOunces(1.6543), delta);
        msg = "22.45 * (224 / 0.0625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), QUARTER.toOunces(22.45), delta);
        msg = "9876.5432 * (224 / 0.0625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), QUARTER.toOunces(9876.5432), delta);
        msg = "1987654344.3345 * (224 / 0.0625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), QUARTER.toOunces(1.9876543443345E9), delta);
        msg = "784.46789765434 * (224 / 0.0625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), QUARTER.toOunces(784.46789765434), delta);
        // ====================
        // ====================POUND
        // ====================
        // to_factor = 1.0
        to_factor = POUND.getFactor();
        msg = "-1 * (224 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), QUARTER.toPounds(-1.0), delta);
        msg = "-0.1 * (224 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), QUARTER.toPounds(-0.1), delta);
        msg = "-0.000456789 * (224 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), QUARTER.toPounds(-4.56789E-4), delta);
        msg = "-73.25 * (224 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), QUARTER.toPounds(-73.25), delta);
        msg = "-56229.321 * (224 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), QUARTER.toPounds(-56229.321), delta);
        msg = "-873.5432456 * (224 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), QUARTER.toPounds(-873.5432456), delta);
        msg = "0 * (224 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), QUARTER.toPounds(0.0), delta);
        msg = "0.1 * (224 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), QUARTER.toPounds(0.1), delta);
        msg = "0.0000876543297 * (224 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), QUARTER.toPounds(8.76543297E-5), delta);
        msg = "0.33 * (224 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), QUARTER.toPounds(0.33), delta);
        msg = "0.6543 * (224 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), QUARTER.toPounds(0.6543), delta);
        msg = "1 * (224 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), QUARTER.toPounds(1.0), delta);
        msg = "1.6543 * (224 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), QUARTER.toPounds(1.6543), delta);
        msg = "22.45 * (224 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), QUARTER.toPounds(22.45), delta);
        msg = "9876.5432 * (224 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), QUARTER.toPounds(9876.5432), delta);
        msg = "1987654344.3345 * (224 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), QUARTER.toPounds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (224 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), QUARTER.toPounds(784.46789765434), delta);
        // ====================
        // ====================STONE
        // ====================
        // to_factor = 16.0
        to_factor = STONE.getFactor();
        msg = "-1 * (224 / 16)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), QUARTER.toStones(-1.0), delta);
        msg = "-0.1 * (224 / 16)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), QUARTER.toStones(-0.1), delta);
        msg = "-0.000456789 * (224 / 16)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), QUARTER.toStones(-4.56789E-4), delta);
        msg = "-73.25 * (224 / 16)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), QUARTER.toStones(-73.25), delta);
        msg = "-56229.321 * (224 / 16)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), QUARTER.toStones(-56229.321), delta);
        msg = "-873.5432456 * (224 / 16)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), QUARTER.toStones(-873.5432456), delta);
        msg = "0 * (224 / 16)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), QUARTER.toStones(0.0), delta);
        msg = "0.1 * (224 / 16)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), QUARTER.toStones(0.1), delta);
        msg = "0.0000876543297 * (224 / 16)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), QUARTER.toStones(8.76543297E-5), delta);
        msg = "0.33 * (224 / 16)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), QUARTER.toStones(0.33), delta);
        msg = "0.6543 * (224 / 16)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), QUARTER.toStones(0.6543), delta);
        msg = "1 * (224 / 16)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), QUARTER.toStones(1.0), delta);
        msg = "1.6543 * (224 / 16)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), QUARTER.toStones(1.6543), delta);
        msg = "22.45 * (224 / 16)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), QUARTER.toStones(22.45), delta);
        msg = "9876.5432 * (224 / 16)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), QUARTER.toStones(9876.5432), delta);
        msg = "1987654344.3345 * (224 / 16)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), QUARTER.toStones(1.9876543443345E9), delta);
        msg = "784.46789765434 * (224 / 16)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), QUARTER.toStones(784.46789765434), delta);
        // ====================
        // ====================QUARTER
        // ====================
        // to_factor = 224.0
        to_factor = QUARTER.getFactor();
        msg = "-1 * (224 / 224)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), QUARTER.toQuarters(-1.0), delta);
        msg = "-0.1 * (224 / 224)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), QUARTER.toQuarters(-0.1), delta);
        msg = "-0.000456789 * (224 / 224)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), QUARTER.toQuarters(-4.56789E-4), delta);
        msg = "-73.25 * (224 / 224)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), QUARTER.toQuarters(-73.25), delta);
        msg = "-56229.321 * (224 / 224)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), QUARTER.toQuarters(-56229.321), delta);
        msg = "-873.5432456 * (224 / 224)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), QUARTER.toQuarters(-873.5432456), delta);
        msg = "0 * (224 / 224)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), QUARTER.toQuarters(0.0), delta);
        msg = "0.1 * (224 / 224)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), QUARTER.toQuarters(0.1), delta);
        msg = "0.0000876543297 * (224 / 224)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), QUARTER.toQuarters(8.76543297E-5), delta);
        msg = "0.33 * (224 / 224)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), QUARTER.toQuarters(0.33), delta);
        msg = "0.6543 * (224 / 224)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), QUARTER.toQuarters(0.6543), delta);
        msg = "1 * (224 / 224)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), QUARTER.toQuarters(1.0), delta);
        msg = "1.6543 * (224 / 224)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), QUARTER.toQuarters(1.6543), delta);
        msg = "22.45 * (224 / 224)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), QUARTER.toQuarters(22.45), delta);
        msg = "9876.5432 * (224 / 224)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), QUARTER.toQuarters(9876.5432), delta);
        msg = "1987654344.3345 * (224 / 224)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), QUARTER.toQuarters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (224 / 224)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), QUARTER.toQuarters(784.46789765434), delta);
        // ====================
        // ====================HUNDREDWEIGHT
        // ====================
        // to_factor = 448.0
        to_factor = HUNDREDWEIGHT.getFactor();
        msg = "-1 / (448 / 224)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), QUARTER.toHundredweights(-1.0), delta);
        msg = "-0.1 / (448 / 224)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), QUARTER.toHundredweights(-0.1), delta);
        msg = "-0.000456789 / (448 / 224)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), QUARTER.toHundredweights(-4.56789E-4), delta);
        msg = "-73.25 / (448 / 224)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), QUARTER.toHundredweights(-73.25), delta);
        msg = "-56229.321 / (448 / 224)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), QUARTER.toHundredweights(-56229.321), delta);
        msg = "-873.5432456 / (448 / 224)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), QUARTER.toHundredweights(-873.5432456), delta);
        msg = "0 / (448 / 224)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), QUARTER.toHundredweights(0.0), delta);
        msg = "0.1 / (448 / 224)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), QUARTER.toHundredweights(0.1), delta);
        msg = "0.0000876543297 / (448 / 224)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), QUARTER.toHundredweights(8.76543297E-5), delta);
        msg = "0.33 / (448 / 224)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), QUARTER.toHundredweights(0.33), delta);
        msg = "0.6543 / (448 / 224)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), QUARTER.toHundredweights(0.6543), delta);
        msg = "1 / (448 / 224)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), QUARTER.toHundredweights(1.0), delta);
        msg = "1.6543 / (448 / 224)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), QUARTER.toHundredweights(1.6543), delta);
        msg = "22.45 / (448 / 224)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), QUARTER.toHundredweights(22.45), delta);
        msg = "9876.5432 / (448 / 224)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), QUARTER.toHundredweights(9876.5432), delta);
        msg = "1987654344.3345 / (448 / 224)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), QUARTER.toHundredweights(1.9876543443345E9), delta);
        msg = "784.46789765434 / (448 / 224)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), QUARTER.toHundredweights(784.46789765434), delta);
    }

    @Test()
    public void testHundredweight() {
        // from_factor = 448.0
        double from_factor = HUNDREDWEIGHT.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================GRAIN
        // ====================
        // to_factor = 0.0023148148148148147
        to_factor = GRAIN.getFactor();
        msg = "-1 * (448 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HUNDREDWEIGHT.toGrains(-1.0), delta);
        msg = "-0.1 * (448 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HUNDREDWEIGHT.toGrains(-0.1), delta);
        msg = "-0.000456789 * (448 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HUNDREDWEIGHT.toGrains(-4.56789E-4), delta);
        msg = "-73.25 * (448 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HUNDREDWEIGHT.toGrains(-73.25), delta);
        msg = "-56229.321 * (448 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HUNDREDWEIGHT.toGrains(-56229.321), delta);
        msg = "-873.5432456 * (448 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HUNDREDWEIGHT.toGrains(-873.5432456), delta);
        msg = "0 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HUNDREDWEIGHT.toGrains(0.0), delta);
        msg = "0.1 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HUNDREDWEIGHT.toGrains(0.1), delta);
        msg = "0.0000876543297 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HUNDREDWEIGHT.toGrains(8.76543297E-5), delta);
        msg = "0.33 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HUNDREDWEIGHT.toGrains(0.33), delta);
        msg = "0.6543 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HUNDREDWEIGHT.toGrains(0.6543), delta);
        msg = "1 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HUNDREDWEIGHT.toGrains(1.0), delta);
        msg = "1.6543 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HUNDREDWEIGHT.toGrains(1.6543), delta);
        msg = "22.45 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HUNDREDWEIGHT.toGrains(22.45), delta);
        msg = "9876.5432 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HUNDREDWEIGHT.toGrains(9876.5432), delta);
        msg = "1987654344.3345 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HUNDREDWEIGHT.toGrains(1.9876543443345E9), delta);
        msg = "784.46789765434 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HUNDREDWEIGHT.toGrains(784.46789765434), delta);
        // ====================
        // ====================DRACHM
        // ====================
        // to_factor = 0.0023148148148148147
        to_factor = DRACHM.getFactor();
        msg = "-1 * (448 / 0.0023148148148148147)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HUNDREDWEIGHT.toDrachms(-1.0), delta);
        msg = "-0.1 * (448 / 0.0023148148148148147)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HUNDREDWEIGHT.toDrachms(-0.1), delta);
        msg = "-0.000456789 * (448 / 0.0023148148148148147)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HUNDREDWEIGHT.toDrachms(-4.56789E-4), delta);
        msg = "-73.25 * (448 / 0.0023148148148148147)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HUNDREDWEIGHT.toDrachms(-73.25), delta);
        msg = "-56229.321 * (448 / 0.0023148148148148147)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HUNDREDWEIGHT.toDrachms(-56229.321), delta);
        msg = "-873.5432456 * (448 / 0.0023148148148148147)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HUNDREDWEIGHT.toDrachms(-873.5432456), delta);
        msg = "0 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HUNDREDWEIGHT.toDrachms(0.0), delta);
        msg = "0.1 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HUNDREDWEIGHT.toDrachms(0.1), delta);
        msg = "0.0000876543297 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HUNDREDWEIGHT.toDrachms(8.76543297E-5), delta);
        msg = "0.33 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HUNDREDWEIGHT.toDrachms(0.33), delta);
        msg = "0.6543 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HUNDREDWEIGHT.toDrachms(0.6543), delta);
        msg = "1 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HUNDREDWEIGHT.toDrachms(1.0), delta);
        msg = "1.6543 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HUNDREDWEIGHT.toDrachms(1.6543), delta);
        msg = "22.45 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HUNDREDWEIGHT.toDrachms(22.45), delta);
        msg = "9876.5432 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HUNDREDWEIGHT.toDrachms(9876.5432), delta);
        msg = "1987654344.3345 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HUNDREDWEIGHT.toDrachms(1.9876543443345E9), delta);
        msg = "784.46789765434 * (448 / 0.0023148148148148147)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HUNDREDWEIGHT.toDrachms(784.46789765434), delta);
        // ====================
        // ====================OUNCE
        // ====================
        // to_factor = 0.0625
        to_factor = OUNCE.getFactor();
        msg = "-1 * (448 / 0.0625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HUNDREDWEIGHT.toOunces(-1.0), delta);
        msg = "-0.1 * (448 / 0.0625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HUNDREDWEIGHT.toOunces(-0.1), delta);
        msg = "-0.000456789 * (448 / 0.0625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HUNDREDWEIGHT.toOunces(-4.56789E-4), delta);
        msg = "-73.25 * (448 / 0.0625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HUNDREDWEIGHT.toOunces(-73.25), delta);
        msg = "-56229.321 * (448 / 0.0625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HUNDREDWEIGHT.toOunces(-56229.321), delta);
        msg = "-873.5432456 * (448 / 0.0625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HUNDREDWEIGHT.toOunces(-873.5432456), delta);
        msg = "0 * (448 / 0.0625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HUNDREDWEIGHT.toOunces(0.0), delta);
        msg = "0.1 * (448 / 0.0625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HUNDREDWEIGHT.toOunces(0.1), delta);
        msg = "0.0000876543297 * (448 / 0.0625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HUNDREDWEIGHT.toOunces(8.76543297E-5), delta);
        msg = "0.33 * (448 / 0.0625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HUNDREDWEIGHT.toOunces(0.33), delta);
        msg = "0.6543 * (448 / 0.0625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HUNDREDWEIGHT.toOunces(0.6543), delta);
        msg = "1 * (448 / 0.0625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HUNDREDWEIGHT.toOunces(1.0), delta);
        msg = "1.6543 * (448 / 0.0625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HUNDREDWEIGHT.toOunces(1.6543), delta);
        msg = "22.45 * (448 / 0.0625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HUNDREDWEIGHT.toOunces(22.45), delta);
        msg = "9876.5432 * (448 / 0.0625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HUNDREDWEIGHT.toOunces(9876.5432), delta);
        msg = "1987654344.3345 * (448 / 0.0625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HUNDREDWEIGHT.toOunces(1.9876543443345E9), delta);
        msg = "784.46789765434 * (448 / 0.0625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HUNDREDWEIGHT.toOunces(784.46789765434), delta);
        // ====================
        // ====================POUND
        // ====================
        // to_factor = 1.0
        to_factor = POUND.getFactor();
        msg = "-1 * (448 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HUNDREDWEIGHT.toPounds(-1.0), delta);
        msg = "-0.1 * (448 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HUNDREDWEIGHT.toPounds(-0.1), delta);
        msg = "-0.000456789 * (448 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HUNDREDWEIGHT.toPounds(-4.56789E-4), delta);
        msg = "-73.25 * (448 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HUNDREDWEIGHT.toPounds(-73.25), delta);
        msg = "-56229.321 * (448 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HUNDREDWEIGHT.toPounds(-56229.321), delta);
        msg = "-873.5432456 * (448 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HUNDREDWEIGHT.toPounds(-873.5432456), delta);
        msg = "0 * (448 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HUNDREDWEIGHT.toPounds(0.0), delta);
        msg = "0.1 * (448 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HUNDREDWEIGHT.toPounds(0.1), delta);
        msg = "0.0000876543297 * (448 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HUNDREDWEIGHT.toPounds(8.76543297E-5), delta);
        msg = "0.33 * (448 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HUNDREDWEIGHT.toPounds(0.33), delta);
        msg = "0.6543 * (448 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HUNDREDWEIGHT.toPounds(0.6543), delta);
        msg = "1 * (448 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HUNDREDWEIGHT.toPounds(1.0), delta);
        msg = "1.6543 * (448 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HUNDREDWEIGHT.toPounds(1.6543), delta);
        msg = "22.45 * (448 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HUNDREDWEIGHT.toPounds(22.45), delta);
        msg = "9876.5432 * (448 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HUNDREDWEIGHT.toPounds(9876.5432), delta);
        msg = "1987654344.3345 * (448 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HUNDREDWEIGHT.toPounds(1.9876543443345E9), delta);
        msg = "784.46789765434 * (448 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HUNDREDWEIGHT.toPounds(784.46789765434), delta);
        // ====================
        // ====================STONE
        // ====================
        // to_factor = 16.0
        to_factor = STONE.getFactor();
        msg = "-1 * (448 / 16)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HUNDREDWEIGHT.toStones(-1.0), delta);
        msg = "-0.1 * (448 / 16)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HUNDREDWEIGHT.toStones(-0.1), delta);
        msg = "-0.000456789 * (448 / 16)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HUNDREDWEIGHT.toStones(-4.56789E-4), delta);
        msg = "-73.25 * (448 / 16)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HUNDREDWEIGHT.toStones(-73.25), delta);
        msg = "-56229.321 * (448 / 16)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HUNDREDWEIGHT.toStones(-56229.321), delta);
        msg = "-873.5432456 * (448 / 16)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HUNDREDWEIGHT.toStones(-873.5432456), delta);
        msg = "0 * (448 / 16)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HUNDREDWEIGHT.toStones(0.0), delta);
        msg = "0.1 * (448 / 16)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HUNDREDWEIGHT.toStones(0.1), delta);
        msg = "0.0000876543297 * (448 / 16)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HUNDREDWEIGHT.toStones(8.76543297E-5), delta);
        msg = "0.33 * (448 / 16)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HUNDREDWEIGHT.toStones(0.33), delta);
        msg = "0.6543 * (448 / 16)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HUNDREDWEIGHT.toStones(0.6543), delta);
        msg = "1 * (448 / 16)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HUNDREDWEIGHT.toStones(1.0), delta);
        msg = "1.6543 * (448 / 16)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HUNDREDWEIGHT.toStones(1.6543), delta);
        msg = "22.45 * (448 / 16)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HUNDREDWEIGHT.toStones(22.45), delta);
        msg = "9876.5432 * (448 / 16)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HUNDREDWEIGHT.toStones(9876.5432), delta);
        msg = "1987654344.3345 * (448 / 16)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HUNDREDWEIGHT.toStones(1.9876543443345E9), delta);
        msg = "784.46789765434 * (448 / 16)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HUNDREDWEIGHT.toStones(784.46789765434), delta);
        // ====================
        // ====================QUARTER
        // ====================
        // to_factor = 224.0
        to_factor = QUARTER.getFactor();
        msg = "-1 * (448 / 224)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HUNDREDWEIGHT.toQuarters(-1.0), delta);
        msg = "-0.1 * (448 / 224)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HUNDREDWEIGHT.toQuarters(-0.1), delta);
        msg = "-0.000456789 * (448 / 224)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HUNDREDWEIGHT.toQuarters(-4.56789E-4), delta);
        msg = "-73.25 * (448 / 224)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HUNDREDWEIGHT.toQuarters(-73.25), delta);
        msg = "-56229.321 * (448 / 224)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HUNDREDWEIGHT.toQuarters(-56229.321), delta);
        msg = "-873.5432456 * (448 / 224)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HUNDREDWEIGHT.toQuarters(-873.5432456), delta);
        msg = "0 * (448 / 224)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HUNDREDWEIGHT.toQuarters(0.0), delta);
        msg = "0.1 * (448 / 224)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HUNDREDWEIGHT.toQuarters(0.1), delta);
        msg = "0.0000876543297 * (448 / 224)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HUNDREDWEIGHT.toQuarters(8.76543297E-5), delta);
        msg = "0.33 * (448 / 224)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HUNDREDWEIGHT.toQuarters(0.33), delta);
        msg = "0.6543 * (448 / 224)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HUNDREDWEIGHT.toQuarters(0.6543), delta);
        msg = "1 * (448 / 224)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HUNDREDWEIGHT.toQuarters(1.0), delta);
        msg = "1.6543 * (448 / 224)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HUNDREDWEIGHT.toQuarters(1.6543), delta);
        msg = "22.45 * (448 / 224)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HUNDREDWEIGHT.toQuarters(22.45), delta);
        msg = "9876.5432 * (448 / 224)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HUNDREDWEIGHT.toQuarters(9876.5432), delta);
        msg = "1987654344.3345 * (448 / 224)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HUNDREDWEIGHT.toQuarters(1.9876543443345E9), delta);
        msg = "784.46789765434 * (448 / 224)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HUNDREDWEIGHT.toQuarters(784.46789765434), delta);
        // ====================
        // ====================HUNDREDWEIGHT
        // ====================
        // to_factor = 448.0
        to_factor = HUNDREDWEIGHT.getFactor();
        msg = "-1 * (448 / 448)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HUNDREDWEIGHT.toHundredweights(-1.0), delta);
        msg = "-0.1 * (448 / 448)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HUNDREDWEIGHT.toHundredweights(-0.1), delta);
        msg = "-0.000456789 * (448 / 448)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HUNDREDWEIGHT.toHundredweights(-4.56789E-4), delta);
        msg = "-73.25 * (448 / 448)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HUNDREDWEIGHT.toHundredweights(-73.25), delta);
        msg = "-56229.321 * (448 / 448)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HUNDREDWEIGHT.toHundredweights(-56229.321), delta);
        msg = "-873.5432456 * (448 / 448)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HUNDREDWEIGHT.toHundredweights(-873.5432456), delta);
        msg = "0 * (448 / 448)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HUNDREDWEIGHT.toHundredweights(0.0), delta);
        msg = "0.1 * (448 / 448)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HUNDREDWEIGHT.toHundredweights(0.1), delta);
        msg = "0.0000876543297 * (448 / 448)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HUNDREDWEIGHT.toHundredweights(8.76543297E-5), delta);
        msg = "0.33 * (448 / 448)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HUNDREDWEIGHT.toHundredweights(0.33), delta);
        msg = "0.6543 * (448 / 448)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HUNDREDWEIGHT.toHundredweights(0.6543), delta);
        msg = "1 * (448 / 448)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HUNDREDWEIGHT.toHundredweights(1.0), delta);
        msg = "1.6543 * (448 / 448)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HUNDREDWEIGHT.toHundredweights(1.6543), delta);
        msg = "22.45 * (448 / 448)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HUNDREDWEIGHT.toHundredweights(22.45), delta);
        msg = "9876.5432 * (448 / 448)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HUNDREDWEIGHT.toHundredweights(9876.5432), delta);
        msg = "1987654344.3345 * (448 / 448)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HUNDREDWEIGHT.toHundredweights(1.9876543443345E9), delta);
        msg = "784.46789765434 * (448 / 448)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HUNDREDWEIGHT.toHundredweights(784.46789765434), delta);
    }
}
