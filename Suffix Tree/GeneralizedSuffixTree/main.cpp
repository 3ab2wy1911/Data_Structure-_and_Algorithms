#include <iostream>
#include <cstring>

using namespace std;

// Node used to build the suffix tree.
struct Node {
    // We won't store any chars, what we need is the starting Index
    // and the length of the suffix...

    int edgeStart; // The index of the char in the original string.
    Node* child;  // The child of the node...
    // If we have banana$
    // then a is a node
    // which have na and $ as children...
    Node* next;   // The next child of the node....
    int suffixStart;
    int length; // The length of the suffix ... we can remove it if we want...

    Node () : child(nullptr), next(nullptr), edgeStart(-1), length(-1), suffixStart(-1) {}
    ~Node() {
        delete child;
        delete next;
    }
};

// Our beautiful tree

class SuffixTree {
public:
    Node *root;    // The root node ... the beginning of the tree.
    const char *str;   // The original string...
    int len; // The length of the string...

    // Parameterized constructor takes the string...
    explicit SuffixTree(const char *str) {
        this->root = new Node(); // Create a new root node
        this->str = str;   // Filling the string...
        this->len = (int) strlen(str);
        // Here we Start to build the tree...
        for (int i = len - 1; i >= 0; i--) {    // Looping through the string from the end...
            insert(root, i, i);   // calling the function insert...
        }
    }


    void insert(Node *node, int index, int suffixStart) {
        // In Insert if we found the node have no children...
        // And there is no other nodes ... then we are at the root...
        // Then just Insert the char...

        Node *current = node;  // Refer to the current node...
        Node *tmp = new Node();

        if (current->child == nullptr) {
            // First case no children for the node...
            current->child = new Node();   // Create the first child...
            updateNode(current->child, index);  // Update it...
            return; // No more operations needed...
        }

        // If we found a children for the node then we go to the first child...
        current = current->child;
        // Then we compare the suffix with the stored suffix in the node...
        // Till we get the maximum match ...
        // Then we just insert and split the node...
        while (current != nullptr) {    // loop through the children...

            if (getChar(current, index)) {  // If we found the first char in the node matching the first char in the current suffix...
                int matchingLength = getMaximumMatchLength(current, index);

                // then we must split and insert ...
                if (matchingLength < current->length) {
                    splitAndInsert(current, matchingLength);
                }
                insert(current, index + matchingLength, suffixStart);
                return;    // to end the insert operation;
            } else {
                tmp = current;
                current = current->next;
            }
        }

        // If we
        Node *newNode = new Node();
        newNode->edgeStart = index;
        newNode->length = len - index;
        newNode->suffixStart = suffixStart;
        tmp->next = newNode;
    }

    void updateNode(Node *current, int index) const {
        current->edgeStart = index;
        current->suffixStart = index;
        current->length = len - index;
    }

    bool getChar(Node *current, int index) const {
        return str[current->edgeStart] == str[index];
    }

    int getMaximumMatchLength(Node *current, int startingIndex) const {
        int i = current->edgeStart, j = startingIndex, result = 0;
        while (i < current->length + current->edgeStart and str[i] == str[j]) {
            ++i;
            ++j;
            ++result;
        }
        return result;
    }

    static void splitAndInsert(Node *current, int matchingLength) {

        // update the current and the new child...
        Node *newNode = new Node();
        newNode->edgeStart = current->edgeStart + matchingLength;
        newNode->length = current->length - matchingLength;
        newNode->suffixStart = current->suffixStart;

        // Minimize the length, and change the suffix start to -1 as it's no longer a leaf...
        current->length = matchingLength;
        current->suffixStart = -1;

        newNode->child = current->child;
        current->child = newNode;

    }

    [[maybe_unused]] void traverse() {
        traverse(root, 0);
    }

    void traverse(Node *current, int depth) {
        if (current == nullptr) {
            return;
        }

        // Print the current node
        for (int i = 0; i < depth; i++) {
            cout << "  "; // Add indentation for better visualization of the tree structure
        }

        cout << "Node: ";
        for (int i = current->edgeStart; i < current->edgeStart + current->length; i++) {
            cout << str[i];
        }
        cout << endl;

        // Recursively traverse the children
        if (current->child != nullptr) {
            for (int i = 0; i < depth + 1; i++) {
                cout << "  "; // Add indentation for better visualization
            }
            cout << "Child: ";
            traverse(current->child, depth + 1);
        }

        // Move to the next sibling node
        traverse(current->next, depth);
    }

    void search(const char* searchStr) {
        search(root, 0, searchStr);
    }

    void search(Node* node, int index, const char *searchStr){
        Node* current = node->child;    // get the first child of the node...

        // Looping through the children till finding a matching...
        while (current != nullptr and str[current->edgeStart] != searchStr[index]) {
            current = current->next;
            }

        if (current == nullptr) {   // If we didn't find a matching node just return...
            return;
        }

        // Otherwise start comparing the two suffixes...
        for (int i =current->edgeStart ; i<current->length + current->edgeStart; i++) {
            if (index > ::strlen(searchStr) - 1){
                break; // Index must not be greater than the length of the suffix.
            }
            if (str[i] == searchStr[index]) {
                index++;
                continue;
            }
            return;
        }

        if(index == ::strlen(searchStr)){
            getIndex(current);
            cout <<endl;
        }

        else if (index < ::strlen(searchStr)){
            search (current, index, searchStr);
        }
    }

