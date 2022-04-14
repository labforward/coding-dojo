package io.labforward.javadojo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserDto {

    private final String name;
    private final String email;
    private final String password;

}
