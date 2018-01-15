public class Test{

  public static void main(String [] args){
    QuickFindUF qf = new QuickFindUF(10);
    System.out.println(qf);

    qf.union(4,3);
    System.out.println("After union(4,3) ");
    System.out.println(qf);

    qf.union(3,8);
    System.out.println("After union(3,8) " );
    System.out.println(qf);

    qf.union(6,5);
    System.out.println("After union(6,5) " );
    System.out.println(qf);

    qf.union(9,4);
    System.out.println("After union(9,4) ");
    System.out.println(qf);

    qf.union(2,1);
    System.out.println("After union(2,1) ");
    System.out.println(qf);

    System.out.println("isConnected(8,9)? " + qf.isConnected(8,9));
    System.out.println(qf);

    System.out.println("isConnected(0,5)? " + qf.isConnected(0,5));
    System.out.println(qf);

    qf.union(5,0);
    System.out.println("After union(5,0) ");
    System.out.println(qf);

    qf.union(7,2);
    System.out.println("After union(7,2) ");
    System.out.println(qf);

    qf.union(6,1);
    System.out.println("After union(6,1) " );
    System.out.println(qf);

  }

}
