package codes.abdullah.measurement.system.usc;

import codes.abdullah.measurement.dimension.Length;
import codes.abdullah.measurement.dimension.Volume;

@SuppressWarnings(value = "unchecked")
public class Uscs {

    static final double max_points = 12.0;

    static final double max_picas = 6.0;

    static final double max_inches = 12.0;

    static final double max_feet = 3.0;

    static final double max_yards = 1760.0;

    static final double max_miles = -1.0;

    static final double points = 0.0011574074074074073d;

    static final double picas = 0.013888888888888888d;

    static final double inches = 0.08333333333333333d;

    static final double feet = 1d;

    static final double yards = 3d;

    static final double miles = 5280d;

    public static final UscLength POINT = new UscLength(points, "p", 0, max_points);

    public static final UscLength PICA = new UscLength(picas, "P", 1, max_picas);

    public static final UscLength INCH = new UscLength(inches, "in", 2, max_inches);

    public static final UscLength FOOT = new UscLength(feet, "ft", 3, max_feet);

    public static final UscLength YARD = new UscLength(yards, "yd", 4, max_yards);

    public static final UscLength MILE = new UscLength(miles, "mi", 5, max_miles);

    static final Usc<Length>[] USC_LENGTH_UNITS = new Usc[] { POINT, PICA, INCH, FOOT, YARD, MILE };

    static final double max_tea_spoons = 3.0;

    static final double max_table_spoons = 2.0;

    static final double max_fluid_ounces = 8.0;

    static final double max_cups = 2.0;

    static final double max_pints = 2.0;

    static final double max_quarts = 4.0;

    static final double max_gallons = -1.0;

    static final double tea_spoons = 0.16666666666666666d;

    static final double table_spoons = 0.5d;

    static final double fluid_ounces = 1d;

    static final double cups = 8d;

    static final double pints = 16d;

    static final double quarts = 32d;

    static final double gallons = 128d;

    public static final UscVolume TEA_SPOON = new UscVolume(tea_spoons, "tsp", 0, max_tea_spoons);

    public static final UscVolume TABLE_SPOON = new UscVolume(table_spoons, "tbsp", 1, max_table_spoons);

    public static final UscVolume FLUID_OUNCE = new UscVolume(fluid_ounces, "fl.oz", 2, max_fluid_ounces);

    public static final UscVolume CUP = new UscVolume(cups, "gi", 3, max_cups);

    public static final UscVolume PINT = new UscVolume(pints, "pt", 4, max_pints);

    public static final UscVolume QUART = new UscVolume(quarts, "qt", 5, max_quarts);

    public static final UscVolume GALLON = new UscVolume(gallons, "gal", 6, max_gallons);

    static final Usc<Volume>[] USC_VOLUME_UNITS = new Usc[] { TEA_SPOON, TABLE_SPOON, FLUID_OUNCE, CUP, PINT, QUART, GALLON };

    static final double max_fathoms = 120;

    static final double max_cables = 8.439;

    static final double max_nautical_miles = -1.0;

    static final double fathoms = 6;

    static final double cables = 608.0;

    static final double nautical_miles = 6076.12;

    public static final UscNautical FATHOM = new UscNautical(fathoms, "ftm", 0, max_fathoms);

    public static final UscNautical CABLE = new UscNautical(cables, "cb", 1, max_cables);

    public static final UscNautical NAUTICAL_MILE = new UscNautical(nautical_miles, "NM", 2, max_nautical_miles);

    static final Usc<Length>[] USC_NAUTICAL_UNITS = new Usc[] { FATHOM, CABLE, NAUTICAL_MILE };

    public static void main(String[] args) {
        System.out.println(FATHOM.to(15001, MILE));
    }
}
