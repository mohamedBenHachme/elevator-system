package echalenge.elevator;

public class ElevatorUp implements ElevatorState {
	Elevator elevator;
	public ElevatorUp(Elevator elevator) {
		this.elevator = elevator;
	}
	@Override
	public void up() {
		if(elevator.getCurrentFloor() < elevator.getBuilding().getNumberOfFloors()) {
			System.out.println("elevator "+elevator.getCurrentFloor() +" is going up to floor number: "+elevator.getCurrentFloor()+1);
			elevator.setCurrentFloor(elevator.getCurrentFloor()+1);
			elevator.setState(elevator.getElevatorUp());
		}
		else {
			elevator.setState(elevator.getElevatorDown());
			elevator.down();
		}
	}

	@Override
	public void down() {
		System.out.println("elevator is still going Up, it can't switch directions...");		
	}
	@Override
	public void rest() {
		
	}
	@Override
	public void stop(int floor) {
		
	}
	
}
