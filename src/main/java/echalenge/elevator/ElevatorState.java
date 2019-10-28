package echalenge.elevator;

public interface ElevatorState {
	public void up();
	public void down();
	public void rest();
	public void stop(int floor);
}
