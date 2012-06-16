/*
 * Copyright (C) 2008 Beelucid Software, LLC.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which is generated into the LICENSE.txt file.
 *
 * Created on June 20, 2008 by Megan Adams
 */
package ouput.beelucid.plugin; 
import ouput.beelucid.*;

import ouput.beelucid.plugin.*; 

/**
 * Translated EXCEPTION class inherits from java.lang.RuntimeException (throw / catch not required).
 */
public class EXCEPTION extends java.lang.RuntimeException {
    private static final long serialVersionUID = 1L;
    /**
     * Construct a EXCEPTION.
     */
    public EXCEPTION(String  p0) {
        super(p0);
    }
    /**
     * Construct a EXCEPTION.
     */
    public EXCEPTION() {
        super("VB.Net translated exception");
    }
    /**
     * get the Exception message.
     */
    public String Message() {
        return super.getMessage();
    }
    /**
     * get the Exception message.
     */
    public String toString() {
        return super.getMessage();
    }
    /**
     * get the Exception stack trace as a String.
     */
    public String StackTrace() {
        StackTraceElement[] st = this.getStackTrace();
		String rtn = this.getMessage() + "\r\n";
		for (int i=0; i<st.length; i++) {
		rtn += "  " + st[i] + "\r\n";
		}
		return rtn;
    }
}
