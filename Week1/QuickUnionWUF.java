public class QuickUnionWUF
{

	private int[] id;
	private int[] sz;
	private int count;

	public static void main(String[] Args)
	{
		int N = StdIn.readInt();
		QuickUnionWUF uf = new QuickUnionWUF(N);
		while (!StdIn.isEmpty())
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (!uf.connected(p,q))
			{
				uf.union(p,q);
				StdOut.println(p + " connected to " + q);
			}
			StdOut.println(uf.count() + "components");
			StdOut.println("ID = ");
			for(int c = 0; c < N; c++)
			{
				System.out.print(uf.id(c) + ", ");
			}
			StdOut.println("");
		}
	}



	public QuickUnionWUF(int N)
	{
		id = new int[N];
		sz = new int[N];
		count = N;
		for (int i = 0; i < N; i++)
		{
			id[i] = i;
			sz[i] = 1;
		}
	}	

	 public int count() 
	{
       return count;
    }

    public int id(int c)
    {
    	return id[c];
    }

	private int root(int i)
	{
		while (i != id[i]) i = id[i];
		return i;
	}

	public boolean connected(int p, int q)
	{
		return root(p) == root(q);
	}

	public void union (int p, int q)
	{
		int i = root(p);
		int j = root(q);
		if (i == j) return;

		if (sz[i] < sz[j])	{id[i] = j; sz[i] += sz[j];}
		else 				{id[j] = i; sz[i] += sz[j];}
		count--;
	}
}