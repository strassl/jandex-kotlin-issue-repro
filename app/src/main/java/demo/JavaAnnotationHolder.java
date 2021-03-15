package demo;

import demo.TestAnnotation;
import java.util.List;

public class JavaAnnotationHolder {
  public JavaAnnotationHolder(List<@TestAnnotation ? extends List<@TestAnnotation ? extends Object>> testParameter) {
  }
}