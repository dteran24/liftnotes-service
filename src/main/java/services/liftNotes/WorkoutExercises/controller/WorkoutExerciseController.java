package services.liftNotes.WorkoutExercises.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.liftNotes.Excercises.models.Exercise;
import services.liftNotes.Excercises.service.ExerciseService;
import services.liftNotes.WorkoutExercises.model.WorkoutExercise;
import services.liftNotes.WorkoutExercises.service.WorkoutExerciseService;
import services.liftNotes.Workouts.models.Workout;
import services.liftNotes.Workouts.service.WorkoutsService;
import services.liftNotes.config.exceptions.WorkoutExerciseDoesNotExist;

import java.util.List;


@RestController
@RequestMapping("/workoutExercise")
@CrossOrigin("*")
public class WorkoutExerciseController {

    private final WorkoutExerciseService workoutExerciseService;
    private final WorkoutsService workoutsService;
    private final ExerciseService exerciseService;

    @Autowired
    public WorkoutExerciseController(WorkoutsService workoutsService, WorkoutExerciseService workoutExerciseService, ExerciseService exerciseService){
        super();
        this.workoutsService = workoutsService;
        this.workoutExerciseService = workoutExerciseService;
        this.exerciseService =exerciseService;
    }


    //adding workout later on
    @PostMapping("/add")
    public ResponseEntity<String> addWorkoutExercise(@RequestParam int exerciseID, @RequestBody WorkoutExercise workoutExercise){
        try {
//            Workout workout = workoutsService.getWorkoutByID(workoutID);
            Exercise exercise = exerciseService.getExerciseByID(exerciseID);
//            workoutExercise.setWorkout(workout);
            workoutExercise.setExercise(exercise);

            workoutExerciseService.saveWorkoutExercise(workoutExercise);
            return new ResponseEntity<>("Workout exercise added!", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong!", HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> removeWorkoutExercise(@RequestParam int workoutExerciseID) throws WorkoutExerciseDoesNotExist {
        try {
            workoutExerciseService.removeWorkoutExercise(workoutExerciseID);
            return new ResponseEntity<>("Workout exercise deleted!", HttpStatus.OK) ;
        }catch (WorkoutExerciseDoesNotExist e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT) ;
        }


    }

    @GetMapping("/all")
    public ResponseEntity<Object> allWorkoutsAndExercise(){
        List<WorkoutExercise> data =  workoutExerciseService.getAllWorkoutData();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
