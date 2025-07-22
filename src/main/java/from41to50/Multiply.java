package from41to50;

class Multiply {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String ans = "";
        int n = num1.length();
        int m = num2.length();
        for (int i = m - 1; i >= 0; i--) {
            char c2 = num2.charAt(i);
            int c2i = c2 - '0';
            int add = 0;
            StringBuffer sb = new StringBuffer();
            int times = m - 1 - i;
            while (times-- > 0) {
                sb.append('0');
            }
            for (int j = n - 1; j >= 0; j--) {
                char c1 = num1.charAt(j);
                int c1i = c1 - '0';
                int sum = c1i * c2i + add;
                add = sum / 10;
                sb.append(sum % 10);
            }
            if (add > 0) {
                sb.append(add);
            }
            ans = addAndString(ans, sb.reverse().toString());
        }
        return ans;
    }
    public String addAndString(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        if (n < m) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        n = num1.length();
        m = num2.length();
        StringBuffer sb = new StringBuffer();
        int times = n - m;
        while (times-- > 0) {
            sb.append('0');
        }
        num2 = sb.append(num2).toString();
        sb = new StringBuffer();
        int add = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c1 = num1.charAt(i);
            char c2 = num2.charAt(i);
            int sum = c1 - '0' + c2 - '0' + add;
            add = sum / 10;
            sb.append(sum % 10);
        }
        if (add > 0) {
            sb.append(add);
        }
        return sb.reverse().toString();
    }
}