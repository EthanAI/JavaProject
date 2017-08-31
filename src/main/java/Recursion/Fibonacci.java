package Recursion;

/**
 * Created by ethansmith on 8/30/17.
 */

/*
    Dynamic programming is different from recursion
    Fibanacci is a terrible use case for recursion, but dynamic programming works great
    recursion will repeat many many caluclations
    how many = ?
 */
public class Fibonacci {
    // This is terribel
    public static int recursiveFib(int num) {
        if(num <= 1)
            return num;
        else
            return recursiveFib(num - 1) + recursiveFib(num - 2);
    }

    // Caching to turn 'recursion' into dynamic programming
    private static int[] cacheInt = new int[10000]; // Thats ugly
    public static int dynamicFib(int num) {
        if(num <= 1)    // Base case forces filling in the first few entries (Unique to fib)
            return num;
        else if(cacheInt[num] != 0)  // For 2 -> On. Check if value exists in cache. If so use it
            return cacheInt[num];    // guess int[] initializes at 0
        else {  // If no cache value exists, compute it from the previous two. In leading edge case, one will be cached, the other will not
            cacheInt[num] = dynamicFib(num - 2) + dynamicFib(num - 1); // Case 2: d(0) & d(1) are already knowm. d(2) written to cache
            return cacheInt[num];                                      // Case 3: d(1) & d(2) are already known. d(3) written to cache
        }
    }

    public static void iterativeFib(int num) {
        int a = 0;
        int b = 1;

        for(int i = 1; i <= num; i++) {
            System.out.println(b);

            int temp = a + b;
            a = b;
            b = temp;
        }
    }

    // Stores all values. Maybe we need that sometimes?
    public static int fibArray(int n)
    {
        int f[] = new int[n + 1]; // room for zero as well

        // Initalize starting values
        f[0] = 0;
        f[1] = 1;

        // Skip to finding #2
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 2] + f[i - 1];
        }

        return f[n];
    }
}
