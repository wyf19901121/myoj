package leetcode;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0, begin = 0, end = 0, n = 0;
        if (gas == null) {
            return -1;
        }
        int count = gas.length;
        int gasinCar = 0;
        while (n < count - 1) {
            gasinCar += gas[i] - cost[i];
            if (gasinCar >= 0) {
                end++;
                i = end;
            }
            else {
                begin--;
                if (begin < 0) {
                    begin = count - 1;
                }
                i = begin;
            }
            n++;
        }
        
        gasinCar += gas[i] - cost[i];
        
        if (gasinCar >= 0) {
            return begin;
        }
        return -1;
    }
}
