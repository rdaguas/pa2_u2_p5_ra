package com.uce.edu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.IHotelService;

@SpringBootApplication
public class Pa2U2P5RaApplication implements CommandLineRunner {

	@Autowired
	private IHotelService iHotelService;
	
	@Autowired
	private IHabitacionService iHabitacionService;


	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5RaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Hotel hote = new Hotel();
		hote.setNombre("Marriot");
		hote.setDireccion("Av.Colon");
		

		Habitacion h1 = new Habitacion();
		h1.setClase("Economica");
		h1.setNumero("A7");
		h1.setHotel(hote);
		
		Habitacion h2 = new Habitacion();
		h2.setClase("VIP");
		h2.setNumero("A8");
		h2.setHotel(hote);
		
		List<Habitacion> habitaciones = new ArrayList<>();
		habitaciones.add(h1);
		habitaciones.add(h2);
		hote.setHabitaciones(habitaciones);
		this.iHotelService.guardar(hote);
		
		//buscar hotel
		Hotel hoteb = this.iHotelService.buscar(1);
		System.out.println(hoteb);
		
		//actualizar hotel
		Hotel hoteAc = this.iHotelService.buscar(2);
		hoteAc.setNombre("Colon");
		this.iHotelService.actualizar(hoteAc);
		
		//eliminar hotel
		this.iHotelService.eliminar(3);
	}

}
