package IESbank.Service;

import IESbank.Entity.IES_USER;
import IESbank.Repository.IES_USER_Repository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ACCOUNT_Service_ImplTest {

    @Mock
    private IES_USER_Repository iesUserRepository;
    private ACCOUNT_Service_Impl account_service_impl;






@Autowired
    AutoCloseable autoCloseable;
@Autowired
    IES_USER iesUser;


    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);

    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void createUserAccount() {
        mock(IES_USER.class);
        mock(IES_USER_Repository.class);

        when(iesUserRepository.save(iesUser)).thenReturn((iesUser));
        assertThat(account_service_impl.createUserAccount(user)).isEqualTo("status");

    }

    @Test
    void fetchUserAccounts() {
    }

    @Test
    void getUserAccById() {
    }

    @Test
    void changeAccStatus() {
    }

    @Test
    void unlockUserAccount() {
    }
}