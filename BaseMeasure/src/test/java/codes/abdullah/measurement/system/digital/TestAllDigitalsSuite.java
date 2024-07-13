package codes.abdullah.measurement.system.digital;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestFixedDigitalByte.class, TestRandomDigitalByte.class, TestFixedDigitalBit.class, TestRandomDigitalBit.class })
public class TestAllDigitalsSuite {
}
