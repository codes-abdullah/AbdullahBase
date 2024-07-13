package codes.abdullah.measurement.system.japan;

import codes.abdullah.measurement.dimension.Area;
import codes.abdullah.measurement.dimension.Length;
import codes.abdullah.measurement.dimension.Mass;
import codes.abdullah.measurement.dimension.Volume;

@SuppressWarnings(value = "unchecked")
public class Japans {

    static final double max_mos = 10.0;

    static final double max_rins = 10.0;

    static final double max_bus = 10.0;

    static final double max_suns = 10.0;

    static final double max_shakus = 6.0;

    static final double max_kens = 1.6666666666666667;

    static final double max_jos = 36.0;

    static final double max_chos = 36.0;

    static final double max_ris = -1.0;

    static final double mos = 0.0001d;

    static final double rins = 0.001d;

    static final double bus = 0.01d;

    static final double suns = 0.1d;

    static final double shakus = 1d;

    static final double kens = 6d;

    static final double jos = 10d;

    static final double chos = 360d;

    static final double ris = 12960d;

    public static final JapanLength MO = new JapanLength(mos, "毛", 0, max_mos);

    public static final JapanLength RIN = new JapanLength(rins, "厘", 1, max_rins);

    public static final JapanLength BU = new JapanLength(bus, "分", 2, max_bus);

    public static final JapanLength SUN = new JapanLength(suns, "寸", 3, max_suns);

    public static final JapanLength SHAKU = new JapanLength(shakus, "尺", 4, max_shakus);

    public static final JapanLength KEN = new JapanLength(kens, "間", 5, max_kens);

    public static final JapanLength JO = new JapanLength(jos, "丈", 6, max_jos);

    public static final JapanLength CHO = new JapanLength(chos, "町", 7, max_chos);

    public static final JapanLength RI = new JapanLength(ris, "里", 8, max_ris);

    static final Japan<Length>[] JAPAN_LENGTH_UNITS = new Japan[] { MO, RIN, BU, SUN, SHAKU, KEN, JO, CHO, RI };

    public static final class area {

        private area() {
        }

        static final double max_shakus = 10.0;

        static final double max_gos = 5.0;

        static final double max_jos = 2.0;

        static final double max_tsubos = 30.0;

        static final double max_ses = 10.0;

        static final double max_tans = 10.0;

        static final double max_chos = -1.0;

        static final double shakus = 0.01d;

        static final double gos = 0.1d;

        static final double jos = 0.5d;

        static final double tsubos = 1d;

        static final double ses = 30d;

        static final double tans = 300d;

        static final double chos = 3000d;

        public static final JapanArea SHAKU = new JapanArea(shakus, "勺", 0, max_shakus);

        public static final JapanArea GO = new JapanArea(gos, "合", 1, max_gos);

        public static final JapanArea JO = new JapanArea(jos, "畳", 2, max_jos);

        public static final JapanArea TSUBO = new JapanArea(tsubos, "坪", 3, max_tsubos);

        public static final JapanArea SE = new JapanArea(ses, "畝", 4, max_ses);

        public static final JapanArea TAN = new JapanArea(tans, "段", 5, max_tans);

        public static final JapanArea CHO = new JapanArea(chos, "町", 6, max_chos);

        static final Japan<Area>[] JAPAN_AREA_UNITS = new Japan[] { SHAKU, GO, JO, TSUBO, SE, TAN, CHO };
    }

    static final double max_funs = 10.0;

    static final double max_mommes = 100.0;

    static final double max_hyakumes = 1.6;

    static final double max_kins = 6.25;

    static final double max_kans = 8.0;

    static final double max_marus = 2.0;

    static final double max_tans = -1.0;

    static final double funs = 0.000625d;

    static final double mommes = 0.00625d;

    static final double hyakumes = 0.625d;

    static final double kins = 1d;

    static final double kans = 6.25d;

    static final double marus = 50d;

    static final double tans = 100d;

    public static final JapanMass FUN = new JapanMass(funs, "分", 0, max_funs);

    public static final JapanMass MOMME = new JapanMass(mommes, "匁", 1, max_mommes);

    public static final JapanMass HYAKUME = new JapanMass(hyakumes, "百目", 2, max_hyakumes);

    public static final JapanMass KIN = new JapanMass(kins, "斤", 3, max_kins);

    public static final JapanMass KAN = new JapanMass(kans, "貫", 4, max_kans);

    public static final JapanMass MARU = new JapanMass(marus, "丸", 5, max_marus);

    public static final JapanMass TAN = new JapanMass(tans, "担", 6, max_tans);

    static final Japan<Mass>[] JAPAN_MASS_UNITS = new Japan[] { FUN, MOMME, HYAKUME, KIN, KAN, MARU, TAN };

    public static final class volume {

        private volume() {
        }

        static final double max_sais = 0.001;

        static final double max_shakus = 0.01;

        static final double max_gos = 0.1;

        static final double max_shos = 1.0;

        static final double max_tos = 10.0;

        static final double max_kokus = -1.0;

        static final double sais = 1000000d;

        static final double shakus = 1000d;

        static final double gos = 10d;

        static final double shos = 1d;

        static final double tos = 1d;

        static final double kokus = 10d;

        public static final JapanVolume SAI = new JapanVolume(sais, "才", 0, max_sais);

        public static final JapanVolume SHAKU = new JapanVolume(shakus, "勺", 1, max_shakus);

        public static final JapanVolume GO = new JapanVolume(gos, "合", 2, max_gos);

        public static final JapanVolume SHO = new JapanVolume(shos, "升", 3, max_shos);

        public static final JapanVolume TO = new JapanVolume(tos, "斗", 4, max_tos);

        public static final JapanVolume KOKU = new JapanVolume(kokus, "石", 5, max_kokus);

        static final Japan<Volume>[] JAPAN_VOLUME_UNITS = new Japan[] { SAI, SHAKU, GO, SHO, TO, KOKU };
    }
}
