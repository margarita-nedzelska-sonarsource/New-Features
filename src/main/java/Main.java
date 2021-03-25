import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;


final class IntF implements F {

  @Override
  public void f() {
    System.out.println("Hello!");
  }
}


sealed interface I {};

non-sealed interface U extends I {}

final class A implements I, U {
}

sealed class P {}

final class PP extends P {}


final record Person(String name, int age, String comment) implements Serializable {
}

public class Main {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("margo.txt"));
    Person o = (Person)ois.readObject();
    
    P p = new P();

    System.out.println(o);
    

/*
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("margo.txt"));
    oos.writeObject(new Person("Margo", 26));*/
  }
}
