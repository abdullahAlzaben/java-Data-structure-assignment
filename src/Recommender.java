import java.io.File;
import java.util.Scanner;

public class Recommender {

	// Return the top k recommended friends for user i using the popular nodes method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
	public static <K extends Comparable<K>> PQK<Double, K> recommendPop(Graph<K> g, K i, int k) {
		try {
		int count=0;
		int count2=0;
		
		List<K>  nght = new LinkedList<K>();
		List<K>  thetree = new LinkedList<K>();
		PQK<Double, K> list = new PQKImp<Double, K>(k);
		
		
		if(g.isNode(i)==false)
			return null;
	
		
		nght=g.neighb(i);
		thetree=  g.getNodes();
		
		
		
		

		thetree.findFirst();
		while(!thetree.last()) {
			if(thetree.retrieve().compareTo(i)==0) {
				thetree.remove();
				break;
			}
			thetree.findNext();
		}
		
		if(thetree.retrieve().compareTo(i)==0) {
			thetree.remove();
		}
		
		nght.findFirst();
		for(int te=0; te<nght.size(); te++) {
			thetree.findFirst();
		for(int ta=0; ta<thetree.size(); ta++) {
			if(nght.retrieve().compareTo(thetree.retrieve())==0) {
				thetree.remove();
				break;
			}
			thetree.findNext();
		}
		nght.findNext();
		}
	
		double cont=0;
		thetree.findFirst();
	while(!thetree.last()) {
		cont=g.deg(thetree.retrieve());
		list.enqueue(cont, thetree.retrieve()); 
		
		thetree.findNext(); }
	
	
	cont=g.deg(thetree.retrieve());
	list.enqueue(cont, thetree.retrieve()); 
	

	
	
	
	return list;
		
		}catch(Exception e) {
			PQK<Double, K> list = new PQKImp<Double, K>(k);
			return list;
			}
	
	}

	// Return the top k recommended friends for user i using common neighbors method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
	public static <K extends Comparable<K>> PQK<Double, K> recommendCN(Graph<K> g, K i, int k) {
		try {
		boolean find =true;
	
		List<K>  thetree = new LinkedList<K>();
		List<K>  nght = new LinkedList<K>();
		PQK<Double, K> list = new PQKImp<Double, K>(k);
		
	
		if(g.isNode(i)==false)
			return null;
	
		
		
		thetree = g.getNodes();
		
		nght=g.neighb(i);
		
		
		thetree.findFirst();
		while(!thetree.last()) {
			if(thetree.retrieve().compareTo(i)==0) {
				thetree.remove();
				break;
			}
			thetree.findNext();
		}
		
		if(thetree.retrieve().compareTo(i)==0) {
			thetree.remove();
		}
		
		nght.findFirst();
		for(int te=0; te<nght.size(); te++) {
			thetree.findFirst();
		for(int ta=0; ta<thetree.size(); ta++) {
			if(nght.retrieve().compareTo(thetree.retrieve())==0) {
				thetree.remove();
				break;
			}
			thetree.findNext();
		}
		nght.findNext();
		}
		
		double cont=0;
		thetree.findFirst();
	while(!thetree.last()) {
		cont=0;
		nght.findFirst();
		while(!nght.last()) {
			
		if(g.isEdge(nght.retrieve(), thetree.retrieve())) {
			cont++;
		  }
		nght.findNext();
		}
		if(g.isEdge(nght.retrieve(), thetree.retrieve())) {
			cont++;
		  }
		list.enqueue(cont, thetree.retrieve());
		thetree.findNext(); }
	
	cont=0;
	nght.findFirst();
	while(!nght.last()) {
		
	if(g.isEdge(nght.retrieve(), thetree.retrieve())) {
		cont++;
	  }
	nght.findNext();
	}
	if(g.isEdge(nght.retrieve(), thetree.retrieve())) {
		cont++;
	  }
	list.enqueue(cont, thetree.retrieve());
		
		
		
	
		
		
		
		
		
		
			  
		
		return list;
		}catch(Exception e) {
			PQK<Double, K> list = new PQKImp<Double, K>(k);
			return list;
			}
		
	}

	// Read graph from file. The file is a text file where each line contains an edge. The end and start of the edge are separated by space(s) or tabs.
	public static Graph<Integer> read(String fileName) {
       
		try {
			Graph<Integer> g = new MGraph<Integer>();
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNextInt()) {
				int i = scanner.nextInt();
				g.addNode(i);
				int j = scanner.nextInt();
				g.addNode(j);
				g.addEdge(i, j);
			}
			scanner.close();
			return g;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
