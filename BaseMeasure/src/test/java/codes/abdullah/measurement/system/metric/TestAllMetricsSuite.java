package codes.abdullah.measurement.system.metric;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestRandomMetricTime.class, TestFixedMetricTime.class, TestFixedMetricArea.class, TestRandomMetricMass.class, TestRandomMetricArea.class, TestFixedMetricVolume.class, TestFixedMetricMass.class, TestRandomMetricVolume.class, TestFixedMetricLength.class, TestRandomMetricLength.class })
public class TestAllMetricsSuite {
}
