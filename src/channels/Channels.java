/**
 * ##library.name##
 * ##library.sentence##
 * ##library.url##
 *
 * Copyright ##copyright## ##author##
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author      ##author##
 * @modified    ##date##
 * @version     ##library.prettyVersion## (##library.version##)
 */

package channels;


import java.awt.Color;

import processing.core.*;

/**
 * Channels is a Processing library that lets you extract the red, green, blue, hue, saturation, or brightness channels from a PImage. It works similarly to Processing's built-in red(), green(), blue(), brightness(), hue(), and saturation() functions, but instead of applying to individual pixels, Channels' equivalent functions apply to the entire image.
 * Extracting individual channels can be useful for visualizing or analyzing images. Channels can be used to modify an image in place for display or to extract an array of int representing the pixels for the relevant channel.
 * 
 * @example ChannelsDemo 

 */

public class Channels {
	public final static String VERSION = "##library.prettyVersion##";
	
	public final static int[] red(int[] pix){
		return processColor(pix, 16);
	}
	
	public final static int[] green(int[] pix){
		return processColor(pix, 8);
	}
	
	public final static int[] blue(int[] pix){
		return processColor(pix, 0);
	}
	
	public final static int[] hue(int[] pix){
		return processHSB(pix, 0);
	}
	
	public final static int[] saturation(int[] pix){
		return processHSB(pix, 1);
	}
	
	public final static int[] brightness(int[] pix){
		return processHSB(pix, 2);
	}
	
	
	private final static int[] processColor(int[] pix, int offset){
		int[] result = new int[pix.length];
		for(int p = 0; p<pix.length; p++){
			result[p] = pix[p] >> offset & 0xff;
		}
		return result;
	}
	
	private final static int[] processHSB(int[] pix, int index){
		int[] result = new int[pix.length];

		for(int p = 0; p< pix.length; p++){
			   float[] cacheHsbValue = new float[3];
			   Color.RGBtoHSB((pix[p] >> 16) & 0xff, (pix[p] >> 8) & 0xff,pix[p] & 0xff, cacheHsbValue);
			   result[p] = (int)(cacheHsbValue[index] * 255);
		}
		return result;
	}
	
	public final static void red(PImage i){		
		processColor(i, 16);
	}
	
	public final static void green(PImage i){		
		processColor(i, 8);
	}
	
	public final static void blue(PImage i){		
		processColor(i, 0);
	}
	
	public final static void hue(PImage i){		
		processHSB(i, 0);
	}
	
	public final static void saturation(PImage i){		
		processHSB(i, 1);
	}
	
	public final static void brightness(PImage i){		
		processHSB(i, 2);
	}
	
	private final static int color(int c){
		if (c > 255) c = 255; else if (c < 0) c = 0;
        return 0xff000000 | (c << 16) | (c << 8) | c;
	}
	
	private final static void processColor(PImage i, int offset){
		i.loadPixels();
		for(int p = 0; p<(i.width * i.height); p++){
			i.pixels[p] = color(i.pixels[p] >> offset & 0xff);
		}
		i.updatePixels();
	}
	
	private final static void processHSB(PImage i, int index){
		i.loadPixels();
		for(int p = 0; p<(i.width * i.height); p++){
			   float[] cacheHsbValue = new float[3];
			   Color.RGBtoHSB((i.pixels[p] >> 16) & 0xff, (i.pixels[p] >> 8) & 0xff,i.pixels[p] & 0xff, cacheHsbValue);
			   i.pixels[p] = color((int)(cacheHsbValue[index] * 255));
		}
		i.updatePixels();

	}
	

}

