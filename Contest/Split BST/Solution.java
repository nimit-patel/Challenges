class Solution {
    public TreeNode[] splitBST(TreeNode root, int V) {

       // no split possible
        if(root == null)
            return new TreeNode[]{null, null};

        TreeNode[] result = new TreeNode[2];

        // Special case: root split
        if(root.val == V){
            result[0] = root;
            result[1] = root.right;
            root.right = null;      // split
            return result;
        }

        TreeNode prevToRoot = null;
        result[1] = root;
        while(root != null){
            if(V < root.val){
                prevToRoot = root;
                root = root.left;
            }else if(V > root.val){
                prevToRoot = root;
                root = root.right;
            }else{                          //match found
                result[0] = root;

                if(root.equals(prevToRoot.left)){
                    prevToRoot.left = root.right;
                }else{
                    prevToRoot.right = root.right;
                }
                root.right = null;
                break;
            }

        }

        return result;
    }
}
