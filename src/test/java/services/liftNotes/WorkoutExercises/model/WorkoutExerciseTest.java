package services.liftNotes.WorkoutExercises.model;

import org.junit.jupiter.api.Test;
import services.liftNotes.Excercises.models.Exercise;
import services.liftNotes.WorkoutExerciseHistory.models.WorkoutExerciseHistory;
import services.liftNotes.config.models.ApplicationUser;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutExerciseTest {
    @Test
    public void gettersAndSetters(){
        WorkoutExercise workoutExercise = new WorkoutExercise();
        Exercise exercise = new Exercise();
        ApplicationUser applicationUser = new ApplicationUser();
        List<WorkoutExerciseHistory> historyList = new ArrayList<>();

        workoutExercise.setId(0);
        workoutExercise.setExercise(exercise);
        workoutExercise.setSets(1);
        workoutExercise.setReps(2);
        workoutExercise.setWeight(3);
        workoutExercise.setCreationDate("test");
        workoutExercise.setLastUpdated("test2");
        workoutExercise.setUser(applicationUser);
        workoutExercise.setHistoryList(historyList);

        assertEquals(exercise, workoutExercise.getExercise());
        assertEquals(0, workoutExercise.getId());
        assertEquals(1, workoutExercise.getSets());
        assertEquals(2,workoutExercise.getReps());
        assertEquals(3, workoutExercise.getWeight());
        assertEquals("test",workoutExercise.getCreationDate());
        assertEquals("test2", workoutExercise.getLastUpdated());
        assertEquals(applicationUser, workoutExercise.getUser());
        assertEquals(historyList, workoutExercise.getHistoryList());

    }
}