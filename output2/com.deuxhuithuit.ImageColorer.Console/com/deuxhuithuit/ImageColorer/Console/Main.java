package com.deuxhuithuit.ImageColorer.Console;

public final class Main
{

	private static final String HEX_COLOR_FORMAT_32 = "{0}{1:X2}{2:X2}{3:X2}.{4}"; // color is 16 bits
	private static final String HEX_COLOR_FORMAT_16 = "{0}{1:X1}{2:X1}{3:X1}.{4}"; // color is 8 bits
	private static final String RGB_TEXT_COLOR_FORMAT = "{0}rgb({1},{2},{3}).{4}"; // color is always 16 bits
	private static final String RGB_FIXED_COLOR_FORMAT = "{0}{1:000}{2:000}{3:000}).{4}"; // 16 bits here too

	private static final int COLOR_FORMAT = 16; // 16 (X10) | 256 (X100)
	//Private Const COLOR_DEPTH As Byte = 16 ' 8, 16, 24 beware! 1111 1111 / 1111 1111 / 1111 1111

	private static String outputFolder = "../../output/";
	private static String file = "../../test.gif";
	private static Color victim;
	private static String colorFormat = HEX_COLOR_FORMAT_16;
	private static int stepper = 256 / COLOR_FORMAT;

	public static void main()
	{
		parseArgs();

		Microsoft.VisualBasic.FileSystem.WriteLine("Welcome in Deux Huit Huit's ImageColorer");
		Microsoft.VisualBasic.FileSystem.WriteLine();
		Microsoft.VisualBasic.FileSystem.WriteLine("File: {0}", file);
		Microsoft.VisualBasic.FileSystem.WriteLine("Output: {0}", outputFolder);
		Microsoft.VisualBasic.FileSystem.WriteLine("Filename format {0}", colorFormat);
		Microsoft.VisualBasic.FileSystem.WriteLine();
		Microsoft.VisualBasic.FileSystem.WriteLine("Color format: {0} bits", COLOR_FORMAT);
		Microsoft.VisualBasic.FileSystem.WriteLine("Victim {0}", victim);
		Microsoft.VisualBasic.FileSystem.WriteLine();
		Threading.Thread.Sleep(1000);
		Microsoft.VisualBasic.FileSystem.Write(" -> 3 -> ");
		Threading.Thread.Sleep(1000);
		Microsoft.VisualBasic.FileSystem.Write("2 -> ");
		Threading.Thread.Sleep(1000);
		Microsoft.VisualBasic.FileSystem.Write("1 -> ");
		Threading.Thread.Sleep(1000);
		Microsoft.VisualBasic.FileSystem.WriteLine(" GO!");
		Microsoft.VisualBasic.FileSystem.WriteLine();

		java.util.Date start = new java.util.Date();

		IO.FileInfo fileInfo = new java.io.File(file);

		if (fileInfo != null && fileInfo.Exists)
		{
			ProcessFile(fileInfo);
		}
		else
		{
			Microsoft.VisualBasic.FileSystem.WriteLine("ERROR: File '{0}' does not exists. Can not continue.", fileInfo.FullName);
		}
		Microsoft.VisualBasic.FileSystem.WriteLine();
		Microsoft.VisualBasic.FileSystem.WriteLine("Took {0:0.000} minutes to create {1} images", (new java.util.Date() - start).TotalMinutes, ((Math.pow(COLOR_FORMAT, 3))));
		Microsoft.VisualBasic.FileSystem.WriteLine();
		Microsoft.VisualBasic.FileSystem.WriteLine("Hit <Enter> to exit...");
		ReadLine();
	}

	private static void parseArgs()
	{
		for (String s : My.Application.CommandLineArgs)
		{
//VB TO JAVA CONVERTER NOTE: The following VB 'Select Case' included either a non-ordinal switch expression or non-ordinal, range-type, or non-constant 'Case' expressions and was converted to Java 'if-else' logic:
//			Select Case s

//ORIGINAL LINE: Case "-v"
			if (s.equals("-v"))
			{

			}
//ORIGINAL LINE: Case Else
			else
			{
				if (s.startsWith("-f:"))
				{
					file = s.substring(0, 0) + s.substring(0 + 3);
				}
				else if (s.startsWith("-o:"))
				{
					outputFolder = s.substring(0, 0) + s.substring(0 + 3);
				}
				else if (s.startsWith("-c:"))
				{
					victim = Core.GifImage.ParseColor(s.substring(0, 0) + s.substring(0 + 3));
				}
				else
				{
					Microsoft.VisualBasic.FileSystem.WriteLine("Argument '{0}' not valid.", s);
				}
			}
		}
	}

	private static void ProcessFile(IO.FileInfo fileInfo)
	{
		Drawing.Image img = Drawing.Bitmap.FromFile(fileInfo.FullName);

		for (int r = 0; r <= 128; r += stepper)
		{
			for (int g = 0; g <= 32; g += stepper)
			{
				for (int b = 0; b <= 32; b += stepper)
				{
					tangible.RefObject<Drawing.Image> tempRef_img = new tangible.RefObject<Drawing.Image>(img);
					CreateNewImage(tempRef_img, r, g, b);
					img = tempRef_img.argvalue;
				}
			}
		}

		img.dispose();
		img = null;
	}


	private static void CreateNewImage(tangible.RefObject<Drawing.Image> refImage, int r, int g, int b)
	{
		Image newImage = (Image)refImage.argvalue.Clone;

		// Convert to gif with new color
		Core.GifImage.ConverToGifImageWithNewColor(newImage, refImage.argvalue.Palette, victim, Color.FromArgb(255, r, g, b));

		// Sage this gif image
		tangible.RefObject<Drawing.Image> tempRef_newImage = new tangible.RefObject<Drawing.Image>(newImage);
		SaveGifImage(tempRef_newImage, r, g, b);
		newImage = tempRef_newImage.argvalue;

		// Free up resources
		newImage.dispose();
		newImage = null;
	}

	private static int sd(int n)
	{
		if (n == 0)
		{
			return 0;
		}
		return n / stepper;
	}

	private static void SaveGifImage(tangible.RefObject<Drawing.Image> newImage, int r, int g, int b)
	{
		if (! ((new java.io.File(outputFolder)).exists()))
		{
			(new java.io.File(outputFolder)).mkdir();
		}
		IO.FileInfo fileInfo = new java.io.File(String.format(colorFormat, outputFolder, sd(r), sd(g), sd(b), "gif"));

		if (fileInfo.Exists)
		{
			fileInfo.Delete();
		}

		newImage.argvalue.Save(fileInfo.FullName, Drawing.Imaging.ImageFormat.Gif);

		Microsoft.VisualBasic.FileSystem.WriteLine(" - File {0} as been created!", fileInfo.Name);
	}
}