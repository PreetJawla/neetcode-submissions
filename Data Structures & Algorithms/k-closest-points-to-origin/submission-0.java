// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
//         if( k > points.length) return new int[0][0];
//         PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//         HashMap<Integer, int[]> distanceMap = new HashMap<>();

//         for(int i = 0; i< points.length; i++){
//             int distance = (int) Math.sqrt(points[i][0]* points[i][0] + points[i][1]*points[i][1]);
//             distanceMap.put(distance, points[i]);
//             minHeap.add(distance);
//         }

//         while(k > 1) minHeap.poll();
//         int kDistance = minHeap.poll();
//         return distanceMap.get(kDistance);
//     }
// }

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> {
                int distA = a[0]*a[0] + a[1]*a[1];
                int distB = b[0]*b[0] + b[1]*b[1];
                return Integer.compare(distA, distB);
            }
        );

        for (int[] point : points) {
            minHeap.add(point);
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
