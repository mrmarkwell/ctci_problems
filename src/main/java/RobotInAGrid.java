import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Key issue with this one - grid[r][c] is not the same as grid[x][y].
// This really goofed up my actual answer. It does work in the example below though.

/**
 * 8.2 RobotInAGrid
 *
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits"
 * such that the robot cannot step on them. Design an algorithm to find a path for the robot from
 * the top left to the bottom right.
 */
class RobotInAGrid {

    public List<Direction> findPathForRobot(boolean[][] grid) {
        if (grid == null ||
                grid.length == 0 ||
                grid[0].length == 0 ||
                grid[0][grid[0].length - 1]) {
            return null;
        }
        int x = 0;
        int y = grid[0].length - 1;
        Map<Pair<Integer, Integer>, Direction> path_map = new HashMap<>();
        _visit(x + 1, y, Direction.RIGHT, grid, path_map);
        _visit(x, y - 1, Direction.DOWN, grid, path_map);
        if (path_map.containsKey(new Pair<>(grid.length - 1, 0))) {
            // We reached the end!
            LinkedList<Direction> path = new LinkedList<>();
            x = grid.length - 1;
            y = 0;
            while (x != 0 || y != grid[0].length - 1) {
                Direction dir = path_map.get(new Pair<>(x, y));
                path.addFirst(dir);
                if (dir == Direction.RIGHT) x = x - 1;
                if (dir == Direction.DOWN) y = y + 1;
            }
            return path;
        } else {
            return null;
        }
    }



    private void _visit(int x, int y, Direction entry_dir, boolean[][] grid, Map<Pair<Integer, Integer>, Direction> path_map) {
        if (x >= grid.length) return;
        if (y < 0) return;
        if (grid[x][y]) return; // cell is inaccessible!
        Pair p = new Pair<>(x, y);
        if (path_map.containsKey(p)) return; // Visited this cell before!
        path_map.put(p, entry_dir);
        _visit(x + 1, y, Direction.RIGHT, grid, path_map);
        _visit(x, y - 1, Direction.DOWN, grid, path_map);
    }
    public static void main(String[] args) {
        RobotInAGrid sut = new RobotInAGrid();


        boolean[][] grid = {
                {false, false, false, false, false, false},
                {false, true,  true,  true,  true,  false},
                {false, false, false, false, false, false},
                {true,  false, false, true,  false, false},
                {false, true,  false, false, true,  true },
                {false, false, false, false, false, false}};

        printGrid(grid);
        List<Direction> result = sut.findPathForRobot(grid);
        System.out.println(result);

        boolean[][] grid2 = {
                {false, false, false},
                {false, true, true},
                {false, false, false}};



        printGrid(grid2);
        result = sut.findPathForRobot(grid2);
        System.out.println(result);

    }

    public static void printGrid(boolean[][] grid) {
        for(int x = grid.length - 1; x >= 0; x--) {
            StringBuilder sb = new StringBuilder();
            //for (int y = grid.length - 1; y >= 0; y--) {
            for (int y = 0; y < grid.length; y++) {
                sb.append(grid[y][x] ? " 1 " : " 0 ");
            }
            System.out.println(sb.toString());
        }
    }

    // Enum for directions.
    public enum Direction {
        DOWN,
        RIGHT
    }
}

