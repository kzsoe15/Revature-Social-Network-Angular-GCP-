package socialMediaWebApp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import socialMediaWebApp.controllers.SessionAccountController;
import socialMediaWebApp.models.Account;
import socialMediaWebApp.servicelayer.AccountService;
import socialMediaWebApp.servicelayer.EmailService;


@ExtendWith(MockitoExtension.class)
public class UserAccountController 
{

    SessionAccountController accountController;
    
    
    @Mock
    AccountService accountService;
    
    @Mock
    EmailService emailService;
    
    
    @BeforeEach
    public void setUp()
    {
    	accountController = new SessionAccountController(accountService, emailService);
    }
    /*
     * Testing the method getUser() inside the controller layer
     * 
     */
    @Test
    @DisplayName("getUserTestEquals")
    public void getUserTestEquals()
    {
    	String username = "test2";
		String password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3";
		
//		Set
    	Account mockAccount = new Account(2, username, password, null, 
    			"test2@gmail.com", null, "oldname", "newlname", null, null);
    	Account expectedAccount = new Account(2, username, password, null, 
    			"test2@gmail.com", null, "oldname", "newlname", null, null);
//    	Define
    	when(accountService.getMyAccount(username, password)).thenReturn(mockAccount);
    	
    	Account actualAccount = accountService.getMyAccount(username, password);
//    	Assert
    	verify(accountService, times(1)).getMyAccount(username, password);
    	assertEquals(expectedAccount, actualAccount);
    }
    
    @Test
    @DisplayName("getUserTestNotEquals")
    public void getUserTestNotEquals()
    {
    	String username = "test2";
		String password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3";
		
//		Set
    	Account mockAccount = new Account(2, username, password, null, 
    			"test1@gmail.com", null, "oldname", "newlname", null, null);
    	Account expectedAccount = new Account(2, username, password, null, 
    			"test2@gmail.com", null, "oldname", "newlname", null, null);
//    	Define
    	when(accountService.getMyAccount(username, password)).thenReturn(mockAccount);
    	
    	Account actualAccount = accountService.getMyAccount(username, password);
//    	Assert
    	verify(accountService, times(1)).getMyAccount(username, password);
    	assertNotEquals(expectedAccount, actualAccount);
    }
    
    /*
     *Testing themethod getAccountById() inside the controller layer 
     * 
     */
    @Test
	@DisplayName("getAccountByIdTestEquals")
	public void getAccountByIdTestEquals()
	{
		int userId = 2;
		String username = "test2";
		String password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3";

//		Set
		Account mockAccount = new Account(2, username, password, null, 
    			"test2@gmail.com", null, "oldname", "newlname", null, null);
		
		Account expectedAccount = new Account(2, username, password, null, 
    			"test2@gmail.com", null, "oldname", "newlname", null, null);
//    	Defene mock
    	when(accountService.getAccountById(userId)).thenReturn(mockAccount);
    	
    	Account actualAccount = accountService.getAccountById(userId);
    
//    	Assert
    	verify(accountService, times(1)).getAccountById(userId);
    	assertEquals(expectedAccount, actualAccount);
	}
    
    @Test
	@DisplayName("getAccountByIdTestEquals")
	public void getAccountByIdTestNotEquals()
	{
		int userId = 2;
		String username = "test2";
		String password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3";

//		Set
		Account mockAccount = new Account(1, username, password, null, 
    			"test2@gmail.com", null, "oldname", "newlname", null, null);
		
		Account expectedAccount = new Account(2, username, password, null, 
    			"test2@gmail.com", null, "oldname", "newlname", null, null);
//    	Defene mock
    	when(accountService.getAccountById(userId)).thenReturn(mockAccount);
    	
    	Account actualAccount = accountService.getAccountById(userId);
    
//    	Assert
    	verify(accountService, times(1)).getAccountById(userId);
    	assertNotEquals(expectedAccount, actualAccount);
	}
	
	/*
	 * Testing the method getAccountByUsername() in the controller layer
	 * 
	 */
	@Test
	@DisplayName("getUserAccountByUsernameTestEquals")
	public void getUserAccountByUsernameTestEquals()
	{
		String username = "test2";
		String password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3";

		Account mockAccount = new Account(2, username, password, null, 
    			"test2@gmail.com", null, "oldname", "newlname", null, null);
		
		Account expectedAccount = new Account(2, username, password, null, 
    			"test2@gmail.com", null, "oldname", "newlname", null, null);
    	
    	when(accountService.getUserAccountByUsername(username)).thenReturn(mockAccount);
    	
    	Account actualAccount = accountService.getUserAccountByUsername(username);
    	
    	verify(accountService, times(1)).getUserAccountByUsername(username);
    	assertEquals(expectedAccount, actualAccount);
	}
	
	@Test
	@DisplayName("getUserAccountByUsernameTestEquals")
	public void getUserAccountByUsernameTestNotEquals()
	{
		String username = "test2";
		String password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3";

		Account mockAccount = new Account(2, "fakeUserName", password, null, 
    			"test2@gmail.com", null, "oldname", "newlname", null, null);
		
		Account expectedAccount = new Account(2, username, password, null, 
    			"test2@gmail.com", null, "oldname", "newlname", null, null);
    	
    	when(accountService.getUserAccountByUsername(username)).thenReturn(mockAccount);
    	
    	Account actualAccount = accountService.getUserAccountByUsername(username);
    	
    	verify(accountService, times(1)).getUserAccountByUsername(username);
    	assertNotEquals(expectedAccount, actualAccount);
	}
	
	/*
	 *Test the method getMyAccountByEmailAndUsername() in the controller layer 
	 * 
	 */
	@Test
	@DisplayName("getMyAccountByEmailAndUsernameTestEquals")
	public void getMyAccountByEmailAndUsernameTestEquals()
	{
		String username = "test2";
		String email = "test2@gmail.com";
		String password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3";

		Account mockAccount = new Account(2, username, password, null, 
    			"test2@gmail.com", null, "oldname", "newlname", null, null);
		
		Account expectedAccount = new Account(2, username, password, null, 
    			"test2@gmail.com", null, "oldname", "newlname", null, null);
    	
    	when(accountService.getMyAccountByEmailAndUsername(username, email)).thenReturn(mockAccount);
    	
    	Account actualAccount = accountService.getMyAccountByEmailAndUsername(username, email);
    	
    	verify(accountService, times(1)).getMyAccountByEmailAndUsername(username, email);
    	assertEquals(expectedAccount, actualAccount);
	}
	
	@Test
	@DisplayName("getMyAccountByEmailAndUsernameTestEquals")
	public void getMyAccountByEmailAndUsernameTestNotEquals()
	{
		String username = "test2";
		String email = "test2@gmail.com";
		String password = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3";

		Account mockAccount = new Account(2, username, password, null, 
    			"test0@gmail.com", null, "oldname", "newlname", null, null);
		
		Account expectedAccount = new Account(2, username, password, null, 
    			"test2@gmail.com", null, "oldname", "newlname", null, null);
    	
    	when(accountService.getMyAccountByEmailAndUsername(username, email)).thenReturn(mockAccount);
    	
    	Account actualAccount = accountService.getMyAccountByEmailAndUsername(username, email);
    	
    	verify(accountService, times(1)).getMyAccountByEmailAndUsername(username, email);
    	assertNotEquals(expectedAccount, actualAccount);
	}
    

    
}