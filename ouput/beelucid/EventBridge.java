/*
 * Copyright (C) 2008 Beelucid Software, LLC.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which is generated into the LICENSE.txt file.
 *
 * Created on June 20, 2008 by Megan Adams
 */
package ouput.beelucid; 
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
/**
 * <code>EventBridge</code> is a BeeLucid synthesized class to support VB events. It uses 
 * a HashSet to support adding and removing handlers for events.
 */
public class EventBridge {
    @SuppressWarnings("unchecked")
    private HashSet<EventHandlerBridge> event = new HashSet<EventHandlerBridge>();
    public int hashCode() {
        int hashCode = 1;
        hashCode = 31*hashCode + (event==null ? 0 : event.hashCode());
        return hashCode;
    }
    public boolean equals(Object o) {
        if (o==this) return true;
        if (!(o instanceof EventBridge)) return false;
        EventBridge thatEvent = (EventBridge) o;
        return (thatEvent.event.equals(this.event));
    }
    // add, clear, and remove routines for Events  
    public void addHandlers(HashSet<EventHandlerBridge> delegates) {
        if (event == null) event = new HashSet<EventHandlerBridge>();
        event.addAll(delegates); 
    }
    public void addHandler(EventHandlerBridge delegate) {
        if (event == null) event = new HashSet<EventHandlerBridge>();
        event.add(delegate); 
    }
    public HashSet<EventHandlerBridge> getHandlers() {
        if (event == null) event = new HashSet<EventHandlerBridge>();
        return event;
    }
    public EventHandlerBridge getHandler() {
        if (event == null) {
			 event = new HashSet<EventHandlerBridge>();
			 return null; 
		}
        Iterator <? extends EventHandlerBridge> it = event.iterator();
        if (it.hasNext()) return ((EventHandlerBridge) it.next());
        return null;
    }
    public HashSet <? extends EventHandlerBridge> clearHandler() {
        if (event == null) event = new HashSet<EventHandlerBridge>();
        HashSet <? extends EventHandlerBridge> rtn = (HashSet <? extends EventHandlerBridge>) event.clone();
        event.clear();
        return rtn;
    }
    public HashSet <? extends EventHandlerBridge> cloneHandler() {
        if (event == null) event = new HashSet<EventHandlerBridge>();
        HashSet <? extends EventHandlerBridge> rtn = (HashSet <? extends EventHandlerBridge>) event.clone();
        return rtn;
    }
    public void removeHandler(EventHandlerBridge delegate) {
        if (event == null) event = new HashSet<EventHandlerBridge>();
        event.remove(delegate); 
    }
}
