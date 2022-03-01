package GameComponents;

import GUI.Panel;

import java.awt.*;

public class Player implements IDisplayable, IMovable, ICollidable {
    private int xPosition;
    private int yPosition;
    private final int width = 40;
    private final int height = 5;
    private final Color color = new Color(190, 80, 80);
    private MovingDirections movingDirection = MovingDirections.NEUTRAL;
    private final int deltaX = 4;
    private final Panel panel;

    public Player(final Panel panel) {
        this.panel = panel;
        this.xPosition = (panel.getWidth() / 2) - (width / 2);
        this.yPosition = panel.getHeight() - height - 5;
    }

    @Override
    public int getWidthSpan() {
        return xPosition + width;
    }

    @Override
    public int getHeightSpan() {
        return yPosition + height;
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public MovingDirections getMovingDirection() {
        return movingDirection;
    }

    public void setMovingDirection(final MovingDirections movingDirection) {
        this.movingDirection = movingDirection;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public void move() {
        if (movingDirection == MovingDirections.LEFT && xPosition >= 0) {
            xPosition = xPosition - deltaX;
        } else if (movingDirection == MovingDirections.RIGHT && xPosition + width <= panel.getWidth()) {
            xPosition = xPosition + deltaX;
        }

    }

    @Override
    public void display(final Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(xPosition, yPosition, width, height);
    }

}
