package services.liftNotes.Excercises.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.liftNotes.Excercises.models.Exercise;
import services.liftNotes.Excercises.service.ExerciseService;

@CrossOrigin
@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    @Autowired
    ExerciseService exerciseService;

    @PostMapping("/add")
    public String addExercise(@RequestBody Exercise exercise){
        exerciseService.saveExercise(exercise);
        return "Exercise Added!";
    }
    @DeleteMapping("/delete")
    public String removeExercise(@RequestParam int exerciseID){
        exerciseService.deleteExercise(exerciseID);
        return "Exercise Deleted!";
    }
    @GetMapping("/all")
    public String getAllExercise(){
        exerciseService.getAllExercise();
        return "Request Completed!";
    }
}
