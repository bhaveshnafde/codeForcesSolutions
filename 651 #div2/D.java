import java.io.*;
import java.util.*;

public class D{

    static void printArray(int arr[], int size)
    {
        for (int i = 0; i < size; i++)
        {
            System.out.printf("%d ", arr[i]);
        }
        System.out.printf("\n");
        return;
    }

    /* This function returns 0 if there are
    no more sequences to be printed, otherwise
    modifies arr[] so that arr[] contains
    next sequence to be printed */
    static int getSuccessor(int arr[], int k, int n)
    {
        /* start from the rightmost side and
        find the first number less than n */
        int p = k - 1;
        while (arr[p] == n)
        {
            p--;
            if (p < 0)
            {
                break;
            }
        }

        /* If all numbers are n in the array
        then there is no successor, return 0 */
        if (p < 0)
        {
            return 0;
        }

        /* Update arr[] so that it contains successor */
        arr[p] = arr[p] + 1;
        for (int i = p + 1; i < k; i++)
        {
            arr[i] = 1;
        }
        return 1;
    }

    /* The main function that prints all
    sequences from 1, 1, ..1 to n, n, ..n */
    static void minSS(int arr[], int n, int k)
    {
        int[] ss = new int[k];

        /* Initialize the current sequence as
        the first sequence to be printed */
        for (int i = 0; i < k; i++)
        {
            ss[i] = arr[i];
        }

        /* The loop breaks when there are
        no more successors to be printed */
        while (true)
        {
            /* Print the current sequence */
            printArray(ss, k);

            /* Update arr[] so that it contains
            next sequence to be printed. And if
            there are no more sequences then
            break the loop */
            if (getSuccessor(ss, k, n) == 0)
            {
                break;
            }
        }
    }

    public static void main(String[] args) {
      try{
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        int n = in.nextInt();
        int k = in.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
          arr[i] = in.nextInt();
        }
        minSS(arr, n, k);


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
