package services.liftNotes.WorkoutExerciseHistory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.liftNotes.WorkoutExerciseHistory.models.WorkoutExerciseHistory;
import services.liftNotes.WorkoutExerciseHistory.service.WorkoutExerciseHistoryService;
import services.liftNotes.config.exceptions.AccountDoesNotExist;
import services.liftNotes.config.models.ApplicationUser;
import services.liftNotes.config.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/history")
public class WorkoutExerciseHistoryController {

    private final WorkoutExerciseHistoryService workoutExerciseHistoryService;
    private final UserService userService;
    @Autowired
    public WorkoutExerciseHistoryController(WorkoutExerciseHistoryService workoutExerciseHistoryService, UserService userService){
        this.workoutExerciseHistoryService = workoutExerciseHistoryService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getHistory(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        ApplicationUser user = userService.loadUserByUsername(username);
        try{
            List<WorkoutExerciseHistory> data = workoutExerciseHistoryService.getHistoryByUserId(user.getUserId());
            return new ResponseEntity<>(data, HttpStatus.OK);
        }catch (AccountDoesNotExist e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
