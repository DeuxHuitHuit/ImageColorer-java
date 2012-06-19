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
import java.lang.reflect.Method;
/**
 * <code>EventHandlerBridge</code> is a BeeLucid synthesized base class to support VB event handling.
 * It contains a handler / eventObject pair, and implements hashcode() and equals().
 */
public class EventHandlerBridge {
    protected Method handler = null;
    protected Object eventObject = null;
    public EventHandlerBridge(Object obj, Method m) {
        handler = m;
        eventObject = obj;
    }
    public EventHandlerBridge() {}
    public int hashCode() {
        int hashCode = 1;
        hashCode = 31*hashCode + (handler==null ? 0 : handler.hashCode());
        hashCode = 31*hashCode + (eventObject==null ? 0 : eventObject.hashCode());
        return hashCode;
    }
    public boolean equals(Object o) {
        if (o==this) return true;
        if (!(o instanceof EventHandlerBridge)) return false;
        EventHandlerBridge that = (EventHandlerBridge) o;
        return (that.handler.equals(this.handler) && that.eventObject.equals(this.eventObject) );
    }
}
