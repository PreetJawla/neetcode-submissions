class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        return binarySearch(piles, maxPile, h);
    }

    public int binarySearch(int[] piles, int maxPile, int h) {
        int result = maxPile;
        int minPile = 1;

        while (minPile <= maxPile) {
            int mid = minPile + (maxPile - minPile) / 2;
            if (checkHs(piles, mid, h)) {
                result = mid;
                maxPile = mid - 1;
            } else {
                minPile = mid + 1;
            }
        }

        return result;
    }

    public boolean checkHs(int[] piles, int speed, int h) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + speed - 1) / speed; // ceil(pile / speed)
        }
        return time <= h;
    }
}
