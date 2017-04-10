public class NodeHeap implements PriorityQueue<Node> {

	private Node[] data;
	private int size = 0;

	public NodeHeap(int capacity) {
		data = new Node[capacity];
	}

	@Override
	public void enqueue(Node item) {
		data[++size] = item;
		int index = size;
		while (parrentOf(index) > 0 && data[parrentOf(index)].compareTo(data[index]) > 0) {
			swap(parrentOf(index), index);
			index = parrentOf(index);
		}
	}

	@Override
	public Node dequeue() {
		Node removedNode = data[1];
		data[1] = data[size--];
		heapify(1);
		return removedNode;
	}

	@Override
	public Node peek() {
		return data[1];
	}

	@Override
	public int size() {
		return this.size;
	}

	private int parrentOf(int p) {
		return p / 2;
	}

	private int leftOf(int p) {
		return 2 * p;
	}

	private int rightOf(int p) {
		return 2 * p + 1;
	}

	private void swap(int n, int m) {
		data[0] = data[m];
		data[m] = data[n];
		data[n] = data[0];
	}

	private boolean isLeaf(int position) {
		if (position > size / 2) {
			return true;
		}
		return false;
	}

	private void heapify(int position) {
		if (isLeaf(position)) {
			return;
		}

		if (data[position].compareTo(data[leftOf(position)]) > 0 || data[position].compareTo(data[rightOf(position)]) > 0) {
			if (data[leftOf(position)].compareTo(data[rightOf(position)]) < 0) {
				swap(position, leftOf(position));
				heapify(leftOf(position));
			} else {
				swap(position, rightOf(position));
				heapify(rightOf(position));
			}
		}
	}

	public Node[] getData() {
		return data;
	}

	public void setData(Node[] data) {
		this.data = data;
	}

	public Node getRoot(){
		return this.data[1];
	}
	
	public Node getSeccondVertice(){
		return this.data[2];
	}
	
	public void swapRoot(){
//		System.out.println("swaproot");
		this.swap(1, 4);
		this.swap(2, 4);
	}
	
	public void swapSeccond(){
//		System.out.println("seccond");
		this.swap(2,4);
	}


}
