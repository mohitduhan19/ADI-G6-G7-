package LEC15;

public class Priority_Queue {
   static class Node{
      int data;
      int priority;
      Node next;
   }
   static Node node = new Node();

   static Node newNode(int d ,int p){
      Node temp = new Node();
      temp.data=d;
      temp.priority=p;
      temp.next=null;
      return temp;
   }
   static int peek(Node head){
      return head.data;
   }
   static Node pop(Node head){
      head=head.next;
      return head;
   }
   static Node push(Node head , int d , int p){
      Node start= head;
      Node temp= newNode(d ,p);
      //cas 1 : head of list has lesser priority then new node so insert node before head node and change head node to new node
      if((head).priority>p){
         temp.next=head;
         head=temp;
      }else {
         //traverse the list and find a position to insert node
         while (start.next != null && start.next.priority <= p){
            start=start.next;
         }
         temp.next=start.next;
         start.next=temp;
      }
      return head;
   }
   static int isEmpty(Node head){
      return head==null?1:0;
   }
   public static void main(String[] args) {
      Node pq = newNode(5,1);
      pq = push(pq,6,2);
      pq = push(pq,7,3);
      pq = push(pq,8,0);

      while (isEmpty(pq) == 0){
         System.out.print(peek(pq));
         pq = pop(pq);
      }

   }
}