package Math;
//    3115题   质数的最大距离
public class maximumPrimeDifference {
    public int maximumPrimeDifference(int[] nums) {
        int first,last;
        for(first=0;first<nums.length;first++){
            if(isPrime(nums[first])){
                break;
            }
        }
        for(last=nums.length-1;last>=0;last--){
            if(isPrime(nums[last])){
                break;
            }
        }
        return last-first;
    }
    public boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        if(n<=3){
            return true;
        }
        if(n%2==0 || n%3==0){
            return false;
        }
        for(int i=5;i<=Math.sqrt(n);i+=6){
            if(n%i==0 || n%(i+2)==0){
                return false;
            }
        }
        return true;
    }
}
