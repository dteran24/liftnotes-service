package services.liftNotes.Workouts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import services.liftNotes.Workouts.models.Workout;
import services.liftNotes.Workouts.models.WorkoutList;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("workouts")
public class WorkoutController {
private WorkoutService workoutService;


@Autowired
public WorkoutController(WorkoutService workoutService){
    this.workoutService = workoutService;
}
@ResponseStatus(HttpStatus.OK)
@GetMapping("")
public List<WorkoutList> showAllWorkouts(){
    List<WorkoutList> list = workoutService.getWorkouts();
    return list;
}
@ResponseStatus(HttpStatus.CREATED)
@PostMapping("/add")
public void addWorkout(@RequestBody Workout workout){
    workoutService.addWorkout(workout);

}
@ResponseStatus(HttpStatus.ACCEPTED)
@DeleteMapping("/{id}")
public void deleteWorkout(@PathVariable String id){
    workoutService.removeWorkoutById(id);
}
@ResponseStatus(HttpStatus.ACCEPTED)
@PatchMapping("/{id}")
public void partialUpdateWorkout(@PathVariable String id, @RequestBody Workout workout) {
        workoutService.updateWorkoutById(id, workout);
}
//@GetMapping("/{id}")
//public Optional<Workout> findWorkout(@PathVariable String id) {
//        return workoutService.findWorkoutById(id);
//    }
}



