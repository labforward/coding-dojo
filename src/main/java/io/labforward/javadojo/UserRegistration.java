package io.labforward.javadojo;

public class UserRegistration {

    private UserDto userDto;

    public UserRegistration(UserDto userDto) {
        this.userDto = userDto;
    }

    public User process() throws Exception {
        validate();
        return new User(userDto.getName(), userDto.getEmail(), userDto.getPassword());
    }

    private void validate() throws Exception {
        if (userDto.getName() == null) {
            throw new Exception("Name is missing");
        } else if (userDto.getEmail() == null) {
            throw new Exception("Email is missing");
        } else if (userDto.getPassword() == null) {
            throw new Exception("Password is missing");
        } else if (userDto.getPassword().length() < 6) {
            throw new Exception("Password is too short");
        }
    }
}
