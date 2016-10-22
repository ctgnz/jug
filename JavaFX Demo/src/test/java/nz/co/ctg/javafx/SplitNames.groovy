package nz.co.ctg.javafx

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith

import groovyjarjarantlr.StringUtils;;

@RunWith(ConcordionRunner.class)
class SplitNames {

  public Result split(String fullName) {
    Result result = new Result();
    String[] words = NameSplitter.splitName(fullName);
    result.firstName = words[0];
    result.lastName = words[1];
    return result;
  }

  class Result {
    public String firstName = "TODO";
    public String lastName = "TODO";
  }
  
  def isValid(String text) {
    if ("Smith" == text)
      return text
    return "Unknown"
  }
  
  def getLastName(Result result) {
    return isValid(result.lastName)
  }
  
}
