package com.globant.serviceImpl;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.globant.dto.ResponseDto;
import com.globant.repository.BitacoraRepository;
import com.globant.service.impl.MarvelServiceImpl;
import com.globant.util.TestConstants;


@SpringBootTest(classes = {BitacoraRepository.class})
class MarvelServiceImplTest {

	
	@InjectMocks
	private MarvelServiceImpl marvel;
	
    @MockBean
    private RestTemplate restTemplate;
    
    @MockBean
    private BitacoraRepository repository;
	
	
    @BeforeEach
    public void setup() throws Exception {
        initMocks(this);
    }
    
    @Test
    void getMarvelCharactersTest() {
    	
    	when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(), eq(ResponseDto.class)))
    	.thenReturn(new ResponseEntity<ResponseDto>(TestConstants.getValidResponseDto(), HttpStatus.OK));
    	
    	when(repository.save(any())).thenReturn(TestConstants.getValidBitacora());
    	
    	ResponseDto body = marvel.getMarvelCharacters();
    
    	assertNotNull(body);
    }
    
    
    @Test
    void getMarvelCharactersByCharacterTest() {
    	
    	when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(), eq(ResponseDto.class)))
    	.thenReturn(new ResponseEntity<ResponseDto>(TestConstants.getValidResponseDto(), HttpStatus.OK));
    	
    	when(repository.save(any())).thenReturn(TestConstants.getValidBitacora());
    	
    	ResponseDto body = marvel.getMarvelCharactersByCharacter("1009178");
    
    	assertNotNull(body);
    }
	
}
