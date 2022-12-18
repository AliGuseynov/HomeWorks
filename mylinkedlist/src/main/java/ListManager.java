public class ListManager <T> {

    ListNode value;
    ListNode next;

    public ListManager(){
        value = null;
        next = null;
    }

    // check if the list is full or empty
    public boolean listValueCheck(){
        if(value != null)
            return true;
        else
            return false;
    }

    // add element to list
    public void listFirstAdd(int v){
        ListNode listNode = new ListNode(v);
        if(listValueCheck()==true){
            listNode.next = value;
            this.value = listNode;
        }
        else{

            this.value = listNode;
            this.next = listNode;
        }
    }
    public void listLastAdd(int v){
        ListNode listNode = new ListNode(v);
        if(listValueCheck()==true){
            next.next = listNode;
            next = listNode;
        }
        else{
            this.value = listNode;
            this.next = listNode;
        }
    }

    // ---> Print all list <---
    public void listWrite(){
        ListNode listNode = value;
        while(listNode != null){
            System.out.print("[ "+listNode.value +" ] ");
            listNode = listNode.next;
        }

    }
}
