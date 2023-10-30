O(nlogn)

        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int sum = 0;
        int cnt = 0;
        sum+= nums[left] + nums[right];
        while(left < right)
        {
            if(sum == k) 
            {
                sum=0;
                cnt++;
                left++;
                right--;
                sum+= nums[left] + nums[right];

            }
            else if(sum < k)
            {
                sum-= nums[left];
                left++;
                sum+= nums[left];
               
            }
            else
            {
                sum-= nums[right];
                right--;
                sum+= nums[right];
            }
       }
        return cnt;


