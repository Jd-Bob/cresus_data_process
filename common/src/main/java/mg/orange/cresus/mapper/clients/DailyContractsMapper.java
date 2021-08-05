package mg.orange.cresus.mapper.clients;


import mg.orange.cresus.data_transfert_object.DailyContractsDTO;
import mg.orange.cresus.domain_object.DailyContracts;
import mg.orange.cresus.domain_object.cbm.CbmDailyContrat;
import mg.orange.cresus.domain_object.projection.PDailyContrat;
import mg.orange.cresus.mapper.clients.external.CbmDailyContractsMapper;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.List;

@Mapper(componentModel = "cdi", uses ={CbmDailyContractsMapper.class})
public interface DailyContractsMapper {
    DailyContractsMapper INSTANCE = Mappers.getMapper(DailyContractsMapper.class);

    DailyContracts toDO(DailyContractsDTO dailyContractsDTO);
    DailyContractsDTO toDto(DailyContracts dailyContracts);
    List<DailyContracts> toDOs(List<DailyContractsDTO> dailyContractsDTOList);
    List<DailyContractsDTO> toDTOs(List<DailyContracts> dailyContractsList);

//    @IterableMapping(qualifiedByName="mapWithoutId")
    List<DailyContracts> toLocalDOs(List<PDailyContrat> pDailyContratList);

//    @Named("mapWithoutId")
//    @Mapping(target = "birthday_date", expression ="java(convertAndCheckTypeBirth(pDailyContrat.birthday_date))")
    DailyContracts toLocalDO(PDailyContrat pDailyContrat);

//    default Date convertAndCheckTypeBirth(Object birthdayDate){
//        if(birthdayDate instanceof  Date){
//            return (Date)birthdayDate;
//        }
//        return null;
//    }

}
