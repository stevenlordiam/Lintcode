public class Hashtable<K,V> {

	private Hashnode<K,V>[] nodes;

	@SuppressWarnings("unchecked")
	public Hashtable(int size){
		nodes = new Hashnode[size];
	}

	private int getIndex(K key){
		int hash = key.hashCode() % nodes.length;
		if(hash < 0){
			hash += nodes.length;
		}
		return hash;
	}

	public V insert(K key, V data){
		int hash = getIndex(key);

		// Lets check if same key already exists and if so lets update it with the new value
		for(Hashnode<K,V> node = nodes[hash]; node != null; node = node.next){
			if((hash == node.hash) && key.equals(node.key)){
				V oldData = node.data;
				node.data = data;
				return oldData;
			}
		}

		// Lets add the new hash node created below to the start of linked list at nodes[hash] position
		Hashnode<K,V> node = new Hashnode<K,V>(key, data, nodes[hash], hash);
		nodes[hash] = node;

		return null;
	}

	/**
	 * It Removes the given key from hash table.
	 * 1. Gets the hash using built in hash code method and by doing % to match to local index
	 * 2. Look for the corresponding index in nodes array, if found then, we got the linked list
	 *         a. Search for the given key, also match the hash
	 *         b. If found, make previous.next = node.next; and return true.
	 * @param key
	 * @return
	 */
	public boolean remove(K key){
		int hash = getIndex(key);
		Hashnode<K,V> previous = null;
		for(Hashnode<K,V> node = nodes[hash]; node != null; node = node.next){
			if((hash == node.hash) && key.equals(node.key)){
				if(previous != null){
					previous.next = node.next;
				}else{
					nodes[hash] = node.next;
				}
				return true;
			}
			previous = node;    
		}
		return false;
	}

	public V get(K key){
		int hash = getIndex(key);

		for(Hashnode<K,V> node = nodes[hash]; node != null; node = node.next){
			if(key.equals(node.key))
				return node.data;
		}
		return null;
	}

	public void resize(int size){
		Hashtable<K, V> newtbl = new Hashtable<K, V>(size);
		for(Hashnode<K,V> node : nodes){
			for(; node != null; node = node.next){
				newtbl.insert(node.key, node.data);
				remove(node.key);
			}
		}
		nodes = newtbl.nodes;
	}

	/**
	 * Generic Hash node class, acts like a linked list node
	 * @author IVY3508
	 *
	 * @param <K>
	 * @param <V>
	 */
	static class Hashnode<K,V> {
		final K key;
		V data;
		Hashnode<K,V> next;
		final int hash;

		public Hashnode(K k, V v, Hashnode<K,V> n, int h){
			key = k;
			data = v;
			next = n;
			hash = h;
		}
	}

	public static void main(String[] args) {

		Hashtable<String, Integer> tbl = new Hashtable<String, Integer>(5);

		tbl.insert("one", 1);
		tbl.insert("three", 3);
		tbl.insert("nineteen", 19);
		tbl.insert("fifteen", 15);
		tbl.insert("six", 6);

		System.out.println("After Insert");

		System.out.println("three :: "+tbl.get("three"));
		System.out.println("six :: "+tbl.get("six"));

		/*tbl.remove("three");

		System.out.println(tbl.get("three"));*/

		tbl.resize(8);

		System.out.println("After Resize");

		System.out.println("three :: "+tbl.get("three"));
		System.out.println("six :: "+tbl.get("six"));

		tbl.insert("hundred", 100);

		System.out.println("hundred :: "+tbl.get("hundred"));

	}

}