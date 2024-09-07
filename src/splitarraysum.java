public class splitarraysum {
    public static void main(String[] args) {
        int[]nums={7,2,5,10,8};
        int m=2;
        int ans=split(nums,m);
        System.out.println(ans);

    }
    static int split(int[]nums,int m){
        int start=0;
        int end=0;
        for(int i=0;i<nums.length-1;i++){
            start=Math.max(start,nums[i]);
        end=end+nums[i];
        }
        //binarysearch
        while(start<end) {
            //try for potential ans;
            int mid = start + (end - start) / 2;
            int sum = 0;
            int pieces = 1;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (sum + num > mid) {
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }
            if (pieces > m) { //means target>mid
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;  //here strt ==end
    }
}
