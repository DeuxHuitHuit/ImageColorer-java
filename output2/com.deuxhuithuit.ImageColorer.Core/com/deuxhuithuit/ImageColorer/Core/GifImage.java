﻿package com.deuxhuithuit.ImageColorer.Core;

public class GifImage
{

	public static void CreateGifImage(tangible.RefObject<Image> refImage, tangible.RefObject<Image> destImage)
	{
		// Copy the palette to assure colors follow
		destImage.argvalue.Palette = refImage.argvalue.Palette;

		//now to copy the actual bitmap data
		//lock the source and destination bits
		BitmapData src = ((Bitmap)refImage.argvalue).LockBits(new Rectangle(0, 0, refImage.argvalue.Width, refImage.argvalue.Height), ImageLockMode.ReadOnly, refImage.argvalue.PixelFormat);
		BitmapData dst = ((Bitmap)destImage.argvalue).LockBits(new Rectangle(0, 0, destImage.argvalue.Width, destImage.argvalue.Height), ImageLockMode.WriteOnly, destImage.argvalue.PixelFormat);

		//steps through each pixel
		int y = 0;
		for (y = 0; y < refImage.argvalue.Height; y++)
		{
//VB TO JAVA CONVERTER TODO TASK: There is no Java equivalent to VB's implicit 'once only' variable initialization within loops:
			int x;
			for (x = 0; x < refImage.argvalue.Width; x++)
			{
				//transferring the bytes
				Marshal.WriteByte(dst.Scan0, dst.Stride * y + x, Marshal.ReadByte(src.Scan0, src.Stride * y + x));
			}
		}

		//all done, unlock the bitmaps
		((Bitmap)refImage.argvalue).UnlockBits(src);
		((Bitmap)destImage.argvalue).UnlockBits(dst);
	}

	public static Image CreateGifImage(tangible.RefObject<Image> refImage)
	{
		//Create a new 8 bit per pixel image
		Bitmap bm = new Bitmap(refImage.argvalue.Width, refImage.argvalue.Height, PixelFormat.Format8bppIndexed);

		tangible.RefObject<Image> tempRef_bm = new tangible.RefObject<Image>(bm);
		CreateGifImage(refImage, tempRef_bm);
		bm = tempRef_bm.argvalue;

		return bm;
	}

	public static void ReplaceColorInPalette(tangible.RefObject<Image> refImage, ColorPalette refPalette, Color victimColor, Color newColor)
	{
		//get it's palette
		ColorPalette ncp = refPalette;

		// Start with the refPalette
		Drawing.Imaging.ColorPalette palette = refPalette;
		for (int x = 0; x < palette.Entries.getLength(); x++)
		{
			Drawing.Color color = palette.Entries(x);
			int alpha = 255;
			// if we found our victim
			if (color.R == victimColor.R && color.B == victimColor.B && color.G == victimColor.G)
			{
				// replace it in the palette
				ncp.Entries(x) = Drawing.Color.FromArgb(victimColor.A, newColor.R, newColor.G, newColor.B);
			}
			else
			{
				ncp.Entries(x) = Drawing.Color.FromArgb(color.A, color.R, color.G, color.B);
			}
		}
		//re-insert the palette
		refImage.argvalue.Palette = ncp;
	}

	public static void ConverToGifImageWithNewColor(tangible.RefObject<Image> refImage, ColorPalette refPalette, Color victimColor, Color newColor)
	{
		ReplaceColorInPalette(refImage, refPalette, victimColor, newColor);

		// Rewrite the bitmap data in a new image
		tangible.RefObject<Image> tempRef_refImage = new tangible.RefObject<Image>(refImage);
		Image gifImage = Core.GifImage.CreateGifImage(tempRef_refImage);
		refImage.argvalue = tempRef_refImage.argvalue;

		refImage.argvalue.dispose();

		refImage.argvalue = gifImage;
	}

	public static void ReplaceTransparencyColor()
	{
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

	public static Color ParseColor(String s)
	{
		if (! (String.IsNullOrWhiteSpace(s)))
		{
			int r = 0;
			int g = 0;
			int b = 0;
			String[] splitted = s.split("[,]", -1);
			if (splitted.length != 3)
			{
				if (s.length() == 6)
				{
					Integer.TryParse(s.substring(0, 2), Globalization.NumberStyles.HexNumber, Globalization.CultureInfo.InvariantCulture, r);
					Integer.TryParse(s.substring(2, 4), Globalization.NumberStyles.HexNumber, Globalization.CultureInfo.InvariantCulture, g);
					Integer.TryParse(s.substring(4, 6), Globalization.NumberStyles.HexNumber, Globalization.CultureInfo.InvariantCulture, b);
				}
				else if (s.length() == 3)
				{
					Integer.TryParse(s.substring(0, 1), Globalization.NumberStyles.HexNumber, Globalization.CultureInfo.InvariantCulture, r);
					Integer.TryParse(s.substring(1, 2), Globalization.NumberStyles.HexNumber, Globalization.CultureInfo.InvariantCulture, g);
					Integer.TryParse(s.substring(2, 3), Globalization.NumberStyles.HexNumber, Globalization.CultureInfo.InvariantCulture, b);
				}
			}
			else
			{
				Integer.TryParse(splitted[0], r);
				Integer.TryParse(splitted[1], g);
				Integer.TryParse(splitted[2], b);
			}
			return Color.FromArgb(255, r, g, b);
		}
		return null;
	}

}