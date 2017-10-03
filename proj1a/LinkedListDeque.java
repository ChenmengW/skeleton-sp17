public class LinkedListDeque<E>{
	public class GeneNode{
		public GeneNode pre;
		public E item;
		public GeneNode next;


		public GeneNode(E i){
			pre = this;
			item = i;
			next = this;
		}

		public GeneNode(){
			pre = this;
			item = null;
			next = this;
		}
	}

	private GeneNode sentinel;
	private int size;
	private GeneNode last;

	public LinkedListDeque (){
		sentinel = new GeneNode();
		size = 0;
		last = sentinel;
	}

	public void addLast (E i){
		last.next = new GeneNode(i);
		sentinel.pre = last.next;
		last.next.pre = last;
		last.next.next = sentinel;
		last = last.next;
		size += 1;
	}

	public void addFirst (E i){
		GeneNode itemtoadd = new GeneNode (i);
		itemtoadd.next = sentinel.next;
		sentinel.next.pre = itemtoadd;
		sentinel.next = itemtoadd;
		itemtoadd.pre = sentinel;
		last = last.next;
		size += 1;
	}

	public boolean isEmpty(){
		if (size == 0){
			return true;
		}
		else {return false;}
	}

	public int size(){
		return size;
	}

	public void printDeque(){
		GeneNode p = sentinel.next;
		int psize = size;
		while (psize != 0){
			System.out.println(p.item);
			psize -= 1;
			p = p.next;
		}
	}

	public E removeFirst(){
		E firstReturn = sentinel.next.item;
		sentinel.next = sentinel.next.next;
		sentinel.next.pre = sentinel;
		size -= 1;
		return firstReturn;
	}

	public E removeLast(){
		E lastReturn =last.item;
		last.pre.next = sentinel;
		sentinel.pre = last.pre;
		last = sentinel.pre;
		size -= 1;
		return lastReturn;
	}

	public E get(int index){
		int p = 0;
		GeneNode g = sentinel.next;
		while(p != index){
			g = g.next;
			p += 1;
		}
		return g.item;
	}

	public E getRecursive(int index){

		return getRecursivehelper(index, this.sentinel.next);
	}

	private E getRecursivehelper(int index, GeneNode node){
		if (index == 0){
			return node.item;
		}
		else {
			return getRecursivehelper(index - 1, node.next);
		}
	}


}






