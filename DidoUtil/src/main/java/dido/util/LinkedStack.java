package dido.util;
/* Stack implemented with a linked structure internally.
*  Can contain any type of Item.
*/

public class LinkedStack<T>{

  private static class Node<U> {
    U item;
    Node<U> next;

    public Node(U itm, Node<U> nxt ){
      this.item = itm;
      this.next = nxt;
    }

    public Node(){
      item = null;
      next = null;
    }

    public boolean end(){
      return (next==null && item ==null);
    }
  }

  // Sentinel end of the stack(item==null,next==null)
  private Node<T> top = new Node<T>();


  public void push(T item){
    top = new Node<T> (item, top);  // top points to the new object inserted
  }

  public T pop(){
    T result = top.item;
    if(!top.end())
       top = top.next;
    return result;
  }

  public static void main (String [] args){
    //stack of Strings
    LinkedStack<String> lss = new LinkedStack<String>();
    String hello = "Hello world !!";
    for(String s: hello.split(" "))
      lss.push(s);
    String res;
    while((res=lss.pop() ) != null) {
        System.out.println(res);
    }
    // Stack of Integer
    LinkedStack<Integer> lsi = new LinkedStack<Integer>();
    Integer[] num = {1,2,3,4,5};
    for(Integer s: num)
      lsi.push(s);
    Integer ri;
    while((ri=lsi.pop()) != null) {
        System.out.println(ri);
    }
  }

}
