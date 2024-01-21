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

@CrossOrigin
@RestController
@RequestMapping("/workoutExercise")
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

    @PostMapping("/add")
    public ResponseEntity<String> addWorkoutExercise(@RequestParam int workoutID, @RequestParam int exerciseID, @RequestBody WorkoutExercise workoutExercise){
        try {
            Workout workout = workoutsService.getWorkoutByID(workoutID);
            Exercise exercise = exerciseService.getExerciseByID(exerciseID);
            workoutExercise.setWorkout(workout);
            workoutExercise.setExercise(exercise);

            workoutExerciseService.saveWorkoutExercise(workoutExercise);
            return new ResponseEntity<>("Workout exercise added!", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong!", HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> removeWorkoutExercise(@RequestParam int workoutExerciseID){
        workoutExerciseService.removeWorkoutExercise(workoutExerciseID);
        return new ResponseEntity<>("Workout exercise deleted!", HttpStatus.OK) ;
    }
}
