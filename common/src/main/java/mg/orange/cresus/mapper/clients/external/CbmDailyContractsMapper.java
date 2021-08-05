package mg.orange.cresus.mapper.clients.external;


import mg.orange.cresus.data_transfert_object.cbm.CbmDailyContratDTO;
import mg.orange.cresus.domain_object.cbm.CbmDailyContrat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface CbmDailyContractsMapper {
    CbmDailyContractsMapper INSTANCE = Mappers.getMapper(CbmDailyContractsMapper.class);

    CbmDailyContrat toDo(CbmDailyContratDTO cbmDailyContratDTO);
    CbmDailyContratDTO toDTO(CbmDailyContrat cbmDailyContrat);
    List<CbmDailyContrat> toDOs(List<CbmDailyContratDTO> cbmDailyContratDTOList);
    List<CbmDailyContratDTO> toDTOs(List<CbmDailyContrat> cbmDailyContratList);
}
