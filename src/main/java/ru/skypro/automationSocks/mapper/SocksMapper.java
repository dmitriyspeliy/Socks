package ru.skypro.automationSocks.mapper;

import org.mapstruct.*;
import ru.skypro.automationSocks.entity.Socks;
import ru.skypro.automationSocks.record.SocksRecord;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface SocksMapper {

    Collection<Socks> toEntityList(Collection<SocksRecord> socksRecords);

    Collection<SocksRecord> toRecordList(Collection<Socks> socks);

    Socks socksRecordToSocks(SocksRecord socksRecord);

    SocksRecord socksToSocksRecord(Socks socks);

}
