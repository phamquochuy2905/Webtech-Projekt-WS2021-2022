package htw.berlin.webtech.Todoapp;

import htw.berlin.webtech.Todoapp.controllers.ToDoRestController;
import htw.berlin.webtech.Todoapp.service.ToDoListService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ToDoRestController.class)
class ToDoRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToDoListService todoService;

    @Test
    @DisplayName("should return 404 if todo is not found")
    void should_return_404_if_todo_is_not_found() throws Exception {
        // given
        doReturn(null).when(todoService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/todos/123"))
                // then
                .andExpect(status().isNotFound());
    }
}
