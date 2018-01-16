public class Test{

  public static void main(String [] args){
    QuickUnion qu = new QuickUnion(10);
    System.out.println(qu);

    qu.union(4,3);
    System.out.println("After union(4,3) ");
    System.out.println(qu);

    qu.union(3,8);
    System.out.println("After union(3,8) " );
    System.out.println(qu);

    qu.union(6,5);
    System.out.println("After union(6,5) " );
    System.out.println(qu);

    qu.union(9,4);
    System.out.println("After union(9,4) ");
    System.out.println(qu);

    qu.union(2,1);
    System.out.println("After union(2,1) " );
    System.out.println(qu);

    System.out.println("isConnected(8,9)? " + qu.isConnected(8,9));
    System.out.println(qu);

    System.out.println("isConnected(0,5)? " + qu.isConnected(5,4));
    System.out.println(qu);

    qu.union(5,0);
    System.out.println("After union(5,0) ");
    System.out.println(qu);

    qu.union(7,2);
    System.out.println("After union(7,2) ");
    System.out.println(qu);

    qu.union(6,1);
    System.out.println("After union(6,1) ");
    System.out.println(qu);

    qu.union(7,3);
    System.out.println("After union(7,3) ");
    System.out.println(qu);

  }

}
