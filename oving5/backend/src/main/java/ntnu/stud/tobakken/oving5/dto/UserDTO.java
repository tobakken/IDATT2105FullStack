package ntnu.stud.tobakken.oving5.dto;

import ntnu.stud.tobakken.oving5.entity.User;

public class UserDTO {
    private String username;

    public UserDTO(User user) {
        this.username = user.getUsername();
    }

    public String getUsername() {
        return username;
    }
}
