public class BinaryTree {

    private TreeNode myRoot;

    public BinaryTree() {
        myRoot = null;
    }

    public BinaryTree(TreeNode t) {
        myRoot = t;
    }

    // Print the values in the tree in preorder: root value first,
    // then values in the left subtree (in preorder), then values
    // in the right subtree (in preorder).
    public void printPreorder() {
        if (myRoot == null) {
            System.out.println("(empty tree)");
        } else {
            myRoot.printPreorder();
            System.out.println();
        }
    }

    // Print the values in the tree in inorder: values in the left
    // subtree first (in inorder), then the root value, then values
    // in the right subtree (in inorder).
    public void printInorder() {
        if (myRoot == null) {
            System.out.println("(empty tree)");
        } else {
            myRoot.printInorder();
            System.out.println();
        }
    }

    public void fillSampleTree1() {
        myRoot = new TreeNode("a", new TreeNode("b"), new TreeNode("c"));
    }

    public void fillSampleTree2() {
        myRoot = new TreeNode("a", new TreeNode("b", new TreeNode("d", new TreeNode("e"), new TreeNode("f")), null), new TreeNode("c"));
    }

    public int height() {
        if(myRoot != null) {
            return myRoot.height();
        }
        return 0;
    }

    public boolean isCompletelyBalanced(){
        if(myRoot != null) {
            return myRoot.isCompletelyBalanced();
        }
        return false;
    }

    public void print() {
        if (myRoot != null) {
            myRoot.print(0);
        }
    }

    public static BinaryTree fibTree (int n) {
        BinaryTree result = new BinaryTree();
        result.myRoot = result.fibTreeHelper (n);
        return result;
    }
    
    private TreeNode fibTreeHelper (int n) {
        if (n == 0 || n == 1) {
            return new TreeNode(n);
        }
        else {
            TreeNode node = new TreeNode(1, fibTreeHelper(n-1), fibTreeHelper(n-2));
            int rootValue = (int) node.myLeft.myItem + (int) node.myRight.myItem;
            return new TreeNode(rootValue, node.myLeft, node.myRight);
        }
    }

    public static BinaryTree exprTree (String s) {
        BinaryTree result = new BinaryTree();
        result.myRoot = result.exprTreeHelper (s);
        return result;
    }

    // Return the tree corresponding to the given arithmetic expression.
    // The expression is legal, fully parenthesized, contains no blanks, 
    // and involves only the operations + and *.
    private TreeNode exprTreeHelper (String expr) {
        if (expr.charAt (0) != '(') {
            return new TreeNode(expr);
        } else {
            // expr is a parenthesized expression.
            // Strip off the beginning and ending parentheses,
            // find the main operator (an occurrence of + or * not nested
            // in parentheses, and construct the two subtrees.
            int nesting = 0;
            int opPos = 0;
            int end = 0;
            for (int k = 1; k < expr.length() - 1; k++) {  
                    if(expr.charAt(k) == '+' || expr.charAt(k) == '*' ) {
                        if(nesting == 0) {
                            opPos = k;
                            break;
                        }
                        nesting--;
                    }
                    else if(expr.charAt(k) == '(') {
                        nesting++;
                    }
            }
            String opnd1 = expr.substring (1, opPos);
            String opnd2 = expr.substring (opPos+1, expr.length()-1);
            String op = expr.substring (opPos, opPos+1);
            System.out.println ("expression = " + expr);
            System.out.println ("operand 1 = " + opnd1);
            System.out.println ("operator = " + op);
            System.out.println ("operand 2 = " + opnd2);
            System.out.println ( );
            return new TreeNode(op, exprTreeHelper(opnd1), exprTreeHelper(opnd2));
        }
    }

    public void optimize() {
        if(myRoot != null) {
           myRoot.optimize(myRoot);
        }
    }


    public static void main(String[] args) {
        BinaryTree t;
        t = new BinaryTree();
        print(t, "the empty tree");
        t.fillSampleTree1();
        print(t, "sample tree 1");
        t.fillSampleTree2();
        print(t, "sample tree 2");

        System.out.println("height = " + t.height());
        System.out.println("isCompletelyBalanced = " + t.isCompletelyBalanced());
        System.out.println("\nTest: print\n");
        t.print();

        BinaryTree a = new BinaryTree();
        a = a.fibTree(5);
        a.print();


        BinaryTree b = new BinaryTree();
        b = b.exprTree("((a+(5*(9+1)))+(6*5))");
        b.print();

        System.out.print("\nTest for optimize");
        BinaryTree c = new BinaryTree();
        c = c.exprTree("((2+3)+1)");
        c.print();
        c.optimize();
        c.print();

    }

    private static void print(BinaryTree t, String description) {
        System.out.println(description + " in preorder");
        t.printPreorder();
        System.out.println(description + " in inorder");
        t.printInorder();
        System.out.println();
    }

    private static class TreeNode {

        public Object myItem;
        public TreeNode myLeft;
        public TreeNode myRight;

