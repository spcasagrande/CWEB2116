package finalProject;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;

public class FileManagerTest {
	
	@Test
	public void testGetName() {
		// store the original System.in for later restoration
		InputStream originalSystemIn = System.in;
		
		try
		{
			String simulatedInput = "Test Name";
			System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
			Scanner scanner = new Scanner(System.in);
			String simulatedName = scanner.nextLine();
			
			scanner.close();
			
			Assert.assertEquals(simulatedInput, simulatedName);
			
		} finally {
			System.setIn(originalSystemIn);
		}
	}
}
