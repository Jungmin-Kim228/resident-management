package com.nhnacademy.resimanage;

import com.nhnacademy.resimanage.config.RootConfig;
import com.nhnacademy.resimanage.config.WebConfig;
import com.nhnacademy.resimanage.repository.ResidentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
    @ContextConfiguration(classes = RootConfig.class),
    @ContextConfiguration(classes = WebConfig.class)
})
public class BasicTest {
    @Autowired
    ResidentRepository residentRepository;

    @Test
    void test() {
        assertThat(residentRepository.findById(7).get().getResidentRegistrationNumber().contains("120315")).isTrue();
    }
}
