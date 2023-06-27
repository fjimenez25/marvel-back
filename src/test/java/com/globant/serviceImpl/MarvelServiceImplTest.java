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
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.globant.dto.ResponseDto;
import com.globant.repository.BitacoraRepository;
import com.globant.service.impl.MarvelServiceImpl;
import com.globant.util.ApiCallUtil;
import com.globant.util.TestConstants;


@SpringBootTest(classes = {BitacoraRepository.class})
class MarvelServiceImplTest {

	
	@InjectMocks
	private MarvelServiceImpl marvel;
	
    @MockBean
    private RestTemplate restTemplate;
    
    @MockBean
    private BitacoraRepository repository;
	
	@MockBean
	private ApiCallUtil util;
	
    @BeforeEach
    public void setup() throws Exception {
        initMocks(this);
        
        ReflectionTestUtils.setField(marvel, "baseUrl", "https://gateway.marvel.com:443/v1/public/characters");
        ReflectionTestUtils.setField(marvel, "apiKey", "831197e178cd630551c03e6b9b8e1c65");
        ReflectionTestUtils.setField(marvel, "hash", "d0153cecda67869bf2b554fe2dd18b63");
        ReflectionTestUtils.setField(marvel, "ts", "1");
    }
    
    @Test
    void getMarvelCharactersTest() {
    	
    	//when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(), eq(ResponseDto.class)))
    	//.thenReturn(new ResponseEntity<ResponseDto>(TestConstants.getValidResponseDto(), HttpStatus.OK));
    	
    	
    	when(util.call(any(), anyString(), any(HttpMethod.class), any()))
    	.thenReturn(new ResponseEntity(TestConstants.getValidResponseDto(), HttpStatus.OK));
    	
    	
    	when(repository.save(any())).thenReturn(TestConstants.getValidBitacora());
    	
    	ResponseDto body = marvel.getMarvelCharacters();
    
    	assertNotNull(body);
    }
    
    
    @Test
    void getMarvelCharactersByCharacterTest() {
    	
    	//when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(), eq(ResponseDto.class)))
    	//.thenReturn(new ResponseEntity<ResponseDto>(TestConstants.getValidResponseDto(), HttpStatus.OK));
    	
    	when(util.call(any(), anyString(), any(HttpMethod.class), any()))
    	.thenReturn(new ResponseEntity(TestConstants.getValidResponseDto(), HttpStatus.OK));
    	
    	when(repository.save(any())).thenReturn(TestConstants.getValidBitacora());
    	
    	ResponseDto body = marvel.getMarvelCharactersByCharacter("1009178");
    
    	assertNotNull(body);
    }
	
}
