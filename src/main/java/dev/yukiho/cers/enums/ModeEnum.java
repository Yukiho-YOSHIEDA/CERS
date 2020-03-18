package dev.yukiho.cers.enums;

import dev.yukiho.cers.exception.BadRequestException;
import dev.yukiho.cers.exception.UnexpectedException;

import java.util.Arrays;

public enum ModeEnum {
    ENTER(1, "enter"),
    LEAVE(2, "leave");

    private int id;
    private String name;

    ModeEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ModeEnum getModeByName(String name) {
        return Arrays.stream(values())
                .filter(modeEnum -> modeEnum.getName().equals(name))
                .findFirst()
                .orElseThrow(new BadRequestException("Invalid parameter : mode"));
    }

    public static ModeEnum getModeById(int id) {
        return Arrays.stream(values())
                .filter(modeEnum -> modeEnum.getId() == id)
                .findFirst()
                .orElseThrow(new UnexpectedException("Unexpected error"));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
