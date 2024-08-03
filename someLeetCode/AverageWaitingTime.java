package someLeetCode;

public class AverageWaitingTime {
    public static double averageWaitingTime(int[][] customers) {

        double totalWaiting = 0;
        int whenMealFinishes = 0;

        for (int[] customer : customers) {
            int currTime = customer[0];

            if (whenMealFinishes < currTime) whenMealFinishes = currTime;

            if (currTime >= whenMealFinishes) totalWaiting += customer[1];
            else totalWaiting += customer[1] + (whenMealFinishes - currTime);

            whenMealFinishes += customer[1];
        }

        return totalWaiting / customers.length;
    }

    public static void main(String[] args) {
        System.out.println(averageWaitingTime(new int[][]{{1, 2}, {2, 5}, {4, 3}}));
        System.out.println(averageWaitingTime(new int[][]{{1, 496}, {2, 8112}}));
    }
}
