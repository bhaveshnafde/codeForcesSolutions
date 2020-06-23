import java.io.*;
import java.util.*;

public class B{

    public static StringBuilder solution(String st){
        StringBuilder str = new StringBuilder(st);
        while(true){
          boolean isTrue = true;
          for(int i = 0; i < str.length() - 1; i++){
            if(str.charAt(i) == '1' && str.charAt(i+1) == '0'){
                if(i+2 < str.length() && str.charAt(i+2) == '0'){
                  if(i-1 >= 0 && str.charAt(i-1) == '1'){//1100
                    str.delete(i+1,i+2);
                  }else{//0100
                    str.delete(i+1,i+2);
                  }
                }else{
                  if(i-1 >= 0 && str.charAt(i-1) == '1'){ //1101
                    str.delete(i,i+1);
                  }else{
                    str.delete(i,i+1);
                  }
                }
              isTrue = false;
            }
          }
          if(isTrue){
            return str;
          }
        }
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            String st = in.nextLine();
            StringBuilder ans = solution(st);
            w.println(ans);
        }

        w.close();
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
