package services.liftNotes.Excercises.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.liftNotes.Excercises.models.Exercise;
import services.liftNotes.Excercises.service.ExerciseService;
import services.liftNotes.Utils.GetDate;
import services.liftNotes.config.exceptions.ExerciseAlreadyExists;
import services.liftNotes.config.exceptions.ExerciseDoesNotExist;

import java.util.List;


@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;
    @Autowired
    public ExerciseController(ExerciseService exerciseService){
        super();
        this.exerciseService = exerciseService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addExercise(@RequestBody Exercise exercise){

        try {
            exerciseService.saveExercise(exercise);
            return new ResponseEntity<>("Exercise Created!", HttpStatus.CREATED);
        }catch (ExerciseAlreadyExists e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }
    @DeleteMapping("/delete/{exerciseID}")
    public ResponseEntity<String> removeExercise(@PathVariable int exerciseID) {
        try{
            exerciseService.deleteExercise(exerciseID);
            return new ResponseEntity<>("Exercise Deleted!", HttpStatus.OK);
        }catch (ExerciseDoesNotExist e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<Object> getAllExercise(){
        List<Exercise> allExercises = exerciseService.getAllExercise();

        if (allExercises.isEmpty()){
            return new ResponseEntity<>("There are no exercises at the moment!", HttpStatus.OK);
        }
        return new ResponseEntity<>(allExercises, HttpStatus.OK);
    }
}
