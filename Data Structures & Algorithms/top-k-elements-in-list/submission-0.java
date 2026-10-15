// class Solution {
//     public int[] topKFrequent(int[] nums, int k){
//         Map<Integer, Integer> frequencyMap = new HashMap<>();
//         for(int i : nums){
//             frequencyMap.put(i , frequencyMap.getOrDefault(i, 0)+1);
//         }
//         List<Integer>[] bucket = new ArrayList[nums.length + 1];

//         for(int key : frequencyMap.keySet()){
//             int value = frequencyMap.get(key);
//             if(bucket[value] == null){
//                 bucket[value] = new ArrayList<>();
//                 bucket[value].add(key);
//             }else{
//                 bucket[value].add(key);
//             }
//         }
//         int rem = 0;
//         int[] returnArray = new int[nums.length];
//         for(int i = nums.length-1; i>= 0 && k != 0 ; i--){
//             if(bucket[i] != null){
//                 for(int value: bucket[i]){
//                     returnArray[rem] = value;
//                     rem++;
//                 }
//                 k--;
//             }
//         }
//         return returnArray;

//     }
// }


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        
        @SuppressWarnings("unchecked")
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int key : frequencyMap.keySet()) {
            int freq = frequencyMap.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        
        int[] result = new int[k];
        int count = 0;
        
        for (int i = bucket.length - 1; i >= 0 && count < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    if (count < k) {
                        result[count++] = num;
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }
}

