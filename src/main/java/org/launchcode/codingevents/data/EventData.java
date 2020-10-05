package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chris Bay
 */
public class EventData {

    private static final Map<Integer, Event> events = new HashMap<>();
    // static variable ^ shared among all instances of this class
    public static Collection<Event> getAll() {
        return events.values();
    }

    public static Event getById(int id) {
        return events.get(id);
    }

    public static void add(Event event) {
        events.put(event.getId(), event);
    }

    public static void remove(int id) {
        events.remove(id);
    }

}


// didn't call instance of class using constructor w this.field
// so this class only exists to provide access to models