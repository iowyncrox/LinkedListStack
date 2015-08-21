import java.util.NoSuchElementException;

public class LinkedListStack<T> {

	private Node<T> top;

	public LinkedListStack() {
		top = null;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void clear() {
		top = null;
	}

	public void insert(T data) {
		top = new Node<T>(data, top);
	}

	public T topOfStack() {
		if (isEmpty())
			throw new NoSuchElementException();
		return top.data;
	}

	public T delete() {
		T temp = topOfStack();
		top = top.next;
		return temp;
	}

	@Override
	public String toString() {
		if (isEmpty())
			return "[ ]";

		StringBuffer sb = new StringBuffer("[");
		Node<T> temp = top;
		while (temp.next != null) {
			sb.append(temp.data + ", ");
			temp = temp.next;
		}
		sb.append(temp.data + "]");
		return sb.toString();
	}

	private class Node<T> {
		private T data;
		Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		LinkedListStack<Integer> linkedListStack = new LinkedListStack<Integer>();
		for (int i = 0; i < 5; i++) {
			linkedListStack.insert(i);
		}
		System.out.println(linkedListStack);

		linkedListStack.delete();
		linkedListStack.delete();
		System.out.println(linkedListStack);
	}
}