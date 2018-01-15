public class QuickFindUF{
  private int [] objs;
  private int size;

  public QuickFindUF(int size){
    this.size = size;

    objs = new int[this.size];

    for(int index = 0; index < size; ++index){
      objs[index] = index;
    }

  }

  public void union(int p, int q){
    // to avoid index out of bound
    if(p >= 0 && p < this.size && q >= 0 && q < this.size){

      int toChange = objs[p];                      // important to store it as the value at index p
                                                  //  might change later on; resulting in a bugs
      int changeTo = objs[q];

      for(int index = 0; index < size; ++index){   // those connected to p now needs to connect to q
        if(this.objs[index] == toChange)          // every object that is connect to p must change
            this.objs[index] = changeTo;
      }
    }

  }

  public boolean isConnected(int p, int q){
    // to avoid index out of bound
    if(p >= 0 && p < size && q >= 0 && q < size)
      return this.objs[p] == this.objs[q];

    return false;
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
