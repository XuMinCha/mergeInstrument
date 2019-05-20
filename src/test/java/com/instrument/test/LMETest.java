package com.instrument.test;

import com.instrument.service.impl.LMEExchange;
import com.instrument.service.impl.PBInstrumentImpl;
import com.instrument.service.impl.PreferenceRuleImpl;
import com.instrument.service.impl.PrimePBInstrumentImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class LMETest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LMETest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( LMETest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	PBInstrumentImpl pbInstrument = new PBInstrumentImpl("03_2018","  15-03-2018         "," 17-03-2018    ","  LME_PB   "," Lead 13 March 2018 ","  TRUE           ");
    	PrimePBInstrumentImpl primeIntrument = new PrimePBInstrumentImpl("03_2018","  14-03-2018        "," 18-03-2018    ","  LME_PB   "," Lead 13 March 2018 ","  FALSE         ");
    	PreferenceRuleImpl rule = new PreferenceRuleImpl(pbInstrument,primeIntrument);
    	LMEExchange lme = new LMEExchange();
    	String pbResult = lme.publish(pbInstrument, rule);
    	System.out.println(pbResult);
        assertTrue( true );
    }
}
