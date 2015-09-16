package codebeauty;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumOnlyOneAndZero28 {
    public List<Integer> getRes(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }
        if (n == 1) {
            res.get(0).add(0);
            return res.get(0);
        }

        res.get(1).add(0);//1%n == 1
        
        //i代表第i为，从0开始; j 代表 10的i次方%n的值
        int noUpdate = 0;//连续没有更新的次数，如果到达n次则没有解
        for (int i = 1, j = 10 % n; ; i++, j = (j * 10) % n) {
            boolean updated = false;
            //如果j对应的位置为空，即10的i次方之前没有数%n的值为j，则更新
            if (res.get(j).size() == 0) {
                res.get(j).add(i);
            }
            for (int k = 0; k < n; k++) {
                //遍历全部余数信息数组,如果余数k不空但余数(k + j) % n为空，则用10的i次方加上余数k所对应的数来做余数(k + j) % n对应的值
                //同i不能大于余数k最高位，防止与上面的j相同即(k == j)
                if (!res.get(k).isEmpty() && res.get((k + j) % n).isEmpty()
                        && i > res.get(k).get(res.get(k).size() - 1)) {
                    updated = true;
                    noUpdate = 0;
                    for (Integer integer : res.get(k)) {
                        res.get((k + j) % n).add(integer);
                    }
                    res.get((k + j) % n).add(i);
                }
            }
            if (updated == false) {
                noUpdate++;
            }
            if (noUpdate == n || !res.get(0).isEmpty()) {
                break;
            }
        }
        if (!res.get(0).isEmpty()) {
            return res.get(0);
        }
        return null;
    }
    
    public static void main(String[] args) {
        int n;
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()) {
            n = cin.nextInt();
            List<Integer> res = new NumOnlyOneAndZero28().getRes(n);
            for (Integer integer : res) {
                System.out.print(integer + " ");
            }
        }
    }
}
