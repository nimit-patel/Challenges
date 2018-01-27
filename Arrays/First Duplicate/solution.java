int firstDuplicate(int[] a) {
    int len = a.length;

    // changing sign is quick compare to adding length to a value

    for(int index = 0; index < len; ++index){

        int val_index = Math.abs(a[index])-1;

        if(a[val_index] < 0){
            return Math.abs(a[index]);
        }else{
            a[val_index] *= -1; // mark visited
        }

    }
        return -1;
}
