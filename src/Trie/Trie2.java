package Trie;

public class Trie2 {
    static class Node {
        Node[] links;
        //counter for number of words that ends at this node
        int cntEndWith;
        //counter for number of words that have this node as a prefix
        int cntPrefix;

        //Constructor  for node
        Node() {
            links = new Node[26];
            cntEndWith = 0;
            cntPrefix = 0;
        }

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        public Node get(char ch) {
            return links[ch - 'a'];
        }

        public void increasePrefix() {
            cntPrefix++;
        }

        void increaseEnd() {
            // Increment the counter
            cntEndWith++;
        }

        void deleteEnd() {
            // Decrement the counter
            cntEndWith--;
        }

        void reducePrefix() {
            // Decrement the counter
            cntPrefix--;
        }
    }

    private Node root;

    Trie2() {
        root = new Node();
    }

    void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {//if not there then create a new node
                node.put(word.charAt(i), new Node());
            }
            //move to the child node corresponding to the character
            node = node.get(word.charAt(i));
            //increase the prefix count for the node
            node.increasePrefix();
        }
        //increment the end count for the last node of the word
        node.increaseEnd();

    }

    int countWordsEqualTo(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                //if character is found then move to the next child node
                node = node.get(word.charAt(i));
            } else {
                //return 0 if not found
                return 0;
            }
        }
        //return the count of the words ending at the node
        return node.cntEndWith;
    }

    int countWordsStartingWith(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                //if found move to the next node
                node = node.get(word.charAt(i));
            } else {
                return 0;
            }
        }
        //return the count of words with the prefix
        return node.cntPrefix;
    }

    void erase(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                node.reducePrefix();
            } else {
                return;
            }
        }
        node.deleteEnd();
    }


        public static void main(String[] args) {
            Trie2 trie = new Trie2();
            trie.insert("apple");
            trie.insert("app");
            System.out.println("Inserting strings 'apple', 'app' into Trie");
            System.out.print("Count Words Equal to 'apple': ");
            System.out.println(trie.countWordsEqualTo("apple"));
            System.out.print("Count Words Starting With 'app': ");
            System.out.println(trie.countWordsStartingWith("app"));
            System.out.println("Erasing word 'app' from trie");
            trie.erase("app");
            System.out.print("Count Words Equal to 'apple': ");
            System.out.println(trie.countWordsEqualTo("apple"));
            System.out.print("Count Words Starting With 'apple': ");
            System.out.println(trie.countWordsStartingWith("app"));
        }
    }

