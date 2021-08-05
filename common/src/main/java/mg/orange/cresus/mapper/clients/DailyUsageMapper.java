package mg.orange.cresus.mapper.clients;



import mg.orange.cresus.data_transfert_object.DailyUsageDTO;
import mg.orange.cresus.domain_object.DailyUsage;
import mg.orange.cresus.domain_object.projection.PDailyUsage;
import mg.orange.cresus.mapper.clients.external.CbmDailyUsageMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "cdi", uses ={CbmDailyUsageMapper.class})
public interface DailyUsageMapper {
    DailyUsageMapper INSTANCE = Mappers.getMapper(DailyUsageMapper.class);

    DailyUsage toDO(DailyUsageDTO dailyUsageDTO);
    DailyUsageDTO toDto(DailyUsage dailyUsageList);
    List<DailyUsage> toDOs(List<DailyUsageDTO> dailyUsageDTOS);
    List<DailyUsageDTO> toDTOs(List<DailyUsage> dailyContractsList);

    //@IterableMapping(qualifiedByName="mapWithoutId")
    List<DailyUsage> toLocalDOs(List<PDailyUsage> pDailyContratList);

    //@Named("mapWithoutId")
    //@Mapping(target = "id", ignore = true)
    DailyUsage toLocalDO(PDailyUsage pDailyContrat);
}
