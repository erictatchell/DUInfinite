package org.bcit.comp2522.dui.client;

import processing.core.PImage;

import org.bson.Document;

public class Menu {
  private Manager manager;
  private Window window;
  String scoreDisplay;
  String highScoreDisplay;

  PImage car1, car2, car3, car4;
  public Menu(Manager manager, Window scene) {
    this.manager = manager;
    this.window = scene;

    car1 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/redUpright.png");
    car2 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/lamboUpright.png");
    car3 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/viperUpright.png");
    car4 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/PurpUpright.png");
  }

  public void menu2() {
    window.background(0);


    window.fill(255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.mediumFont);
    window.text("DUI", window.width / 2, 90);

    //Should take you to a page to select a car style
    //semi = hard
    //car = medium
    //moto = easy
    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.smallFont);
    window.text("Difficulty", window.width / 2 + 10, 100 + 100);
    manager.button.diff();

    // Should take you to a page to select show you what car color your at
    // like skins but for cars that you unlock at certain scores
    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.smallFont);
    window.text("Cars", window.width / 2 + 10, 100 + 200);
    manager.button.cars();

    // Should take you to a page to show you the top 3-5 scores
    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.smallFont);
    window.text("LeaderBoard", window.width / 2 + 10, 100 + 300);
    manager.button.leaderboard();

    // Should take you to a page that asks if you really want to quit
    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.smallFont);
    window.text("Quit", 900, 100 + 450);
//    manager.button.quit();
  }

       /*
        check the score to see if the player has unlocked the next car if they have then call the
        function that will see if the player chooses the red yellow or blue car and then
         set the player.carColor to the color they chose
         then in the player class you can use a switch statement to change the color of the car
         */

  public void carSelection(){
    window.background(0);


    window.fill(255,255,255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.mediumFont);
    window.text("Car Rank", window.width / 2, 90);

    // Red
    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.smallFont);
    window.text("Red", 150, 450);

    window.image(car1, 100, 125, 150, 250);

    window.fill(255, 255, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.smallFont);
    window.textSize(30);
    window.text("Select", 150, 525);
    manager.button.red();


    // Yellow
    window.fill(255, 255, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.smallFont);
    window.text("Yellow", 475, 450);

    window.image(car2, 425, 125, 100, 250);
    if (manager.game.highScore >= 1000) {
      window.fill(255, 255, 255);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.smallFont);
      window.textSize(30);
      window.text("Select", 475, 525);
      manager.button.yellow();
    }

    // Blue
    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.smallFont);
    window.text("Blue", 775, 450);
    window.image(car3, 725, 125, 100, 250);
    if (manager.game.highScore >= 2500) {
      window.fill(255, 255, 255);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.smallFont);
      window.textSize(30);
      window.text("Select", 775, 525);
      manager.button.blue();
    }

    // Purple
    window.fill(160, 32, 240);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.smallFont);
    window.text("Purple", 1075, 450);
    window.image(car4, 1025, 125, 100, 250);
    if (manager.game.highScore >= 5000) {
      window.fill(255, 255, 255);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.smallFont);
      window.textSize(30);
      window.text("Select", 1075, 525);
      manager.button.purple();
      //player.BlueCar();
    }
  }


  public void gameOver() {
    manager.game.stopScore();
    window.background(0);
    scoreDisplay = String.format("Your score: %d", manager.game.score);
    System.out.println(scoreDisplay);

    if (manager.game.score > manager.game.highScore) {
      highScoreDisplay = "New High Score!";
      window.fill(255, 255, 0);
      window.textFont(manager.contentLoader.smallFont);
      window.textAlign(window.CENTER);
      window.text(highScoreDisplay, (window.width / 2), 275);
    } else {
      highScoreDisplay = "";
    }
    window.fill(255, 255, 255);
    window.textFont(manager.contentLoader.smallFont);
    window.textAlign(window.CENTER);
    window.text(scoreDisplay, (window.width / 2), 350);

    // Totaled
    window.fill(255, 0, 0);
    window.textFont(manager.contentLoader.mediumFont);
    window.textAlign(window.CENTER);
    window.text("TOTALED", (window.width / 2), 175);

    manager.button.mainMenu();
    manager.button.playAgain();
  }

  public void Leaderboard() {
    DatabaseHandler dbhandler = new DatabaseHandler("pavanbrar73", "KFmJyFJrTM6Dd7c2");

    window.background(0);

    window.textSize(32);
    window.fill(255);
    window.textAlign(window.CENTER);

    window.text("Leaderboard", window.width/2, 80);
    window.text("Rank", 100, 160);
    window.text("Name", window.width/2 - 200, 160);
    window.text("Score", window.width/2 + 200, 160);

    window.textSize(28);
    window.textAlign(window.CENTER, window.CENTER);
//    window.fill(255);
    int y = 200;
    int rank = 1;

    window.stroke(255);
    window.strokeWeight(2);
    window.line(80, 180, window.width - 80, 180);

    window.rect(80, 180, 70, y - 180);

    window.rect(window.width/2 - 390, 180, 340, y - 180);

    for (Document doc : dbhandler.getHighestScores()) {

      String name = doc.getString("name");
      long score = doc.getLong("score");
      window.stroke(255);
      window.strokeWeight(2);
      window.line(80, y - 20, window.width - 80, y - 20);

      window.text(rank, 150, y);

      window.rect(window.width/2 - 390, y - 20, 340, 40);

      window.text(name, window.width/2 - 120, y);

      window.rect(window.width/2 + 150, y - 20, 270, 40);

      window.text(score, window.width/2 + 270, y);

      window.stroke(255);
      window.strokeWeight(2);
      window.line(80, y + 20, window.width - 80, y + 20);

      y += 40;
      rank++;
    }

    window.stroke(255);
    window.strokeWeight(2);
    window.line(80, y - 20, window.width - 80, y - 20);
  }

  public void main() {
    window.background(0);
    window.fill(255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.bigFont);
    window.text("DUI", window.width / 2, 200);
    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.bigFont);
    window.text("DUI", window.width / 2 + 10, 200 + 10);
    window.fill(255);
    window.textFont(manager.contentLoader.smallFont);
    window.text("Driving\nUnintelligently", window.width / 2, 300);
    window.rect( (window.width / 2) - 150, 450, 300, 125);
    window.textAlign(window.CENTER);
    window.fill(0);
    window.textFont(manager.contentLoader.mediumFont);
    window.text("PLAY", window.width / 2, 535);
    manager.button.play();
  }
}