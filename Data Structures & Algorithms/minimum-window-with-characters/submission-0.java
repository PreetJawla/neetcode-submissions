// class Solution {
//     public String minWindow(String s, String t) {
//         HashMap<Character, Integer> targetMap = new HashMap<>();
//         HashMap<Character, Integer> mainMap = new HashMap<>();

//         int minLength = 0;

//         for(int i = 0; i < s.length(); i++){
//             char sh = s.charAt(i);
//             mainMap.put(sh, mainMap.getOrDefault(sh, 0)+1);
//         }

//         for(int i = 0; i < t.length(); i++){
//             char ch = t.charAt(i);
//             targetMap.put(ch, targetMap.getOrDefault(ch, 0)+1);
//             minLength++;
//         }

//         int l = 0, r = s.length() -1;
//         int maxLength = 0;


//         while(l<r){
//             char ch = s.charAt(l);
//             char chLast = s.charAt(r);
//             if(targetMap.containsKey(ch)){
//                 if(targetMap.get(ch) < mainMap.get(ch)){
//                     l++;
//                 }
//             }else{
//                 l++;
//             }

//             if(targetMap.containsKey(chLast)){
//                 if(targetMap.get(chLast) < mainMap.get(chLast)){
//                     r--;
//                 }else{
//                     r--;
//                 }
//             }
//         }

//         return s.subString(l,r+1);

//     }
// }

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> targetMap = new HashMap<>();
        HashMap<Character, Integer> mainMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            mainMap.put(ch, mainMap.getOrDefault(ch, 0) + 1);
        }

        int l = 0, r = s.length() - 1;

        while (l <= r) {
            char chLeft = s.charAt(l);
            if (!targetMap.containsKey(chLeft)) {
                l++;
            } else if (mainMap.get(chLeft) > targetMap.get(chLeft)) {
                mainMap.put(chLeft, mainMap.get(chLeft) - 1);
                l++;
            } else {
                break;
            }
        }

        while (r >= l) {
            char chRight = s.charAt(r);
            if (!targetMap.containsKey(chRight)) {
                r--;
            } else if (mainMap.get(chRight) > targetMap.get(chRight)) {
                mainMap.put(chRight, mainMap.get(chRight) - 1);
                r--;
            } else {
                break;
            }
        }

        // Check if final window is valid
        HashMap<Character, Integer> windowMap = new HashMap<>();
        for (int i = l; i <= r; i++) {
            char ch = s.charAt(i);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : targetMap.keySet()) {
            if (windowMap.getOrDefault(ch, 0) < targetMap.get(ch)) {
                return ""; // not all target characters are included
            }
        }

        return s.substring(l, r + 1);
    }
}

