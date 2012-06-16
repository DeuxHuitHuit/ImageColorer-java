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

import java.io.InputStreamReader; 
import java.io.ByteArrayInputStream; 
import java.io.OutputStream; 
import ouput.beelucid.plugin.IO.Stream.InputStream; 
import ouput.beelucid.plugin.InvalidOperationException; 

/**
 * Translated class Stream wraps instances of Java InputStream, OutputStream.
 */
public class Stream {
    private boolean canRead = false, canWrite = false;
	private OutputStream out;
	private java.io.InputStream in;
	
    /**
     * Construct a Stream.
     */
    public Stream(java.io.InputStream  p0) {
        in = p0;
		canRead = true;
		canWrite = false;
    }
    /**
     * Construct a Stream.
     */
    public Stream(java.io.OutputStream  p0) {
        out = p0;
		canWrite = true;
		canRead = true;
    }
    public java.io.InputStream getInputStream() {
        return in;
		
    }
    public java.io.OutputStream getOutputStream() {
        return out;
		
    }
    /**
     * Current stream supports reading.
     */
    public boolean canRead() {
        return canRead;
		
    }
    /**
     * Current stream supports writing.
     */
    public boolean canWrite() {
        return canWrite;
		
    }
    /**
     * Used for text/xml files, this will force an encoding check & BOM read.
     */
    public void setupForBOM() {
        if (in == null) throw new InvalidOperationException("null Stream not allowed");
		in = new InputStream(in, false);
    }
    /**
     * Get the encoding.
     */
    public String getEncoding() {
        if (in instanceof InputStream) 
			return ((InputStream)in).getEncoding();
		return new InputStreamReader(new ByteArrayInputStream(new byte[0])).getEncoding();
    }
}
