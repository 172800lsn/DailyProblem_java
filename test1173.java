class Solution {
    public int tribonacci(int n) {
        int a=0,b=0,c=1,d=1;
        if(n==0||n==1) return n;
        if(n==2) return 1;
        for(int i=2;i<n;i++){
            a=b;
            b=c;
            c=d;
            d=a+b+c;
        }
        return d;
    }
}
