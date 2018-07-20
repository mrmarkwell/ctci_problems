/**
 * 16.7 Number Max
 * Write a method that finds the maximum of two numbers. You should not use if-else or any other comparison operator.
 *
 */
class FindMax {

    public int findMaximum(int a, int b) {
        int sub = a - b;
        int mask = sub >> 31;
        return (a & ~mask) | (b & mask);
    }

    public static void main(String[] args) {

        FindMax sut = new FindMax();
        System.out.println(sut.findMaximum(10, 22));
        System.out.println(sut.findMaximum(39, 75));
        System.out.println(sut.findMaximum(23124, 98237));
        System.out.println(sut.findMaximum(8925, 987));
        System.out.println(sut.findMaximum(0, -9821735));
        System.out.println(sut.findMaximum(-982374892, -7893472));
    }

}

