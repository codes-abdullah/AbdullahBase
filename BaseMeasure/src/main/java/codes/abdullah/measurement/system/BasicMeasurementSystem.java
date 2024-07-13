package codes.abdullah.measurement.system;

public class BasicMeasurementSystem implements MeasurementSystem {
	private final int id;
	private final String name;

	public BasicMeasurementSystem(String name) {
		this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();		
		this.id = MeasurementSystems.install(this);
	}

	@Override
	public final boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj instanceof MeasurementSystem) {
			MeasurementSystem ms = (MeasurementSystem) obj;
			return ms.getId() == id;
		}
		return false;
	}

	@Override
	public String getName() {
		return name;
	}
	
	

	@Override
	public String toString() {
		return name;
	}

	@Override
	public final int getId() {
		return id;
	}

}
