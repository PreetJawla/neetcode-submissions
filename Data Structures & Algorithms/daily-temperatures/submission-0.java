// class Solution {
//     public int[] dailyTemperatures(int[] temp) {
//         int[] newArray = new int[temp.length ];
//         Stack<Integer> value = new Stack<>(); 
//         value.push(temp.length-1);
//         for(int i = temp.length-1; i >= 0 ; i--){
//             if(value.empty()){
//                 value.push(i);
//             }
//             if(temp[i] < temp[value.peek()]){
//                 newArray[i] = value.peek() - i;
//                 value.push(i);
//                 continue;
//             }else{
//                 while(!value.empty() && temp[value.peek()] < temp[i]){
//                     value.pop();
//                 }
//                 if(!value.empty() && temp[i] < temp[value.peek()]){
//                     newArray[i] = value.peek() - i;
//                     value.push(i);
//                 }
//             }
//         }
//         return newArray;
//     }
// }
class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] newArray = new int[temp.length];
        Stack<Integer> value = new Stack<>();
        for (int i = temp.length - 1; i >= 0; i--) {
            while (!value.isEmpty() && temp[value.peek()] <= temp[i]) {
                value.pop();
            }
            if (!value.isEmpty()) {
                newArray[i] = value.peek() - i;
            }
            value.push(i);
        }
        return newArray;
    }
}

