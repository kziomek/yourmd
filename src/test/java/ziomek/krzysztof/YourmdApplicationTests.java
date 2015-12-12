package ziomek.krzysztof;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ziomek.krzysztof.yourmd.YourmdApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = YourmdApplication.class)
@WebAppConfiguration
public class YourmdApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("Go");
	}


}
