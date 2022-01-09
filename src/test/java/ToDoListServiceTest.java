import htw.berlin.webtech.Todoapp.persistence.ToDoListRepository;
import htw.berlin.webtech.Todoapp.service.ToDoListService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ToDoListServiceTest implements WithAssertions {

    @Mock
    private ToDoListRepository repo;

    @InjectMocks
    private ToDoListService underTest;

    @Test
    @DisplayName("should return true if delete was successful")
    void should_return_true_if_person_to_delete_exists() {
        Long givenId =200L;
        doReturn(true).when(repo).existsById(givenId);

        boolean result = underTest.deleteById(givenId);

        verify(repo).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("should return false if person to delete does not exist")
    void should_return_false_if_person_to_delete_does_not_exist() {

        Long givenId = 200L;
        doReturn(false).when(repo).existsById(givenId);

        boolean result = underTest.deleteById(givenId);

        verifyNoMoreInteractions(repo);
        assertThat(result).isFalse();
    }
}
