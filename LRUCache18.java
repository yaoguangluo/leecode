//这段代码是完全没用linkedhashmap思想的数据结构算法实现lru cache。通过测试我得到18/18分， 只差一分了。。。

//供观赏
//罗瑶光
public class LRUCache
{
    public int find = 0;
    public int capacity;
    public int key;
    public int value= -1;
    public int result;
    public int index;
    public LRUCache next;
    public LRUCache prev;
    public LRUCache first;
    public LRUCache tail;
    public LRUCache(int capa)
    {
        this.index=0;
        this.capacity = capa;
        this.first = this;
        this.tail  = this;
    }
    public int get(int key)
    {
        int find = findget(first, key);
        LRUCache temp = new LRUCache(this.capacity);
        temp.key = key;
        temp.value = value;
        
        if(find==1)
        {
             temp.value = this.value;
             if(this.tail != null)
            {

               this.tail.next = temp;
               temp.prev = this.tail;
               this.tail = this.tail.next;
            }else{

                    this.tail = temp;
                    this.first = temp;
                }
            this.first = findfirst(this.tail); 
            return this.value;
        }else{
            
            return -1;
        }
    }
    public int findget(LRUCache node,int key)
    {
      while(node != null)
      {
          if(node.key == key)
          {   
               this.value=node.value;
              
              if(node.next != null && node.prev!= null)
              {
                  node.prev.next = node.next;
                  node.next.prev = node.prev;
                  node = node.next;
              }else if(node.next != null && node.prev== null)
              {
                  node=node.next;
                  node.prev=null;
                  this.first=node;
              }else if(node.next == null && node.prev!= null)
              {
                  
                  node=node.prev;
                  node.next=null;
                  this.tail=node;
              }else if(node.next == null && node.prev == null)
              {
                  node=null;
                  this.first=null;
                  this.tail =null;
              }
              
              return 1;
          }
          node = node.next;
      }
        return 0;
    }
    
    
    public void put(int key,int value)
    {
      int find = find(first, key);
      if(this.tail != null)
      {
          LRUCache temp = new LRUCache(this.capacity);
          temp.key = key;
          temp.value = value;
          this.tail.next = temp;
          temp.prev = this.tail;
          this.tail = this.tail.next;
          
      }else{
          LRUCache temp = new LRUCache(this.capacity);
          temp.key = key;
          temp.value = value;
          this.tail = temp;
          this.first = temp;
      }
      int loop = this.tail.capacity;
      this.first=findfirst(this.tail);
    }
    
    public LRUCache findfirst(LRUCache temp)
    {
        int loop= temp.capacity;
        while(loop>1)
        {
            if(temp.prev!=null)
            {
                temp=temp.prev;
            }
            loop-=1;
        }
        return temp;
    }
    public int find(LRUCache node,int key)
    {
      while(node != null)
      {
          if(node.key == key)
          {   
              
              if(node.next != null && node.prev!= null)
              {
                  node.prev.next = node.next;
                  node.next.prev = node.prev;
                  node = node.next;
              }else if(node.next != null && node.prev== null)
              {
                  node=node.next;
                  node.prev=null;
                  this.first=node;
              }else if(node.next == null && node.prev!= null)
              {
                  
                  node=node.prev;
                  node.next=null;
                  this.tail=node;
              }else if(node.next == null && node.prev == null)
              {
                  node=null;
                  this.first=null;
                  this.tail =null;
              }
              
              return 1;
          }
          node = node.next;
      }
        return 0;
    }  
}
