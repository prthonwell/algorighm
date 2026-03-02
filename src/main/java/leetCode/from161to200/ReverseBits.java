package leetCode.from161to200;

class ReverseBits {
    public int reverseBits(int n) {
        int rev = 0;
        for(int i = 0;i <32&&n!=0;i++){
            rev|=(n&1)<<(31-i);
            n >>>=1;
        }
        return rev;
    }

    public static void main(String[] args) {
        int n = 43261596;
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverseBits(n));
    }
}