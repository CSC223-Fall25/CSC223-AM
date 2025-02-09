
package csc223.am;

public class SinglyLinkedList implements LinkedList {
    Node head;
    Node tail;
    
    // Insert an item at the end of the list for unsorted lists
    public void insert(char item){
        Node new_item = new Node();
        new_item.data = item;
        if (this.head == null){
            this.head = new_item;
            this.tail = new_item;
        } else {
            this.tail.next = new_item;
            this.tail = new_item;
        }

    }

    // Removes an item from the list
    public void remove(char item){
        if(this.head.data == item){
            this.head = this.head.next;
        }
        Node curr = this.head;
        while (curr.next != null){
            if (curr.next.data == item){
                curr.next = curr.next.next;
                break;
            } else {
            curr = curr.next;
            }
        }
        if (curr.next == null){
            this.tail = curr;
        }
    }

    // Get the first item, return '☠' if the list is empty
    public char getFirst(){
        if (this.head != null){
            return this.head.data;
        } else {
            return '☠';
        }
    }

    // Get the last item, return '☠' if the list is empty
    public char getLast(){
        if (this.tail != null){
            return this.tail.data;
        } else {
            return '☠';
        }
    }

    // Get an item at a specific index, return '☠' if index is out of bounds
    public char get(int index){
        Node curr = this.head;
        for (int i = 0; i <= index; i++){
            if (i == index){
                return curr.data;
            }
            curr = curr.next;
        }
        return '☠';
        
    }

    // Get the size of the list
    public int size(){
        int i = 0;
        Node curr = this.head;
        while (curr != null){
            i += 1;
            curr = curr.next;
        }
        return i;
    }

    // Check if the list is empty
    public boolean isEmpty(){
        return this.head == null;
    }

    // Clear the list
    public void clear(){
        this.head = null;
        this.tail = null;
    }

    // Check if the list contains an item
    public boolean contains(char item){
        boolean check = false;
        Node curr = this.head;
        while (curr != null){
            if (curr.data == item){
                check = true;
                break;
            }
        }
        return check;
    }

    // Get the index of an item, if it exists else return -1
    public int indexOf(char item){
        int i = 1;
        Node curr = this.head;
        while (curr != null){
            if (curr.data == item){
                return i;
            }
            i += 1;
            curr = curr.next;
        }
        return -1;
        
    }

    // Get the last index of an item, if it exists else return -1
    public int lastIndexOf(char item){
        int i = 1;
        int curr_index = -1;
        Node curr = this.head;
        while (curr != null){
            if (curr.data == item){
                curr_index = i;
            }
            i += 1;
            curr = curr.next;
        }
        return curr_index;
    }

    // Reverse the list
    public void reverse(){
        Node prev = null;
        Node curr = this.head;
        while (curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        this.head = prev;
        Node tail = this.head;
        while (tail.next != null){
            tail = tail.next;
        }
        this.tail = tail;

    }

    // Creates and returns a String representation of the list
    // e.g. `A -> B -> C -> D` should return "ABCD"
    @Override
    public String toString(){
        String out = "";
        Node curr = this.head;
        while (curr != null){
            out += curr.data;
            curr = curr.next;
        }
        return out;
    }
}
