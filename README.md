# Image Colorer [![Build Status](https://secure.travis-ci.org/DeuxHuitHuit/ImageColorer-java.png?branch=master)](http://travis-ci.org/DeuxHuitHuit/ImageColorer-java)

### Changes pixels colors in order to generate a new image for each color in RGB space

*Currently only working with gif files*

Transparency is supported only with Java 1.7 on Windows.

## Command line usage

`java -jar ImageColorer.jar [arg:value]`

Where [arg:value] can be:

- -f Original file path (-f:test.gif)
- -o Output folder (-o:./output)
- -c Victim color (-c:F00)

Convertion to Java have been made with those tools' demo version

- VBeeJ For Java from Beelucid <http://www.beelucid.com/products/download_vbj>
- VB to Java Converter from <http://tangiblesoftwaresolutions.com/Product_Details/VB_to_Java_Converter_Details.html>

Help for the rewrite of the GifImage

- <http://stackoverflow.com/questions/8996105/best-method-for-saving-a-java-image-object-with-a-custom-palette-to-a-gif-file>
- <http://stackoverflow.com/questions/5264706/how-to-replace-color-of-an-image>
- <http://stackoverflow.com/questions/3514158/how-do-you-clone-a-bufferedimage>
- <http://docs.oracle.com/javase/6/docs/api/java/awt/image/FilteredImageSource.html>
- <http://docs.oracle.com/javase/6/docs/api/java/awt/image/RGBImageFilter.html>