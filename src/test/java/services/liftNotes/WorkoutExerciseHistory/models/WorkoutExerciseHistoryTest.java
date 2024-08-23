package services.liftNotes.WorkoutExerciseHistory.models;

import org.junit.jupiter.api.Test;
import services.liftNotes.WorkoutExercises.model.WorkoutExercise;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutExerciseHistoryTest {
    @Test
    public void gettersAndSetters(){
        WorkoutExerciseHistory history = new WorkoutExerciseHistory();

        history.setReps(2);
        history.setSets(3);
        history.setWeight(4);
        history.setCreationDate("test");

        assertEquals(2, history.getReps());
        assertEquals(3, history.getSets());
        assertEquals(4, history.getWeight());
        assertEquals("test", history.getCreationDate());
    }

    @Test
    public void testNoArgsConstructor() {
        WorkoutExerciseHistory history = new WorkoutExerciseHistory();

        assertNotNull(history);
        assertEquals(0, history.getId());
        assertNull(history.getWorkoutExercise());
        assertEquals(0, history.getSets());
        assertEquals(0, history.getReps());
        assertEquals(0, history.getWeight());
        assertNull(history.getCreationDate());
    }

    @Test
    public void testAllArgsConstructor() {
        WorkoutExercise exercise = new WorkoutExercise();
        WorkoutExerciseHistory history = new WorkoutExerciseHistory(1, exercise, 3, 12, 100, "2023-08-23");

        assertEquals(1, history.getId());
        assertEquals(exercise, history.getWorkoutExercise());
        assertEquals(3, history.getSets());
        assertEquals(12, history.getReps());
        assertEquals(100, history.getWeight());
        assertEquals("2023-08-23", history.getCreationDate());
    }

    @Test
    public void testCustomConstructor() {
        WorkoutExercise exercise = new WorkoutExercise();
        WorkoutExerciseHistory history = new WorkoutExerciseHistory(exercise, 3, 12, 100, "2023-08-23");

        assertEquals(exercise, history.getWorkoutExercise());
        assertEquals(3, history.getSets());
        assertEquals(12, history.getReps());
        assertEquals(100, history.getWeight());
        assertEquals("2023-08-23", history.getCreationDate());
    }

}