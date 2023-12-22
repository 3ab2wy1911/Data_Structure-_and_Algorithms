#include <iostream>
using namespace std;

struct Node{    // Interval Tree Node...
    int max;    // Maximum endpoint on the branch...
    pair<int,int> interval; // The interval stored in the node...
    Node* left; // Left child...
    Node* right; // Right child...

    Node():left(nullptr), right(nullptr) {};    // Default constructor...
};

//----------------------------------------------------------------

class IntervalTree{ //Interval Tree class...
public:
    Node* root; // Root node...
    IntervalTree(){ // Default constructor...
        root = nullptr; // Very Important to assign the root to null "not calling its constructor"...
    }

    void insert(pair<int,int> interval){    // Insert the interval...
        insert(root, interval);
    }

    void insert(Node*& current, pair<int,int> interval){    // Take the current Node by its address and the interval we are inserting...
        if (current == nullptr){    // In case if we reach the end of the tree...
            current = new Node();   // Create a new node...
            // Start initializing the attributes of the node...
            current->interval = interval;
            current->max = interval.second;
            current->left = current->right = nullptr;
            return; // End the insertion process...
        }

        // Otherwise we are on a not empty node...
        // We are here augmenting Non Balanced BST so the insertion process will be so easy...
        // Decide which subtree we will go to...
        if (interval.first < current->interval.first) { // Here the lower bound of the interval is lower than the lower bound of the node...
            insert(current->left, interval);    // So we will go to the left subtree...
        }
        else {  // Otherwise we will go to the right subtree...
            insert(current->right, interval);
        }
        if (root->max < interval.second){   // Of course, we will update the max as it's represent the maximum endpoint of the subtree...
            root->max = interval.second;
        }
    }

    void inorderTraverse(Node* current) {   // Inorder traverse Left -> Root -> Right...
        if (current != nullptr) {
            inorderTraverse(current->left);
            cout << "[" << current->interval.first << ", " << current->interval.second << "] ";
            inorderTraverse(current->right);
        }
    }

    Node* search(Node* node, pair<int, int> query) {

        if (node == nullptr) {  // In case of empty tree...
            return nullptr;
        }

        // If the query interval overlaps with the current node's interval...
        if (query.first <= node->interval.second && query.second >= node->interval.first) {
            return node;
        }

        // If the left child is not null and its max endpoint is greater than or equal to the query start...
        if (node->left != nullptr && query.first <= node->left->max) {
            return search(node->left, query);
        }

        // Otherwise, search in the right subtree...
        return search(node->right, query);
    }

    void search(pair<int, int> query) {
        Node* result = search(root, query);
        if (result != nullptr) {
            cout << "Found interval: [" << result->interval.first << ", " << result->interval.second << "]" << endl;
        } else {
            cout << "Interval not found." << endl;
        }
    }

};


int main() {
    IntervalTree tree;

    // Insert intervals
    tree.insert(make_pair(3, 8));
    tree.insert(make_pair(1, 5));
    tree.insert(make_pair(6, 10));
    tree.insert(make_pair(9, 12));
    tree.insert(make_pair(0, 2));

    // Print intervals in sorted order
    cout << "Intervals in  Inorder Traverse : ";
    tree.inorderTraverse(tree.root);
    cout << endl;

    // Search for an interval
    tree.search(make_pair(4, 7));

    return 0;
}

