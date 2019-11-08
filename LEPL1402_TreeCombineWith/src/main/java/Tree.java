public class Tree {

    public Node root;

    public Tree(Node root){
        this.root = root;
    }

    public Tree combineWith(Tree o){
        if(o==null){
            return this;
        }
        return new Tree(secondFunc(this.root,o.root));
    }
    public Node secondFunc(Node a, Node b){
        if (a==null && b==null){
            return null;
        }
        else if(a==null){
            return new Node(b.val,b.left,b.right);
        } else if (b == null) {
            return new Node(a.val,a.left,a.right);
        }
        else{
            return new Node(a.val + b.val, secondFunc(a.left,b.left), secondFunc(a.right,b.right));
        }
    }

}