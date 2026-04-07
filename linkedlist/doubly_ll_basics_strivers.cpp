#include <bits/stdc++.h>
using namespace std;

class Node {
public:
    int data;
    Node* next;
    Node* prev;

    Node(int data) : data(data), next(nullptr), prev(nullptr) {}
    Node(int data, Node* next, Node* prev) : data(data), next(next), prev(prev) {}
};

Node* convertArrtoDLL(const vector<int>& arr) {
    if (arr.empty()) return nullptr;
    Node* head = new Node(arr[0]);
    Node* tail = head;
    for (size_t i = 1; i < arr.size(); ++i) {
        Node* newNode = new Node(arr[i]);
        tail->next = newNode;
        newNode->prev = tail;
        tail = newNode;
    }
    return head;
}

void printDLL(Node* head) {
    cout << "printing DLL\n";
    while (head != nullptr) {
        cout << head->data << " ";
        head = head->next;
    }
    cout << '\n';
}

int main() {
    vector<int> arr = {12, 5, 8, 7};
    Node* head = convertArrtoDLL(arr);
    printDLL(head);
    return 0;
}