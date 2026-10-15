class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones) maxHeap.add(i);
        
        while(!maxHeap.isEmpty()){
            int firstStone = maxHeap.poll();
            int secondStone;
            if(!maxHeap.isEmpty()) secondStone = maxHeap.poll();
            else return firstStone;
            if(firstStone != secondStone) maxHeap.add(firstStone - secondStone);
        }
        return (maxHeap.isEmpty()) ? 0 : maxHeap.poll();
    }
}
