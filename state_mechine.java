package yaoguang;

public class state_machine
{
    public static int findpath(int m, int n, int N, int i, int j)
    {
        int mod = 1000000000+7;
        int max[][] = new int[m][n];
        max[i][j]=1;
        int total=0;
        for(int p=0;p<N;p++)
        {
            int[][]temp = new int[m][n];
            for(int k=0;k<m;k++)
            {
                for(int l=0;l<n;l++)
                {
                    if(k==0){total=(total+max[k][l])%mod;}
                    if(l==0){total=(total+max[k][l])%mod;}
                    if(k==m-1){total=(total+max[k][l])%mod;}
                    if(k==n-1){total=(total+max[k][l])%mod;}
                    int a1=k>0?max[k-1][l]:0;
                    int a2=k<m-1?max[k+1][l]:0;
                    int a3=l>0?max[k][l-1]:0;
                    int a4=l<n-1?max[k][l+1]:0;
                    temp[k][l]=((a1+a2)%mod+(a3+a4)%mod)%mod;
                }
            }
            max=temp;
        }
        return total;

    }

    public static void main(String[]argv)
    {
      System.out.println(findpath(2,2,2,0,0));

    }
}
