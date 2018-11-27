package main;

import creaturesSight.Entity;

public class GameCamera {

    private Handler handler;
    private float xOffset, yOffset;
    private int mapSize = 1010;

    public GameCamera(Handler handler, float xOffset, float yOffset) {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void checkBlankSpace() {
         if(xOffset < 0){
             xOffset = 0;
         }
         if (xOffset > mapSize){
             xOffset = mapSize;
         }
         if(yOffset < 0){
             yOffset = 0;
         }
        if (yOffset > mapSize) {
            yOffset = mapSize;
        }
    }

    public void centerOnEntity(Entity e) {
        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
        checkBlankSpace();
    }

    public void move(float xAmt, float yAmt) {
        xOffset = xOffset + xAmt;
        yOffset = yOffset + yAmt;
        checkBlankSpace();
    }

    public float getxOffset() {
        return xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }
}