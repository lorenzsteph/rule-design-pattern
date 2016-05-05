package it.design.pattern;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ChainOfResponsibilityTests.class, ServiceLocatorTests.class, ServiceLocatorAndChainTests.class })
public class AllTests {
}
