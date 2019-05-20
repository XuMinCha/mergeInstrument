package com.instrument.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import com.instrument.service.IInstrument;
import com.instrument.service.IRule;

public class PreferenceRuleImpl implements IRule {

	private IInstrument[] instruments;
	
	public PreferenceRuleImpl(IInstrument... instruments) {
		this.instruments = instruments;
	}
	
	public Map<String,Object> merge() {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Stream.of(this.instruments).filter(instr -> instr.getName().startsWith("PB_") || instr.getName().startsWith("PRIME_PB_"))
		                      .forEach(instr -> {
		                    	  if(instr.getName().startsWith("PB_")) {
		                    		  PBInstrumentImpl impl = (PBInstrumentImpl)instr;
		                    		  resultMap.put("LAST_TRADING_DATE", impl.getLastTradingDate());
		                    		  resultMap.put("DELIVERY_DATE", impl.getDeliveryDate());
		                    	  }
		                    	  if(instr.getName().startsWith("PRIME_PB_")) {
		                    		  PrimePBInstrumentImpl impl = (PrimePBInstrumentImpl)instr;
		                    		  resultMap.put("TRADABLE", impl.isTradable());
		                    	  }
		                      });
		return resultMap;
	}

}
