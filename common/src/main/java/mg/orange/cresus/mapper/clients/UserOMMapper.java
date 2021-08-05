package mg.orange.cresus.mapper.clients;

import mg.orange.cresus.data_transfert_object.UserOMDTO;
import mg.orange.cresus.domain_object.UserOM;
import mg.orange.cresus.domain_object.projection.PClientOM;
import mg.orange.cresus.mapper.clients.external.ClientOMMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "cdi", uses ={ClientOMMapper.class})
public interface UserOMMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    UserOM toDO(UserOMDTO userOMDTO);
    UserOMDTO toDto(UserOM userOM);
    List<UserOM> toDOs(List<UserOMDTO> userOMDTOs);
    List<UserOMDTO> toDTOs(List<UserOM> userOMs);

    //@IterableMapping(qualifiedByName="mapWithoutId")
    List<UserOM> toLocalDOs(List<PClientOM> pClientOMs);

    //@Named("mapWithoutId")
    //@Mapping(target = "id", ignore = true)
    UserOM toLocalDO(PClientOM pClientOM);
}
