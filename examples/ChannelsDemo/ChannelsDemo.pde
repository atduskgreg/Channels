import channels.*;
import java.awt.*;

PImage img;
PImage redImg;
PImage blueImg;
PImage greenImg;

PImage hueImg;
PImage saturationImg;
PImage brightnessImg;


void setup() {  
  size(250*3, 250*3);
  img = loadImage("testImage.png");
  redImg = loadImage("testImage.png");
  blueImg = loadImage("testImage.png");
  greenImg = loadImage("testImage.png");
  
  hueImg = loadImage("testImage.png");  
  saturationImg = loadImage("testImage.png");
  brightnessImg = loadImage("testImage.png");
  
  Channels.red(redImg);
  Channels.blue(blueImg);
  Channels.green(greenImg);
  
  Channels.hue(hueImg);
  Channels.saturation(saturationImg);
  Channels.brightness(brightnessImg);
}

void draw() {
  background(0);
  image(img,250,0, 250, 250);
  tint(255,0,0);
  image(redImg, 0, 250, 250, 250);
  tint(0,255,0);
  image(greenImg, 250, 250, 250, 250);
  tint(0,0,255);
  image(blueImg, 500, 250, 250,250);
  noTint();
  image(hueImg, 0, 500, 250,250);
  image(saturationImg, 250, 500, 250,250);
  image(brightnessImg, 500, 500, 250,250);
  
  fill(255);
  text("red", 10, 270);
  text("green", 260, 270);
  text("blue", 510, 270);
  
  fill(0);
  text("hue", 10, 270+250);
  text("saturation", 260, 270+250);
  text("brightness", 510, 270+250);

}
