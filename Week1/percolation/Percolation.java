import WeightedQuickUnionUF.;

public class Percolation 
{
	private int[] x;
	private int[] y;
	private boolean[][] siteState;

	// create N-by-N grid, with all sites blocked
	public Percolation(int N)
	{
		if(N <= 0) { throw new IllegalArgumentException(); }
		siteState = new boolean[N][N];
		uf = new WeightedQuickUnionUF(N + 1);
	}			
	// open site (row i, column j) if it is not open already
	public void open(int i, int j)			
	{}
	// is site (row i, column j) open?
	public boolean isOpen(int i, int j)
	{}		
	// is site (row i, column j) full?
	public boolean isFull(int i, int j);		
	// does the system percolate?
	public boolean percolates()
	{}

	// test client (optional)   
	public static void main(String[] args)   
	{
		int N = StdIn.readInt();
		Percolation perc = new Percolation(N);

	}
}
