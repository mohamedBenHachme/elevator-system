package echalenge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import echalenge.elevator.Building;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EchalengeApplicationTests {

	@Test
	public void the_closest_elevator_to_top_floor_should_arrive_first() {
		int numberOfFloors = 10;
		Building building = new Building(numberOfFloors, "id1:1", "id2:6");
		String idOfFirstAvailableEevator = building.requestElevator();
		assertEquals("id2", idOfFirstAvailableEevator);
	}
	
	@Test
	public void elevators_going_down_arrive_last_to_top_floor() {
		Building building = new Building(10, "id1:1", "id2:6");
		building.move("id2", "DOWN");
		String idOfFirstAvailableEevator = building.requestElevator();
		assertEquals("id1", idOfFirstAvailableEevator);
	}
	
	@Test
	public void elevators_goign_up_arrive_to_top_floor_befor_those_going_down() {
		Building building = new Building(10, "id1:1", "id2:6");
		building.move("id1", "UP");
		building.move("id2", "DOWN");
		String idOfFirstAvailableEevator = building.requestElevator();
		assertEquals("id1", idOfFirstAvailableEevator);
	}
	
	@Test
	public void elevators_going_up_should_be_compared_to_those_resting() {
		Building building = new Building(10, "id1:1", "id2:6", "id3:5");
		building.move("id1", "UP");
		building.move("id2", "DOWN");
		String idOfFirstAvailableEevator = building.requestElevator();
		System.out.println(" id1 "+building.getElevator("id1").getCurrentFloor());
		assertEquals("id3", idOfFirstAvailableEevator);
	}
}
