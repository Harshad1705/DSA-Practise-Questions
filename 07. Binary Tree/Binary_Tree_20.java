
// Construct Tree from Inorder & PostOrder 


public class Binary_Tree_20 {

    public static int pos(int[] in , int n , int key){
        for(int i=0 ; i<n ;i++){
            if(in[i]==key){
                return i;
            }
        }
        return -1;
    }

    public static Binary_Tree_01.Node solve(int[] inorder, int[] postorder,  int startIndex, int endIndex,int n) {
        // base case 
        if(index<0 || startIndex>endIndex){
            return null;
        }

        // create node
        int ele = postorder[index];
        Binary_Tree_01.Node root = new Binary_Tree_01.Node(ele);
        // find position
        int position = pos(inorder,n,ele);

        index--;

        // recursive calls
        root.right = solve(inorder, postorder, position+1, endIndex, n);
        root.left = solve(inorder, postorder,  startIndex, position-1, n);

        return root;

    }
    static int index;

    public static Binary_Tree_01.Node buildTree(int[] inorder , int[] postorder , int n){

        index = n-1;
        int startIndex = 0;
        int endIndex = n-1;


        Binary_Tree_01.Node root = solve(inorder , postorder , startIndex , endIndex , n);

        return root;
    }

    

    public static void main(String[] args) {
        int inorder[] = {4,8,2,5,1,6,3,7};
        int postorder[] = {8,4,5,2,6,7,3,1};
        int n = 8;

        Binary_Tree_01.Node root = buildTree(inorder , postorder , n);

        Binary_Tree_01.levelOrderTraversal(root);
    }

}






// c++



// Node* solve(int in[] , int post[] , int &index ,
//         int start , int end , int n , map<int,int> &m){
//     if(index<0 || start>end){
//         return NULL;
//     }
//     int ele = post[index];
//     Node* root = new Node(ele);
//     int pos = m[ele];
    
//     root->right = solve(in,post,index--,pos+1,end,n,m);
//     root->left = solve(in,post,index-- , start, pos-1,n,m);
    
//     return root;
// }
// void create_map(map<int,int> m , int[] in ,int n){
//     for(int i=0;i<n;i++){
//         map[in[i]] = i;
//     }
// }
// Node *buildTree(int in[], int post[], int n) {
//     // Your code here
//     map<int,int> m;
//     create_map(m ,  in , n);
    
//     int index = n-1;
//     int startIndex = 0;
//     int endIndex = n-1;
//     Node* root = solve(in , post ,index , startIndex ,endIndex,n , m);
//     return root;
// }
