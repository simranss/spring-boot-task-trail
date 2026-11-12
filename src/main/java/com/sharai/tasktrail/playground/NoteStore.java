package com.sharai.tasktrail.playground;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

@Component
public class NoteStore {
    private final Map<Long, Note> notes = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong();

    public List<Note> findAll() {
        return notes.values().stream()
                .sorted(Comparator.comparing(Note::id))
                .toList();
    }

    public Optional<Note> findById(Long id) {
        return Optional.ofNullable(notes.get(id));
    }

    public Note create(NoteRequest req) {
        long id = sequence.incrementAndGet();
        Note note = new Note(id, req.title(), req.content());
        notes.put(id, note);

        return note;
    }

    public Optional<Note> update(Long id, NoteRequest req) {
        if (!notes.containsKey(id)) return Optional.empty();

        Note note = new Note(id, req.title(), req.content());
        notes.put(id, note);

        return Optional.of(note);
    }

    public boolean delete(Long id) {
        return notes.remove(id) != null;
    }
}
