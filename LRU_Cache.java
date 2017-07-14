//这段代码是完全没用linkedhashmap思想的数据结构算法实现lru cache。通过测试我得到17/18分， 
//罗瑶光

public class LRUCache 
{
    public int capacity;
    public int key;
    public int value;
    public int result;
    public LRUCache next;
    public LRUCache prev;
    public LRUCache temp;
    public LRUCache(int capa) 
    {
        this.capacity = capa;
        this.temp = this;
    }
    public int get(int key) 
    {
        this.temp = get_node(key,this.temp);
        return this.temp.result;
    }
    public LRUCache get_node(int key, LRUCache node)
    {
        LRUCache nodet=new LRUCache(node.capacity);
        int temp = -1;
        int find = 0;
        while(node.next != null)
        {
            node = node.next;
            if(node.key == key)
            {
                find = 1;
                nodet.key = node.key;
                temp = node.value;
                node.value = -1;
                nodet.value = -1;
                if(node.next != null && node.prev != null)
                {
                    node.prev.next=node.next;
                    node.next.prev=node.prev;
                    node=node.next;
                }else if(node.next != null && node.prev == null)
                {
                    node=node.next;
                    node.prev=null;
                }else  if(node.next == null && node.prev != null)
                {
                    node=node.prev;
                    node.next=null;
                }
            }
        }
        if(find == 1)
        {
            node.next  = nodet;
            nodet.prev = node;   
            LRUCache tp = nodet;
            tp.value = temp;
            int loop = nodet.capacity;
            while(loop>0)
            {
                if(tp.prev!=null)
                {
                    tp=tp.prev;
                }
                loop-=1;
            }
            tp.result=temp;
            tp.prev=null;
            return tp; 
        }else{
            LRUCache tp = node;
            int loop = node.capacity;
            while(loop>0)
            {
                if(tp.prev!=null)
                {
                    tp=tp.prev;
                }
                loop-=1;
            }
            tp.result=-1;
            tp.prev=null;
            return tp; 
        }
    }
    
    public void put(int key, int value) 
    {
      //  this.temp = this;
        this.temp = put_node(this.temp, key, value);
    }
    
    public LRUCache put_node(LRUCache node,int key, int value)
    {

        int temp = -1;
        int find = 0;
        LRUCache nodet=new LRUCache(node.capacity);
        int index=0;
        while(node.next != null)
        {
            node = node.next;
            if(node.key == key)
            {
                find=1;
                nodet.key = node.key;
                temp = value;
                if(node.next != null && node.prev != null)
                {
                    node.prev.next=node.next;
                    node.next.prev=node.prev;
                    node=node.next;
                }else if(node.next != null && node.prev == null)
                {
                    node=node.next;
                    node.prev=null;
                }else  if(node.next == null && node.prev != null)
                {
                    node=node.prev;
                    node.next=null;
                }
            }
        }
        if(find == 1)
        {
            node.next  = nodet;
            nodet.prev = node;
            nodet.value= temp;
            LRUCache tp = nodet;
            int loop = nodet.capacity;
            while(loop>0)
            {
                if(tp.prev!=null)
                {
                    tp=tp.prev;
                }
                loop-=1;
            }
            tp.prev=null;
            return tp; 
        }else{
            node.next   = nodet;
            nodet.key   = key;
            nodet.prev  = node;
            nodet.value = value;
            
            LRUCache tp = nodet;
            int loop = nodet.capacity;
            while(loop>0)
            {
                if(tp.prev!=null)
                {
                    tp=tp.prev;
                }
                loop-=1;
            }
            tp.prev=null;
            return tp; 
        }
    }
}
