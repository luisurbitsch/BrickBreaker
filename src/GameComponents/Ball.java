package GameComponents;

import GUI.Panel;

import java.awt.*;

public class Ball implements IDisplayable, IMovable, ICollidable {
    private final Player player;
    private int xPosition;
    private int yPosition;
    private final int size = 10;
    private final Color color = new Color(229, 229, 30);
    private BallStatuses ballStatus = BallStatuses.NEUTRAL;
    private int deltaX = 0;
    private int deltaY = -2;
    private final Panel panel;

    public Ball(final Panel panel, final Player player) {
        this.panel = panel;
        this.player = player;
        this.xPosition = player.getxPosition() + size + (size / 2);
        this.yPosition = player.getyPosition() - size;
    }

    @Override
    public int getWidthSpan() {
        return xPosition + size;
    }

    @Override
    public int getHeightSpan() {
        return yPosition + size;
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

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public Player getPlayer() {
        return player;
    }

    public BallStatuses getBallStatus() {
        return ballStatus;
    }

    public void setBallStatus(final BallStatuses ballStatus) {
        this.ballStatus = ballStatus;
    }

    public Panel getPanel() {
        return panel;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(final int deltaX) {
        this.deltaX = deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(final int deltaY) {
        this.deltaY = deltaY;
    }

    private void followPlayer() {
        xPosition = player.getxPosition() + size + (size / 2);
        yPosition = player.getyPosition() - size;
    }

    @Override
    public void display(final Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval(xPosition, yPosition, size, size);
    }

    @Override
    public void move() {
        if (ballStatus == BallStatuses.MOVING) {
            xPosition = xPosition + deltaX;
            yPosition = yPosition + deltaY;
        } else if (ballStatus == BallStatuses.NEUTRAL) {
            followPlayer();
        }
        detectCollisions();
        detectGameOver();
    }

    private void detectCollisions() {
        reboundWindowEdges();
        reboundPlayer();
        reboundObstacles();
    }

    private void reboundWindowEdges() {
        if (xPosition <= 0 || xPosition + size > panel.getWidth()) {
            deltaX = -deltaX;
        }
        if (yPosition <= 0) {
            deltaY = -deltaY;
        }
    }

    private int getRandomRebound() {
        int randomRebound = (int) ((Math.random() * 100) % 4);
        if (randomRebound % 2 == 0) {
            return -randomRebound;
        } else {
            return randomRebound;
        }
    }

    private void reboundPlayer() {
        if (ballStatus == BallStatuses.MOVING) {
            if (deltaY > 0) {
                if (xPosition >= player.getxPosition() && xPosition <= player.getxPosition() + player.getWidth()
                        && yPosition + size >= player.getyPosition()) {
                    deltaY = -deltaY;
                    deltaX = getRandomRebound();
                }
            }
        }
    }

    private void reboundObstacles() {
        for (Obstacle obstacle : LevelLoader.getObstacles()) {
            reboundFromTop(obstacle);
            reboundFromBottom(obstacle);
            reboundFromLeft(obstacle);
            reboundFromRight(obstacle);
        }
    }

    private void reboundFromTop(final Obstacle obstacle) {
        if (deltaY > 0) {
            if (xPosition + size >= obstacle.getxPosition() && xPosition <= obstacle.getWidthSpan()) {
                if (yPosition + size == obstacle.getyPosition()) {
                    deltaY = -deltaY;
                    obstacle.decreaseCount();
                }
            }
        }
    }

    private void reboundFromBottom(final Obstacle obstacle) {
        if (deltaY < 0) {
            if (xPosition + size >= obstacle.getxPosition() && xPosition <= obstacle.getWidthSpan()) {
                if (yPosition == obstacle.getHeightSpan()) {
                    deltaY = -deltaY;
                    obstacle.decreaseCount();
                }
            }
        }
    }

    private void reboundFromLeft(final Obstacle obstacle) {
        if (deltaX > 0) {
            if (yPosition + size > obstacle.getyPosition() && yPosition < obstacle.getHeightSpan()) {
                if (xPosition + size >= obstacle.getxPosition() && xPosition + size <= obstacle.getWidthSpan()) {
                    deltaX = -deltaX;
                    obstacle.decreaseCount();
                }
            }
        }
    }

    private void reboundFromRight(final Obstacle obstacle) {
        if (deltaX < 0) {
            if (yPosition + size > obstacle.getyPosition() && yPosition < obstacle.getHeightSpan()) {
                if (xPosition <= obstacle.getWidthSpan() && xPosition >= obstacle.getxPosition()) {
                    deltaX = -deltaX;
                    obstacle.decreaseCount();
                }
            }
        }
    }

    private void detectGameOver() {
        if (deltaY > 0) {
            if (yPosition >= player.getyPosition()) {
                System.exit(-1);
            }
        }
    }
}
