package services.liftNotes.Workouts;

import org.springframework.stereotype.Service;
import services.liftNotes.Utils.GetDate;
import services.liftNotes.Utils.RandomIdGenerator;
import services.liftNotes.Workouts.models.Workout;
import services.liftNotes.Workouts.models.WorkoutHistory;
import services.liftNotes.Workouts.models.WorkoutList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkoutService {
        public static List<WorkoutList> workouts = new ArrayList<>();
        public static List<Workout> dummyDataChest = new ArrayList<>();
        public static List<Workout> dummyDataLegs = new ArrayList<>();
        public static List<Workout> dummyDataArms = new ArrayList<>();
        public static List<Workout> dummyDataBack = new ArrayList<>();
        public static List<Workout> dummyDataShoulders = new ArrayList<>();





    static {
        workouts.add(new WorkoutList("Chest", dummyDataChest));
        workouts.add(new WorkoutList("Shoulders", dummyDataShoulders));
        workouts.add(new WorkoutList("Legs", dummyDataLegs));
        workouts.add(new WorkoutList("Arms", dummyDataArms));
        workouts.add(new WorkoutList("Back", dummyDataBack));

    }
    public List<WorkoutList> getWorkouts(){
        return workouts;
    };
    public void addWorkout(Workout workout){
        workout.setHistory(new ArrayList<WorkoutHistory>());
        workout.setId(RandomIdGenerator.generateRandomId());
        workout.setDate(GetDate.currentDate());
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
        for (WorkoutList workoutList : workouts) {
            for (Workout workout : workoutList.getWorkouts()) {
                if (workout.getId().equals(id)) {
                    WorkoutHistory workoutHistory = new WorkoutHistory(workout);

                    workout.getHistory().add(workoutHistory);
                    // Update the workout data with the new values
                    workout.setName(updatedWorkoutData.getName());
                    workout.setReps(updatedWorkoutData.getReps());
                    workout.setWeight(updatedWorkoutData.getWeight());
                    workout.setSets(updatedWorkoutData.getSets());
                    workout.setNotes(updatedWorkoutData.getNotes());
                    workout.setDate(GetDate.currentDate());

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
