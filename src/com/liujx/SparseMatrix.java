package com.liujx;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SparseMatrix {

    public int[][] twoDToSparse(int[][] data){
//        1. 遍历原始二维数组，得到有效的数据的个数
        int count = 1;
        for (int[] da : data){
            for (int d : da){
                count += d > 0 ? 1 : 0;
            }
        }
//        2. 根据sum就可以创建稀疏数组
        int[][] result = new int[count][3];
        result[0][0] = data.length;
        result[0][1] = data[0].length;
        result[0][2] = count;
//        3. 将二维数组的有效数据存入稀疏数组
        int index = 1;
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data[i].length; j++){
                if (data[i][j] > 0){
                    result[index][0] = i;
                    result[index][1] = j;
                    result[index][2] = data[i][j];
                    index++;
                }
            }
        }

        return result;
    }

    public int[][] read(String fileName){
        File file = new File(fileName);
        BufferedReader reader = null;
        FileReader fileReader = null;
        List<String[]> list = new ArrayList<>();
        int[][] result = new int[0][];
        try {
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            reader.lines().forEach(x -> {
                list.add(x.split("\t"));
            });
            String[][] strings = list.toArray(new String[0][0]);
            result = new int[strings.length][strings[0].length];
            for (int i = 0; i < strings.length; i++){
                for (int j = 0; j < strings[i].length; j++){
                    result[i][j] = Integer.parseInt(strings[i][j]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sparseTotwoD(result);

    }

    public int[][] sparseTotwoD(int[][] sparse){
//        1. 读取第一行，创建二维数组
        int row = sparse[0][0];
        int col = sparse[0][1];
        int size = sparse[0][2];
//        2. 再读取后几行，填入数据
        int[][] result = new int[row][col];
        for (int i = 1; i < size; i++){
            result[sparse[i][0]][sparse[i][1]] = sparse[i][2];
        }

        return result;
    }

    public boolean save(int[][] data, String fileName){
        int[][] sparse = twoDToSparse(data);
        File  file = null;
        Writer writer = null;
        try {
             file = new File(fileName);
             writer = new FileWriter(file);
             for (int[] spa : sparse){
                 String line = spa[0] + "\t" + spa[1] + "\t" + spa[2] + "\n";
                 writer.write(line);
             }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SparseMatrix sparseMatrix = new SparseMatrix();
        int[][] data = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0 ,0, 0},
                {0, 0, 0, 2, 0, 0, 0, 0, 0 ,0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0, 0},
        };
        int[][] sparse = sparseMatrix.twoDToSparse(data);
        for (int[] spa : sparse){
            System.out.println(Arrays.toString(spa));
        }

        int[][] result = sparseMatrix.sparseTotwoD(sparse);
        for (int[] tt : result){
            System.out.println(Arrays.toString(tt));
        }
//        System.out.println(sparseMatrix.save(data, "./map.data"));
        int[][] results = sparseMatrix.read("./map.data");
        for (int[] re : results){
            System.out.println(Arrays.toString(re));
        }
    }


}
