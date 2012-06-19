package com.deuxhuithuit.ImageColorer.Core;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.IndexColorModel;
import java.awt.image.RGBImageFilter;
import java.awt.image.WritableRaster;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class GifImage {
	
	// http://stackoverflow.com/questions/5264706/how-to-replace-color-of-an-image
	// http://docs.oracle.com/javase/6/docs/api/java/awt/image/FilteredImageSource.html
	// http://docs.oracle.com/javase/6/docs/api/java/awt/image/RGBImageFilter.html
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
        	 if (rgb == _trans) {
        		 return rgb;
        	 }
        	 if (rgb == (_victimColor.getRGB() | 0xFF000000)) {
        		// found our victim, return the new color
        		 return _newColor.getRGB();
        	 }
        	 // return original color
        	 return rgb;
         }
     }
	
	public static void CreateGifImage(tangible.RefObject<BufferedImage> refImage, tangible.RefObject<BufferedImage> destImage) {
		// Copy the palette to assure colors follow
		//destImage.argvalue.Palette = refImage.argvalue.Palette;

		//now to copy the actual bitmap data
		//lock the source and destination bits
		//BitmapData src = ((Bitmap)refImage.argvalue).LockBits(new Rectangle(0, 0, refImage.argvalue.Width, refImage.argvalue.Height), ImageLockMode.ReadOnly, refImage.argvalue.PixelFormat);
		//BitmapData dst = ((Bitmap)destImage.argvalue).LockBits(new Rectangle(0, 0, destImage.argvalue.Width, destImage.argvalue.Height), ImageLockMode.WriteOnly, destImage.argvalue.PixelFormat);

		//steps through each pixel
		//int y = 0;
		//for (y = 0; y < refImage.argvalue.Height; y++) {
			//VB TO JAVA CONVERTER TODO TASK: There is no Java equivalent to VB's implicit 'once only' variable initialization within loops:
			//int x;
			//for (x = 0; x < refImage.argvalue.Width; x++) {
				//transferring the bytes
				//Marshal.WriteByte(dst.Scan0, dst.Stride * y + x, Marshal.ReadByte(src.Scan0, src.Stride * y + x));
			//}
		//}

		//all done, unlock the bitmaps
		//((Bitmap)refImage.argvalue).UnlockBits(src);
		//((Bitmap)destImage.argvalue).UnlockBits(dst);
		
		// "This method comes from the .NET version." +
		// "But since it's impossible to change the image's palette in java, there is not need for this pseudo clone method"
		throw new NotImplementedException();
	}

	public static BufferedImage CreateGifImage(tangible.RefObject<BufferedImage> refImage, IndexColorModel cm) {
		
		// http://stackoverflow.com/questions/3514158/how-do-you-clone-a-bufferedimage
		//ColorModel cm = refImage.argvalue.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = refImage.argvalue.copyData(null);
		//RefObject<BufferedImage> newImage = new tangible.RefObject<BufferedImage>( new BufferedImage(cm, raster, isAlphaPremultiplied, null) );

		//Create a new 8 bit per pixel image
		BufferedImage bi = new BufferedImage(cm, raster, isAlphaPremultiplied, null);
		
		//tangible.RefObject<BufferedImage> tempRef_bm = new tangible.RefObject<BufferedImage>(bi);
		//CreateGifImage(refImage, tempRef_bm);
		//bi = tempRef_bm.argvalue;

		return bi;
	}

	public static void ReplaceColorInPalette(tangible.RefObject<BufferedImage> refImage, IndexColorModel refPalette, Color victimColor, Color newColor) {
		//get it's palette
		//IndexColorModel ncp = refPalette;

		// Start with the refPalette
		/*IndexColorModel palette = refPalette;
		
		int size = palette.getMapSize();
		
		byte reds[] = new byte[size];
		byte greens[] = new byte[size];
		byte blues[] = new byte[size];
		byte alphas[] = new byte[size];
		
		palette.getReds(reds);
		palette.getGreens(greens);
		palette.getBlues(blues);
		
		for (int x = 0; x < size; x++) {
			//Color color = new Color(palette.getRed(x), palette.getGreen(x), palette.getBlue(x), palette.getAlpha(x));
			//int alpha = 255;
			// if we found our victim
			int r = reds[x] & 0xFF;
			int g = greens[x] & 0xFF;
			int b = blues[x] & 0xFF;
			
			if (r == victimColor.getRed() && b == victimColor.getBlue() && g == victimColor.getGreen()) {
				// replace it in the palette
				//ncp. = Drawing.Color.FromArgb(victimColor.A, newColor.R, newColor.G, newColor.B);
				reds[x] = (byte) newColor.getRed();
				greens[x] = (byte) newColor.getGreen();
				blues[x] = (byte) newColor.getBlue();
				alphas[x] = (byte) newColor.getAlpha();
			//} else {
				//ncp.Entries(x) = Drawing.Color.FromArgb(color.A, color.R, color.G, color.B);
			}
		}
		//re-insert the palette
		//refImage.argvalue.Palette = ncp;
		
		// return the new palette
		IndexColorModel newPalette = new IndexColorModel(palette.getPixelSize(), size,  reds, greens, blues, alphas);
		
		return newPalette;*/
	}

	public static void ConverToGifImageWithNewColor(tangible.RefObject<BufferedImage> refImage, IndexColorModel refPalette, Color victimColor, Color newColor) {
		//IndexColorModel newPalette = ReplaceColorInPalette(refImage, refPalette, victimColor, newColor);
		BufferedImage original = refImage.argvalue;
		
		
		// Rewrite the bitmap data in a new image
		//BufferedImage gifImage = CreateGifImage(refImage, newPalette);
		int tp = ((IndexColorModel) refImage.argvalue.getColorModel()).getTransparentPixel();
		ChangeOneColorImageFilter colorFilter = new ChangeOneColorImageFilter(victimColor, newColor, refImage.argvalue.getColorModel().getRGB(tp));
		
		FilteredImageSource fis = new FilteredImageSource(refImage.argvalue.getSource(), colorFilter);
		
		Image img = Toolkit.getDefaultToolkit().createImage(fis);
		
		//fis.startProduction(refImage.argvalue);
		BufferedImage dest = new BufferedImage(
				original.getWidth(), original.getHeight(),
			    BufferedImage.TYPE_INT_ARGB );
			Graphics2D g2 = dest.createGraphics();
			//g2.setComposite(AlphaComposite.DstIn);
			g2.drawImage(img, 0, 0, null);
			g2.dispose();
		
		// replace ref param
		refImage.argvalue = dest;
	}

	public static void ReplaceTransparencyColor() {
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