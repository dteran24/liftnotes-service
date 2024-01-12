package services.liftNotes.WorkoutExercises.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private WorkoutExerciseService workoutExerciseService;
    @Autowired
    private WorkoutsService workoutsService;
    @Autowired
    private ExerciseService exerciseService;

    @PostMapping("/add")
    public String addWorkoutExercise(@RequestParam int workoutID, @RequestParam int exerciseID, @RequestBody WorkoutExercise workoutExercise){
        Workout workout = workoutsService.getWorkoutByID(workoutID);
        Exercise exercise = exerciseService.getExerciseByID(exerciseID);
        workoutExercise.setWorkout(workout);
        workoutExercise.setExercise(exercise);

        workoutExerciseService.saveWorkoutExercise(workoutExercise);
        return "Workout exercise added!";
    }
    @DeleteMapping("/delete")
    public String removeWorkoutExercise(@RequestParam int workoutExerciseID){
        workoutExerciseService.removeWorkoutExercise(workoutExerciseID);
        return "Workout exercise deleted!";
    }
}
