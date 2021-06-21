public class BSTMap<K extends Comparable<K>, T> implements Map<K, T> {
	public BSTNode<K, T> root; // Do not change this
	private int size;
	/** Creates a new instance of BST */
	public BSTMap() {
		root  = null;
		size=0;
	}
	
	
	public boolean full() {
		return false;
	}
	

	public void clear() {
		root = null;
		size=0;
	}
	
	public int size() {
		return size;
	}

	public boolean insert(K k, T e) {
		
		if(k==null || e==null)
			return false;
		 BSTNode<K, T> node = new BSTNode<K, T>(k,e);
		
		if(root==null) {
			
			root  = node;
			size++;
		return true; }
		
		 BSTNode<K, T>p = root, q = root;
				
			while(p != null) {
				q = p;
				if(p.key.compareTo(k)==0) {
					return false;
				}
				else if(p.key.compareTo(k)>0)
					p = p.left;
				else
					p = p.right;
			}
			if ( q.key.compareTo(k)>0)
				q.left = node;
			else
				q.right = node;
	
			size++;
			return true;

		

	}
	public boolean update(K k, T e) {
		if(k==null || e==null)
			return false;
		
		if(root==null) 
			return false;
		
		 BSTNode<K, T>p = root, q = root;
			
			while(p != null) {
				q = p;
				if(p.key.compareTo(k)==0) {
					p.data=e;
					return true;
				}
				else if(p.key.compareTo(k)>0)
					p = p.left;
				else
					p = p.right;
			}
			return false;
		
		
	}
	public Pair<Boolean, T> retrieve(K k){
		if(k==null) {
			Pair<Boolean, T> pair = new Pair<Boolean, T>(false,null);
			 return pair; }
		if(root==null) {
			Pair<Boolean, T> pair = new Pair<Boolean, T>(false,null);
			 return pair; }
		
		 BSTNode<K, T>p = root, q = root;
			
			while(p != null) {
				q = p;
				if(p.key.compareTo(k)==0) {
					Pair<Boolean, T> pair = new Pair<Boolean, T>(true,p.data);
					 return pair;
				}
				else if(p.key.compareTo(k)>0)
					p = p.left;
				else
					p = p.right;
			}
			Pair<Boolean, T> pair = new Pair<Boolean, T>(false,null);
			 return pair;
		
	}
	public boolean remove(K k) {
		
		if(k==null) 
			return false;
		
		if(root==null) 
			return false;
		
		 BSTNode<K, T> p = root;
		 BSTNode<K, T> q = null; 
	      while (p != null) {

	         if (p.key.compareTo(k)>0) {
	            q =p;
	            p = p.left;
	         } else if (p.key.compareTo(k)<0) {
	            q = p;
	            p = p.right;
	         } 
	         else { 

	             
	             if ((p.left != null) && (p.right != null)) { 
	 		
	            	 BSTNode<K, T> min = p.right;
	                q = p;
	                while (min.left != null) {
	                   q = min;
	                   min = min.left;
	                }
	                p.key = min.key;
	                p.data = min.data;
	                k = min.key;
	                p = min;
	              
	             }
	           
	             if (p.left != null) { 
	                p = p.left;
	             } else { 
	                p = p.right;
	             }

	             if (q == null) { 
	                root = p;
	             } else {
	                if (q.key.compareTo(k)>0) {
	                   q.left = p;
	                } else {
	                   q.right = p;
	                }
	             }
	             size--;
	             return true;

	          } 
	       }
	     
	       return false; 
	    

	      }
	
	public List<K> getKeys(){
	
		List<K>  list = new LinkedList<K>();
		if(root==null)
			return list;
		if(root.left!=null)
		orderd(list,root.left);
		

	
		
		list.insert(root.key);
		
		
		if(root.right!=null)
		orderd(list,root.right);
		
		return list;
		
	}
	private  void  orderd(List<K> l , BSTNode f) {
		 BSTNode<K, T> p = f;
		 
		 if( p.left != null )
			 orderd(l,p.left);
		 
		 l.insert(p.key);
		 
		 if( p.right != null)
			  orderd(l,p.right);
		
		
	}


}
