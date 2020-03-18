package dev.yukiho.cers.service;

import dev.yukiho.cers.db.model.Event;
import dev.yukiho.cers.enums.ModeEnum;
import dev.yukiho.cers.exception.UnexpectedException;
import dev.yukiho.cers.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class EventService {

    private EventRepository eventRepository;

    public EventService(@Autowired EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(String id, String mode, Date acceptedAt) {
        var event = new Event();
        var modeEnum = ModeEnum.getModeByName(mode);

        var lastEvent = eventRepository.selectEventByStudentId(id).stream()
                .findFirst();

        modeEnum.ensureLastEvent(lastEvent);

        event.setStudentId(id);
        event.setMode(modeEnum.getId());
        event.setAcceptedAt(acceptedAt);

        var result = eventRepository.insertEvent(event);

        return eventRepository.selectEventById(result.getId())
                .orElseThrow(new UnexpectedException("Unexpected error"));
    }

}
