import sys
class Node:
    def __init__(self, head, value):
        self.head = head
        self.value = value
        self.node = {}
    
    def add_child(self, value, child_node):
        if value not in self.node:
            self.node[value] = child_node

    def find_node(self, target_value):
        return self.node.get(target_value)

class Tree:
    def __init__(self):
        self.root = Node(None, "root")

    def add_node(self, word):
        current_node = self.root
        for char in word:
            if current_node.find_node(char) is None:
                new_node = Node(current_node, char)
                current_node.add_child(char, new_node)
            current_node = current_node.find_node(char)

    def find_node(self, word):
        current_node = self.root
        for char in word:
            current_node = current_node.find_node(char)
            if current_node is None:
                return False
        return True


input = sys.stdin.readline
N, M = map(int, input().split(" "))
answer = 0
tree = Tree()
for _ in range(N):
    word = input()
    tree.add_node(word)

for _ in range(M):
    target_word = input().strip()
    if tree.find_node(target_word):
        answer += 1

print(answer)