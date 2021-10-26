package ir.maktab.bustransportation.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public FilterRegistrationBean<CustomerFilter> filterRegistrationBean() {
        FilterRegistrationBean<CustomerFilter> registrationBean = new FilterRegistrationBean();
        CustomerFilter customerFilter = new CustomerFilter();

        registrationBean.setFilter(customerFilter);
        registrationBean.addUrlPatterns("/User-Page");
        registrationBean.addUrlPatterns("/passenger-form");
        registrationBean.addUrlPatterns("/tickets");
        registrationBean.addUrlPatterns("/add-customer-ticket");
        registrationBean.addUrlPatterns("/customers-ticket");
        registrationBean.addUrlPatterns("/ticket-detail");
        registrationBean.addUrlPatterns("/remove-ticket");

        return registrationBean;
    }
}
