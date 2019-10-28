package echalenge.elevator;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Building {
	private int numberOfFloors;
	private Map<String, Elevator> elevators;
	private Dispatcher dispatcher;
	public Building(int numberOfFloors, String...elevators) {
		dispatcher = Dispatcher.getDispatcher();
		this.elevators = new HashMap<>();
		this.numberOfFloors = numberOfFloors;
		for(String e : elevators) {
			String elevatorId = e.split(":")[0];
			int elevatorCurrentFloor = Integer.parseInt(e.split(":")[1]);
			this.elevators.put(elevatorId, new Elevator(elevatorId, elevatorCurrentFloor));
			
		}
		
		dispatcher.initializeDispatcher(this.elevators, this.numberOfFloors);
	}
	public Elevator getElevator(String id) {
		return elevators.get(id);
	}
	public String requestElevator() {
		Elevator elevator = dispatcher.getClosestElevatorToTop();
		return elevator.getId();
	}
	
	public void move(String elevatorID, String action) {
		Elevator e = elevators.get(elevatorID);
		dispatcher.move(e, action);
	}
	
	
	
}
