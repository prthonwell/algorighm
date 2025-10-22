package leetCode.from201to300;

public class GetHint {
    public String getHint(String secret, String guess) {
        int[] spec = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            spec[secret.charAt(i) - '0']++;
        }
        int B = 0;
        for (int i = 0; i < guess.length(); i++) {
            int index = guess.charAt(i) - '0';
            if (spec[index] > 0) {
                spec[index]--;
                B++;
            }
        }
        int A = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
                B--;
            }
        }
        return A + "A" + B + "B";
    }

    public static void main(String[] args) {
        GetHint h = new GetHint();
        System.out.println(h.getHint("1807", "0817"));
    }
}