    void getIndex(Node *current) { // Get the suffixStart...
        if (current != nullptr && current->suffixStart != -1) { // Check that we are on a leaf...
            cout << current->suffixStart << " ";
        }

        Node *node = ((current != nullptr) ? current->child : nullptr);
        while (node != nullptr) {
            getIndex(node);
            node = node->next;
        }
    }


};


int main() {
    // Test Case 0
    SuffixTree t0("bananabanaba$");
    cout << "Test Case 0:" << endl;
    cout << "Search for 'ana': ";
    t0.search("ana"); // Prints: 1 3 7
    cout << "Search for 'naba': ";
    t0.search("naba"); // Prints: 4 8
    cout << endl;

    // Test Case 1
    SuffixTree t1("programming$");
    cout << "Test Case 1:" << endl;
    cout << "Search for 'gram': ";
    t1.search("gram"); // Prints: 3
    cout << "Search for 'pro': ";
    t1.search("pro"); // Prints: 0
    cout << "Search for 'ing': ";
    t1.search("ing"); // Prints: 8
    cout << endl;

    // Test Case 2
    SuffixTree t2("abcdefgh$");
    cout << "\nTest Case 2:" << endl;
    cout << "Search for 'cde': ";
    t2.search("cde"); // Prints: 2
    cout << "Search for 'gh$': ";
    t2.search("gh$"); // Prints: 6
    cout << "Search for 'xyz': ";
    t2.search("xyz"); // Prints nothing
    cout << endl;

    // Test Case 3
    SuffixTree t3("abcdabcd$");
    cout << "\nTest Case 3:" << endl;
    cout << "Search for 'abc': ";
    t3.search("abc"); // Prints: 0 4
    cout << "Search for 'cd$': ";
    t3.search("cd$"); // Prints: 6
    cout << "Search for 'xy': ";
    t3.search("xy"); // Prints nothing
    cout << endl;

    // Test Case 4
    SuffixTree t4("\nabcde$");
    cout << "Test Case 4:" << endl;
    cout << "Search for 'bcd': ";
    t4.search("bcd"); // Prints: 1
    cout << "Search for 'e$': ";
    t4.search("e$"); // Prints: 4
    cout << "Search for 'xyz': ";
    t4.search("xyz"); // Prints nothing
    cout << endl;

    // Test Case 5
    SuffixTree t5("mississippi$");
    cout << "\nTest Case 5:" << endl;
    cout << "Search for 'ss': ";
    t5.search("ss"); // Prints: 2 5
    cout << "Search for 'pi': ";
    t5.search("pi"); // Prints: 9
    cout << "Search for 'xy': ";
    t5.search("xy"); // Prints nothing
    cout << endl;

    // Test Case 6
    SuffixTree t6("abcd$");
    cout << "\nTest Case 6:" << endl;
    cout << "Search for 'cd': ";
    t6.search("cd"); // Prints: 2
    cout << "Search for 'a': ";
    t6.search("a"); // Prints: 0
    cout << "Search for 'xyz': ";
    t6.search("xyz"); // Prints nothing
    cout << endl;

    // Test Case 7
    SuffixTree t7("abcdef$");
    cout << "\nTest Case 7:" << endl;
    cout << "Search for 'cde': ";
    t7.search("cde"); // Prints: 2
    cout << "Search for 'ab': ";
    t7.search("ab"); // Prints: 0
    cout << "Search for 'xyz': ";
    t7.search("xyz"); // Prints nothing
    cout << endl;

    // Test Case 8
    SuffixTree t8("xyzxyz$");
    cout << "\nTest Case 8:" << endl;
    cout << "Search for 'xy': ";
    t8.search("xy"); // Prints: 0 3
    cout << "Search for 'z': ";
    t8.search("z"); // Prints: 2 5
    cout << "Search for 'yz': ";
    t8.search("yz"); // Prints: 1 4
    cout << endl;

    // Test Case 9
    SuffixTree t9("aaaaaaa$");
    cout << "Test Case 9:" << endl;
    cout << "Search for 'aa': ";
    t9.search("aa"); // Prints: 0 1 2 3 4 5
    cout << "Search for 'a': ";
    t9.search("a"); // Prints: 0 1 2 3 4 5 6
    cout << "Search for 'ba': ";
    t9.search("ba"); // Prints nothing
    cout << endl;

    // Test Case 10
    SuffixTree t10("abcdefg$");
    cout << "\nTest Case 10:" << endl;
    cout << "Search for 'efg': ";
    t10.search("efg"); // Prints: 4
    cout << "Search for 'abc': ";
    t10.search("abc"); // Prints: 0
    cout << "Search for 'z': ";
    t10.search("z"); // Prints nothing
    cout << endl;
}





