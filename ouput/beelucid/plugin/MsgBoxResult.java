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
 * MsgBoxResult, an enum for enum for MsgBox results.
 */
public class MsgBoxResult {
    public static final int OK		= 1;
	public static final int Cancel		= 2;
	public static final int Abort		= 3;
	public static final int Retry		= 3;
	public static final int Ignore		= 2;
	public static final int Yes		= 6;
	public static final int No		= 7;
	
    /**
     * get value OK.
     */
    public static int OK() {
        return OK;
    }
    /**
     * get value Cancel.
     */
    public static int Cancel() {
        return Cancel;
    }
    /**
     * get value Abort.
     */
    public static int Abort() {
        return Abort;
    }
    /**
     * get value Retry.
     */
    public static int Retry() {
        return Retry;
    }
    /**
     * get value Ignore.
     */
    public static int Ignore() {
        return Ignore;
    }
    /**
     * get value Yes.
     */
    public static int Yes() {
        return Yes;
    }
    /**
     * get value No.
     */
    public static int No() {
        return No;
    }
}
