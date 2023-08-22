package services.liftNotes.Workouts;

import org.springframework.stereotype.Service;
import services.liftNotes.Utils.GetDate;
import services.liftNotes.Utils.RandomIdGenerator;
import services.liftNotes.Workouts.models.Workout;
import services.liftNotes.Workouts.models.WorkoutList;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class WorkoutService {
        public static String date = GetDate.currentDate();
        public static List<WorkoutList> workouts = new ArrayList<>();
        public static List<Workout> dummyDataChest = new ArrayList<>();
        public static List<Workout> dummyDataLegs = new ArrayList<>();


    static {

        dummyDataChest.add(new Workout("1", "Chest", "Fly Machine", 5, 115, 5, "Go lighter", date ));
        dummyDataLegs.add(new Workout("2", "Legs","Leg Press", 5, 115, 5, "Go lighter", date));
        workouts.add(new WorkoutList("Chest", dummyDataChest));
        workouts.add(new WorkoutList("Legs", dummyDataLegs));

    }
    public List<WorkoutList> getWorkouts(){
        return workouts;
    };
    public void addWorkout(Workout workout){
        workout.setId(RandomIdGenerator.generateRandomId());
        String genre = workout.getGenre();
            for (WorkoutList workoutList : workouts) {
                if (workoutList.getGenre().equals(genre)) {
                    workoutList.addWorkout(workout);
                break;
            }
        }
    }

    public void removeWorkoutById(String id) {
        workouts.forEach(workoutList -> {
            List<Workout> updatedWorkouts = workoutList.getWorkouts()
                    .stream()
                    .filter(workout -> !workout.getId().equals(id))
                    .collect(Collectors.toList());

            workoutList.setWorkouts(updatedWorkouts);
        });
    }

    public Optional<Workout> updateWorkoutById(String id, Workout updatedWorkoutData) {
    System.out.println("UPDATING WORKOUT");
    System.out.println(updatedWorkoutData);
        for (WorkoutList workoutList : workouts) {
            for (Workout workout : workoutList.getWorkouts()) {
                if (workout.getId().equals(id)) {
                    // Update the workout data with the new values
                    workout.setDate(GetDate.currentDate());
                    workout.setName(updatedWorkoutData.getName());
                    workout.setReps(updatedWorkoutData.getReps());
                    workout.setWeight(updatedWorkoutData.getWeight());
                    workout.setSets(updatedWorkoutData.getSets());
                    workout.setNotes(updatedWorkoutData.getNotes());
                    workout.setDate(updatedWorkoutData.getDate());

                    return Optional.of(workout);
                }
            }
        }
        return Optional.empty(); // Workout not found
    }

    public Optional<Workout> findWorkoutById(String id) {
        return workouts.stream()
                .flatMap(workoutList -> workoutList.getWorkouts().stream())
                .filter(workout -> workout.getId().equals(id))
                .findFirst();
    }
}
