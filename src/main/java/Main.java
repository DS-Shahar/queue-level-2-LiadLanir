public class Main
{
    public static void main(String[] args)
    {
      
    }
    public static boolean isIn(Queue<Integer> q1, int x)
    {
        Queue<Integer> q2 = new Queue<>();
        boolean f = false;
        while (!q1.isEmpty())
        {
            int y = q1.remove();
            if (y == x)
            {
                f = true;
            }
            q2.insert(y);
        }
        while (!q2.isEmpty())
        {
            q1.insert(q2.remove());
        }
        return f;
    }
    public static Queue<Integer> ex1(Queue<Integer> q1)
    {
        Queue<Integer> q2 = new Queue<>();
        Queue<Integer> q3 = new Queue<>();
        int pr = q1.remove();
        q3.insert(pr);
        int cnt = 1;
        while (!q1.isEmpty())
        {
            int cr = q1.remove();
            q3.insert(cr);
            if (cr == pr)
            {
                cnt++;
            }
            else
            {
                q2.insert(cnt);
                cnt = 1;
                pr = cr;
            }
        }
        q2.insert(cnt);
        while (!q3.isEmpty())
        {
            q1.insert(q3.remove());
        }
        return q2;
    }
    public static boolean ex2(Queue<Integer> q1)
    {
        Queue<Integer> q2 = new Queue<>();
        boolean dup = false;
        while (!q1.isEmpty())
        {
            int x = q1.remove();
            if (isIn(q2, x))
            {
                dup = true;
            }
            q2.insert(x);
        }
        while (!q2.isEmpty())
        {
            q1.insert(q2.remove());
        }
        return dup;
    }
    public static void ex3(Queue<Integer> q1)
    {
        Queue<Integer> q2 = new Queue<>();
        while (!q1.isEmpty())
        {
            int x = q1.remove();
            if (!isIn(q2, x))
            {
                q2.insert(x);
            }
        }
        while (!q2.isEmpty())
        {
            q1.insert(q2.remove());
        }
    }
    public static void ex4(Queue<Integer> q1)
    {
        Queue<Integer> q2 = new Queue<>();
        Queue<Integer> q3 = new Queue<>();
        while (!q1.isEmpty())
        {
            int min = q1.remove();
            q3.insert(min);
            while (!q1.isEmpty())
            {
                int x = q1.remove();
                q3.insert(x);
                if (x < min)
                {
                    min = x;
                }
            }
            boolean rem = false;
            while (!q3.isEmpty())
            {
                int x = q3.remove();
                if (x == min && !rem)
                {
                    rem = true;
                }
                else
                {
                    q1.insert(x);
                }
            }
            q2.insert(min);
        }
        while (!q2.isEmpty())
        {
            q1.insert(q2.remove());
        }
    }
    public static Queue<Integer> ex5(Queue<Integer> q1, Queue<Integer> q2)
    {
        Queue<Integer> q3 = new Queue<>();
        while (!q1.isEmpty() && !q2.isEmpty())
        {
            if (q1.head() <= q2.head())
            {
                q3.insert(q1.remove());
            }
            else
            {
                q3.insert(q2.remove());
            }
        }
        while (!q1.isEmpty())
        {
            q3.insert(q1.remove());
        }
        while (!q2.isEmpty())
        {
            q3.insert(q2.remove());
        }
        return q3;
    }
    public static int ex6(Queue<Integer> q1)
    {
        Queue<Integer> q2 = new Queue<>();
        int cur = 0;
        int curSum = 0;
        int max = 0;
        int maxSum = 0;
        while (!q1.isEmpty())
        {
            int x = q1.remove();
            q2.insert(x);
            if (x % 2 == 0)
            {
                cur++;
                curSum += x;
                if (cur > max)
                {
                    max = cur;
                    maxSum = curSum;
                }
            }
            else
            {
                cur = 0;
                curSum = 0;
            }
        }
        while (!q2.isEmpty())
        {
            q1.insert(q2.remove());
        }
        return maxSum;
    }
}
