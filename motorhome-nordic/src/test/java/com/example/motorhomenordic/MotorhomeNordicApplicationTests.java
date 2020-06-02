package com.example.motorhomenordic;

import com.example.motorhomenordic.models.Booking;
import com.example.motorhomenordic.models.Customer;
import com.example.motorhomenordic.repositories.BookingRepositoryDB;
import com.example.motorhomenordic.repositories.CustomerRepositoryDB;
import com.example.motorhomenordic.repositories.IBookingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MotorhomeNordicApplicationTests {

	BookingRepositoryDB bookingRepositoryDB;
	CustomerRepositoryDB customerRepositoryDB;

	@Test
	public void getLastBookingTest(){

		//Arrange
		bookingRepositoryDB = new BookingRepositoryDB();
		//ACT
		int booking_id = 12;
		int actual = bookingRepositoryDB.getLastBookingID();
		//Assert
		assertEquals(booking_id, actual);

	}


	@Test
	public void getBookingTest(){
		//Arrange
		bookingRepositoryDB = new BookingRepositoryDB();
		Booking booking = new Booking(10, "2020-05-28", true, 16, 1);

		//ACT
		int expected = booking.getBooking_id();
		int actuel = bookingRepositoryDB.getBooking(10).getBooking_id();
		//Assert
		assertEquals(expected, actuel);
	}


	@Test
	public void getCustomerTest(){
		//Arrange
		customerRepositoryDB = new CustomerRepositoryDB();
		Customer customer = new Customer("Omarrr", "Atik", "oma@gmail.dk", 0, 16, 22, 14);
		//ACT
		String expected = customer.getFirstName();
		String actuel = customerRepositoryDB.getCustomer(16).getFirstName();

		//Assert
		assertEquals(expected, actuel);

	}


}
