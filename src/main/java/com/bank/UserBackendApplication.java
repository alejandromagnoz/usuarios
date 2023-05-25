package com.bank;

import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
//@EnableJms
public class UserBackendApplication {

	public static void main(String[] args) throws ParseException {
		ConfigurableApplicationContext context = SpringApplication.run(UserBackendApplication.class, args);
		
		// Send a message with a POJO - the template reuse the message converter
		/*JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
	    List<Venta> listadoVentas = new ArrayList<>();
	    Venta venta = new Venta();
	    venta.setCantidad(1);
	    venta.setCodigo(1);
	    
	    SimpleDateFormat formatB = new SimpleDateFormat("dd/MM/yyyy");
		String fechaVenta = "2019/10/10"; 
		
	    
	    venta.setFechaVenta(formatB.parse(fechaVenta));
	    venta.setIdVenta(Long.valueOf("123"));
	    venta.setNombre("Hotdog");
	    venta.setPrecio(1000);
	    venta.setTotal(1000);
	    listadoVentas.add(venta);
	    jmsTemplate.convertAndSend("listadoventas", listadoVentas);*/
	    
	    
	}
/*

	@Bean
	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		// This provides all boot's default to this factory, including the message converter
		configurer.configure(factory, connectionFactory);
		// You could still override some of Boot's default if necessary.
		return factory;
	}

	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
*/
}
