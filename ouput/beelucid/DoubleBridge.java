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
 * <code>DoubleBridge</code> is a BeeLucid 'bridge class' which provides method stubs for .Net services which the underlying Java type <code>Double</code> does not support.
 */
public class DoubleBridge {
    private double doubleVar;

    /**
     * @return the value of the underlying double Java variable.
     */
    public double doubleValue() {
        return doubleVar;
    }
    /**
     * @return the Class object of the underlying Java type .
     */
    public static Class GetType() {
        return double.class;

    }
    /**
     * @return an Instance of DoubleBridge wrapping an object of the underlying Java type double.
     */
    public DoubleBridge(Object  p0) {
        doubleVar = DoubleBridge.fromObject(p0);
    }
    /**
     * @return an Instance of DoubleBridge wrapping an object of the underlying Java type double.
     */
    public DoubleBridge(DoubleBridge  p0) {
        doubleVar = p0.doubleValue();
    }
    /**
     * @return an Instance of DoubleBridge wrapping an object of the underlying Java type double.
     */
    public DoubleBridge(double  p0) {
        doubleVar = p0;
    }
    /**
     * @return an Instance of DoubleBridge wrapping an object of the underlying Java type double.
     */
    public DoubleBridge() {
        doubleVar = 0;
    }
    public static double fromObject(Object  p0) {
        String valStr = p0.toString().replaceAll("[^a-zA-Z0-9+-.]", "");
		return new java.math.BigDecimal(valStr).doubleValue();
		
    }
    /**
     * @return the underlying value as a String.
     */
    public String toString() {
        return new Double (doubleVar).toString();
    }
    /**
     * @return the underlying value as a String, formatted according to the format parameter.
     */
    public String toString(String  p0) {
        return ""; // target dependent 
    }
}
