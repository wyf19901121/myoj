package codebeauty;

import java.util.ArrayList;
import java.util.List;

public class BuyBook14 {
    private double price = 8.00;
    private int[] books = {1, 1, 1, 1, 1};
    private double[] discout = {0, 1.00, 0.95, 0.90, 0.80, 0.75};
    
    public double solution() {
        if (books[0] == 0 && books[1] == 0 && books[2] == 0
                && books[3] == 0 && books[4] == 0) {
            return 0.00;
        }
        List<Double> curPrice = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != 0) {
                books[i]--;
                curPrice.add(count++*price*discout[count-1] + solution());
            }
        }
        double min = Double.MAX_VALUE;
        for (int i = 0; i < curPrice.size(); i++) {
            if (curPrice.get(i) < min) {
                min = curPrice.get(i);
            }
        }
        return min;
    }
    
    public static void main(String[] args) {
        System.out.println(new BuyBook14().solution());
    }

}
