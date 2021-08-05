package mg.orange.cresus.mapper.clients;

import mg.orange.cresus.data_transfert_object.MonthlyUsageDTO;
import mg.orange.cresus.domain_object.MonthlyUsage;
import mg.orange.cresus.domain_object.projection.PMonthlyUsage;
import mg.orange.cresus.mapper.clients.external.CbmDailyUsageMapper;
import mg.orange.cresus.mapper.clients.external.CbmMonthlyUsageMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "cdi", uses ={CbmMonthlyUsageMapper.class})
public interface MonthlyUsageMapper {
    MonthlyUsageMapper INSTANCE = Mappers.getMapper(MonthlyUsageMapper.class);

    MonthlyUsage toDo(MonthlyUsageDTO monthlyUsageDTO);
    MonthlyUsageDTO toDTO(MonthlyUsage monthlyUsage);
    List<MonthlyUsage> toDOs(List<MonthlyUsageDTO> monthlyUsageDTOList);
    List<MonthlyUsageDTO> toDTOs(List<MonthlyUsage> monthlyUsageList);

    List<MonthlyUsage> toLocalDOs(List<PMonthlyUsage> pDailyContratList);

    MonthlyUsage toLocalDO(PMonthlyUsage pDailyContrat);
}
