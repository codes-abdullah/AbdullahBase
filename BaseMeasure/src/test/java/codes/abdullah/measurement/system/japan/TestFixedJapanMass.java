package codes.abdullah.measurement.system.japan;

import static codes.abdullah.measurement.system.japan.Japans.FUN;
import static codes.abdullah.measurement.system.japan.Japans.HYAKUME;
import static codes.abdullah.measurement.system.japan.Japans.KAN;
import static codes.abdullah.measurement.system.japan.Japans.KIN;
import static codes.abdullah.measurement.system.japan.Japans.MARU;
import static codes.abdullah.measurement.system.japan.Japans.MOMME;
import static codes.abdullah.measurement.system.japan.Japans.TAN;
import static codes.abdullah.measurement.utils.TestUtils.delta;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFixedJapanMass {

    @Test()
    public void testFun() {
        // from_factor = 6.25E-4
        double from_factor = FUN.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================FUN
        // ====================
        // to_factor = 6.25E-4
        to_factor = FUN.getFactor();
        msg = "-1 * (0.000625 / 0.000625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), FUN.toFuns(-1.0), delta);
        msg = "-0.1 * (0.000625 / 0.000625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), FUN.toFuns(-0.1), delta);
        msg = "-0.000456789 * (0.000625 / 0.000625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), FUN.toFuns(-4.56789E-4), delta);
        msg = "-73.25 * (0.000625 / 0.000625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), FUN.toFuns(-73.25), delta);
        msg = "-56229.321 * (0.000625 / 0.000625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), FUN.toFuns(-56229.321), delta);
        msg = "-873.5432456 * (0.000625 / 0.000625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), FUN.toFuns(-873.5432456), delta);
        msg = "0 * (0.000625 / 0.000625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), FUN.toFuns(0.0), delta);
        msg = "0.1 * (0.000625 / 0.000625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), FUN.toFuns(0.1), delta);
        msg = "0.0000876543297 * (0.000625 / 0.000625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), FUN.toFuns(8.76543297E-5), delta);
        msg = "0.33 * (0.000625 / 0.000625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), FUN.toFuns(0.33), delta);
        msg = "0.6543 * (0.000625 / 0.000625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), FUN.toFuns(0.6543), delta);
        msg = "1 * (0.000625 / 0.000625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), FUN.toFuns(1.0), delta);
        msg = "1.6543 * (0.000625 / 0.000625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), FUN.toFuns(1.6543), delta);
        msg = "22.45 * (0.000625 / 0.000625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), FUN.toFuns(22.45), delta);
        msg = "9876.5432 * (0.000625 / 0.000625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), FUN.toFuns(9876.5432), delta);
        msg = "1987654344.3345 * (0.000625 / 0.000625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), FUN.toFuns(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.000625 / 0.000625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), FUN.toFuns(784.46789765434), delta);
        // ====================
        // ====================MOMME
        // ====================
        // to_factor = 0.00625
        to_factor = MOMME.getFactor();
        msg = "-1 / (0.00625 / 0.000625)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), FUN.toMommes(-1.0), delta);
        msg = "-0.1 / (0.00625 / 0.000625)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), FUN.toMommes(-0.1), delta);
        msg = "-0.000456789 / (0.00625 / 0.000625)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), FUN.toMommes(-4.56789E-4), delta);
        msg = "-73.25 / (0.00625 / 0.000625)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), FUN.toMommes(-73.25), delta);
        msg = "-56229.321 / (0.00625 / 0.000625)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), FUN.toMommes(-56229.321), delta);
        msg = "-873.5432456 / (0.00625 / 0.000625)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), FUN.toMommes(-873.5432456), delta);
        msg = "0 / (0.00625 / 0.000625)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), FUN.toMommes(0.0), delta);
        msg = "0.1 / (0.00625 / 0.000625)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), FUN.toMommes(0.1), delta);
        msg = "0.0000876543297 / (0.00625 / 0.000625)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), FUN.toMommes(8.76543297E-5), delta);
        msg = "0.33 / (0.00625 / 0.000625)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), FUN.toMommes(0.33), delta);
        msg = "0.6543 / (0.00625 / 0.000625)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), FUN.toMommes(0.6543), delta);
        msg = "1 / (0.00625 / 0.000625)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), FUN.toMommes(1.0), delta);
        msg = "1.6543 / (0.00625 / 0.000625)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), FUN.toMommes(1.6543), delta);
        msg = "22.45 / (0.00625 / 0.000625)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), FUN.toMommes(22.45), delta);
        msg = "9876.5432 / (0.00625 / 0.000625)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), FUN.toMommes(9876.5432), delta);
        msg = "1987654344.3345 / (0.00625 / 0.000625)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), FUN.toMommes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.00625 / 0.000625)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), FUN.toMommes(784.46789765434), delta);
        // ====================
        // ====================HYAKUME
        // ====================
        // to_factor = 0.625
        to_factor = HYAKUME.getFactor();
        msg = "-1 / (0.625 / 0.000625)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), FUN.toHyakumes(-1.0), delta);
        msg = "-0.1 / (0.625 / 0.000625)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), FUN.toHyakumes(-0.1), delta);
        msg = "-0.000456789 / (0.625 / 0.000625)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), FUN.toHyakumes(-4.56789E-4), delta);
        msg = "-73.25 / (0.625 / 0.000625)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), FUN.toHyakumes(-73.25), delta);
        msg = "-56229.321 / (0.625 / 0.000625)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), FUN.toHyakumes(-56229.321), delta);
        msg = "-873.5432456 / (0.625 / 0.000625)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), FUN.toHyakumes(-873.5432456), delta);
        msg = "0 / (0.625 / 0.000625)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), FUN.toHyakumes(0.0), delta);
        msg = "0.1 / (0.625 / 0.000625)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), FUN.toHyakumes(0.1), delta);
        msg = "0.0000876543297 / (0.625 / 0.000625)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), FUN.toHyakumes(8.76543297E-5), delta);
        msg = "0.33 / (0.625 / 0.000625)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), FUN.toHyakumes(0.33), delta);
        msg = "0.6543 / (0.625 / 0.000625)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), FUN.toHyakumes(0.6543), delta);
        msg = "1 / (0.625 / 0.000625)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), FUN.toHyakumes(1.0), delta);
        msg = "1.6543 / (0.625 / 0.000625)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), FUN.toHyakumes(1.6543), delta);
        msg = "22.45 / (0.625 / 0.000625)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), FUN.toHyakumes(22.45), delta);
        msg = "9876.5432 / (0.625 / 0.000625)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), FUN.toHyakumes(9876.5432), delta);
        msg = "1987654344.3345 / (0.625 / 0.000625)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), FUN.toHyakumes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.625 / 0.000625)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), FUN.toHyakumes(784.46789765434), delta);
        // ====================
        // ====================KIN
        // ====================
        // to_factor = 1.0
        to_factor = KIN.getFactor();
        msg = "-1 / (1 / 0.000625)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), FUN.toKins(-1.0), delta);
        msg = "-0.1 / (1 / 0.000625)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), FUN.toKins(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.000625)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), FUN.toKins(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.000625)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), FUN.toKins(-73.25), delta);
        msg = "-56229.321 / (1 / 0.000625)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), FUN.toKins(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.000625)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), FUN.toKins(-873.5432456), delta);
        msg = "0 / (1 / 0.000625)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), FUN.toKins(0.0), delta);
        msg = "0.1 / (1 / 0.000625)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), FUN.toKins(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.000625)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), FUN.toKins(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.000625)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), FUN.toKins(0.33), delta);
        msg = "0.6543 / (1 / 0.000625)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), FUN.toKins(0.6543), delta);
        msg = "1 / (1 / 0.000625)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), FUN.toKins(1.0), delta);
        msg = "1.6543 / (1 / 0.000625)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), FUN.toKins(1.6543), delta);
        msg = "22.45 / (1 / 0.000625)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), FUN.toKins(22.45), delta);
        msg = "9876.5432 / (1 / 0.000625)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), FUN.toKins(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.000625)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), FUN.toKins(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.000625)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), FUN.toKins(784.46789765434), delta);
        // ====================
        // ====================KAN
        // ====================
        // to_factor = 6.25
        to_factor = KAN.getFactor();
        msg = "-1 / (6.25 / 0.000625)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), FUN.toKans(-1.0), delta);
        msg = "-0.1 / (6.25 / 0.000625)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), FUN.toKans(-0.1), delta);
        msg = "-0.000456789 / (6.25 / 0.000625)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), FUN.toKans(-4.56789E-4), delta);
        msg = "-73.25 / (6.25 / 0.000625)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), FUN.toKans(-73.25), delta);
        msg = "-56229.321 / (6.25 / 0.000625)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), FUN.toKans(-56229.321), delta);
        msg = "-873.5432456 / (6.25 / 0.000625)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), FUN.toKans(-873.5432456), delta);
        msg = "0 / (6.25 / 0.000625)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), FUN.toKans(0.0), delta);
        msg = "0.1 / (6.25 / 0.000625)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), FUN.toKans(0.1), delta);
        msg = "0.0000876543297 / (6.25 / 0.000625)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), FUN.toKans(8.76543297E-5), delta);
        msg = "0.33 / (6.25 / 0.000625)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), FUN.toKans(0.33), delta);
        msg = "0.6543 / (6.25 / 0.000625)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), FUN.toKans(0.6543), delta);
        msg = "1 / (6.25 / 0.000625)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), FUN.toKans(1.0), delta);
        msg = "1.6543 / (6.25 / 0.000625)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), FUN.toKans(1.6543), delta);
        msg = "22.45 / (6.25 / 0.000625)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), FUN.toKans(22.45), delta);
        msg = "9876.5432 / (6.25 / 0.000625)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), FUN.toKans(9876.5432), delta);
        msg = "1987654344.3345 / (6.25 / 0.000625)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), FUN.toKans(1.9876543443345E9), delta);
        msg = "784.46789765434 / (6.25 / 0.000625)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), FUN.toKans(784.46789765434), delta);
        // ====================
        // ====================MARU
        // ====================
        // to_factor = 50.0
        to_factor = MARU.getFactor();
        msg = "-1 / (50 / 0.000625)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), FUN.toMarus(-1.0), delta);
        msg = "-0.1 / (50 / 0.000625)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), FUN.toMarus(-0.1), delta);
        msg = "-0.000456789 / (50 / 0.000625)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), FUN.toMarus(-4.56789E-4), delta);
        msg = "-73.25 / (50 / 0.000625)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), FUN.toMarus(-73.25), delta);
        msg = "-56229.321 / (50 / 0.000625)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), FUN.toMarus(-56229.321), delta);
        msg = "-873.5432456 / (50 / 0.000625)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), FUN.toMarus(-873.5432456), delta);
        msg = "0 / (50 / 0.000625)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), FUN.toMarus(0.0), delta);
        msg = "0.1 / (50 / 0.000625)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), FUN.toMarus(0.1), delta);
        msg = "0.0000876543297 / (50 / 0.000625)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), FUN.toMarus(8.76543297E-5), delta);
        msg = "0.33 / (50 / 0.000625)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), FUN.toMarus(0.33), delta);
        msg = "0.6543 / (50 / 0.000625)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), FUN.toMarus(0.6543), delta);
        msg = "1 / (50 / 0.000625)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), FUN.toMarus(1.0), delta);
        msg = "1.6543 / (50 / 0.000625)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), FUN.toMarus(1.6543), delta);
        msg = "22.45 / (50 / 0.000625)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), FUN.toMarus(22.45), delta);
        msg = "9876.5432 / (50 / 0.000625)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), FUN.toMarus(9876.5432), delta);
        msg = "1987654344.3345 / (50 / 0.000625)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), FUN.toMarus(1.9876543443345E9), delta);
        msg = "784.46789765434 / (50 / 0.000625)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), FUN.toMarus(784.46789765434), delta);
        // ====================
        // ====================TAN
        // ====================
        // to_factor = 100.0
        to_factor = TAN.getFactor();
        msg = "-1 / (100 / 0.000625)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), FUN.toTans(-1.0), delta);
        msg = "-0.1 / (100 / 0.000625)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), FUN.toTans(-0.1), delta);
        msg = "-0.000456789 / (100 / 0.000625)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), FUN.toTans(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 0.000625)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), FUN.toTans(-73.25), delta);
        msg = "-56229.321 / (100 / 0.000625)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), FUN.toTans(-56229.321), delta);
        msg = "-873.5432456 / (100 / 0.000625)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), FUN.toTans(-873.5432456), delta);
        msg = "0 / (100 / 0.000625)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), FUN.toTans(0.0), delta);
        msg = "0.1 / (100 / 0.000625)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), FUN.toTans(0.1), delta);
        msg = "0.0000876543297 / (100 / 0.000625)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), FUN.toTans(8.76543297E-5), delta);
        msg = "0.33 / (100 / 0.000625)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), FUN.toTans(0.33), delta);
        msg = "0.6543 / (100 / 0.000625)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), FUN.toTans(0.6543), delta);
        msg = "1 / (100 / 0.000625)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), FUN.toTans(1.0), delta);
        msg = "1.6543 / (100 / 0.000625)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), FUN.toTans(1.6543), delta);
        msg = "22.45 / (100 / 0.000625)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), FUN.toTans(22.45), delta);
        msg = "9876.5432 / (100 / 0.000625)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), FUN.toTans(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 0.000625)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), FUN.toTans(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 0.000625)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), FUN.toTans(784.46789765434), delta);
    }

    @Test()
    public void testMomme() {
        // from_factor = 0.00625
        double from_factor = MOMME.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================FUN
        // ====================
        // to_factor = 6.25E-4
        to_factor = FUN.getFactor();
        msg = "-1 * (0.00625 / 0.000625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MOMME.toFuns(-1.0), delta);
        msg = "-0.1 * (0.00625 / 0.000625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MOMME.toFuns(-0.1), delta);
        msg = "-0.000456789 * (0.00625 / 0.000625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MOMME.toFuns(-4.56789E-4), delta);
        msg = "-73.25 * (0.00625 / 0.000625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MOMME.toFuns(-73.25), delta);
        msg = "-56229.321 * (0.00625 / 0.000625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MOMME.toFuns(-56229.321), delta);
        msg = "-873.5432456 * (0.00625 / 0.000625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MOMME.toFuns(-873.5432456), delta);
        msg = "0 * (0.00625 / 0.000625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MOMME.toFuns(0.0), delta);
        msg = "0.1 * (0.00625 / 0.000625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MOMME.toFuns(0.1), delta);
        msg = "0.0000876543297 * (0.00625 / 0.000625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MOMME.toFuns(8.76543297E-5), delta);
        msg = "0.33 * (0.00625 / 0.000625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MOMME.toFuns(0.33), delta);
        msg = "0.6543 * (0.00625 / 0.000625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MOMME.toFuns(0.6543), delta);
        msg = "1 * (0.00625 / 0.000625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MOMME.toFuns(1.0), delta);
        msg = "1.6543 * (0.00625 / 0.000625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MOMME.toFuns(1.6543), delta);
        msg = "22.45 * (0.00625 / 0.000625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MOMME.toFuns(22.45), delta);
        msg = "9876.5432 * (0.00625 / 0.000625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MOMME.toFuns(9876.5432), delta);
        msg = "1987654344.3345 * (0.00625 / 0.000625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MOMME.toFuns(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.00625 / 0.000625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MOMME.toFuns(784.46789765434), delta);
        // ====================
        // ====================MOMME
        // ====================
        // to_factor = 0.00625
        to_factor = MOMME.getFactor();
        msg = "-1 * (0.00625 / 0.00625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MOMME.toMommes(-1.0), delta);
        msg = "-0.1 * (0.00625 / 0.00625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MOMME.toMommes(-0.1), delta);
        msg = "-0.000456789 * (0.00625 / 0.00625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MOMME.toMommes(-4.56789E-4), delta);
        msg = "-73.25 * (0.00625 / 0.00625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MOMME.toMommes(-73.25), delta);
        msg = "-56229.321 * (0.00625 / 0.00625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MOMME.toMommes(-56229.321), delta);
        msg = "-873.5432456 * (0.00625 / 0.00625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MOMME.toMommes(-873.5432456), delta);
        msg = "0 * (0.00625 / 0.00625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MOMME.toMommes(0.0), delta);
        msg = "0.1 * (0.00625 / 0.00625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MOMME.toMommes(0.1), delta);
        msg = "0.0000876543297 * (0.00625 / 0.00625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MOMME.toMommes(8.76543297E-5), delta);
        msg = "0.33 * (0.00625 / 0.00625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MOMME.toMommes(0.33), delta);
        msg = "0.6543 * (0.00625 / 0.00625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MOMME.toMommes(0.6543), delta);
        msg = "1 * (0.00625 / 0.00625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MOMME.toMommes(1.0), delta);
        msg = "1.6543 * (0.00625 / 0.00625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MOMME.toMommes(1.6543), delta);
        msg = "22.45 * (0.00625 / 0.00625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MOMME.toMommes(22.45), delta);
        msg = "9876.5432 * (0.00625 / 0.00625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MOMME.toMommes(9876.5432), delta);
        msg = "1987654344.3345 * (0.00625 / 0.00625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MOMME.toMommes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.00625 / 0.00625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MOMME.toMommes(784.46789765434), delta);
        // ====================
        // ====================HYAKUME
        // ====================
        // to_factor = 0.625
        to_factor = HYAKUME.getFactor();
        msg = "-1 / (0.625 / 0.00625)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MOMME.toHyakumes(-1.0), delta);
        msg = "-0.1 / (0.625 / 0.00625)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MOMME.toHyakumes(-0.1), delta);
        msg = "-0.000456789 / (0.625 / 0.00625)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MOMME.toHyakumes(-4.56789E-4), delta);
        msg = "-73.25 / (0.625 / 0.00625)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MOMME.toHyakumes(-73.25), delta);
        msg = "-56229.321 / (0.625 / 0.00625)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MOMME.toHyakumes(-56229.321), delta);
        msg = "-873.5432456 / (0.625 / 0.00625)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MOMME.toHyakumes(-873.5432456), delta);
        msg = "0 / (0.625 / 0.00625)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MOMME.toHyakumes(0.0), delta);
        msg = "0.1 / (0.625 / 0.00625)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MOMME.toHyakumes(0.1), delta);
        msg = "0.0000876543297 / (0.625 / 0.00625)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MOMME.toHyakumes(8.76543297E-5), delta);
        msg = "0.33 / (0.625 / 0.00625)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MOMME.toHyakumes(0.33), delta);
        msg = "0.6543 / (0.625 / 0.00625)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MOMME.toHyakumes(0.6543), delta);
        msg = "1 / (0.625 / 0.00625)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MOMME.toHyakumes(1.0), delta);
        msg = "1.6543 / (0.625 / 0.00625)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MOMME.toHyakumes(1.6543), delta);
        msg = "22.45 / (0.625 / 0.00625)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MOMME.toHyakumes(22.45), delta);
        msg = "9876.5432 / (0.625 / 0.00625)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MOMME.toHyakumes(9876.5432), delta);
        msg = "1987654344.3345 / (0.625 / 0.00625)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MOMME.toHyakumes(1.9876543443345E9), delta);
        msg = "784.46789765434 / (0.625 / 0.00625)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MOMME.toHyakumes(784.46789765434), delta);
        // ====================
        // ====================KIN
        // ====================
        // to_factor = 1.0
        to_factor = KIN.getFactor();
        msg = "-1 / (1 / 0.00625)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MOMME.toKins(-1.0), delta);
        msg = "-0.1 / (1 / 0.00625)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MOMME.toKins(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.00625)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MOMME.toKins(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.00625)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MOMME.toKins(-73.25), delta);
        msg = "-56229.321 / (1 / 0.00625)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MOMME.toKins(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.00625)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MOMME.toKins(-873.5432456), delta);
        msg = "0 / (1 / 0.00625)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MOMME.toKins(0.0), delta);
        msg = "0.1 / (1 / 0.00625)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MOMME.toKins(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.00625)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MOMME.toKins(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.00625)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MOMME.toKins(0.33), delta);
        msg = "0.6543 / (1 / 0.00625)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MOMME.toKins(0.6543), delta);
        msg = "1 / (1 / 0.00625)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MOMME.toKins(1.0), delta);
        msg = "1.6543 / (1 / 0.00625)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MOMME.toKins(1.6543), delta);
        msg = "22.45 / (1 / 0.00625)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MOMME.toKins(22.45), delta);
        msg = "9876.5432 / (1 / 0.00625)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MOMME.toKins(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.00625)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MOMME.toKins(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.00625)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MOMME.toKins(784.46789765434), delta);
        // ====================
        // ====================KAN
        // ====================
        // to_factor = 6.25
        to_factor = KAN.getFactor();
        msg = "-1 / (6.25 / 0.00625)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MOMME.toKans(-1.0), delta);
        msg = "-0.1 / (6.25 / 0.00625)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MOMME.toKans(-0.1), delta);
        msg = "-0.000456789 / (6.25 / 0.00625)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MOMME.toKans(-4.56789E-4), delta);
        msg = "-73.25 / (6.25 / 0.00625)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MOMME.toKans(-73.25), delta);
        msg = "-56229.321 / (6.25 / 0.00625)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MOMME.toKans(-56229.321), delta);
        msg = "-873.5432456 / (6.25 / 0.00625)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MOMME.toKans(-873.5432456), delta);
        msg = "0 / (6.25 / 0.00625)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MOMME.toKans(0.0), delta);
        msg = "0.1 / (6.25 / 0.00625)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MOMME.toKans(0.1), delta);
        msg = "0.0000876543297 / (6.25 / 0.00625)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MOMME.toKans(8.76543297E-5), delta);
        msg = "0.33 / (6.25 / 0.00625)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MOMME.toKans(0.33), delta);
        msg = "0.6543 / (6.25 / 0.00625)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MOMME.toKans(0.6543), delta);
        msg = "1 / (6.25 / 0.00625)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MOMME.toKans(1.0), delta);
        msg = "1.6543 / (6.25 / 0.00625)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MOMME.toKans(1.6543), delta);
        msg = "22.45 / (6.25 / 0.00625)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MOMME.toKans(22.45), delta);
        msg = "9876.5432 / (6.25 / 0.00625)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MOMME.toKans(9876.5432), delta);
        msg = "1987654344.3345 / (6.25 / 0.00625)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MOMME.toKans(1.9876543443345E9), delta);
        msg = "784.46789765434 / (6.25 / 0.00625)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MOMME.toKans(784.46789765434), delta);
        // ====================
        // ====================MARU
        // ====================
        // to_factor = 50.0
        to_factor = MARU.getFactor();
        msg = "-1 / (50 / 0.00625)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MOMME.toMarus(-1.0), delta);
        msg = "-0.1 / (50 / 0.00625)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MOMME.toMarus(-0.1), delta);
        msg = "-0.000456789 / (50 / 0.00625)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MOMME.toMarus(-4.56789E-4), delta);
        msg = "-73.25 / (50 / 0.00625)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MOMME.toMarus(-73.25), delta);
        msg = "-56229.321 / (50 / 0.00625)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MOMME.toMarus(-56229.321), delta);
        msg = "-873.5432456 / (50 / 0.00625)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MOMME.toMarus(-873.5432456), delta);
        msg = "0 / (50 / 0.00625)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MOMME.toMarus(0.0), delta);
        msg = "0.1 / (50 / 0.00625)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MOMME.toMarus(0.1), delta);
        msg = "0.0000876543297 / (50 / 0.00625)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MOMME.toMarus(8.76543297E-5), delta);
        msg = "0.33 / (50 / 0.00625)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MOMME.toMarus(0.33), delta);
        msg = "0.6543 / (50 / 0.00625)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MOMME.toMarus(0.6543), delta);
        msg = "1 / (50 / 0.00625)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MOMME.toMarus(1.0), delta);
        msg = "1.6543 / (50 / 0.00625)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MOMME.toMarus(1.6543), delta);
        msg = "22.45 / (50 / 0.00625)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MOMME.toMarus(22.45), delta);
        msg = "9876.5432 / (50 / 0.00625)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MOMME.toMarus(9876.5432), delta);
        msg = "1987654344.3345 / (50 / 0.00625)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MOMME.toMarus(1.9876543443345E9), delta);
        msg = "784.46789765434 / (50 / 0.00625)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MOMME.toMarus(784.46789765434), delta);
        // ====================
        // ====================TAN
        // ====================
        // to_factor = 100.0
        to_factor = TAN.getFactor();
        msg = "-1 / (100 / 0.00625)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MOMME.toTans(-1.0), delta);
        msg = "-0.1 / (100 / 0.00625)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MOMME.toTans(-0.1), delta);
        msg = "-0.000456789 / (100 / 0.00625)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MOMME.toTans(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 0.00625)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MOMME.toTans(-73.25), delta);
        msg = "-56229.321 / (100 / 0.00625)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MOMME.toTans(-56229.321), delta);
        msg = "-873.5432456 / (100 / 0.00625)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MOMME.toTans(-873.5432456), delta);
        msg = "0 / (100 / 0.00625)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MOMME.toTans(0.0), delta);
        msg = "0.1 / (100 / 0.00625)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MOMME.toTans(0.1), delta);
        msg = "0.0000876543297 / (100 / 0.00625)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MOMME.toTans(8.76543297E-5), delta);
        msg = "0.33 / (100 / 0.00625)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MOMME.toTans(0.33), delta);
        msg = "0.6543 / (100 / 0.00625)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MOMME.toTans(0.6543), delta);
        msg = "1 / (100 / 0.00625)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MOMME.toTans(1.0), delta);
        msg = "1.6543 / (100 / 0.00625)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MOMME.toTans(1.6543), delta);
        msg = "22.45 / (100 / 0.00625)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MOMME.toTans(22.45), delta);
        msg = "9876.5432 / (100 / 0.00625)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MOMME.toTans(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 0.00625)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MOMME.toTans(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 0.00625)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MOMME.toTans(784.46789765434), delta);
    }

    @Test()
    public void testHyakume() {
        // from_factor = 0.625
        double from_factor = HYAKUME.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================FUN
        // ====================
        // to_factor = 6.25E-4
        to_factor = FUN.getFactor();
        msg = "-1 * (0.625 / 0.000625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HYAKUME.toFuns(-1.0), delta);
        msg = "-0.1 * (0.625 / 0.000625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HYAKUME.toFuns(-0.1), delta);
        msg = "-0.000456789 * (0.625 / 0.000625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HYAKUME.toFuns(-4.56789E-4), delta);
        msg = "-73.25 * (0.625 / 0.000625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HYAKUME.toFuns(-73.25), delta);
        msg = "-56229.321 * (0.625 / 0.000625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HYAKUME.toFuns(-56229.321), delta);
        msg = "-873.5432456 * (0.625 / 0.000625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HYAKUME.toFuns(-873.5432456), delta);
        msg = "0 * (0.625 / 0.000625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HYAKUME.toFuns(0.0), delta);
        msg = "0.1 * (0.625 / 0.000625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HYAKUME.toFuns(0.1), delta);
        msg = "0.0000876543297 * (0.625 / 0.000625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HYAKUME.toFuns(8.76543297E-5), delta);
        msg = "0.33 * (0.625 / 0.000625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HYAKUME.toFuns(0.33), delta);
        msg = "0.6543 * (0.625 / 0.000625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HYAKUME.toFuns(0.6543), delta);
        msg = "1 * (0.625 / 0.000625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HYAKUME.toFuns(1.0), delta);
        msg = "1.6543 * (0.625 / 0.000625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HYAKUME.toFuns(1.6543), delta);
        msg = "22.45 * (0.625 / 0.000625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HYAKUME.toFuns(22.45), delta);
        msg = "9876.5432 * (0.625 / 0.000625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HYAKUME.toFuns(9876.5432), delta);
        msg = "1987654344.3345 * (0.625 / 0.000625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HYAKUME.toFuns(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.625 / 0.000625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HYAKUME.toFuns(784.46789765434), delta);
        // ====================
        // ====================MOMME
        // ====================
        // to_factor = 0.00625
        to_factor = MOMME.getFactor();
        msg = "-1 * (0.625 / 0.00625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HYAKUME.toMommes(-1.0), delta);
        msg = "-0.1 * (0.625 / 0.00625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HYAKUME.toMommes(-0.1), delta);
        msg = "-0.000456789 * (0.625 / 0.00625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HYAKUME.toMommes(-4.56789E-4), delta);
        msg = "-73.25 * (0.625 / 0.00625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HYAKUME.toMommes(-73.25), delta);
        msg = "-56229.321 * (0.625 / 0.00625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HYAKUME.toMommes(-56229.321), delta);
        msg = "-873.5432456 * (0.625 / 0.00625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HYAKUME.toMommes(-873.5432456), delta);
        msg = "0 * (0.625 / 0.00625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HYAKUME.toMommes(0.0), delta);
        msg = "0.1 * (0.625 / 0.00625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HYAKUME.toMommes(0.1), delta);
        msg = "0.0000876543297 * (0.625 / 0.00625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HYAKUME.toMommes(8.76543297E-5), delta);
        msg = "0.33 * (0.625 / 0.00625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HYAKUME.toMommes(0.33), delta);
        msg = "0.6543 * (0.625 / 0.00625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HYAKUME.toMommes(0.6543), delta);
        msg = "1 * (0.625 / 0.00625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HYAKUME.toMommes(1.0), delta);
        msg = "1.6543 * (0.625 / 0.00625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HYAKUME.toMommes(1.6543), delta);
        msg = "22.45 * (0.625 / 0.00625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HYAKUME.toMommes(22.45), delta);
        msg = "9876.5432 * (0.625 / 0.00625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HYAKUME.toMommes(9876.5432), delta);
        msg = "1987654344.3345 * (0.625 / 0.00625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HYAKUME.toMommes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.625 / 0.00625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HYAKUME.toMommes(784.46789765434), delta);
        // ====================
        // ====================HYAKUME
        // ====================
        // to_factor = 0.625
        to_factor = HYAKUME.getFactor();
        msg = "-1 * (0.625 / 0.625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), HYAKUME.toHyakumes(-1.0), delta);
        msg = "-0.1 * (0.625 / 0.625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), HYAKUME.toHyakumes(-0.1), delta);
        msg = "-0.000456789 * (0.625 / 0.625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), HYAKUME.toHyakumes(-4.56789E-4), delta);
        msg = "-73.25 * (0.625 / 0.625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), HYAKUME.toHyakumes(-73.25), delta);
        msg = "-56229.321 * (0.625 / 0.625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), HYAKUME.toHyakumes(-56229.321), delta);
        msg = "-873.5432456 * (0.625 / 0.625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), HYAKUME.toHyakumes(-873.5432456), delta);
        msg = "0 * (0.625 / 0.625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), HYAKUME.toHyakumes(0.0), delta);
        msg = "0.1 * (0.625 / 0.625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), HYAKUME.toHyakumes(0.1), delta);
        msg = "0.0000876543297 * (0.625 / 0.625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), HYAKUME.toHyakumes(8.76543297E-5), delta);
        msg = "0.33 * (0.625 / 0.625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), HYAKUME.toHyakumes(0.33), delta);
        msg = "0.6543 * (0.625 / 0.625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), HYAKUME.toHyakumes(0.6543), delta);
        msg = "1 * (0.625 / 0.625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), HYAKUME.toHyakumes(1.0), delta);
        msg = "1.6543 * (0.625 / 0.625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), HYAKUME.toHyakumes(1.6543), delta);
        msg = "22.45 * (0.625 / 0.625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), HYAKUME.toHyakumes(22.45), delta);
        msg = "9876.5432 * (0.625 / 0.625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), HYAKUME.toHyakumes(9876.5432), delta);
        msg = "1987654344.3345 * (0.625 / 0.625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), HYAKUME.toHyakumes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (0.625 / 0.625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), HYAKUME.toHyakumes(784.46789765434), delta);
        // ====================
        // ====================KIN
        // ====================
        // to_factor = 1.0
        to_factor = KIN.getFactor();
        msg = "-1 / (1 / 0.625)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), HYAKUME.toKins(-1.0), delta);
        msg = "-0.1 / (1 / 0.625)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), HYAKUME.toKins(-0.1), delta);
        msg = "-0.000456789 / (1 / 0.625)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), HYAKUME.toKins(-4.56789E-4), delta);
        msg = "-73.25 / (1 / 0.625)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), HYAKUME.toKins(-73.25), delta);
        msg = "-56229.321 / (1 / 0.625)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), HYAKUME.toKins(-56229.321), delta);
        msg = "-873.5432456 / (1 / 0.625)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), HYAKUME.toKins(-873.5432456), delta);
        msg = "0 / (1 / 0.625)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), HYAKUME.toKins(0.0), delta);
        msg = "0.1 / (1 / 0.625)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), HYAKUME.toKins(0.1), delta);
        msg = "0.0000876543297 / (1 / 0.625)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), HYAKUME.toKins(8.76543297E-5), delta);
        msg = "0.33 / (1 / 0.625)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), HYAKUME.toKins(0.33), delta);
        msg = "0.6543 / (1 / 0.625)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), HYAKUME.toKins(0.6543), delta);
        msg = "1 / (1 / 0.625)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), HYAKUME.toKins(1.0), delta);
        msg = "1.6543 / (1 / 0.625)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), HYAKUME.toKins(1.6543), delta);
        msg = "22.45 / (1 / 0.625)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), HYAKUME.toKins(22.45), delta);
        msg = "9876.5432 / (1 / 0.625)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), HYAKUME.toKins(9876.5432), delta);
        msg = "1987654344.3345 / (1 / 0.625)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), HYAKUME.toKins(1.9876543443345E9), delta);
        msg = "784.46789765434 / (1 / 0.625)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), HYAKUME.toKins(784.46789765434), delta);
        // ====================
        // ====================KAN
        // ====================
        // to_factor = 6.25
        to_factor = KAN.getFactor();
        msg = "-1 / (6.25 / 0.625)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), HYAKUME.toKans(-1.0), delta);
        msg = "-0.1 / (6.25 / 0.625)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), HYAKUME.toKans(-0.1), delta);
        msg = "-0.000456789 / (6.25 / 0.625)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), HYAKUME.toKans(-4.56789E-4), delta);
        msg = "-73.25 / (6.25 / 0.625)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), HYAKUME.toKans(-73.25), delta);
        msg = "-56229.321 / (6.25 / 0.625)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), HYAKUME.toKans(-56229.321), delta);
        msg = "-873.5432456 / (6.25 / 0.625)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), HYAKUME.toKans(-873.5432456), delta);
        msg = "0 / (6.25 / 0.625)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), HYAKUME.toKans(0.0), delta);
        msg = "0.1 / (6.25 / 0.625)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), HYAKUME.toKans(0.1), delta);
        msg = "0.0000876543297 / (6.25 / 0.625)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), HYAKUME.toKans(8.76543297E-5), delta);
        msg = "0.33 / (6.25 / 0.625)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), HYAKUME.toKans(0.33), delta);
        msg = "0.6543 / (6.25 / 0.625)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), HYAKUME.toKans(0.6543), delta);
        msg = "1 / (6.25 / 0.625)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), HYAKUME.toKans(1.0), delta);
        msg = "1.6543 / (6.25 / 0.625)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), HYAKUME.toKans(1.6543), delta);
        msg = "22.45 / (6.25 / 0.625)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), HYAKUME.toKans(22.45), delta);
        msg = "9876.5432 / (6.25 / 0.625)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), HYAKUME.toKans(9876.5432), delta);
        msg = "1987654344.3345 / (6.25 / 0.625)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), HYAKUME.toKans(1.9876543443345E9), delta);
        msg = "784.46789765434 / (6.25 / 0.625)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), HYAKUME.toKans(784.46789765434), delta);
        // ====================
        // ====================MARU
        // ====================
        // to_factor = 50.0
        to_factor = MARU.getFactor();
        msg = "-1 / (50 / 0.625)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), HYAKUME.toMarus(-1.0), delta);
        msg = "-0.1 / (50 / 0.625)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), HYAKUME.toMarus(-0.1), delta);
        msg = "-0.000456789 / (50 / 0.625)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), HYAKUME.toMarus(-4.56789E-4), delta);
        msg = "-73.25 / (50 / 0.625)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), HYAKUME.toMarus(-73.25), delta);
        msg = "-56229.321 / (50 / 0.625)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), HYAKUME.toMarus(-56229.321), delta);
        msg = "-873.5432456 / (50 / 0.625)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), HYAKUME.toMarus(-873.5432456), delta);
        msg = "0 / (50 / 0.625)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), HYAKUME.toMarus(0.0), delta);
        msg = "0.1 / (50 / 0.625)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), HYAKUME.toMarus(0.1), delta);
        msg = "0.0000876543297 / (50 / 0.625)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), HYAKUME.toMarus(8.76543297E-5), delta);
        msg = "0.33 / (50 / 0.625)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), HYAKUME.toMarus(0.33), delta);
        msg = "0.6543 / (50 / 0.625)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), HYAKUME.toMarus(0.6543), delta);
        msg = "1 / (50 / 0.625)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), HYAKUME.toMarus(1.0), delta);
        msg = "1.6543 / (50 / 0.625)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), HYAKUME.toMarus(1.6543), delta);
        msg = "22.45 / (50 / 0.625)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), HYAKUME.toMarus(22.45), delta);
        msg = "9876.5432 / (50 / 0.625)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), HYAKUME.toMarus(9876.5432), delta);
        msg = "1987654344.3345 / (50 / 0.625)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), HYAKUME.toMarus(1.9876543443345E9), delta);
        msg = "784.46789765434 / (50 / 0.625)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), HYAKUME.toMarus(784.46789765434), delta);
        // ====================
        // ====================TAN
        // ====================
        // to_factor = 100.0
        to_factor = TAN.getFactor();
        msg = "-1 / (100 / 0.625)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), HYAKUME.toTans(-1.0), delta);
        msg = "-0.1 / (100 / 0.625)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), HYAKUME.toTans(-0.1), delta);
        msg = "-0.000456789 / (100 / 0.625)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), HYAKUME.toTans(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 0.625)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), HYAKUME.toTans(-73.25), delta);
        msg = "-56229.321 / (100 / 0.625)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), HYAKUME.toTans(-56229.321), delta);
        msg = "-873.5432456 / (100 / 0.625)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), HYAKUME.toTans(-873.5432456), delta);
        msg = "0 / (100 / 0.625)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), HYAKUME.toTans(0.0), delta);
        msg = "0.1 / (100 / 0.625)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), HYAKUME.toTans(0.1), delta);
        msg = "0.0000876543297 / (100 / 0.625)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), HYAKUME.toTans(8.76543297E-5), delta);
        msg = "0.33 / (100 / 0.625)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), HYAKUME.toTans(0.33), delta);
        msg = "0.6543 / (100 / 0.625)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), HYAKUME.toTans(0.6543), delta);
        msg = "1 / (100 / 0.625)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), HYAKUME.toTans(1.0), delta);
        msg = "1.6543 / (100 / 0.625)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), HYAKUME.toTans(1.6543), delta);
        msg = "22.45 / (100 / 0.625)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), HYAKUME.toTans(22.45), delta);
        msg = "9876.5432 / (100 / 0.625)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), HYAKUME.toTans(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 0.625)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), HYAKUME.toTans(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 0.625)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), HYAKUME.toTans(784.46789765434), delta);
    }

    @Test()
    public void testKin() {
        // from_factor = 1.0
        double from_factor = KIN.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================FUN
        // ====================
        // to_factor = 6.25E-4
        to_factor = FUN.getFactor();
        msg = "-1 * (1 / 0.000625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KIN.toFuns(-1.0), delta);
        msg = "-0.1 * (1 / 0.000625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KIN.toFuns(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.000625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KIN.toFuns(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.000625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KIN.toFuns(-73.25), delta);
        msg = "-56229.321 * (1 / 0.000625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KIN.toFuns(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.000625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KIN.toFuns(-873.5432456), delta);
        msg = "0 * (1 / 0.000625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KIN.toFuns(0.0), delta);
        msg = "0.1 * (1 / 0.000625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KIN.toFuns(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.000625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KIN.toFuns(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.000625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KIN.toFuns(0.33), delta);
        msg = "0.6543 * (1 / 0.000625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KIN.toFuns(0.6543), delta);
        msg = "1 * (1 / 0.000625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KIN.toFuns(1.0), delta);
        msg = "1.6543 * (1 / 0.000625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KIN.toFuns(1.6543), delta);
        msg = "22.45 * (1 / 0.000625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KIN.toFuns(22.45), delta);
        msg = "9876.5432 * (1 / 0.000625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KIN.toFuns(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.000625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KIN.toFuns(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.000625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KIN.toFuns(784.46789765434), delta);
        // ====================
        // ====================MOMME
        // ====================
        // to_factor = 0.00625
        to_factor = MOMME.getFactor();
        msg = "-1 * (1 / 0.00625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KIN.toMommes(-1.0), delta);
        msg = "-0.1 * (1 / 0.00625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KIN.toMommes(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.00625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KIN.toMommes(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.00625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KIN.toMommes(-73.25), delta);
        msg = "-56229.321 * (1 / 0.00625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KIN.toMommes(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.00625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KIN.toMommes(-873.5432456), delta);
        msg = "0 * (1 / 0.00625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KIN.toMommes(0.0), delta);
        msg = "0.1 * (1 / 0.00625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KIN.toMommes(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.00625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KIN.toMommes(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.00625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KIN.toMommes(0.33), delta);
        msg = "0.6543 * (1 / 0.00625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KIN.toMommes(0.6543), delta);
        msg = "1 * (1 / 0.00625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KIN.toMommes(1.0), delta);
        msg = "1.6543 * (1 / 0.00625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KIN.toMommes(1.6543), delta);
        msg = "22.45 * (1 / 0.00625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KIN.toMommes(22.45), delta);
        msg = "9876.5432 * (1 / 0.00625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KIN.toMommes(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.00625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KIN.toMommes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.00625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KIN.toMommes(784.46789765434), delta);
        // ====================
        // ====================HYAKUME
        // ====================
        // to_factor = 0.625
        to_factor = HYAKUME.getFactor();
        msg = "-1 * (1 / 0.625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KIN.toHyakumes(-1.0), delta);
        msg = "-0.1 * (1 / 0.625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KIN.toHyakumes(-0.1), delta);
        msg = "-0.000456789 * (1 / 0.625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KIN.toHyakumes(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 0.625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KIN.toHyakumes(-73.25), delta);
        msg = "-56229.321 * (1 / 0.625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KIN.toHyakumes(-56229.321), delta);
        msg = "-873.5432456 * (1 / 0.625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KIN.toHyakumes(-873.5432456), delta);
        msg = "0 * (1 / 0.625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KIN.toHyakumes(0.0), delta);
        msg = "0.1 * (1 / 0.625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KIN.toHyakumes(0.1), delta);
        msg = "0.0000876543297 * (1 / 0.625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KIN.toHyakumes(8.76543297E-5), delta);
        msg = "0.33 * (1 / 0.625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KIN.toHyakumes(0.33), delta);
        msg = "0.6543 * (1 / 0.625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KIN.toHyakumes(0.6543), delta);
        msg = "1 * (1 / 0.625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KIN.toHyakumes(1.0), delta);
        msg = "1.6543 * (1 / 0.625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KIN.toHyakumes(1.6543), delta);
        msg = "22.45 * (1 / 0.625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KIN.toHyakumes(22.45), delta);
        msg = "9876.5432 * (1 / 0.625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KIN.toHyakumes(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 0.625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KIN.toHyakumes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 0.625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KIN.toHyakumes(784.46789765434), delta);
        // ====================
        // ====================KIN
        // ====================
        // to_factor = 1.0
        to_factor = KIN.getFactor();
        msg = "-1 * (1 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KIN.toKins(-1.0), delta);
        msg = "-0.1 * (1 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KIN.toKins(-0.1), delta);
        msg = "-0.000456789 * (1 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KIN.toKins(-4.56789E-4), delta);
        msg = "-73.25 * (1 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KIN.toKins(-73.25), delta);
        msg = "-56229.321 * (1 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KIN.toKins(-56229.321), delta);
        msg = "-873.5432456 * (1 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KIN.toKins(-873.5432456), delta);
        msg = "0 * (1 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KIN.toKins(0.0), delta);
        msg = "0.1 * (1 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KIN.toKins(0.1), delta);
        msg = "0.0000876543297 * (1 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KIN.toKins(8.76543297E-5), delta);
        msg = "0.33 * (1 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KIN.toKins(0.33), delta);
        msg = "0.6543 * (1 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KIN.toKins(0.6543), delta);
        msg = "1 * (1 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KIN.toKins(1.0), delta);
        msg = "1.6543 * (1 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KIN.toKins(1.6543), delta);
        msg = "22.45 * (1 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KIN.toKins(22.45), delta);
        msg = "9876.5432 * (1 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KIN.toKins(9876.5432), delta);
        msg = "1987654344.3345 * (1 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KIN.toKins(1.9876543443345E9), delta);
        msg = "784.46789765434 * (1 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KIN.toKins(784.46789765434), delta);
        // ====================
        // ====================KAN
        // ====================
        // to_factor = 6.25
        to_factor = KAN.getFactor();
        msg = "-1 / (6.25 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), KIN.toKans(-1.0), delta);
        msg = "-0.1 / (6.25 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), KIN.toKans(-0.1), delta);
        msg = "-0.000456789 / (6.25 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), KIN.toKans(-4.56789E-4), delta);
        msg = "-73.25 / (6.25 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), KIN.toKans(-73.25), delta);
        msg = "-56229.321 / (6.25 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), KIN.toKans(-56229.321), delta);
        msg = "-873.5432456 / (6.25 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), KIN.toKans(-873.5432456), delta);
        msg = "0 / (6.25 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), KIN.toKans(0.0), delta);
        msg = "0.1 / (6.25 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), KIN.toKans(0.1), delta);
        msg = "0.0000876543297 / (6.25 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), KIN.toKans(8.76543297E-5), delta);
        msg = "0.33 / (6.25 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), KIN.toKans(0.33), delta);
        msg = "0.6543 / (6.25 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), KIN.toKans(0.6543), delta);
        msg = "1 / (6.25 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), KIN.toKans(1.0), delta);
        msg = "1.6543 / (6.25 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), KIN.toKans(1.6543), delta);
        msg = "22.45 / (6.25 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), KIN.toKans(22.45), delta);
        msg = "9876.5432 / (6.25 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), KIN.toKans(9876.5432), delta);
        msg = "1987654344.3345 / (6.25 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), KIN.toKans(1.9876543443345E9), delta);
        msg = "784.46789765434 / (6.25 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), KIN.toKans(784.46789765434), delta);
        // ====================
        // ====================MARU
        // ====================
        // to_factor = 50.0
        to_factor = MARU.getFactor();
        msg = "-1 / (50 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), KIN.toMarus(-1.0), delta);
        msg = "-0.1 / (50 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), KIN.toMarus(-0.1), delta);
        msg = "-0.000456789 / (50 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), KIN.toMarus(-4.56789E-4), delta);
        msg = "-73.25 / (50 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), KIN.toMarus(-73.25), delta);
        msg = "-56229.321 / (50 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), KIN.toMarus(-56229.321), delta);
        msg = "-873.5432456 / (50 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), KIN.toMarus(-873.5432456), delta);
        msg = "0 / (50 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), KIN.toMarus(0.0), delta);
        msg = "0.1 / (50 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), KIN.toMarus(0.1), delta);
        msg = "0.0000876543297 / (50 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), KIN.toMarus(8.76543297E-5), delta);
        msg = "0.33 / (50 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), KIN.toMarus(0.33), delta);
        msg = "0.6543 / (50 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), KIN.toMarus(0.6543), delta);
        msg = "1 / (50 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), KIN.toMarus(1.0), delta);
        msg = "1.6543 / (50 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), KIN.toMarus(1.6543), delta);
        msg = "22.45 / (50 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), KIN.toMarus(22.45), delta);
        msg = "9876.5432 / (50 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), KIN.toMarus(9876.5432), delta);
        msg = "1987654344.3345 / (50 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), KIN.toMarus(1.9876543443345E9), delta);
        msg = "784.46789765434 / (50 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), KIN.toMarus(784.46789765434), delta);
        // ====================
        // ====================TAN
        // ====================
        // to_factor = 100.0
        to_factor = TAN.getFactor();
        msg = "-1 / (100 / 1)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), KIN.toTans(-1.0), delta);
        msg = "-0.1 / (100 / 1)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), KIN.toTans(-0.1), delta);
        msg = "-0.000456789 / (100 / 1)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), KIN.toTans(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 1)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), KIN.toTans(-73.25), delta);
        msg = "-56229.321 / (100 / 1)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), KIN.toTans(-56229.321), delta);
        msg = "-873.5432456 / (100 / 1)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), KIN.toTans(-873.5432456), delta);
        msg = "0 / (100 / 1)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), KIN.toTans(0.0), delta);
        msg = "0.1 / (100 / 1)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), KIN.toTans(0.1), delta);
        msg = "0.0000876543297 / (100 / 1)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), KIN.toTans(8.76543297E-5), delta);
        msg = "0.33 / (100 / 1)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), KIN.toTans(0.33), delta);
        msg = "0.6543 / (100 / 1)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), KIN.toTans(0.6543), delta);
        msg = "1 / (100 / 1)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), KIN.toTans(1.0), delta);
        msg = "1.6543 / (100 / 1)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), KIN.toTans(1.6543), delta);
        msg = "22.45 / (100 / 1)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), KIN.toTans(22.45), delta);
        msg = "9876.5432 / (100 / 1)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), KIN.toTans(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 1)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), KIN.toTans(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 1)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), KIN.toTans(784.46789765434), delta);
    }

    @Test()
    public void testKan() {
        // from_factor = 6.25
        double from_factor = KAN.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================FUN
        // ====================
        // to_factor = 6.25E-4
        to_factor = FUN.getFactor();
        msg = "-1 * (6.25 / 0.000625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KAN.toFuns(-1.0), delta);
        msg = "-0.1 * (6.25 / 0.000625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KAN.toFuns(-0.1), delta);
        msg = "-0.000456789 * (6.25 / 0.000625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KAN.toFuns(-4.56789E-4), delta);
        msg = "-73.25 * (6.25 / 0.000625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KAN.toFuns(-73.25), delta);
        msg = "-56229.321 * (6.25 / 0.000625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KAN.toFuns(-56229.321), delta);
        msg = "-873.5432456 * (6.25 / 0.000625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KAN.toFuns(-873.5432456), delta);
        msg = "0 * (6.25 / 0.000625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KAN.toFuns(0.0), delta);
        msg = "0.1 * (6.25 / 0.000625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KAN.toFuns(0.1), delta);
        msg = "0.0000876543297 * (6.25 / 0.000625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KAN.toFuns(8.76543297E-5), delta);
        msg = "0.33 * (6.25 / 0.000625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KAN.toFuns(0.33), delta);
        msg = "0.6543 * (6.25 / 0.000625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KAN.toFuns(0.6543), delta);
        msg = "1 * (6.25 / 0.000625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KAN.toFuns(1.0), delta);
        msg = "1.6543 * (6.25 / 0.000625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KAN.toFuns(1.6543), delta);
        msg = "22.45 * (6.25 / 0.000625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KAN.toFuns(22.45), delta);
        msg = "9876.5432 * (6.25 / 0.000625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KAN.toFuns(9876.5432), delta);
        msg = "1987654344.3345 * (6.25 / 0.000625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KAN.toFuns(1.9876543443345E9), delta);
        msg = "784.46789765434 * (6.25 / 0.000625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KAN.toFuns(784.46789765434), delta);
        // ====================
        // ====================MOMME
        // ====================
        // to_factor = 0.00625
        to_factor = MOMME.getFactor();
        msg = "-1 * (6.25 / 0.00625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KAN.toMommes(-1.0), delta);
        msg = "-0.1 * (6.25 / 0.00625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KAN.toMommes(-0.1), delta);
        msg = "-0.000456789 * (6.25 / 0.00625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KAN.toMommes(-4.56789E-4), delta);
        msg = "-73.25 * (6.25 / 0.00625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KAN.toMommes(-73.25), delta);
        msg = "-56229.321 * (6.25 / 0.00625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KAN.toMommes(-56229.321), delta);
        msg = "-873.5432456 * (6.25 / 0.00625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KAN.toMommes(-873.5432456), delta);
        msg = "0 * (6.25 / 0.00625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KAN.toMommes(0.0), delta);
        msg = "0.1 * (6.25 / 0.00625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KAN.toMommes(0.1), delta);
        msg = "0.0000876543297 * (6.25 / 0.00625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KAN.toMommes(8.76543297E-5), delta);
        msg = "0.33 * (6.25 / 0.00625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KAN.toMommes(0.33), delta);
        msg = "0.6543 * (6.25 / 0.00625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KAN.toMommes(0.6543), delta);
        msg = "1 * (6.25 / 0.00625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KAN.toMommes(1.0), delta);
        msg = "1.6543 * (6.25 / 0.00625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KAN.toMommes(1.6543), delta);
        msg = "22.45 * (6.25 / 0.00625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KAN.toMommes(22.45), delta);
        msg = "9876.5432 * (6.25 / 0.00625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KAN.toMommes(9876.5432), delta);
        msg = "1987654344.3345 * (6.25 / 0.00625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KAN.toMommes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (6.25 / 0.00625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KAN.toMommes(784.46789765434), delta);
        // ====================
        // ====================HYAKUME
        // ====================
        // to_factor = 0.625
        to_factor = HYAKUME.getFactor();
        msg = "-1 * (6.25 / 0.625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KAN.toHyakumes(-1.0), delta);
        msg = "-0.1 * (6.25 / 0.625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KAN.toHyakumes(-0.1), delta);
        msg = "-0.000456789 * (6.25 / 0.625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KAN.toHyakumes(-4.56789E-4), delta);
        msg = "-73.25 * (6.25 / 0.625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KAN.toHyakumes(-73.25), delta);
        msg = "-56229.321 * (6.25 / 0.625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KAN.toHyakumes(-56229.321), delta);
        msg = "-873.5432456 * (6.25 / 0.625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KAN.toHyakumes(-873.5432456), delta);
        msg = "0 * (6.25 / 0.625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KAN.toHyakumes(0.0), delta);
        msg = "0.1 * (6.25 / 0.625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KAN.toHyakumes(0.1), delta);
        msg = "0.0000876543297 * (6.25 / 0.625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KAN.toHyakumes(8.76543297E-5), delta);
        msg = "0.33 * (6.25 / 0.625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KAN.toHyakumes(0.33), delta);
        msg = "0.6543 * (6.25 / 0.625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KAN.toHyakumes(0.6543), delta);
        msg = "1 * (6.25 / 0.625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KAN.toHyakumes(1.0), delta);
        msg = "1.6543 * (6.25 / 0.625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KAN.toHyakumes(1.6543), delta);
        msg = "22.45 * (6.25 / 0.625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KAN.toHyakumes(22.45), delta);
        msg = "9876.5432 * (6.25 / 0.625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KAN.toHyakumes(9876.5432), delta);
        msg = "1987654344.3345 * (6.25 / 0.625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KAN.toHyakumes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (6.25 / 0.625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KAN.toHyakumes(784.46789765434), delta);
        // ====================
        // ====================KIN
        // ====================
        // to_factor = 1.0
        to_factor = KIN.getFactor();
        msg = "-1 * (6.25 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KAN.toKins(-1.0), delta);
        msg = "-0.1 * (6.25 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KAN.toKins(-0.1), delta);
        msg = "-0.000456789 * (6.25 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KAN.toKins(-4.56789E-4), delta);
        msg = "-73.25 * (6.25 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KAN.toKins(-73.25), delta);
        msg = "-56229.321 * (6.25 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KAN.toKins(-56229.321), delta);
        msg = "-873.5432456 * (6.25 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KAN.toKins(-873.5432456), delta);
        msg = "0 * (6.25 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KAN.toKins(0.0), delta);
        msg = "0.1 * (6.25 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KAN.toKins(0.1), delta);
        msg = "0.0000876543297 * (6.25 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KAN.toKins(8.76543297E-5), delta);
        msg = "0.33 * (6.25 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KAN.toKins(0.33), delta);
        msg = "0.6543 * (6.25 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KAN.toKins(0.6543), delta);
        msg = "1 * (6.25 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KAN.toKins(1.0), delta);
        msg = "1.6543 * (6.25 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KAN.toKins(1.6543), delta);
        msg = "22.45 * (6.25 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KAN.toKins(22.45), delta);
        msg = "9876.5432 * (6.25 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KAN.toKins(9876.5432), delta);
        msg = "1987654344.3345 * (6.25 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KAN.toKins(1.9876543443345E9), delta);
        msg = "784.46789765434 * (6.25 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KAN.toKins(784.46789765434), delta);
        // ====================
        // ====================KAN
        // ====================
        // to_factor = 6.25
        to_factor = KAN.getFactor();
        msg = "-1 * (6.25 / 6.25)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), KAN.toKans(-1.0), delta);
        msg = "-0.1 * (6.25 / 6.25)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), KAN.toKans(-0.1), delta);
        msg = "-0.000456789 * (6.25 / 6.25)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), KAN.toKans(-4.56789E-4), delta);
        msg = "-73.25 * (6.25 / 6.25)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), KAN.toKans(-73.25), delta);
        msg = "-56229.321 * (6.25 / 6.25)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), KAN.toKans(-56229.321), delta);
        msg = "-873.5432456 * (6.25 / 6.25)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), KAN.toKans(-873.5432456), delta);
        msg = "0 * (6.25 / 6.25)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), KAN.toKans(0.0), delta);
        msg = "0.1 * (6.25 / 6.25)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), KAN.toKans(0.1), delta);
        msg = "0.0000876543297 * (6.25 / 6.25)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), KAN.toKans(8.76543297E-5), delta);
        msg = "0.33 * (6.25 / 6.25)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), KAN.toKans(0.33), delta);
        msg = "0.6543 * (6.25 / 6.25)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), KAN.toKans(0.6543), delta);
        msg = "1 * (6.25 / 6.25)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), KAN.toKans(1.0), delta);
        msg = "1.6543 * (6.25 / 6.25)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), KAN.toKans(1.6543), delta);
        msg = "22.45 * (6.25 / 6.25)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), KAN.toKans(22.45), delta);
        msg = "9876.5432 * (6.25 / 6.25)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), KAN.toKans(9876.5432), delta);
        msg = "1987654344.3345 * (6.25 / 6.25)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), KAN.toKans(1.9876543443345E9), delta);
        msg = "784.46789765434 * (6.25 / 6.25)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), KAN.toKans(784.46789765434), delta);
        // ====================
        // ====================MARU
        // ====================
        // to_factor = 50.0
        to_factor = MARU.getFactor();
        msg = "-1 / (50 / 6.25)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), KAN.toMarus(-1.0), delta);
        msg = "-0.1 / (50 / 6.25)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), KAN.toMarus(-0.1), delta);
        msg = "-0.000456789 / (50 / 6.25)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), KAN.toMarus(-4.56789E-4), delta);
        msg = "-73.25 / (50 / 6.25)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), KAN.toMarus(-73.25), delta);
        msg = "-56229.321 / (50 / 6.25)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), KAN.toMarus(-56229.321), delta);
        msg = "-873.5432456 / (50 / 6.25)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), KAN.toMarus(-873.5432456), delta);
        msg = "0 / (50 / 6.25)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), KAN.toMarus(0.0), delta);
        msg = "0.1 / (50 / 6.25)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), KAN.toMarus(0.1), delta);
        msg = "0.0000876543297 / (50 / 6.25)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), KAN.toMarus(8.76543297E-5), delta);
        msg = "0.33 / (50 / 6.25)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), KAN.toMarus(0.33), delta);
        msg = "0.6543 / (50 / 6.25)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), KAN.toMarus(0.6543), delta);
        msg = "1 / (50 / 6.25)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), KAN.toMarus(1.0), delta);
        msg = "1.6543 / (50 / 6.25)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), KAN.toMarus(1.6543), delta);
        msg = "22.45 / (50 / 6.25)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), KAN.toMarus(22.45), delta);
        msg = "9876.5432 / (50 / 6.25)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), KAN.toMarus(9876.5432), delta);
        msg = "1987654344.3345 / (50 / 6.25)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), KAN.toMarus(1.9876543443345E9), delta);
        msg = "784.46789765434 / (50 / 6.25)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), KAN.toMarus(784.46789765434), delta);
        // ====================
        // ====================TAN
        // ====================
        // to_factor = 100.0
        to_factor = TAN.getFactor();
        msg = "-1 / (100 / 6.25)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), KAN.toTans(-1.0), delta);
        msg = "-0.1 / (100 / 6.25)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), KAN.toTans(-0.1), delta);
        msg = "-0.000456789 / (100 / 6.25)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), KAN.toTans(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 6.25)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), KAN.toTans(-73.25), delta);
        msg = "-56229.321 / (100 / 6.25)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), KAN.toTans(-56229.321), delta);
        msg = "-873.5432456 / (100 / 6.25)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), KAN.toTans(-873.5432456), delta);
        msg = "0 / (100 / 6.25)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), KAN.toTans(0.0), delta);
        msg = "0.1 / (100 / 6.25)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), KAN.toTans(0.1), delta);
        msg = "0.0000876543297 / (100 / 6.25)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), KAN.toTans(8.76543297E-5), delta);
        msg = "0.33 / (100 / 6.25)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), KAN.toTans(0.33), delta);
        msg = "0.6543 / (100 / 6.25)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), KAN.toTans(0.6543), delta);
        msg = "1 / (100 / 6.25)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), KAN.toTans(1.0), delta);
        msg = "1.6543 / (100 / 6.25)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), KAN.toTans(1.6543), delta);
        msg = "22.45 / (100 / 6.25)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), KAN.toTans(22.45), delta);
        msg = "9876.5432 / (100 / 6.25)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), KAN.toTans(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 6.25)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), KAN.toTans(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 6.25)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), KAN.toTans(784.46789765434), delta);
    }

    @Test()
    public void testMaru() {
        // from_factor = 50.0
        double from_factor = MARU.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================FUN
        // ====================
        // to_factor = 6.25E-4
        to_factor = FUN.getFactor();
        msg = "-1 * (50 / 0.000625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MARU.toFuns(-1.0), delta);
        msg = "-0.1 * (50 / 0.000625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MARU.toFuns(-0.1), delta);
        msg = "-0.000456789 * (50 / 0.000625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MARU.toFuns(-4.56789E-4), delta);
        msg = "-73.25 * (50 / 0.000625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MARU.toFuns(-73.25), delta);
        msg = "-56229.321 * (50 / 0.000625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MARU.toFuns(-56229.321), delta);
        msg = "-873.5432456 * (50 / 0.000625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MARU.toFuns(-873.5432456), delta);
        msg = "0 * (50 / 0.000625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MARU.toFuns(0.0), delta);
        msg = "0.1 * (50 / 0.000625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MARU.toFuns(0.1), delta);
        msg = "0.0000876543297 * (50 / 0.000625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MARU.toFuns(8.76543297E-5), delta);
        msg = "0.33 * (50 / 0.000625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MARU.toFuns(0.33), delta);
        msg = "0.6543 * (50 / 0.000625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MARU.toFuns(0.6543), delta);
        msg = "1 * (50 / 0.000625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MARU.toFuns(1.0), delta);
        msg = "1.6543 * (50 / 0.000625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MARU.toFuns(1.6543), delta);
        msg = "22.45 * (50 / 0.000625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MARU.toFuns(22.45), delta);
        msg = "9876.5432 * (50 / 0.000625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MARU.toFuns(9876.5432), delta);
        msg = "1987654344.3345 * (50 / 0.000625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MARU.toFuns(1.9876543443345E9), delta);
        msg = "784.46789765434 * (50 / 0.000625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MARU.toFuns(784.46789765434), delta);
        // ====================
        // ====================MOMME
        // ====================
        // to_factor = 0.00625
        to_factor = MOMME.getFactor();
        msg = "-1 * (50 / 0.00625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MARU.toMommes(-1.0), delta);
        msg = "-0.1 * (50 / 0.00625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MARU.toMommes(-0.1), delta);
        msg = "-0.000456789 * (50 / 0.00625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MARU.toMommes(-4.56789E-4), delta);
        msg = "-73.25 * (50 / 0.00625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MARU.toMommes(-73.25), delta);
        msg = "-56229.321 * (50 / 0.00625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MARU.toMommes(-56229.321), delta);
        msg = "-873.5432456 * (50 / 0.00625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MARU.toMommes(-873.5432456), delta);
        msg = "0 * (50 / 0.00625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MARU.toMommes(0.0), delta);
        msg = "0.1 * (50 / 0.00625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MARU.toMommes(0.1), delta);
        msg = "0.0000876543297 * (50 / 0.00625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MARU.toMommes(8.76543297E-5), delta);
        msg = "0.33 * (50 / 0.00625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MARU.toMommes(0.33), delta);
        msg = "0.6543 * (50 / 0.00625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MARU.toMommes(0.6543), delta);
        msg = "1 * (50 / 0.00625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MARU.toMommes(1.0), delta);
        msg = "1.6543 * (50 / 0.00625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MARU.toMommes(1.6543), delta);
        msg = "22.45 * (50 / 0.00625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MARU.toMommes(22.45), delta);
        msg = "9876.5432 * (50 / 0.00625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MARU.toMommes(9876.5432), delta);
        msg = "1987654344.3345 * (50 / 0.00625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MARU.toMommes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (50 / 0.00625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MARU.toMommes(784.46789765434), delta);
        // ====================
        // ====================HYAKUME
        // ====================
        // to_factor = 0.625
        to_factor = HYAKUME.getFactor();
        msg = "-1 * (50 / 0.625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MARU.toHyakumes(-1.0), delta);
        msg = "-0.1 * (50 / 0.625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MARU.toHyakumes(-0.1), delta);
        msg = "-0.000456789 * (50 / 0.625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MARU.toHyakumes(-4.56789E-4), delta);
        msg = "-73.25 * (50 / 0.625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MARU.toHyakumes(-73.25), delta);
        msg = "-56229.321 * (50 / 0.625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MARU.toHyakumes(-56229.321), delta);
        msg = "-873.5432456 * (50 / 0.625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MARU.toHyakumes(-873.5432456), delta);
        msg = "0 * (50 / 0.625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MARU.toHyakumes(0.0), delta);
        msg = "0.1 * (50 / 0.625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MARU.toHyakumes(0.1), delta);
        msg = "0.0000876543297 * (50 / 0.625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MARU.toHyakumes(8.76543297E-5), delta);
        msg = "0.33 * (50 / 0.625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MARU.toHyakumes(0.33), delta);
        msg = "0.6543 * (50 / 0.625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MARU.toHyakumes(0.6543), delta);
        msg = "1 * (50 / 0.625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MARU.toHyakumes(1.0), delta);
        msg = "1.6543 * (50 / 0.625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MARU.toHyakumes(1.6543), delta);
        msg = "22.45 * (50 / 0.625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MARU.toHyakumes(22.45), delta);
        msg = "9876.5432 * (50 / 0.625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MARU.toHyakumes(9876.5432), delta);
        msg = "1987654344.3345 * (50 / 0.625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MARU.toHyakumes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (50 / 0.625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MARU.toHyakumes(784.46789765434), delta);
        // ====================
        // ====================KIN
        // ====================
        // to_factor = 1.0
        to_factor = KIN.getFactor();
        msg = "-1 * (50 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MARU.toKins(-1.0), delta);
        msg = "-0.1 * (50 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MARU.toKins(-0.1), delta);
        msg = "-0.000456789 * (50 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MARU.toKins(-4.56789E-4), delta);
        msg = "-73.25 * (50 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MARU.toKins(-73.25), delta);
        msg = "-56229.321 * (50 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MARU.toKins(-56229.321), delta);
        msg = "-873.5432456 * (50 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MARU.toKins(-873.5432456), delta);
        msg = "0 * (50 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MARU.toKins(0.0), delta);
        msg = "0.1 * (50 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MARU.toKins(0.1), delta);
        msg = "0.0000876543297 * (50 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MARU.toKins(8.76543297E-5), delta);
        msg = "0.33 * (50 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MARU.toKins(0.33), delta);
        msg = "0.6543 * (50 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MARU.toKins(0.6543), delta);
        msg = "1 * (50 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MARU.toKins(1.0), delta);
        msg = "1.6543 * (50 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MARU.toKins(1.6543), delta);
        msg = "22.45 * (50 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MARU.toKins(22.45), delta);
        msg = "9876.5432 * (50 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MARU.toKins(9876.5432), delta);
        msg = "1987654344.3345 * (50 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MARU.toKins(1.9876543443345E9), delta);
        msg = "784.46789765434 * (50 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MARU.toKins(784.46789765434), delta);
        // ====================
        // ====================KAN
        // ====================
        // to_factor = 6.25
        to_factor = KAN.getFactor();
        msg = "-1 * (50 / 6.25)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MARU.toKans(-1.0), delta);
        msg = "-0.1 * (50 / 6.25)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MARU.toKans(-0.1), delta);
        msg = "-0.000456789 * (50 / 6.25)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MARU.toKans(-4.56789E-4), delta);
        msg = "-73.25 * (50 / 6.25)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MARU.toKans(-73.25), delta);
        msg = "-56229.321 * (50 / 6.25)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MARU.toKans(-56229.321), delta);
        msg = "-873.5432456 * (50 / 6.25)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MARU.toKans(-873.5432456), delta);
        msg = "0 * (50 / 6.25)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MARU.toKans(0.0), delta);
        msg = "0.1 * (50 / 6.25)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MARU.toKans(0.1), delta);
        msg = "0.0000876543297 * (50 / 6.25)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MARU.toKans(8.76543297E-5), delta);
        msg = "0.33 * (50 / 6.25)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MARU.toKans(0.33), delta);
        msg = "0.6543 * (50 / 6.25)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MARU.toKans(0.6543), delta);
        msg = "1 * (50 / 6.25)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MARU.toKans(1.0), delta);
        msg = "1.6543 * (50 / 6.25)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MARU.toKans(1.6543), delta);
        msg = "22.45 * (50 / 6.25)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MARU.toKans(22.45), delta);
        msg = "9876.5432 * (50 / 6.25)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MARU.toKans(9876.5432), delta);
        msg = "1987654344.3345 * (50 / 6.25)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MARU.toKans(1.9876543443345E9), delta);
        msg = "784.46789765434 * (50 / 6.25)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MARU.toKans(784.46789765434), delta);
        // ====================
        // ====================MARU
        // ====================
        // to_factor = 50.0
        to_factor = MARU.getFactor();
        msg = "-1 * (50 / 50)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), MARU.toMarus(-1.0), delta);
        msg = "-0.1 * (50 / 50)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), MARU.toMarus(-0.1), delta);
        msg = "-0.000456789 * (50 / 50)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), MARU.toMarus(-4.56789E-4), delta);
        msg = "-73.25 * (50 / 50)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), MARU.toMarus(-73.25), delta);
        msg = "-56229.321 * (50 / 50)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), MARU.toMarus(-56229.321), delta);
        msg = "-873.5432456 * (50 / 50)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), MARU.toMarus(-873.5432456), delta);
        msg = "0 * (50 / 50)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), MARU.toMarus(0.0), delta);
        msg = "0.1 * (50 / 50)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), MARU.toMarus(0.1), delta);
        msg = "0.0000876543297 * (50 / 50)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), MARU.toMarus(8.76543297E-5), delta);
        msg = "0.33 * (50 / 50)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), MARU.toMarus(0.33), delta);
        msg = "0.6543 * (50 / 50)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), MARU.toMarus(0.6543), delta);
        msg = "1 * (50 / 50)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), MARU.toMarus(1.0), delta);
        msg = "1.6543 * (50 / 50)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), MARU.toMarus(1.6543), delta);
        msg = "22.45 * (50 / 50)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), MARU.toMarus(22.45), delta);
        msg = "9876.5432 * (50 / 50)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), MARU.toMarus(9876.5432), delta);
        msg = "1987654344.3345 * (50 / 50)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), MARU.toMarus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (50 / 50)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), MARU.toMarus(784.46789765434), delta);
        // ====================
        // ====================TAN
        // ====================
        // to_factor = 100.0
        to_factor = TAN.getFactor();
        msg = "-1 / (100 / 50)";
        assertEquals(msg, -1.0 / (to_factor / from_factor), MARU.toTans(-1.0), delta);
        msg = "-0.1 / (100 / 50)";
        assertEquals(msg, -0.1 / (to_factor / from_factor), MARU.toTans(-0.1), delta);
        msg = "-0.000456789 / (100 / 50)";
        assertEquals(msg, -4.56789E-4 / (to_factor / from_factor), MARU.toTans(-4.56789E-4), delta);
        msg = "-73.25 / (100 / 50)";
        assertEquals(msg, -73.25 / (to_factor / from_factor), MARU.toTans(-73.25), delta);
        msg = "-56229.321 / (100 / 50)";
        assertEquals(msg, -56229.321 / (to_factor / from_factor), MARU.toTans(-56229.321), delta);
        msg = "-873.5432456 / (100 / 50)";
        assertEquals(msg, -873.5432456 / (to_factor / from_factor), MARU.toTans(-873.5432456), delta);
        msg = "0 / (100 / 50)";
        assertEquals(msg, 0.0 / (to_factor / from_factor), MARU.toTans(0.0), delta);
        msg = "0.1 / (100 / 50)";
        assertEquals(msg, 0.1 / (to_factor / from_factor), MARU.toTans(0.1), delta);
        msg = "0.0000876543297 / (100 / 50)";
        assertEquals(msg, 8.76543297E-5 / (to_factor / from_factor), MARU.toTans(8.76543297E-5), delta);
        msg = "0.33 / (100 / 50)";
        assertEquals(msg, 0.33 / (to_factor / from_factor), MARU.toTans(0.33), delta);
        msg = "0.6543 / (100 / 50)";
        assertEquals(msg, 0.6543 / (to_factor / from_factor), MARU.toTans(0.6543), delta);
        msg = "1 / (100 / 50)";
        assertEquals(msg, 1.0 / (to_factor / from_factor), MARU.toTans(1.0), delta);
        msg = "1.6543 / (100 / 50)";
        assertEquals(msg, 1.6543 / (to_factor / from_factor), MARU.toTans(1.6543), delta);
        msg = "22.45 / (100 / 50)";
        assertEquals(msg, 22.45 / (to_factor / from_factor), MARU.toTans(22.45), delta);
        msg = "9876.5432 / (100 / 50)";
        assertEquals(msg, 9876.5432 / (to_factor / from_factor), MARU.toTans(9876.5432), delta);
        msg = "1987654344.3345 / (100 / 50)";
        assertEquals(msg, 1.9876543443345E9 / (to_factor / from_factor), MARU.toTans(1.9876543443345E9), delta);
        msg = "784.46789765434 / (100 / 50)";
        assertEquals(msg, 784.46789765434 / (to_factor / from_factor), MARU.toTans(784.46789765434), delta);
    }

    @Test()
    public void testTan() {
        // from_factor = 100.0
        double from_factor = TAN.getFactor();
        double to_factor;
        String msg;
        // ====================
        // ====================FUN
        // ====================
        // to_factor = 6.25E-4
        to_factor = FUN.getFactor();
        msg = "-1 * (100 / 0.000625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TAN.toFuns(-1.0), delta);
        msg = "-0.1 * (100 / 0.000625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TAN.toFuns(-0.1), delta);
        msg = "-0.000456789 * (100 / 0.000625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TAN.toFuns(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 0.000625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TAN.toFuns(-73.25), delta);
        msg = "-56229.321 * (100 / 0.000625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TAN.toFuns(-56229.321), delta);
        msg = "-873.5432456 * (100 / 0.000625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TAN.toFuns(-873.5432456), delta);
        msg = "0 * (100 / 0.000625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TAN.toFuns(0.0), delta);
        msg = "0.1 * (100 / 0.000625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TAN.toFuns(0.1), delta);
        msg = "0.0000876543297 * (100 / 0.000625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TAN.toFuns(8.76543297E-5), delta);
        msg = "0.33 * (100 / 0.000625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TAN.toFuns(0.33), delta);
        msg = "0.6543 * (100 / 0.000625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TAN.toFuns(0.6543), delta);
        msg = "1 * (100 / 0.000625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TAN.toFuns(1.0), delta);
        msg = "1.6543 * (100 / 0.000625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TAN.toFuns(1.6543), delta);
        msg = "22.45 * (100 / 0.000625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TAN.toFuns(22.45), delta);
        msg = "9876.5432 * (100 / 0.000625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TAN.toFuns(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 0.000625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TAN.toFuns(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 0.000625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TAN.toFuns(784.46789765434), delta);
        // ====================
        // ====================MOMME
        // ====================
        // to_factor = 0.00625
        to_factor = MOMME.getFactor();
        msg = "-1 * (100 / 0.00625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TAN.toMommes(-1.0), delta);
        msg = "-0.1 * (100 / 0.00625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TAN.toMommes(-0.1), delta);
        msg = "-0.000456789 * (100 / 0.00625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TAN.toMommes(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 0.00625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TAN.toMommes(-73.25), delta);
        msg = "-56229.321 * (100 / 0.00625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TAN.toMommes(-56229.321), delta);
        msg = "-873.5432456 * (100 / 0.00625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TAN.toMommes(-873.5432456), delta);
        msg = "0 * (100 / 0.00625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TAN.toMommes(0.0), delta);
        msg = "0.1 * (100 / 0.00625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TAN.toMommes(0.1), delta);
        msg = "0.0000876543297 * (100 / 0.00625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TAN.toMommes(8.76543297E-5), delta);
        msg = "0.33 * (100 / 0.00625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TAN.toMommes(0.33), delta);
        msg = "0.6543 * (100 / 0.00625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TAN.toMommes(0.6543), delta);
        msg = "1 * (100 / 0.00625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TAN.toMommes(1.0), delta);
        msg = "1.6543 * (100 / 0.00625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TAN.toMommes(1.6543), delta);
        msg = "22.45 * (100 / 0.00625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TAN.toMommes(22.45), delta);
        msg = "9876.5432 * (100 / 0.00625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TAN.toMommes(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 0.00625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TAN.toMommes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 0.00625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TAN.toMommes(784.46789765434), delta);
        // ====================
        // ====================HYAKUME
        // ====================
        // to_factor = 0.625
        to_factor = HYAKUME.getFactor();
        msg = "-1 * (100 / 0.625)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TAN.toHyakumes(-1.0), delta);
        msg = "-0.1 * (100 / 0.625)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TAN.toHyakumes(-0.1), delta);
        msg = "-0.000456789 * (100 / 0.625)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TAN.toHyakumes(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 0.625)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TAN.toHyakumes(-73.25), delta);
        msg = "-56229.321 * (100 / 0.625)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TAN.toHyakumes(-56229.321), delta);
        msg = "-873.5432456 * (100 / 0.625)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TAN.toHyakumes(-873.5432456), delta);
        msg = "0 * (100 / 0.625)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TAN.toHyakumes(0.0), delta);
        msg = "0.1 * (100 / 0.625)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TAN.toHyakumes(0.1), delta);
        msg = "0.0000876543297 * (100 / 0.625)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TAN.toHyakumes(8.76543297E-5), delta);
        msg = "0.33 * (100 / 0.625)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TAN.toHyakumes(0.33), delta);
        msg = "0.6543 * (100 / 0.625)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TAN.toHyakumes(0.6543), delta);
        msg = "1 * (100 / 0.625)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TAN.toHyakumes(1.0), delta);
        msg = "1.6543 * (100 / 0.625)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TAN.toHyakumes(1.6543), delta);
        msg = "22.45 * (100 / 0.625)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TAN.toHyakumes(22.45), delta);
        msg = "9876.5432 * (100 / 0.625)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TAN.toHyakumes(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 0.625)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TAN.toHyakumes(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 0.625)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TAN.toHyakumes(784.46789765434), delta);
        // ====================
        // ====================KIN
        // ====================
        // to_factor = 1.0
        to_factor = KIN.getFactor();
        msg = "-1 * (100 / 1)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TAN.toKins(-1.0), delta);
        msg = "-0.1 * (100 / 1)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TAN.toKins(-0.1), delta);
        msg = "-0.000456789 * (100 / 1)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TAN.toKins(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 1)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TAN.toKins(-73.25), delta);
        msg = "-56229.321 * (100 / 1)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TAN.toKins(-56229.321), delta);
        msg = "-873.5432456 * (100 / 1)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TAN.toKins(-873.5432456), delta);
        msg = "0 * (100 / 1)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TAN.toKins(0.0), delta);
        msg = "0.1 * (100 / 1)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TAN.toKins(0.1), delta);
        msg = "0.0000876543297 * (100 / 1)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TAN.toKins(8.76543297E-5), delta);
        msg = "0.33 * (100 / 1)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TAN.toKins(0.33), delta);
        msg = "0.6543 * (100 / 1)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TAN.toKins(0.6543), delta);
        msg = "1 * (100 / 1)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TAN.toKins(1.0), delta);
        msg = "1.6543 * (100 / 1)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TAN.toKins(1.6543), delta);
        msg = "22.45 * (100 / 1)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TAN.toKins(22.45), delta);
        msg = "9876.5432 * (100 / 1)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TAN.toKins(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 1)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TAN.toKins(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 1)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TAN.toKins(784.46789765434), delta);
        // ====================
        // ====================KAN
        // ====================
        // to_factor = 6.25
        to_factor = KAN.getFactor();
        msg = "-1 * (100 / 6.25)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TAN.toKans(-1.0), delta);
        msg = "-0.1 * (100 / 6.25)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TAN.toKans(-0.1), delta);
        msg = "-0.000456789 * (100 / 6.25)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TAN.toKans(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 6.25)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TAN.toKans(-73.25), delta);
        msg = "-56229.321 * (100 / 6.25)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TAN.toKans(-56229.321), delta);
        msg = "-873.5432456 * (100 / 6.25)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TAN.toKans(-873.5432456), delta);
        msg = "0 * (100 / 6.25)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TAN.toKans(0.0), delta);
        msg = "0.1 * (100 / 6.25)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TAN.toKans(0.1), delta);
        msg = "0.0000876543297 * (100 / 6.25)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TAN.toKans(8.76543297E-5), delta);
        msg = "0.33 * (100 / 6.25)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TAN.toKans(0.33), delta);
        msg = "0.6543 * (100 / 6.25)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TAN.toKans(0.6543), delta);
        msg = "1 * (100 / 6.25)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TAN.toKans(1.0), delta);
        msg = "1.6543 * (100 / 6.25)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TAN.toKans(1.6543), delta);
        msg = "22.45 * (100 / 6.25)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TAN.toKans(22.45), delta);
        msg = "9876.5432 * (100 / 6.25)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TAN.toKans(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 6.25)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TAN.toKans(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 6.25)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TAN.toKans(784.46789765434), delta);
        // ====================
        // ====================MARU
        // ====================
        // to_factor = 50.0
        to_factor = MARU.getFactor();
        msg = "-1 * (100 / 50)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TAN.toMarus(-1.0), delta);
        msg = "-0.1 * (100 / 50)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TAN.toMarus(-0.1), delta);
        msg = "-0.000456789 * (100 / 50)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TAN.toMarus(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 50)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TAN.toMarus(-73.25), delta);
        msg = "-56229.321 * (100 / 50)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TAN.toMarus(-56229.321), delta);
        msg = "-873.5432456 * (100 / 50)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TAN.toMarus(-873.5432456), delta);
        msg = "0 * (100 / 50)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TAN.toMarus(0.0), delta);
        msg = "0.1 * (100 / 50)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TAN.toMarus(0.1), delta);
        msg = "0.0000876543297 * (100 / 50)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TAN.toMarus(8.76543297E-5), delta);
        msg = "0.33 * (100 / 50)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TAN.toMarus(0.33), delta);
        msg = "0.6543 * (100 / 50)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TAN.toMarus(0.6543), delta);
        msg = "1 * (100 / 50)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TAN.toMarus(1.0), delta);
        msg = "1.6543 * (100 / 50)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TAN.toMarus(1.6543), delta);
        msg = "22.45 * (100 / 50)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TAN.toMarus(22.45), delta);
        msg = "9876.5432 * (100 / 50)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TAN.toMarus(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 50)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TAN.toMarus(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 50)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TAN.toMarus(784.46789765434), delta);
        // ====================
        // ====================TAN
        // ====================
        // to_factor = 100.0
        to_factor = TAN.getFactor();
        msg = "-1 * (100 / 100)";
        assertEquals(msg, -1.0 * (from_factor / to_factor), TAN.toTans(-1.0), delta);
        msg = "-0.1 * (100 / 100)";
        assertEquals(msg, -0.1 * (from_factor / to_factor), TAN.toTans(-0.1), delta);
        msg = "-0.000456789 * (100 / 100)";
        assertEquals(msg, -4.56789E-4 * (from_factor / to_factor), TAN.toTans(-4.56789E-4), delta);
        msg = "-73.25 * (100 / 100)";
        assertEquals(msg, -73.25 * (from_factor / to_factor), TAN.toTans(-73.25), delta);
        msg = "-56229.321 * (100 / 100)";
        assertEquals(msg, -56229.321 * (from_factor / to_factor), TAN.toTans(-56229.321), delta);
        msg = "-873.5432456 * (100 / 100)";
        assertEquals(msg, -873.5432456 * (from_factor / to_factor), TAN.toTans(-873.5432456), delta);
        msg = "0 * (100 / 100)";
        assertEquals(msg, 0.0 * (from_factor / to_factor), TAN.toTans(0.0), delta);
        msg = "0.1 * (100 / 100)";
        assertEquals(msg, 0.1 * (from_factor / to_factor), TAN.toTans(0.1), delta);
        msg = "0.0000876543297 * (100 / 100)";
        assertEquals(msg, 8.76543297E-5 * (from_factor / to_factor), TAN.toTans(8.76543297E-5), delta);
        msg = "0.33 * (100 / 100)";
        assertEquals(msg, 0.33 * (from_factor / to_factor), TAN.toTans(0.33), delta);
        msg = "0.6543 * (100 / 100)";
        assertEquals(msg, 0.6543 * (from_factor / to_factor), TAN.toTans(0.6543), delta);
        msg = "1 * (100 / 100)";
        assertEquals(msg, 1.0 * (from_factor / to_factor), TAN.toTans(1.0), delta);
        msg = "1.6543 * (100 / 100)";
        assertEquals(msg, 1.6543 * (from_factor / to_factor), TAN.toTans(1.6543), delta);
        msg = "22.45 * (100 / 100)";
        assertEquals(msg, 22.45 * (from_factor / to_factor), TAN.toTans(22.45), delta);
        msg = "9876.5432 * (100 / 100)";
        assertEquals(msg, 9876.5432 * (from_factor / to_factor), TAN.toTans(9876.5432), delta);
        msg = "1987654344.3345 * (100 / 100)";
        assertEquals(msg, 1.9876543443345E9 * (from_factor / to_factor), TAN.toTans(1.9876543443345E9), delta);
        msg = "784.46789765434 * (100 / 100)";
        assertEquals(msg, 784.46789765434 * (from_factor / to_factor), TAN.toTans(784.46789765434), delta);
    }
}
