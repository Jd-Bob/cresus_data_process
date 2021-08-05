package mg.orange.cresus.mapper.clients.external;



import mg.orange.cresus.data_transfert_object.cbm.CbmMonthlyUsageDTO;
import mg.orange.cresus.domain_object.cbm.CbmMonthlyUsage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface CbmMonthlyUsageMapper {
    CbmMonthlyUsageMapper INSTANCE = Mappers.getMapper(CbmMonthlyUsageMapper.class);

    CbmMonthlyUsage toDo(CbmMonthlyUsageDTO cbmMonthlyUsageDTO);
    CbmMonthlyUsageDTO toDTO(CbmMonthlyUsage cbmMonthlyUsage);
    List<CbmMonthlyUsage> toDOs(List<CbmMonthlyUsageDTO> cbmMonthlyUsageDTOList);
    List<CbmMonthlyUsageDTO> toDTOs(List<CbmMonthlyUsage> cbmMonthlyUsageList);
}
