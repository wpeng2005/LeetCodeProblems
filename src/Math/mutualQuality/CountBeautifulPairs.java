package Math.mutualQuality;
//   2748题   美丽下标对的数目
public class CountBeautifulPairs {
    //用数组存储
    public int countBeautifulPairs(int[] nums) {
        int[] records=new int[10];
        int count=0;
        for(int num:nums){
            int last=num%10;
            while(num>=10){
                num=num/10;
            }
            for(int j=1;j<=9;j++){
                if(records[j]>0 && gcd(j,last)==1){
                    count+=records[j];
                }
            }
            records[num]++;
        }
        return count;
    }
    public int gcd(int a,int b){
        return a==0?b:gcd(b%a,a);
    }


    public int countBeautifulPairs(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(gcd(thefirst(nums[i]),thelast(nums[j]))==1){
                    ans++;
                }
            }
        }
        return ans;
    }
    public int thefirst(int num){
        String str=Integer.toString(num);
        int first=Integer.parseInt(String.valueOf(str.charAt(0)));
        return first;
    }
    public int thelast(int num){
        String str=Integer.toString(num);
        int last=Integer.parseInt(String.valueOf(str.charAt(str.length()-1)));
        return last;
    }
    public int gcd(int a,int b){
        return a==0?b:gcd(b%a,a);
    }
}
