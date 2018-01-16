public class QuickUnion{
  private int [] objs;
  private int size;

  // Stores integers as in a tree type structure
  public QuickUnion(int size){
    this.size = size;

    objs = new int[this.size];

    for(int index = 0; index < size; ++index){
      objs[index] = index;
    }
  }


  public void union(int p, int q){
    if(p >= 0 && p < size && q >=0 && q < size){

        // p is acting as a child and q as a parent
        /*
        while(this.objs[q] != q){ // while q is not a root of itself
          q = this.objs[q];
        }

        while(this.objs[p] != p){ // p is not a root of itself
          p = this.objs[p];
        }*/

        // once they are root of themselves sassign q as a parent to p
        this.objs[findRoot(p)] = findRoot(q);
    }
  }

  public boolean isConnected(int p, int q){
    if(p >= 0 && p < size && q >=0 && q < size)
      return findRoot(p) == findRoot(q); // if they have same root they are connected

    return false;
  }

  private int findRoot(int index){
    if(this.objs[index] == index) // this is guranteed to happen as there are no cycles
      return index;

    return findRoot(this.objs[index]);
  }

  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("[");

    for(int index = 0; index < size - 1; ++index){
        sb.append(this.objs[index] + ",");
    }

    sb.append(this.objs[size - 1] + "]");

    return sb.toString();
  }

}
