/*
 * Copyright (C) 2008 Beelucid Software, LLC.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which is generated into the LICENSE.txt file.
 *
 * Created on June 20, 2008 by Megan Adams
 */
package ouput.beelucid.plugin.IO.Stream; 
import ouput.beelucid.*;

import ouput.beelucid.plugin.IO.Stream.*; 
import java.io.InputStreamReader; 
import java.io.ByteArrayInputStream; 
import java.io.PushbackInputStream; 

/**
 * Translated class InputStream inherits from Java InputStream.
 */
public class InputStream extends java.io.InputStream {
    private boolean initCalled = false;
	private PushbackInputStream in;
	private static final int BOM_SIZE = 4;
	String encoding = new InputStreamReader(new ByteArrayInputStream(new byte[0])).getEncoding(); // default
	boolean isInited = true;
    /**
     * No encoding check or BOM read.
     */
    public InputStream(java.io.InputStream  p0) {
        in = new PushbackInputStream(p0);
    }
    /**
     * Used for text/xml files, to force encoding check & BOM read.
     */
    public InputStream(java.io.InputStream  p0, boolean  p1) {
        in = new PushbackInputStream(p0, 4);
		isInited = p1; // false to force check
    }
    public java.io.InputStream getInputStream() {
        return in;
		
    }
    /**
     * Read-ahead four bytes and check for BOM marks. Extra bytes are unread back to the stream, only BOM bytes are skipped.
     */
    public void init() {
        if (isInited) return;
		byte bom[] = new byte[BOM_SIZE];
		int n=0, unread;
		try {
			n = in.read(bom, 0, bom.length);
		}
		catch  (java.io.IOException e){
			e.printStackTrace();
		}
		unread = n;
		// Java InputStreamReader skips all BOM's except UTF-8 BOM
		if ( (bom[0] == (byte)0x00) && (bom[1] == (byte)0x00) &&
				(bom[2] == (byte)0xFE) && (bom[3] == (byte)0xFF) ) {
			encoding = "UTF-32BE";
			//unread = n - 4;
		} else if ( (bom[0] == (byte)0xFF) && (bom[1] == (byte)0xFE) &&
				(bom[2] == (byte)0x00) && (bom[3] == (byte)0x00) ) {
			encoding = "UTF-32LE";
			//unread = n - 4;
		} else if (  (bom[0] == (byte)0xEF) && (bom[1] == (byte)0xBB) &&
				(bom[2] == (byte)0xBF) ) {
			encoding = "UTF-8";
			unread = n - 3;
		} else if ( (bom[0] == (byte)0xFE) && (bom[1] == (byte)0xFF) ) {
			encoding = "UTF-16BE";
			//unread = n - 2;
		} else if ( (bom[0] == (byte)0xFF) && (bom[1] == (byte)0xFE) ) {
			encoding = "UTF-16LE";
			//unread = n - 2;
		}
		
		try {
			if (unread > 0) in.unread(bom, (n - unread), unread);
		}
		catch  (java.io.IOException e){
			e.printStackTrace();
		}
		isInited = true;
		initCalled = true;
		
    }
    public int read() {
        if (!isInited) init();
		try {
			return in.read();
		}
		catch  (java.io.IOException e){
			e.printStackTrace();
		}
		return 0;
    }
    public void close() {
        if (initCalled) isInited = false;
		try {
			in.close();
		}
		catch  (java.io.IOException e){
			e.printStackTrace();
		}
	
    }
    public String getEncoding() {
        if (!isInited) this.read();
		return encoding;
    }
}
