import java.util.Vector;

//this method from Aditya Goel
//developed and optimized by yaoguang luo
public class UBSTtoBST
{
    static int[] has;
    public static void main(String []argv)
    {
         leaf n = new leaf();
         n.t = 9;
         n.left = new leaf();
         n.left.t = 8;
         n.left.left = new leaf();
         n.left.left.t = 7;
         n.left.left.left = new leaf();
         n.left.left.left.t = 6;
         n.left.left.left.left = new leaf();
         n.left.left.left.left.t = 5;
         Vector<leaf> leafs = new Vector<leaf>();

         readBST(n,leafs);
         has = new int[leafs.size()];
         leaf root = toBST(leafs,0,leafs.size()-1);
         System.out.println(1);
    }
    public static void readBST(leaf n, Vector<leaf> leafs)
    {
         if(n.left != null)
         {
            readBST(n.left,leafs);
         }
         if(n.right != null)
         {
            readBST(n.right,leafs);
         }
         leafs.add(n);
    }
    public static leaf toBST(Vector<leaf> leafs,int f,int l)
    {
        if(f>l)
          return null;
        if(has[(f+l)/2]==0)
        {
            has[(f+l)/2]=1;
            leaf lf = leafs.get((f+l)/2);
            lf.left = toBST(leafs,0,(f+l)/2-1);
            lf.right= toBST(leafs,(f+l)/2+1,l);
            return lf;
        }else{
            return null;
        }
    }
}
class leaf
{
    public int t;
    public leaf left;
    public leaf right;

}
