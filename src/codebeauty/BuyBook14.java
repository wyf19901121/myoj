package codebeauty;

public class BuyBook14 {
    private double price = 8.00;
    private int[] books = {1, 1, 1, 1, 1};
    private double[] discout = {0, 1.00, 0.95, 0.90, 0.80, 0.75};
    
    public double solution() {
        double[][][][][] res = new double[books[0]+1][books[1]+1][books[2]+1][books[3]+1][books[4]+1];
        res[0][0][0][0][0] = 0.00;
        for (int i = 0; i < 5; i++) {
            for (int j = 1; j <= books[i]; j++) {
                switch (i) {
                case 0:
                    res[j][0][0][0][0] = price + res[j-1][0][0][0][0];
                    break;
                case 1:
                    res[books[0]][j][0][0][0] = Math.min(price + res[books[0]][j-1][0][0][0], price * 2 * discout[2] + res[books[0]-1][j-1][0][0][0]);
                    break;
                case 2:
                    res[books[0]][books[1]][j][0][0] = Math.min(Math.min(price + res[books[0]][books[1]][j-1][0][0], 
                            price * 2 * discout[2] + res[books[0]][books[1]-1][j-1][0][0]),
                            price * 3 * discout[3] + res[books[0]-1][books[1]-1][j-1][0][0]);
                    break;
                case 3:
                    res[books[0]][books[1]][books[2]][j][0] = Math.min(Math.min(Math.min(price + res[books[0]][books[1]][books[2]][j-1][0], 
                            price * 2 * discout[2] + res[books[0]][books[1]][books[2]-1][j-1][0]),
                            price * 3 * discout[3] + res[books[0]][books[1]-1][books[2]-1][j-1][0]), 
                            price * 4 * discout[4] + res[books[0]-1][books[1]-1][books[2]-1][j-1][0]);
                    break;
                case 4:
                    res[books[0]][books[1]][books[2]][books[3]][j] = Math.min(Math.min(Math.min(Math.min(price + res[books[0]][books[1]][books[2]][books[3]][j-1], 
                            price * 2 * discout[2] + res[books[0]][books[1]][books[2]][books[3]-1][j-1]), 
                            price * 3 * discout[3] + res[books[0]][books[1]][books[2]-1][books[3]-1][j-1]), 
                            price * 4 * discout[4] + res[books[0]][books[1]-1][books[2]-1][books[3]-1][j-1]), 
                            price * 5 * discout[5] + res[books[0]-1][books[1]-1][books[2]-1][books[3]-1][j-1]);
                    break;
                default:
                    break;
                }
            }
        }
        return res[books[0]][books[1]][books[2]][books[3]][books[4]];
    }
    
    public static void main(String[] args) {
        System.out.println(new BuyBook14().solution());
    }

}
