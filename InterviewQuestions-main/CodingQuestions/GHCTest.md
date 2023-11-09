## 1. 
For a number X, let its "Coolness” be defined as the number of "101 "s occurring in its binary representation. For example, the number 21 has Coolness 2, since Its binary representation is 10101, and the string "101" occurs twice in this representation.

A number is defined as Very Cool If its Coolness is greater than or equal to K. Please, output the number of Very Cool Integers between 1 and R.

Input: Two space-separated integers, R and K

Output:
Print Single integer representing the number of Very Cool integers between 1 and R.

Sample input1: 21 2
Sample Output1: 1

Sample input2: 102 1
Sample output2: 48

```java
import java.util.Scanner;

public class VeryCoolIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.close();

        int count = 0;
        for (int i = 1; i <= R; i++) {
            if (coolness(i) >= K) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static int coolness(int number) {
        String binary = Integer.toBinaryString(number);
        int count = 0;
        int index = 0;

        while (index != -1) {
            index = binary.indexOf("101", index);
            if (index != -1) {
                count++;
                index += 2; // Move to check for the next occurrence
            }
        }

        return count;
    }
}
```

---

## 2
The 'Miscria Champions League' (MCL) is coming soon, and its preparations have already started. ThunderCracker Is busy practicing with his team, when suddenty he thinks of an interesting problem.

ThunderCracker 's team consists of 'N' players (including himself). All the players stand in a straight line (numbered from 1 to N), and pass the ball to each other. The maximum power with which any player can hit the ball on the i'th pass is given by an array A(i). This means that if a player at position 'j' (1<=j<=N) has the ball at the time of the i'th pass, he can pass it to any player with a position from (j-A(i)) to (j-1), or from (j+1) to (j+A(i)) (provided that the position exists).

Now, ThunderCracker wants to find out the number of ways in which, after exactly M passes, the ball reaches his friend MunKee, given that the first pass is made by ThunderCracker. (Two ways are considered different if there exists atleast one pass which resulted in the ball being passed to a different player.)

Input:
The first line of the input consists of 4 space separated integers - N (denoting the number of players), M (denoting the number of passes), and X and Y, denoting ThunderCracker's and MunKee's numbers respectively.
The next line contains M space separated integers, denoting array A, the power with which passes can be made in the i'th pass (1<=i<=M).

Output:
A single integer, that is the number of ways in which the ball can be passed such that the first pass is made by ThunderCracker, and the ball reaches MunKee after M passes. As the answer can be very large, output it modulo 1000000007.

Constraints:
2 <=N <= 2000
1 <= M <= 2000
1  <= A(i) <= 1000
1 <= X, Y <= N

It is guaranteed that X and Y are distinct integers.

Sample input: 
3 3 2 1
1 1 1

Sample Output:
2

```java
import java.util.*;

public class MCLBallPassOptimized {
    static final int MOD = 1000000007;

    public static int countBallPassWays(int N, int M, int X, int Y, int[] A) {
        int[] dp = new int[N + 1];
        dp[X] = 1;

        for (int passes = 1; passes <= M; passes++) {
            int[] newDp = new int[N + 1];
            for (int position = 1; position <= N; position++) {
                for (int power = 1; power <= A[passes - 1]; power++) {
                    int leftPos = position - power;
                    int rightPos = position + power;

                    if (leftPos >= 1) {
                        newDp[position] = (newDp[position] + dp[leftPos]) % MOD;
                    }

                    if (rightPos <= N) {
                        newDp[position] = (newDp[position] + dp[rightPos]) % MOD;
                    }
                }
            }
            dp = newDp;
        }

        return dp[Y];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int[] A = new int[M];
        for (int i = 0; i < M; i++) {
            A[i] = scanner.nextInt();
        }
        scanner.close();

        int result = countBallPassWays(N, M, X, Y, A);
        System.out.println(result);
    }
}
```
