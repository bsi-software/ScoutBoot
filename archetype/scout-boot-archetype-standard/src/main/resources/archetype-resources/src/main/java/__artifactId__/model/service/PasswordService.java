#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.model.service;

public interface PasswordService {

  public static final int PASSWORD_LENGTH_MIN = 3;
  public static final int PASSWORD_LENGTH_MAX = 64;

  /**
   * Checks if the provided password matches the implemented policy. The implemented policy does a null check and
   * verifies the password length.
   *
   * @param password
   * @return
   */
  public boolean matchesPasswordPolicy(String password);

  /**
   * @param passwordPlainAttempt
   * @param passwordHash
   * @return
   */
  public boolean passwordIsValid(String passwordPlainAttempt, String passwordHash);

  /**
   * @param passwordNew
   * @return
   */
  public String calculatePasswordHash(String passwordNew);
}
