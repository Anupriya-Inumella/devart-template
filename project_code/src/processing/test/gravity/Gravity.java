package processing.test.gravity;

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Gravity extends PApplet {

float[] x = new float[100];
float[] y = new float[100];
float[] speed = new float[100];
PImage s;

public void setup() {
 
  background(0);
  stroke(255);
  s = loadImage("spacewalk.jpg");

  int i = 0;
  while(i < 100) {  
    x[i] = random(0, width);
    y[i] = random(0, height);
    speed[i] = random(1, 5);
    i = i + 1;
  }
}

public void draw() {
  background(0);

  // draw triangle
  //triangle(mouseX, mouseY-6, mouseX, mouseY+6, mouseX+30, mouseY);
  image(s,mouseX,mouseY+6);
  
  int i = 0;
  while(i < 100) {
    float co = map(speed[i], 1, 5, 100, 255);
    stroke(co);
    strokeWeight(speed[i]);
    point(x[i], y[i]);
  
    x[i] = x[i] - speed[i] / 2;
    if(x[i] < 0) {
      x[i] = width;
    }
    i = i + 1;
  }
}

  public int sketchWidth() { return 1000; }
  public int sketchHeight() { return 800; }
}
