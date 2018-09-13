package Array.Easy;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        int[] a = {1, 0, 0, 0, 0, 1};
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        canPlaceFlowers.canPlaceFlowers(a, 2);
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else {
                if (i > 0 && i < flowerbed.length - 1) {
                    if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                        n -= 1;
                        i += 2;
                    } else i += 1;
                } else {
                    if (i == 0 && (i + 1 >= flowerbed.length || flowerbed[i + 1] == 0)) {
                        n -= 1;
                        i += 2;
                    } else if (i == flowerbed.length - 1 && (i - 1 < 0 || flowerbed[i - 1] == 0)) {
                        n -= 1;
                        i += 2;
                    } else i += 1;
                }
            }
        }
        return n <= 0;
    }

}
