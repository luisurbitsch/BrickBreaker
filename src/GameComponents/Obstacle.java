package GameComponents;

import Tools.RandomNumber;

import java.awt.*;

public class Obstacle implements IDisplayable, ICollidable{
    private int xPosition;
    private int yPosition;
    private static int width = 40;
    private static int height = 20;
    private Color color = new Color(RandomNumber.get(20, 230), RandomNumber.get(20, 230), RandomNumber.get(20, 230));
    private final Color countColor = Color.white;
    private int count;

    public Obstacle(final int xPosition, final int yPosition, final int count) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.count = count;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(final int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(final int yPosition) {
        this.yPosition = yPosition;
    }

    public static int getWidth() {
        return width;
    }

    public void setWidth(final int width) {
        Obstacle.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public void setHeight(final int height) {
        Obstacle.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(final Color color) {
        this.color = color;
    }

    public Color getCountColor() {
        return countColor;
    }

    public int getWidthSpan() {
        return xPosition + width;
    }

    public int getHeightSpan() {
        return yPosition + height;
    }

    public int getCount() {
        return count;
    }

    public void decreaseCount() {
        count -= 1;
    }

    public boolean isRemovable() {
        return count == 0;
    }

    private void displayCount(final Graphics graphics) {
        graphics.setColor(countColor);
        graphics.drawString(Integer.toString(count), xPosition + 15, yPosition + 15);
    }

    @Override
    public void display(final Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(xPosition, yPosition, width, height);
        displayCount(graphics);
    }

}
