/*
 * Copyright (C) 2008 Beelucid Software, LLC.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which is generated into the LICENSE.txt file.
 *
 * Created on June 20, 2008 by Megan Adams
 */
package ouput.beelucid.plugin.Drawing; 
import ouput.beelucid.*;

import ouput.beelucid.plugin.Drawing.*; 
import ouput.beelucid.plugin.Drawing.Imaging.ImageFormat; 

public class Image {
    protected java.awt.Image image = null;
	
    public Image(ouput.beelucid.plugin.Drawing.Bitmap  b) {
        javax.swing.ImageIcon ic = new javax.swing.ImageIcon(b.getFilename());
		image = ic.getImage(); 
    }
    /**
     * @param im.
     */
    public Image(java.awt.Image  im) {
        image = im;
    }
    public Image() {
    }
    /**
     * Get the underlying Java Image.
     */
    public java.awt.Image getImage() {
        return image;
    }
    /**
     * BeeLucid generated stub
     */
    public static Image FromFile(Object  p0) {
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
    public Object Dispose() {
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
    public Object Clone() {
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
    public Object Palette() {
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
    public Object Save(Object  p0, Object  p1) {
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
