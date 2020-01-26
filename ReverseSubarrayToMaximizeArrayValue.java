//https://leetcode.com/problems/reverse-subarray-to-maximize-array-value/
class Solution {
    public int maxValueAfterReverse(int[] nums) {
        int curDif=0;
        int maxDif=0;
        for(int i=0;i<nums.length-1;i++){
            curDif+=Math.abs(nums[i]-nums[i+1]);
        }

        maxDif=curDif;
        System.out.println("Base "+curDif);
        
        for(int i=0;i<nums.length;i++){
            int tmpN=curDif;
            
            for(int j=i+1;j<nums.length;j++){
                int oldDif=0;
                int nDif=0;
                if(i>0){
                    oldDif+=Math.abs(nums[i]-nums[i-1]);
                    nDif+=  Math.abs(nums[j]-nums[i-1]);
                }
                if(j<nums.length-1){
                    oldDif+=Math.abs(nums[j]-nums[j+1]);
                    nDif+=  Math.abs(nums[i]-nums[j+1]);
                }
                tmpN=curDif+nDif-oldDif;
                maxDif=Math.max(maxDif,tmpN);
                //System.out.println("i "+i+" j "+j +" nDif "+nDif+" oldDif "+oldDif+" tmpN "+tmpN+" maxDif "+maxDif);
            }
        }
        return maxDif;
    }
}
