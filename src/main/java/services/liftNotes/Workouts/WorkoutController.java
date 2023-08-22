package services.liftNotes.Workouts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.liftNotes.Workouts.models.Workout;
import services.liftNotes.Workouts.models.WorkoutList;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("workouts")
public class WorkoutController {
private WorkoutService workoutService;


@Autowired
public WorkoutController(WorkoutService workoutService){
    this.workoutService = workoutService;
}
@GetMapping("")
public List<WorkoutList> showAllWorkouts(){
    List<WorkoutList> list = workoutService.getWorkouts();
    return list;
}

@PostMapping("/add")
public ResponseEntity<String> addWorkout(@RequestBody Workout workout){
    workoutService.addWorkout(workout);
    return ResponseEntity.ok("Workout Added!");
}
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteWorkout(@PathVariable String id){
    workoutService.removeWorkoutById(id);
    return ResponseEntity.ok("Workout Removed!");
}
@PatchMapping("/{id}")
public ResponseEntity<String> partialUpdateWorkout(@PathVariable String id, @RequestBody Workout workout) {
        workoutService.updateWorkoutById(id, workout);
        return ResponseEntity.ok("Workout updated successfully");
    }
    @GetMapping("/{id}")
    public Optional<Workout> findWorkout(@PathVariable String id) {
        return workoutService.findWorkoutById(id);
    }
}
