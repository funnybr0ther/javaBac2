public class Tree {

    public Node root;

    public Tree(Node root){
        this.root = root;
    }

    @Override
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        Tree tree;
        try{
            tree = (Tree)o;
        } catch (Exception e) {
            return false;
        }
        if(tree.root == null && this.root == null){
            return true;
        }
        else if(tree.root == null || this.root == null){
            return false;
        }
        else{
            return this.root.equals(tree.root);
        }
    }

}