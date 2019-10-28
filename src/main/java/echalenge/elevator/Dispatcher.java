package echalenge.elevator;

import java.util.Map;

public class Dispatcher {
	private static Dispatcher dispatcher = null;
	private Map<String, Elevator> elevators;
	private int nomberOfFloors = 0;
	private Dispatcher() {
	}
	public static Dispatcher getDispatcher() {
		if(dispatcher == null) {
			dispatcher = new Dispatcher();
		}
		return dispatcher;
	}
	
	public void initializeDispatcher(Map<String, Elevator> elevators, int nomberOfFloors) {
		this.elevators = elevators;
		this.nomberOfFloors = nomberOfFloors;
	}
	
	public Elevator getClosestElevatorToTop() {
		Elevator elevator = null;
		int topElevatorFloor = 0;
		for(Elevator e : elevators.values()) {
			if( e.getCurrentFloor() >= topElevatorFloor ) {
				topElevatorFloor = e.getCurrentFloor();
				elevator = e;
				
			}
		}
		return elevator;
	}
	public void move(Elevator e, String action) {
		switch(action) {
			case "DOWN":
				e.down();
				break;
			case "UP":
				e.up();
		}
		
	}
	
	
	
}
