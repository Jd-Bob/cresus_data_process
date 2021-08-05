package mg.orange.cresus.mapper.clients;



import mg.orange.cresus.data_transfert_object.DailyUsageInternationalDTO;
import mg.orange.cresus.domain_object.DailyUsageInternational;
import mg.orange.cresus.domain_object.projection.PDailyUsageInternational;
import mg.orange.cresus.mapper.clients.external.CbmDailyUsageInternationalMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "cdi", uses ={CbmDailyUsageInternationalMapper.class})
public interface DailyUsageInternationalMapper {
    DailyUsageInternationalMapper INSTANCE = Mappers.getMapper(DailyUsageInternationalMapper.class);

    DailyUsageInternational toDO(DailyUsageInternationalDTO dailyUsageDTO);
    DailyUsageInternationalDTO toDto(DailyUsageInternational dailyUsageList);
    List<DailyUsageInternational> toDOs(List<DailyUsageInternationalDTO> dailyUsageDTOS);
    List<DailyUsageInternationalDTO> toDTOs(List<DailyUsageInternational> dailyContractsList);

    //@IterableMapping(qualifiedByName="mapWithoutId")
    List<DailyUsageInternational> toLocalDOs(List<PDailyUsageInternational> pDailyContratList);

    //@Named("mapWithoutId")
    //@Mapping(target = "id", ignore = true)
    DailyUsageInternational toLocalDO(PDailyUsageInternational pDailyContrat);
}
