
public class PQKImp<P extends Comparable<P>, T> implements PQK<P, T> {
	private int maxsize;
	private int size;
	
	private Pair<P,T>[] nodes;

	public PQKImp(int k) {
		maxsize = k;
		size = 0;
		
		
		nodes = (Pair<P,T>[]) new Pair[k];

	}
	public int length() {
		return size;
	}
	public void enqueue(P pr, T e) {
		boolean here=false;
		int help=0;
		int place=0;
		int count=0;
		Pair<P, T> pair = new Pair<P, T> (pr,e);
		
		if(size==0) {
	
			nodes[size]=pair;
		
			size++;
			return;
		}
		else
			
		for(int i=0; i<size; i++ ) {
	
			if(pair.first.compareTo(nodes[i].first)>0) {
				
				for (int j = size-1; j >= count; --j) {
					if(j+1!=maxsize) 
						nodes[j+1] = nodes[j]; 
						
					
				}
				
				nodes[count]=pair;
		
				if(size==maxsize)
					return;
				size++;
				return;
			}
			
			if(pair.first.compareTo(nodes[i].first)==0) {
				here=true;
				place=i;
				help=count;
				
			}
			
			 count++; ///
			}
		if(here==true) {
			
			if(place+1==size && size==maxsize)                               ////////////// ******* check
				return;
			for (int j = size-1; j > place; --j) {
				if(j+1!=maxsize) 
					nodes[j+1] = nodes[j]; 
			}
			
			if(help+1!=maxsize)
				help++;
			
			nodes[help]=pair;
			
			if(size==maxsize)
				return;
			size++;
			return;
		}
		
		
		
		if(size!=maxsize) {
			
			nodes[size]=pair;
			size++;
		}
			
			
				
		}
		
	
	public Pair<P, T> serve(){
		if(size==0){
			Pair<P, T> pair = new Pair<P, T> (null,null);
			return pair; }
		Pair<P, T> pair = new Pair<P, T> (nodes[0].first,nodes[0].second);
		for (int i = 1; i < size; i++) {
			nodes[i-1] = nodes[i];
		}
		if(size==1) {
			nodes[0]=null;	
		}
		size--;
        return pair;
	}
	
}
