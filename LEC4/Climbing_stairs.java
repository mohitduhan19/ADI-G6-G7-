package LEC4;

public class Climbing_stairs {
    public int climbStairs(int n) {
        if(n <= 1)return 1;

        int oneJump = climbStairs(n-1);
        int twoJump = climbStairs(n-2);

        return oneJump + twoJump;
    }
}
