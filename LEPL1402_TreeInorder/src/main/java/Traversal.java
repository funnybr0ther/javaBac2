import java.util.List;
import java.util.Stack; // this should give you a hint for the iterative version

public class Traversal {

    public static void recursiveInorder(Node root, List<Integer> res) {
        if (root == null){
            return;
        }
        else if(root.isLeaf()){
            res.add(root.val);
            return;
        }
        else{
            recursiveInorder(root.left,res);
            res.add(root.val);
            recursiveInorder(root.right,res);
        }
    }


    public static void iterativeInorder(Node root, List<Integer> res){
        if (root == null)
            return;


        Stack<Node> s = new Stack<Node>();
        Node curr = root;

        while (curr != null || s.size() > 0)
        {

            while (curr !=  null)
            {

                s.push(curr);
                curr = curr.left;
            }
           curr = s.pop();

            res.add(curr.val);

            curr = curr.right;
        }
    }
}