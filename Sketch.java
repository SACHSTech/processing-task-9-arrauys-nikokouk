import processing.core.PApplet;

public class Sketch extends PApplet {

  //Declare Variables
  
  float playerX = 300;
  float playerY = 300;
  float[] circleX = new float[30];
  float[] circleY = new float[30];
  boolean[] boolSnowShow = new boolean[30];
  int intLives = 3;


  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {

    //declare size
  
    size(400, 400);

    //declares position of the black snowballs
    for (int i = 0; i < circleY.length; i++) {
      circleY[i] = random(height);
      circleX[i] = random(width);  
    }

    //Decides if snow is visible or not
    for (int i = 0; i < circleY.length; i++) {
      circleY[i] = random(height);
      boolSnowShow[i] = true;
    }
  }

  public void setup() {

  background(3, 252, 132);
    
  }

  public void draw() {

  //draw background
  background(3, 252, 132);

  //Make Player
  fill(200);
  ellipse(playerX, playerY, 20, 20);
  
  //Draws Black Snowballs on screen
  for (int i = 0; i < circleY.length; i++) {
    float circleX = width * i / circleY.length;
    if (boolSnowShow[i]) {
      fill(0);
      ellipse(circleX, circleY[i], 25, 25);
    }
    
    circleY[i]++;

    if (circleY[i] > height) {
      circleY[i] = 0;
    }

    // Slows down and speeds black snowfall
  if (keyPressed) {
    if (keyCode == UP) {
      circleY[i]-=2;
  }
    else if (keyCode == DOWN) {
      circleY[i]+=2;
    }
  }
    
  //Makes user lose lives
  if (playerX >= circleX-12.5 && playerX <= circleX+12.5 && playerY >= circleY[i]-12.5 && playerY <= circleY[i]+12.5 && boolSnowShow[i]){
    intLives = intLives - 1;
    boolSnowShow[i] = false;
    }

  //Mouse click removes circles
  if (mouseX >= circleX-12.5 && mouseX <= circleX+12.5 &&   mouseY >= circleY[i]-12.5 && mouseY <= circleY[i]+12.5 && mousePressed == true) {
    boolSnowShow[i] = false;
  }

  // Lives display
  if (intLives == 3) {
    fill(252, 186, 3); 
    rect(385, 5, 10, 10);
    rect(370, 5, 10, 10);
    rect(355, 5, 10, 10);
  }
  if (intLives == 2) {
    fill(252, 186, 3); 
    rect(385, 5, 10, 10);
    rect(370, 5, 10, 10);
  }
  if (intLives == 1) {
    fill(252, 186, 3); 
    rect(385, 5, 10, 10);
  }
  if (intLives <= 0) {
    background(255); 
  }


  }
}

  //method to move the player
  public void keyPressed() {

  if (key == 'w') {
    playerY-=4;
  }
  if (key == 's') {
    playerY+=4;
  }
  if (key == 'a') {
    playerX-=4;
  }
  if (key == 'd') {
    playerX+=4; 
  }

  
    }

}