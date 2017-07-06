//speed =O(len(in)*log(len(a))/log(len(b)))
//method design by yaoguang
public class Sfinder
{
    public static  void main(String []argv)
    {
        String a = "ajdsiasiodjiajdsTPOiasioosajdb";
        String b = "bcfsadfasdas";
        String in= "bacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsiasiodjiosajdbiodjiosajdbbacdajdsiasiodjdsiasiodjiosaajdsTPOiasiodjiosajdbiodjiosajdbjiosajdb";
        System.out.println(find(a,b,in));


    }
    public static boolean find(String a,String b,String in)
    {
        for(int i=0;i<in.length();i++)
        {
          if(check(a,b,in,i))
          {
              return true;
          }
        }
        return false;
    }
    public static boolean check(String a,String b,String in,int i)
    {
         int len = a.length();
         if(a.length() < b.length())
         {
              len=b.length();
         }
         int f1=1;
         int f2=1;
         return compare(f1,f2,a,b,in,i,len);
         //return false;
    }
    public static boolean compare(int f1,int f2,String a,String b,String in,int i,int len)
    {
            for(int j = 0;j < len;j++)
            {
                if(f1==0 && f2==0)
                {
                    return false;
                }else if(f1==0 && f2==1)
                {
                    f2 = sf1(b,i,j,in);
                }else if(f1==1 && f2==0)
                {
                    f1 = sf1(a,i,j,in);
                }else{
                    f1 = sf1(a,i,j,in);
                    f2 = sf1(b,i,j,in);
                }
            }
         if(f1==1||f2==1) {return true;}
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
