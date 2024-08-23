package services.liftNotes.Excercises.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseTest {
    @Test
    public void testGettersAndSetters() {
        Exercise exercise = new Exercise();

        exercise.setId(1);
        exercise.setGenre("Cardio");
        exercise.setName("Running");
        exercise.setDescription("A cardio exercise that involves running.");

        assertEquals(1, exercise.getId());
        assertEquals("Cardio", exercise.getGenre());
        assertEquals("Running", exercise.getName());
        assertEquals("A cardio exercise that involves running.", exercise.getDescription());
    }

    @Test
    public void testAllArgsConstructor() {
        Exercise exercise = new Exercise(1, "Strength", "Push-up", "A strength exercise where you push yourself up from the ground.");

        assertEquals(1, exercise.getId());
        assertEquals("Strength", exercise.getGenre());
        assertEquals("Push-up", exercise.getName());
        assertEquals("A strength exercise where you push yourself up from the ground.", exercise.getDescription());
    }

    @Test
    public void testNoArgsConstructor() {
        Exercise exercise = new Exercise();

        assertNotNull(exercise);
        assertEquals(0, exercise.getId());
        assertNull(exercise.getGenre());
        assertNull(exercise.getName());
        assertNull(exercise.getDescription());
    }
}