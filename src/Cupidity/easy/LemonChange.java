package Cupidity.easy;

//LeetCode   860题   柠檬水找零
public class LemonChange {
    //优化空间和时间
    public boolean lemonadeChangeLessTimeAndSpace(int[] bills) {
        if (bills[0] > 5) {
            return false;
        }
        if (bills == null || bills.length == 0) {
            return true;
        }
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if(bills[i]==5){
                five++;
            }else if(bills[i]==10){
                if(five>0){
                    ten++;
                    five--;
                }else{
                    return false;
                }
            }else{
                if(five>0 && ten>0){
                    ten--;
                    five--;
                }else if(five>=3){
                    five-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    //贪心
    public boolean lemonadeChange(int[] bills) {
        if (bills[0] > 5) {
            return false;
        }
        if (bills == null || bills.length == 0) {
            return true;
        }
        int five = 1;
        int ten = 0;
        int twen = 0;
        int cur = five * 5 + ten * 10 + twen * 20;
        for (int i = 1; i < bills.length; i++) {
            int expe = bills[i] - 5;
            if (expe == 0) {
                five++;
                continue;
            }
            cur = five * 5 + ten * 10 + twen * 20;
            if (cur < expe) {
                return false;
            }
            if (five == 0) {
                return false;
            }
            if (bills[i] == 10) {
                five--;
                ten++;
            } else {
                twen++;
                if (ten > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }

            }

        }
        return true;
    }
}
