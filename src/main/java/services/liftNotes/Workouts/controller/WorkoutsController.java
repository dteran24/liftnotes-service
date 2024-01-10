package services.liftNotes.Workouts.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.liftNotes.Utils.GetDate;
import services.liftNotes.Workouts.models.Workout;
import services.liftNotes.Workouts.service.WorkoutsService;

import java.util.Date;


@CrossOrigin
@RestController
@RequestMapping("/workout")
public class WorkoutsController {
    @Autowired
    private WorkoutsService workoutService;

    @PostMapping("/add")
    public String addWorkout(@RequestBody Workout workout){

        workout.setDate(GetDate.currentDate());

        workoutService.saveWorkout(workout);
        return "Workout Added!";
    }




}



