package binarySearchTree;

public class BinaryTree {
    /**
     * корневой узел.
     */
    private Node root;

    /**
     * Добавление значения в узел.
     *
     * @param value знаачение.
     */
    public void add(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            addRightLeft(root, value);

        }
    }

    /**
     * Рекурсивный вызов процедуры добавления в узел, если узел занят.
     *
     * @param begin узел для начала рекурсии.
     * @param value добавление значения.
     */
    private void addRightLeft(Node begin, int value) {
        if (value >= begin.getValue()) {
            if (begin.getRight() == null) {
                Node nextNode = new Node(value);
                begin.setRight(nextNode);
            } else {
                addRightLeft(begin.getRight(), value);
            }
        } else {
            if (begin.getLeft() == null) {
                Node nextNode = new Node(value);
                begin.setLeft(nextNode);
            } else {
                addRightLeft(begin.getLeft(), value);
            }
        }
    }

    /**
     * Получение значения самого левого узла в дереве.
     *
     * @return минимальное значение.
     */
    public int getMin() {
        Node left = root;

        while (true) {
            if (left.getLeft() == null) {
                break;
            }
            left = left.getLeft();
        }
        return left.getValue();
    }

    /**
     * Получение значения самого правого узла в дереве.
     *
     * @return максимальное значение.
     */
    public int getMax() {
        Node right = root;

        while (true) {
            if (right.getRight() == null) {
                break;
            }
            right = right.getRight();
        }
        return right.getValue();
    }
}