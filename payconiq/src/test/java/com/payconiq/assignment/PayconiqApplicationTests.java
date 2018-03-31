package com.payconiq.assignment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.payconiq.assignment.controllers.StockController;
import com.payconiq.assignment.domain.Stock;
import com.payconiq.assignment.services.StockService;

@RunWith(SpringRunner.class)

@WebMvcTest(value = StockController.class, secure = false)
public class PayconiqApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	private String path = "http://localhost:8080/payconiq/api/stocks";

	@MockBean
	private StockService stockService;

	Stock mockStock = new Stock(1,"Byteridge", 23.1, 1.0, 1.0);

	String stockJson = "{\"name\": \"Byteridge\",\"currentPrice\": 23.1,\"lastUpdate\": \"2018-03-29T18:30:00.000+0000\",\"highPrice\": 23.1,\"lowPrice\": 23.1,\"faceValue\": 1,\"bookValue\": 1 }";

	@Before
	public void init() {
	}
	
	
	@Test
	public void getStock() throws Exception {

		Mockito.when(stockService.getStock(Mockito.anyInt())).thenReturn(mockStock);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(path + "/1").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:1,name:Byteridge,currentPrice:23.1,highPrice:23.1,lowPrice:23.1,faceValue:1,bookValue:1}";

		//JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}



}
