package services.liftNotes.Workouts.models;

import org.junit.jupiter.api.Test;
import services.liftNotes.config.models.ApplicationUser;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutTest {

    @Test
    public void gettersAndSetters(){
        Workout workout = new Workout();
        ApplicationUser applicationUser = new ApplicationUser();

        workout.setUser(applicationUser);
        workout.setId(0);
        workout.setDate("test");
        workout.setDuration("test1");

        assertEquals(applicationUser, workout.getUser());
        assertEquals(0, workout.getId());
        assertEquals("test",workout.getDate());
        assertEquals("test1",workout.getDuration());
    }
}