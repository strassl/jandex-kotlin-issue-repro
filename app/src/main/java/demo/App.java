package demo;

import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import org.jboss.jandex.*;

public class App {
  public static void main(String[] args) throws IOException {
    Indexer indexer = new Indexer();
    indexer.index(App.class.getClassLoader().getResourceAsStream("demo/JavaAnnotationHolder.class"));
    indexer.index(App.class.getClassLoader().getResourceAsStream("demo/KotlinAnnotationHolder.class"));
    indexer.index(App.class.getClassLoader().getResourceAsStream("demo/TestAnnotation.class"));
    Index index = indexer.complete();

    DotName testAnnotation = DotName.createSimple("demo.TestAnnotation");
    List<AnnotationInstance> annotations = index.getAnnotations(DotName.createSimple("demo.TestAnnotation"));
    
    for (AnnotationInstance annotation : annotations) {
      System.out.println(annotation);
      TypeTarget typeTarget = annotation.target().asType();
      System.out.println("Usage type: " + typeTarget.usage());
      System.out.println("Type usage is located within: " + typeTarget.enclosingTarget() + "(" + typeTarget.enclosingTarget().asMethod().declaringClass() + ")");
      System.out.println("Usage type: " + typeTarget.usage());
      System.out.println("Target type: "  + typeTarget.target());
    }
  }
}