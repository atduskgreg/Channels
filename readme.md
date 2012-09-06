### Channels

<a href="http://www.flickr.com/photos/unavoidablegrain/7945413206/" title="Processing Channels library demo by atduskgreg, on Flickr"><img src="http://farm9.staticflickr.com/8303/7945413206_5e157c71ae.jpg" width="486"  alt="Processing Channels library demo"></a>

Channels is a Processing library that lets you extract the red, green, blue, hue, saturation, or brightness channels from a PImage. It works similarly to Processing's built-in [red()](http://processing.org/reference/red_.html), [green()](http://processing.org/reference/green_.html), [blue()](http://processing.org/reference/bluee_.html), [brightness()](http://processing.org/reference/brightness_.html), [hue()](http://processing.org/reference/hue_.html), and [saturation()](http://processing.org/reference/saturation_.html) functions, but instead of applying to individual pixels, Channels' equivalent functions apply to the entire image.

Extracting individual channels can be useful for visualizing or analyzing images. Channels can be used to modify an image in place for display or to extract an array of ints representing the pixels for the relevant channel.

### Examples

Here's an example of the first mode: modifying a PImage in place so it displays just one channel of the original image.

````
PImage myImage;
void setup(){
  size(500,500);
  myImage = loadImage("testImage.png"); // a square image around 500x500 pixels
  Channels.red(myImage);
}

void draw(){
  image(myImage,0,0);
}
````

Here's an example of the second mode: extracting the pixels of a particular channel for use:

````
PImage myImage;
int[] myPixels;
void setup(){
  size(500,500);
  myImage = loadImage(testImage.png);
  myPixels = new int[myImage.width * myImage.height];

  myImage.loadPixels();
  myPixels = Channels.red(myImage.pixels);
}

void draw(){
  for(int i = 0; i < myPixels.length; i++){
    // do something with the pixels in the red channel...
  }
}
````

An example of something useful to do with the pixels of a given channel might be to run the marching squares algorithm on it using [the Isolines Processing library](http://makematics.com/code/Isolines).