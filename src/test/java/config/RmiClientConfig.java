package config;

import dao.SingerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

@Configuration
public class RmiClientConfig {

	@Bean
	public SingerService singerService() {
		HttpInvokerProxyFactoryBean factoryBean = new HttpInvokerProxyFactoryBean();
		factoryBean.setServiceInterface(SingerService.class);
		factoryBean.setServiceUrl("http://localhost:8080/spring_http_war/invoker/httpInvoker/singerService");
		factoryBean.afterPropertiesSet();
		return (SingerService) factoryBean.getObject();
	}
}
