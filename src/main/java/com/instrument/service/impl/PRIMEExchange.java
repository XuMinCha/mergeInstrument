package com.instrument.service.impl;

import java.util.Map;

import com.instrument.service.IExchange;
import com.instrument.service.IInstrument;
import com.instrument.service.IRule;

public class PRIMEExchange implements IExchange {

	@Override
	public String publish(IInstrument instrument, IRule rule) {
		Map<String,Object> result = rule.merge();
		if(instrument instanceof PBInstrumentImpl) {
			PBInstrumentImpl pbImpl = (PBInstrumentImpl)instrument;
			pbImpl.setTradable(result.get("TRADABLE") != null? result.get("TRADABLE").toString() : "");
			return pbImpl.aggregate();
		}
		else if(instrument instanceof PrimePBInstrumentImpl) {
			PrimePBInstrumentImpl primeImpl = (PrimePBInstrumentImpl)instrument;
			primeImpl.setLastTradingDate(result.get("LAST_TRADING_DATE") != null? result.get("LAST_TRADING_DATE").toString() : "");
			primeImpl.setDeliveryDate(result.get("DELIVERY_DATE") != null? result.get("DELIVERY_DATE").toString() : "");
			return primeImpl.aggregate();
		}
		return "";
	}
}
