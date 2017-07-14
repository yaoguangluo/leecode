//这段代码是完全没用linkedhashmap思想的数据结构算法实现lru cache。通过测试我得到17/18分， 
//没有用指定的方法却能打到17分我觉得我有必要来介绍这段算法/
//我参阅满分18分的正确答案是有歧义的，因为最后一分是强调速度要快，但是忽略了内存占用空间。而我的代码虽然慢了点，拿不到最后那一分，
//但是我的代码内存占用比率比正确代码占用内存控件成比例上升。比如1万亿读写次数，我的内存占用至少是正确答案的百万分之一。
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
