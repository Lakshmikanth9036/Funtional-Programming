package StockAccounts;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class StockAccount {

	private static JSONObject stocks = null;
	private static Gson gson = new Gson();
	private static Scanner in = new Scanner(System.in);
	private static char ans;

	public StockAccount(String fileName) {
		try {
			stocks = (JSONObject) new JSONParser().parse(new FileReader(fileName));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	public double valueOf() {
		double totalValue = 0;
		for (Object stock : stocks.values()) {
			JSONArray stk = (JSONArray) stock;
			for (int i = 0; i < stk.size(); i++) {
				String ref = (String) stk.get(i);
				Stocks stck = gson.fromJson(ref, Stocks.class);
				totalValue = totalValue + stck.getTotalValue();
			}
		}
		return totalValue;
	}

	public void buy(int amount, String symbol) {
		JSONArray stks = (JSONArray) stocks.get("Stocks");
		int k = 0;
		for (int i = 0; i < stks.size(); i++) {
			String ref = (String) stks.get(i);
			Stocks stoks = gson.fromJson(ref, Stocks.class);
			if (stoks.getStockName().equals(symbol)) {
				System.out.println(stoks);
				stoks.setShares(stoks.getShares() + amount);
				String stk = gson.toJson(stoks);
				stks.set(k, stk);
				break;
			}
			k++;
		}
		System.out.println("Do you commit the changes?");
		System.out.println("If yes press y/Y");
		ans = in.next().charAt(0);
		if (ans == 'y' || ans == 'Y')
			save(PathConfigurer.getPath());
	}

	public void sell(int amount, String symbol) {
		JSONArray stks = (JSONArray) stocks.get("Stocks");
		int k = 0;

		// String s = stks.stream().filter(ref ->
		//
		// gson.fromJson((String) ref,
		// Stocks.class).getStockName().equals(symbol)).findFirst().orElse(null).toString();
		//
		// Stocks stk = gson.fromJson(s, Stocks.class);
		// stk.setShares(stk.getShares() - amount);
		//
		// System.out.println(stk);

		for (int i = 0; i < stks.size(); i++) {
			String ref = (String) stks.get(i);
			Stocks stoks = gson.fromJson(ref, Stocks.class);
			if (stoks.getStockName().equals(symbol)) {
				System.out.println(stoks);
				
				int val = stoks.getShares() - amount;
				if (val >= 0) {
					stoks.setShares(val);
					String stk = gson.toJson(stoks);
					stks.set(k, stk);
					LocalDateTime dateNtime = LocalDateTime.now();
					int shr = stoks.getShares();
					String stkName = stoks.getStockName();
					CompanyShares cs = new CompanyShares(stkName, shr, "sell", dateNtime);
					String cmpShr = gson.toJson(cs);
					JSONArray compShares = (JSONArray) stocks.get("CompanyShares");
					compShares.add(cmpShr);
				}
				else{
					System.out.println("Shares are not available");
				}
				break;
			}
			k++;
		}
		System.out.println("Do you commit the changes?");
		System.out.println("If yes press y/Y");
		ans = in.next().charAt(0);
		if (ans == 'y' || ans == 'Y')
			save(PathConfigurer.getPath());
	}

	public void createStock() {
		JSONArray stcks = (JSONArray) stocks.get("Stocks");
		System.out.println("Enter stock name");
		String stockName = in.next();
		System.out.println("Enter number of shares");
		int shares = in.nextInt();
		System.out.println("Enter the share price");
		double shareprice = in.nextDouble();
		Stocks stks = new Stocks(stockName, shares, shareprice);
		String ref = gson.toJson(stks);
		stcks.add(ref);
		System.out.println("Do you commit the changes?");
		System.out.println("If yes press y/Y");
		ans = in.next().charAt(0);
		if (ans == 'y' || ans == 'Y')
			save(PathConfigurer.getPath());
	}

	public void save(String fileName) {
		try (PrintWriter writer = new PrintWriter(fileName);) {
			writer.write(stocks.toJSONString());
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void printReport() {
		JSONArray stk = (JSONArray) stocks.get("Stocks");

		stk.forEach(st -> {
			System.out.println(gson.fromJson((String) st, Stocks.class));
			System.out.println();
		});

	}

	public void transactionDetails(){
		JSONArray transactions = (JSONArray) stocks.get("CompanyShares");

		transactions.forEach(st -> {
			System.out.println(gson.fromJson((String) st, CompanyShares.class));
			System.out.println();
		});
	}
	
	
	public void addOrRemoveCompanySharesInLinkedList(){
		
		LinkedList<Stocks> companyShares = new LinkedList<>();
		
		JSONArray stk = (JSONArray) stocks.get("Stocks");

		stk.forEach(st -> {
			Stocks stok = gson.fromJson((String) st, Stocks.class);
			companyShares.add(stok);
		});
		
		System.out.println("1. Add company\n"
						+ "2. Remove company");
		
		System.out.println("Enter your choice: ");
		int choice = in.nextInt();
		
		switch(choice){
		
		case 1 : 
			createStock();
			break;
			
		case 2 :
			int i = 0;
			System.out.println("List of companies in company shares");
			companyShares.forEach(com -> {System.out.println(com.getStockName());});
			System.out.println("Enter the company name that you want to remove form the company shares");
			String companyName = in.next();
			
			for (int j = 0; j < stk.size(); j++) {
				String ref = (String) stk.get(j);
				Stocks stoks = gson.fromJson(ref, Stocks.class);
				if (stoks.getStockName().equals(companyName)) {
					System.out.println("Details of selected stock: ");
					System.out.println(stoks);
					System.out.println("Are you sure you want to remove the above stock");
					System.out.println("If yes press y/Y");
					ans = in.next().charAt(0);
					if (ans == 'y' || ans == 'Y'){
						stk.remove(i);
						System.out.println("Successfully removed........");
					}
				}
				i++;
			}
			System.out.println("Do you commit the changes?");
			System.out.println("If yes press y/Y");
			ans = in.next().charAt(0);
			if (ans == 'y' || ans == 'Y'){
				save(PathConfigurer.getPath());
				System.out.println("Changes have been commited");
			}
			break;
			
		default : break;
		}	
	}
	
	public void transactionDetailsInStack(){
		Stack<CompanyShares> transactions = new Stack<>();
		
		JSONArray stk = (JSONArray) stocks.get("CompanyShares");

		stk.forEach(ref -> {
			CompanyShares cs = gson.fromJson((String) ref, CompanyShares.class);
			transactions.push(cs);
		});
		
		transactions.forEach(System.out::println);
	}
	
	public void dataNtimeOfTransactionInQueue(){
		Queue<CompanyShares> transactions = new Queue<>();
		
		JSONArray stk = (JSONArray) stocks.get("CompanyShares");

		stk.forEach(ref -> {
			CompanyShares cs = gson.fromJson((String) ref, CompanyShares.class);
			transactions.enqueue(cs);
		});
		
		transactions.forEach(t -> {System.out.println(t.getDateNtime()+" "+t.getStatus());});
	}
	
}
