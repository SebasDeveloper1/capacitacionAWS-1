package co.com.ath.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountInfoTest {
    @Test
    public void testAccountNumberGetterSetter() {
        AccountInfo accountInfo = new AccountInfo();

        // Establecer el número de cuenta
        String accountNumber = "1234567890";
        accountInfo.setAccountNumber(accountNumber);

        // Comprobar que se recupera correctamente el número de cuenta
        assertEquals(accountNumber, accountInfo.getAccountNumber());
    }

    @Test
    public void testAccountTypeGetterSetter() {
        AccountInfo accountInfo = new AccountInfo();

        // Establecer el tipo de cuenta
        String accountType = "Ahorro";
        accountInfo.setAccountType(accountType);

        // Comprobar que se recupera correctamente el tipo de cuenta
        assertEquals(accountType, accountInfo.getAccountType());
    }

    @Test
    public void testAccountKeyGetterSetter() {
        AccountInfo accountInfo = new AccountInfo();

        // Establecer la clave de la cuenta
        String accountKey = "122121212";
        accountInfo.setAccountKey(accountKey);

        // Comprobar que se recupera correctamente la clave de la cuenta
        assertEquals(accountKey, accountInfo.getAccountKey());
    }

    @Test
    public void testBankGetterSetter() {
        AccountInfo accountInfo = new AccountInfo();

        // Establecer el nombre del banco
        String bank = "Banco de Bogotá";
        accountInfo.setBank(bank);

        // Comprobar que se recupera correctamente el nombre del banco
        assertEquals(bank, accountInfo.getBank());
    }

    @Test
    public void testBalanceGetterSetter() {
        AccountInfo accountInfo = new AccountInfo();

        // Establecer el saldo de la cuenta
        Double balance = 1000.5;
        accountInfo.setBalance(balance);

        // Comprobar que se recupera correctamente el saldo de la cuenta
        assertEquals(balance, accountInfo.getBalance());
    }
}