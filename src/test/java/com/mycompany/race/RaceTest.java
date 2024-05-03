package com.mycompany.race;


import org.junit.Test;
import static org.junit.Assert.*;

public class RaceTest {


    // Race can be instantiated with a positive integer race length.
    @Test
    public void test_instantiate_race_with_positive_integer_length() {
        Race race = new Race(1000);
        assertNotNull(race);
    }

    // An exception is raised if the race length is not a positive integer.
    @Test
    public void test_exception_raised_for_non_positive_integer_length() {
        assertThrows(IllegalArgumentException.class, () -> {
        });
    }

    // Horses can be added to the race in a given lane.
    @Test
    public void test_addHorseToRace() {
        Race race = new Race(1000);
        Horse horse = new Horse('$', "Venus", 0.7);
        race.addHorse(horse, 1);

    }

    // The race can be started and the horses will move forward or fall depending on their confidence rating.
    @Test
    public void test_race_start_and_horse_movement() {
        Race race = new Race(1000);
    
        Horse horse1 = new Horse('$', "Venus", 0.7);
        Horse horse2 = new Horse('%', "Eva", 0.8);
        Horse horse3 = new Horse('@', "Tay", 0.6);
    
        race.addHorse(horse1, 1);
        race.addHorse(horse2, 2);
        race.addHorse(horse3, 3);
    
        race.startRace();
    
        assertTrue(horse1.getDistanceTravelled() > 0 || horse1.hasFallen());
        assertTrue(horse2.getDistanceTravelled() > 0 || horse2.hasFallen());
        assertTrue(horse3.getDistanceTravelled() > 0 || horse3.hasFallen());
    }

    // The winner of the race can be determined and displayed.
    @Test
    public void test_determine_and_display_winner() {
        Race race = new Race(1000);
    
        Horse horse1 = new Horse('$', "Venus", 0.7);
        Horse horse2 = new Horse('%', "Eva", 0.8);
        Horse horse3 = new Horse('@', "Tay", 0.6);
    
        race.addHorse(horse1, 1);
        race.addHorse(horse2, 2);
        race.addHorse(horse3, 3);
    
        race.startRace();
    
        String winnerName = race.getWinner().getName();
    
        assertNotNull(winnerName);
    }

    // The race positions can be printed on the terminal.
    @Test
    public void test_print_race_positions() {
        // Create a Race instance
        Race race = new Race(10); // Assuming the race length is 1000 meters
    
        // Create Horse instances and add them to the race
        Horse horse1 = new Horse('$', "Venus", 0.7); // Example horse with symbol 'H', name "Horse1", and confidence rating 0.7
        Horse horse2 = new Horse('%', "Eva", 0.8); // Example horse with symbol 'S', name "Horse2", and confidence rating 0.8
        Horse horse3 = new Horse('@', "Tay", 0.6); // Example horse with symbol 'P', name "Horse3", and confidence rating 0.6
    
        race.addHorse(horse1, 1); // Add horse1 to lane 1
        race.addHorse(horse2, 2); // Add horse2 to lane 2
        race.addHorse(horse3, 3); // Add horse3 to lane 3
    
        // Start the race
        race.startRace();
    }

    // An exception is raised if an invalid lane number is provided when adding a horse.
    @Test
    public void test_exception_invalid_lane_number() {
        Race race = new Race(1000);
        Horse horse = new Horse('$', "Venus", 0.7);
    
        assertThrows(IllegalArgumentException.class, () -> {
            race.addHorse(horse, 4);
        });
    }

    // An exception is raised if a horse is added to a non-existent lane.
    @Test
    public void test_exception_when_adding_horse_to_nonexistent_lane() {
        Race race = new Race(1000);
        Horse horse = new Horse('$', "Venus", 0.7);
    
        assertThrows(IllegalArgumentException.class, () -> {
            race.addHorse(horse, 4);
        });
    }

