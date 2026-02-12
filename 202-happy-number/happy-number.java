// class Solution {
//     public boolean isHappy(int n) {
//         if(n<0) return false;
//         if(n==1) return true;
//         Set<Integer> set = new HashSet<>();
//         while(n != 1){
//             int ans = check(n);
//             if(set.contains(ans)) return false;
//             set.add(ans);
//             n = ans;  
//         }
//         return true;
        
//     }
//     public int check(int n){
//         int sum = 0;
//         while(n > 0){
//             int temp = n % 10;
//             sum += temp * temp;
//             n = n / 10;

//         }
//         return sum;
//     }
// }



class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) return false;

        int slow = n;
        int fast = n;

        do {
            slow = squareSum(slow);                 // move 1 step
            fast = squareSum(squareSum(fast));      // move 2 steps
        } while (slow != fast);

        return slow == 1;
    }

    private int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }
}
