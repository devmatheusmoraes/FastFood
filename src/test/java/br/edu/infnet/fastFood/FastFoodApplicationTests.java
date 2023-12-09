package br.edu.infnet.fastFood;

import br.edu.infnet.fastFood.controllers.BebidaController;
import br.edu.infnet.fastFood.model.domain.Bebida;
import br.edu.infnet.fastFood.services.BebidaService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {BebidaController.class, BebidaService.class})
@AutoConfigureMockMvc
class FastFoodApplicationTests {

	@Test
	@Order(1)
	void contextLoads() {
	}

	@Order(2)
	@Autowired
	private MockMvc mockMvc;

	@Order(3)
	@Mock
	private BebidaService bebidaService;

	@Order(4)
	@InjectMocks
	private BebidaController bebidaController;

	@Order(5)
	@Test
	void testGetAllBebidas() throws Exception {
		Bebida bebida = new Bebida("Coca-Cola", 3.0f, 1, true, 500.0f, "Coca-Cola Company");
		List<Bebida> bebidaList = Collections.singletonList(bebida);

		when(bebidaService.getAll()).thenReturn(bebidaList);

		mockMvc.perform(MockMvcRequestBuilders.get("/bebida")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value("Coca-Cola"));
	}

}
