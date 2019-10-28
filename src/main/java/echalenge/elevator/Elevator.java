package echalenge.elevator;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Elevator implements ElevatorState {
	private String id;
	private int currentFloor;
	private Building building;
	private ElevatorState state;
	
	private ElevatorUp elevatorUp;
	private ElevatorDown elevatorDown;
	private ElevatorRest elevatorRest;
	
	public Elevator(String id, int currentFloor) {
		elevatorDown = new ElevatorDown(this);
		elevatorUp = new ElevatorUp(this);
		elevatorRest = new ElevatorRest(this);
		this.id = id;
		this.currentFloor = currentFloor;
		this.state = new ElevatorRest(this);
	}

	@Override
	public void up() {
		state.up();
	}

	@Override
	public void down() {
		state.down();
	}

	@Override
	public void rest() {
		state.rest();
	}

	@Override
	public void stop(int floor) {
		state.stop(floor);
	}
	
}
