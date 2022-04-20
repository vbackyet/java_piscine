package ex03;

public class TransNode {

	private TransNode	next;
	private TransNode	previous;
	private Transaction		data;

	public TransNode(TransNode next, TransNode previous, Transaction data) {
		this.next = next;
		this.previous = previous;
		this.data = data;
	}
	public TransNode getNext() {
		return next;
	}

	public void setNext(TransNode next) {
		this.next = next;
	}

	public TransNode getPrevious() {
		return previous;
	}

	public void setPrevious(TransNode previous) {
		this.previous = previous;
	}

	public Transaction getData() {
		return data;
	}

	public void setData(Transaction data) {
		this.data = data;
	}
	
}

