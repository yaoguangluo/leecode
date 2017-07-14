//那个18分的我如果加个size，也能满分，不过行数超了200行，没意思所以还是用linkedhashmap
//娱乐供娱乐，当真就输了。妈妈
//下面是满分的代码逻辑。
//瑶光

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache
{
    public int max;
    public LinkedHashMap<Integer,Integer> link;
    public LRUCache(int capa)
    {
        max=capa;
        link = new LinkedHashMap<Integer, Integer>(capa,1);
    }
     public int get(int key)
    {
        if(link.containsKey(key))
        {
            int temp = link.get(key);
            link.remove(key);
            link.put(key,temp);
            return temp;
        }else{
            return -1;
        }
    }
    public void put (int key, int value)
    {
        if(link.containsKey(key))
        {
            link.remove(key);
            link.put(key,value);
        }else{
             if(link.size()>=max){
                link.remove(link.keySet().iterator().next());
             }
            link.put(key,value);
           // link.clear();
        }
    }
}
