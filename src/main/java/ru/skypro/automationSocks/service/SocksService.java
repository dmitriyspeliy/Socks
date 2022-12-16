package ru.skypro.automationSocks.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.skypro.automationSocks.entity.SocksId;
import ru.skypro.automationSocks.exception.ElemNotFound;
import ru.skypro.automationSocks.mapper.SocksMapper;
import ru.skypro.automationSocks.record.SocksRecord;
import ru.skypro.automationSocks.repository.SocksRepository;


@Service
public class SocksService {

    private final SocksRepository socksRepository;

    private final SocksMapper socksMapper;

    private final String OPERATION_LESSTHAN = "lessThan";
    private final String OPERATION_MORETHAN = "moreThan";
    private final String OPERATION_EQUALS = "equals";

    Logger logger = LoggerFactory.getLogger(SocksService.class);

    public SocksService(SocksRepository socksRepository, SocksMapper socksMapper) {
        this.socksRepository = socksRepository;
        this.socksMapper = socksMapper;
    }

    public Integer findCountOfSocks(String color, String operation, Integer cotton) {
        int result = 0;
        switch (operation) {
            case OPERATION_MORETHAN -> {
                logger.info("Was invoked method for get all Socks where operation is " + OPERATION_MORETHAN + "color is " + color + " and cotton greater then " + cotton);
                result += socksMapper.toRecordList(socksRepository.findSocksBySocksColorIgnoreCaseAndAndSocksCottonGreaterThan(color, cotton)).stream().mapToInt(SocksRecord::getSocksCount).sum();

            }
            case OPERATION_LESSTHAN -> {
                logger.info("Was invoked method for get all Socks where operation is " + OPERATION_LESSTHAN + "color is " + color + " and cotton less then " + cotton);
                result += socksMapper.toRecordList(socksRepository.findSocksBySocksColorIgnoreCaseAndAndSocksCottonIsLessThan(color, cotton)).stream().mapToInt(SocksRecord::getSocksCount).sum();
            }
            case OPERATION_EQUALS -> {
                logger.info("Was invoked method for get all Socks where operation is " + OPERATION_EQUALS + " color is " + color + " and cotton equals " + cotton);
                result += socksMapper.toRecordList(socksRepository.findSocksBySocksColorIgnoreCaseAndSocksCottonEquals(color, cotton)).stream().mapToInt(SocksRecord::getSocksCount).sum();
            }
        }
        if (result == 0) {
            logger.error("No found element where color operation is " + operation + " + color is " + color + " and cotton equals " + cotton);
            throw new ElemNotFound("Носок с запросом, содержание хлопка:" + cotton + " и цвета:" + color + " нет");
        }
        return result;
    }

    public String addCountSocks(SocksRecord socksRecord){
        SocksRecord check = socksMapper.socksToSocksRecord(socksRepository
                .findById(new SocksId(socksRecord.getSocksColor()
                        ,socksRecord.getSocksCotton())).orElse(null));
        if(check == null){
            socksRepository.save(socksMapper.socksRecordToSocks(socksRecord));
            return "Удалось добавить приход, новый товар" + socksRecord;
        }
        check.setSocksCount(check.getSocksCount() + socksRecord.getSocksCount());
        socksRepository.save(socksMapper.socksRecordToSocks(check));
        return "Удалось добавить приход";
    }

    public String removeCountSocks(SocksRecord socksRecord){
        SocksRecord check = socksMapper.socksToSocksRecord(socksRepository
                .findById(new SocksId(socksRecord.getSocksColor()
                        ,socksRecord.getSocksCotton())).orElse(null));
        if(check == null){
            throw new ElemNotFound("Не возможно осуществить отпуск, так как такого товара нет" + socksRecord);
        }
        int checkCount = check.getSocksCount() - socksRecord.getSocksCount();
        if(checkCount == 0){
            socksRepository.delete(socksMapper.socksRecordToSocks(check));
            return "Отпуск осуществлен успешно";
        } else if (checkCount > 0) {
            check.setSocksCount(check.getSocksCount() - socksRecord.getSocksCount());
            return "Отпуск осуществлен успешно";
        }
        throw new ElemNotFound("Не возможно осуществить отпуск, так как фактически носок меньше");
    }

}
