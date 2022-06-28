#include <string>
#include <vector>
#include <algorithm>
using namespace std;

struct Tree {
    int idx; // 값
    int x, y; // 좌표
    Tree* left;
    Tree* right;
};

bool cmp(Tree A, Tree B) {
    // y값이 크면 앞으로 
    if (A.y > B.y) return true;
    else if (A.y < B.y) return false;
    // y값이 같으면 x값이 작으면 앞으로
    else {
        if (A.x < B.x) return true;
        else return false;
    }
}

void makeBinaryTree(Tree* root, Tree* child) {
    if (root->x > child->x) {
        if (root->left == NULL) {
            root->left = child;
            return;
        }
        makeBinaryTree(root->left, child);
    }
    else {
        if (root->right == NULL) {
            root->right = child;
            return;
        }
        makeBinaryTree(root->right, child);
    }
}

void preOrder(Tree* root, vector<int>& answer) {
    if (root == NULL) return;
    answer.push_back(root->idx);
    preOrder(root->left, answer);
    preOrder(root->right, answer);
}

void postOrder(Tree* root, vector<int>& answer) {
    if (root == NULL) return;
    postOrder(root->left, answer);
    postOrder(root->right, answer);
    answer.push_back(root->idx);
}

vector<vector<int>> solution(vector<vector<int>> nodeinfo) {
    vector<vector<int>> answer;
    vector<Tree> tr;

    // node 생성
    for (int i = 0; i  < nodeinfo.size(); i++) {
        int x = nodeinfo[i][0];
        int y = nodeinfo[i][1];
        int idx = i + 1;
        tr.push_back({ idx, x, y, NULL, NULL });
    }

    // 트리 생성을 위한 정렬
    sort(tr.begin(), tr.end(), cmp);
    
    // 트리 생성
    Tree* root = &tr[0];
    for (int i = 1; i < tr.size(); i++) makeBinaryTree(root, &tr[i]);
    
    // 전위 순회
    vector<int> pre;
    preOrder(root, pre);
    
    // 후위 순회
    vector<int> post;
    postOrder(root, post);
    
    // answer에 넣기
    answer.push_back(pre);
    answer.push_back(post);

    return answer;
}
