package com.instrument.service.impl;

import com.instrument.service.IInstrument;

public class PBInstrumentImpl implements IInstrument {
	
	private String prefix = "PB_";
	
	private String name;
	
	private static final String SEPERATOR = "|";
	
	private static final String NEWLINE = "\n\r";
	
	private String lastTradingDate;
	
	private String deliveryDate;
	
	private String market;
	
	private String label;
	
	private String tradable;
	
	public PBInstrumentImpl(String suffix,String lastTradingDate,String deliveryDate,String market,String label,String tradable) {
		this.name = this.prefix+suffix;
		this.lastTradingDate = lastTradingDate;
		this.deliveryDate = deliveryDate;
		this.market = market;
		this.label = label;
		this.tradable = tradable;
	}
	
	public String aggregate() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getName()).append(NEWLINE);
		sb.append(SEPERATOR).append("  LAST_TRADING_DATE  ")
		  .append(SEPERATOR).append(" DELIVERY_DATE ")
		  .append(SEPERATOR).append("  MARKET   ")
		  .append(SEPERATOR).append("LABEL              ")
		  .append(SEPERATOR).append("TRADABLE           ")
		  .append(SEPERATOR).append(NEWLINE);
		sb.append(SEPERATOR).append(this.lastTradingDate)
		  .append(SEPERATOR).append(this.deliveryDate)
		  .append(SEPERATOR).append(this.market)
		  .append(SEPERATOR).append(this.label)
		  .append(SEPERATOR).append(this.tradable)
		  .append(SEPERATOR).append(NEWLINE);
		return sb.toString();
	}

	@Override
	public String getName() {
		return this.name;
	}

	public String getLastTradingDate() {
		return lastTradingDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setLastTradingDate(String lastTradingDate) {
		this.lastTradingDate = lastTradingDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public void setTradable(String tradable) {
		this.tradable = tradable;
	}
	
}
