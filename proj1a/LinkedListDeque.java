public class LinkedListDeque{
	public class IntNode{
		public IntNode pre;
		public int item;
		public IntNode next;

		public IntNode(){
			pre = this;
			item = 1;
			next = pre;
		}


	}

	private IntNode sentinel;
	private int size;
	private IntNode last;

	public LinkedListDeque (){
		sentinel = IntNode();
	}




}






