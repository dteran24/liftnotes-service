package services.liftNotes.WorkoutExercises.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.liftNotes.Excercises.models.Exercise;
import services.liftNotes.Excercises.service.ExerciseService;
import services.liftNotes.Utils.GetDate;
import services.liftNotes.WorkoutExercises.model.WorkoutExercise;
import services.liftNotes.WorkoutExercises.service.WorkoutExerciseService;
import services.liftNotes.Workouts.models.Workout;
import services.liftNotes.Workouts.service.WorkoutsService;
import services.liftNotes.config.exceptions.WorkoutExerciseDoesNotExist;

import java.util.List;


@RestController
@RequestMapping("/workoutExercise")
public class WorkoutExerciseController {

    private final WorkoutExerciseService workoutExerciseService;
    private final ExerciseService exerciseService;
    private final UserService userService;

    @Autowired
    public WorkoutExerciseController(UserService userService, WorkoutExerciseService workoutExerciseService, ExerciseService exerciseService){
        super();
        this.userService = userService;
        this.workoutExerciseService = workoutExerciseService;
        this.exerciseService =exerciseService;
    }


    //adding workout later on
    @PostMapping("/add/{workoutExerciseID}")
    public ResponseEntity<String> addWorkoutExercise(@PathVariable int workoutExerciseID, @RequestBody WorkoutExercise workoutExercise){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        ApplicationUser user = userService.loadUserByUsername(username);

        if(user != null) {
            try {
                workoutExercise.setUser(user);
                workoutExercise.setCreationDate(GetDate.currentDate());
//            Workout workout = workoutsService.getWorkoutByID(workoutID);
                Exercise exercise = exerciseService.getExerciseByID(workoutExerciseID);
//            workoutExercise.setWorkout(workout);
                workoutExercise.setExercise(exercise);

                workoutExerciseService.saveWorkoutExercise(workoutExercise);
                return new ResponseEntity<>("Workout exercise added!", HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }else{
            return new ResponseEntity<>("No User found!", HttpStatus.UNAUTHORIZED);
        }

    }
    @DeleteMapping("/delete/{workoutExerciseID}")
    public ResponseEntity<String> removeWorkoutExercise(@PathVariable int workoutExerciseID) {
        try {
            workoutExerciseService.removeWorkoutExercise(workoutExerciseID);
            return new ResponseEntity<>("Workout exercise deleted!", HttpStatus.OK) ;
        }catch (WorkoutExerciseDoesNotExist e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT) ;
        }


    }
    @PatchMapping("/update/{workoutExerciseID}")
    public ResponseEntity<String> updateWorkoutExercise(@PathVariable int workoutExerciseID, @RequestBody WorkoutExercise workoutExercise){
        try{
            workoutExerciseService.updateWorkoutExercise(workoutExerciseID, workoutExercise);
            return new ResponseEntity<>("Workout updated!", HttpStatus.OK);
        }catch (WorkoutExerciseDoesNotExist e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Object> allWorkoutsAndExercise(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        ApplicationUser user = userService.loadUserByUsername(username);
        try {
            List<WorkoutExercise> data =  workoutExerciseService.findAllWithExerciseAndWorkoutByUserId(user.getUserId());
            return new ResponseEntity<>(data, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{workoutExerciseID}")
    public ResponseEntity<Object> getWorkoutAndExerciseById(@PathVariable int workoutExerciseID) {
        try{
            WorkoutExercise data = workoutExerciseService.getAllWorkoutDataById(workoutExerciseID);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }catch (WorkoutExerciseDoesNotExist e){
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        }


}
