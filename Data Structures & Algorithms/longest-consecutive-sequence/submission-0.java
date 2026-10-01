class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet <Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int maxLength = 0;

        for (int num : set) { 
            
            if (!set.contains(num - 1)) {  
                int currentLength = 1;
                int currentNum = num;
                
                while (set.contains(currentNum + 1)) {
                    currentLength++;
                    currentNum++;
                }
                
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        
        return maxLength;
    }
}
