package services.liftNotes.Workouts.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import services.liftNotes.Utils.GetDate;
import services.liftNotes.Workouts.models.Workout;
import services.liftNotes.Workouts.service.WorkoutsService;
import services.liftNotes.config.models.ApplicationUser;
import services.liftNotes.config.service.UserService;


@CrossOrigin
@RestController
@RequestMapping("/workout")
public class WorkoutsController {
    @Autowired
    private WorkoutsService workoutService;
    @Autowired
    private UserService userService;

//    @PostMapping("/add")
//    public String addWorkout(@AuthenticationPrincipal ApplicationUser authenticatedUser, @RequestBody Workout workout) {
//        // Check if the user with the specified ID exists
//        ApplicationUser user = userService.loadUserByUsername(authenticatedUser.getUsername());
//
//        if (user != null) {
//            workout.setUser(user);
//            workout.setDate(GetDate.currentDate());
//            workoutService.saveWorkout(workout);
//            return "Workout Added!";
//        } else {
//            return "User not found for ID: " + authenticatedUser.getId();
//        }
//    }

}



