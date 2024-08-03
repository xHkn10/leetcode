package someLeetCode;

public class AirplaneSeatAssignmentProbability {

    static public double nthPersonGetsNthSeat(int n) {
        if (n == 1) return 1;
        return (1D / n) + ((1 - 2 * (1D / n)) * nthPersonGetsNthSeat(n - 1));
    }

    public static void main(String[] args) {
        System.out.println(nthPersonGetsNthSeat(10));
    }
}
