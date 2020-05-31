package com.liujx.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze {

    private List<Integer> result = new ArrayList<>();

    public int[][] createGraph(int size){
        int [][] maze = new int[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (i == 0 || j == 0 || i == (size - 1) || j == (size - 1)){
                    maze[i][j] = 1;
                }else{
                    maze[i][j] = 0;
                }
            }
        }
        return maze;
    }

    public boolean go(int[][] map, int i, int j){
        int length = map.length;
        if (map[length - 2][length - 2] == 2){
            return true;
        }else if (map[i][j] == 0){
            map[i][j] = 2;
            for (int[] g : map){
                System.out.println(Arrays.toString(g));
            }
            System.out.println();
            System.out.println();
            // 策略：下 -> 右 -> 上 -> 左
            if (go(map, i + 1, j)){
                return true;
            }else if (go(map, i, j + 1) ){
                return true;
            }else if (go(map, i, j - 1)){
                return true;
            }else if (go(map, i - 1, j)){
                return true;
            }else{
                map[i][j] = 3;
                return false;
            }
        }else{
            return false;
        }
    }



    public static void main(String[] args) {
        Maze maze = new Maze();
        int[][] graph = maze.createGraph(10);
        graph[3][1] = 1;
        graph[3][2] = 1;
        graph[3][3] = 1;
        graph[3][4] = 1;
        graph[4][4] = 1;
        graph[5][4] = 1;
        graph[7][4] = 1;
        graph[7][3] = 1;
        graph[7][5] = 1;
        graph[7][6] = 1;
        graph[7][7] = 1;
        graph[7][8] = 1;
        graph[7][9] = 1;
        for (int[] g : graph){
            System.out.println(Arrays.toString(g));
        }


        if (maze.go(graph, 1, 1)){
            System.out.println("走出来了");
        }else{
            System.out.println("死循环");
        }

        for (int[] g : graph){
            System.out.println(Arrays.toString(g));
        }

    }
}
