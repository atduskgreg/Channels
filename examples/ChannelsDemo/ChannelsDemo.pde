import channels.*;

PImage img;
PImage redImg;

void setup() {
  size(250*3, 250*3);
  img = loadImage("testImage.png");
  redImg = loadImage("testImage.png");
  
  //Channels.red(redImg);
}

void draw() {
  background(0);
  image(img,250,0, 250, 250);
  image(redImg, 0, 250, 250, 250);
}
