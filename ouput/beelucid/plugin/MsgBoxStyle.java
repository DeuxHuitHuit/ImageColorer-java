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
 * MsgBoxStyle, an enum for enum for MsgBox styles.
 */
public class MsgBoxStyle {
    public static final int OKOnly		= 0;
	public static final int OKCancel		= 1;
	public static final int AbortRetryIgnore		= 2;
	public static final int YesNoCancel		= 3;
	public static final int YesNo		= 4;
	public static final int RetryCancel		= 5;
	public static final int Critical		= 16;
	public static final int Question		= 32;
	public static final int Exclamation		= 48;
	public static final int Information		= 64;
	
    /**
     * get value OKOnly.
     */
    public static int OKOnly() {
        return OKOnly;
    }
    /**
     * get value OKCancel.
     */
    public static int OKCancel() {
        return OKCancel;
    }
    /**
     * get value AbortRetryIgnore.
     */
    public static int AbortRetryIgnore() {
        return AbortRetryIgnore;
    }
    /**
     * get value YesNoCancel.
     */
    public static int YesNoCancel() {
        return YesNoCancel;
    }
    /**
     * get value YesNo.
     */
    public static int YesNo() {
        return YesNo;
    }
    /**
     * get value RetryCancel.
     */
    public static int RetryCancel() {
        return RetryCancel;
    }
    /**
     * get value Critical.
     */
    public static int Critical() {
        return Critical;
    }
    /**
     * get value Question.
     */
    public static int Question() {
        return Question;
    }
    /**
     * get value Exclamation.
     */
    public static int Exclamation() {
        return Exclamation;
    }
    /**
     * get value Information.
     */
    public static int Information() {
        return Information;
    }
}
