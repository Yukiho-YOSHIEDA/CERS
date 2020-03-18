package dev.yukiho.cers.enums;

import dev.yukiho.cers.db.model.Event;
import dev.yukiho.cers.exception.BadRequestException;
import dev.yukiho.cers.exception.ConflictException;
import dev.yukiho.cers.exception.UnexpectedException;

import java.util.Arrays;
import java.util.Optional;

public enum ModeEnum {
    ENTER(1, "enter") {
        @Override
        public void ensureLastEvent(Optional<Event> lastEvent) {
            lastEvent.ifPresent(event -> {
                var eventMode = ModeEnum.getModeById(event.getMode());
                if (eventMode.equals(ModeEnum.ENTER)) {
                    throw new ConflictException("id : " + event.getStudentId() + " already entered");
                }
            });
        }
    },
    LEAVE(2, "leave") {
        @Override
        public void ensureLastEvent(Optional<Event> lastEvent) {
            lastEvent.ifPresentOrElse(event -> {
                        var eventMode = ModeEnum.getModeById(event.getMode());
                        if (eventMode.equals(ModeEnum.LEAVE)) {
                            throw new ConflictException("id : " + event.getStudentId() + " already leaved");
                        }
                    },
                    () -> {
                        throw new BadRequestException("No record that entered room");
                    });
        }
    };

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

    public abstract void ensureLastEvent(Optional<Event> lastEvent);
}
