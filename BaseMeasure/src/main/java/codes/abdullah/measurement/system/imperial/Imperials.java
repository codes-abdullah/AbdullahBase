package codes.abdullah.measurement.system.imperial;

import codes.abdullah.measurement.dimension.Area;
import codes.abdullah.measurement.dimension.Length;
import codes.abdullah.measurement.dimension.Mass;
import codes.abdullah.measurement.dimension.Volume;

@SuppressWarnings(value = "unchecked")
public class Imperials {

    static final double max_thous = 1000.0;

    static final double max_inches = 12.0;

    static final double max_feet = 3.0;

    static final double max_yards = 22.0;

    static final double max_chains = 10.0;

    static final double max_furlongs = 8.0;

    static final double max_miles = -1.0;

    static final double thous = 0.00008333333333333333d;

    static final double inches = 0.08333333333333333d;

    static final double feet = 1d;

    static final double yards = 3d;

    static final double chains = 66d;

    static final double furlongs = 660d;

    static final double miles = 5280d;

    public static final ImperialLength THOU = new ImperialLength(thous, "th", 0, max_thous);

    public static final ImperialLength INCH = new ImperialLength(inches, "in", 1, max_inches);

    public static final ImperialLength FOOT = new ImperialLength(feet, "ft", 2, max_feet);

    public static final ImperialLength YARD = new ImperialLength(yards, "yd", 3, max_yards);

    public static final ImperialLength CHAIN = new ImperialLength(chains, "ch", 4, max_chains);

    public static final ImperialLength FURLONG = new ImperialLength(furlongs, "fur", 5, max_furlongs);

    public static final ImperialLength MILE = new ImperialLength(miles, "mi", 6, max_miles);

    static final Imperial<Length>[] IMPERIAL_LENGTH_UNITS = new Imperial[] { THOU, INCH, FOOT, YARD, CHAIN, FURLONG, MILE };

    static final double max_square_thous = 1000.0;

    static final double max_square_inches = 12.0;

    static final double max_square_feet = 3.0;

    static final double max_square_yards = 22.0;

    static final double max_square_chains = 10.0;

    static final double max_square_furlongs = 8.0;

    static final double max_square_miles = -1.0;

    static final double square_thous = 0.00008333333333333333d;

    static final double square_inches = 0.08333333333333333d;

    static final double square_feet = 1d;

    static final double square_yards = 3d;

    static final double square_chains = 66d;

    static final double square_furlongs = 660d;

    static final double square_miles = 5280d;

    public static final ImperialArea SQUARE_THOU = new ImperialArea(square_thous, "th²", 0, max_square_thous);

    public static final ImperialArea SQUARE_INCH = new ImperialArea(square_inches, "in²", 1, max_square_inches);

    public static final ImperialArea SQUARE_FOOT = new ImperialArea(square_feet, "ft²", 2, max_square_feet);

    public static final ImperialArea SQUARE_YARD = new ImperialArea(square_yards, "yd²", 3, max_square_yards);

    public static final ImperialArea SQUARE_CHAIN = new ImperialArea(square_chains, "ch²", 4, max_square_chains);

    public static final ImperialArea SQUARE_FURLONG = new ImperialArea(square_furlongs, "fur²", 5, max_square_furlongs);

    public static final ImperialArea SQUARE_MILE = new ImperialArea(square_miles, "mi²", 6, max_square_miles);

    static final Imperial<Area>[] IMPERIAL_AREA_UNITS = new Imperial[] { SQUARE_THOU, SQUARE_INCH, SQUARE_FOOT, SQUARE_YARD, SQUARE_CHAIN, SQUARE_FURLONG, SQUARE_MILE };

    static final double max_grains = 1.0;

    static final double max_drachms = 27.0;

    static final double max_ounces = 16.0;

    static final double max_pounds = 16.0;

    static final double max_stones = 14.0;

    static final double max_quarters = 2.0;

    static final double max_hundredweights = -1.0;

    static final double grains = 0.0023148148148148147d;

    static final double drachms = 0.0023148148148148147d;

    static final double ounces = 0.0625d;

    static final double pounds = 1d;

    static final double stones = 16d;

    static final double quarters = 224d;

    static final double hundredweights = 448d;

    public static final ImperialMass GRAIN = new ImperialMass(grains, "gr", 0, max_grains);

    public static final ImperialMass DRACHM = new ImperialMass(drachms, "dr", 1, max_drachms);

    public static final ImperialMass OUNCE = new ImperialMass(ounces, "oz", 2, max_ounces);

    public static final ImperialMass POUND = new ImperialMass(pounds, "lb", 3, max_pounds);

    public static final ImperialMass STONE = new ImperialMass(stones, "st", 4, max_stones);

    public static final ImperialMass QUARTER = new ImperialMass(quarters, "qr", 5, max_quarters);

    public static final ImperialMass HUNDREDWEIGHT = new ImperialMass(hundredweights, "cwt", 6, max_hundredweights);

    static final Imperial<Mass>[] IMPERIAL_MASS_UNITS = new Imperial[] { GRAIN, DRACHM, OUNCE, POUND, STONE, QUARTER, HUNDREDWEIGHT };

    static final double max_tea_spoons = 3.0;

    static final double max_table_spoons = 2.0;

    static final double max_fluid_ounces = 5.0;

    static final double max_gills = 4.0;

    static final double max_pints = 2.0;

    static final double max_quarts = 4.0;

    static final double max_gallons = -1.0;

    static final double tea_spoons = 0.16666666666666666d;

    static final double table_spoons = 0.5d;

    static final double fluid_ounces = 1d;

    static final double gills = 5d;

    static final double pints = 20d;

    static final double quarts = 40d;

    static final double gallons = 160d;

    public static final ImperialVolume TEA_SPOON = new ImperialVolume(tea_spoons, "tsp", 0, max_tea_spoons);

    public static final ImperialVolume TABLE_SPOON = new ImperialVolume(table_spoons, "tbsp", 1, max_table_spoons);

    public static final ImperialVolume FLUID_OUNCE = new ImperialVolume(fluid_ounces, "fl.oz", 2, max_fluid_ounces);

    public static final ImperialVolume GILL = new ImperialVolume(gills, "gi", 3, max_gills);

    public static final ImperialVolume PINT = new ImperialVolume(pints, "pt", 4, max_pints);

    public static final ImperialVolume QUART = new ImperialVolume(quarts, "qt", 5, max_quarts);

    public static final ImperialVolume GALLON = new ImperialVolume(gallons, "gal", 6, max_gallons);

    static final Imperial<Volume>[] IMPERIAL_VOLUME_UNITS = new Imperial[] { TEA_SPOON, TABLE_SPOON, FLUID_OUNCE, GILL, PINT, QUART, GALLON };
}
