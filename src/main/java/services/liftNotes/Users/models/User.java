package services.liftNotes.Users.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private Integer age;
    private Integer weight;
    private String height;
    private String imageUrl;
}
