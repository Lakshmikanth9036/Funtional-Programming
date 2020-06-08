package StockAccounts;

import java.io.Serializable;

public class Stocks implements Serializable {

	private String stockName;
	private int shares;
	private double shareprice;

	public Stocks(String stockName, int shares, double price) {
		super();
		this.stockName = stockName;
		this.shares = shares;
		this.shareprice = price;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public double getPrice() {
		return shareprice;
	}

	public void setPrice(double price) {
		this.shareprice = price;
	}

	public double getTotalValue() {
		return this.shares * this.shareprice;
	}

	@Override
	public String toString() {
		return "{ stockName : " + stockName + "\nshares : " + shares + "\nshareprice : " + shareprice + " }";
	}

}
