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
	public static void ThilitPrint(BinNode<Integer> t)
	{
	    if(t==null)
	    {
	        return;
	    }
	    System.out.println(t.getValue());
	    ThilitPrint(t.getLeft());
	    ThilitPrint(t.getRight());
	}
	public static void TohitPrint(BinNode<Integer> t)
	{
	    if(t==null)
	    {
	        return;
	    }
    	TohitPrint(t.getLeft());
	    System.out.println(t.getValue());
    	TohitPrint(t.getRight());
	}
	public static void SofitPrint(BinNode<Integer> t)
	{
	    if(t==null)
	    {
	        return;
	    }
	    SofitPrint(t.getLeft());
	    SofitPrint(t.getRight());
	    System.out.println(t.getValue());
	}
	public static boolean sumZomet(BinNode<Integer> t)
	{
	    int sum = 0;
	    if(t.getLeft()!=null)
	    {
	        sum = sum + t.getLeft().getValue();
	    }
	    if(t.getRight()!=null)
	    {
	        sum = sum + t.getRight().getValue();
	    }
	    if(sum==t.getValue())
	    {
	        return true;
	    }
	    return false;
	}
	public static boolean hasSumNode(BinNode<Integer> t)
	{
	    if(t==null)
	    {
	        return false;
	    }
	    
	    if(sumZomet(t)==true)
	    {
	        return true;
	    }
	    
	    boolean LeftSide = hasSumNode(t.getLeft());
	    if(LeftSide==true)
	    {
	        return true;
	    }
	    boolean RightSide = hasSumNode(t.getRight());
	    return RightSide;
	}
	public static int countSumNodes(BinNode<Integer> t)
	{
	    int count = 0;
	    if(t==null)
	    {
	        return 0;
	    }
	    if(sumZomet(t)==true)
	    {
	        count++;
	    }
	    count = count + countSumNodes(t.getLeft());
	    count = count + countSumNodes(t.getRight());
	    return count;
	}
	public static boolean isAllSumTree(BinNode<Integer> t)
	{
	    if(t==null)
	    {
	        return true;
	    }
	    
	    if(sumZomet(t)==false)
	    {
	        return false;
	    }
	    if(isAllSumTree(t.getLeft())==false)
	    {
	        return false;
	    }
	    if(isAllSumTree(t.getRight())==false)
	    {
	        return false;
	    }
	    return true;
	}
	public static void ZugiNoNotZugiSon(BinNode<Integer> t)
	{
	    if(t==null)
	    {
	        return;
	    }
	    if(t.getValue()%2==0)
	    {
	        if(t.hasLeft() && t.getLeft().getValue()%2==0)
	        {
	            if(t.hasRight() && t.getRight().getValue()%2==0)
	            {
	                System.out.println(t.getValue());
	            }
	        }
	        if(t.hasLeft()==false && t.hasRight()==false)
	        {
	            System.out.println(t.getValue());
	        }
	        if(t.hasLeft()==false && t.hasRight()==true)
	        {
	            if(t.getRight().getValue()%2==0)
	            {
	                System.out.println(t.getValue());
	            }
	        }
	        if(t.hasLeft()==true && t.hasRight()==false)
	        {
	            if(t.getLeft().getValue()%2==0)
	            {
	                System.out.println(t.getValue());
	            }
	        }
	    }
	    ZugiNoNotZugiSon(t.getLeft());
	    ZugiNoNotZugiSon(t.getRight());
	}
	public static int CounterOfZugiNoNotZugiSon(BinNode<Integer> t)
	{
	    int counter = 0;
	    if(t==null)
	    {
	        return 0;
	    }
	    if(t.getValue()%2==0)
	    {
	        if(t.hasLeft() && t.getLeft().getValue()%2==0)
	        {
	            if(t.hasRight() && t.getRight().getValue()%2==0)
	            {
	                counter++;
	            }
	        }
	        if(t.hasLeft()==false && t.hasRight()==false)
	        {
	            counter++;
	        }
	        if(t.hasLeft()==false && t.hasRight()==true)
	        {
	            if(t.getRight().getValue()%2==0)
	            {
	                counter++;
	            }
	        }
	        if(t.hasLeft()==true && t.hasRight()==false)
	        {
	            if(t.getLeft().getValue()%2==0)
	            {
	                counter++;
	            }
	        }
	    }
	    counter = counter + CounterOfZugiNoNotZugiSon(t.getLeft());
	    counter = counter + CounterOfZugiNoNotZugiSon(t.getRight());
	    return counter;
	}
	public static boolean IsThereGood(BinNode<Integer> t)
	{
	    if (t == null) {
        return false;
    }

    boolean currentIsGood = false;
    if (t.getValue() % 2 == 0) {
        boolean leftOk = !t.hasLeft() || t.getLeft().getValue() % 2 == 0;
        boolean rightOk = !t.hasRight() || t.getRight().getValue() % 2 == 0;
        
        if (leftOk && rightOk) {
            currentIsGood = true;
        }
    }

    if (currentIsGood) {
        return true;
    }

    if (IsThereGood(t.getLeft())) {
        return true;
    }

    if (IsThereGood(t.getRight())) {
        return true;
    }

    return false;
	}
	public static boolean isAllGood(BinNode<Integer> t)
	{
	    if(t==null)
	    {
	        return true;
	    }
	    boolean Checker = false;
	    if(t.getValue()%2==0)
	    {
	        boolean LeftOk = !t.hasLeft() || t.getLeft().getValue()%2==0;
	        boolean RightOk = !t.hasRight() || t.getRight().getValue()%2==0;
	        if(LeftOk&&RightOk)
	        {
	            Checker = true;
	        }
	    }
	    if(Checker==false)
	    {
	        return false;
	    }
	    if(isAllGood(t.getLeft())==false || isAllGood(t.getRight())==false)
	    {
	        return false;
	    }
	    return true;
	}
	public static void SabaGadol(BinNode<Integer> t)
	{
	    if(t==null)
	    {
	        return;
	    }
	    int sum = 0;
	    if(t.hasLeft())
	    {
	        if(t.getLeft().hasLeft())
	        {
	            sum = sum + t.getLeft().getLeft().getValue();
	        }
	        if(t.getLeft().hasRight())
	        {
	            sum = sum + t.getLeft().getRight().getValue();
	        }
	    }
	    if(t.hasRight())
	    {
	        if(t.getRight().hasLeft())
	        {
	            sum = sum + t.getRight().getLeft().getValue();
	        }
	        if(t.getRight().hasRight())
	        {
	            sum = sum + t.getRight().getRight().getValue();
	        }
	    }
	    if(t.getValue()>sum)
	    {
	        System.out.println(t.getValue());
	    }
	    SabaGadol(t.getLeft());
	    SabaGadol(t.getRight());
	}
}

