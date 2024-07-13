package codes.abdullah.measurement.system.digital;

import codes.abdullah.measurement.dimension.Data;

@SuppressWarnings(value = "unchecked")
public class Digitals {

    static final double max_bytes = 1000.0;

    static final double max_kilobytes = 1000.0;

    static final double max_megabytes = 1000.0;

    static final double max_gigabytes = 1000.0;

    static final double max_terabytes = 1000.0;

    static final double max_petabytes = -1.0;

    static final double bytes = 0.000001d;

    static final double kilobytes = 0.001d;

    static final double megabytes = 1d;

    static final double gigabytes = 1000d;

    static final double terabytes = 1000000d;

    static final double petabytes = 1000000000d;

    public static final DigitalByte BYTE = new DigitalByte(bytes, "b", 0, max_bytes);

    public static final DigitalByte KILOBYTE = new DigitalByte(kilobytes, "kb", 1, max_kilobytes);

    public static final DigitalByte MEGABYTE = new DigitalByte(megabytes, "mb", 2, max_megabytes);

    public static final DigitalByte GIGABYTE = new DigitalByte(gigabytes, "gb", 3, max_gigabytes);

    public static final DigitalByte TERABYTE = new DigitalByte(terabytes, "tb", 4, max_terabytes);

    public static final DigitalByte PETABYTE = new DigitalByte(petabytes, "pb", 5, max_petabytes);

    static final Digital<Data>[] DIGITAL_BYTE_UNITS = new Digital[] { BYTE, KILOBYTE, MEGABYTE, GIGABYTE, TERABYTE, PETABYTE };

    static final double max_bits = 1000.0;

    static final double max_kilobits = 1000.0;

    static final double max_megabits = 1000.0;

    static final double max_gigabits = 1000.0;

    static final double max_terabits = 1000.0;

    static final double max_petabits = -1.0;

    static final double bits = 0.000001d;

    static final double kilobits = 0.001d;

    static final double megabits = 1d;

    static final double gigabits = 1000d;

    static final double terabits = 1000000d;

    static final double petabits = 1000000000d;

    public static final DigitalBit BIT = new DigitalBit(bits, "bit", 0, max_bits);

    public static final DigitalBit KILOBIT = new DigitalBit(kilobits, "kbit", 1, max_kilobits);

    public static final DigitalBit MEGABIT = new DigitalBit(megabits, "mbit", 2, max_megabits);

    public static final DigitalBit GIGABIT = new DigitalBit(gigabits, "gbit", 3, max_gigabits);

    public static final DigitalBit TERABIT = new DigitalBit(terabits, "tbit", 4, max_terabits);

    public static final DigitalBit PETABIT = new DigitalBit(petabits, "pbit", 5, max_petabits);

    static final Digital<Data>[] DIGITAL_BIT_UNITS = new Digital[] { BIT, KILOBIT, MEGABIT, GIGABIT, TERABIT, PETABIT };
}
