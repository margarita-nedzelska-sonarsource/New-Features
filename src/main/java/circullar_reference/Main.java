package circullar_reference;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Data implements Serializable {
  private static final long serialVersionUID = 0L;
  Object obj;
}
class Carrier implements Serializable {
  private static final long serialVersionUID = 1L;
  private final Data d;
  public Carrier(Data d) {
    this.d = d;
  }
  public Data d() {
    return d;
  }
}
public class Main {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    Data d1 = new Data();
    Carrier c1 = new Carrier(d1);
    d1.obj = c1;
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("out.txt"));
    oos.writeObject(c1);
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("out.txt"));
    Carrier carrier = (Carrier) ois.readObject();
    System.out.println(carrier == carrier.d().obj);
  }
}
