import java.util.Scanner;

class link8{
    int info;
    link8 next;
}
public class LINKED_LIST {
    static link8 start = null;
    public static void create(link8 node){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of node: ");
        node.info= sc.nextInt();
        node.next=null;
        System.out.println("Press Y or y to continue ");
        char ch = sc.next().charAt(0);
        while (ch =='y' || ch=='Y' ){
            link8 temp = new link8();
            System.out.println("Enter value of new node: ");
            temp.info= sc.nextInt();
            temp.next=null;
            node.next=temp;
            node=temp;
            System.out.println("Press Y or y to continue ");
            ch = sc.next().charAt(0);
        }
    }
    public static void display(link8 node){
        while (node != null) {
            System.out.print(node.info + "-->");
            node = node.next;
        }
    }
    public static void display1(link8 node){
        if (node==null)
            return;
        else {
            System.out.print(node.info+"-->");
            display(node.next);
        }
    }

    public static void insert_begin(link8 node){
        Scanner sc = new Scanner(System.in);
        link8  current = new link8();
        System.out.println("\nEnter the value of the node to be inserted in the beginning: ");
        current.info= sc.nextInt();
        current.next= null;
        current.next=node;
        start=current;
    }
    public static void delete_begin(link8 node){
        start= node.next;
    }
    public static void insert_any(link8 node){
        Scanner sc = new Scanner(System.in);
        link8 current2 = new link8();
        System.out.println("Enter location to be inserted: ");
        int loc = sc.nextInt();
        int i =1;
        if (loc==1){
            current2.next=node;
            start= current2;
        }
        else {
            link8 previous = new link8();
            while (i < loc) {
                previous = node;
                node = node.next;
                i++;
            }
            previous.next = current2;
            current2.next = node;
        }
    }
    public static void delete_any(link8 node){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter location: ");
        int loc = sc.nextInt();
        int i =1;
        if (loc ==1){
            start=node.next;
        }
        else {
            link8 pre = new link8();
            while (i<loc){
                pre=node;
                node=node.next;
                i++;
            }
            pre.next=node.next;
        }
    }
    public static void insert_end(link8 node){
        Scanner sc = new Scanner(System.in);
        link8 current3 = new link8();
        System.out.println("Enter the value of new node: ");
        current3.info = sc.nextInt();
        while (node!= null){
            node=node.next;
        }
        node.next=current3;
    }
    public static void delete_end(link8 node){
        link8 pre = new link8();
        while (node.next!=null){
            pre=node;
            node=node.next;
        }
        pre.next=null;
    }
    public static void sort(link8 node){
        link8 ptr1 = new link8();
        link8 ptr2 = new link8();
        for (ptr1=node ;ptr1!=null;ptr1=ptr1.next){
            for (ptr2 = ptr1.next;ptr2!=null; ptr2 = ptr2.next){
                if (ptr1.info> ptr2.info){
                    int t = ptr1.info;
                    ptr1.info = ptr2.info;
                    ptr2.info= t;
                }
            }
        }

    }
    public static void reverse(link8 node){
        link8 prev = node;
        link8 curr = node.next;
        while (node!=null){
            link8 next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        start.next=prev;
        node=node.next;
    }
    public static void swap(link8 node){
        link8 previous1 = new link8();
        while (node!=null){
            previous1=node;
            node = node.next;
        }
        int t = start.info;
        int tt = previous1.info;
        previous1.info=t;
        start.info=tt;
    }

    public static void main(String[] args) {
        link8 node = new link8();
        start=node;
        create(start);
        System.out.println("Before insertion: ");
        display(start);
        insert_begin(start);
        System.out.println("After insertion: ");
        display(start);
        System.out.println(start);
        sort(start);
        System.out.println("After sorting");
        display(start);
        swap(start);
        System.out.println();
        System.out.println("After swapping:");
        display(start);
        display1(start);
        reverse(start);
        System.out.println("After reversing: ");
        display(start);
    }
}