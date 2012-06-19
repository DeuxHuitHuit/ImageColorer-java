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
import ouput.beelucid.*;

import java.lang.reflect.Method; 

/**
 * <code>ObjectBridge</code> is a BeeLucid 'bridge class' which provides method stubs for .Net services which the underlying Java type <code>Object</code> does not support.
 * The <code>ObjectBridge</code> class also supports the services of function returns whose type is unknown.
 */
public class ObjectBridge {
    private Object objectVar = null; 
    /**
     * @return an instance of ObjectBridge wrapping an object of the underlying Java type Object
     */
    public ObjectBridge(Object  p0) {
        objectVar = p0; 
    }
    /**
     * @return the value of the underlying Object Java variable
     */
    public Object ObjectValue() {
        return objectVar; 
    }
    /**
     * Unimplemented setter.
     */
    public void set_Name(String  p0) {
        throw new RuntimeException("Unimplemented method");
    }
    /**
     * Look for a Name getter and invoke if there is one.
     */
    public String get_Name() {
        Method[] methods = objectVar.getClass().getMethods();
		for (Method m : methods) {
			if ((m.getName().equalsIgnoreCase("getName")
					|| m.getName().equalsIgnoreCase("name")
					|| m.getName().equalsIgnoreCase("get_name"))
					&& m.getParameterTypes().length == 0
					&& m.getReturnType() == String.class) {
				try {
					return (String) m.invoke(objectVar, ((Object) null));
				} catch (Exception e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		}
		return "";
    }
    /**
     * @return the underlying value as a String.
     */
    public String toString() {
        return objectVar.toString();
    }
    /**
     * @return the underlying value as a String, formatted according to the format parameter.
     */
    public String toString(String  p0) {
        return ""; // target dependent 
    }
    /**
     * * A catch-all for partially undefined Windows Controls.
     */
    public Object AddRange(Object []  p0) {
        try {
			throw new Exception("unimplemented method");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		 // return default value for return type
		return null; 
    }
    /**
     * Return true if the references refer to the same object, false otherwise.
     */
    public boolean ReferenceEquals(Object  p0, Object  p1) {
        return (p0 == p1);
    }
    /**
     * BeeLucid generated stub
     */
    public boolean Exists() {
		try {
			throw new Exception("unimplemented method");
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		}
		 // return default value for return type
		return false; 
	 }
}
