package ouput; 
import ouput.beelucid.*;

import ouput.beelucid.plugin.Drawing.Image; 
import ouput.beelucid.plugin.Drawing.*; 
import ouput.beelucid.plugin.Drawing.Imaging.ColorPalette; 
import ouput.beelucid.plugin.Drawing.Color; 
import ouput.beelucid.Core.GifImage; 
import ouput.beelucid.plugin.Globalization.NumberStyles; 
import ouput.beelucid.plugin.Globalization.CultureInfo; 
import ouput.beelucid.plugin.Drawing.Imaging.*; 
import ouput.GifImage; 


public class GifImage
{
    public static void CreateGifImage(Image [] refImage, Image [] destImage) {
        //  Copy the palette to assure colors follow
        destImage[0].set_Palette(refImage[0].get_Palette()); 
        // now to copy the actual bitmap data
        // lock the source and destination bits
        BitmapData src = ((ouput.beelucid.plugin.Drawing.Bitmap ) refImage[0]).LockBits(new ouput.beelucid.Rectangle (0, 0, refImage[0].Width(), refImage[0].Height()), ouput.beelucid.ImageLockMode.Readonly(), refImage[0].PixelFormat()); 
        BitmapData dst = ((ouput.beelucid.plugin.Drawing.Bitmap ) destImage[0]).LockBits(new ouput.beelucid.Rectangle (0, 0, destImage[0].Width(), destImage[0].Height()), ouput.beelucid.ImageLockMode.Writeonly(), destImage[0].PixelFormat()); 
        // steps through each pixel
        int Y = 0; 
        for (Y = 0;  Y <= refImage[0].Height() - 1;  Y++)  {
            int X = 0; 
            for (X = 0;  X <= refImage[0].Width() - 1;  X++)  {
                // transferring the bytes
                ouput.beelucid.Marshal.WriteByte(dst.Scan0(), dst.Stride() * Y + X, ouput.beelucid.Marshal.ReadByte(src.Scan0(), src.Stride() * Y + X)); 
            }
        }
        // all done, unlock the bitmaps
        ((ouput.beelucid.plugin.Drawing.Bitmap ) refImage[0]).UnlockBits(src); 
        ((ouput.beelucid.plugin.Drawing.Bitmap ) destImage[0]).UnlockBits(dst); 
    }
    public static Image CreateGifImage(Image [] refImage) {
        // Create a new 8 bit per pixel image
        return; 
        ouput.beelucid.plugin.Drawing.Bitmap bm = new ouput.beelucid.plugin.Drawing.Bitmap (refImage[0].Width(), refImage[0].Height(), ouput.beelucid.PixelFormat.Format8bppIndexed()); 
        CreateGifImage.get_Image_DefaultProperty(refImage[0], bm); 
        return bm; 
    }
    public static void ReplaceColorInPalette(Image [] refImage, ColorPalette  refPalette, Color  victimColor, Color  newColor) {
        // get it's palette
        ColorPalette ncp = refPalette; 
        //  Start with the refPalette
        ColorPalette Palette = refPalette; 
        for (int X = 0;  X <= Palette.get_Entries().Length() - 1;  X++)  {
            Color Color = Palette.get_Entries(X); 
            int alpha = 255; 
            //  if we found our victim
            if (Color.R() == victimColor.R() && Color.B() == victimColor.B() && Color.G() == victimColor.G()) {
                //  replace it in the palette
                ncp.set_Entries(X, Color.FromArgb(victimColor.A(), newColor.R(), newColor.G(), newColor.B())); 
            }
            else  {
                ncp.set_Entries(X, Color.FromArgb(Color.A(), Color.R(), Color.G(), Color.B())); 
            }
        }
        // re-insert the palette
        refImage[0].set_Palette(ncp); 
    }
    public static void ConverToGifImageWithNewColor(Image [] refImage, ColorPalette  refPalette, Color  victimColor, Color  newColor) {
        Image [] ByRef$1  = new Image [1] ;  // load ByRef parameter
        ByRef$1[0]  = refImage[0]; 
        GifImage.ReplaceColorInPalette(ByRef$1, refPalette, victimColor, newColor); 
        refImage[0] = ByRef$1[0];  // store ByRef parameter
        //  Rewrite the bitmap data in a new image
        Image GifImage = ouput.beelucid.Core.GifImage.CreateGifImage(refImage[0]); 
        refImage[0].Dispose(); 
        refImage[0] = GifImage; 
    }
    public static void ReplaceTransparencyColor() {
        // copy all the entries from the old palette removing any transparency
        // Dim n As Integer = 0
        // Dim c As Color
        // For Each c In bm.Palette.Entries
        //     ncp.Entries(n) = Color.FromArgb(255, c)
        //     n += 1
        // Next c
        // Set the newly selected transparency
        // ncp.Entries(0) = Color.FromArgb(0, bm.Palette.Entries(0))
        // re-insert the palette
        // refImage.Palette = ncp
    }
    public static Color ParseColor(String  S) {
        if ( !(StringBridge.IsNullOrWhiteSpace(S))) {
            int R = 0; 
            int G = 0; 
            int B = 0; 
            String [] splitted = (new StringBridge(S)).Split(','); 
            if ((new ArrayBridge(splitted)).length() != 3) {
                if (S.length() == 6) {
                    IntegerBridge.TryParse(S.substring(0, 2), ouput.beelucid.plugin.Globalization.NumberStyles.HexNumber(), ouput.beelucid.plugin.Globalization.CultureInfo.InvariantCulture(), R); 
                    IntegerBridge.TryParse(S.substring(2, 2), ouput.beelucid.plugin.Globalization.NumberStyles.HexNumber(), ouput.beelucid.plugin.Globalization.CultureInfo.InvariantCulture(), G); 
                    IntegerBridge.TryParse(S.substring(4, 2), ouput.beelucid.plugin.Globalization.NumberStyles.HexNumber(), ouput.beelucid.plugin.Globalization.CultureInfo.InvariantCulture(), B); 
                }
                else if (S.length() == 3) {
                    IntegerBridge.TryParse(S.substring(0, 1), ouput.beelucid.plugin.Globalization.NumberStyles.HexNumber(), ouput.beelucid.plugin.Globalization.CultureInfo.InvariantCulture(), R); 
                    IntegerBridge.TryParse(S.substring(1, 1), ouput.beelucid.plugin.Globalization.NumberStyles.HexNumber(), ouput.beelucid.plugin.Globalization.CultureInfo.InvariantCulture(), G); 
                    IntegerBridge.TryParse(S.substring(2, 1), ouput.beelucid.plugin.Globalization.NumberStyles.HexNumber(), ouput.beelucid.plugin.Globalization.CultureInfo.InvariantCulture(), B); 
                }
            }
            else  {
                IntegerBridge.TryParse(splitted[0], R); 
                IntegerBridge.TryParse(splitted[1], G); 
                IntegerBridge.TryParse(splitted[2], B); 
            }
            return Color.FromArgb(255, R, G, B); 
        }
        return (ouput.beelucid.plugin.Drawing.Color ) null; 
    }
}
