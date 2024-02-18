
package Assymint;

public class MainLinkedList {
int size;
StoreNode head;
StoreNode tail;
ShoppingCartList cart;

    public MainLinkedList() {
    }

    public MainLinkedList(int size, StoreNode head, StoreNode tail, ShoppingCartList cart) {
        this.size = size;
        this.head = head;
        this.tail = tail;
        this.cart = cart;
    }
    //return array of ID of Store and quentity
   public Integer[] searchItem(String name,String id){
    StoreNode currStore=head;
    while(currStore!=null){
        ItemsNode curr=currStore.store.head; 
        while(curr!=null){
            if(curr.name.equals(name)&&curr.ID.equals(id))
                return new Integer[]{currStore.store.storeNumber,curr.quntity};
            curr=curr.next;
        }
        currStore=currStore.next;
    }
    return null;   
   }
  
   public void add(int storeNum,ItemsNode i){
    StoreNode curr=head;
    for(int j=1;j<storeNum;j++)
        curr=curr.next;
    if(curr.next!=null)
    curr.next.store.AddItem(i);
    else {
        StoreNode stor=new StoreNode();
        stor.next.store.AddItem(i);
    }
    
   }
   public double purchase(){
   ItemsNode curr=cart.head;
   double price=0.0;
   while(curr!=null){   
   price+=curr.price;
   curr=curr.next;    
   }
   cart.head=null;
   cart.size=0;
   return price;
   }    
   }
    
       
       
       
       
       
       
       
       
   
