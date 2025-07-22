import java.util.Arrays;

public class NCardsABWin {
    // 谷歌面试题扩展版
    // 面值为1N的牌组成一组，
    // 每次你从组里等概率的抽出1~N中的一张
    // 下次抽会换一个新的组，有无限组
    // 当累加和<ā时，你将一直抽牌
    // 当累加和>=a且<b时，你将获胜
    // 当累加和>=b时，你将失败
    // 返回获胜的概率，给定的参数为N,a,b
    private static Double nCardsABWin(int N, int a, int b) {
        if (b <= a) return 0.0;
        if (b - a > N) return 1.0;
        Double[] DpList = new Double[b];
        Arrays.fill(DpList, a,b,1.0);
        Double sum = (double) (b - a);
        for (int i = a - 1; i >= 0; i--) {
            if (i == a - 1) {
                DpList[i] = sum/N;
            }else if (i + 1 + N >= b) {
                sum = sum + DpList[i + 1];
                DpList[i] = sum/N;
            }else {
                sum = sum + DpList[i + 1] - DpList[i + 1 + N];
                DpList[i] = sum/N;
            }
        }
        return DpList[0];
    }


    public static void main(String[] args) {
        int N = 100;
        int a = 233;
        int b = 255;
        System.out.println(nCardsABWin(N,a,b));
    }
}

