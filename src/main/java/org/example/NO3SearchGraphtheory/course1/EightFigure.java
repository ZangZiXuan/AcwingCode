package org.example.NO3SearchGraphtheory.course1;

import java.util.*;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/4/24 16:42
 * @Version 1.0
 */
public class EightFigure {
    private static final int[][] GOAL_STATE = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}}; // 目标状态
    private static final int[] dx = {0, 0, 1, -1};
    // X轴方向移动向量：右、左、下、上
    private static final int[] dy = {1, -1, 0, 0};
    // Y轴方向移动向量：右、左、下、上

    public static void main(String[] args) {
        int[][] puzzle = {{1, 2, 3}, {0, 4, 6}, {7, 5, 8}};
        // 初始状态，0表示空格

        List<int[][]> solution = solvePuzzle(puzzle);
        // 解决八数码问题
        if (solution != null) {
            for (int[][] state : solution) {
                printPuzzle(state);
                // 打印解决方案
                System.out.println();
            }
        } else {
            System.out.println("No solution exists."); // 无解
        }
    }

    private static List<int[][]> solvePuzzle(int[][] initial) {
        Queue<int[][]> queue = new LinkedList<>(); // 用于广度优先搜索的队列
        Map<int[][], int[][]> parentMap = new HashMap<>(); // 记录每个状态的父状态，用于最后重构路径

        queue.offer(initial); // 将初始状态放入队列
        parentMap.put(initial, null); // 初始状态没有父状态

        while (!queue.isEmpty()) {
            int[][] current = queue.poll(); // 从队列中取出当前状态

            if (isGoalState(current)) { // 如果当前状态是目标状态
                return reconstructPath(current, parentMap); // 重构路径并返回解决方案
            }

            int[] emptyPosition = findEmptyPosition(current); // 找到空格位置

            // 尝试向四个方向移动空格
            for (int i = 0; i < 4; i++) {
                int newX = emptyPosition[0] + dx[i]; // 新的空格位置的X坐标
                int newY = emptyPosition[1] + dy[i]; // 新的空格位置的Y坐标

                if (isValidMove(newX, newY)) { // 如果移动是合法的
                    int[][] newState = swap(current, emptyPosition[0], emptyPosition[1], newX, newY); // 交换空格和相邻数字的位置

                    if (!parentMap.containsKey(newState)) { // 如果新状态之前没有出现过
                        queue.offer(newState); // 将新状态加入队列
                        parentMap.put(newState, current); // 记录新状态的父状态
                    }
                }
            }
        }

        return null; // 如果队列为空仍然没有找到解，则返回null
    }

    private static boolean isGoalState(int[][] state) {
        return Arrays.deepEquals(state, GOAL_STATE); // 检查当前状态是否是目标状态
    }

    private static int[] findEmptyPosition(int[][] state) {
        int[] position = new int[2];

        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++) {
                if (state[i][j] == 0) { // 找到空格位置
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        }
        return position;
    }

    private static boolean isValidMove(int x, int y) {
        return x >= 0 && x < 3 && y >= 0 && y < 3; // 检查移动是否合法，即是否在网格范围内
    }

    private static int[][] swap(int[][] state, int x1, int y1, int x2, int y2) {
        int[][] newState = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newState[i][j] = state[i][j]; // 复制当前状态
            }
        }
        int temp = newState[x1][y1]; // 交换空格和相邻数字的位置
        newState[x1][y1] = newState[x2][y2];
        newState[x2][y2] = temp;
        return newState;
    }

    private static List<int[][]> reconstructPath(int[][] goalState, Map<int[][], int[][]> parentMap) {
        List<int[][]> path = new ArrayList<>();
        int[][] current = goalState;

        while (current != null) { // 从目标状态回溯到初始状态，重构路径
            path.add(0, current); // 将当前状态添加到路径的开头
            current = parentMap.get(current); // 获取当前状态的父状态
        }

        return path; // 返回重构的路径
    }

    private static void printPuzzle(int[][] state) {
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++) {
                System.out.print(state[i][j] + " "); // 打印当前状态的网格
            }
            System.out.println();
        }
    }
}
