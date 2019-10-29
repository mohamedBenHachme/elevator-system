package echalenge.elevator;

public class ElevatorDown implements ElevatorState {
	private final Elevator elevator;
	public ElevatorDown(Elevator elevator) {
		this.elevator = elevator;
	}
	@Override
	public void up() {
		if( elevator.getCurrentFloor() == 1) {
			elevator.setState(elevator.getElevatorUp());
		}
		else {
			System.out.println("elevator "+ elevator.getId() +"  is still going down, it can't switch directions...");
		}
	}

	@Override
	public void down() {
		if(elevator.getCurrentFloor() > 1) {
			System.out.println("elevator "+ elevator.getId() +" is going down to floor number: "+ (elevator.getCurrentFloor()-1));
			elevator.setCurrentFloor(elevator.getCurrentFloor()-1);
			down();
		}
		else {
			elevator.setState(elevator.getElevatorRest());
			elevator.up();
		}			
	}
	@Override
	public void rest() {
		
	}
	@Override
	public void stop(int floor) {
		// TODO Auto-generated method stub
		
	}
	
	
}
