package leecode;

public class nero_euler
{
    static int total=0;
    public static int findpath(int m, int n, int N, int i, int j)
    {
        int max[][] = new int[m][n];
        max[i][j]=1;
        derect(max,m,n,N,i-1,j);
        derect(max,m,n,N,i+1,j);
        derect(max,m,n,N,i,j-1);
        derect(max,m,n,N,i,j+1);
        return total;
    }
    public static void derect(int[][] max,int m, int n, int N, int i, int j)
    {
        if(N<0) return;
        if(i<0)  {total+=1;return;}
        if(i>=m) {total+=1;return;}
        if(j<0)  {total+=1;return;}
        if(j>=n) {total+=1;return;}
        if(max[i][j]==1) {return;}
        max[i][j]=1;
        derect(max,m,n,N-1,i-1,j);
        derect(max,m,n,N-1,i+1,j);
        derect(max,m,n,N-1,i,j-1);
        derect(max,m,n,N-1,i,j+1);
    }
    public static void main(String[]argv)
    {
        System.out.println(findpath(20,20,100,6,6));
    }
}
