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
	
	public static void main(String[] args) {
		NodeHeap nh = new NodeHeap(10);
		
		nh.enqueue(new Node(2f));
		nh.enqueue(new Node(2f));
		nh.enqueue(new Node(6f));
		Node n_last = new Node(7f);
		nh.enqueue(n_last);
		nh.enqueue(new Node(8f));
		//System.out.println(nh.getData()[2].getCost());
		
		n_last.setCost(1f);
		nh.heapify(2);
		if(n_last.getCost()>nh.getData()[0].getCost() || n_last.getCost()>nh.getData()[0].getCost()){
			//nh.heapify(3);
		}
		//nh.updateNode(2);
		//System.out.println(nh.size);
		while (nh.size>0){
			
			//nh.dequeue();
			System.out.println(nh.dequeue().getCost());
		}
	}


}
