package ru.skypro.automationSocks.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.automationSocks.exception.ElemNotFound;
import ru.skypro.automationSocks.mapper.SocksMapper;
import ru.skypro.automationSocks.record.SocksRecord;
import ru.skypro.automationSocks.repository.SocksRepository;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class SocksServiceTest {

    @Mock
    SocksMapper mapper;

    @Spy
    SocksRepository repository;

    @InjectMocks
    SocksService socksService;

    SocksRecord socksRecordcorrect2 = new SocksRecord("Red", 20, 100);

    SocksRecord socksRecordIncorrect1 = new SocksRecord("Red", 20, 100);
    SocksRecord socksRecordIncorrect3 = new SocksRecord("Red", 20, 100);

    Collection<SocksRecord> collection = List.of(socksRecordIncorrect1, socksRecordcorrect2, socksRecordIncorrect3);


    @Test
    void positiveMoreThanFindCountOfSocks() {
        when(mapper.toRecordList(any())).thenReturn(collection);
        int totalExp = collection.stream().mapToInt(SocksRecord::getSocksCount).sum();
        assertThat(totalExp).isEqualTo(socksService.findCountOfSocks("red", "moreThan", 20));
        verify(repository, times(1)).findSocksBySocksColorIgnoreCaseAndAndSocksCottonGreaterThan(anyString(), anyInt());
    }

    @Test
    void positiveEqualsFindCountOfSocks() {
        when(mapper.toRecordList(any())).thenReturn(collection);
        int totalExp = collection.stream().mapToInt(SocksRecord::getSocksCount).sum();
        assertThat(totalExp).isEqualTo(socksService.findCountOfSocks("red", "equals", 20));
        verify(repository, times(1)).findSocksBySocksColorIgnoreCaseAndSocksCottonEquals(anyString(), anyInt());
    }

    @Test
    void positiveLessThanFindCountOfSocks() {
        when(mapper.toRecordList(any())).thenReturn(collection);
        int totalExp = collection.stream().mapToInt(SocksRecord::getSocksCount).sum();
        assertThat(totalExp).isEqualTo(socksService.findCountOfSocks("red", "lessThan", 20));
        verify(repository, times(1)).findSocksBySocksColorIgnoreCaseAndAndSocksCottonIsLessThan(anyString(), anyInt());
    }

    @Test
    void negativeWithEmptyColorFindCountOfSocks() {
        assertThatExceptionOfType(ElemNotFound.class)
                .isThrownBy(() -> socksService.findCountOfSocks("", "equals", 100));
    }

    @Test
    void negativeWithEmptyOperationFindCountOfSocks() {
        assertThatExceptionOfType(ElemNotFound.class)
                .isThrownBy(() -> socksService.findCountOfSocks("red", "", 100));
    }

    @Test
    void negativeWithEmptyCottonFindCountOfSocks() {
        assertThatExceptionOfType(ElemNotFound.class)
                .isThrownBy(() -> socksService.findCountOfSocks("", "equals", null));
    }

    @Test
    void negativeWithNullFindCountOfSocks() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> socksService.findCountOfSocks(null, null, null));
    }




}