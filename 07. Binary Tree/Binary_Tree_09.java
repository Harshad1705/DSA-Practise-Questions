// vertical order traversal
// cdoe in in c++ language






// vector<int> verticalOrder(Node *root)
// {
//                                             
//     map<int,map<int,vector<int>>> nodes;                                             maps the horizontal distance with level and vector that contain element
//     queue<pair<Node*,pair<int,int>>> q;                                              queue in which two unkown parameter extra added to find value of horizonatal distance and level
//     vector<int> result;
    
//     q.push(make_pair(root,make_pair(0,0)));                                          insert first node(root) in queue having horizonal distance=0 and level=0
    
//     while(!q.empty()){
        
//         pair<Node*,pair<int,int>> temp = q.front();                                  pop first value of queue
//         q.pop();
        
//         Node* node = temp.first;                                                     extract node
//         int horizontal_distance = temp.second.first;                                 extract horizonal distance
//         int level = temp.second.second;                                              extract level
         
//         nodes[horizontal_distance][level].push_back(node->data);                     update the map vector
        
//         if(node->left!=NULL){
//             q.push(make_pair(node->left,make_pair(horizontal_distance-1,level+1)));    if(left not null) insert in queue
//         }
//         if(node->right!=NULL){
//             q.push(make_pair(node->right,make_pair(horizontal_distance+1,level+1)));     if(right not null) insert in queue
//         }
//     }
//     for(auto i : nodes){
//         for(auto j : i.second){
//             for(auto k : j.second){
//                 result.push_back(k);                                                      push result in vector 
//             }
//         }
//     }
    
//     return result;
// }
// };
