//speed =O(len(in)*log(len(a))/log(len(b)))
//method design by yaoguang
package leecode;
public class Sfinder
{
    public static  void main(String []argv)
    {
        //String a = "ajdsiasiodjiajdsTPOiasioosajdb";
        //String b = "bcfsadfasdas";

        String []a = new String[12];
        int len=20;
        a[0] = "123ajdsiasiodjiajdppsTPOiasioosajdb";
        a[1] = "998";
        a[2] = "1ajdsiasiodjiappjdsTPOiasioosajdb";
        a[3] = "1bcfsadfasdapps";
        a[4] = "1ajdsiasiodjiajpppdsTPOiasioosajdb";
        a[5] = "1bcfsadfasdappps";
        a[6] = "1ajdsiasiodjiajppdsTPOiasioosajdb";
        a[7] = "1bcfsadfasdappps";
        a[8] = "1ajdsiasiodjiajdsTPOiasioosajdb";
        a[9] = "1bcfsadfasdasppp";
        a[10] = "1ajdsiasiodjiapppjdsTPOiasioosajdb";
        a[11] = "1bcfsadfasdappps";
        String in = "bacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodbac998dajdsiasiodjdsiasiodjiosaajdlyfgsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsTPOiasiodjiosajdbiodjiosajdbjiosajdb";
        System.out.println(find(a,in,len));


    }
    public static boolean find(String []a,String in,int len)
    {
        for(int i=0;i<in.length();i++)
        {
          if(check(a,in,i,len))
          {
              return true;
          }
        }
        return false;
    }
    public static boolean check(String []a,String in,int i,int len)
    {
         int []b= new int[a.length];
         for(int i1=0;i1<b.length;i1++)
         {
            b[i1]=1;
         }
         //int f1=1;
         //int f2=1;
         return compare(a,b,in,i,len);
         //return false;
    }
    public static boolean compare(String []a,int []b,String in,int i,int len)
    {
            for(int j = 0;j < len;j++)
            {
                int total = 0;
                for(int k = 0;k < b.length;k ++)
                {
                    if(b[k] == 1) {
                        b[k] = sf1(a[k], i, j, in);
                    }else{
                        total += 1;
                    }
                }
                if(total == a.length)
                    return false;

            }

        for(int k=0;k<b.length;k++)
        {
            if(b[k]==1)
              return true;
        }
         return false;
    }
    public static int sf1(String a,int i,int j,String in)
    {
                if(j>=a.length())
                {
                    return 1;
                }

                if(i+j>=in.length())
               {
                   return 1;
                }

                if(a.charAt(j)!=in.charAt(j+i))
                {
                    return 0;
                }
            return 1;
    }
}
