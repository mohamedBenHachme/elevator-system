package echalenge.elevator;

public class ElevatorRest implements ElevatorState {
	private final Elevator elevator;
	public ElevatorRest(Elevator elevator) {
		this.elevator = elevator;
	}
	@Override
	public void up() {
		System.out.println("Elevator is going up");
		elevator.setState(elevator.getElevatorUp());
		elevator.getState().up();
	}

	@Override
	public void down() {
		System.out.println("Elevator is going down ...");
		elevator.setState(elevator.getElevatorDown());
		elevator.getState().down();
	}
	@Override
	public void rest() {
		System.out.println("Elevator is resting at floor : "+elevator.getCurrentFloor());
	}
	@Override
	public void stop(int floor) {
		// TODO Auto-generated method stub
		
	}
	
}
