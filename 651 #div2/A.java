import java.io.*;
import java.util.*;

public class A{

    public static int maxGCD(int arr[], int n){
            int high = 0;
            for (int i = 0; i < n; i++)
                high = Math.max(high, arr[i]);

            // Maintaining count array
            int count[]=new int[high + 1];
            for (int i = 0; i < n; i++)
                count[arr[i]]++;

            // Variable to store
            // the multiples of
            // a number
            int counter = 0;

            // Iterating from MAX
            // to 1 GCD is always
            // between MAX and 1
            // The first GCD found
            // will be the highest
            // as we are decrementing
            // the potential GCD
            for (int i = high; i >= 1; i--)
            {
                int j = i;

                // Iterating from current
                // potential GCD till it
                // is less than MAX
                while (j <= high)
                {
                    // A multiple found
                    if (count[j]>0)
                        counter+=count[j];

                    // Incrementing potential
                    // GCD by itself
                    // To check i, 2i, 3i....
                    j += i;

                    // 2 multiples found,
                    // max GCD found
                    if (counter == 2)
                        return i;
                }
                counter=0;
            }
        return 1;
    }

    public static void main(String[] args) {
      try{
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++){
              arr[i] = i+1;
            }
            int ans = maxGCD(arr, n);
            w.println(ans);
        }

        w.close();
      }catch(Exception E){
        System.out.println(E);
      }
    }

    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}
