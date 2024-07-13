package codes.abdullah.measurement.system.japan;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestFixedJapanLength.class, TestRandomJapanArea.class, TestFixedJapanArea.class, TestRandomJapanLength.class, TestRandomJapanMass.class, TestFixedJapanMass.class })
public class TestAllJapansSuite {
}
