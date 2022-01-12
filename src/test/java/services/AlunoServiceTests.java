package services;

import com.dh.meli.diploma.repository.AlunoRepository;
import com.dh.meli.diploma.service.AlunoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class AlunoServiceTests {

    @InjectMocks
    private AlunoService service;

    @Mock
    private AlunoRepository repository;

    private long existingId;
    private long nonExistingId;

    @BeforeEach
    void setUp() throws Exception
    {
        existingId = 1L;
        nonExistingId = 1000L;

    }
}
