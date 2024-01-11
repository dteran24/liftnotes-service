package services.liftNotes.WorkoutExercises.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.liftNotes.WorkoutExercises.model.WorkoutExercise;
import services.liftNotes.WorkoutExercises.service.WorkoutExerciseService;

@CrossOrigin
@RestController
@RequestMapping("/workoutExercise")
public class WorkoutExerciseController {
    @Autowired
    private WorkoutExerciseService workoutExerciseService;

    @PostMapping("/add")
    public String addWorkoutExercise(WorkoutExercise workoutExercise){
        workoutExerciseService.saveWorkoutExercise(workoutExercise);
        return "Workout exercise Added!";
    }
}
