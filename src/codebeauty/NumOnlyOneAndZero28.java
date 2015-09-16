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
        
        //i�����iΪ����0��ʼ; j ���� 10��i�η�%n��ֵ
        int noUpdate = 0;//����û�и��µĴ������������n����û�н�
        for (int i = 1, j = 10 % n; ; i++, j = (j * 10) % n) {
            boolean updated = false;
            //���j��Ӧ��λ��Ϊ�գ���10��i�η�֮ǰû����%n��ֵΪj�������
            if (res.get(j).size() == 0) {
                res.get(j).add(i);
            }
            for (int k = 0; k < n; k++) {
                //����ȫ��������Ϣ����,�������k���յ�����(k + j) % nΪ�գ�����10��i�η���������k����Ӧ������������(k + j) % n��Ӧ��ֵ
                //ͬi���ܴ�������k���λ����ֹ�������j��ͬ��(k == j)
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
