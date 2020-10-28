package com.acidonper.myapp.entities;

import javax.validation.constraints.NotEmpty;

public class Jump {
    @NotEmpty
    public String message;
    @NotEmpty
    public String last_path;
    @NotEmpty
    public String jump_path;

    public String[] jumps;

    public Jump(String message, String last_path, String jump_path, String[] jumps) {
        this.message = message;
        this.last_path = last_path;
        this.jump_path = jump_path;
        this.jumps = jumps;
    }

}


