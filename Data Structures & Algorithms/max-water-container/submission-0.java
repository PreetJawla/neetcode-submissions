class Solution {
    public int maxArea(int[] heights) {
        int maxVolume = 0;
        int r = 0 , l = heights.length-1;
        while(r< l){
            if(maxVolume < ((l-r)* Math.min(heights[r],heights[l]))){
                maxVolume = ((l-r)* Math.min(heights[r],heights[l]));
            }
            if(heights[r]< heights[l]){
                r++;
            }else{
                l--;
            }
        }
        return maxVolume;
    }
}
