package redAndBlackTree;

public class RBTree<K extends Comparable<K>,V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;



    static class RBNode<K extends Comparable<K>,V>{
        private RBNode parent;
        private RBNode left;
        private RBNode right;
        private boolean color;
        private K key;
        private V value;

        private RBNode root;

        private void leftRotate(RBNode x){
            RBNode y = x.right;
            x.right = y.left;
            if(y.left!=null){
                y.left.parent = x;
            }
            if(x.parent!=null){
                y.parent = x.parent;
                if(x.parent.left==x){
                    x.parent.left = y;
                }else if(x.parent.right==x){
                    x.parent.right = y;
                }
            }else {
                this.root = y;
                this.root.parent=null;
            }

            y.left = x;
            x.parent = y;
        }
        private void rightRotate(RBNode x){
            RBNode y = x.left;
            x.left = y.right;
            if(y.right!=null){
                y.right.parent = x;
            }
            if(x.parent!=null){
                y.parent = x.parent;
                if(x.parent.left==x){
                    x.parent.left = y;
                }else if(x.parent.right==x){
                    x.parent.right = y;
                }
            }else {
                this.root = y;
                this.root.parent=null;
            }

            y.right = x;
            x.parent = y;
        }

        public void insert(K key,V value){
            RBNode<K, V> node = new RBNode<>();
            node.setColor(RED);
            node.setKey(key);
            node.setValue(value);
            insert(node);
        }
        public void insert(RBNode node){
            RBNode x = this.root;
            RBNode parent = null;
            while (x!=null){
                parent = x;
                int cmp = node.key.compareTo(x.getKey());
                if(cmp>0){
                    x = x.right;
                }else if(cmp==0){
                    x.value = node.getValue();
                    return;
                }else {
                    x = x.left;
                }
            }
            node.parent = parent;
            if(parent!=null){
                int cmp = node.key.compareTo(parent.getKey());
                if(cmp>0){
                    parent.right = node;
                }else {
                    x = x.left;
                }
            }else {
                this.root = node;
            }
            insertFixup(node);
        }

        public void insertFixup(RBNode node){
            this.root.setColor(BLACK);
            RBNode parent = parentOf(node);
            RBNode gParent = parentOf(parent);
            //parent不是null则爷爷一定不是null
            if(parent!=null&&parent.color==RED){
                RBNode uncle = null;
                if(parent == gParent.left){
                    uncle = gParent.right;
                    if(uncle!=null&&uncle.color==RED){
                        parent.color = BLACK;
                        uncle.color = BLACK;
                        gParent.color = RED;
                        insertFixup(gParent);
                        return;
                    }
                    if(uncle==null||uncle.color==BLACK){
                        if(parent.left==node){
                            parent.setColor(BLACK);
                            gParent.setColor(RED);
                            rightRotate(gParent);
                            return;
                        }else{
                            leftRotate(parent);
                            insertFixup(parent);
                            return;
                        }
                    }
                }else {
                    uncle = gParent.left;
                    if (uncle != null && uncle.color == RED) {
                        parent.color = BLACK;
                        uncle.color = BLACK;
                        gParent.color = RED;
                        insertFixup(gParent);
                        return;
                    }
                    if (uncle == null || uncle.color == BLACK) {
                        if (parent.right == node) {
                            parent.setColor(BLACK);
                            gParent.setColor(RED);
                            leftRotate(gParent);
                            return;
                        } else {
                            rightRotate(parent);
                            insertFixup(parent);
                            return;
                        }
                    }
                }
            }
        }

        private void inOrderPrint(){
            inOrderPrint(this.root);
        }
        private void inOrderPrint(RBNode node){
            if(node!=null){
                inOrderPrint(node.left);
                System.out.println(node.value);
                inOrderPrint(node.right);
            }
        }
        private void setRed(RBNode node){
            if(node!=null){
                node.color=RED;
            }
        }
        private void setBlack(RBNode node){
            if(node!=null){
                node.color=BLACK;
            }
        }
        private RBNode parentOf(RBNode node){
            if(node!=null){
                return node.parent;
            }
            return null;
        }
        private boolean isRed(RBNode node){
            if(node!=null){
                return node.color==RED;
            }
            return false;
        }
        private boolean isBlack(RBNode node){
            if(node!=null){
                return node.color==BLACK;
            }
            return false;
        }

        public RBNode getParent() {
            return parent;
        }

        public RBNode() {
        }

        public void setParent(RBNode parent) {
            this.parent = parent;
        }

        public RBNode getLeft() {
            return left;
        }

        public void setLeft(RBNode left) {
            this.left = left;
        }

        public RBNode getRight() {
            return right;
        }

        public void setRight(RBNode right) {
            this.right = right;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public RBNode(RBNode parent, RBNode left, RBNode right, boolean color, K key, V value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.color = color;
            this.key = key;
            this.value = value;
        }
    }
}
