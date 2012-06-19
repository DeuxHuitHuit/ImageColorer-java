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

import ouput.beelucid.plugin.IO.Stream.Stream; 
import ouput.beelucid.plugin.Drawing.Color; 

public class Console {
    public static Stream Out() {
        return new Stream(System.out);
    }
    /**
     * WriteLine output to System.out.
     */
    public static void WriteLine(String  p0, int  p1, Object  p2, double  p3) {
        String[] strArr = new String[3];
        strArr[0] = "" + p1; 
        strArr[1] = (p2 != null ? p2.toString() : ""); 
        strArr[2] = "" + p3; 
        System.out.println(SystemBridge.Format(p0.toString(), strArr));
    }
    /**
     * WriteLine output to System.out.
     */
    public static void WriteLine(String  p0, Color  p1) {
        String[] strArr = new String[1];
        strArr[0] = (p1 != null ? p1.toString() : ""); 
        System.out.println(SystemBridge.Format(p0.toString(), strArr));
    }
    /**
     * WriteLine output to System.out.
     */
    public static void WriteLine(String  p0, int  p1) {
        String[] strArr = new String[1];
        strArr[0] = "" + p1; 
        System.out.println(SystemBridge.Format(p0.toString(), strArr));
    }
    /**
     * WriteLine output to System.out.
     */
    public static void WriteLine(String  p0, String  p1) {
        String[] strArr = new String[1];
        strArr[0] = p1; 
        System.out.println(SystemBridge.Format(p0.toString(), strArr));
    }
    /**
     * WriteLine output to System.out.
     */
    public static void WriteLine() {
        System.out.println(); 
    }
    /**
     * WriteLine output to System.out.
     */
    public static void WriteLine(String  p0) {
        System.out.println(p0); 
    }
    /**
     * Write output to System.out.
     */
    public static void Write(String  p0) {
        System.out.print(p0); 
    }
}
