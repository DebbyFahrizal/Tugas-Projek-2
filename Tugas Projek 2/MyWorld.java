import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    ScoreBoard scoreBoard;
    public ScoreBoard getScoreBoard(){
        return this.scoreBoard;
    }
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1);
        spawnplane();
        this.scoreBoard = new ScoreBoard();
        this.addObject(scoreBoard, 60, 30);
    }

    private void spawnplane(){
        Random rnd = new Random();
        plane p1 = new plane();
        p1.setRotation(270);
        this.addObject(p1, rnd.nextInt(getWidth() -30), this.getHeight()-30);
    }
    
    private void spawntrap(){
        Random rnd = new Random();
        for(int i= 0; i<rnd.nextInt(2); i++){
            trap en = new trap();
            this.addObject(en, rnd.nextInt(this.getWidth() - 30), 2);
        }
    }
    
    public void act(){
        List<trap> trap = this.getObjects(trap.class);
        System.out.println(trap.size());
        if(trap.size()==0){
            spawntrap();
        }
    }
}
