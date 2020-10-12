package sanguino;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import sanguino.mastermind.AllMasterMindTest;
import sanguino.utils.AllUtilsTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    AllMasterMindTest.class,
    AllUtilsTest.class } )
public class AllTest {
    
}