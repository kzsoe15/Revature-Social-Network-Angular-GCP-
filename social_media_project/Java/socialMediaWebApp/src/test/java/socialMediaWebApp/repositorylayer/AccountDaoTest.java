package socialMediaWebApp.repositorylayer;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import socialMediaWebApp.models.Account;

@Transactional
public class AccountDaoTest 
{
	
	public static ApplicationContext appContext = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	AccountDao accountDaoImpl = 
			appContext.getBean("accountDaoImpl", AccountDao.class);
	
	@Test
	@DisplayName("getMyAccountByUserNameAndPasswordTestEquals")
    public void getMyAccountByUserNameAndPasswordTestEquals()
    {
    	
		String username = "TheFridge";
		String password = "27cc6994fc1c01ce6659c6bddca9b69c4c6a9418065e612c69d110b3f7b11f8a";
		
    	Account expectedAccount = new Account(8, "TheFridge", "27cc6994fc1c01ce6659c6bddca9b69c4c6a9418065e612c69d110b3f7b11f8a", null, 
    			"FrankThomas@gmail.com", null, "Frank", "Thomas", null, null);

    	Account actualAccount = 
    			accountDaoImpl.getMyAccount(username ,password);
    	actualAccount.setMyComments(null);
    	actualAccount.setLikedPosts(null);
    	actualAccount.setMyPosts(null);
    	
    	
    	
    	
    	assertEquals(expectedAccount, actualAccount);
    }
    
	@Test
	@DisplayName("getAccountByIdTestEquals")
	public void getAccountByIdTestEquals()
	{
		int userId = 8;

		
		Account expectedAccount = new Account(8, "TheFridge", "27cc6994fc1c01ce6659c6bddca9b69c4c6a9418065e612c69d110b3f7b11f8a", null, 
    			"FrankThomas@gmail.com", null, "Frank", "Thomas", null, null);
		
    	Account actualAccount = 
    			accountDaoImpl.getAccountById(userId);
    	actualAccount.setMyComments(null);
    	actualAccount.setMyPosts(null);
    	actualAccount.setLikedPosts(null);
		
    	assertEquals(expectedAccount, actualAccount);
	}
	
	
	@Test
	@DisplayName("getUserAccountByUsernameTestEquals")
	public void getUserAccountByUsernameTestEquals()
	{
		
		String username = "TheFridge";

		Account expectedAccount = new Account(8, "TheFridge", "27cc6994fc1c01ce6659c6bddca9b69c4c6a9418065e612c69d110b3f7b11f8a", null, 
    			"FrankThomas@gmail.com", null, "Frank", "Thomas", null, null);
		
    	Account actualAccount = 
    			accountDaoImpl.getUserAccountByUsername(username);
    	actualAccount.setMyComments(null);
    	actualAccount.setMyPosts(null);
    	actualAccount.setLikedPosts(null);
		
    	assertEquals(expectedAccount, actualAccount);
	}
	
	
	@Test
	@DisplayName("getMyAccountByEmailAndUsernameTestEquals")
	public void getMyAccountByEmailAndUsernameTestEquals()
	{
		String username = "TheFridge";
		String email = "FrankThomas@gmail.com";

		Account expectedAccount = new Account(8, "TheFridge", "27cc6994fc1c01ce6659c6bddca9b69c4c6a9418065e612c69d110b3f7b11f8a", null, 
    			"FrankThomas@gmail.com", null, "Frank", "Thomas", null, null);
		
    	Account actualAccount = 
    			accountDaoImpl.getMyAccountByEmailAndUsername(username, email);
    	actualAccount.setMyComments(null);
    	actualAccount.setMyPosts(null);
    	actualAccount.setLikedPosts(null);
		
    	assertEquals(expectedAccount, actualAccount);
	}
	
	@Test
	@DisplayName("getMyAccountByUserNameAndPasswordTestNotEquals")
    public void getMyAccountByUserNameAndPasswordTestNotEquals()
    {
		String username = "TheFridge";
		String password = "27cc6994fc1c01ce6659c6bddca9b69c4c6a9418065e612c69d110b3f7b11f8a";
    	Account expectedAccount = new Account(8, "FakeUserName", "fakePassword", null, 
    			"FrankThomas@gmail.com", null, "Frank", "Thomas", null, null);

    	Account actualAccount = 
    			accountDaoImpl.getMyAccount(username ,password);
    	actualAccount.setMyComments(null);
    	actualAccount.setLikedPosts(null);
    	actualAccount.setMyPosts(null);
    	
    	
    	
    	
    	assertNotEquals(expectedAccount, actualAccount);
    }
    
	@Test
	@DisplayName("getAccountByIdTestNotEquals")
	public void getAccountByIdTestNotEquals()
	{
		int userId = 8;

		
		Account expectedAccount = new Account(88, "TheFridge", "27cc6994fc1c01ce6659c6bddca9b69c4c6a9418065e612c69d110b3f7b11f8a", null, 
    			"FrankThomas@gmail.com", null, "Frank", "Thomas", null, null);
		
    	Account actualAccount = 
    			accountDaoImpl.getAccountById(userId);
    	actualAccount.setMyComments(null);
    	actualAccount.setMyPosts(null);
    	actualAccount.setLikedPosts(null);
		
    	assertNotEquals(expectedAccount, actualAccount);
	}
	
	
	@Test
	@DisplayName("getUserAccountByUsernameTestNotEquals")
	public void getUserAccountByUsernameTestNotEquals()
	{
		
		String username = "TheFridge";

		Account expectedAccount = new Account(8, "FakeUserName", "27cc6994fc1c01ce6659c6bddca9b69c4c6a9418065e612c69d110b3f7b11f8a", null, 
    			"FrankThomas@gmail.com", null, "Frank", "Thomas", null, null);
		
    	Account actualAccount = 
    			accountDaoImpl.getUserAccountByUsername(username);
    	actualAccount.setMyComments(null);
    	actualAccount.setMyPosts(null);
    	actualAccount.setLikedPosts(null);
		
    	assertNotEquals(expectedAccount, actualAccount);
	}
	
	
	@Test
	@DisplayName("getMyAccountByEmailAndUsernameTestNotEquals")
	public void getMyAccountByEmailAndUsernameTestNotEquals()
	{
		
		String username = "TheFridge";
		String email = "FrankThomas@gmail.com";

		Account expectedAccount = new Account(8, "FakeUserName", "27cc6994fc1c01ce6659c6bddca9b69c4c6a9418065e612c69d110b3f7b11f8a", null, 
    			"FakeThomas@gmail.com", null, "Frank", "Thomas", null, null);
		
    	Account actualAccount = 
    			accountDaoImpl.getMyAccountByEmailAndUsername(username, email);
    	actualAccount.setMyComments(null);
    	actualAccount.setMyPosts(null);
    	actualAccount.setLikedPosts(null);
    	
    	assertNotEquals(expectedAccount, actualAccount);
	}
    
}
