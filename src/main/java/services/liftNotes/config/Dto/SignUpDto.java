package services.liftNotes.config.Dto;

import lombok.Getter;
import lombok.Setter;
import services.liftNotes.Users.controller.models.User;

@Getter
@Setter
public class SignUpDto extends User {
    private String name;
    private String username;
    private String email;
    private String password;
    private Integer age;
    private Integer weight;
    private String height;

    public SignUpDto() {
    }

}