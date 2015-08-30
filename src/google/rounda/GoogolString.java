package google.rounda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class GoogolString {
    static String input = "A-large.in";
    static String output = "output.txt";
    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        File file = new File(input);
        BufferedReader reader = null;
        File outfile = new File(output);
        BufferedWriter writer = null;
        
        reader = new BufferedReader(new FileReader(file));
        writer = new BufferedWriter(new FileWriter(outfile));
        int caseNum = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < caseNum; i++) {
            BigInteger k = new BigInteger(reader.readLine());
            BigInteger sn = new BigInteger("0");
            for (int j = 0; ; j++) {
                if (sn.compareTo(k) >= 0) {
                    break;
                }
                else {
                    sn = sn.add(sn).add(new BigInteger("1"));
                }
            }
            
            int num = 0;
            BigInteger middle = sn.add(new BigInteger("1")).divide(new BigInteger("2"));
            while (!k.equals(middle) && !middle.equals(new BigInteger("0"))) {
                k = middle.subtract(k.subtract(middle));
                while (middle.compareTo(k) > 0) {
                    middle = middle.divide(new BigInteger("2"));
                }
                num++;
            }
            int cost = num % 2 == 0 ? 0 : 1;
            StringBuffer result = new StringBuffer("Case #");
            result.append(i+1);
            result.append(": " + cost);
            writer.write(result.toString());
            writer.newLine();
        }
        try {
            writer.flush();
            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
