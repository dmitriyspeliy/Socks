package ru.skypro.automationSocks;

import net.minidev.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.skypro.automationSocks.controller.SocksController;
import ru.skypro.automationSocks.entity.Socks;
import ru.skypro.automationSocks.entity.SocksId;
import ru.skypro.automationSocks.mapper.SocksMapper;
import ru.skypro.automationSocks.record.SocksRecord;
import ru.skypro.automationSocks.repository.SocksRepository;
import ru.skypro.automationSocks.service.SocksService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SocksController.class)
public class AutomationSocksIntegrationTestsWithMockTest {

    @Autowired
    private MockMvc mockMvc;

    @Spy
    SocksMapper socksMapper;

    @MockBean
    private SocksRepository socksRepository;

    @SpyBean
    private SocksService socksService;

    @InjectMocks
    private SocksController socksController;

    private final JSONObject jsonObject = new JSONObject();

    SocksRecord socksRecordcorrect2 = new SocksRecord("Red", 20, 100);

    SocksRecord socksRecordIncorrect1 = new SocksRecord("Red", 20, 100);
    SocksRecord socksRecordIncorrect3 = new SocksRecord("Red", 20, 100);

    Collection<SocksRecord> collection = List.of(socksRecordIncorrect1, socksRecordcorrect2, socksRecordIncorrect3);


    @BeforeEach
    void init() {
        jsonObject.put("socksCount", 100);
        jsonObject.put("cotton", 100);
        jsonObject.put("color", "red");
    }

  /*  @Test
    void createFaculty() throws Exception {

        when(socksRepository.save(any(Socks.class))).thenReturn(new Socks());
        when(socksRepository.findById(any(SocksId.class))).thenReturn(Optional.of(new Socks()));

        mockMvc.perform(MockMvcRequestBuilders.post("/income")
                        .content(jsonObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cotton").value(10))
                .andExpect(jsonPath("$.color").value("color"));
    }*/

    /*@Test
    void findFacultyByID() throws Exception {

        when(facultyRepository.findById(anyLong())).thenReturn(Optional.of(faculty));


        mockMvc.perform(MockMvcRequestBuilders.get("/faculty/2") //send
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()) //receive
                .andExpect(jsonPath("$.id").value(id));

    }

    @Test
    void getAllFaculties() throws Exception {

        when(facultyRepository.findAll()).thenReturn(arr);

        mockMvc.perform(MockMvcRequestBuilders.get("/faculty") //send
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()) //receive
                .andExpect(jsonPath("$", hasSize(2)));

    }

    @Test
    void getFacultiesByColorIgnoreCase() throws Exception {

        when(facultyRepository.getFacultiesByColorIgnoreCase(anyString())).thenReturn(arr);

        mockMvc.perform(MockMvcRequestBuilders.get("/faculty/findBycolor?color=orange") //send
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()) //receive
                .andExpect(jsonPath("$[0].color", equalTo("Orange")));
    }

    @Test
    void getFacultiesByNameIgnoreCase() throws Exception {

        when(facultyRepository.getFacultiesByNameIgnoreCase(anyString())).thenReturn(arr);

        mockMvc.perform(MockMvcRequestBuilders.get("/faculty/findByName?name=mytest") //send
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()) //receive
                .andExpect(jsonPath("$[0].name", equalTo("MyTest")));
    }

    @Test
    void updateFaculty() throws Exception {
        Faculty updateFaculty = new Faculty();
        updateFaculty.setColor("Blue");
        updateFaculty.setName("Blue");

        when(facultyRepository.findById(anyLong())).thenReturn(Optional.of(faculty));
        when(facultyRepository.save(any(Faculty.class))).thenReturn(updateFaculty);

        mockMvc.perform(MockMvcRequestBuilders.put("/faculty/30") //send
                        .content(facultyObject.toString()).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()) //receive
                .andExpect(jsonPath("$.name").value(updateFaculty.getName())).andExpect(jsonPath("$.color").value(updateFaculty.getColor()));

    }

    @Test
    void deleteFacultyByID() throws Exception {

        when(facultyRepository.findById(anyLong())).thenReturn(Optional.of(faculty));
        when(facultyService.deleteFacultyByID(anyLong())).thenReturn(facultyRecord);


        mockMvc.perform(MockMvcRequestBuilders.delete("/faculty/2") //send
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()) //receive
                .andExpect(jsonPath("$.name").value(name));

    }
*/

}
