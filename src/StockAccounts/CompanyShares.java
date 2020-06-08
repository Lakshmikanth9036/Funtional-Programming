package StockAccounts;

import java.time.LocalDateTime;

public class CompanyShares {
	
	private String symbol;
	private int shares;
	private String status;
	private LocalDateTime dateNtime;
	
	public CompanyShares(String symbol, int shares, String status, LocalDateTime dateNtime) {
		super();
		this.symbol = symbol;
		this.shares = shares;
		this.status = status;
		this.dateNtime = dateNtime;
	}
	
	public String getSymbol() {
		return symbol;
	}

	public int getShares() {
		return shares;
	}

	public String getStatus() {
		return status;
	}

	public LocalDateTime getDateNtime() {
		return dateNtime;
	}

	@Override
	public String toString() {
		return "\n{ symbol : " + symbol + "\nshares : " + shares + "\nstatus : " + status + "\ndateNtime : "
				+ dateNtime + " }\n";
	}
	
}
