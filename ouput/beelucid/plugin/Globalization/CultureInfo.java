/*
 * Copyright (C) 2008 Beelucid Software, LLC.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which is generated into the LICENSE.txt file.
 *
 * Created on June 20, 2008 by Megan Adams
 */
package ouput.beelucid.plugin.Globalization; 
import ouput.beelucid.*;

import ouput.beelucid.plugin.Globalization.*; 

public class CultureInfo {
    private static final long serialVersionUID = 1L;
    /**
     * Return Current Culture.
     */
    public static CultureInfo CurrentCulture() {
        return new CultureInfo();
    }
    /**
     * BeeLucid generated stub.
     */
    public String TwoLetterISOLanguageName() {
        try {
			throw new Exception("unimplemented method");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		// return default value for return type
		return ""; 
    }
    /**
     * BeeLucid generated stub
     */
    public static Object InvariantCulture() {
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
