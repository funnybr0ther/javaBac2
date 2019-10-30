public class Node {

    public int val;
    public Node left;
    public Node right;

    public Node(int val){
        this.val = val;
    }

    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }

    @Override
    public boolean equals(Object o){
        Node node = (Node) o;
        if(this.isLeaf() && ((Node) o).isLeaf()){
            return this.val == node.val;
        }
        else if (this.isLeaf() || ((Node) o).isLeaf()){
            return false;
        }
        else{
            return this.left.equals(node.left) && this.right.equals(node.right);
        }
    }
}