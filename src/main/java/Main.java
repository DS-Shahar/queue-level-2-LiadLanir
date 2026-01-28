public class Main
{
	public static void main(String[] args) {
	    BinNode<Integer> n2 = new BinNode<>(2);
        BinNode<Integer> n5 = new BinNode<>(5);
        BinNode<Integer> n8 = new BinNode<>(8);
        BinNode<Integer> n4 = new BinNode<>(n2, 4, n5);
        BinNode<Integer> root = new BinNode<>(n4, 10, n8);

        SabaGadol(root);
	}
	public static boolean isEvenWithoutOddChild(BinNode<Integer> node) {
    if (node == null) return false;

    int val = node.getValue();
    if (val % 2 != 0) return false; // הצומת עצמו לא זוגי

    if (node.hasLeft() && node.getLeft().getValue() % 2 != 0)
        return false;

    if (node.hasRight() && node.getRight().getValue() % 2 != 0)
        return false;

    return true;
}
		public static void printNodes(BinNode<Integer> root) {
	    if (root == null) return;
	
	    if (isEvenWithoutOddChild(root)) {
	        System.out.println(root.getValue());
	    }
	
	    printNodes(root.getLeft());
	    printNodes(root.getRight());
	}
	public static int countNodes(BinNode<Integer> root) {
	    if (root == null) return 0;
	
	    int count = isEvenWithoutOddChild(root) ? 1 : 0;
	
	    return count
	         + countNodes(root.getLeft())
	         + countNodes(root.getRight());
	}
	public static boolean allNodes(BinNode<Integer> root) {
    if (root == null) return true;

    if (!isEvenWithoutOddChild(root)) return false;

    return allNodes(root.getLeft())
        && allNodes(root.getRight());
}

}








