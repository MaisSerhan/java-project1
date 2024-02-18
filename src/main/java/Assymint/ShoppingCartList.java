
package Assymint;

public class ShoppingCartList{
 int size;
 ItemsNode head;
 ItemsNode tail;
 MainLinkedList list;//Main linked list (list of store)
    public ShoppingCartList() {
    }

    public ShoppingCartList(int size, ItemsNode head, ItemsNode tail) {
        this.size = size;
        this.head = head;
        this.tail = tail;
    }

 public void AddItems(ItemsNode iteam){
  //search of item
  Integer [] search=list.searchItem(iteam.name, iteam.ID);
  //quentity is larg of found
  if(search==null)
    return;  
  else if((search[1]-iteam.quntity)<0){
      return;
  }   
//item is finish delet in main linked list
  else if((search[1]-iteam.quntity)==0){
    StoreNode store=list.head;
  for(int i=1;i<search[0];i++){
      store=store.next;
  }  
    store.store.deleteItem(iteam.ID);

  }  
  //decrease quentity
  else{
   StoreNode store=list.head;
  for(int i=1;i<search[0];i++){
      store=store.next;
  }
   ItemsNode itemCurr=store.store.head;
  while(itemCurr!=null){
      if(itemCurr.ID==iteam.ID){
        itemCurr.quntity-=iteam.quntity; break;}
      itemCurr=itemCurr.next;
  }
  }
 
  //additem in shopping
  if(head==null){
   head=iteam;
   tail=iteam;}
  else{
   tail.next=iteam; 
   tail=iteam;}
   size++;
  }
   
  

  

 public void returnIteam(String itemNode,int quantity){
    ItemsNode currShop=head;String id="";

    //access to iteam in shop list 
    while(currShop!=null){
    if(currShop.name==itemNode){
        id=currShop.ID;
        break;}
        currShop=currShop.next;    
    }
    
    //add if not found item in main list
    Integer [] search=list.searchItem(itemNode, id);
    if(search==null){
    list.add(currShop.storeNumber, currShop);
        
        } 
     
    //rise quentity
    else{
    StoreNode store=list.head;
    for(int i=1;i<search[0];i++){
      store=store.next;
    }
    ItemsNode curr=store.store.head;
    while(curr!=null){
        if(curr.name==itemNode){
            curr.quntity++;break;}
    }    
    } 
  
    //delete in shop list
    if(head.name==itemNode&&tail.name==itemNode&&head.equals(tail)){
        head=null; tail=null;}
    else if(head.name==itemNode){
        head=head.next;}
    else{currShop=head;
    while(currShop.next!=null){
        if(currShop.next.name==itemNode){
            if(currShop.next==tail)
                tail=currShop;
            currShop.next=currShop.next.next;
        break;}
        currShop=currShop.next;
    }}
   size--; 
 }
}