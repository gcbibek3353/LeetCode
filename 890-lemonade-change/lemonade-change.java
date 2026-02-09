class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fCount = 0;
        int tCount = 0;
        int t2Count = 0;
        for(int i = 0; i < bills.length; i ++) {
            if(bills[i] == 5) fCount ++;
            else if (bills[i] == 10) {
                tCount ++;
                if(fCount <= 0) return false;
                else fCount --;
            }
            else {
                t2Count ++;
                if(fCount <= 0) return false;
                if(tCount <= 0 && fCount < 3) return false;
                else {
                    fCount --;
                    if(tCount > 0) tCount --;
                    else fCount -= 2;
                }
            }
        }
        return true;
    }
}