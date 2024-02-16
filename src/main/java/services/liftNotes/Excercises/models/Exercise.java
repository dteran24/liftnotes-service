package services.liftNotes.Excercises.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private int id;
    private String genre;
    @Column(unique = true)
    private String name;
    private String description;
}
