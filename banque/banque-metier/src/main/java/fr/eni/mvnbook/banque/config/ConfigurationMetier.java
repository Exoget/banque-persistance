package fr.eni.mvnbook.banque.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({
    "fr.eni.mvnbook.banque.metier"
})
public class ConfigurationMetier {

}
