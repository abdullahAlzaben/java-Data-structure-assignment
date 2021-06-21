
public class MGraph<K extends Comparable<K>> implements Graph<K> {
	public Map<K, List<K>> adj; // Do not change this
	
	public MGraph() {
		adj= new BSTMap<K, List<K>>();
	}
	
public boolean addNode(K i) {
	try {
	if(i==null)
		return false;
//	if(adj.getKeys().exists(i))
//		return false;
	if(adj.retrieve(i).first==true)
		return false;
		return adj.insert(i, new LinkedList<K>() );
	
	}catch(Exception e) {
		return false;
		}
	
		
	}
public boolean isNode(K i) {
	try {
	    ///////// 
	if(i==null)
		return false;
	if(adj.retrieve(i).first==true )
		return true; }
	catch(Exception e) {
		return false;
		}
	
	return false;
}
public boolean addEdge(K i, K j) {
	try {
		
	if(i==null )
		return false;
	if(j==null )
		return false;
	
	if(adj.retrieve(i).first==false ) 
		return false;
	
	if(adj.retrieve(j).first==false ) 
		return false;
	
	List<K>  list1 = new LinkedList<K>();
	List<K>  list2 = new LinkedList<K>();
	
	list1=adj.retrieve(i).second;
	list2=adj.retrieve(j).second;
	

		
		
	
	       
		if(list2.exists(i)==false && list1.exists(j)==false ) {
			adj.retrieve(i).second.insert(j);
			adj.retrieve(j).second.insert(i);
			return true;
		}
	
		
		
//		
//		list2.findFirst();
//		while(list2.last()) {
//			
//		list2.findNext();}
//		
//		list1.insert(list2.retrieve());
//		
//		list3.findFirst();
//		while(list3.last()) {
//			list2.insert(list3.retrieve());
//		list3.findNext();}
//		
//		list2.insert(list3.retrieve());
//		
//		adj.retrieve(j).second=list2;
//		adj.retrieve(i).second=list1;
		
	
	}catch(Exception e) {
			return false;
			}
	return false;
}
public boolean isEdge(K i, K j) {
	try {
	if(adj.size()==0)
		return false; 
	
	if(i==null || j==null)
		return false;
	
		
	
	if(adj.retrieve(i).first==false ) 
		return false;
	
	if(adj.retrieve(j).first==false ) 
		return false;
	
		List<K>  list1 = new LinkedList<K>();
		List<K>  list2 = new LinkedList<K>();
		list2=adj.retrieve(j).second;
		list1=adj.retrieve(i).second;
		if(list1.exists(j)==true && list2.exists(i)==true)
			return true;
	
	}catch(Exception e) {
		return false;
		}
	return false;
	
}
public List<K> neighb(K i){
	
	try {
	List<K>  list = adj.retrieve(i).second;
	if(adj.size()==0)
		return list; 
	
	if(i==null )
		return list;
	if(adj.retrieve(i).first==false)
		return list;
	

	return list;
	}catch(Exception e) {
		List<K>  list = adj.retrieve(i).second;
		return list;
		}
	
	
}
public int deg(K i) {
	try {
	
	if(i==null )
		return -1;
	if(adj.retrieve(i).first==false)
		return -1;
	return adj.retrieve(i).second.size();
	}catch(Exception e) {
		return -1;
		}
	
}
public List<K> getNodes(){
	
	return adj.getKeys();
	
}

}
