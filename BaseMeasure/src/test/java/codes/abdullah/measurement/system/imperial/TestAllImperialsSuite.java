package codes.abdullah.measurement.system.imperial;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestFixedImperialArea.class, TestFixedImperialVolume.class, TestRandomImperialVolume.class, TestFixedImperialMass.class, TestRandomImperialLength.class, TestFixedImperialLength.class, TestRandomImperialMass.class, TestRandomImperialArea.class })
public class TestAllImperialsSuite {
}
