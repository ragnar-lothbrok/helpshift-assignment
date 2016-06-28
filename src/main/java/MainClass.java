import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.coding.contacts.api.ContactService;
import com.coding.contacts.api.impl.ContactServiceImpl;
import com.coding.model.Contact;

/**
 * This is main class of the program
 * 
 * @author raghunandangupta
 *
 */
public class MainClass {

	public static void main(String[] args) {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int choice = 0;
		String firstName = null, searchText = null;
		ContactService contactService = ContactServiceImpl.getInstance();
		System.out.println("*********Welcome to Contact Archives**********");
		do {
			try {
				System.out.println("Please enter your choice.");
				System.out.println("1) Add contact 2) Search 3) Exit");
				choice = Integer.parseInt(bufferedReader.readLine());
				switch (choice) {
				case 1:
					System.out.println("Please enter firstName lastName : ");
					firstName = bufferedReader.readLine();
					String split[] = firstName.split(" ");
					if (split.length == 1) {
						contactService.addContact(split[0], null);
					} else {
						contactService.addContact(split[0], split[1]);
					}
					break;
				case 2:
					System.out.println("Please enter search keyword : ");
					searchText = bufferedReader.readLine();
					List<Contact> contactDataList = contactService.serachContact(searchText);
					if (contactDataList.size() == 0) {
						System.out.println("No Matches Found");
					} else {
						for (Contact modifiedContact : contactDataList) {
							System.out.println(modifiedContact.getFirstName() + " "
									+ (modifiedContact.getLastName() == null ? "" : modifiedContact.getLastName()));
						}
					}
					break;
				}
			} catch (Exception exception) {
				System.out.println("Exception occured : " + exception.getMessage());
			}
		} while (choice != 3);
		System.out.println("*********Happy Searching**********");
	}

}
