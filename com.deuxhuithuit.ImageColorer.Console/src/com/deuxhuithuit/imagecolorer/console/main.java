package com.deuxhuithuit.imagecolorer.console; 

import ouput.beelucid.*;

import java.util.Date; 
import ouput.beelucid.Threading.Thread; 
import ouput.beelucid.plugin.IO.fileInfo; 
import ouput.beelucid.FileIO.FileSystem; 
import ouput.beelucid.plugin.My.Application; 
import java.util.Iterator; 
import ouput.beelucid.Core.GifImage; 
import ouput.beelucid.plugin.Drawing.Image; 
import ouput.beelucid.plugin.Drawing.*; 
import ouput.beelucid.plugin.Drawing.Color; 
import ouput.beelucid.plugin.Drawing.Imaging.ImageFormat; 
import ouput.beelucid.plugin.Drawing.Imaging.*; 

final class main
{
    private static final String HEX_COLOR_FORMAT_32 = "{0}{1:X2}{2:X2}{3:X2}.{4}";//  color is 16 bits
    private static final String HEX_COLOR_FORMAT_16 = "{0}{1:X1}{2:X1}{3:X1}.{4}";//  color is 8 bits
    private static final String RGB_TEXT_COLOR_FORMAT = "{0}rgb({1},{2},{3}).{4}";//  color is always 16 bits
    private static final String RGB_FIXED_COLOR_FORMAT = "{0}{1:000}{2:000}{3:000}).{4}";//  16 bits here too
    private static final int COLOR_FORMAT = 16;//  16 (X10) | 256 (X100)
    // Private Const COLOR_DEPTH As Byte = 16 ' 8, 16, 24 beware! 1111 1111 / 1111 1111 / 1111 1111
    private static String outputFolder = "../../output/"; 
    private static String file = "../../test.gif"; 
    private static Color victim = null; 
    private static String colorFormat = main.HEX_COLOR_FORMAT_16; 
    private static int stepper = 256 / main.COLOR_FORMAT; 
    public static void main(String[] args) {
        main.parseArgs(); 
        System.out.println("Welcome in Deux Huit Huit\'s ImageColorer"); 
        System.out.println(); 
        System.out.println("File: {0}", main.file); 
        System.out.println("Output: {0}", main.outputFolder); 
        System.out.println("Filename format {0}", main.colorFormat); 
        System.out.println(); 
        System.out.println("Color format: {0} bits", main.COLOR_FORMAT); 
        System.out.println("Victim {0}", main.victim); 
        System.out.println(); 
        ouput.beelucid.Threading.Thread.Sleep(1000); 
        System.out.print(" -> 3 -> "); 
        ouput.beelucid.Threading.Thread.Sleep(1000); 
        System.out.print("2 -> "); 
        ouput.beelucid.Threading.Thread.Sleep(1000); 
        System.out.print("1 -> "); 
        ouput.beelucid.Threading.Thread.Sleep(1000); 
        System.out.println(" GO!"); 
        System.out.println(); 
        Date Start = SystemBridge.Now(); 
        fileInfo fileInfo = ouput.beelucid.FileIO.FileSystem.GetFileInfo(main.file); 
        if (fileInfo != null && fileInfo.Exists()) {
            main.ProcessFile(fileInfo); 
        }
        else  {
            System.out.println("ERROR: File \'{0}\' does not exists. Can not continue.", (ouput.beelucid.plugin.Drawing.Color ) fileInfo.FullName()); 
        }
        System.out.println(); 
        System.out.println("Took {0:0.000} minutes to create {1} images", (SystemBridge.Now() - Start)); 
        System.out.println(); 
        System.out.println("Hit <Enter> to exit..."); 
        SystemBridge.ReadLine(); 
    }
    private static void parseArgs() {
        for (Object S_0 : (Iterable) ouput.beelucid.plugin.My.Application.CommandLineArgs()) {
            String S = S_0.toString();
            if (S.equals("-v")) {
            }
            else  {
                if (S.startsWith("-f:")) {
                    main.file = (new StringBridge(S)).Remove(0, 3); 
                }
                else if (S.startsWith("-o:")) {
                    main.outputFolder = (new StringBridge(S)).Remove(0, 3); 
                }
                else if (S.startsWith("-c:")) {
                    main.victim = ouput.beelucid.Core.GifImage.ParseColor((new StringBridge(S)).Remove(0, 3)); 
                }
                else  {
                    System.out.println("Argument \'{0}\' not valid.", S); 
                }
            }
        }
    }
    private static void ProcessFile(fileInfo  fileInfo) {
        Image img = ouput.beelucid.plugin.Drawing.Image.FromFile(fileInfo.FullName()); 
        for (int R = 0;  ((main.stepper >= 0 &&  R <= 128) || (main.stepper < 0 &&  R >= 128));  R = R + main.stepper)  {
            for (int G = 0;  ((main.stepper >= 0 &&  G <= 32) || (main.stepper < 0 &&  G >= 32));  G = G + main.stepper)  {
                for (int B = 0;  ((main.stepper >= 0 &&  B <= 32) || (main.stepper < 0 &&  B >= 32));  B = B + main.stepper)  {
                    Image [] ByRef$1  = new Image [1] ;  // load ByRef parameter
                    ByRef$1[0]  = img; 
                    main.CreateNewImage(ByRef$1, R, G, B); 
                    img = ByRef$1[0];  // store ByRef parameter
                }
            }
        }
        img.Dispose(); 
        img = (ouput.beelucid.plugin.Drawing.Image ) null; 
    }
    private static void CreateNewImage(Image [] refImage, int  R, int  G, int  B) {
        Image newImage = (ouput.beelucid.plugin.Drawing.Image ) refImage[0].Clone(); 
        //  Convert to gif with new color
        ouput.beelucid.Core.GifImage.ConverToGifImageWithNewColor(newImage, refImage[0].Palette(), main.victim, Color.FromArgb(255, R, G, B)); 
        //  Sage this gif image
        Image [] ByRef$1  = new Image [1] ;  // load ByRef parameter
        ByRef$1[0]  = newImage; 
        main.SaveGifImage(ByRef$1, R, G, B); 
        newImage = ByRef$1[0];  // store ByRef parameter
        //  Free up resources
        newImage.Dispose(); 
        newImage = (ouput.beelucid.plugin.Drawing.Image ) null; 
    }
    private static int sd(int  N) {
        if (N == 0) {
            return 0; 
        }
        return N / main.stepper; 
    }
    private static void SaveGifImage(Image [] newImage, int  R, int  G, int  B) {
        if ( !(ouput.beelucid.FileIO.FileSystem.GetDirectoryInfo(main.outputFolder).Exists())) {
            ouput.beelucid.FileIO.FileSystem.CreateDirectory(main.outputFolder); 
        }
        fileInfo fileInfo = ouput.beelucid.FileIO.FileSystem.GetFileInfo(StringBridge.Format(main.colorFormat, main.outputFolder, main.sd(R), main.sd(G), main.sd(B), "gif")); 
        if (fileInfo.Exists()) {
            fileInfo.Delete(); 
        }
        newImage[0].Save(fileInfo.FullName(), ouput.beelucid.plugin.Drawing.Imaging.ImageFormat.Gif()); 
        System.out.println(" - File {0} as been created!", (ouput.beelucid.plugin.Drawing.Color ) fileInfo.Name()); 
    }
}
