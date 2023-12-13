O(n^3*nlog(n))  -

public class Main
{
	public static void main(String[] args) {
	   int[] arr = {-1,-8,-8,9,-8,-1,16};
	   int n = arr.length;
	   Set<List<Integer>> set = new HashSet<>();
	   for(int i = 0; i < n - 2; i++)
	   {
	       for(int j = i + 1; j < n - 1; j++)
	       {
	           for(int k = j + 1; k < n; k++)
	           {
	               if(arr[i] + arr[j] + arr[k] == 0)
	               {
	                      List<Integer> triplet = new ArrayList<>();
                        triplet.add(arr[i]);
                        triplet.add(arr[j]);
                        triplet.add(arr[k]);
                        Collections.sort(triplet);
                        set.add(triplet);
                        // break;
	               }
	           }
	       }
	   }
	   //System.out.println(set);
	   List<List<Integer>> ans = new ArrayList<>(set);
	   System.out.println(ans);
	}
}

0(n^3 * nlogn) -

public static void main(String[] args) {
		int[] nums = {-1,-8,-8,9,16};
	    Arrays.sort(nums);
	    List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n - 2; i++)
        {
            if(i > 0 && nums[i]==nums[i-1])
               continue;
            for(int j = i + 1; j < n - 1; j++)
            {
                if( ( j - 1 > i) && ( nums[j] == nums[j - 1]) )   //[-1,-8,-8,9,16] - [-1,-8,-9] and [-8,-8,16] here will not be exceuted if only j == j-1 , i begins at index 2 and j at 3 , hence you have to make sure j should not be right next to i , to make this comparission.
                    continue;
                List<Integer> temp = new ArrayList<>();
                for(int k = j + 1; k < n; k++)
                {
                    if(nums[i] + nums[j] + nums[k] == 0)
                    {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);//System.out.println(nums[i]);
                        ans.add(temp);
                        break;
                    }
                    
                }
                
            }
        }
        System.out.println(ans);
	}  


O(nlogn + n^2)  -


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n - 2; i++)
        {
            if(i > 0 && nums[i]==nums[i-1])
               continue;
            int left = i + 1;
            int right = n - 1;
             
            while( left < right)
            {
                int sum = nums[i] + nums[left] + nums[right];
                if( sum == 0)
                {
                    List<Integer> temp = Arrays.asList(nums[i], nums[left], nums[right]);
                    ans.add(temp);
                    left++;
                    right--;
                    while(left<nums.length && nums[left] == nums[left-1]) 
                        left++;
                    // while(right >= 0 && nums[right] == nums[right+1])
                    //     right--;  
                }
                else if (sum  < 0)
                    left++;
                else
                    right--;
            }
        }
        return ans;
    }
}  
