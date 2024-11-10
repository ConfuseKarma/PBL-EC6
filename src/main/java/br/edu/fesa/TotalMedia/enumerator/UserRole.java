
package br.edu.fesa.TotalMedia.enumerator;

public enum UserRole {
    
  CLIENT(0),
  CRITIC(1),
  ADMIN(2);

  private final int id;

  // Construtor para o enum
  UserRole(int id) {
    this.id = id;
  }

  // Getter para o id
  public int getId() {
    return id;
  }
}
