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

import ouput.beelucid.plugin.Globalization.NumberStyles; 

/**
 * <code>IntegerBridge</code> is a BeeLucid 'bridge class' which provides method stubs for .Net services which the underlying Java type <code>Integer</code> does not support.
 */
public class IntegerBridge {
    private int integerVar;

    /**
     * @return the value of the underlying int Java variable.
     */
    public int intValue() {
        return integerVar;
    }
    /**
     * @return the Class object of the underlying Java type .
     */
    public static Class GetType() {
        return int.class;

    }
    /**
     * @return an Instance of IntegerBridge wrapping an object of the underlying Java type int.
     */
    public IntegerBridge(Object  p0) {
        integerVar = IntegerBridge.fromObject(p0);
    }
    /**
     * @return an Instance of IntegerBridge wrapping an object of the underlying Java type int.
     */
    public IntegerBridge(IntegerBridge  p0) {
        integerVar = p0.intValue();
    }
    /**
     * @return an Instance of IntegerBridge wrapping an object of the underlying Java type int.
     */
    public IntegerBridge(int  p0) {
        integerVar = p0;
    }
    /**
     * @return an Instance of IntegerBridge wrapping an object of the underlying Java type int.
     */
    public IntegerBridge() {
        integerVar = 0;
    }
    public static int fromObject(Object  p0) {
        String valStr = p0.toString().replaceAll("[^a-zA-Z0-9+-.]", "");
		return new java.math.BigDecimal(valStr).intValue();
		
    }
    /**
     * @return the underlying value as a String.
     */
    public String toString() {
        return new Integer (integerVar).toString();
    }
    /**
     * @return the underlying value as a String, formatted according to the format parameter.
     */
    public String toString(String  p0) {
        return ""; // target dependent 
    }
    /**
     * BeeLucid generated stub
     */
    public static Object TryParse(String  p0, int  p1) {
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
    public static Object TryParse(String  p0, Object  p1, Object  p2, int  p3) {
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
