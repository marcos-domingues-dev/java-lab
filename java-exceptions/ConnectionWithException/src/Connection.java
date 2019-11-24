
public class Connection implements AutoCloseable {

	public void open() {
		System.out.println("Connection was opened.");
	}

	public void readData() {
		System.out.println("Reading data from connection.");
		throw new IllegalStateException("Server is down.");
	}

	@Override
	public void close() throws Exception {
		System.out.println("Connection was closed.");

	}
}
