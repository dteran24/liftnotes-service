package services.liftNotes.Workouts.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import services.liftNotes.Utils.GetDate;
import services.liftNotes.Workouts.models.Workout;
import services.liftNotes.Workouts.service.WorkoutsService;
import services.liftNotes.config.exceptions.WorkoutDoesNotExist;
import services.liftNotes.config.models.ApplicationUser;
import services.liftNotes.config.service.UserService;

import java.util.HashMap;
import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping("/workout")
public class WorkoutsController {

    private final WorkoutsService workoutService;
    private final UserService userService;

    @Autowired
    public WorkoutsController(WorkoutsService workoutsService, UserService userService){
        super();
        this.workoutService = workoutsService;
        this.userService = userService;


    }


    @GetMapping("/workout/{id}")
    public ResponseEntity<Object> getWorkoutById(@PathVariable int workoutID){
        try{
            Workout workout = workoutService.getWorkoutByID(workoutID);

            return new ResponseEntity<>(workout, HttpStatus.OK);
        } catch (WorkoutDoesNotExist e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/add")
    public ResponseEntity<String> addWorkout(@RequestBody Workout workout) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        ApplicationUser user = userService.loadUserByUsername(username);

        if (user != null) {
            workout.setUser(user);
            workout.setDate(GetDate.currentDate());
            workoutService.saveWorkout(workout);
            return new ResponseEntity<>("Workout Added!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("User not found for ID: " + username, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{workoutID}")
    public ResponseEntity<String> deleteWorkout(@PathVariable int workoutID){
        try{
            workoutService.deleteWorkout(workoutID);
            return new ResponseEntity<>("Workout Deleted!", HttpStatus.OK);
        } catch (WorkoutDoesNotExist e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }


    }

}



