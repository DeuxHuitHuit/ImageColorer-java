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

/**
 * <code>StringBridge</code> is a BeeLucid 'bridge class' which provides method stubs for .Net services which the underlying Java type <code>String</code> does not support.
 */
public class StringBridge {
    private String stringVar = null; 
    /**
     * @return an instance of StringBridge wrapping an object of the underlying Java type String
     */
    public StringBridge(StringBridge  p4) {
        stringVar = p4.stringVar; 
    }
    public StringBridge(String  p0) {
        stringVar = new String(p0);
    }
    public StringBridge(char []  carr, int  start, int  len) {
        stringVar = new String(carr, start, len);
    }
    public StringBridge(Object  p0) {
    }
    /**
     * @return the value of the underlying String Java variable
     */
    public String StringValue() {
        return stringVar; 
    }
    /**
     * Return an empty String.
     */
    public static String Empty() {
        return "";
    }
    /**
     * BeeLucid generated stub
     */
    public String Remove(int  p0, int  p1) {
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
     * BeeLucid generated stub
     */
    public static String Format(String  p0, String  p1, int  p2, int  p3, int  p4, String  p5) {
		try {
			throw new Exception("unimplemented method");
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		}
		 // return default value for return type
		return null; 
	 }
}
