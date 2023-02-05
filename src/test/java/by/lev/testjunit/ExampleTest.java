package by.lev.testjunit;

import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@SelectPackages("by.lev.testjunit")
@ExcludePackages("exampletest")
@IncludeTags("TagExample")
@Suite
public class ExampleTest {

}