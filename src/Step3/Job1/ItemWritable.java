package stubs;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class ItemWritable implements WritableComparable<ItemWritable> {

  String id;
  Double value;

  public ItemWritable() {}
  public ItemWritable(String id, double rate) {
	  this.id = id;
	  this.value = rate;
  }

  /**
   * Serializes the fields of this object to out.
   */
  public void write(DataOutput out) throws IOException {
    out.writeUTF(id);
    out.writeDouble(value);
  }

  /**
   * Deserializes the fields of this object from in.
   */
  public void readFields(DataInput in) throws IOException {
    id = in.readUTF();
    value = in.readDouble();
  }

  /**
   * Compares this object to another StringPairWritable object by
   * comparing the left strings first. If the left strings are equal,
   * then the right strings are compared.
   */
  public int compareTo(ItemWritable other) {
	  return Double.compare(other.value, this.value);
  }

  /* getters and setters for the two objects in the pair */
  public String getid() {
	  return id;
  }
  
  public double getRate() {
	  return value;
  }
  
  public void setid(String id) {
	  this.id = id;
  }
  
  public void setRate(double rate) {
	  this.value = rate;
  }

  /**
   * A custom method that returns the two strings in the 
   * StringPairWritable object inside parentheses and separated by
   * a comma. For example: "(left,right)".
   */
  public String toString() {
    return "(" + id + "," + value + ")";
  }

  /**
   * The equals method compares two StringPairWritable objects for 
   * equality. The equals and hashCode methods have been automatically
   * generated by Eclipse by right-clicking on an empty line, selecting
   * Source, and then selecting the Generate hashCode() and equals()
   * option. 
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ItemWritable other = (ItemWritable) obj;
    return this.id.equals(other.id) && this.value == other.value;
  }

  /**
   * The hashCode method generates a hash code for a StringPairWritable 
   * object. The equals and hashCode methods have been automatically
   * generated by Eclipse by right-clicking on an empty line, selecting
   * Source, and then selecting the Generate hashCode() and equals()
   * option. 
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + value.hashCode();
    return result;
  }
}
