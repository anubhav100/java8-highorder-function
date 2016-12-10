package main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CreateHighOrderFunction {
  private static List<Integer> list;
  private static List<Integer> result = new ArrayList<>();

  public CreateHighOrderFunction(List<Integer> list) {
    CreateHighOrderFunction.list = list;
  }

  //find Even Number is a function which takes a Predicate

  public static List<Integer> findEvenNumbers(Predicate<Integer> predicateToApply) {

    BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> filter;
    //here filter is a BiFunction Which act as a high order Function it takes a list,another function predicate
    // as a argument

    filter = (listOfIntegers, predicate) -> {
      result.addAll(list.stream().filter(predicate).collect(Collectors.toList()));
      return result;
    };
    //called the apply method of BiFunction and sent list and predicateToApply as argument

    filter.apply(list, predicateToApply);
    return result;

  }
}