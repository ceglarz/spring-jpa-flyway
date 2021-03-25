package com.ceglarz.springjpaflyway;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
class SpringJpaFlywayApplicationTests {

    @Autowired
    private SampleRepository sampleRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void findCustom() {

        Sample expectedSample = new Sample();
        expectedSample.setId(1);
        expectedSample.setName("sample");

        List<Sample> samples = sampleRepository.findCustom("sample");

        assertThat(samples.size()).isGreaterThan(0);
        assertThat(samples.get(0)).isEqualToComparingFieldByField(expectedSample);
    }

}
