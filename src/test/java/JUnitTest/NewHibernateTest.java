package JUnitTest;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oreo.charity.beans.BankAccount;
import com.oreo.charity.beans.Donation;
import com.oreo.charity.beans.Event;
import com.oreo.charity.beans.Organization;
import com.oreo.charity.beans.OrganizationType;
import com.oreo.charity.beans.User;
import com.oreo.charity.beans.UserRole;
import com.oreo.charity.dataTier.BankAccountDAO;
import com.oreo.charity.dataTier.DataFacade;
import com.oreo.charity.dataTier.DonationDAO;
import com.oreo.charity.dataTier.EventDAO;
import com.oreo.charity.dataTier.OrganizationDAO;
import com.oreo.charity.dataTier.OrganizationTypeDAO;
import com.oreo.charity.dataTier.UserDAO;
import com.oreo.charity.dataTier.UserRoleDAO;

public class NewHibernateTest {
	
	private static ApplicationContext contxt;

	@BeforeClass
	public static void setup() {
		contxt = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	@Test
	public void testFacade(){
		System.out.println( contxt.getBean(DataFacade.class).getBankAccount() );
		System.out.println( contxt.getBean(DataFacade.class).getDonation() );
		//System.out.println( contxt.getBean(DataFacade.class).getEvent() );
		//System.out.println( contxt.getBean(DataFacade.class).getOrganization() );
		//System.out.println( contxt.getBean(DataFacade.class).getOrganizationType() );
		//System.out.println( contxt.getBean(DataFacade.class).getUser() );
		//System.out.println( contxt.getBean(DataFacade.class).getUserRole() );
	}
	
	@Test
	@Ignore
	public void testGetFromEveryTable() {
		
		BankAccount bean1 = contxt.getBean(BankAccountDAO.class).get(1);
		OrganizationType bean6 = contxt.getBean(OrganizationTypeDAO.class).get(1);
		UserRole bean2 = contxt.getBean(UserRoleDAO.class).get(1);
		Donation bean3 = contxt.getBean(DonationDAO.class).get(1);
		Event bean4 = contxt.getBean(EventDAO.class).get(1);
		Organization bean5 = contxt.getBean(OrganizationDAO.class).get(1);
		User bean7 = contxt.getBean(UserDAO.class).get(1);

		System.out.println(bean1);
		System.out.println(bean6);
		System.out.println(bean2);
		System.out.println(bean3);
		System.out.println(bean4);
		System.out.println(bean5);
		System.out.println(bean7);
	}
}
