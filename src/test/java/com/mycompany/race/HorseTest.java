package com.mycompany.race;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HorseTest {
    
    @SuppressWarnings("deprecation")
    @Test
    public void testConstructor() {
        Horse horse = new Horse('A', "Black Beauty", 0.8);
        assertEquals('A', horse.getSymbol());
        assertEquals("Black Beauty", horse.getName());
        assertEquals(0.8, horse.getConfidence());
        assertEquals(0, horse.getDistanceTravelled());
        assertFalse(horse.hasFallen());
    }
    
    @Test
    public void testFall() {
        Horse horse = new Horse('B', "Spirit", 0.9);
        assertFalse(horse.hasFallen());
        horse.fall();
        assertTrue(horse.hasFallen());
    }
    
    @Test
    public void testMoveForward() {
        Horse horse = new Horse('C', "Seabiscuit", 0.7);
        assertEquals(0, horse.getDistanceTravelled());
        horse.moveForward();
        assertEquals(1, horse.getDistanceTravelled());
    }
    
    @Test
    public void testGoBackToStart() {
        Horse horse = new Horse('D', "Secretariat", 0.6);
        horse.moveForward();
        horse.moveForward();
        assertEquals(2, horse.getDistanceTravelled());
        horse.goBackToStart();
        assertEquals(0, horse.getDistanceTravelled());
        assertFalse(horse.hasFallen());
    }
    
    @SuppressWarnings("deprecation")
    @Test
    public void testSetConfidence() {
        Horse horse = new Horse('E', "War Admiral", 0.5);
        assertEquals(0.5, horse.getConfidence());
        horse.setConfidence(0.9);
        assertEquals(0.9, horse.getConfidence());
        horse.setConfidence(-0.2);
        assertEquals(0.9, horse.getConfidence()); // Confidence should not change
        horse.setConfidence(1.5);
        assertEquals(0.9, horse.getConfidence()); // Confidence should not change
    }
    
    @Test
    public void testSetSymbol() {
        Horse horse = new Horse('F', "American Pharoah", 0.8);
        assertEquals('F', horse.getSymbol());
        horse.setSymbol('G');
        assertEquals('G', horse.getSymbol());
    }
}