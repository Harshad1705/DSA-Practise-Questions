// lowest comon ancestor in BST 

public class BST_05 {

    public static BST_01.Node LCAinaBST(BST_01.Node root, int  p, int q) 
    {		
       
        while(root!=null){
            // for right subtree
            if(root.data < p && root.data < q){
                root = root.right;
            // for left subtree
            }else if(root.data > p && root.data > q){
                root = root.left;
            // for root
            }else{
                return root;
            }
        }
        
        return null;
	}

    public static void main(String[] args) {

        int[] arr={4,2,3,1,5}; 

        BST_01.Node root = null;

        for(int i : arr){
            root = BST_01.insert(root, i);
        }

        System.out.println(LCAinaBST(root, 2, 4).data);
    }
    
}
