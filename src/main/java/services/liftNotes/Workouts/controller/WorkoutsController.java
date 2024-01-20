package services.liftNotes.Workouts.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    private final WorkoutsService workoutService;
    private final UserService userService;

    @Autowired
    public WorkoutsController(WorkoutsService workoutsService, UserService userService){
        super();
        this.workoutService = workoutsService;
        this.userService = userService;


    }

    @PostMapping("/add")
    public ResponseEntity<String> addWorkout(@RequestBody Workout workout) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        ApplicationUser user = userService.loadUserByUsername(username);

        if (user != null) {
            workout.setUser(user);
            workout.setDate(GetDate.currentDate());
            workoutService.saveWorkout(workout);
            return new ResponseEntity<>("Workout Added!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("User not found for ID: " + username, HttpStatus.NOT_FOUND);
        }
    }

}



