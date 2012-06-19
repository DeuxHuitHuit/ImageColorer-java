/*
 * Copyright (C) 2008 Beelucid Software, LLC.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which is generated into the LICENSE.txt file.
 *
 * Created on June 20, 2008 by Megan Adams
 */
package ouput.beelucid.plugin.VisualBasic; 
import ouput.beelucid.*;

import ouput.beelucid.plugin.VisualBasic.*; 

/**
 * CompareMethod values  indicate how to compare strings (text or binary compare).
 */
public class CompareMethod {
    public static final int Binary		= 0;
	public static final int Text		= 1;
	
    /**
     * get value Binary.
     */
    public static int Binary() {
        return Binary;
    }
    /**
     * get value Text.
     */
    public static int Text() {
        return Text;
    }
}
