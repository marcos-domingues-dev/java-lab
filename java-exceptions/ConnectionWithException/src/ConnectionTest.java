
public class ConnectionTest {

	public static void main(String[] args) {

		// This class "Connection"implements a AutoCloseable 
		// interface, and alwais will do the finnaly block
		// calling the "close()" method.
		
		try (Connection connection = new Connection()) {
			connection.open();
			connection.readData();
			connection.close();
		} catch (Exception ex) {
			System.out.println("An error was ocurred." + ex.getMessage());
		}
	}
}
