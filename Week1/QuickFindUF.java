public class QuickFindUF
{

	private int[] id;
	private int count;

	public static void main(String[] Args)
	{
		int N = StdIn.readInt();
		QuickFindUF uf = new QuickFindUF(N);
		while (!StdIn.isEmpty())
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (!uf.connected(p,q))
			{
				uf.union(p,q);
				StdOut.println(p + " connected to " + q);
			}
			StdOut.println("ID = ");
			for(int c = 0; c < N; c++)
			{
				System.out.print(uf.id(c) + ", ");
			}
			StdOut.println("");
		}
	}


	public int id(int c)
    {
    	return id[c];
    }
    

	public QuickFindUF(int N)
	{
		id = new int[N];
		count = N;

		for (int i = 0; i < N; i++)
			id[i] = i;
	}	

	public int count() 
	{
       return count;
    }


	public boolean connected(int p, int q)
	{
		return id[p] == id[q];
	}

	public void union (int p, int q)
	{
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++)
			if (id[i]==pid) id[i] = qid;
			count--;
			//bug: if instead of getting id[p] through pid we just throw id[p] we get bug
	}
}