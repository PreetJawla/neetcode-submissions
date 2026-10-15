class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        // Count frequency of each card
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int card : hand) {
            freqMap.put(card, freqMap.getOrDefault(card, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(freqMap.keySet());

        while (!minHeap.isEmpty()) {
            int start = minHeap.peek();
            for (int i = 0; i < groupSize; i++) {
                int card = start + i;
                if (!freqMap.containsKey(card)) return false;

                freqMap.put(card, freqMap.get(card) - 1);

                if (freqMap.get(card) == 0) {
                    freqMap.remove(card);
                    if (card != minHeap.peek()) return false;
                    minHeap.poll();
                }
            }
        }

        return true;
    }
}
