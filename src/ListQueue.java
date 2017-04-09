import java.util.List;
import java.util.ArrayList;

public class ListQueue<T> implements Queue<T>{

	List<T> list = new ArrayList<>();
	
	@Override
	public void enqueue(T item) {
		list.add(item);
	}

	@Override
	public T dequeue() {
		return list.remove(0);
	}

	@Override
	public T peek() {
		return list.get(0);
	}

	@Override
	public int size() {
		return list.size();
	}

}
