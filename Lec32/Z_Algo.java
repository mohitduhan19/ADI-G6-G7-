package Lec32;

public class Z_Algo {
    public static ArrayList<Integer> search(String pattern, String text)
    {

        String concat = pattern + "$" + text;
        ArrayList<Integer> res = new ArrayList<Integer> ();
        int l = concat.length();

        int Z[] = new int[l];

        // Construct Z array
        getZarr(concat, Z);

        for(int i = 0; i < l; ++i){

            if(Z[i] == pattern.length()){
                res.add(i - pattern.length());
            }
        }
        return res;
    }

    private static void getZarr(String str, int[] Z) {

        int n = str.length();

        // [L,R] make a window which matches with
        // prefix of s
        int L = 0, R = 0;

        for(int i = 1; i < n; ++i) {

            // if i>R nothing matches so we will calculate.
            // Z[i] using naive way.
            if(i > R){

                L = R = i;
                while(R < n && str.charAt(R - L) == str.charAt(R))
                    R++;

                Z[i] = R - L;
                R--;

            }
            else{
                int k = i - L;

                // if Z[k] is less than remaining interval
                // then Z[i] will be equal to Z[k].
                // For example, str = "ababab", i = 3, R = 5
                // and L = 2
                if(Z[k] < R - i + 1)
                    Z[i] = Z[k];
                else{
                    L = i;
                    while(R < n && str.charAt(R - L) == str.charAt(R))
                        R++;

                    Z[i] = R - L;
                    R--;
                }
            }
        }
    }
}
