package leetCode.from121to140;

class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int Extra = 0;
        int[] candies = new int[n];
        candies[0] = 1;
        int highpoint = -1;
        int decPos = -1;
        int decLength = -1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
                highpoint = -1;
            } else if (ratings[i] < ratings[i - 1]) {
                candies[i] = 1;
                if (highpoint == -1) {
                    highpoint = candies[i - 1];
                    decPos = i - 1;
                    decLength = 1;
                } else {
                    decLength++;
                }
                Extra += (i - decPos - 1) + (decLength >= highpoint ? 1 : 0);
            } else {
                candies[i] = 1;
                highpoint = -1;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += candies[i];
        }
        return sum + Extra;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        System.out.println(candy.candy(new int[]{1,2,87,87,87,2,1}));
    }
}