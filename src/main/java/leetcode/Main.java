package leetcode;


import leetcode.cn.LD.UnionFind;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = Integer.parseInt(sc.nextLine());
        int col = Integer.parseInt(sc.nextLine());
        UnionFind unionFind = new UnionFind(row +col);
        String line;
        List<String[]> res = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            line = sc.nextLine();
            String[] s = line.split(" ");
            res.add(s);
        }
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < col; j++) {
                if(Integer.parseInt(res.get(i)[j]) == 1){
                    unionFind.unionEle(i,j);
                }
            }
        }
        System.out.println(unionFind.getCount());

    }
}
