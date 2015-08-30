package google.rounda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class GCube {
    static String input = "B-large.in";
    static String output = "output.txt";
    public static void main(String[] args) throws IOException {
        File file = new File(input);
        BufferedReader reader = null;
        File outfile = new File(output);
        BufferedWriter writer = null;
        
        reader = new BufferedReader(new FileReader(file));
        writer = new BufferedWriter(new FileWriter(outfile));
        int caseNum = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < caseNum; i++) {
            String[] line1 = reader.readLine().split(" ");
            int N = Integer.parseInt(line1[0]);
            int M = Integer.parseInt(line1[1]);
            String[] length = reader.readLine().split(" ");
            int[] lengths = new int [N];
            for (int j = 0; j < N; j++) {
                lengths[j] = Integer.parseInt(length[j]);
            }
            String[] result = new String[M];
            for (int j = 0; j < M; j++) {
                String[] line = reader.readLine().split(" ");
                int left = Integer.parseInt(line[0]);
                int right = Integer.parseInt(line[1]);
                double V = 1.0000000;
                for (int k = left; k <= right; k++) {
                    V *= Math.pow((double)lengths[k], 1.0000000/(double)(right - left + 1)) ;
                }
                String r = String.format("%.7f", V);
                result[j] = r;
            }
            StringBuffer outr = new StringBuffer("Case #");
            outr.append(i+1);
            outr.append(":");
            writer.write(outr.toString());
            writer.newLine();
            for (int j = 0; j < result.length; j++) {
                writer.write(result[j]);
                writer.newLine();
            }
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
