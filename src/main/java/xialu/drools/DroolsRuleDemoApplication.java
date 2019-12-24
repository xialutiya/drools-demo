package xialu.drools;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("xialu.drools.dao")
@SpringBootApplication
public class DroolsRuleDemoApplication {

    protected static Logger logger = LoggerFactory.getLogger(DroolsRuleDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DroolsRuleDemoApplication.class, args);
        logger.info("SpringBoot Start Success");
    }

}
