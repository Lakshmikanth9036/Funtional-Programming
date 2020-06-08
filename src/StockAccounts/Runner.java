package StockAccounts;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		char ans;
		StockAccount stk = new StockAccount(PathConfigurer.getPath());

		 do{
		 System.out.println(" -----Menu------");
		 System.out.println("1. Get total value of account dollars \n"
		 + "2. Buy shares for a perticular stock \n"
		 + "3. Sell shares of perticular stock \n"
		 + "4. Create stock\n"
		 + "5. Save your stock account \n"
		 + "6. Print a detailed report of stocks and values \n"
		 + "7. Transaction details\n"
		 + "8. Exit");
		 System.out.println("Enter your choice:");
		 int choice = in.nextInt();
		
		 switch(choice){
		
			case 1:
				double totalValue = stk.valueOf();
				System.out.println("Total value of account: " + totalValue);
				break;

			case 2:
				System.out.println("Enter the symbol of shares that you want to buy");
				String symbol = in.next();
				System.out.println("Enter the amount of shares that you want to buy");
				int amount = in.nextInt();
				stk.buy(amount, symbol);
				System.out.println("Transaction complete.....");
				break;

			case 3:
				System.out.println("Enter the symbol of shares that you want to sell");
				String symbol1 = in.next();
				System.out.println("Enter the amount of shares that you want to sell");
				int amount1 = in.nextInt();
				stk.sell(amount1, symbol1);
				System.out.println("Transaction complete.....");
				break;

			case 4:
				stk.createStock();
				break;
				
			case 5:
				stk.save(PathConfigurer.getPath());
				System.out.println("Transaction details have been saved succesfully!!!!!");
				break;

			case 6:
				System.out.println("Detailed report of stocks: ");
				stk.printReport();
				break;
				
			case 7:
				System.out.println("Transaction details: ");
				stk.transactionDetails();
				break;

			default:
				break;
			}
		
		 System.out.println();
		 System.out.println("Do you want to continue with transaction if yes press Y/y else N/n");
		 ans = in.next().charAt(0);
		
		 }while(ans=='y' || ans=='Y');
	}
	
	
}