    // A horse cannot move forward if it has fallen.
    @Test
    public void test_horse_cannot_move_forward_if_fallen() {
        Race race = new Race(1000);
        Horse horse = new Horse('$', "Venus", 0.7);
        race.addHorse(horse, 1);
    
        // Set horse to fallen
        horse.fall();
    
        // Move horse forward
        race.moveForward(horse);
    
        // Assert that the distance travelled is still 0
        assertEquals(0, horse.getDistanceTravelled());
    }

    // Add the moveHorse method to the Race class
    public void moveHorse(Horse horse) {
        // Implementation of moving the horse forward
    }

    // The confidence rating of a horse cannot be set to a value outside the range of 0 to 1.
    @Test
    public void test_confidence_rating_range() {
        Horse horse = new Horse('$', "Venus", 0.7);
        horse.setConfidence(0.5);
        assertEquals(0.5, horse.getConfidence(), 0.001);
    
        horse.setConfidence(1.5);
        assertEquals(0.5, horse.getConfidence(), 0.001);
    
        horse.setConfidence(-0.5);
        assertEquals(0.5, horse.getConfidence(), 0.001);
    }

    // The race can handle horses with the same name.
    @Test
    public void test_race_can_handle_horses_with_same_name() {
        Race race = new Race(1000);
    
        Horse horse1 = new Horse('$', "Venus", 0.7);
        Horse horse2 = new Horse('%', "Venus", 0.8);
    
        race.addHorse(horse1, 1);
        race.addHorse(horse2, 2);
    
        race.startRace();
    
        assertTrue(race.raceWonBy(horse1) || race.raceWonBy(horse2));
    }

    // The race can handle more than three horses.
    @Test
    public void test_race_can_handle_more_than_three_horses() {
        Race race = new Race(1000);
    
        Horse horse1 = new Horse('$', "Venus", 0.7);
        Horse horse2 = new Horse('%', "Eva", 0.8);
        Horse horse3 = new Horse('@', "Tay", 0.6);
        Horse horse4 = new Horse('#', "Mars", 0.9);
    
        race.addHorse(horse1, 1);
        race.addHorse(horse2, 2);
        race.addHorse(horse3, 3);
        race.addHorse(horse4, 4);
    
        race.startRace();
    
        assertTrue(race.raceWonBy(horse1) || race.raceWonBy(horse2) || race.raceWonBy(horse3) || race.raceWonBy(horse4));
    }

    // The race can handle horses with the same symbol.
    @Test
    public void test_race_can_handle_horses_with_same_symbol() {
        Race race = new Race(1000);
    
        Horse horse1 = new Horse('$', "Venus", 0.7);
        Horse horse2 = new Horse('$', "Eva", 0.8);
    
        race.addHorse(horse1, 1);
        race.addHorse(horse2, 2);
    
        race.startRace();
    
        assertTrue(race.raceWonBy(horse1) || race.raceWonBy(horse2));
    }

    // The race can handle horses with the same confidence rating.
    @Test
    public void test_race_with_same_confidence_rating() {
        Race race = new Race(1000);
    
        Horse horse1 = new Horse('$', "Venus", 0.7);
        Horse horse2 = new Horse('%', "Eva", 0.7);
        Horse horse3 = new Horse('@', "Tay", 0.7);
    
        race.addHorse(horse1, 1);
        race.addHorse(horse2, 2);
        race.addHorse(horse3, 3);
    
        race.startRace();
    
        assertTrue(race.raceWonBy(horse1) || race.raceWonBy(horse2) || race.raceWonBy(horse3));
    }

    // The race can handle horses with a confidence rating of 0 or 1.
    @Test
    public void test_race_can_handle_horses_with_confidence_0_or_1() {
        Race race = new Race(1000);
    
        Horse horse1 = new Horse('$', "Venus", 0); // Horse with confidence rating 0
        Horse horse2 = new Horse('%', "Eva", 1); // Horse with confidence rating 1
    
        race.addHorse(horse1, 1);
        race.addHorse(horse2, 2);
    
        race.startRace();
    
        assertTrue(race.raceWonBy(horse1) || race.raceWonBy(horse2));
    }
}