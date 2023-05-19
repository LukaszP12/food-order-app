package pl.strefakursow.elunchapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.strefakursow.elunchapp.DTO.TestAddressDto;

@SpringBootTest
public class MyTest {

    @Test
    void test1() {
        TestAddressDto testAddressDto = new TestAddressDto();
        testAddressDto.setCity("Warszawa");
        testAddressDto.setStreet("Jana Pawła");
        testAddressDto.setStreetNumber("25");

        TestAddressDto testAddressDtobuilded = new TestAddressDto.Builder()
                .setCity("Warszawa")
                .setStreet("Jana Pawła")
                .setStreetNumber("25")
                .build();

        Assertions.assertEquals(testAddressDto, testAddressDtobuilded);
    }

    @Test
    void test2() {
        TestAddressDto testAddressDto = new TestAddressDto();
        testAddressDto.setCity("Warszawa");
        testAddressDto.setStreet("Jana Pawła");
        testAddressDto.setStreetNumber("25");

        TestAddressDto testAddressDtoBuilded = new TestAddressDto
                .Builder()
                .setCity("Warszawa")
                .setStreet("Jana Pawła")
                .setStreetNumber("20")
                .build();

        Assertions.assertEquals(testAddressDto, testAddressDtoBuilded);
    }

}
