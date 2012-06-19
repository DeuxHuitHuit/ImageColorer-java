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

/**
 * Translated Color type inherits Java java.awt.Color type.
 */
public class Color extends java.awt.Color {
    /**
     * Construct a Color.
     */
    public Color() {
        super(0,0,0);
    }
    /**
     * Construct a Color.
     */
    public Color(int  rgb) {
        super(rgb);
    }
    /**
     * Yo, light Yell-ow.
     */
    public static Color LightYellow() {
        java.awt.Color c = new java.awt.Color(0xff,0xff,0xe0);
		return new Color(c.getRGB());
    }
    /**
     * Hark the Dark Red.
     */
    public static Color DarkRed() {
        return new Color(Color.red.darker().getRGB());
    }
    /**
     * Hello Yellow.
     */
    public static Color Yellow() {
        java.awt.Color c =  java.awt.Color.yellow;
		return  new Color(c.getRGB());
    }
    /**
     * BeeLucid generated stub
     */
    public static Color FromArgb(int  p0, int  p1, int  p2, int  p3) {
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
     * @return Color from red, green, blue.
     */
    public static Color FromArgb(int  r, int  g, int  b) {
        java.awt.Color c = new java.awt.Color(r & 0xff,g & 0xff,b & 0xff);
		return new Color(c.getRGB());
    }
    /**
     * @return Yellow Green.
     */
    public static Color YellowGreen() {
        java.awt.Color c = new java.awt.Color(0xad,0xff,0x2f);
		return new Color(c.getRGB());
    }
}