        public TreeNode(Object obj) {
            myItem = obj;
            myLeft = myRight = null;
        }

        public TreeNode(Object obj, TreeNode left, TreeNode right) {
            myItem = obj;
            myLeft = left;
            myRight = right;
        }

        private void printPreorder() {
            System.out.print(myItem + " ");
            if (myLeft != null) {
                myLeft.printPreorder();
            }
            if (myRight != null) {
                myRight.printPreorder();
            }
        }

        private void printInorder() {
            if (myLeft != null) {
                myLeft.printInorder();
            }
            System.out.print(myItem + " ");
            if (myRight != null) {
                myRight.printInorder();
            }
        }

        public int height() {
            if(myLeft != null & myRight != null) {
                return 1 + Math.max(myLeft.height(), myRight.height());
            }
            else if(myLeft == null && myRight == null) {
                return 1;
            }
            else if(myLeft == null) {
                return 1 + this.myRight.height();
            }
                return 1 + this.myLeft.height();
        }
        public boolean isCompletelyBalanced() {
            if(myLeft == null && myRight == null) {
                return true;
            }
            else if(myLeft != null && myRight != null) {
                return myLeft.height() == myRight.height();
            }
            return false;
        }

        private static final String indent1 = "    ";

        private void print(int indent) {
            if(myRight != null && myLeft != null) {
                myRight.print(indent + 2);
                println(myItem, indent);
                myLeft.print(indent + 2);
            }
            else if(myLeft != null) {
                myLeft.print(indent + 2);
                println(myItem, indent);
            }
            else if(myRight != null) {
                myRight.print(indent + 2);
                println(myItem, indent);
            }
            else {
                println(myItem, indent);
            }
        }

        private static void println (Object obj, int indent) {
            for (int k = 0; k < indent; k++) {
                System.out.print(indent1);
            }
            System.out.println (obj);
        }

        public void optimize(TreeNode tree) {
            // if(myItem.equals("+")) {
            //     if(!myLeft.myItem.equals("+") && !myLeft.myItem.equals("*") && !myRight.myItem.equals("+") && !myRight.myItem.equals("*") ) {
            //         // myItem =((Integer.parseInt(myLeft.myItem)) + (Integer.parseInt(myRight.myItem)));
            //         int a = Integer.valueOf((String) myLeft.myItem); 
            //         int b = Integer.valueOf((String) myRight.myItem); 
            //         myItem = a + b;
            //         myLeft = myRight = null;
            //     }
            //     else if (myLeft.myItem.equals("+") || myLeft.myItem.equals("*")) {
            //         optimize(myLeft);
            //         if (myRight.myItem.equals("+") || myRight.myItem.equals("*")) {
            //             optimize(myRight);
            //         }
            //     }
            //     else if (myRight.myItem.equals("+") || myRight.myItem.equals("*")) {
            //         optimize(myRight);
            //         if (myLeft.myItem.equals("+") || myLeft.myItem.equals("*")) {
            //             optimize(myLeft);
            //         }
            //     }
            // }
            // else if(myItem.equals("*")) {
            //     if(!myLeft.myItem.equals("+") && !myLeft.myItem.equals("*") && !myRight.myItem.equals("+") && !myRight.myItem.equals("*") ) {
            //         // myItem = myLeft.myItem * myRight.myItem;
            //         int a = Integer.valueOf((String) myLeft.myItem); 
            //         int b = Integer.valueOf((String) myRight.myItem); 
            //         myItem = a * b;
            //         myLeft = myRight = null;
            //     }
            //     else if (myLeft.myItem.equals("+") || myLeft.myItem.equals("*")) {
            //         optimize(myLeft);
            //         if (myRight.myItem.equals("+") || myRight.myItem.equals("*")) {
            //             optimize(myRight);
            //         }
            //     }
            //     else if (myRight.myItem.equals("+") || myRight.myItem.equals("*")) {
            //         optimize(myRight);
            //         if (myLeft.myItem.equals("+") || myLeft.myItem.equals("*")) {
            //             optimize(myLeft);
            //         }
            //     }
            // }
            // else if(myItem.equals("a")) {
            //     if(myLeft != null && myRight == null) {
            //         optimize(myLeft);
            //     }
            //     else if(myRight != null && myLeft == null) {
            //         optimize(myRight);
            //     }
            // }

            if(myItem.equals("+")) {
                if(!myLeft.myItem.equals("+") && !myRight.myItem.equals("+")) {
                    int a = Integer.valueOf((String) myLeft.myItem); 
                    int b = Integer.valueOf((String) myRight.myItem); 
                    myItem = a + b;
                    myLeft = myRight = null;
                }
                // if(myLeft.myItem.equals("+")) {
                //     optimize(myLeft);
                // }
                if(myRight.myItem.equals("+")) {
                    optimize(myRight);
                }
            }
        }
    }
}

// 1 5 2 4 3 9 6 8 7 11 10 Integer.parseInt("1234");