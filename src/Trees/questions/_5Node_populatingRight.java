package Trees.questions;

public class _5Node_populatingRight {
    public int val;
    public _5Node_populatingRight left;
    public _5Node_populatingRight right;
    public _5Node_populatingRight next;

    public _5Node_populatingRight() {
    }

    public _5Node_populatingRight(int val) {
        this.val = val;
    }

    public _5Node_populatingRight(int val, _5Node_populatingRight left, _5Node_populatingRight right, _5Node_populatingRight next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public _5Node_populatingRight connect(_5Node_populatingRight root) {
        if (root == null) {
            return null;
        }
        _5Node_populatingRight leftmost = root;
        while (leftmost.left != null) {
            _5Node_populatingRight current = leftmost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {//for connecting that 5 and 6
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    public static void main(String[] args) {
        _5Node_populatingRight obj=new _5Node_populatingRight();

    }
}
