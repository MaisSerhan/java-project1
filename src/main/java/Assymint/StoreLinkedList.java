
package Assymint;

public class StoreLinkedList {
 int size;
 ItemsNode head;
 ItemsNode tail;
 int storeNumber;
    public StoreLinkedList() {
    }

    public StoreLinkedList(int size, ItemsNode head, ItemsNode tail) {
        this.size = size;
        this.head = head;
        this.tail = tail;
    }
 
 public boolean AddItem(ItemsNode item){
  if(item.storeNumber!=this.storeNumber)
      return false;
    if(head==null){
     tail=item;
     head=item;
     size++;
     return true;
 }
   
 ItemsNode curr=head,prev=null;
 if(curr.name.compareToIgnoreCase(item.name)>0){
     item.next=head;
     head=item;
 } 
 
 else if(tail.name.compareToIgnoreCase(item.name)<0){
     tail.next=item;
     tail=item;
    }
 else{
 while(curr!=null){
  if(curr.name.compareToIgnoreCase(item.name)>0){
  prev.next=item;
  item.next=curr;
 size++;return true;}
 prev=curr;
 curr=curr.next;
 }
 prev.next=item;}
 size++;
 
 return true;}
 
 
 public boolean deleteItem(String id){
     ItemsNode curr=head;
     if(curr.ID==id){
         head=head.next;
         if(size==1)tail=null;
         size--;return true;}
     while(curr.next!=null){
         if(curr.next.ID==id){
             if(curr.next==tail)
                 tail=curr;
             curr.next=curr.next.next;
             size--;
             return true;
         }
         curr=curr.next;
     }
  return false;
 }
}
