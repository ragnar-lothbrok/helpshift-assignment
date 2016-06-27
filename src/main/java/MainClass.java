import java.util.Scanner;

import com.coding.contacts.api.ContactService;
import com.coding.contacts.api.impl.ContactServiceImpl;

public class MainClass {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		ContactService contactService = ContactServiceImpl.getInstance();
		System.out.println("*********Welcome to Contact Archives**********");
		do {
			try{
				System.out.println("Please enter your choice.");
				System.out.println("1) Add contact 2) Search 3) Exit");
				choice = scanner.nextInt();
				switch(choice){
				case 1:
					break;
				case 2:
					break;
				}
			}catch(Exception exception){
				
			}
		} while (choice != 3);

		System.out.println("*********Thank you for using Contact Archives**********");
	}

}
