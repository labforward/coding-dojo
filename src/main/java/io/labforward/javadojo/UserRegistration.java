package io.labforward.javadojo;

public class UserRegistration {

    public Boolean register(User user){
        if(user.getUsername() == null ||
           user.getEmail() == null){
            return false;
        } else{
            return true;
        }
    }
}
