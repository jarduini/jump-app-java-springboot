package com.acidonper.myapp.dtos;

import javax.validation.constraints.NotEmpty;
import java.util.Arrays;

public class JumpDto {
    @NotEmpty
    public String message;
    @NotEmpty
    public String last_path;
    @NotEmpty
    public String jump_path;
    @NotEmpty
    public String[] jumps;

    public JumpDto() {
        super();
    }

    public JumpDto(String message, String last_path, String jump_path, String[] jumps) {
        this.message = message;
        this.last_path = last_path;
        this.jump_path = jump_path;
        this.jumps = jumps;
    }

    public String toStringCustom() {
        return String.format(
                "Jump[message='%s', last_path='%s', jump_path='%s', jumps='%s']", message, last_path, jump_path, Arrays.toString(jumps));
    }

}


