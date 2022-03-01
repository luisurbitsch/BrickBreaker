package GameComponents;
import GUI.Panel;
import Tools.RandomNumber;

import java.awt.*;
import java.util.ArrayList;

public class LevelLoader {
    private static final ArrayList<Obstacle> obstacles = new ArrayList<>();

    public LevelLoader() {

    }

    public static void loadObstacles(final Panel panel) {
        for(int x = 0; x < panel.getWidth(); x = x + Obstacle.getWidth()) {
            for (int y = 0; y < panel.getHeight() / 3; y = y + Obstacle.getHeight()) {
                if(RandomNumber.get(0, 5) == RandomNumber.get(0, 5)) {
                    obstacles.add(new Obstacle(x, y, RandomNumber.get(1, 10)));
                }
            }
        }
    }

    public static ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    public static void displayObstacles(final Graphics graphics) {
        for (Obstacle obstacle: obstacles) {
            obstacle.display(graphics);
        }
        filterRemovableObstacles();
    }

    private static void filterRemovableObstacles() {
        obstacles.removeIf(Obstacle::isRemovable);
    }

    public static void reloadObstacles(final Panel panel) {
        if(obstacles.isEmpty()) {
            loadObstacles(panel);
        }
    }
}
