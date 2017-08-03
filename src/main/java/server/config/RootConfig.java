package server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.BurlapServiceExporter;
import org.springframework.remoting.caucho.HessianServiceExporter;

import server.Calculator;
import server.CalculatorImpl;

@Configuration
public class RootConfig {
	@Bean
	public Calculator calculator(){
		return new CalculatorImpl();
	}
	
	@Bean
	public HessianServiceExporter hessianExportedCalculatorService(Calculator calculator){
		HessianServiceExporter exporter = new HessianServiceExporter();
		exporter.setService(calculator);
		exporter.setServiceInterface(Calculator.class);
		return exporter;
	}
	
	@Bean
	public BurlapServiceExporter burlapExportedCalculatorService(Calculator calculator){
		BurlapServiceExporter exporter = new BurlapServiceExporter();
		exporter.setService(calculator);
		exporter.setServiceInterface(Calculator.class);
		return exporter;
	}
	
}
