package rlouol.example.springwebfluxbaeldungexample.model;

public class Employee {

  private String id;
  private String name;

  public Employee() {}

  public Employee(String id, String name) {
    this.id = id;
    this.name = id;
  }

  public String getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Employee) {
      return this.id.equals(((Employee) obj).getId()) && this.name.equals(((Employee) obj).getName());
    }

    return false;
  }

  @Override
  public String toString() {
    return "Employee(id=" + this.id + ",name=" + this.name + ")";
  }
}
