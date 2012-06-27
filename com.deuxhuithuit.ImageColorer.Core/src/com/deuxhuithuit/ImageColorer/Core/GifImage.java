package com.deuxhuithuit.ImageColorer.Core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.IndexColorModel;
import java.awt.image.RGBImageFilter;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class GifImage {
	
	/**
	 * 
	 * @author DeuxHuitHuit
	 *
	 * This class reprensent a simple Image Filter.
	 * This is the actual code that permits the color swap in Java.
	 * 
	 * @see http://stackoverflow.com/questions/5264706/how-to-replace-color-of-an-image
 	 * @see http://docs.oracle.com/javase/6/docs/api/java/awt/image/FilteredImageSource.html
	 * @see http://docs.oracle.com/javase/6/docs/api/java/awt/image/RGBImageFilter.html
	 */
	protected static final class ChangeOneColorImageFilter extends RGBImageFilter {
		 private Color _victimColor;
		 private Color _newColor;
		 private int _trans;
		 
         public ChangeOneColorImageFilter (Color victimColor, Color newColor, int trans) {
             // The filter's operation does not depend on the
             // pixel's location, so IndexColorModels can be
             // filtered directly.
             canFilterIndexColorModel = true;
             
             _newColor = newColor;
             _victimColor = victimColor;
             _trans = trans;
         }

         public int filterRGB(int x, int y, int rgb) {
        	 // if this is the transparent color, return it now
        	 if (rgb == _trans) {
        		 return rgb;
        	 }
        	 
        	 // if we found our victim color, and this color is opaque
        	 if (rgb == (_victimColor.getRGB() | 0xFF000000)) {
        		// found our victim, return the new color
        		 return _newColor.getRGB();
        	 }
        	 
        	 // return original color
        	 return rgb;
         }
     }
	
	public static void CreateGifImage(tangible.RefObject<BufferedImage> refImage, tangible.RefObject<BufferedImage> destImage) {
		// "This method comes from the .NET version." +
		// "But since it's impossible to change the image's palette in java, there is not need for this pseudo clone method"
		// This was done this was in VB.NET to help memory management
		throw new NotImplementedException();
	}

	public static void CreateGifImage(tangible.RefObject<BufferedImage> refImage, FilteredImageSource fis, IndexColorModel cm) {
		// Create the actual image
		Image img = Toolkit.getDefaultToolkit().createImage(fis);
		
		// Create a new buffered (in-memory) image
		BufferedImage dest = new BufferedImage(refImage.argvalue.getWidth(), refImage.argvalue.getHeight(), BufferedImage.TYPE_INT_ARGB );
		// Get its graphic instance
		Graphics2D g2 = dest.createGraphics();
		
		// N.B. This next call should be here, but it fails on old Java version
		// g2.setComposite(AlphaComposite.DstIn);
		
		// Draw the new image into the buffered one
		g2.drawImage(img, 0, 0, null);
		
		// Dispose the graphics to free some memory
		g2.dispose();
		
		// Replace ref parameter
		// This pointer swap serves as the "ByRef" keyword in VB.NET
		refImage.argvalue = dest;
	}

	public static FilteredImageSource ReplaceColorInPalette(tangible.RefObject<BufferedImage> refImage, IndexColorModel refPalette, Color victimColor, Color newColor) {
		// Get the color use as transparency
		int tp = ((IndexColorModel) refImage.argvalue.getColorModel()).getTransparentPixel();
		
		// Create a new instance of our color filter
		ChangeOneColorImageFilter colorFilter = new ChangeOneColorImageFilter(victimColor, newColor, refImage.argvalue.getColorModel().getRGB(tp));
		
		// Create an image source for our consumer
		FilteredImageSource fis = new FilteredImageSource(refImage.argvalue.getSource(), colorFilter);
		
		// Return the new image source
		return fis;
	}

	public static void ConverToGifImageWithNewColor(tangible.RefObject<BufferedImage> refImage, IndexColorModel refPalette, Color victimColor, Color newColor) {
		// N.B. The refPalette object does not have any purpose in this version
		// It is passed to internal method just to keep the signature as-is
		
		// Get a new image source, with the color changed
		FilteredImageSource fis = ReplaceColorInPalette(refImage, refPalette, victimColor, newColor);
		
		// Write it to memory
		CreateGifImage(refImage, fis, refPalette);
	}

	public static void ReplaceTransparencyColor() {
		// N.B. This code was commented in the Original VB.NET version
		// We left it here just for the reader
		
		//copy all the entries from the old palette removing any transparency
		//Dim n As Integer = 0
		//Dim c As Color
		//For Each c In bm.Palette.Entries
		//    ncp.Entries(n) = Color.FromArgb(255, c)
		//    n += 1
		//Next c
		//Set the newly selected transparency
		//ncp.Entries(0) = Color.FromArgb(0, bm.Palette.Entries(0))
		//re-insert the palette
		//refImage.Palette = ncp
	}

	public static Color ParseColor(String s) {
		if (s != null && s.length() > 0) {
			int r = 0;
			int g = 0;
			int b = 0;
			String[] splitted = s.split("[,]");
			if (splitted.length != 3) {
				// try hexa, radix = 16
				if (s.length() == 6) { // A1A1A1
					r = Integer.parseInt(s.substring(0, 2), 16);
					g = Integer.parseInt(s.substring(2, 4), 16);
					b = Integer.parseInt(s.substring(4, 6), 16);
				} else if (s.length() == 3) {
					r = Integer.parseInt(s.substring(0, 1), 16);
					g = Integer.parseInt(s.substring(1, 2), 16);
					b = Integer.parseInt(s.substring(2, 3), 16);
				}
			} else {
				r = Integer.parseInt(splitted[0]);
				g = Integer.parseInt(splitted[1]);
				b = Integer.parseInt(splitted[2]);
			}
			return new Color(r, g, b, 255);
		}
		return null;
	}

}