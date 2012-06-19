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

public class Bitmap extends ouput.beelucid.plugin.Drawing.Image  {
    private String filename = "";
    public Bitmap(String  f) {
        filename = f;
    }
    public String getFilename() {
        return filename;
    }
}
