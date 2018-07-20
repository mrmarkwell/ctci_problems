import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 8.1 Triple Step
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 */
class TripleStep {

    // Complexity O(branches ^ depth)
    // Max depth is number of steps
    // Branches is 3
    // Therefore -> O(3^n)
    public int countWaysToHopSteps(int num_steps) {
        if (num_steps < 1) return 0;
        List<Integer> steps = new ArrayList<>(num_steps + 1);
        for (int i = 0; i <= num_steps; i++) {
            steps.add(0);
        }
        _visitStep(1, steps);
        _visitStep(2, steps);
        _visitStep(3, steps);

        System.out.println(steps);
        return steps.get(num_steps);
    }

    private void _visitStep(int step, List<Integer> steps) {
        if (step >= steps.size()) return;
        steps.set(step, steps.get(step) + 1);
        _visitStep(step + 1, steps);
        _visitStep(step + 2, steps);
        _visitStep(step + 3, steps);

    }

    List<BigInteger> steps = new ArrayList(Arrays.asList(
            BigInteger.ZERO,
            BigInteger.ONE,
            BigInteger.TWO,
            BigInteger.valueOf(4)));


    // Complexity: O(n) worst case
    // O(1) amortized average case
    // Using smartness:
    public BigInteger countWaysToHopStepsSmartly(int num_steps) {
        if (num_steps < 1) return BigInteger.valueOf(0);
        if (steps.size() >= num_steps) return steps.get(num_steps);
        int cur = steps.size();
        while (cur <= num_steps) {
            steps.add(steps.get(cur - 1).add(steps.get(cur - 2).add(steps.get(cur - 3))));
            cur++;
        }
        return steps.get(num_steps);
    }

    public static void main(String[] args) {
        TripleStep sut = new TripleStep();

        int result = sut.countWaysToHopSteps(10);
        System.out.println(result);
        result = sut.countWaysToHopSteps(20);
        System.out.println(result);
        result = sut.countWaysToHopSteps(30);
        System.out.println(result);
        //result = sut.countWaysToHopSteps(40);
        //System.out.println(result);

        BigInteger big_result;
        big_result = sut.countWaysToHopStepsSmartly(10);
        System.out.println(big_result);
        big_result = sut.countWaysToHopStepsSmartly(20);
        System.out.println(big_result);
        big_result = sut.countWaysToHopStepsSmartly(30);
        System.out.println(big_result);

        big_result = sut.countWaysToHopStepsSmartly(100);
        System.out.println(big_result);
        big_result = sut.countWaysToHopStepsSmartly(200);
        System.out.println(big_result);
        big_result = sut.countWaysToHopStepsSmartly(300);
        System.out.println(big_result);
        big_result = sut.countWaysToHopStepsSmartly(1000);
        System.out.println(big_result);
        big_result = sut.countWaysToHopStepsSmartly(2000);
        System.out.println(big_result);
        big_result = sut.countWaysToHopStepsSmartly(3000);
        System.out.println(big_result);
//        result = sut.countWaysToHopSteps(40);
//        System.out.println(result);
    }

}

