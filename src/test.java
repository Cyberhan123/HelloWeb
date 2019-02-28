public class test {

    static int[] v = new int[10];
    static int[][] s = new int[4][4];
    static int sum = 0;

    public static void main(String[] args) {
        s[0][0] = 0;
        s(1);
        System.out.println(sum);
    }

    private static void s(int code) {
        if (code == 10) {
            sum++;
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (v[i] != 0) continue;
            else {
                int a = 0, b = 0;
                switch (code) {
                    case 1:
                        a = 1;
                        b = 0;
                        break;
                    case 2:
                        a = 1;
                        b = 1;
                        break;
                    case 3:
                        a = 2;
                        b = 0;
                        break;
                    case 4:
                        a = 2;
                        b = 1;
                        break;
                    case 5:
                        a = 2;
                        b = 2;
                        break;
                    case 6:
                        a = 3;
                        b = 0;
                        break;
                    case 7:
                        a = 3;
                        b = 1;
                        break;
                    case 8:
                        a = 3;
                        b = 2;
                        break;
                    case 9:
                        a = 3;
                        b = 3;
                        break;
                }
                s[a][b] = i;
                if (s[a][b] < s[a - 1][b]) {
                    continue;
                }
                if (b - 1 >= 0) {
                    if (s[a][b] < s[a - 1][b - 1]) {
                        continue;
                    }
                }
            }
            v[i] = 1;
            s(code + 1);
            v[i] = 0;
        }
    }


}
