package services.liftNotes.Workouts.controller;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import services.liftNotes.Users.controller.models.User;
import services.liftNotes.Users.service.UserService;
import services.liftNotes.Utils.GetDate;
import services.liftNotes.Workouts.models.Workout;
import services.liftNotes.Workouts.service.WorkoutsService;


@CrossOrigin
@RestController
@RequestMapping("/workout")
public class WorkoutsController {
    @Autowired
    private WorkoutsService workoutService;
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addWorkout(@AuthenticationPrincipal User authenticatedUser, @RequestBody Workout workout) {
        // Check if the user with the specified ID exists
        User user = userService.getUserByID(authenticatedUser.getId());

        if (user != null) {
            workout.setUser(user);
            workout.setDate(GetDate.currentDate());
            workoutService.saveWorkout(workout);
            return "Workout Added!";
        } else {
            return "User not found for ID: " + authenticatedUser.getId();
        }
    }

}



