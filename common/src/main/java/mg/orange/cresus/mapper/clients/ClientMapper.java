package mg.orange.cresus.mapper.clients;

import mg.orange.cresus.data_transfert_object.ClientDTO;
import mg.orange.cresus.domain_object.Client;
import mg.orange.cresus.domain_object.projection.PClient;
import mg.orange.cresus.mapper.clients.external.ClientSAMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "cdi", uses ={ClientSAMapper.class})
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client toDO(ClientDTO clientDTO);
    ClientDTO toDto(Client client);
    List<Client> toDOs(List<ClientDTO> clientDTOs);
    List<ClientDTO> toDTOs(List<Client> clients);

    //@IterableMapping(qualifiedByName="mapWithoutId")
    List<Client> toLocalDOs(List<PClient> pClients);

    //@Named("mapWithoutId")
    //@Mapping(target = "id", ignore = true)
    Client toLocalDO(PClient pClient);

}
